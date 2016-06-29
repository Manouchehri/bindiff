package y.h;

import y.g.*;
import y.b.*;

public class gJ
{
    gO a;
    ch b;
    cU c;
    public static final gP d;
    public static final gP e;
    public static final gP f;
    public static final gP g;
    public static final gO h;
    public static final gO i;
    public static final gO j;
    public static final gQ k;
    public static final gQ l;
    public static final gQ m;
    
    public gJ(final ch b) {
        this.b = b;
        this.c = null;
        this.a = gJ.i;
    }
    
    public d a(final double n, final an an, final long n2) {
        if (n2 < 0L) {
            throw new IllegalArgumentException("preferredDuration  = " + n2 + " < 0");
        }
        if (n <= 0.0) {
            throw new IllegalArgumentException("specified zoom factor <= 0: " + n);
        }
        return new hT(this.b, n, an, n2, this.c);
    }
    
    static {
        d = new gS();
        e = new gS(true);
        f = new gR();
        g = new gR(true);
        h = new gO(null);
        i = new gO(null);
        j = new gO(null);
        k = new gM();
        l = new gN();
        m = new gL();
    }
}
