import javax.swing.JFrame;
import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import java.awt.GridLayout;
import java.awt.BorderLayout;
import java.awt.event.*;
import javax.swing.ImageIcon;
import java.awt.Dimension;
import javax.swing.*;
import java.awt.Color;
import java.awt.Font;
import java.lang.Math;
import java.util.*;
import javax.swing.SwingUtilities;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.awt.font.TextAttribute;
import java.text.AttributedString;

public class GUI {

   private String count;
   private JLabel label;
   private JFrame frame;
   private JPanel buttonPanel, labelPanel;
   private JButton zero, one, two, three, four, five,
                   six, seven, eight, nine, decimal, 
                   multiply, divide, subtract, add, 
                   exponent, leftParenth, rightParenthesis,
                   leftParenthesis, equals, clear;
   
   public GUI() {
   
      count = "";
      frame = new JFrame();
      
      zero = new JButton("0");
      one = new JButton("1");
      two = new JButton("2");
      three = new JButton("3");
      four = new JButton("4");
      five = new JButton("5");
      six = new JButton("6");
      seven = new JButton("7");
      eight = new JButton("8");
      nine = new JButton("9");
      decimal = new JButton(".");
      multiply = new JButton("*");
      divide = new JButton("/");
      add = new JButton("+");
      subtract = new JButton("-");
      exponent = new JButton("^");
      leftParenthesis = new JButton("(");
      rightParenthesis = new JButton(")");
      equals = new JButton();
      clear = new JButton("C");
      
      label = new JLabel("= ", JLabel.LEFT);
      label.setPreferredSize(new Dimension(220, 15));
      label.setForeground(new Color(220,  209, 255));
      label.setBackground(new Color(120, 90, 40));
      label.setFont(new Font("Verdana", Font.PLAIN, 15));
      label.setVerticalAlignment(JLabel.BOTTOM);
   
      buttonPanel = new JPanel();
      labelPanel = new JPanel();
      buttonPanel.setBorder( BorderFactory.createEmptyBorder(10,10 , 10, 10) );
      labelPanel.setBorder( BorderFactory.createEmptyBorder(10,10 , 10, 10) );
      buttonPanel.setLayout( new GridLayout(6, 4) );
      buttonPanel.add(zero);
      buttonPanel.add(one);
      buttonPanel.add(two);
      buttonPanel.add(three);
      buttonPanel.add(four);
      buttonPanel.add(five);
      buttonPanel.add(six);
      buttonPanel.add(seven);
      buttonPanel.add(eight);
      buttonPanel.add(nine);
      buttonPanel.add(decimal);
      buttonPanel.add(multiply);
      buttonPanel.add(divide);
      buttonPanel.add(add);
      buttonPanel.add(subtract);
      buttonPanel.add(exponent);
      buttonPanel.add(leftParenthesis);
      buttonPanel.add(rightParenthesis);
      buttonPanel.add(equals);
      buttonPanel.add(clear);
      labelPanel.add(label);
   
      frame.add( buttonPanel, BorderLayout.CENTER );
      frame.add( labelPanel, BorderLayout.SOUTH);
      frame.setBackground(Color.GREEN);
      labelPanel.setBackground(Color.BLACK);
      buttonPanel.setBackground(Color.BLACK);
      frame.setDefaultCloseOperation( JFrame.EXIT_ON_CLOSE );
      frame.setTitle( "Calculator" );
      frame.pack();
      frame.setVisible(true);
      
      MouseListener hover = 
         new MouseAdapter() {
            public void mouseEntered(MouseEvent e) {
               equals.setIcon(new ImageIcon(getClass().getResource("EqualsLavender.png ")));
            }
            public void mouseExited(MouseEvent e) {
               equals.setIcon(new ImageIcon(getClass().getResource("Equals.png ")));
            }
         
         };
      
      ActionListener number = 
         new ActionListener() {
            public void actionPerformed(ActionEvent e) {
               identifyNumber(e);
               label.setText("= " + count );
            }
         };
      
      ActionListener operator = 
         new ActionListener() {
            public void actionPerformed(ActionEvent e) {
               try {
                  int index;
                  identifyOperator(e);
                  String html = count + "<html>";
                  count.replaceAll("  ", " ");
                  html.replaceAll("  ", " ");
                  while (html.contains("^")) {
                     index = html.indexOf("^");
                     html = html.replace(html.charAt(index - 2) + " ^ " + count.charAt(index + 2), count.charAt(index - 2) + "<sup>" + count.charAt(index + 2) + "</sup>");
                  }
                  label.setText("<html>= " + html );
               } 
               catch (NumberFormatException ae) {
                  label.setText("Invalid");
                  count = "";
               }
            }
         };
      ActionListener exponentAndLogarithm = 
         new ActionListener() {
            public void actionPerformed(ActionEvent e) {
               try {
                  count += " ^ ";
                  count.replaceAll("  ", " ");
                  label.setText("= " + count );
               } 
               catch (NumberFormatException ae) {
                  label.setText("Invalid");
                  count = "";
               }
            }
         };
      ActionListener equalsListener = 
         new ActionListener() {
            public void actionPerformed(ActionEvent e) {
               Calculations Calculator = new Calculations(count); 
               count = Calculator.count;
               try {
                  if ((double)(int)Double.parseDouble(count) == Double.parseDouble(count)) {
                     count = (int)Double.parseDouble(count) + "";
                  } 
                  label.setText("= " + count );
               }
               catch (NumberFormatException a) {
                  label.setText("= " + count );
               }
            }
         };
   
      
      zero.addActionListener(number);
      one.addActionListener(number);
      two.addActionListener(number);
      three.addActionListener(number);
      four.addActionListener(number);
      five.addActionListener(number);
      six.addActionListener(number);
      seven.addActionListener(number);
      eight.addActionListener(number);
      nine.addActionListener(number);
      decimal.addActionListener(number);
      multiply.addActionListener(operator); 
      divide.addActionListener(operator);
      add.addActionListener(operator);
      subtract.addActionListener(operator);
      exponent.addActionListener(exponentAndLogarithm);
      leftParenthesis.addActionListener(operator);
      rightParenthesis.addActionListener(operator);
      equals.addActionListener(equalsListener);
      equals.addMouseListener(hover);
      clear.addActionListener(operator);
      
      equals.setSize(52, 26);
      System.out.println(equals.getWidth());
      System.out.println(equals.getHeight());
      equals.setIcon(new ImageIcon(getClass().getResource("equals.png")));
   }
    
   public static void main(String []args) {
      new GUI();
   }
   
   public void identifyOperator(ActionEvent e) {
   
      if (e.getSource() == leftParenthesis) {
         count += " ( ";
      }
      
      else if (e.getSource() == rightParenthesis) {
         count += " ) ";
      }
      
      else if (e.getSource() == multiply) {
         count += " * ";
      }
      
      else if (e.getSource() == divide) {
         count += " / ";
      }
      else if (e.getSource() == add) {
         count += " + ";
      }
      else if (e.getSource() == subtract) {
         count += " - ";
      }
      else if (e.getSource() == clear) {
         count = "";
      }
   }
   
   public void identifyNumber(ActionEvent e) {
   
      if (e.getSource() == zero) {
         count += "0";
      }
      else if (e.getSource() == one) {
         count += "1";
      }
      else if (e.getSource() == two) {
         count += "2";
      }
      else if (e.getSource() == three) {
         count += "3";
      }
      else if (e.getSource() == four) {
         count += "4";
      }
      else if (e.getSource() == five) {
         count += "5";
      }
      else if (e.getSource() == six) {
         count += "6";
      }
      else if (e.getSource() == seven) {
         count += "7";
      }
      else if (e.getSource() == eight) {
         count += "8";
      }
      else if (e.getSource() == nine) {
         count += "9";
      } 
      else if (e.getSource() == decimal) {
         count += ".";
      }
   }
}
