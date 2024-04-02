package com.apispring.api.service;

import com.apispring.api.models.FileStorage;
import com.apispring.api.repository.FileRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.Base64Utils;
import org.springframework.web.multipart.MultipartFile;

import java.io.*;
import java.util.Base64;

@Service
public class FileService {
    @Autowired
    FileRepository fileRepository;
    public FileStorage getFile(String filename){
        return  fileRepository.findByfilename(filename);
    }
    public String convertToBase64(String imagePath) {
        File file = new File(imagePath);
        try (FileInputStream imageInFile = new FileInputStream(file)) {
            byte[] imageData = new byte[(int) file.length()];
            imageInFile.read(imageData);
            String base64Image = Base64.getEncoder().encodeToString(imageData);

            return base64Image;
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }
    }
    public String uploadBase64File(MultipartFile file) throws IOException {

        byte[] bytes = file.getBytes();
        String base64Data = java.util.Base64.getEncoder().encodeToString(bytes);
        String filename = file.getOriginalFilename();
        String filetype = file.getContentType();

        FileStorage fileStorage = new FileStorage();
        fileStorage.setFilename(filename);
        fileStorage.setFiletype(filetype);
        fileStorage.setFilebase64(base64Data);
        FileStorage newfile = fileRepository.save(fileStorage);

        if(newfile != null){
            return String.format("File %s upload success",filename);
        }
        return "File upload failed";
    }
    public byte[] downloadBase64File(String filename) {
        FileStorage fileStorage = fileRepository.findByfilename(filename);
        if (fileStorage != null) {
            String base64Data = fileStorage.getFilebase64();
            return Base64Utils.decodeFromString(base64Data);
        } else {
            return null;
        }
    }
}
