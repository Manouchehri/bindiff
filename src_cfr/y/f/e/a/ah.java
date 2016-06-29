/*
 * Decompiled with CFR 0_115.
 */
package y.f.e.a;

import y.c.d;
import y.c.q;
import y.f.e.a.Z;
import y.f.e.a.a;
import y.f.e.a.af;
import y.f.e.a.ag;
import y.f.e.a.aq;

public class ah
implements aq {
    private double a;
    private d b;
    private ag c;
    private ag d;
    private a e;
    private final af f;

    ah(af af2, d d2) {
        this.f = af2;
        this.a = 50.0;
        this.e = new Z();
        this.b = d2;
        this.c = af2.c(d2.c());
        this.d = af2.c(d2.d());
    }

    @Override
    public double a() {
        return this.a;
    }

    @Override
    public double b() {
        return this.c.h() + this.d.h() + this.a;
    }

    public void a(double d2) {
        this.a = d2;
    }
}

