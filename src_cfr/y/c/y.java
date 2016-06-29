/*
 * Decompiled with CFR 0_115.
 */
package y.c;

import java.util.Iterator;
import y.c.C;
import y.c.D;
import y.c.c;
import y.c.p;
import y.c.q;
import y.c.x;
import y.c.z;

public class y
extends D {
    public y() {
    }

    public y(x x2) {
        super(x2);
    }

    public y(x x2, c c2) {
        super(x2, c2);
    }

    public y(Iterator iterator) {
        super(iterator);
    }

    public y(q[] arrq) {
        boolean bl2 = D.e;
        int n2 = 0;
        do {
            if (n2 >= arrq.length) return;
            this.b(arrq[n2]);
            ++n2;
        } while (!bl2);
    }

    public y(q q2) {
        this.b(q2);
    }

    public y(y y2) {
        this(y2.a());
    }

    public x a() {
        return new z(this);
    }

    public q b() {
        return (q)this.f();
    }

    public q c() {
        return (q)this.i();
    }

    public q d() {
        return (q)this.g();
    }

    public q[] e() {
        return (q[])this.toArray(new q[this.size()]);
    }
}

