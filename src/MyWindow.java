import java.awt.Color;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
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
		//private HashMap<String, EClass> hMapEClass= new HashMap<>();
		private DefaultListModel dlmMethods = new DefaultListModel<EMethod>();
		private DefaultListModel dlmFields = new DefaultListModel<EField>();
		private DefaultListModel dlmEClasses = new DefaultListModel<EClass>();
		private JDialog jd = new JDialog();
		
	public MyWindow(String title) {
		super(title);
		setSize(800, 600);
		setVisible(true);
		setLocationRelativeTo(null);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		
		newClass.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				jd.setAlwaysOnTop(true);
				JPanel prompt = new JPanel();
				prompt.setLayout(new BoxLayout(prompt, BoxLayout.PAGE_AXIS));
				JTextField nameField = new JTextField(7);
				JButton createMethod = new JButton("New Method");
				JButton addField = new JButton("New Field");
				
				createMethod.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						if (e.getSource() == createMethod) {
							EMethod method = new EMethod();
							String methodName = JOptionPane.showInputDialog(jd, "Method name?");
							method.setName(methodName);
							String methodParams = JOptionPane.showInputDialog(jd,"Parameters (enter like this: type1 name1, type2 name2...)?");
							HashMap hMapMethodParams = new HashMap<String, String>();
							boolean working = enterKeys(methodParams, hMapMethodParams);
							if (!working) {
								JOptionPane.showMessageDialog(jd,"Parameters inputed incorrectly!", "Error!", JOptionPane.ERROR_MESSAGE);
								return;
							}
							method.setParams(hMapMethodParams);
							String mReturnType = JOptionPane.showInputDialog(jd, "Return type?");
							method.setReturnType(mReturnType);
							String description = JOptionPane.showInputDialog(jd, "What does this method do?");
							method.setFunctionDescrip(description);
							dlmMethods.addElement(method);
						}
					}
				});
				
				addField.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						if (e.getSource() == addField) {
							String fieldType = JOptionPane.showInputDialog(jd, "Field type?");
							String fieldName = JOptionPane.showInputDialog(jd, "Field name?");
							EField ef = new EField(fieldType, fieldName);
							dlmFields.addElement(ef);
						}
					}
				});
				
				JList listEClasses = new JList(dlmEClasses);
				MouseListener mouseListenerECLasses = new MouseAdapter() {
					public void mouseClicked(MouseEvent e ) {
						if (e.getClickCount() == 1) {
							String selectedEClassKey = (String) listEClasses.getSelectedValue();
							//set parent class
						}
					}
				};
				JScrollPane scrollEClasses = new JScrollPane(listEClasses);
				prompt.add(new JLabel("Class Name: "));
				prompt.add(nameField);
				prompt.add(new JLabel("Parent Class: "));
				prompt.add(scrollEClasses);
				prompt.add(addField);
				JList fields = new JList(dlmFields);
				MouseListener mouseListenerFields = new MouseAdapter() {
					public void mouseClicked(MouseEvent e) {
						if (e.getClickCount() == 2) {
							EField eff = (EField) fields.getSelectedValue();
							//String selectedField = eff.name + " ";
							int delete = JOptionPane.showConfirmDialog(prompt, "Delete this field?");
							int index = dlmFields.indexOf(eff);
							if (delete == JOptionPane.OK_OPTION) {
								dlmFields.removeElementAt(index);
							}
						}
					}
				};
				fields.addMouseListener(mouseListenerFields);
				JScrollPane fieldsScroll = new JScrollPane(fields);
				prompt.add(new JLabel("Fields: "));
				prompt.add(fieldsScroll);
				prompt.add(createMethod);
				JList jlEMethods = new JList(dlmMethods);
				MouseListener mouseListenerEMethods = new  MouseAdapter() {
				    public void mouseClicked(MouseEvent e) {
				        if (e.getClickCount() == 2) {
				        	EMethod selectedEMethod = (EMethod) jlEMethods.getSelectedValue();
				        	JPanel eMethodStuff = new JPanel();
				        	eMethodStuff.setLayout(new BoxLayout(eMethodStuff, BoxLayout.PAGE_AXIS));
				        	eMethodStuff.add(new JLabel("Method name: " + selectedEMethod.getName()));
				        	eMethodStuff.add(new JLabel("Method parameters: " + selectedEMethod.getParams()));
				        	eMethodStuff.add(new JLabel("Method return type: " + selectedEMethod.getReturnType()));
				        	eMethodStuff.add(new JLabel("Method description: " + selectedEMethod.getFunctionDescrip()));
				        	JOptionPane.showMessageDialog(prompt, eMethodStuff, selectedEMethod.getName() + "info", JOptionPane.OK_OPTION);
				        }
				    }
				};
				jlEMethods.addMouseListener(mouseListenerEMethods);
				JScrollPane methods = new JScrollPane(jlEMethods);
				prompt.add(new JLabel("Methods:"));
				prompt.add(methods);
				
				
				if (e.getSource() == newClass) {
					int result = JOptionPane.showConfirmDialog(null, prompt, "New Class", JOptionPane.OK_CANCEL_OPTION);
					if (result == JOptionPane.OK_OPTION) {
						ArrayList<EField> listFields = new ArrayList<EField>();
						for (int i = 0; i < fields.getModel().getSize(); i++) {
							listFields.add((EField)fields.getModel().getElementAt(i));
						}
						
						ArrayList<EMethod> listMethods = new ArrayList<EMethod>();
						for (int i = 0; i < jlEMethods.getModel().getSize(); i++) {
							listMethods.add((EMethod)jlEMethods.getModel().getElementAt(i));
						}
						EClass ec = new EClass(nameField.getText(), listFields, listMethods);
						dlmEClasses.addElement(ec);
					}
				}
				/*
				boolean noDups = true;
				
//				for (int i = 0; i < classNames.size(); i++) {
//					if (classNames.get(i).equals(parentClassField.getText())) {
//						JOptionPane.showMessageDialog(null, "A class with the same name already exist.", "Error", JOptionPane.QUESTION_MESSAGE);
//					}
//				}
				
				if (noDups) {
					ArrayList<EField> listFields = new ArrayList<EField>();
					for (int i = 0; i < fields.getModel().getSize(); i++) {
						listFields.add((EField)jlEMethods.getModel().getElementAt(i));
					}
					
					ArrayList<EMethod> listMethods = new ArrayList<EMethod>();
					for (int i = 0; i < jlEMethods.getModel().getSize(); i++) {
						listMethods.add((EMethod)jlEMethods.getModel().getElementAt(i));
					}
					EClass ec = new EClass(nameField.getText(), listFields, listMethods);
					dlmEClasses.addElement(ec);
				}
				*/
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
