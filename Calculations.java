import java.lang.Math;

public class Calculations {

   String count;
   
   public Calculations(String count) {
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
   }
   
   public String equals(String subCount) {
      
      //PEMDAS
      if (subCount.contains("(") || subCount.contains(")")) {
         subCount = parentheses(subCount);
      }
      else if (subCount.contains("<sup>")) {
         subCount = exponents(subCount);
      } 
      else if (subCount.contains("*") || subCount.contains("/")) {
         subCount = multiplicationAndDivision(subCount);
      }
      else if (subCount.contains("+") || subCount.contains("-")) {
         subCount = additionAndSubtraction(subCount);   
      } 
      
      return subCount;
      
   }
     
   public String parentheses(String subCount) {
   subCount = subCount.replaceAll("  ", " ");
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
      subCount = subCount.replaceAll("  ", " ");
      String[] s1 = subCount.split(" ");
      double sum = 0;
      for (int i = 0; i < s1.length; i++) {
         if (s1[i].contains("<sup>")) {
            
            sum = Math.pow(Double.parseDouble(s1[i-1]), Double.parseDouble(s1[i+1]));
            subCount = subCount.replace(s1[i-1] + " <sup> " + s1[i+1] + " </sup> ", sum + "");
            s1 = subCount.split(" ");
            i--;
         }
      }
      return subCount; 
   }

   public String multiplicationAndDivision(String subCount) {
   subCount = subCount.replaceAll("  ", " ");
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
   subCount = subCount.replaceAll("  ", " ");
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
