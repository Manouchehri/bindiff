/*
 * Decompiled with CFR 0_115.
 */
package y.d.b;

import y.d.b.c;
import y.d.b.d;
import y.d.b.t;
import y.d.b.u;
import y.d.b.z;

public class b {
    protected u a;
    private z b;
    private z c;
    private z d;
    private double e;
    private double f;
    private double g;
    private int h;

    /*
     * Unable to fully structure code
     */
    public b(z var1_1, z var2_2, z var3_3, u var4_4) {
        super();
        if (var3_3.f(var3_3.a()) <= 0) ** GOTO lbl-1000
        this.b = var1_1;
        this.c = var2_2;
        this.d = var3_3;
        if (c.a != 0) lbl-1000: // 2 sources:
        {
            this.b = var1_1.d();
            this.c = var2_2.d();
            this.d = var3_3.d();
        }
        this.e = this.b.e();
        this.f = this.c.e();
        this.g = this.d.e();
        this.h = (int)(this.e + this.f + this.g);
        this.a = var4_4;
    }

    public b(z z2, z z3, u u2) {
        this(z2, z3, z2.b(), u2);
    }

    public b(z z2, z z3, z z4) {
        this(z2, z3, z4, d.a());
    }

    public final z a() {
        return this.b;
    }

    public final z b() {
        return this.c;
    }

    public final z c() {
        return this.d;
    }

    public final double d() {
        return this.e;
    }

    public final double e() {
        return this.f;
    }

    public final double f() {
        return this.g;
    }

    public final t a(b b2) {
        z z2 = this.b.c(b2.c()).b(b2.a().c(this.d));
        z z3 = this.c.c(b2.c()).b(b2.b().c(this.d));
        z z4 = this.d.c(b2.c());
        return new t(z2, z3, z4);
    }

    public final void g() {
        z z2 = this.b.e(this.c);
        z2 = z2.e(this.d);
        this.b = this.b.d(z2);
        this.c = this.c.d(z2);
        this.d = this.d.d(z2);
        this.e = this.b.e();
        this.f = this.c.e();
        this.g = this.d.e();
    }

    public final boolean equals(Object object) {
        if (object == this) {
            return true;
        }
        if (!(object instanceof b)) {
            return false;
        }
        b b2 = (b)object;
        z z2 = this.b.c(b2.c()).b(b2.a().c(this.d));
        z z3 = this.c.c(b2.c()).b(b2.b().c(this.d));
        if (z2.c() != 0) return false;
        if (z3.c() != 0) return false;
        return true;
    }

    public int hashCode() {
        return this.h;
    }

    public String toString() {
        return new StringBuffer().append("X: ").append(this.b).append(" Y: ").append(this.c).append(" W: ").append(this.d).toString();
    }
}

