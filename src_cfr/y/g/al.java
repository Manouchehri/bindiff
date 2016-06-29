/*
 * Decompiled with CFR 0_115.
 */
package y.g;

import y.g.p;

public class al {
    private long a;
    private long b;
    private boolean c = true;

    public al() {
        this(true);
    }

    public al(boolean bl2) {
        if (!bl2) return;
        this.a();
    }

    public void a() {
        if (!this.c) return;
        this.a = this.f();
        this.c = false;
    }

    public void b() {
        if (this.c) return;
        this.b += this.f() - this.a;
        this.c = true;
    }

    public void c() {
        if (this.c) {
            this.a();
            if (!p.c) return;
        }
        this.b();
    }

    public long d() {
        if (!this.c) return this.b + this.f() - this.a;
        return this.b;
    }

    public final void e() {
        this.b = 0;
        this.a = this.f();
    }

    public final String toString() {
        long l2 = this.d();
        long l3 = l2 / 60000;
        long l4 = (l2 -= 60000 * l3) / 1000;
        long l5 = l2 -= 1000 * l4;
        String string = "";
        string = new StringBuffer().append(string).append(l3).append(" Minutes ").toString();
        string = new StringBuffer().append(string).append(l4).append(" Seconds ").toString();
        return new StringBuffer().append(string).append(l5).append(" Millisec.").toString();
    }

    private long f() {
        return System.currentTimeMillis();
    }
}

