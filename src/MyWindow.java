import java.awt.Color;
import java.awt.LayoutManager;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.lang.reflect.Field;

import javax.swing.*;
import java.util.*;

public class MyWindow extends JFrame{
		private JMenuBar mBar = new JMenuBar();
		private JMenu option = new JMenu("Options");
		private JMenuItem newClass = new JMenuItem("New Class");
		private HashMap<String, EClass> hMapEClass= new HashMap<>();
		private DefaultListModel dlm = new DefaultListModel();
		private JList jl;
		
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
				JTextField nameField = new JTextField(7);
				JTextField parentClassField = new JTextField(7);
				//ArrayList of Children classes
				JButton createMethod = new JButton("New Method");
				//ArrayList of Fields
				
				createMethod.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						if (e.getSource() == createMethod) {
							EMethod method = new EMethod();
							JDialog jd = new JDialog();
							jd.setAlwaysOnTop(true);
							String methodName = JOptionPane.showInputDialog(jd, "Method Name?");
							method.setName(methodName);
							String methodParams = JOptionPane.showInputDialog(jd,"Parameters (enter like this: type1 name1, type2 name2...)?");
							HashMap hMapMethodParams = new HashMap<String, String>();
							boolean working = enterKeys(methodParams, hMapMethodParams);
							if (!working) {
								JOptionPane.showMessageDialog(jd,"Parameters inputed incorrectly!", "Error!", JOptionPane.ERROR_MESSAGE);
								return;
							}
							method.setParams(hMapMethodParams);
							String mReturnType = JOptionPane.showInputDialog(jd, "Return Type?");
							method.setReturnType(mReturnType);
							String description = JOptionPane.showInputDialog(jd, "What does this method do?");
							dlm.addElement(method);
						}
					}
				});
				
				ArrayList<String> classNames = new ArrayList<String>();
				Set<String> keys = hMapEClass.keySet();
				for (String key: keys) {
					classNames.add(key);
				}
				
				prompt.add(new JLabel("Class Name:"));
				prompt.add(nameField);
				prompt.add(new JLabel("Parent Class: "));
				prompt.add(parentClassField);
				prompt.add(createMethod);
				jl = new JList(dlm);
				MouseListener mouseListener = new  MouseAdapter() {
				    public void mouseClicked(MouseEvent e) {
				        if (e.getClickCount() == 2) {
				        	EMethod selectedEMethod = (EMethod) jl.getSelectedValue();
				        	JOptionPane.showMessageDialog(prompt, selectedEMethod.getFunctionDescrip(), selectedEMethod.getName(), JOptionPane.OK_OPTION);
				        	System.out.println(selectedEMethod);
				        }
				    }
				};
				jl.addMouseListener(mouseListener);
				JScrollPane methods = new JScrollPane(jl);
				prompt.add(new JLabel("Methods:"));
				prompt.add(methods);
				
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
		option.add(newClass);
		mBar.add(option);
		setJMenuBar(mBar);
	}
	
	public boolean enterKeys(String raw, HashMap<String, String> hMapP) {
		
		try {
			String[] s = raw.split(",");
			int indexOfSpace;
			for (int i = 0; i < s.length; i++) {
				indexOfSpace = s[i].indexOf(" ");
				hMapP.put(s[i].substring(0, indexOfSpace), s[i].substring(++indexOfSpace, s[i].length()));
			}
			return true;
		} catch (StringIndexOutOfBoundsException e) {
			return false;
		}
	}
}
