package com.backend.services;

import java.io.IOException;

public interface IDatabaseService {
    String exportDatabase() throws IOException, InterruptedException;
    String importDatabase() throws IOException, InterruptedException;
    String importDatabase(String filePath) throws IOException, InterruptedException;
}