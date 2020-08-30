//Student's Full Name- Tasfique Enam
//Student's ID- J16020825/5886429
//Modification Date 16/04/2019
//Purpose of this file- Parking Ticket Class
package assignment1;
public class ParkingTicket {
    private ParkedCar parkedCarObj = new ParkedCar ();
    private double fine;
    PoliceOfficer officerObj = new PoliceOfficer ();
    public static double FIRST_HOUR_FINE_RATE = 150.00;
    public static double ADDITIONAL_HOUR_FINE_RATE = 50.00;
    public static double MAXIMUM_FINE_RATE = 300.00;
    
    public ParkingTicket() { //default constructor
        parkedCarObj = null;
        fine = 0.0;
        officerObj = null;
    }
    
    public ParkingTicket(ParkedCar parkedCarObj, double fine, PoliceOfficer officerObj) { //non default constructor 
        this.parkedCarObj = parkedCarObj;
        this.fine = fine;
        this.officerObj = officerObj;
    }
    
    public void setParkedCarObj (ParkedCar parkedCarObj) { //setter methods.
        this.parkedCarObj = parkedCarObj;
    }
    
    public void setFine (double fine) {
        this.fine = fine;
    }
     
    public void setPoliceOfficer (PoliceOfficer officerObj) {
        this.officerObj = officerObj;
    }
    
    public ParkedCar getParkedCarObj () { //getter methods.
        return parkedCarObj;
    }
    
    public double getFine () { 
        return fine;
    }
    
    public PoliceOfficer getPoliceOfficerObj () {
        return officerObj;
    }
    
    public void Calculation (int minute) { // the calculation method 
        if(minute<61) {
            fine = FIRST_HOUR_FINE_RATE;
        }
        
        else if (minute>60 && minute<121){
           fine = FIRST_HOUR_FINE_RATE + ADDITIONAL_HOUR_FINE_RATE;
        }
        
        else if (minute>120 && minute<181){
            fine = FIRST_HOUR_FINE_RATE + 2*ADDITIONAL_HOUR_FINE_RATE;
        }
        
        else if (minute>180) {
            fine = FIRST_HOUR_FINE_RATE + 3*ADDITIONAL_HOUR_FINE_RATE;
        }
        
        if(fine > MAXIMUM_FINE_RATE) {
            fine = MAXIMUM_FINE_RATE;
        }
        
        
        
        //return fine;
        
       // else if (minute>240) {
           // fine = FIRST_HOUR_FINE_RATE + 3*ADDITIONAL_HOUR_FINE_RATE;
       // }
    }
    
    @Override
    public String toString () { //toString method to display
        String str;
        str = "\n*********INFORMATION ON THE ILLEGALLY PARKED CAR(S)*********"+getParkedCarObj().toString()+"\n"
                +"\n*********THE DETAILS OF THE POLICE OFFICER*********"+getPoliceOfficerObj()+"\n"
                +"\nThe Rate of the Fine is \n"+getFine();
        
        return str;
    }
    
}
