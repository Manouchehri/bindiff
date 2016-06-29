package y.f.d;

import y.c.*;
import y.f.*;
import y.d.*;
import java.util.*;

class n
{
    private static final y.d.n[] a;
    private static final z b;
    private static final t c;
    
    private static boolean a(final E e, final I i, final am am, final am am2) {
        final int f = y.f.d.a.f;
        if (e instanceof K) {
            return true;
        }
        boolean a = false;
        try {
            int j = 0;
            while (j < n.a.length) {
                a = y.d.n.a(n.a[j], e.a(n.a[j].d(), i, am, am2, e.a(n.a[j], i, am, am2)), 1.0);
                if (f != 0) {
                    return a;
                }
                if (!a) {
                    return false;
                }
                ++j;
                if (f != 0) {
                    break;
                }
            }
        }
        catch (UnsupportedOperationException ex) {
            return false;
        }
        return a;
    }
    
    static D a(final X x, final d d, final C c, final E e, final boolean b, final boolean b2, final boolean b3) {
        final int f = y.f.d.a.f;
        final D d2 = new D();
        final I b4 = x.b((Object)d);
        final am a = x.a((Object)d.c());
        final am a2 = x.a((Object)d.d());
        final E labelModel = c.getLabelModel();
        final Object o = (c.getModelParameter() == null) ? labelModel.c() : c.getModelParameter();
        final y.d.n n = (labelModel == null) ? c.getOrientedBox() : labelModel.a(c.getOrientedBox().d(), b4, a, a2, o);
        D d3 = null;
        if (b) {
            d2.add(new B(n, o, c, false));
            if (f == 0) {
                return d3;
            }
        }
        Label_0271: {
            if (e != null && e != labelModel) {
                final y.c.C m = a(x, d, a(c.getOrientedBox(), e, e.a(n, b4, a, a2), c.getPreferredPlacementDescriptor()), e, b2, b3).m();
                while (m.f()) {
                    final B b5 = (B)m.d();
                    d3 = d2;
                    if (f != 0) {
                        break;
                    }
                    d3.add(a(b5, c, labelModel, b4, a, a2));
                    m.g();
                    if (f != 0) {
                        break Label_0271;
                    }
                }
                return d3;
            }
        }
        d2.addAll(a(x, d, c, labelModel, b2, b3));
        return d3;
    }
    
    private static B a(final B b, final C c, final E e, final I i, final am am, final am am2) {
        final Object a = e.a(b.d(), i, am, am2);
        return new B(e.a(b.d().d(), i, am, am2, a), a, c);
    }
    
    private static C a(final y.d.n n, final E e, final Object modelParameter, final aG ag) {
        final y.f.D d = new y.f.D();
        d.a(e);
        d.setModelParameter(modelParameter);
        d.a(ag);
        d.a(n);
        return d;
    }
    
    private static D a(final X x, final d d, final C c, final E e, final boolean b, final boolean b2) {
        final I b3 = x.b((Object)d);
        final am a = x.a((Object)d.c());
        final am a2 = x.a((Object)d.d());
        if (e == null || a(e, b3, a, a2)) {
            return a(x, d, c, b, b2);
        }
        return e.a(c, b3, a, a2);
    }
    
    private static D a(final X x, final d d, final C c, final boolean b, final boolean b2) {
        final int i = y.f.d.a.f;
        final y s = x.s(d.c());
        final y s2 = x.s(d.d());
        final am a = x.a((Object)d.c());
        final am a2 = x.a((Object)d.d());
        final I b3 = x.b((Object)d);
        final v a3 = ae.a(b3, a, a2, 0.0);
        final D d2 = new D();
        if (a3.h() == 0) {
            return d2;
        }
        final aG preferredPlacementDescriptor = c.getPreferredPlacementDescriptor();
        final double a4 = a(a3);
        final int a5 = a(x, a3);
        int n = 0;
        final int n2 = a3.h() - 1;
        do {
            int j = 0;
        Label_0121:
            while (j < n2) {
                final m a6 = a3.a(n);
                if (a6.g() > 0.0) {
                    final p[] a7 = a(preferredPlacementDescriptor, a6, b);
                    int n3 = 0;
                    do {
                        int k = 0;
                    Label_0160:
                        while (k < a7.length) {
                            final p p5 = a7[n3];
                            final y.d.n[] a8 = a(c, a6, p5);
                            j = 0;
                            if (i != 0) {
                                continue Label_0121;
                            }
                            int n4 = j;
                            do {
                                int l = 0;
                                Label_0191: {
                                    l = n4;
                                }
                                Label_0193:
                                while (l < a8.length) {
                                    final y.d.n n5 = a8[n4];
                                    final double[] a9 = a(n5, a6, p5, a5);
                                    k = 0;
                                    if (i == 0) {
                                        int n6 = k;
                                        while (n6 < a9.length) {
                                            final y.d.n n7 = new y.d.n(n5);
                                            final z m = a6.i();
                                            m.b(a9[n6]);
                                            a(n7, a6, z.a(a6.c(), m), p5);
                                            l = (b2 ? 1 : 0);
                                            if (i != 0) {
                                                continue Label_0193;
                                            }
                                            if (b2) {
                                                ae.b(n7);
                                            }
                                            double n8 = a4;
                                            boolean b4 = true;
                                            if (preferredPlacementDescriptor.i()) {
                                                b4 = false;
                                                n8 = Math.min(n8, a(s, n7));
                                            }
                                            if (preferredPlacementDescriptor.k()) {
                                                b4 = false;
                                                n8 = Math.min(n8, a(s2, n7));
                                            }
                                            if (b4 || n8 < 100.0) {
                                                final B b5 = new B(n7, c.getLabelModel().a(n7, b3, a, a2), c, false);
                                                b5.a(a(b5, preferredPlacementDescriptor, p5));
                                                d2.add(b5);
                                            }
                                            ++n6;
                                            if (i != 0) {
                                                break;
                                            }
                                        }
                                        ++n4;
                                        continue Label_0191;
                                    }
                                    continue Label_0160;
                                }
                                break;
                            } while (i == 0);
                            ++n3;
                        }
                        break;
                    } while (i == 0);
                }
                ++n;
            }
            break;
        } while (i == 0);
        return d2;
    }
    
    private static int a(final X x, final v v) {
        int n = (int)Math.floor(30.0 / (v.h() - 1));
        if (x.h() > 100) {
            n = (int)Math.floor(15.0 / (v.h() - 1));
            if (y.f.d.a.f == 0) {
                return Math.max(n, 5);
            }
        }
        if (x.h() > 500) {
            n = (int)Math.floor(10.0 / (v.h() - 1));
        }
        return Math.max(n, 5);
    }
    
    private static double a(final v v) {
        return Math.max(100.0, v.k() * 0.2);
    }
    
    private static p[] a(final aG ag, final m m, final boolean b) {
        final p[] b2 = b(ag, m, b);
        a(b2);
        b(b2);
        a(b2, ag);
        return b2;
    }
    
    private static p[] b(final aG ag, final m m, final boolean b) {
        final int f = y.f.d.a.f;
        final boolean b2 = m.j() < 0.0;
        final boolean b3 = m.j() > 0.0;
        final boolean b4 = m.k() < -0.001;
        final boolean b5 = m.k() > 0.001;
        final boolean b6 = !b4 && !b5;
        final boolean l = ag.l();
        final boolean n = ag.n();
        final boolean i = ag.m();
        final boolean u = ag.u();
        final boolean v = ag.v();
        final boolean w = ag.w();
        p[] array = new p[5];
        int n2 = 0;
        if (i) {
            array[n2++] = new p((byte)1, false, null);
        }
        Label_0368: {
            if (n && ((b && (b5 || b6)) || (!b && ((b5 && (v || w)) || (b3 && b6 && w) || (b2 && b6 && v))))) {
                array[n2++] = new p((byte)0, true, null);
                array[n2++] = new p((byte)0, true, null);
                if (f == 0) {
                    break Label_0368;
                }
            }
            if (l && ((b && b4) || (!b && (u || (b4 && (v || w)) || (b3 && b6 && v) || (b2 && b6 && w))))) {
                array[n2++] = new p((byte)0, false, null);
                array[n2++] = new p((byte)0, false, null);
            }
        }
        Label_0579: {
            if (n && ((b && b4) || (!b && (u || (b4 && (v || w)) || (b3 && b6 && v) || (b2 && b6 && w))))) {
                array[n2++] = new p((byte)2, false, null);
                array[n2++] = new p((byte)2, false, null);
                if (f == 0) {
                    break Label_0579;
                }
            }
            if (l && ((b && (b5 || b6)) || (!b && ((b5 && (v || w)) || (b3 && b6 && w) || (b2 && b6 && v))))) {
                array[n2++] = new p((byte)2, true, null);
                array[n2++] = new p((byte)2, true, null);
            }
        }
        if (n2 == 0) {
            array[n2++] = new p((byte)1, false, null);
            array[n2++] = new p((byte)0, false, null);
            array[n2++] = new p((byte)0, false, null);
            array[n2++] = new p((byte)2, false, null);
            array[n2++] = new p((byte)2, false, null);
            if (f == 0) {
                return array;
            }
        }
        if (n2 < 5) {
            final p[] array2 = new p[n2];
            int j = 0;
            while (j < n2) {
                array2[j] = array[j];
                ++j;
                if (f != 0) {
                    return array;
                }
                if (f != 0) {
                    break;
                }
            }
            array = array2;
        }
        return array;
    }
    
    private static void a(final p[] array, final aG ag) {
        final int f = y.f.d.a.f;
        final int n = (ag.h() <= 0.0) ? 40 : ((int)Math.ceil(ag.h()));
        if (array.length == 1) {
            p.a(array[0], 0);
            if (f == 0) {
                return;
            }
        }
        if (array.length == 2) {
            p.a(array[0], 0);
            p.a(array[1], n);
            if (f == 0) {
                return;
            }
        }
        if (array.length == 3) {
            p.a(array[0], 0);
            p.a(array[1], 0);
            p.a(array[2], n);
            if (f == 0) {
                return;
            }
        }
        if (array.length == 4) {
            p.a(array[0], 0);
            p.a(array[1], n);
            p.a(array[2], 0);
            p.a(array[3], n);
            if (f == 0) {
                return;
            }
        }
        if (array.length == 5) {
            p.a(array[0], 0);
            p.a(array[1], 0);
            p.a(array[2], n);
            p.a(array[3], 0);
            p.a(array[4], n);
        }
    }
    
    private static void a(final p[] array) {
        final int f = y.f.d.a.f;
        Label_0033: {
            if (array.length < 5) {
                int i = 0;
                while (i < array.length) {
                    p.a(array[i], 1.0);
                    ++i;
                    if (f != 0) {
                        break Label_0033;
                    }
                }
                return;
            }
        }
        if (array.length == 5) {
            p.a(array[0], 1.0);
            p.a(array[1], 1.0);
            p.a(array[2], 2.0);
            p.a(array[3], 1.0);
            p.a(array[4], 2.0);
        }
    }
    
    private static void b(final p[] array) {
        final int f = y.f.d.a.f;
        Label_0033: {
            if (array.length < 5) {
                int i = 0;
                while (i < array.length) {
                    p.b(array[i], 0);
                    ++i;
                    if (f != 0) {
                        break Label_0033;
                    }
                }
                return;
            }
        }
        if (array.length == 5) {
            p.b(array[0], 0);
            p.b(array[1], 1);
            p.b(array[2], 0);
            p.b(array[3], 1);
            p.b(array[4], 0);
        }
    }
    
    private static double a(final y y, final y.d.n n) {
        return y.f.d.m.a(y, n);
    }
    
    private static double a(final B b, final aG ag, final p p3) {
        double n = 0.0;
        final double n2 = ag.m() ? 0.0 : ag.h();
        if (n2 < 0.0 || Math.abs(n2 - p.a(p3)) < 0.001) {
            n = 1.0;
        }
        return n;
    }
    
    private static y.d.n a(final q q, final z z, final double n) {
        return new y.d.n(n.c, q, (n != 0.0) ? z.a(n) : z);
    }
    
    private static y.d.n[] a(final C c, final m m, final p p3) {
        final ArrayList list = new ArrayList<y.d.n>();
        final q d = c.getOrientedBox().d();
        final z i = m.i();
        final aG preferredPlacementDescriptor = c.getPreferredPlacementDescriptor();
        final double d2 = preferredPlacementDescriptor.d();
        final z a = i.a(-1.5707963267948966);
        a.c();
        final byte b = p.b(p3);
        Label_0411: {
            if (b == 1 || (b == 0 && !p.c(p3)) || (b == 2 && p.c(p3))) {
                if (preferredPlacementDescriptor.o()) {
                    list.add(a(d, n.b, d2));
                }
                if (!preferredPlacementDescriptor.p()) {
                    break Label_0411;
                }
                list.add(a(d, a, d2));
                if (y.f.d.a.f == 0) {
                    break Label_0411;
                }
            }
            if (preferredPlacementDescriptor.o()) {
                if (preferredPlacementDescriptor.q()) {
                    if (preferredPlacementDescriptor.s()) {
                        list.add(a(d, n.b, d2));
                    }
                    if (preferredPlacementDescriptor.t()) {
                        list.add(a(d, n.b, d2 + 3.141592653589793));
                    }
                }
                if (preferredPlacementDescriptor.r()) {
                    if (preferredPlacementDescriptor.s()) {
                        list.add(a(d, n.b, -d2));
                    }
                    if (preferredPlacementDescriptor.t()) {
                        list.add(a(d, n.b, -d2 + 3.141592653589793));
                    }
                }
            }
            if (preferredPlacementDescriptor.p()) {
                if (preferredPlacementDescriptor.q()) {
                    if (preferredPlacementDescriptor.s()) {
                        list.add(a(d, a, d2));
                    }
                    if (preferredPlacementDescriptor.t()) {
                        list.add(a(d, a, d2 + 3.141592653589793));
                    }
                }
                if (preferredPlacementDescriptor.r()) {
                    if (preferredPlacementDescriptor.s()) {
                        list.add(a(d, a, -d2));
                    }
                    if (preferredPlacementDescriptor.t()) {
                        list.add(a(d, a, -d2 + 3.141592653589793));
                    }
                }
            }
        }
        if (list.size() == 0) {
            return new y.d.n[] { a(d, n.b, d2) };
        }
        return (y.d.n[])list.toArray(new y.d.n[list.size()]);
    }
    
    private static void a(final y.d.n n, final m m, final t t, final p p4) {
        if (p.b(p4) == 1) {
            n.e(t.a, t.b);
            if (y.f.d.a.f == 0) {
                return;
            }
        }
        z c = z.c(m.i());
        if (p.b(p4) == 0) {
            c = new z(-c.a(), -c.b());
        }
        c.b(p.a(p4) + n.e() + n.f());
        final t a = z.a(t, c);
        n.e(a.a, a.b);
        final double a2 = a(m, n.a(n));
        final z z = new z(-c.a(), -c.b());
        z.c();
        z.b(a2 - Math.abs(p.a(p4)));
        final t a3 = y.d.z.a(a, z);
        n.e(a3.a, a3.b);
    }
    
    private static double a(final m m, final t[] array) {
        final int f = y.f.d.a.f;
        double n = Double.MAX_VALUE;
        int i = 0;
        double a = 0.0;
        while (i < array.length) {
            final double n2 = a = a(m, array[i]);
            if (f != 0) {
                return a;
            }
            if (a < n) {
                n = n2;
            }
            ++i;
            if (f != 0) {
                break;
            }
        }
        return a;
    }
    
    private static double[] a(final y.d.n n, final m m, final p p4, final int n2) {
        final int f = y.f.d.a.f;
        final t k = n.k();
        final z i = m.i();
        i.c();
        i.b(Math.max(n.e(), n.f()));
        int min = Math.min(Math.max((int)Math.floor(m.g() / (2.0 * t.a(k, n.b(n, new m(k, z.a(k, i)), 0.0)) * p.d(p4))), 3), n2);
        if (min % 2 == 0) {
            ++min;
        }
        final double n3 = 1.0 / (min - 1 + 2 * p.e(p4));
        final double[] array = new double[min];
        int n4 = 0;
        int j = p.e(p4);
        while (j < min + p.e(p4)) {
            array[n4++] = n3 * j;
            ++j;
            if (f != 0) {
                return array;
            }
            if (f != 0) {
                break;
            }
        }
        if (p.e(p4) == 0) {
            array[min - 1] = 1.0;
            return array;
        }
        return array;
    }
    
    private static double a(final m m, final t t) {
        final t c = m.c();
        final t d = m.d();
        final double n = d.a - c.a;
        final double n2 = d.b - c.b;
        final double n3 = t.a - c.a;
        final double n4 = t.b - c.b;
        final double n5 = n3 * n + n4 * n2;
        double n6 = n3 * n3 + n4 * n4 - n5 * n5 / (n * n + n2 * n2);
        if (n6 < 0.0) {
            n6 = 0.0;
        }
        return Math.sqrt(n6);
    }
    
    static {
        a = new y.d.n[] { new y.d.n(15.0, 5.0, 30.0, 10.0, 1.0, 0.0), new y.d.n(-15.0, -15.0, 100.0, 30.0, 0.5, 0.5), new y.d.n(50.0, 90.0, 40.0, 15.0, 0.0, -1.0) };
        b = new z(0.0, -1.0);
        c = new t(0.0, 0.0);
    }
}
