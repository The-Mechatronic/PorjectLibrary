/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.themechatronic.library.entity;

import java.util.Date;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @Entity Se indica que se quiere persistir los datos de esta entidad
 * @author EdwarVelasquez
 */
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Book {
    @Id
    private long isbn;
    private String title;
    private Integer copies;
    
    @Temporal(TemporalType.DATE)
    private Date alta;
    
    /**
     * @ManyToOne relación de muchos a uno
     */
    
    @ManyToOne
    private Author author;
    
    @ManyToOne
    private Editorial editorial;
}
