package com.foodies.restaurantapi.service;

import com.foodies.restaurantapi.dao.RestaurantDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Map;

@Service
public class RestaurantService {

    @Autowired
    RestaurantDao restaurantDao;

    public Map<String, Object> getNearRestaurants(double longitude, double latitude, int distance, int offset, int row_count) {

        return restaurantDao.getNearByRestaurants(longitude, latitude, distance, offset, row_count);

    }

}
