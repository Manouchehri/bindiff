/*
 * Decompiled with CFR 0_115.
 */
package a.a.a;

import a.a.a.c;
import java.lang.reflect.Method;

final class e
extends c {
    private e(Class class_, Method[] arrmethod) {
        super(class_, arrmethod);
    }

    static e a() {
        String[] arrstring = new String[]{"getCenterPoint", "getRadius", "getFocusPoint", "getFractions", "getColors"};
        try {
            Class class_ = Class.forName("java.awt.RadialGradientPaint");
            Method[] arrmethod = new Method[arrstring.length];
            int n2 = 0;
            while (n2 < arrstring.length) {
                arrmethod[n2] = class_.getMethod(arrstring[n2], a);
                ++n2;
            }
            return new e(class_, arrmethod);
        }
        catch (ClassNotFoundException var2_2) {
            return new e(null, null);
        }
        catch (NoSuchMethodException var2_3) {
            return new e(null, null);
        }
    }
}

