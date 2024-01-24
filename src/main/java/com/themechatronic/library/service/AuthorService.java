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
import java.util.Optional;

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
        
        validate(name);
        
        Author author = new Author();
        
        author.setName(name);
        
        authorRepository.save(author);
    }
    
    @Transactional(readOnly = true)
    public List<Author> listAuthors(){
    
        List<Author> authors = new ArrayList();

        authors = authorRepository.findAll();

        return authors;
    }   
    
    /**
     * Método para listar los autores
     * @return 
     */    
     @Transactional
    public void modifyAuthor(String name, String id) throws MyException{
        
        validate(name);
        
        Optional<Author> respuesta = authorRepository.findById(id);

        if (respuesta.isPresent()) {
            Author author = respuesta.get();
            
            author.setName(name);

            authorRepository.save(author);

        }
    }
    
    @Transactional(readOnly = true)
    public Author getOne(String id){
        return authorRepository.getOne(id);
    }
    
    @Transactional
    public void eliminar(String id) throws MyException{
        
        Author author = authorRepository.getById(id);
        
        authorRepository.delete(author);
    }
    
     private void validate(String name) throws MyException {
        
        if (name.isEmpty() || name == null) {
            throw new MyException("El nombre no puede ser nulo o estar vacio");
        }
    }    
}
