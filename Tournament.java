public class Tournament{

   private String date;
   private String swimStyle;
   private int Id;
   private int placement;
   private double time;

   public Tournament(String date, String swimStyle, int Id, int placement, double time){
      this.date = date;
      this.swimStyle = swimStyle;
      this.Id = Id;
      this.placement = placement;
      this.time = time;
   }
   public Tournament()  {
   
   }

   public String toString(){
      return "ID: " + Id + "\nDate: " + date + "\nswimStyle: " + swimStyle + "\nplacement: " + placement + "\ntime: " + time;
   }

   public String getDate(){
      return date;
   }
   
   public String getSwimStyle(){
      return swimStyle;
   }
   public int getId(){
      return Id;
   }
   public int getPlacement(){
      return placement;
   }
   public double getTime(){
      return time;
   }
   public void setId(int Id){
      this.Id = Id;
   }
   public void setDate(String date){
      this.date = date;
   }
   public void setSwimStyle(String swimStyle){
      this.swimStyle = swimStyle;
   }
   public void setPlacement(int placement){
      this.placement = placement;
   }
   public void setTime(double time){
      this.time = time;
   }
}