package y.f.f.b;

public class o
{
    public static final o a;
    public static final o b;
    public static final o c;
    public static final o d;
    public static final o e;
    private static final String[] f;
    private static final char[] g;
    private int h;
    private static double i;
    
    o(int i) {
        if (i != 1000) {
            while (i < 0) {
                i += 4;
            }
            while (i > 3) {
                i -= 4;
            }
        }
        this.h = i;
    }
    
    public static o a(int i) {
        final int a = h.a;
        Label_0042: {
            if (i != 1000) {
                while (i < 0) {
                    i += 4;
                    if (a != 0) {
                        break Label_0042;
                    }
                    if (a != 0) {
                        break;
                    }
                }
                while (i > 3) {
                    i -= 4;
                    if (a != 0) {
                        return o.a;
                    }
                    if (a != 0) {
                        break;
                    }
                }
            }
        }
        switch (i) {
            case 0: {
                return o.a;
            }
            case 1: {
                return o.b;
            }
            case 2: {
                return o.c;
            }
            case 3: {
                return o.d;
            }
            case 1000: {
                return o.e;
            }
            default: {
                throw new RuntimeException("Invalid number in direction construction: " + i);
            }
        }
    }
    
    public static o a(final char c) {
        final int a = h.a;
        Label_0080: {
            switch (c) {
                case '^': {
                    final int n = 0;
                    if (a != 0) {
                        break Label_0080;
                    }
                    return a(n);
                }
                case '>': {
                    final int n = 1;
                    if (a != 0) {
                        break Label_0080;
                    }
                    return a(n);
                }
                case '_': {
                    final int n = 2;
                    if (a != 0) {
                        break Label_0080;
                    }
                    return a(n);
                }
                case '<': {
                    final int n = 3;
                    if (a != 0) {
                        break Label_0080;
                    }
                    return a(n);
                }
                case '+': {
                    final int n = 1000;
                    if (a != 0) {
                        break;
                    }
                    return a(n);
                }
            }
        }
        throw new RuntimeException("Direction Constructor: Invalid character: " + c);
    }
    
    public o a() {
        if (this == o.e) {
            return a(this.h);
        }
        int n = this.h + 1;
        if (n > 3) {
            n = 0;
        }
        return a(n);
    }
    
    public o b(final int n) {
        final int a = y.f.f.b.h.a;
        if (this == o.e) {
            return a(this.h);
        }
        o o = this;
        int i = 0;
        o a2 = null;
        while (i < n) {
            a2 = o.a();
            if (a != 0) {
                return a2;
            }
            o = a2;
            ++i;
            if (a != 0) {
                break;
            }
        }
        return a2;
    }
    
    public o b() {
        if (this == o.e) {
            return a(this.h);
        }
        int n = this.h - 1;
        if (n < 0) {
            n = 3;
        }
        return a(n);
    }
    
    public o c() {
        if (this == o.e) {
            return o.e;
        }
        int n = this.h + 2;
        if (n > 3) {
            n -= 4;
        }
        return a(n);
    }
    
    public boolean d() {
        final int f = this.f();
        return f == 1 || f == 3;
    }
    
    public boolean e() {
        final int f = this.f();
        return f == 0 || f == 2;
    }
    
    public boolean a(final o o) {
        return this != o.e && o != o.e && this.h == o.f();
    }
    
    public int f() {
        return this.h;
    }
    
    public int g() {
        return this.h;
    }
    
    public String toString() {
        if (this == o.e) {
            return "+";
        }
        return o.f[this.h];
    }
    
    static {
        a = new o(0);
        b = new o(1);
        c = new o(2);
        d = new o(3);
        e = new o(1000);
        f = new String[] { "^", ">", "_", "<" };
        g = new char[] { '^', '>', '_', '<' };
        o.i = 1.0E-4;
    }
}
