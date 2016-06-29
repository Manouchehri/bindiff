/*
 * Decompiled with CFR 0_115.
 */
package y.f.i.a;

import y.f.i.a.Y;
import y.f.i.a.ab;

class W
extends Y {
    private int a = 10;
    private long b;
    private long c;
    private long d;
    private long e;
    private long f;
    private final long g;
    private long h;

    W(long l2, long l3) {
        this.c = this.b = 50;
        this.d = this.e = l2;
        this.f = l3;
        this.g = l3 - l2;
    }

    @Override
    protected boolean a(long l2) {
        long l3;
        block2 : {
            if (l2 != this.c) return false;
            this.h = l2;
            l3 = System.currentTimeMillis();
            long l4 = l3 - this.d;
            long l5 = Math.max((long)this.a, (this.f - l3) / 2);
            if (l4 == 0) {
                this.b *= l5;
                if (ab.a == 0) break block2;
            }
            this.b = Math.max(1, (long)((double)l5 / (double)l4 * (double)this.b));
        }
        this.c = l2 + this.b;
        this.d = l3;
        if (l3 < this.f) return false;
        this.f = l3 + this.g;
        return true;
    }
}

