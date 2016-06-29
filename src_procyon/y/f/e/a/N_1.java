package y.f.e.a;

class N implements Y
{
    public double a(final double n) {
        if (this.b(n)) {
            return 0.0;
        }
        return -2.0 * n + 1.0;
    }
    
    public boolean b(final double n) {
        return n >= 0.5;
    }
}
