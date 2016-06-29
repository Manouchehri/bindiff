package y.h.a;

import y.h.*;
import y.c.*;
import java.util.*;

public class v
{
    private static final Collection b;
    private Map c;
    private Map d;
    private Map e;
    private z f;
    private o g;
    private m h;
    private Vector i;
    private K j;
    private i k;
    private Map l;
    private Map m;
    private A n;
    private A o;
    private q p;
    private int q;
    private c r;
    private c s;
    private c t;
    public static int a;
    
    public v(final i i) {
        this(i, new y.h.a.c());
    }
    
    public v(final i i, final m h) {
        final int a = v.a;
        this.r = new I();
        this.s = new C(this);
        this.t = new H(this);
        this.d = new WeakHashMap();
        this.e = new WeakHashMap();
        this.c = new WeakHashMap();
        this.f = new z(this, i, null);
        this.c.put(i, this.f);
        this.g = new B(this);
        this.i = new Vector();
        this.h = h;
        this.j = new d();
        Label_0207: {
            if (i instanceof bu) {
                ((bu)i).a(this);
                if (a == 0) {
                    break Label_0207;
                }
                y.c.i.g = !y.c.i.g;
            }
            synchronized (v.b) {
                v.b.add(this);
            }
        }
        this.k = new i();
        this.l = new WeakHashMap();
        this.m = new WeakHashMap();
        this.n = this.k.t();
        this.o = this.k.t();
        this.p = this.k.d();
        this.l.put(i, this.p);
        this.m.put(null, this.p);
        this.q = 0;
        this.k.a(new w(this));
        i.a(this.g);
        final x o = i.o();
        while (o.f()) {
            final q e = o.e();
            final q q = this.l.get(i);
            final q d = this.k.d();
            this.m.put(e, d);
            this.n.a(d, e);
            this.k.a(d, q);
            o.g();
            if (a != 0) {
                break;
            }
        }
    }
    
    public static v a(final i i) {
        if (i instanceof bu) {
            return ((bu)i).C();
        }
        synchronized (v.b) {
            for (final v v : v.b) {
                if (v.d(i)) {
                    return v;
                }
            }
        }
        return null;
    }
    
    public q a(final q q) {
        int a = v.a;
        i i;
        if (q == null) {
            i = this.g();
        }
        else if (this.j(q)) {
            i = this.m(q);
        }
        else {
            i = q.e();
        }
        final i h = this.h(i);
        if (h instanceof bu) {
            ((bu)h).a(this);
        }
        final q a2 = this.h.a(i, h);
        this.a(new t(this, (byte)6, i, a2));
        final z z = new z(this, h, a2);
        this.c.put(h, z);
        this.e.put(a2, z);
        final q q2 = this.m.get(a2);
        this.l.put(h, q2);
        this.a(new t(this, (byte)4, i, a2));
        if (this.k(q)) {
            this.c(new y(a2), q);
        }
        this.k.a(q2.f(), null, q2.f().d().g(), 0, 1);
        final q q3 = a2;
        if (y.c.i.g) {
            v.a = ++a;
        }
        return q3;
    }
    
    public q b(final i i) {
        return this.a(this.e(i));
    }
    
    public q b(final q q) {
        i i;
        if (q == null) {
            i = this.g();
        }
        else if (this.j(q)) {
            i = this.m(q);
        }
        else {
            i = q.e();
        }
        final q a = this.h.a(i, q);
        this.c(a);
        if (this.k(q)) {
            this.c(new y(a), q);
        }
        return a;
    }
    
    public q c(final i i) {
        return this.b(this.e(i));
    }
    
    public void c(final q q) {
        final i e = q.e();
        y y = null;
        final boolean j = this.j(q);
        if (j) {
            y = new y(this.m(q).o());
            this.a(this.m(q), y);
            this.g(q);
        }
        this.a(new t(this, (byte)6, q.e(), q));
        final q q2 = this.m.get(q);
        if (!this.o.d(q2)) {
            this.o.a(q2, true);
        }
        this.a(new t(this, (byte)4, e, q));
        if (j) {
            this.c(y, q);
        }
        this.k.a(q2.f(), null, q2.f().d().g(), 0, 1);
    }
    
    public y.c.d a(final q q, final q q2) {
        final i e = q.e();
        final i e2 = q2.e();
        if (e == null || e2 == null) {
            throw new IllegalArgumentException("Not all endpoints lie in a graph.");
        }
        if (e == e2) {
            return e.a(q, q2);
        }
        final i a = this.a(e, e2);
        if (a == null) {
            throw new IllegalArgumentException("No common ancestor found.");
        }
        final y.c.d a2 = a.a(this.a(q, a), this.a(q2, a));
        this.b(a2, q, q2);
        return a2;
    }
    
    public void a(final y.c.d d, final q a, final q b) {
        final int a2 = v.a;
        final i a3 = d.a();
        if (a3 != null && !this.d(a3)) {
            throw new IllegalArgumentException("Edge not in graph hierarchy.");
        }
        final i e = a.e();
        final i e2 = b.e();
        if (e == null || e2 == null) {
            throw new IllegalArgumentException("Not all endpoints lie in a graph.");
        }
        if (this.e(d)) {
            if (e == e2) {
                this.b(e, a3);
                this.a(d);
                this.a(a3, e, d, a, b);
                this.c(a3, e);
                if (a2 == 0) {
                    return;
                }
            }
            final i a4 = this.a(e, e2);
            if (a4 == null) {
                throw new IllegalArgumentException("No common ancestor found.");
            }
            this.b(a4, a3);
            final E f = this.f(d);
            final q a5 = this.a(a, a4);
            final q a6 = this.a(b, a4);
            this.a(d);
            this.a(a3, a4, d, a5, a6);
            f.a = a;
            f.b = b;
            this.a(d, (byte)7);
            this.d.put(d, f);
            this.a(d, (byte)5);
            this.c(a3, a4);
            if (a2 == 0) {
                return;
            }
        }
        if (e == e2) {
            this.b(e, a3);
            this.a(a3, e, d, a, b);
            this.c(a3, e);
            if (a2 == 0) {
                return;
            }
        }
        final i a7 = this.a(e, e2);
        if (a7 == null) {
            throw new IllegalArgumentException("No common ancestor found.");
        }
        this.b(a7, a3);
        this.a(a3, a7, d, this.a(a, a7), this.a(b, a7));
        this.b(d, a, b);
        this.c(a3, a7);
    }
    
    private void a(final i i, final i j, final y.c.d d, final q q, final q q2) {
        if (i != j && i != null) {
            i.a(d);
        }
        j.a(d, q, q2);
        if (i != j && i != null) {
            j.b(d);
        }
    }
    
    private void b(final i i, final i j) {
        if (i != null) {
            i.r();
        }
        if (j != null) {
            j.r();
        }
    }
    
    private void c(final i i, final i j) {
        if (i != null) {
            i.s();
        }
        if (j != null) {
            j.s();
        }
    }
    
    private void a(final y.c.d d, final byte b) {
        this.a(new t(this, b, d.a(), d));
    }
    
    public q a(final q q, final i i) {
        final int a = v.a;
        if (q.e() == i) {
            return q;
        }
        try {
            q q2 = this.e(q.e());
            while (q2 != null) {
                final q q3 = q2;
                if (a != 0 || q3.e() == i) {
                    return q3;
                }
                q2 = this.e(q2.e());
                if (a != 0) {
                    goto Label_0055;
                }
            }
            goto Label_0055;
        }
        catch (RuntimeException ex) {
            throw new IllegalArgumentException("No representative of v in inGraph.");
        }
    }
    
    public void d(final q q) {
        this.b(q, this.h(q.e()));
    }
    
    public void b(final q q, final i i) {
        final i e = q.e();
        e.r();
        final boolean k = this.k(q);
        this.a(new t(this, (byte)6, e, q));
        if (i instanceof bu) {
            ((bu)i).a(this);
        }
        final z z = new z(this, i, q);
        this.c.put(i, z);
        this.e.put(q, z);
        final q q2 = this.m.get(q);
        this.l.put(i, q2);
        if (k) {
            this.o.a(q2, false);
        }
        this.a(new t(this, (byte)4, e, q));
        this.k.a(q2.f(), null, q2.f().d().g(), 0, 1);
        e.s();
    }
    
    public void e(final q q) {
        final i e = q.e();
        e.r();
        final y y = new y(this.p(q));
        this.b(y);
        this.d(q);
        this.a(y, q);
        e.s();
    }
    
    public void f(final q q) {
        final i e = q.e();
        e.r();
        final y y = new y(this.m(q).o());
        this.a(this.m(q), y);
        this.c(q);
        this.c(y, q);
        e.s();
    }
    
    public void g(final q q) {
        final int a = v.a;
        final i e = q.e();
        this.a(new t(this, (byte)6, e, q));
        Label_0138: {
            if (this.j(q)) {
                this.c.remove(this.q(q).c());
                final i c = this.q(q).c();
                if (c instanceof bu) {
                    ((bu)c).a((v)null);
                }
                this.e.remove(q);
                if (a == 0) {
                    break Label_0138;
                }
            }
            if (this.k(q)) {
                this.o.a(this.m.get(q), false);
                if (a == 0) {
                    break Label_0138;
                }
            }
            throw new IllegalArgumentException("convertToNode. Node is already normal");
        }
        final q s = this.s(q);
        this.k.a(s.f(), null, s.f().d().i(), 0, 0);
        this.a(new t(this, (byte)4, e, q));
    }
    
    public void b(final y.c.d d, final q q, final q q2) {
        this.a(d, (byte)7);
        this.d.put(d, new E(q, q2));
        this.a(d, (byte)5);
    }
    
    public void a(final y.c.d d) {
        this.a(d, (byte)7);
        this.d.remove(d);
        this.a(d, (byte)5);
    }
    
    public K a() {
        return this.j;
    }
    
    public void a(final q q, final y.h.a.y y) {
        this.b(this.s(q), y);
    }
    
    private void b(final q q, final y.h.a.y y) {
        final int a = v.a;
        y.c.d d = q.g();
        while (d != null) {
            final q c = d.c();
            final q q2 = (q)this.n.b(c);
            y.a(q2);
            if (c.b() > 0 && !this.j(q2)) {
                this.b(c, y);
            }
            d = d.h();
            if (a != 0) {
                break;
            }
        }
    }
    
    public Iterator h(final q q) {
        return new J(this, this.s(q));
    }
    
    public Iterator b() {
        return new D(this, this.p);
    }
    
    public Iterator i(final q q) {
        return new D(this, this.s(q));
    }
    
    public c c() {
        return this.r;
    }
    
    public c d() {
        return this.s;
    }
    
    public c e() {
        return this.t;
    }
    
    public q b(final y.c.d d) {
        return this.f(d).a();
    }
    
    public q c(final y.c.d d) {
        return this.f(d).b();
    }
    
    public boolean d(final i i) {
        return this.i(i) != null;
    }
    
    public y.h.a.x d(final y.c.d d) {
        final E f = this.f(d);
        return (f == null) ? null : new F(f);
    }
    
    public boolean e(final y.c.d d) {
        return this.d.get(d) != null;
    }
    
    public boolean j(final q q) {
        return this.e.get(q) != null;
    }
    
    public boolean k(final q q) {
        return this.o.d(this.m.get(q));
    }
    
    public boolean l(final q q) {
        return !this.o.d(this.m.get(q)) && this.e.get(q) == null;
    }
    
    public boolean f() {
        final int a = v.a;
        final x o = this.k.o();
        boolean d = false;
        while (o.f()) {
            d = this.o.d(o.e());
            if (a != 0) {
                return d;
            }
            if (d) {
                return true;
            }
            o.g();
            if (a != 0) {
                break;
            }
        }
        return d;
    }
    
    public i m(final q q) {
        final z q2 = this.q(q);
        if (q2 != null) {
            return q2.c();
        }
        return this.f.c();
    }
    
    public q e(final i i) {
        return (q)this.n.b(this.l.get(i));
    }
    
    public q n(final q q) {
        return (q)this.n.b(this.m.get(q).f().d());
    }
    
    public boolean b(final q q, final q q2) {
        final int a = v.a;
        if (q == null) {
            return true;
        }
        final q value = this.m.get(q);
        q d = this.m.get(q2);
        while (d != this.p) {
            if (value == d) {
                return true;
            }
            d = d.f().d();
            if (a != 0) {
                break;
            }
        }
        return false;
    }
    
    public i f(final i i) {
        return this.i(i).a();
    }
    
    public i g() {
        return this.f.a;
    }
    
    public boolean g(final i i) {
        return this.f.a == i;
    }
    
    public Object[] a(Object e) {
        final int a = v.a;
        final y.c.D d = new y.c.D();
        Label_0051: {
            if (e instanceof q) {
                e = ((q)e).e();
                if (a == 0) {
                    break Label_0051;
                }
            }
            if (!(e instanceof i)) {
                throw new IllegalArgumentException("argument neither instance of Graph nor of Node.");
            }
        }
        q d2 = this.l.get(e);
        while (d2 != this.p) {
            d.c(this.n.b(d2));
            d2 = d2.f().d();
            if (a != 0) {
                return d.toArray();
            }
            if (a != 0) {
                break;
            }
        }
        d.c(this.g());
        return d.toArray();
    }
    
    public Object[] a(final Object o, final boolean b) {
        final int a = v.a;
        final y.c.D d = new y.c.D();
        while (true) {
            Label_0040: {
                if (!(o instanceof i)) {
                    break Label_0040;
                }
                q q = this.l.get(o);
                if (a != 0) {
                    break Label_0040;
                }
                while (q != this.p && q != null) {
                    d.c(this.n.b(q));
                    q = q.f().d();
                    if (a != 0) {
                        break;
                    }
                }
                d.c(this.g());
                return d.toArray();
            }
            q q = this.m.get(o);
            if (!b && q != null) {
                q = q.f().d();
            }
            continue;
        }
    }
    
    public q a(final y y) {
        final int a = v.a;
        final y y2 = new y();
        final x a2 = y.a();
        while (a2.f()) {
            y2.add(this.m.get(a2.e()));
            final Object b;
            final x x = (x)(b = a2);
            if (a != 0) {
                return (q)b;
            }
            x.g();
            if (a != 0) {
                break;
            }
        }
        Object b = this.n.b(y.a.A.a(this.k, this.p, false, y2));
        return (q)b;
    }
    
    public i a(final i i, final i j) {
        final int a = v.a;
        final i g = this.g();
        if (i == j) {
            return i;
        }
        if (i == g || j == g) {
            return g;
        }
        final y.c.D d = new y.c.D();
        z z = this.i(i);
        if (z == null) {
            return g;
        }
        d.c(i);
        while (z.b != null) {
            final i e = z.b.e();
            if (e == j) {
                return j;
            }
            d.c(e);
            z = z.b();
            if (a != 0) {
                break;
            }
        }
        final y.c.D d2 = new y.c.D();
        z z2 = this.i(j);
        if (z2 == null) {
            return g;
        }
        d2.c(j);
        while (z2.b != null) {
            final i e2 = z2.b.e();
            if (e2 == i) {
                return i;
            }
            d2.c(e2);
            z2 = z2.b();
            if (a != 0) {
                break;
            }
        }
        final Object[] array = d.toArray();
        final Object[] array2 = d2.toArray();
        int k = 0;
        int n = 0;
        Label_0242: {
            while (k < array.length) {
                n = k;
                if (a != 0 || (n >= array2.length || array[k] != array2[k])) {
                    break Label_0242;
                }
                ++k;
                if (a != 0) {
                    goto Label_0240;
                }
            }
            goto Label_0240;
        }
        if (n == 0) {
            return g;
        }
        return (i)array[k - 1];
    }
    
    public int o(final q q) {
        final int a = v.a;
        final q s = this.s(q);
        int n = 0;
        q q2 = this.t(s);
        while (q2 != this.p) {
            final int j;
            final boolean b = (j = (this.j(this.r(q2)) ? 1 : 0)) != 0;
            if (a != 0) {
                return j;
            }
            if (b) {
                break;
            }
            ++n;
            q2 = this.t(q2);
            if (a != 0) {
                break;
            }
        }
        return n;
    }
    
    public x p(final q q) {
        return new y.h.a.A(this, this.m.get(q));
    }
    
    public void a(final u u) {
        this.i.add(u);
    }
    
    protected void a(final t t) {
        final int a = v.a;
        if (!this.i.isEmpty()) {
            final u[] array = new u[this.i.size()];
            this.i.toArray(array);
            int i = 0;
            while (i < array.length) {
                array[i].a(t);
                ++i;
                if (a != 0) {
                    break;
                }
            }
        }
    }
    
    public void a(y c, final q q) {
        final int a = v.a;
        if (c.isEmpty()) {
            return;
        }
        final i e = q.e();
        e.r();
        final z q2 = this.q(q);
        final i c2 = q2.c();
        this.e(c, this.n(q));
        c = this.c(c);
        final e a2 = e.a(c, c2).a();
        while (a2.f()) {
            final y.c.d a3 = a2.a();
            final E f = this.f(a3);
            if (a != 0) {
                return;
            }
            Label_0555: {
                if (a3.c() == q || a3.d() == q) {
                    if (f == null || f.a == q || f.b == q) {
                        final q c3 = a3.c();
                        final q d = a3.d();
                        if (a3.c() == q) {
                            e.a(a3, a3.c(), q);
                            e.b(a3);
                            this.g(a3);
                            if (f == null) {
                                this.b(a3, c3, d);
                            }
                            this.a(a3, f != null, c3, d);
                            if (a == 0) {
                                break Label_0555;
                            }
                        }
                        e.a(a3, q, a3.d());
                        e.b(a3);
                        this.g(a3);
                        if (f == null) {
                            this.b(a3, c3, d);
                        }
                        this.a(a3, f != null, c3, d);
                        if (a == 0) {
                            break Label_0555;
                        }
                    }
                    final q c4 = a3.c();
                    final q d2 = a3.d();
                    if (a3.c() == q) {
                        q2.a.a(a3, q2.a(f.a()).b(), a3.d());
                        q2.a.b(a3);
                        this.g(a3);
                        this.a(a3, true, c4, d2);
                        if (a == 0) {
                            break Label_0555;
                        }
                    }
                    q2.a.a(a3, a3.c(), q2.a(f.b()).b());
                    q2.a.b(a3);
                    this.g(a3);
                    this.a(a3, true, c4, d2);
                    if (a == 0) {
                        break Label_0555;
                    }
                }
                final q c5 = a3.c();
                final q d3 = a3.d();
                Label_0513: {
                    if (c5.e() != e) {
                        e.a(a3, q, d3);
                        e.b(a3);
                        this.g(a3);
                        if (a == 0) {
                            break Label_0513;
                        }
                    }
                    e.a(a3, c5, q);
                    e.b(a3);
                    this.g(a3);
                }
                if (f == null) {
                    this.b(a3, c5, d3);
                    this.a(a3, false, c5, d3);
                    if (a == 0) {
                        break Label_0555;
                    }
                }
                this.a(a3, true, c5, d3);
            }
            a2.g();
            if (a != 0) {
                break;
            }
        }
        e.s();
    }
    
    public void a(final i i, y c) {
        final int a = v.a;
        if (c.isEmpty()) {
            return;
        }
        final z j = this.i(i);
        final z b = j.b();
        final i c2 = b.c();
        c2.r();
        c = this.c(c);
        final q d = j.d();
        final f a2 = i.a(c, c2);
        e e = new f(d.j()).a();
        while (true) {
            while (e.f()) {
                final y.c.d a3 = e.a();
                final boolean e2 = this.e(a3);
                if (a != 0) {
                    i e3 = null;
                    while (true) {
                        if (e2) {
                            final y.c.d a4 = e.a();
                            final q c3 = a4.c();
                            final q d2 = a4.d();
                            e3 = a4.c().e();
                            if (a == 0) {
                                Label_0479: {
                                    if (e3 == i) {
                                        c2.a(a4, d, a4.d());
                                        c2.b(a4);
                                        this.a(a4, c3, d2, d, a4.d());
                                        this.a(a4, true, c3, d2);
                                        if (a == 0) {
                                            break Label_0479;
                                        }
                                    }
                                    if (a4.d().e() == i) {
                                        c2.a(a4, a4.c(), d);
                                        c2.b(a4);
                                        this.a(a4, c3, d2, a4.c(), d);
                                        this.a(a4, true, c3, d2);
                                    }
                                }
                                e.g();
                                if (a == 0) {
                                    e.f();
                                    continue;
                                }
                            }
                        }
                        break;
                    }
                    e3.s();
                    return;
                }
                if (e2) {
                    final q c4 = a3.c();
                    final q d3 = a3.d();
                    if (c4 == d) {
                        final q b2 = b.a(this.f(a3).a()).b();
                        if (b2 != d) {
                            c2.a(a3);
                            c2.a(a3, b2, a3.d());
                            c2.b(a3);
                            this.g(a3);
                            this.a(a3, true, c4, d3);
                        }
                    }
                    if (d3 == d) {
                        final E f = this.f(a3);
                        if (f != null) {
                            final q b3 = b.a(f.b()).b();
                            if (b3 != d) {
                                c2.a(a3);
                                c2.a(a3, a3.c(), b3);
                                c2.b(a3);
                                this.g(a3);
                                this.a(a3, true, c4, d3);
                            }
                        }
                    }
                }
                e.g();
                if (a != 0) {
                    break;
                }
            }
            e = a2.a();
            continue;
        }
    }
    
    public void b(final y y, final q q) {
        final int a = v.a;
        final x a2 = y.a();
        while (a2.f()) {
            this.c(a2.e(), q);
            a2.g();
            if (a != 0) {
                break;
            }
        }
    }
    
    public void c(final q q, final q q2) {
        final int a = v.a;
        if (q == q2) {
            throw new IllegalArgumentException("node may not be identical to parentNode");
        }
        if (this.b(q, q2)) {
            throw new IllegalArgumentException("node may not be an ancestor of parentNode");
        }
        final i i = (q2 == null) ? this.g() : (this.j(q2) ? this.m(q2) : q2.e());
        i j = q.e();
        final i a2 = this.a(i, j);
        while (true) {
        Label_0256_Outer:
            while (j != a2) {
                final v v = this;
                if (a != 0) {
                    final Object[] a3 = v.a(q2, true);
                    int n = 0;
                    i k = (i)a3[n++];
                    while (true) {
                        while (k != a2) {
                            final q q3 = (q)a3[n++];
                            if (this.j(q3)) {
                                k = this.m(q3);
                                if (a != 0) {
                                    if (this.n(q) != q2) {
                                        this.c(new y(q), q2);
                                    }
                                    return;
                                }
                                if (a != 0) {
                                    break;
                                }
                                continue Label_0256_Outer;
                            }
                        }
                        while (k != i) {
                            final q q4 = (q)a3[n++];
                            if (this.j(q4)) {
                                this.a(new y(q), q4);
                                k = this.m(q4);
                                if (a != 0) {
                                    return;
                                }
                                if (a != 0) {
                                    break;
                                }
                                continue Label_0256_Outer;
                            }
                        }
                        continue;
                    }
                }
                this.a(j, new y(q));
                j = q.e();
                if (a != 0) {
                    break;
                }
            }
            final v v = this;
            continue;
        }
    }
    
    public void c(final y y, final q q) {
        if (!y.isEmpty()) {
            this.f(this.d(y), q);
        }
    }
    
    public void b(y d) {
        final int a = v.a;
        if (d.isEmpty()) {
            return;
        }
        d = this.d(d);
        y y = new y();
        q n = this.n(d.b());
        final x a2 = d.a();
        while (a2.f()) {
            final q e = a2.e();
            final q n2 = this.n(e);
            if (a != 0) {
                return;
            }
            if (n2 != null) {
                if (!this.j(n2)) {
                    if (n2 != n) {
                        if (n != null) {
                            this.f(y, this.n(n));
                        }
                        n = n2;
                        y = new y();
                    }
                    y.add(e);
                }
            }
            a2.g();
            if (a != 0) {
                break;
            }
        }
        if (y.size() > 0) {
            this.c(y, this.n(n));
        }
    }
    
    private i h(final i i) {
        return this.h.a(i);
    }
    
    private z i(final i i) {
        return this.c.get(i);
    }
    
    private z q(final q q) {
        return this.e.get(q);
    }
    
    private E f(final y.c.d d) {
        return this.d.get(d);
    }
    
    private q r(final q q) {
        return (q)this.n.b(q);
    }
    
    private q s(final q q) {
        return this.m.get(q);
    }
    
    private q j(final i i) {
        return this.l.get(i);
    }
    
    private q t(final q q) {
        return q.f().d();
    }
    
    private y c(final y y) {
        final int a = v.a;
        if (y.isEmpty()) {
            return y;
        }
        final y y2 = new y();
        final boolean[] array = new boolean[y.b().e().e()];
        x x = y.a();
        while (true) {
            while (x.f()) {
                array[x.e().d()] = true;
                x.g();
                if (a != 0) {
                    while (x.f()) {
                        if (this.k(x.e()) && array[x.e().d()]) {
                            this.a(x.e(), array, y2);
                        }
                        x.g();
                        if (a != 0) {
                            break;
                        }
                    }
                    y y3;
                    if (y2.size() > 0) {
                        y3 = new y(y.a());
                        y3.a(y2);
                    }
                    else {
                        y3 = y;
                    }
                    return y3;
                }
                if (a != 0) {
                    break;
                }
            }
            x = y.a();
            continue;
        }
    }
    
    private void a(final q q, final boolean[] array, final y y) {
        final int a = v.a;
        final x p3 = this.p(q);
        while (p3.f()) {
            final q e = p3.e();
            if (!array[e.d()]) {
                y.add(e);
            }
            if (this.k(e)) {
                this.a(e, array, y);
            }
            p3.g();
            if (a != 0) {
                break;
            }
        }
    }
    
    private y d(final y y) {
        return this.d(y, null);
    }
    
    private y d(final y y, q s) {
        final int a = v.a;
        final y y2 = new y();
        final boolean[] array = new boolean[this.k.e()];
        final x a2 = y.a();
        while (true) {
            while (a2.f()) {
                array[this.s(a2.e()).d()] = true;
                a2.g();
                if (a != 0) {
                    final x a3 = y.a();
                Label_0161_Outer:
                    while (a3.f()) {
                        q q = this.t(this.s(a3.e()));
                        while (true) {
                            while (q != s) {
                                final boolean b = array[q.d()];
                                if (a == 0) {
                                    if (b) {
                                        break;
                                    }
                                    q = this.t(q);
                                    if (a != 0) {
                                        break;
                                    }
                                    continue Label_0161_Outer;
                                }
                                else {
                                    if (!b) {
                                        y2.add(a3.e());
                                    }
                                    a3.g();
                                    if (a != 0) {
                                        break Label_0161_Outer;
                                    }
                                    continue Label_0161_Outer;
                                }
                            }
                            final boolean b2 = array[q.d()];
                            continue;
                        }
                    }
                    return y2;
                }
                if (a != 0) {
                    break;
                }
            }
            s = this.s(s);
            continue;
        }
    }
    
    private void e(final y y, final q q) {
        final int i = v.a;
        i j;
        if (q == null) {
            j = this.g();
        }
        else if (this.j(q)) {
            j = this.m(q);
        }
        else {
            j = q.e();
        }
        this.s(q);
        final q k = this.j(j);
        final boolean[] array = new boolean[j.e()];
        x x = y.a();
        while (true) {
            while (x.f()) {
                array[x.e().d()] = true;
                x.g();
                if (i != 0) {
                    while (x.f()) {
                        final q e = x.e();
                        q q2 = this.t(this.s(e));
                        boolean b = true;
                        do {
                            q q3 = null;
                            q q4 = null;
                            while (q3 != q4) {
                                q3 = q2;
                                q4 = k;
                                if (i == 0) {
                                    if (q3 == q4) {
                                        break;
                                    }
                                    b = array[this.r(q2).d()];
                                    q2 = this.t(q2);
                                }
                            }
                            break;
                        } while (i == 0);
                        if (!b) {
                            this.c(new y(e), q);
                        }
                        x.g();
                        if (i != 0) {
                            break;
                        }
                    }
                    return;
                }
                if (i != 0) {
                    break;
                }
            }
            x = y.a();
            continue;
        }
    }
    
    private void f(final y y, final q q) {
        final int a = v.a;
        if (y.isEmpty()) {
            return;
        }
        final q s = this.s(q);
        q n = this.n(y.b());
        y y2 = new y();
        final x a2 = y.a();
        while (true) {
            while (a2.f()) {
                final q e = a2.e();
                final q s2 = this.s(e);
                final q n2 = this.n(e);
                final y.c.d f = s2.f();
                final boolean j = this.j(e);
                if (a != 0) {
                    if (!j) {
                        this.a(new t(this, (byte)8, n, y2));
                    }
                    return;
                }
                Label_0158: {
                    if (j || this.k(e)) {
                        this.k.a(f, s2, null, 1, s, s.g(), 1);
                        if (a == 0) {
                            break Label_0158;
                        }
                    }
                    this.k.a(f, s2, null, 1, s, s.i(), 0);
                }
                if (n != n2) {
                    this.a(new t(this, (byte)8, n, y2));
                    n = n2;
                    y2 = new y();
                }
                y2.add(e);
                a2.g();
                if (a != 0) {
                    break;
                }
            }
            y2.isEmpty();
            continue;
        }
    }
    
    private void g(final y.c.d d) {
        final E f = this.f(d);
        if (f == null) {
            return;
        }
        if (d.c() == f.a() && d.d() == f.b()) {
            this.a(d);
        }
    }
    
    private void a(final y.c.d d, final q q, final q q2, final q q3, final q q4) {
        final E f = this.f(d);
        if (f == null) {
            if (q != q3 || q2 != q4) {
                this.b(d, q, q2);
            }
            return;
        }
        if (d.c() == f.a() && d.d() == f.b()) {
            this.a(d);
        }
    }
    
    private void a(final y.c.d d, final boolean b, final q q, final q q2) {
        final K a = this.a();
        if (a != null) {
            a.a(d, b, q, q2);
        }
    }
    
    static int a(final v v) {
        return ++v.q;
    }
    
    static z a(final v v, final i i) {
        return v.i(i);
    }
    
    static Map b(final v v) {
        return v.m;
    }
    
    static i c(final v v) {
        return v.k;
    }
    
    static Map d(final v v) {
        return v.l;
    }
    
    static A e(final v v) {
        return v.n;
    }
    
    static q a(final v v, final q q) {
        return v.s(q);
    }
    
    static y a(final v v, final y y) {
        return v.d(y);
    }
    
    static q b(final v v, final q q) {
        return v.t(q);
    }
    
    static q c(final v v, final q q) {
        return v.r(q);
    }
    
    static E a(final v v, final y.c.d d) {
        return v.f(d);
    }
    
    static int f(final v v) {
        return v.q;
    }
    
    static {
        b = new ArrayList();
    }
}
