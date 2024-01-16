/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.themechatronic.library.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.GenericGenerator;

/**
 *
 * @author EdwarVelasquez
 */
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Author {
    
    /**
     * @Id Indica la clave primaria de la entidad
     * @GeneratedValue Genera un Id númerico
     * @GenericGenerator Identificadores UUID (Universally Unique Identifier)
     * @Column // Cambia la longitud a 36 caracteres para UUID
    */
    @Id 
    @GeneratedValue(generator = "uuid") 
    @GenericGenerator(name = "uuid", strategy = "uuid2")    
    @Column(length = 36) // Cambia la longitud a 36 caracteres para UUID    
    private String id;
    
    private String name;
    
}
