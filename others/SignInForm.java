import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.sql.*;

// javac SignInForm.java
// java -cp ".;sqlite-jdbc-3.32.3.2.jar" SignInForm
class SignInForm extends JFrame implements ActionListener {
    
    JFrame frame;

    JLabel username_label = new JLabel ("Username");
    JTextField username_tf = new JTextField ("");

    JLabel password_label = new JLabel ("Password");
    JTextField password_tf = new JTextField ("");

    JButton login_button = new JButton ("LOG IN");

    JLabel result_label = new JLabel ("");

    SignInForm () {
        setGUI ();
        updateGUI ();
    }

    public void setGUI () {

        frame = new JFrame ("SIGN-IN FORM");

        frame.setSize (530, 450);
        frame.getContentPane ().setLayout (null);
        frame.setResizable (false);
        frame.setLocationRelativeTo (null);
        frame.setVisible (true);
        frame.setDefaultCloseOperation (JFrame.EXIT_ON_CLOSE);

    }

    public void updateGUI () {

        username_label.setBounds (100, 60, 100, 50);
        username_tf.setBounds (220, 70, 200, 30);
        frame.add (username_label);
        frame.add (username_tf);


        password_label.setBounds (100, 130, 100, 50);
        password_tf.setBounds (220, 140, 200, 30);
        frame.add (password_label);
        frame.add (password_tf);

        login_button.setBounds (205, 240, 100, 40);
        login_button.setBackground(Color.gray);
        frame.add (login_button);

        login_button.addActionListener (this);

        result_label.setBounds (110, 305, 320, 100);
        frame.add (result_label);

    }

    public void actionPerformed (ActionEvent action_event) {

        String username_str = username_tf.getText ();
        String password_str = password_tf.getText ();
        
        Connection connection = null;

        try {

            connection = DriverManager.getConnection ("jdbc:sqlite:/F:/Java-progs/sqlite/StudentDataBase");
            Statement statement = connection.createStatement ();
            String query = "SELECT * FROM Users";
            ResultSet result_set = statement.executeQuery (query);

            while (result_set.next ()) {

                String username = result_set.getString (1);
                String password = result_set.getString (2);

                if (username_str.equals (username) && password_str.equals (password)) {
                    result_label.setText ("LOGIN SUCCESSFULL !!");
                    break;
                }
                else if (username_str.equals (username) && !password_str.equals (password)) {
                    result_label.setText ("<html>LOGIN FAILED !! <br>Wrong Password ! <br>Please enter correct password :)</html>");
                    break;
                }
                else 
                    result_label.setText ("LOGIN FAILED !!");
            }

            connection.close ();

        }
        catch (Exception e) {

            result_label.setText ("LOGIN FAILED !!");
            System.err.println (e.getClass ().getName () + ": " + e.getMessage ());

        }

    }

    public static void main (String[] args) {

        SignInForm SignInForm = new SignInForm ();
    
    }

}
