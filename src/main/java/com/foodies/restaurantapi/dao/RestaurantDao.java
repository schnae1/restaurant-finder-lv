package com.foodies.restaurantapi.dao;

import com.foodies.restaurantapi.model.Restaurant;

import java.util.List;

public interface RestaurantDao {

    public List<Restaurant> getNearByRestaurants(double longitude, double latitude, int distance);

}
