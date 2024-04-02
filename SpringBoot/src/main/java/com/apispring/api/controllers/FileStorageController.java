package com.apispring.api.controllers;

import com.apispring.api.models.FileStorage;
import com.apispring.api.service.FileService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

@Controller
@RequestMapping("/api/file")
public class FileStorageController {
    @Autowired
    FileService fileService;

    @PostMapping("/base64")
    public ResponseEntity<?> uploadBase64File(@RequestParam("file")MultipartFile data) throws IOException {
        String respone = fileService.uploadBase64File(data);
        return ResponseEntity.ok(respone);
    }

    @GetMapping("/base64/{filename}")
    public ResponseEntity<?> downloadBase64File(@PathVariable String filename) {
        FileStorage fileStorage = fileService.getFile(filename);
        byte[] file = fileService.downloadBase64File(filename);
        return ResponseEntity.status(HttpStatus.OK).contentType(MediaType.valueOf(fileStorage.getFiletype())).body(file);
    }
}
