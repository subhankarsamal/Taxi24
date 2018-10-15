/*
* To change this license header, choose License Headers in Project Properties.
* To change this template file, choose Tools | Templates
* and open the template in the editor.
*/
package com.samal.taxi24.services;

import com.samal.taxi24.entities.Driver;
import com.samal.taxi24.entities.repositories.DriverRepository;
import com.samal.taxi24.entities.repositories.RiderRepository;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author john
 */
@Service
public class DriverService {
    
    @Autowired
    private DriverRepository driverRepository;
    
    @Autowired
    private RiderRepository riderRepository;
    
    public List<Driver> getDriverList(){
        return driverRepository.findAll();
    }
    
    public List<Driver> getDriverList(double distance,String id){
        return getDriverList (distance,riderRepository.findOne(id).getLon(),riderRepository.findOne(id).getLat());
    }
    
    public List<Driver> getDriverList(double distance,double lon,double lat){
        List<Driver> driverList=new ArrayList<>();
        
        Iterator<Driver> iterator = driverRepository.findAll().iterator();
        while (iterator.hasNext()) {
            Driver d = iterator.next();
            
            double theta = d.getLon() - lon;
            double dist = Math.sin(deg2rad(d.getLat())) * Math.sin(deg2rad(lat)) + Math.cos(deg2rad(d.getLat())) * Math.cos(deg2rad(lat)) * Math.cos(deg2rad(theta));
            dist = Math.acos(dist);
            dist = rad2deg(dist);
            dist = dist * 60 * 1.1515;
            dist = dist * 1.609344;
            
            if(dist<=distance){
                driverList.add(d);
            }
        }
        
        return driverList;
    }
    
    public Driver saveDriver(Driver driver){
        driver.setCreationTime(new Date());
        return driverRepository.saveAndFlush(driver);
    }
    
    public Driver getDriverById(String id){
        return driverRepository.findOne(id);
    }
    
    public List<Driver> getActiveDriverList(boolean isActive){
        return driverRepository.findByIsActive(isActive);
    }
    
    
    /*:::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::*/
    
    /*::  This function converts decimal degrees to radians             :*/
    
    /*:::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::*/
    
    private double deg2rad(double deg) {
        
        return (deg * Math.PI / 180.0);
        
    }
    
    /*:::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::*/
    
    /*::  This function converts radians to decimal degrees             :*/
    
    /*:::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::*/
    
    private double rad2deg(double rad) {
        
        return (rad * 180.0 / Math.PI);
        
    }
    
}
