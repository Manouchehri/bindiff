package y.f;

import y.c.*;
import java.awt.geom.*;
import java.util.*;
import y.d.*;

public class ae
{
    private static final v a;
    private static final t b;
    
    public static byte a(final X x, final c c) {
        final boolean j = X.j;
        int n = 0;
        final int[] array = new int[4];
        final e p2 = x.p();
        while (p2.f()) {
            final d a = p2.a();
            Label_0125: {
                if (c == null || c.d(a)) {
                    final v l = x.l(a);
                    n += l.h() - 1;
                    final s i = l.j();
                    while (i.f()) {
                        a(i.a(), array);
                        i.g();
                        if (j) {
                            break Label_0125;
                        }
                        if (j) {
                            break;
                        }
                    }
                }
                p2.g();
            }
            if (j) {
                break;
            }
        }
        return a(array, n);
    }
    
    public static boolean b(final X x, final c c) {
        return a(x, c, (byte)1);
    }
    
    private static boolean a(final X x, final c c, final byte b) {
        final boolean j = X.j;
        int n = 0;
        int n2 = 0;
        int n3 = 0;
        final e p3 = x.p();
        while (p3.f()) {
            final d a = p3.a();
            if (j) {
                return true;
            }
            if (c == null || c.d(a)) {
                ++n;
                final v l = x.l(a);
                if (l.h() == 2) {
                    ++n3;
                }
                final s i = l.j();
                double n4 = 0.0;
                Label_0195: {
                    while (i.f()) {
                        final m a2 = i.a();
                        final double abs = Math.abs(a2.j());
                        final double abs2 = Math.abs(a2.k());
                        n4 = dcmpl(abs, 1.0E-4);
                        if (j || (n4 > 0 && abs2 > 1.0E-4 && (b == 1 || Math.abs(abs - abs2) > 1.0E-4) && !j)) {
                            break Label_0195;
                        }
                        i.g();
                        if (j) {
                            goto Label_0193;
                        }
                    }
                    goto Label_0193;
                }
                if (n4 != 0) {
                    ++n2;
                }
            }
            p3.g();
            if (j) {
                break;
            }
        }
        if (n2 == n || (n2 > n3 && n2 > 0.5 * n)) {
            return true;
        }
        return false;
    }
    
    private static byte a(final int[] array, final int n) {
        int n2 = 2;
        byte b = 0;
        if (array[n2] > array[0]) {
            n2 = 0;
            b = 2;
        }
        if (array[n2] > array[3]) {
            n2 = 3;
            b = 1;
        }
        if (array[n2] > array[1]) {
            n2 = 1;
            b = 3;
        }
        if (array[b] > 0.3 * n && array[b] > 5 * array[n2]) {
            return b;
        }
        return -1;
    }
    
    private static void a(final m m, final int[] array) {
        final boolean j = X.j;
        final t c = m.c();
        final t d = m.d();
        Label_0058: {
            if (c.a < d.a) {
                final int n = 1;
                ++array[n];
                if (!j) {
                    break Label_0058;
                }
            }
            if (c.a > d.a) {
                final int n2 = 3;
                ++array[n2];
            }
        }
        if (c.b < d.b) {
            final int n3 = 0;
            ++array[n3];
            if (!j) {
                return;
            }
        }
        if (c.b > d.b) {
            final int n4 = 2;
            ++array[n4];
        }
    }
    
    public static double a(final X x, final q q, final q q2) {
        return t.a(x.j(q), x.k(q), x.j(q2), x.k(q2));
    }
    
    public static void a(final I i) {
        final boolean j = X.j;
        I m = null;
        Label_0125: {
            Label_0124: {
                if (i.pointCount() > 0) {
                    final ArrayList list = new ArrayList<Object>(i.pointCount());
                    int k = i.pointCount() - 1;
                    while (true) {
                        while (k >= 0) {
                            list.add(i.getPoint(k));
                            --k;
                            if (j) {
                                int l = 0;
                                while (l < list.size()) {
                                    final t t = list.get(l);
                                    m = i;
                                    if (j) {
                                        break Label_0125;
                                    }
                                    i.addPoint(t.a(), t.b());
                                    ++l;
                                    if (j) {
                                        break;
                                    }
                                }
                                break Label_0124;
                            }
                            if (j) {
                                break;
                            }
                        }
                        i.clearPoints();
                        continue;
                    }
                }
            }
            m = i;
        }
        final t sourcePoint = m.getSourcePoint();
        i.setSourcePoint(i.getTargetPoint());
        i.setTargetPoint(sourcePoint);
    }
    
    public static void a(final X x) {
        a(x, true);
    }
    
    public static void a(final X x, final boolean b) {
        final boolean j = X.j;
        Label_0065: {
            if (b) {
                final e p2 = x.p();
                while (p2.f()) {
                    final d a = p2.a();
                    x.a(a, ae.b);
                    x.b(a, ae.b);
                    x.b(a, ae.a);
                    p2.g();
                    if (j) {
                        break Label_0065;
                    }
                }
                return;
            }
        }
        final e p3 = x.p();
        while (p3.f()) {
            x.b(p3.a(), ae.a);
            p3.g();
            if (j) {
                break;
            }
        }
    }
    
    public static void a(final X x, final d d) {
        a(x, d, true);
    }
    
    public static void a(final X x, final d d, final boolean b) {
        if (b) {
            x.a(d, ae.b);
            x.b(d, ae.b);
        }
        x.b(d, ae.a);
    }
    
    public static void b(final X x) {
        final boolean j = X.j;
        final e p = x.p();
        while (p.f()) {
            b(x, p.a());
            p.g();
            if (j) {
                break;
            }
        }
    }
    
    public static void b(final X x, final d d) {
        final boolean j = X.j;
        final I b = x.b((Object)d);
        t p2 = x.p(d);
        if (b.pointCount() > 0) {
            int i = 0;
            boolean equals = false;
            Label_0088: {
                while (i < b.pointCount()) {
                    final t point = b.getPoint(i);
                    equals = p2.equals(point);
                    if (j || (equals && !j)) {
                        break Label_0088;
                    }
                    p2 = point;
                    ++i;
                    if (j) {
                        goto Label_0087;
                    }
                }
                goto Label_0087;
            }
            if (equals || p2.equals(x.q(d))) {
                final D m = x.m(d);
                t t = (t)m.k().c();
                p p3 = m.k().a();
                while (p3 != m.l()) {
                    if (p3.c().equals(t)) {
                        m.h(p3);
                    }
                    t = (t)p3.c();
                    p3 = p3.a();
                    if (j) {
                        break;
                    }
                }
                x.a(d, m);
            }
        }
    }
    
    public static void a(final X x, final d d, final double n, final double n2) {
        final boolean j = X.j;
        final I b = x.b((Object)d);
        int i = b.pointCount() - 1;
        while (i >= 0) {
            final t point = b.getPoint(i);
            b.setPoint(i, point.a + n, point.b + n2);
            --i;
            if (j) {
                break;
            }
        }
    }
    
    public static void a(final X x, final q q, final double n, final double n2) {
        final am a = x.a((Object)q);
        a.setLocation(a.getX() + n, a.getY() + n2);
    }
    
    public static void a(final X x, final x x2, final double n, final double n2) {
        final boolean j = X.j;
        final HashSet set = new HashSet<q>();
        while (true) {
            while (x2.f()) {
                final X x3 = x;
                if (j) {
                    final e p4 = x3.p();
                    while (p4.f()) {
                        final d a = p4.a();
                        if (set.contains(a.c()) && set.contains(a.d())) {
                            a(x, a, n, n2);
                        }
                        p4.g();
                        if (j) {
                            break;
                        }
                    }
                    return;
                }
                a(x, x2.e(), n, n2);
                set.add(x2.e());
                x2.g();
                if (j) {
                    break;
                }
            }
            final X x3 = x;
            continue;
        }
    }
    
    public static Rectangle2D a(final X x, final x x2, final e e) {
        final Rectangle2D a = a(x, x2);
        final Rectangle2D a2 = a(x, e);
        if (a.getWidth() < 0.0) {
            return a2;
        }
        if (a2.getWidth() < 0.0) {
            return a;
        }
        a.add(a2);
        return a;
    }
    
    public static Rectangle2D a(final X x, final x x2) {
        final boolean j = X.j;
        if (!x2.f()) {
            return new Rectangle2D.Double(0.0, 0.0, -1.0, -1.0);
        }
        double min = Double.MAX_VALUE;
        double min2 = Double.MAX_VALUE;
        double max = -1.7976931348623157E308;
        double max2 = -1.7976931348623157E308;
        while (x2.f()) {
            final am h = x.h(x2.e());
            min = Math.min(min, h.getX());
            min2 = Math.min(min2, h.getY());
            max = Math.max(max, h.getX() + h.getWidth());
            max2 = Math.max(max2, h.getY() + h.getHeight());
            x2.g();
            if (j) {
                break;
            }
        }
        return new Rectangle2D.Double(min, min2, max - min, max2 - min2);
    }
    
    public static Rectangle2D a(final X x, final e e) {
        final boolean j = X.j;
        if (!e.f()) {
            return new Rectangle2D.Double(0.0, 0.0, -1.0, -1.0);
        }
        final t p2 = x.p(e.a());
        double n = p2.a;
        double n2 = p2.a;
        double n3 = p2.b;
        double n4 = p2.b;
    Label_0274_Outer:
        while (e.f()) {
            final d a = e.a();
            final I g = x.g(a);
            int i = g.pointCount() - 1;
            while (true) {
                while (i >= 0) {
                    final t point = g.getPoint(i);
                    n = Math.min(n, point.a);
                    n2 = Math.max(n2, point.a);
                    n3 = Math.min(n3, point.b);
                    n4 = Math.max(n4, point.b);
                    --i;
                    if (!j) {
                        if (j) {
                            break;
                        }
                        continue Label_0274_Outer;
                    }
                    else {
                        if (j) {
                            break Label_0274_Outer;
                        }
                        continue Label_0274_Outer;
                    }
                }
                final t p3 = x.p(a);
                final double min = Math.min(n, p3.a);
                final double max = Math.max(n2, p3.a);
                final double min2 = Math.min(n3, p3.b);
                final double max2 = Math.max(n4, p3.b);
                final t q = x.q(a);
                n = Math.min(min, q.a);
                n2 = Math.max(max, q.a);
                n3 = Math.min(min2, q.b);
                n4 = Math.max(max2, q.b);
                e.g();
                continue;
            }
        }
        return new Rectangle2D.Double(n, n3, n2 - n, n4 - n3);
    }
    
    public static Rectangle2D a(final X x, final x x2, final e e, final boolean b) {
        final boolean j = X.j;
        final Rectangle2D a = a(x, x2, e);
        if (b) {
            x2.i();
            while (true) {
                while (x2.f()) {
                    final aj[] a_ = x.a_(x2.e());
                    final am h = x.h(x2.e());
                    if (j) {
                        while (e.f()) {
                            final C[] d = x.d((Object)e.a());
                            final I b2 = x.b((Object)e.a());
                            final am a2 = x.a((Object)e.a().c());
                            final am a3 = x.a((Object)e.a().d());
                            Label_0403: {
                                if (d != null && d.length > 0) {
                                    int i = 0;
                                    while (i < d.length) {
                                        final y h2 = d[i].getLabelModel().a(d[i].getOrientedBox().d(), b2, a2, a3, d[i].getModelParameter()).h();
                                        a.add(h2.c, h2.d);
                                        a.add(h2.c + h2.a, h2.d + h2.b);
                                        ++i;
                                        if (j) {
                                            break Label_0403;
                                        }
                                        if (j) {
                                            break;
                                        }
                                    }
                                }
                                e.g();
                            }
                            if (j) {
                                break;
                            }
                        }
                        return a;
                    }
                    Label_0193: {
                        if (a_ != null && a_.length > 0) {
                            int k = 0;
                            while (k < a_.length) {
                                final y h3 = a_[k].a().a(a_[k].getOrientedBox().d(), h, a_[k].getModelParameter()).h();
                                a.add(h3.c, h3.d);
                                a.add(h3.c + h3.a, h3.d + h3.b);
                                ++k;
                                if (j) {
                                    break Label_0193;
                                }
                                if (j) {
                                    break;
                                }
                            }
                        }
                        x2.g();
                    }
                    if (j) {
                        break;
                    }
                }
                e.i();
                continue;
            }
        }
        return a;
    }
    
    public static void c(final X x) {
        final boolean j = X.j;
        final t c = t.c;
        final e p = x.p();
        while (p.f()) {
            final d a = p.a();
            x.a(a, c);
            x.b(a, c);
            p.g();
            if (j) {
                break;
            }
        }
    }
    
    public static v a(final I i, final am am, final am am2) {
        return a(i, am, am2, 0.0);
    }
    
    public static v c(final X x, final d d) {
        return a(x.g(d), x.h(d.c()), x.h(d.d()));
    }
    
    public static v a(final I i, final am am, final am am2, final double n) {
        final boolean j = X.j;
        final t t = new t(am.getX() - n, am.getY() - n);
        final y.d.q q = new y.d.q(am.getWidth() + 2.0 * n, am.getHeight() + 2.0 * n);
        final t t2 = new t(am2.getX() - n, am2.getY() - n);
        final y.d.q q2 = new y.d.q(am2.getWidth() + 2.0 * n, am2.getHeight() + 2.0 * n);
        final ArrayList<Object> list = new ArrayList<Object>(i.pointCount() + 2);
        list.add(new t(i.getSourcePoint().a() + t.a() + q.a() / 2.0, i.getSourcePoint().b() + t.b() + q.b() / 2.0));
        int k = 0;
        while (k < i.pointCount()) {
            list.add(i.getPoint(k));
            ++k;
            if (j) {
                break;
            }
        }
        list.add(new t(i.getTargetPoint().a() + t2.a() + q2.a() / 2.0, i.getTargetPoint().b() + t2.b() + q2.b() / 2.0));
        final t t3 = list.get(0);
        final t t4 = list.get(list.size() - 1);
        ArrayList<Object> list2 = new ArrayList<Object>();
        int n2 = 0;
        while (a(t, q, list.get(n2))) {
            if (++n2 == list.size()) {
                return new v();
            }
        }
        if (n2 > 0) {
            list2.add(a(t, q, list.get(n2 - 1), list.get(n2)));
        }
        int l = list.size() - 1;
        while (true) {
            while (l >= n2) {
                final int a;
                final int n3 = a = (a(t2, q2, list.get(l)) ? 1 : 0);
                if (!j) {
                    if (n3 == 0) {
                        break;
                    }
                    --l;
                    if (j) {
                        break;
                    }
                    continue;
                }
                else {
                    int n4 = a;
                    while (true) {
                        while (n4 <= l) {
                            list2.add(list.get(n4));
                            ++n4;
                            if (j) {
                                Label_0594: {
                                    if (!list2.isEmpty()) {
                                        list2.add(a(t2, q2, list.get(l + 1), list2.get(list2.size() - 1)));
                                        if (!j) {
                                            break Label_0594;
                                        }
                                    }
                                    list2 = list;
                                }
                                final v v = new v(list2);
                                if (i.g) {
                                    X.j = !j;
                                }
                                return v;
                            }
                            if (j) {
                                break;
                            }
                        }
                        if (l == list.size() - 1) {
                            return new v(list2);
                        }
                        continue;
                    }
                }
            }
            int a = n2;
            continue;
        }
    }
    
    public static void d(final X x) {
        final boolean j = X.j;
        final e p = x.p();
        while (p.f()) {
            d(x, p.a());
            p.g();
            if (j) {
                break;
            }
        }
    }
    
    public static void d(final X x, final d d) {
        final List e = c(x, d).e();
        if (!e.isEmpty()) {
            x.c(d, e.get(0));
            x.d(d, e.get(e.size() - 1));
            e.remove(e.size() - 1);
            e.remove(0);
            x.b(d, new v(e));
        }
    }
    
    public static void a(final X x, final d d, final d d2, final double n, final boolean b, final double n2, final double n3) {
        final boolean j = X.j;
        int h = x.l(d).h();
        final t[] array = new t[h];
        int n4 = 0;
        final y.c.C a = x.l(d).a();
        while (true) {
            while (a.f()) {
                final t t = (t)a.d();
                final int n5 = n4;
                if (!j) {
                    Label_0167: {
                        if (n5 <= 0 || !t.equals(array[n4 - 1])) {
                            if (n4 > 1 && y.d.e.d(array[n4 - 2], array[n4 - 1], t)) {
                                array[n4 - 1] = new t(t.a(), t.b());
                                if (!j) {
                                    break Label_0167;
                                }
                            }
                            array[n4] = new t(t.a(), t.b());
                            ++n4;
                        }
                    }
                    a.g();
                    if (j) {
                        break;
                    }
                    continue;
                }
                else {
                    if (n5 < 2) {
                        return;
                    }
                    final D d3 = new D();
                    final z z = new z(array[1], array[0]);
                    final z c = y.d.z.c(z);
                    c.b(n);
                    t a2 = y.d.z.a(array[1], c);
                    t a5 = null;
                    Label_0491: {
                        if (b) {
                            final z z2 = new z(z);
                            boolean b2 = true;
                            final double d4 = z2.d();
                            double n6 = (n3 * d4 + n2) / d4;
                            if (h == 2 && n6 > 0.5) {
                                n6 = 0.5;
                            }
                            z2.b(n6);
                            z2.a(c);
                            if (h > 2) {
                                final a a3 = new a(y.d.z.a(array[1], c), y.d.z.a(array[0], c));
                                final z c2 = y.d.z.c(new z(array[2], array[1]));
                                c2.b(n);
                                final t a4 = y.d.a.a(a3, new a(y.d.z.a(array[2], c2), y.d.z.a(array[1], c2)));
                                if (a4 != null && z2.d() > new z(a4, array[0]).d()) {
                                    b2 = false;
                                    a2 = a4;
                                }
                            }
                            if (b2) {
                                d3.add(y.d.z.a(array[0], z2));
                            }
                            a5 = array[0];
                            if (!j) {
                                break Label_0491;
                            }
                        }
                        a5 = y.d.z.a(array[0], c);
                    }
                    a a6 = new a(a5, a2);
                    int i = 1;
                    while (true) {
                        while (i < h - 1) {
                            final a a7 = a6;
                            final z c3;
                            final z z3 = c3 = y.d.z.c(new z(array[i + 1], array[i]));
                            if (j) {
                                final z z4 = c3;
                                final z c4 = y.d.z.c(z4);
                                c4.b(n);
                                t a9 = null;
                                Label_0941: {
                                    if (b) {
                                        final z z5 = new z(z4);
                                        boolean b3 = true;
                                        final double d5 = z5.d();
                                        double n7 = (n3 * d5 + n2) / d5;
                                        if (h == 2 && n7 > 0.5) {
                                            n7 = 0.5;
                                            b3 = false;
                                        }
                                        z5.b(-n7);
                                        z5.a(c4);
                                        if (h > 2) {
                                            final z c5 = y.d.z.c(new z(array[h - 2], array[h - 3]));
                                            c5.b(n);
                                            final t a8 = y.d.a.a(new a(y.d.z.a(array[h - 2], c5), y.d.z.a(array[h - 3], c5)), new a(y.d.z.a(array[h - 1], c4), y.d.z.a(array[h - 2], c4)));
                                            if (a8 != null && z5.d() > new z(a8, array[h - 1]).d()) {
                                                b3 = false;
                                            }
                                        }
                                        if (b3) {
                                            d3.add(y.d.z.a(array[h - 1], z5));
                                        }
                                        a9 = array[h - 1];
                                        if (!j) {
                                            break Label_0941;
                                        }
                                    }
                                    a9 = y.d.z.a(array[h - 1], c4);
                                }
                                if (d.c().equals(d2.c())) {
                                    x.b(d2, d3);
                                    x.a(d2, a5, a9);
                                    if (!j) {
                                        return;
                                    }
                                }
                                d3.n();
                                x.b(d2, d3);
                                x.a(d2, a9, a5);
                                return;
                            }
                            c3.b(n);
                            a6 = new a(y.d.z.a(array[i], z3), y.d.z.a(array[i + 1], z3));
                            final t a10 = y.d.a.a(a7, a6);
                            if (a10 != null) {
                                d3.add(a10);
                            }
                            ++i;
                            if (j) {
                                break;
                            }
                        }
                        final z z6 = new z(array[h - 1], array[h - 2]);
                        continue;
                    }
                }
            }
            final int n8;
            h = (n8 = n4);
            continue;
        }
    }
    
    public static void a(final X x, final d d, final f f, final double n, final boolean b, final boolean b2, final double n2, final double n3) {
        final boolean j = X.j;
        double n4 = n;
        double n5 = 0.0;
        if (b && f.size() % 2 == 1) {
            n5 -= n * 0.5;
        }
        final e a = f.a();
        while (true) {
            while (a.f()) {
                a(x, d, a.a(), n4 + n5, b2, n2, n3);
                final double n6 = dcmpg(n4, 0.0);
                if (j) {
                    if (n6 != 0 && f.size() % 2 == 1) {
                        a(x, d, d, -n * 0.5, b2, n2, n3);
                    }
                    return;
                }
                if (n6 < 0) {
                    n4 -= n;
                }
                n4 = -n4;
                a.g();
                if (j) {
                    break;
                }
            }
            continue;
        }
    }
    
    public static void a(final X x, final d d, final d d2) {
        x.c(d, x.q(d2));
        x.d(d, x.p(d2));
        x.b(d, x.j(d2).g());
    }
    
    private static boolean a(final t t, final y.d.q q, final t t2) {
        return t2.a >= t.a && t2.b >= t.b && t2.a <= t.a + q.a() && t2.b <= t.b + q.b();
    }
    
    private static t a(final t t, final y.d.q q, final t t2, final t t3) {
        final Point2D.Double a = a(t.a, t.b, q.a(), q.b(), t2.a, t2.b, t3.a, t3.b, null);
        return new t(a.x, a.y);
    }
    
    private static Point2D.Double a(final double n, final double y, final double n2, final double n3, final double x, final double y2, final double n4, final double n5, Point2D.Double double1) {
        if (double1 == null) {
            double1 = new Point2D.Double();
        }
        if (x < n || y2 < y || x > n + n2 || y2 > y + n3) {
            double1.x = x;
            double1.y = y2;
            return double1;
        }
        final double n6 = n4 - x;
        final double n7 = n5 - y2;
        if (n6 == 0.0) {
            if (n7 < 0.0) {
                double1.x = x;
                double1.y = y;
                return double1;
            }
            double1.x = x;
            double1.y = y + n3;
            return double1;
        }
        else if (n7 == 0.0) {
            if (n6 < 0.0) {
                double1.x = n;
                double1.y = y2;
                return double1;
            }
            double1.x = n + n2;
            double1.y = y2;
            return double1;
        }
        else {
            final double n8 = n7 / n6;
            if (n6 > 0.0) {
                final double y3 = y2 + n8 * (n + n2 - x);
                if (y3 < y) {
                    double1.x = x + (y - y2) / n8;
                    double1.y = y;
                    return double1;
                }
                if (y3 <= y + n3) {
                    double1.x = n + n2;
                    double1.y = y3;
                    return double1;
                }
                double1.x = x + (y + n3 - y2) / n8;
                double1.y = y + n3;
                return double1;
            }
            else {
                final double y4 = y2 + n8 * (n - x);
                if (y4 < y) {
                    double1.x = x + (y - y2) / n8;
                    double1.y = y;
                    return double1;
                }
                if (y4 <= y + n3) {
                    double1.x = n;
                    double1.y = y4;
                    return double1;
                }
                double1.x = x + (y + n3 - y2) / n8;
                double1.y = y + n3;
                return double1;
            }
        }
    }
    
    public static int a(final Rectangle2D[] array, final Rectangle2D rectangle2D, final double n) {
        return a(array, rectangle2D, n, 1);
    }
    
    static void a(final Rectangle2D[] array, final Rectangle2D rectangle2D, final double n, final int[] array2) {
        final boolean j = X.j;
        if (array == null || array.length < 1) {
            if (rectangle2D != null) {
                rectangle2D.setFrame(0.0, 0.0, 0.0, 0.0);
            }
            array2[0] = (array2[1] = 0);
        }
        double max = 0.0;
        double n2 = 0.0;
        int i = 0;
        while (true) {
            while (i < array.length) {
                final Rectangle2D rectangle2D2 = array[i];
                max = Math.max(max, rectangle2D2.getWidth());
                final double max2 = Math.max(n2, rectangle2D2.getHeight());
                if (j) {
                    final double n3 = max2;
                    final double n4 = n3 / Math.sqrt(n3 / n);
                    final int n5 = (int)Math.floor(n4 / max);
                    final int n6 = (int)Math.ceil(n4 / max);
                    final int n7 = (int)Math.ceil(array.length / n5);
                    final int n8 = (int)Math.ceil(array.length / n6);
                    int n9 = 0;
                    int n10 = 0;
                    Label_0205: {
                        if (n5 * n7 < n6 * n8) {
                            n9 = n5;
                            n10 = n7;
                            if (!j) {
                                break Label_0205;
                            }
                        }
                        n9 = n6;
                        n10 = n8;
                    }
                    int n11 = 0;
                    int n12 = 0;
                    double n13 = 0.0;
                    double n14 = 0.0;
                    Label_0425: {
                        Label_0325: {
                            if (max > n2) {
                                int k = 0;
                                while (k < array.length) {
                                    array[k].setFrame(n12 * max, n11 * n2, array[k].getWidth(), array[k].getHeight());
                                    n13 = Math.max(n13, array[k].getMaxX());
                                    n14 = Math.max(n14, array[k].getMaxY());
                                    ++n12;
                                    if (j) {
                                        return;
                                    }
                                    if (n12 >= n9) {
                                        ++n11;
                                        n12 = 0;
                                    }
                                    ++k;
                                    if (j) {
                                        break Label_0325;
                                    }
                                }
                                break Label_0425;
                            }
                        }
                        int l = 0;
                        while (l < array.length) {
                            array[l].setFrame(n12 * max, n11 * n2, array[l].getWidth(), array[l].getHeight());
                            n13 = Math.max(n13, array[l].getMaxX());
                            n14 = Math.max(n14, array[l].getMaxY());
                            ++n11;
                            if (j) {
                                return;
                            }
                            if (n11 >= n10) {
                                ++n12;
                                n11 = 0;
                            }
                            ++l;
                            if (j) {
                                break;
                            }
                        }
                    }
                    if (rectangle2D != null) {
                        rectangle2D.setFrame(0.0, 0.0, n13, n14);
                    }
                    array2[0] = n10;
                    array2[1] = n9;
                    return;
                }
                n2 = max2;
                ++i;
                if (j) {
                    break;
                }
            }
            final double n15 = max * n2 * array.length;
            continue;
        }
    }
    
    public static int a(final Rectangle2D[] array, final Rectangle2D rectangle2D, final double n, final int n2) {
        final boolean j = X.j;
        if (array == null || array.length < 1) {
            if (rectangle2D != null) {
                rectangle2D.setFrame(0.0, 0.0, 0.0, 0.0);
            }
            return 0;
        }
        double n3;
        double max = n3 = array[0].getWidth();
        double n4;
        double max2 = n4 = array[0].getHeight();
        int i = 1;
        while (true) {
        Label_0252_Outer:
            while (i < array.length) {
                final double width = array[i].getWidth();
                n3 = Math.min(n3, width);
                max = Math.max(max, width);
                final double height = array[i].getHeight();
                n4 = Math.min(n4, height);
                max2 = Math.max(max2, height);
                ++i;
                if (j) {
                    final D d = new D();
                    double n5 = 0.0;
                    int k = 0;
                    while (true) {
                    Label_0994_Outer:
                        while (k < array.length) {
                            final Rectangle2D rectangle2D2 = array[k];
                            d.add(array[k]);
                            n5 += rectangle2D2.getWidth() * rectangle2D2.getHeight();
                            ++k;
                            if (!j) {
                                if (j) {
                                    break;
                                }
                                continue Label_0252_Outer;
                            }
                            else {
                                double max3 = 0.0;
                                double max4 = 0.0;
                                double n6 = Math.max(n3, 0.9 * (n * Math.sqrt(n5 / n)));
                                double n7 = Double.MAX_VALUE;
                                D d2 = null;
                                D d3 = new D();
                                int n8 = 0;
                                D d5 = null;
                            Block_21:
                                while (true) {
                                    ++n8;
                                    double min = Double.MAX_VALUE;
                                    D d4 = new D();
                                    d3.add(d4);
                                    double n10;
                                    double width2;
                                    double n9 = width2 = (n10 = 0.0);
                                    p p4 = d.k();
                                    while (true) {
                                        while (p4 != null) {
                                            final Rectangle2D rectangle2D3 = (Rectangle2D)p4.c();
                                            final double n11 = dcmpl(width2 + rectangle2D3.getWidth(), n6);
                                            if (!j) {
                                                Label_0482: {
                                                    if (n11 > 0 && d4.size() > 0) {
                                                        min = Math.min(width2 + rectangle2D3.getWidth(), min);
                                                        n10 = Math.max(n10, width2);
                                                        d4 = new D();
                                                        d4.add(rectangle2D3);
                                                        d3.add(d4);
                                                        width2 = rectangle2D3.getWidth();
                                                        if (!j) {
                                                            break Label_0482;
                                                        }
                                                    }
                                                    d4.add(rectangle2D3);
                                                    width2 += rectangle2D3.getWidth();
                                                }
                                                if (d4.size() == 1) {
                                                    n9 += ((Rectangle2D)d4.f()).getHeight();
                                                }
                                                n10 = Math.max(n10, width2);
                                                p4 = p4.a();
                                                if (j) {
                                                    break;
                                                }
                                                continue Label_0252_Outer;
                                            }
                                            else {
                                                final int n12 = (int)n11;
                                                final double n13 = n10 / n9;
                                                if (n13 > 0.0) {
                                                    final double n14 = Math.max(n13, n) / Math.min(n13, n);
                                                    if (n14 < n7) {
                                                        n7 = n14;
                                                        d2 = d3;
                                                        d3 = new D();
                                                    }
                                                }
                                                boolean b = true;
                                                while (true) {
                                                    Label_0651: {
                                                        if (n * n9 <= n10 || n12 <= 1) {
                                                            break Label_0651;
                                                        }
                                                        b = false;
                                                        d5.clear();
                                                        if (min < Double.MAX_VALUE) {
                                                            n6 = Math.max(1.1 * n6, min);
                                                            if (!j) {
                                                                break Label_0651;
                                                            }
                                                        }
                                                        n6 *= 1.1;
                                                    }
                                                    if (n8 > 50) {
                                                        b = true;
                                                    }
                                                    if (!b) {
                                                        continue Block_21;
                                                    }
                                                    d5 = d2;
                                                    if (!j) {
                                                        break Block_21;
                                                    }
                                                    continue Label_0994_Outer;
                                                }
                                            }
                                        }
                                        d3.size();
                                        continue Label_0994_Outer;
                                    }
                                }
                                if (d5 != null) {
                                    d3 = d2;
                                }
                                double n15 = 0.0;
                                final y.c.C m = d3.m();
                            Label_1277_Outer:
                                while (true) {
                                Label_1277:
                                    while (true) {
                                        while (true) {
                                        Label_0835:
                                            while (m.f()) {
                                                double n16 = 0.0;
                                                final D d6 = (D)m.d();
                                                final y.c.C l = d6.m();
                                                if (!j) {
                                                    final y.c.C c = l;
                                                    while (true) {
                                                        while (c.f()) {
                                                            final Rectangle2D rectangle2D4 = (Rectangle2D)c.d();
                                                            rectangle2D4.setFrame(n16, n15, rectangle2D4.getWidth(), rectangle2D4.getHeight());
                                                            n16 += rectangle2D4.getWidth();
                                                            c.g();
                                                            if (!j) {
                                                                if (j) {
                                                                    break;
                                                                }
                                                                continue Label_0252_Outer;
                                                            }
                                                            else {
                                                                if (j) {
                                                                    break Label_0835;
                                                                }
                                                                continue Label_1277_Outer;
                                                            }
                                                        }
                                                        max3 = Math.max(max3, n16);
                                                        n15 += a(d6);
                                                        max4 = Math.max(max4, n15);
                                                        m.g();
                                                        continue Label_0994_Outer;
                                                    }
                                                }
                                                final y.c.C c2 = l;
                                            Label_0996:
                                                while (c2.f()) {
                                                    final D d7 = (D)c2.d();
                                                    final double n17 = max3 - b(d7);
                                                    final D d8 = d7;
                                                    if (!j) {
                                                        p p5 = d8.k();
                                                        while (true) {
                                                            while (p5 != null) {
                                                                final Rectangle2D rectangle2D5 = (Rectangle2D)p5.c();
                                                                rectangle2D5.setFrame(rectangle2D5.getX() + n17, rectangle2D5.getY(), rectangle2D5.getWidth(), rectangle2D5.getHeight());
                                                                p5 = p5.a();
                                                                if (j) {
                                                                    continue Label_0996;
                                                                }
                                                                if (j) {
                                                                    break;
                                                                }
                                                            }
                                                            c2.g();
                                                            continue Label_1277_Outer;
                                                        }
                                                    }
                                                    break Label_1277;
                                                }
                                                if (rectangle2D != null) {
                                                    rectangle2D.setFrame(0.0, 0.0, max3, max4);
                                                }
                                                final D d9;
                                                d9.size();
                                                return;
                                            }
                                            switch (n2) {
                                                case 4: {
                                                    final y.c.C m2 = d3.m();
                                                Label_0871:
                                                    while (m2.f()) {
                                                        final D d10 = (D)m2.d();
                                                        final double n18 = (max3 - b(d10)) / 2.0;
                                                        final D d9 = d10;
                                                        if (!j) {
                                                            p p6 = d9.k();
                                                            while (true) {
                                                                while (p6 != null) {
                                                                    final Rectangle2D rectangle2D6 = (Rectangle2D)p6.c();
                                                                    rectangle2D6.setFrame(rectangle2D6.getX() + n18, rectangle2D6.getY(), rectangle2D6.getWidth(), rectangle2D6.getHeight());
                                                                    p6 = p6.a();
                                                                    if (j) {
                                                                        continue Label_0871;
                                                                    }
                                                                    if (j) {
                                                                        break;
                                                                    }
                                                                }
                                                                m2.g();
                                                                continue;
                                                            }
                                                        }
                                                        continue Label_1277;
                                                    }
                                                    continue;
                                                }
                                                case 2: {
                                                    d3.m();
                                                    continue Label_1277_Outer;
                                                }
                                                case 3: {
                                                    final y.c.C m3 = d3.m();
                                                    while (m3.f()) {
                                                        double n19 = 0.0;
                                                        final D d11 = (D)m3.d();
                                                        final int size = d11.size();
                                                        if (j) {
                                                            return size;
                                                        }
                                                        Label_1256: {
                                                            if (size > 1) {
                                                                final double n20 = (max3 - b(d11)) / (d11.size() - 1);
                                                                p p7 = d11.k();
                                                                while (p7 != null) {
                                                                    final Rectangle2D rectangle2D7 = (Rectangle2D)p7.c();
                                                                    rectangle2D7.setFrame(n19, rectangle2D7.getY(), rectangle2D7.getWidth(), rectangle2D7.getHeight());
                                                                    n19 += rectangle2D7.getWidth() + n20;
                                                                    p7 = p7.a();
                                                                    if (j) {
                                                                        break Label_1256;
                                                                    }
                                                                    if (j) {
                                                                        break;
                                                                    }
                                                                }
                                                            }
                                                            m3.g();
                                                        }
                                                        if (j) {
                                                            break;
                                                        }
                                                    }
                                                    continue;
                                                }
                                            }
                                            break;
                                        }
                                        break;
                                    }
                                    break;
                                }
                            }
                        }
                        d.sort(new af());
                        continue;
                    }
                }
                if (j) {
                    break;
                }
            }
            if (n4 / max2 > 0.95 && n3 / max > 0.95) {
                final int[] array2 = new int[2];
                a(array, rectangle2D, n, array2);
                return array2[0];
            }
            continue;
        }
    }
    
    private static double a(final D d) {
        final boolean j = X.j;
        double n = 0.0;
        p p = d.k();
        double max = 0.0;
        while (p != null) {
            max = Math.max(((Rectangle2D)p.c()).getHeight(), n);
            if (j) {
                return max;
            }
            n = max;
            p = p.a();
            if (j) {
                break;
            }
        }
        return max;
    }
    
    private static double b(final D d) {
        final boolean j = X.j;
        double n = 0.0;
        p p = d.k();
        double n2 = 0.0;
        while (p != null) {
            n2 = n + ((Rectangle2D)p.c()).getWidth();
            if (j) {
                return n2;
            }
            n = n2;
            p = p.a();
            if (j) {
                break;
            }
        }
        return n2;
    }
    
    public static boolean a(final X x, final d d, final Rectangle2D rectangle2D) {
        final boolean j = X.j;
        final D m = x.m(d);
        t t = (t)m.g();
        boolean intersectsLine = false;
        while (!m.isEmpty()) {
            final t t2 = (t)m.g();
            intersectsLine = rectangle2D.intersectsLine(t.a, t.b, t2.a, t2.b);
            if (j) {
                return intersectsLine;
            }
            if (intersectsLine) {
                return true;
            }
            t = t2;
            if (j) {
                break;
            }
        }
        return intersectsLine;
    }
    
    public static void a(final X x, final O o) {
        final boolean j = X.j;
        final x o2 = x.o();
        while (o2.f()) {
            final q e = o2.e();
            final am a = o.a(e);
            if (a != null) {
                x.a((Object)e);
                x.b(e, a.getWidth(), a.getHeight());
                x.c(e, a.getX(), a.getY());
            }
            final aj[] a_ = o.a_(e);
            final aj[] a_2 = x.a_(e);
            if (a_ != null && a_2 != null) {
                int n = 0;
                do {
                    Label_0114: {
                        final int length = a_.length;
                    }
                    int i = 0;
                    int length2 = 0;
                    while (i < length2) {
                        i = n;
                        length2 = a_2.length;
                        if (!j) {
                            if (i < length2) {
                                a_2[n].setModelParameter(a_[n].getModelParameter());
                                ++n;
                                continue Label_0114;
                            }
                            break;
                        }
                    }
                    break;
                } while (!j);
            }
            o2.g();
            if (j) {
                break;
            }
        }
        final e p2 = x.p();
    Label_0179:
        while (p2.f()) {
            final d a2 = p2.a();
            final I b = o.b(a2);
            Label_0382: {
                if (b != null) {
                    final I b2 = x.b((Object)a2);
                    b2.setSourcePoint(b.getSourcePoint());
                    b2.setTargetPoint(b.getTargetPoint());
                    Label_0324: {
                        if (b2.pointCount() != b.pointCount()) {
                            b2.clearPoints();
                            int k = 0;
                            while (k < b.pointCount()) {
                                final t point = b.getPoint(k);
                                b2.addPoint(point.a(), point.b());
                                ++k;
                                if (j) {
                                    continue Label_0179;
                                }
                                if (j) {
                                    break Label_0324;
                                }
                            }
                            break Label_0382;
                        }
                    }
                    int l = 0;
                    while (l < b.pointCount()) {
                        final t point2 = b.getPoint(l);
                        b2.setPoint(l, point2.a(), point2.b());
                        ++l;
                        if (j) {
                            continue Label_0179;
                        }
                        if (j) {
                            break;
                        }
                    }
                }
            }
            final C[] d = o.d(a2);
            final C[] d2 = x.d((Object)a2);
            if (d != null && d2 != null) {
                int n2 = 0;
                do {
                    Label_0411: {
                        final int length3 = d.length;
                    }
                    int n3 = 0;
                    int length4 = 0;
                    while (n3 < length4) {
                        n3 = n2;
                        length4 = d2.length;
                        if (!j) {
                            if (n3 < length4) {
                                d2[n2].setModelParameter(d[n2].getModelParameter());
                                ++n2;
                                continue Label_0411;
                            }
                            break;
                        }
                    }
                    break;
                } while (!j);
            }
            p2.g();
            if (j) {
                break;
            }
        }
    }
    
    public static void a(final X x, final y.c.y y, final q q, final boolean b, final byte b2) {
        final boolean j = X.j;
        if (y.size() > 1) {
            double n = Double.MAX_VALUE;
            double n2 = -1.7976931348623157E308;
            double n3 = 0.0;
            final x a = y.a();
        Label_0194_Outer:
            while (true) {
                while (true) {
                    while (a.f()) {
                        final am a2 = x.a((Object)a.e());
                        if (!j) {
                            Label_0169: {
                                if (b) {
                                    n3 += a2.getHeight();
                                    n = Math.min(n, a2.getY());
                                    n2 = Math.max(n2, a2.getY() + a2.getHeight());
                                    if (!j) {
                                        break Label_0169;
                                    }
                                }
                                n3 += a2.getWidth();
                                n = Math.min(n, a2.getX());
                                n2 = Math.max(n2, a2.getX() + a2.getWidth());
                            }
                            a.g();
                            if (j) {
                                break;
                            }
                            continue Label_0194_Outer;
                        }
                        else {
                            final am a3 = null;
                            final am am = a3;
                            Label_0814: {
                                switch (b2) {
                                    default: {
                                        return;
                                    }
                                    case -1: {
                                        Label_0312: {
                                            if (b) {
                                                final double n4 = (am != null) ? am.getY() : n;
                                                final x a4 = y.a();
                                                while (a4.f()) {
                                                    final am a5 = x.a((Object)a4.e());
                                                    a5.setLocation(a5.getX(), n4);
                                                    a4.g();
                                                    if (j) {
                                                        break Label_0312;
                                                    }
                                                }
                                                return;
                                            }
                                        }
                                        final double n5 = (am != null) ? am.getX() : n;
                                        final x a6 = y.a();
                                        while (a6.f()) {
                                            final am a7 = x.a((Object)a6.e());
                                            a7.setLocation(n5, a7.getY());
                                            a6.g();
                                            if (j) {
                                                break Label_0814;
                                            }
                                        }
                                        return;
                                    }
                                    case 0: {
                                        Label_0507: {
                                            if (b) {
                                                final double n6 = (am != null) ? (am.getY() + am.getHeight() * 0.5) : ((n + n2) * 0.5);
                                                final x a8 = y.a();
                                                while (a8.f()) {
                                                    final am a9 = x.a((Object)a8.e());
                                                    a9.setLocation(a9.getX(), n6 - a9.getHeight() * 0.5);
                                                    a8.g();
                                                    if (j) {
                                                        break Label_0507;
                                                    }
                                                }
                                                return;
                                            }
                                        }
                                        final double n7 = (am != null) ? (am.getX() + am.getWidth() * 0.5) : ((n + n2) * 0.5);
                                        final x a10 = y.a();
                                        while (a10.f()) {
                                            final am a11 = x.a((Object)a10.e());
                                            a11.setLocation(n7 - a11.getWidth() * 0.5, a11.getY());
                                            a10.g();
                                            if (j) {
                                                break Label_0814;
                                            }
                                        }
                                        return;
                                    }
                                    case 1: {
                                        Label_0718: {
                                            if (b) {
                                                final double n8 = (am != null) ? (am.getY() + am.getHeight()) : n2;
                                                final x a12 = y.a();
                                                while (a12.f()) {
                                                    final am a13 = x.a((Object)a12.e());
                                                    a13.setLocation(a13.getX(), n8 - a13.getHeight());
                                                    a12.g();
                                                    if (j) {
                                                        break Label_0718;
                                                    }
                                                }
                                                return;
                                            }
                                        }
                                        final double n9 = (am != null) ? (am.getX() + am.getWidth()) : n2;
                                        final x a14 = y.a();
                                        while (a14.f()) {
                                            final am a15 = x.a((Object)a14.e());
                                            a15.setLocation(n9 - a15.getWidth(), a15.getY());
                                            a14.g();
                                            if (j) {
                                                break Label_0814;
                                            }
                                        }
                                        return;
                                    }
                                    case 2: {
                                        y.sort(new ag(x, b));
                                        final double n10 = n2 - n - n3;
                                        double n11 = 0.0;
                                        Label_0864: {
                                            if (n10 <= 0.0) {
                                                n11 = 0.0;
                                                if (!j) {
                                                    break Label_0864;
                                                }
                                            }
                                            n11 = n10 / (y.size() - 1);
                                        }
                                        Label_0959: {
                                            if (b) {
                                                double y2 = x.a((Object)y.b()).getY();
                                                final x a16 = y.a();
                                                while (a16.f()) {
                                                    final am a17 = x.a((Object)a16.e());
                                                    a17.setLocation(a17.getX(), y2);
                                                    y2 += a17.getHeight() + n11;
                                                    a16.g();
                                                    if (j) {
                                                        break Label_0959;
                                                    }
                                                }
                                                return;
                                            }
                                        }
                                        double x2 = x.a((Object)y.b()).getX();
                                        final x a18 = y.a();
                                        while (a18.f()) {
                                            final am a19 = x.a((Object)a18.e());
                                            a19.setLocation(x2, a19.getY());
                                            x2 += a19.getWidth() + n11;
                                            a18.g();
                                            if (j) {
                                                break;
                                            }
                                        }
                                        return;
                                    }
                                }
                            }
                        }
                    }
                    if (q != null) {
                        final am a3 = x.a((Object)q);
                        continue;
                    }
                    break;
                }
                continue Label_0194_Outer;
            }
        }
    }
    
    static boolean a(final n n) {
        return Double.isNaN(n.b()) || Double.isNaN(n.c()) || Double.isNaN(n.e()) || Double.isNaN(n.f()) || Double.isNaN(n.g()) || Double.isNaN(n.i());
    }
    
    public static boolean b(final n n) {
        final double i = n.i();
        if (i > 0.0) {
            final t k = n.k();
            n.c(-n.g(), -i);
            n.b(k);
            return true;
        }
        return false;
    }
    
    static {
        a = new v();
        b = t.c;
    }
}
