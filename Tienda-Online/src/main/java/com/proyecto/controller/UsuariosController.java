package com.proyecto.controller;

import java.util.List;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.RestController;


import com.proyecto.model.Usuarios;
import com.proyecto.servicios.UsuariosService;

@RestController
@RequestMapping("/usuarios")
public class UsuariosController {

    private UsuariosService service;

    public UsuariosController() {
        service = new UsuariosService();
    }
    
    
    @PostMapping
    public String crear(@RequestBody  Usuarios usuarios){
        return service.crear(usuarios);
    }

    @GetMapping
    public List<Usuarios> listar(){
        return service.listar();
    }

    @GetMapping("/id{id}")
    public Usuarios listarId(@PathVariable(name="id")int idUsuarios){
        return service.listarId(idUsuarios);
    }

    @PutMapping
    @CrossOrigin
    public String actualizar(@RequestBody Usuarios usuarios){
        return service.actualizar(usuarios);
    }
    
    
    @DeleteMapping("/{id}")
    @CrossOrigin
    public String eliminar(@PathVariable(name="id")int idUsuarios){
        return service.eliminar(idUsuarios);
    }
   
    
}
