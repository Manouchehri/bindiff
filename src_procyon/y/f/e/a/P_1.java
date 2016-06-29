package y.f.e.a;

class P implements Y
{
    public double a(final double n) {
        if (this.b(n)) {
            return 0.0;
        }
        return 1.0 - n / 2.0;
    }
    
    public boolean b(final double n) {
        return n >= 2.0;
    }
}
