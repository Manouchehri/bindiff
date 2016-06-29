/*
 * Decompiled with CFR 0_115.
 */
package y.c;

import java.util.ArrayList;
import y.c.A;
import y.c.D;
import y.c.I;
import y.c.J;
import y.c.L;
import y.c.N;
import y.c.d;
import y.c.h;
import y.c.q;

class K {
    int a;
    int b;
    ArrayList c;
    ArrayList d;

    private K() {
    }

    K(int n2, int n3) {
        this.a = n2;
        this.b = n3;
        this.c = new ArrayList();
        int n4 = this.a - 1;
        do {
            if (n4 < 0) {
                this.d = new ArrayList();
                return;
            }
            this.c.add(new Integer(n4));
            --n4;
        } while (true);
    }

    private int a(L l2) {
        if (!this.c.isEmpty()) {
            return (Integer)this.c.remove(this.c.size() - 1);
        }
        this.a(l2, this.a, this.a + this.b);
        int n2 = this.a + this.b - 1;
        do {
            if (n2 <= this.a) {
                int n3 = this.a;
                this.a += this.b;
                return n3;
            }
            this.c.add(new Integer(n2));
            --n2;
        } while (true);
    }

    A a(L l2, String string) {
        int n2 = this.a(l2);
        J j2 = new J(n2, string, this);
        this.d.add(j2);
        this.a(l2, n2);
        return j2;
    }

    h b(L l2, String string) {
        int n2 = this.a(l2);
        N n3 = new N(n2, string, this);
        this.d.add(n3);
        this.a(l2, n2);
        return n3;
    }

    void a(L l2, int n2, int n3) {
        I i2 = l2.c();
        while (i2 != null) {
            Object[] arrobject = new Object[n3];
            System.arraycopy(i2.k, 0, arrobject, 0, n2);
            i2.k = arrobject;
            i2 = l2.a(i2);
        }
    }

    void a(I i2, int n2, int n3) {
        Object[] arrobject = new Object[n3];
        System.arraycopy(i2.k, 0, arrobject, 0, n2);
        i2.k = arrobject;
    }

    void a(L l2, int n2) {
        I i2 = l2.c();
        while (i2 != null) {
            i2.k[n2] = null;
            i2 = l2.a(i2);
        }
    }

    void a(A a2, L l2) {
        if (!(a2 instanceof J)) return;
        J j2 = (J)a2;
        if (j2.d != this) {
            throw new IllegalArgumentException("Map does not belong to this graph!");
        }
        if (j2.a()) {
            throw new IllegalStateException("Map has been already disposed !");
        }
        j2.b();
        int n2 = ((J)a2).a;
        if (this.c.contains(new Integer(n2))) return;
        this.a(l2, n2);
        this.c.add(new Integer(n2));
        this.d.remove(a2);
    }

    void a(h h2, L l2) {
        if (!(h2 instanceof N)) return;
        N n2 = (N)h2;
        if (n2.d != this) {
            throw new IllegalArgumentException("Map does not belong to this graph!");
        }
        if (n2.a()) {
            throw new IllegalStateException("Map has been already disposed !");
        }
        n2.b();
        int n3 = n2.a;
        if (this.c.contains(new Integer(n3))) return;
        this.a(l2, n3);
        this.c.add(new Integer(n3));
        this.d.remove(h2);
    }

    A[] a() {
        A[] arra;
        boolean bl2 = D.e;
        A[] arra2 = new A[this.d.size()];
        for (int i2 = 0; i2 < this.d.size(); ++i2) {
            arra = arra2;
            if (bl2) return arra;
            arra[i2] = (J)this.d.get(i2);
            if (!bl2) continue;
        }
        arra = arra2;
        return arra;
    }

    h[] b() {
        h[] arrh;
        boolean bl2 = D.e;
        h[] arrh2 = new h[this.d.size()];
        for (int i2 = 0; i2 < this.d.size(); ++i2) {
            arrh = arrh2;
            if (bl2) return arrh;
            arrh[i2] = (N)this.d.get(i2);
            if (!bl2) continue;
        }
        arrh = arrh2;
        return arrh;
    }

    void a(q q2, q q3) {
        boolean bl2 = D.e;
        int n2 = 0;
        do {
            if (n2 >= this.d.size()) return;
            int n3 = ((J)this.d.get((int)n2)).a;
            q3.k[n3] = q2.k[n3];
            ++n2;
        } while (!bl2);
    }

    void a(d d2, d d3) {
        boolean bl2 = D.e;
        int n2 = 0;
        do {
            if (n2 >= this.d.size()) return;
            int n3 = ((N)this.d.get((int)n2)).a;
            d3.k[n3] = d2.k[n3];
            ++n2;
        } while (!bl2);
    }

    K c() {
        K k2 = new K();
        k2.a = this.a;
        k2.b = this.b;
        k2.d = (ArrayList)this.d.clone();
        k2.c = (ArrayList)this.c.clone();
        return k2;
    }
}

