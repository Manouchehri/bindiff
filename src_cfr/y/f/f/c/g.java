/*
 * Decompiled with CFR 0_115.
 */
package y.f.f.c;

import java.util.Iterator;
import y.c.D;
import y.c.q;

public class g {
    private q b;
    private int c;
    private short d;
    private g e;
    private g f;
    private D g;
    private int h;
    private int i = 0;
    private int j = 0;
    public static int a;

    public g(q q2, int n2, short s2) {
        this.b = q2;
        this.c = n2;
        this.d = s2;
        this.g = new D();
    }

    public void a(q q2) {
        this.g.add(q2);
    }

    public q a() {
        return this.b;
    }

    public int b() {
        return this.c;
    }

    public short c() {
        return this.d;
    }

    public void a(g g2, g g3) {
        this.e = g2;
        this.f = g3;
    }

    public g d() {
        return this.e;
    }

    public g e() {
        return this.f;
    }

    public q f() {
        return (q)this.g.f();
    }

    public q g() {
        return (q)this.g.i();
    }

    public D h() {
        return this.g;
    }

    public void a(int n2) {
        this.h = n2;
    }

    public int i() {
        return this.h;
    }

    public String toString() {
        String string;
        int n2 = a;
        StringBuffer stringBuffer = new StringBuffer();
        String string2 = "";
        Iterator iterator = this.g.iterator();
        while (iterator.hasNext()) {
            stringBuffer.append(string2);
            stringBuffer.append(iterator.next());
            string = "-";
            if (n2 != 0) return string;
            string2 = string;
            if (n2 == 0) continue;
        }
        string = stringBuffer.toString();
        return string;
    }

    public int j() {
        return this.i;
    }

    public int k() {
        return this.j;
    }

    public void b(int n2) {
        this.i = n2;
    }

    public void c(int n2) {
        this.j = n2;
    }
}

