package y.f.e.a;

class X implements Y
{
    public double a(final double n) {
        if (this.b(n)) {
            return 0.0;
        }
        return (1.0 - n) * (1.0 - n) * (1.0 - n);
    }
    
    public boolean b(final double n) {
        return n >= 1.0;
    }
}
