//Student's Full Name- Tasfique Enam
//Student's ID- J16020825/5886429
//Modification Date 16/04/2019
//Purpose of this file- Parked Car Class

package assignment1;

public class ParkedCar { //declaring attributes.
    private String CarMake;
    private String CarModel;
    private String CarColor;
    private String CarReg;
    private int MinuteParked;
    
    public ParkedCar (){ //constructor with the minuteparked initialised to 0 this is the default constructor
        CarMake = "";
        CarModel = "";
        CarColor = "";
        CarReg = "";
        MinuteParked = 0;
    }
    public ParkedCar (String CarMake, String CarModel, String CarColor, String CarReg, int MinuteParked){ //non default constructor
        this.CarMake = CarMake;
        this.CarModel = CarModel;
        this.CarColor = CarColor;
        this.CarReg = CarReg;
        this.MinuteParked = MinuteParked;
    }
    
    public void setMinuteParked (int MinuteParked) { //setter method for minute parked.
        this.MinuteParked = MinuteParked;
    }
    
    public int getMinuteParked (){ //getter for minute parked.
        return MinuteParked;
    }
    
    
    @Override
     public String toString(){ //toString to Display
        String str;
        str = "\nThe Number of Minutes the Car was Parked \n"+getMinuteParked()+"\n"
                +"\n**********************"+
                "\nTHE DETAILS OF THE CAR \n"+
                "**********************\n"+
                "\nThe Car Maker is "+CarMake+
                "\nThe Model of the Car is "+CarModel+
                "\nThe Colour of the Car is "+CarColor+
                "\nThe Registration of the Car is "+CarReg+"\n";
        return str;
    }
    
}
