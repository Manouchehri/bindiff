/*
 * Decompiled with CFR 0_115.
 */
package y.h;

import java.awt.Color;
import java.awt.geom.Point2D;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Vector;
import y.c.C;
import y.c.D;
import y.c.d;
import y.c.i;
import y.d.n;
import y.d.q;
import y.d.t;
import y.d.y;
import y.e.a;
import y.f.B;
import y.f.E;
import y.f.I;
import y.f.K;
import y.f.aG;
import y.f.aJ;
import y.f.aL;
import y.f.aO;
import y.f.aP;
import y.f.am;
import y.f.z;
import y.h.aB;
import y.h.ay;
import y.h.bu;
import y.h.fj;
import y.h.gZ;
import y.h.gs;
import y.h.hb;
import y.h.hg;
import y.h.hh;
import y.h.hj;
import y.h.s;
import y.h.u;

public class aA
extends gZ
implements y.f.C {
    static final byte lb = 7;
    public static final byte HEAD = 10;
    public static final byte TAIL = 11;
    public static final byte CENTER = 12;
    public static final byte SHEAD = 13;
    public static final byte THEAD = 14;
    public static final byte STAIL = 15;
    public static final byte TTAIL = 16;
    public static final byte SCENTR = 17;
    public static final byte TCENTR = 18;
    public static final byte ANYWHERE = 99;
    public static final byte CENTER_RATIO = 19;
    public static final byte TAIL_RATIO = 20;
    public static final byte HEAD_RATIO = 21;
    public static final byte DYNAMIC = 24;
    public static final byte UNDEFINED = 127;
    public static final byte TWO_POS = 0;
    public static final byte CENTERED = 1;
    public static final byte SIX_POS = 2;
    public static final byte THREE_CENTER = 3;
    public static final byte FREE = 4;
    public static final byte CENTER_SLIDER = 5;
    public static final byte SIDE_SLIDER = 6;
    public static final byte CUSTOM_LABEL_MODEL = 127;
    private static final byte[][] jb = new byte[][]{{10, 11}, {12}, {10, 13, 14, 11, 15, 16}, {12, 17, 18}, {99}, {24}, {24}};
    private double rb = 0.5;
    private E kb = new z(63);
    private Object sb = this.kb.c();
    private aB pb;
    private double nb = 2.0;
    private aG mb = aG.g(0);
    private static final hb ob;
    private static final hg qb;
    static Class class$y$view$YLabel$BoundsProvider;
    static Class class$y$view$YLabel$Layout;
    static Class class$y$view$YLabel$Painter;
    static Class class$y$view$YLabel$UserDataHandler;
    static Class class$y$layout$DiscreteEdgeLabelModel;
    static Class class$y$layout$FreeEdgeLabelModel;
    static Class class$y$layout$SliderEdgeLabelModel;

    public aA(String string, byte by2) {
        this.setModel(by2);
        this.setText(string);
    }

    @Override
    hg c() {
        return qb;
    }

    public aA(String string) {
        this(string, 2);
    }

    @Override
    void b() {
        if (this.pb == null) return;
        if (this.pb.getEdge() == null) return;
        i i2 = this.pb.getEdge().a();
        if (!(i2 instanceof bu)) return;
        bu bu2 = (bu)i2;
        bu2.e(this);
    }

    public aA() {
        this("");
    }

    public Object clone() {
        aA aA2 = new aA();
        aA2.adoptValues(this);
        return aA2;
    }

    @Override
    public void adoptValues(gZ gZ2) {
        super.adoptValues(gZ2);
        if (!(gZ2 instanceof aA)) return;
        aA aA2 = (aA)gZ2;
        this.sb = aA2.sb;
        this.kb = aA2.kb;
        this.nb = aA2.nb;
        this.mb = aA2.mb;
    }

    @Override
    public void calculateOffset() {
        try {
            bu bu2 = this.getGraph2D();
            Point2D point2D = this.pb.getSourceIntersection();
            fj fj2 = bu2.t(this.getEdge().c());
            fj fj3 = bu2.t(this.getEdge().d());
            n n2 = this.getLabelModel().a(new q(this.getWidth(), this.getHeight()), this.pb, fj2, fj3, this.getModelParameter());
            n2.a(n2.a().b(- point2D.getX(), - point2D.getY()));
            super.setOffset(n2);
            return;
        }
        catch (Exception var1_2) {
            this.offsetRectangle.b(this.getWidth(), this.getHeight());
        }
    }

    @Override
    public void setText(String string) {
        String string2 = this.getText();
        super.setText(string);
        bu bu2 = this.getGraph2D();
        if (bu2 == null) return;
        bu2.a(this, "text", string2, this.getText());
    }

    public void setDistance(double d2) {
        this.nb = d2;
        if (this.kb instanceof aO) {
            ((aO)this.kb).a(this.nb, this.nb);
        }
        if (this.kb instanceof z) {
            ((z)this.kb).a(this.nb);
        }
        if (this.kb instanceof aJ) {
            ((aJ)this.kb).a(d2);
        }
        if (this.kb instanceof aL) {
            ((aL)this.kb).a(d2);
        }
        if (this.kb instanceof s) {
            ((s)this.kb).a(d2);
        }
        this.setOffsetDirty();
    }

    @Override
    public void setOffset(double d2, double d3) {
        super.setOffset(d2, d3);
        if (!(this.kb instanceof K)) return;
        Object object = this.getBestModelParameterForOffset(d2, d3);
        if (object == null) return;
        this.sb = object;
        this.pb.h();
    }

    public double getDistance() {
        return this.nb;
    }

    public void setPreferredPlacement(byte by2) {
        this.mb = aG.g(by2);
    }

    public byte getPreferredPlacement() {
        byte by2 = this.mb.a();
        byte by3 = this.mb.b();
        return (byte)(by2 | by3);
    }

    @Override
    public aG getPreferredPlacementDescriptor() {
        return this.mb;
    }

    public void setPreferredPlacementDescriptor(aG aG2) {
        if (aG2 == null) {
            throw new IllegalArgumentException("null");
        }
        this.mb = aG2;
    }

    public double getRatio() {
        if (this.kb instanceof aO) {
            aB aB2 = this.getOwner();
            aP aP2 = (aP)this.b(this.getOrientedBox(), aB2);
            return aP2.e();
        }
        if (!(this.sb instanceof u)) return 0.5;
        u u2 = (u)this.sb;
        if (u2.b() >= 0) return 0.5;
        return u2.a();
    }

    public void setRatio(double d2) {
        aP aP2;
        aP aP3;
        block4 : {
            boolean bl2 = fj.z;
            if (this.kb instanceof s) {
                this.setModelParameter(new u(d2, -1));
            }
            if (!(this.kb instanceof aO)) return;
            aO aO2 = (aO)this.kb;
            aB aB2 = this.getOwner();
            if (aB2 == null) return;
            aP aP4 = (aP)this.b(this.getOrientedBox(), aB2);
            aP3 = null;
            double d3 = Double.MAX_VALUE;
            D d4 = aO2.a(this, (I)aB2, (am)aB2.getSourceRealizer(), (am)aB2.getTargetRealizer());
            C c2 = d4.m();
            while (c2.f()) {
                aP aP5;
                B b2 = (B)c2.d();
                aP2 = aP5 = (aP)b2.b();
                if (!bl2) {
                    if (Math.abs(aP2.e() - d2) < d3 && aP5.d() == aP4.d()) {
                        d3 = Math.abs(aP5.e() - d2);
                        aP3 = aP5;
                    }
                    c2.g();
                    if (!bl2) continue;
                }
                break block4;
            }
            aP2 = aP3;
        }
        if (aP2 == null) return;
        this.setModelParameter(aP3);
    }

    @Override
    public Object getBestModelParameterForBounds(n n2) {
        if (this.kb == null) return null;
        aB aB2 = this.getOwner();
        if (aB2 == null) return null;
        if (aB2.getEdge() == null) return null;
        if (aB2.getEdge().a() == null) return null;
        return this.b(n2, aB2);
    }

    public Object getBestModelParameterForOffset(double d2, double d3) {
        aB aB2 = this.getOwner();
        if (aB2 == null) return null;
        Point2D point2D = aB2.getSourceIntersection();
        return this.b(this.d(point2D.getX() + d2, point2D.getY() + d3), aB2);
    }

    public Object getBestModelParameterForLocation(double d2, double d3) {
        aB aB2 = this.getOwner();
        if (aB2 == null) return null;
        return this.b(this.d(d2, d3), aB2);
    }

    private n d(double d2, double d3) {
        double d4 = this.getHeight();
        return new n(d2, d3 + d4, this.getWidth(), d4, 0.0, -1.0);
    }

    public boolean hasFreePositioning() {
        if (this.model != 4) return false;
        return true;
    }

    public boolean hasSliderPositioning() {
        if (this.model == 5) return true;
        if (this.model == 6) return true;
        return false;
    }

    @Override
    public void setModel(byte by2) {
        boolean bl2 = fj.z;
        if (by2 == this.model) {
            return;
        }
        if (by2 >= 0 && by2 <= 7) {
            Object object;
            aB aB2 = this.pb;
            boolean bl3 = aB2 != null && aB2.getEdge() != null && aB2.getEdge().a() != null;
            this.model = by2;
            E e2 = this.kb;
            switch (this.model) {
                case 0: {
                    this.kb = aA.b(18, this.nb);
                    if (!bl2) break;
                }
                case 1: {
                    this.kb = aA.b(128, this.nb);
                    if (!bl2) break;
                }
                case 2: {
                    this.kb = aA.b(63, this.nb);
                    if (!bl2) break;
                }
                case 3: {
                    this.kb = aA.b(448, this.nb);
                    if (!bl2) break;
                }
                case 4: {
                    this.kb = new K();
                    if (!bl2) break;
                }
                case 5: {
                    this.kb = aA.b(0, this.nb);
                    if (!bl2) break;
                }
                case 6: {
                    this.kb = aA.b(1, this.nb);
                }
            }
            if (e2 instanceof z && this.kb instanceof z && (object = (z)this.kb).a(this.sb)) {
                if (this.nb == ((z)e2).b()) return;
                this.setOffsetDirty();
                return;
            }
            this.sb = this.kb.c();
            if (this.kb instanceof K && bl3) {
                object = this.pb.getSourceIntersection();
                double d2 = this.offsetRectangle.f();
                double d3 = this.offsetRectangle.g();
                double d4 = this.offsetRectangle.i();
                double d5 = this.offsetRectangle.b() + d2 * d3;
                double d6 = this.offsetRectangle.c() + d2 * d4;
                double d7 = this.height;
                n n2 = new n(d5 - d7 * d3 + object.getX(), d6 - d7 * d4 + object.getY(), this.width, d7, d3, d4);
                this.sb = this.b(n2, aB2);
            }
            this.placement = this.getPosition();
            this.setOffsetDirty();
            if (!bl2) return;
        }
        if (127 != by2) return;
        this.model = 127;
        this.kb = null;
    }

    private static E b(int n2, double d2) {
        z z2 = new z(n2);
        z2.a(d2);
        return z2;
    }

    private static aO b(byte by2, double d2) {
        aO aO2 = new aO(by2);
        aO2.a(d2, d2);
        return aO2;
    }

    @Override
    public byte getPosition() {
        int n2;
        if (this.kb instanceof z) {
            n2 = (Integer)this.sb;
            switch (n2) {
                case 1: {
                    return 13;
                }
                case 2: {
                    return 10;
                }
                case 4: {
                    return 14;
                }
                case 64: {
                    return 17;
                }
                case 128: {
                    return 12;
                }
                case 256: {
                    return 18;
                }
                case 8: {
                    return 15;
                }
                case 16: {
                    return 11;
                }
                case 32: {
                    return 16;
                }
            }
        }
        if (this.kb instanceof aJ) {
            n2 = aJ.a(this.sb);
            switch (n2) {
                case 1: {
                    return 13;
                }
                case 2: {
                    return 10;
                }
                case 4: {
                    return 14;
                }
                case 64: {
                    return 17;
                }
                case 128: {
                    return 12;
                }
                case 256: {
                    return 18;
                }
                case 8: {
                    return 15;
                }
                case 16: {
                    return 11;
                }
                case 32: {
                    return 16;
                }
            }
        }
        if (this.kb instanceof K) {
            return 99;
        }
        if (this.kb instanceof aO) {
            return 24;
        }
        if (!(this.kb instanceof aL)) return 127;
        return 24;
    }

    @Override
    public void setPosition(byte by2) {
        if (this.kb instanceof z) {
            this.b(by2);
            if (!fj.z) return;
        }
        if (!(this.kb instanceof aJ)) return;
        this.c(by2);
    }

    private void b(byte by2) {
        boolean bl2 = fj.z;
        z z2 = (z)this.kb;
        int n2 = 0;
        switch (by2) {
            case 13: {
                n2 = 1;
                if (!bl2) break;
            }
            case 10: {
                n2 = 2;
                if (!bl2) break;
            }
            case 14: {
                n2 = 4;
                if (!bl2) break;
            }
            case 17: {
                n2 = 64;
                if (!bl2) break;
            }
            case 12: {
                n2 = 128;
                if (!bl2) break;
            }
            case 18: {
                n2 = 256;
                if (!bl2) break;
            }
            case 15: {
                n2 = 8;
                if (!bl2) break;
            }
            case 11: {
                n2 = 16;
                if (!bl2) break;
            }
            case 16: {
                n2 = 32;
            }
        }
        Object object = z.a(n2);
        if (z2.a(object)) {
            this.sb = object;
        }
        this.setOffsetDirty();
    }

    private void c(byte by2) {
        boolean bl2 = fj.z;
        aJ aJ2 = (aJ)this.kb;
        int n2 = 0;
        switch (by2) {
            case 13: {
                n2 = 1;
                if (!bl2) break;
            }
            case 10: {
                n2 = 2;
                if (!bl2) break;
            }
            case 14: {
                n2 = 4;
                if (!bl2) break;
            }
            case 17: {
                n2 = 64;
                if (!bl2) break;
            }
            case 12: {
                n2 = 128;
                if (!bl2) break;
            }
            case 18: {
                n2 = 256;
                if (!bl2) break;
            }
            case 15: {
                n2 = 8;
                if (!bl2) break;
            }
            case 11: {
                n2 = 16;
                if (!bl2) break;
            }
            case 16: {
                n2 = 32;
            }
        }
        Object object = aJ.a(n2);
        if (aJ2.b(object)) {
            this.sb = object;
        }
        this.setOffsetDirty();
    }

    public static Map modelToStringMap() {
        LinkedHashMap<Byte, String> linkedHashMap = new LinkedHashMap<Byte, String>(11);
        linkedHashMap.put(new Byte(1), "Centered");
        linkedHashMap.put(new Byte(0), "2 Pos");
        linkedHashMap.put(new Byte(2), "6 Pos");
        linkedHashMap.put(new Byte(3), "3 Pos Center");
        linkedHashMap.put(new Byte(4), "Free");
        linkedHashMap.put(new Byte(5), "Center Slider");
        linkedHashMap.put(new Byte(6), "Side Slider");
        return linkedHashMap;
    }

    public static Map positionToStringMap() {
        LinkedHashMap<Byte, String> linkedHashMap = new LinkedHashMap<Byte, String>(21);
        linkedHashMap.put(new Byte(10), "Head");
        linkedHashMap.put(new Byte(11), "Tail");
        linkedHashMap.put(new Byte(12), "Center");
        linkedHashMap.put(new Byte(13), "Source Head");
        linkedHashMap.put(new Byte(14), "Target Head");
        linkedHashMap.put(new Byte(15), "Source Tail");
        linkedHashMap.put(new Byte(16), "Target Tail");
        linkedHashMap.put(new Byte(99), "Anywhere");
        linkedHashMap.put(new Byte(19), "Center");
        linkedHashMap.put(new Byte(20), "Tail");
        linkedHashMap.put(new Byte(21), "Head");
        linkedHashMap.put(new Byte(24), "Dynamic");
        linkedHashMap.put(new Byte(17), "Source Center");
        linkedHashMap.put(new Byte(18), "Target Center");
        linkedHashMap.put(new Byte(127), "Undefined");
        return linkedHashMap;
    }

    public static Map preferredPlacementsToStringMap() {
        LinkedHashMap<Byte, String> linkedHashMap = new LinkedHashMap<Byte, String>(3);
        linkedHashMap.put(new Byte(34), "At Target (right)");
        linkedHashMap.put(new Byte(2), "At Target");
        linkedHashMap.put(new Byte(18), "At Target (left)");
        linkedHashMap.put(new Byte(33), "At Source (right)");
        linkedHashMap.put(new Byte(1), "At Source");
        linkedHashMap.put(new Byte(17), "At Source (left)");
        linkedHashMap.put(new Byte(36), "At Center (right)");
        linkedHashMap.put(new Byte(4), "At Center");
        linkedHashMap.put(new Byte(20), "At Center (left)");
        linkedHashMap.put(new Byte(4), "At Center");
        linkedHashMap.put(new Byte(0), "Anywhere");
        return linkedHashMap;
    }

    public static final byte[] getModelPositions(byte by2) {
        return jb[by2];
    }

    public byte[] getModelPositions() {
        return aA.getModelPositions(this.getModel());
    }

    /*
     * Unable to fully structure code
     */
    public static Vector availablePositions(Byte var0) {
        var4_1 = fj.z;
        var1_2 = new Vector<Byte>(10);
        if (var0 == null) ** GOTO lbl10
        var2_3 = aA.getModelPositions(var0.byteValue());
        for (var3_4 = 0; var3_4 < var2_3.length; ++var3_4) {
            v0 = var1_2;
            if (var4_1 != false) return v0;
            v0.add(new Byte(var2_3[var3_4]));
            if (!var4_1) continue;
lbl10: // 2 sources:
            var1_2.add(new Byte(127));
            break;
        }
        v0 = var1_2;
        return v0;
    }

    public d getEdge() {
        if (this.pb == null) return null;
        d d2 = this.pb.getEdge();
        return d2;
    }

    protected bu getGraph2D() {
        d d2 = this.getEdge();
        if (d2 != null) return (bu)d2.a();
        return null;
    }

    public aB getRealizer() {
        return this.getOwner();
    }

    public aB getOwner() {
        return this.pb;
    }

    public void bindRealizer(aB aB2) {
        this.pb = aB2;
        this.setOffsetDirty();
    }

    @Override
    public E getLabelModel() {
        return this.kb;
    }

    @Override
    public Object getModelParameter() {
        return this.sb;
    }

    @Override
    public void setModelParameter(Object object) {
        this.b(object);
        this.setOffsetDirty();
    }

    private void b(Object object) {
        this.sb = object;
        this.placement = this.getPosition();
    }

    public void setLabelModel(E e2) {
        this.b(e2);
        this.setOffsetDirty();
    }

    public void setLabelModel(E e2, Object object) {
        this.b(e2);
        this.b(object);
        this.setOffsetDirty();
    }

    private void b(E e2) {
        int n2;
        boolean bl2 = fj.z;
        this.kb = e2;
        if (e2 == null) {
            this.model = 127;
            if (!bl2) return;
        }
        Class class_ = class$y$layout$DiscreteEdgeLabelModel == null ? (aA.class$y$layout$DiscreteEdgeLabelModel = aA.class$("y.f.z")) : class$y$layout$DiscreteEdgeLabelModel;
        if (e2.getClass() == class_) {
            n2 = ((z)e2).a();
            switch (n2) {
                case 18: {
                    this.model = 0;
                    if (!bl2) return;
                }
                case 128: {
                    this.model = 1;
                    if (!bl2) return;
                }
                case 63: {
                    this.model = 2;
                    if (!bl2) return;
                }
                case 448: {
                    this.model = 3;
                    if (!bl2) return;
                }
            }
            this.model = 127;
            if (!bl2) return;
        }
        Class class_2 = class$y$layout$FreeEdgeLabelModel == null ? (aA.class$y$layout$FreeEdgeLabelModel = aA.class$("y.f.K")) : class$y$layout$FreeEdgeLabelModel;
        if (e2.getClass() == class_2) {
            this.model = 4;
            if (!bl2) return;
        }
        Class class_3 = class$y$layout$SliderEdgeLabelModel == null ? (aA.class$y$layout$SliderEdgeLabelModel = aA.class$("y.f.aO")) : class$y$layout$SliderEdgeLabelModel;
        if (e2.getClass() == class_3) {
            n2 = ((aO)e2).a();
            switch (n2) {
                case 0: {
                    this.model = 5;
                    if (!bl2) return;
                }
                case 1: {
                    this.model = 6;
                    if (!bl2) return;
                }
            }
            this.model = 127;
            if (!bl2) return;
        }
        this.model = 127;
    }

    @Override
    public void setOffsetDirty() {
        super.setOffsetDirty();
        if (this.pb == null) return;
        this.pb.h();
    }

    @Override
    public void setSizeDirty() {
        super.setSizeDirty();
        if (this.pb == null) return;
        this.pb.h();
        this.pb.labelBoundsChanged();
    }

    @Override
    public n getOrientedBox() {
        Point2D point2D = this.pb.getSourceIntersection();
        n n2 = this.getOffset();
        return n2.f(point2D.getX(), point2D.getY());
    }

    @Override
    public void repaint() {
        if (this.pb == null) return;
        if (this.pb.i() == null) return;
        y y2 = this.getBox();
        this.pb.i().a(y2.c(), y2.d(), y2.a(), y2.b());
    }

    @Override
    public void write(ObjectOutputStream objectOutputStream) {
        objectOutputStream.writeByte(2);
        super.write(objectOutputStream);
        objectOutputStream.writeFloat((float)this.rb);
        objectOutputStream.writeFloat((float)this.getDistance());
    }

    @Override
    public void read(ObjectInputStream objectInputStream) {
        boolean bl2 = fj.z;
        switch (objectInputStream.readByte()) {
            Point2D point2D;
            aB aB2;
            case 0: {
                super.read(objectInputStream);
                if (objectInputStream.readBoolean()) {
                    this.setBackgroundColor(Color.white);
                }
                this.rb = objectInputStream.readFloat();
                if (!bl2) return;
            }
            case 1: {
                super.read(objectInputStream);
                this.rb = objectInputStream.readFloat();
                if (this.model != 5) {
                    if (this.model != 6) return;
                }
                if ((aB2 = this.getOwner()) == null) return;
                point2D = aB2.getSourceIntersection();
                this.setModelParameter(this.b(this.offsetRectangle.f(point2D.getX(), point2D.getY()), aB2));
                if (!bl2) return;
            }
            case 2: {
                super.read(objectInputStream);
                this.rb = objectInputStream.readFloat();
                if ((this.model == 5 || this.model == 6) && (aB2 = this.getOwner()) != null) {
                    point2D = aB2.getSourceIntersection();
                    this.setModelParameter(this.b(this.offsetRectangle.f(point2D.getX(), point2D.getY()), aB2));
                }
                this.setDistance(objectInputStream.readFloat());
                if (!bl2) return;
            }
        }
        throw new a();
    }

    private Object b(n n2, aB aB2) {
        return this.kb.a(n2, (I)aB2, (am)aB2.getSourceRealizer(), (am)aB2.getTargetRealizer());
    }

    @Override
    public void setConfiguration(String string) {
        aA.getFactory().a(this, string);
    }

    public static hb getFactory() {
        return ob;
    }

    static Class class$(String string) {
        try {
            return Class.forName(string);
        }
        catch (ClassNotFoundException var1_1) {
            throw new NoClassDefFoundError(var1_1.getMessage());
        }
    }

    static {
        HashMap<Class, Object> hashMap = new HashMap<Class, Object>();
        Class class_ = class$y$view$YLabel$BoundsProvider == null ? (aA.class$y$view$YLabel$BoundsProvider = aA.class$("y.h.ha")) : class$y$view$YLabel$BoundsProvider;
        hashMap.put(class_, hh.d);
        Class class_2 = class$y$view$YLabel$Layout == null ? (aA.class$y$view$YLabel$Layout = aA.class$("y.h.hc")) : class$y$view$YLabel$Layout;
        hashMap.put(class_2, hh.d);
        Class class_3 = class$y$view$YLabel$Painter == null ? (aA.class$y$view$YLabel$Painter = aA.class$("y.h.hd")) : class$y$view$YLabel$Painter;
        hashMap.put(class_3, hh.d);
        Class class_4 = class$y$view$YLabel$UserDataHandler == null ? (aA.class$y$view$YLabel$UserDataHandler = aA.class$("y.h.hf")) : class$y$view$YLabel$UserDataHandler;
        hashMap.put(class_4, new gs(0));
        qb = new hg(hashMap, hashMap, null);
        ob = new hb(hashMap);
        hashMap = new HashMap();
        hashMap.put(class$y$view$YLabel$Painter == null ? (aA.class$y$view$YLabel$Painter = aA.class$("y.h.hd")) : class$y$view$YLabel$Painter, new hj());
        ob.a("CroppingLabel", hashMap);
        hashMap = new HashMap();
        ay ay2 = new ay();
        ay2.a(true);
        hashMap.put(class$y$view$YLabel$Painter == null ? (aA.class$y$view$YLabel$Painter = aA.class$("y.h.hd")) : class$y$view$YLabel$Painter, ay2);
        ob.a("AutoFlippingLabel", hashMap);
    }
}

