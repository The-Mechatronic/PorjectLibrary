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
 * @RequestMapping especifica la ruta que activa el método
 * @author EdwarVelasquez
 */
@Controller
@RequestMapping("/book")    //localhost:8080/book
public class BookController {
    
    /**
     * @Autowired se inicializa de manera automática
     */
    @Autowired
    private AuthorService authorService;
    @Autowired
    private BookService bookService;
    @Autowired
    private EditorialService editorialService;
    
    
    @GetMapping("/register")  //localhost:8080/book/register
    public String register(){
    
    return "book_form.html";
    }    
    
    /**
     * ModelMap los modelos en Springboot sirven para imprimamos información por
     * pantalla, que se necesite mostrar en la pantalla del usuario
     * @param isbn
     * @param copies
     * @param title
     * @param idAuthor
     * @param idEditorial
     * @param modelo
     * @return 
     */
    @PostMapping("/registration")   //localhost:8080/book/registration
    public String registration(@RequestParam (required=false) Long isbn, 
            @RequestParam (required=false) Integer copies,
            @RequestParam String title, 
            @RequestParam String idAuthor,
            @RequestParam String idEditorial,
            ModelMap modelo){
        
        try {
            bookService.createBook(isbn, title, copies, idAuthor, idEditorial);
            
            modelo.put("exito","El libro fue cargado correctamente");
            
        } catch (MyException ex) {
            Logger.getLogger(BookController.class.getName()).log(Level.SEVERE, 
                    null, ex);
            
            modelo.put("error", ex.getMessage());
            
            return "book_form.html";    //Se vuelve a cargar el formulario
        }
        
        return "index.html";
    }
}
