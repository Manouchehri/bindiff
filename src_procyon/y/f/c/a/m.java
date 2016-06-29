package y.f.c.a;

import y.f.*;
import java.util.*;
import y.g.*;
import y.a.*;
import y.f.c.*;
import y.c.*;

public class m implements aT
{
    private q a;
    private q b;
    private y c;
    private A d;
    private ArrayList e;
    private q[] f;
    private final aT g;
    private c h;
    private HashMap i;
    private boolean j;
    private X k;
    private h l;
    private h m;
    private A n;
    private A o;
    private A p;
    private c q;
    private int r;
    private f s;
    private f t;
    private A u;
    private f v;
    private boolean w;
    
    public m(final aT g) {
        this.d = null;
        this.w = false;
        this.g = g;
    }
    
    void a(final A d) {
        this.d = d;
    }
    
    public void a(final X x, final aU au, final aV av) {
        final boolean x2 = N.x;
        final boolean b = au.b() == 0;
        final ArrayList list = new ArrayList<q>(64);
        c c = null;
        c c2 = null;
        Label_0228: {
            Label_0221: {
                Label_0144: {
                    if (b) {
                        c = M.a();
                        final x o = x.o();
                        while (o.f()) {
                            final q e = o.e();
                            final A a = (A)(c2 = this.d);
                            if (x2) {
                                break Label_0228;
                            }
                            Label_0132: {
                                if (a == null || !this.d.d(e)) {
                                    list.add(e);
                                    ((A)c).a(e, true);
                                    if (!x2) {
                                        break Label_0132;
                                    }
                                }
                                ((A)c).a(e, false);
                            }
                            o.g();
                            if (x2) {
                                break Label_0144;
                            }
                        }
                        break Label_0221;
                    }
                }
                c = x.c(N.t);
                if (c != null) {
                    final x o2 = x.o();
                    while (o2.f()) {
                        final q e2 = o2.e();
                        final A a2 = (A)(c2 = c);
                        if (x2) {
                            break Label_0228;
                        }
                        if (a2.d(e2)) {
                            list.add(e2);
                        }
                        o2.g();
                        if (x2) {
                            return;
                        }
                    }
                    break Label_0221;
                }
                return;
            }
            c2 = x.c(aR.a);
        }
        final c c3 = c2;
        Label_0260: {
            if (c3 != null) {
                this.h = (c)c3.b(x);
                if (!x2) {
                    break Label_0260;
                }
            }
            this.h = null;
        }
        this.j = !this.b(x);
        this.k = new w();
        this.q = x.c("y.layout.hierarchic.incremental.ConstraintIncrementalLayerer.EDGE_WEIGHTS_DPKEY");
        this.p = M.a();
        this.n = this.k.t();
        this.r = 0;
        this.l = this.k.u();
        this.m = this.k.u();
        final q[] array = new q[au.b()];
        int max = au.b() + list.size() + 2;
        int i = 0;
    Label_0377:
        while (true) {
        Label_0506_Outer:
            while (i < array.length) {
                final X k = this.k;
                if (!x2) {
                    final q d = k.d();
                    array[i] = d;
                    int n = 0;
                    p p3 = au.a(i).d().k();
                    while (true) {
                        while (p3 != null) {
                            final q q = (q)p3.c();
                            n += q.b();
                            this.p.a(q, d);
                            p3 = p3.a();
                            if (!x2) {
                                if (x2) {
                                    break;
                                }
                                continue Label_0506_Outer;
                            }
                            else {
                                if (i > 0) {
                                    final d a3 = this.k.a(array[i - 1], d);
                                    this.m.a(a3, 2);
                                    this.l.a(a3, n);
                                    max = Math.max(max, n);
                                }
                                ++i;
                                if (x2) {
                                    break Label_0506_Outer;
                                }
                                continue Label_0377;
                            }
                        }
                        this.n.a(d, au.a(i).d());
                        continue;
                    }
                }
                final c c4 = k.c(ah.f_);
                this.i = new HashMap();
                Label_0766: {
                    Label_0761: {
                        c c5 = null;
                        Label_0758: {
                            Label_0747: {
                                Label_0736: {
                                    Label_0682: {
                                        if (c4 != null) {
                                            final x o3 = x.o();
                                            while (o3.f()) {
                                                final q e3 = o3.e();
                                                c5 = c4;
                                                if (x2) {
                                                    break Label_0758;
                                                }
                                                this.i.put((c5.b(e3) != null) ? c4.b(e3) : e3, e3);
                                                o3.g();
                                                if (x2) {
                                                    break Label_0682;
                                                }
                                            }
                                            break Label_0736;
                                        }
                                    }
                                    final x o4 = x.o();
                                    while (o4.f()) {
                                        final q e4 = o4.e();
                                        this.i.put(e4, e4);
                                        o4.g();
                                        if (x2) {
                                            break Label_0747;
                                        }
                                        if (x2) {
                                            break;
                                        }
                                    }
                                }
                                this.v = new f();
                            }
                            if (!this.j) {
                                break Label_0761;
                            }
                            final c q2 = this.q;
                        }
                        if (c5 == null) {
                            break Label_0766;
                        }
                    }
                    this.c(x);
                }
                final I j = new I(x);
                boolean d2 = false;
                Label_0850: {
                    if (this.d != null) {
                        final x o5 = x.o();
                        while (o5.f()) {
                            final q e5 = o5.e();
                            d2 = this.d.d(e5);
                            if (x2) {
                                break Label_0850;
                            }
                            if (d2) {
                                j.a(e5);
                            }
                            o5.g();
                            if (x2) {
                                break;
                            }
                        }
                    }
                    final boolean l = this.j;
                }
                if (d2 && this.q == null) {
                    Label_0903: {
                        if (list.isEmpty() || b) {
                            this.b(x, au, av);
                            if (!x2) {
                                break Label_0903;
                            }
                        }
                        new bL().a(x, au, av);
                    }
                    j.f();
                    return;
                }
                this.b(x, c);
                this.u = M.a();
                this.a(x);
                final A a4 = M.a();
                this.b(x, a4, this.d);
                if (this.a(x, a4, this.d)) {
                    this.a(a4, this.v);
                    this.b(x, a4, this.d);
                }
                this.a(x, a4);
                int n2 = 0;
                int n3 = 0;
            Label_1071_Outer:
                while (n3 < array.length) {
                    while (true) {
                        while (a4.a(((y)this.n.b(array[n3])).b()) > n2) {
                            au.a((byte)0, n2);
                            ++n2;
                            if (!x2) {
                                if (x2) {
                                    break;
                                }
                                continue Label_1071_Outer;
                            }
                            else {
                                if (x2) {
                                    break Label_1071_Outer;
                                }
                                continue Label_1071_Outer;
                            }
                        }
                        ++n3;
                        ++n2;
                        continue;
                    }
                }
            Label_1171_Outer:
                for (final q q3 : list) {
                    if (!x2) {
                        final int a5 = a4.a(q3);
                        while (true) {
                            while (a5 >= au.b()) {
                                au.a((byte)0, au.b());
                                if (!x2) {
                                    if (x2) {
                                        break;
                                    }
                                    continue Label_1171_Outer;
                                }
                                else {
                                    if (x2) {
                                        break Label_1171_Outer;
                                    }
                                    continue Label_1171_Outer;
                                }
                            }
                            au.a(a5).a(q3);
                            continue;
                        }
                    }
                    return;
                }
                j.f();
                this.i.clear();
                return;
            }
            continue;
        }
    }
    
    private void a(final X x, final A a) {
        final boolean x2 = N.x;
        final c c = x.c(bk.b);
        if (this.e == null || this.f == null || this.f.length < 2) {
            return;
        }
        for (final d d : this.e) {
            if (this.k.f(d)) {
                this.k.a(d);
                if (x2) {
                    break;
                }
                continue;
            }
        }
        int i = 1;
        while (true) {
        Label_0312_Outer:
            while (i < this.f.length - 1) {
                final X k = this.k;
                if (x2) {
                    final y[] a2 = y.a.h.a(k);
                    final y[] array = new y[a2.length];
                    int j = 0;
                    while (j < a2.length) {
                        final y y = a2[j];
                        array[j] = new y();
                    Label_0185:
                        while (true) {
                            y y2 = null;
                            final x a3 = y2.a();
                            while (a3.f()) {
                                final y y3 = y2 = (y)this.n.b(a3.e());
                                if (x2) {
                                    continue Label_0185;
                                }
                                if (y2 != null) {
                                    array[j].addAll(y3);
                                }
                                a3.g();
                                if (x2) {
                                    break;
                                }
                            }
                            break;
                        }
                        ++j;
                        if (x2) {
                            break;
                        }
                    }
                    final int[] array2 = new int[this.f.length - 1];
                    int l = 0;
                    while (true) {
                        while (l < array2.length) {
                            array2[l] = Integer.MAX_VALUE;
                            ++l;
                            if (x2) {
                                final x o = x.o();
                                while (true) {
                                    while (o.f()) {
                                        final q e = o.e();
                                        final int a4 = a.a(e);
                                        l = Math.max(l, a4);
                                        if (x2) {
                                            final int[] array3 = new int[l + 1];
                                            int n = -1;
                                            int n2 = 0;
                                            int n3 = 0;
                                            while (true) {
                                                while (n3 < array2.length) {
                                                    final int n5;
                                                    final int n4 = n5 = array2[n3];
                                                    final int n6 = Integer.MAX_VALUE;
                                                    if (x2) {
                                                        int n7 = n5 + n6;
                                                        while (true) {
                                                            while (n7 < array3.length) {
                                                                array3[n7] = n2;
                                                                ++n7;
                                                                if (x2) {
                                                                    while (n7 < array.length) {
                                                                        final y y4 = array[n7];
                                                                        Label_0786: {
                                                                            Label_0783: {
                                                                                if (y4.size() != 0) {
                                                                                    final x a5 = y4.a();
                                                                                    int n8 = a.a(a5.e());
                                                                                    final int n9 = array3[n8];
                                                                                    while (true) {
                                                                                        while (a5.f()) {
                                                                                            final int a6 = a.a(a5.e());
                                                                                            final int n10 = array3[a6];
                                                                                            final int n11 = n9;
                                                                                            if (!x2) {
                                                                                                if (n10 != n11) {
                                                                                                    break Label_0783;
                                                                                                }
                                                                                                n8 = Math.min(n8, a6);
                                                                                                a5.g();
                                                                                                if (x2) {
                                                                                                    break;
                                                                                                }
                                                                                                continue Label_0312_Outer;
                                                                                            }
                                                                                            else {
                                                                                                final int n12 = n10 - n11;
                                                                                                if (n12 > 0) {
                                                                                                    final x a7 = y4.a();
                                                                                                    while (a7.f()) {
                                                                                                        final q e2 = a7.e();
                                                                                                        a.a(e2, a.a(e2) - n12);
                                                                                                        a7.g();
                                                                                                        if (x2) {
                                                                                                            break Label_0786;
                                                                                                        }
                                                                                                        if (x2) {
                                                                                                            break;
                                                                                                        }
                                                                                                    }
                                                                                                }
                                                                                                break Label_0783;
                                                                                            }
                                                                                        }
                                                                                        final int n13 = array2[n9];
                                                                                        continue;
                                                                                    }
                                                                                }
                                                                            }
                                                                            ++n7;
                                                                        }
                                                                        if (x2) {
                                                                            break;
                                                                        }
                                                                    }
                                                                    return;
                                                                }
                                                                if (x2) {
                                                                    break;
                                                                }
                                                            }
                                                            n7 = 0;
                                                            continue;
                                                        }
                                                    }
                                                    Label_0538: {
                                                        if (n5 != n6) {
                                                            int n14 = n + 1;
                                                            while (true) {
                                                                while (n14 < n4) {
                                                                    array3[n14] = n2;
                                                                    ++n14;
                                                                    if (x2) {
                                                                        n = n4 - 1;
                                                                        break Label_0538;
                                                                    }
                                                                    if (x2) {
                                                                        break;
                                                                    }
                                                                }
                                                                n2 = n3;
                                                                continue;
                                                            }
                                                        }
                                                    }
                                                    ++n3;
                                                    if (x2) {
                                                        break;
                                                    }
                                                }
                                                continue;
                                            }
                                        }
                                        final bh bh = (c != null) ? ((bh)c.b(e)) : null;
                                        if (bh != null && bh.c() != null && bh.c().a() >= 0) {
                                            array2[bh.c().a()] = Math.min(array2[bh.c().a()], a4);
                                        }
                                        o.g();
                                        if (x2) {
                                            break;
                                        }
                                    }
                                    array2[0] = 0;
                                    continue;
                                }
                            }
                            if (x2) {
                                break;
                            }
                        }
                        l = 0;
                        continue;
                    }
                }
                k.a(this.f[i]);
                ++i;
                if (x2) {
                    break;
                }
            }
            final X m = this.k;
            continue;
        }
    }
    
    private boolean a(final X x, final A a, final A a2) {
        final boolean x2 = N.x;
        if (this.w) {
            return false;
        }
        final e p3 = x.p();
        while (p3.f()) {
            final d a3 = p3.a();
            if ((a2 == null || (!a2.d(a3.c()) && !a2.d(a3.d()))) && a.a(a3.c()) == a.a(a3.d())) {
                return true;
            }
            p3.g();
            if (x2) {
                break;
            }
        }
        return false;
    }
    
    private void a(final A a, final f f) {
        final boolean x = N.x;
        final y y = new y();
        final HashMap<q, q> hashMap = new HashMap<q, q>();
        final HashMap<q, q> hashMap2 = new HashMap<q, q>();
        x x2 = this.c.a();
        while (true) {
            while (x2.f()) {
                final q e = x2.e();
                final x m = e.m();
                final q e2 = m.e();
                m.g();
                final q e3 = m.e();
                hashMap.put(e, e2);
                hashMap2.put(e, e3);
                x2.g();
                if (x) {
                    while (x2.f()) {
                        this.k.a(x2.e());
                        x2.g();
                        if (x) {
                            break;
                        }
                    }
                    final HashSet set = new HashSet(this.e);
                    final x a2 = this.c.a();
                    while (true) {
                        while (a2.f()) {
                            final q e4 = a2.e();
                            final q q = hashMap.get(e4);
                            final q q2 = hashMap2.get(e4);
                            final int a3 = a.a(((y)this.n.b(q)).b());
                            final A t = a;
                            if (x) {
                                final A a4 = t;
                                y.a.m.a(y.a.m.a(this.k), a4);
                                final x a5 = y.a();
                                while (a5.f()) {
                                    final q e5 = a5.e();
                                    final q q3 = hashMap.get(e5);
                                    final int a6 = a4.a(q3);
                                    final q q4 = hashMap2.get(e5);
                                    final int a7 = a4.a(q4);
                                    if (x) {
                                        return;
                                    }
                                    Label_0903: {
                                        if (a6 <= a7) {
                                            d d = q3.a(q4);
                                            if (d == null || set.contains(d)) {
                                                d = this.k.a(q3, q4);
                                                this.m.a(d, 2);
                                                this.l.a(d, 1);
                                                if (!x) {
                                                    break Label_0903;
                                                }
                                            }
                                            this.m.a(d, Math.max(this.m.a(d), 2));
                                            if (!x) {
                                                break Label_0903;
                                            }
                                        }
                                        d d2 = q3.b(q4);
                                        if (d2 == null || set.contains(d2)) {
                                            d2 = this.k.a(q4, q3);
                                            this.m.a(d2, 2);
                                            this.l.a(d2, 1);
                                            if (!x) {
                                                break Label_0903;
                                            }
                                        }
                                        this.m.a(d2, Math.max(this.m.a(d2), 2));
                                    }
                                    a5.g();
                                    if (x) {
                                        break;
                                    }
                                }
                                this.k.a(a4);
                                return;
                            }
                            final int a8 = a.a(((y)this.n.b(q2)).b());
                            Label_0598: {
                                if (q != q2) {
                                    if (a3 == a8) {
                                        y.add(e4);
                                        if (!x) {
                                            break Label_0598;
                                        }
                                    }
                                    if (a3 < a8) {
                                        d d3 = q.a(q2);
                                        if (d3 == null || set.contains(d3)) {
                                            d3 = this.k.a(q, q2);
                                            this.m.a(d3, 2 * (a8 - a3));
                                            this.l.a(d3, 1);
                                            if (!x) {
                                                break Label_0598;
                                            }
                                        }
                                        this.m.a(d3, Math.max(this.m.a(d3), 2 * (a8 - a3)));
                                        this.l.a(d3, Math.max(this.l.a(d3), 1));
                                        if (!x) {
                                            break Label_0598;
                                        }
                                    }
                                    d d4 = q.b(q2);
                                    if (d4 == null || set.contains(d4)) {
                                        d4 = this.k.a(q2, q);
                                        this.m.a(d4, 2 * (a3 - a8));
                                        this.l.a(d4, 1);
                                        if (!x) {
                                            break Label_0598;
                                        }
                                    }
                                    this.m.a(d4, Math.max(this.m.a(d4), 2 * (a8 - a3)));
                                    this.l.a(d4, Math.max(this.l.a(d4), 1));
                                }
                            }
                            a2.g();
                            if (x) {
                                break;
                            }
                        }
                        final A t = this.k.t();
                        continue;
                    }
                }
                if (x) {
                    break;
                }
            }
            x2 = this.c.a();
            continue;
        }
    }
    
    static void a(final i i, c a) {
        final boolean x = N.x;
        if (g.a(i)) {
            return;
        }
        if (a == null) {
            a = y.g.q.a(new Integer(1));
        }
        final h b = M.b();
        final e p2 = i.p();
        while (p2.f()) {
            final d a2 = p2.a();
            b.a(a2, a.a(a2));
            p2.g();
            if (x) {
                break;
            }
        }
        final f f = new f();
        Label_0304: {
        Label_0292:
            while (true) {
                final f a3;
                (a3 = y.a.c.a(i, true)).isEmpty();
                int j = 0;
            Label_0101:
                while (j == 0) {
                    a3.size();
                    int n2 = 0;
                Label_0110:
                    while (true) {
                        int a4 = 0;
                        int n = 0;
                        if (a4 == n) {
                            final d b2 = a3.b();
                            f.add(b2);
                            i.a(b2);
                            if (!x) {
                                continue Label_0304;
                            }
                        }
                        n2 = Integer.MAX_VALUE;
                        final e a5 = a3.a();
                        while (a5.f()) {
                            final int n3 = a4 = b.a(a5.a());
                            n = n2;
                            if (x) {
                                continue Label_0110;
                            }
                            if (a4 < n) {
                                n2 = n3;
                            }
                            a5.g();
                            if (x) {
                                break;
                            }
                        }
                        break;
                    }
                    final e a6 = a3.a();
                    while (a6.f()) {
                        final d a7 = a6.a();
                        final int n4 = b.a(a7) - n2;
                        b.a(a7, n4);
                        if (x) {
                            break Label_0304;
                        }
                        j = n4;
                        if (x) {
                            continue Label_0101;
                        }
                        if (j == 0) {
                            f.add(a7);
                            i.a(a7);
                        }
                        a6.g();
                        if (x) {
                            break Label_0292;
                        }
                    }
                    continue Label_0304;
                }
                break;
            }
            f.sort(new y.f.c.a.p(a));
        }
        final e a8 = f.a();
        while (a8.f()) {
            final d a9 = a8.a();
            i.b(a9);
            if (!g.a(i)) {
                i.a(a9);
            }
            a8.g();
            if (x) {
                break;
            }
        }
    }
    
    private void a(final X x) {
        final boolean x2 = N.x;
        final c c = x.c(bk.b);
        this.c = new y();
        this.r += 10;
        e e = this.t.a();
        while (true) {
            while (e.f()) {
                this.r += this.a(e.a());
                e.g();
                if (x2) {
                    while (true) {
                        while (e.f()) {
                            this.r += this.a(e.a());
                            e.g();
                            if (x2) {
                                while (true) {
                                    while (e.f()) {
                                        this.a(e.a(), c);
                                        e.g();
                                        if (x2) {
                                            while (e.f()) {
                                                this.a(e.a(), c);
                                                e.g();
                                                if (x2) {
                                                    break;
                                                }
                                            }
                                            return;
                                        }
                                        if (x2) {
                                            break;
                                        }
                                    }
                                    e = this.s.a();
                                    continue;
                                }
                            }
                            if (x2) {
                                break;
                            }
                        }
                        e = this.t.a();
                        continue;
                    }
                }
                if (x2) {
                    break;
                }
            }
            e = this.s.a();
            continue;
        }
    }
    
    private void a(final d d, final c c) {
        final boolean x = N.x;
        final q q = (q)this.p.b(d.c());
        final q q2 = (q)this.p.b(d.d());
        if (q == q2) {
            return;
        }
        final bh bh = (c == null) ? null : ((bh)c.b(d.c()));
        final bh bh2 = (c == null) ? null : ((bh)c.b(d.d()));
        if (bh != null && bh2 != null && bh.c().a() != bh2.c().a()) {
            d d2 = null;
            Label_0170: {
                if (bh.c().a() > bh2.c().a()) {
                    d2 = this.k.a(q2, q);
                    if (!x) {
                        break Label_0170;
                    }
                }
                d2 = this.k.a(q, q2);
            }
            this.l.a(d2, this.a(d));
            this.m.a(d2, 2);
            return;
        }
        final int a = this.o.a(q);
        final int a2 = this.o.a(q2);
        if (a < a2) {
            this.a(q, q2, d, false);
            if (!x) {
                return;
            }
        }
        if (a == a2) {
            this.a(q, q2, d, true);
            if (!x) {
                return;
            }
        }
        this.a(q2, q, d, false);
    }
    
    private int a(final d d) {
        return (this.q == null) ? 1 : Math.max(0, this.q.a(d));
    }
    
    private void a(final q q, final q q2, final d d, final boolean b) {
        final q d2 = this.k.d();
        this.c.add(d2);
        this.u.a(d2, d);
        final d a = this.k.a(d2, q);
        this.l.a(a, this.r);
        this.m.a(a, 0);
        final d a2 = this.k.a(d2, q2);
        final int a3 = this.a(d);
        this.l.a(a2, b ? this.r : a3);
        this.m.a(a2, b ? 0 : 2);
    }
    
    private void b(final i i, final c c) {
        final boolean x = N.x;
        this.o = this.k.t();
        this.s = new f();
        this.t = new f();
        final f f = new f();
        final f f2 = new f();
        final I j = new I(this.k);
        if (this.a != null) {
            j.a(this.a.j());
        }
        if (this.b != null) {
            j.a(this.b.j());
        }
        final A t = this.k.t();
        y.a.h.a(this.k, t);
        final h b = M.b();
        final int n = i.h() + 1;
        final e p2 = this.k.p();
        while (true) {
            while (p2.f()) {
                final d a = p2.a();
                final h h = b;
                if (x) {
                    final h h2 = h;
                    this.k.a("y.layout.hierarchic.incremental.ConstraintIncrementalLayerer.ORIG_EDGES", h2);
                    final e p3 = i.p();
                    while (true) {
                        while (p3.f()) {
                            final d a2 = p3.a();
                            if (x) {
                                final y[] a3 = y.a.h.a(this.k);
                                int k = 0;
                                while (k < a3.length) {
                                    final q b2 = a3[k].b();
                                    if (b2 != this.a) {
                                        this.k.a(this.a, b2);
                                    }
                                    ++k;
                                    if (x) {
                                        break;
                                    }
                                }
                                final int a4 = new di(this.g).a(this.k, this.o, f);
                                i.d_("y.layout.hierarchic.incremental.ConstraintIncrementalLayerer.ORIG_EDGES");
                                e e = f.a();
                                while (true) {
                                    while (e.f()) {
                                        this.k.c(e.a());
                                        e.g();
                                        if (x) {
                                            while (true) {
                                                while (e.f()) {
                                                    final d a5 = e.a();
                                                    final X l = this.k;
                                                    if (x) {
                                                        l.a(t);
                                                        return;
                                                    }
                                                    if (l.f(a5)) {
                                                        this.k.a(a5);
                                                    }
                                                    e.g();
                                                    if (x) {
                                                        break;
                                                    }
                                                }
                                                j.f();
                                                if (this.a != null) {
                                                    this.o.a(this.a, -1);
                                                }
                                                if (this.b != null) {
                                                    this.o.a(this.b, a4 + 1);
                                                }
                                                final X m = this.k;
                                                continue;
                                            }
                                        }
                                        if (x) {
                                            break;
                                        }
                                    }
                                    e = f2.a();
                                    continue;
                                }
                            }
                            Label_0410: {
                                if (c.d(a2.c()) || c.d(a2.d())) {
                                    final q q = (q)this.p.b(a2.c());
                                    final q q2 = (q)this.p.b(a2.d());
                                    if (q != q2) {
                                        final int a6 = t.a(q);
                                        final int a7 = t.a(q2);
                                        final d a8 = this.k.a(q, q2);
                                        h2.a(a8, a2);
                                        b.a(a8, 1);
                                        f2.add(a8);
                                        if (a6 != a7) {
                                            this.s.add(a2);
                                            if (!x) {
                                                break Label_0410;
                                            }
                                        }
                                        this.t.add(a2);
                                    }
                                }
                            }
                            p3.g();
                            if (x) {
                                break;
                            }
                        }
                        a(this.k, b);
                        continue;
                    }
                }
                h.a(a, n);
                p2.g();
                if (x) {
                    break;
                }
            }
            M.b();
            continue;
        }
    }
    
    private int b(final X x, final A a, final A a2) {
        final boolean x2 = N.x;
        final A t = this.k.t();
        final A t2 = x.t();
        final A t3 = this.k.t();
        final int a3 = y.a.h.a(this.k, t3);
        final J j = new J(this.k, t3);
        int i = 0;
    Label_0058:
        while (true) {
        Label_0251_Outer:
            while (i < a3) {
                j.c(new Integer(i));
                y.a.u.a(this.k, t, this.l, this.m);
                final X k = this.k;
                if (!x2) {
                    final x o = k.o();
                Label_0251:
                    while (true) {
                        while (o.f()) {
                            final q e = o.e();
                            final int a4 = t.a(e);
                            Object b = this.n.b(e);
                        Label_0152:
                            while (true) {
                                final y y = (y)b;
                                if (x2) {
                                    break Label_0251;
                                }
                                if (y != null) {
                                    final x a5 = y.a();
                                    while (a5.f()) {
                                        final q e2 = a5.e();
                                        b = a2;
                                        if (x2) {
                                            continue Label_0152;
                                        }
                                        if (a2 == null || !a2.d(e2)) {
                                            t2.a(e2, a4);
                                        }
                                        a5.g();
                                        if (x2) {
                                            break;
                                        }
                                    }
                                    break;
                                }
                                break;
                            }
                            o.g();
                            if (x2) {
                                break;
                            }
                            continue Label_0251_Outer;
                            if (x2) {
                                break Label_0251_Outer;
                            }
                            continue Label_0058;
                        }
                        ++i;
                        continue Label_0251;
                    }
                }
                k.a(t3);
                j.b();
                return i;
            }
            i = new D().a(x, t2, a);
            x.a(t2);
            this.k.a(t);
            final X l = this.k;
            continue;
        }
    }
    
    private int b(final X x, final aU au, final aV av) {
        if (this.g instanceof aW) {
            this.g.a(x, au, av);
            return au.b();
        }
        new aW(this.g).a(x, au, av);
        return au.b();
    }
    
    private boolean b(final X x) {
        final boolean x2 = N.x;
        if (bk.c(x) != null) {
            return true;
        }
        if (this.h == null) {
            return false;
        }
        final c c = x.c(ah.f_);
        final x o = x.o();
        while (o.f()) {
            final q e = o.e();
            if (this.h.b((c != null && c.b(e) != null) ? c.b(e) : e) != null) {
                return true;
            }
            o.g();
            if (x2) {
                break;
            }
        }
        return false;
    }
    
    private boolean a(final q q, final q q2) {
        final f a = y.a.q.a(this.k, q, q2, true);
        if (a != null && !a.isEmpty()) {
            return true;
        }
        final f a2 = y.a.q.a(this.k, q2, q, true);
        return a2 != null && !a2.isEmpty();
    }
    
    private void c(final X x) {
        final boolean x2 = N.x;
        final c c = x.c(ah.f_);
        this.a = this.k.d();
        this.n.a(this.a, new y());
        this.b = this.k.d();
        this.n.a(this.b, new y());
        this.e = new ArrayList();
        final bk c2 = bk.c(x);
        this.f = null;
        int size = 0;
        Label_0401: {
            Label_0315: {
                if (c2 != null && c2.e().size() > 1) {
                    size = c2.e().size();
                    (this.f = new q[size + 1])[0] = this.a;
                    this.f[size] = this.b;
                    int i = 1;
                    while (true) {
                        while (i < size) {
                            this.f[i] = this.k.d();
                            final d a = this.k.a(this.f[i - 1], this.f[i]);
                            if (!x2) {
                                final d d = a;
                                Label_0241: {
                                    if (i == 1) {
                                        this.m.a(d, 1);
                                        if (!x2) {
                                            break Label_0241;
                                        }
                                    }
                                    this.m.a(d, 2);
                                }
                                this.l.a(d, 0);
                                ++i;
                                if (x2) {
                                    break;
                                }
                                continue;
                            }
                            else {
                                final d d2 = a;
                                this.m.a(d2, 1);
                                this.l.a(d2, 0);
                                if (x2) {
                                    break Label_0315;
                                }
                                break Label_0401;
                            }
                        }
                        this.k.a(this.f[size - 1], this.f[size]);
                        continue;
                    }
                }
            }
            (this.f = new q[2])[0] = this.a;
            this.f[1] = this.b;
            final d a2 = this.k.a(this.f[0], this.f[1]);
            this.e.add(a2);
            this.m.a(a2, 0);
            this.l.a(a2, 0);
            size = 1;
        }
        final y.c.D d3 = new y.c.D();
        final y.c.D d4 = new y.c.D();
        final c c3 = x.c(bk.b);
        C c4 = x.o();
    Label_1824:
        while (true) {
            do {
                c4.f();
                boolean b = false;
            Label_0441:
                while (b) {
                    final q e = ((x)c4).e();
                    final q a3 = this.a(e);
                    bh bh = null;
                    Object d5;
                    final c c5 = (c)(d5 = c3);
                    if (!x2) {
                        if (c5 != null && c3.b(e) != null) {
                            bh = (bh)c3.b(e);
                            if (!bh.b()) {
                                final bt c6 = bh.c();
                                if (c6 != null && c6.a() >= 0) {
                                    final d a4 = this.k.a(this.f[c6.a()], a3);
                                    int n = 0;
                                    Label_0578: {
                                        if (c6.a() == 0) {
                                            n = 0;
                                            this.e.add(a4);
                                            if (!x2) {
                                                break Label_0578;
                                            }
                                        }
                                        n = 1;
                                    }
                                    this.m.a(a4, n);
                                    this.l.a(a4, 0);
                                    final d a5 = this.k.a(a3, this.f[c6.a() + 1]);
                                    int n2 = 0;
                                    Label_0662: {
                                        if (c6.a() == this.f.length - 2) {
                                            n2 = 0;
                                            this.e.add(a5);
                                            if (!x2) {
                                                break Label_0662;
                                            }
                                        }
                                        n2 = 1;
                                    }
                                    this.m.a(a5, n2);
                                    this.l.a(a5, 0);
                                }
                            }
                        }
                        else {
                            final d a6 = this.k.a(this.a, a3);
                            this.m.a(a6, 0);
                            this.l.a(a6, 0);
                            this.e.add(a6);
                            final d a7 = this.k.a(a3, this.b);
                            this.m.a(a7, 0);
                            this.l.a(a7, 0);
                            this.e.add(a7);
                        }
                        co co = null;
                        co co2 = null;
                        final Object o = (c != null && c.b(e) != null) ? c.b(e) : e;
                        Label_1817: {
                            if (this.h != null) {
                                final y.c.D d6 = (y.c.D)this.h.b(o);
                                if (d6 != null) {
                                    final C m = d6.m();
                                    while (m.f()) {
                                        final Object d7 = m.d();
                                        b = (d7 instanceof co);
                                        if (x2) {
                                            continue Label_0441;
                                        }
                                        if (b) {
                                            final co co3 = (co)d7;
                                            final q q = this.i.get(co3.d());
                                            Label_1300: {
                                                switch (co3.c()) {
                                                    case 0: {
                                                        final bh bh2 = (c3 != null) ? ((bh)c3.b(q)) : null;
                                                        if (bh != null && bh2 != null && bh.c() != bh2.c()) {
                                                            break;
                                                        }
                                                        d3.add(new o(e, co3));
                                                        if (x2) {
                                                            break Label_1300;
                                                        }
                                                        break;
                                                    }
                                                    case -1: {
                                                        final bh bh3 = (c3 != null) ? ((bh)c3.b(q)) : null;
                                                        if (bh != null && bh3 != null && bh.c().a() < bh3.c().a()) {
                                                            break;
                                                        }
                                                        d4.add(new o(e, co3));
                                                        this.r += co3.a();
                                                        if (x2) {
                                                            break Label_1300;
                                                        }
                                                        break;
                                                    }
                                                    case 1: {
                                                        final bh bh4 = (c3 != null) ? ((bh)c3.b(q)) : null;
                                                        if (bh != null && bh4 != null && bh.c().a() > bh4.c().a()) {
                                                            break;
                                                        }
                                                        d4.add(new o(e, co3));
                                                        this.r += co3.a();
                                                        if (x2) {
                                                            break Label_1300;
                                                        }
                                                        break;
                                                    }
                                                    case 2: {
                                                        if (bh != null && bh.c().a() != 0) {
                                                            break;
                                                        }
                                                        if (co == null) {
                                                            co = co3;
                                                            if (!x2) {
                                                                break;
                                                            }
                                                        }
                                                        if (co.b() >= co3.b()) {
                                                            break;
                                                        }
                                                        co = co3;
                                                        if (x2) {
                                                            break Label_1300;
                                                        }
                                                        break;
                                                    }
                                                    case -2: {
                                                        if (bh != null && bh.c().a() != size - 1) {
                                                            break;
                                                        }
                                                        if (co2 == null) {
                                                            co2 = co3;
                                                            if (!x2) {
                                                                break;
                                                            }
                                                        }
                                                        if (co2.b() < co3.b()) {
                                                            co2 = co3;
                                                            break;
                                                        }
                                                        break;
                                                    }
                                                }
                                            }
                                        }
                                        m.g();
                                        if (x2) {
                                            break;
                                        }
                                    }
                                    final y y = (y)this.n.b(a3);
                                    if (co != null && co2 != null) {
                                        Label_1601: {
                                            Label_1592: {
                                                Label_1503: {
                                                    if (co.b() > co2.b()) {
                                                        final y y2 = (y)this.n.b(this.a);
                                                        if (y != null) {
                                                            final x a8 = y.a();
                                                            while (a8.f()) {
                                                                final q e2 = a8.e();
                                                                y2.add(e2);
                                                                this.p.a(e2, this.a);
                                                                a8.g();
                                                                if (x2) {
                                                                    break Label_1601;
                                                                }
                                                                if (x2) {
                                                                    break Label_1503;
                                                                }
                                                            }
                                                        }
                                                        break Label_1592;
                                                    }
                                                }
                                                final y y3 = (y)this.n.b(this.b);
                                                if (y != null) {
                                                    final x a9 = y.a();
                                                    while (a9.f()) {
                                                        final q e3 = a9.e();
                                                        y3.add(e3);
                                                        this.p.a(e3, this.b);
                                                        a9.g();
                                                        if (x2) {
                                                            break Label_1601;
                                                        }
                                                        if (x2) {
                                                            break;
                                                        }
                                                    }
                                                }
                                            }
                                            this.k.a(a3);
                                        }
                                        if (!x2) {
                                            break Label_1817;
                                        }
                                    }
                                    if (co != null) {
                                        final y y4 = (y)this.n.b(this.a);
                                        Label_1709: {
                                            if (y != null) {
                                                final x a10 = y.a();
                                                while (a10.f()) {
                                                    final q e4 = a10.e();
                                                    y4.add(e4);
                                                    this.p.a(e4, this.a);
                                                    a10.g();
                                                    if (x2) {
                                                        break Label_1709;
                                                    }
                                                    if (x2) {
                                                        break;
                                                    }
                                                }
                                            }
                                            this.k.a(a3);
                                        }
                                        if (!x2) {
                                            break Label_1817;
                                        }
                                    }
                                    if (co2 != null) {
                                        final y y5 = (y)this.n.b(this.b);
                                        if (y != null) {
                                            final x a11 = y.a();
                                            while (a11.f()) {
                                                final q e5 = a11.e();
                                                y5.add(e5);
                                                this.p.a(e5, this.b);
                                                a11.g();
                                                if (x2) {
                                                    continue Label_1824;
                                                }
                                                if (x2) {
                                                    break;
                                                }
                                            }
                                        }
                                        this.k.a(a3);
                                    }
                                }
                            }
                        }
                        c4.g();
                        continue Label_1824;
                    }
                    while (true) {
                        final o o2 = (o)d5;
                        final q a12 = this.a(o2.a);
                        final q a13 = this.a(this.i.get(o2.b.d()));
                        Label_2558: {
                            Label_2551: {
                                if (a12 != a13 && a13 != null && !this.a(a12, a13)) {
                                    f f = new f(a13.l());
                                    final e a14 = f.a();
                                    while (true) {
                                        while (a14.f()) {
                                            final d a15 = a14.a();
                                            this.k.a(a15, a12, a15.d());
                                            a14.g();
                                            if (x2) {
                                                final e a16 = f.a();
                                                while (a16.f()) {
                                                    final d a17 = a16.a();
                                                    this.k.a(a17, a17.c(), a12);
                                                    a16.g();
                                                    if (x2) {
                                                        break Label_2558;
                                                    }
                                                    if (x2) {
                                                        break;
                                                    }
                                                }
                                                final y y6 = (y)this.n.b(a13);
                                                final y y7 = (y)this.n.b(a12);
                                                Label_2527: {
                                                    if (y6 != null) {
                                                        final x a18 = y6.a();
                                                        while (a18.f()) {
                                                            final q e6 = a18.e();
                                                            y7.add(e6);
                                                            this.p.a(e6, a12);
                                                            a18.g();
                                                            if (x2) {
                                                                break Label_2527;
                                                            }
                                                            if (x2) {
                                                                break;
                                                            }
                                                        }
                                                    }
                                                    if (a13 == this.b) {
                                                        this.b = a12;
                                                    }
                                                }
                                                if (a13 == this.a) {
                                                    this.a = a12;
                                                }
                                                this.k.a(a13);
                                                break Label_2551;
                                            }
                                            if (x2) {
                                                break;
                                            }
                                        }
                                        f = new f(a13.k());
                                        continue;
                                    }
                                }
                            }
                            c4.g();
                        }
                        if (!x2) {
                            if (c4.f()) {
                                d5 = c4.d();
                                continue;
                            }
                        }
                        break;
                    }
                    return;
                }
                break;
            } while (!x2);
            int a22 = 0;
            Label_2159: {
                Label_2154: {
                    if (!d4.isEmpty()) {
                        final h b2 = M.b();
                        int max = 1;
                        final C j = d4.m();
                        while (true) {
                            while (j.f()) {
                                final o o3 = (o)j.d();
                                final q a19 = this.a(o3.a);
                                final q a20 = this.a(this.i.get(o3.b.d()));
                                Object o4 = null;
                                if (x2) {
                                    final e p = this.k.p();
                                    while (p.f()) {
                                        final d a21 = p.a();
                                        a22 = b2.a(a21);
                                        if (x2) {
                                            break Label_2159;
                                        }
                                        if (a22 == 0) {
                                            b2.a(a21, max);
                                        }
                                        p.g();
                                        if (x2) {
                                            break;
                                        }
                                    }
                                    a(this.k, b2);
                                    break Label_2154;
                                }
                                if (a19 != a20 && a20 != null) {
                                    if (o3.a() == -1) {
                                        o4 = this.k.a(a19, a20);
                                    }
                                    else if (o3.a() == 1) {
                                        o4 = this.k.a(a20, a19);
                                    }
                                    if (o4 != null) {
                                        b2.a(o4, o3.b());
                                        max = Math.max(max, o3.b());
                                        this.m.a(o4, o3.b.e() * 2);
                                        this.l.a(o4, o3.b.a());
                                    }
                                }
                                j.g();
                                if (x2) {
                                    break;
                                }
                            }
                            max *= this.k.h() + 1;
                            continue;
                        }
                    }
                }
                d3.isEmpty();
            }
            if (a22 == 0) {
                d3.sort(new n());
                c4 = d3.m();
                continue;
            }
            break;
        }
    }
    
    private q a(final q q) {
        if (q == null) {
            return null;
        }
        q d = (q)this.p.b(q);
        if (d == null) {
            d = this.k.d();
            this.p.a(q, d);
            final y y = new y();
            y.add(q);
            this.n.a(d, y);
        }
        return d;
    }
}
