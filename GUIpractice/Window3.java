import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Window3 extends JFrame implements ActionListener{
    private Container pane;
    private JLabel j;
    private JTextField t;

   public Window3() {
    this.setTitle("Degrees Converter");
    this.setSize(200,150);
    this.setLocation(100,100);
    this.setDefaultCloseOperation(EXIT_ON_CLOSE);

    pane = this.getContentPane();
    pane.setLayout(new BoxLayout(pane, BoxLayout.Y_AXIS));
    JButton b = new JButton("Convert to Fahrenheit");
    b.addActionListener(this);
    b.setActionCommand("Celsius");
    JButton b2 = new JButton("Convert to Celsius");
    b2.addActionListener(this);
    b2.setActionCommand("Fahrenheit");
    t = new JTextField(1);
    j = new JLabel("Input a number");
    pane.add(t);
    pane.add(b);
    pane.add(b2);
    pane.add(j);
  }

  public void actionPerformed(ActionEvent e){
    String event = e.getActionCommand();
    if(event.equals("Celsius")){
      double answer = CtoF(Double.parseDouble(t.getText()));
      String s = "" + answer;
      j.setText(s);
    }
    if(event.equals("Fahrenheit")){
      double answer = FtoC(Double.parseDouble(t.getText()));
      String s = "" + answer;
      j.setText(s);
    }
  }

  public static double CtoF(double cel){
      return ((cel*(9/5))+32);
    }

  public static double FtoC(double far){
      return ((far -32)*5/9);
    }


  public static void main(String[] args) {
     Window3 g = new Window3();
     g.setVisible(true);
  }

}