package y.f.c.a;

import y.d.*;
import y.a.*;
import y.g.*;
import java.util.*;
import y.c.*;

class cr
{
    private static final double a;
    private Map b;
    private List c;
    private double d;
    private double e;
    private double f;
    private double g;
    private Map h;
    private List i;
    private Map j;
    private Set k;
    private c l;
    private c m;
    private double n;
    private boolean o;
    private double p;
    private double q;
    private double r;
    private double s;
    private ArrayList t;
    private int u;
    private long v;
    private int w;
    private int x;
    private final Comparator y;
    private List z;
    private D A;
    private D B;
    private double C;
    private double D;
    
    public cr() {
        this.e = -1.7976931348623157E308;
        this.f = Double.MAX_VALUE;
        this.g = 10.0;
        this.h = new HashMap();
        this.i = new ArrayList();
        this.j = new HashMap();
        this.k = new HashSet();
        this.n = 0.0;
        this.o = true;
        this.p = 1.0;
        this.q = 0.5;
        this.s = 0.0;
        this.t = new ArrayList();
        this.u = 20;
        this.v = 100L;
        this.w = 100;
        this.x = 500;
        this.y = new cz(null);
        this.b = new HashMap(11);
        this.c = new ArrayList(62);
    }
    
    public void a(final double e) {
        this.e = e;
    }
    
    public void a() {
        this.r = 0.0;
        this.k.clear();
        this.j.clear();
        this.i.clear();
        this.h.clear();
        this.b.clear();
        this.t.clear();
        this.c.clear();
        this.s = 0.0;
        this.d = -1.0;
        this.z = null;
    }
    
    public void b(final double n) {
        this.n = n;
    }
    
    public void c(final double s) {
        this.s = s;
    }
    
    public void a(final c l) {
        this.l = l;
    }
    
    public void b(final c m) {
        this.m = m;
    }
    
    public c b() {
        return this.l;
    }
    
    public c c() {
        return this.m;
    }
    
    public void a(final Object o, final double n, final boolean b, final double n2, final boolean b2, final boolean b3, final double n3) {
        this.a(o, 0.0, this.g, n, b, n2, b2, b3, n3);
    }
    
    public cy a(final Object o) {
        return this.b.get(o);
    }
    
    public cy a(final Object o, final double n, final double n2, final double n3, final double n4, final boolean b, final double n5, final boolean b2) {
        return this.a(o, n, n2, n3, n4, b, n5, b2, false, 0.0);
    }
    
    public cy a(final Object o, final double n, final double n2, final double n3, final boolean b, final double n4, final boolean b2, final boolean b3, final double n5) {
        return this.a(o, n, n2, n2, n3, b, n4, b2, b3, n5);
    }
    
    public cy a(final Object o, final double n, final double n2, final double n3, final double n4, final boolean b, final double n5, final boolean b2, final boolean b3, final double n6) {
        cy cy = null;
        Label_0060: {
            if (n4 > n5) {
                cy = y.f.c.a.cy.a(o, n, n5, b2, n4, b, n2, n3, b3, n6);
                if (!N.x) {
                    break Label_0060;
                }
            }
            cy = y.f.c.a.cy.a(o, n, n4, b, n5, b2, n2, n3, b3, n6);
        }
        this.b.put(o, cy);
        this.c.add(cy);
        this.k.add(o);
        return cy;
    }
    
    public cy a(final Object o, final Object o2, final double n, final double n2, final double n3, final boolean b, final double n4, final boolean b2, final boolean b3, final double n5) {
        D d = this.h.get(o2);
        if (d == null) {
            d = new D();
            this.h.put(o2, d);
            this.i.add(d);
        }
        final cy a = cy.a(o, n, n3, b, n4, b2, n2, n2, b3, n5);
        d.add(a);
        this.j.put(o, d);
        return a;
    }
    
    public void a(final Object o, final Object o2, final int n) {
        this.t.add(new Object[] { o, o2, new Integer(n) });
    }
    
    public boolean b(final Object o) {
        return this.k.contains(o);
    }
    
    public boolean c(final Object o) {
        final Object value = this.h.get(o);
        return value != null && this.b.containsKey(value);
    }
    
    public void a(final long v) {
        this.v = v;
    }
    
    public void a(final int w) {
        this.w = w;
    }
    
    public void b(final int u) {
        this.u = u;
    }
    
    public void c(final int x) {
        this.x = x;
    }
    
    public void d() {
        final boolean x = N.x;
        if (this.h.size() > 0) {
            this.l();
        }
        final cs cs = new cs(this);
        this.z = new ArrayList();
        final cy[] array = new cy[this.c.size()];
        this.C = Double.MAX_VALUE;
        this.D = -1.7976931348623157E308;
        int i = this.c.size() - 1;
        while (true) {
        Label_0328_Outer:
            while (i >= 0) {
                final cy cy = this.c.get(i);
                this.D = Math.max(this.D, cy.c);
                this.C = Math.min(this.C, cy.b);
                final cy[] array2 = array;
                if (x) {
                    final cy[] array3 = array2;
                    System.arraycopy(array, 0, array3, 0, array.length);
                    final cv[] array4 = new cv[array3.length * 2];
                    int j = 0;
                    while (true) {
                        while (j < array3.length) {
                            final cy cy2 = array3[j];
                            final cv cv = new cv(null);
                            cv.b = cy2.b - cy2.h - cy2.e;
                            cv.c = true;
                            cv.a = cy2;
                            array4[j * 2] = cv;
                            final cv cv2 = new cv(null);
                            cv2.b = cy2.c + cy2.h + cy2.e;
                            cv2.c = false;
                            cv2.a = cy2;
                            array4[j * 2 + 1] = cv2;
                            ++j;
                            if (x) {
                                final ArrayList list = new ArrayList<cy>(array3.length);
                                int n = 0;
                            Label_2256:
                                do {
                                    Label_2248: {
                                    Label_2198:
                                        while (true) {
                                            final int length = array4.length;
                                        Label_0347:
                                            while (true) {
                                                int k = 0;
                                                int n2 = 0;
                                                while (k < n2) {
                                                    final cv cv3 = array4[n];
                                                    if (x) {
                                                        return;
                                                    }
                                                    if (cv3.c) {
                                                        ++j;
                                                        cv3.a.r = list.size();
                                                        list.add(cv3.a);
                                                        if (!x) {
                                                            break Label_2248;
                                                        }
                                                    }
                                                    if (--j != 0) {
                                                        break Label_2248;
                                                    }
                                                    final int size = list.size();
                                                    if (size <= 1) {
                                                        break Label_2198;
                                                    }
                                                    final q[] array5 = new q[size];
                                                    final i l = new i();
                                                    final i m = new i();
                                                    final i i2 = new i();
                                                    i i3 = null;
                                                    A t = null;
                                                    q[] array6 = null;
                                                    h u = null;
                                                    h u2 = null;
                                                    A a = null;
                                                Label_0455:
                                                    while (true) {
                                                        i i4 = null;
                                                        i3 = i4;
                                                        if (size > this.u) {
                                                            i3 = null;
                                                            t = null;
                                                            array6 = null;
                                                        }
                                                        else {
                                                            t = i3.t();
                                                            array6 = new q[list.size()];
                                                        }
                                                        u = l.u();
                                                        u2 = l.u();
                                                        a = M.a();
                                                        int n3 = 0;
                                                        while (n3 < size) {
                                                            a.a(array5[n3] = l.d(), list.get(n3));
                                                            i4 = i3;
                                                            if (x) {
                                                                continue Label_0455;
                                                            }
                                                            if (i4 != null) {
                                                                t.a(array6[n3] = i3.d(), list.get(n3));
                                                            }
                                                            ++n3;
                                                            if (x) {
                                                                break;
                                                            }
                                                        }
                                                        break;
                                                    }
                                                    int n4 = 0;
                                                Label_0874:
                                                    for (final Object[] array7 : this.t) {
                                                        final cy a2 = this.a(array7[0]);
                                                        final cy a3 = this.a(array7[1]);
                                                        cy cy3 = null;
                                                        while (cy3 != null) {
                                                            cy3 = a3;
                                                            if (!x) {
                                                                if (cy3 == null || a2.r < 0 || a2.r >= size || list.get(a2.r) != a2 || a3.r < 0 || a3.r >= size || list.get(a3.r) != a3 || (int)array7[2] <= 0) {
                                                                    break;
                                                                }
                                                                final d a4 = l.a(array5[a2.r], array5[a3.r]);
                                                                ++n4;
                                                                u.a(a4, 3);
                                                                u2.a(a4, 1);
                                                                if (i3 == null || i3.b(array6[a2.r], array6[a3.r]) || i3.b(array6[a3.r], array6[a2.r])) {
                                                                    break;
                                                                }
                                                                i3.a(array6[a2.r], array6[a3.r]);
                                                                if (x) {
                                                                    break Label_0874;
                                                                }
                                                                break;
                                                            }
                                                        }
                                                    }
                                                    i i5 = null;
                                                    Label_1396: {
                                                        if (i3 != null || n4 < this.x) {
                                                            int n5 = 0;
                                                            while (n5 < size) {
                                                                final cy cy4 = list.get(n5);
                                                                k = n5 + 1;
                                                                if (x) {
                                                                    continue Label_2248;
                                                                }
                                                                int n6 = k;
                                                                while (n6 < size) {
                                                                    final cy cy5 = list.get(n6);
                                                                    i5 = i3;
                                                                    if (x) {
                                                                        break Label_1396;
                                                                    }
                                                                    if (i5 != null && cy4.c + cy4.h + cy4.e > cy5.b - cy5.h - cy5.e && cy4.b - cy4.h - cy4.e < cy5.c + cy5.h + cy5.e) {
                                                                        boolean b = true;
                                                                        Label_1212: {
                                                                            if (cy4.b - cy4.e > cy5.c + cy5.e) {
                                                                                if (cy4.m == 0 || cy4.m == 2) {
                                                                                    if (cy5.m != 1 && cy5.m != 0) {
                                                                                        break Label_1212;
                                                                                    }
                                                                                    b = false;
                                                                                    if (!x) {
                                                                                        break Label_1212;
                                                                                    }
                                                                                }
                                                                                if (cy5.m != 3 && cy5.m != 2) {
                                                                                    break Label_1212;
                                                                                }
                                                                                b = false;
                                                                                if (!x) {
                                                                                    break Label_1212;
                                                                                }
                                                                            }
                                                                            if (cy5.b - cy5.e > cy4.c + cy4.e) {
                                                                                if (cy4.m == 0 || cy4.m == 1) {
                                                                                    if (cy5.m != 2 && cy5.m != 0) {
                                                                                        break Label_1212;
                                                                                    }
                                                                                    b = false;
                                                                                    if (!x) {
                                                                                        break Label_1212;
                                                                                    }
                                                                                }
                                                                                if (cy5.m == 3 || cy5.m == 1) {
                                                                                    b = false;
                                                                                }
                                                                            }
                                                                        }
                                                                        if (b && array6[n5].c(array6[n6]) == null) {
                                                                            i3.a(array6[n5], array6[n6]);
                                                                            if (i3.g() > this.w) {
                                                                                i3 = null;
                                                                            }
                                                                        }
                                                                    }
                                                                    Label_1378: {
                                                                        if (n4 < this.x) {
                                                                            final int a5 = this.a(cy4, cy5);
                                                                            if (a5 != 0) {
                                                                                ++n4;
                                                                                if (a5 > 0) {
                                                                                    final d a6 = l.a(array5[n5], array5[n6]);
                                                                                    u.a(a6, a5);
                                                                                    u2.a(a6, 1);
                                                                                    if (!x) {
                                                                                        break Label_1378;
                                                                                    }
                                                                                }
                                                                                final d a7 = l.a(array5[n6], array5[n5]);
                                                                                u.a(a7, -a5);
                                                                                u2.a(a7, 1);
                                                                            }
                                                                        }
                                                                    }
                                                                    ++n6;
                                                                    if (x) {
                                                                        break;
                                                                    }
                                                                }
                                                                ++n5;
                                                                if (x) {
                                                                    break;
                                                                }
                                                            }
                                                        }
                                                    }
                                                    final q d = i5.d();
                                                    l.d();
                                                Label_1406:
                                                    while (true) {
                                                        while (true) {
                                                            q e = null;
                                                            final q q = e;
                                                            u.a(l.a(d, q), 0);
                                                            l.o();
                                                            Label_1434:
                                                            while (true) {
                                                                x a8 = null;
                                                                final x x2 = a8;
                                                                while (x2.f()) {
                                                                    final q q2 = e = x2.e();
                                                                    if (x) {
                                                                        continue Label_1406;
                                                                    }
                                                                    Label_1604: {
                                                                        if (e != d && q2 != q) {
                                                                            final cy cy6 = (cy)a.b(q2);
                                                                            if (cy6 != null) {
                                                                                if (cy6.a() == 0) {
                                                                                    u.a(l.a(q2, d), 0);
                                                                                    if (!x) {
                                                                                        break Label_1604;
                                                                                    }
                                                                                }
                                                                                if (cy6.a() == 3) {
                                                                                    u.a(l.a(q, q2), 0);
                                                                                    if (!x) {
                                                                                        break Label_1604;
                                                                                    }
                                                                                }
                                                                                u.a(l.a(d, q2), 0);
                                                                                u.a(l.a(q2, q), 0);
                                                                            }
                                                                        }
                                                                    }
                                                                    x2.g();
                                                                    if (x) {
                                                                        break;
                                                                    }
                                                                }
                                                                final int[] array8 = new int[4];
                                                                do {
                                                                    Label_1624:
                                                                    final f a9 = y.a.c.a(l, true);
                                                                    f f = null;
                                                                    while (!f.isEmpty()) {
                                                                        d b2 = a9.b();
                                                                        int a10 = u.a(b2);
                                                                        f = a9;
                                                                        if (!x) {
                                                                            final y.c.e a11 = f.a();
                                                                            while (a11.f()) {
                                                                                final d a12 = a11.a();
                                                                                final int a13 = u.a(a12);
                                                                                n2 = a10;
                                                                                if (x) {
                                                                                    continue Label_0347;
                                                                                }
                                                                                if (a13 < n2) {
                                                                                    a10 = a13;
                                                                                    b2 = a12;
                                                                                }
                                                                                a11.g();
                                                                                if (x) {
                                                                                    break;
                                                                                }
                                                                            }
                                                                            final q d2 = l.d();
                                                                            u.a(l.a(b2.d(), d2), -a10);
                                                                            final int[] array9 = array8;
                                                                            final int n7 = a10;
                                                                            ++array9[n7];
                                                                            l.a(b2, b2.c(), d2);
                                                                            continue Label_1624;
                                                                        }
                                                                    }
                                                                    break;
                                                                } while (!x);
                                                                final int[] array10 = new int[4];
                                                                array10[0] = 1;
                                                                int n8 = 1;
                                                                while (n8 < 3) {
                                                                    array10[n8] = array8[n8] * array10[n8 - 1] + 1;
                                                                    ++n8;
                                                                    if (x) {
                                                                        break Label_2198;
                                                                    }
                                                                    if (x) {
                                                                        break;
                                                                    }
                                                                }
                                                                final A a14 = M.a(new int[l.f()]);
                                                                final h b3 = M.b(new int[l.h()]);
                                                                final y.c.e p = l.p();
                                                                while (true) {
                                                                    while (p.f()) {
                                                                        final d a15 = p.a();
                                                                        final int a16;
                                                                        final int n9 = a16 = u.a(a15);
                                                                        if (!x) {
                                                                            if (a16 < 0) {
                                                                                b3.a(a15, array10[-n9]);
                                                                            }
                                                                            p.g();
                                                                            if (x) {
                                                                                break;
                                                                            }
                                                                            continue Label_0328_Outer;
                                                                        }
                                                                        else {
                                                                            int n10 = a16;
                                                                            while (n10 < array5.length) {
                                                                                final q q3 = array5[n10];
                                                                                final cy cy7 = list.get(n10);
                                                                                cy7.d = a14.a(q3);
                                                                                final byte m2;
                                                                                final byte b4 = m2 = cy7.m;
                                                                                if (x) {
                                                                                    continue Label_2248;
                                                                                }
                                                                                Label_2056: {
                                                                                    if (b4 == 0) {
                                                                                        final cy cy8 = cy7;
                                                                                        cy8.d -= 0.25;
                                                                                        if (!x) {
                                                                                            break Label_2056;
                                                                                        }
                                                                                    }
                                                                                    if (cy7.m == 3) {
                                                                                        final cy cy9 = cy7;
                                                                                        cy9.d += 0.25;
                                                                                    }
                                                                                }
                                                                                ++n10;
                                                                                if (x) {
                                                                                    break;
                                                                                }
                                                                            }
                                                                            if (i3 != null && i3.g() < this.w) {
                                                                                final y[] a17 = y.a.k.a(i3);
                                                                                final double n11 = 0.2 / a17.length;
                                                                                int n12 = 0;
                                                                                Label_2101:
                                                                                while (n12 < a17.length) {
                                                                                    a8 = a17[n12].a();
                                                                                    if (!x) {
                                                                                        final x x3 = a8;
                                                                                        while (true) {
                                                                                            while (x3.f()) {
                                                                                                final cy cy10 = (cy)t.b(x3.e());
                                                                                                cy10.d += n11 * n12;
                                                                                                x3.g();
                                                                                                if (!x) {
                                                                                                    if (x) {
                                                                                                        break;
                                                                                                    }
                                                                                                    continue Label_0328_Outer;
                                                                                                }
                                                                                                else {
                                                                                                    if (x) {
                                                                                                        break Label_2198;
                                                                                                    }
                                                                                                    continue Label_2101;
                                                                                                }
                                                                                            }
                                                                                            ++n12;
                                                                                            continue;
                                                                                        }
                                                                                    }
                                                                                    continue Label_1434;
                                                                                }
                                                                                break Label_2198;
                                                                            }
                                                                            break Label_2198;
                                                                        }
                                                                    }
                                                                    y.a.u.a(l, a14, b3, u2, this.v);
                                                                    continue;
                                                                }
                                                            }
                                                        }
                                                        break;
                                                    }
                                                }
                                                break;
                                            }
                                            break Label_2256;
                                        }
                                        final cy[] array11 = list.toArray(new cy[list.size()]);
                                        list.clear();
                                        y.g.e.a(array11, this.y);
                                        y.g.e.a(array11, cs);
                                        this.z.add(array11);
                                    }
                                    ++n;
                                } while (!x);
                                this.k();
                                return;
                            }
                            if (x) {
                                break;
                            }
                        }
                        y.g.e.a(array4, new ct(this));
                        j = 0;
                        continue;
                    }
                }
                array2[i] = cy;
                --i;
                if (x) {
                    break;
                }
            }
            final cy[] array12 = new cy[array.length];
            continue;
        }
    }
    
    private int a(final cy cy, final cy cy2) {
        if (cy.c + cy.h < cy2.b - cy2.h) {
            return 0;
        }
        if (cy.b - cy.h > cy2.c + cy2.h) {
            return 0;
        }
        if (cy2.a() == cy.a()) {
            switch (cy2.a()) {
                default: {
                    if (cy.b == cy2.b) {
                        if (cy.c < cy2.c) {
                            return 1;
                        }
                        if (cy.c == cy2.c) {
                            return 0;
                        }
                        return -1;
                    }
                    else if (cy.c == cy2.c) {
                        if (cy.b > cy2.c) {
                            return 1;
                        }
                        return -1;
                    }
                    else if (cy.b < cy2.b) {
                        if (cy.c > cy2.c) {
                            return -2;
                        }
                        return 0;
                    }
                    else {
                        if (cy.c < cy2.c) {
                            return 2;
                        }
                        return 0;
                    }
                    break;
                }
                case 3: {
                    if (cy.b == cy2.b) {
                        if (cy.c < cy2.c) {
                            return -1;
                        }
                        if (cy.c == cy2.c) {
                            return 0;
                        }
                        return 1;
                    }
                    else if (cy.c == cy2.c) {
                        if (cy.b > cy2.c) {
                            return -1;
                        }
                        return 1;
                    }
                    else if (cy.b < cy2.b) {
                        if (cy.c > cy2.c) {
                            return 2;
                        }
                        return 0;
                    }
                    else {
                        if (cy.c < cy2.c) {
                            return -2;
                        }
                        return 0;
                    }
                    break;
                }
                case 1: {
                    if (cy.b == cy2.b) {
                        if (cy.c > cy2.c) {
                            return -1;
                        }
                        if (cy.c < cy2.c) {
                            return 1;
                        }
                        return 0;
                    }
                    else if (cy.c == cy2.c) {
                        if (cy.b > cy2.b) {
                            return -1;
                        }
                        if (cy.b < cy2.b) {
                            return 1;
                        }
                        return 0;
                    }
                    else if (cy.b < cy2.b && cy.c > cy2.c) {
                        final boolean a = this.a(cy.b, cy.h, cy2.b, cy2.h);
                        final boolean a2 = this.a(cy.c, cy.h, cy2.c, cy2.h);
                        if (a && !a2) {
                            return 1;
                        }
                        if (a2 && !a) {
                            return -1;
                        }
                        return 0;
                    }
                    else if (cy2.b < cy.b && cy2.c > cy.c) {
                        final boolean a3 = this.a(cy.b, cy.h, cy2.b, cy2.h);
                        final boolean a4 = this.a(cy.c, cy.h, cy2.c, cy2.h);
                        if (a3 && !a4) {
                            return -1;
                        }
                        if (a4 && !a3) {
                            return 1;
                        }
                        return 0;
                    }
                    else {
                        if (cy.b < cy2.b && cy.c < cy2.c) {
                            return 2;
                        }
                        if (cy2.b < cy.b && cy2.c < cy.c) {
                            return -2;
                        }
                        break;
                    }
                    break;
                }
                case 2: {
                    if (cy.b == cy2.b) {
                        if (cy.c > cy2.c) {
                            return 1;
                        }
                        if (cy.c < cy2.c) {
                            return -1;
                        }
                        return 0;
                    }
                    else if (cy.c == cy2.c) {
                        if (cy.b > cy2.b) {
                            return 1;
                        }
                        if (cy.b < cy2.b) {
                            return -1;
                        }
                        return 0;
                    }
                    else if (cy.b < cy2.b && cy.c > cy2.c) {
                        final boolean a5 = this.a(cy.b, cy.h, cy2.b, cy2.h);
                        final boolean a6 = this.a(cy.c, cy.h, cy2.c, cy2.h);
                        if (a5 && !a6) {
                            return -1;
                        }
                        if (a6 && !a5) {
                            return 1;
                        }
                        return 0;
                    }
                    else if (cy2.b < cy.b && cy2.c > cy.c) {
                        final boolean a7 = this.a(cy.b, cy.h, cy2.b, cy2.h);
                        final boolean a8 = this.a(cy.c, cy.h, cy2.c, cy2.h);
                        if (a7 && !a8) {
                            return 1;
                        }
                        if (a8 && !a7) {
                            return -1;
                        }
                        return 0;
                    }
                    else {
                        if (cy.b < cy2.b && cy.c < cy2.c) {
                            return -2;
                        }
                        if (cy2.b < cy.b && cy2.c < cy.c) {
                            return 2;
                        }
                        break;
                    }
                    break;
                }
            }
        }
        else {
            if (cy2.a() == 0) {
                return -3;
            }
            if (cy.a() == 0) {
                return 3;
            }
            if (cy2.a() == 3) {
                return 3;
            }
            if (cy.a() == 3) {
                return -3;
            }
            final boolean a9 = this.a(cy.b, cy.h, cy2.b, cy2.h);
            final boolean a10 = this.a(cy.c, cy.h, cy2.c, cy2.h);
            if (cy.a() == 2) {
                if (a9) {
                    if (!a10) {
                        return 2;
                    }
                    final double abs = Math.abs(cy.b - cy2.b);
                    final double abs2 = Math.abs(cy.c - cy2.c);
                    if (abs == abs2) {
                        return 0;
                    }
                    return (abs > abs2) ? -1 : 1;
                }
                else if (a10) {
                    return -2;
                }
            }
            else if (a9) {
                if (!a10) {
                    return -2;
                }
                final double abs3 = Math.abs(cy.b - cy2.b);
                final double abs4 = Math.abs(cy.c - cy2.c);
                if (abs3 == abs4) {
                    return 0;
                }
                return (abs3 > abs4) ? 1 : -1;
            }
            else if (a10) {
                return 2;
            }
        }
        return 0;
    }
    
    private boolean a(final double n, final double n2, final double n3, final double n4) {
        return Math.abs(n - n3) < Math.min(n2, n4);
    }
    
    private void k() {
        final boolean x = N.x;
        this.A = new D();
        Label_0305: {
            Label_0245: {
                if (this.l != null) {
                    if (this.l.b(this.l.e()) > this.C) {
                        this.A.a(new cw(this.C, -this.f, 0.0, this.s, false));
                    }
                    y.d.d d = this.l.e();
                    while (true) {
                        while (d != null) {
                            final double b = this.l.b(d);
                            final double n = -this.l.c(d);
                            final double a = this.l.a(d);
                            final double n2 = dcmpl(a, Double.MAX_VALUE);
                            if (!x) {
                                this.A.b(new cw(b, (n2 == 0) ? (-this.f) : (-a), n, 0.0, this.s, false));
                                d = this.l.e(d);
                                if (x) {
                                    break;
                                }
                                continue;
                            }
                            else {
                                if (n2 >= 0) {
                                    break Label_0305;
                                }
                                this.A.b(new cw(this.D, -this.f, 0.0, this.s, false));
                                if (x) {
                                    break Label_0245;
                                }
                                break Label_0305;
                            }
                        }
                        final double n3 = dcmpg(this.l.b(this.l.f()), this.D);
                        continue;
                    }
                }
            }
            this.A.a(new cw(this.C, -this.f, 0.0, this.s, false));
            this.A.b(new cw(this.D, -this.f, 0.0, this.s, false));
        }
        this.B = new D();
        Label_0540: {
            if (this.m != null) {
                if (this.m.b(this.m.e()) > this.C) {
                    this.B.a(new cw(this.C, this.e, 0.0, this.s, true));
                }
                y.d.d d2 = this.m.e();
                while (true) {
                    while (d2 != null) {
                        final double b2 = this.m.b(d2);
                        final double c = this.m.c(d2);
                        final double a2 = this.m.a(d2);
                        final double n4 = dcmpl(a2, -1.7976931348623157E308);
                        if (!x) {
                            this.B.b(new cw(b2, (n4 == 0) ? this.e : a2, c, 0.0, this.s, true));
                            d2 = this.m.e(d2);
                            if (x) {
                                break;
                            }
                            continue;
                        }
                        else {
                            if (n4 >= 0) {
                                return;
                            }
                            this.B.b(new cw(this.D, this.e, 0.0, this.s, true));
                            if (x) {
                                break Label_0540;
                            }
                            return;
                        }
                    }
                    final double n5 = dcmpg(this.m.b(this.m.f()), this.D);
                    continue;
                }
            }
        }
        this.B.a(new cw(this.C, this.e, 0.0, this.s, true));
        this.B.b(new cw(this.D, this.e, 0.0, this.s, true));
    }
    
    private static D a(final D d, final boolean b) {
        final boolean x = N.x;
        if (d == null || d.isEmpty()) {
            return d;
        }
        final ArrayList<cu> list = (ArrayList<cu>)new ArrayList<Comparable>();
        cw cw = null;
        p p2 = d.k();
        while (true) {
            while (p2 != null) {
                final cw a = a((cw)p2.c(), p2.a());
                if (x) {
                    final D d2 = new D();
                    final cx cx = new cx();
                    cw cw2 = null;
                    double n = cu.a(list.get(0));
                    for (final cu cu : list) {
                        if (n != cu.a(cu)) {
                            final cw a2 = cx.a(n);
                            if (a2 != null && (cw2 == null || cw2.c != a2.c || cw2.e != a2.e || cw2.d != a2.d || cw2.a != a2.a)) {
                                d2.add(a2);
                                cw2 = a2;
                            }
                            n = cu.a(cu);
                        }
                        if (cu.a()) {
                            cx.a(cu.b(cu));
                            if (!x) {
                                continue;
                            }
                        }
                        cx.b(cu.b(cu));
                        if (x) {
                            break;
                        }
                    }
                    final cw a3 = cx.a(n);
                    if (a3 != null && (cw2 == null || cw2.c != a3.c || cw2.e != a3.e || cw2.d != a3.d || cw2.a != a3.a)) {
                        d2.add(a3);
                    }
                    return d2;
                }
                Label_0246: {
                    if (cw == null) {
                        list.add(new cu((a.b == -1.7976931348623157E308) ? a.b : (a.b - (a.d + a.e)), (byte)0, a));
                        if (!x) {
                            break Label_0246;
                        }
                    }
                    final boolean b2 = a.c < cw.c;
                    list.add(new cu(a.b + (b2 ? (cw.d + cw.e) : 0.0), (byte)1, cw));
                    list.add(new cu(a.b - (b2 ? 0.0 : (a.d + a.e)), (byte)0, a));
                }
                cw = a;
                p2 = p2.a();
                if (x) {
                    break;
                }
            }
            Collections.sort((List<Comparable>)list);
            continue;
        }
    }
    
    private static cw a(final cw cw, final p p2) {
        final boolean x = N.x;
        if (cw.f == 1.0) {
            if (p2 != null) {
                final double c = cw.c + ((cw)p2.c()).b - cw.b;
                if (!x) {
                    return new cw(cw.b, c, cw.d, cw.e, cw.a);
                }
            }
            final double c = Double.MAX_VALUE;
            if (!x) {
                return new cw(cw.b, c, cw.d, cw.e, cw.a);
            }
        }
        final double c = cw.c;
        return new cw(cw.b, c, cw.d, cw.e, cw.a);
    }
    
    private double f(final double n) {
        final boolean x = N.x;
        p p = a(this.B, true).k();
        p p2 = a(this.A, false).k();
        double max = -1.7976931348623157E308;
        while (p != null && p2 != null) {
            final cw cw = (cw)p.c();
            final cw cw2 = (cw)p2.c();
            double n3 = 0.0;
            Label_0263: {
                if (cw.b < cw2.b) {
                    final double n2 = cw.b + (cw2.b - cw.b) * cw.f;
                    final cw cw3 = (cw)p2.b().c();
                    n3 = -(Math.min(cw2.c, cw3.c + (cw2.b - cw3.b) * cw3.f) + cw2.d) - (n2 + cw.d);
                    if (!x) {
                        break Label_0263;
                    }
                }
                final double n4 = cw2.b + (cw.b - cw2.b) * cw2.f;
                final cw cw4 = (cw)p.b().c();
                n3 = -(n4 + cw2.d) - (Math.max(cw.c, cw4.c + (cw.b - cw4.b) * cw4.f) + cw.d);
            }
            max = Math.max(max, n * (Math.max(cw.e, cw2.e) - n3));
            if (p.a() != null && p2.a() != null) {
                if (((cw)p.a().c()).b < ((cw)p2.a().c()).b) {
                    p = p.a();
                    if (!x) {
                        continue;
                    }
                }
                p2 = p2.a();
                if (!x) {
                    continue;
                }
            }
            if (p2.a() != null) {
                p2 = p2.a();
                if (!x) {
                    continue;
                }
            }
            if (p.a() == null) {
                break;
            }
            p = p.a();
            if (x) {
                break;
            }
        }
        if (max == -1.7976931348623157E308) {
            return 0.0;
        }
        return max;
    }
    
    private double g(final double n) {
        final boolean x = N.x;
        p p = a(this.B, true).k();
        p p2 = a(this.A, false).k();
        double max = -1.7976931348623157E308;
        while (p != null && p2 != null) {
            final cw cw = (cw)p.c();
            final cw cw2 = (cw)p2.c();
            max = Math.max(max, Math.max(n, Math.max(cw.e, cw2.e)) - (-(cw2.c + cw2.d) - (cw.c + cw.d)));
            if (p.a() != null && p2.a() != null) {
                if (((cw)p.a().c()).b < ((cw)p2.a().c()).b) {
                    p = p.a();
                    if (!x) {
                        continue;
                    }
                }
                p2 = p2.a();
                if (!x) {
                    continue;
                }
            }
            if (p2.a() != null) {
                p2 = p2.a();
                if (!x) {
                    continue;
                }
            }
            if (p.a() == null) {
                break;
            }
            p = p.a();
            if (x) {
                break;
            }
        }
        return -max;
    }
    
    double e() {
        return this.r;
    }
    
    public double d(final double n) {
        double max = Math.max(this.r, -this.g(n));
        if (max == -1.7976931348623157E308) {
            max = 0.0;
        }
        return max;
    }
    
    public void f() {
        final boolean x = N.x;
        final Iterator<cy[]> iterator = (Iterator<cy[]>)this.z.iterator();
    Label_0079:
        while (true) {
            iterator.hasNext();
            byte m = 0;
        Label_0021:
            while (m != 0) {
                final cy[] array = iterator.next();
                int i = 0;
                while (i < array.length) {
                    m = array[i].m;
                    if (x) {
                        continue Label_0021;
                    }
                    if (m != 0) {
                        break;
                    }
                    this.a(this.B, array[i]);
                    ++i;
                    if (x) {
                        break Label_0079;
                    }
                }
                continue Label_0079;
            }
            break;
        }
    }
    
    public void g() {
        final boolean x = N.x;
    Label_0178:
        for (final cy[] array : this.z) {
            int n = array.length;
            int n2 = 1;
        Label_0037:
            while (true) {
                int i = n - n2;
                while (i >= 0) {
                    final byte b = (byte)(n = array[i].m);
                    final int n3 = n2 = 3;
                    if (x) {
                        continue Label_0037;
                    }
                    if (b != n3) {
                        break;
                    }
                    final cy cy = array[i];
                    final double k = cy.k;
                    final double l = cy.l;
                    final double f = cy.f;
                    final double g = cy.g;
                    cy.l = -k;
                    cy.k = -l;
                    cy.g = f;
                    cy.f = g;
                    this.a(this.A, cy);
                    cy.d = -cy.d;
                    cy.k = k;
                    cy.l = l;
                    cy.g = g;
                    cy.f = f;
                    --i;
                    if (x) {
                        break Label_0178;
                    }
                }
                break;
            }
        }
    }
    
    public void h() {
        final boolean x = N.x;
    Label_0077_Outer:
        for (final cy[] array : this.z) {
            final int a = this.a(array);
            int i = 0;
            while (true) {
                while (i <= a) {
                    final int m;
                    final byte b = (byte)(m = array[i].m);
                    if (x) {
                        while (true) {
                            Label_0110: {
                                if (m > a) {
                                    break Label_0110;
                                }
                                this.a(this.B, array[i]);
                                ++i;
                                if (!x) {
                                    if (x) {
                                        break Label_0110;
                                    }
                                    break;
                                }
                                while (true) {
                                    while (i > a) {
                                        final int j;
                                        final byte b2 = (byte)(j = array[i].m);
                                        final int n2;
                                        final int n = n2 = 3;
                                        if (!x) {
                                            if (b2 != n) {
                                                break;
                                            }
                                            --i;
                                            if (x) {
                                                break;
                                            }
                                            continue Label_0077_Outer;
                                        }
                                        else {
                                            if (j <= n2) {
                                                continue Label_0077_Outer;
                                            }
                                            final cy cy = array[i];
                                            final double k = cy.k;
                                            final double l = cy.l;
                                            cy.l = -k;
                                            cy.k = -l;
                                            this.a(this.A, cy);
                                            cy.d = -cy.d;
                                            cy.k = k;
                                            cy.l = l;
                                            --i;
                                            if (x || x) {
                                                break Label_0077_Outer;
                                            }
                                            break;
                                        }
                                    }
                                    int j = i;
                                    int n2 = a;
                                    continue;
                                }
                            }
                            i = array.length - 1;
                            continue;
                        }
                    }
                    if (b != 0) {
                        break;
                    }
                    ++i;
                    if (x) {
                        break;
                    }
                }
                int m = i;
                continue;
            }
        }
    }
    
    private int a(final cy[] array) {
        final boolean x = N.x;
        int n = -1;
        int length = array.length;
        int i = 0;
        while (true) {
            while (i < array.length) {
                final cy cy = array[i];
                final int m;
                final byte b = (byte)(m = cy.m);
                if (!x) {
                    Label_0065: {
                        if (b == 0) {
                            n = i;
                            if (!x) {
                                break Label_0065;
                            }
                        }
                        if (cy.m == 3 && length == array.length) {
                            length = i;
                        }
                    }
                    ++i;
                    if (x) {
                        break;
                    }
                    continue;
                }
                else {
                    if (m == array.length) {
                        return length - 1;
                    }
                    if (n < 0) {
                        return length - 1;
                    }
                    return Math.min(array.length - 1, n + (length - n) / 2);
                }
            }
            int m = length;
            continue;
        }
    }
    
    void i() {
        final boolean x = N.x;
        final double r = this.r;
        final double[][] array = { { 3.0, 10.0, 15.0 }, { 3.0, 2.0, 5.0 }, { 2.0, 1.0, 3.0 }, { 0.0, 1.0, 1.0 }, { 0.0, 0.0, 0.0 } };
        double n = 1.0;
        double n2 = 1.0;
        double n3 = 1.0;
        this.r = this.a(n, n2, n3, 0.0, 0.0, 0.0);
        int n4 = 0;
        do {
            Label_0150: {
                final double n5 = dcmpl(this.r, 0.0);
            }
            double n6 = 0.0;
            Label_0156:
            while (n6 > 0 && n4 < array.length) {
                double r2 = Double.MAX_VALUE;
                while (this.r > 0.0) {
                    n6 = dcmpl(r2, this.r + 0.001);
                    if (x) {
                        continue Label_0156;
                    }
                    if (n6 <= 0) {
                        break;
                    }
                    n3 /= 2.0;
                    n2 /= 2.0;
                    n /= 2.0;
                    r2 = this.r;
                    this.r = r;
                    this.r = this.a(n, n2, n3, array[n4][0], array[n4][1], array[n4][2]);
                    if (x) {
                        break;
                    }
                }
                ++n4;
                continue Label_0150;
            }
            break;
        } while (!x);
    }
    
    private double a(final double n, final double n2, final double n3, final double n4, final double n5, final double n6) {
        final boolean x = N.x;
        this.d();
        final Iterator iterator = this.z.iterator();
        do {
            double hasNext = 0.0;
            Label_0020: {
                hasNext = (iterator.hasNext() ? 1 : 0);
            }
            Label_0027:
            while (hasNext != 0) {
                final cy[] array = iterator.next();
                final cr cr = this;
                if (!x) {
                    final int a = this.a(array);
                    int i = 0;
                    while (true) {
                        while (i <= a) {
                            final cy cy = array[i];
                            final double f = cy.f;
                            final double g = cy.g;
                            final double n7 = dcmpl(n, 1.0);
                            if (x) {
                                double n8 = n7;
                                while (n8 > a) {
                                    final cy cy2 = array[n8];
                                    final double k = cy2.k;
                                    final double l = cy2.l;
                                    final double n9 = hasNext = dcmpl(n2, 1.0);
                                    if (x) {
                                        continue Label_0027;
                                    }
                                    Label_0368: {
                                        if (n9 != 0 && k > cy2.i) {
                                            cy2.l = -Math.max(cy2.i + n5, k * n2);
                                            if (!x) {
                                                break Label_0368;
                                            }
                                        }
                                        cy2.l = -k;
                                    }
                                    Label_0420: {
                                        if (n2 != 1.0 && l < cy2.j) {
                                            cy2.k = -Math.max(cy2.j + n6, l * n3);
                                            if (!x) {
                                                break Label_0420;
                                            }
                                        }
                                        cy2.k = -l;
                                    }
                                    final double f2 = cy2.f;
                                    final double g2 = cy2.g;
                                    Label_0469: {
                                        if (n != 1.0 && f2 > n4) {
                                            cy2.f = g2 * n;
                                            if (!x) {
                                                break Label_0469;
                                            }
                                        }
                                        cy2.f = g2;
                                    }
                                    Label_0504: {
                                        if (n != 1.0 && g2 > n4) {
                                            cy2.g = f2 * n;
                                            if (!x) {
                                                break Label_0504;
                                            }
                                        }
                                        cy2.g = f2;
                                    }
                                    this.a(this.A, cy2);
                                    cy2.d = -cy2.d;
                                    cy2.f = f2;
                                    cy2.g = g2;
                                    cy2.k = k;
                                    cy2.l = l;
                                    --n8;
                                    if (x) {
                                        break;
                                    }
                                }
                                this.b(array);
                                continue Label_0020;
                            }
                            if (n7 != 0) {
                                if (f > n4) {
                                    cy.f = Math.max(n4, f * n);
                                }
                                if (g > n4) {
                                    cy.g = Math.max(n4, g * n);
                                }
                            }
                            final double j = cy.l;
                            final double m = cy.k;
                            if (n3 != 1.0 && j < cy.j) {
                                cy.l = Math.max(cy.j + n6, j * n3);
                            }
                            if (n != 1.0 && m > cy.i) {
                                cy.k = Math.max(cy.i + n5, m * n2);
                            }
                            this.a(this.B, cy);
                            cy.f = f;
                            cy.g = g;
                            cy.l = j;
                            cy.k = m;
                            ++i;
                            if (x) {
                                break;
                            }
                        }
                        final int n10 = array.length - 1;
                        continue;
                    }
                }
                return Math.max(cr.r, this.f(n));
            }
            break;
        } while (!x);
        final cr cr = this;
        return Math.max(cr.r, this.f(n));
    }
    
    public void j() {
        final boolean x = N.x;
        this.d();
        for (final cy[] array : this.z) {
            final int a = this.a(array);
            if (x) {
                return;
            }
            int i = 0;
        Label_0268:
            while (true) {
                int n = i;
                int n2 = a;
            Label_0055:
                while (true) {
                    while (true) {
                        Label_0087: {
                            if (n > n2) {
                                break Label_0087;
                            }
                            this.a(this.B, array[i]);
                            ++i;
                            if (!x) {
                                if (x) {
                                    break Label_0087;
                                }
                                break;
                            }
                            while (i > a) {
                                final cy cy = array[i];
                                final double k = cy.k;
                                final double l = cy.l;
                                final double f = cy.f;
                                final double g = cy.g;
                                cy.f = g;
                                cy.g = f;
                                cy.l = -k;
                                cy.k = -l;
                                final byte m = cy.m;
                                final int n3 = n = m;
                                final int n4 = n2 = 1;
                                if (x) {
                                    continue Label_0055;
                                }
                                Label_0204: {
                                    if (n3 == n4) {
                                        cy.m = 2;
                                        if (!x) {
                                            break Label_0204;
                                        }
                                    }
                                    if (m == 2) {
                                        cy.m = 1;
                                    }
                                }
                                this.a(this.A, cy);
                                cy.d = -cy.d;
                                cy.f = f;
                                cy.g = g;
                                cy.k = k;
                                cy.l = l;
                                cy.m = m;
                                --i;
                                if (x) {
                                    break;
                                }
                            }
                            break Label_0268;
                        }
                        i = array.length - 1;
                        continue;
                    }
                }
            }
            this.b(array);
            if (x) {
                break;
            }
        }
        this.r = Math.max(this.r, this.d(0.0));
    }
    
    private void b(final cy[] array) {
        final boolean x = N.x;
        cy cy = null;
        cy cy2 = null;
        int i = 0;
        while (true) {
            while (i < array.length) {
                final cy cy3 = array[i];
                final double d = cy3.d;
                final boolean naN = Double.isNaN(d);
                if (x) {
                    if (naN) {
                        if (cy2 == null) {
                            cy2 = new cy(null, 0.0, 0.0, 0.0, (byte)3, -1.7976931348623157E308, Double.MAX_VALUE, 0.0, 0.0, false, 0.0, 0.0, 0.0, null);
                            cy2.d = this.m.d();
                        }
                        int j = 0;
                        while (true) {
                            while (j < array.length) {
                                final cy cy4 = array[j];
                                final double n = dcmpl(cy4.d, Double.MAX_VALUE);
                                if (x) {
                                    double n2 = n;
                                    while (n2 >= 0) {
                                        final cy cy5 = array[n2];
                                        if (cy5.d == -1.7976931348623157E308) {
                                            cy5.d = Math.min(cy5.l, cy.d - Math.max(cy.f, cy5.g) - (cy.e + cy5.e));
                                            cy = cy5;
                                        }
                                        --n2;
                                        if (x) {
                                            break;
                                        }
                                    }
                                    return;
                                }
                                if (n == 0) {
                                    cy4.d = Math.max(cy4.k, cy2.d + Math.max(cy2.g, cy4.f) + cy2.e + cy4.e);
                                    cy2 = cy4;
                                }
                                ++j;
                                if (x) {
                                    break;
                                }
                            }
                            if (cy == null) {
                                cy = new cy(null, 0.0, 0.0, 0.0, (byte)3, -1.7976931348623157E308, Double.MAX_VALUE, 0.0, 0.0, false, 0.0, 0.0, 0.0, null);
                                cy.d = this.l.c();
                            }
                            final int n3 = array.length - 1;
                            continue;
                        }
                    }
                    return;
                }
                Label_0136: {
                    if (!naN) {
                        if (d < Double.MAX_VALUE && cy3.d > -1.7976931348623157E308) {
                            Label_0100: {
                                if (cy == null) {
                                    cy = cy3;
                                    if (!x) {
                                        break Label_0100;
                                    }
                                }
                                if (cy.d > cy3.d) {
                                    cy = cy3;
                                }
                            }
                            if (cy2 == null) {
                                cy2 = cy3;
                                if (!x) {
                                    break Label_0136;
                                }
                            }
                            if (cy2.d < cy3.d) {
                                cy2 = cy3;
                                if (x) {}
                            }
                        }
                    }
                }
                ++i;
                if (x) {
                    break;
                }
            }
            continue;
        }
    }
    
    public double a(final double n, final double n2, final double n3) {
        return this.a(this.B, n, n2, n3);
    }
    
    public double b(final double n, final double n2, final double n3) {
        return -this.a(this.A, n, n2, n3);
    }
    
    private double a(final D d, final double n, final double n2, final double n3) {
        final boolean x = N.x;
        cw cw = (cw)d.f();
        p p4 = d.k().a();
        double b = 0.0;
        while (p4 != null) {
            final cw cw2 = (cw)p4.c();
            b = cw2.b;
            if (x) {
                return b;
            }
            if (b > n) {
                double max = cw.c + Math.max(cw.e, n3);
                double b2 = 0.0;
                while (p4 != null) {
                    final cw cw3 = (cw)p4.c();
                    b2 = cw3.b;
                    if (x) {
                        return b2;
                    }
                    if (b2 >= n2) {
                        return max;
                    }
                    max = Math.max(max, cw3.c + Math.max(cw2.e, n3));
                    p4 = p4.a();
                    if (x) {
                        break;
                    }
                }
                return b2;
            }
            cw = cw2;
            p4 = p4.a();
            if (x) {
                break;
            }
        }
        return b;
    }
    
    public void e(final double n) {
        final boolean x = N.x;
        if (n == 0.0) {
            return;
        }
        if (this.l != null) {
            this.l.a(n);
        }
        final Iterator<cy[]> iterator = (Iterator<cy[]>)this.z.iterator();
    Label_0121:
        while (true) {
            iterator.hasNext();
            boolean naN = false;
        Label_0043:
            while (naN) {
                final cy[] array = iterator.next();
                int i = this.a(array) + 1;
                while (i < array.length) {
                    final cy cy = array[i];
                    naN = Double.isNaN(cy.d);
                    if (x) {
                        continue Label_0043;
                    }
                    if (!naN) {
                        final cy cy2 = cy;
                        cy2.d += n;
                    }
                    ++i;
                    if (x) {
                        break Label_0121;
                    }
                }
                continue Label_0121;
            }
            break;
        }
        p p = this.A.k();
        while (p != null) {
            final cw cw = (cw)p.c();
            cw.c -= n;
            p = p.a();
            if (x) {
                break;
            }
        }
    }
    
    private void l() {
        final boolean x = N.x;
        int n = this.i.size() - 1;
        do {
            int i = 0;
        Label_0018:
            while (i >= 0) {
                double b = Double.MAX_VALUE;
                double c = -1.7976931348623157E308;
                double k = -1.7976931348623157E308;
                double l = Double.MAX_VALUE;
                boolean b2 = true;
                boolean b3 = true;
                final D d = this.i.get(n);
                double n2 = 0.0;
                double n3 = 0.0;
                double max = 0.0;
                p p = d.k();
                while (p != null) {
                    final cy cy = (cy)p.c();
                    max = Math.max(max, cy.e);
                    i = (cy.n ? 1 : 0);
                    if (x) {
                        continue Label_0018;
                    }
                    Label_0265: {
                        if (i != 0) {
                            final double n4 = cy.o / cr.a;
                            if (cy.k > -1.7976931348623157E308) {
                                k = Math.max(k, cy.k + n4);
                            }
                            if (cy.l < Double.MAX_VALUE) {
                                l = Math.min(l, cy.l - n4);
                            }
                            n3 = Math.max(n3, cy.g + n4);
                            n2 = Math.max(n2, cy.f + n4);
                            if (!x) {
                                break Label_0265;
                            }
                        }
                        k = Math.max(k, cy.k);
                        l = Math.min(l, cy.l);
                        n3 = Math.max(n3, cy.g);
                        n2 = Math.max(n2, cy.f);
                    }
                    if (cy.b < b) {
                        b = cy.b;
                        final byte a = cy.a();
                        b2 = (a == 2 || a == 0);
                    }
                    if (cy.c > c) {
                        c = cy.c;
                        final byte a2 = cy.a();
                        b3 = (a2 == 1 || a2 == 0);
                    }
                    this.k.add(cy.a);
                    p = p.a();
                    if (x) {
                        break;
                    }
                }
                final cy a3 = cy.a(d, max * 2.0, b, b2, c, b3, n2, n3);
                a3.k = k;
                a3.l = l;
                this.b.put(d, a3);
                this.c.add(a3);
                --n;
            }
            break;
        } while (!x);
    }
    
    public double d(final Object o) {
        final double d = this.f(o).d;
        if (Double.isNaN(d)) {
            return this.n;
        }
        return d;
    }
    
    public double e(final Object o) {
        return this.d(this.h.get(o));
    }
    
    private void a(final D d, final cy cy) {
        if (this.o && Math.abs(cy.c - cy.b) + ((cy.m == 3 || cy.m == 0) ? (cy.e * 2.0) : 0.0) < this.q) {
            cy.d = Double.NaN;
            return;
        }
        if (cy.n) {
            this.c(d, cy);
            if (!N.x) {
                return;
            }
        }
        this.b(d, cy);
    }
    
    private void b(final D d, final cy cy) {
        final boolean x = N.x;
        final byte a = cy.a();
        final cw cw = new cw(cy.b, 0.0, cy.e, cy.g, a == 0 || a == 2);
        final cw cw2 = new cw(cy.c, 0.0, cy.e, cy.g, a == 1 || a == 0);
        p p2 = d.k();
        cw cw4;
        cw cw3 = cw4 = (cw)p2.c();
        double n = Math.max(cy.f, cw3.e);
        double n2 = Math.max(cw3.c + cw3.d + n, cy.k - cy.e);
        while (true) {
        Label_0396:
            while (true) {
            Label_0518_Outer:
                while (cy.b - cy.e - n > cw3.b + cw3.d) {
                    cw4 = cw3;
                    p2 = p2.a();
                    cw3 = (cw)p2.c();
                    n = Math.max(cy.f, cw3.e);
                    if (x) {
                        final p a2 = d.a(cw, p2);
                        while (true) {
                            while (cy.c >= cw3.b) {
                                cw4 = cw3;
                                n2 = Math.max(cw3.c + cw3.d + Math.max(cw3.e, cy.f), n2);
                                d.h(p2);
                                final p a3;
                                p2 = (a3 = p2.a());
                                if (x) {
                                    double n3 = 0.0;
                                    double n4 = 0.0;
                                    Label_0832: {
                                        while (true) {
                                            if (a3 != null) {
                                                n3 = cy.c + cy.e + n;
                                                n4 = cw3.b - cw3.d;
                                                if (x) {
                                                    break Label_0832;
                                                }
                                                if (n3 > n4) {
                                                    if (cw2.a != cw3.a) {
                                                        n2 = Math.max(cw3.c + cw3.d + n, n2);
                                                    }
                                                    p2 = p2.a();
                                                    if (p2 != null) {
                                                        cw3 = (cw)p2.c();
                                                        n = Math.max(cy.f, cw3.e);
                                                        if (!x) {
                                                            continue Label_0518_Outer;
                                                        }
                                                    }
                                                }
                                            }
                                            break;
                                        }
                                        if (a2.b() != null) {
                                            final cw cw5 = (cw)a2.b().c();
                                            if (cw5.b + this.p > cy.b && cw5.a != cw.a && a2.b().b() != null) {
                                                final cw cw6 = (cw)a2.b().b().c();
                                                n2 = Math.max(n2, cw6.c + cw6.d + Math.max(cw6.e, cy.f));
                                            }
                                        }
                                        if (a2.a() != null) {
                                            final cw cw7 = (cw)a2.a().c();
                                            if (cw7.b - this.p < cy.c && cw7.a != cw2.a) {
                                                n2 = Math.max(n2, cw7.c + cw7.d + Math.max(cw7.e, cy.f));
                                            }
                                        }
                                        final double e = cy.e;
                                    }
                                    final double d2 = n3 + n4;
                                    a2.a(new cw(cy.b, d2, cy.e, cy.g, cy.m == 2 || cy.m == 0));
                                    d.b(new cw(cy.c, cw4.c, cw4.d, cw4.e, cy.m == 0 || cy.m == 1), a2);
                                    cy.d = d2;
                                    this.r = Math.max(this.r, d2 - cy.l);
                                    this.d = Math.max(this.d, d2);
                                    return;
                                }
                                if (a3 == null) {
                                    break;
                                }
                                cw3 = (cw)p2.c();
                                if (x) {
                                    break;
                                }
                            }
                            n = Math.max(cy.f, cw3.e);
                            continue;
                        }
                    }
                    if (x) {
                        break;
                    }
                }
                while (p2 != null) {
                    final double b = cy.b;
                    final double b2 = cw3.b;
                    if (x) {
                        n2 = Math.max(b, b2);
                        continue Label_0396;
                    }
                    if (b <= b2) {
                        break;
                    }
                    if (cw.a != cw3.a) {
                        if (p2.b() != null) {
                            final cw cw8 = (cw)p2.b().c();
                            n2 = Math.max(n2, cw8.c + cw8.d + Math.max(cy.f, cw8.e));
                        }
                        n2 = Math.max(n2, cw3.c + cw3.d + Math.max(cw3.e, cy.f));
                    }
                    cw4 = cw3;
                    p2 = p2.a();
                    cw3 = (cw)p2.c();
                    if (x) {
                        break;
                    }
                }
                break;
            }
            final double n5 = cw4.c + cw4.d + Math.max(cw4.e, cy.f);
            continue;
        }
    }
    
    private void c(final D d, final cy cy) {
        final boolean x = N.x;
        final byte a = cy.a();
        double n = 0.0;
        Label_0054: {
            if (a == 1) {
                n = this.e(d, cy);
                if (!x) {
                    break Label_0054;
                }
            }
            if (a == 2) {
                n = this.f(d, cy);
                if (!x) {
                    break Label_0054;
                }
            }
            n = this.d(d, cy);
        }
        this.r = Math.max(this.r, n - cy.l);
        this.d = Math.max(this.d, this.d);
    }
    
    private static double a(final cw cw, final double n, final cy cy) {
        return Math.max(cy.k, cw.c + cw.d + Math.max(cw.e, cy.f) + cy.e + (n - cw.b) * cw.f);
    }
    
    private static double a(final cw cw, final cy cy) {
        return Math.max(cy.k, cw.c + cw.d + Math.max(cw.e, cy.f) + cy.e);
    }
    
    private double d(final D d, final cy cy) {
        final boolean x = N.x;
        p p2 = d.k();
        cw cw2;
        cw cw = cw2 = (cw)p2.c();
        while (cy.b - cy.e - Math.max(cy.f, cw.e) > cw.b + cw.d) {
            cw2 = cw;
            p2 = p2.a();
            if (p2 != null) {
                cw = (cw)p2.c();
                if (x) {
                    break;
                }
                continue;
            }
        }
        double n = cy.k;
        while (p2 != null && cy.b > cw.b) {
            if (!cw.a) {
                if (cw2 != null) {
                    n = Math.max(n, a(cw2, cy));
                }
                n = Math.max(n, a(cw, cy));
            }
            cw2 = cw;
            p2 = p2.a();
            if (p2 != null) {
                cw = (cw)p2.c();
                if (x) {
                    break;
                }
                continue;
            }
        }
        double n2 = cy.o / cr.a;
        final double n3 = cy.c - cy.b;
        if (n3 <= n2 * 3.0) {
            n2 = n3 * 0.35;
        }
        final double b = cy.b;
        final double c = cy.c;
        final double p3 = b + n2;
        final double q = c - n2;
        final double n4 = (p3 - b) * 1.0;
        double max = Math.max(n, a(cw2, b, cy));
        while (true) {
        Label_0532_Outer:
            while (p2 != null && cw.b < p3) {
                final double b2 = cw.b;
                final double n5 = a(cw2, b2, cy);
                final double max2 = Math.max(n5, a(cw, cy));
                if (max2 > max + (cw.b - b) * 1.0) {
                    max = max2 - (b2 - b) * 1.0;
                }
                cw2 = cw;
                p2 = p2.a();
                if (p2 != null) {
                    cw = (cw)p2.c();
                    if (x) {
                        if (n5 > b2) {
                            max = n5 - n4;
                        }
                        double d2 = max + n4;
                        while (true) {
                            while (p2 != null && cw.b < q) {
                                final double n6 = cw.b;
                                final double max3 = Math.max(a(cw2, n6, cy), a(cw, cy));
                                if (max3 > d2) {
                                    d2 = max3;
                                    max = d2 - n4;
                                }
                                cw2 = cw;
                                p2 = p2.a();
                                if (p2 != null) {
                                    cw = (cw)p2.c();
                                    if (x) {
                                        if (n6 > d2) {
                                            d2 = n6;
                                            max = d2 - n4;
                                        }
                                        double n7 = d2;
                                        while (true) {
                                            while (p2 != null && cw.b < c) {
                                                final double b3 = cw.b;
                                                final double n8 = a(cw2, b3, cy);
                                                final double max4 = Math.max(n8, a(cw, cy));
                                                if (max4 > n7 + (b3 - q) * -1.0) {
                                                    n7 = (d2 = max4 - (b3 - q) * -1.0);
                                                    max = d2 - n4;
                                                }
                                                cw2 = cw;
                                                p2 = p2.a();
                                                if (p2 != null) {
                                                    cw = (cw)p2.c();
                                                    if (x) {
                                                        if (n8 > b3) {
                                                            n7 = (d2 = n8 - (c - q) * -1.0);
                                                            max = d2 - n4;
                                                        }
                                                        while (p2 != null && cy.c + cy.e + Math.max(cy.f, cw.e) > cw.b - cw.d) {
                                                            final double b4 = cw.b;
                                                            if (!cw.a) {
                                                                final double a = a(cw, cy);
                                                                if (a > n7 + (b4 - q) * -1.0) {
                                                                    n7 = (d2 = a - (b4 - q) * -1.0);
                                                                    max = d2 - n4;
                                                                }
                                                            }
                                                            p2 = p2.a();
                                                            if (p2 != null) {
                                                                cw = (cw)p2.c();
                                                                if (x) {
                                                                    break;
                                                                }
                                                                continue Label_0532_Outer;
                                                            }
                                                        }
                                                        final D d3 = new D();
                                                        d3.add(new cw(b, max, 1.0, cy.e, cy.g, true));
                                                        d3.add(new cw(p3, d2, 0.0, cy.e, cy.g, true));
                                                        d3.add(new cw(q, n7, -1.0, cy.e, cy.g, true));
                                                        d3.add(new cw(c, -1.7976931348623157E308, 0.0, 0.0, 0.0, true));
                                                        a(d, d3);
                                                        this.a(d);
                                                        cy.p = p3;
                                                        cy.q = q;
                                                        cy.d = d2;
                                                        return d2 + cy.e;
                                                    }
                                                    if (x) {
                                                        break;
                                                    }
                                                    continue Label_0532_Outer;
                                                }
                                            }
                                            final double b3 = n7 + (c - q) * -1.0;
                                            final double n8 = a(cw2, c, cy);
                                            continue;
                                        }
                                    }
                                    if (x) {
                                        break;
                                    }
                                    continue Label_0532_Outer;
                                }
                            }
                            final double n6 = a(cw2, q, cy);
                            continue;
                        }
                    }
                    if (x) {
                        break;
                    }
                    continue;
                }
            }
            final double b2 = max + n4;
            final double n5 = a(cw2, p3, cy);
            continue;
        }
    }
    
    private double e(final D d, final cy cy) {
        final boolean x = N.x;
        p p2 = d.k();
        cw cw2;
        cw cw = cw2 = (cw)p2.c();
        while (cy.b - cy.e - Math.max(cy.f, cw.e) > cw.b + cw.d) {
            cw2 = cw;
            p2 = p2.a();
            if (p2 != null) {
                cw = (cw)p2.c();
                if (x) {
                    break;
                }
                continue;
            }
        }
        double n = cy.k;
        while (p2 != null && cy.b > cw.b) {
            if (cw.a) {
                if (cw2.a && cw2 != cw) {
                    n = Math.max(n, a(cw2, cy));
                }
                n = Math.max(n, a(cw, cy));
            }
            cw2 = cw;
            p2 = p2.a();
            if (p2 != null) {
                cw = (cw)p2.c();
                if (x) {
                    break;
                }
                continue;
            }
        }
        final double n2 = cy.o / cr.a;
        final double b = cy.b;
        double n3 = Math.max(n, a(cw2, b, cy));
        final double n4 = b + n2;
        int n5 = 0;
        final double n6 = b;
        double n7 = n3;
        double n8 = cy.k;
        while (true) {
        Label_0628_Outer:
            while (p2 != null && cy.c >= cw.b) {
                final double n9 = cw.b;
                final double max = Math.max(a(cw2, n9, cy), a(cw, cy));
                if (n5 == 0 && cw.b >= n4) {
                    n3 = Math.max(n3, a(cw2, n4, cy) + n2);
                    n5 = 1;
                }
                Label_0384: {
                    if (max > n7 - (n9 - n6)) {
                        n7 = max + (n9 - n6);
                        if (n5 == 0) {
                            n3 = n7;
                            if (!x) {
                                break Label_0384;
                            }
                        }
                        n8 = Math.max(n8, max);
                    }
                }
                cw2 = cw;
                p2 = p2.a();
                if (p2 != null) {
                    cw = (cw)p2.c();
                    if (x) {
                        while (true) {
                            while (p2 != null && cy.c + cy.e + Math.max(cy.f, cw.e) > cw.b - cw.d + 0.001) {
                                final double b2 = cw.b;
                                if (n5 == 0 && b2 >= n4) {
                                    n3 = Math.max(n3, a(cw2, n4, cy) + n2);
                                    n5 = 1;
                                }
                                Label_0585: {
                                    if (!cw.a) {
                                        final double a = a(cw, cy);
                                        if (a > n7 - (b2 - n6)) {
                                            n7 = a + (b2 - n6);
                                            if (n5 == 0) {
                                                n3 = n7;
                                                if (!x) {
                                                    break Label_0585;
                                                }
                                            }
                                            n8 = Math.max(n8, a);
                                        }
                                    }
                                }
                                cw2 = cw;
                                p2 = p2.a();
                                if (p2 != null) {
                                    cw = (cw)p2.c();
                                    if (x) {
                                        final double max2 = Math.max(n7 - b2, n9);
                                        final D d2 = new D();
                                        Label_1033: {
                                            if (b2 <= n2 * 3.0) {
                                                d2.add(new cw(cy.b, max2 + b2, -1.0, cy.e, cy.g, false));
                                                cy.d = max2 + b2 * 0.5;
                                                cy.p = cy.b + b2 * 0.5;
                                                cy.q = cy.p;
                                                if (!x) {
                                                    break Label_1033;
                                                }
                                            }
                                            if (n5 == 0) {
                                                n8 = Math.max(max2 + n2, a(cw2, n4, cy));
                                            }
                                            final double max3 = Math.max(max2 + n2, n8);
                                            final double q = cy.c - (max3 - max2);
                                            final double d3 = max3;
                                            final double n10 = n3 - d3;
                                            double p3 = 0.0;
                                            Label_0844: {
                                                if (n10 >= n2) {
                                                    p3 = b + n10;
                                                    if (!x) {
                                                        break Label_0844;
                                                    }
                                                }
                                                p3 = b + n2;
                                                n3 = d3 + n2;
                                            }
                                            if (q - p3 < n2) {
                                                d2.add(new cw(cy.b, max2 + b2, -1.0, cy.e, cy.g, false));
                                                cy.d = max2 + b2 * 0.5;
                                                cy.p = cy.b + b2 * 0.5;
                                                cy.q = cy.p;
                                                if (!x) {
                                                    break Label_1033;
                                                }
                                            }
                                            d2.add(new cw(b, n3, -1.0, cy.e, cy.g, false));
                                            d2.add(new cw(p3, d3, 0.0, cy.e, cy.g, true));
                                            d2.add(new cw(q, max3, -1.0, cy.e, cy.g, true));
                                            cy.d = d3;
                                            cy.p = p3;
                                            cy.q = q;
                                        }
                                        d2.add(new cw(cy.c, -1.7976931348623157E308, 0.0, 0.0, 0.0, true));
                                        a(d, d2);
                                        this.a(d);
                                        return cy.d + cy.p - cy.b + cy.e;
                                    }
                                    if (x) {
                                        break;
                                    }
                                    continue Label_0628_Outer;
                                }
                            }
                            final double b2 = cy.c - cy.b;
                            continue;
                        }
                    }
                    if (x) {
                        break;
                    }
                    continue;
                }
            }
            final double n9 = a(cw2, cy.c, cy);
            continue;
        }
    }
    
    private double f(final D d, final cy cy) {
        final boolean x = N.x;
        p p2 = d.l();
        cw cw2;
        cw cw = cw2 = (cw)p2.c();
        while (cy.c + cy.e + Math.max(cy.f, cw.e) < cw.b + cw.d) {
            cw2 = cw;
            p2 = p2.b();
            if (p2 != null) {
                cw = (cw)p2.c();
                if (x) {
                    break;
                }
                continue;
            }
        }
        double n = cy.k;
        while (p2 != null && cy.c < cw.b) {
            if (cw.a) {
                if (cw2.a && cw2 != cw) {
                    n = Math.max(n, a(cw2, cy));
                }
                n = Math.max(n, a(cw, cy));
            }
            cw2 = cw;
            p2 = p2.b();
            if (p2 != null) {
                cw = (cw)p2.c();
                if (x) {
                    break;
                }
                continue;
            }
        }
        final double n2 = cy.o / cr.a;
        final double c = cy.c;
        double n3 = Math.max(n, a(cw, c, cy));
        final double n4 = c - n2;
        int n5 = 0;
        final double b = cy.b;
        final double n6 = c;
        double n7 = n3;
        double n8 = cy.k;
        while (true) {
        Label_0637_Outer:
            while (p2 != null && cy.b <= cw2.b) {
                final double n9 = cw2.b;
                final double max = Math.max(a(cw2, cy), a(cw, n9, cy));
                Label_0349: {
                    if (max > n7 - (n6 - n9)) {
                        n7 = max + (n6 - n9);
                        if (n5 == 0) {
                            n3 = n7;
                            if (!x) {
                                break Label_0349;
                            }
                        }
                        n8 = Math.max(n8, max);
                    }
                }
                if (n5 == 0 && cw.b < n4) {
                    n3 = Math.max(n3, a(cw, n4, cy) + n2);
                    n5 = 1;
                }
                cw2 = cw;
                p2 = p2.b();
                if (p2 != null) {
                    cw = (cw)p2.c();
                    if (x) {
                        while (true) {
                            while (p2 != null && cy.c - cy.e - Math.max(cy.f, cw.e) < cw2.b + cw2.d - 0.001) {
                                final double b2 = cw2.b;
                                Label_0553: {
                                    if (!cw.a) {
                                        final double a = a(cw2, cy);
                                        if (a > n7 - (n6 - b2)) {
                                            n7 = a + (n6 - b2);
                                            if (n5 == 0) {
                                                n3 = n7;
                                                if (!x) {
                                                    break Label_0553;
                                                }
                                            }
                                            n8 = Math.max(n8, a);
                                        }
                                    }
                                }
                                if (n5 == 0 && cw.b < n4) {
                                    n3 = Math.max(n3, a(cw, n4, cy) + n2);
                                    n5 = 1;
                                }
                                cw2 = cw;
                                p2 = p2.b();
                                if (p2 != null) {
                                    cw = (cw)p2.c();
                                    if (x) {
                                        final double max2 = Math.max(n7 - b2, n9);
                                        final D d2 = new D();
                                        Label_1018: {
                                            if (b2 <= n2 * 3.0) {
                                                d2.add(new cw(b, max2, 1.0, cy.e, cy.g, true));
                                                cy.d = max2 + b2 * 0.5;
                                                cy.p = b + b2 * 0.5;
                                                cy.q = cy.p;
                                                if (!x) {
                                                    break Label_1018;
                                                }
                                            }
                                            if (n5 == 0) {
                                                n8 = Math.max(n3 + n2, a(cw2, n4, cy));
                                            }
                                            final double max3 = Math.max(max2 + n2, n8);
                                            final double p3 = b + (max3 - max2);
                                            final double n10 = max3;
                                            final double n11 = n3 - n10;
                                            double q = 0.0;
                                            Label_0842: {
                                                if (n11 >= n2) {
                                                    q = c - n11;
                                                    if (!x) {
                                                        break Label_0842;
                                                    }
                                                }
                                                q = c - n2;
                                            }
                                            if (q - p3 < n2) {
                                                d2.add(new cw(b, max2, 1.0, cy.e, cy.g, true));
                                                cy.d = max2 + b2 * 0.5;
                                                cy.p = b + b2 * 0.5;
                                                cy.q = cy.p;
                                                if (!x) {
                                                    break Label_1018;
                                                }
                                            }
                                            d2.add(new cw(b, max2, 1.0, cy.e, cy.g, true));
                                            d2.add(new cw(p3, max3, 0.0, cy.e, cy.g, true));
                                            d2.add(new cw(q, n10, 1.0, cy.e, cy.g, true));
                                            cy.d = max3;
                                            cy.p = p3;
                                            cy.q = q;
                                        }
                                        d2.add(new cw(cy.c, -1.7976931348623157E308, 0.0, 0.0, 0.0, false));
                                        a(d, d2);
                                        this.a(d);
                                        return cy.d + cy.c - cy.q + cy.e;
                                    }
                                    if (x) {
                                        break;
                                    }
                                    continue Label_0637_Outer;
                                }
                            }
                            final double b2 = cy.c - cy.b;
                            continue;
                        }
                    }
                    if (x) {
                        break;
                    }
                    continue;
                }
            }
            final double n9 = a(cw2, cy.b, cy);
            continue;
        }
    }
    
    private static void a(final D d, final D d2) {
        final boolean x = N.x;
        if (d.isEmpty()) {
            d.a(d2);
            if (!x) {
                return;
            }
        }
        if (!d2.isEmpty()) {
            p p2 = d.k();
            p k = d2.k();
            cw cw = null;
            p p3 = null;
            Label_0083: {
                while (p2 != null) {
                    p3 = p2;
                    if (x || a(p3) >= a(k)) {
                        break Label_0083;
                    }
                    cw = (cw)p2.c();
                    p2 = p2.a();
                    if (x) {
                        goto Label_0082;
                    }
                }
                goto Label_0082;
            }
            if (p3 == null) {
                d.a(d2);
                return;
            }
            final p l = d2.l();
            while (k != null) {
                final p a = k.a();
                d.a(k, p2);
                k = a;
                if (x) {
                    return;
                }
                if (x) {
                    break;
                }
            }
            final cw cw2 = (cw)l.c();
            while (true) {
                while (p2 != null) {
                    final double n = dcmpg(a(p2), cw2.b);
                    if (x) {
                        if (n == 0) {
                            d.h(l);
                            if (!x) {
                                return;
                            }
                        }
                        l.a(new cw(cw2.b, cw.c + (cw2.b - cw.b) * cw.f, cw.f, cw.d, cw.e, cw2.a));
                        return;
                    }
                    if (n >= 0) {
                        break;
                    }
                    cw = (cw)d.h(p2);
                    p2 = p2.a();
                    if (x) {
                        break;
                    }
                }
                if (cw != null) {
                    if (p2 != null) {
                        final double n2 = dcmpl(a(p2), cw2.b);
                        continue;
                    }
                }
                break;
            }
        }
    }
    
    private static double a(final p p) {
        return ((cw)p.c()).b;
    }
    
    private void a(final D d) {
        final boolean x = N.x;
        double b = -1.7976931348623157E308;
        p p = d.k();
        while (p != null) {
            if (p.c() == null) {
                throw new IllegalStateException("Cell.getInfo = null: " + p);
            }
            final cw cw = (cw)p.c();
            if (cw.b < b) {
                throw new IllegalStateException("Wrong sorting of frontier!");
            }
            b = cw.b;
            p = p.a();
            if (x) {
                break;
            }
        }
    }
    
    private cy f(final Object o) {
        final cy cy = this.b.get(o);
        if (cy != null) {
            return cy;
        }
        final Object value = this.j.get(o);
        if (value != null) {
            return (cy)this.b.get(value);
        }
        throw new IllegalArgumentException("No such key registered!");
    }
    
    public void a(final boolean o) {
        this.o = o;
    }
    
    static {
        a = Math.sqrt(2.0);
    }
}
