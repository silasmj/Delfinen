import java.util.*;
import java.io.*;
import java.text.DecimalFormat;
import java.lang.Math;

public class Delfinen   {
   public static void main(String[] args) throws FileNotFoundException{
      Scanner input = new Scanner(System.in);
      input.useLocale(Locale.US);
      
      FileHandler filehandler = new FileHandler();
      //showMembers(input, filehandler);
      mainMenu(input, filehandler);
      
      //createNewMember(input, filehandler);
      //createTrainer(input, filehandler);
      //createNewTournament(input, filehandler);
      
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
      for(int i = 0; i <= filehandler.getMemberList().size() - 1; i++){
         System.out.println("First name: " + filehandler.getMemberList().get(i).getFirstName() + "\nLast Name: " + filehandler.getMemberList().get(i).getLastName() + "\nAge: " + filehandler.getMemberList().get(i).getAge() + "\nEmail: " + filehandler.getMemberList().get(i).getEmail() + "\nPhone Number: " + filehandler.getMemberList().get(i).getPhoneNumber() + "\nId: " + filehandler.getMemberList().get(i).getId() + "Active or passive - True for active, false for passive: " + filehandler.getMemberList().get(i).getActive() + "\nArrrears: " + filehandler.getMemberList().get(i).getArrears());
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
      System.out.println("Trainers");
      for(int i = 0; i <= filehandler.getTrainerList().size() - 1; i++){
         System.out.println("Name: " + filehandler.getTrainerList().get(i).getName() + "\nEmail: " + filehandler.getTrainerList().get(i).getEmail() + "\nPhone: " + filehandler.getTrainerList().get(i).getPhone() + "\nId: " + filehandler.getTrainerList().get(i).getId());
      }
      System.out.println("1 = Create trainer\n2 = Delete trainer\n3 = Edit trainer\n4 = Back");
      int s = input.nextInt();
      if(s == 1){
         createTrainer(input, filehandler);
      }else if(s == 2){
         System.out.println("Give ID");
         int selectedID = input.nextInt();
         deleteTrainer(input, filehandler, selectedID);
      }else if(s == 3){
         //editTrainer(input, filehandler);
      }else if(s == 4){
         showData(input, filehandler);
      }
   }

   
   public static void showTournaments(Scanner input, FileHandler filehandler){
      System.out.println("==========Trainers==========");
      for(int i = 0; i <= filehandler.getTournamentList().size() - 1; i++){
         System.out.println("Date :" + filehandler.getTournamentList().get(i).getDate() + "\nSwim style: " + filehandler.getTournamentList().get(i).getSwimStyle() + "\nID: " + filehandler.getTournamentList().get(i).getId() + "\nPlacement: " + filehandler.getTournamentList().get(i).getPlacement() + "\nTime " + filehandler.getTournamentList().get(i).getTime());
      }
      System.out.println("1 = Create tournament\n2 = Delete tournament\n3 = Edit tournament\n4 = Back");
      int s = input.nextInt();
      if(s == 1){
         createNewTournament(input, filehandler);       
      }else if(s == 2){
         System.out.println("Enter ID of the tournament that you want to delete");
         int selectedId = input.nextInt();
         deleteTournament(filehandler, input, selectedId);
      }else if(s == 3){
         //editTournament(input, filehandler);
      }else if(s == 4){
         showData(input, filehandler);
      }
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
         filehandler.getMemberList().add(compSwimmer);
      } else if(swimmer == 1){
        normalSwimmer = new Member(firstName, lastName, age, email, phoneNumber, getFreeMemberID(filehandler), active);
         filehandler.getMemberList().add(normalSwimmer);
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
         System.out.println("The customer got " + newPrice + " left to pay");
         normalSwimmer.setArrears(newPrice);
      }
      
      if(swimmer == 2){
         filehandler.getMemberList().add(compSwimmer);
      }else if(swimmer == 1){
         filehandler.getMemberList().add(normalSwimmer);
      }
      showMembers(input, filehandler);
  }
  
  public static int calculateArrears(int price, int amountPaid){
      System.out.println("Price: " + price + " Amount Paid: " + amountPaid);
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
      filehandler.getTrainerList().add(newTrainer);
      showTrainers(input, filehandler);
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
      filehandler.getTournamentList().add(t1);
   }
    
   public static int getFreeMemberID(FileHandler filehandler){
      ArrayList<Integer> usedIds = new ArrayList<>();
      
      int index = 0;
      for (Member currentMember : filehandler.getMemberList()){
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
         for (Trainer currentTrainer : filehandler.getTrainerList()){
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
      for (Tournament currentTournament : filehandler.getTournamentList()){
         usedIds.add(currentTournament.getId());
      }
      
      int givenID = 1;
      
      if(usedIds.size() >= 1){
         givenID = Collections.max(usedIds) + 1;
      }
      return givenID;
   }
   public static void editTournament(Scanner input, FileHandler filehandler, int selectedId)   {
      Tournament tempTour = new Tournament();
      int indexNumber = 0;
      for(int i = 0; i <= filehandler.getTournamentList().size() - 1; i++){
         if(filehandler.getTournamentList().get(i).getId() == selectedId)  {
            tempTour = filehandler.getTournamentList().get(i);
            indexNumber = i;
         }
      }
         System.out.println("Change the date from: " + tempTour.getDate() + " to: ");
         String newDate = input.next();
         if(!newDate.equalsIgnoreCase("0"))  {
            tempTour.setDate(newDate);
         }
         System.out.println("Change the swim style from: " + tempTour.getSwimStyle() + " to: ");
         String newStyle = input.next();
         if(!newStyle.equalsIgnoreCase("0"))  {
            tempTour.setSwimStyle(newStyle);
         }
         System.out.println("Change the placement from: " + tempTour.getPlacement() + " to: ");
         int newPlacement = input.nextInt();
         if(newPlacement != 0){
            tempTour.setPlacement(newPlacement);
         }
         System.out.println("Change the time from: " + tempTour.getTime() + " to: ");
         String newTime = input.next();
         if(!newTime.equalsIgnoreCase("0")){
            tempTour.setTime(newTime);
         }
         System.out.println("Would you confirm these changes: " + tempTour + "\nPress 'Y' for yes \nPress 'N' to remake the edit \nPress 'B' to get back to the main menu");
         String answer = input.next();
         if(answer.equalsIgnoreCase("y")){
            filehandler.getTournamentList().set(indexNumber, tempTour);
            System.out.println("Edited firm: \n" + filehandler.getTournamentList().get(indexNumber));
         }else if(answer.equalsIgnoreCase("n"))  {
            editTournament(input, filehandler, selectedId);
         }else{
            System.out.println("Returning to main menu...");
            mainMenu(input, filehandler);
         }
   }
   
   public static void saveData(Scanner input, FileHandler filehandler){
     try{
         filehandler.printMemberToFile();
         filehandler.printTrainerToFile();
         filehandler.printTournamentToFile();
         mainMenu(input, filehandler);
     }catch (FileNotFoundException e){
         e.printStackTrace();
     }
   }
   public static void deleteMember(Scanner input, FileHandler filehandler, int selectedID){
      int index = 0;
      for (Member selectedMember : filehandler.getMemberList()){
         if(selectedID == selectedMember.getId()){
            System.out.println("You sure you want to delete: " + selectedMember.getFirstName() + " (True/False)");
            Boolean confirmDeletion = input.nextBoolean();
            if(confirmDeletion == true){
               filehandler.getMemberList().remove(index);
            }
            break;
         }
         index++;
      }
      showMembers(input, filehandler);
    }
    public static void deleteTournament(FileHandler filehandler, Scanner input, int selectedId){
      for(int i = 0; i <= filehandler.getTournamentList().size() - 1; i++){
         if(filehandler.getTournamentList().get(i).getId() == selectedId){
            System.out.println("Are you sure you want to delete: " + filehandler.getTournamentList().get(i).getId() + "\nAnswer with Y/N");
            String answer = input.next();
            if (answer.equalsIgnoreCase("y")){
               System.out.println("Successfully deleted: " + filehandler.getTournamentList().get(i).getId());
               filehandler.getTournamentList().remove(i);  
            }else{
  //             showTournament(filehandler, input);
            }
         }
      }
   }
   public static void editTrainer(Scanner input, FileHandler filehandler, int selectedId){
      Trainer tempTrainer = new Trainer();
      int number = 0;

      for(int i = 0; i <= filehandler.getTrainerList().size() - 1; i++){
         if(filehandler.getTrainerList().get(i).getId() == selectedId){
         tempTrainer = filehandler.getTrainerList().get(i);
         number = i;

         }
         System.out.println("Change name from: " + tempTrainer.getName() + "to: ");
         String newName = input.next();
         if(!newName.equalsIgnoreCase("0")){
            tempTrainer.setName(newName);
         }

      }
      System.out.println("Change email from: " + tempTrainer.getEmail() + "to: "); 
      String newEmail = input.next();
      if(!newEmail.equalsIgnoreCase("0")){
         tempTrainer.setEmail(newEmail);
      }
      System.out.println("Change phone from: " + tempTrainer.getPhone() + "to: ");
      int newPhone = input.nextInt();
      if(newPhone != 0){
         tempTrainer.setPhone(newPhone);
      }
   }
   public static void deleteTrainer(Scanner input, FileHandler filehandler, int selectedID){
      int index = 0;
      for (Trainer selectedTrainer : filehandler.getTrainerList()){
         if(selectedID == selectedTrainer.getId()){
            System.out.println("You sure you want to delete: " + selectedTrainer.getName() + " (True/False)");
            Boolean confirmDeletion = input.nextBoolean();
            if(confirmDeletion == true){
               filehandler.getTrainerList().remove(index);
            }
            break;
         }
         index++;
      }
      showTrainers(input, filehandler);
    }
}