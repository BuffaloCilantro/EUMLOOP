import java.awt.Color;
import java.util.HashMap;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;

public class MyWindow extends JFrame{
		JMenuBar mBar = new JMenuBar();
		JMenu editClasses = new JMenu("Edit");
		HashMap<String, EClass> hMap = new HashMap<>();
		JButton button = new JButton("Edit");
		
	public MyWindow(String title) {
		super(title);
		setSize(800, 600);
		setVisible(true);
		setLocationRelativeTo(null);
		mBar.setBackground(Color.RED);
		mBar.add(button);
		setJMenuBar(mBar);
		setVisible(true);
	}
}
