package y.f;

import y.d.*;

public class S implements U
{
    private n c;
    private aG d;
    
    public S(final n n) {
        this(n, (byte)0);
    }
    
    public S(final n n, final byte b) {
        this(n, aG.g(b));
    }
    
    public S(final n n, final aG ag) {
        this.a(n);
        this.a(ag);
    }
    
    public void a(final n c) {
        this.c = c;
    }
    
    public n a() {
        return this.c;
    }
    
    public double b() {
        return this.c.h().a();
    }
    
    public double c() {
        return this.c.h().b();
    }
    
    public void a(final double n, final double n2) {
        final t e = this.c.h().e();
        this.c.d(n - e.a, n2 - e.b);
    }
    
    public double d() {
        return this.c.h().c();
    }
    
    public double e() {
        return this.c.h().d();
    }
    
    public void a(final aG d) {
        if (d == null) {
            throw new IllegalArgumentException("null");
        }
        this.d = d;
    }
    
    public aG f() {
        return this.d;
    }
    
    public String toString() {
        return this.a().toString() + " " + this.g();
    }
    
    private String g() {
        final boolean j = X.j;
        final byte a = this.d.a();
        if (a == 0) {
            return a(a);
        }
        String s = "";
        final StringBuffer sb = new StringBuffer();
        final byte[] array = { 1, 2, 4 };
        int i = 0;
        while (i < array.length) {
            if ((a & array[i]) == array[i]) {
                sb.append(s).append(a(array[i]));
                s = "|";
            }
            ++i;
            if (j) {
                break;
            }
        }
        return sb.toString();
    }
    
    private static String a(final byte b) {
        switch (b) {
            case 0: {
                return "PLACE_ANYWHERE";
            }
            case 1: {
                return "PLACE_AT_SOURCE";
            }
            case 2: {
                return "PLACE_AT_TARGET";
            }
            case 4: {
                return "PLACE_AT_CENTER";
            }
            default: {
                return "ILLEGAL_PLACEMENT: " + b;
            }
        }
    }
}
