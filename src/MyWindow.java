import java.awt.Color;
import java.awt.LayoutManager;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.HashMap;

import javax.swing.*;
import java.util.*;

public class MyWindow extends JFrame{
		private JMenuBar mBar = new JMenuBar();
		private JMenu option = new JMenu("Options");
		private JMenuItem newClass = new JMenuItem("New Class");
		private HashMap<String, EClass> hMap = new HashMap<>();
		//NewEClass newClass = new NewEClass("New Class", hMap);
		
	public MyWindow(String title) {
		super(title);
		setSize(800, 600);
		setVisible(true);
		setLocationRelativeTo(null);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		newClass.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JPanel prompt = new JPanel();
				BoxLayout bl = new BoxLayout(prompt, 0);
				prompt.setLayout(bl);
				DefaultListModel dlm = new DefaultListModel();
				JTextField nameField = new JTextField(7);
				JTextField parentClassField = new JTextField(7);
				//ArrayList of Children classes
				JButton createMethod = new JButton("New Method");
				//ArrayList of Fields
				
				createMethod.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						if (e.getSource() == createMethod) {
							System.out.println("I Did it!");
							EMethod m = new EMethod();
							JDialog jd = new JDialog();
							jd.setAlwaysOnTop(true);
							String mName = JOptionPane.showInputDialog(jd, "Method Name?");
							m.setName(mName);
							String mParams = JOptionPane.showInputDialog(jd,"Parameters (enter like this: type name, type name...)?");
							enterKeys(mParams, m.getParams());
							String mReturnType = JOptionPane.showInputDialog(jd, "Return Type?");
							m.setReturnType(mReturnType);
							
							dlm.addElement(mName);
							
						}
					}
				});
				
				ArrayList<String> classNames = new ArrayList<String>();
				Set<String> keys = hMap.keySet();
				for (String key: keys) {
					classNames.add(key);
				}
				
				prompt.add(new JLabel("Class Name:"));
				prompt.add(nameField);
				prompt.add(new JLabel("Parent Class: "));
				prompt.add(parentClassField);
				prompt.add(createMethod);
				JList jl = new JList(dlm);
				prompt.add(new JLabel("Methods:"));
				prompt.add(jl);
				
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
	
	public HashMap<String, String> enterKeys(String raw, HashMap<String, String> hMapP) {
		String[] s = raw.split(",");
		String key;
		String value;
		int indexOfSpace;
		for (int i = 0; i < s.length; i++) {
			indexOfSpace = s[i].indexOf(" ");
			hMapP.put(s[i].substring(0, indexOfSpace), s[i].substring(++indexOfSpace, s[i].length()));
		}
		return null;
		
	}
}
