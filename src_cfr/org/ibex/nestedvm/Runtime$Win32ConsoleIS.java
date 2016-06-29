/*
 * Decompiled with CFR 0_115.
 */
package org.ibex.nestedvm;

import java.io.InputStream;

class Runtime$Win32ConsoleIS
extends InputStream {
    private int pushedBack = -1;
    private final InputStream parent;

    public Runtime$Win32ConsoleIS(InputStream inputStream) {
        this.parent = inputStream;
    }

    @Override
    public int read() {
        if (this.pushedBack != -1) {
            int n2 = this.pushedBack;
            this.pushedBack = -1;
            return n2;
        }
        int n3 = this.parent.read();
        if (n3 != 13) return n3;
        n3 = this.parent.read();
        if (n3 == 10) return n3;
        this.pushedBack = n3;
        return 13;
    }

    @Override
    public int read(byte[] arrby, int n2, int n3) {
        int n4;
        int n5;
        boolean bl2 = false;
        if (this.pushedBack != -1 && n3 > 0) {
            arrby[0] = (byte)this.pushedBack;
            this.pushedBack = -1;
            ++n2;
            --n3;
            bl2 = true;
        }
        if ((n4 = this.parent.read(arrby, n2, n3)) == -1) {
            if (!bl2) return -1;
            return 1;
        }
        for (int i2 = 0; i2 < n4; ++i2) {
            if (arrby[n2 + i2] != 13) continue;
            if (i2 == n4 - 1) {
                int n6 = this.parent.read();
                if (n6 == 10) {
                    arrby[n2 + i2] = 10;
                    continue;
                }
                this.pushedBack = n6;
                continue;
            }
            if (arrby[n2 + i2 + 1] != 10) continue;
            System.arraycopy(arrby, n2 + i2 + 1, arrby, n2 + i2, n3 - i2 - 1);
            --n4;
        }
        if (bl2) {
            n5 = 1;
            return n4 + n5;
        }
        n5 = 0;
        return n4 + n5;
    }
}

