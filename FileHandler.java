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
   public void printTrainerFromFile() throws FileNotFoundException{
      File f = new File("trainer.txt");
      Scanner scan = new Scanner(f);
      while(scan.hasNextLine()){
         String line = scan.nextLine();
         Scanner lineScan = new Scanner(line);
         String n = lineScan.next();
         String email = lineScan.next();
         int phone = lineScan.nextInt();
         int id = lineScan.nextInt();
         Trainer t1 = new Trainer(n, email, phone, id);
         trainerList.add(t1);
      }
   }
   public void printTournamentFromFile() throws FileNotFoundException{
      File f = new File("tournament.txt");
      Scanner scan = new Scanner(f);
      while(scan.hasNextLine()){
         String line = scan.nextLine();
         Scanner lineScan = new Scanner(line);
         String d = lineScan.next();
         String st = lineScan.next();
         int id = lineScan.nextInt();
         int pl = lineScan.nextInt();
         String time = lineScan.next();
         Tournament to1 = new Tournament(d, st, id, pl, time);
         tournamentList.add(to1);
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
   public void printTrainerToFile() throws FileNotFoundException{
      PrintStream write = new PrintStream(new File("trainer.txt"));
      for(int i = 0; i <= trainerList.size() - 1; i++){
         write.print(trainerList.get(i).getName() + " " + trainerList.get(i).getEmail() + " " + trainerList.get(i).getPhone() + " " + trainerList.get(i).getId());
         if(i != trainerList.size() - 1){
            System.out.print("\n");
         }
      }
   }
   public void printTournamentToFile() throws FileNotFoundException{
      PrintStream write = new PrintStream(new File("tournament.txt"));
      for(int i = 0; i <= tournamentList.size() - 1; i++){
         write.print(tournamentList.get(i).getDate() + " " + tournamentList.get(i).getSwimStyle() + " " + tournamentList.get(i).getId() + " " + tournamentList.get(i).getPlacement() + " " + tournamentList.get(i).getTime());
         if(i != tournamentList.size() - 1){
            System.out.print("\n");
         }
      }
   }
}