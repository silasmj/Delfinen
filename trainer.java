public class trainer{
   private String name;
   private String email;
   private int phone;
   private int id;
   
   public trainer(String name, String email, int phone, int id){
      this.name = name;
      this.email = email;
      this.phone = phone;
      this.id = id;
   }
   public void setName(String name){
      this.name = name;
   }
   public String getName(String name){
      return name;
   }
   public void setEmail(String email){
      this.email = email;
   }
   public String getEmail(String email){
      return email;
   }
   public void setPhone(int phone){
      this.phone = phone;
   }
   public int getPhone(int phone){
      return phone;
   }
   public void setId(int id){
      this.id = id;
   }
   public int getId(int id){
      return id;
   }

public String toString(){
	return "trainer [name=" + name + ", email=" + email + ", phone=" + phone + ", id=" + id + "]";   }
}
