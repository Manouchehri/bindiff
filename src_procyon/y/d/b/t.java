package y.d.b;

public class t
{
    protected u a;
    private z e;
    private z f;
    private z g;
    protected double b;
    protected double c;
    protected double d;
    private int h;
    
    public t(final z e, final z f, final z g, final u a) {
        this.e = e;
        this.f = f;
        this.g = g;
        this.a = a;
        this.b = this.e.e();
        this.c = this.f.e();
        this.d = this.g.e();
        this.h = (int)(this.b + this.c + this.d);
    }
    
    public t(final z z, final z z2, final z z3) {
        this(z, z2, z3, y.d.b.d.a());
    }
    
    public z a() {
        return this.e;
    }
    
    public z b() {
        return this.f;
    }
    
    public z c() {
        return this.g;
    }
    
    public double a(final t t) {
        double acos = Math.acos((this.b * t.b + this.c * t.c) / (Math.sqrt(this.b * this.b + this.c * this.c) * Math.sqrt(t.b * t.b + t.c * t.c)));
        if (this.b * t.c + this.c * t.b > 0.0) {
            acos = 6.283185307179586 - acos;
        }
        return acos;
    }
    
    public boolean equals(final Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof t)) {
            return false;
        }
        final t t = (t)o;
        final z b = this.e.c(t.c()).b(t.a().c(this.g));
        final z b2 = this.f.c(t.c()).b(t.b().c(this.g));
        return b.c() == 0 && b2.c() == 0;
    }
    
    public int hashCode() {
        return this.h;
    }
    
    public String toString() {
        return "(" + this.e + "," + this.f + "," + this.g + ")";
    }
}
