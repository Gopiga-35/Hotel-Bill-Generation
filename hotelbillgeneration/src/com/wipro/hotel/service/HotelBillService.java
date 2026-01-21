package com.wipro.hotel.service;

import java.util.Date;

import com.wipro.hotel.entity.Customer;
import com.wipro.hotel.exception.InvalidDataException;
import com.wipro.hotel.exception.InvalidRoomTypeException;

public class HotelBillService {

    public String validateData(String customerId, Date bookingDate, Date departureDate, String roomType) {
        try {
            if (customerId == null || customerId.length() != 8 || bookingDate.after(departureDate)) {
                throw new InvalidDataException();
            }

            if (!(roomType.equalsIgnoreCase("AC") || roomType.equalsIgnoreCase("Non-AC"))) {
                throw new InvalidRoomTypeException();
            }

            return "Valid";

        } catch (InvalidDataException | InvalidRoomTypeException e) {
            return e.toString();
        }
    }

    public int getDaysStayed(Date bookingDate, Date departureDate) {
        long diff = departureDate.getTime() - bookingDate.getTime();
        return (int) (diff / 86400000);
    }

    public String calculateBill(String customerId, Date bookingDate, Date departureDate, String roomType) {

        String result = validateData(customerId, bookingDate, departureDate, roomType);
        if (!result.equals("Valid")) {
            return result;
        }

        Customer customer = new Customer(customerId, bookingDate, departureDate, roomType);

        int daysStayed = getDaysStayed(bookingDate, departureDate);
        double tariff = customer.getTariffPerDay();
        double bill = daysStayed * tariff;

        double tax;
        if (bill <= 5000) {
            tax = bill * 0.05;
        } else if (bill > 5000 && bill <= 10000) {
            tax = bill * 0.10;
        } else {
            tax = bill * 0.20;
        }

        double totalBill = bill + tax;
        customer.setBillAmount(totalBill);

        return customer.toString();
    }
}
