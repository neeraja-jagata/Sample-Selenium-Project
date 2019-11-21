package reflectionsApiEg;
import java.lang.reflect.Method;

import propertiesFileTest.*;
public class ReflectApiTest {

	public static void main(String[] args) {
		Way2AutomationTest obj= new Way2AutomationTest();
		Class className= obj.getClass();
		System.out.println(className.getName());
		System.out.println(className.getMethods().length);
		for(Method m:className.getMethods()){
			System.out.println(" "+m.getReturnType().getSimpleName()+" "+m.getName());
		}
		

	}

}
