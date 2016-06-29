package y.f.i.a;

import y.c.*;
import y.f.*;
import java.util.*;

class aw extends ab
{
    private int b;
    private d c;
    private byte d;
    private boolean e;
    private R f;
    
    protected void b(final aa aa) {
        super.b(aa);
        this.c = this.b().c();
        this.d = this.a().c().a(this.c).e();
        this.b = this.b().d().f().m();
        this.e = (this.b > 0 && this.d != 0 && !this.c.e());
        this.f = aa.g();
    }
    
    protected double a(final f f, final R r, final P p5, final v v, final double n) {
        final int a = ab.a;
        final boolean b = f.j() == null;
        final byte c = v.c();
        final boolean b2 = c == 4 || c == 2;
        double n2 = 0.0;
        Label_0189: {
            if (b || b2) {
                if (!this.a(v.b(), b ? 0 : 1) || (d(f) && !this.a(true))) {
                    break Label_0189;
                }
                n2 = this.b;
                if (a == 0) {
                    break Label_0189;
                }
            }
            if (v.c() == 3 && p5.b(f.c())) {
                n2 += this.b;
                if (a == 0) {
                    break Label_0189;
                }
            }
            if (this.a(v.b(), 1) && (!d(f) || this.a(true))) {
                n2 = this.b;
            }
        }
        this.a("monotonic edge route penalty", n2, false);
        return n2;
    }
    
    double[] a(final f f, final R r, final P[] array, final v[] array2, final double[] array3) {
        if (!this.e) {
            this.b("monotonic edge route penalty", 0.0, false);
            return new double[array.length];
        }
        return super.a(f, r, array, array2, array3);
    }
    
    protected double b(final f f) {
        if (!this.e) {
            return 0.0;
        }
        double n = 0.0;
        if (a(f, this.f) && this.a(f.d().c()) && this.a(false)) {
            n = this.b;
        }
        this.a("HEUR monotonic penalty", n, true);
        return n;
    }
    
    private boolean a(final y y) {
        final X a = this.a().a();
        return ((this.d == 2 || this.d == 3) && y == a(this.c, a, (byte)2)) || ((this.d == 1 || this.d == 3) && y == a(this.c, a, (byte)1));
    }
    
    private static boolean a(final f f, final R r) {
        final y d = f.d();
        final R a = f.a();
        if (d == y.b) {
            return r.j() <= a.h();
        }
        if (d == y.d) {
            return a.j() <= r.h();
        }
        if (d == y.a) {
            return a.k() <= r.i();
        }
        return r.k() <= a.i();
    }
    
    private boolean a(final boolean b) {
        final int a = ab.a;
        final List a2 = this.a().a(this.c).a(b);
        if (a2 == null || a2.isEmpty()) {
            return true;
        }
        final HashSet<y> set = new HashSet<y>();
        final Iterator<ax> iterator = a2.iterator();
        while (iterator.hasNext()) {
            final byte b2 = iterator.next().e().b();
            if (b2 == 0) {
                return true;
            }
            set.add(a(b2));
            if (a != 0) {
                break;
            }
        }
        final Set d = this.d();
        d.retainAll(set);
        return !d.isEmpty();
    }
    
    private static y a(final byte b) {
        switch (b) {
            case 1: {
                return y.a;
            }
            case 2: {
                return y.c;
            }
            case 4: {
                return y.d;
            }
            case 8: {
                return y.b;
            }
            default: {
                throw new IllegalArgumentException(b + "not allowed");
            }
        }
    }
    
    private static boolean d(final f f) {
        return !f.i();
    }
    
    private Set d() {
        final X a = this.a().a();
        final HashSet set = new HashSet((Collection<? extends E>)Arrays.asList(y.a, y.c, y.d, y.b));
        if (this.d == 2 || this.d == 3) {
            set.remove(a(this.c, a, (byte)2));
        }
        if (this.d == 1 || this.d == 3) {
            set.remove(a(this.c, a, (byte)1));
        }
        return set;
    }
    
    private boolean a(final y[] array, final int n) {
        final int a = ab.a;
        final X a2 = this.a().a();
        byte b2 = 0;
        Label_0081: {
            if (this.d == 2 || this.d == 3) {
                final y a3 = a(this.c, a2, (byte)2);
                int i = n;
                while (i < array.length) {
                    final boolean b = (b2 = (byte)(a3.equals(array[i]) ? 1 : 0)) != 0;
                    if (a != 0) {
                        break Label_0081;
                    }
                    if (b) {
                        return true;
                    }
                    ++i;
                    if (a != 0) {
                        break;
                    }
                }
            }
            b2 = this.d;
        }
        boolean equals = false;
        if (b2 == 1 || this.d == 3) {
            final y a4 = a(this.c, a2, (byte)1);
            int j = n;
            while (j < array.length) {
                equals = a4.equals(array[j]);
                if (a != 0) {
                    break;
                }
                if (equals) {
                    return true;
                }
                ++j;
                if (a != 0) {
                    break;
                }
            }
        }
        return equals;
    }
    
    private static y a(final d d, final X x, final byte b) {
        if (b == 2) {
            return (x.j(d.c()) < x.j(d.d())) ? y.d : y.b;
        }
        if (b == 1) {
            return (x.k(d.c()) < x.k(d.d())) ? y.a : y.c;
        }
        return null;
    }
}
