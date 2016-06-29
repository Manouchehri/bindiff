package y.e;

import y.h.a.*;
import y.g.*;
import java.util.zip.*;
import java.io.*;
import y.c.*;
import y.h.*;
import java.util.*;

public class h extends c
{
    private v v;
    private boolean w;
    protected static Map b;
    protected static Map c;
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
    
    public static void a(final String s, final String s2) {
        y.e.h.b.put(s, s2);
        y.e.h.c.put(s2, s);
    }
    
    public static String a(final String s) {
        final String s2 = y.e.h.c.get(s);
        return (s2 != null) ? s2 : s;
    }
    
    public static String b(final String s) {
        final String s2 = y.e.h.b.get(s);
        return (s2 != null) ? s2 : s;
    }
    
    public void a(final bu bu, final OutputStream outputStream) {
        y.g.o.a(this, "writeOS");
        this.v = y.h.a.v.a(bu);
        final ObjectOutputStream a = this.a(outputStream);
        int n = 3;
        if (this.x.size() > 0) {
            n = 4;
        }
        a.writeByte(n);
        a.flush();
        final GZIPOutputStream gzipOutputStream = new GZIPOutputStream(outputStream);
        final ObjectOutputStream a2 = this.a(gzipOutputStream);
        this.b(bu, a2);
        if (n > 3) {
            this.a(bu, a2);
        }
        a2.flush();
        gzipOutputStream.flush();
        gzipOutputStream.finish();
    }
    
    void a(final bu bu, final ObjectOutputStream objectOutputStream) {
        final int a = y.e.c.a;
        objectOutputStream.writeInt(305419896);
        objectOutputStream.writeInt(this.x.size());
        for (final Map.Entry<Object, V> entry : this.x.entrySet()) {
            objectOutputStream.writeObject(entry.getKey());
            this.a(bu, (y.e.i)entry.getValue(), objectOutputStream);
            if (a != 0) {
                break;
            }
        }
    }
    
    void a(final bu bu, final y.e.i i, final ObjectOutputStream objectOutputStream) {
        final int a = y.e.c.a;
        final ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        final ObjectOutputStream objectOutputStream2 = new ObjectOutputStream(byteArrayOutputStream);
        i.a(bu, bu, objectOutputStream2);
        final v c = bu.C();
        final x o = bu.o();
        while (o.f()) {
            final q e = o.e();
            i.a(bu, e, objectOutputStream2);
            if (c != null && c.j(e)) {
                this.a((bu)c.m(e), i, objectOutputStream2);
            }
            o.g();
            if (a != 0) {
                break;
            }
        }
        final e p3 = bu.p();
        while (p3.f()) {
            i.a(bu, p3.a(), objectOutputStream2);
            p3.g();
            if (a != 0) {
                return;
            }
            if (a != 0) {
                break;
            }
        }
        objectOutputStream2.flush();
        objectOutputStream2.close();
        byteArrayOutputStream.flush();
        objectOutputStream.writeInt(byteArrayOutputStream.size());
        byteArrayOutputStream.writeTo(objectOutputStream);
    }
    
    protected void b(final bu bu, final ObjectOutputStream objectOutputStream) {
        final int a = y.e.c.a;
        y.g.o.a(this, "writeOOS");
        objectOutputStream.writeByte(2);
        Label_0044: {
            if (this.v != null) {
                this.w = this.v.f();
                if (a == 0) {
                    break Label_0044;
                }
            }
            this.w = false;
        }
        final boolean b = this.v != null;
        objectOutputStream.writeBoolean(this.w);
        objectOutputStream.writeBoolean(b);
        objectOutputStream.writeInt(bu.f());
        final x o = bu.o();
        while (true) {
            while (o.f()) {
                this.a(bu, o.e(), objectOutputStream);
                o.g();
                if (a != 0) {
                    final e p2 = bu.p();
                    while (p2.f()) {
                        final d a2 = p2.a();
                        objectOutputStream.writeInt(a2.c().d());
                        objectOutputStream.writeInt(a2.d().d());
                        this.a(bu, a2, objectOutputStream);
                        p2.g();
                        if (a != 0) {
                            break;
                        }
                    }
                    return;
                }
                if (a != 0) {
                    break;
                }
            }
            objectOutputStream.writeInt(bu.h());
            continue;
        }
    }
    
    protected void a(final bu bu, final d d, final ObjectOutputStream objectOutputStream) {
        objectOutputStream.writeByte(1);
        this.b(bu, d, objectOutputStream);
        this.c(bu, d, objectOutputStream);
    }
    
    protected void b(final bu bu, final d d, final ObjectOutputStream objectOutputStream) {
        final aB i = bu.i(d);
        objectOutputStream.writeObject(a(i.getClass().getName()));
        i.write(objectOutputStream);
    }
    
    protected void c(final bu bu, final d d, final ObjectOutputStream objectOutputStream) {
        final int a = y.e.c.a;
        if (this.v == null) {
            return;
        }
        if (this.v.e(d)) {
            objectOutputStream.writeBoolean(true);
            final q b = this.v.b(d);
            Label_0163: {
                Label_0158: {
                    if (b != d.c()) {
                        objectOutputStream.writeBoolean(true);
                        final Object[] a2 = this.v.a((Object)b);
                        int i = 1;
                        while (i < a2.length && a2[i] != d.c()) {
                            ++i;
                            if (a != 0) {
                                break;
                            }
                        }
                        objectOutputStream.writeInt(a2.length - i);
                        ++i;
                        while (true) {
                            while (i < a2.length) {
                                objectOutputStream.writeInt(((q)a2[i]).d());
                                ++i;
                                if (a == 0) {
                                    if (a != 0) {
                                        break;
                                    }
                                    continue;
                                }
                                else {
                                    if (a != 0) {
                                        break Label_0158;
                                    }
                                    break Label_0163;
                                }
                            }
                            objectOutputStream.writeInt(b.d());
                            continue;
                        }
                    }
                }
                objectOutputStream.writeBoolean(false);
            }
            final q c = this.v.c(d);
            Label_0292: {
                if (c != d.d()) {
                    objectOutputStream.writeBoolean(true);
                    final Object[] a3 = this.v.a((Object)c);
                    int j = 1;
                    while (j < a3.length && a3[j] != d.d()) {
                        ++j;
                        if (a != 0) {
                            break;
                        }
                    }
                    objectOutputStream.writeInt(a3.length - j);
                    ++j;
                    while (true) {
                        while (j < a3.length) {
                            objectOutputStream.writeInt(((q)a3[j]).d());
                            ++j;
                            if (a == 0) {
                                if (a != 0) {
                                    break;
                                }
                                continue;
                            }
                            else {
                                if (a != 0) {
                                    break Label_0292;
                                }
                                return;
                            }
                        }
                        objectOutputStream.writeInt(c.d());
                        continue;
                    }
                }
            }
            objectOutputStream.writeBoolean(false);
            if (a == 0) {
                return;
            }
        }
        objectOutputStream.writeBoolean(false);
    }
    
    protected void a(final bu bu, final q q, final ObjectOutputStream objectOutputStream) {
        objectOutputStream.writeByte(2);
        this.b(bu, q, objectOutputStream);
        this.c(bu, q, objectOutputStream);
        this.d(bu, q, objectOutputStream);
    }
    
    protected void b(final bu bu, final q q, final ObjectOutputStream objectOutputStream) {
        final fj t = bu.t(q);
        objectOutputStream.writeObject(a(((bV)t).getClass().getName()));
        t.write(objectOutputStream);
        if (t instanceof bV && this.v == null) {
            this.b(((bV)t).g(), objectOutputStream);
        }
    }
    
    protected void c(final bu bu, final q q, final ObjectOutputStream objectOutputStream) {
        if (this.v == null) {
            return;
        }
        if (this.v.j(q)) {
            objectOutputStream.writeBoolean(true);
            this.b((bu)this.v.m(q), objectOutputStream);
            if (y.e.c.a == 0) {
                return;
            }
        }
        objectOutputStream.writeBoolean(false);
    }
    
    protected void d(final bu bu, final q q, final ObjectOutputStream objectOutputStream) {
        if (this.v == null || !this.w) {
            return;
        }
        objectOutputStream.writeBoolean(this.v.k(q));
        final q n = this.v.n(q);
        if (n != null && this.v.k(n)) {
            objectOutputStream.writeInt(n.d());
            if (y.e.c.a == 0) {
                return;
            }
        }
        objectOutputStream.writeInt(-1);
    }
    
    protected ObjectOutputStream a(final OutputStream outputStream) {
        return new ObjectOutputStream(outputStream);
    }
    
    static Class c(final String s) {
        try {
            return Class.forName(s);
        }
        catch (ClassNotFoundException ex) {
            throw new NoClassDefFoundError(ex.getMessage());
        }
    }
    
    static {
        y.e.h.b = new HashMap();
        y.e.h.c = new HashMap();
        final StringBuffer sb = new StringBuffer("y.view.");
        a(sb.toString() + "ShapeNodeRealizer", ((y.e.h.d == null) ? (y.e.h.d = c("y.h.gn")) : y.e.h.d).getName());
        a(sb.toString() + "ImageNodeRealizer", ((y.e.h.e == null) ? (y.e.h.e = c("y.h.df")) : y.e.h.e).getName());
        a(sb.toString() + "Graph2DNodeRealizer", ((y.e.h.f == null) ? (y.e.h.f = c("y.h.bV")) : y.e.h.f).getName());
        a(sb.toString() + "GenericNodeRealizer", ((y.e.h.g == null) ? (y.e.h.g = c("y.h.aZ")) : y.e.h.g).getName());
        a(sb.toString() + "GenericGroupNodeRealizer", ((y.e.h.h == null) ? (y.e.h.h = c("y.h.a.e")) : y.e.h.h).getName());
        a(sb.toString() + "tabular.TableGroupNodeRealizer", ((y.e.h.i == null) ? (y.e.h.i = c("y.h.b.a")) : y.e.h.i).getName());
        a(sb.toString() + "hierarchy.GroupNodeRealizer", ((y.e.h.j == null) ? (y.e.h.j = c("y.h.a.p")) : y.e.h.j).getName());
        a(sb.toString() + "ProxyShapeNodeRealizer", ((y.e.h.k == null) ? (y.e.h.k = c("y.h.gd")) : y.e.h.k).getName());
        a(sb.toString() + "hierarchy.ProxyAutoBoundsNodeRealizer", ((y.e.h.l == null) ? (y.e.h.l = c("y.h.a.L")) : y.e.h.l).getName());
        a(sb.toString() + "PolyLineEdgeRealizer", ((y.e.h.m == null) ? (y.e.h.m = c("y.h.fJ")) : y.e.h.m).getName());
        a(sb.toString() + "QuadCurveEdgeRealizer", ((y.e.h.n == null) ? (y.e.h.n = c("y.h.ge")) : y.e.h.n).getName());
        a(sb.toString() + "GenericEdgeRealizer", ((y.e.h.o == null) ? (y.e.h.o = c("y.h.aF")) : y.e.h.o).getName());
        a(sb.toString() + "ArcEdgeRealizer", ((y.e.h.p == null) ? (y.e.h.p = c("y.h.g")) : y.e.h.p).getName());
        a(sb.toString() + "BezierEdgeRealizer", ((y.e.h.q == null) ? (y.e.h.q = c("y.h.B")) : y.e.h.q).getName());
        a(sb.toString() + "SplineEdgeRealizer", ((y.e.h.r == null) ? (y.e.h.r = c("y.h.gD")) : y.e.h.r).getName());
        a(sb.toString() + "Port", ((y.e.h.s == null) ? (y.e.h.s = c("y.h.fL")) : y.e.h.s).getName());
        a(sb.toString() + "InterfacePort", ((y.e.h.t == null) ? (y.e.h.t = c("y.h.dg")) : y.e.h.t).getName());
        a(sb.toString() + "tabular.TableStyle.SimpleStyle", ((y.e.h.u == null) ? (y.e.h.u = c("y.h.b.Z")) : y.e.h.u).getName());
        sb.setLength(0);
        sb.append("demo.uml.");
        a(sb.toString() + "ClassNodeRealizer", "demo.uml.ClassNodeRealizer");
        a(sb.toString() + "NoteNodeRealizer", "demo.uml.NoteNodeRealizer");
        y.e.h.b.put(sb.toString() + "UMLClassNodeRealizer", "demo.uml.ClassNodeRealizer");
        y.e.h.b.put(sb.toString() + "UMLNoteNodeRealizer", "demo.uml.NoteNodeRealizer");
    }
}
