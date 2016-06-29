package y.h;

import y.c.*;
import java.awt.*;
import java.awt.geom.*;
import y.e.*;
import java.io.*;
import java.util.*;

public class aF extends aB implements dy
{
    private aY b;
    private Object c;
    private Map d;
    static final aM a;
    
    public static aM a() {
        return aF.a;
    }
    
    public aF() {
        this.b = a().a();
    }
    
    public aF(final aB ab) {
        Label_0035: {
            if (ab instanceof aF) {
                this.b((aF)ab);
                if (!fj.z) {
                    break Label_0035;
                }
            }
            this.b = a().a();
        }
        super.b(ab);
    }
    
    public dy getMouseInputEditorProvider() {
        if (this.b.b != null) {
            return this;
        }
        return null;
    }
    
    public dx a(final ch ch, final double n, final double n2, final cW cw) {
        if (this.b.b != null) {
            return this.b.b.a(this, ch, n, n2, cw);
        }
        return null;
    }
    
    private void b(final aF af) {
        this.b = af.b;
        if (this.d != null) {
            this.d.clear();
        }
        if (this.b.o != null) {
            this.b.o.a(this);
        }
        if (af.d != null && af.d.size() > 0) {
            if (this.d == null) {
                this.d = new HashMap();
            }
            this.d.putAll(af.d);
        }
        if (this.o() != null) {
            this.c = this.o().a(af, af.c, this);
            if (!fj.z) {
                return;
            }
        }
        this.c = af.c;
    }
    
    public void calcUnionRect(final Rectangle2D rectangle2D) {
        final boolean z = fj.z;
        final aW m = this.m();
        if (m != null) {
            m.a(this, this.bends, this.path, rectangle2D);
            if (!z) {
                return;
            }
        }
        super.calcUnionRect(rectangle2D);
        Label_0092: {
            if (this.isSelected()) {
                p p = this.bends.k();
                while (p != null) {
                    final x x = (x)p.c();
                    rectangle2D.add(x.b(), x.c());
                    p = p.a();
                    if (z) {
                        break Label_0092;
                    }
                }
                return;
            }
        }
        p p2 = this.bends.k();
        while (p2 != null) {
            final x x2 = (x)p2.c();
            if (x2.d()) {
                rectangle2D.add(x2.b(), x2.c());
            }
            p2 = p2.a();
            if (z) {
                break;
            }
        }
    }
    
    public void reInsertBend(final x x, final x x2, final int n) {
        this.k().a(this, this.bends, x, x2, n);
    }
    
    public x removeBend(final x x) {
        return this.k().a(this, this.bends, x);
    }
    
    public aB createCopy(final aB ab) {
        return new aF(ab);
    }
    
    public x createBend(final double n, final double n2, final x x, final int n3) {
        return this.k().a(this, this.bends, n, n2, x, n3);
    }
    
    protected void paintArrows(final Graphics2D graphics2D) {
        final aH e = this.e();
        if (e != null) {
            e.a(this, this.bends, this.path, graphics2D);
            if (!fj.z) {
                return;
            }
        }
        super.paintArrows(graphics2D);
    }
    
    protected void paintLabels(final Graphics2D graphics2D) {
        final aR d = this.d();
        if (d != null) {
            d.a(this, graphics2D);
            if (!fj.z) {
                return;
            }
        }
        super.paintLabels(graphics2D);
    }
    
    public void bendChanged(final x x, final double n, final double n2) {
        this.k().a(this, this.bends, x, n, n2);
    }
    
    public x insertBend(final double n, final double n2) {
        return this.k().a(this, this.bends, n, n2);
    }
    
    public void registerObstacles(final C c) {
        final aK b = this.b();
        if (b != null) {
            if (this.isDirty()) {
                this.recalculateFeatures();
            }
            b.a(this, this.bends, this.path, c);
            if (!fj.z) {
                return;
            }
        }
        super.registerObstacles(c);
    }
    
    private final aK b() {
        return this.b.d;
    }
    
    private aS c() {
        return this.b.g;
    }
    
    private aR d() {
        return this.b.c;
    }
    
    private aH e() {
        return this.b.e;
    }
    
    private aL g() {
        return this.b.j;
    }
    
    private aP j() {
        return this.b.l;
    }
    
    private aI k() {
        return this.b.k;
    }
    
    private aT l() {
        return this.b.i;
    }
    
    private aW m() {
        return this.b.f;
    }
    
    private aU n() {
        return this.b.h;
    }
    
    private aX o() {
        return this.b.m;
    }
    
    private aJ p() {
        return this.b.n;
    }
    
    protected byte calculatePath(final Point2D point2D, final Point2D point2D2) {
        return this.l().a(this, this.bends, this.path, point2D, point2D2);
    }
    
    public void paint(final Graphics2D graphics2D) {
        if ((this.pb & 0x1) == 0x0) {
            return;
        }
        if (this.isDirty()) {
            this.recalculateFeatures();
        }
        if ((this.pb & 0x2) == 0x0) {
            return;
        }
        final aS c = this.c();
        if (c != null) {
            c.a(this, this.bends, this.path, graphics2D, aB.b(this, graphics2D));
            if (!fj.z) {
                return;
            }
        }
        super.paint(graphics2D);
    }
    
    protected void paintPorts(final Graphics2D graphics2D) {
        final aU n = this.n();
        if (n != null) {
            n.a(this, this.bends, this.path, graphics2D);
            if (!fj.z) {
                return;
            }
        }
        super.paintPorts(graphics2D);
    }
    
    protected void paintHighlightedBends(final Graphics2D graphics2D) {
        final aJ p = this.p();
        if (p != null) {
            p.a(this, this.bends, this.path, graphics2D, true);
            if (!fj.z) {
                return;
            }
        }
        super.paintHighlightedBends(graphics2D);
    }
    
    protected void paintBends(final Graphics2D graphics2D) {
        final aJ p = this.p();
        if (p != null) {
            p.a(this, this.bends, this.path, graphics2D, false);
            if (!fj.z) {
                return;
            }
        }
        super.paintBends(graphics2D);
    }
    
    public void paintSloppy(final Graphics2D graphics2D) {
        if ((this.pb & 0x1) == 0x0) {
            return;
        }
        final aS c = this.c();
        if (c != null) {
            if (this.isDirty()) {
                this.recalculateFeatures();
            }
            if ((this.pb & 0x2) == 0x0) {
                return;
            }
            c.b(this, this.bends, this.path, graphics2D, aB.b(this, graphics2D));
            if (!fj.z) {
                return;
            }
        }
        super.paintSloppy(graphics2D);
    }
    
    public int getMinBendCount() {
        return this.k().a(this);
    }
    
    public void clearBends() {
        while (this.bendCount() > this.getMinBendCount() && this.k().a(this, this.bends, this.firstBend()) != null) {}
    }
    
    public boolean contains(final double n, final double n2) {
        final aL g = this.g();
        if (g != null) {
            return g.a(this, this.bends, this.path, n, n2);
        }
        return super.contains(n, n2);
    }
    
    public int containsSeg(final double n, final double n2) {
        final aL g = this.g();
        if (g != null) {
            return g.b(this, this.bends, this.path, n, n2);
        }
        return super.containsSeg(n, n2);
    }
    
    public boolean pathIntersects(final Rectangle2D rectangle2D, final boolean b) {
        final aP j = this.j();
        if (j != null) {
            return j.a(this, this.bends, this.path, rectangle2D, b);
        }
        return super.pathIntersects(rectangle2D, b);
    }
    
    public aA createEdgeLabel() {
        final aQ q = this.b.q;
        if (q != null) {
            return q.a(this);
        }
        return super.createEdgeLabel();
    }
    
    void f() {
        final aV p = this.b.p;
        if (p != null) {
            p.a(this);
        }
    }
    
    public void read(final ObjectInputStream objectInputStream) {
        final boolean z = fj.z;
        Label_0240: {
            switch (objectInputStream.readByte()) {
                case 0: {
                    super.read(objectInputStream);
                    a().a(this, (String)objectInputStream.readObject());
                    if (objectInputStream.readBoolean()) {
                        if (this.o() != null) {
                            this.c = this.o().a(this, objectInputStream);
                            if (!z) {
                                return;
                            }
                        }
                        throw new a("No UserDataHandler registered to read userData!");
                    }
                    return;
                }
                case 1: {
                    super.read(objectInputStream);
                    a().a(this, (String)objectInputStream.readObject());
                    Label_0168: {
                        if (objectInputStream.readBoolean()) {
                            if (this.o() != null) {
                                this.c = this.o().a(this, objectInputStream);
                                if (!z) {
                                    break Label_0168;
                                }
                            }
                            throw new a("No UserDataHandler registered to read userData!");
                        }
                    }
                    final int int1 = objectInputStream.readInt();
                    Label_0205: {
                        if (this.d == null) {
                            this.d = new HashMap();
                            if (!z) {
                                break Label_0205;
                            }
                        }
                        this.d.clear();
                    }
                    int i = 0;
                    while (i < int1) {
                        this.d.put(objectInputStream.readObject(), objectInputStream.readObject());
                        ++i;
                        if (z) {
                            break Label_0240;
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
        if (this.d == null || this.d.size() == 0) {
            objectOutputStream.writeByte(0);
            super.write(objectOutputStream);
            objectOutputStream.writeObject(this.b.a);
            if (this.o() != null) {
                objectOutputStream.writeBoolean(true);
                this.o().a(this, this.c, objectOutputStream);
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
        objectOutputStream.writeObject(this.b.a);
        Label_0145: {
            if (this.o() != null) {
                objectOutputStream.writeBoolean(true);
                this.o().a(this, this.c, objectOutputStream);
                if (!z) {
                    break Label_0145;
                }
            }
            objectOutputStream.writeBoolean(false);
        }
        objectOutputStream.writeInt(this.d.size());
        for (final Map.Entry<Object, V> entry : this.d.entrySet()) {
            objectOutputStream.writeObject(entry.getKey());
            objectOutputStream.writeObject(entry.getValue());
            if (z) {
                break;
            }
        }
    }
    
    static aY a(final aF af) {
        return af.b;
    }
    
    static aY a(final aF af, final aY b) {
        return af.b = b;
    }
    
    static {
        a = new aM(null);
    }
}
