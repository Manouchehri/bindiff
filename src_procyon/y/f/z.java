package y.f;

import y.d.*;

public class z implements E
{
    static final Integer[] a;
    private static final Object b;
    private static final Object c;
    private static final Object d;
    private static final Object e;
    private int f;
    private aO g;
    private double h;
    
    public z() {
        this(63);
    }
    
    public z(final int f) {
        this.f = 63;
        this.h = 2.0;
        this.f = f;
        if (f == 128 || f == 448) {
            this.g = new aO((byte)0);
            if (!X.j) {
                return;
            }
        }
        this.g = new aO((byte)1);
    }
    
    public int a() {
        return this.f;
    }
    
    public double b() {
        return this.h;
    }
    
    public void a(final double h) {
        this.h = h;
    }
    
    public Object c() {
        if ((this.f & 0x80) != 0x0) {
            return z.b;
        }
        if ((this.f & 0x40) != 0x0) {
            return z.c;
        }
        if ((this.f & 0x10) != 0x0) {
            return z.d;
        }
        if ((this.f & 0x8) != 0x0) {
            return z.e;
        }
        return z.b;
    }
    
    public Object a(final n n, final I i, final am am, final am am2) {
        if (ae.a(n)) {
            throw new IllegalArgumentException("Invalid label bounds: " + n);
        }
        final D d = new D();
        d.a(n);
        final y.c.D a = this.a(d, i, am, am2);
        if (a.isEmpty()) {
            return this.c();
        }
        return aW.a(a, n.k()).b();
    }
    
    public static Object a(final int n) {
        switch (n) {
            case 1:
            case 2:
            case 4:
            case 8:
            case 16:
            case 32:
            case 64:
            case 128:
            case 256: {
                return new Integer(n);
            }
            default: {
                throw new IllegalArgumentException("Invalid position: " + n);
            }
        }
    }
    
    public boolean a(final Object o) {
        return o instanceof Integer && (this.f & (int)o) != 0x0;
    }
    
    public n a(final q q, final I i, final am am, final am am2, final Object o) {
        return this.a(q, i, am, am2, (o != null) ? ((Number)o).intValue() : ((Number)this.c()).intValue());
    }
    
    public y.c.D a(final C c, final I i, final am am, final am am2) {
        final boolean j = X.j;
        final y.c.D d = new y.c.D();
        final q d2 = c.getOrientedBox().d();
        int k = 0;
        while (k < z.a.length) {
            final int intValue = z.a[k];
            if ((this.f & intValue) != 0x0) {
                boolean b = false;
                Label_0103: {
                    if (intValue == 128) {
                        b = true;
                        if (!j) {
                            break Label_0103;
                        }
                    }
                    if (intValue == 64) {
                        b = true;
                        if (!j) {
                            break Label_0103;
                        }
                    }
                    if (intValue == 256) {
                        b = true;
                    }
                }
                d.add(new B(this.a(d2, i, am, am2, intValue), z.a[k], c, b));
            }
            ++k;
            if (j) {
                break;
            }
        }
        return d;
    }
    
    protected n a(final q q, final I i, final am am, final am am2, final int n) {
        final boolean j = X.j;
        final v a = ae.a(i, am, am2, 0.0);
        int n2 = 0;
        double n3 = 0.0;
        int n4 = -1;
        final s k = a.j();
        while (true) {
            while (k.f()) {
                ++n4;
                final double g = k.a().g();
                final double n5 = dcmpl(g, n3);
                if (!j) {
                    if (n5 > 0) {
                        n3 = g;
                        n2 = n4;
                    }
                    k.g();
                    if (j) {
                        break;
                    }
                    continue;
                }
                else {
                    int n6 = (int)n5;
                    byte b = 3;
                    double n7 = 0.0;
                    Label_0311: {
                        switch (n) {
                            case 1: {
                                b = 2;
                                n6 = 0;
                                n7 = 0.0;
                                if (j) {
                                    break Label_0311;
                                }
                                break;
                            }
                            case 2: {
                                b = 2;
                                n6 = n2;
                                n7 = 0.5;
                                if (j) {
                                    break Label_0311;
                                }
                                break;
                            }
                            case 4: {
                                b = 2;
                                n6 = n4;
                                n7 = 1.0;
                                if (j) {
                                    break Label_0311;
                                }
                                break;
                            }
                            case 64: {
                                b = 0;
                                n6 = 0;
                                n7 = 0.0;
                                if (j) {
                                    break Label_0311;
                                }
                                break;
                            }
                            case 128: {
                                b = 0;
                                n6 = n2;
                                n7 = 0.5;
                                if (j) {
                                    break Label_0311;
                                }
                                break;
                            }
                            case 256: {
                                b = 0;
                                n6 = n4;
                                n7 = 1.0;
                                if (j) {
                                    break Label_0311;
                                }
                                break;
                            }
                            case 8: {
                                b = 1;
                                n6 = 0;
                                n7 = 0.0;
                                if (j) {
                                    break Label_0311;
                                }
                                break;
                            }
                            case 16: {
                                b = 1;
                                n6 = n2;
                                n7 = 0.5;
                                if (j) {
                                    break Label_0311;
                                }
                                break;
                            }
                            case 32: {
                                b = 1;
                                n6 = n4;
                                n7 = 1.0;
                                break;
                            }
                        }
                    }
                    final m a2 = a.a(n6);
                    final n n8 = new n(new t(0.0, 0.0), q);
                    final y h = n8.h();
                    if (a2 == null) {
                        n8.e(am.getX() + h.a * 0.5, am.getY() - h.b * 0.5);
                        return n8;
                    }
                    final t c = a2.c();
                    final t d = a2.d();
                    double n9 = d.a() - c.a();
                    double n10 = d.b() - c.b();
                    if (n9 == 0.0 && n10 == 0.0) {
                        n9 = am.getX() + am.getWidth() * 0.5 + i.getSourcePoint().a - (am2.getX() + am2.getWidth() * 0.5 + i.getTargetPoint().a);
                        n10 = am.getY() + am.getHeight() * 0.5 + i.getSourcePoint().b - (am2.getY() + am2.getHeight() * 0.5 + i.getTargetPoint().b);
                        if (n9 == 0.0 && n10 == 0.0) {
                            n9 = 1.0E-6;
                        }
                    }
                    final y.d.z a3 = this.g.a(n9, n10, h.a(), h.b(), b);
                    a3.c();
                    a3.b(this.h);
                    return this.g.a(q, i, am, am2, new aP(n6, n7, a3, b, n7));
                }
            }
            continue;
        }
    }
    
    static {
        a = new Integer[] { new Integer(1), new Integer(2), new Integer(4), new Integer(8), new Integer(16), new Integer(32), new Integer(64), new Integer(128), new Integer(256) };
        b = new Integer(128);
        c = new Integer(64);
        d = new Integer(16);
        e = new Integer(8);
    }
}
