package y.c;

import java.util.*;

class K
{
    int a;
    int b;
    ArrayList c;
    ArrayList d;
    
    private K() {
    }
    
    K(final int a, final int b) {
        this.a = a;
        this.b = b;
        this.c = new ArrayList();
        for (int i = this.a - 1; i >= 0; --i) {
            this.c.add(new Integer(i));
        }
        this.d = new ArrayList();
    }
    
    private int a(final L l) {
        int n;
        if (this.c.isEmpty()) {
            this.a(l, this.a, this.a + this.b);
            for (int i = this.a + this.b - 1; i > this.a; --i) {
                this.c.add(new Integer(i));
            }
            n = this.a;
            this.a += this.b;
        }
        else {
            n = this.c.remove(this.c.size() - 1);
        }
        return n;
    }
    
    A a(final L l, final String s) {
        final int a = this.a(l);
        final J j = new J(a, s, this);
        this.d.add(j);
        this.a(l, a);
        return j;
    }
    
    h b(final L l, final String s) {
        final int a = this.a(l);
        final N n = new N(a, s, this);
        this.d.add(n);
        this.a(l, a);
        return n;
    }
    
    void a(final L l, final int n, final int n2) {
        for (I i = l.c(); i != null; i = l.a(i)) {
            final Object[] k = new Object[n2];
            System.arraycopy(i.k, 0, k, 0, n);
            i.k = k;
        }
    }
    
    void a(final I i, final int n, final int n2) {
        final Object[] k = new Object[n2];
        System.arraycopy(i.k, 0, k, 0, n);
        i.k = k;
    }
    
    void a(final L l, final int n) {
        for (I i = l.c(); i != null; i = l.a(i)) {
            i.k[n] = null;
        }
    }
    
    void a(final A a, final L l) {
        if (a instanceof J) {
            final J j = (J)a;
            if (j.d != this) {
                throw new IllegalArgumentException("Map does not belong to this graph!");
            }
            if (j.a()) {
                throw new IllegalStateException("Map has been already disposed !");
            }
            j.b();
            final int a2 = ((J)a).a;
            if (!this.c.contains(new Integer(a2))) {
                this.a(l, a2);
                this.c.add(new Integer(a2));
                this.d.remove(a);
            }
        }
    }
    
    void a(final h h, final L l) {
        if (h instanceof N) {
            final N n = (N)h;
            if (n.d != this) {
                throw new IllegalArgumentException("Map does not belong to this graph!");
            }
            if (n.a()) {
                throw new IllegalStateException("Map has been already disposed !");
            }
            n.b();
            final int a = n.a;
            if (!this.c.contains(new Integer(a))) {
                this.a(l, a);
                this.c.add(new Integer(a));
                this.d.remove(h);
            }
        }
    }
    
    A[] a() {
        final boolean e = D.e;
        final A[] array = new A[this.d.size()];
        int i = 0;
        A[] array2 = null;
        while (i < this.d.size()) {
            array2 = array;
            if (e) {
                return array2;
            }
            array2[i] = this.d.get(i);
            ++i;
            if (e) {
                break;
            }
        }
        return array2;
    }
    
    h[] b() {
        final boolean e = D.e;
        final h[] array = new h[this.d.size()];
        int i = 0;
        h[] array2 = null;
        while (i < this.d.size()) {
            array2 = array;
            if (e) {
                return array2;
            }
            array2[i] = this.d.get(i);
            ++i;
            if (e) {
                break;
            }
        }
        return array2;
    }
    
    void a(final q q, final q q2) {
        final boolean e = D.e;
        int i = 0;
        while (i < this.d.size()) {
            final int a = this.d.get(i).a;
            q2.k[a] = q.k[a];
            ++i;
            if (e) {
                break;
            }
        }
    }
    
    void a(final d d, final d d2) {
        final boolean e = D.e;
        int i = 0;
        while (i < this.d.size()) {
            final int a = this.d.get(i).a;
            d2.k[a] = d.k[a];
            ++i;
            if (e) {
                break;
            }
        }
    }
    
    K c() {
        final K k = new K();
        k.a = this.a;
        k.b = this.b;
        k.d = (ArrayList)this.d.clone();
        k.c = (ArrayList)this.c.clone();
        return k;
    }
}
