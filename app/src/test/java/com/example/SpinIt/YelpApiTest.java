package com.example.SpinIt;

import android.os.Handler;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import org.junit.Test;
import static org.junit.Assert.*;

public class YelpApiTest {
    Spin spin = null;
    @Test
    public void testingYelpAPI() throws InterruptedException {

        //First create an empty person then we can create a Spin for that person
        ArrayList<String> listOfStatus = new ArrayList<String>();
        Set<String> listOfFriends = new HashSet<String>();
        String username = "briantdu777";

        ArrayList<Place> listOfSpunPlaces = new ArrayList<Place>();
        ArrayList<Place> listOfCheckPlaces = new ArrayList<Place>();
        ArrayList<String> dietaryList = new ArrayList<String>();
        ArrayList<String> foodList = new ArrayList<String>();
        dietaryList.add("Vegan");
        foodList.add("Coffee & Tea");
        PrefList pl = new PrefList();

        pl.setDietaryPref(dietaryList);
        pl.setFoodPref(foodList);

        SpunPlaces sp1 = new SpunPlaces(listOfCheckPlaces, listOfSpunPlaces);

        Person per1 = new Person("lol", pl, sp1, listOfStatus);

        spin = new Spin(per1, "lol");

        boolean checker;
        //This should fail because we haven't set a longitude and/or a latitude
//        checker = spin.setPlaces();
//        assertEquals(false, checker);

        spin.setLocation(34.155516, -119.194739);
        spin.setRadius(1000);

        checker = spin.setPlaces();
        assertEquals(true, checker);

        ArrayList<Place> temp = spin.getListOfPlaces();

        for(int i = 0; i < temp.size(); i++) {
            System.out.println("Values");
            System.out.println(temp.get(i).getURL());
            System.out.println(temp.get(i).getLatitude());
            System.out.println(temp.get(i).getLongitude());
            System.out.println(temp.get(i).getName());
            System.out.println(temp.get(i).getAddress());
        }
//            new Handler().postDelayed(new Runnable() {
//                @Override
//                public void run() {
//                    assertEquals(false, spin.getRandomPlaces().isEmpty());
//                }
//            }, 1000);

    }
}
