package y.f.c;

import y.c.*;
import y.d.*;

public class z
{
    int a;
    boolean b;
    double c;
    double d;
    public double e;
    public double f;
    double g;
    double h;
    double i;
    double j;
    double k;
    public f l;
    
    z(final double d, final double c, final int a, final boolean b) {
        this.g = 0.0;
        this.h = 20.0;
        this.i = 0.0;
        this.j = 20.0;
        this.k = 20.0;
        this.l = new f();
        this.a = a;
        this.b = b;
        this.d = d;
        this.c = c;
    }
    
    public void a(final double h) {
        this.h = h;
    }
    
    public void a(final double n, final double k) {
        this.k = k;
        this.a(n);
    }
    
    public double a() {
        return this.e += this.j;
    }
    
    public double b() {
        if (this.f < this.h) {
            this.f = Math.max(this.f + this.k, this.h);
            if (!y.f.c.a.i) {
                return this.f;
            }
        }
        this.f += this.k;
        return this.f;
    }
    
    public void b(final double f) {
        this.f = f;
    }
    
    public void b(final double n, final double n2) {
        this.d(n);
        this.c(n2);
    }
    
    public void c(final double n) {
        this.i = n;
        this.f = n;
    }
    
    public void d(final double g) {
        this.g = g;
        this.e = g - this.j;
    }
    
    public void c() {
        this.c(this.i);
        this.d(this.g);
    }
    
    public double d() {
        if (this.l.size() < 1) {
            return this.i;
        }
        return Math.max(this.i + this.k * this.l.size(), this.h + this.k * (this.l.size() - 1));
    }
    
    public double a(final int n) {
        if (n == 0) {
            return this.i;
        }
        return Math.max(this.i + this.k * n, this.h + this.k * (n - 1));
    }
    
    public double e() {
        if (this.l.size() == 0) {
            return this.i;
        }
        return Math.max(this.i + this.k * this.l.size(), this.h + this.k * (this.l.size() - 1));
    }
    
    public double f() {
        if (this.l.size() < 1) {
            return this.g;
        }
        return this.g + this.j * (this.l.size() - 1);
    }
    
    public double g() {
        if (this.l.size() < 1) {
            return this.g;
        }
        return this.g + this.j * this.l.size();
    }
    
    public t c(final double n, final double n2) {
        if (this.b) {
            switch (this.a) {
                case 0: {
                    return new t(this.d - n, this.c - n2);
                }
                case 1: {
                    return new t(this.d + n2, this.c - n);
                }
                case 2: {
                    return new t(this.d + n, this.c + n2);
                }
                case 3: {
                    return new t(this.d - n2, this.c + n);
                }
                default: {
                    throw new RuntimeException("Cannot be!");
                }
            }
        }
        else {
            switch (this.a) {
                case 0: {
                    return new t(this.d + n, this.c - n2);
                }
                case 1: {
                    return new t(this.d + n2, this.c + n);
                }
                case 2: {
                    return new t(this.d - n, this.c + n2);
                }
                case 3: {
                    return new t(this.d - n2, this.c - n);
                }
                default: {
                    throw new RuntimeException("Cannot be!");
                }
            }
        }
    }
    
    public double d(final double n, final double n2) {
        if (this.b) {
            switch (this.a) {
                case 0: {
                    return this.d - n;
                }
                case 1: {
                    return this.c - n2;
                }
                case 2: {
                    return n - this.d;
                }
                case 3: {
                    return n2 - this.c;
                }
                default: {
                    throw new RuntimeException("Cannot be!");
                }
            }
        }
        else {
            switch (this.a) {
                case 0: {
                    return n - this.d;
                }
                case 1: {
                    return n2 - this.c;
                }
                case 2: {
                    return this.d - n;
                }
                case 3: {
                    return this.c - n2;
                }
                default: {
                    throw new RuntimeException("Cannot be!");
                }
            }
        }
    }
    
    public double e(final double n, final double n2) {
        if (this.b) {
            switch (this.a) {
                case 0: {
                    return this.c - n2;
                }
                case 1: {
                    return this.c - n;
                }
                case 2: {
                    return this.c + n2;
                }
                case 3: {
                    return this.c + n;
                }
                default: {
                    throw new RuntimeException("Cannot be!");
                }
            }
        }
        else {
            switch (this.a) {
                case 0: {
                    return this.c - n2;
                }
                case 1: {
                    return this.c + n;
                }
                case 2: {
                    return this.c + n2;
                }
                case 3: {
                    return this.c - n;
                }
                default: {
                    throw new RuntimeException("Cannot be!");
                }
            }
        }
    }
    
    public double f(final double n, final double n2) {
        if (this.b) {
            switch (this.a) {
                case 0: {
                    return this.d - n;
                }
                case 1: {
                    return this.d + n2;
                }
                case 2: {
                    return this.d + n;
                }
                case 3: {
                    return this.d - n2;
                }
                default: {
                    throw new RuntimeException("Cannot be!");
                }
            }
        }
        else {
            switch (this.a) {
                case 0: {
                    return this.d + n;
                }
                case 1: {
                    return this.d + n2;
                }
                case 2: {
                    return this.d - n;
                }
                case 3: {
                    return this.d - n2;
                }
                default: {
                    throw new RuntimeException("Cannot be!");
                }
            }
        }
    }
}
