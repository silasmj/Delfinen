import java.util.*;
import java.io.*;
import java.text.DecimalFormat;

public class Delfinen   {
   public static void main(String[] args) throws FileNotFoundException{
      Scanner scan = new Scanner(System.in);
      scan.useLocale(Locale.US);
      
      FileHandler filehandler = new FileHandler();
      showMembers(scan, filehandler);
      //mainMenu(scan, filehandler);
      
      //createNewMember(scan, filehandler);
      //createTrainer(scan, filehandler);
      createNewTournament(scan, filehandler);
      
      //filehandler.printMemberToFile();
      //filehandler.printMemberFromFile();
      
      filehandler.printTrainerToFile();
      filehandler.printTrainerFromFile();
      
      filehandler.printTournamentToFile();
      filehandler.printTournamentFromFile();
      
      //System.out.println(filehandler.memberList);
      //System.out.println(filehandler.trainerList);
      //System.out.println(filehandler.tournamentList);
   }
   
   public static void mainMenu(Scanner input, FileHandler filehandler){
      System.out.println("=====Main menu=====\nD = Showdata\nS = Savedata\nQ = Quit");
      String s = input.next();
      if(s.equalsIgnoreCase("d")){
         showData(input, filehandler);
      }else if(s.equalsIgnoreCase("s")){
        // saveData(input, filehandler);
      }
   }
   
   public static void showData(Scanner input, FileHandler filehandler){
      System.out.println("Data");
      String s = input.next();
      System.out.println("M = Members\nT = Trainers\nU = Tournaments\nB = Back");
      if(s.equalsIgnoreCase("m")){
         showMembers(input, filehandler);
      }else if(s.equalsIgnoreCase("t")){
         showTrainers(input, filehandler);
      }else if(s.equalsIgnoreCase("u")){
         showTournaments(input, filehandler);
      }else if(s.equalsIgnoreCase("b")){
         mainMenu(input, filehandler);
      }
   }
   
   public static void showMembers(Scanner input, FileHandler filehandler){
      System.out.println("Members");
      for(int i = 0; i <= filehandler.memberList.size() - 1; i++){

                 
      }
      System.out.println("1 = Create member\n2 = Delete member\n3 = Edit member");
      int s = input.nextInt();
      if(s == 1){
         createNewMember(input, filehandler);       
      }else if(s == 2){
         //deleteMember(input, filehandler);
      }else if(s == 3){
         //editMember(input, filehandler);
      }
   }
   
   public static void showTrainers(Scanner input, FileHandler filehandler){
      
   }
   
   public static void showTournaments(Scanner input, FileHandler filehandler){
      
   }
   
   public static void createNewMember(Scanner input, FileHandler filehandler){
      
      System.out.println("Press 1 for swimmer\nPress 2 for competetive swimmer");
      int swimmer = input.nextInt();
      System.out.println("Enter first name: ");
      String firstName = input.next();
      System.out.println("Enter last name: ");
      String lastName = input.next();
      System.out.println("Enter age: ");
      int age = input.nextInt();
      System.out.println("Enter email: ");
      String email = input.next();
      System.out.println("Enter phone number: ");
      int phoneNumber = input.nextInt();
      System.out.println("Enter member type: ");
      String memberType = input.next();
      System.out.println("Enter true for active or false for passive");
      boolean active = input.nextBoolean();
      if(swimmer == 2){
         System.out.println("Enter swim style: ");
         String swimStyle = input.next();
         System.out.println("Enter records: ");
         double records = input.nextDouble();
         CompetetiveSwimmer swimmer2 = new CompetetiveSwimmer(firstName, lastName, age, email, phoneNumber, getFreeMemberID(filehandler), memberType, active, swimStyle, records);
         filehandler.memberList.add(swimmer2);
      } else if(swimmer == 1){
         Member swimmerMotionist = new Member(firstName, lastName, age, email, phoneNumber, getFreeMemberID(filehandler), memberType, active);
         filehandler.memberList.add(swimmerMotionist);
      }
   }
   
   public static void createTrainer(Scanner input, FileHandler filehandler){
      System.out.println("Enter first name: ");
      String name = input.next();
      System.out.println("Enter email: ");
      String email = input.next();
      System.out.println("Enter phone: ");
      int phone= input.nextInt();
      
      Trainer newTrainer = new Trainer(name, email, phone, 1);
      filehandler.trainerList.add(newTrainer);
   }
   public static void createNewTournament(Scanner input, FileHandler filehandler){
      System.out.println("Enter date");
      String date = input.next();
      System.out.println("Enter swimstyle");
      String swimStyle = input.next();
      System.out.println("Enter placement");
      int placement = input.nextInt();
      System.out.println("Enter time");
      String time = input.next();
      Tournament t1 = new Tournament(date, swimStyle, 1, placement, time);
      filehandler.tournamentList.add(t1);
   }
    
   public static int getFreeMemberID(FileHandler filehandler){
      ArrayList<Integer> usedIds = new ArrayList<>();
      
      int index = 0;
      for (Member currentMember : filehandler.memberList){
         usedIds.add(currentMember.getId());
      }
      
      int givenID = 1;
      
      if(usedIds.size() >= 1){
         givenID = Collections.max(usedIds) + 1;
      }
      return givenID;
   }
   
   public static int getFreeTrainerID(FileHandler filehandler){
      ArrayList<Integer> usedIds = new ArrayList<>();
      
      int index = 0;
      for (Trainer currentTrainer : filehandler.trainerList){
         usedIds.add(currentTrainer.getId());
      }
      
      int givenID = 1;
      
      if(usedIds.size() >= 1){
         givenID = Collections.max(usedIds) + 1;
      }
      return givenID;
   }
   
   public static int getFreeTournamentID(FileHandler filehandler){
      ArrayList<Integer> usedIds = new ArrayList<>();
      
      int index = 0;
      for (Tournament currentTournament : filehandler.tournamentList){
         usedIds.add(currentTournament.getId());
      }
      
      int givenID = 1;
      
      if(usedIds.size() >= 1){
         givenID = Collections.max(usedIds) + 1;
      }
      return givenID;
   }
}