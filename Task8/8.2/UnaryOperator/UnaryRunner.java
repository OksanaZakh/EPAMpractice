package UnaryOperator;

import java.lang.reflect.*;

public class UnaryRunner {

    public void run() {
        Class myClass = null;
        try {
            myClass = Class.forName("UnaryOperator.UnaryOperator");
        } catch (ClassNotFoundException e) {
            e.getMessage();
        }
        System.out.println("Working with the class " + myClass.getName());

        getModifInfo(myClass);
        getFieldsInfo(myClass);
        getConstructorsInfo(myClass);
        getMethodsInfo(myClass);
        modifyInstance();
    }

    private void getModifInfo(Class myClass) {
        System.out.println("Modifier info:");
        int modifiers = myClass.getModifiers();
        if (Modifier.isPublic(modifiers)) {
            System.out.println("public");
        }
        if (Modifier.isStatic(modifiers)) {
            System.out.println("static");
        }
        if (Modifier.isFinal(modifiers)) {
            System.out.println("final");
        }
    }

    private void getFieldsInfo(Class myClass) {
        System.out.println("Fields info:");
        Field[] fields = myClass.getDeclaredFields();
        for (Field field : fields) {
            Class<?> fieldType = field.getType();
            System.out.println("\tName: " + field.getName());
            System.out.println("\tType: " + fieldType.getName());
        }
    }

    private void getConstructorsInfo(Class myClass) {
        System.out.println("Constructors info:");
        Constructor<?>[] constrs = myClass.getConstructors();
        int i = 0;
        for (Constructor<?> constructor : constrs) {
            System.out.print("Constructor " + (++i) + " : ");
            Class<?>[] paramTypes = constructor.getParameterTypes();
            for (Class<?> paramType : paramTypes) {
                System.out.print(paramType.getName() + " ");
            }
            System.out.println();
        }
    }

    private void getMethodsInfo(Class myClass) {
        System.out.println("Methods info:");
        Method[] methods = myClass.getDeclaredMethods();
        for (Method method : methods) {
            System.out.println("Name: " + method.getName());
            System.out.println("\tReturn type: "
                    + method.getReturnType().getName());
            Class<?>[] paramTypes = method.getParameterTypes();
            System.out.print("\tParam types:");
            for (Class<?> paramType : paramTypes) {
                System.out.print(paramType.getName() + " ");
            }
            System.out.println();
        }
    }

    public void modifyInstance() {
        System.out.println("Modifying instance called");
        UnaryOperator unaryOperator = new UnaryOperator(25.25);
        Class myClass = unaryOperator.getClass();
        System.out.println("Unary operator before any changes: " + unaryOperator.toString());
        try {
            Field field = myClass.getDeclaredField("num");
            field.setAccessible(true);
            field.set(unaryOperator, 101.1);
        } catch (NoSuchFieldException | IllegalAccessException e) {
            e.getMessage();
        }
        System.out.println("Unary operator after changing private field: " + unaryOperator.toString());

        try {
            Method method = myClass.getMethod("increment");
            method.invoke(unaryOperator);
        } catch (NoSuchMethodException | InvocationTargetException | IllegalAccessException e) {
            e.getMessage();
        }

        System.out.println("Unary operator after invocation of method: " + unaryOperator.toString());
    }

}
