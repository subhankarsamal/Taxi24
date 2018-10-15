/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.samal.taxi24.entities.repositories;

import com.samal.taxi24.entities.Rider;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 *
 * @author johnray
 */
public interface RiderRepository extends JpaRepository<Rider, String>{
    
}
