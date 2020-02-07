
import java.text.DecimalFormat;
 
public class Client {
   private int age = 0;
   private char gender;
   private String emailAddress = "";
   private String engineerType = "";
   private boolean lowIncome;
   private boolean firstGenCollege;
   private boolean highSchoolGrad;
   private String egg = "";
   private int povertyLine = 30000;
   private int income = 0;
   private static int numberOfClients = 0;
   
   
   public Client(int ageIn, String genderIn, String emailIn, 
               String majorIn, int incomeIn,
               String firstGen, String highSchool) {
      
      //use setters
      setAge(ageIn);
      setGender(genderIn);
      
      setEmail(emailIn);
      setEngineer(majorIn);
      setIncomeLevel(incomeIn);
      setCollegeStat(firstGen);
      setHighSchool(highSchool);
      numberOfClients++;
      
      
   }
   

   
   public boolean setAge(int ageIn) {
      boolean isAgeSet = false;
      if (ageIn > 0) {
         age = ageIn;
         isAgeSet = true;   
      }
      return isAgeSet;
   }
   
   
   public int getAge() {
      return age;
   }
   
   
   public boolean setGender(String genderIn) {
      boolean isGenderValid = false;
      
      if (genderIn == "W") {
         isGenderValid = true;
      }
      
      else if (genderIn == "M") {
         isGenderValid = true;
      }
      
      else {
         egg = "Data for other gender identies has yet to be collected." 
               + "\nWe thank you for your patience while we do more research.";   
      }
      
      return isGenderValid;
   }
   
   public char getGender() {
   
      return gender;
   }
   
   public boolean setEmail(String emailIn) {
      boolean isEmailValid = false;
      
      if (emailIn.contains("@") && emailIn.contains(".")) {
         isEmailValid = true;
      }
      
      return isEmailValid;
   } 
   
   
   public String getEmail() {
      return emailAddress;
   }
   
   public boolean setEngineer(String majorIn) {
      boolean isMajorSet = false;
      
      if (majorIn != null) {
         engineerType = majorIn;
         isMajorSet = true;
      }  
      
      return isMajorSet; 
   }
   
   public String getEngineer() {
      return engineerType;
   }
   
   public boolean setIncomeLevel(int incomeIn) {
      boolean lowIncome = false;
      if (incomeIn > 0) {
         income = incomeIn;
         
         if (income < povertyLine) {
            lowIncome = true;
         }
     } 
      return lowIncome;
   }
   
   public String isLowIncome() {
         if (income < povertyLine) {
            return "Low Income";
         }      
         
         else {
            return "Not Low Income";
         }
   }
   
   public double getIncome() {
      return income;
   }
   
   public boolean setCollegeStat(String answer) {
      if (answer.equalsIgnoreCase("Y")) {
         firstGenCollege = true;      
      }
      
      else {
         firstGenCollege = false;
      }
      
      return firstGenCollege;
   }
   
   public String isFirstGen() {
      if (setCollegeStat("Y")) {
         return "yes";
         
      }
      
      else {
         return "no";
      }
   }
   
    
   
   public boolean setHighSchool(String answer) {
      if (answer.equalsIgnoreCase("Y")) {
         highSchoolGrad = true;      
      }
      
      else {
         highSchoolGrad = false;
      }   
      return highSchoolGrad;
   }  
   
   public String hs() {
      if (setHighSchool("Y")) {
         return "yes";
      }
      else {
         return "no";
      }
   } 
   
   public static int getCount () {
      return numberOfClients;
   }
 /**  
   public String toString() {
      DecimalFormat df = new DecimalFormat("$#,##0.00#");
      String output = "About Client:" 
         + "\nAge: " + getAge() 
         + "\nGender: " + getGender()
         + "\nEmail Address: " + getEmail()
         + "\nIncome: " + isLowIncome()
         + "\nFirst Generation College Student? " + isFirstGen()
         + "\nGraduated High School? " + hs();
         
      return output;
   }
   */
   



   
}