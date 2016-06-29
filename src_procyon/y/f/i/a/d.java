package y.f.i.a;

import java.util.*;

class d
{
    private e[] a;
    private int b;
    private int c;
    private Comparator d;
    
    public d(final int c, final Comparator d) {
        this.a = new e[c + 2];
        this.b = 0;
        this.c = c;
        this.d = d;
    }
    
    public List a() {
        final int a = ab.a;
        final ArrayList<Object> list = new ArrayList<Object>();
        int i = 0;
        ArrayList<Object> list2 = null;
        while (i < this.b) {
            list2 = list;
            if (a != 0) {
                return list2;
            }
            list2.add(this.a[i].a);
            ++i;
            if (a != 0) {
                break;
            }
        }
        return list2;
    }
    
    public e a(final Object o, final Object o2) {
        if (this.b == this.c) {
            this.c += 1024;
            final e[] a = new e[this.c + 2];
            System.arraycopy(this.a, 0, a, 0, this.a.length);
            this.a = a;
        }
        ++this.b;
        final e e = new e(o, o2, this.b);
        this.a(this.b, e);
        return e;
    }
    
    public void b() {
        final int a = ab.a;
        int i = this.a.length - 1;
        while (i >= 0) {
            this.a[i] = null;
            --i;
            if (a != 0) {
                return;
            }
            if (a != 0) {
                break;
            }
        }
        this.b = 0;
    }
    
    void a(int n, final e e) {
        final int a = ab.a;
        this.a[0] = e;
        int n2 = n / 2;
        e e2 = this.a[n2];
        while (this.d.compare(e2.b, e.b) > 0) {
            this.a[n] = e2;
            e2.c = n;
            n = n2;
            n2 >>= 1;
            e2 = this.a[n2];
            if (a != 0) {
                return;
            }
            if (a != 0) {
                break;
            }
        }
        this.a[n] = e;
        e.c = n;
    }
    
    void b(int n, final e e) {
        final int a = ab.a;
        int i = n << 1;
        this.a[this.b + 1] = this.a[this.b];
        while (i <= this.b) {
            e e2 = this.a[i];
            if (a != 0) {
                return;
            }
            if (i < this.b && this.d.compare(this.a[i + 1].b, e2.b) < 0) {
                e2 = this.a[++i];
            }
            if (this.d.compare(e.b, e2.b) <= 0) {
                break;
            }
            this.a[n] = e2;
            e2.c = n;
            n = i;
            i <<= 1;
            if (a != 0) {
                break;
            }
        }
        this.a[n] = e;
        e.c = n;
    }
    
    public void a(final e e) {
        final e e2 = this.a[this.b];
        this.a[this.b] = null;
        --this.b;
        if (e != e2) {
            if (this.d.compare(e2.b, e.b) > 0) {
                this.b(e.c, e2);
                if (ab.a == 0) {
                    return;
                }
            }
            this.a(e.c, e2);
        }
    }
    
    public void a(final e e, final Object b) {
        e.b = b;
        this.a(e.c, e);
    }
    
    public void b(final e e, final Object o) {
        if (this.d.compare(o, e.b) < 0) {
            this.a(e, o);
            if (ab.a == 0) {
                return;
            }
        }
        this.c(e, o);
    }
    
    public void c(final e e, final Object b) {
        e.b = b;
        this.b(e.c, e);
    }
    
    public e c() {
        return this.a[1];
    }
    
    public boolean d() {
        return this.b == 0;
    }
}
