import java.lang.Math;

public class Calculations {

   String count;
   
   public Calculations(String count) {
      this.count = equals(count);
   }
  
   public String equals(String subCount) {
      
      //PEMDAS
      if (subCount.contains("(") || subCount.contains(")")) {
         subCount = parentheses(subCount);
      }
      if (subCount.contains("^")) {
         subCount = exponents(subCount);
      } 
      if (subCount.contains("*") || subCount.contains("/")) {
         subCount = multiplicationAndDivision(subCount);
      }
      if (subCount.contains("+") || subCount.contains("-")) {
         subCount = additionAndSubtraction(subCount);   
      } 
      
      if ((double)(int)Double.parseDouble(subCount) == Double.parseDouble(subCount)) {
         subCount = (int)Double.parseDouble(subCount) + "";
      }
      
      return subCount;
   }
      
   public String parentheses(String subCount) {
      String parenthCount = "";
      int last = 0;
      int previous = -1;
      for (int i = 0; i < subCount.indexOf(")"); i++) {
         if (subCount.charAt(i) == '(') {
            last = i;
         }
      }
      parenthCount = subCount.substring(last + 2, subCount.indexOf(")")); 
      subCount = subCount.replace("( " + subCount.substring(last + 2, subCount.indexOf(")")) + ") " , equals(parenthCount));
      return equals(subCount);
   }
   
   public String exponents(String subCount) {
      String[] s1 = subCount.split(" ");
      double sum = 0;
      for (int i = 0; i < s1.length; i++) {
         if (s1[i].contains("^")) {
            sum = Math.pow(Double.parseDouble(s1[i-1]), Double.parseDouble(s1[i+1]));
            subCount = subCount.replace(s1[i-1] + "^" + s1[i+1], sum + "");
            s1 = subCount.split(" ");
            i --;
         }
      }
      return subCount; 
   }

   public String multiplicationAndDivision(String subCount) {
      String[] s1 = subCount.split(" ");
      double sum = 0;
      for (int i = 0; i < s1.length; i++) {
         if (s1[i].contains("*")) {
            sum = Double.parseDouble(s1[i-1]) * Double.parseDouble(s1[i+1]);
            subCount = subCount.replace(s1[i-1] + " * " + s1[i+1], sum + "");
            s1 = subCount.split(" ");
            i --;
         }
         if (s1[i].contains("/")) {
            sum = Double.parseDouble(s1[i-1]) / Double.parseDouble(s1[i+1]);
            subCount = subCount.replace(s1[i-1] + " / " + s1[i+1], sum + "");
            s1 = subCount.split(" ");
            i--;
         }   
      }
      return subCount; 
   }


   public String additionAndSubtraction(String subCount) {
      String[] s1 = subCount.split(" ");
      double sum = 0;
      for (int i = 0; i < s1.length; i++) {
         if (s1[i].contains("+"))  {
            sum = Double.parseDouble(s1[i-1]) + Double.parseDouble(s1[i+1]);
            subCount = subCount.replace(s1[i-1] + " + " + s1[i+1], sum + "");
            s1 = subCount.split(" ");
            i--;
         } 
         if (s1[i].contains("-")) {
            sum = Double.parseDouble(s1[i-1]) - Double.parseDouble(s1[i+1]);
            subCount = subCount.replace(s1[i-1] + " - " + s1[i+1], sum + "");
            s1 = subCount.split(" ");
            i--;
         }   
      }
      return subCount; 
   }
}
         
         
         
         
           /* if (count.contains(" ( ") || count.contains(" ) ")) {
            for (int i = 0; i < count.length(); i++) {
               if (count.charAt(i) == ')' || count.charAt(i) == '(') {
                  containsParenth++;
               }
            }
            System.out.println(containsParenth);
            startingPlace = count.indexOf("(");
            endingPlace = count.indexOf(")");
            for (int i = 0; i < containsParenth/2; i++) {
               String parenthesesString = count.substring(startingPlace + 2, endingPlace);
               while (parenthesesString.contains("(")) {
                  startingPlace = parenthesesString.indexOf("(");
                  inParentheses = equals(count.substring(startingPlace + 2, endingPlace));
                  System.out.println(inParentheses);
                  count = count.substring(0, startingPlace - 1) + " " + inParentheses + " " + count.substring(endingPlace + 2);
                     // if ( is found, change the index of that to the startingPlace, calculate, then put the result back into the String
               }
               // 5 + ( 2 - ( 5 - 4 ) - ( 3 + 3) )
               // SCRAP ALL, MAKE PEMDAS FUNCTION FIRST
               // GO WITH ORIG IDEA OF 
               // IF STRING CONTAINS (, ADD TO CONTAINSRIGHTPAR, FIND indexOf("(", CONTAINSRIGHTPAR)
               // MAKE NEW METHOD FOR PARENTHASES0
               System.out.println(startingPlace);
               System.out.println(endingPlace);
               System.out.println(count.substring(startingPlace + 2, endingPlace));
               inParentheses = equals(count.substring(startingPlace + 2, endingPlace));
               count = count.substring(0, startingPlace - 1) + " " + inParentheses + " " + count.substring(endingPlace + 2);
               System.out.println(count);
                  
            }
         } 
         
         String[] s = count.split(" ", -2); // Count, split into an array of Strings
                                         // split based on whitespace
         // PEMDAS
         if (count.contains("[()]+")) {
            parentheses();          
                                         
                                         
                                         
                                         
                                         
                                         
                                         
                                         
                                         
                                         
                                         
                                         
      
         double finalCount = Double.parseDouble(s[0]);
         for (int i = 1; i <= s.length - 1; i++) {
            switch (s[i]) {
               case "*": i++; finalCount = finalCount*Double.parseDouble(s[i]);
                  break;
               case "/": i++; finalCount = finalCount/Double.parseDouble(s[i]);
                  break;
               case "+": i++; finalCount += Double.parseDouble(s[i]);
                  break;
               case "-": i++; finalCount -= Double.parseDouble(s[i]);
                  break;
               case "^": i++; finalCount = Math.pow(finalCount, Double.parseDouble(s[i]));
                  break;
            }  
         }
         if ((double)(int)finalCount == finalCount) {
            return (int)finalCount + "";
         }
         else { 
            return finalCount + "";
         } 
      }
      }
      */
