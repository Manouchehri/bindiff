package y.f.i;

import y.f.*;
import y.d.*;
import y.c.*;
import java.util.*;

class D
{
    private HashMap a;
    private y.c.D[] b;
    private int[] c;
    private y.c.D d;
    
    D(final ay ay) {
        final int f = v.f;
        this();
        final Iterator a = ay.a();
        while (a.hasNext()) {
            final aA aa = a.next();
            final ax a2 = aa.a();
            this.d.add(a2);
            if (a2.b()) {
                final Object b = b(a2.c(), a2.d());
                int b2 = aa.b();
                if (this.a.containsKey(b)) {
                    b2 += this.a.get(b);
                }
                this.a.put(b, new Integer(b2));
                if (f == 0) {
                    continue;
                }
            }
            if (a2.a(1)) {
                final int[] c = this.c;
                final int n = 0;
                c[n] += aa.b();
            }
            if (a2.a(2)) {
                final int[] c2 = this.c;
                final int n2 = 1;
                c2[n2] += aa.b();
            }
            if (a2.a(8)) {
                final int[] c3 = this.c;
                final int n3 = 2;
                c3[n3] += aa.b();
            }
            if (a2.a(4)) {
                final int[] c4 = this.c;
                final int n4 = 3;
                c4[n4] += aa.b();
                if (f != 0) {
                    break;
                }
                continue;
            }
        }
    }
    
    D() {
        final int f = v.f;
        this.a = null;
        this.b = new y.c.D[4];
        this.c = new int[4];
        this.d = new y.c.D();
        this.a = new HashMap();
        int i = 0;
        while (i < 4) {
            this.b[i] = new y.c.D();
            this.c[i] = -1;
            ++i;
            if (f != 0) {
                break;
            }
        }
    }
    
    private static Object b(final double n, final double n2) {
        return new t((int)Math.floor(n * 10.0), (int)Math.floor(n2 * 10.0));
    }
    
    public y.c.D a() {
        return this.d;
    }
    
    public int a(final double n, final double n2) {
        final Object b = b(n, n2);
        if (this.a.containsKey(b)) {
            return (int)this.a.get(b);
        }
        return -1;
    }
    
    public int a(final int n) {
        int n2 = 0;
        if ((n & 0x1) != 0x0) {
            if (this.c[0] < 0) {
                return Integer.MAX_VALUE;
            }
            n2 += this.c[0];
        }
        if ((n & 0x2) != 0x0) {
            if (this.c[1] < 0) {
                return Integer.MAX_VALUE;
            }
            n2 += this.c[1];
        }
        if ((n & 0x4) != 0x0) {
            if (this.c[3] < 0) {
                return Integer.MAX_VALUE;
            }
            n2 += this.c[3];
        }
        if ((n & 0x8) != 0x0) {
            if (this.c[2] < 0) {
                return Integer.MAX_VALUE;
            }
            n2 += this.c[2];
        }
        return n2;
    }
    
    public p a(final t t, final int n) {
        if (n == 1) {
            return this.b[0].b(t);
        }
        if (n == 2) {
            return this.b[1].b(t);
        }
        if (n == 4) {
            return this.b[3].b(t);
        }
        if (n == 8) {
            return this.b[2].b(t);
        }
        throw new RuntimeException("unknown direction");
    }
    
    public void a(final p p2, final int n) {
        final int f = v.f;
        if (n == 1) {
            this.b[0].h(p2);
            if (f == 0) {
                return;
            }
        }
        if (n == 2) {
            this.b[1].h(p2);
            if (f == 0) {
                return;
            }
        }
        if (n == 4) {
            this.b[3].h(p2);
            if (f == 0) {
                return;
            }
        }
        if (n == 8) {
            this.b[2].h(p2);
            if (f == 0) {
                return;
            }
        }
        throw new RuntimeException("unknown direction");
    }
    
    public y.c.D b(final int n) {
        final y.c.D d = new y.c.D();
        if ((n & 0x1) != 0x0) {
            d.addAll(this.b[0]);
        }
        if ((n & 0x2) != 0x0) {
            d.addAll(this.b[1]);
        }
        if ((n & 0x4) != 0x0) {
            d.addAll(this.b[3]);
        }
        if ((n & 0x8) != 0x0) {
            d.addAll(this.b[2]);
        }
        return d;
    }
}
