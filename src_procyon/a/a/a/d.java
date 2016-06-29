package a.a.a;

import java.lang.reflect.*;

final class d extends c
{
    private d(final Class clazz, final Method[] array) {
        super(clazz, array);
    }
    
    static d a() {
        final String[] array = { "getStartPoint", "getEndPoint", "getFractions", "getColors" };
        try {
            final Class<?> forName = Class.forName("java.awt.LinearGradientPaint");
            final Method[] array2 = new Method[array.length];
            for (int i = 0; i < array.length; ++i) {
                array2[i] = forName.getMethod(array[i], (Class[])d.a);
            }
            return new d(forName, array2);
        }
        catch (ClassNotFoundException ex) {
            return new d(null, null);
        }
        catch (NoSuchMethodException ex2) {
            return new d(null, null);
        }
    }
}
