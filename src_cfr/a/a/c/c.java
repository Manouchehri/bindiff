/*
 * Decompiled with CFR 0_115.
 */
package a.a.c;

import a.a.c.b;
import a.a.c.d;
import java.awt.RenderingHints;

final class c
extends RenderingHints.Key {
    private c() {
        super(0);
    }

    @Override
    public boolean isCompatibleValue(Object object) {
        if (object == null) return true;
        if (object instanceof d) return true;
        return false;
    }

    c(b b2) {
        this();
    }
}

