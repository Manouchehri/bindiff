/*
 * Decompiled with CFR 0_115.
 */
package org.ibex.nestedvm;

import java.io.File;

public class Runtime$SecurityManager {
    public boolean allowRead(File file) {
        return true;
    }

    public boolean allowWrite(File file) {
        return true;
    }

    public boolean allowStat(File file) {
        return true;
    }

    public boolean allowUnlink(File file) {
        return true;
    }
}

