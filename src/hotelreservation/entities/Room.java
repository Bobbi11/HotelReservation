package hotelreservation.entities;

import hotelreservation.entities.Enums.RoomType;

public class Room {

    

    private String id;
    private RoomType type;
    private int numBeds;
    private boolean reserved;
    
    public Room(String id, RoomType type, int numBeds, boolean reserved) {
        this.id = id;
        this.type = type;
        this.numBeds = numBeds;
        this.reserved = reserved;
    }

    public void bookRoom() {this.reserved = true;}

    public boolean isAvailable() {return this.reserved;}
}
