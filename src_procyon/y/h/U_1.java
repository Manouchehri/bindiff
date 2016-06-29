package y.h;

import java.util.*;
import y.h.a.*;
import y.c.*;

public class U implements cg
{
    private static final Iterator a;
    private boolean b;
    private boolean c;
    private boolean d;
    
    public U() {
        this.b = false;
        this.c = true;
        this.d = false;
    }
    
    public void a(final boolean b) {
        this.b = b;
    }
    
    public void b(final boolean c) {
        this.c = c;
    }
    
    public void c(final boolean d) {
        this.d = d;
    }
    
    public Iterator a(final bu bu, final int n) {
        return this.a(bu, n, true);
    }
    
    public Iterator b(final bu bu, final int n) {
        return this.a(bu, n, false);
    }
    
    private Iterator a(final bu bu, final int n, final boolean b) {
        final v a = v.a(bu);
        if ((n & 0x51) != 0x0 && (n & 0x2E) != 0x0) {
            if (a != null && this.d) {
                if (this.b) {
                    if (b) {
                        return new ag(bu, a, n);
                    }
                    return new Y(bu, a, n);
                }
                else {
                    if (b) {
                        return new as(bu, a, n);
                    }
                    return new an(bu, a, n);
                }
            }
            else {
                if (a != null && this.c) {
                    return new hN(new W(bu, a, n, b), new X(bu, n, b), this.b ^ b);
                }
                return new hN(new W(bu, n, b), new X(bu, n, b), this.b ^ b);
            }
        }
        else if ((n & 0x51) != 0x0) {
            if (a != null && this.c) {
                return new W(bu, a, n, b);
            }
            return new W(bu, n, b);
        }
        else {
            if ((n & 0x2E) != 0x0) {
                return new X(bu, n, b);
            }
            return U.a;
        }
    }
    
    static {
        a = new V();
    }
}
