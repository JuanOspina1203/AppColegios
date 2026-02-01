package com.backend.controllers;

import com.backend.routes.Routes;
import com.backend.services.IDatabaseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(Routes.DATABASES_ROUTE)
public class DatabaseController {

    @Autowired
    private IDatabaseService databaseService;

    @PostMapping(Routes.DATABASE_EXPORT)
    @PreAuthorize("hasRole('DIRECTOR')")
    public ResponseEntity<String> exportDatabase() {
        try {
            String result = this.databaseService.exportDatabase();
            return ResponseEntity.ok("Database exported successfully. File saved at: " + result);
        } catch (Exception e) {
            return ResponseEntity.internalServerError()
                    .body("Error exporting database: " + e.getMessage());
        }
    }

    @PostMapping(Routes.DATABASE_IMPORT)
    @PreAuthorize("hasRole('DIRECTOR')")
    public ResponseEntity<String> importDatabase() {
        try {
            String result = this.databaseService.importDatabase();
            return ResponseEntity.ok("Database imported" + result);
        } catch (Exception e) {
            return ResponseEntity.internalServerError()
                    .body("Error importing database: " + e.getMessage());
        }
    }

    @PostMapping(Routes.DATABASE_IMPORT + Routes.DATABASE_FILE)
    @PreAuthorize("hasRole('DIRECTOR')")
    public ResponseEntity<String> importDatabaseFromFile(@PathVariable String filename) {
        try {
            String result = this.databaseService.importDatabase(filename);
            return ResponseEntity.ok("Database imported: " + result);
        } catch (Exception e) {
            return ResponseEntity.internalServerError()
                    .body("Error importing database: " + e.getMessage());
        }
    }
}