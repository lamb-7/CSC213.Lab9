import java.lang.reflect.*;


public class Reflector {
    public static void main(String[] args) throws Exception {
	
	// Note - we only have the .class file - not the original source code! But that does not stop
	// us from getting some human readable information about what methods are in there!
	// You can even call or invoke these methods - though that is what you will need to do in the lab!

        // changed this
        Class<?> clazz = Class.forName("StudentGadget");

        Object toolbox = clazz.getDeclaredConstructor().newInstance();
        Method launchMethod = clazz.getDeclaredMethod("launch", String.class);
        // Class<?> clazz = StudentGadget.class;

        System.out.println("🔎 Inspecting class: " + clazz.getName());
        System.out.println("\n📋 Methods Found:\n");

        Method[] methods = clazz.getDeclaredMethods();

        // added here
        launchMethod.invoke(toolbox, "U9r1IESzvyqFiLpQ");

        for (Method method : methods) {
            int mod = method.getModifiers();
            System.out.println("🛠 Method: " + method.getName());
            System.out.println("   ↳ Modifiers: " + Modifier.toString(mod));
            System.out.println("   ↳ Return Type: " + method.getReturnType().getSimpleName());

            Class<?>[] paramTypes = method.getParameterTypes();
            System.out.print("   ↳ Parameters: ");
            if (paramTypes.length == 0) {
                System.out.print("none");
            } else {
                for (Class<?> p : paramTypes) {
                    System.out.print(p.getSimpleName() + " ");
                }
            }
            System.out.println("\n");
        }
    }
}

