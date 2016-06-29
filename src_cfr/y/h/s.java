/*
 * Decompiled with CFR 0_115.
 */
package y.h;

import java.awt.RenderingHints;
import y.h.C;
import y.h.T;
import y.h.bu;

final class S
extends RenderingHints.Key {
    public static final RenderingHints.Key a = new S();

    protected S() {
        super(1764);
    }

    @Override
    public boolean isCompatibleValue(Object object) {
        if (object instanceof T) return true;
        if (object == null) return true;
        return false;
    }

    public static Object a(bu bu2, C c2) {
        return new T(bu2, c2);
    }
}

