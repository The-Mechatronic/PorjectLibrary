/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.themechatronic.library.service;

import com.themechatronic.library.entity.Author;
import com.themechatronic.library.entity.Book;
import com.themechatronic.library.entity.Editorial;
import com.themechatronic.library.repository.AuthorRepository;
import com.themechatronic.library.repository.BookRepository;
import com.themechatronic.library.repository.EditorialRepository;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;
import javax.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;

/**
 *
 * @author EdwarVelasquez
 */
public class BookService {
    /**
     * @Autowired esto se conoce como inyección de dependencias, lo que hace 
     * inicializar la variable de manera automática
     */
    @Autowired
    private BookRepository bookRepository;
    
    @Autowired
    private AuthorRepository authorRepository;
    
    @Autowired
    private EditorialRepository editorialRepository;
    
    /**
     * @Transactional es una transacción, solo persiste en la base de datos 
     * si el método se ejecuta sin lanzar excepciones. Todos aquellos métodos 
     * que generen cambios permanentes en la base de datos, deben tener un 
     * trancsactional.
     * @param isbn
     * @param title
     * @param copies
     * @param idAuthor
     * @param idEditorial 
     */
    @Transactional
    public void createBook(Long isbn, String title, Integer copies, 
            String idAuthor, String idEditorial){
        
        Author author = authorRepository.findById(idAuthor).get();
        Editorial editorial = editorialRepository.findById(idEditorial).get();
        Book book = new Book();
        
        book.setIsbn(isbn);
        book.setTitle(title);
        book.setCopies(copies);
        
        book.setAlta(new Date());
        
        book.setAuthor(author);
        book.setEditorial(editorial);
        
        bookRepository.save(book);}
    
    /**
     * Méotodo para listar los libros
     * @return 
     */
    public List<Book> listBooks(){
        
        List<Book> books = new ArrayList();
        
        books = bookRepository.findAll();
        
        return books;
    }
    
    /**
     * Método para modificar un libro
     */
    @Transactional
    public void modifyBook(Long isbn, String title, String idEditorial, String
            idAuthor, Integer copies){
        
        /**
         * Optional hace referencia a una variable que puede tener un valor 
         * asignado o que puede contener un valor null.
         */
        Optional<Book> responseBook = bookRepository.findById(isbn);
        Optional<Author> responseAuthor = authorRepository.findById(idAuthor);
        Optional<Editorial> responseEditorial = editorialRepository.findById
        (idEditorial);
        
        /**
         * Se instacia un autor y una editorial
         */        
        Author author = new Author();
        Editorial editorial = new Editorial();
        
        if(responseAuthor.isPresent()){
            author = responseAuthor.get();
        }
        
        if(responseEditorial.isPresent()){
            editorial = responseEditorial.get();
        }
        
        if(responseBook.isPresent()){
            Book book = responseBook.get();
            book.setTitle(title);
            book.setAuthor(author);
            book.setEditorial(editorial);
            book.setCopies(copies);
        }        
    }
}
