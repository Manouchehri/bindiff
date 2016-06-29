package y.f.k;

import y.c.*;
import y.d.*;
import y.f.*;

public class v implements J
{
    private byte a;
    private double b;
    private boolean c;
    
    public v() {
        this((byte)0, 0.5);
    }
    
    public v(final byte a, final double b) {
        this.a = a;
        this.b = b;
        this.c = false;
    }
    
    public void a(final X x, final q q) {
        final int g = d.g;
        if (q.g() != null) {
            this.a(x, q, q.g());
        }
        int n = 0;
        y.c.d d = q.f();
        while (d != null) {
            this.a(x, q, d, n);
            d = d.g();
            ++n;
            if (g != 0) {
                break;
            }
        }
    }
    
    protected void a(final X x, final q q, final y.c.d d) {
        final int g = d.g;
        final I b = x.b((Object)d);
        Label_0059: {
            switch (this.a) {
                default: {
                    b.setTargetPoint(t.c);
                    if (g != 0) {
                        break Label_0059;
                    }
                    break;
                }
                case 1: {
                    final aE a = this.a(x, d);
                    if (a != null && a.a()) {
                        break;
                    }
                    if (a == null || a.g()) {
                        b.setTargetPoint(t.c);
                        if (g == 0) {
                            break;
                        }
                    }
                    final am a2 = x.a((Object)q);
                    if (a.c()) {
                        b.setTargetPoint(new t(0.0, -a2.getHeight() * 0.5));
                        if (g == 0) {
                            break;
                        }
                    }
                    if (a.e()) {
                        b.setTargetPoint(new t(a2.getWidth() * 0.5, 0.0));
                        if (g == 0) {
                            break;
                        }
                    }
                    if (a.d()) {
                        b.setTargetPoint(new t(0.0, a2.getHeight() * 0.5));
                        if (g == 0) {
                            break;
                        }
                    }
                    b.setTargetPoint(new t(-a2.getWidth() * 0.5, 0.0));
                    break;
                }
            }
        }
    }
    
    protected void a(final X x, final q q, final y.c.d d, final int n) {
        final int g = d.g;
        final I b = x.b((Object)d);
        final am a = x.a((Object)q);
        final double width = a.getWidth();
        final double height = a.getHeight();
        final int c = q.c();
        final int n2 = this.c ? -1 : 1;
        switch (this.a) {
            case 2: {
                final double a2 = this.a(width, c);
                b.setSourcePoint(new t(n2 * (a2 + n * this.a(width, c, a2) - width / 2.0), -height / 2.0));
            }
            case 3: {
                final double a3 = this.a(width, c);
                b.setSourcePoint(new t(n2 * (a3 + n * this.a(width, c, a3) - width / 2.0), height / 2.0));
            }
            case 4: {
                final double a4 = this.a(height, c);
                b.setSourcePoint(new t(width / 2.0, n2 * (a4 + n * this.a(height, c, a4) - height / 2.0)));
            }
            case 5: {
                final double a5 = this.a(height, c);
                b.setSourcePoint(new t(-width / 2.0, n2 * (a5 + n * this.a(height, c, a5) - height / 2.0)));
            }
            case 0: {
                b.setSourcePoint(t.c);
            }
            case 1: {
                final aE a6 = this.a(x, d, n);
                if (a6 != null && a6.a()) {
                    break;
                }
                if (a6 == null || a6.g()) {
                    b.setSourcePoint(t.c);
                    if (g == 0) {
                        return;
                    }
                }
                if (a6.c()) {
                    b.setSourcePoint(new t(0.0, -a.getHeight() * 0.5));
                    if (g == 0) {
                        return;
                    }
                }
                if (a6.e()) {
                    b.setSourcePoint(new t(a.getWidth() * 0.5, 0.0));
                    if (g == 0) {
                        return;
                    }
                }
                if (a6.d()) {
                    b.setSourcePoint(new t(0.0, a.getHeight() * 0.5));
                    if (g == 0) {
                        return;
                    }
                }
                b.setSourcePoint(new t(-a.getWidth() * 0.5, 0.0));
            }
        }
    }
    
    protected double a(final double n, final int n2) {
        if (n2 <= 1) {
            return n * 0.5;
        }
        return this.b * (n / (n2 - 1 + 2.0 * this.b));
    }
    
    protected double a(final double n, final int n2, final double n3) {
        if (n2 <= 1) {
            return 0.0;
        }
        return (n - 2.0 * n3) / (n2 - 1);
    }
    
    protected aE a(final X x, final y.c.d d, final int n) {
        return aE.d(x, d);
    }
    
    protected aE a(final X x, final y.c.d d) {
        return aE.e(x, d);
    }
}
