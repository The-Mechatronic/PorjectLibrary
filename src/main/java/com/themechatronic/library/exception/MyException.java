/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.themechatronic.library.exception;

/**
 * Se crea esta excepción para diferenciarla de los errores propios y bugs del 
 * sistema 
 * @author EdwarVelasquez
 */
public class MyException extends Exception {
    
    public MyException(String msg){
        super(msg);
    }    
}
