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
				
			}
		});
		option.add(newClass);
		mBar.add(option);
		setJMenuBar(mBar);
		
		setVisible(true);
	}
}
