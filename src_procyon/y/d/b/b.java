package y.d.b;

public class b
{
    protected u a;
    private z b;
    private z c;
    private z d;
    private double e;
    private double f;
    private double g;
    private int h;
    
    public b(final z b, final z c, final z d, final u a) {
        Label_0070: {
            if (d.f(d.a()) > 0) {
                this.b = b;
                this.c = c;
                this.d = d;
                if (y.d.b.c.a == 0) {
                    break Label_0070;
                }
            }
            this.b = b.d();
            this.c = c.d();
            this.d = d.d();
        }
        this.e = this.b.e();
        this.f = this.c.e();
        this.g = this.d.e();
        this.h = (int)(this.e + this.f + this.g);
        this.a = a;
    }
    
    public b(final z z, final z z2, final u u) {
        this(z, z2, z.b(), u);
    }
    
    public b(final z z, final z z2, final z z3) {
        this(z, z2, z3, y.d.b.d.a());
    }
    
    public final z a() {
        return this.b;
    }
    
    public final z b() {
        return this.c;
    }
    
    public final z c() {
        return this.d;
    }
    
    public final double d() {
        return this.e;
    }
    
    public final double e() {
        return this.f;
    }
    
    public final double f() {
        return this.g;
    }
    
    public final t a(final b b) {
        return new t(this.b.c(b.c()).b(b.a().c(this.d)), this.c.c(b.c()).b(b.b().c(this.d)), this.d.c(b.c()));
    }
    
    public final void g() {
        final z e = this.b.e(this.c).e(this.d);
        this.b = this.b.d(e);
        this.c = this.c.d(e);
        this.d = this.d.d(e);
        this.e = this.b.e();
        this.f = this.c.e();
        this.g = this.d.e();
    }
    
    public final boolean equals(final Object o) {
        if (o == this) {
            return true;
        }
        if (!(o instanceof b)) {
            return false;
        }
        final b b = (b)o;
        final z b2 = this.b.c(b.c()).b(b.a().c(this.d));
        final z b3 = this.c.c(b.c()).b(b.b().c(this.d));
        return b2.c() == 0 && b3.c() == 0;
    }
    
    public int hashCode() {
        return this.h;
    }
    
    public String toString() {
        return "X: " + this.b + " Y: " + this.c + " W: " + this.d;
    }
}
