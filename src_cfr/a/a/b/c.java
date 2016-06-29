/*
 * Decompiled with CFR 0_115.
 */
package a.a.b;

import a.a.b.a;
import a.a.b.b;
import java.awt.RenderingHints;

final class c
extends RenderingHints.Key {
    private c() {
        super(0);
    }

    @Override
    public boolean isCompatibleValue(Object object) {
        if (object == null) return true;
        if (object instanceof a) return true;
        return false;
    }

    c(b b2) {
        this();
    }
}

