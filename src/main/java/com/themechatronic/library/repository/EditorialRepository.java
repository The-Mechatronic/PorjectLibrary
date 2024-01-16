/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.themechatronic.library.repository;

import com.themechatronic.library.entity.Editorial;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 *
 * @author EdwarVelasquez
 */
@Repository
public interface EditorialRepository extends JpaRepository<Editorial, String>{
    
}
