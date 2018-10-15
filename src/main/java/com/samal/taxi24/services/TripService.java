/*
* To change this license header, choose License Headers in Project Properties.
* To change this template file, choose Tools | Templates
* and open the template in the editor.
*/
package com.samal.taxi24.services;


import com.samal.taxi24.entities.Trip;
import com.samal.taxi24.entities.repositories.TripRepository;
import java.util.Date;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;



/**
 *
 * @author johnray
 */
@Service
public class TripService {
    
    @Autowired
    private TripRepository tripRepository;
    
    
    public Trip saveTrip(Trip trip){
       
        if(trip.getEndTime()!=null){
            trip.setIsActive(false);
        }
        
        return tripRepository.saveAndFlush(trip);
    }
    
    public List<Trip> getTripList(){
        return tripRepository.findAll();
    }
    
    public Trip getTripById(String id){
        return tripRepository.findOne(id);
    }
    
    public List<Trip> getActiveTripList(boolean isActive){
        return tripRepository.findByIsActive(isActive);
    }
    
}
