package com.foodies.restaurantapi.api;

import com.foodies.restaurantapi.model.Restaurant;
import com.foodies.restaurantapi.service.RestaurantService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequestMapping("api/v1/restaurants")
@RestController
public class RestaurantController {

    @Autowired
    RestaurantService restaurantService;

    @GetMapping
    @ResponseBody
    public List<Restaurant> getNearRestaurants(
            @RequestParam(required = true) double longitude,
            @RequestParam(required = true) double latitude,
            @RequestParam(required = true) int distance) {

        return restaurantService.getNearRestaurants(longitude, latitude, distance);

    }

}
