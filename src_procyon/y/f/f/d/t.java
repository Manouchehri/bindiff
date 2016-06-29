package y.f.f.d;

import y.f.*;
import y.f.f.b.*;
import y.g.*;
import y.c.*;
import y.f.f.c.*;

public class t implements p
{
    public static final Object a;
    protected h b;
    protected X c;
    private f g;
    private short h;
    protected short d;
    protected int e;
    protected int f;
    private boolean i;
    private m j;
    private boolean k;
    
    public t() {
        this.g = new g();
        this.h = 0;
        this.d = 0;
        this.e = 3;
        this.f = 50;
        this.i = false;
        this.k = false;
    }
    
    public void a(final h b) {
        this.c = (X)b.a();
        this.b = b;
    }
    
    public boolean b() {
        return this.k;
    }
    
    public void a(final int f) {
        this.f = f;
    }
    
    public void a(final m j) {
        this.j = j;
    }
    
    public short c() {
        return this.h;
    }
    
    public void a(final short h) {
        this.h = h;
    }
    
    public void b(final short d) {
        this.d = d;
    }
    
    public void b(final int e) {
        this.e = e;
    }
    
    public void a(final boolean i) {
        this.i = i;
    }
    
    public void a(final f g) {
        this.g = g;
    }
    
    public void a() {
        o.a(this, 1, "------->>> Entering Compaction Phase");
        final al al = new al();
        o.a(this, 2, "-----> Introduce dummy nodes for labels");
        o.a(this, 2, "-----> Split nodes");
        final y y = new y(this.b, this.h, this.f);
        y.f.f.d.y.a(this.i);
        y.b(this.b());
        y.c();
        this.j.h = (int)al.d();
        al.e();
        o.a(this, 2, "-----> Do compaction");
        final r r = new r();
        r.a(this.d());
        r.a(y.a());
        final A t = y.a().a().t();
        final D b = y.b();
        if (this.g instanceof g) {
            ((g)this.g).a(b);
        }
        r.a(this.g);
        r.a(this.e);
        r.a(t);
        this.j.i = (int)al.d();
        al.e();
        y.a(t, this.c);
        y.a().a().a(t);
        this.j.n = (int)al.d();
        this.j.q = y.g();
        this.j.s = y.f();
        this.j.r = y.e();
        this.j.j = r.a();
        this.j.k = r.b();
        this.j.l = r.c();
        this.j.m = r.d();
        o.a(this, 3, "-> Total running time of compaction Phase: " + al);
        o.a(this, 1, "<<<------- Leaving Compaction Phase");
    }
    
    protected l d() {
        switch (this.d) {
            case 0: {
                return new k();
            }
            case 1: {
                return new y.f.f.c.h();
            }
            case 2: {
                return new n();
            }
            default: {
                o.a((Object)"Unknown Compactor !");
                return null;
            }
        }
    }
    
    static {
        a = "y.layout.orthogonal.kandinsky.KanCompactor.BORDER_DPKEY";
    }
}
