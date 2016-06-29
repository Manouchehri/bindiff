package a.a.a;

import java.lang.reflect.*;

final class e extends c
{
    private e(final Class clazz, final Method[] array) {
        super(clazz, array);
    }
    
    static e a() {
        final String[] array = { "getCenterPoint", "getRadius", "getFocusPoint", "getFractions", "getColors" };
        try {
            final Class<?> forName = Class.forName("java.awt.RadialGradientPaint");
            final Method[] array2 = new Method[array.length];
            for (int i = 0; i < array.length; ++i) {
                array2[i] = forName.getMethod(array[i], (Class[])e.a);
            }
            return new e(forName, array2);
        }
        catch (ClassNotFoundException ex) {
            return new e(null, null);
        }
        catch (NoSuchMethodException ex2) {
            return new e(null, null);
        }
    }
}
