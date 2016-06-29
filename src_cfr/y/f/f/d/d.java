/*
 * Decompiled with CFR 0_115.
 */
package y.f.f.d;

import y.c.d;
import y.c.e;
import y.c.f;
import y.f.f.d.o;

public class D {
    private f a = new f();
    private int b;
    private Integer c = new Integer(10);

    public void a(Integer n2) {
        this.c = n2;
    }

    public Integer a() {
        return this.c;
    }

    public void a(int n2) {
        this.b = n2;
    }

    public int b() {
        return this.b;
    }

    public void a(d d2) {
        this.a.add(d2);
    }

    public e c() {
        return this.a.a();
    }

    public int d() {
        return this.a.size() - 2;
    }

    public String toString() {
        boolean bl2 = o.p;
        String string = "";
        e e2 = this.c();
        do {
            if (!e2.f()) return new StringBuffer().append(string).append("=").append(this.b).append("[").append(this.c).append("]").toString();
            string = new StringBuffer().append(string).append(e2.a()).append(" ").toString();
            e2.g();
            if (bl2) return string;
        } while (!bl2);
        return new StringBuffer().append(string).append("=").append(this.b).append("[").append(this.c).append("]").toString();
    }
}

