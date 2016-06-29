/*
 * Decompiled with CFR 0_115.
 */
package org.jfree.util;

public class BooleanUtilities {
    private BooleanUtilities() {
    }

    public static Boolean valueOf(boolean bl2) {
        Boolean bl3;
        if (bl2) {
            bl3 = Boolean.TRUE;
            return bl3;
        }
        bl3 = Boolean.FALSE;
        return bl3;
    }
}

