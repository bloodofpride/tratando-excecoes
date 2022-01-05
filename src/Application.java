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


        Reservation reservation = new Reservation(numberRoom,checkIn,checkOut);
        System.out.println(reservation);

        try{
            System.out.println("Enter data to update reservation: ");
            System.out.print("Check-in Date (dd/MM/yyyy): ");
            Date checkIn2 = sdf.parse(sc.next());
            System.out.print("Check-out Date (dd/MM/yyyy): ");
            Date checkOut2 = sdf.parse(sc.next());
            reservation.updateDates(checkIn2,checkOut2);

            System.out.println(reservation);
        }catch (Exception e){
            e.printStackTrace();
        }
    }
}
