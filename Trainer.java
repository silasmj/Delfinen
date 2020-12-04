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
   public Trainer()  {
   }
   public void setName(String name){
      this.name = name;
   }
   public String getName(){
      return name;
   }
   public void setEmail(String email){
      this.email = email;
   }
   public String getEmail(){
      return email;
   }
   public void setPhone(int phone){
      this.phone = phone;
   }
   public int getPhone(){
      return phone;
   }
   public void setId(int id){
      this.id = id;
   }
   public int getId(){
      return id;
   }

public String toString(){
	return "trainer [name=" + name + ", email=" + email + ", phone=" + phone + ", id=" + id + "]";   }
}
