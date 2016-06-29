package y.h.b;

import y.d.*;
import java.util.*;

final class j implements i
{
    private final List a;
    private final List b;
    private final List c;
    private final List d;
    private r e;
    private final a f;
    
    j(final a f, final double n, final double n2, final double n3, final double n4, final r r, final r r2) {
        this.f = f;
        this.a = new ArrayList();
        this.b = Collections.unmodifiableList((List<?>)this.a);
        this.a.add(new y.h.b.r(f, this, n2, n4, r2));
        (this.c = new ArrayList()).add(new t(f, this, n, n3, r));
        this.d = Collections.unmodifiableList((List<?>)this.c);
        this.e = y.h.b.a.x();
    }
    
    j(final a f, final j j) {
        final int h = y.h.b.a.H;
        this.f = f;
        this.a = new ArrayList(j.a.size());
        this.b = Collections.unmodifiableList((List<?>)this.a);
        final Iterator<y.h.b.r> iterator = j.a.iterator();
        while (true) {
            while (iterator.hasNext()) {
                final y.h.b.r r = new y.h.b.r(f, iterator.next());
                this.a.add(r);
                y.h.b.r.a(r, this);
                if (h != 0) {
                    final Iterator<t> iterator2 = j.c.iterator();
                    while (iterator2.hasNext()) {
                        final t t = new t(f, iterator2.next());
                        this.c.add(t);
                        y.h.b.t.a(t, this);
                        if (h != 0) {
                            return;
                        }
                        if (h != 0) {
                            break;
                        }
                    }
                    this.e = j.e;
                    return;
                }
                if (h != 0) {
                    break;
                }
            }
            this.c = new ArrayList(j.c.size());
            this.d = Collections.unmodifiableList((List<?>)this.c);
            continue;
        }
    }
    
    public a a() {
        return this.f;
    }
    
    public int n() {
        return this.a.size();
    }
    
    public f c(final int n) {
        return this.a.get(n);
    }
    
    public f a(final double n, final double n2) {
        return y.h.b.a.a(this.f, n, n2);
    }
    
    public Collection b() {
        final ArrayList list = new ArrayList();
        this.a(this.a, list);
        return list;
    }
    
    private void a(final List list, final List list2) {
        final int h = y.h.b.a.H;
        for (final f f : list) {
            if (f.e()) {
                list2.add(f);
            }
            if (!f.o().isEmpty()) {
                this.a(f.o(), list2);
                if (h != 0) {
                    break;
                }
                continue;
            }
        }
    }
    
    public int k() {
        return this.c.size();
    }
    
    public c b(final int n) {
        return this.c.get(n);
    }
    
    public c b(final double n, final double n2) {
        return y.h.b.a.b(this.f, n, n2);
    }
    
    public Collection c() {
        final ArrayList list = new ArrayList();
        this.b(this.c, list);
        return list;
    }
    
    private void b(final List list, final List list2) {
        final int h = y.h.b.a.H;
        for (final c c : list) {
            if (c.e()) {
                list2.add(c);
            }
            if (!c.l().isEmpty()) {
                this.b(c.l(), list2);
                if (h != 0) {
                    break;
                }
                continue;
            }
        }
    }
    
    public void a(final r e) {
        final int h = y.h.b.a.H;
        Label_0026: {
            if (e == null) {
                this.e = y.h.b.a.x();
                if (h == 0) {
                    break Label_0026;
                }
            }
            this.e = e;
        }
        final s s = new s();
        y.h.b.a.a(this.f, s);
        y.h.b.a.b(this.f, s);
        double n = s.b + s.d;
        double n2 = s.a + s.c;
        Iterator<f> iterator = this.l().iterator();
        while (true) {
            while (iterator.hasNext()) {
                n += ((c)iterator.next()).g();
                if (h != 0) {
                    while (iterator.hasNext()) {
                        n2 += iterator.next().g();
                        if (h != 0) {
                            return;
                        }
                        if (h != 0) {
                            break;
                        }
                    }
                    y.h.b.a.c(this.f, n, n2);
                    return;
                }
                if (h != 0) {
                    break;
                }
            }
            iterator = this.o().iterator();
            continue;
        }
    }
    
    public r d() {
        return this.e;
    }
    
    public f m() {
        return this.a(this.a.size());
    }
    
    public f a(final int n) {
        final boolean c = y.h.b.a.c(this.f);
        if (c) {
            y.h.b.a.a(this.f, false);
        }
        try {
            final s s = new s();
            y.h.b.a.a(this.f, s);
            final double b = y.h.b.a.b(this.f);
            final y.h.b.r r = new y.h.b.r(this.f, this.f.p(), this.f.q(), this.f.r());
            this.a.add(n, r);
            y.h.b.r.a(r, this);
            final s s2 = new s();
            y.h.b.a.a(this.f, s2);
            y.h.b.a.c(this.f, this.a().getWidth() + s2.b - s.b + s2.d - s.d, b + r.g());
            return r;
        }
        finally {
            if (c) {
                y.h.b.a.a(this.f, c);
            }
        }
    }
    
    public List o() {
        return this.b;
    }
    
    public c j() {
        return this.d(this.c.size());
    }
    
    public c d(final int n) {
        final boolean c = y.h.b.a.c(this.f);
        if (c) {
            y.h.b.a.a(this.f, false);
        }
        try {
            final s s = new s();
            y.h.b.a.b(this.f, s);
            final double a = y.h.b.a.a(this.f);
            final t t = new t(this.f, this.f.m(), this.f.n(), this.f.o());
            this.c.add(n, t);
            y.h.b.t.a(t, this);
            final s s2 = new s();
            y.h.b.a.b(this.f, s2);
            y.h.b.a.c(this.f, a + t.g(), this.a().getHeight() + s2.a - s.a + s2.c - s.c);
            return t;
        }
        finally {
            if (c) {
                y.h.b.a.a(this.f, c);
            }
        }
    }
    
    public List l() {
        return this.d;
    }
    
    static List a(final j j) {
        return j.a;
    }
    
    static List b(final j j) {
        return j.c;
    }
}
