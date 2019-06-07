import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.HashMap;

import javax.swing.*;
import java.util.*;

public class MyWindow extends JFrame{
		JMenuBar mBar = new JMenuBar();
		JMenu option = new JMenu("Options");
		JMenuItem newClass = new JMenuItem("New Class");
		HashMap<String, EClass> hMap = new HashMap<>();
		
		
	public MyWindow(String title) {
		super(title);
		setSize(800, 600);
		setVisible(true);
		setLocationRelativeTo(null);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		newClass.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JPanel prompt = new JPanel();
				
				JTextField nameField = new JTextField(7);
				JTextField parentClassField = new JTextField(7);
				//ArrayList of Children classes
				//ArrayList of Methods
				//ArrayList of Fields
				
				ArrayList<String> classNames = new ArrayList<String>();
				Set<String> keys = hMap.keySet();
				for (String key: keys) {
					classNames.add(key);
				}
				
				prompt.add(new JLabel("Class Name:"));
				prompt.add(nameField);
				prompt.add(new JLabel("Parent Class: "));
				prompt.add(parentClassField);
				
				if (e.getSource() == newClass) {
					JOptionPane.showConfirmDialog(null, prompt, "New Class", JOptionPane.OK_CANCEL_OPTION);
				}
				boolean noDups = true;
				for (int i = 0; i < classNames.size(); i++) {
					if (classNames.get(i).equals(parentClassField.getText())) {
						JOptionPane.showMessageDialog(null, "A class with the same name already exist.", "Error", JOptionPane.QUESTION_MESSAGE);
					}
				}
				
				if (noDups) {
					//make class and add to hashMap
					//EClass newEClass = new EClass(nameField.getText(), );
				}
			}
		});
		System.out.println("checkout3");
		option.add(newClass);
		mBar.add(option);
		setJMenuBar(mBar);
	}
}
