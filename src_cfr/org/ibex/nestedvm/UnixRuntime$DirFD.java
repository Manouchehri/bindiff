/*
 * Decompiled with CFR 0_115.
 */
package org.ibex.nestedvm;

import org.ibex.nestedvm.Runtime;
import org.ibex.nestedvm.Runtime$FD;
import org.ibex.nestedvm.Runtime$FStat;
import org.ibex.nestedvm.UnixRuntime;
import org.ibex.nestedvm.UnixRuntime$DirFD$1;

public abstract class UnixRuntime$DirFD
extends Runtime$FD {
    private int pos = -2;

    protected abstract int size();

    protected abstract String name(int var1);

    protected abstract int inode(int var1);

    protected abstract int myDev();

    protected abstract int parentInode();

    protected abstract int myInode();

    @Override
    public int flags() {
        return 0;
    }

    /*
     * Unable to fully structure code
     */
    @Override
    public int getdents(byte[] var1_1, int var2_2, int var3_3) {
        var4_4 = var2_2;
        while (var3_3 > 0) {
            if (this.pos >= this.size()) return var2_2 - var4_4;
            switch (this.pos) {
                case -2: 
                case -1: {
                    v0 = var5_5 = this.pos == -1 ? this.parentInode() : this.myInode();
                    if (var5_5 != -1) {
                        var6_6 = 9 + (this.pos == -1 ? 2 : 1);
                        if (var6_6 > var3_3) {
                            return var2_2 - var4_4;
                        }
                        var1_1[var2_2 + 8] = 46;
                        if (this.pos != -1) break;
                        var1_1[var2_2 + 9] = 46;
                        break;
                    }
                    ** GOTO lbl30
                }
                default: {
                    var7_7 = this.name(this.pos);
                    var8_8 = Runtime.getBytes(var7_7);
                    var6_6 = var8_8.length + 9;
                    if (var6_6 > var3_3) {
                        return var2_2 - var4_4;
                    }
                    var5_5 = this.inode(this.pos);
                    System.arraycopy(var8_8, 0, var1_1, var2_2 + 8, var8_8.length);
                }
            }
            var1_1[var2_2 + var6_6 - 1] = 0;
            var6_6 = var6_6 + 3 & -4;
            UnixRuntime.access$500(var1_1, var2_2, var6_6);
            UnixRuntime.access$500(var1_1, var2_2 + 4, var5_5);
            var2_2 += var6_6;
            var3_3 -= var6_6;
lbl30: // 2 sources:
            ++this.pos;
        }
        return var2_2 - var4_4;
    }

    @Override
    protected Runtime$FStat _fstat() {
        return new UnixRuntime$DirFD$1(this);
    }
}

