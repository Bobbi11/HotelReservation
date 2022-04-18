package hotelreservation.controllers;

import java.time.LocalDate;
import java.util.ArrayList;

import hotelreservation.data.HotelDataConnection;
import hotelreservation.entities.Hotel;
import hotelreservation.entities.Room;

public class HotelController {
    
    private static HotelController instance = null;
    private HotelDataConnection connection = HotelDataConnection.getInstance();

    /**
     * Returns the instance of the HotelController
     * @return the HotelController instance
     */
    public static HotelController getInstance() {
        if (instance == null) {
            instance = new HotelController();
        }
        return instance;
    }

    public ArrayList<Hotel> getAllHotels() throws Exception {
        return connection.getAllHotels();
    }

    public ArrayList<Hotel> getAllAvailableHotels(Integer location, Integer numCustomers, LocalDate from, LocalDate to) throws Exception {
        ReservationController reservController = ReservationController.getInstance();
        String fromString = from.toString();
        String toString = to.toString();
        ArrayList<Hotel> hotels = connection.getHotelsInArea(location);
        ArrayList<Hotel> availableHotels = new ArrayList<Hotel>();
        for (Hotel hotel : hotels) {
            ArrayList<Room> rooms = connection.getRoomsByHotelId(hotel.getId());
            Integer count = 0;
            for (Room room : rooms) {
                if (reservController.isAvailable(room.getHotelId(), room.getRoomNum(), fromString, toString)) {
                    count += room.getCapacity();
                }
            }
            if (count >= numCustomers) {
                availableHotels.add(hotel);
            }
        }
        return availableHotels;
    }

    // public ArrayList<Hotel> filterHotelsByInfo(ArrayList<Hotel> hotels, String[] constr) throws Exception {
    //     ArrayList<Hotel> availableHotels = new ArrayList<Hotel>();

    //     for (Hotel hotel : hotels) {
    //         boolean add = false;
    //         for (String s: constr) {
    //             if (s.contains(" ")) {
    //                 if (s.charAt(0) == hotel.getHotelInfo().getStarRating()) {
    //                     add = true;  
    //                 }
    //             } else {
    //                 if (s.equals("Gym") && !hotel.getHotelInfo().getGym()) {
    //                     add = false;
    //                     break;
    //                 }
    //                 else if (s.equals("WiFi") && !hotel.getHotelInfo().getWifi()) {
    //                     add = false;
    //                     break;
    //                 }
    //                 else if (s.equals("Breakfast") && !hotel.getHotelInfo().getRestaurant()) {
    //                     add = false;
    //                     break;
    //                 }
    //             }
    //         }
    //         if (add) {
    //             availableHotels.add(hotel);
    //         }
    //     }
    //     return availableHotels;
    // }

    public ArrayList<Hotel> filterByInfo(ArrayList<Hotel> hotels, String[] gildi) throws Exception {
        ReservationController reservController = ReservationController.getInstance();
        ArrayList<Hotel> availableHotels = new ArrayList<Hotel>();
        for (Hotel hotel : hotels) {
            Boolean check = true;
            for (int i = 0; i < gildi.length; i++) {
                if(gildi[i].contains("gym") && !hotel.getHotelInfo().getGym()){
                    check = false;
                }
                if(gildi[i].contains("wifi") && !hotel.getHotelInfo().getWifi()){
                    check = false;
                }
                if(gildi[i].contains("breakfast") && !hotel.getHotelInfo().getRestaurant()){
                    check = false;
                }
            }
            if(check){
                availableHotels.add(hotel);
            }

        }
        return availableHotels;
    }

    public Hotel getHotelByID(Integer ID) throws Exception {
        return connection.getHotelById(ID);
    }

    // getHotelIdByName
    public Hotel getHotelIdByName(String name) throws Exception {
        return connection.getHotelByName(name);
    }

    // getHotelsByStarRating
    // public ArrayList<Hotel> getHotelsByStarRating(Integer starRatings) throws Exception {
    //     return connection.getHotelsByStarRating(starRating);
    // }

}

