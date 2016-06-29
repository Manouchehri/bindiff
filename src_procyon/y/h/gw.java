package y.h;

import y.d.*;
import y.c.*;
import y.f.*;
import java.util.*;

public class gw implements al
{
    private double a;
    
    public gw() {
        this(4.0);
    }
    
    public gw(final double a) {
        this.a = a;
    }
    
    public n a(final q q, final am am, final Object o) {
        final gx gx = (gx)o;
        final n n = new n(new t(0.0, 0.0), q);
        n.c(gx.g(), gx.h());
        final y h = n.h();
        final double a = h.a();
        final double b = h.b();
        n.e(am.getX() + am.getWidth() * 0.5 + am.getWidth() * gx.a - gx.c * a + gx.e - a * 0.5 + a * 0.5, am.getY() + am.getHeight() * 0.5 + am.getHeight() * gx.b - gx.d * b + gx.f - b * 0.5 + b * 0.5);
        return n;
    }
    
    public D a(final aj aj, final am am) {
        final boolean z = fj.z;
        final D d = new D();
        final n orientedBox = aj.getOrientedBox();
        final q d2 = orientedBox.d();
        final List a = this.a(orientedBox.g(), orientedBox.i());
        int i = 0;
        D d3 = null;
        while (i < a.size()) {
            final gx gx = a.get(i);
            final n a2 = this.a(d2, am, gx);
            d3 = d;
            if (z) {
                return d3;
            }
            d3.add(new ai(a2, gx, aj, false));
            ++i;
            if (z) {
                break;
            }
        }
        return d3;
    }
    
    public Object a(final n n, final am am) {
        final boolean z = fj.z;
        if (gu.a(n)) {
            throw new IllegalArgumentException("Invalid label bounds: " + n);
        }
        final y h = n.h();
        final y y = new y(am.getX(), am.getY(), am.getWidth(), am.getHeight());
        final double c = h.c();
        final double a = h.a();
        final double c2 = y.c();
        final double a2 = y.a();
        double n2 = 0.0;
        double n3 = 0.0;
        double a3 = 0.0;
        Label_0525: {
            if (c + a < c2) {
                n2 = 0.5;
                n3 = -0.5;
                a3 = c + a - c2;
                if (!z) {
                    break Label_0525;
                }
            }
            if (c > c2 + a2) {
                n2 = -0.5;
                n3 = 0.5;
                a3 = c - (c2 + a2);
                if (!z) {
                    break Label_0525;
                }
            }
            if (c < c2 && c + a > c2 + a2) {
                n2 = 0.0;
                n3 = (c + a * (0.5 + n2) - c2) / a2 - 0.5;
                a3 = 0.0;
                if (!z) {
                    break Label_0525;
                }
            }
            if (c < c2) {
                n2 = (c2 - c) / a - 0.5;
                n3 = -0.5;
                a3 = 0.0;
                if (!z) {
                    break Label_0525;
                }
            }
            if (c + a > c2 + a2) {
                n2 = (c2 + a2 - c) / a - 0.5;
                n3 = 0.5;
                a3 = 0.0;
                if (!z) {
                    break Label_0525;
                }
            }
            final boolean b = c < c2 + a2 * 0.33;
            final boolean b2 = c + a > c2 + a2 * 0.66;
            Label_0423: {
                if ((b && !b2) || c == c2) {
                    n2 = -0.5;
                    if (!z) {
                        break Label_0423;
                    }
                }
                if ((b2 && !b) || c + a == c2 + a2) {
                    n2 = 0.5;
                    if (!z) {
                        break Label_0423;
                    }
                }
                n2 = 0.0;
            }
            n3 = (c + a * (0.5 + n2) - c2) / a2 - 0.5;
            if (c - this.a == c2) {
                n2 = -0.5;
                n3 = -0.5;
                a3 = this.a;
                if (!z) {
                    break Label_0525;
                }
            }
            if (c + a + this.a == c2 + a2) {
                n2 = 0.5;
                n3 = 0.5;
                a3 = -this.a;
                if (!z) {
                    break Label_0525;
                }
            }
            a3 = 0.0;
        }
        final double d = h.d();
        final double b3 = h.b();
        final double d2 = y.d();
        final double b4 = y.b();
        double n4 = 0.0;
        if (d + b3 < d2) {
            n4 = 0.5;
            final double n5 = -0.5;
            final double a4 = d + b3 - d2;
            if (!z) {
                return new gx(n3, n5, n2, n4, a3, a4, n.g(), n.i());
            }
        }
        if (d > d2 + b4) {
            n4 = -0.5;
            final double n5 = 0.5;
            final double a4 = d - (d2 + b4);
            if (!z) {
                return new gx(n3, n5, n2, n4, a3, a4, n.g(), n.i());
            }
        }
        if (d < d2 && d + b3 > d2 + b4) {
            n4 = 0.0;
            final double n5 = (d + b3 * (0.5 + n4) - d2) / b4 - 0.5;
            final double a4 = 0.0;
            if (!z) {
                return new gx(n3, n5, n2, n4, a3, a4, n.g(), n.i());
            }
        }
        if (d < d2) {
            n4 = (d2 - d) / b3 - 0.5;
            final double n5 = -0.5;
            final double a4 = 0.0;
            if (!z) {
                return new gx(n3, n5, n2, n4, a3, a4, n.g(), n.i());
            }
        }
        if (d + b3 > d2 + b4) {
            n4 = (d2 + b4 - d) / b3 - 0.5;
            final double n5 = 0.5;
            final double a4 = 0.0;
            if (!z) {
                return new gx(n3, n5, n2, n4, a3, a4, n.g(), n.i());
            }
        }
        final boolean b5 = d < d2 + b4 * 0.33;
        final boolean b6 = d + b3 > d2 + b4 * 0.66;
        Label_0871: {
            if ((b5 && !b6) || d == d2) {
                n4 = -0.5;
                if (!z) {
                    break Label_0871;
                }
            }
            if ((b6 && !b5) || d + b3 == d2 + b4) {
                n4 = 0.5;
                if (!z) {
                    break Label_0871;
                }
            }
            n4 = 0.0;
        }
        double n5 = (d + b3 * (0.5 + n4) - d2) / b4 - 0.5;
        if (d - this.a == d2) {
            n4 = -0.5;
            n5 = -0.5;
            final double a4 = this.a;
            if (!z) {
                return new gx(n3, n5, n2, n4, a3, a4, n.g(), n.i());
            }
        }
        if (d + b3 + this.a == d2 + b4) {
            n4 = 0.5;
            n5 = 0.5;
            final double a4 = -this.a;
            if (!z) {
                return new gx(n3, n5, n2, n4, a3, a4, n.g(), n.i());
            }
        }
        final double a4 = 0.0;
        return new gx(n3, n5, n2, n4, a3, a4, n.g(), n.i());
    }
    
    public double a() {
        return this.a;
    }
    
    private List a(final double n, final double n2) {
        final ArrayList<gx> list = new ArrayList<gx>();
        list.add(new gx(0.0, -0.5, 0.0, 0.5, 0.0, -this.a, n, n2));
        list.add(new gx(-0.5, -0.5, 0.5, 0.5, -this.a, -this.a, n, n2));
        list.add(new gx(0.5, -0.5, -0.5, 0.5, this.a, -this.a, n, n2));
        list.add(new gx(0.5, 0.0, -0.5, 0.0, this.a, 0.0, n, n2));
        list.add(new gx(-0.5, 0.0, 0.5, 0.0, -this.a, 0.0, n, n2));
        list.add(new gx(0.0, 0.5, 0.0, -0.5, 0.0, this.a, n, n2));
        list.add(new gx(-0.5, 0.5, 0.5, -0.5, -this.a, this.a, n, n2));
        list.add(new gx(0.5, 0.5, -0.5, -0.5, this.a, this.a, n, n2));
        list.add(new gx(0.0, 0.0, 0.0, 0.0, 0.0, 0.0, n, n2));
        list.add(new gx(0.0, 0.5, 0.0, 0.5, 0.0, -this.a, n, n2));
        list.add(new gx(0.0, -0.5, 0.0, -0.5, 0.0, this.a, n, n2));
        list.add(new gx(-0.5, 0.0, -0.5, 0.0, this.a, 0.0, n, n2));
        list.add(new gx(0.5, 0.0, 0.5, 0.0, -this.a, 0.0, n, n2));
        list.add(new gx(-0.5, -0.5, -0.5, -0.5, this.a, this.a, n, n2));
        list.add(new gx(0.5, -0.5, 0.5, -0.5, -this.a, this.a, n, n2));
        list.add(new gx(-0.5, 0.5, -0.5, 0.5, this.a, -this.a, n, n2));
        list.add(new gx(0.5, 0.5, 0.5, 0.5, -this.a, -this.a, n, n2));
        return list;
    }
    
    public Object c() {
        return new gx(0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, -1.0);
    }
    
    public Object a(final double n, final double n2, final double n3, final double n4, final double n5, final double n6, final double n7, final double n8) {
        return new gx(n, n2, n3, n4, n5, n6, n7, n8);
    }
}
