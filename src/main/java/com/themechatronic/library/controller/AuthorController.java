/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.themechatronic.library.controller;

import com.themechatronic.library.exception.MyException;
import com.themechatronic.library.service.AuthorService;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

/**
 *
 * @author EdwarVelasquez
 */
@Controller
@RequestMapping("/author")  //localhost:8080/author
public class AuthorController {
    
    @Autowired
    private AuthorService authorService;
            
    @GetMapping("/register")    //localhost:8080/author/register
    public String register(){
        
        return "author_form.html";
    }
    
    @PostMapping("/registration")
    
    /**
     * @RequestParam indica que es un parametro requerido y que va a llegar 
     * cuando se ejecute el formulario
     */
    public String registration(@RequestParam String nombre){
        
        /**
         * Try intenta llamar al servicio y si hay un error o algún problema 
         * lanza la excepción
         */
        try {
            //System.out.println("Nombre: " + nombre);    //Muestra en consola 
            //jjel nombre

            authorService.createAuthor(nombre);
        } catch (MyException ex) {
            Logger.getLogger(AuthorController.class.getName()).log(Level.SEVERE,
                    null, ex);
            
            return "author_form.html";
        }
                                                    
        return "index.html";
    }
}
