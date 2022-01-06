import model.entities.Reservation;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

public class Application {
    public static void main(String[] args) throws ParseException {
        Scanner sc = new Scanner(System.in);
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");

        System.out.print("Room Number: ");
        int numberRoom = sc.nextInt();
        sc.nextLine();
        System.out.print("Check-in Date (dd/MM/yyyy): ");
        Date checkIn = sdf.parse(sc.next());
        System.out.print("Check-out Date (dd/MM/yyyy): ");
        Date checkOut = sdf.parse(sc.next());

        if(!checkOut.after(checkIn)){
            System.out.println("Error in reservation: Check-out date must be after check-in date");
        }
        else {
            Reservation reservation = new Reservation(numberRoom, checkIn, checkOut);
            System.out.println(reservation);

            System.out.println("Enter data to update reservation: ");
            System.out.print("Check-in Date (dd/MM/yyyy): ");
            Date checkIn2 = sdf.parse(sc.next());
            System.out.print("Check-out Date (dd/MM/yyyy): ");
            Date checkOut2 = sdf.parse(sc.next());

            Date now = new Date();
            if (checkIn2.before(now) || checkOut2.before(now)) {
                System.out.println("Error in reservation: Reservation dates for update must be future dates");
            }
            else if(!checkOut2.after(checkIn2)){
                System.out.println("Error in reservation: Check-out date must be after check-in date");
            }
            else{
                reservation.updateDates(checkIn2, checkOut2);
                System.out.println(reservation);
            }
        }
        sc.close();
    }
}
