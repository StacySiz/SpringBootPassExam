package ru.itis.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

import static ru.itis.controllers.UploadFileController.setFileName;

@Service
public class UploadServiceImpl implements UploadService {
    @Autowired
    public DocumentStatsService statsService;
    @Override
    public Path upload(MultipartFile file) {
        Path path = null;
        try {
              String UPLOADED_FOLDER = "C://UploadingFiles//";
            byte[] bytes = file.getBytes();
             path = Paths.get(UPLOADED_FOLDER + file.getOriginalFilename());
            setFileName(file.getOriginalFilename());
            Path testfile = Files.write(path, bytes);
//            String result = documentStatsService.count(testfile);
//            String result = "that's a test";

            statsService.count(testfile.toFile());

        } catch (IOException e) {
            e.printStackTrace();
        }
        return path;

//        File testFile = new File("C:\\Users\\Stacy\\IdeaProjects\\JavaEnterpriseProjects\\SpringBootPassExam\\src\\main\\java\\ru\\itis\\services\\test.txt");
//        String result=  documentStatsService.count(new File(file.getOriginalFilename()));
//        File thisFile = new File(file.getName());
//        System.out.println(documentStatsService.count(thisFile));
    }
    }

