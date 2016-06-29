package y.f.i.a;

class by extends bw
{
    private final int[] a;
    private final int[] b;
    private final bs c;
    
    by(final bs c, final int n, final int n2) {
        final int a = ab.a;
        super(c);
        this.c = c;
        final boolean b = n > n2;
        this.a = new int[bs.c(c).b()];
        this.b = new int[bs.c(c).b()];
        int i = 0;
        while (i < bs.c(c).b()) {
            Label_0173: {
                if ((i < n && i < n2) || (i > n && i > n2)) {
                    this.a[i] = i;
                    this.b[i] = i;
                    if (a == 0) {
                        break Label_0173;
                    }
                }
                if (i != n && i != n2) {
                    this.a[i] = (b ? (i - 1) : (i + 1));
                    this.b[i] = (b ? (i + 1) : (i - 1));
                }
            }
            ++i;
            if (a != 0) {
                break;
            }
        }
        this.a[n] = (b ? (n - 1) : (n + 1));
        this.b[n] = n2;
        this.a[n2] = n;
        this.b[n2] = (b ? (n2 + 1) : (n2 - 1));
    }
    
    public int a(final int n) {
        return this.a[n];
    }
    
    public int b(final int n) {
        return this.b[n];
    }
}
