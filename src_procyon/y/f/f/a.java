package y.f.f;

public class a
{
    private double b;
    private double c;
    private double d;
    public static boolean a;
    
    public a() {
        this.b = 15.0;
        this.c = 15.0;
        this.d = 15.0;
    }
    
    public void a(final double b) {
        this.b = b;
    }
    
    public double a() {
        return this.b;
    }
    
    public void b(final double c) {
        this.c = c;
    }
    
    public double b() {
        return this.c;
    }
    
    public void c(final double d) {
        this.d = d;
    }
    
    public double c() {
        return this.d;
    }
    
    public a d() {
        final a a = new a();
        a.a(this.a());
        a.b(this.b());
        a.c(this.c());
        return a;
    }
}
