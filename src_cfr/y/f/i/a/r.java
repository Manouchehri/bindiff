/*
 * Decompiled with CFR 0_115.
 */
package y.f.i.a;

import java.util.HashMap;
import y.d.y;
import y.f.i.a.P;
import y.f.i.a.Q;
import y.f.i.a.S;
import y.f.i.a.bc;

public class R {
    private static int a = 0;
    private final int b;
    private final Q c;
    private final HashMap d;
    private final y e;
    private bc f;
    private HashMap g;

    public R(y y2, Q q2) {
        this.e = y2;
        this.b = a++;
        this.c = q2;
        this.d = new HashMap();
    }

    public R(double d2, double d3, double d4, double d5, Q q2) {
        this(new y(d2, d3, d4, d5), q2);
    }

    public Object a(Object object, Object object2) {
        return this.d.put(object, object2);
    }

    public Object a(Object object) {
        return this.d.get(object);
    }

    public void a() {
        this.d.clear();
    }

    bc b() {
        return this.f;
    }

    void a(bc bc2) {
        this.f = bc2;
    }

    HashMap c() {
        return this.g;
    }

    void a(HashMap hashMap) {
        this.g = hashMap;
    }

    public Q d() {
        return this.c;
    }

    public int e() {
        return this.b;
    }

    static void f() {
        a = 0;
    }

    public y g() {
        return this.e;
    }

    public double h() {
        return this.e.c();
    }

    public double i() {
        return this.e.d();
    }

    public double j() {
        return this.e.c() + this.e.a();
    }

    public double k() {
        return this.e.d() + this.e.b();
    }

    public double l() {
        return this.e.a();
    }

    public double m() {
        return this.e.b();
    }

    public P a(S s2) {
        if (s2 == S.a) {
            return new P(this.h(), this.j(), this.i(), false);
        }
        if (s2 == S.b) {
            return new P(this.h(), this.j(), this.k(), false);
        }
        if (s2 == S.d) {
            return new P(this.i(), this.k(), this.h(), true);
        }
        if (s2 != S.c) return null;
        return new P(this.i(), this.k(), this.j(), true);
    }
}

