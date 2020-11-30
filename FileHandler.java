import java.io.*;
import java.util.*;

public class FileHandler{
  ArrayList<Member> memberList = new ArrayList<>();
  ArrayList<Trainer> trainerList = new ArrayList<>();
  ArrayList<Tournament> tournamentList = new ArrayList<>();
  
   public void printMemberFromFile() throws FileNotFoundException  {
      File f = new File("member.txt");
      Scanner read = new Scanner(f);
      while(read.hasNextLine())  {
         String line = read.nextLine();
         Scanner lineScan = new Scanner(line);
         String fn = lineScan.next();
         String ln = lineScan.next();
         int age = lineScan.nextInt();
         String email = lineScan.next();
         int pn = lineScan.nextInt();
         int id = lineScan.nextInt();
         String mType = lineScan.next();
         Boolean active = lineScan.nextBoolean();
         Member m1 = new Member(fn, ln, age, email, pn, id, mType, active);
         memberList.add(m1);
      } 
   }
   public void printMemberToFile() throws FileNotFoundException{
      PrintStream write = new PrintStream(new File("member.txt"));
      for(int i = 0; i <= memberList.size() - 1; i++){
          write.print(memberList.get(i).getFirstName() + " " + memberList.get(i).getLastName() + " " + memberList.get(i).getAge() + " " + memberList.get(i).getEmail() + " " + memberList.get(i).getPhoneNumber() + " " + memberList.get(i).getId() + " " + memberList.get(i).getMemberType() + " " + memberList.get(i).getActive());
          if(i != memberList.size() - 1){
              System.out.print("\n");
          }
      }
   }
   
   
}