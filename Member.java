public class Member {
	private String firstName;
	private String lastName;
	private int age;
	private String email;
	private int phoneNumber;
	private int id;
	private String activity;
	private String memberType;
	private Boolean active;
	
	public Member(String fn, String ln, int a, String email, int pn, int id, String act, String mType, Boolean active) {
		this.firstName = fn;
		this.lastName = ln;
		this.age = a;
		this.email = email;
		this.phoneNumber = pn;
		this.id = id;
		this.activity = act;
		this.memberType = mType;
		this.active = active;
	}
   public String toString()   {
      return "Member: " + "\nFirstname: " + firstName + "\nLastname: " + lastName + "\nAge: " + age + "\nEmail: " + email + "\nPhone number: " + phoneNumber + "\nId: " + id + "\nActivity: " + activity + "\nMember type: " + memberType + "\nActive or passive: " + active;
   }
	public void setFirstName(String fn) {
		this.firstName = fn;
	}
	public String getFirstName() {
		return firstName;
	}
	public void setLastName(String ln)	{
		this.lastName = ln;
	}
	public String getLastName() {
		return lastName;
	}
   public void setAge(int a) {
      this.age = a;
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
      this.phoneNumber = pn;
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
   public void setActivity(String act) {
      this.activity = act;
   }
   public String getActivity()   {
      return activity;
   }
   public void setMemberType(String mType)   {
      this.memberType = mType;
   }
   public String getMemberType() {
      return memberType;
   }
   public void setActive(Boolean active) {
      this.active = active;
   }
   public boolean getActive() {
      return active;
   }
   
   public static void main(String[] args){
      Member m1 = new Member("Lars", "Petersen", 44, "lol", 2223, 1, "Crawl", "Senior", true);
      System.out.println(m1);
   }
	
}
