package com.xvitcoder.springmvcangularjs.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.xvitcoder.springmvcangularjs.beans.Car;
import com.xvitcoder.springmvcangularjs.repositories.CarRepository;
import com.xvitcoder.springmvcangularjs.service.CarService;

/**
 * Created with IntelliJ IDEA.
 * User: xvitcoder
 * Date: 12/21/12
 * Time: 12:23 AM
 */
@Controller
@RequestMapping("/cars")
public class CarController {

    @Autowired 
    private CarRepository repository;

    @RequestMapping("/carlist.json")
    public @ResponseBody List<Car> getCarList() {
        return repository.findAll();
    }

    @RequestMapping(value = "/addCar", method = RequestMethod.POST)
    public @ResponseBody void addCar(@RequestBody Car car) {
        repository.save(car);
    }

    @RequestMapping(value = "/removeCar/{car}", method = RequestMethod.DELETE)
    public @ResponseBody void removeCar(@PathVariable("car") String car) {
        repository.deleteCarByName(car);
    }

    @RequestMapping(value = "/removeAllCars", method = RequestMethod.DELETE)
    public @ResponseBody void removeAllCars() {
        repository.deleteAll();
    }

    @RequestMapping("/layout")
    public String getCarPartialPage() {
        return "cars/layout";
    }
}
