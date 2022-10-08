package com.proyecto.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.proyecto.model.Producto;
import com.proyecto.servicios.FileServiceApi;
import com.proyecto.servicios.ProductoService;

@RestController
@RequestMapping("/productos")
public class ProductoController {

    @Autowired
    private FileServiceApi fileServiceApi;
    
    private ProductoService service;


    public ProductoController() {
        service = new ProductoService();
    }
    
    
    @PostMapping("/files")
    @CrossOrigin
    public String archivos(@RequestParam(value="imagen") MultipartFile file ){
        String msg="";
        try {
            fileServiceApi.save(file);
            msg="cargado";
        } catch (Exception e) {
            e.getMessage();
            e.printStackTrace();
            msg="error";
        }
        return msg;
    }

    @PostMapping
    public String crear(@RequestBody  Producto producto){
        return service.crear(producto);
    }

    @GetMapping
    public List<Producto> listar(){
        return service.listar();
    }

    @GetMapping("/id{idProductos}")
    @CrossOrigin
    public Producto listarId(@PathVariable(name="idProductos")int idProductos){
        return service.listarId(idProductos);
    }

    @PutMapping
    @CrossOrigin
    public String actualizar(@RequestBody Producto producto){
        return service.actualizar(producto);
    }
    
    
    @DeleteMapping("/{idProductos}")
    @CrossOrigin
    public String eliminar(@PathVariable(name="idProductos")int idProductos){
        return service.eliminar(idProductos);
    }
   
    
}
