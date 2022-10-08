package com.proyecto.servicios;



import org.springframework.web.multipart.MultipartFile;

public interface FileServiceApi {
    
    public void save( MultipartFile file) throws Exception;

}
