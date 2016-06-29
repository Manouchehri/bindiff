package y.d;

import java.util.*;
import y.c.*;

public final class v
{
    public static final v a;
    D b;
    
    public v() {
        this.b = new D();
    }
    
    public v(final List list) {
        final boolean d = t.d;
        this.b = new D();
        if (list != null && !list.isEmpty()) {
            final Iterator<Object> iterator = list.iterator();
            while (iterator.hasNext()) {
                this.b.add(iterator.next());
                if (d) {
                    break;
                }
            }
        }
    }
    
    public v(final t[] array) {
        if (array == null) {
            this.b = new D();
            if (!t.d) {
                return;
            }
        }
        this.b = new D(array);
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
        final boolean d = t.d;
        final ArrayList<Object> list = new ArrayList<Object>(this.b.size());
        final C a = this.a();
        ArrayList<Object> list2 = null;
        while (a.f()) {
            list2 = list;
            if (d) {
                return list2;
            }
            list2.add(a.d());
            a.g();
            if (d) {
                break;
            }
        }
        return list2;
    }
    
    public t[] f() {
        final boolean d = t.d;
        final t[] array = new t[this.b.size()];
        int n = 0;
        final C a = this.a();
        t[] array2 = null;
        while (a.f()) {
            array2 = array;
            if (d) {
                return array2;
            }
            array2[n++] = (t)a.d();
            a.g();
            if (d) {
                break;
            }
        }
        return array2;
    }
    
    public v g() {
        final boolean d = t.d;
        final ArrayList<Object> list = new ArrayList<Object>();
        final C a = this.a();
        while (a.f()) {
            list.add(0, a.d());
            a.g();
            if (d) {
                break;
            }
        }
        return new v(list);
    }
    
    public int h() {
        return this.b.size();
    }
    
    public int i() {
        final int size = this.b.size();
        return (size > 0) ? (size - 1) : 0;
    }
    
    public s j() {
        return new x(this.b());
    }
    
    public m a(final int n) {
        if (n + 1 >= this.b.size()) {
            return null;
        }
        final t t = (t)this.b.a(n);
        final t t2 = (t)this.b.a(n + 1);
        if (t == null || t2 == null) {
            return null;
        }
        return new m(t, t2);
    }
    
    public String toString() {
        final boolean d = t.d;
        final StringBuffer sb = new StringBuffer();
        sb.append("YPointPath:\n");
        final C a = this.a();
        while (a.f()) {
            final StringBuffer append = sb.append(((t)a.d()).toString() + "\n");
            if (d) {
                return append.toString();
            }
            a.g();
            if (d) {
                break;
            }
        }
        final StringBuffer append = sb;
        return append.toString();
    }
    
    public double k() {
        final boolean d = t.d;
        if (this.b.size() > 1) {
            t t = (t)this.b.f();
            double n = 0.0;
            p p = this.b.k().a();
            double n2 = 0.0;
            while (p != null) {
                final t t2 = (t)p.c();
                n2 = n + y.d.t.a(t, t2);
                if (d) {
                    return n2;
                }
                n = n2;
                t = t2;
                p = p.a();
                if (d) {
                    break;
                }
            }
            return n2;
        }
        return 0.0;
    }
    
    static {
        a = new v();
    }
}
