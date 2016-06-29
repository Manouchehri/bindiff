/*
 * Decompiled with CFR 0_115.
 */
package y.f.i.a;

import y.c.d;
import y.f.i.a.ab;
import y.f.i.a.bD;

class bE {
    private int a;
    private bD b;

    public bE(int n2) {
        this(n2, null);
    }

    public bE(int n2, bD bD2) {
        this.a = n2;
        this.b = bD2;
    }

    public int a() {
        return this.a;
    }

    public bD b() {
        return this.b;
    }

    public boolean c() {
        if (this.b == null) return false;
        return true;
    }

    public void a(bD bD2) {
        int n2 = ab.a;
        if (this.b == null) {
            this.b = bD2;
            if (n2 == 0) return;
        }
        if (bD2 == null) return;
        if (!this.b.a(bD2)) return;
        int n3 = this.b.c();
        int n4 = bD2.c();
        int n5 = Math.min(n3, n4);
        this.a += n5;
        if (n4 > n5) {
            this.b = new bD(bD.c(bD2), bD.d(bD2), bD.b(bD2), n4 - n5);
            if (n2 == 0) return;
        }
        if (n3 > n5) {
            this.b.a(n3 - n5);
            if (n2 == 0) return;
        }
        this.b = null;
    }
}

