/*
 * Decompiled with CFR 0_115.
 */
package y.h;

import java.awt.Graphics2D;
import java.awt.geom.GeneralPath;
import java.awt.geom.Point2D;
import java.awt.geom.Rectangle2D;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import y.c.p;
import y.e.a;
import y.h.C;
import y.h.aA;
import y.h.aB;
import y.h.aG;
import y.h.aH;
import y.h.aI;
import y.h.aJ;
import y.h.aK;
import y.h.aL;
import y.h.aM;
import y.h.aN;
import y.h.aO;
import y.h.aP;
import y.h.aQ;
import y.h.aR;
import y.h.aS;
import y.h.aT;
import y.h.aU;
import y.h.aV;
import y.h.aW;
import y.h.aX;
import y.h.aY;
import y.h.cW;
import y.h.ch;
import y.h.dx;
import y.h.dy;
import y.h.fj;
import y.h.x;
import y.h.z;

public class aF
extends aB
implements dy {
    private aY b;
    private Object c;
    private Map d;
    static final aM a = new aM(null);

    public static aM a() {
        return a;
    }

    public aF() {
        this.b = aF.a().a();
    }

    public aF(aB aB2) {
        block2 : {
            if (aB2 instanceof aF) {
                this.b((aF)aB2);
                if (!fj.z) break block2;
            }
            this.b = aF.a().a();
        }
        super.b(aB2);
    }

    @Override
    public dy getMouseInputEditorProvider() {
        if (this.b.b == null) return null;
        return this;
    }

    @Override
    public dx a(ch ch2, double d2, double d3, cW cW2) {
        if (this.b.b == null) return null;
        return this.b.b.a(this, ch2, d2, d3, cW2);
    }

    private void b(aF aF2) {
        this.b = aF2.b;
        if (this.d != null) {
            this.d.clear();
        }
        if (this.b.o != null) {
            this.b.o.a(this);
        }
        if (aF2.d != null && aF2.d.size() > 0) {
            if (this.d == null) {
                this.d = new HashMap();
            }
            this.d.putAll(aF2.d);
        }
        if (this.o() != null) {
            this.c = this.o().a((aB)aF2, aF2.c, this);
            if (!fj.z) return;
        }
        this.c = aF2.c;
    }

    @Override
    public void calcUnionRect(Rectangle2D rectangle2D) {
        x x2;
        p p2;
        boolean bl2 = fj.z;
        aW aW2 = this.m();
        if (aW2 != null) {
            aW2.a(this, this.bends, this.path, rectangle2D);
            if (!bl2) return;
        }
        super.calcUnionRect(rectangle2D);
        if (this.isSelected()) {
            p2 = this.bends.k();
            do {
                if (p2 == null) return;
                x2 = (x)p2.c();
                rectangle2D.add(x2.b(), x2.c());
                p2 = p2.a();
            } while (!bl2);
        }
        p2 = this.bends.k();
        do {
            if (p2 == null) return;
            x2 = (x)p2.c();
            if (x2.d()) {
                rectangle2D.add(x2.b(), x2.c());
            }
            p2 = p2.a();
        } while (!bl2);
    }

    @Override
    public void reInsertBend(x x2, x x3, int n2) {
        this.k().a((aB)this, this.bends, x2, x3, n2);
    }

    @Override
    public x removeBend(x x2) {
        return this.k().a(this, this.bends, x2);
    }

    @Override
    public aB createCopy(aB aB2) {
        return new aF(aB2);
    }

    @Override
    public x createBend(double d2, double d3, x x2, int n2) {
        return this.k().a(this, this.bends, d2, d3, x2, n2);
    }

    @Override
    protected void paintArrows(Graphics2D graphics2D) {
        aH aH2 = this.e();
        if (aH2 != null) {
            aH2.a(this, this.bends, this.path, graphics2D);
            if (!fj.z) return;
        }
        super.paintArrows(graphics2D);
    }

    @Override
    protected void paintLabels(Graphics2D graphics2D) {
        aR aR2 = this.d();
        if (aR2 != null) {
            aR2.a(this, graphics2D);
            if (!fj.z) return;
        }
        super.paintLabels(graphics2D);
    }

    @Override
    public void bendChanged(x x2, double d2, double d3) {
        this.k().a((aB)this, this.bends, x2, d2, d3);
    }

    @Override
    public x insertBend(double d2, double d3) {
        return this.k().a(this, this.bends, d2, d3);
    }

    @Override
    public void registerObstacles(C c2) {
        aK aK2 = this.b();
        if (aK2 != null) {
            if (this.isDirty()) {
                this.recalculateFeatures();
            }
            aK2.a(this, this.bends, this.path, c2);
            if (!fj.z) return;
        }
        super.registerObstacles(c2);
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

    @Override
    protected byte calculatePath(Point2D point2D, Point2D point2D2) {
        return this.l().a(this, this.bends, this.path, point2D, point2D2);
    }

    @Override
    public void paint(Graphics2D graphics2D) {
        if ((this.pb & 1) == 0) {
            return;
        }
        if (this.isDirty()) {
            this.recalculateFeatures();
        }
        if ((this.pb & 2) == 0) {
            return;
        }
        aS aS2 = this.c();
        if (aS2 != null) {
            boolean bl2 = aF.b(this, graphics2D);
            aS2.a(this, this.bends, this.path, graphics2D, bl2);
            if (!fj.z) return;
        }
        super.paint(graphics2D);
    }

    @Override
    protected void paintPorts(Graphics2D graphics2D) {
        aU aU2 = this.n();
        if (aU2 != null) {
            aU2.a(this, this.bends, this.path, graphics2D);
            if (!fj.z) return;
        }
        super.paintPorts(graphics2D);
    }

    @Override
    protected void paintHighlightedBends(Graphics2D graphics2D) {
        aJ aJ2 = this.p();
        if (aJ2 != null) {
            aJ2.a(this, this.bends, this.path, graphics2D, true);
            if (!fj.z) return;
        }
        super.paintHighlightedBends(graphics2D);
    }

    @Override
    protected void paintBends(Graphics2D graphics2D) {
        aJ aJ2 = this.p();
        if (aJ2 != null) {
            aJ2.a(this, this.bends, this.path, graphics2D, false);
            if (!fj.z) return;
        }
        super.paintBends(graphics2D);
    }

    @Override
    public void paintSloppy(Graphics2D graphics2D) {
        if ((this.pb & 1) == 0) {
            return;
        }
        aS aS2 = this.c();
        if (aS2 != null) {
            if (this.isDirty()) {
                this.recalculateFeatures();
            }
            if ((this.pb & 2) == 0) {
                return;
            }
            boolean bl2 = aF.b(this, graphics2D);
            aS2.b(this, this.bends, this.path, graphics2D, bl2);
            if (!fj.z) return;
        }
        super.paintSloppy(graphics2D);
    }

    @Override
    public int getMinBendCount() {
        return this.k().a(this);
    }

    @Override
    public void clearBends() {
        while (this.bendCount() > this.getMinBendCount()) {
            if (this.k().a(this, this.bends, this.firstBend()) == null) return;
        }
    }

    @Override
    public boolean contains(double d2, double d3) {
        aL aL2 = this.g();
        if (aL2 == null) return super.contains(d2, d3);
        return aL2.a(this, this.bends, this.path, d2, d3);
    }

    @Override
    public int containsSeg(double d2, double d3) {
        aL aL2 = this.g();
        if (aL2 == null) return super.containsSeg(d2, d3);
        return aL2.b(this, this.bends, this.path, d2, d3);
    }

    @Override
    public boolean pathIntersects(Rectangle2D rectangle2D, boolean bl2) {
        aP aP2 = this.j();
        if (aP2 == null) return super.pathIntersects(rectangle2D, bl2);
        return aP2.a(this, this.bends, this.path, rectangle2D, bl2);
    }

    @Override
    public aA createEdgeLabel() {
        aQ aQ2 = this.b.q;
        if (aQ2 == null) return super.createEdgeLabel();
        return aQ2.a(this);
    }

    @Override
    void f() {
        aV aV2 = this.b.p;
        if (aV2 == null) return;
        aV2.a(this);
    }

    @Override
    public void read(ObjectInputStream objectInputStream) {
        boolean bl2 = fj.z;
        switch (objectInputStream.readByte()) {
            case 0: {
                super.read(objectInputStream);
                aF.a().a(this, (String)objectInputStream.readObject());
                boolean bl3 = objectInputStream.readBoolean();
                if (!bl3) return;
                if (this.o() == null) throw new a("No UserDataHandler registered to read userData!");
                this.c = this.o().a(this, objectInputStream);
                if (!bl2) return;
                throw new a("No UserDataHandler registered to read userData!");
            }
            case 1: {
                int n2;
                block9 : {
                    super.read(objectInputStream);
                    aF.a().a(this, (String)objectInputStream.readObject());
                    boolean bl4 = objectInputStream.readBoolean();
                    if (bl4) {
                        if (this.o() == null) throw new a("No UserDataHandler registered to read userData!");
                        this.c = this.o().a(this, objectInputStream);
                        if (bl2) {
                            throw new a("No UserDataHandler registered to read userData!");
                        }
                    }
                    n2 = objectInputStream.readInt();
                    if (this.d == null) {
                        this.d = new HashMap();
                        if (!bl2) break block9;
                    }
                    this.d.clear();
                }
                int n3 = 0;
                do {
                    if (n3 >= n2) return;
                    this.d.put(objectInputStream.readObject(), objectInputStream.readObject());
                    ++n3;
                } while (!bl2);
            }
        }
        throw new a();
    }

    @Override
    public void write(ObjectOutputStream objectOutputStream) {
        boolean bl2;
        block5 : {
            bl2 = fj.z;
            if (this.d == null || this.d.size() == 0) {
                objectOutputStream.writeByte(0);
                super.write(objectOutputStream);
                objectOutputStream.writeObject(this.b.a);
                if (this.o() != null) {
                    objectOutputStream.writeBoolean(true);
                    this.o().a((aB)this, this.c, objectOutputStream);
                    if (!bl2) return;
                }
                objectOutputStream.writeBoolean(false);
                if (!bl2) return;
            }
            objectOutputStream.writeByte(1);
            super.write(objectOutputStream);
            objectOutputStream.writeObject(this.b.a);
            if (this.o() != null) {
                objectOutputStream.writeBoolean(true);
                this.o().a((aB)this, this.c, objectOutputStream);
                if (!bl2) break block5;
            }
            objectOutputStream.writeBoolean(false);
        }
        objectOutputStream.writeInt(this.d.size());
        Iterator iterator = this.d.entrySet().iterator();
        do {
            if (!iterator.hasNext()) return;
            Map.Entry entry = iterator.next();
            objectOutputStream.writeObject(entry.getKey());
            objectOutputStream.writeObject(entry.getValue());
        } while (!bl2);
    }

    static aY a(aF aF2) {
        return aF2.b;
    }

    static aY a(aF aF2, aY aY2) {
        aF2.b = aY2;
        return aF2.b;
    }
}

