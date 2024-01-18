/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.themechatronic.library.service;

import com.themechatronic.library.entity.Author;
import com.themechatronic.library.exception.MyException;
import com.themechatronic.library.repository.AuthorRepository;
import java.util.ArrayList;
import java.util.List;
import javax.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author EdwarVelasquez
 */
@Service
public class AuthorService {
    
    @Autowired
    AuthorRepository authorRepository;
    
    /**
     * @Transactional es una transacción, solo persiste en la base de datos 
     * si el método se ejecuta sin lanzar excepciones.
     * @param name 
     */
    @Transactional
    public void createAuthor(String name)throws MyException{
        
        Author author = new Author();
        
        author.setName(name);
        
        authorRepository.save(author);
    }
    
    private void validar(String nombre) throws MyException{    
        if (nombre.isEmpty() || nombre == null){            
            throw new MyException("El nombre no puede ser nulo ni estar vacio");
        }
    }
    
    /**
     * Método para listar los autores
     * @return 
     */
    public List<Author> listAuthors(){
    
        List<Author> authors = new ArrayList();

        authors = authorRepository.findAll();

        return authors;
    }
}
