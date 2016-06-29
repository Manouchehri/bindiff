package y.f.e.a;

class U implements Y
{
    public double a(final double n) {
        if (this.b(n)) {
            return 0.0;
        }
        return -4.0 * n / 3.0 + 1.0;
    }
    
    public boolean b(final double n) {
        return n >= 0.75;
    }
}
