package com.wipro.hotel.entity;

import java.util.Date;

public class Customer {

    private String customerId;
    private Date bookingDate;
    private Date departureDate;
    private String roomType;
    private double billAmount;

    public Customer(String customerId, Date bookingDate, Date departureDate, String roomType) {
        this.customerId = customerId;
        this.bookingDate = bookingDate;
        this.departureDate = departureDate;
        this.roomType = roomType;
    }

    public double getTariffPerDay() {
        if (roomType.equalsIgnoreCase("AC")) {
            return 3725.00;
        } else if (roomType.equalsIgnoreCase("Non-AC")) {
            return 2250.00;
        }
        return 0;
    }

    @Override
    public String toString() {
        return "Customer id:" + customerId +
               "\nBill Amount:Rs." + billAmount;
    }

    public String getCustomerId() {
        return customerId;
    }

    public void setCustomerId(String customerId) {
        this.customerId = customerId;
    }

    public Date getBookingDate() {
        return bookingDate;
    }

    public void setBookingDate(Date bookingDate) {
        this.bookingDate = bookingDate;
    }

    public Date getDepartureDate() {
        return departureDate;
    }

    public void setDepartureDate(Date departureDate) {
        this.departureDate = departureDate;
    }

    public String getRoomType() {
        return roomType;
    }

    public void setRoomType(String roomType) {
        this.roomType = roomType;
    }

    public double getBillAmount() {
        return billAmount;
    }

    public void setBillAmount(double billAmount) {
        this.billAmount = billAmount;
    }
}
