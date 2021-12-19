import java.io.*;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.text.*;
import javax.swing.plaf.metal.*;

class TextEditor extends JFrame implements ActionListener {
	//GUI
	JFrame frame;

	JTextArea text_area;

	TextEditor() {

		frame = new JFrame("TextEditor");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		try {
			UIManager.setLookAndFeel("javax.swing.plaf.metal.MetalLookAndFeel");
			MetalLookAndFeel.setCurrentTheme(new OceanTheme());
		}
		catch(Exception e) {
		}

		text_area = new JTextArea();

		JMenuBar menu_bar = new JMenuBar();

		JMenu file_menu = new JMenu("File");

		JMenuItem file_new = new JMenuItem("New");
		JMenuItem file_open = new JMenuItem("Open");
		JMenuItem file_save = new JMenuItem("Save");
		JMenuItem file_print = new JMenuItem("Print");

		file_new.addActionListener(this);
		file_open.addActionListener(this);
		file_save.addActionListener(this);
		file_print.addActionListener(this);

		file_menu.add(file_new);
		file_menu.add(file_open);
		file_menu.add(file_save);
		file_menu.add(file_print);

		JMenu edit_menu = new JMenu("Edit");

		JMenuItem edit_cut = new JMenuItem("Cut");
		JMenuItem edit_copy = new JMenuItem("Copy");
		JMenuItem edit_paste = new JMenuItem("Paste");

		edit_cut.addActionListener(this);
		edit_copy.addActionListener(this);
		edit_paste.addActionListener(this);

		edit_menu.add(edit_cut);
		edit_menu.add(edit_copy);
		edit_menu.add(edit_paste);

		JMenuItem close_menu = new JMenuItem("Close");

		close_menu.addActionListener(this);

		menu_bar.add(file_menu);
		menu_bar.add(edit_menu);
		menu_bar.add(close_menu);

		frame.setJMenuBar(menu_bar);
		frame.add(text_area);
		frame.setSize(750, 500);
		frame.setVisible(true);

	}

	//Actions
	public void actionPerformed(ActionEvent action_event) {

		String action = action_event.getActionCommand();

		if(action.equals("New")) {
			text_area.setText("");
		}

		else if(action.equals("Open")) {
			
			JFileChooser file_chooser = new JFileChooser("file_chooser: ");

			int fc = file_chooser.showOpenDialog(null);

			if(fc == JFileChooser.APPROVE_OPTION) {

				File open_file = new File(file_chooser.getSelectedFile().getAbsolutePath());

				try {

					String line = "", content = "";

					FileReader fr = new FileReader(open_file);
					BufferedReader br = new BufferedReader(fr);

					content = br.readLine();

					while((line = br.readLine()) != null) {
						content = content + "\n" + line;
					}
					text_area.setText(content);
					br.close ();
					
				}
				catch(Exception exception) {
					JOptionPane.showMessageDialog(frame, exception.getMessage());
				}

			}

			else
				JOptionPane.showMessageDialog(frame, "Operation Cancelled!!");

		}

		else if(action.equals("Save")) {
			
			JFileChooser file_chooser = new JFileChooser("file_chooser: ");

			int fc = file_chooser.showSaveDialog(null);

			if(fc == JFileChooser.APPROVE_OPTION) {

				File save_file = new File(file_chooser.getSelectedFile().getAbsolutePath());

				try {

					FileWriter fw = new FileWriter(save_file, false);
					BufferedWriter bw = new BufferedWriter(fw);

					bw.write(text_area.getText());

					bw.flush();
					bw.close();

				}
				catch(Exception exception) {
					JOptionPane.showMessageDialog(frame, exception.getMessage());
				}
			}

			else
				JOptionPane.showMessageDialog(frame, "Operation Cancelled!!");

		}

		else if(action.equals("Print")) {

			try {
				text_area.print();
			}
			catch(Exception exception) {
				JOptionPane.showMessageDialog(frame, exception.getMessage());
			}

		}

		else if(action.equals("Cut")) {
			text_area.cut();
		}

		else if(action.equals("Copy")) {
			text_area.copy();
		}

		else if(action.equals("Paste")) {
			text_area.paste();
		}

		else if(action.equals("Close")) {
			frame.setVisible(false);
		}

	}

	public static void main(String args[]) {

		TextEditor text_editor = new TextEditor();

	}

}