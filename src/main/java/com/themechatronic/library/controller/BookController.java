/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.themechatronic.library.controller;

import com.themechatronic.library.exception.MyException;
import com.themechatronic.library.service.AuthorService;
import com.themechatronic.library.service.BookService;
import com.themechatronic.library.service.EditorialService;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

/**
 *
 * @author EdwarVelasquez
 */
@Controller
@RequestMapping("/book")    //localhost:8080/book
public class BookController {
    
    @Autowired 
    private BookService bookService;
    @Autowired
    private AuthorService authorService;
    @Autowired
    private EditorialService editorialService;
    
    @GetMapping("/register")    //localhost:8080/book/register
    public String register(){
    
    return "book_form.html";
}   
    /**
     * 
     * @param isbn
     * @param title
     * @param idEditorial
     * @param author
     * @param idCopies
     * @param modelo
     * @return 
     * ModelMap es un parámetro del método controlador, los modelos en Spring
     * sirven para que se inserten en este modelo toda la información que vamos
     * a mostrar por pantalla o que se necesita utilizar en la interfaz del 
     * usuario en este caso se usa para mostrar un mensaje de error al usuario
     */
    @PostMapping("/registration")
    public String registration(@RequestParam(required=false) Long isbn, 
            @RequestParam String title, @RequestParam String idEditorial, 
            @RequestParam String author, 
            @RequestParam(required=false) Integer idCopies, ModelMap modelo){

        try {
            bookService.createBook(isbn, title, idCopies, author, idEditorial);
            
            modelo.put("Éxito", "El libro fue cargado correctamente");
            
        } catch (MyException ex) {
            
            //En esta línea se accede al error que se realizó en servicio
            modelo.put("Error", ex.getMessage());

            return "book_form.html";           
        }

        return "index.html";
    }
}
