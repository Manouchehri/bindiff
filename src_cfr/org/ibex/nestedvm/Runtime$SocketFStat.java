/*
 * Decompiled with CFR 0_115.
 */
package org.ibex.nestedvm;

import org.ibex.nestedvm.Runtime$FStat;

public class Runtime$SocketFStat
extends Runtime$FStat {
    @Override
    public int dev() {
        return -1;
    }

    @Override
    public int type() {
        return 49152;
    }

    @Override
    public int inode() {
        return this.hashCode() & 32767;
    }
}

