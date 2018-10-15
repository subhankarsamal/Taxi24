/*
* To change this license header, choose License Headers in Project Properties.
* To change this template file, choose Tools | Templates
* and open the template in the editor.
*/
package com.samal.taxi24.controllers;

import com.samal.taxi24.entities.Driver;
import com.samal.taxi24.entities.Rider;
import com.samal.taxi24.entities.Trip;
import com.samal.taxi24.services.DriverService;
import com.samal.taxi24.services.RiderService;
import com.samal.taxi24.services.TripService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;



/**
 *
 * @author johnray
 */
@CrossOrigin
@RestController
@RequestMapping("/samal/services/taxi24")
public class ServiceController {
    
    @Autowired
    private DriverService driverService;
    
    @Autowired
    private RiderService riderService;
    
    @Autowired
    private TripService tripService;
    
    
    /*
    Get a list of all drivers
    */
    //@PreAuthorize("hasAnyRole('ROLE_USER')")
    //@GetMapping("/accesslogs/{userId}")
    @GetMapping("/driver")
    public List<Driver> getDriverList(){
        
        return driverService.getDriverList();
    }
    
    
    /*
    Get a specific driver by ID
    */
     //@PreAuthorize("hasAnyRole('ROLE_USER')")
    //@GetMapping("/accesslogs/{userId}")
    @GetMapping("/driver/{id}")
    public Driver getDriverById(@PathVariable("id") String id){
        
        return driverService.getDriverById(id);
    }
    
    /*
    create edit driver and their all properties
    */
     //@PreAuthorize("hasAnyRole('ROLE_USER')")
    //@GetMapping("/accesslogs/{userId}")
    @PostMapping("/driver")
    public Driver saveDriver(@RequestBody Driver driver){
        
        return driverService.saveDriver(driver);
    }
    
    /*
    Get a list of all available drivers
    */
     //@PreAuthorize("hasAnyRole('ROLE_USER')")
    //@GetMapping("/accesslogs/{userId}")
    @GetMapping("/driver/active/{status}")
    public List<Driver> getActiveDriverList(@PathVariable("status") int status)
    {
        return driverService.getActiveDriverList((status == 1));
    }
    
    
    /*
    Get a list of all available drivers within 3km for a specific
location
    */
     //@PreAuthorize("hasAnyRole('ROLE_USER')")
    //@GetMapping("/accesslogs/{userId}")
    @GetMapping("/driver/nearBy/{distance}")
    public List<Driver> getDriverList(@PathVariable("distance") double distance,@RequestParam("lon") double lon,@RequestParam("lat") double lat)
    {
        return driverService.getDriverList(distance,lon,lat);
    }
    
    
    /*
   For a specific rider, get a list of the 3 closest drivers
    */
     //@PreAuthorize("hasAnyRole('ROLE_USER')")
    //@GetMapping("/accesslogs/{userId}")
    @GetMapping("/rider/nearByDriver/{distance}")
    public List<Driver> getDriverList(@PathVariable("distance") double distance,@RequestParam("id") String id)
    {
        return driverService.getDriverList(distance,id);
    }
    
    
    /*
    Get a list of all riders
    */
     //@PreAuthorize("hasAnyRole('ROLE_USER')")
    //@GetMapping("/accesslogs/{userId}")
    @GetMapping("/rider")
    public List<Rider> getRiderList(){
        
        return riderService.getRiderList();
    }
    
    /*
    Get a specific rider by ID
    */
     //@PreAuthorize("hasAnyRole('ROLE_USER')")
    //@GetMapping("/accesslogs/{userId}")
    @GetMapping("/rider/{id}")
    public Rider getRiderById(@PathVariable("id") String id){
        
        return riderService.getRiderById(id);
    }
    
    /*
    create and edit of rider properties
    */
     //@PreAuthorize("hasAnyRole('ROLE_USER')")
    //@GetMapping("/accesslogs/{userId}")
    @PostMapping("/rider")
    public Rider saveRider(@RequestBody Rider rider){
        
        return riderService.saveRider(rider);
    }
    
    
    /*
    Get a list of all trip
    */
     //@PreAuthorize("hasAnyRole('ROLE_USER')")
    //@GetMapping("/accesslogs/{userId}")
    @GetMapping("/trip")
    public List<Trip> getTripList(){
        
        return tripService.getTripList();
    }
    
    /*
    Get a list of all Trips By id
    */
     //@PreAuthorize("hasAnyRole('ROLE_USER')")
    //@GetMapping("/accesslogs/{userId}")
    @GetMapping("/trip/{id}")
    public Trip getTripById(@PathVariable("id") String id){
        
        return tripService.getTripById(id);
    }
    
    /*
   create edit and complete trip
    */
     //@PreAuthorize("hasAnyRole('ROLE_USER')")
    //@GetMapping("/accesslogs/{userId}")
    @PostMapping("/trip")
    public Trip saveTrip(@RequestBody Trip trip){
        
        return tripService.saveTrip(trip);
    }
    
    /*
    Get a list of all active Trips
    */
     //@PreAuthorize("hasAnyRole('ROLE_USER')")
    //@GetMapping("/accesslogs/{userId}")
    @GetMapping("/trip/active/{status}")
    public List<Trip> getActiveTripList(@PathVariable("status") int status)
    {
        return tripService.getActiveTripList((status == 1));
    }
    
    
   
    
    
    
}
