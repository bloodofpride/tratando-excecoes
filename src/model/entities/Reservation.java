package model.entities;

import java.text.SimpleDateFormat;
import java.util.Date;

public class Reservation {
    private final SimpleDateFormat sdf = new SimpleDateFormat();

    private Integer roomNumber;
    private Date checkIn;
    private Date checkOut;

    public Reservation(){}

    public Reservation(Integer roomNumber, Date checkIn, Date checkOut) {
        this.roomNumber = roomNumber;
        this.checkIn = checkIn;
        this.checkOut = checkOut;
    }

    public Integer getRoomNumber() {
        return roomNumber;
    }

    public void setRoomNumber(Integer roomNumber) {
        this.roomNumber = roomNumber;
    }

    public Date getCheckIn() {
        return checkIn;
    }

    public Date getCheckOut() {
        return checkOut;
    }

    public Integer duration(){
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy/MM/dd");
        Integer firstDate = Integer.parseInt(sdf.format(checkIn));
        Integer secondDate = Integer.parseInt(sdf.format(checkOut));

        return secondDate - firstDate;
    }

    public void updateDates(Date checkIn, Date checkOut){
       if(checkIn.after(new Date()) ||  checkIn.equals(new Date()) && checkOut.after(new Date())) {
           if (checkIn.before(checkOut)) {
               this.checkIn = checkIn;
               this.checkOut = checkOut;
           } else {

           }
       }else{

       }
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Reservation: Room ");
        sb.append(roomNumber);
        sb.append(", check-in: ");
        sb.append(sdf.format(checkIn));
        sb.append(", check-out: ");
        sb.append(sdf.format(checkOut));
        sb.append(", ");
        sb.append(duration());
        sb.append(" night(s)");
        System.out.println();
        return sb.toString();
    }
}
