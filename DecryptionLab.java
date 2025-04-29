import java.lang.reflect.Method;

public class DecryptionLab {
    public static void main(String[] args) throws Exception {
        Class<?> clazz = Class.forName("MysteryToolbox");

        Object toolbox = clazz.getDeclaredConstructor().newInstance();

        // List methods
        Method[] methods = clazz.getDeclaredMethods();

        for (Method m : methods) {
            if (m.getParameterCount() == 1 && m.getParameterTypes()[0] == String.class) {
                String methodName = m.getName();
		System.out.println(methodName);
		String key;
		switch (methodName) {
    			case "hammer":
        			key = "aRTyWEy3RngEqgqq";
        			break;
    			case "screwdriver":
        			key = "kNYWIeNpFYlAOLPK";
        			break;
    			case "wrench":
        			key = "XI4i0C09PZ4rk6fY";
        			break;
    			case "glue":
        			key = "zYeoyfW2agYfeUmi";
        			break;
    			default:
        			key = "";
		}

                m.setAccessible(true); // not needed here but safe practice
                //TODO - you need to invoke the method to get the decrypted version!

		Object result = "This is not the unencrypted message!  See the TODO above";
				result = m.invoke(toolbox, key);
                System.out.println("🧰 " + methodName + ": " + result);
            }
        }
    }
}

