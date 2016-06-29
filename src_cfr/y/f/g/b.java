/*
 * Decompiled with CFR 0_115.
 */
package y.f.g;

import y.c.D;
import y.c.p;
import y.d.c;
import y.f.am;
import y.f.c.a.Z;
import y.f.c.a.aY;
import y.f.c.a.bK;
import y.f.g.C;
import y.f.g.E;
import y.f.g.d;

class B
extends E
implements C {
    D a;
    c[] b;
    final Z c;

    B(aY aY2, bK bK2, Z z2) {
        super(aY2, bK2);
        if (z2 == null) {
            z2 = Z.a;
        }
        this.c = z2;
    }

    @Override
    public Z c() {
        return this.c;
    }

    @Override
    public byte b() {
        return 0;
    }

    @Override
    public p d() {
        if (this.a == null) return null;
        p p2 = this.a.k();
        return p2;
    }

    @Override
    public int e() {
        if (this.a == null) return 0;
        int n2 = this.a.size();
        return n2;
    }

    @Override
    public c a(int n2, am am2) {
        boolean bl2 = d.d;
        if (this.b == null) {
            this.b = new c[4];
        }
        if (this.b[n2] != null) return this.b[n2];
        switch (n2) {
            case 0: {
                this.b[n2] = new c(0.0, am2.getWidth(), 0.0);
                if (!bl2) return this.b[n2];
            }
            case 1: {
                this.b[n2] = new c(0.0, am2.getHeight(), am2.getWidth());
                if (!bl2) return this.b[n2];
            }
            case 2: {
                this.b[n2] = new c(0.0, am2.getWidth(), am2.getHeight());
                if (!bl2) return this.b[n2];
            }
            case 3: {
                this.b[n2] = new c(0.0, am2.getHeight(), 0.0);
            }
        }
        return this.b[n2];
    }

    @Override
    public c a(int n2) {
        if (this.b != null) return this.b[n2];
        return null;
    }
}

