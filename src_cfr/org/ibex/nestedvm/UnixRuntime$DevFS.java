/*
 * Decompiled with CFR 0_115.
 */
package org.ibex.nestedvm;

import org.ibex.nestedvm.Runtime$ErrnoException;
import org.ibex.nestedvm.Runtime$FD;
import org.ibex.nestedvm.Runtime$FStat;
import org.ibex.nestedvm.UnixRuntime;
import org.ibex.nestedvm.UnixRuntime$DevFS$1;
import org.ibex.nestedvm.UnixRuntime$DevFS$2;
import org.ibex.nestedvm.UnixRuntime$DevFS$3;
import org.ibex.nestedvm.UnixRuntime$DevFS$4;
import org.ibex.nestedvm.UnixRuntime$DevFS$5;
import org.ibex.nestedvm.UnixRuntime$DevFS$6;
import org.ibex.nestedvm.UnixRuntime$FS;

public class UnixRuntime$DevFS
extends UnixRuntime$FS {
    private static final int ROOT_INODE = 1;
    private static final int NULL_INODE = 2;
    private static final int ZERO_INODE = 3;
    private static final int FD_INODE = 4;
    private static final int FD_INODES = 32;
    private Runtime$FD devZeroFD;
    private Runtime$FD devNullFD;

    public UnixRuntime$DevFS() {
        this.devZeroFD = new UnixRuntime$DevFS$1(this);
        this.devNullFD = new UnixRuntime$DevFS$2(this);
    }

    @Override
    public Runtime$FD open(UnixRuntime unixRuntime, String string, int n2, int n3) {
        if (string.equals("null")) {
            return this.devNullFD;
        }
        if (string.equals("zero")) {
            return this.devZeroFD;
        }
        if (string.startsWith("fd/")) {
            int n4;
            try {
                n4 = Integer.parseInt(string.substring(4));
            }
            catch (NumberFormatException var6_7) {
                return null;
            }
            if (n4 < 0) return null;
            if (n4 >= 64) {
                return null;
            }
            if (unixRuntime.fds[n4] != null) return unixRuntime.fds[n4].dup();
            return null;
        }
        if (!string.equals("fd")) {
            if (!string.equals("")) return null;
            return new UnixRuntime$DevFS$4(this);
        }
        int n5 = 0;
        for (int i2 = 0; i2 < 64; ++i2) {
            if (unixRuntime.fds[i2] == null) continue;
            ++n5;
        }
        int[] arrn = new int[n5];
        n5 = 0;
        int n6 = 0;
        while (n6 < 64) {
            if (unixRuntime.fds[n6] != null) {
                arrn[n5++] = n6;
            }
            ++n6;
        }
        return new UnixRuntime$DevFS$3(this, arrn);
    }

    @Override
    public Runtime$FStat stat(UnixRuntime unixRuntime, String string) {
        if (string.equals("null")) {
            return this.devNullFD.fstat();
        }
        if (string.equals("zero")) {
            return this.devZeroFD.fstat();
        }
        if (string.startsWith("fd/")) {
            int n2;
            try {
                n2 = Integer.parseInt(string.substring(3));
            }
            catch (NumberFormatException var4_4) {
                return null;
            }
            if (n2 < 0) return null;
            if (n2 >= 64) {
                return null;
            }
            if (unixRuntime.fds[n2] != null) return unixRuntime.fds[n2].fstat();
            return null;
        }
        if (string.equals("fd")) {
            return new UnixRuntime$DevFS$5(this);
        }
        if (!string.equals("")) return null;
        return new UnixRuntime$DevFS$6(this);
    }

    @Override
    public void mkdir(UnixRuntime unixRuntime, String string, int n2) {
        throw new Runtime$ErrnoException(30);
    }

    @Override
    public void unlink(UnixRuntime unixRuntime, String string) {
        throw new Runtime$ErrnoException(30);
    }
}

