import java.util.*;
import java.io.*;

public class Delfinen   {
   public static void main(String[] args) throws FileNotFoundException{
      Scanner scan = new Scanner(System.in);
      
      FileHandler filehandler = new FileHandler();
      
      createNewMember(scan, filehandler);
      
      //filehandler.printMemberToFile();
      //filehandler.printMemberFromFile();
      
      filehandler.printTrainerToFile();
      filehandler.printTrainerFromFile();
      
      //System.out.println(filehandler.memberList);
      System.out.println(filehandler.trainerList);
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
         CompetetiveSwimmer swimmer2 = new CompetetiveSwimmer(firstName, lastName, age, email, phoneNumber, 1, memberType, active, swimStyle, records);
         filehandler.memberList.add(swimmer2);
      } else if(swimmer == 1){
         Member swimmerMotionist = new Member(firstName, lastName, age, email, phoneNumber, 1, memberType, active);
         filehandler.memberList.add(swimmerMotionist);
      }
   }
}