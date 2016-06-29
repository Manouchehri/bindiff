/*
 * Decompiled with CFR 0_115.
 */
package y.e;

import java.io.ByteArrayOutputStream;
import java.io.ObjectOutputStream;
import java.io.OutputStream;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import java.util.zip.GZIPOutputStream;
import y.c.C;
import y.c.d;
import y.c.e;
import y.c.q;
import y.c.x;
import y.e.c;
import y.e.i;
import y.g.o;
import y.h.a.v;
import y.h.aB;
import y.h.bV;
import y.h.bu;
import y.h.fj;

public class h
extends c {
    private v v;
    private boolean w;
    protected static Map b = new HashMap();
    protected static Map c = new HashMap();
    private Map x;
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
    static Class r;
    static Class s;
    static Class t;
    static Class u;

    public static void a(String string, String string2) {
        b.put(string, string2);
        c.put(string2, string);
    }

    public static String a(String string) {
        String string2;
        String string3 = (String)c.get(string);
        if (string3 != null) {
            string2 = string3;
            return string2;
        }
        string2 = string;
        return string2;
    }

    public static String b(String string) {
        String string2;
        String string3 = (String)b.get(string);
        if (string3 != null) {
            string2 = string3;
            return string2;
        }
        string2 = string;
        return string2;
    }

    @Override
    public void a(bu bu2, OutputStream outputStream) {
        o.a(this, (Object)"writeOS");
        this.v = v.a(bu2);
        ObjectOutputStream objectOutputStream = this.a(outputStream);
        int n2 = 3;
        if (this.x.size() > 0) {
            n2 = 4;
        }
        objectOutputStream.writeByte(n2);
        objectOutputStream.flush();
        GZIPOutputStream gZIPOutputStream = new GZIPOutputStream(outputStream);
        objectOutputStream = this.a(gZIPOutputStream);
        this.b(bu2, objectOutputStream);
        if (n2 > 3) {
            this.a(bu2, objectOutputStream);
        }
        objectOutputStream.flush();
        gZIPOutputStream.flush();
        gZIPOutputStream.finish();
    }

    void a(bu bu2, ObjectOutputStream objectOutputStream) {
        int n2 = c.a;
        objectOutputStream.writeInt(305419896);
        objectOutputStream.writeInt(this.x.size());
        Iterator iterator = this.x.entrySet().iterator();
        do {
            if (!iterator.hasNext()) return;
            Map.Entry entry = iterator.next();
            objectOutputStream.writeObject(entry.getKey());
            this.a(bu2, (i)entry.getValue(), objectOutputStream);
        } while (n2 == 0);
    }

    void a(bu bu2, i i2, ObjectOutputStream objectOutputStream) {
        int n2 = c.a;
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        ObjectOutputStream objectOutputStream2 = new ObjectOutputStream(byteArrayOutputStream);
        i2.a(bu2, bu2, objectOutputStream2);
        v v2 = bu2.C();
        C c2 = bu2.o();
        while (c2.f()) {
            q q2 = c2.e();
            i2.a(bu2, q2, objectOutputStream2);
            if (v2 != null && v2.j(q2)) {
                this.a((bu)v2.m(q2), i2, objectOutputStream2);
            }
            c2.g();
            if (n2 == 0) continue;
        }
        c2 = bu2.p();
        while (c2.f()) {
            d d2 = c2.a();
            i2.a(bu2, d2, objectOutputStream2);
            c2.g();
            if (n2 != 0) return;
            if (n2 == 0) continue;
        }
        objectOutputStream2.flush();
        objectOutputStream2.close();
        byteArrayOutputStream.flush();
        objectOutputStream.writeInt(byteArrayOutputStream.size());
        byteArrayOutputStream.writeTo(objectOutputStream);
    }

    protected void b(bu bu2, ObjectOutputStream objectOutputStream) {
        int n2;
        C c2;
        block6 : {
            block5 : {
                n2 = c.a;
                o.a(this, (Object)"writeOOS");
                objectOutputStream.writeByte(2);
                if (this.v != null) {
                    this.w = this.v.f();
                    if (n2 == 0) break block5;
                }
                this.w = false;
            }
            boolean bl2 = this.v != null;
            objectOutputStream.writeBoolean(this.w);
            objectOutputStream.writeBoolean(bl2);
            objectOutputStream.writeInt(bu2.f());
            c2 = bu2.o();
            while (c2.f()) {
                this.a(bu2, c2.e(), objectOutputStream);
                c2.g();
                if (n2 == 0) {
                    if (n2 == 0) continue;
                }
                break block6;
            }
            objectOutputStream.writeInt(bu2.h());
        }
        c2 = bu2.p();
        do {
            if (!c2.f()) return;
            d d2 = c2.a();
            objectOutputStream.writeInt(d2.c().d());
            objectOutputStream.writeInt(d2.d().d());
            this.a(bu2, d2, objectOutputStream);
            c2.g();
        } while (n2 == 0);
    }

    protected void a(bu bu2, d d2, ObjectOutputStream objectOutputStream) {
        objectOutputStream.writeByte(1);
        this.b(bu2, d2, objectOutputStream);
        this.c(bu2, d2, objectOutputStream);
    }

    protected void b(bu bu2, d d2, ObjectOutputStream objectOutputStream) {
        aB aB2 = bu2.i(d2);
        objectOutputStream.writeObject(h.a(aB2.getClass().getName()));
        aB2.write(objectOutputStream);
    }

    protected void c(bu bu2, d d2, ObjectOutputStream objectOutputStream) {
        int n2 = c.a;
        if (this.v == null) {
            return;
        }
        if (this.v.e(d2)) {
            Object object;
            block12 : {
                objectOutputStream.writeBoolean(true);
                q q2 = this.v.b(d2);
                if (q2 != d2.c()) {
                    block11 : {
                        int n3;
                        objectOutputStream.writeBoolean(true);
                        object = this.v.a((Object)q2);
                        for (n3 = 1; n3 < object.length && object[n3] != d2.c(); ++n3) {
                            if (n2 == 0) continue;
                        }
                        objectOutputStream.writeInt(object.length - n3);
                        ++n3;
                        while (n3 < object.length) {
                            objectOutputStream.writeInt(((q)object[n3]).d());
                            ++n3;
                            if (n2 == 0) {
                                if (n2 == 0) continue;
                            }
                            break block11;
                        }
                        objectOutputStream.writeInt(q2.d());
                    }
                    if (n2 == 0) break block12;
                }
                objectOutputStream.writeBoolean(false);
            }
            if ((object = this.v.c(d2)) != d2.d()) {
                block13 : {
                    int n4;
                    objectOutputStream.writeBoolean(true);
                    Object[] arrobject = this.v.a(object);
                    for (n4 = 1; n4 < arrobject.length && arrobject[n4] != d2.d(); ++n4) {
                        if (n2 == 0) continue;
                    }
                    objectOutputStream.writeInt(arrobject.length - n4);
                    ++n4;
                    while (n4 < arrobject.length) {
                        objectOutputStream.writeInt(((q)arrobject[n4]).d());
                        ++n4;
                        if (n2 == 0) {
                            if (n2 == 0) continue;
                        }
                        break block13;
                    }
                    objectOutputStream.writeInt(object.d());
                }
                if (n2 == 0) return;
            }
            objectOutputStream.writeBoolean(false);
            if (n2 == 0) return;
        }
        objectOutputStream.writeBoolean(false);
    }

    protected void a(bu bu2, q q2, ObjectOutputStream objectOutputStream) {
        objectOutputStream.writeByte(2);
        this.b(bu2, q2, objectOutputStream);
        this.c(bu2, q2, objectOutputStream);
        this.d(bu2, q2, objectOutputStream);
    }

    protected void b(bu bu2, q q2, ObjectOutputStream objectOutputStream) {
        fj fj2 = bu2.t(q2);
        objectOutputStream.writeObject(h.a(fj2.getClass().getName()));
        fj2.write(objectOutputStream);
        if (!(fj2 instanceof bV)) return;
        if (this.v != null) return;
        this.b(((bV)fj2).g(), objectOutputStream);
    }

    protected void c(bu bu2, q q2, ObjectOutputStream objectOutputStream) {
        if (this.v == null) {
            return;
        }
        if (this.v.j(q2)) {
            objectOutputStream.writeBoolean(true);
            this.b((bu)this.v.m(q2), objectOutputStream);
            if (c.a == 0) return;
        }
        objectOutputStream.writeBoolean(false);
    }

    protected void d(bu bu2, q q2, ObjectOutputStream objectOutputStream) {
        if (this.v == null) return;
        if (!this.w) {
            return;
        }
        objectOutputStream.writeBoolean(this.v.k(q2));
        q q3 = this.v.n(q2);
        if (q3 != null && this.v.k(q3)) {
            objectOutputStream.writeInt(q3.d());
            if (c.a == 0) return;
        }
        objectOutputStream.writeInt(-1);
    }

    protected ObjectOutputStream a(OutputStream outputStream) {
        return new ObjectOutputStream(outputStream);
    }

    static Class c(String string) {
        try {
            return Class.forName(string);
        }
        catch (ClassNotFoundException var1_1) {
            throw new NoClassDefFoundError(var1_1.getMessage());
        }
    }

    static {
        StringBuffer stringBuffer = new StringBuffer("y.view.");
        Class class_ = d == null ? (h.d = h.c("y.h.gn")) : d;
        h.a(new StringBuffer().append(stringBuffer.toString()).append("ShapeNodeRealizer").toString(), class_.getName());
        Class class_2 = e == null ? (h.e = h.c("y.h.df")) : e;
        h.a(new StringBuffer().append(stringBuffer.toString()).append("ImageNodeRealizer").toString(), class_2.getName());
        Class class_3 = f == null ? (h.f = h.c("y.h.bV")) : f;
        h.a(new StringBuffer().append(stringBuffer.toString()).append("Graph2DNodeRealizer").toString(), class_3.getName());
        Class class_4 = g == null ? (h.g = h.c("y.h.aZ")) : g;
        h.a(new StringBuffer().append(stringBuffer.toString()).append("GenericNodeRealizer").toString(), class_4.getName());
        Class class_5 = h == null ? (h.h = h.c("y.h.a.e")) : h;
        h.a(new StringBuffer().append(stringBuffer.toString()).append("GenericGroupNodeRealizer").toString(), class_5.getName());
        Class class_6 = i == null ? (h.i = h.c("y.h.b.a")) : i;
        h.a(new StringBuffer().append(stringBuffer.toString()).append("tabular.TableGroupNodeRealizer").toString(), class_6.getName());
        Class class_7 = j == null ? (h.j = h.c("y.h.a.p")) : j;
        h.a(new StringBuffer().append(stringBuffer.toString()).append("hierarchy.GroupNodeRealizer").toString(), class_7.getName());
        Class class_8 = k == null ? (h.k = h.c("y.h.gd")) : k;
        h.a(new StringBuffer().append(stringBuffer.toString()).append("ProxyShapeNodeRealizer").toString(), class_8.getName());
        Class class_9 = l == null ? (h.l = h.c("y.h.a.L")) : l;
        h.a(new StringBuffer().append(stringBuffer.toString()).append("hierarchy.ProxyAutoBoundsNodeRealizer").toString(), class_9.getName());
        Class class_10 = m == null ? (h.m = h.c("y.h.fJ")) : m;
        h.a(new StringBuffer().append(stringBuffer.toString()).append("PolyLineEdgeRealizer").toString(), class_10.getName());
        Class class_11 = n == null ? (h.n = h.c("y.h.ge")) : n;
        h.a(new StringBuffer().append(stringBuffer.toString()).append("QuadCurveEdgeRealizer").toString(), class_11.getName());
        Class class_12 = o == null ? (h.o = h.c("y.h.aF")) : o;
        h.a(new StringBuffer().append(stringBuffer.toString()).append("GenericEdgeRealizer").toString(), class_12.getName());
        Class class_13 = p == null ? (h.p = h.c("y.h.g")) : p;
        h.a(new StringBuffer().append(stringBuffer.toString()).append("ArcEdgeRealizer").toString(), class_13.getName());
        Class class_14 = q == null ? (h.q = h.c("y.h.B")) : q;
        h.a(new StringBuffer().append(stringBuffer.toString()).append("BezierEdgeRealizer").toString(), class_14.getName());
        Class class_15 = r == null ? (h.r = h.c("y.h.gD")) : r;
        h.a(new StringBuffer().append(stringBuffer.toString()).append("SplineEdgeRealizer").toString(), class_15.getName());
        Class class_16 = s == null ? (h.s = h.c("y.h.fL")) : s;
        h.a(new StringBuffer().append(stringBuffer.toString()).append("Port").toString(), class_16.getName());
        Class class_17 = t == null ? (h.t = h.c("y.h.dg")) : t;
        h.a(new StringBuffer().append(stringBuffer.toString()).append("InterfacePort").toString(), class_17.getName());
        Class class_18 = u == null ? (h.u = h.c("y.h.b.Z")) : u;
        h.a(new StringBuffer().append(stringBuffer.toString()).append("tabular.TableStyle.SimpleStyle").toString(), class_18.getName());
        stringBuffer.setLength(0);
        stringBuffer.append("demo.uml.");
        h.a(new StringBuffer().append(stringBuffer.toString()).append("ClassNodeRealizer").toString(), "demo.uml.ClassNodeRealizer");
        h.a(new StringBuffer().append(stringBuffer.toString()).append("NoteNodeRealizer").toString(), "demo.uml.NoteNodeRealizer");
        b.put(new StringBuffer().append(stringBuffer.toString()).append("UMLClassNodeRealizer").toString(), "demo.uml.ClassNodeRealizer");
        b.put(new StringBuffer().append(stringBuffer.toString()).append("UMLNoteNodeRealizer").toString(), "demo.uml.NoteNodeRealizer");
    }
}

