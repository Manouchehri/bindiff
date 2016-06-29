/*
 * Decompiled with CFR 0_115.
 */
package a.a.a;

import a.a.a.c;
import java.lang.reflect.Method;

final class d
extends c {
    private d(Class class_, Method[] arrmethod) {
        super(class_, arrmethod);
    }

    static d a() {
        String[] arrstring = new String[]{"getStartPoint", "getEndPoint", "getFractions", "getColors"};
        try {
            Class class_ = Class.forName("java.awt.LinearGradientPaint");
            Method[] arrmethod = new Method[arrstring.length];
            int n2 = 0;
            while (n2 < arrstring.length) {
                arrmethod[n2] = class_.getMethod(arrstring[n2], a);
                ++n2;
            }
            return new d(class_, arrmethod);
        }
        catch (ClassNotFoundException var2_2) {
            return new d(null, null);
        }
        catch (NoSuchMethodException var2_3) {
            return new d(null, null);
        }
    }
}

