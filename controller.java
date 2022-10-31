public class controller {
   public static void main(String []args) {
      GUI GUI = new GUI();
      Calculations Calculator = new Calculations(GUI.count);
      GUI.count = Calculator.count;
   }
}