package com.xvitcoder.springmvcangularjs.service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map.Entry;

import org.springframework.stereotype.Component;

/**
 * Created with IntelliJ IDEA.
 * User: xvitcoder
 * Date: 12/20/12
 * Time: 11:14 PM
 */
@Component("carServiceHashImpl")
public class CarServiceHashImpl implements CarService {
    private static HashMap<Integer, String> carMap = new HashMap<Integer, String>();
    private static int counterOfCars = 0;

    @Override
    public List<String> getAllCars() {
        return (List<String>) (new ArrayList<String>(carMap.values()));
    }

    @Override
    public void addCar(String car) {
        carMap.put(++counterOfCars, car);
    }

    @Override
    public void deleteCar(String car) {
    	int keyToRemove = 0;
        if (carMap.values().contains(car)) {
            for(Entry<Integer, String> entry : carMap.entrySet()){
            	if(entry.getValue().equals(car)){
            		keyToRemove = entry.getKey();
            		break;
            	}
            }
            carMap.remove(keyToRemove);
        }
    }

    @Override
    public void deleteAll() {
        carMap.clear();
    }
}
