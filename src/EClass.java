import java.lang.reflect.Method;
import java.lang.reflect.Field;

public class EClass {
	private String name;
	private EClass parentClass;
	private EClass[] childClasses;
	private Object classType;
	private Method[] methods;
	private Field[] fields;
	
	
	public EClass(String name, EClass parentClass, EClass[] childClasses, Object classType,
				  Method[] methods, Field[] fields) {
		this.setName(name);
		this.setParentClass(parentClass);
		this.setChildClasses(childClasses);
		this.setClassType(classType);
		this.setMethods(methods);
		this.setFields(fields);
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


	public EClass[] getChildClasses() {
		return childClasses;
	}


	public void setChildClasses(EClass[] childClasses) {
		this.childClasses = childClasses;
	}


	public Object getClassType() {
		return classType;
	}


	public void setClassType(Object classType) {
		this.classType = classType;
	}


	public Method[] getMethods() {
		return methods;
	}


	public void setMethods(Method[] methods) {
		this.methods = methods;
	}


	public Field[] getFields() {
		return fields;
	}


	public void setFields(Field[] fields) {
		this.fields = fields;
	}
}
