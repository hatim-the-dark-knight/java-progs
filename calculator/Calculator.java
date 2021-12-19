import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

class Calculator extends JFrame implements ActionListener {

	double x, y;
	int operation;

	JFrame frame;

	JLabel label = new JLabel();

	JTextField text_field = new JTextField();

	JRadioButton radio_button_on = new JRadioButton("on");
	JRadioButton radio_button_off = new JRadioButton("off");

	JButton button_0 = new JButton("0");
	JButton button_1 = new JButton("1");
	JButton button_2 = new JButton("2");
	JButton button_3 = new JButton("3");
	JButton button_4 = new JButton("4");
	JButton button_5 = new JButton("5");
	JButton button_6 = new JButton("6");
	JButton button_7 = new JButton("7");
	JButton button_8 = new JButton("8");
	JButton button_9 = new JButton("9");

	JButton button_dot = new JButton(".");
	JButton button_clear = new JButton("C");
	JButton button_delete = new JButton("DEL");

	JButton button_slash = new JButton("/");
	JButton button_star = new JButton("*");
	JButton button_plus = new JButton("+");
	JButton button_minus = new JButton("-");
	JButton button_equalTo = new JButton("=");

	JButton button_square = new JButton("x\u00B2");
	JButton button_inverse = new JButton("1/x");
	JButton button_squareRoot = new JButton("\u221Ax");

	Calculator() {
	
		setGUI();
		updatingGUI();

	}
	public void setGUI() {

		frame = new JFrame("Calculator");

		frame.setSize(350, 600);
		frame.getContentPane().setLayout(null);
		frame.getContentPane().setBackground(Color.gray);
		frame.setResizable(false);
		frame.setLocationRelativeTo(null);
		frame.setVisible(true);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}

	public void updatingGUI() {
	
		label.setBounds(20, 0, 330, 25);
		label.setForeground(Color.white);
		frame.add(label);

		text_field.setBounds(20, 30, 295, 70);
		text_field.setFont(new Font("Courier New", Font.BOLD, 20));
		text_field.setEditable(false);
		text_field.setHorizontalAlignment(SwingConstants.RIGHT);
		frame.add(text_field);

		radio_button_on.setBounds(20, 120, 66, 30);
		radio_button_on.setSelected(true);
		radio_button_on.setFont(new Font("Courier New", Font.BOLD, 18));
		radio_button_on.setBackground(Color.gray);
		//radio_button_on.setForeground(Color.white);
		frame.add(radio_button_on);

		radio_button_off.setBounds(20, 145, 66, 30);
		radio_button_off.setSelected(false);
		radio_button_off.setFont(new Font("Courier New", Font.BOLD, 18));
		radio_button_off.setBackground(Color.gray);
		//radio_button_off.setForeground(Color.white);
		frame.add(radio_button_off);

		ButtonGroup button_group = new ButtonGroup();
		button_group.add(radio_button_off);
		button_group.add(radio_button_on);

		radio_button_on.addActionListener(this);
		radio_button_off.addActionListener(this);


		button_clear.setBounds(96, 120, 66, 55);
		button_clear.setFont(new Font("Courier New", Font.BOLD, 17));
		button_clear.setBackground(Color.black);
		button_clear.setForeground(Color.red);
		frame.add(button_clear);

		button_delete.setBounds(172, 120, 66, 55);
		button_delete.setFont(new Font("Courier New", Font.BOLD, 17));
		button_delete.setBackground(Color.red);
		button_delete.setForeground(Color.white);
		frame.add(button_delete);

		button_slash.setBounds(248, 120, 66, 55);
		button_slash.setFont(new Font("Courier New", Font.BOLD, 20));
		button_slash.setBackground(Color.black);
		button_slash.setForeground(Color.white);
		frame.add(button_slash);

		button_clear.addActionListener(this);
		button_delete.addActionListener(this);
		button_slash.addActionListener(this);


		button_inverse.setBounds(20, 190, 66, 55);
		button_inverse.setFont(new Font("Courier New", Font.BOLD, 17));
		button_inverse.setBackground(Color.black);
		button_inverse.setForeground(Color.white);
		frame.add(button_inverse);

		button_square.setBounds(96, 190, 66, 55);
		button_square.setFont(new Font("Courier New", Font.BOLD, 20));
		button_square.setBackground(Color.black);
		button_square.setForeground(Color.white);
		frame.add(button_square);

		button_squareRoot.setBounds(172, 190, 66, 55);
		button_squareRoot.setFont(new Font("Courier New", Font.BOLD, 20));
		button_squareRoot.setBackground(Color.black);
		button_squareRoot.setForeground(Color.white);
		frame.add(button_squareRoot);

		button_star.setBounds(248, 190, 66, 55);
		button_star.setFont(new Font("Courier New", Font.BOLD, 20));
		button_star.setBackground(Color.black);
		button_star.setForeground(Color.white);
		frame.add(button_star);

		button_inverse.addActionListener(this);
		button_square.addActionListener(this);
		button_squareRoot.addActionListener(this);
		button_star.addActionListener(this);


		button_7.setBounds(20, 260, 66, 55);
		button_7.setFont(new Font("Courier New", Font.BOLD, 20));
		button_7.setBackground(Color.black);
		button_7.setForeground(Color.white);
		frame.add(button_7);

		button_8.setBounds(96, 260, 66, 55);
		button_8.setFont(new Font("Courier New", Font.BOLD, 20));
		button_8.setBackground(Color.black);
		button_8.setForeground(Color.white);
		frame.add(button_8);

		button_9.setBounds(172, 260, 66, 55);
		button_9.setFont(new Font("Courier New", Font.BOLD, 20));
		button_9.setBackground(Color.black);
		button_9.setForeground(Color.white);
		frame.add(button_9);

		button_minus.setBounds(248, 260, 66, 55);
		button_minus.setFont(new Font("Courier New", Font.BOLD, 20));
		button_minus.setBackground(Color.black);
		button_minus.setForeground(Color.white);
		frame.add(button_minus);

		button_7.addActionListener(this);
		button_8.addActionListener(this);
		button_9.addActionListener(this);
		button_minus.addActionListener(this);


		button_4.setBounds(20, 330, 66, 55);
		button_4.setFont(new Font("Courier New", Font.BOLD, 20));
		button_4.setBackground(Color.black);
		button_4.setForeground(Color.white);
		frame.add(button_4);

		button_5.setBounds(96, 330, 66, 55);
		button_5.setFont(new Font("Courier New", Font.BOLD, 20));
		button_5.setBackground(Color.black);
		button_5.setForeground(Color.white);
		frame.add(button_5);

		button_6.setBounds(172, 330, 66, 55);
		button_6.setFont(new Font("Courier New", Font.BOLD, 20));
		button_6.setBackground(Color.black);
		button_6.setForeground(Color.white);
		frame.add(button_6);

		button_plus.setBounds(248, 330, 66, 55);
		button_plus.setFont(new Font("Courier New", Font.BOLD, 20));
		button_plus.setBackground(Color.black);
		button_plus.setForeground(Color.white);
		frame.add(button_plus);

		button_4.addActionListener(this);
		button_5.addActionListener(this);
		button_6.addActionListener(this);
		button_plus.addActionListener(this);


		button_1.setBounds(20, 400, 66, 55);
		button_1.setFont(new Font("Courier New", Font.BOLD, 20));
		button_1.setBackground(Color.black);
		button_1.setForeground(Color.white);
		frame.add(button_1);

		button_2.setBounds(96, 400, 66, 55);
		button_2.setFont(new Font("Courier New", Font.BOLD, 20));
		button_2.setBackground(Color.black);
		button_2.setForeground(Color.white);
		frame.add(button_2);

		button_3.setBounds(172, 400, 66, 55);
		button_3.setFont(new Font("Courier New", Font.BOLD, 20));
		button_3.setBackground(Color.black);
		button_3.setForeground(Color.white);
		frame.add(button_3);

		button_equalTo.setBounds(248, 400, 66, 125);
		button_equalTo.setFont(new Font("Courier New", Font.BOLD, 20));
		button_equalTo.setBackground(Color.black);
		button_equalTo.setForeground(Color.white);
		frame.add(button_equalTo);

		button_1.addActionListener(this);
		button_2.addActionListener(this);
		button_3.addActionListener(this);
		button_equalTo.addActionListener(this);


		button_0.setBounds(20, 470, 142, 55);
		button_0.setFont(new Font("Courier New", Font.BOLD, 20));
		button_0.setBackground(Color.black);
		button_0.setForeground(Color.white);
		frame.add(button_0);

		button_dot.setBounds(172, 470, 66, 55);
		button_dot.setFont(new Font("Courier New", Font.BOLD, 20));
		button_dot.setBackground(Color.black);
		button_dot.setForeground(Color.white);
		frame.add(button_dot);

		button_0.addActionListener(this);
		button_dot.addActionListener(this);

	}

	public void actionPerformed(ActionEvent action_event) {

		Object button = action_event.getSource();

		if(button == radio_button_on) 
			setEnabled ();

		else if(button == radio_button_off)
			setDisabled();

		else if(button == button_clear) {
			label.setText("");
			text_field.setText("");
		}

		else if(button == button_delete) {
			int length = text_field.getText().length();
			int _length = length - 1;

			if(length > 0) {
				StringBuilder undeleted = new StringBuilder(text_field.getText());
				undeleted.deleteCharAt(_length);
				text_field.setText(undeleted.toString());
			}
			if(text_field.getText().endsWith("")) {
				label.setText("");
			}
		}

		else if(button == button_0) {
			if(text_field.getText().equals("0"))
				return;
			else
				text_field.setText(text_field.getText() + "0");
		}

		else if(button == button_1) 
			text_field.setText(text_field.getText() + "1");
		
		else if(button == button_2) 
			text_field.setText(text_field.getText() + "2");
		
		else if(button == button_3) 
			text_field.setText(text_field.getText() + "3");
		
		else if(button == button_4) 
			text_field.setText(text_field.getText() + "4");
		
		else if(button == button_5) 
			text_field.setText(text_field.getText() + "5");
		
		else if(button == button_6) 
			text_field.setText(text_field.getText() + "6");
		
		else if(button == button_7) 
			text_field.setText(text_field.getText() + "7");
		
		else if(button == button_8) 
			text_field.setText(text_field.getText() + "8");
		
		else if(button == button_9) 
			text_field.setText(text_field.getText() + "9");
		
		else if(button == button_dot) {
			if(text_field.getText().contains("."))
				return;
			else
				text_field.setText(text_field.getText() + ".");
		}

		else if(button == button_slash) {
			String string = text_field.getText();
			x = Double.parseDouble(text_field.getText());
			text_field.setText("");
			label.setText(string + "/");
			operation = 1;
		}

		else if(button == button_star) {
			String string = text_field.getText();
			x = Double.parseDouble(text_field.getText());
			text_field.setText("");
			label.setText(string + "*");
			operation = 2;
		}

		else if(button == button_minus) {
			String string = text_field.getText();
			x = Double.parseDouble(text_field.getText());
			text_field.setText("");
			label.setText(string + "-");
			operation = 3;
		}

		else if(button == button_plus) {
			String string = text_field.getText();
			x = Double.parseDouble(text_field.getText());
			text_field.setText("");
			label.setText(string + "+");
			operation = 4;
		}

		else if(button == button_inverse) {
			x = Double.parseDouble(text_field.getText());
			double inverse = 1/x;
			String string = Double.toString(inverse);
			if(string.endsWith(".0"))
				text_field.setText(string.replace(".0", ""));
			else
				text_field.setText(string);
		}

		else if(button == button_square) {
			x = Double.parseDouble(text_field.getText());
			double square = Math.pow(x, 2);
			String string = Double.toString(square);
			if(string.endsWith(".0"))
				text_field.setText(string.replace(".0", ""));
			else
				text_field.setText(string);
		}

		else if(button == button_squareRoot) {
			x = Double.parseDouble(text_field.getText());
			double squareRoot = Math.sqrt(x);
			String string = Double.toString(squareRoot);
			if(string.endsWith(".0"))
				text_field.setText(string.replace(".0", ""));
			else
				text_field.setText(string);
		}

		else if(button == button_equalTo) {
			switch(operation) {
				case 1:
					y = x / Double.parseDouble(text_field.getText());
					if(Double.toString(y).endsWith(".0"))
						text_field.setText(Double.toString(y).replace(".0", ""));
					else
						text_field.setText(Double.toString(y));
					label.setText("");
					break;
				case 2:
					y = x * Double.parseDouble(text_field.getText());
					if(Double.toString(y).endsWith(".0"))
						text_field.setText(Double.toString(y).replace(".0", ""));
					else
						text_field.setText(Double.toString(y));
					label.setText("");
					break;
				case 3:
					y = x - Double.parseDouble(text_field.getText());
					if(Double.toString(y).endsWith(".0"))
						text_field.setText(Double.toString(y).replace(".0", ""));
					else
						text_field.setText(Double.toString(y));
					label.setText("");
					break;
				case 4:
					y = x + Double.parseDouble(text_field.getText());
					if(Double.toString(y).endsWith(".0"))
						text_field.setText(Double.toString(y).replace(".0", ""));
					else
						text_field.setText(Double.toString(y));
					label.setText("");
					break;
			}
		}
	}

	public void setEnabled() {

		label.setEnabled(true);
		text_field.setEnabled(true);

		radio_button_on.setEnabled(false);
		radio_button_off.setEnabled(true);

		button_clear.setEnabled(true);
		button_delete.setEnabled(true);
		button_slash.setEnabled(true);

		button_inverse.setEnabled(true);
		button_square.setEnabled(true);
		button_squareRoot.setEnabled(true);
		button_star.setEnabled(true);

		button_7.setEnabled(true);
		button_8.setEnabled(true);
		button_9.setEnabled(true);
		button_minus.setEnabled(true);

		button_4.setEnabled(true);
		button_5.setEnabled(true);
		button_6.setEnabled(true);
		button_plus.setEnabled(true);

		button_1.setEnabled(true);
		button_2.setEnabled(true);
		button_3.setEnabled(true);
		button_equalTo.setEnabled(true);

		button_0.setEnabled(true);
		button_dot.setEnabled(true);

	}

	public void setDisabled() {

		label.setText("");
		text_field.setText("");

		radio_button_on.setEnabled(true);
		radio_button_off.setEnabled(false);

		button_clear.setEnabled(false);
		button_delete.setEnabled(false);
		button_slash.setEnabled(false);

		button_inverse.setEnabled(false);
		button_square.setEnabled(false);
		button_squareRoot.setEnabled(false);
		button_star.setEnabled(false);

		button_7.setEnabled(false);
		button_8.setEnabled(false);
		button_9.setEnabled(false);
		button_minus.setEnabled(false);

		button_4.setEnabled(false);
		button_5.setEnabled(false);
		button_6.setEnabled(false);
		button_plus.setEnabled(false);

		button_1.setEnabled(false);
		button_2.setEnabled(false);
		button_3.setEnabled(false);
		button_equalTo.setEnabled(false);

		button_0.setEnabled(false);
		button_dot.setEnabled(false);

	}

	public static void main(String[] args) {
	
		Calculator calculator = new Calculator();

	}

}