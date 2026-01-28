package com.backend.services.implementeds;

import com.backend.services.IDatabaseService;
import org.springframework.stereotype.Service;
import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

@Service
public class DatabaseServiceImplemented implements IDatabaseService {

    private static final String DOCKER_CONTAINER = "mysqlcontainer";
    private static final String DB_NAME = "schools_database";
    private static final String DB_USER = "root";
    private static final String DB_PASS = "1107974062";
    private static final String PROJECT_BACKUP_PATH = "database_backup.sql";
    private static final String PROJECT_BACKUP_DIR = "backups";

    @Override
    public String exportDatabase() throws IOException, InterruptedException {
        String timestamp = LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyyMMdd_HHmmss"));
        String tempFileName = "/tmp/database_export_" + timestamp + ".sql";
        String[] command = {
                "docker", "exec", DOCKER_CONTAINER,
                "mysqldump",
                "-u", DB_USER,
                "-p" + DB_PASS,
                "--set-gtid-purged=OFF",
                "--databases", DB_NAME,
                "--result-file=" + tempFileName
        };
        Process exportProcess = new ProcessBuilder(command).start();
        int exportExitCode = exportProcess.waitFor();
        if (exportExitCode != 0) throw new RuntimeException("Error exporting database");
        String projectBackupFile = PROJECT_BACKUP_PATH;
        String[] copyCommand = {
                "docker", "cp",
                DOCKER_CONTAINER + ":" + tempFileName,
                projectBackupFile
        };
        Process copyProcess = new ProcessBuilder(copyCommand).start();
        int copyExitCode = copyProcess.waitFor();
        if (copyExitCode != 0) throw new RuntimeException("Error copying file from container to project");
        ensureBackupDirectoryExists();
        String timestampBackupFile = PROJECT_BACKUP_DIR + "/schools_database_" + timestamp + ".sql";
        Files.copy(Paths.get(projectBackupFile), Paths.get(timestampBackupFile));
        String[] cleanCommand = {
                "docker", "exec", DOCKER_CONTAINER,
                "rm", tempFileName
        };
        new ProcessBuilder(cleanCommand).start().waitFor();

        return projectBackupFile;
    }

    @Override
    public String importDatabase() throws IOException, InterruptedException {

        File sqlFile = new File(PROJECT_BACKUP_PATH);
        if (!sqlFile.exists()) throw new FileNotFoundException("Backup file not found: " + PROJECT_BACKUP_PATH);
        String tempFileName = "/tmp/database_import.sql";
        String[] copyCommand = {
                "docker", "cp",
                PROJECT_BACKUP_PATH,
                DOCKER_CONTAINER + ":" + tempFileName
        };
        Process copyProcess = new ProcessBuilder(copyCommand).start();
        int copyExitCode = copyProcess.waitFor();
        if (copyExitCode != 0) throw new RuntimeException("Error copying file to container");
        String[] importCommand = {
                "docker", "exec", DOCKER_CONTAINER,
                "bash", "-c",
                "mysql -u " + DB_USER + " -p" + DB_PASS + " " + DB_NAME + " < " + tempFileName
        };
        Process importProcess = new ProcessBuilder(importCommand).start();
        BufferedReader errorReader = new BufferedReader(new InputStreamReader(importProcess.getErrorStream()));
        StringBuilder errors = new StringBuilder();
        String line;
        while ((line = errorReader.readLine()) != null)
            errors.append(line).append("\n");
        int importExitCode = importProcess.waitFor();
        if (importExitCode != 0) {
            BufferedReader outputReader = new BufferedReader(new InputStreamReader(importProcess.getInputStream()));
            StringBuilder output = new StringBuilder();
            while ((line = outputReader.readLine()) != null)
                output.append(line).append("\n");
            throw new RuntimeException("Error importing database.\nErrors: " + errors + "\nOutput: " + output);
        }
        String[] cleanCommand = {
                "docker", "exec", DOCKER_CONTAINER,
                "rm", tempFileName
        };
        new ProcessBuilder(cleanCommand).start().waitFor();
        return "Database imported successfully from " + PROJECT_BACKUP_PATH;
    }

    @Override
    public String importDatabase(String filePath) throws IOException, InterruptedException {
        File sqlFile = new File(filePath);
        if (!sqlFile.exists()) throw new FileNotFoundException("Backup file not found: " + filePath);
        String tempFileName = "/tmp/database_import.sql";
        String[] copyCommand = {
                "docker", "cp",
                filePath,
                DOCKER_CONTAINER + ":" + tempFileName
        };
        Process copyProcess = new ProcessBuilder(copyCommand).start();
        int copyExitCode = copyProcess.waitFor();
        if (copyExitCode != 0) throw new RuntimeException("Error copying file to container");
        String[] importCommand = {
                "docker", "exec", DOCKER_CONTAINER,
                "bash", "-c",
                "mysql -u " + DB_USER + " -p" + DB_PASS + " " + DB_NAME + " < " + tempFileName
        };
        Process importProcess = new ProcessBuilder(importCommand).start();
        BufferedReader errorReader = new BufferedReader(
                new InputStreamReader(importProcess.getErrorStream()));
        StringBuilder errors = new StringBuilder();
        String line;
        while ((line = errorReader.readLine()) != null)
            errors.append(line).append("\n");
        int importExitCode = importProcess.waitFor();
        if (importExitCode != 0) throw new RuntimeException("Error importing database: " + errors);
        String[] cleanCommand = {
                "docker", "exec", DOCKER_CONTAINER,
                "rm", tempFileName
        };
        new ProcessBuilder(cleanCommand).start().waitFor();
        return "Database imported successfully from " + filePath;
    }

    private void ensureBackupDirectoryExists() throws IOException {
        Path backupDir = Paths.get(PROJECT_BACKUP_DIR);
        if (!Files.exists(backupDir)) Files.createDirectories(backupDir);
    }
}