/*
   -client provides age, engineering profession, 
   income and gender, first-gen stat, excon status 
   disability status
   
   -it ask for permission to read search engine data
   - create a dummy file with search terms
      black disabled man
      first gen college woman
      
      
   - if client search history contains a term,
   it determines the person's category then sends them 
   scholarship based on their category
   
   - 
   
   
   
   */
import java.util.ArrayList;
import java.text.DecimalFormat;
import java.io.FileNotFoundException;
import java.io.File;
import java.util.Scanner;
   
public class ScholarshipSniff {
   
   private ArrayList<String> attributes; 
   private ArrayList<String> reset = new ArrayList<String>();
   private ArrayList<String> blackMan = new ArrayList<String>();
   private int blackManPoints = 0;
   private ArrayList<String> blackWoman = new ArrayList<String>();
   private int blackWomanPoints = 0;
   private ArrayList<String> lowIncome = new ArrayList<String>();
   private int lowIncomePoints  = 0;
   private ArrayList<String> firstGenCollege = new ArrayList<String>();
   private int firstGenPoints = 0;
   private ArrayList<String> engineering = new ArrayList<String>();
   private int engineeringPoints = 0;
   private ArrayList<Client> clientArray = new ArrayList<Client>(); 

   
   public ScholarshipSniff(ArrayList<String> attIn) {
        
      attributes = attIn;
      addtoBlackMan();
      addtoBlackWoman();
      addtoLowIncome();
      addtoEngineering();
      addtoLowIncome();
   }
   
   public void addClient(Client clientIn) {

      clientArray.add(clientIn);
   }
   
   public void addtoBlackMan() {
      blackMan.add("jordans");
      blackMan.add("basketball");
      blackMan.add("black barbers near me");
      blackMan.add("kanye west");
      blackMan.add("dreadlocks");
   }
   
   public void addtoBlackWoman() {
      blackWoman.add("box braids");
      blackWoman.add("cantu shampoo");
      blackWoman.add("shea butter");
      blackWoman.add("beyonce");
   }
   
   public void addtoLowIncome() {
      lowIncome.add("wic application");
      lowIncome.add("food stamps");
      lowIncome.add("section 8 housing");
      lowIncome.add("ebt card lost");
      
      
   }
   
   public void addtoFGCollege() {
      firstGenCollege.add("how to apply for fafsa");
      firstGenCollege.add("uneducated mom");
      firstGenCollege.add("small town to big city college");
      firstGenCollege.add("can't relate to college peers");
      firstGenCollege.add("give parents a better life");                              
   }
   
   public void addtoEngineering() {
      engineering.add("software");
      engineering.add("mechanical");
      engineering.add("chemical");
      engineering.add("industrial");
      engineering.add("electrical");
      engineering.add("biomedical");
      engineering.add("civil");
   }
   
   public ScholarshipSniff readFile(String fileNameIn) 
                     throws FileNotFoundException {
      Scanner reader = new Scanner(new File(fileNameIn));
      //ArrayList<String> attList  = new ArrayList<String>();
      
      while (reader.hasNext()) {
         attributes.add(reader.nextLine());
               
      } 
      
      ScholarshipSniff clientAttributes = new ScholarshipSniff(attributes);
      
      return clientAttributes;
   }
   
   public int getTotalAttributes() {
      return attributes.size();
   }
   public ArrayList<String> getAttributes() {
      return attributes;
   }
   
   public boolean isPossiblyBlackWoman(ArrayList<String> attIn) {
      
      boolean isBW = false;

      for (int i = 0; i < blackWoman.size(); i++) {
          if(attIn.contains(blackWoman.get(1))) {
            blackWomanPoints++;
            
            blackManPoints = 0;

            break;
          }      
     }
      if (blackWomanPoints > 0) {
         isBW = true;
      }
      
      
      return isBW;
   }
     
 
  
   public boolean isPossiblyBlackMan(ArrayList<String> attIn) {
      boolean isBM = false;
 

      for (int i = 0; i < blackMan.size(); i++) {
          if(attIn.contains(blackMan.get(1)) || attIn.contains(blackMan.get(3))) {
            blackManPoints++;
            blackWomanPoints = 0;
            break;
          }      
     }
      if (blackManPoints > 0) {
         isBM = true;
         
      }
      
      
      return isBM;
   }      
      
      
      
      /*
    int index = 0;  
    for (String str : attIn) {
        if (str.contains(blackMan.get(index))) {
            blackManPoints++;
            
        }
        index++;
    }
    
    if (blackManPoints > 0) {
      isBM = true;
    }
    */
     /*
      for (int i = 0; i < lowIncome.size(); i++) {
         for (int j = i; j < attIn.size(); j++) {
            if (attIn.get(j).equalsIgnoreCase(lowIncome.get(i))) {
               blackManPoints++;
               break;
            }
         }
      }
      if (blackManPoints > 0) {
         isBM = true;
      }
      
      return isBM;
   }
   
   **/

   
   public boolean isPossiblyLowIncome(ArrayList<String> attIn) {
      boolean isLC = false;
      
      for (int i = 0; i < lowIncome.size(); i++) {
          if(attIn.contains(lowIncome.get(1)) || attIn.contains(lowIncome.get(2)) ||
             attIn.contains(lowIncome.get(3)) || attIn.contains(lowIncome.get(4))) {
            lowIncomePoints++;
            break;
          }      
     }
      if (lowIncomePoints > 0) {
         isLC = true;
      }
      
      
      return isLC;
   }         
      /**
    int index = 0;  
    for (String str : attIn) {
        if (str.toLowerCase().contains(lowIncome.get(index))) {
            lowIncomePoints++;
            
        }
        index++;
    }
    
    if (lowIncomePoints > 0) {
      isLC = true;
    }      
     
     
      for (int i = 0; i < lowIncome.size(); i++) {
         for (int j = i; j < attIn.size(); j++) {
            if (attIn.get(j).equalsIgnoreCase(lowIncome.get(i))) {
               lowIncomePoints++;
               break;
            }
         }
      }
      if (lowIncomePoints > 0) {
         isLC = true;
      }
      
      return isLC;
      */

   

   public boolean isPossiblyFG(ArrayList<String> attIn) {
      boolean isFG = false;
      for (int i = 0; i < firstGenCollege.size(); i++) {
          if(attIn.contains(firstGenCollege.get(0))) {
           firstGenPoints++;
            break;
            
          }      
     }
      if (firstGenPoints > 0) {
         isFG = true;
      }
      
      
      return isFG;
   }       
      
      /**
    int index = 0;  
    for (String str : attIn) {
        if (str.toLowerCase().contains(firstGenCollege.get(index))) {
            firstGenPoints++;
            
        }
        index++;
    }
    
    if (firstGenPoints > 0) {
      isFG = true;
    }      
      
        
         for (int i = 0; i < firstGenCollege.size(); i++) {
            for (int j = i; j < attIn.size(); j++) {
               if (attIn.get(j).equalsIgnoreCase(firstGenCollege.get(i))) {
                  firstGenPoints++;
                  break;
               }
            }
         }
         if (firstGenPoints > 0) {
            isFG = true;
         }
         
         return isFG;
         */
         
  
   
   public boolean containsEngineering(ArrayList<String> attIn) {
      boolean containsEngineering = false;
      
      for (int i = 0; i < engineering.size(); i++) {
          if(attIn.contains(engineering.get(1))) {
            engineeringPoints++;
            break;
          }      
     }
      if (engineeringPoints > 0) {
         containsEngineering = true;
      }
      
      
      return containsEngineering;
   }           
    /*
    int index = 0;  
       
       
    for (String str : attIn) {
        if (str.toLowerCase().contains(engineering.get(index))) {
            engineeringPoints++;
            
        }
        index++;
    }
    
    if (engineeringPoints > 0) {
      containsEngineering = true;
    }      
        
      

         for (int i = 0; i < engineering.size(); i++) {
            for (int j = i; j < attIn.size(); j++) {
               if (attIn.get(j).equalsIgnoreCase(engineering.get(i))) {
                  engineeringPoints++;
                  break;
               }
            }
         }
         if (engineeringPoints > 0) {
            containsEngineering = true;
         }
     
         return containsEngineering;
      */
   
   
   public void reset() {
      attributes = reset;
   }
   
 }

   

   