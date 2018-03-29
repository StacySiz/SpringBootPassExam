package ru.itis.controllers;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

import ru.itis.services.DocumentStatsService;
import ru.itis.services.UploadService;

@Controller
public class UploadFileController {
    @Autowired
    public UploadService uploadService;

//    @Autowired
//    public DocumentStatsService documentStatsService;

    public static String getFileName() {
        return fileName;
    }

    public static void setFileName(String fileName) {
        UploadFileController.fileName = fileName;
    }

    public static String fileName = null;

    @GetMapping("/upload")
    public String showupload() {
        return "upload";
    }

    @PostMapping("/upload")
    public String singleFileUpload(@RequestParam("file") MultipartFile file,
                                   RedirectAttributes redirectAttributes) {

        if (file.isEmpty()) {
            redirectAttributes.addFlashAttribute("message", "Please select a file to upload");
            return "redirect:uploadStatus";
        }
        Path path = uploadService.upload(file);
        redirectAttributes.addFlashAttribute("message",
                "Result" + path + "'");

        return "redirect:/uploadStatus";
    }


    @GetMapping("/uploadStatus")
    public String uploadStatus() {
        return "uploadStatus";
    }
}
