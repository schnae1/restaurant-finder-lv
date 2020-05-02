package com.foodies.restaurantapi.service;

import com.foodies.restaurantapi.dao.RestaurantDao;
import com.foodies.restaurantapi.model.Restaurant;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RestaurantService {

    @Autowired
    RestaurantDao restaurantDao;

    public List<Restaurant> getNearRestaurants(double longitude, double latitude, int distance) {

        return restaurantDao.getNearByRestaurants(longitude, latitude, distance);

    }

}
