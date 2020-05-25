package com.foodies.restaurantapi.dao;

import java.util.Map;

public interface RestaurantDao {

    public Map<String, Object> getNearByRestaurants(double longitude, double latitude, int distance, int offset, int row_count);

}
