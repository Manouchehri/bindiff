package y.h;

import y.d.*;

public class fm implements fO
{
    private static final fm j;
    public static final fP a;
    public static final fP b;
    public static final fP c;
    public static final fP d;
    public static final fP e;
    public static final fP f;
    public static final fP g;
    public static final fP h;
    public static final fP i;
    private byte k;
    
    public fm() {
        this.k = 5;
    }
    
    public byte a() {
        return this.k;
    }
    
    public t a(final eU eu, final fP fp) {
        final fn a = a(fp);
        final fj b = eu.b();
        return new t(b.getCenterX() + a.b * b.getWidth(), b.getCenterY() + a.c * b.getHeight());
    }
    
    public fP a(final fj fj, final t t) {
        switch (this.a()) {
            case 1: {
                return this.e(fj, t);
            }
            case 2: {
                return this.b(fj, t);
            }
            case 3: {
                return this.c(fj, t);
            }
            case 4: {
                return this.d(fj, t);
            }
            case 5: {
                return this.f(fj, t);
            }
            default: {
                throw new IllegalStateException("Invalid policy: " + this.a());
            }
        }
    }
    
    private fP b(final fj fj, final t t) {
        if (fj == null) {
            return this.b(fm.f);
        }
        return this.f(fj, a(fj, t, false));
    }
    
    private fP c(final fj fj, final t t) {
        if (fj == null) {
            return this.b(fm.a);
        }
        final t a = a(fj, t, false);
        if (a(t, a) > a(t, new t(fj.getCenterX(), fj.getCenterY()))) {
            return this.b(fm.a);
        }
        return this.f(fj, a);
    }
    
    private fP d(final fj fj, final t t) {
        if (fj == null) {
            return this.b(fm.a);
        }
        return this.f(fj, a(fj, t, true));
    }
    
    private static t a(final fj fj, final t t, final boolean b) {
        final boolean z = fj.z;
        final double x = fj.getX();
        final double y = fj.getY();
        final double width = fj.getWidth();
        final double height = fj.getHeight();
        double a = t.a();
        Label_0065: {
            if (a < x) {
                a = x;
                if (!z) {
                    break Label_0065;
                }
            }
            if (a > x + width) {
                a = x + width;
            }
        }
        double b2 = t.b();
        Label_0106: {
            if (b2 < y) {
                b2 = y;
                if (!z) {
                    break Label_0106;
                }
            }
            if (b2 > y + height) {
                b2 = y + height;
            }
        }
        if (b) {
            return new t(a, b2);
        }
        final double n = a - fj.getCenterX();
        final double n2 = b2 - fj.getCenterY();
        final boolean b3 = Math.abs(Math.abs(n) - width * 0.5) < 1.0E-8;
        final boolean b4 = Math.abs(Math.abs(n2) - height * 0.5) < 1.0E-8;
        final double n3 = (n > 0.0) ? (x + width) : x;
        final double n4 = (n2 > 0.0) ? (y + height) : y;
        if (b3 || b4) {
            if (b3 && b4) {
                return new t(n3, n4);
            }
            if (b3) {
                return new t(n3, b2);
            }
            return new t(a, n4);
        }
        else {
            if (width - 2.0 * Math.abs(n) < height - 2.0 * Math.abs(n2)) {
                return new t(n3, b2);
            }
            return new t(a, n4);
        }
    }
    
    private fP e(final fj fj, final t t) {
        final boolean z = fj.z;
        if (fj == null) {
            return this.b(fm.a);
        }
        final double centerX = fj.getCenterX();
        final double width = fj.getWidth();
        final double centerY = fj.getCenterY();
        final double height = fj.getHeight();
        final fn[] array = { a(fm.a), a(fm.b), a(fm.c), a(fm.d), a(fm.e), a(fm.f), a(fm.g), a(fm.h), a(fm.i) };
        double n = Double.POSITIVE_INFINITY;
        int n2 = -1;
        int i = 0;
        fn fn = null;
        while (i < array.length) {
            fn = array[i];
            if (z) {
                return fn;
            }
            final fn fn2 = fn;
            final double a = a(new t(centerX + fn2.b * width, centerY + fn2.c * height), t);
            if (n > a) {
                n = a;
                n2 = i;
            }
            ++i;
            if (z) {
                break;
            }
        }
        final fn fn3 = new fn(this, array[n2].b, array[n2].c);
        return fn;
    }
    
    private static double a(final t t, final t t2) {
        final double n = t.a() - t2.a();
        final double n2 = t.b() - t2.b();
        return n * n + n2 * n2;
    }
    
    private fP f(final fj fj, final t t) {
        final boolean z = fj.z;
        if (fj == null) {
            return this.b(fm.a);
        }
        final double x = fj.getX();
        final double width = fj.getWidth();
        final double y = fj.getY();
        final double height = fj.getHeight();
        double n = 0.0;
        Label_0073: {
            if (width > 0.0) {
                n = (t.a() - x - width * 0.5) / width;
                if (!z) {
                    break Label_0073;
                }
            }
            n = 0.0;
        }
        double n2 = 0.0;
        Label_0107: {
            if (height > 0.0) {
                n2 = (t.b() - y - height * 0.5) / height;
                if (!z) {
                    break Label_0107;
                }
            }
            n2 = 0.0;
        }
        if (n == 0.0 && n2 == 0.0) {
            return this.b(fm.a);
        }
        return new fn(this, n, n2);
    }
    
    public fP a(final t t) {
        return new fn(this, t.a(), t.b());
    }
    
    private fn b(final fP fp) {
        final fn a = a(fp);
        return new fn(this, a.b, a.c);
    }
    
    static fn a(final fP fp) {
        try {
            return (fn)fp;
        }
        catch (ClassCastException ex) {
            throw new IllegalArgumentException("Invalid model parameter type.");
        }
    }
    
    static {
        j = new fm();
        a = fm.j.a(new t(0.0, 0.0));
        b = fm.j.a(new t(-0.5, 0.0));
        c = fm.j.a(new t(0.5, 0.0));
        d = fm.j.a(new t(0.0, -0.5));
        e = fm.j.a(new t(0.0, 0.5));
        f = fm.j.a(new t(-0.5, -0.5));
        g = fm.j.a(new t(0.5, -0.5));
        h = fm.j.a(new t(0.5, 0.5));
        i = fm.j.a(new t(-0.5, 0.5));
    }
}
