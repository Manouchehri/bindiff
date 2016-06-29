package y.f;

import y.c.*;
import y.d.*;

public class A implements al
{
    static final Integer[] a;
    private static final Object b;
    private static final Object c;
    private static final Object d;
    private static final Object e;
    private double f;
    private final int g;
    
    public A() {
        this(130816, 4.0);
    }
    
    public A(final int g, final double f) {
        this.f = f;
        this.g = g;
    }
    
    public int a() {
        return this.g;
    }
    
    public double b() {
        return this.f;
    }
    
    public void a(final double f) {
        this.f = f;
    }
    
    public Object c() {
        if ((this.g & 0x100) != 0x0) {
            return A.b;
        }
        if ((this.g & 0x4) != 0x0) {
            return A.c;
        }
        if ((this.g & 0x1) != 0x0) {
            return A.d;
        }
        if ((this.g & 0x8) != 0x0) {
            return A.e;
        }
        return A.b;
    }
    
    public boolean a(final Object o) {
        return o instanceof Integer && (this.g & (int)o) != 0x0;
    }
    
    public n a(final q q, final am am, final Object o) {
        return this.a(q, am, (int)o);
    }
    
    public D a(final aj aj, final am am) {
        final boolean j = X.j;
        final D d = new D();
        final y box = aj.getBox();
        int i = 0;
        while (i < A.a.length) {
            final int intValue = A.a[i];
            if ((this.g & intValue) != 0x0) {
                boolean b = false;
                switch (intValue) {
                    case 256:
                    case 512:
                    case 1024:
                    case 2048:
                    case 4096:
                    case 8192:
                    case 16384:
                    case 32768:
                    case 65536: {
                        b = true;
                        break;
                    }
                }
                d.add(new ai(this.a(box, am, intValue), A.a[i], aj, b));
            }
            ++i;
            if (j) {
                break;
            }
        }
        return d;
    }
    
    protected n a(final q q, final am am, final int n) {
        final boolean j = X.j;
        double n2 = Double.NaN;
        double n3 = Double.NaN;
        Label_0885: {
            switch (n) {
                case 256: {
                    n2 = am.getX() + (am.getWidth() - q.a()) / 2.0;
                    n3 = am.getY() + (am.getHeight() - q.b()) / 2.0;
                    if (j) {
                        break Label_0885;
                    }
                    break;
                }
                case 512: {
                    n2 = am.getX() + (am.getWidth() - q.a()) / 2.0;
                    n3 = am.getY() + (am.getHeight() - q.b()) - this.b();
                    if (j) {
                        break Label_0885;
                    }
                    break;
                }
                case 1024: {
                    n2 = am.getX() + (am.getWidth() - q.a()) / 2.0;
                    n3 = am.getY() + this.b();
                    if (j) {
                        break Label_0885;
                    }
                    break;
                }
                case 2048: {
                    n2 = am.getX() + this.b();
                    n3 = am.getY() + (am.getHeight() - q.b()) / 2.0;
                    if (j) {
                        break Label_0885;
                    }
                    break;
                }
                case 4096: {
                    n2 = am.getX() + (am.getWidth() - q.a()) - this.b();
                    n3 = am.getY() + (am.getHeight() - q.b()) / 2.0;
                    if (j) {
                        break Label_0885;
                    }
                    break;
                }
                case 8192: {
                    n2 = am.getX() + this.b();
                    n3 = am.getY() + this.b();
                    if (j) {
                        break Label_0885;
                    }
                    break;
                }
                case 16384: {
                    n2 = am.getX() + (am.getWidth() - q.a()) - this.b();
                    n3 = am.getY() + this.b();
                    if (j) {
                        break Label_0885;
                    }
                    break;
                }
                case 32768: {
                    n2 = am.getX() + this.b();
                    n3 = am.getY() + (am.getHeight() - q.b()) - this.b();
                    if (j) {
                        break Label_0885;
                    }
                    break;
                }
                case 65536: {
                    n2 = am.getX() + (am.getWidth() - q.a()) - this.b();
                    n3 = am.getY() + (am.getHeight() - q.b()) - this.b();
                    if (j) {
                        break Label_0885;
                    }
                    break;
                }
                case 1: {
                    n2 = am.getX() + (am.getWidth() - q.a()) / 2.0;
                    n3 = am.getY() - q.b() - this.b();
                    if (j) {
                        break Label_0885;
                    }
                    break;
                }
                case 2: {
                    n2 = am.getX() - q.a() - this.b();
                    n3 = am.getY() - q.b();
                    if (j) {
                        break Label_0885;
                    }
                    break;
                }
                case 4: {
                    n2 = am.getX() + am.getWidth() + this.b();
                    n3 = am.getY() - q.b();
                    if (j) {
                        break Label_0885;
                    }
                    break;
                }
                case 8: {
                    n2 = am.getX() + am.getWidth() + this.b();
                    n3 = am.getY() + (am.getHeight() - q.b()) / 2.0;
                    if (j) {
                        break Label_0885;
                    }
                    break;
                }
                case 16: {
                    n2 = am.getX() - q.a() - this.b();
                    n3 = am.getY() + (am.getHeight() - q.b()) / 2.0;
                    if (j) {
                        break Label_0885;
                    }
                    break;
                }
                case 32: {
                    n2 = am.getX() + (am.getWidth() - q.a()) / 2.0;
                    n3 = am.getY() + am.getHeight() + this.b();
                    if (j) {
                        break Label_0885;
                    }
                    break;
                }
                case 64: {
                    n2 = am.getX() - q.a() - this.b();
                    n3 = am.getY() + am.getHeight();
                    if (j) {
                        break Label_0885;
                    }
                    break;
                }
                case 128: {
                    n2 = am.getX() + am.getWidth() + this.b();
                    n3 = am.getY() + am.getHeight();
                    break;
                }
            }
        }
        return new n(new t(n2, n3 + q.b()), q);
    }
    
    public Object a(final n n, final am am) {
        if (ae.a(n)) {
            throw new IllegalArgumentException("Invalid label bounds: " + n);
        }
        final ak ak = new ak();
        ak.a(n);
        final D a = this.a(ak, am);
        if (a.isEmpty()) {
            return this.c();
        }
        return aW.a(a, n.k()).b();
    }
    
    static {
        a = new Integer[] { new Integer(1), new Integer(2), new Integer(4), new Integer(8), new Integer(16), new Integer(32), new Integer(64), new Integer(128), new Integer(256), new Integer(512), new Integer(1024), new Integer(2048), new Integer(4096), new Integer(8192), new Integer(16384), new Integer(32768), new Integer(65536) };
        b = new Integer(256);
        c = new Integer(4);
        d = new Integer(1);
        e = new Integer(8);
    }
}
