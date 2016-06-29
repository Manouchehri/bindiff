package y.h.b;

import y.c.*;
import java.util.*;
import y.h.*;

public class T extends ae implements cf
{
    private f a;
    private y.h.b.c b;
    private byte c;
    private boolean d;
    private boolean e;
    private boolean f;
    private final WeakHashMap g;
    
    public T() {
        this.g = new WeakHashMap();
        this.c = 1;
        this.d = true;
        this.f = true;
    }
    
    public boolean a(final double n, final double n2) {
        this.a = null;
        this.b = null;
        if (this.h != null && this.i != null) {
            final q a = this.a(new cW(this.h, n, n2, true));
            if (a != null) {
                final bu graph2D = this.h.getGraph2D();
                if (graph2D != null && ae.a(graph2D, a) == this.i) {
                    final f a2 = this.i.l().a(n, n2);
                    if (a2 != null && this.a(a2, n, n2)) {
                        this.a = a2;
                        return true;
                    }
                    final y.h.b.c b = this.i.l().b(n, n2);
                    if (b != null && this.a(b, n, n2)) {
                        this.b = b;
                        return true;
                    }
                    if (a2 == null && b == null) {
                        if (a(this.i.l())) {
                            return !this.i.isSelected();
                        }
                        return this.h();
                    }
                }
            }
        }
        this.i();
        return false;
    }
    
    private static boolean a(final i i) {
        return i.c().isEmpty() && i.b().isEmpty();
    }
    
    protected boolean a(final y.h.b.c c, final double n, final double n2) {
        return this.a(this.i, c, n, n2, this.k());
    }
    
    protected boolean a(final f f, final double n, final double n2) {
        return this.a(this.i, f, n, n2, this.k());
    }
    
    protected boolean d(final dw dw) {
        return (dw.d() & 0x40) != 0x0;
    }
    
    public void onGraph2DSelectionEvent(final ce ce) {
        final Object d = ce.d();
        if (ce.a() && this.l()) {
            final fj a = ae.a(ce.e(), (q)d);
            if (a instanceof a && !a.isSelected()) {
                this.a((a)a);
            }
        }
    }
    
    public byte g() {
        return this.c;
    }
    
    public boolean h() {
        return this.d;
    }
    
    public boolean j() {
        return this.e;
    }
    
    public boolean k() {
        return this.f;
    }
    
    private void a(final a a) {
        final int h = a.H;
        Iterator<f> iterator = a.l().c().iterator();
        while (true) {
            while (iterator.hasNext()) {
                this.a((y.h.b.c)iterator.next(), false);
                if (h != 0) {
                    while (iterator.hasNext()) {
                        this.a(iterator.next(), false);
                        if (h != 0) {
                            break;
                        }
                    }
                    return;
                }
                if (h != 0) {
                    break;
                }
            }
            iterator = a.l().b().iterator();
            continue;
        }
    }
    
    public boolean a(final dw dw) {
        return this.i(dw);
    }
    
    private boolean i(final dw dw) {
        return this.g(dw) && this.a(dw.a(), dw.b());
    }
    
    public void b(final dw dw) {
        final int h = y.h.b.a.H;
        if (this.i(dw) && this.h != null) {
            final bu graph2D = this.h.getGraph2D();
            Label_0134: {
                if (this.i != null) {
                    if (this.l() && !this.g.containsKey(graph2D)) {
                        graph2D.a(this);
                        this.g.put(graph2D, null);
                    }
                    if (this.a != null) {
                        this.a(graph2D, this.a, this.d(dw));
                        if (h == 0) {
                            break Label_0134;
                        }
                    }
                    if (this.b != null) {
                        this.a(graph2D, this.b, this.d(dw));
                        if (h == 0) {
                            break Label_0134;
                        }
                    }
                    this.a(graph2D, this.i.l(), this.d(dw));
                }
            }
            graph2D.T();
        }
        this.e();
    }
    
    protected void a(final bu bu, final y.h.b.c c, final boolean b) {
        this.a(bu, new V(this, c), b);
    }
    
    protected void a(final bu bu, final f f, final boolean b) {
        this.a(bu, new U(this, f), b);
    }
    
    private void a(final bu bu, final W w, final boolean b) {
        final a b2 = w.b();
        Label_0076: {
            if (b) {
                if (!this.j() && !w.a(b2.l())) {
                    break Label_0076;
                }
                w.a(!w.a());
                if (y.h.b.a.H == 0) {
                    break Label_0076;
                }
            }
            this.a(b2);
            bu.N();
            w.a(true);
        }
        if (this.l() && !b2.isSelected()) {
            this.a(b2, true);
        }
    }
    
    private boolean l() {
        return 2 == this.g();
    }
    
    protected void a(final bu bu, final i i, final boolean b) {
        final int h = y.h.b.a.H;
        if (a(i)) {
            if (b) {
                if (!this.a(bu)) {
                    return;
                }
                this.a(i.a(), true);
                if (h == 0) {
                    return;
                }
            }
            bu.N();
            this.a(i.a(), true);
            if (h == 0) {
                return;
            }
        }
        if (this.h()) {
            this.a(i.a());
        }
    }
    
    private boolean a(final bu bu) {
        return bu.H() || bu.J().f() || bu.M().f();
    }
    
    protected void a(final a a, final boolean b) {
        final int h = a.H;
        if (b) {
            final q node = a.getNode();
            if (node == null) {
                a.setSelected(true);
                if (h == 0) {
                    return;
                }
            }
            gg.a((bu)node.e(), node);
            if (h == 0) {
                return;
            }
        }
        a.setSelected(false);
    }
    
    protected void a(final y.h.b.c c, final boolean b) {
        c.a(b);
    }
    
    protected void a(final f f, final boolean b) {
        f.a(b);
    }
    
    void i() {
        super.i();
        this.a = null;
        this.b = null;
    }
}
