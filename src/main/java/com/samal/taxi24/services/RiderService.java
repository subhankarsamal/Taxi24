/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.samal.taxi24.services;
import com.samal.taxi24.entities.Rider;
import com.samal.taxi24.entities.repositories.RiderRepository;
import java.util.Date;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;





/**
 *
 * @author johnray
 */
@Service
public class RiderService {
    
    @Autowired
    private RiderRepository riderRepository;
    
    public Rider saveRider(Rider rider){
        rider.setCreationTime(new Date());
        return riderRepository.saveAndFlush(rider);
    }
    
    public List<Rider> getRiderList(){
        return riderRepository.findAll();
    }
    
    public Rider getRiderById(String id){
        return riderRepository.findOne(id);
        
    }
    
}
