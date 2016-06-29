package y.b;

class o implements n
{
    private final double a;
    private final double b;
    private final double c;
    
    o(final double b, final double c) {
        this.a = 2.0 / (1.0 - b + c);
        this.b = b;
        this.c = c;
    }
    
    public double a(final double n) {
        if (0.0 >= n) {
            return 0.0;
        }
        if (1.0 <= n) {
            return 1.0;
        }
        if (this.b > n) {
            return this.a / (2.0 * this.b) * n * n;
        }
        if (this.c < n) {
            final double n2 = 1.0 - n;
            return 1.0 - this.a / (2.0 - 2.0 * this.c) * n2 * n2;
        }
        return this.a * (n - this.b / 2.0);
    }
}
