import java.io.*;
import java.util.*;

public class FileHandler{
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
            String tournaments = lineScan.next();
            String[] array1 = tournaments.split(",");
            for(int i = 0; i <= array1.length - 1; i++) {
               int value = Integer.parseInt(array1[i]);
               compS.getListOfTournaments().add(value);
            }
            
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
         double time = lineScan.nextDouble();
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
                String stringOfValues = "";
                for(int k = 0; k <= tempCompSwimmer.getListOfTournaments().size() -1; k++){
                    if(k != tempCompSwimmer.getListOfTournaments().size() - 1){
                        stringOfValues = stringOfValues + tempCompSwimmer.getListOfTournaments().get(k) + ",";
                    }else{
                        stringOfValues = stringOfValues + tempCompSwimmer.getListOfTournaments().get(k);
                    }
                }
                write.print(tempCompSwimmer.getFirstName() + " " + tempCompSwimmer.getLastName() + " " + tempCompSwimmer.getAge() + " " + tempCompSwimmer.getEmail() + " " + tempCompSwimmer.getPhoneNumber() + " " + tempCompSwimmer.getId() + " " + tempCompSwimmer.getActive() + " " + tempCompSwimmer.getArrears() + " " + tempCompSwimmer.getSwimStyle() + " " + tempCompSwimmer.getTrainerId() + " " + stringOfValues);
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
         String time = String.valueOf(tournamentList.get(i).getTime());
         String formattedTime = time.replace(".", ",");
         write.print(tournamentList.get(i).getDate() + " " + tournamentList.get(i).getSwimStyle() + " " + tournamentList.get(i).getId() + " " + tournamentList.get(i).getPlacement() + " " + formattedTime);
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