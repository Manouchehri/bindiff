package y.h;

import java.awt.*;
import y.c.*;
import java.awt.geom.*;
import y.g.*;
import y.e.*;
import java.io.*;
import java.util.*;

public class aZ extends fj implements dy
{
    protected bc a;
    Object b;
    private bt w;
    private Map A;
    static be c;
    static Class d;
    static Class e;
    static Class f;
    static Class g;
    static Class h;
    static Class i;
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
    static Class v;
    
    public static be a() {
        return aZ.c;
    }
    
    public aZ() {
        this(a().b());
    }
    
    private aZ(final bc a) {
        this.a = a;
        super.b("");
        be.a(this);
    }
    
    void b(final String s) {
    }
    
    public void a(final String s, final Object o) {
        if (this.A == null) {
            this.A = new HashMap();
        }
        this.A.put(s, o);
    }
    
    public Object a(final String s) {
        if (this.A == null) {
            return null;
        }
        return this.A.get(s);
    }
    
    public Set e() {
        if (this.A == null) {
            return Collections.EMPTY_SET;
        }
        return Collections.unmodifiableSet((Set<?>)this.A.entrySet());
    }
    
    public void c(final String s) {
        if (this.A != null) {
            this.A.remove(s);
            if (this.A.size() == 0) {
                this.A = null;
            }
        }
    }
    
    public aZ(final fj fj) {
        super(fj);
        if (fj instanceof aZ) {
            this.a((aZ)fj);
            if (!fj.z) {
                return;
            }
        }
        this.a = a().b();
    }
    
    public String f() {
        return this.a.a;
    }
    
    public void d(final String s) {
        a().a(this, s);
    }
    
    protected void a(final aZ az) {
        this.a = az.a;
        if (this.A != null) {
            this.A.clear();
        }
        if (this.a.o != null) {
            this.a.o.a(this);
        }
        if (az.A != null && az.A.size() > 0) {
            if (this.A == null) {
                this.A = new HashMap();
            }
            this.A.putAll(az.A);
        }
        if (this.a.j != null) {
            this.b = this.a.j.a(az, az.b, this);
            if (!fj.z) {
                return;
            }
        }
        this.b = az.b;
    }
    
    public fj createCopy(final fj fj) {
        return new aZ(fj);
    }
    
    public void paintNode(final Graphics2D graphics2D) {
        if (fj.b(this, graphics2D)) {
            this.paintHotSpots(graphics2D);
        }
        this.b(graphics2D);
        if (fj.b(graphics2D, false)) {
            this.paintPorts(graphics2D);
        }
        if (fj.c(graphics2D, false)) {
            this.paintText(graphics2D);
        }
    }
    
    protected void boundsChanged() {
        final bb k = this.a.k;
        if (k != null) {
            k.a(this);
        }
    }
    
    protected void labelBoundsChanged(final eR er) {
        if (this.a != null) {
            final bl l = this.a.l;
            if (l != null) {
                l.a(this, er);
            }
        }
    }
    
    public D getPortCandidates(final double n) {
        final bp c = this.a.c;
        if (c != null) {
            return c.a(this, n);
        }
        return super.getPortCandidates(n);
    }
    
    public byte getLayer() {
        final bn q = this.a.q;
        if (q != null) {
            return q.a(this);
        }
        return super.getLayer();
    }
    
    public void setLayer(final byte layer) {
        final bn q = this.a.q;
        if (q != null) {
            q.a(this, layer);
            if (!fj.z) {
                return;
            }
        }
        super.setLayer(layer);
    }
    
    public void paint(final Graphics2D graphics2D) {
        final bo e = this.a.e;
        if (e != null) {
            final Graphics2D graphics2D2 = (Graphics2D)graphics2D.create();
            try {
                e.a(this, graphics2D2);
                return;
            }
            finally {
                graphics2D2.dispose();
            }
        }
        super.paint(graphics2D);
    }
    
    public void paintSloppy(final Graphics2D graphics2D) {
        final bo e = this.a.e;
        if (e != null) {
            final Graphics2D graphics2D2 = (Graphics2D)graphics2D.create();
            try {
                e.e(this, graphics2D2);
                return;
            }
            finally {
                graphics2D2.dispose();
            }
        }
        super.paintSloppy(graphics2D);
    }
    
    public boolean contains(final double n, final double n2) {
        final bd i = this.a.i;
        if (i != null) {
            return i.a(this, n, n2);
        }
        return super.contains(n, n2);
    }
    
    public byte hotSpotHit(final double n, final double n2) {
        final bh f = this.a.f;
        if (f != null) {
            return f.a(this, n, n2);
        }
        return super.hotSpotHit(n, n2);
    }
    
    public boolean findIntersection(final double n, final double n2, final double n3, final double n4, final Point2D point2D) {
        final bk h = this.a.h;
        if (h != null) {
            return h.a(this, n, n2, n3, n4, point2D);
        }
        return super.findIntersection(n, n2, n3, n4, point2D);
    }
    
    public void paintHotSpots(final Graphics2D graphics2D) {
        final bi g = this.a.g;
        if (g != null) {
            final Graphics2D graphics2D2 = (Graphics2D)graphics2D.create();
            try {
                g.a(this, graphics2D2);
                return;
            }
            finally {
                graphics2D2.dispose();
            }
        }
        super.paintHotSpots(graphics2D);
    }
    
    public void calcUnionRect(final Rectangle2D rectangle2D) {
        final br d = this.a.d;
        if (d != null) {
            d.a(this, rectangle2D);
            if (!fj.z) {
                return;
            }
        }
        super.calcUnionRect(rectangle2D);
    }
    
    public eR createNodeLabel() {
        final bm r = this.a.r;
        if (r != null) {
            return r.a(this);
        }
        return super.createNodeLabel();
    }
    
    void c() {
        final bq p = this.a.p;
        if (p != null) {
            p.a(this);
        }
    }
    
    private ag g() {
        return X.b();
    }
    
    public void read(final ObjectInputStream objectInputStream) {
        final boolean z = fj.z;
        Label_0454: {
            switch (objectInputStream.readByte()) {
                case 0: {
                    super.read(objectInputStream);
                    a().a(this, (String)objectInputStream.readObject());
                    if (objectInputStream.readBoolean()) {
                        final bs j = this.a.j;
                        if (j != null) {
                            this.b = j.a(this, objectInputStream);
                            if (!z) {
                                return;
                            }
                        }
                        throw new a("No userDataHandler registered to read userData!");
                    }
                    return;
                }
                case 1: {
                    super.read(objectInputStream);
                    a().a(this, (String)objectInputStream.readObject());
                    Label_0172: {
                        if (objectInputStream.readBoolean()) {
                            final bs i = this.a.j;
                            if (i != null) {
                                this.b = i.a(this, objectInputStream);
                                if (!z) {
                                    break Label_0172;
                                }
                            }
                            throw new a("No userDataHandler registered to read userData!");
                        }
                    }
                    final int int1 = objectInputStream.readInt();
                    Label_0209: {
                        if (this.A == null) {
                            this.A = new HashMap();
                            if (!z) {
                                break Label_0209;
                            }
                        }
                        this.A.clear();
                    }
                    final ag g = this.g();
                    int k = 0;
                    while (k < int1) {
                        Label_0369: {
                            switch (objectInputStream.readByte()) {
                                case 1: {
                                    final Object object = objectInputStream.readObject();
                                    try {
                                        final Object instance = Class.forName(y.e.h.b((String)objectInputStream.readObject())).newInstance();
                                        ((Externalizable)instance).readExternal(objectInputStream);
                                        this.A.put(object, instance);
                                        break;
                                    }
                                    catch (InstantiationException ex) {
                                        throw new InvalidClassException(ex.getMessage());
                                    }
                                    catch (IllegalAccessException ex2) {
                                        throw new InvalidClassException(ex2.getMessage());
                                    }
                                }
                                case 2: {
                                    this.A.put(objectInputStream.readObject(), objectInputStream.readObject());
                                    if (z) {
                                        break Label_0369;
                                    }
                                    break;
                                }
                                case Byte.MAX_VALUE: {
                                    final Object object2 = objectInputStream.readObject();
                                    final Class<?> forName = Class.forName(y.e.h.b((String)objectInputStream.readObject()));
                                    final String s = (String)objectInputStream.readObject();
                                    if (s == null) {
                                        this.A.put(object2, s);
                                        if (!z) {
                                            break;
                                        }
                                    }
                                    this.A.put(object2, g.a(s, forName));
                                    break;
                                }
                            }
                        }
                        ++k;
                        if (z) {
                            break Label_0454;
                        }
                    }
                    return;
                }
            }
        }
        throw new a();
    }
    
    public void write(final ObjectOutputStream objectOutputStream) {
        final boolean z = fj.z;
        final Map a = this.A;
        if (a == null || a.isEmpty()) {
            objectOutputStream.writeByte(0);
            super.write(objectOutputStream);
            objectOutputStream.writeObject(this.a.a);
            final bs j = this.a.j;
            if (j != null) {
                objectOutputStream.writeBoolean(true);
                j.a(this, this.b, objectOutputStream);
                if (!z) {
                    return;
                }
            }
            objectOutputStream.writeBoolean(false);
            if (!z) {
                return;
            }
        }
        objectOutputStream.writeByte(1);
        super.write(objectOutputStream);
        objectOutputStream.writeObject(this.a.a);
        final bs i = this.a.j;
        Label_0148: {
            if (i != null) {
                objectOutputStream.writeBoolean(true);
                i.a(this, this.b, objectOutputStream);
                if (!z) {
                    break Label_0148;
                }
            }
            objectOutputStream.writeBoolean(false);
        }
        final ArrayList list = new ArrayList<Map.Entry<K, Object>>(a.size());
        while (true) {
            for (final Map.Entry<Object, V> entry : a.entrySet()) {
                if (!"y.view.hierarchy.GroupNodePainter.GROUP_STATE_STYLE".equals(entry.getKey())) {
                    list.add((Map.Entry<K, Object>)entry);
                    if (z) {
                        final ag g = this.g();
                        for (final Map.Entry<K, Object> entry2 : list) {
                            final Externalizable value = entry2.getValue();
                            if (value instanceof Externalizable) {
                                objectOutputStream.writeByte(1);
                                objectOutputStream.writeObject(entry2.getKey());
                                objectOutputStream.writeObject(y.e.h.a(value.getClass().getName()));
                                value.writeExternal(objectOutputStream);
                                if (!z) {
                                    continue;
                                }
                            }
                            if (value instanceof Serializable) {
                                objectOutputStream.writeByte(2);
                                objectOutputStream.writeObject(entry2.getKey());
                                objectOutputStream.writeObject(entry2.getValue());
                                if (!z) {
                                    continue;
                                }
                            }
                            objectOutputStream.writeByte(127);
                            objectOutputStream.writeObject(entry2.getKey());
                            if (value == null) {
                                objectOutputStream.writeObject((aZ.d == null) ? (aZ.d = e("java.lang.Object")) : aZ.d);
                                objectOutputStream.writeObject(null);
                                if (!z) {
                                    continue;
                                }
                            }
                            objectOutputStream.writeObject(y.e.h.a(value.getClass().getName()));
                            objectOutputStream.writeObject(g.a(value, value.getClass()));
                            if (z) {
                                break;
                            }
                        }
                        return;
                    }
                    if (z) {
                        break;
                    }
                    continue;
                }
            }
            objectOutputStream.writeInt(list.size());
            continue;
        }
    }
    
    public dy getMouseInputEditorProvider() {
        if (this.a.b != null) {
            return this;
        }
        return null;
    }
    
    public dx a(final ch ch, final double n, final double n2, final cW cw) {
        final bf b = this.a.b;
        if (b != null) {
            return b.a(this, ch, n, n2, cw);
        }
        return null;
    }
    
    public gt getSizeConstraintProvider() {
        if (this.a.n != null) {
            if (this.w == null) {
                this.w = new bt(this);
            }
            return this.w;
        }
        this.w = null;
        return super.getSizeConstraintProvider();
    }
    
    static Class e(final String s) {
        try {
            return Class.forName(s);
        }
        catch (ClassNotFoundException ex) {
            throw new NoClassDefFoundError(ex.getMessage());
        }
    }
    
    static {
        aZ.c = new be(null);
    }
}
