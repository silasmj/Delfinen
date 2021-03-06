public class Member {
	private String firstName;
	private String lastName;
	private int age;
	private String email;
	private int phoneNumber;
	private int id;
	private Boolean active;
   private int arrears;
	
	public Member(String firstName, String lastName, int age, String email, int phoneNumber, int id, Boolean active, int arrears) {
		this.firstName = firstName;
		this.lastName = lastName;
		this.age = age;
		this.email = email;
		this.phoneNumber = phoneNumber;
		this.id = id;
		this.active = active;
      this.arrears = arrears;
	}
   
   public Member(){
   
   }
   
   @Override
   public String toString()   {
      String sActive;
      if(active == true)  {
         sActive = "active";
      }else{
         sActive = "passive";
      }
      return "Member: " + "\nFirstname: " + firstName + "\nLastname: " + lastName + "\nAge: " + age + "\nEmail: " + email + "\nPhone number: " + phoneNumber + "\nId: " + id + "\nActive or passive: " + active + "\nArrears: " + arrears;
   }
   public void setArrears(int arrears){
      this.arrears = arrears;
   }
   public int getArrears(){
      return arrears;
   }
	public void setFirstName(String fn) {
		firstName = fn;
	}
	public String getFirstName() {
		return firstName;
	}
	public void setLastName(String ln)	{
		lastName = ln;
	}
	public String getLastName() {
		return lastName;
	}
   public void setAge(int a) {
      age = a;
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
      phoneNumber = pn;
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
