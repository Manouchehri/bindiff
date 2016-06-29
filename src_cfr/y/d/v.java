/*
 * Decompiled with CFR 0_115.
 */
package y.d;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import y.c.C;
import y.c.D;
import y.c.p;
import y.d.m;
import y.d.s;
import y.d.t;
import y.d.u;
import y.d.w;
import y.d.x;

public final class v {
    public static final v a = new v();
    D b;

    public v() {
        this.b = new D();
    }

    public v(List list) {
        boolean bl2 = t.d;
        this.b = new D();
        if (list == null) return;
        if (list.isEmpty()) return;
        Iterator iterator = list.iterator();
        do {
            if (!iterator.hasNext()) return;
            this.b.add(iterator.next());
        } while (!bl2);
    }

    public v(t[] arrt) {
        if (arrt == null) {
            this.b = new D();
            if (!t.d) return;
        }
        this.b = new D(arrt);
    }

    public C a() {
        return this.b.m();
    }

    public u b() {
        return new w(this.b.m());
    }

    public t c() {
        return (t)this.b.f();
    }

    public t d() {
        return (t)this.b.i();
    }

    public List e() {
        ArrayList<Object> arrayList;
        boolean bl2 = t.d;
        ArrayList<Object> arrayList2 = new ArrayList<Object>(this.b.size());
        C c2 = this.a();
        while (c2.f()) {
            arrayList = arrayList2;
            if (bl2) return arrayList;
            arrayList.add(c2.d());
            c2.g();
            if (!bl2) continue;
        }
        arrayList = arrayList2;
        return arrayList;
    }

    public t[] f() {
        t[] arrt;
        boolean bl2 = t.d;
        t[] arrt2 = new t[this.b.size()];
        int n2 = 0;
        C c2 = this.a();
        while (c2.f()) {
            arrt = arrt2;
            if (bl2) return arrt;
            arrt[n2++] = (t)c2.d();
            c2.g();
            if (!bl2) continue;
        }
        arrt = arrt2;
        return arrt;
    }

    public v g() {
        boolean bl2 = t.d;
        ArrayList<Object> arrayList = new ArrayList<Object>();
        C c2 = this.a();
        do {
            if (!c2.f()) return new v(arrayList);
            arrayList.add(0, c2.d());
            c2.g();
        } while (!bl2);
        return new v(arrayList);
    }

    public int h() {
        return this.b.size();
    }

    public int i() {
        int n2 = this.b.size();
        if (n2 <= 0) return 0;
        int n3 = n2 - 1;
        return n3;
    }

    public s j() {
        return new x(this.b());
    }

    public m a(int n2) {
        if (n2 + 1 >= this.b.size()) {
            return null;
        }
        t t2 = (t)this.b.a(n2);
        t t3 = (t)this.b.a(n2 + 1);
        if (t2 == null) return null;
        if (t3 != null) return new m(t2, t3);
        return null;
    }

    public String toString() {
        StringBuffer stringBuffer;
        boolean bl2 = t.d;
        StringBuffer stringBuffer2 = new StringBuffer();
        stringBuffer2.append("YPointPath:\n");
        C c2 = this.a();
        while (c2.f()) {
            t t2 = (t)c2.d();
            stringBuffer = stringBuffer2.append(new StringBuffer().append(t2.toString()).append("\n").toString());
            if (bl2) return stringBuffer.toString();
            c2.g();
            if (!bl2) continue;
        }
        stringBuffer = stringBuffer2;
        return stringBuffer.toString();
    }

    public double k() {
        double d2;
        boolean bl2 = t.d;
        if (this.b.size() <= 1) return 0.0;
        t t2 = (t)this.b.f();
        double d3 = 0.0;
        for (p p2 = this.b.k().a(); p2 != null; p2 = p2.a()) {
            t t3 = (t)p2.c();
            d2 = d3 + t.a(t2, t3);
            if (bl2) return d2;
            d3 = d2;
            t2 = t3;
            if (!bl2) continue;
        }
        d2 = d3;
        return d2;
    }
}

