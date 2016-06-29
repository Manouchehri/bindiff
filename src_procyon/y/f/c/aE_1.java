package y.f.c;

import java.util.*;
import y.d.*;
import y.c.*;
import y.f.*;

class aE
{
    private X a;
    private A b;
    private boolean c;
    private static Comparator d;
    private static Comparator e;
    private A f;
    private A g;
    private c h;
    private boolean i;
    
    public aE(final X a, final A f, final A g, final c h) {
        this.i = false;
        this.a = a;
        this.f = f;
        this.g = g;
        this.h = h;
        this.i = true;
    }
    
    public void a(final boolean c) {
        this.c = c;
    }
    
    public boolean a() {
        return this.c;
    }
    
    public y[] a(final y[] array) {
        final boolean i = y.f.c.a.i;
        if (!this.e()) {
            return array;
        }
        final A a = K.a((i)this.a);
        final int[] array2 = new int[this.a.f()];
        int j = 0;
    Label_0101_Outer:
        while (j < array.length) {
            int n = 0;
            final x a2 = array[j].a();
            while (true) {
                while (a2.f()) {
                    array2[a2.e().d()] = n;
                    a2.g();
                    ++n;
                    if (!i) {
                        if (i) {
                            break;
                        }
                        continue Label_0101_Outer;
                    }
                    else {
                        if (i) {
                            break Label_0101_Outer;
                        }
                        continue Label_0101_Outer;
                    }
                }
                ++j;
                continue;
            }
        }
        this.a.a(new aH(array2, (byte)1), new aH(array2, (byte)0));
        final D d = new D();
        final Object[] array3 = new Object[array.length];
        final ArrayList<Object> list = new ArrayList<Object>(array.length * 2);
        int k = 0;
        while (true) {
        Label_0896_Outer:
            while (k < array.length) {
                list.add(array3[k] = K.a(array[k], a));
                ++k;
                if (i) {
                    while (true) {
                        while (k < array.length) {
                            final y y = array[k];
                            final Integer n2 = new Integer(d.size());
                            final Integer n3 = new Integer(d.size() + 1);
                            d.add(y);
                            final c c = this.a.c(U.a);
                            final int l = this.i ? 1 : 0;
                            if (i) {
                                final q[] array4 = new q[l];
                                this.b = this.a.t();
                                final e p = this.a.p();
                                while (true) {
                                    do {
                                        Label_0921: {
                                            p.f();
                                        }
                                        byte a3 = 0;
                                        Label_0928:
                                        while (a3 != 0) {
                                            final d a4 = p.a();
                                            final aE ae = this;
                                            if (!i) {
                                                this.g.b(a4.c());
                                                Object value = null;
                                                Label_0959:
                                                while (value == null && this.g.b(a4.d()) != null) {
                                                    final d d2 = (d)this.g.b(a4.d());
                                                    final S[] a5 = this.a(d2);
                                                    if (a5 != null && a5.length > 0) {
                                                        int n4 = 0;
                                                        d f = a4;
                                                        while (this.g.b(f.d()) != null) {
                                                            final q d3 = f.d();
                                                            final Object o = value = list.get(this.f.a(d3));
                                                            if (i) {
                                                                continue Label_0959;
                                                            }
                                                            if (value == K.s || o == K.q || o == K.p) {
                                                                array4[n4++] = d3;
                                                            }
                                                            f = d3.f();
                                                            if (i) {
                                                                break;
                                                            }
                                                        }
                                                        int n5 = 0;
                                                        while (n5 < a5.length) {
                                                            a3 = a(a5[n5].f());
                                                            if (i) {
                                                                continue Label_0928;
                                                            }
                                                            q q = null;
                                                            Label_1268: {
                                                                Label_1216: {
                                                                    Label_1230: {
                                                                        switch (a3) {
                                                                            case 1: {
                                                                                q = array4[this.h.d(d2) ? (n4 - 1) : 0];
                                                                                if (i) {
                                                                                    break Label_1216;
                                                                                }
                                                                                break Label_1268;
                                                                            }
                                                                            case 0:
                                                                            case 4: {
                                                                                q = array4[n4 / 2];
                                                                                if (i) {
                                                                                    break Label_1230;
                                                                                }
                                                                                break Label_1268;
                                                                            }
                                                                            case 2: {
                                                                                q = array4[this.h.d(d2) ? 0 : (n4 - 1)];
                                                                                if (i) {
                                                                                    break;
                                                                                }
                                                                                break Label_1268;
                                                                            }
                                                                        }
                                                                    }
                                                                }
                                                                q = array4[0];
                                                            }
                                                            this.a(q, a5[n5]);
                                                            ++n5;
                                                            if (i) {
                                                                break;
                                                            }
                                                        }
                                                        break;
                                                    }
                                                    break;
                                                }
                                                p.g();
                                                continue Label_0921;
                                            }
                                            ae.d();
                                            return (y[])d.toArray(new y[d.size()]);
                                        }
                                        break;
                                    } while (!i);
                                    final aE ae = this;
                                    continue;
                                }
                            }
                            boolean b = l == 0;
                            p p2 = y.k();
                            while (true) {
                            Label_0328:
                                while (true) {
                                    Label_0546: {
                                        final boolean b2;
                                        Label_0535: {
                                            if (p2 != null) {
                                                b2 = b;
                                                if (i) {
                                                    break Label_0535;
                                                }
                                                if (!b2) {
                                                    p2.c();
                                                    break Label_0328;
                                                }
                                            }
                                            while (true) {
                                                while (p2 != null) {
                                                    this.f.a(p2.c(), n2);
                                                    p2 = p2.a();
                                                    if (i) {
                                                        break Label_0546;
                                                    }
                                                    if (i) {
                                                        break;
                                                    }
                                                }
                                                final boolean m = this.i;
                                                break Label_0535;
                                                final Object b3;
                                                final q q2 = (q)b3;
                                                this.f.a(q2, n2);
                                                if (this.g.b(q2) == null) {
                                                    d d4 = q2.f();
                                                    while (d4 != null) {
                                                        final boolean b4 = b;
                                                        if (i) {
                                                            break Label_0535;
                                                        }
                                                        if (b4) {
                                                            break;
                                                        }
                                                        final d d5 = (d)this.g.b(d4.d());
                                                        S[] array5 = null;
                                                        Label_0439: {
                                                            if (d5 == null) {
                                                                array5 = (S[])c.b(d4);
                                                                if (!i) {
                                                                    break Label_0439;
                                                                }
                                                            }
                                                            array5 = (S[])c.b(d5);
                                                        }
                                                        if (array5 != null && array5.length > 0 && !this.a(d4, list)) {
                                                            b = true;
                                                            if (!i) {
                                                                break;
                                                            }
                                                        }
                                                        d4 = d4.g();
                                                        if (i) {
                                                            break;
                                                        }
                                                    }
                                                }
                                                p2 = p2.a();
                                                if (i) {
                                                    continue;
                                                }
                                                break;
                                            }
                                            continue Label_0896_Outer;
                                        }
                                        if (b2 && !b) {
                                            break;
                                        }
                                    }
                                    if (k < array.length - 1) {
                                        final y y2 = new y();
                                        d.add(y2);
                                        list.add(d.size() - 1, K.s);
                                        final x a6 = y.a();
                                        while (a6.f()) {
                                            final q e = a6.e();
                                            int c2 = e.c();
                                            final e l2;
                                            final e e2 = l2 = e.l();
                                            if (i) {
                                                continue Label_0328;
                                            }
                                            final e e3 = e2;
                                            while (c2 > 0) {
                                                final d a7 = e3.a();
                                                final q d6 = a7.d();
                                                final q d7 = this.a.d();
                                                a.a(d7, K.s);
                                                this.a.b(d7, 1.0, 1.0);
                                                final d a8 = this.a.a(e, d7);
                                                final d a9 = this.a.a(d7, d6);
                                                this.a.b((Object)a8).setSourcePoint(this.a.b((Object)a7).getSourcePoint());
                                                this.a.b((Object)a9).setTargetPoint(this.a.b((Object)a7).getTargetPoint());
                                                final Object b3;
                                                Object b5 = b3 = this.g.b(e);
                                                if (i) {
                                                    continue Label_0328;
                                                }
                                                if (b3 == null) {
                                                    b5 = this.g.b(d6);
                                                }
                                                if (b5 == null) {
                                                    b5 = a7;
                                                }
                                                this.g.a(d7, b5);
                                                y2.add(d7);
                                                this.f.a(d7, n3);
                                                this.a.d(a7);
                                                e3.g();
                                                --c2;
                                                if (i) {
                                                    break;
                                                }
                                            }
                                            a6.g();
                                            if (i) {
                                                break;
                                            }
                                        }
                                        break;
                                    }
                                    break;
                                }
                                break;
                            }
                            ++k;
                            if (i) {
                                break;
                            }
                        }
                        d.size();
                        continue;
                    }
                }
                if (i) {
                    break;
                }
            }
            k = 0;
            continue;
        }
    }
    
    private void a(final q q, final S s) {
        D d = (D)this.b.b(q);
        if (d == null) {
            d = new D();
            this.b.a(q, d);
        }
        d.add(s);
    }
    
    private void d() {
        final boolean i = y.f.c.a.i;
        final ArrayList<Object> list = new ArrayList<Object>(5);
        final ArrayList<Object> list2 = new ArrayList<Object>(5);
        final ArrayList<Object> list3 = new ArrayList<Object>(5);
        final x o = this.a.o();
    Label_0856:
        do {
            boolean f = o.f();
        Label_0048:
            while (f) {
                final q e = o.e();
                final D d = (D)this.b.b(e);
                if (d != null) {
                    final S[] array = (S[])d.toArray(new S[d.size()]);
                    final d d2 = (d)this.g.b(e);
                    if (d2 == null) {
                        throw new IllegalStateException("realEdge == null: Can't be!!!");
                    }
                    double max = 0.0;
                    double max2 = 0.0;
                    double max3 = 0.0;
                    int n = 0;
                    do {
                        int j = 0;
                        Label_0142: {
                            j = n;
                        }
                        int length = array.length;
                        while (j < length) {
                            final S s = array[n];
                            final byte b = s.f().b();
                            final int n2 = j = b;
                            final int n3 = length = 16;
                            if (!i) {
                                Label_0232: {
                                    if (n2 == n3) {
                                        max = Math.max(max, s.b());
                                        if (!i) {
                                            break Label_0232;
                                        }
                                    }
                                    if (b == 32) {
                                        max2 = Math.max(max2, s.b());
                                        if (!i) {
                                            break Label_0232;
                                        }
                                    }
                                    max3 = Math.max(max3, s.b());
                                }
                                ++n;
                                continue Label_0142;
                            }
                        }
                        break;
                    } while (!i);
                    if (max3 > max * 2.0) {
                        max = max3 / 2.0;
                    }
                    if (max3 > max2 * 2.0) {
                        max2 = max3 / 2.0;
                    }
                    final byte[] array2 = { 1, 4, 0, 2 };
                    double max4 = 0.0;
                    int n4 = 0;
                Label_0674:
                    do {
                        int k = n4;
                        int length2 = array2.length;
                    Label_0312:
                        while (k < length2) {
                            list.clear();
                            list2.clear();
                            list3.clear();
                            final int n5 = (f = false) ? 1 : 0;
                            if (!i) {
                                int l = n5;
                                while (l < array.length) {
                                    final S s2 = array[l];
                                    final aG f2 = s2.f();
                                    final byte b2 = (byte)(k = a(f2));
                                    final byte b3 = (byte)(length2 = array2[n4]);
                                    if (i) {
                                        continue Label_0312;
                                    }
                                    Label_0453: {
                                        if (b2 == b3) {
                                            Label_0430: {
                                                switch (f2.b()) {
                                                    case 16: {
                                                        list.add(s2);
                                                        if (i) {
                                                            break Label_0430;
                                                        }
                                                        break Label_0453;
                                                    }
                                                    case 32: {
                                                        list2.add(s2);
                                                        if (i) {
                                                            break;
                                                        }
                                                        break Label_0453;
                                                    }
                                                }
                                            }
                                            list3.add(s2);
                                        }
                                    }
                                    ++l;
                                    if (i) {
                                        break;
                                    }
                                }
                                double n6 = max4;
                                double n7 = max4;
                                int n8 = 0;
                                while (true) {
                                    while (n8 < list.size()) {
                                        final S s3 = list.get(n8);
                                        s3.a(max2, n6);
                                        n6 += s3.c();
                                        ++n8;
                                        if (i) {
                                            while (true) {
                                                while (n8 < list2.size()) {
                                                    final S s4 = list2.get(n8);
                                                    s4.a(max2 - s4.b(), n7);
                                                    n7 += s4.c();
                                                    ++n8;
                                                    if (i) {
                                                        int n9 = 0;
                                                        while (n9 < list3.size()) {
                                                            final S s5 = list3.get(n9);
                                                            s5.a(max2 - s5.b() / 2.0, max4);
                                                            max4 += s5.c();
                                                            ++n9;
                                                            if (i) {
                                                                continue Label_0674;
                                                            }
                                                            if (i) {
                                                                break;
                                                            }
                                                        }
                                                        ++n4;
                                                        continue Label_0674;
                                                    }
                                                    if (i) {
                                                        break;
                                                    }
                                                }
                                                max4 = Math.max(n6, n7);
                                                continue;
                                            }
                                        }
                                        if (i) {
                                            break;
                                        }
                                    }
                                    n8 = 0;
                                    continue;
                                }
                            }
                            continue Label_0048;
                        }
                        break;
                    } while (!i);
                    this.a.b(e, max + max2, max4);
                    this.a.b(e.g(), new t(-(max + max2) / 2.0 + max2, -max4 / 2.0));
                    this.a.a(e.f(), new t(-(max + max2) / 2.0 + max2, max4 / 2.0));
                    if (this.h.d(d2)) {
                        int n10 = 0;
                        while (n10 < array.length) {
                            final S s6 = array[n10];
                            s6.a(s6.d(), max4 - s6.c() - s6.e());
                            ++n10;
                            if (i) {
                                continue Label_0856;
                            }
                            if (i) {
                                break;
                            }
                        }
                    }
                }
                o.g();
                continue Label_0856;
            }
            break;
        } while (!i);
    }
    
    public S[] a(final d d) {
        final c c = this.a.c(U.a);
        if (c == null) {
            return null;
        }
        return (S[])c.b(d);
    }
    
    private S[] a(final q q) {
        final D d = (D)this.b.b(q);
        if (d != null) {
            return (S[])d.toArray(new S[d.size()]);
        }
        return null;
    }
    
    private boolean e() {
        return this.a() && this.a.c(U.a) != null;
    }
    
    public void a(final f f) {
        final boolean i = y.f.c.a.i;
        if (!this.e()) {
            return;
        }
        final x o = this.a.o();
        while (o.f()) {
            final q e = o.e();
            final S[] a = this.a(e);
            if (i) {
                return;
            }
            Label_0198: {
                if (a != null) {
                    if (this.g.b(e) == null) {
                        throw new IllegalStateException("realEdge == null: Can't be!!!");
                    }
                    final am h = this.a.h(e);
                    final double x = h.getX();
                    final double y = h.getY();
                    h.getWidth();
                    h.getHeight();
                    int j = 0;
                    while (j < a.length) {
                        a[j].a(a[j].d() + x, a[j].e() + y);
                        ++j;
                        if (i) {
                            break Label_0198;
                        }
                        if (i) {
                            break;
                        }
                    }
                }
                o.g();
            }
            if (i) {
                break;
            }
        }
        this.b(f);
        this.b();
        this.a.a(this.b);
    }
    
    public void b() {
        final boolean i = y.f.c.a.i;
        final e p = this.a.p();
    Label_0161_Outer:
        while (p.f()) {
            if (p.a().e()) {
                final d a = p.a();
                final S[] a2 = this.a(a);
                if (a2 != null) {
                    y.g.e.a(a2, aE.d);
                    final D m = this.a.m(a);
                    final t[] array = (t[])m.toArray(new t[m.size()]);
                    t t = array[0];
                    int j = 1;
                    while (true) {
                        while (j < array.length) {
                            final t t2 = array[j];
                            final double n = dcmpl(t.b(), t2.b());
                            if (i) {
                                if (n >= array.length) {}
                                t t3 = array[array.length - 1];
                                int k = array.length - 2;
                                while (true) {
                                    while (k >= 0) {
                                        final t t4 = array[k];
                                        final double n2 = dcmpl(t3.b(), t4.b());
                                        if (!i) {
                                            if (n2 == 0) {
                                                this.a(t3, t4, a2, false);
                                                if (!i) {
                                                    break;
                                                }
                                            }
                                            t3 = t4;
                                            --k;
                                            if (i) {
                                                break;
                                            }
                                            continue Label_0161_Outer;
                                        }
                                        else if (n2 < 0) {}
                                    }
                                    continue;
                                }
                            }
                            if (n == 0) {
                                this.a(t, t2, a2, true);
                                if (!i) {
                                    break;
                                }
                            }
                            t = t2;
                            ++j;
                            if (i) {
                                break;
                            }
                        }
                        continue;
                    }
                }
            }
            p.g();
            if (i) {
                break;
            }
        }
    }
    
    public void b(final f f) {
        final boolean i = y.f.c.a.i;
        final e a = f.a();
    Label_0147_Outer:
        while (a.f()) {
            final d a2 = a.a();
            final S[] a3 = this.a(a2);
            if (a3 != null) {
                y.g.e.a(a3, aE.d);
                final D m = this.a.m(a2);
                final t[] array = (t[])m.toArray(new t[m.size()]);
                t t = array[0];
                int j = 1;
                while (true) {
                    while (j < array.length) {
                        final t t2 = array[j];
                        final double n = dcmpl(t.b(), t2.b());
                        if (i) {
                            if (n >= array.length) {}
                            t t3 = array[array.length - 1];
                            int k = array.length - 2;
                            while (true) {
                                while (k >= 0) {
                                    final t t4 = array[k];
                                    final double n2 = dcmpl(t3.b(), t4.b());
                                    if (!i) {
                                        if (n2 == 0) {
                                            this.a(t3, t4, a3, false);
                                            if (!i) {
                                                break;
                                            }
                                        }
                                        t3 = t4;
                                        --k;
                                        if (i) {
                                            break;
                                        }
                                        continue Label_0147_Outer;
                                    }
                                    else if (n2 < 0) {}
                                }
                                continue;
                            }
                        }
                        if (n == 0) {
                            this.a(t, t2, a3, true);
                            if (!i) {
                                break;
                            }
                        }
                        t = t2;
                        ++j;
                        if (i) {
                            break;
                        }
                    }
                    continue;
                }
            }
            a.g();
            if (i) {
                break;
            }
        }
    }
    
    void a(final t t, final t t2, final S[] array, final boolean b) {
        final boolean i = y.f.c.a.i;
        Label_0217: {
            if (t.a() < t2.a()) {
                Label_0120: {
                    if (b) {
                        double n = t.a() + 10.0;
                        final double b2 = t.b();
                        int j = 0;
                        while (j < array.length) {
                            final S s = array[j];
                            if (s.f().a() == 2) {
                                return;
                            }
                            s.a(n, b2 - s.c() / 2.0);
                            n += s.b() + 10.0;
                            ++j;
                            if (i) {
                                break Label_0120;
                            }
                        }
                        return;
                    }
                }
                double n2 = t.a() + 10.0;
                final double b3 = t.b();
                int k = array.length - 1;
                while (k >= 0) {
                    final S s2 = array[k];
                    if (s2.f().a() != 2) {
                        return;
                    }
                    s2.a().h();
                    s2.a(n2, b3 - s2.c() / 2.0);
                    n2 += s2.b() + 10.0;
                    --k;
                    if (i) {
                        break Label_0217;
                    }
                }
                return;
            }
        }
        Label_0314: {
            if (b) {
                double n3 = t.a() - 10.0;
                final double b4 = t.b();
                int l = 0;
                while (l < array.length) {
                    final S s3 = array[l];
                    if (s3.f().a() == 2) {
                        return;
                    }
                    s3.a(n3 - s3.b(), b4 - s3.c() / 2.0);
                    n3 -= s3.b() + 10.0;
                    ++l;
                    if (i) {
                        break Label_0314;
                    }
                }
                return;
            }
        }
        double n4 = t.a() - 10.0;
        final double b5 = t.b();
        int n5 = array.length - 1;
        while (n5 >= 0) {
            final S s4 = array[n5];
            if (s4.f().a() != 2) {
                return;
            }
            s4.a(n4 - s4.b(), b5 - s4.c() / 2.0);
            n4 -= s4.b() + 10.0;
            --n5;
            if (i) {
                break;
            }
        }
    }
    
    private boolean a(final d d, final List list) {
        final boolean i = y.f.c.a.i;
        d d2 = d;
        int a = this.f.a(d2.c());
        while (true) {
            while (this.g.b(d2.c()) != null) {
                final Object value = list.get(a);
                final Object p2 = K.p;
                if (!i) {
                    if (value == p2 || list.get(a) == K.q) {
                        return true;
                    }
                    d2 = d2.c().g();
                    --a;
                    if (i) {
                        break;
                    }
                    continue;
                }
                else {
                    while (true) {
                        if (value == p2 || list.get(a) == K.q) {
                            return true;
                        }
                        ++a;
                        if (!i) {
                            if (this.g.b(d2.d()) != null) {
                                d2 = d2.d().f();
                                list.get(a);
                                final Object p3 = K.p;
                                continue;
                            }
                        }
                        break;
                    }
                    return false;
                }
            }
            d2 = d;
            a = this.f.a(d2.c()) + 1;
            continue;
        }
    }
    
    public void c() {
        this.h = null;
        this.g = null;
        this.b = null;
        this.f = null;
        this.a = null;
    }
    
    private static byte a(final aG ag) {
        final byte a = ag.a();
        if (a == 7) {
            return 0;
        }
        return a;
    }
    
    static {
        aE.d = new aF(false);
        aE.e = new aF(true);
    }
}
