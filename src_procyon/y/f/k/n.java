package y.f.k;

import y.d.*;

class n
{
    static final n a;
    static final n b;
    static final n c;
    static final n d;
    static final n e;
    private final double[] f;
    private double g;
    
    private n(final double[] f) {
        this.g = Double.NaN;
        this.f = f;
    }
    
    private n(final double n, final double n2) {
        this(new double[] { n, n2 });
    }
    
    double a(final n n) {
        final int g = y.f.k.d.g;
        double n2 = 0.0;
        int i = 0;
        double n3 = 0.0;
        while (i < this.f.length) {
            n3 = n2 + this.f[i] * n.a(i);
            if (g != 0) {
                return n3;
            }
            n2 = n3;
            ++i;
            if (g != 0) {
                break;
            }
        }
        return n3;
    }
    
    double a(final int n) {
        return this.f[n];
    }
    
    n a(final l l) {
        return a(this.a(l.a(0)), this.a(l.a(1)));
    }
    
    public String toString() {
        final int g = y.f.k.d.g;
        final StringBuffer sb = new StringBuffer("Vector:\n");
        int i = 0;
        while (true) {
            while (i < this.f.length) {
                sb.append(this.f[i]).append(' ');
                ++i;
                if (g != 0) {
                    if (this == n.b) {
                        sb.append("\n EAST");
                    }
                    if (this == n.c) {
                        sb.append("\n SOUTH");
                    }
                    if (this == n.d) {
                        sb.append("\n WEST");
                    }
                    return sb.toString();
                }
                if (g != 0) {
                    break;
                }
            }
            if (this == n.a) {
                sb.append("\n NORTH");
            }
            continue;
        }
    }
    
    n a(final double n) {
        final int g = y.f.k.d.g;
        final double[] array = new double[this.f.length];
        int i = 0;
        double[] array2 = null;
        while (i < this.f.length) {
            final double n2 = this.f[i];
            array2 = array;
            if (g != 0) {
                return a(array2);
            }
            array2[i] = n2 * n;
            ++i;
            if (g != 0) {
                break;
            }
        }
        return a(array2);
    }
    
    double a() {
        final int g = y.f.k.d.g;
        if (Double.isNaN(this.g)) {
            this.g = 0.0;
            int i = 0;
            while (i < this.f.length) {
                final n n = this;
                if (g != 0) {
                    return n.g;
                }
                this.g += this.f[i];
                ++i;
                if (g != 0) {
                    break;
                }
            }
        }
        final n n = this;
        return n.g;
    }
    
    int b() {
        if (this == n.a) {
            return 0;
        }
        if (this == n.b) {
            return 1;
        }
        if (this == n.c) {
            return 2;
        }
        if (this == n.d) {
            return 3;
        }
        throw new IllegalArgumentException("not a direction " + this);
    }
    
    static n b(final int n) {
        if (n == 0) {
            return n.a;
        }
        if (n == 1) {
            return n.b;
        }
        if (n == 2) {
            return n.c;
        }
        if (n == 3) {
            return n.d;
        }
        throw new IllegalArgumentException("Invalid direction " + n);
    }
    
    static n a(final double[] array) {
        if (array.length == 2) {
            return a(array[0], array[1]);
        }
        return new n(array);
    }
    
    static n a(final double n, final double n2) {
        if (n.e.f[0] == n && n.e.f[1] == n2) {
            return n.e;
        }
        if (n.a.f[0] == n && n.a.f[1] == n2) {
            return n.a;
        }
        if (n.b.f[0] == n && n.b.f[1] == n2) {
            return n.b;
        }
        if (n.c.f[0] == n && n.c.f[1] == n2) {
            return n.c;
        }
        if (n.d.f[0] == n && n.d.f[1] == n2) {
            return n.d;
        }
        return new n(n, n2);
    }
    
    static n a(final t t) {
        return a(t.a(), t.b());
    }
    
    static {
        a = new n(0.0, -1.0);
        b = new n(1.0, 0.0);
        c = new n(0.0, 1.0);
        d = new n(-1.0, 0.0);
        e = new n(0.0, 0.0);
    }
}
