/*
 * Decompiled with CFR 0_115.
 */
package y.h;

import java.awt.RenderingHints;
import y.h.gH;

final class gG
extends RenderingHints.Key {
    gG() {
        super(443556);
    }

    @Override
    public final boolean isCompatibleValue(Object object) {
        return object instanceof gH;
    }
}

