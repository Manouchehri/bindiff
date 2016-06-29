/*
 * Decompiled with CFR 0_115.
 */
package y.f.f.c;

import y.c.A;
import y.c.i;
import y.c.q;
import y.c.x;
import y.d.t;
import y.f.f.b.h;
import y.f.f.c.b;
import y.f.f.c.f;
import y.f.f.c.g;
import y.f.f.c.l;
import y.f.f.c.p;
import y.g.al;

public class r {
    private h a;
    private f b;
    private l c;
    private int d = 3;
    private boolean e = false;
    private int f = 0;
    private int g = 0;
    private int h = 0;
    private int i = 0;

    public void a(h h2) {
        this.a = h2;
    }

    public void a(l l2) {
        this.c = l2;
    }

    public void a(f f2) {
        this.b = f2;
    }

    public void a(int n2) {
        this.d = n2;
    }

    public void a(boolean bl2) {
        this.e = bl2;
    }

    public void a(A a2) {
        Object object;
        int n2 = g.a;
        al al2 = new al();
        p p2 = new p(0, this.a);
        p p3 = new p(1, this.a);
        this.f = (int)al2.d();
        al2.e();
        if (this.b != null) {
            this.b.a(this.a, p2, p3);
            this.g = (int)al2.d();
            al2.e();
        }
        this.c.a(this.a, p2, p3);
        this.h = (int)al2.d();
        al2.e();
        if (this.d != 3) {
            object = new b();
            object.a(this.d);
            object.a(this.a, p2, p3);
            this.i = (int)al2.d();
        }
        object = this.a.a().o();
        while (object.f()) {
            q q2 = object.e();
            int n3 = p3.a(q2).i();
            int n4 = p2.a(q2).i();
            a2.a((Object)q2, new t(n4, n3));
            object.g();
            if (n2 != 0) return;
            if (n2 == 0) continue;
        }
        p3.c();
        p2.c();
    }

    public int a() {
        return this.f;
    }

    public int b() {
        return this.g;
    }

    public int c() {
        return this.h;
    }

    public int d() {
        return this.i;
    }
}

