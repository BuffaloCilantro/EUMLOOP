import java.lang.reflect.Method;
import java.lang.reflect.Field;
import java.util.ArrayList;

public class EClass {
	private String name;
	private EClass parentClass;
//	private EClass[] childClasses;
	private ArrayList<Field> fields = new ArrayList<Field>();
	private ArrayList<EMethod> methods = new ArrayList<EMethod>();
	
	
	public EClass(String name, EClass parentClass, 
//				  EClass[] childClasses, 
				  ArrayList<Field> fields, ArrayList<EMethod> methods) {
		this.setName(name);
		this.setParentClass(parentClass);
//		this.setChildClasses(childClasses);
		this.setFields(fields);
		this.setMethods(methods);
	}

	public String getName() {
		return name;
	}


	public void setName(String name) {
		this.name = name;
	}


	public EClass getParentClass() {
		return parentClass;
	}


	public void setParentClass(EClass parentClass) {
		this.parentClass = parentClass;
	}


//	public EClass[] getChildClasses() {
//		return childClasses;
//	}
//
//
//	public void setChildClasses(EClass[] childClasses) {
//		this.childClasses = childClasses;
//	}


	public ArrayList<EMethod> getMethods() {
		return methods;
	}

	public void setMethods(ArrayList<EMethod> methods) {
		this.methods = methods;
	}

	public ArrayList<Field> getFields() {
		return fields;
	}

	public void setFields(ArrayList<Field> fields) {
		this.fields = fields;
	}
}