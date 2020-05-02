package com.foodies.restaurantapi.database;

import com.foodies.restaurantapi.constants.Constants;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.List;

@Component
public class PopulateDatabase {

    @Autowired
    JdbcTemplate jdbcTemplate;

    public void PopulateDB() {

        System.out.println("Populating DB...");

        BufferedReader br = null;
        String line = "";
        String cvsSplitBy = ";";
        List<Object[]> restaurantList = new ArrayList<>();

        // Get restaurant data from csv file
        try{

            br = new BufferedReader(new FileReader(Constants.RESTAURANTS_FILE_PATH));
            line = br.readLine();
            while ((line = br.readLine()) != null) {

                String[] restaurantData = line.split(cvsSplitBy);

                restaurantList.add(createRestaurantData(restaurantData));

            }

            System.out.println(restaurantList.size());
            for (int i = 0; i < restaurantList.size(); i += Constants.BATCH_SIZE) {

                List<Object[]> batchList = restaurantList.subList(i, Math.min(i + Constants.BATCH_SIZE, restaurantList.size()));
                jdbcTemplate.batchUpdate(Constants.SQL_INSERT_RESTAURANT_DATA, batchList);

            }

        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    public Object[] createRestaurantData(String[] restaurantData) {

        Object[] obj = new Object[]{};

        try{

            String permitNumber = restaurantData[0].trim();
            String restaurantName = restaurantData[4].trim();
            String address = restaurantData[6].trim();
            double latitude = 0;
            double longitude = 0;
            int cityId = 0;
            try {
                latitude = Double.parseDouble(restaurantData[7].trim());
            } catch (Exception e) {

            }
            try {
                longitude = Double.parseDouble(restaurantData[8].trim());
            } catch (Exception e) {

            }
            try {
                cityId = Integer.parseInt(restaurantData[9].trim());
            } catch (Exception e) {

            }
            String cityName = restaurantData[10].trim();
            String zipCode = restaurantData[11].trim();
            String searchText = restaurantData[20].trim();

            obj = new Object[]{
                    permitNumber,
                    restaurantName,
                    address,
                    latitude,
                    longitude,
                    cityId,
                    cityName,
                    zipCode,
                    searchText
            };

        } catch (Exception e) {
            e.printStackTrace();
        }

        return obj;
    }

}
