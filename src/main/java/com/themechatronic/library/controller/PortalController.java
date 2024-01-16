/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.themechatronic.library.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * El controlador permite poder comunicar y conectar las interfaces de usuario 
 * con la lógica del negocio.
 * @RequestMapping lo que hace es confirgurar la url que va a escuchar a este 
 * controlador, en este caso se va a activar cuando se coloque un back slash "/"
 * @author EdwarVelasquez
 */
@Controller
@RequestMapping("/")
public class PortalController {
    
    @GetMapping("/")
    public String index(){
        
        return "index.html";
    }    
}
