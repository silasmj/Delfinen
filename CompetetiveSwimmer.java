public class CompetetiveSwimmer extends Member {
    private String swimStyle;
    private double records;

    public CompetetiveSwimmer(String fn, String ln, int a, String email, int pn, int id, String mType, Boolean active, String st, double r){
      super(fn, ln, a, email, pn, id, mType, active);
      this.swimStyle = st;
      this.records = r;
        
    }
    
    public String toString() {
      return "Competetive Swimmer" + "\nFirstname: " + getFirstName() + "\nLastname: " + getLastName() + "\nEmail: " + getEmail() + "\nPhone number: " + getPhoneNumber() + "\nId: " + getId() + "\nMember type: " + getMemberType() + "\nActive or passive: " + getActive() + "\nSwim style: " + swimStyle + "\nRecords: " + records;
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
