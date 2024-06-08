package com.example.alpha.admin;

public class BookingStatusDTO {
    private long booked;
    private long cancelled;

    public  long getBooked (){
        return  booked ;
    }

    public long getCancelled() {
        return cancelled;
    }

    public void setBooked(long booked) {
        this.booked = booked;
    }

    public void setCancelled(long cancelled) {
        this.cancelled = cancelled;
    }
}
