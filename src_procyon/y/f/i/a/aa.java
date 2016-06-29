package y.f.i.a;

import y.d.*;
import y.c.*;
import java.util.*;

public class aa
{
    private final V a;
    private final Z b;
    private final double c;
    private final ac d;
    private f e;
    private d f;
    private Set g;
    private Set h;
    private List i;
    private List j;
    private R k;
    private R l;
    private x m;
    private long n;
    private long o;
    
    protected aa(final V a, final Z b) {
        this.a = a;
        this.b = b;
        final y b2 = b.c().r().b();
        this.c = b2.a() + b2.b();
        this.d = new ac(b);
    }
    
    public V a() {
        return this.a;
    }
    
    public e b() {
        return this.e.a();
    }
    
    protected void a(final f e) {
        this.e = e;
    }
    
    public d c() {
        return this.f;
    }
    
    protected void a(final d f) {
        this.f = f;
        this.i = this.b.c().r().a(f.c());
        this.g = new HashSet(this.i);
        this.k = null;
        this.j = this.b.c().r().a(f.d());
        this.h = new HashSet(this.j);
        this.l = null;
        this.m = this.b.c().a(f);
    }
    
    public x d() {
        return this.m;
    }
    
    public int e() {
        return this.i.size();
    }
    
    public void a(final R r) {
        if (this.g.add(r)) {
            this.i.add(r);
            this.k = null;
        }
    }
    
    public R a(final int n) {
        return this.i.get(n);
    }
    
    public boolean b(final R r) {
        return this.g.contains(r);
    }
    
    public R f() {
        if (this.k == null) {
            this.k = this.a(this.i);
        }
        return this.k;
    }
    
    public void c(final R r) {
        if (this.h.add(r)) {
            this.j.add(r);
            this.l = null;
        }
    }
    
    public R b(final int n) {
        return this.j.get(n);
    }
    
    public boolean d(final R r) {
        return this.h.contains(r);
    }
    
    public R g() {
        if (this.l == null) {
            this.l = this.a(this.j);
        }
        return this.l;
    }
    
    private R a(final List list) {
        final int a = ab.a;
        double min = Double.MAX_VALUE;
        double min2 = Double.MAX_VALUE;
        double max = -1.7976931348623157E308;
        double max2 = -1.7976931348623157E308;
        final Iterator<R> iterator = list.iterator();
        R r = null;
        while (iterator.hasNext()) {
            r = iterator.next();
            if (a != 0) {
                return r;
            }
            final R r2 = r;
            min = Math.min(min, r2.h());
            max = Math.max(max, r2.j());
            min2 = Math.min(min2, r2.i());
            max2 = Math.max(max2, r2.k());
            if (a != 0) {
                break;
            }
        }
        final R r3 = new R(min, min2, max - min, max2 - min2, null);
        return r;
    }
    
    double h() {
        return this.c;
    }
    
    public ac i() {
        return this.d;
    }
    
    void a(final long n) {
        this.n = n;
    }
    
    long j() {
        return this.n;
    }
    
    void b(final long o) {
        this.o = o;
    }
    
    long k() {
        return this.o;
    }
}
