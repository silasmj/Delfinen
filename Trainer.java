public class Trainer{
   
   private String name;
   private String email;
   private int phone;
   private int id;
   
   public Trainer(String name, String email, int phone, int id){
       this.name = name;
       this.email = email;
       this.phone = phone;
       this.id = id;
   }
   
   public String toString(){
      return "Name: " + name + "\nEmail: " + email + "\nPhone: " + phone + "\nid: " + id;
   }
   
   public void setName(String name){
      this.name = name;
   }
   
   public void setEmail(String email){
      this.email = email;
   }
   
   public void setPhone(int phone){
      this.phone = phone;
   }
   
   public String getName(){
      return name;
   }
   
   public String getEmail(){
      return email;
   }
   
   public int getPhone(){
      return phone;
   }
}