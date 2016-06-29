/*
 * Decompiled with CFR 0_115.
 */
package y.f.c.a;

import y.c.q;
import y.f.c.a.N;
import y.f.c.a.bz;

class bG {
    private q a;
    private q b;

    private bG() {
    }

    public void a(q q2) {
        if (this.a != null) throw new RuntimeException("Proxy already set!");
        this.a = q2;
        if (!N.x) return;
        throw new RuntimeException("Proxy already set!");
    }

    public void b(q q2) {
        if (this.b != null) throw new RuntimeException("Proxy already set!");
        this.b = q2;
        if (!N.x) return;
        throw new RuntimeException("Proxy already set!");
    }

    public q a() {
        return this.a;
    }

    public q b() {
        return this.b;
    }

    bG(bz bz2) {
        this();
    }
}

