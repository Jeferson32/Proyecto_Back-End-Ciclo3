package com.proyecto.servicios;

import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;


import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

@Service
public class FileServiceImp implements FileServiceApi {

    private final Path rootFolder = Paths.get("C:\\Users\\Jeferson\\Downloads\\ONLINE-SHOP V 0.3\\ONLINE-SHOP v 0.2\\imagenes");
    
    @Override
    public void save(MultipartFile file) throws Exception {
        Files.copy(file.getInputStream(),this.rootFolder.resolve(file.getOriginalFilename()));
        
    }
}
