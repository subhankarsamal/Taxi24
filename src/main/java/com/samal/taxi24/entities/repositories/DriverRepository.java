/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.samal.taxi24.entities.repositories;

import com.samal.taxi24.entities.Driver;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 *
 * @author john
 */
public interface DriverRepository extends JpaRepository<Driver, String>{
    List<Driver> findByIsActive(boolean isActive);
}
