import java.io.*;
import java.util.*;

public class FileHandler implements Comparator<Member>{
  private ArrayList<Member> memberList = new ArrayList<>();
  private ArrayList<Trainer> trainerList = new ArrayList<>();
  private ArrayList<Tournament> tournamentList = new ArrayList<>();
  
   public void createFile() throws IOException   {
      File mFile = new File("member.txt");
      File tFile = new File("trainer.txt");
      File toFile = new File("tournament.txt");
      mFile.createNewFile();
      tFile.createNewFile();
      toFile.createNewFile();
   }

 /*  public int compare (Member m1, Member m2){
      int comparison = 0;
      comparison = m1.memberList.getArrears().compareTo(m2.memberList.getArrears());
      if(comparison == 0)  {
         comparison = m1.memberList.getFirstName().compareTo(m2.memberList.getFirstName());
      }
      return comparison;
   }*/
   
   public void printMemberFromFile() throws FileNotFoundException  {
      File f = new File("member.txt");
      Scanner read = new Scanner(f);
      while(read.hasNextLine())  {
         String line = read.nextLine();
         Scanner lineScan = new Scanner(line);
         String firstName = lineScan.next();
         String lastName = lineScan.next();
         int age = lineScan.nextInt();
         String email = lineScan.next();
         int phoneNumber = lineScan.nextInt();
         int id = lineScan.nextInt();
         Boolean active = lineScan.nextBoolean();
         int arrears = lineScan.nextInt();
         if(lineScan.hasNext()){
            String swimStyle = lineScan.next();
            int trainerId = lineScan.nextInt();
            CompetetiveSwimmer compS = new CompetetiveSwimmer(firstName, lastName, age, email, phoneNumber, id, active, arrears, swimStyle, trainerId);
            memberList.add(compS);
         }else{
            Member m1 = new Member(firstName, lastName, age, email, phoneNumber, id, active, arrears);
            memberList.add(m1);
         }
      } 
   }
   public void printTrainerFromFile() throws FileNotFoundException{
      File f = new File("trainer.txt");
      Scanner scan = new Scanner(f);
      while(scan.hasNextLine()){
         String line = scan.nextLine();
         Scanner lineScan = new Scanner(line);
         String name = lineScan.next();
         String email = lineScan.next();
         int phoneNumber = lineScan.nextInt();
         int id = lineScan.nextInt();
         Trainer t1 = new Trainer(name, email, phoneNumber, id);
         trainerList.add(t1);
      }
   }
   public void printTournamentFromFile() throws FileNotFoundException{
      File f = new File("tournament.txt");
      Scanner scan = new Scanner(f);
      while(scan.hasNextLine()){
         String line = scan.nextLine();
         Scanner lineScan = new Scanner(line);
         String date = lineScan.next();
         String swimStyle = lineScan.next();
         int id = lineScan.nextInt();
         int placement = lineScan.nextInt();
         String time = lineScan.next();
         Tournament to1 = new Tournament(date, swimStyle, id, placement, time);
         tournamentList.add(to1);
      }
   }
   public void printMemberToFile() throws FileNotFoundException{
      try {
         PrintStream write = new PrintStream(new File("member.txt"));
         for(int i = 0; i <= memberList.size() - 1; i++){
            if(memberList.get(i).getClass().getName() == "CompetetiveSwimmer"){
                CompetetiveSwimmer tempCompSwimmer;
                tempCompSwimmer = (CompetetiveSwimmer) memberList.get(i);
                write.print(tempCompSwimmer.getFirstName() + " " + tempCompSwimmer.getLastName() + " " + tempCompSwimmer.getAge() + " " + tempCompSwimmer.getEmail() + " " + tempCompSwimmer.getPhoneNumber() + " " + tempCompSwimmer.getId() + " " + tempCompSwimmer.getActive() + " " + tempCompSwimmer.getArrears() + " " + tempCompSwimmer.getSwimStyle() + " " + tempCompSwimmer.getTrainerId());
            }else{  
                write.print(memberList.get(i).getFirstName() + " " + memberList.get(i).getLastName() + " " + memberList.get(i).getAge() + " " + memberList.get(i).getEmail() + " " + memberList.get(i).getPhoneNumber() + " " + memberList.get(i).getId() + " " + memberList.get(i).getActive() + " " + memberList.get(i).getArrears());      
            }
            if(i != memberList.size() - 1){
                 write.print("\n");
            } 
          }   
      }catch (FileNotFoundException e) {
         e.printStackTrace();
      }
   }
   public void printTrainerToFile() throws FileNotFoundException{
      PrintStream write = new PrintStream(new File("trainer.txt"));
      for(int i = 0; i <= trainerList.size() - 1; i++){
         write.print(trainerList.get(i).getName() + " " + trainerList.get(i).getEmail() + " " + trainerList.get(i).getPhone() + " " + trainerList.get(i).getId());
         if(i != trainerList.size() - 1){
            write.print("\n");
         }
      }
   }
   public void printTournamentToFile() throws FileNotFoundException{
      PrintStream write = new PrintStream(new File("tournament.txt"));
      for(int i = 0; i <= tournamentList.size() - 1; i++){
         write.print(tournamentList.get(i).getDate() + " " + tournamentList.get(i).getSwimStyle() + " " + tournamentList.get(i).getId() + " " + tournamentList.get(i).getPlacement() + " " + tournamentList.get(i).getTime());
         if(i != tournamentList.size() - 1){
            write.print("\n");
         }
      }
   }
   public ArrayList<Tournament> getTournamentList(){
      return tournamentList;
   }
   public ArrayList<Member> getMemberList(){
      return memberList;
   }
   public ArrayList<Trainer> getTrainerList(){
      return trainerList;
   }
}