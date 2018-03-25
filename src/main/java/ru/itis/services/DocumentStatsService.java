package ru.itis.services;

import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.nio.file.Path;

public interface DocumentStatsService {
    String count(Path path);
}
