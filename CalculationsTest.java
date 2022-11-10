import java.lang.Math;
import java.util.*;


public class CalculationsTest {

   String count;
   
  public CalculationsTest(String count) {
      this.count = count;
      while (1 == 1) {
         try {
            this.count = Double.toString(Double.parseDouble(this.count));
            break;
         } 
         catch (NumberFormatException e) {
            this.count = equals(this.count);
            this.count = this.count.replaceAll("  ", " ");
         }
      }
      System.out.println(this.count);
   }
   
   public static void main(String []args) {
      new CalculationsTest("2 ^ 4");
   }
  
   public String equals(String subCount) {
      
      //PEMDAS
      if (subCount.contains("(") || subCount.contains(")")) {
         subCount = parentheses(subCount);
      }
      else if (subCount.contains("^")) {
         subCount = exponents(subCount);
      } 
      else if (subCount.contains("*") || subCount.contains("/")) {
         subCount = multiplicationAndDivision(subCount);
      }
      else if (subCount.contains("+") || subCount.contains("-")) {
         subCount = additionAndSubtraction(subCount);   
      } 
      try {
         if ((double)(int)Double.parseDouble(subCount) == Double.parseDouble(subCount)) {
            subCount = (int)Double.parseDouble(subCount) + "";
         } 
      }
      catch (NumberFormatException a) {
      }
      return subCount;
      
   }
     
   public String parentheses(String subCount) {
      int last = 0;
      for (int i = 0; i < subCount.indexOf(")"); i++) {
         if (subCount.charAt(i) == '(' ) {
            last = i;
         }
      }
      String parenth = subCount.substring(last + 1, subCount.indexOf(")"));
      subCount = subCount.replace( "(" + parenth + ")", equals(parenth) );
      return subCount;
   } 
      
   public String exponents(String subCount) {
      String[] s1 = subCount.split(" ");
      double sum = 0;
      for (int i = 0; i < s1.length; i++) {
         if (s1[i].contains("^")) {
            sum = Math.pow(Double.parseDouble(s1[i-1]), Double.parseDouble(s1[i+1]));
            subCount = subCount.replace(s1[i-1] + " ^ " + s1[i+1], sum + "");
            s1 = subCount.split(" ");
            i--;
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
            i--;
         }
         else if (s1[i].contains("/")) {
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
         if (s1[i].equals("+"))  {
            sum = Double.parseDouble(s1[i-1]) + Double.parseDouble(s1[i+1]);
            subCount = subCount.replace(s1[i-1] + " + " + s1[i+1], sum + "");
            s1 = subCount.split(" ");
            i--;
         } 
         else if (s1[i].equals("-")) {
            sum = Double.parseDouble(s1[i-1]) - Double.parseDouble(s1[i+1]);
            subCount = subCount.replace(s1[i-1] + " - " + s1[i+1], sum + "");
            s1 = subCount.split(" ");
            i--;
         }   
      }
      return subCount; 
   } 
}
