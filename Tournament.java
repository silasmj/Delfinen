public class Tournament{

   private String date;
   private String swimStyle;
   private int ID;
   private int placement;
   private double time;

   public Tournament(String date, String swimStyle, int ID, int placement, double time){
      this.date = date;
      this.swimStyle = swimStyle;
      this.ID = ID;
      this.placement = placement;
      this.time = time;
   }

   public String toString(){
      return "Date: " + date + "\nswimStyle: " + swimStyle + "\nID: " + ID + "\nplacement: " + placement + "\ntime: " + time;
   }

   public String getDate(){
      return date;
   }
   
   public String getSwimStyle(){
      return swimStyle;
   }
   public int getId(){
      return ID;
   }
   public int getPlacement(){
      return placement;
   }
   public double getTime(){
      return time;
   }
}