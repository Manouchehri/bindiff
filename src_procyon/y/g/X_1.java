package y.g;

import java.util.*;

public class X implements ag
{
    private static X r;
    private Map s;
    static Class a;
    static Class b;
    static Class c;
    static Class d;
    static Class e;
    static Class f;
    static Class g;
    static Class h;
    static Class i;
    static Class j;
    static Class k;
    static Class l;
    static Class m;
    static Class n;
    static Class o;
    static Class p;
    static Class q;
    
    protected X() {
        this.s = new HashMap();
    }
    
    protected void a() {
        this.a((X.a == null) ? (X.a = a("java.lang.Integer")) : X.a, new ah((X.a == null) ? (X.a = a("java.lang.Integer")) : X.a, (X.a == null) ? (X.a = a("java.lang.Integer")) : X.a));
        this.a((X.b == null) ? (X.b = a("java.lang.Float")) : X.b, new ah((X.b == null) ? (X.b = a("java.lang.Float")) : X.b, (X.b == null) ? (X.b = a("java.lang.Float")) : X.b));
        this.a((X.c == null) ? (X.c = a("java.lang.Double")) : X.c, new ah((X.c == null) ? (X.c = a("java.lang.Double")) : X.c, (X.c == null) ? (X.c = a("java.lang.Double")) : X.c));
        this.a((X.d == null) ? (X.d = a("java.lang.Byte")) : X.d, new ah((X.d == null) ? (X.d = a("java.lang.Byte")) : X.d, (X.d == null) ? (X.d = a("java.lang.Byte")) : X.d));
        this.a((X.e == null) ? (X.e = a("java.lang.Short")) : X.e, new ah((X.e == null) ? (X.e = a("java.lang.Short")) : X.e, (X.e == null) ? (X.e = a("java.lang.Short")) : X.e));
        this.a((X.f == null) ? (X.f = a("java.lang.Boolean")) : X.f, new ah((X.f == null) ? (X.f = a("java.lang.Boolean")) : X.f, (X.f == null) ? (X.f = a("java.lang.Boolean")) : X.f));
        this.a((X.g == null) ? (X.g = a("java.lang.Long")) : X.g, new ah((X.g == null) ? (X.g = a("java.lang.Long")) : X.g, (X.g == null) ? (X.g = a("java.lang.Long")) : X.g));
        this.a(Integer.TYPE, new ah((X.a == null) ? (X.a = a("java.lang.Integer")) : X.a, Integer.TYPE));
        this.a(Float.TYPE, new ah((X.b == null) ? (X.b = a("java.lang.Float")) : X.b, Float.TYPE));
        this.a(Double.TYPE, new ah((X.c == null) ? (X.c = a("java.lang.Double")) : X.c, Double.TYPE));
        this.a(Byte.TYPE, new ah((X.d == null) ? (X.d = a("java.lang.Byte")) : X.d, Byte.TYPE));
        this.a(Short.TYPE, new ah((X.e == null) ? (X.e = a("java.lang.Short")) : X.e, Short.TYPE));
        this.a(Boolean.TYPE, new ah((X.f == null) ? (X.f = a("java.lang.Boolean")) : X.f, Boolean.TYPE));
        this.a(Long.TYPE, new ah((X.g == null) ? (X.g = a("java.lang.Long")) : X.g, Long.TYPE));
        this.a((X.h == null) ? (X.h = a("java.lang.String")) : X.h, new Z());
        this.a((X.i == null) ? (X.i = a("java.awt.Color")) : X.i, new ae());
        this.a((X.j == null) ? (X.j = a("java.io.File")) : X.j, new ah((X.j == null) ? (X.j = a("java.io.File")) : X.j));
        this.a((X.k == null) ? (X.k = a("java.util.Date")) : X.k, new ah((X.k == null) ? (X.k = a("java.util.Date")) : X.k));
        this.a((X.l == null) ? (X.l = a("java.awt.Font")) : X.l, new aa());
        this.a((X.m == null) ? (X.m = a("java.net.URL")) : X.m, new af());
        this.a((X.n == null) ? (X.n = a("java.awt.geom.Rectangle2D")) : X.n, new ab());
        this.a((X.o == null) ? (X.o = a("java.awt.geom.Point2D")) : X.o, new Y());
        this.a((X.p == null) ? (X.p = a("java.lang.Class")) : X.p, new ac());
        this.a((X.q == null) ? (X.q = a("java.util.Locale")) : X.q, new ad());
    }
    
    public void a(final Class clazz, final ag ag) {
        this.s.put(clazz, ag);
    }
    
    public static X b() {
        return X.r;
    }
    
    public Object a(final String s, final Class clazz) {
        if (s == null) {
            return null;
        }
        final ag a = this.a(clazz);
        if (a == null) {
            throw new IllegalArgumentException("No suitable objectStringConverter found for " + s + " [" + clazz + "]");
        }
        return a.a(s, clazz);
    }
    
    public String a(final Object o, final Class clazz) {
        if (o == null) {
            return null;
        }
        final ag a = this.a(clazz);
        if (a == null) {
            throw new IllegalArgumentException("No suitable objectStringConverter found for " + o + " [" + clazz + "]");
        }
        return a.a(o, clazz);
    }
    
    public ag a(final Class clazz) {
        final ag ag = this.s.get(clazz);
        if (ag == null) {
            for (final Map.Entry<Class, V> entry : this.s.entrySet()) {
                if (((Class)entry.getKey()).isAssignableFrom(clazz)) {
                    return entry.getValue();
                }
            }
            return null;
        }
        return ag;
    }
    
    static Class a(final String s) {
        try {
            return Class.forName(s);
        }
        catch (ClassNotFoundException ex) {
            throw new NoClassDefFoundError(ex.getMessage());
        }
    }
    
    static {
        final X r = new X();
        r.a();
        X.r = r;
    }
}
