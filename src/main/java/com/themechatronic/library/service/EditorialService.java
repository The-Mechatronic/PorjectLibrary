/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.themechatronic.library.service;


import com.themechatronic.library.entity.Editorial;
import com.themechatronic.library.repository.EditorialRepository;
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
public class EditorialService {
    
    @Autowired
    EditorialRepository editorialRepository;
    
    /**
     * @Transactional es una transacción, solo persiste en la base de datos 
     * si el método se ejecuta sin lanzar excepciones.
     * @param name 
     */
    @Transactional
    private void createEditorial(String name){
        
        Editorial editorial = new Editorial();
        
        editorial.setName(name);
        
        editorialRepository.save(editorial);        
    }
    
    /**
     * Método para listar las editoriales 
     */
    public List<Editorial> listEditorial(){
        
        List<Editorial> editorials = new ArrayList();
        
        editorials = editorialRepository.findAll();
        
        return editorials;
    } 
}
    

