// a java program to display max. 93 fibonacci numbers
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

class FibonacciSeriesGenerator extends JFrame implements ItemListener {
	
	JFrame frame;

	JTextField text_field = new JTextField("");

	JLabel display_label = new JLabel();

	Checkbox checkbox = new Checkbox(" Display fibonacci numbers upto N");

	JLabel label = new JLabel();

	FibonacciSeriesGenerator() {
		setGUI();
		updateGUI();
	}

	public void setGUI() {

		frame = new JFrame("Fibonacci Series Generator");

		frame.setSize(400, 700);
		frame.getContentPane().setLayout(null);
		frame.getContentPane().setBackground(Color.black);
		frame.setResizable(false);
		frame.setLocationRelativeTo(null);
		frame.setVisible(true);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

	}

	public void updateGUI() {

		text_field.setBounds(20, 30, 350, 35);
		text_field.setFont(new Font("Courier New", Font.BOLD, 20));
		frame.add(text_field);

		display_label.setBounds(20, 65, 350, 30);
		display_label.setForeground(Color.red);
		frame.add(display_label);

		checkbox.setBounds(40, 95, 330, 35);
		checkbox.setFont(new Font("Courier New", Font.BOLD, 13));
		checkbox.setForeground(Color.white);
		frame.add(checkbox);

		checkbox.addItemListener(this);

		label.setBounds(20, 130, 350, 500);
		label.setFont(new Font("Courier New", Font.BOLD, 13));
		label.setForeground(Color.white);
		frame.add(label);

	}

	public void itemStateChanged(ItemEvent item_event) {

		long no_1 = 0, no_2 = 1, no_3 = 1, n = -1;

		Object item = item_event.getSource();

		if(item == checkbox) {

			try {
				n = Long.parseLong(text_field.getText());
				if(n < 0) {
					display_label.setText("Please enter a whole number!!");
					label.setText("");
					return;
				}
			} catch(NumberFormatException e) {
				display_label.setText("Please enter a whole number!!");
				label.setText("");
				return;
			}

			display_label.setText("");

			if(item_event.getStateChange() == 1) {

				label.setText("<html>Fibonacci numbers upto " + Long.toString(n) + ": ");

				if(n == 0) {
					label.setText(label.getText() + Long.toString(no_1) + "</html>");
				}
				else {
					label.setText(label.getText() + Long.toString(no_1) + ",  " + Long.toString(no_2));
					if(n == 1) return;
					for(int i = 0; (no_1 + no_2) <= n; i++) {
						no_3 = no_1 + no_2;
						label.setText(label.getText() + ",  " + Long.toString(no_3));
						no_1 = no_2;
						no_2 = no_3;
					}
					label.setText(label.getText() + "</html>");
				}

			}

			else {
				label.setText("<html>" + Long.toString(n) + " Fibonacci numbers " + ": ");

				if(n == 0)
					label.setText(label.getText() + "--");
				else if(n == 1) {
					label.setText(label.getText() + Long.toString(no_1));
				}
				else {
					label.setText(label.getText() + Long.toString(no_1) + ",  " + Long.toString(no_2));

					if(n == 2) return;

					for(int i = 2; i < n; i++) {
						no_3 = no_1 + no_2;
						label.setText(label.getText() + ",  " + Long.toString(no_3));
						no_1 = no_2;
						no_2 = no_3;
					}

					label.setText(label.getText() + "</html>");
				}
			}
		}
	}

	public static void main(String[] args) {

		FibonacciSeriesGenerator fibonacciSeriesGenerator = new FibonacciSeriesGenerator();

	}
}