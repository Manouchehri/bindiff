/*
 * Decompiled with CFR 0_115.
 */
package y.f.f.d;

import y.c.C;
import y.c.D;
import y.c.d;
import y.f.f.c.g;
import y.f.f.d.o;

public class p {
    private D a = new D();

    public p() {
    }

    public p(g g2) {
        this();
        this.a(g2);
    }

    public void a(g g2) {
        this.a.add(g2);
    }

    public C a() {
        return this.a.m();
    }

    public g b() {
        C c2 = this.a();
        return (g)c2.d();
    }

    public static void a(y.f.f.c.p p2, p p3, p p4, int n2) {
        boolean bl2 = o.p;
        C c2 = p3.a();
        block0 : do {
            if (!c2.f()) return;
            g g2 = (g)c2.d();
            C c3 = p4.a();
            while (c3.f()) {
                g g3 = (g)c3.d();
                p2.a(g2, g3, n2);
                c3.g();
                if (bl2) continue block0;
                if (!bl2) continue;
            }
            c2.g();
        } while (!bl2);
    }

    public String toString() {
        StringBuffer stringBuffer;
        boolean bl2 = o.p;
        StringBuffer stringBuffer2 = new StringBuffer();
        C c2 = this.a();
        while (c2.f()) {
            g g2 = (g)c2.d();
            stringBuffer = stringBuffer2.append(new StringBuffer().append(g2.toString()).append("  ").toString());
            if (bl2) return stringBuffer.toString();
            c2.g();
            if (!bl2) continue;
        }
        stringBuffer = stringBuffer2;
        return stringBuffer.toString();
    }
}

