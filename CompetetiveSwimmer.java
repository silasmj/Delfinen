public class CompetetiveSwimmer extends Member {
    private String swimStyle;
    private int ageGroup;
    private double records;

    public CompetetiveSwimmer(String fn, String ln, int a, String email, int pn, int id, String act, String mType, Boolean active, String st, int ag, double r){
      super(fn, ln, a, email, pn, id, act, mType, active);
      this.swimStyle = st;
      this.ageGroup = ag;
      this.records = r;
        
    }
    
    public String toString() {
      return "Competetive Swimmer" + "\nFirstname: " + fn + "\nLastname: " + ln + "\nAge: " + a + "\nEmail: " + email + "\nPhone number: " + pn + "\nId: " + id + "\nActivity: " + act + "\nMember type: " + mType + "\nActive or passive: " + active + "\nSwim style: " + swimStyle + "\nAge group: " + ageGroup + "\nRecords: " + records;
    }
    
    public String getSwimStyle(){
      return swimStyle;
    }
    
    public void setSwimStyle(String swimStyle){
      this.swimStyle = st;
    }
    
    public int getAgeGroup(){
      return ageGroup;
    }
    
    public void setAgeGroup(int ageGroup){
      this.ageGroup = ag;
    }

    public int getRecords(){
      return records;
    }
    
    public void setRecords(double records){
      this.records = r;
    }


}
