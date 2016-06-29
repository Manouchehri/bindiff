package y.f.i.a;

import y.g.*;
import y.f.*;
import java.util.*;
import y.d.*;
import y.c.*;

class bi extends ab implements H
{
    private aU b;
    private List c;
    private List d;
    private List e;
    private int f;
    private boolean g;
    private boolean h;
    
    protected void a(final Z z) {
        super.a(z);
        z.a().a(bl.a, M.a());
    }
    
    protected void c() {
        this.a().a().d_(bl.a);
        super.c();
        this.b = null;
        this.c = null;
        this.d = null;
        this.e = null;
    }
    
    protected void b(final aa aa) {
        super.b(aa);
        final d c = aa.c();
        final X a = this.a().a();
        this.f = aa.d().f().o();
        if (this.f <= 0) {
            this.h = false;
            return;
        }
        this.b = this.a().a(c);
        this.c = this.b.a(true);
        this.d = this.b.a(false);
        if (!(this.h = ((this.c != null && this.c.size() > 0) || (this.d != null && this.d.size() > 0)))) {
            return;
        }
        final List b = this.b.b(true);
        if (b.size() > 0) {
            this.a(a, c, b, true);
        }
        this.e = this.b.b(false);
        if (this.e.size() > 0) {
            this.a(a, c, this.e, false);
            aa.a().a((H)this);
        }
    }
    
    private void a(final X x, final d d, final List list, final boolean b) {
        final int a = ab.a;
        final am a2 = x.a((Object)(b ? d.c() : d.d()));
        final Iterator<ax> iterator = list.iterator();
    Label_0217:
        while (true) {
            boolean hasNext = iterator.hasNext();
        Label_0046:
            while (hasNext) {
                final t a3 = this.b.a(iterator.next(), b);
                if (!y.a(a2.getX(), a2.getY(), a2.getWidth(), a2.getHeight(), a3.a(), a3.b())) {
                    for (final R r : this.a().c().r().a(new y(a3.a(), a3.b(), 0.0, 0.0))) {
                        hasNext = b;
                        if (a != 0) {
                            continue Label_0046;
                        }
                        if (b) {
                            this.b().a(r);
                            if (a == 0) {
                                continue;
                            }
                        }
                        this.b().c(r);
                        if (a != 0) {
                            break Label_0217;
                        }
                    }
                    continue Label_0217;
                }
                continue Label_0217;
            }
            break;
        }
    }
    
    protected void c(final aa aa) {
        super.c(aa);
        if (this.h && this.e.size() > 0) {
            aa.a().b(this);
        }
    }
    
    protected void d(final aa aa) {
        super.d(aa);
        if (this.h && this.e.size() > 0) {
            aa.a().b(this);
        }
    }
    
    double[] a(final f f, final R r, final P[] array, final v[] array2, final double[] array3) {
        final int a = ab.a;
        if (!this.h) {
            this.b("source port penalty", 0.0, false);
            this.b("target port penalty", 0.0, false);
            return new double[array.length];
        }
        this.g = (this.c != null);
        f b = f;
        while (this.g && b != null) {
            this.g = this.b().b(b.a());
            b = b.b();
            if (a != 0) {
                break;
            }
        }
        return super.a(f, r, array, array2, array3);
    }
    
    protected double a(final f f, final R r, final P p5, final v v, final double n) {
        final int a = ab.a;
        final R a2 = f.a();
        double min = 0.0;
        Label_0104: {
            if (this.g) {
                min = this.f;
                final Iterator iterator = this.b.a(a2, r, p5, true).iterator();
                while (iterator.hasNext()) {
                    min = Math.min(min, iterator.next().f());
                    if (a != 0) {
                        break Label_0104;
                    }
                    if (a != 0) {
                        break;
                    }
                }
            }
            this.a("source port penalty", min, false);
        }
        if (min > n) {
            return min;
        }
        double min2 = 0.0;
        if (this.d != null && this.b().d(r)) {
            min2 = this.f;
            final Iterator iterator2 = this.b.a(a2, r, p5, false).iterator();
            while (iterator2.hasNext()) {
                min2 = Math.min(min2, iterator2.next().f());
                if (a != 0) {
                    return min + min2;
                }
                if (a != 0) {
                    break;
                }
            }
        }
        this.a("target port penalty", min2, false);
        return min + min2;
    }
    
    public void a(final f f, final R r, final P p5, final List list, final aa aa) {
        final int a = ab.a;
        if (this.e.size() > 0 && aa.d(r)) {
            final Iterator<ax> iterator = (Iterator<ax>)this.b.a(this.e, f.a(), r, false).iterator();
            while (iterator.hasNext()) {
                final t a2 = this.b.a(iterator.next(), false);
                final double n = p5.a() ? a2.b() : a2.a();
                if (p5.e().a(n)) {
                    list.add(new P(n, n, p5.f(), p5.a()));
                    if (a != 0) {
                        break;
                    }
                    continue;
                }
            }
        }
    }
    
    protected double a(final f f) {
        final int a = ab.a;
        if (!this.h) {
            return 0.0;
        }
        final f b = f.b();
        double n = 0.0;
        double min = 0.0;
        if (b != null && this.c != null && this.b().b(b.a())) {
            n = this.f;
            final Iterator iterator = this.b.a(b.a(), f.a(), f.c(), true).iterator();
            while (iterator.hasNext()) {
                min = Math.min(n, iterator.next().f());
                if (a != 0) {
                    break;
                }
                n = min;
                if (a != 0) {
                    break;
                }
            }
        }
        return min;
    }
    
    protected void a(final List list) {
        final int i = ab.a;
        if (!this.h) {
            return;
        }
        final List b = this.b.b(true);
        if (b.isEmpty()) {
            return;
        }
        final aa b2 = this.b();
        int n = 0;
        final int e = b2.e();
    Label_0326:
        do {
            int j = 0;
        Label_0048:
            while (j < e) {
                final R a = b2.a(n);
                final f f = new f(a);
            Label_0323:
                for (final R r : this.a().c().r().c(a)) {
                    if (b2.b(r)) {
                        continue;
                    }
                    final P a2 = V.a(a, r);
                    final Iterator iterator2 = this.b.a(b, a, r, true).iterator();
                    while (iterator2.hasNext()) {
                        final t a3 = this.b.a(iterator2.next(), true);
                        j = (a2.a() ? 1 : 0);
                        if (i != 0) {
                            continue Label_0048;
                        }
                        final double n2 = (j != 0) ? a3.b() : a3.a();
                        if (!a2.e().a(n2)) {
                            continue;
                        }
                        final y.f.y a4 = V.a(f, r);
                        final P p = new P(n2, n2, a2.f(), a2.a());
                        final f f2 = new f(r);
                        f2.a(a4);
                        f2.a(p);
                        f2.a(f);
                        list.add(f2);
                        if (i != 0) {
                            continue Label_0326;
                        }
                        if (i != 0) {
                            break Label_0323;
                        }
                    }
                }
                ++n;
            }
            break;
        } while (i == 0);
    }
    
    protected void a(final ac ac) {
        final int a = ab.a;
        super.a(ac);
        final e b = this.b().b();
        while (b.f()) {
            final d a2 = b.a();
            final U b2 = ac.b(a2);
            if (b2 != null) {
                final aU a3 = this.a().a(a2);
                a3.b(b2, true);
                a3.b(b2, false);
                this.a(b2, a3, true);
                this.a(b2, a3, false);
            }
            b.g();
            if (a != 0) {
                break;
            }
        }
    }
    
    private void a(final U u, final aU au, final boolean b) {
        final List a = au.a(u, b);
        if (a.size() > 0) {
            final List a2 = au.a(a);
            final ax ax = (a2.size() > 0) ? a2.get(0) : null;
            if (ax != null) {
                final t a3 = au.a(ax, b);
                final w a4 = this.b().i().a(u);
                if (b) {
                    a4.a(a3);
                    if (ab.a == 0) {
                        return;
                    }
                }
                a4.b(a3);
            }
        }
    }
}
