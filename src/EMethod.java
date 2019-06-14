import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.HashMap;

import javax.swing.JDialog;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

public class EMethod {
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
}
