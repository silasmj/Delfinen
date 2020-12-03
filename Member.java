public class Member {
	private String firstName;
	private String lastName;
	private int age;
	private String email;
	private int phoneNumber;
	private int id;
	private String memberType;
	private Boolean active;
	
	public Member(String firstName, String lastName, int age, String email, int phoneNumber, int id, Boolean active) {
		this.firstName = firstName;
		this.lastName = lastName;
		this.age = age;
		this.email = email;
		this.phoneNumber = phoneNumber;
		this.id = id;
		this.active = active;
	}
   
   public Member(){
   
   }
   public String toString()   {
      return "Member: " + "\nFirstname: " + firstName + "\nLastname: " + lastName + "\nAge: " + age + "\nEmail: " + email + "\nPhone number: " + phoneNumber + "\nId: " + id + "\nActive or passive: " + active;
   }
	public void setFirstName(String fn) {
		this.firstName = firstName;
	}
	public String getFirstName() {
		return firstName;
	}
	public void setLastName(String ln)	{
		this.lastName = lastName;
	}
	public String getLastName() {
		return lastName;
	}
   public void setAge(int a) {
      this.age = age;
   }
   public int getAge()  {
      return age;
   }
   public void setEmail(String email)  {
      this.email = email;
   }
   public String getEmail()   {
      return email;
   }
   public void setPhoneNumber(int pn)  {
      this.phoneNumber = phoneNumber;
   }
   public int getPhoneNumber()   {
      return phoneNumber;
   }
   public void setId(int id)  {
      this.id = id;
   }
   public int getId()   {
      return id;
   }

   public void setActive(Boolean active) {
      this.active = active;
   }
   public boolean getActive() {
      return active;
   }
   public String getAgeGroup(){
      String ageGroup;
      if(age >= 18 && age < 60){
         ageGroup = "senior";
      }else if (age < 18){
         ageGroup = "junior";
      }else{
         ageGroup = "pensioner";
      }
         return ageGroup;
   }
	
}
