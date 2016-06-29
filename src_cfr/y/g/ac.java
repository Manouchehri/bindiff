/*
 * Decompiled with CFR 0_115.
 */
package y.g;

import y.g.X;
import y.g.a;

final class ac
extends a {
    ac() {
        Class class_ = X.p == null ? (X.p = X.a("java.lang.Class")) : X.p;
        super(class_);
    }

    @Override
    protected Object a(String string) {
        try {
            return Class.forName(string, false, this.getClass().getClassLoader());
        }
        catch (ClassNotFoundException var2_3) {
            throw new IllegalArgumentException(new StringBuffer().append("Did not find class ").append(string).toString());
        }
        catch (Exception var2_4) {
            throw new IllegalArgumentException(new StringBuffer().append("Could not load class").append(string).toString());
        }
    }

    @Override
    protected String a(Object object) {
        return ((Class)object).getName();
    }
}

