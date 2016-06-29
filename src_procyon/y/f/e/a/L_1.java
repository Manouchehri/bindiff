package y.f.e.a;

class L implements Y
{
    public double a(final double n) {
        if (this.b(n)) {
            return 0.0;
        }
        return Math.sqrt(n);
    }
    
    public boolean b(final double n) {
        return n <= 0.0;
    }
}
