package y.f.f;

import y.f.f.a.*;
import y.f.*;

public class b extends c
{
    public static final Object n;
    private a o;
    private boolean p;
    private boolean q;
    private y.f.f.a r;
    
    protected y.f.f.a a() {
        return new y.f.f.a();
    }
    
    public y.f.f.a n() {
        if (this.r == null) {
            this.r = this.a();
        }
        return this.r;
    }
    
    public boolean o() {
        final ad b = this.b();
        if (b instanceof V) {
            return ((V)b).d();
        }
        if (this.q) {
            throw new IllegalStateException("No LabelLayoutTranslator registered");
        }
        return false;
    }
    
    public boolean p() {
        final ad b = this.b();
        if (b instanceof V) {
            return ((V)b).e() && ((V)b).c();
        }
        if (this.p) {
            throw new IllegalStateException("No LabelLayoutTranslator registered");
        }
        return false;
    }
    
    public void d(final ad ad) {
        super.d(ad);
    }
    
    public int q() {
        return this.o.a();
    }
    
    protected boolean b(final X x) {
        return this.o.b(x);
    }
    
    protected void a(final X x) {
        this.o.a(this.n());
        this.o.d(this.e());
        this.o.a(x);
    }
    
    public void c(final X x) {
        if (this.e() instanceof e) {
            final e e = (e)this.e();
            e.a(this.q());
            e.b(this.q());
            e.a(this.o() || this.p());
        }
        super.c(x);
    }
    
    static {
        n = y.f.f.c.n;
    }
}
