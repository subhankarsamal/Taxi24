/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.samal.taxi24.entities.repositories;

import com.samal.taxi24.entities.Trip;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 *
 * @author johnray
 */
public interface TripRepository extends JpaRepository<Trip, String>{
    
    /**
     * Method to retrieve List of Trip objects having their active status
     *
     * @param isActive, active status of the Trip
     * @return List
     */
    List<Trip> findByIsActive(boolean isActive);
    
}
