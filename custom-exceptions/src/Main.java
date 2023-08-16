import Model.Entities.Reservation;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws ParseException {

        Scanner sc = new Scanner(System.in);
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");

        System.out.println("Room number: ");
        int number = sc.nextInt();
        System.out.println("Check-in date: ");
        Date checkIn = sdf.parse(sc.next());
        System.out.println("Check-out date: ");
        Date checkOut = sdf.parse(sc.next());

        if (!checkOut.after(checkIn)) {
            System.out.println("Error in reservation: Check-out date must be AFTER check-in date. ");
        } else {
            Reservation reservation = new Reservation(number, checkIn, checkOut);
            System.out.println("Reservation: " + reservation);


            System.out.println("Enter data to update reservation: ");
            System.out.println("Check-in date: ");
            checkIn = sdf.parse(sc.next());
            System.out.println("Check-out date: ");
            checkOut = sdf.parse(sc.next());


            Date now = new Date();
            if (checkIn.before(now) || checkOut.before(now)) {
                System.out.println("Check-out date: ");
            } else if (!checkOut.after(checkIn)) {
                System.out.println("Error in reservation: Check-out date must be AFTER check-in date. ");
            } else {
                reservation.updateDates(checkIn, checkOut);
                System.out.println("Reservation: " + reservation);
            }


        }


        sc.close();
    }
}