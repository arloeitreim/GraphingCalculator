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

public class GUITest {

   public GUITest() {
      JFrame frame = new JFrame();
      JPanel p = new JPanel();
      JLabel l = new JLabel("2");
      String count = "<html>2 + 3 ( 2 - 3 ) + (m<sup>_</sup>)</html>";
      if (count.contains("_")) {
      l.setText(count);
      String s = "3";
      char c = s.charAt(0);
      count = count.replace('_', c);
      l.setText(count);
      }
      System.out.println(count);
      
      frame.add(l);
      frame.setDefaultCloseOperation( JFrame.EXIT_ON_CLOSE );
      frame.setTitle( "Calculator" );
      frame.pack();
      frame.setVisible(true);

   }
   
   public static void main(String []args) {
      new GUITest();
   }
}
   