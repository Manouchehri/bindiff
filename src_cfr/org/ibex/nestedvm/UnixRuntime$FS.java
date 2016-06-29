/*
 * Decompiled with CFR 0_115.
 */
package org.ibex.nestedvm;

import org.ibex.nestedvm.Runtime$FD;
import org.ibex.nestedvm.Runtime$FStat;
import org.ibex.nestedvm.UnixRuntime;
import org.ibex.nestedvm.UnixRuntime$GlobalState;

public abstract class UnixRuntime$FS {
    static final int OPEN = 1;
    static final int STAT = 2;
    static final int LSTAT = 3;
    static final int MKDIR = 4;
    static final int UNLINK = 5;
    UnixRuntime.GlobalState owner;
    int devno;

    Object dispatch(int n2, UnixRuntime unixRuntime, String string, int n3, int n4) {
        switch (n2) {
            case 1: {
                return this.open(unixRuntime, string, n3, n4);
            }
            case 2: {
                return this.stat(unixRuntime, string);
            }
            case 3: {
                return this.lstat(unixRuntime, string);
            }
            case 4: {
                this.mkdir(unixRuntime, string, n3);
                return null;
            }
            case 5: {
                this.unlink(unixRuntime, string);
                return null;
            }
        }
        throw new Error("should never happen");
    }

    public Runtime$FStat lstat(UnixRuntime unixRuntime, String string) {
        return this.stat(unixRuntime, string);
    }

    public abstract Runtime$FD open(UnixRuntime var1, String var2, int var3, int var4);

    public abstract Runtime$FStat stat(UnixRuntime var1, String var2);

    public abstract void mkdir(UnixRuntime var1, String var2, int var3);

    public abstract void unlink(UnixRuntime var1, String var2);
}

