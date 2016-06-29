package y.f.b;

import y.g.*;
import java.util.*;
import y.c.*;

public class c implements f
{
    private i g;
    private A h;
    private e i;
    public static int a;
    
    public c(final i g) {
        this.g = g;
        this.a();
    }
    
    protected void a() {
        final int a = c.a;
        y.c.c c = this.g.c(y.f.b.f.b);
        if (c == null) {
            c = new d(this);
        }
        y.c.c c2 = this.g.c(y.f.b.f.c);
        if (c2 == null) {
            c2 = q.a((Object)null);
        }
        y.c.c c3 = this.g.c(y.f.b.f.d);
        if (c3 == null) {
            c3 = q.a(Boolean.FALSE);
        }
        this.h = this.a(this.g);
        this.i = new e(null, new y());
        final HashMap<Object, y.c.q> hashMap = new HashMap<Object, y.c.q>();
        x x = this.g.o();
        while (true) {
            while (x.f()) {
                y.c.q q = x.e();
                final Object b;
                final Object o = b = c.b(q);
                if (a != 0) {
                    while (true) {
                        final y.c.q a2 = (y.c.q)b;
                        final e i = this.i(q);
                        this.a(this.i(a2), q);
                        i.a = a2;
                        if (a == 0) {
                            if (c3.d(q) && i.b == null) {
                                i.b = new y();
                            }
                            x.g();
                            if (a == 0) {
                                if (x.f()) {
                                    q = x.e();
                                    hashMap.get(c2.b(q));
                                    continue;
                                }
                            }
                            this.a(this.b(), this.i);
                        }
                        break;
                    }
                    return;
                }
                if (b == null) {
                    throw new IllegalArgumentException("no id defined for node " + q);
                }
                hashMap.put(o, q);
                x.g();
                if (a != 0) {
                    break;
                }
            }
            x = this.g.o();
            continue;
        }
    }
    
    private void a(final y.c.q q, final e e) {
        final int a = c.a;
        if (e.b == null) {
            return;
        }
        final HashMap<Object, p> hashMap = new HashMap<Object, p>();
        final HashMap<Object, p> hashMap2 = new HashMap<Object, p>();
        final y.c.f d = new y.c.f();
        final y.c.f c = new y.c.f();
        p p2 = e.b.k();
        while (true) {
            while (p2 != null) {
                final y.c.q q2 = (y.c.q)p2.c();
                Object o;
                final y.c.d d2 = (y.c.d)(o = q2.g());
                if (a != 0) {
                    e e3;
                    while (true) {
                        final e e2 = e3 = (e)o;
                        if (a == 0) {
                            p p7 = null;
                            Label_0487: {
                                Label_0482: {
                                    if (e3.d != null) {
                                        p p3 = e2.d.k();
                                        while (true) {
                                            while (p3 != null) {
                                                final y.c.d d3 = (y.c.d)p3.c();
                                                final p p5;
                                                final p p4 = p5 = hashMap2.get(d3);
                                                if (a != 0) {
                                                    p a2 = p5;
                                                    while (a2 != null) {
                                                        final y.c.d d4 = (y.c.d)a2.c();
                                                        final p p6 = p7 = hashMap.get(d4);
                                                        if (a != 0) {
                                                            break Label_0487;
                                                        }
                                                        Label_0470: {
                                                            if (p7 != null) {
                                                                d.h(p6);
                                                                hashMap.remove(d4);
                                                                if (a == 0) {
                                                                    break Label_0470;
                                                                }
                                                            }
                                                            hashMap2.put(d4, c.b(d4));
                                                        }
                                                        a2 = a2.a();
                                                        if (a != 0) {
                                                            break;
                                                        }
                                                    }
                                                    break Label_0482;
                                                }
                                                Label_0371: {
                                                    if (p5 != null) {
                                                        c.h(p4);
                                                        hashMap2.remove(d3);
                                                        if (a == 0) {
                                                            break Label_0371;
                                                        }
                                                    }
                                                    hashMap.put(d3, d.b(d3));
                                                }
                                                p3 = p3.a();
                                                if (a != 0) {
                                                    break;
                                                }
                                            }
                                            e2.c.k();
                                            continue;
                                        }
                                    }
                                }
                                p2.a();
                            }
                            p2 = p7;
                            if (a == 0) {
                                if (p2 != null) {
                                    o = this.h.b(p2.c());
                                    continue;
                                }
                            }
                            e.c = c;
                        }
                        break;
                    }
                    e3.d = d;
                    return;
                }
                y.c.d d5 = d2;
                y.c.q q4;
                y.c.q q3 = null;
                y.c.q q5 = null;
                y.c.q q6;
                Label_0104_Outer:Label_0143_Outer:
                while (true) {
                    while (true) {
                        while (true) {
                            Label_0158: {
                                Label_0136: {
                                    if (d5 == null) {
                                        break Label_0136;
                                    }
                                    q3 = (q4 = this.a(d5.c()));
                                    q5 = q;
                                    q6 = q;
                                    if (a != 0) {
                                        break Label_0158;
                                    }
                                    if (q4 != q6) {
                                        hashMap2.put(d5, c.b(d5));
                                    }
                                    d5 = d5.h();
                                    if (a == 0) {
                                        continue Label_0104_Outer;
                                    }
                                }
                                d5 = q2.f();
                                if (d5 == null) {
                                    break;
                                }
                                q3 = (q4 = this.a(d5.d()));
                                q5 = q;
                                q6 = q;
                            }
                            if (a != 0) {
                                continue Label_0143_Outer;
                            }
                            break;
                        }
                        if (q3 != q5) {
                            hashMap.put(d5, d.b(d5));
                        }
                        d5 = d5.g();
                        if (a != 0) {
                            break;
                        }
                        continue;
                    }
                }
                this.a(q2, (e)this.h.b(q2));
                p2 = p2.a();
                if (a != 0) {
                    break;
                }
            }
            p2 = e.b.k();
            continue;
        }
    }
    
    private void a(final e e, final y.c.q q) {
        if (e.b == null) {
            e.b = new y();
        }
        e.b.add(q);
    }
    
    private e i(final y.c.q q) {
        if (q == null) {
            return this.i;
        }
        e e = (e)this.h.b(q);
        if (e == null) {
            e = new e(null, null);
            this.h.a(q, e);
        }
        return e;
    }
    
    protected A a(final i i) {
        return i.t();
    }
    
    protected void a(final i i, final A a) {
        if (i != null && a != null) {
            i.a(a);
        }
    }
    
    public y.c.q a(final y.c.q q) {
        if (q == null) {
            throw new IllegalArgumentException("node is root!");
        }
        return ((e)this.h.b(q)).a;
    }
    
    public y.c.q b() {
        return null;
    }
    
    public y b(final y.c.q q) {
        return (q == null) ? this.i.b : ((e)this.h.b(q)).b;
    }
    
    public y c(final y.c.q q) {
        final y y = new y();
        this.a(q, y);
        return y;
    }
    
    private void a(final y.c.q q, final y y) {
        final int a = c.a;
        p p2 = ((e)((q == null) ? this.i : this.h.b(q))).b.k();
        while (p2 != null) {
            final y.c.q q2 = (y.c.q)p2.c();
            y.add(q2);
            if (this.d(q2)) {
                this.a(q2, y);
            }
            p2 = p2.a();
            if (a != 0) {
                break;
            }
        }
    }
    
    public boolean d(final y.c.q q) {
        return q == null || ((e)this.h.b(q)).b != null;
    }
    
    public boolean e(final y.c.q q) {
        return this.d(q) && !this.b(q).isEmpty();
    }
    
    public boolean a(final y.c.d d) {
        return this.a(d.c()) == this.a(d.d());
    }
    
    public y.c.f f(final y.c.q q) {
        return this.i(q).c;
    }
    
    public y.c.f g(final y.c.q q) {
        return this.i(q).d;
    }
    
    public y.c.q a(y.c.q q, final y.c.q q2) {
        final int a = c.a;
        if (q == null) {
            throw new IllegalArgumentException("no representative for virtual root!");
        }
        y.c.q q3 = this.a(q);
        y.c.q q4 = null;
        Label_0053: {
            while (q3 != q2) {
                q4 = q3;
                if (a != 0 || q4 == null) {
                    break Label_0053;
                }
                q = q3;
                q3 = this.a(q);
                if (a != 0) {
                    goto Label_0052;
                }
            }
            goto Label_0052;
        }
        if (q4 == null && q2 != null) {
            return null;
        }
        return q;
    }
    
    public void c() {
        this.a(this.g, this.h);
        this.g = null;
        this.h = null;
        this.i = null;
    }
    
    public static boolean b(final i i) {
        return i.c(y.f.b.f.d) != null && i.c(y.f.b.f.b) != null && i.c(y.f.b.f.c) != null;
    }
    
    public static boolean c(final i i) {
        final int a = c.a;
        if (!b(i)) {
            return true;
        }
        final y.c.c c = i.c(y.f.b.f.b);
        final y.c.c c2 = i.c(y.f.b.f.c);
        final HashSet set = new HashSet<Object>();
        x x = i.o();
        while (true) {
            while (x.f()) {
                set.add(c2.b(x.e()));
                final boolean contains = set.contains(c.b(x.e()));
                if (a != 0) {
                    boolean contains2 = false;
                    while (true) {
                        if (contains) {
                            contains2 = set.contains(c.b(x.e()));
                            if (a == 0) {
                                if (contains2) {
                                    return false;
                                }
                                x.g();
                                if (a == 0) {
                                    x.f();
                                    continue;
                                }
                            }
                        }
                        break;
                    }
                    return contains2;
                }
                if (contains) {
                    return false;
                }
                x.g();
                if (a != 0) {
                    break;
                }
            }
            x = i.o();
            continue;
        }
    }
    
    D h(final y.c.q q) {
        final int a = c.a;
        final D d = new D();
        y.c.q q2 = this.a(q);
        D d2 = null;
        while (q2 != null) {
            d2 = d;
            if (a != 0) {
                return d2;
            }
            d2.add(q2);
            q2 = this.a(q2);
            if (a != 0) {
                break;
            }
        }
        return d2;
    }
    
    public y.c.q b(final y.c.q q, final y.c.q q2) {
        final int a = c.a;
        if (q == q2) {
            return this.a(q);
        }
        if (q == null || q2 == null) {
            return null;
        }
        final int[] array = new int[q.e().e()];
        final D h = this.h(q);
        final D h2 = this.h(q2);
        final int[] array2 = array;
        final int d = q.d();
        ++array2[d];
        C c = h.m();
        while (true) {
            while (c.f()) {
                final Object d2 = c.d();
                y.c.q q3 = null;
                final boolean b = d2 instanceof y.c.q;
                if (a != 0) {
                    while (true) {
                        if (b) {
                            final Object d3 = c.d();
                            y.c.q q4 = null;
                            if (d3 instanceof y.c.q) {
                                q4 = (y.c.q)d3;
                            }
                            if (q4 != null && array[q4.d()] > 0) {
                                return q4;
                            }
                            c.g();
                            if (a == 0) {
                                c.f();
                                continue;
                            }
                        }
                        break;
                    }
                    return this.b();
                }
                if (b) {
                    q3 = (y.c.q)d2;
                }
                if (q3 != null) {
                    final int[] array3 = array;
                    final int d4 = q3.d();
                    ++array3[d4];
                }
                c.g();
                if (a != 0) {
                    break;
                }
            }
            c = h2.m();
            continue;
        }
    }
}
