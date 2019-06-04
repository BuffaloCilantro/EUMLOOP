import java.util.ArrayList;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;

public class MyWindow extends JFrame{
		JMenuBar mBar = new JMenuBar();
		JMenu editClasses = new JMenu();
		ArrayList<EClass> MyEClasses = new ArrayList<EClass>();
	
	public MyWindow(String title) {
		
		super(title);
		setSize(800, 600);
		setVisible(true);
		setLocationRelativeTo(null);
		
		editClasses.setText("Edit");
	}
}
