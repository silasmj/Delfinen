import java.util.ArrayList;

public class CompetetiveSwimmer extends Member {
    private String swimStyle;
    private double records;
    private ArrayList<Integer> listOfTournaments = new ArrayList<>();
    private int trainerId;

    public CompetetiveSwimmer(String firstName, String lastName, int age, String email, int phoneNumber, int id, Boolean active, String swimStyle, double records){
      super(firstName, lastName, age, email, phoneNumber, id, active);
      this.swimStyle = swimStyle;
      this.records = records;
        
    }
    
    public String toString() {
      return "Competetive Swimmer" + "\nFirstname: " + getFirstName() + "\nLastname: " + getLastName() + "\nEmail: " + getEmail() + "\nPhone number: " + getPhoneNumber() + "\nId: " + getId() + "\nActive or passive: " + getActive() + "\nSwim style: " + swimStyle + "\nRecords: " + records;
    }
    
    public String getSwimStyle(){
      return swimStyle;
    }
    
    public void setSwimStyle(String swimStyle){
      this.swimStyle = swimStyle;
    }
    
    public double getRecords(){
      return records;
    }
    
    public void setRecords(double records){
      this.records = records;
    }


}
