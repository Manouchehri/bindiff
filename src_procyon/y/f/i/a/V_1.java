package y.f.i.a;

import y.g.*;
import y.f.c.a.*;
import y.f.*;
import java.util.*;
import y.c.*;

public class V
{
    private h b;
    int a;
    private Z c;
    private D d;
    private D e;
    private D f;
    private D g;
    private bz h;
    private Y i;
    
    public V() {
        this.d = new D();
        this.e = new D();
        this.f = new D();
        this.g = new D();
        this.h = new bz();
    }
    
    D a() {
        return this.d;
    }
    
    public boolean a(final ab ab) {
        return this.d.add(ab);
    }
    
    D b() {
        return this.e;
    }
    
    boolean a(final bR br) {
        return this.e.add(br);
    }
    
    boolean b(final bR br) {
        return this.e.remove(br);
    }
    
    private void a(final f f, final aa aa, final byte b) {
        final int a = ab.a;
        final C m = this.b().m();
        while (m.f()) {
            ((bR)m.d()).a(f, aa, b);
            m.g();
            if (a != 0) {
                break;
            }
        }
    }
    
    D c() {
        return this.f;
    }
    
    public boolean a(final H h) {
        return this.f.add(h);
    }
    
    public boolean b(final H h) {
        return this.f.remove(h);
    }
    
    public void a(final Z c) {
        final int a = ab.a;
        this.c = c;
        this.b = M.b();
        this.a = 0;
        final Iterator iterator = this.d.iterator();
        while (iterator.hasNext()) {
            iterator.next().a(c);
            if (a != 0) {
                break;
            }
        }
    }
    
    public void d() {
        final int a = ab.a;
        final D a2 = this.a();
        final C m = a2.m();
        while (true) {
            while (m.f()) {
                ((ab)m.d()).c();
                m.g();
                if (a != 0) {
                    final X a3 = this.c.a();
                    this.e.clear();
                    this.f.clear();
                    this.g.clear();
                    this.h.c();
                    this.i = null;
                    this.c = null;
                    this.b = null;
                    final c c = a3.c("y.layout.router.polyline.PathSearch.VISITED_NEIGHBORS");
                    if (c != null) {
                        final aO ao = (aO)c.b(a3);
                        if (ao != null) {
                            ao.a(this.a);
                        }
                    }
                    return;
                }
                if (a != 0) {
                    break;
                }
            }
            a2.clear();
            continue;
        }
    }
    
    void a(final d d, final U u) {
        this.b.a(d, u);
    }
    
    public U a(final d d) {
        return (U)this.b.b(d);
    }
    
    protected void a(final aa aa) {
        final int a = ab.a;
        final d c = aa.c();
        int i = 0;
        final x d = aa.d();
        final ad f = d.f();
        double min = 0.0;
    Label_0370_Outer:
        while (i == 0) {
            final C m = this.a().m();
            while (m.f()) {
                ((ab)m.d()).b(aa);
                m.g();
                if (a != 0) {
                    continue Label_0370_Outer;
                }
                if (a != 0) {
                    break;
                }
            }
        Label_0371_Outer:
            while (true) {
            Label_0371:
                while (true) {
                    for (final f f2 : this.c(aa)) {
                        f2.a(f2.f() + this.a(f2));
                        this.h.a(f2, f2.f());
                        f2.a(true);
                        this.a(f2, aa, (byte)1);
                        if (a == 0) {
                            if (a != 0) {
                                break;
                            }
                            continue Label_0370_Outer;
                        }
                        else {
                            final int a2 = i;
                            Label_0494: {
                                if (a2 == 0) {
                                    final C j = this.a().m();
                                    while (true) {
                                        while (j.f()) {
                                            ((ab)j.d()).c(aa);
                                            j.g();
                                            if (a == 0) {
                                                if (a != 0) {
                                                    break;
                                                }
                                                continue Label_0370_Outer;
                                            }
                                            else {
                                                if (d.f() == f) {
                                                    break Label_0370_Outer;
                                                }
                                                d.a(f);
                                                if (a != 0) {
                                                    break Label_0494;
                                                }
                                                break Label_0370_Outer;
                                            }
                                        }
                                        if (!this.h.a()) {
                                            final ad q = f.q();
                                            min = Math.min(1.0, min + 0.25);
                                            this.a(q, min, aa);
                                            d.a(q);
                                            continue Label_0370_Outer;
                                        }
                                        continue;
                                    }
                                }
                            }
                            if (d.f() == f) {
                                continue Label_0370_Outer;
                            }
                            d.a(f);
                            if (a != 0) {
                                break Label_0370_Outer;
                            }
                            continue Label_0370_Outer;
                        }
                    }
                Label_0173:
                    while (!this.h.a()) {
                        final f b = this.h.b();
                        this.a(b, aa, (byte)0);
                        b.a(false);
                        final R a3 = b.a();
                        if (aa.d(a3) && this.b(b)) {
                            i = 1;
                            final U a4 = a(b, aa.c());
                            this.a(a4);
                            this.a(c, a4);
                            if (a == 0) {
                                break;
                            }
                        }
                        final List c2 = this.c.c().r().c(a3);
                        this.a += c2.size();
                        final Iterator<R> iterator2 = c2.iterator();
                        while (iterator2.hasNext()) {
                            this.a(b, iterator2.next(), aa);
                            if (a != 0) {
                                continue Label_0173;
                            }
                            if (a != 0) {
                                break;
                            }
                        }
                        if (min < 1.0) {
                            final int a2;
                            final boolean b2 = (a2 = (this.i.a() ? 1 : 0)) != 0;
                            if (a != 0) {
                                continue Label_0371;
                            }
                            if (b2) {
                                break;
                            }
                            continue Label_0370_Outer;
                        }
                    }
                    break;
                }
                continue Label_0371_Outer;
            }
        }
        final C k = this.a().m();
        while (k.f()) {
            ((ab)k.d()).d(aa);
            k.g();
            if (a != 0) {
                return;
            }
            if (a != 0) {
                break;
            }
        }
        this.e();
    }
    
    protected void a(final ad ad, final double n, final aa aa) {
        final int a = ab.a;
        ad.b((int)(ad.c() * (1.0 - Math.min(1.0, Math.max(0.0, n - 0.3) * 2.0))));
        final double n2 = 1.0 - Math.min(1.0, n * 2.0);
        ad.l((int)(ad.m() * n2));
        ad.o((int)(ad.p() * n2));
        ad.n((int)(ad.o() * n2));
        final double n3 = 1.0 - Math.min(1.0, n * 3.5);
        ad.k((int)(ad.l() * n3));
        ad.h((int)(ad.i() * n3));
        ad.f((int)(ad.g() * n3));
        ad.g((int)(ad.h() * n3));
        ad.i((int)(ad.j() * n3));
        ad.j((int)(ad.k() * n3));
        ad.m((int)(ad.n() * n3));
        final double n4 = 1.0 - Math.min(1.0, n * 10.0);
        ad.a((int)(ad.b() * n4));
        ad.c((int)(ad.d() * n4));
        ad.d((int)(ad.e() * n4));
        ad.e((int)(ad.f() * n4));
        if (a != 0) {
            y.c.i.g = !y.c.i.g;
        }
    }
    
    private double a(final f f) {
        final int a = ab.a;
        double n = 0.0;
        final C m = this.a().m();
        double n2 = 0.0;
        while (m.f()) {
            n2 = n + ((ab)m.d()).a(f);
            if (a != 0) {
                return n2;
            }
            n = n2;
            m.g();
            if (a != 0) {
                break;
            }
        }
        return n2;
    }
    
    private void e() {
        final int a = ab.a;
        final C m = this.g.m();
        while (m.f()) {
            ((R)m.d()).a((HashMap)null);
            m.g();
            if (a != 0) {
                return;
            }
            if (a != 0) {
                break;
            }
        }
        this.g.clear();
        this.h.c();
    }
    
    public void b(final aa aa) {
        final int a = ab.a;
        int k = aa.b().k();
        if (k == 0) {
            return;
        }
        final long n = System.currentTimeMillis() + aa.j();
        C c = this.a().m();
    Label_0214:
        while (true) {
        Label_0221:
            while (true) {
            Label_0349_Outer:
                while (c.f()) {
                    ((ab)c.d()).a(aa);
                    c.g();
                    if (a != 0) {
                        c.f();
                        final long n2;
                        if (n2 != 0) {
                            ((ab)c.d()).e(aa);
                            c.g();
                            if (a == 0) {
                                continue Label_0214;
                            }
                        }
                        final ac i = aa.i();
                        C c2 = aa.b();
                        while (true) {
                            while (c2.f()) {
                                final d a2 = ((e)c2).a();
                                final U a3 = this.a(a2);
                                Object d;
                                final U u = (U)(d = a3);
                                if (a != 0) {
                                    while (true) {
                                        ((ab)d).a(i);
                                        c2.g();
                                        if (a == 0) {
                                            if (c2.f()) {
                                                d = c2.d();
                                                continue Label_0349_Outer;
                                            }
                                        }
                                        break;
                                    }
                                    return;
                                }
                                if (u != null) {
                                    i.a(a2, a3);
                                    final w a4 = i.a(a2);
                                    if (a4 != null) {
                                        this.a(a4);
                                    }
                                }
                                c2.g();
                                if (a != 0) {
                                    break;
                                }
                            }
                            c2 = this.a().m();
                            continue;
                        }
                    }
                    if (a != 0) {
                        break;
                    }
                }
                c = aa.b();
                while (c.f()) {
                    aa.a(((e)c).a());
                    final long n2 = lcmp(aa.k(), Long.MAX_VALUE);
                    if (a != 0) {
                        continue Label_0221;
                    }
                    Label_0185: {
                        if (n2 == 0) {
                            this.i = new y.f.i.a.X();
                            if (a == 0) {
                                break Label_0185;
                            }
                        }
                        final long currentTimeMillis = System.currentTimeMillis();
                        this.i = new W(currentTimeMillis, currentTimeMillis + Math.max((n - currentTimeMillis) / k, aa.k()));
                    }
                    this.a(aa);
                    --k;
                    ((e)c).g();
                    if (a != 0) {
                        break;
                    }
                }
                break;
            }
            c = this.a().m();
            continue Label_0214;
        }
    }
    
    private void a(final w w) {
        final int a = ab.a;
        for (final v v : w.d()) {
            v.h().b().a(v);
            if (a != 0) {
                break;
            }
        }
    }
    
    protected void a(final U u) {
        final int a = ab.a;
        final C m = this.a().m();
        while (m.f()) {
            ((ab)m.d()).a(u);
            m.g();
            if (a != 0) {
                break;
            }
        }
    }
    
    private D c(final aa aa) {
        final int a = ab.a;
        final D d = new D();
        final C m = this.a().m();
        while (m.f()) {
            ((ab)m.d()).a(d);
            m.g();
            if (a != 0) {
                break;
            }
        }
        int i = 0;
        final int e = aa.e();
    Label_0222_Outer:
        while (i < e) {
            final R a2 = aa.a(i);
            final f f = new f(a2);
            while (true) {
                for (final R r : this.c.c().r().c(a2)) {
                    if (!aa.b(r)) {
                        final f f2 = new f(r);
                        f2.a(f);
                        f2.a(a(f, r));
                        f2.a(a(a2, r));
                        d.add(f2);
                        if (a == 0) {
                            if (a != 0) {
                                break;
                            }
                            continue Label_0222_Outer;
                        }
                        else {
                            if (a != 0) {
                                break Label_0222_Outer;
                            }
                            continue Label_0222_Outer;
                        }
                    }
                }
                ++i;
                continue;
            }
        }
        return d;
    }
    
    private List a(final f f, final R r, final y y, final aa aa) {
        final int i = ab.a;
        final ArrayList list = new ArrayList<P>();
        final P a = a(f.a(), r);
        if (a == null) {
            throw new IllegalArgumentException("neighborCell has no common border with the PartitionCell of currentEntrance");
        }
        final D c = this.c();
        Label_0324: {
            Label_0317: {
                if (!c.isEmpty()) {
                    final int[] array = new int[c.size()];
                    int n = 0;
                    p p4 = c.k();
                    while (p4 != null) {
                        final H h = (H)p4.c();
                        final int size = list.size();
                        h.a(f, r, a, list, aa);
                        array[n++] = list.size() - size;
                        p4 = p4.a();
                        if (i != 0) {
                            break Label_0324;
                        }
                        if (i != 0) {
                            break;
                        }
                    }
                    final int size2 = list.size();
                    if (size2 > 1) {
                        int n2 = 0;
                        int j = 0;
                    Label_0162:
                        while (j < array.length) {
                            final int n3 = n2 + array[j];
                            final int n4 = n2;
                            if (i == 0) {
                                int n5 = n4;
                                while (true) {
                                    do {
                                        int k = 0;
                                    Label_0191:
                                        while (k < n3) {
                                            final P p5 = list.get(n5);
                                            final int n6 = n3;
                                            if (i == 0) {
                                                int l = n6;
                                                while (l < size2) {
                                                    final P p6 = list.get(l);
                                                    k = (p5.c(p6) ? 1 : 0);
                                                    if (i != 0) {
                                                        continue Label_0191;
                                                    }
                                                    if (k == 0 && !p6.c(p5)) {
                                                        final P a2 = P.a(p5, p6);
                                                        if (a2 != null) {
                                                            list.add(a2);
                                                        }
                                                    }
                                                    ++l;
                                                    if (i != 0) {
                                                        break;
                                                    }
                                                }
                                                ++n5;
                                            }
                                            else {
                                                n2 = n6;
                                                ++j;
                                                if (i != 0) {
                                                    break Label_0317;
                                                }
                                                continue Label_0162;
                                            }
                                        }
                                        break;
                                    } while (i == 0);
                                    final int n7 = n2 + array[j];
                                    continue;
                                }
                            }
                            break Label_0324;
                        }
                    }
                }
            }
            list.add(a);
        }
        if (y != f.d() || f.c() == null) {
            return list;
        }
        final double f2 = a.f();
        final boolean a3 = a.a();
        final y.f.i.a.M e = f.c().e();
        final y.f.i.a.M m = new y.f.i.a.M(e.a() - 0.1, e.b() + 0.1);
        final HashSet<y.f.i.a.M> set = new HashSet<y.f.i.a.M>();
        final ArrayList<P> list2 = new ArrayList<P>();
        for (final P p7 : list) {
            final y.f.i.a.M e2 = p7.e();
            if (m.b(e2) > 0.0 || e2.c(e)) {
                if (!set.add(e2)) {
                    continue;
                }
                final ArrayList<P> list4;
                final ArrayList<P> list3 = list4 = list2;
                if (i != 0) {
                    return list4;
                }
                list3.add(p7);
                if (i == 0) {
                    continue;
                }
            }
            if (e2.a() < m.a()) {
                final y.f.i.a.M m2 = new y.f.i.a.M(e2.a(), m.a());
                if (set.add(m2)) {
                    list2.add(new P(m2, f2, a3));
                }
            }
            if (e2.b() > m.b()) {
                final y.f.i.a.M m3 = new y.f.i.a.M(m.b(), e2.b());
                if (set.add(m3)) {
                    list2.add(new P(m3, f2, a3));
                }
            }
            final y.f.i.a.M a4 = y.f.i.a.M.a(e, e2);
            if (a4 != null && set.add(a4)) {
                list2.add(new P(a4, f2, a3));
                if (i != 0) {
                    break;
                }
                continue;
            }
        }
        return list2;
    }
    
    private boolean b(final f f) {
        final int a = ab.a;
        final C m = this.a().m();
        boolean c = false;
        while (m.f()) {
            c = ((ab)m.d()).c(f);
            if (a != 0) {
                return c;
            }
            if (!c) {
                return false;
            }
            m.g();
            if (a != 0) {
                break;
            }
        }
        return c;
    }
    
    protected void a(final f f, final R r, final aa aa) {
        final int i = ab.a;
        final y a = a(f, r);
        final List a2 = this.a(f, r, a, aa);
        final f[] array = new f[a2.size()];
        final HashSet set = new HashSet<y.f.i.a.M>(a2.size());
        final D d = new D();
        int n = 0;
        for (final P p3 : a2) {
            if (set.add(p3.e())) {
                final f b = this.b(f, r, p3);
                if (b != null && b.f() < f.f()) {
                    continue;
                }
                array[n++] = b;
                d.add(p3);
                if (i != 0) {
                    break;
                }
                continue;
            }
        }
        final d c = aa.c();
        final R a3 = f.a();
        final int n2 = (f.j() != null) ? f.j().e() : 0;
        final P[] array2 = new P[d.size()];
        final v[] array3 = new v[d.size()];
        final double[] array4 = new double[d.size()];
        int n3 = 0;
        while (true) {
            for (final P p4 : d) {
                array2[n3] = p4;
                array3[n3] = new v(c, a3, f.c(), p4, f.d(), a, n2);
                final f f2 = array[n3];
                final double[] array5 = array4;
                if (i != 0) {
                    final double[] array6 = array5;
                    int n4 = 0;
                    do {
                        int j = 0;
                    Label_0357:
                        while (j < array2.length) {
                            final P p5 = array2[n4];
                            final double n5 = f.f() + array6[n4];
                            final f f3 = array[n4];
                            Label_0695: {
                                f f4 = null;
                                Label_0461: {
                                    if (f3 != null) {
                                        if (n5 >= f3.f()) {
                                            break Label_0695;
                                        }
                                        if (f3.c().d(p5)) {
                                            f4 = f3;
                                            f4.b(null);
                                            if (i == 0) {
                                                break Label_0461;
                                            }
                                        }
                                        f4 = new f(r);
                                        if (i == 0) {
                                            break Label_0461;
                                        }
                                    }
                                    f4 = new f(r);
                                }
                                f4.a(f);
                                f4.a(p5);
                                f4.a(n5);
                                f4.a(array3[n4]);
                                Label_0594: {
                                    if (f4.e()) {
                                        this.h.b(f4, n5 + this.a(f4, aa));
                                        this.a(f4, aa, (byte)2);
                                        if (i == 0) {
                                            break Label_0594;
                                        }
                                    }
                                    f4.a(true);
                                    f4.a(a);
                                    this.h.a(f4, n5 + this.a(f4, aa));
                                    this.a(f4, f);
                                    this.a(f4, aa, (byte)1);
                                }
                                final List a4 = this.a(f, r, p5);
                                if (a4 != null) {
                                    for (final f f5 : a4) {
                                        if (f5 != f4) {
                                            j = (this.h.a(f5) ? 1 : 0);
                                            if (i != 0) {
                                                continue Label_0357;
                                            }
                                            if (j == 0 || f5.f() <= n5) {
                                                continue;
                                            }
                                            this.h.b(f5);
                                            f5.a(false);
                                            if (i != 0) {
                                                break;
                                            }
                                            continue;
                                        }
                                    }
                                }
                            }
                            ++n4;
                        }
                        break;
                    } while (i == 0);
                    return;
                }
                array5[n3] = ((f2 != null) ? (f2.f() - f.f()) : Double.MAX_VALUE);
                ++n3;
                if (i != 0) {
                    break;
                }
            }
            this.a(f, r, array2, array3, aa, array4);
            continue;
        }
    }
    
    private void a(final f f, final f f2) {
        final R a = f2.a();
        HashMap<Object, ArrayList<?>> c = (HashMap<Object, ArrayList<?>>)a.c();
        if (c == null) {
            c = (HashMap<Object, ArrayList<?>>)new HashMap<R, ArrayList<?>>();
            this.g.add(a);
            a.a(c);
        }
        final R a2 = f.a();
        ArrayList<?> list = c.get(a2);
        if (list == null) {
            list = new ArrayList<Object>();
            c.put(a2, list);
        }
        list.add(f);
    }
    
    private List a(final f f, final R r, final P p3) {
        final int a = ab.a;
        final HashMap c = f.a().c();
        if (c == null) {
            return null;
        }
        final ArrayList<f> list = c.get(r);
        if (list == null) {
            return null;
        }
        final ArrayList<f> list2 = new ArrayList<f>();
        ArrayList<f> list3 = null;
        for (final f f2 : list) {
            if (f2.c().c(p3)) {
                list3 = list2;
                if (a != 0) {
                    return list3;
                }
                list3.add(f2);
                if (a != 0) {
                    break;
                }
                continue;
            }
        }
        return list3;
    }
    
    private f b(final f f, final R r, final P p3) {
        final int a = ab.a;
        final List a2 = this.a(f, r, p3);
        if (a2 == null) {
            return null;
        }
        f f2 = null;
        f f4 = null;
        for (final f f3 : a2) {
            f4 = f2;
            if (a != 0) {
                return f4;
            }
            if (f4 != null && f2.f() <= f3.f()) {
                continue;
            }
            f2 = f3;
            if (a != 0) {
                break;
            }
        }
        return f4;
    }
    
    protected double[] a(final f f, final R r, final P[] array, final v[] array2, final aa aa, final double[] array3) {
        final int a = ab.a;
        final double[] array4 = new double[array.length];
        final double[] array5 = new double[array3.length];
        System.arraycopy(array3, 0, array5, 0, array3.length);
        final C m = this.a().m();
        double[] a2 = null;
    Label_0179_Outer:
        while (m.f()) {
            a2 = ((ab)m.d()).a(f, r, array, array2, array5);
            if (a == 0) {
                final double[] array6 = a2;
                int i = 0;
                while (true) {
                    while (i < array6.length) {
                        final double[] array7 = array4;
                        final int n = i;
                        array7[n] += array6[i];
                        final double n2 = dcmpl(array5[i], Double.MAX_VALUE);
                        if (a == 0) {
                            if (n2 != 0 || a != 0) {
                                final double[] array8 = array5;
                                final int n3 = i;
                                array8[n3] -= array6[i];
                                if (array5[i] <= 0.0) {
                                    array5[i] = 0.0;
                                    if (a != 0) {}
                                }
                            }
                            ++i;
                            if (a != 0) {
                                break;
                            }
                            continue Label_0179_Outer;
                        }
                        else {
                            if (n2 != 0) {
                                return array4;
                            }
                            m.g();
                            if (a != 0) {
                                break Label_0179_Outer;
                            }
                            continue Label_0179_Outer;
                        }
                    }
                    continue;
                }
            }
            return a2;
        }
        return a2;
    }
    
    protected double a(final f f, final aa aa) {
        final int a = ab.a;
        double n = 0.0;
        ab ab = null;
        final C m = this.a().m();
        while (m.f()) {
            ab = (ab)m.d();
            n += ab.b(f);
            m.g();
            if (a != 0) {
                return n;
            }
            if (a != 0) {
                break;
            }
        }
        if (ab != null) {}
    }
    
    static P a(final R r, final R r2) {
        return new P(Math.max(r2.h(), r.h()), Math.max(r2.i(), r.i()), Math.min(r2.j(), r.j()), Math.min(r2.k(), r.k()));
    }
    
    static y a(final f f, final R r) {
        final R a = f.a();
        final double max = Math.max(a.h(), r.h());
        final double min = Math.min(a.j(), r.j());
        final double max2 = Math.max(a.i(), r.i());
        if (Math.abs(max - min) > 1.0E-6) {
            if (Math.abs(max2 - r.i()) < 1.0E-6) {
                return y.c;
            }
            return y.a;
        }
        else {
            if (Math.abs(max - r.h()) < 1.0E-6) {
                return y.b;
            }
            return y.d;
        }
    }
    
    static U a(final f f, final d d) {
        final int a = ab.a;
        if (f == null) {
            return null;
        }
        final D d2 = new D();
        f b = f;
        while (b != null) {
            d2.a(b);
            b = b.b();
            if (a != 0) {
                break;
            }
        }
        return new U(d, d2, f.f());
    }
}
