import java.util.ArrayList;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class ClientDriver {


   public static void main(String[] args)
               throws FileNotFoundException {
      ArrayList<String> array = new ArrayList<String>();
      ScholarshipSniff searchHistory = new ScholarshipSniff(array);
      String fileName = "";
      

      int age;
      String gender;
      String emailAddress;
      String engineerType;
      int income;
      String firstGenCollege;
      String highSchoolGrad;
           
      Scanner userInput = new Scanner(System.in);
      //client attributes declared below
      
      System.out.println("Welcome to the Scholarship Sniffer."
         + "\nThis app skims for things about you and finds "
         + "\nscholarships that you would not have thought"
         + "\nto apply for. Once it finds something, it"
         + "\nsends a link to the scholarship application"
         + "\ndirectly to your email.\n\n");
         
     System.out.print("Scholarship Sniffer System Menu"
         + "\nD - Enter Your Info"
         + "\nR - Read Search History"
         + "\nM - Check For Matches"
         + "\nL - List Search History"
         + "\nQ - Quit\n");
         
         char choice =  'Q'; 
         
         do {
            System.out.print("\nPress Key [D, R, M, or Q]:  ");
            
            choice = userInput.nextLine().toUpperCase().charAt(0);
            switch (choice) {
               case 'D': 
               
                  System.out.print("\tAge: ");
                  age = Integer.parseInt(userInput.nextLine());
                  System.out.print("\tGender: ");
                  gender = userInput.nextLine();
                  System.out.print("\tEmail Address: ");
                  emailAddress = userInput.nextLine();
                  System.out.print("\tDesired Major:  ");
                  engineerType = userInput.nextLine();
                  
                  System.out.print("\tIncome: ");
                  income = Integer.parseInt(userInput.nextLine());
                  System.out.print("\tFirst Generation College Student? Y/N: ");
                  firstGenCollege = userInput.nextLine();
   
                  System.out.print("\tGraduated High School?  Y/N: ");
                  highSchoolGrad = userInput.nextLine();
                  Client client = new Client(age, gender, emailAddress, engineerType, income, 
                                             firstGenCollege, highSchoolGrad);
                  System.out.print("***Client added***\n");                           
                  break;
               
               
            
               case 'R': 
                  System.out.println("\nProceeding gives ScholarshipSniff permission to" 
                      + "\naccess your search history.");
                  System.out.print("\n\tSearch History File Name: ");
                  fileName = userInput.nextLine();
               
                  searchHistory = searchHistory.readFile(fileName);
        
                  array = searchHistory.getAttributes();   
           
                  System.out.println("\tFile read in and search history assessed.");
                  break;
               case 'M':

                                   
                  if (searchHistory.isPossiblyBlackWoman(array)) {
                  
                     System.out.print("Our algorithm tells us that you are possibly"
                        + "\n a black female. Stay tuned for relevant scholarships.\n\n" );
                  }
                  if  (searchHistory.isPossiblyBlackMan(array)) {
                  
                     System.out.print("Our algorithm tells us that you are possibly"
                        + "\n a black male. Stay tuned for relevant scholarships.\n\n");
                  }
                  if (searchHistory.isPossiblyLowIncome(array)) {
                  
                     System.out.print("Our algorithm tells us that you are possibly"
                        + "\n low income. Stay tuned for relevant scholarships.\n\n");
                  }
                  if (searchHistory.isPossiblyFG(array)) {
                  
                     System.out.print("Our algorithm tells us that you are possibly"
                        + "\n a first generation college student." 
                        + "Stay tuned for relevant scholarships.\n\n");
                        
                  }
                  if (searchHistory.containsEngineering(array)) {
                  
                     System.out.print("Our algorithm tells us that you are possibly"
                        + "\n you have an interest in one or more engineering disciplines."
                   
                        + "\nStay tuned for relevant scholarships.\n\n");
                        
  
                  }
                  searchHistory.reset();
                  
                 if (searchHistory == null) {
                     System.out.print("Apologies. Our algorithm has yet to find a"
                        + "\nmatch. Check back again soon!\n");
                      
                  }
                  
                  break;
                  
                  
               case 'Q':
                  System.out.print("\nThank you for using ScholarshipSniff!");
                  break;
              
                  
               
               default:
                  System.out.println("\t*** invalid code ***");
              }  
               
           } while (choice != 'Q');
   
   }

}