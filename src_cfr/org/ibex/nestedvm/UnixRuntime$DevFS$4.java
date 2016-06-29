/*
 * Decompiled with CFR 0_115.
 */
package org.ibex.nestedvm;

import org.ibex.nestedvm.UnixRuntime$1;
import org.ibex.nestedvm.UnixRuntime$DevFS;
import org.ibex.nestedvm.UnixRuntime$DevFS$DevDirFD;

class UnixRuntime$DevFS$4
extends UnixRuntime$DevFS$DevDirFD {
    private final UnixRuntime$DevFS this$0;

    UnixRuntime$DevFS$4(UnixRuntime$DevFS unixRuntime$DevFS) {
        super(unixRuntime$DevFS, null);
        this.this$0 = unixRuntime$DevFS;
    }

    @Override
    public int myInode() {
        return 1;
    }

    @Override
    public int parentInode() {
        return 1;
    }

    @Override
    public int inode(int n2) {
        switch (n2) {
            case 0: {
                return 2;
            }
            case 1: {
                return 3;
            }
            case 2: {
                return 4;
            }
        }
        return -1;
    }

    @Override
    public String name(int n2) {
        switch (n2) {
            case 0: {
                return "null";
            }
            case 1: {
                return "zero";
            }
            case 2: {
                return "fd";
            }
        }
        return null;
    }

    @Override
    public int size() {
        return 3;
    }
}

