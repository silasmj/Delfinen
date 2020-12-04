import java.util.ArrayList;

public class CompetetiveSwimmer extends Member {
    private String swimStyle;
    private ArrayList<Integer> listOfTournaments = new ArrayList<>();
    private int trainerId;

    public CompetetiveSwimmer(String firstName, String lastName, int age, String email, int phoneNumber, int id, Boolean active, String swimStyle){
      super(firstName, lastName, age, email, phoneNumber, id, active);
      this.swimStyle = swimStyle;   
    }
    
    public CompetetiveSwimmer() {
    }
    
    public String toString() {
      return "Competetive Swimmer" + "\nFirstname: " + getFirstName() + "\nLastname: " + getLastName() + "\nEmail: " + getEmail() + "\nPhone number: " + getPhoneNumber() + "\nId: " + getId() + "\nActive or passive: " + getActive() + "\nSwim style: " + swimStyle;
    }
    
    public String getSwimStyle(){
      return swimStyle;
    }
    
    public void setSwimStyle(String swimStyle){
      this.swimStyle = swimStyle;
    }
   

}
