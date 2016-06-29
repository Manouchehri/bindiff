/*
 * Decompiled with CFR 0_115.
 */
package y.g;

import java.lang.reflect.Constructor;
import y.g.a;

public class ah
extends a {
    private Class c;
    static Class b;

    public ah(Class class_) {
        super(class_);
        this.c = class_;
    }

    public ah(Class class_, Class class_2) {
        super(class_2);
        this.c = class_;
    }

    @Override
    protected Object a(String string) {
        try {
            Class[] arrclass = new Class[1];
            Class class_ = b == null ? (ah.b = ah.b("java.lang.String")) : b;
            arrclass[0] = class_;
            Constructor constructor = this.c.getConstructor(arrclass);
            return constructor.newInstance(string);
        }
        catch (Exception var2_3) {
            throw new IllegalArgumentException(new StringBuffer().append("Could not deserialize ").append(string).append(" ").append(var2_3).toString());
        }
    }

    @Override
    protected String a(Object object) {
        return object.toString();
    }

    static Class b(String string) {
        try {
            return Class.forName(string);
        }
        catch (ClassNotFoundException var1_1) {
            throw new NoClassDefFoundError(var1_1.getMessage());
        }
    }
}

