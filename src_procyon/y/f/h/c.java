package y.f.h;

import y.g.*;
import y.c.*;
import y.f.h.a.*;

public class c implements o
{
    private D a;
    private boolean b;
    private boolean c;
    private boolean d;
    private boolean e;
    private int f;
    private int g;
    private al h;
    private int i;
    private int j;
    private int k;
    
    public c() {
        this.b = false;
        this.c = false;
        this.d = false;
        this.e = false;
        this.f = -1;
        this.g = 30;
        this.h = new al();
        this.i = 0;
        this.j = 0;
        this.k = 0;
    }
    
    public void a(final D a) {
        this.a = a;
    }
    
    public void a(final boolean c) {
        this.c = c;
    }
    
    public void b(final boolean d) {
        this.d = d;
    }
    
    public void c(final boolean e) {
        this.e = e;
    }
    
    public void a(final int f) {
        this.f = f;
    }
    
    public void d(final boolean b) {
        this.b = b;
    }
    
    public int b() {
        return this.i;
    }
    
    public int d() {
        return this.j;
    }
    
    public int e() {
        return this.k;
    }
    
    public void c() {
        final boolean d = N.d;
        final StringBuffer sb = new StringBuffer();
        sb.append("\n***************************************");
        sb.append("********   PLANAR EMBEDDING    ********");
        sb.append("***************************************");
        y.g.o.a(this, 0, sb);
        final StringBuffer sb2 = new StringBuffer();
        sb2.append("\nSETTINGS:");
        sb2.append("  use biconnected components: " + this.d);
        sb2.append("  edge rerouting enabled    : " + this.c);
        Label_0170: {
            if (this.f == -1) {
                sb2.append("  no reroute iterations bound");
                if (!d) {
                    break Label_0170;
                }
                y.c.i.g = !y.c.i.g;
            }
            sb2.append("  reroute iterations        : " + this.f);
        }
        sb2.append("  allow randomization       : " + this.b + "\n");
        y.g.o.a(this, 3, sb2);
        if (this.a == null) {
            throw new RuntimeException("Forgot to set PlanarInformation!");
        }
        final I i = new I(this.a);
        i.a();
        final f f = new f(this.a.g().p());
        final y y = new y();
        y.a(this.a.g());
        this.h.e();
        x a;
        if (this.d) {
            a = new a(this.a((short)0));
        }
        else {
            a = this.a((short)0);
        }
        a.a(this.a);
        this.i = (int)this.h.d();
        if (this.e) {
            new e().a(this.a);
        }
        final n n = new n(this.a);
        final f c_ = a.c_();
        y.g.o.a(this, 3, "HANDLE MULTIPLE EDGES !");
        i.b();
        y.a(this.a, c_);
        y.a();
        this.h.e();
        y.g.o.a(this, 0, "REINSERTION: " + c_.size() + "  graph edges");
        n.a(c_);
        if (y.g.o.b(this) && !this.a.n()) {
            throw new RuntimeException("Combinatorial Embedder failed !");
        }
        this.j = (int)this.h.d();
        this.h.e();
        if (this.c) {
            y.g.o.a(this, 0, "REROUTE EDGES");
            y.g.o.a(this, 0, "  number of crossings (before rerouting): " + this.a.a());
            n.a(this.f, f);
            y.g.o.a(this, 0, "  number of crossings (after rerouting): " + this.a.a());
        }
        this.k = (int)this.h.d();
        p p = null;
        final q h = this.a.h();
        while (h.f()) {
            final p a2 = h.a();
            if (d) {
                return;
            }
            Label_0688: {
                if (p == null) {
                    p = a2;
                    if (!d) {
                        break Label_0688;
                    }
                }
                if (p.a().k() < a2.a().k()) {
                    p = a2;
                }
            }
            h.g();
            if (d) {
                break;
            }
        }
        this.a.b(p);
        this.a.k();
        y.g.o.a(this, 0, "\n**********************************");
        y.g.o.a(this, 0, "***** PLANAR EMBEDDING DONE! *****");
        y.g.o.a(this, 0, "**********************************\n");
    }
    
    public void a() {
        this.a.b();
        this.a.e();
    }
    
    protected x a(final short n) {
        switch (n) {
            case 0: {
                final s s = new s();
                s.a(this.b);
                s.a(this.g);
                return new H(s);
            }
            case 1: {
                return new V();
            }
            default: {
                return null;
            }
        }
    }
}
