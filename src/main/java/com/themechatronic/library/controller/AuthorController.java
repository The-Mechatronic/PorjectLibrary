/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.themechatronic.library.controller;

import static com.fasterxml.jackson.databind.util.ClassUtil.name;
import com.themechatronic.library.entity.Author;
import com.themechatronic.library.exception.MyException;
import com.themechatronic.library.service.AuthorService;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
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
    
    /**
     * @RequestParam indica que es un parametro requerido y que va a llegar 
     * cuando se ejecute el formulario
     */
    @PostMapping("/registration")
    public String registration(@RequestParam String name, ModelMap modelo){
        
        /**
         * Try intenta llamar al servicio y si hay un error o algún problema 
         * lanza la excepción
         */
        try {
            //System.out.println("Nombre: " + nombre);    //Muestra en consola 
            //jjel nombre

            authorService.createAuthor(name);
            modelo.put("exito","El autor fue registrado correctamente");
        } catch (MyException ex) {
            
            modelo.put("error", ex.getMessage());
            
            return "author_form.html";
        }
                                                    
        return "index.html";
    }
    @GetMapping("/list")
    public String toList(ModelMap modelo){
        
        List <Author> authors = authorService.listAuthors();
        
        modelo.addAttribute("autores", authors);
        
        return "autor_list.html";
    }
    
    @GetMapping("/modify/{id}")
    public String modify(@PathVariable String id, ModelMap modelo){
        modelo.put("autor", authorService.getOne(id));
        
        return "author_modify.html";
    }
    
    @PostMapping("{id}")
    public String modify(@PathVariable String id, String name, ModelMap modelo){
        try {
            authorService.modifyAuthor(name, id);
            
            return "redirect:../list";
        } catch (MyException ex) {
            modelo.put("error", ex.getMessage());
            return "autor_modificar.html";
        }
        
    }
    
   // @GetMapping("{id}")
    public String eliminar(@PathVariable String id, ModelMap modelo) throws MyException{
        authorService.eliminar(id);
        
        return "autor_modificar.html";
    }
}
