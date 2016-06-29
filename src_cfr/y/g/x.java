/*
 * Decompiled with CFR 0_115.
 */
package y.g;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import y.g.Y;
import y.g.Z;
import y.g.aa;
import y.g.ab;
import y.g.ac;
import y.g.ad;
import y.g.ae;
import y.g.af;
import y.g.ag;
import y.g.ah;

public class X
implements ag {
    private static X r;
    private Map s = new HashMap();
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
    }

    protected void a() {
        Class class_ = a == null ? (X.a = X.a("java.lang.Integer")) : a;
        this.a(class_, new ah(a == null ? (X.a = X.a("java.lang.Integer")) : a, a == null ? (X.a = X.a("java.lang.Integer")) : a));
        Class class_2 = b == null ? (X.b = X.a("java.lang.Float")) : b;
        this.a(class_2, new ah(b == null ? (X.b = X.a("java.lang.Float")) : b, b == null ? (X.b = X.a("java.lang.Float")) : b));
        Class class_3 = c == null ? (X.c = X.a("java.lang.Double")) : c;
        this.a(class_3, new ah(c == null ? (X.c = X.a("java.lang.Double")) : c, c == null ? (X.c = X.a("java.lang.Double")) : c));
        Class class_4 = d == null ? (X.d = X.a("java.lang.Byte")) : d;
        this.a(class_4, new ah(d == null ? (X.d = X.a("java.lang.Byte")) : d, d == null ? (X.d = X.a("java.lang.Byte")) : d));
        Class class_5 = e == null ? (X.e = X.a("java.lang.Short")) : e;
        this.a(class_5, new ah(e == null ? (X.e = X.a("java.lang.Short")) : e, e == null ? (X.e = X.a("java.lang.Short")) : e));
        Class class_6 = f == null ? (X.f = X.a("java.lang.Boolean")) : f;
        this.a(class_6, new ah(f == null ? (X.f = X.a("java.lang.Boolean")) : f, f == null ? (X.f = X.a("java.lang.Boolean")) : f));
        Class class_7 = g == null ? (X.g = X.a("java.lang.Long")) : g;
        this.a(class_7, new ah(g == null ? (X.g = X.a("java.lang.Long")) : g, g == null ? (X.g = X.a("java.lang.Long")) : g));
        this.a(Integer.TYPE, new ah(a == null ? (X.a = X.a("java.lang.Integer")) : a, Integer.TYPE));
        this.a(Float.TYPE, new ah(b == null ? (X.b = X.a("java.lang.Float")) : b, Float.TYPE));
        this.a(Double.TYPE, new ah(c == null ? (X.c = X.a("java.lang.Double")) : c, Double.TYPE));
        this.a(Byte.TYPE, new ah(d == null ? (X.d = X.a("java.lang.Byte")) : d, Byte.TYPE));
        this.a(Short.TYPE, new ah(e == null ? (X.e = X.a("java.lang.Short")) : e, Short.TYPE));
        this.a(Boolean.TYPE, new ah(f == null ? (X.f = X.a("java.lang.Boolean")) : f, Boolean.TYPE));
        this.a(Long.TYPE, new ah(g == null ? (X.g = X.a("java.lang.Long")) : g, Long.TYPE));
        Class class_8 = h == null ? (X.h = X.a("java.lang.String")) : h;
        this.a(class_8, new Z());
        Class class_9 = i == null ? (X.i = X.a("java.awt.Color")) : i;
        this.a(class_9, new ae());
        Class class_10 = j == null ? (X.j = X.a("java.io.File")) : j;
        this.a(class_10, new ah(j == null ? (X.j = X.a("java.io.File")) : j));
        Class class_11 = k == null ? (X.k = X.a("java.util.Date")) : k;
        this.a(class_11, new ah(k == null ? (X.k = X.a("java.util.Date")) : k));
        Class class_12 = l == null ? (X.l = X.a("java.awt.Font")) : l;
        this.a(class_12, new aa());
        Class class_13 = m == null ? (X.m = X.a("java.net.URL")) : m;
        this.a(class_13, new af());
        Class class_14 = n == null ? (X.n = X.a("java.awt.geom.Rectangle2D")) : n;
        this.a(class_14, new ab());
        Class class_15 = o == null ? (X.o = X.a("java.awt.geom.Point2D")) : o;
        this.a(class_15, new Y());
        Class class_16 = p == null ? (X.p = X.a("java.lang.Class")) : p;
        this.a(class_16, new ac());
        Class class_17 = q == null ? (X.q = X.a("java.util.Locale")) : q;
        this.a(class_17, new ad());
    }

    public void a(Class class_, ag ag2) {
        this.s.put(class_, ag2);
    }

    public static X b() {
        return r;
    }

    @Override
    public Object a(String string, Class class_) {
        if (string == null) {
            return null;
        }
        ag ag2 = this.a(class_);
        if (ag2 != null) return ag2.a(string, class_);
        throw new IllegalArgumentException(new StringBuffer().append("No suitable objectStringConverter found for ").append(string).append(" [").append(class_).append("]").toString());
    }

    @Override
    public String a(Object object, Class class_) {
        if (object == null) {
            return null;
        }
        ag ag2 = this.a(class_);
        if (ag2 != null) return ag2.a(object, class_);
        throw new IllegalArgumentException(new StringBuffer().append("No suitable objectStringConverter found for ").append(object).append(" [").append(class_).append("]").toString());
    }

    public ag a(Class class_) {
        Class class_2;
        Map.Entry entry;
        ag ag2 = (ag)this.s.get(class_);
        if (ag2 != null) return ag2;
        Iterator iterator = this.s.entrySet().iterator();
        do {
            if (!iterator.hasNext()) return null;
        } while (!(class_2 = (Class)(entry = iterator.next()).getKey()).isAssignableFrom(class_));
        return (ag)entry.getValue();
    }

    static Class a(String string) {
        try {
            return Class.forName(string);
        }
        catch (ClassNotFoundException var1_1) {
            throw new NoClassDefFoundError(var1_1.getMessage());
        }
    }

    static {
        X x2 = new X();
        x2.a();
        r = x2;
    }
}

