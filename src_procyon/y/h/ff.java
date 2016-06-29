package y.h;

import java.util.*;
import y.h.a.*;
import y.c.*;
import y.d.*;
import y.f.*;
import java.awt.*;

public class ff
{
    public static final Object a;
    private boolean b;
    private boolean c;
    private boolean d;
    private c e;
    private c f;
    private c g;
    private c h;
    private boolean i;
    private boolean j;
    private static final fj k;
    
    public ff() {
        this.c = true;
        this.d = true;
    }
    
    public boolean a() {
        return this.b;
    }
    
    public void a(final boolean b) {
        this.b = b;
    }
    
    public boolean b() {
        return this.c;
    }
    
    public boolean c() {
        return this.d;
    }
    
    public void a(final bu bu) {
        if (this.a()) {
            this.c(bu);
        }
        if (this.b()) {
            this.b(bu);
        }
        this.h(bu);
    }
    
    private void h(final bu bu) {
        final fg fg = new fg(this);
        bu.d_(ff.a);
        bu.a(ff.a, fg);
    }
    
    protected void b(final bu bu) {
        final boolean z = fj.z;
        final h u = bu.u();
        final h u2 = bu.u();
        this.i = false;
        final x o = bu.o();
        while (true) {
            do {
                Label_0026: {
                    o.f();
                }
                boolean f = false;
                Label_0033:
                while (f) {
                    final fj t = bu.t(o.e());
                    final int portCount = t.portCount();
                    if (!z) {
                        Label_0231: {
                            if (portCount > 0) {
                                final Iterator ports = t.ports();
                                Label_0069:
                            Label_0226_Outer:
                                while (ports.hasNext()) {
                                    final eU eu = ports.next();
                                    final e d = eu.d();
                                    Label_0156: {
                                        if (d.k() > 1) {
                                            while (d.f()) {
                                                u2.a(d.a(), eu);
                                                d.g();
                                                if (z) {
                                                    break Label_0156;
                                                }
                                                if (z) {
                                                    break;
                                                }
                                            }
                                            this.i = true;
                                        }
                                    }
                                    final e e = eu.e();
                                    if (e.k() > 1) {
                                        while (true) {
                                            do {
                                                f = e.f();
                                                if (z) {
                                                    continue Label_0033;
                                                }
                                                if (!f) {
                                                    break;
                                                }
                                                u.a(e.a(), eu);
                                                e.g();
                                                if (!z) {
                                                    continue Label_0226_Outer;
                                                }
                                                if (z) {
                                                    break Label_0231;
                                                }
                                                continue Label_0069;
                                            } while (!z);
                                            this.i = true;
                                            continue;
                                        }
                                    }
                                }
                            }
                        }
                        o.g();
                        continue Label_0026;
                    }
                    if (portCount != 0) {
                        final Object c = aF.c;
                        this.g = bu.c(c);
                        if (this.g != null) {
                            bu.d_(c);
                        }
                        bu.a(c, u);
                        final Object d2 = aF.d;
                        this.h = bu.c(d2);
                        if (this.h != null) {
                            bu.d_(d2);
                        }
                        bu.a(d2, u2);
                    }
                    else {
                        bu.a(u);
                        bu.a(u2);
                    }
                    return;
                }
                break;
            } while (!z);
            final boolean i = this.i;
            continue;
        }
    }
    
    protected void c(final bu bu) {
        final boolean z = fj.z;
        final h u = bu.u();
        final h u2 = bu.u();
        boolean j = false;
        final v c = bu.C();
        final boolean b = c != null;
        final boolean b2 = !this.c();
        final e p = bu.p();
        while (true) {
            while (p.f()) {
                final d a = p.a();
                final eU a2 = eU.a(bu, a, true);
                final Object a3;
                final eU eu = (eU)(a3 = a2);
                if (z) {
                    final Object o = a3;
                    this.e = bu.c(o);
                    if (this.e != null) {
                        bu.d_(o);
                    }
                    bu.a(o, u);
                    final Object b3 = aF.b;
                    this.f = bu.c(b3);
                    if (this.f != null) {
                        bu.d_(b3);
                    }
                    bu.a(b3, u2);
                    return;
                }
                if (eu != null) {
                    Label_0171: {
                        if (b2 && b && c.k(a.c())) {
                            u.a(a, aE.a(this.a(a2)));
                            if (!z) {
                                break Label_0171;
                            }
                        }
                        bu.i(a).setSourcePoint(eU.b(a2));
                        u.a(a, aE.a(this.a(a2), true));
                    }
                    j = true;
                }
                final eU a4 = eU.a(bu, a, false);
                if (a4 != null) {
                    Label_0265: {
                        if (b2 && b && c.k(a.d())) {
                            u2.a(a, aE.a(this.a(a4)));
                            if (!z) {
                                break Label_0265;
                            }
                        }
                        bu.i(a).setTargetPoint(eU.b(a4));
                        u2.a(a, aE.a(this.a(a4), true));
                    }
                    j = true;
                }
                p.g();
                if (z) {
                    break;
                }
            }
            this.j = j;
            if (j) {
                final Object a3 = aF.a;
                continue;
            }
            break;
        }
        bu.a(u);
        bu.a(u2);
    }
    
    protected byte a(final eU eu) {
        final t h = eu.h();
        final fj b = eu.b();
        final double centerX = b.getCenterX();
        final double centerY = b.getCenterY();
        final double width = b.getWidth();
        final double height = b.getHeight();
        final double n = width * 0.25;
        final double n2 = height * 0.25;
        if (centerX - n <= h.a() && h.a() <= centerX + n && centerY - n2 <= h.b() && h.b() <= centerY + n2) {
            return 0;
        }
        byte b2 = 0;
        double n3 = Double.POSITIVE_INFINITY;
        final double x = b.getX();
        final double y = b.getY();
        final double abs = Math.abs(y - h.b());
        if (n3 > abs) {
            n3 = abs;
            b2 = 1;
        }
        final double abs2 = Math.abs(y + height - h.b());
        if (n3 > abs2) {
            n3 = abs2;
            b2 = 2;
        }
        final double abs3 = Math.abs(x - h.a());
        if (n3 > abs3) {
            n3 = abs3;
            b2 = 8;
        }
        if (n3 > Math.abs(x + width - h.a())) {
            b2 = 4;
        }
        return b2;
    }
    
    public void d(final bu bu) {
        this.i(bu);
        Label_0028: {
            if (this.a()) {
                this.f(bu);
                if (!fj.z) {
                    break Label_0028;
                }
            }
            this.g(bu);
        }
        if (this.b()) {
            this.e(bu);
        }
    }
    
    private void i(final bu bu) {
        bu.d_(ff.a);
    }
    
    protected void e(final bu bu) {
        if (this.i) {
            final Object c = aF.c;
            final c c2 = bu.c(c);
            if (c2 != null) {
                bu.d_(c);
                if (c2 instanceof h) {
                    bu.a((h)c2);
                }
            }
            if (this.g != null) {
                bu.a(c, this.g);
                this.g = null;
            }
            final Object d = aF.d;
            final c c3 = bu.c(d);
            if (c3 != null) {
                bu.d_(d);
                if (c3 instanceof h) {
                    bu.a((h)c3);
                }
            }
            if (this.h != null) {
                bu.a(d, this.h);
                this.h = null;
            }
        }
    }
    
    protected void f(final bu bu) {
        final boolean z = fj.z;
        if (this.j) {
            final c c = bu.c(aF.a);
            final c c2 = bu.c(aF.b);
            final e p = bu.p();
            while (true) {
                while (p.f()) {
                    final d a = p.a();
                    final aB i = bu.i(a);
                    final eU a2 = eU.a(bu, a, true);
                    final Object a3;
                    final eU eu = (eU)(a3 = a2);
                    if (!z) {
                        Label_0123: {
                            if (eu != null) {
                                if (b(c, a)) {
                                    i.setSourcePoint(eU.b(a2));
                                    if (!z) {
                                        break Label_0123;
                                    }
                                }
                                eU.a(a2, i.getSourcePoint());
                            }
                        }
                        final eU a4 = eU.a(bu, a, false);
                        Label_0176: {
                            if (a4 != null) {
                                if (b(c2, a)) {
                                    i.setTargetPoint(eU.b(a4));
                                    if (!z) {
                                        break Label_0176;
                                    }
                                }
                                eU.a(a4, i.getTargetPoint());
                            }
                        }
                        p.g();
                        if (z) {
                            break;
                        }
                        continue;
                    }
                    else {
                        final Object o = a3;
                        if (c != null) {
                            bu.d_(o);
                            if (c instanceof h) {
                                bu.a((h)c);
                            }
                        }
                        if (this.e != null) {
                            bu.a(o, this.e);
                            this.e = null;
                        }
                        final Object b = aF.b;
                        if (c2 == null) {
                            return;
                        }
                        bu.d_(b);
                        if (c2 instanceof h) {
                            bu.a((h)c2);
                        }
                        if (this.f != null) {
                            bu.a(b, this.f);
                            this.f = null;
                        }
                        return;
                    }
                }
                Object a3 = aF.a;
                continue;
            }
        }
    }
    
    protected void g(final bu bu) {
        final boolean z = fj.z;
        final x o = bu.o();
        while (o.f()) {
            final fj t = bu.t(o.e());
            Label_0084: {
                if (t.portCount() > 0) {
                    final Iterator ports = t.ports();
                    while (ports.hasNext()) {
                        this.a(bu, ports.next());
                        if (z) {
                            break Label_0084;
                        }
                        if (z) {
                            break;
                        }
                    }
                }
                o.g();
            }
            if (z) {
                break;
            }
        }
    }
    
    private void a(final bu bu, final eU eu) {
        final boolean z = fj.z;
        final e c = eu.c();
        if (c.f()) {
            d d = null;
            d d2 = null;
            while (true) {
                while (c.f()) {
                    final d a;
                    final d d3 = a = c.a();
                    if (!z) {
                        Label_0068: {
                            if (a.e()) {
                                d = d3;
                                if (!z) {
                                    break Label_0068;
                                }
                            }
                            d2 = d3;
                        }
                        c.g();
                        if (z) {
                            break;
                        }
                        continue;
                    }
                    else {
                        final aB ab = (a == null) ? bu.i(d) : bu.i(d2);
                        if (eU.b(ab) == eu) {
                            eU.a(eu, ab.getSourcePoint());
                            if (!z) {
                                return;
                            }
                        }
                        if (eU.d(ab) == eu) {
                            eU.a(eu, ab.getTargetPoint());
                        }
                        return;
                    }
                }
                continue;
            }
        }
    }
    
    public ad d() {
        return new fi(this, null);
    }
    
    private static boolean b(final c c, final d d) {
        if (c == null) {
            return false;
        }
        final Object b = c.b(d);
        return b != null && ((aE)b).a();
    }
    
    private static fj f() {
        final aZ az = new aZ();
        az.setLocation(0.0, 0.0);
        az.setFillColor(null);
        az.setFillColor2(null);
        az.setLineColor(null);
        while (az.labelCount() > 0) {
            az.removeLabel(az.getLabel(0));
        }
        az.addPort(new eU());
        return az;
    }
    
    static fj e() {
        return ff.k;
    }
    
    static boolean a(final c c, final d d) {
        return b(c, d);
    }
    
    static {
        a = "y.view.NodePortLayoutConfigurator#EDGE2D_DPKEY";
        k = f();
    }
}
