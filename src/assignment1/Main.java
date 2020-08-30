//Student's Full Name- Tasfique Enam
//Student's ID- J16020825/5886429
//Modification Date 16/04/2019
//Purpose of this file- Main Class
package assignment1;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.Scanner;

public class Main {
    
    public static void main(String[] args) {
       Scanner read = new Scanner(System.in); //scanner for reading input from the user.
       int PoliceSelector= 1;
       int option;
       int carNumbers;
      // PoliceOfficer policeObj = new PoliceOfficer(); //policeofficer object
       //ParkedCar parkedCarObj = new ParkedCar();
       //
       ParkingMeter [] AryObjParkingMeter = null; // (it was at down) this is an array object to store purchased parking ticket.
       ParkedCar [] AryObjParkingLot = null; //an array object to store the car's information like car name, registration, color etc...
       ArrayList<PoliceOfficer> policeList = new ArrayList<>(); //police officer array list
       ArrayList<ParkingTicket> parkingTicketList = new ArrayList<>(); //parking ticket array list.
       ArrayList<ParkingMeter> parkingMeterList = new ArrayList<>();
       
      
       
        //entering name of the police officer and their badge number.
        System.out.println("     WELCOME!");
        do{
            System.out.print("*******************\n" + //display menu
                                "1. Enter the Details of the Police Officer.\n" +
                                "2. Enter the Car's Details\n" +
                                "3. Make Calculation and Check Parked Car Status\n"+
                                "4. Display\n"+
                                "5. Exit\n"+
                                "*********************\n" +
                                "Please the enter the number '1' '2' '3' '4' '5' :"
            );
             option = read.nextInt();
             
        switch(option) { //using switch case for selection
            case 1: 
            {
                System.out.print("*****************************\n");
                System.out.println("Sign up for Duty.");
                System.out.print("*****************************\n");
                System.out.println("Enter the Name of the Police Officer");
                String name = read.next();
                System.out.println("Enter the Badge Number of the Police Officer");
                String badgeNumber = read.next();
        
                       PoliceOfficer policeObj = new PoliceOfficer(); //policeofficer object

                //putting the input into the object.
                policeObj.setOfficerName(name);
                policeObj.setBadgeNumber(badgeNumber);
                policeList.add(policeObj); //adding the police object into array list.
                
                System.out.print("\nNow there are "+policeList.size()+" Police Officer in the System\n ");//keep track of how many police officer in the system
                System.out.println("\n"+name+" is Police Officer Number "+policeList.size()+"\n");
                
                break;
            }

            case 2: 
            {
                System.out.println("Which Police Officer Number are you? Please enter the Number (Only One Police Officer can work at a time!)");
                PoliceSelector = read.nextInt();
                
                if(policeList.size() !=0 && PoliceSelector<= policeList.size() && PoliceSelector >0) { //doing validation of wrong user input.
                    policeList.get(PoliceSelector-1); // selecting from the array list of police objects, to let users select which police they want to work with, as only one police officer can work at a time.
                    System.out.println("Police Officer "+PoliceSelector+" is on duty now\n");
                    System.out.println("Enter How many car is there.");
                    carNumbers = read.nextInt();
                    AryObjParkingLot = new ParkedCar [carNumbers]; //inputting the user input into the parkingLot array 
                    //parked car array of object
                    AryObjParkingMeter = new ParkingMeter [carNumbers]; //inputting the user input into meters array, as the Parking Car Objects needs to be stored into a specific array index that matches the parkingLot[] and meters[]
                    //parking meter array of object
                
                for(int c=0; c<carNumbers; c++) { //using a for loop for the number of cars there are, that the user inputted.
                    System.out.println("What is the Car Make of Car Number "+(c+1)+"? "); //asking for user input.
                    String carMake = read.next();
                    System.out.println("What is the Car Model of Car Number "+(c+1)+"? ");
                    String carModel = read.next();
                    System.out.println("What is the Car Colour of Car Number "+(c+1)+"? ");
                    String carColor = read.next();
                    System.out.println("What is the Car Registration of Car Number "+(c+1)+"? ");
                    String carReg = read.next();
                    System.out.println("How many Minutes was the Car Number "+(c+1)+" Parked?");
                    int minuteParkedTime = read.nextInt();

                    AryObjParkingLot[c] = new ParkedCar(carMake, carModel, carColor, carReg, minuteParkedTime); 
                    //inputting the user's input into the ParkedCar objects and they r put into Array with a for loop.
                    //parkingLot.(parkedCarObj);

                    System.out.println("Enter the Purchased Parking Time ");
                    int purchasedParkingTime = read.nextInt();
                    
                    AryObjParkingMeter[c] = new ParkingMeter(); //meter[c] is assigned to new ParkingMeter();
                   
                    AryObjParkingMeter[c].setPurchaseParkingTime(purchasedParkingTime); //it is used like this because it is a setter.
                    //inputting the user's input into array as ParkingMeter number needs to be the same as ParkedCar Array

                }
                    
                }else{
                    System.out.println("\n What you have selected doesn't exist in the System \n");
                }
                
                break;
               
            }
            case 3:
            {
                if(policeList.size() !=0 && AryObjParkingLot != null){ //this is a validation if the user inputs directly 3 in the system in the selection menu
                    System.out.println("The number of '✔' shows the number of Parking Tickets that have created. \n");
                    for(int index=0; index < AryObjParkingLot.length; index++) //using a for loop as there r more than one number of cars.
                        {
                        if(AryObjParkingLot[index].getMinuteParked() > 
                            AryObjParkingMeter[index].getPurchaseParkingTime()) //using if statement to make a comparison to see if minute parked is greater than purchased parking time
                            {
                                ParkingTicket parkingTicketObj = new ParkingTicket(); //create a new object 
                                ParkingMeter parkingMeterObj = new ParkingMeter();
                                
                                parkingTicketObj.setPoliceOfficer(policeList.get(PoliceSelector-1)); //in the parkingTicketObj of the ParkingTicket class, setting the setPoliceOfficer method. policeObj contains police officer details.
                                parkingTicketObj.Calculation(AryObjParkingLot[index].getMinuteParked() - AryObjParkingMeter[index].getPurchaseParkingTime()); //accessing calculation method from the parkingTicketObj
                                parkingTicketObj.setParkedCarObj(AryObjParkingLot[index]); //accessing setParkedCarObj method to 
                                parkingMeterObj.setPurchaseParkingTime(AryObjParkingMeter[index].getPurchaseParkingTime());
                                
                                
                                parkingTicketList.add(parkingTicketObj); //putting parkingTicketObj inside the Parking ticket array list.
                                parkingMeterList.add(parkingMeterObj);
                                System.out.println("✔");
                                
                            }else{
                                System.out.println("\nThere are some Legally Parked Cars, and they have been Ommited from Display. \n");
                            }
                        }
                    
                }else{
                    System.out.println("\nPolice Officer or Car have not been entered into the System \n");
                    System.out.println("You must Sign in as a Police Officer and Enter the Car information for Option 3 to Process.\n");
                }
                
                    System.out.println("\nPlease Select Option '4' to Display the Information.\n");
                break;
            }
            
            case 4:
                
            {
                    System.out.println("Option '4' have been Selected\n");
                    Iterator <ParkingTicket> itr = parkingTicketList.iterator(); //using itr to display all the elements
                    Iterator <ParkingMeter> itr2 = parkingMeterList.iterator();
                    while(itr.hasNext()) {
                        ParkingTicket element = itr.next();
                        ParkingMeter element2 = itr2.next();
                        System.out.println("*********************************************************** \n"+element);
                        System.out.println("*********************************************************** \n"+element2);
                    }
                    
                    /*Iterator <ParkingMeter> itr2 = parkingMeterList.iterator();
                    while(itr2.hasNext()) {
                        ParkingMeter element2 = itr2.next();
                        System.out.println("*********************************************************** \n"+element2);
                        
                    }*/
                   
                break;
            }
            case 5:
            {
                option =0;
                break;
            }
            
            default:
            {
                System.out.println("You have selected the wrong number "); // if the user have inputted the wrong number, in the selection menu.
                break;
            }
                
            
            
       
        }
        
        }while (option!=0);
  
    }
    
}
