//Student's Full Name- Tasfique Enam
//Student's ID- J16020825/5886429
//Modification Date 16/04/2019
//Purpose of this file- Parking Meter Class
package assignment1;

public class ParkingMeter { //declaring attributes
    private int PurchasedParkingTime;
    
    public ParkingMeter (){ //default constructor.
        PurchasedParkingTime = 0;
    }
    
    public void setPurchaseParkingTime (int PurchasedParkingTime) { //setter
        this.PurchasedParkingTime = PurchasedParkingTime;
    }
    
    public int getPurchaseParkingTime () { //getter
        return PurchasedParkingTime;
    }
    
    @Override
    public String toString(){ //toString to display
        String str;
        str = "\nPurchased Parking Time is \n"+getPurchaseParkingTime();
        return str;
    }
    
    
}
