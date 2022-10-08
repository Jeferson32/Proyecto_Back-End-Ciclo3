package com.proyecto.controller;



import org.springframework.web.bind.annotation.PostMapping;

import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.RestController;


import com.proyecto.model.Contacto;

import com.proyecto.servicios.ContactoService;

@RestController
@RequestMapping("/contacto")
public class ContactoController {


    private ContactoService service;


    public ContactoController() {
        service = new ContactoService();
    }
    
    

    @PostMapping
    public String crear(@RequestBody  Contacto contacto){
        return service.crear(contacto);
    }
}
