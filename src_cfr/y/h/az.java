/*
 * Decompiled with CFR 0_115.
 */
package y.h;

import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.geom.Point2D;
import java.awt.geom.Rectangle2D;
import java.io.Externalizable;
import java.io.InvalidClassException;
import java.io.ObjectInput;
import java.io.ObjectInputStream;
import java.io.ObjectOutput;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import y.c.D;
import y.e.a;
import y.e.h;
import y.g.X;
import y.g.ag;
import y.h.ba;
import y.h.bb;
import y.h.bc;
import y.h.bd;
import y.h.be;
import y.h.bf;
import y.h.bg;
import y.h.bh;
import y.h.bi;
import y.h.bj;
import y.h.bk;
import y.h.bl;
import y.h.bm;
import y.h.bn;
import y.h.bo;
import y.h.bp;
import y.h.bq;
import y.h.br;
import y.h.bs;
import y.h.bt;
import y.h.cW;
import y.h.ch;
import y.h.dx;
import y.h.dy;
import y.h.eR;
import y.h.fj;
import y.h.gt;

public class aZ
extends fj
implements dy {
    protected bc a;
    Object b;
    private bt w;
    private Map A;
    static be c = new be(null);
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
        return c;
    }

    public aZ() {
        this(aZ.a().b());
    }

    private aZ(bc bc2) {
        this.a = bc2;
        super.b("");
        be.a(this);
    }

    @Override
    void b(String string) {
    }

    public void a(String string, Object object) {
        if (this.A == null) {
            this.A = new HashMap();
        }
        this.A.put(string, object);
    }

    public Object a(String string) {
        if (this.A != null) return this.A.get(string);
        return null;
    }

    public Set e() {
        if (this.A != null) return Collections.unmodifiableSet(this.A.entrySet());
        return Collections.EMPTY_SET;
    }

    public void c(String string) {
        if (this.A == null) return;
        this.A.remove(string);
        if (this.A.size() != 0) return;
        this.A = null;
    }

    public aZ(fj fj2) {
        super(fj2);
        if (fj2 instanceof aZ) {
            this.a((aZ)fj2);
            if (!fj.z) return;
        }
        this.a = aZ.a().b();
    }

    public String f() {
        return this.a.a;
    }

    public void d(String string) {
        aZ.a().a(this, string);
    }

    protected void a(aZ aZ2) {
        this.a = aZ2.a;
        if (this.A != null) {
            this.A.clear();
        }
        if (this.a.o != null) {
            this.a.o.a(this);
        }
        if (aZ2.A != null && aZ2.A.size() > 0) {
            if (this.A == null) {
                this.A = new HashMap();
            }
            this.A.putAll(aZ2.A);
        }
        if (this.a.j != null) {
            this.b = this.a.j.a((fj)aZ2, aZ2.b, this);
            if (!fj.z) return;
        }
        this.b = aZ2.b;
    }

    @Override
    public fj createCopy(fj fj2) {
        return new aZ(fj2);
    }

    @Override
    public void paintNode(Graphics2D graphics2D) {
        if (aZ.b(this, graphics2D)) {
            this.paintHotSpots(graphics2D);
        }
        this.b(graphics2D);
        if (aZ.b(graphics2D, false)) {
            this.paintPorts(graphics2D);
        }
        if (!aZ.c(graphics2D, false)) return;
        this.paintText(graphics2D);
    }

    @Override
    protected void boundsChanged() {
        bb bb2 = this.a.k;
        if (bb2 == null) return;
        bb2.a(this);
    }

    @Override
    protected void labelBoundsChanged(eR eR2) {
        if (this.a == null) return;
        bl bl2 = this.a.l;
        if (bl2 == null) return;
        bl2.a(this, eR2);
    }

    @Override
    public D getPortCandidates(double d2) {
        bp bp2 = this.a.c;
        if (bp2 == null) return super.getPortCandidates(d2);
        return bp2.a(this, d2);
    }

    @Override
    public byte getLayer() {
        bn bn2 = this.a.q;
        if (bn2 == null) return super.getLayer();
        return bn2.a(this);
    }

    @Override
    public void setLayer(byte by2) {
        bn bn2 = this.a.q;
        if (bn2 != null) {
            bn2.a(this, by2);
            if (!fj.z) return;
        }
        super.setLayer(by2);
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    @Override
    public void paint(Graphics2D graphics2D) {
        bo bo2 = this.a.e;
        if (bo2 != null) {
            Graphics2D graphics2D2 = (Graphics2D)graphics2D.create();
            try {
                bo2.a(this, graphics2D2);
                return;
            }
            finally {
                graphics2D2.dispose();
            }
        } else {
            super.paint(graphics2D);
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    @Override
    public void paintSloppy(Graphics2D graphics2D) {
        bo bo2 = this.a.e;
        if (bo2 != null) {
            Graphics2D graphics2D2 = (Graphics2D)graphics2D.create();
            try {
                bo2.e(this, graphics2D2);
                return;
            }
            finally {
                graphics2D2.dispose();
            }
        } else {
            super.paintSloppy(graphics2D);
        }
    }

    @Override
    public boolean contains(double d2, double d3) {
        bd bd2 = this.a.i;
        if (bd2 == null) return super.contains(d2, d3);
        return bd2.a(this, d2, d3);
    }

    @Override
    public byte hotSpotHit(double d2, double d3) {
        bh bh2 = this.a.f;
        if (bh2 == null) return super.hotSpotHit(d2, d3);
        return bh2.a(this, d2, d3);
    }

    @Override
    public boolean findIntersection(double d2, double d3, double d4, double d5, Point2D point2D) {
        bk bk2 = this.a.h;
        if (bk2 == null) return super.findIntersection(d2, d3, d4, d5, point2D);
        return bk2.a(this, d2, d3, d4, d5, point2D);
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    @Override
    public void paintHotSpots(Graphics2D graphics2D) {
        bi bi2 = this.a.g;
        if (bi2 != null) {
            Graphics2D graphics2D2 = (Graphics2D)graphics2D.create();
            try {
                bi2.a(this, graphics2D2);
                return;
            }
            finally {
                graphics2D2.dispose();
            }
        } else {
            super.paintHotSpots(graphics2D);
        }
    }

    @Override
    public void calcUnionRect(Rectangle2D rectangle2D) {
        br br2 = this.a.d;
        if (br2 != null) {
            br2.a(this, rectangle2D);
            if (!fj.z) return;
        }
        super.calcUnionRect(rectangle2D);
    }

    @Override
    public eR createNodeLabel() {
        bm bm2 = this.a.r;
        if (bm2 == null) return super.createNodeLabel();
        return bm2.a(this);
    }

    @Override
    void c() {
        bq bq2 = this.a.p;
        if (bq2 == null) return;
        bq2.a(this);
    }

    private ag g() {
        return X.b();
    }

    @Override
    public void read(ObjectInputStream objectInputStream) {
        boolean bl2 = fj.z;
        switch (objectInputStream.readByte()) {
            case 0: {
                super.read(objectInputStream);
                aZ.a().a(this, (String)objectInputStream.readObject());
                boolean bl3 = objectInputStream.readBoolean();
                if (!bl3) return;
                bs bs2 = this.a.j;
                if (bs2 == null) throw new a("No userDataHandler registered to read userData!");
                this.b = bs2.a(this, objectInputStream);
                if (!bl2) return;
                throw new a("No userDataHandler registered to read userData!");
            }
            case 1: {
                int n2;
                block18 : {
                    super.read(objectInputStream);
                    aZ.a().a(this, (String)objectInputStream.readObject());
                    boolean bl4 = objectInputStream.readBoolean();
                    if (bl4) {
                        bs bs3 = this.a.j;
                        if (bs3 == null) throw new a("No userDataHandler registered to read userData!");
                        this.b = bs3.a(this, objectInputStream);
                        if (bl2) {
                            throw new a("No userDataHandler registered to read userData!");
                        }
                    }
                    n2 = objectInputStream.readInt();
                    if (this.A == null) {
                        this.A = new HashMap();
                        if (!bl2) break block18;
                    }
                    this.A.clear();
                }
                ag ag2 = this.g();
                int n3 = 0;
                do {
                    if (n3 >= n2) return;
                    switch (objectInputStream.readByte()) {
                        Object object;
                        case 1: {
                            object = objectInputStream.readObject();
                            try {
                                Object obj = Class.forName(h.b((String)objectInputStream.readObject())).newInstance();
                                ((Externalizable)obj).readExternal(objectInputStream);
                                this.A.put(object, obj);
                                break;
                            }
                            catch (InstantiationException var7_13) {
                                throw new InvalidClassException(var7_13.getMessage());
                            }
                            catch (IllegalAccessException var7_14) {
                                throw new InvalidClassException(var7_14.getMessage());
                            }
                        }
                        case 2: {
                            this.A.put(objectInputStream.readObject(), objectInputStream.readObject());
                            if (!bl2) break;
                        }
                        case 127: {
                            object = objectInputStream.readObject();
                            Class class_ = Class.forName(h.b((String)objectInputStream.readObject()));
                            String string = (String)objectInputStream.readObject();
                            if (string == null) {
                                this.A.put(object, string);
                                if (!bl2) break;
                            }
                            this.A.put(object, ag2.a(string, class_));
                        }
                    }
                    ++n3;
                } while (!bl2);
            }
        }
        throw new a();
    }

    /*
     * Unable to fully structure code
     */
    @Override
    public void write(ObjectOutputStream var1_1) {
        block8 : {
            block7 : {
                var9_2 = fj.z;
                var2_3 = this.A;
                if (var2_3 == null || var2_3.isEmpty()) {
                    var1_1.writeByte(0);
                    super.write(var1_1);
                    var1_1.writeObject(this.a.a);
                    var3_4 = this.a.j;
                    if (var3_4 != null) {
                        var1_1.writeBoolean(true);
                        var3_4.a((fj)this, this.b, var1_1);
                        if (var9_2 == false) return;
                    }
                    var1_1.writeBoolean(false);
                    if (var9_2 == false) return;
                }
                var1_1.writeByte(1);
                super.write(var1_1);
                var1_1.writeObject(this.a.a);
                var3_4 = this.a.j;
                if (var3_4 != null) {
                    var1_1.writeBoolean(true);
                    var3_4.a((fj)this, this.b, var1_1);
                    if (!var9_2) break block7;
                }
                var1_1.writeBoolean(false);
            }
            var4_5 = new ArrayList<Object>(var2_3.size());
            for (Map.Entry<K, V> var6_7 : var2_3.entrySet()) {
                if ("y.view.hierarchy.GroupNodePainter.GROUP_STATE_STYLE".equals(var6_7.getKey())) continue;
                var4_5.add(var6_7);
                if (!var9_2) {
                    if (!var9_2) continue;
                }
                break block8;
            }
            var1_1.writeInt(var4_5.size());
        }
        var5_6 = this.g();
        var6_7 = var4_5.iterator();
        do lbl-1000: // 5 sources:
        {
            if (var6_7.hasNext() == false) return;
            var7_8 = (Map.Entry)var6_7.next();
            var8_9 = var7_8.getValue();
            if (!(var8_9 instanceof Externalizable)) ** GOTO lbl45
            var1_1.writeByte(1);
            var1_1.writeObject(var7_8.getKey());
            var1_1.writeObject(h.a(var8_9.getClass().getName()));
            ((Externalizable)var8_9).writeExternal(var1_1);
            if (!var9_2) ** GOTO lbl-1000
lbl45: // 2 sources:
            if (!(var8_9 instanceof Serializable)) ** GOTO lbl50
            var1_1.writeByte(2);
            var1_1.writeObject(var7_8.getKey());
            var1_1.writeObject(var7_8.getValue());
            if (!var9_2) ** GOTO lbl-1000
lbl50: // 2 sources:
            var1_1.writeByte(127);
            var1_1.writeObject(var7_8.getKey());
            if (var8_9 != null) ** GOTO lbl56
            var1_1.writeObject(aZ.d == null ? aZ.e("java.lang.Object") : aZ.d);
            var1_1.writeObject(null);
            if (!var9_2) ** GOTO lbl-1000
lbl56: // 2 sources:
            var1_1.writeObject(h.a(var8_9.getClass().getName()));
            var1_1.writeObject(var5_6.a(var8_9, var8_9.getClass()));
        } while (!var9_2);
    }

    @Override
    public dy getMouseInputEditorProvider() {
        if (this.a.b == null) return null;
        return this;
    }

    @Override
    public dx a(ch ch2, double d2, double d3, cW cW2) {
        bf bf2 = this.a.b;
        if (bf2 == null) return null;
        return bf2.a(this, ch2, d2, d3, cW2);
    }

    @Override
    public gt getSizeConstraintProvider() {
        if (this.a.n != null) {
            if (this.w != null) return this.w;
            this.w = new bt(this);
            return this.w;
        }
        this.w = null;
        return super.getSizeConstraintProvider();
    }

    static Class e(String string) {
        try {
            return Class.forName(string);
        }
        catch (ClassNotFoundException var1_1) {
            throw new NoClassDefFoundError(var1_1.getMessage());
        }
    }
}

