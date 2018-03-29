package ru.itis.services;

import org.springframework.web.multipart.MultipartFile;

import java.nio.file.Path;

public interface UploadService {
    public Path upload(MultipartFile file);
}
