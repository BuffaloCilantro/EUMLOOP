import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;

public class MyWindow extends JFrame{
	
	public MyWindow(String title) {
		super(title);
		setSize(800, 600);
		setVisible(true);
		setLocationRelativeTo(null);
		
		JMenuBar mBar = new JMenuBar();
		JMenu edit = new JMenu();
		
		edit.setText("Edit");
	}
}
