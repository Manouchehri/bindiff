/*
 * Decompiled with CFR 0_115.
 */
package org.ibex.nestedvm;

import org.ibex.nestedvm.UnixRuntime$1;
import org.ibex.nestedvm.UnixRuntime$DevFS;
import org.ibex.nestedvm.UnixRuntime$DevFS$DevDirFD;

class UnixRuntime$DevFS$3
extends UnixRuntime$DevFS$DevDirFD {
    private final int[] val$files;
    private final UnixRuntime$DevFS this$0;

    UnixRuntime$DevFS$3(UnixRuntime$DevFS unixRuntime$DevFS, int[] arrn) {
        super(unixRuntime$DevFS, null);
        this.this$0 = unixRuntime$DevFS;
        this.val$files = arrn;
    }

    @Override
    public int myInode() {
        return 4;
    }

    @Override
    public int parentInode() {
        return 1;
    }

    @Override
    public int inode(int n2) {
        return 32 + n2;
    }

    @Override
    public String name(int n2) {
        return Integer.toString(this.val$files[n2]);
    }

    @Override
    public int size() {
        return this.val$files.length;
    }
}

