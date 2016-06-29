/*
 * Decompiled with CFR 0_115.
 */
package y.f.h.a;

import y.f.h.a.b;
import y.f.h.a.f;
import y.f.h.a.m;

class o {
    o a;
    o b;
    m c;

    o(m m2, o o2, o o3) {
        this.c = m2;
        this.a = o2;
        this.b = o3;
    }

    m a() {
        return this.c;
    }

    o a(o o2) {
        if (o2 == this.a) {
            return this.b;
        }
        if (o2 != this.b) throw new RuntimeException("Link not known!");
        return this.a;
    }

    void a(int n2, o o2) {
        if (n2 == 0) {
            this.a = o2;
            if (!b.g) return;
        }
        this.b = o2;
    }

    void a(o o2, o o3) {
        boolean bl2 = b.g;
        if (o2 == this.a) {
            this.a = o3;
            if (!bl2) return;
        }
        if (o2 != this.b) throw new RuntimeException("Link not known!");
        this.b = o3;
        if (!bl2) return;
        throw new RuntimeException("Link not known!");
    }

    o b() {
        if (this.a != null) {
            this.a.a(this, this.b);
        }
        if (this.b != null) {
            this.b.a(this, this.a);
        }
        this.a = null;
        this.b = null;
        return this;
    }

    void b(o o2, o o3) {
        boolean bl2 = b.g;
        if (o2 == this.a) {
            this.b.a(this, o3);
            o3.a(1, this.b);
            this.b = o3;
            o3.a(0, this);
            if (!bl2) return;
        }
        if (o2 != this.b) throw new RuntimeException("Link not known!");
        this.a.a(this, o3);
        o3.a(0, this.a);
        this.a = o3;
        o3.a(1, this);
        if (!bl2) return;
        throw new RuntimeException("Link not known!");
    }

    /*
     * Unable to fully structure code
     */
    void a(o var1_1, f var2_2) {
        var3_3 = b.g;
        if (var2_2.a() != false) return;
        if (var1_1 != this.a) ** GOTO lbl-1000
        this.b.a(this, var2_2.f());
        var2_2.c(this.b);
        this.b = var2_2.e();
        var2_2.d(this);
        if (var3_3) lbl-1000: // 2 sources:
        {
            if (var1_1 != this.b) throw new RuntimeException("Link not known!");
            this.a.a(this, var2_2.f());
            var2_2.c(this.a);
            this.a = var2_2.e();
            var2_2.d(this);
            if (var3_3) {
                throw new RuntimeException("Link not known!");
            }
        }
        var2_2.b();
    }
}

