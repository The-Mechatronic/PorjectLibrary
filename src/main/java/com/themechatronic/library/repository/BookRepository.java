/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.themechatronic.library.repository;

import com.themechatronic.library.entity.Book;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

/**
 * Se hereda de Jpa repository y va a manejar la entidad Book y que es de tipo
 * Long
 * Como esto es una interfaz sus métodos  no tienen cuerpo Ni retorno
 * @Query: Esta anotación se utiliza para especificar una consulta personalizada
 * @author EdwarVelasquez
 */

@Repository
public interface BookRepository extends JpaRepository<Book, Long> {
    
    /**
     * Con esta query se esta buscando por title
     * @param title
     * @return 
     */
    @Query("SELECT l from Book l WHERE l.title =: title")
    public Book searchByTitle(@Param("title") String title);
    
    
    @Query("SELECT l from Book l WHERE l.author.name =: name")
    public List<Book> searchByAuthor(@Param("name") String author);
}
