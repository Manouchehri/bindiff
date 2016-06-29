/*
 * Decompiled with CFR 0_115.
 */
package y.f.i;

import y.c.i;
import y.c.q;
import y.d.m;
import y.d.t;
import y.f.X;
import y.f.am;
import y.f.i.R;
import y.f.i.v;

class W
extends R {
    private q a;
    private m b;

    W(q q2, byte by2) {
        super(1, 0.0);
        this.a = q2;
        am am2 = ((X)q2.e()).a(q2);
        t t2 = new t(am2.getX(), am2.getY());
        t t3 = new t(am2.getX() + am2.getWidth(), am2.getY());
        t t4 = new t(am2.getX(), am2.getY() + am2.getHeight());
        t t5 = new t(am2.getX() + am2.getWidth(), am2.getY() + am2.getHeight());
        if (by2 == 0) {
            this.a(1);
            this.b = new m(t3, t5);
            this.a(this.b.c().a());
            if (v.f == 0) return;
        }
        if (by2 != 1) return;
        this.a(2);
        this.b = new m(t2, t4);
        this.a(this.b.c().a());
    }

    public q a() {
        return this.a;
    }

    public m b() {
        return this.b;
    }

    public String toString() {
        String string;
        if (this.k() == 1) {
            string = "EAST";
            return new StringBuffer().append("Node: ").append(this.a().d()).append(", Side: ").append(string).toString();
        }
        string = "WEST";
        return new StringBuffer().append("Node: ").append(this.a().d()).append(", Side: ").append(string).toString();
    }
}

