package framework;

import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import framework.parta.Before;
import framework.partc.Inject;
import framework.partc.Service;
import org.reflections.Reflections;

public class FWContext {

	private static List<Object> objectMap = new ArrayList<>();

	public FWContext() {
		try {
			// find and instantiate all classes annotated with the @TestClass annotation
			Reflections reflections = new Reflections("");
			Set<Class<?>> testclasses = reflections.getTypesAnnotatedWith(TestClass.class);
			for (Class<?> implementationClass : testclasses) {
				objectMap.add((Object) implementationClass.newInstance());
			}

			Set<Class<?>> serviceClasses = reflections.getTypesAnnotatedWith(Service.class);
			for (Class<?> implementationClass : serviceClasses) {
				objectMap.add((Object) implementationClass.newInstance());
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		performDI();
	}

	public void start() {
		try {
			for (Object theTestClass : objectMap) {
				// find all methods annotated with the @Test annotation
				for (Method method : theTestClass.getClass().getDeclaredMethods()) {
					if (method.isAnnotationPresent(Test.class)) {
						// calling @Before method
						callBeforeMethod(theTestClass);
						method.invoke(theTestClass);
					}
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	private static void callBeforeMethod(Object testObject){
		try{
			for(Method method : testObject.getClass().getDeclaredMethods()){
				if(method.isAnnotationPresent(Before.class)){
					method.invoke(testObject);
				}
			}
		}catch (Exception ex){
			ex.printStackTrace();
		}
	}

	private static void performDI(){
		try{
			for(Object theTestClass : objectMap){
				for(Field field : theTestClass.getClass().getDeclaredFields()){
					if(field.isAnnotationPresent(Inject.class)){
						Class<?> fieldType = field.getType();
						Object instance = getBeanOftype(fieldType);
						field.setAccessible(true);
						field.set(theTestClass, instance);
					}
				}
			}
		}catch (Exception ex){
			ex.printStackTrace();
		}
	}

	public static Object getBeanOftype(Class interfaceClass){
		Object object = null;
		try{
			for(Object theTestClass : objectMap){
				Class<?>[] interfaces = theTestClass.getClass().getInterfaces();
				for(Class<?> interace : interfaces){
					if(interace.getName().contentEquals(interfaceClass.getName())){
						object = theTestClass;
					}
				}
			}
		}catch (Exception ex){
			ex.printStackTrace();
		}
		return object;
	}
}
