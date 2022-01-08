import model.entities.Reservation;
import model.exceptions.DomainException;
import org.codehaus.groovy.transform.SourceURIASTTransformation;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.InputMismatchException;
import java.util.Scanner;

public class Application {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");

        try {
            System.out.print("Room Number: ");
            int numberRoom = sc.nextInt();
            sc.nextLine();
            System.out.print("Check-in Date (dd/MM/yyyy): ");
            Date checkIn = sdf.parse(sc.next());
            System.out.print("Check-out Date (dd/MM/yyyy): ");
            Date checkOut = sdf.parse(sc.next());

            Reservation reservation = new Reservation(numberRoom, checkIn, checkOut);
            System.out.println(reservation);

            System.out.println("Enter data to update reservation: ");
            System.out.print("Check-in Date (dd/MM/yyyy): ");
            Date checkIn2 = sdf.parse(sc.next());
            System.out.print("Check-out Date (dd/MM/yyyy): ");
            Date checkOut2 = sdf.parse(sc.next());

            reservation.updateDates(checkIn2, checkOut2);
            System.out.println(reservation);
        }
        catch (ParseException e){
            System.out.println("invalid date format");
        }
        catch (DomainException e){
            System.out.println("Error in reservation: "+e.getMessage());
        }
        catch (InputMismatchException e){
            System.out.println("invalid format for Room Number!");
        }
        catch (RuntimeException e){
            System.out.println("Unexpected error");
        }
        finally {
            sc.close();
        }
    }
}
