import java.util.*;
import java.io.*;
import java.text.DecimalFormat;
import java.lang.Math;

public class Delfinen   {
   public static void main(String[] args) throws FileNotFoundException{
      Scanner scan = new Scanner(System.in);
      scan.useLocale(Locale.US);
      
      FileHandler filehandler = new FileHandler();
      //showMembers(scan, filehandler);
      //mainMenu(scan, filehandler);
      
      createNewMember(scan, filehandler);
      //createTrainer(scan, filehandler);
      //createNewTournament(scan, filehandler);
      
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
      System.out.println("=====Main menu=====\n1 = Showdata\n2 = Savedata\n3 = Quit");
      String s = input.next();
      if(s.equalsIgnoreCase("1")){
         showData(input, filehandler);
      }else if(s.equalsIgnoreCase("2")){
        // saveData(input, filehandler);
      }
   }
   
   public static void showData(Scanner input, FileHandler filehandler){
      System.out.println("=====Show Data=====");
      System.out.println("1 = Members\n2 = Trainers\n3 = Tournaments\n4 = Back");
      String s = input.next();
      if(s.equalsIgnoreCase("1")){
         showMembers(input, filehandler);
      }else if(s.equalsIgnoreCase("2")){
         showTrainers(input, filehandler);
      }else if(s.equalsIgnoreCase("3")){
         showTournaments(input, filehandler);
      }else if(s.equalsIgnoreCase("4")){
         mainMenu(input, filehandler);
      }
   }
   
   public static void showMembers(Scanner input, FileHandler filehandler){
      System.out.println("Members");
      for(int i = 0; i <= filehandler.memberList.size() - 1; i++){
         System.out.println(filehandler.memberList.get(i).getFirstName());
      }
      System.out.println("1 = Create member\n2 = Delete member\n3 = Edit member\n4 = Back");
      int s = input.nextInt();
      if(s == 1){
         createNewMember(input, filehandler);       
      }else if(s == 2){
         //deleteMember(input, filehandler);
      }else if(s == 3){
         //editMember(input, filehandler);
      }else if(s == 4){
         showData(input, filehandler);
      }
   }
   
   public static void showTrainers(Scanner input, FileHandler filehandler){
      
   }
   
   public static void showTournaments(Scanner input, FileHandler filehandler){
      
   }
   
  public static void createNewMember(Scanner input, FileHandler filehandler){
     CompetetiveSwimmer compSwimmer = new CompetetiveSwimmer();
     Member normalSwimmer = new Member();
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
      System.out.println("Enter true for active or false for passive");
      boolean active = input.nextBoolean();
      String swimStyle;
      if(swimmer == 2){
         System.out.println("Enter swim style: ");
         swimStyle = input.next();
         compSwimmer = new CompetetiveSwimmer(firstName, lastName, age, email, phoneNumber, getFreeMemberID(filehandler), active, swimStyle);
         filehandler.memberList.add(compSwimmer);
      } else if(swimmer == 1){
        normalSwimmer = new Member(firstName, lastName, age, email, phoneNumber, getFreeMemberID(filehandler), active);
         filehandler.memberList.add(normalSwimmer);
      }
      
      int priceToPay = 0;
      if(active == true){
         if(normalSwimmer.getAgeGroup() == "junior"){
            priceToPay = 1000;
         }else if(normalSwimmer.getAgeGroup() == "senior"){
            priceToPay = 1600;
         }else if(normalSwimmer.getAgeGroup() == "pensioner"){
            priceToPay = 1200;
         }
      }else{
         priceToPay = 500;
      }
      
      System.out.println("Enter amount paid: ");
      int amountPaid = input.nextInt();
      
      int newPrice = calculateArrears(priceToPay, amountPaid);
      
      if(newPrice <= 0){
         System.out.println("The customer should get " + Math.abs(newPrice) + " back");
          normalSwimmer.setArrears(0);
      }else{
         System.out.println("The customer got " + newPrice + " in arrears");
         normalSwimmer.setArrears(newPrice);
      }
      
      if(swimmer == 2){
         filehandler.memberList.add(compSwimmer);
      }else if(swimmer == 1){
         filehandler.memberList.add(normalSwimmer);
      }
  }
  
  public static int calculateArrears(int price, int amountPaid){
      System.out.println("Price: " + price + " amountPaid: " + amountPaid);
      int newPrice = price - amountPaid;
      return newPrice;
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