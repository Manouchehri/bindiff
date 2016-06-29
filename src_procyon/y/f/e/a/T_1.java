package y.f.e.a;

class T implements Y
{
    public double a(final double n) {
        if (this.b(n)) {
            return 0.0;
        }
        return n * n * n;
    }
    
    public boolean b(final double n) {
        return n <= 0.0;
    }
}
