package y.f.f.c;

class d
{
    private double a;
    private int b;
    private g c;
    
    public d(final double a, final int b, final g c) {
        this.c = c;
        this.a = a;
        this.b = b;
    }
    
    public double a() {
        return this.a;
    }
    
    public int b() {
        return this.b;
    }
    
    public g c() {
        return this.c;
    }
    
    public String toString() {
        if (this.b == 0) {
            return "S: " + this.a + " " + this.c;
        }
        if (this.b == 1) {
            return "E: " + this.a + " " + this.c;
        }
        return null;
    }
}
