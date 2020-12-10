import java.util.*;
import java.io.*;
import java.text.DecimalFormat;
import java.lang.Math;

public class Delfinen   {
   public static void main(String[] args) throws FileNotFoundException, IOException{
      Scanner input = new Scanner(System.in);
      input.useLocale(Locale.US);
      
      FileHandler filehandler = new FileHandler();
      //showMembers(input, filehandler);
      
      filehandler.createFile();
      //createNewMember(input, filehandler);
      //createTrainer(input, filehandler);
      //createNewTournament(input, filehandler);
      
      //filehandler.printMemberToFile();
      filehandler.printMemberFromFile();
      
      //filehandler.printTrainerToFile();
      filehandler.printTrainerFromFile();
     
      
      //filehandler.printTournamentToFile();
      filehandler.printTournamentFromFile();
      
      //System.out.println(filehandler.memberList);
      //System.out.println(filehandler.trainerList);
      //System.out.println(filehandler.tournamentList);
      
      mainMenu(input, filehandler);
   }
   
   public static void mainMenu(Scanner input, FileHandler filehandler){
      System.out.println("=====Main menu=====\n1 = Showdata\n2 = Savedata\n3 = Quit");
      String s = input.next();
      if(s.equalsIgnoreCase("1")){
         showData(input, filehandler);
      }else if(s.equalsIgnoreCase("2")){
        saveData(input, filehandler);
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
      ArrayList<Member>swimmerList = new ArrayList<>();
      ArrayList<CompetetiveSwimmer>competitiveSwimmerList = new ArrayList<>();
      System.out.println("==========Members==========");
      for(int i = 0; i <= filehandler.getMemberList().size() - 1; i++){
         if(filehandler.getMemberList().get(i).getClass().getName() == "CompetetiveSwimmer"){
           competitiveSwimmerList.add((CompetetiveSwimmer)filehandler.getMemberList().get(i));
         }else{
           swimmerList.add(filehandler.getMemberList().get(i));
         }
      }
      if(competitiveSwimmerList.size() != 0){
         System.out.println("Competitive Swimmer");
         for(int i = 0; i <= competitiveSwimmerList.size() - 1; i++){
            System.out.println("First name: " + competitiveSwimmerList.get(i).getFirstName() + "\nLast name: " + competitiveSwimmerList.get(i).getLastName() + "\nAge: " + competitiveSwimmerList.get(i).getAge() + "\nEmail: " + competitiveSwimmerList.get(i).getEmail() + "\nPhone number: " + competitiveSwimmerList.get(i).getPhoneNumber() + "\nId: " + competitiveSwimmerList.get(i).getId() + "\nActive: " + competitiveSwimmerList.get(i).getActive() + "\nArrears: " + competitiveSwimmerList.get(i).getArrears() + "\nSwim style: " + competitiveSwimmerList.get(i).getSwimStyle() + "\nTrainer Id: " + competitiveSwimmerList.get(i).getTrainerId() + "\n===================");
         }
      }
      if(swimmerList.size() != 0){
         System.out.println("Swimmer");
         for(int i = 0; i <= swimmerList.size() - 1; i++){
            System.out.println("First name: " + swimmerList.get(i).getFirstName() + "\nLast name: " + swimmerList.get(i).getLastName() + "\nAge: " + swimmerList.get(i).getAge() + "\nEmail: " + swimmerList.get(i).getEmail() + "\nPhone number: " + swimmerList.get(i).getPhoneNumber() + "\nId: " + swimmerList.get(i).getId() + "\nActive: " + swimmerList.get(i).getActive() + "\nArrears: " + swimmerList.get(i).getArrears() + "\n===================");
         }
      }  
      System.out.println("1 = Create member\n2 = Delete member\n3 = Edit member \n4 = Show Arrears\n5 = Back");
      int s = input.nextInt();
      if(s == 1){
         createNewMember(input, filehandler);  
         showMembers(input, filehandler);     
      }else if(s == 2){
         System.out.println("Give the Id of the member you want to delete:");
         int selectedId = input.nextInt();
         deleteMember(input, filehandler, selectedId);
         showMembers(input, filehandler);  
      }else if(s == 3){
         System.out.println("Give the Id of the member you want to edit:");
         int selectedId = input.nextInt();
         //editMember(input, filehandler, selectedId);
         showMembers(input, filehandler);  
      }else if(s == 5){
         showData(input, filehandler);
      }else if(s == 4){
         showArrears(input, filehandler);
         mainMenu(input, filehandler);
      }
   }
   
public static void showTrainers(Scanner input, FileHandler filehandler){
      System.out.println("==========Trainers==========");
      for(int i = 0; i <= filehandler.getTrainerList().size() - 1; i++){
         System.out.println("Name: " + filehandler.getTrainerList().get(i).getName() + "\nEmail: " + filehandler.getTrainerList().get(i).getEmail() + "\nPhone: " + filehandler.getTrainerList().get(i).getPhone() + "\nId: " + filehandler.getTrainerList().get(i).getId() + "\n====================");
      }
      System.out.println("1 = Create trainer\n2 = Delete trainer\n3 = Edit trainer\n4 = Back");
      int s = input.nextInt();
      if(s == 1){
         createTrainer(input, filehandler);
         showTrainers(input, filehandler);
      }else if(s == 2){
         System.out.println("Give the Id of the trainer you want to delete: ");
         int selectedId = input.nextInt();
         deleteTrainer(input, filehandler, selectedId);
         showTrainers(input, filehandler);
      }else if(s == 3){
         System.out.println("Give the Id of the trainer you want to edit:");
         int selectedId = input.nextInt();
         editTrainer(input, filehandler, selectedId);
         showTrainers(input, filehandler);
      }else if(s == 4){
         showData(input, filehandler);
      }
   }

   
   public static void showTournaments(Scanner input, FileHandler filehandler){
      System.out.println("==========Tournaments==========");
      for(int i = 0; i <= filehandler.getTournamentList().size() - 1; i++){
         System.out.println("Date :" + filehandler.getTournamentList().get(i).getDate() + "\nSwim style: " + filehandler.getTournamentList().get(i).getSwimStyle() + "\nID: " + filehandler.getTournamentList().get(i).getId() + "\nPlacement: " + filehandler.getTournamentList().get(i).getPlacement() + "\nTime " + filehandler.getTournamentList().get(i).getTime() + "\n====================");
      }
      System.out.println("1 = Create tournament\n2 = Delete tournament\n3 = Edit tournament\n4 = Back");
      int s = input.nextInt();
      if(s == 1){
         createNewTournament(input, filehandler); 
         showTournaments(input, filehandler);      
      }else if(s == 2){
         System.out.println("Enter the ID of the tournament that you want to delete");
         int selectedId = input.nextInt();
         deleteTournament(input, filehandler, selectedId);
         showTournaments(input, filehandler); 
      }else if(s == 3){
          System.out.println("Enter the ID of the tournament that you want to edit");
          int selectedId = input.nextInt();
          editTournament(input, filehandler, selectedId);
          showTournaments(input, filehandler); 
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
      int arrears = 0;
      String swimStyle;
      if(swimmer == 2){
         System.out.println("Enter swim style: ");
         swimStyle = input.next();
         int trainerId = -1;
         if(filehandler.getTrainerList().size() != 0){
            System.out.println(filehandler.getTrainerList());
            System.out.println("Enter the id of the trainer, that you want to be affiliated with the competitive swimmer: ");
            trainerId = input.nextInt();
         }   
         compSwimmer = new CompetetiveSwimmer(firstName, lastName, age, email, phoneNumber, getFreeMemberID(filehandler), active, arrears, swimStyle, trainerId);
      } else if(swimmer == 1){
        normalSwimmer = new Member(firstName, lastName, age, email, phoneNumber, getFreeMemberID(filehandler), active, arrears);
      }
     
      int priceToPay = 0;
      if(active == true){
        if(swimmer == 1)   { 
            if(normalSwimmer.getAgeGroup() == "junior"){
               priceToPay = 1000;
            }else if(normalSwimmer.getAgeGroup() == "senior"){
               priceToPay = 1600;
            }else if(normalSwimmer.getAgeGroup() == "pensioner"){
               priceToPay = 1200;
            }
         }else if(swimmer == 2){
            if(compSwimmer.getAgeGroup() == "junior"){
               priceToPay = 1000;
            }else if(compSwimmer.getAgeGroup() == "senior"){
               priceToPay = 1600;
            }else if(compSwimmer.getAgeGroup() == "pensioner"){
               priceToPay = 1200;
            }
         }   
         }else{
            priceToPay = 500;
         }
      
      System.out.println("The price is: " + priceToPay);
      System.out.println("Enter amount paid: ");
      int amountPaid = input.nextInt();
      
      int newPrice = calculateArrears(priceToPay, amountPaid);
      
      if(newPrice <= 0){
         System.out.println("The customer should get " + Math.abs(newPrice) + " back");
          normalSwimmer.setArrears(0);
          compSwimmer.setArrears(0);
      }else{
         System.out.println("The customer got " + newPrice + " left to pay");
         normalSwimmer.setArrears(newPrice);
         compSwimmer.setArrears(newPrice);
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
      
      Trainer newTrainer = new Trainer(name, email, phone, getFreeTrainerID(filehandler));
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
      Tournament t1 = new Tournament(date, swimStyle, getFreeTournamentID(filehandler), placement, time);
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
            System.out.println("Edited tournament: \n" + filehandler.getTournamentList().get(indexNumber));
         }else if(answer.equalsIgnoreCase("n"))  {
            editTournament(input, filehandler, selectedId);
         }else{
            System.out.println("Returning to main menu...");
            mainMenu(input, filehandler);
         }
   }
   
       public static void editMember(Scanner input, FileHandler filehandler, int selectedId){
      Member tempMember = new Member();
      int index = 0;
      
      for (Member currentMember : filehandler.getMemberList()){
         if(currentMember.getId() == selectedId){
            tempMember = currentMember;
            break;
         }
         index++;
      }
      
      int menuChoice = 0;
      if(tempMember.getClass().getName() == "CompetetiveSwimmer"){
         System.out.print("What would you like to do with: " + tempMember.getFirstName() + "\n1 Edit information | 2 Edit Tournaments");
         if(tempMember.getArrears() > 0){
            System.out.print(" | 3 Edit Arrears");
         }
         System.out.println();
         menuChoice = input.nextInt();
      }else{
         System.out.print("What would you like to do with: " + tempMember.getFirstName() + "\n1 Edit information");
         if(tempMember.getArrears() > 0){
            System.out.print(" | 3 Edit Arrears");
         }
         System.out.println();
         menuChoice = input.nextInt();
      }
      
      if(menuChoice == 2 && tempMember.getClass().getName() == "CompetetiveSwimmer"){
          CompetetiveSwimmer tempCompetitiveSwimmer;
          tempCompetitiveSwimmer = (CompetetiveSwimmer)tempMember;
         if(tempCompetitiveSwimmer.getListOfTournaments().size() > 0){
            for (int memberTournamentId : tempCompetitiveSwimmer.getListOfTournaments()){
               for (Tournament currentTournament : filehandler.getTournamentList()){
                  if(memberTournamentId == currentTournament.getId()){
                      System.out.println(currentTournament + "\n======");
                  }
               }
            }
         }else{
            System.out.println("This swimmer got no tournaments");
         }

         System.out.println("1: Add new tournament | 2: Delete tournament from swimmer | 3: Back");
         int tournamentChoice = input.nextInt();
         if(tournamentChoice == 1){
             if(filehandler.getTournamentList().size() == 0){
                 System.out.println("There's not tournament available");
             }else{
                 for (Tournament currentTournament : filehandler.getTournamentList()){
                     System.out.println(currentTournament + "\n======");
                 }
             }
             System.out.println("Select tournament to add it to the swimmer");
             int selectedTournamentID = input.nextInt();
             tempCompetitiveSwimmer.getListOfTournaments().add(selectedTournamentID);
             filehandler.getMemberList().set(index, tempCompetitiveSwimmer);
             editMember(input,filehandler, selectedId);
         }else if (tournamentChoice == 2){
             for (int memberTournamentId : tempCompetitiveSwimmer.getListOfTournaments()){
                 for (Tournament currentTournament : filehandler.getTournamentList()){
                     if(memberTournamentId == currentTournament.getId()){
                         System.out.println(currentTournament + "\n======");
                     }
                 }
             }
             System.out.println("Type id to delete");
             int selectedTournamentId = input.nextInt();
             for(int i = 0; i <= tempCompetitiveSwimmer.getListOfTournaments().size() -1; i++){
                 if(tempCompetitiveSwimmer.getListOfTournaments().get(i) == selectedTournamentId){
                     tempCompetitiveSwimmer.getListOfTournaments().remove(i);
                 }
             }
             editMember(input,filehandler, selectedId);
         }else{
             editMember(input,filehandler, selectedId);
         }
      }
      
      if(menuChoice == 1){
         System.out.println("Change firstname from: " + tempMember.getFirstName());
         String newFirstName = input.next();
         if(!newFirstName.equalsIgnoreCase("0")){
            tempMember.setFirstName(newFirstName);
         }
         
         System.out.println("Change lastname from: " + tempMember.getLastName());
         String newLastName = input.next();
         if(!newLastName.equalsIgnoreCase("0")){
            tempMember.setLastName(newLastName);
         }
             
         System.out.println("Change age from: " + tempMember.getAge());
         int newAge = input.nextInt();
         if(newAge != 0){
            tempMember.setAge(newAge);
         }
         
         System.out.println("Change email from: " + tempMember.getEmail());
         String newEmail = input.next();
         if(!newEmail.equalsIgnoreCase("0")){
            tempMember.setEmail(newEmail);
         }
         
         System.out.println("Change phonenumber from: " + tempMember.getPhoneNumber());
         int newPhoneNumber = input.nextInt();
         if(newPhoneNumber != 0){
            tempMember.setPhoneNumber(newPhoneNumber);
         }
         
         System.out.println("Change activity status from: " + tempMember.getActive());
         boolean newActiveStatus = input.nextBoolean();
         tempMember.setActive(newActiveStatus);

         if(tempMember.getClass().getName() == "CompetetiveSwimmer"){
             CompetetiveSwimmer tempCompetitiveSwimmer;
             tempCompetitiveSwimmer = (CompetetiveSwimmer)tempMember;

            System.out.println("Change preferable Swim style from: " + tempCompetitiveSwimmer.getSwimStyle());
            String newSwimStyle = input.next();
            if(!newSwimStyle.equalsIgnoreCase("0")){
                tempCompetitiveSwimmer.setSwimStyle(newSwimStyle);
            }
            
            for (Trainer currentTrainer : filehandler.getTrainerList()){
               System.out.println(currentTrainer);
            }
            System.out.println("Change trainer ID from: " + tempCompetitiveSwimmer.getTrainerId());
            int newTrainerId = input.nextInt();
             tempCompetitiveSwimmer.setTrainerId(newTrainerId);
         }

         
         System.out.println("The changes looks like this: \n" + tempMember + "\nWould you like to save these changes? (1 = true / 2 = false)");
         int answer = input.nextInt();
         if(answer == 1){
            filehandler.getMemberList().set(index, tempMember);
            showMembers(input, filehandler);
         }else{
            showMembers(input, filehandler);
         }
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
   public static void deleteMember(Scanner input, FileHandler filehandler, int selectedId){
      int index = 0;
      for (Member selectedMember : filehandler.getMemberList()){
         if(selectedId == selectedMember.getId()){
            System.out.println("You sure you want to delete: " + selectedMember.getFirstName() + " (True/False)");
            Boolean confirmDeletion = input.nextBoolean();
            if(selectedMember.getArrears() > 0)  {
               System.out.println("The member got " + selectedMember.getArrears() + " left to pay");
               System.out.println("Has the member paid the remaining arrears? yes/no");
               String ans = input.next();
            if(ans.equalsIgnoreCase("yes"))  {
               System.out.println("Perfect - deleting member ...");
            }else{
               System.out.println("Are you sure you want to delete the member. The member still got " + selectedMember.getArrears() + " left to pay - yes/no");
               String confirm = input.next();
               if(confirm.equalsIgnoreCase("No"))  {
                  showMembers(input, filehandler);
               }else if(confirm.equalsIgnoreCase("yes"))  {
                  confirmDeletion = true;
               }
            }   
            if(confirmDeletion == true){
               filehandler.getMemberList().remove(index);
               System.out.println("Member deleted");
            }   
            
            break;
         }
        } 
         index++;
      }
     
      showMembers(input, filehandler);
   } 
   public static void deleteTournament(Scanner input, FileHandler filehandler, int selectedId){
      int index = 0;
      for (Tournament selectedTournament : filehandler.getTournamentList()){
         if(selectedId == selectedTournament.getId()){
            System.out.println("You sure you want to delete: " + selectedTournament.getId() + " (True/False)");
            Boolean confirmDeletion = input.nextBoolean();
            if(confirmDeletion == true){
               filehandler.getTournamentList().remove(index);
            }
            break;
         }
         index++;
      }
      showTournaments(input, filehandler);
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
   public static void deleteTrainer(Scanner input, FileHandler filehandler, int selectedId){
      int index = 0;
      for (Trainer selectedTrainer : filehandler.getTrainerList()){
         if(selectedId == selectedTrainer.getId()){
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
   public static void showArrears(Scanner input, FileHandler filehandler){
      System.out.println("======Members with arrears======");
      for(int i = 0; i <= filehandler.getMemberList().size() - 1; i++) {
         if(filehandler.getMemberList().get(i).getArrears() > 0){
            System.out.println(filehandler.getMemberList().get(i));
            System.out.println("=======================");
         }
      }
      System.out.println();
   }
}