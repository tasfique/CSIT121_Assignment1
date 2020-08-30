//Student's Full Name- Tasfique Enam
//Student's ID- J16020825/5886429
//Modification Date 16/04/2019
//Purpose of this file- PoliceOfficer Class
package assignment1;

public class PoliceOfficer {
    private String officerName;
    private String badgeNumber;
    
    public PoliceOfficer () {
        officerName = null;
        badgeNumber = null;
    }
    
    public void setOfficerName(String officerName) { //setter
        this.officerName = officerName;
    }
    
    public void setBadgeNumber(String badgeNumber) {
        this.badgeNumber = badgeNumber;
    }
    
    public String getOfficerName() { //getter
        return officerName;
    }
    
    public String getBadgeNumber() {
        return badgeNumber;
    }
    
    @Override
    public String toString(){ //toString to display
        String str;
        str = "\nThe Officer Name is \n"+getOfficerName()
                +"\nThe Badge Number of the Officer is \n"+getBadgeNumber()+"\n";
        return str;
    }
}
