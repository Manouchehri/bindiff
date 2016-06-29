package y.f.e.a;

class al
{
    private a a;
    private a b;
    private double c;
    private double d;
    
    al() {
        this.a = new Z();
        this.b = new Z();
    }
    
    public void a(final k k) {
        this.b.a(this.a.d());
        this.b.b(this.a.e());
        this.b.c(this.a.f());
        this.a.a(k.d());
        this.a.b(k.e());
        this.a.c(k.f());
        this.c();
    }
    
    private void c() {
        this.d = this.c;
        final double c = this.a.c();
        final double c2 = this.b.c();
        if (c == 0.0 || c2 == 0.0) {
            this.c = 0.0;
            return;
        }
        this.c = (this.a.d() * this.b.d() + this.a.e() * this.b.e() + this.a.f() * this.b.f()) / (c * c2);
    }
    
    public double a() {
        return this.c;
    }
    
    public double b() {
        return this.d;
    }
}
