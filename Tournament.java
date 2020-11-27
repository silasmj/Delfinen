public class Tournament{

   private String date;
   private String swimStyle;
   private String ageGroup;
   private int ID;
   private int placement;
   private double time;

   public Tournament(String date, String swimStyle, String ageGroup, int ID, int placement, double time){
      this.date = date;
      this.swimStyle = swimStyle;
      this.ageGroup = ageGroup;
      this.ID = ID;
      this.placement = placement;
      this.time = time;
   }

   public String toString(){
      return "Date: " + date + "\nswimStyle: " + swimStyle + "\nageGroup: " + ageGroup + "\nID: " + ID + "\nplacement: " + placement + "\ntime: " + time;
   }

   public String getDate(){
      return date;
   }
   
   public String getSwimStyle(){
      return swimStyle;
   }
   
   public String getAgeGroup(){
      return ageGroup;
   }
   public int getID(){
      return ID;
   }
   public int getPlacement(){
      return placement;
   }
   public double getTime(){
      return time;
   }
}