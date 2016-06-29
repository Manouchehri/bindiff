package y.h;

import y.c.*;
import y.f.*;
import y.d.*;

public class gu implements E, dF
{
    private double a;
    private boolean b;
    private double c;
    private boolean d;
    
    public gu() {
        this.a = 10.0;
    }
    
    public boolean b() {
        return this.b;
    }
    
    public boolean d() {
        return this.d;
    }
    
    public double e() {
        return this.c;
    }
    
    public double f() {
        return this.a;
    }
    
    public Object c() {
        return new gv(this.f(), this.e());
    }
    
    private static ik g() {
        return new ik();
    }
    
    public n a(final q q, final I i, final am am, final am am2, final Object o) {
        final gv gv = (gv)((o == null) ? this.c() : o);
        final ik g = g();
        this.a(g, gv, this.b());
        return g.a(q, i, am, am2, gv);
    }
    
    private void a(final ik ik, final gv gv, final boolean b) {
        this.a(ik, gv.e(), gv, b);
    }
    
    private void a(final ik ik, final byte b, final gv gv, final boolean b2) {
        ik.c(gv.d());
        ik.b(gv.f());
        ik.a(gv.c());
        ik.a(b2);
        ik.b(this.d());
        ik.a(b);
    }
    
    private void a(final ik ik, final byte b, final n n, final boolean b2, final boolean b3, final gv gv, final boolean b4) {
        if (b3 || gv == null) {
            ik.c(b2);
            ik.b(6.283185307179586 - n.j());
            ik.a(this.f());
            ik.a(b4);
            ik.b(this.d());
            ik.a(b);
            if (!fj.z) {
                return;
            }
        }
        this.a(ik, b, gv, b4);
    }
    
    public D a(final C c, final I i, final am am, final am am2) {
        final Object modelParameter = c.getModelParameter();
        gv gv = null;
        Label_0038: {
            if (modelParameter instanceof gv) {
                gv = (gv)modelParameter;
                if (!fj.z) {
                    break Label_0038;
                }
            }
            gv = (gv)this.c();
        }
        final D d = new D();
        final ik g = g();
        this.a(g, (byte)0, gv, this.b());
        d.a(g.a(c, i, am, am2, gv));
        this.a(g, (byte)2, gv, this.b());
        d.a(g.a(c, i, am, am2, gv));
        this.a(g, (byte)1, gv, this.b());
        d.a(g.a(c, i, am, am2, gv));
        return d;
    }
    
    public Object a(final n n, final I i, final am am, final am am2) {
        if (a(n)) {
            throw new IllegalArgumentException("Invalid label bounds: " + n);
        }
        return this.a(n, i, am, am2, null, (byte)0, true);
    }
    
    public Object b(final n n, final I i, final am am, final am am2) {
        if (a(n)) {
            throw new IllegalArgumentException("Invalid label bounds: " + n);
        }
        return this.a(n, i, am, am2, null, (byte)0, false);
    }
    
    public dE a() {
        return new in(this);
    }
    
    private gv a(final n n, final I i, final am am, final am am2, final gv gv, final byte b, final boolean b2) {
        final boolean b3 = !b2 && this.b();
        final boolean b4 = b2 && this.b();
        final boolean c = c(n, i, am, am2);
        final ik g = g();
        gv gv2 = gv;
        double a = 0.0;
        double n2 = 0.0;
        Label_0110: {
            if (gv2 == null) {
                a = Double.MAX_VALUE;
                n2 = Double.MAX_VALUE;
                if (!fj.z) {
                    break Label_0110;
                }
            }
            this.a(g, gv2, b3);
            a = this.a(g, gv2, n, i, am, am2);
            n2 = a(gv2);
        }
        final boolean b5 = 2 == b;
        if (c) {
            this.a(g, (byte)0, n, false, b5, gv, b3);
            final gv a2 = g.a(n, i, am, am2, gv, b, b4);
            final double a3 = this.a(g, a2, n, i, am, am2);
            if (a(a2, a3, gv2, a, n2)) {
                gv2 = a2;
                a = a3;
                n2 = a(gv2);
            }
            if (a < 1.0E-4 && gv2.b() >= 0.0 && gv2.b() <= 1.0) {
                return gv2;
            }
        }
        if ((gv == null && !c) || (gv != null && !gv.d())) {
            this.a(g, (byte)1, n, false, b5, gv, b3);
            final gv a4 = g.a(n, i, am, am2, gv, b, b4);
            final double a5 = this.a(g, a4, n, i, am, am2);
            if (a(a4, a5, gv2, a, n2)) {
                gv2 = a4;
                a = a5;
                n2 = a(gv2);
            }
            this.a(g, (byte)2, n, false, b5, gv, b3);
            final gv a6 = g.a(n, i, am, am2, gv, b, b4);
            final double a7 = this.a(g, a6, n, i, am, am2);
            if (a(a6, a7, gv2, a, n2)) {
                gv2 = a6;
                a = a7;
                n2 = a(gv2);
            }
            if (a < 1.0E-4 && gv2.b() >= 0.0 && gv2.b() <= 1.0) {
                return gv2;
            }
        }
        if (gv == null || gv.d() || (c && b5)) {
            this.a(g, (byte)1, n, true, b5, gv, b3);
            final gv a8 = g.a(n, i, am, am2, gv, b, b4);
            final double a9 = this.a(g, a8, n, i, am, am2);
            if (a(a8, a9, gv2, a, n2)) {
                gv2 = a8;
                a = a9;
                n2 = a(gv2);
            }
            this.a(g, (byte)2, n, true, b5, gv, b3);
            final gv a10 = g.a(n, i, am, am2, gv, b, b4);
            final double a11 = this.a(g, a10, n, i, am, am2);
            if (a(a10, a11, gv2, a, n2)) {
                gv2 = a10;
                a = a11;
            }
            if (a < 1.0E-4 && gv2.b() >= 0.0 && gv2.b() <= 1.0) {
                return gv2;
            }
        }
        if (gv2 == null) {
            return (gv)this.c();
        }
        if (gv != null && gv2.equals(gv)) {
            this.a(g, gv, b3);
            return g.a(n, i, am, am2, gv, (byte)1, b4);
        }
        return gv2;
    }
    
    private double a(final ik ik, final gv gv, final n n, final I i, final am am, final am am2) {
        final n a = ik.a(n.d(), i, am, am2, gv);
        if (n.a(n, a, 1.0E-4)) {
            return 0.0;
        }
        return t.a(n.k(), a.k());
    }
    
    private static double a(final gv gv) {
        if (gv.e() == 0) {
            return Math.abs(gv.b());
        }
        return Math.abs(gv.c()) + Math.abs(gv.b());
    }
    
    private static boolean a(final gv gv, final double n, final gv gv2, final double n2, final double n3) {
        return gv2 == null || n + 1.0E-4 < n2 || (n2 + 1.0E-4 > n && a(gv) < n3);
    }
    
    private static boolean c(final n n, final I i, final am am, final am am2) {
        final boolean z = fj.z;
        final v a = ae.a(i, am, am2, 0.0);
        int j = 0;
        boolean a2 = false;
        while (j < a.h() - 1) {
            a2 = n.a(n, a.a(j), 0.0);
            if (z) {
                return a2;
            }
            if (a2) {
                return true;
            }
            ++j;
            if (z) {
                break;
            }
        }
        return a2;
    }
    
    gv a(final n n, final aB ab, final gv gv, final byte b) {
        if (a(n)) {
            throw new IllegalArgumentException("Invalid label bounds: " + n);
        }
        return this.a(n, ab, ab.getSourceRealizer(), ab.getTargetRealizer(), gv, b, false);
    }
    
    static boolean a(final n n) {
        return Double.isNaN(n.b()) || Double.isNaN(n.c()) || Double.isNaN(n.e()) || Double.isNaN(n.f()) || Double.isNaN(n.g()) || Double.isNaN(n.i());
    }
}
