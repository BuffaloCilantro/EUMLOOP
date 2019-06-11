import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.HashMap;

public class EMethod implements MouseListener{
	private String name;
	private HashMap<String, String> params= new HashMap<String, String>();
	private String returnType;
	private String functionDescrip;
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public HashMap<String, String> getParams() {
		return params;
	}
	public void setParams(HashMap<String, String> params) {
		this.params = params;
	}
	public Object getReturnType() {
		return returnType;
	}
	public void setReturnType(String returnType) {
		this.returnType = returnType;
	}
	public String getFunctionDescrip() {
		return functionDescrip;
	}
	public void setFunctionDescrip(String functionDescrip) {
		this.functionDescrip = functionDescrip;
	}
	
	public String toString() {
		return name;
	}
	@Override
	public void mouseClicked(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void mousePressed(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void mouseReleased(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void mouseEntered(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void mouseExited(MouseEvent e) {
		System.out.println("asds");
		if (e.getSource() == this) {
			System.out.println("Boo!");
		}
		
	}
	
}
