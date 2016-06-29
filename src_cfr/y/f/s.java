/*
 * Decompiled with CFR 0_115.
 */
package y.f;

import y.d.n;
import y.d.t;
import y.d.y;
import y.f.U;
import y.f.X;
import y.f.aG;

public class S
implements U {
    private n c;
    private aG d;

    public S(n n2) {
        this(n2, 0);
    }

    public S(n n2, byte by2) {
        this(n2, aG.g(by2));
    }

    public S(n n2, aG aG2) {
        this.a(n2);
        this.a(aG2);
    }

    public void a(n n2) {
        this.c = n2;
    }

    public n a() {
        return this.c;
    }

    public double b() {
        return this.c.h().a();
    }

    public double c() {
        return this.c.h().b();
    }

    public void a(double d2, double d3) {
        t t2 = this.c.h().e();
        this.c.d(d2 - t2.a, d3 - t2.b);
    }

    public double d() {
        return this.c.h().c();
    }

    public double e() {
        return this.c.h().d();
    }

    public void a(aG aG2) {
        if (aG2 == null) {
            throw new IllegalArgumentException("null");
        }
        this.d = aG2;
    }

    public aG f() {
        return this.d;
    }

    public String toString() {
        return new StringBuffer().append(this.a().toString()).append(" ").append(this.g()).toString();
    }

    private String g() {
        boolean bl2 = X.j;
        byte by2 = this.d.a();
        if (by2 == 0) {
            return S.a(by2);
        }
        String string = "";
        StringBuffer stringBuffer = new StringBuffer();
        byte[] arrby = new byte[]{1, 2, 4};
        int n2 = 0;
        int n3 = arrby.length;
        do {
            if (n2 >= n3) return stringBuffer.toString();
            if ((by2 & arrby[n2]) == arrby[n2]) {
                stringBuffer.append(string).append(S.a(arrby[n2]));
                string = "|";
            }
            ++n2;
        } while (!bl2);
        return stringBuffer.toString();
    }

    private static String a(byte by2) {
        switch (by2) {
            case 0: {
                return "PLACE_ANYWHERE";
            }
            case 1: {
                return "PLACE_AT_SOURCE";
            }
            case 2: {
                return "PLACE_AT_TARGET";
            }
            case 4: {
                return "PLACE_AT_CENTER";
            }
        }
        return new StringBuffer().append("ILLEGAL_PLACEMENT: ").append(by2).toString();
    }
}

