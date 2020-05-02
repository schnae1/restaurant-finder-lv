package com.foodies.restaurantapi.dao;

import com.foodies.restaurantapi.constants.Constants;
import com.foodies.restaurantapi.model.Restaurant;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class RestaurantDataAccessService implements RestaurantDao {

    @Autowired
    JdbcTemplate jdbcTemplate;

    @Override
    public List<Restaurant> getNearByRestaurants(double longitude, double latitude, int distance) {

        List<Restaurant> restaurants = jdbcTemplate.query(
                Constants.SQL_GET_NEAREST_RESTAURANTS,
                new Object[]{latitude, longitude, latitude, distance},
                new RestaurantRowMapper());

        return restaurants;

    }

}
