package y.h;

import java.util.*;
import y.h.a.*;

public final class be
{
    private final bc c;
    Map a;
    Set b;
    
    private be() {
        this.c = new bc("DEFAULT");
        this.a = new HashMap();
        this.b = Collections.unmodifiableSet(this.a.keySet());
    }
    
    public Map a() {
        return new HashMap();
    }
    
    public void a(final String s, final Map map) {
        final bc bc = new bc(s);
        bc.e = map.get((aZ.e == null) ? (aZ.e = aZ.e("y.h.bo")) : aZ.e);
        bc.b = (bf)map.get((aZ.f == null) ? (aZ.f = aZ.e("y.h.bf")) : aZ.f);
        bc.f = (bh)map.get((aZ.g == null) ? (aZ.g = aZ.e("y.h.bh")) : aZ.g);
        bc.g = (bi)map.get((aZ.h == null) ? (aZ.h = aZ.e("y.h.bi")) : aZ.h);
        bc.i = (bd)map.get((aZ.i == null) ? (aZ.i = aZ.e("y.h.bd")) : aZ.i);
        bc.h = (bk)map.get((aZ.k == null) ? (aZ.k = aZ.e("y.h.bk")) : aZ.k);
        bc.j = (bs)map.get((aZ.l == null) ? (aZ.l = aZ.e("y.h.bs")) : aZ.l);
        bc.d = (br)map.get((aZ.m == null) ? (aZ.m = aZ.e("y.h.br")) : aZ.m);
        bc.k = (bb)map.get((aZ.n == null) ? (aZ.n = aZ.e("y.h.bb")) : aZ.n);
        bc.l = (bl)map.get((aZ.o == null) ? (aZ.o = aZ.e("y.h.bl")) : aZ.o);
        bc.c = (bp)map.get((aZ.p == null) ? (aZ.p = aZ.e("y.h.bp")) : aZ.p);
        bc.m = (f)map.get((aZ.q == null) ? (aZ.q = aZ.e("y.h.a.f")) : aZ.q);
        bc.n = (bg)map.get((aZ.r == null) ? (aZ.r = aZ.e("y.h.bg")) : aZ.r);
        bc.o = (bj)map.get((aZ.s == null) ? (aZ.s = aZ.e("y.h.bj")) : aZ.s);
        bc.p = (bq)map.get((aZ.t == null) ? (aZ.t = aZ.e("y.h.bq")) : aZ.t);
        bc.q = (bn)map.get((aZ.u == null) ? (aZ.u = aZ.e("y.h.bn")) : aZ.u);
        bc.r = (bm)map.get((aZ.v == null) ? (aZ.v = aZ.e("y.h.bm")) : aZ.v);
        this.a.put(s, bc);
    }
    
    public Object a(final String s, final Class clazz) {
        final bc bc = this.a.get(s);
        if (bc != null) {
            if (clazz == ((aZ.e == null) ? (aZ.e = aZ.e("y.h.bo")) : aZ.e)) {
                return bc.e;
            }
            if (clazz == ((aZ.f == null) ? (aZ.f = aZ.e("y.h.bf")) : aZ.f)) {
                return bc.b;
            }
            if (clazz == ((aZ.g == null) ? (aZ.g = aZ.e("y.h.bh")) : aZ.g)) {
                return bc.f;
            }
            if (clazz == ((aZ.h == null) ? (aZ.h = aZ.e("y.h.bi")) : aZ.h)) {
                return bc.g;
            }
            if (clazz == ((aZ.i == null) ? (aZ.i = aZ.e("y.h.bd")) : aZ.i)) {
                return bc.i;
            }
            if (clazz == ((aZ.k == null) ? (aZ.k = aZ.e("y.h.bk")) : aZ.k)) {
                return bc.h;
            }
            if (clazz == ((aZ.l == null) ? (aZ.l = aZ.e("y.h.bs")) : aZ.l)) {
                return bc.j;
            }
            if (clazz == ((aZ.m == null) ? (aZ.m = aZ.e("y.h.br")) : aZ.m)) {
                return bc.d;
            }
            if (clazz == ((aZ.n == null) ? (aZ.n = aZ.e("y.h.bb")) : aZ.n)) {
                return bc.k;
            }
            if (clazz == ((aZ.o == null) ? (aZ.o = aZ.e("y.h.bl")) : aZ.o)) {
                return bc.l;
            }
            if (clazz == ((aZ.p == null) ? (aZ.p = aZ.e("y.h.bp")) : aZ.p)) {
                return bc.c;
            }
            if (clazz == ((aZ.q == null) ? (aZ.q = aZ.e("y.h.a.f")) : aZ.q)) {
                return bc.m;
            }
            if (clazz == ((aZ.r == null) ? (aZ.r = aZ.e("y.h.bg")) : aZ.r)) {
                return bc.n;
            }
            if (clazz == ((aZ.s == null) ? (aZ.s = aZ.e("y.h.bj")) : aZ.s)) {
                return bc.o;
            }
            if (clazz == ((aZ.t == null) ? (aZ.t = aZ.e("y.h.bq")) : aZ.t)) {
                return bc.p;
            }
            if (clazz == ((aZ.u == null) ? (aZ.u = aZ.e("y.h.bn")) : aZ.u)) {
                return bc.q;
            }
            if (clazz == ((aZ.v == null) ? (aZ.v = aZ.e("y.h.bm")) : aZ.v)) {
                return bc.r;
            }
        }
        return null;
    }
    
    bc b() {
        return this.c;
    }
    
    bc a(final String s) {
        final bc bc = this.a.get(s);
        if (bc == null) {
            throw new IllegalArgumentException("Given configuration for GenericNodeRealizer does not exist: \"" + s + "\"");
        }
        return bc;
    }
    
    public void a(final aZ az, final String s) {
        final bc a = this.a(s);
        if (az.a != a) {
            az.a = a;
            a(az);
        }
    }
    
    public Set c() {
        return this.b;
    }
    
    static void a(final aZ az) {
        final bj o = az.a.o;
        if (o != null) {
            o.a(az);
        }
        az.invalidatePortPositions();
        az.setEdgesDirty();
    }
    
    be(final ba ba) {
        this();
    }
}
