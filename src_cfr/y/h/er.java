/*
 * Decompiled with CFR 0_115.
 */
package y.h;

import java.awt.geom.Rectangle2D;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.PrintStream;
import java.util.HashMap;
import java.util.Map;
import y.c.i;
import y.d.n;
import y.d.q;
import y.d.y;
import y.e.a;
import y.f.A;
import y.f.J;
import y.f.M;
import y.f.N;
import y.f.X;
import y.f.aj;
import y.f.al;
import y.f.am;
import y.h.bu;
import y.h.eS;
import y.h.eT;
import y.h.fj;
import y.h.gZ;
import y.h.gs;
import y.h.hb;
import y.h.hg;
import y.h.hh;
import y.h.hj;

public class eR
extends gZ
implements aj {
    private static final byte[][] i = new byte[][]{{104, 105, 106, 107}, {100, 102, 101, 115, 116, 117, 118, 119, 120}, {108, 109}, {108, 109, 111, 110}, {114}, {108, 109, 110, 111, 104, 105, 107, 106}, {112}};
    fj a;
    private al r;
    private Object A = new Integer(1);
    private double B = 4.0;
    private static final hg C;
    private static final hb D;
    static Class b;
    static Class c;
    static Class d;
    static Class e;
    static Class f;
    static Class g;
    static Class h;

    @Override
    public void setAutoSizePolicy(byte by2) {
        super.setAutoSizePolicy(by2);
    }

    @Override
    public void setConfiguration(String string) {
        eR.d().a(this, string);
    }

    public static hb d() {
        return D;
    }

    public eR(String string, byte by2) {
        this.r = new A(130816, this.B);
        this.A = this.r.c();
        this.setModel(by2);
        this.setText(string);
    }

    public eR(String string) {
        this(string, 1);
    }

    @Override
    void b() {
        if (this.a == null) return;
        if (this.a.getNode() == null) return;
        i i2 = this.a.getNode().e();
        if (!(i2 instanceof bu)) return;
        bu bu2 = (bu)i2;
        bu2.e(this);
    }

    public eR() {
        this("");
    }

    public Object clone() {
        eR eR2 = new eR();
        eR2.adoptValues(this);
        return eR2;
    }

    @Override
    public void adoptValues(gZ gZ2) {
        super.adoptValues(gZ2);
        if (!(gZ2 instanceof eR)) return;
        eR eR2 = (eR)gZ2;
        this.a(eR2.e());
        if (this.getModel() == 127 || this.a() == null) {
            this.a(eR2.a(), eR2.getModelParameter());
            if (!fj.z) return;
        }
        this.setModelParameter(eR2.getModelParameter());
    }

    @Override
    public void setOffset(double d2, double d3) {
        super.setOffset(d2, d3);
        if (!(this.r instanceof M)) return;
        this.A = new N(d2, d3);
    }

    @Override
    public void setOffsetDirty() {
        if (this.v == 2 || this.v == 1 || this.v == 3) {
            this.setSizeDirty();
        }
        super.setOffsetDirty();
    }

    @Override
    public void setSizeDirty() {
        super.setSizeDirty();
        if (this.a == null) return;
        this.a.labelBoundsChanged(this);
    }

    @Override
    hg c() {
        return C;
    }

    @Override
    public void setText(String string) {
        String string2 = this.getText();
        if (string.equals(string2)) {
            return;
        }
        super.setText(string);
        bu bu2 = this.h();
        if (bu2 == null) return;
        bu2.a(this, "text", string2, this.getText());
    }

    public void a(double d2) {
        this.B = d2;
        if (this.r instanceof A) {
            ((A)this.r).a(this.B);
        }
        this.setOffsetDirty();
    }

    public double e() {
        return this.B;
    }

    @Override
    public al a() {
        return this.r;
    }

    public void a(al al2, Object object) {
        this.a(al2);
        this.a(object);
        this.setOffsetDirty();
    }

    private void a(al al2) {
        boolean bl2 = fj.z;
        this.r = al2;
        if (al2 == null) {
            this.model = 127;
            if (!bl2) return;
        }
        Class class_ = f == null ? (eR.f = eR.a("y.f.A")) : f;
        if (al2.getClass() == class_) {
            int n2 = ((A)al2).a();
            switch (n2) {
                case 57: {
                    this.model = 3;
                    if (!bl2) return;
                }
                case 198: {
                    this.model = 0;
                    if (!bl2) return;
                }
                case 130816: {
                    this.model = 1;
                    if (!bl2) return;
                }
                case 33: {
                    this.model = 2;
                    if (!bl2) return;
                }
                case 255: {
                    this.model = 5;
                    if (!bl2) return;
                }
            }
            this.model = 127;
            if (!bl2) return;
        }
        Class class_2 = g == null ? (eR.g = eR.a("y.f.M")) : g;
        if (al2.getClass() == class_2) {
            this.model = 4;
            if (!bl2) return;
        }
        Class class_3 = h == null ? (eR.h = eR.a("y.f.J")) : h;
        if (al2.getClass() == class_3) {
            this.model = 6;
            if (!bl2) return;
        }
        this.model = 127;
    }

    @Override
    public Object getModelParameter() {
        return this.A;
    }

    @Override
    public void setModelParameter(Object object) {
        this.a(object);
        this.setOffsetDirty();
    }

    private void a(Object object) {
        this.A = object;
        this.placement = this.getPosition();
    }

    @Override
    public Object getBestModelParameterForBounds(n n2) {
        if (this.r == null) return null;
        fj fj2 = this.g();
        if (fj2 == null) return null;
        return this.r.a(n2, (am)fj2);
    }

    @Override
    public void setModel(byte by2) {
        if (by2 >= 0 && by2 <= 6) {
            A a2;
            fj fj2 = this.a;
            this.model = by2;
            al al2 = this.r;
            switch (this.model) {
                case 0: {
                    this.r = new A(198, this.B);
                    break;
                }
                case 1: {
                    this.r = new A(130816, this.B);
                    break;
                }
                case 2: {
                    this.r = new A(33, this.B);
                    break;
                }
                case 3: {
                    this.r = new A(57, this.B);
                    break;
                }
                case 4: {
                    this.r = new M();
                    break;
                }
                case 5: {
                    this.r = new A(255, this.B);
                    break;
                }
                case 6: {
                    this.r = new J(this.h(), this.f());
                }
            }
            if (al2 instanceof A && this.r instanceof A && (a2 = (A)this.r).a(this.A)) {
                if (this.B == ((A)al2).b()) return;
                this.setOffsetDirty();
                return;
            }
            this.A = this.r.c();
            if (this.r instanceof M && fj2 != null) {
                double d2 = this.offsetRectangle.f();
                double d3 = this.offsetRectangle.g();
                double d4 = this.offsetRectangle.i();
                double d5 = this.offsetRectangle.b() + d2 * d3;
                double d6 = this.offsetRectangle.c() + d2 * d4;
                double d7 = this.height;
                n n2 = new n(d5 - d7 * d3 + this.a.getX(), d6 - d7 * d4 + this.a.getY(), this.width, d7, d3, d4);
                this.A = this.r.a(n2, (am)fj2);
            }
            this.placement = this.getPosition();
            this.setOffsetDirty();
            return;
        }
        if (127 != by2) return;
        this.model = 127;
        this.r = null;
    }

    @Override
    public void setPosition(byte by2) {
        if (!(this.r instanceof A)) {
            return;
        }
        A a2 = (A)this.r;
        int n2 = 0;
        switch (by2) {
            case 100: {
                n2 = 256;
                break;
            }
            case 101: {
                n2 = 512;
                break;
            }
            case 102: {
                n2 = 1024;
                break;
            }
            case 117: {
                n2 = 8192;
                break;
            }
            case 118: {
                n2 = 16384;
                break;
            }
            case 119: {
                n2 = 32768;
                break;
            }
            case 120: {
                n2 = 65536;
                break;
            }
            case 115: {
                n2 = 2048;
                break;
            }
            case 116: {
                n2 = 4096;
                break;
            }
            case 104: {
                n2 = 2;
                break;
            }
            case 105: {
                n2 = 4;
                break;
            }
            case 106: {
                n2 = 128;
                break;
            }
            case 107: {
                n2 = 64;
                break;
            }
            case 108: {
                n2 = 1;
                break;
            }
            case 109: {
                n2 = 32;
                break;
            }
            case 110: {
                n2 = 8;
                break;
            }
            case 111: {
                n2 = 16;
            }
        }
        Integer n3 = new Integer(n2);
        if (a2.a(n3)) {
            this.A = n3;
            this.setOffsetDirty();
            return;
        }
        System.err.println(new StringBuffer().append("NLabel::setPos: ERROR: pos ").append(by2).append(" not valid for model ").append(this.model).toString());
    }

    @Override
    public byte getPosition() {
        if (this.r instanceof A) {
            int n2 = (Integer)this.A;
            switch (n2) {
                case 256: {
                    return 100;
                }
                case 1024: {
                    return 102;
                }
                case 512: {
                    return 101;
                }
                case 8192: {
                    return 117;
                }
                case 16384: {
                    return 118;
                }
                case 32768: {
                    return 119;
                }
                case 65536: {
                    return 120;
                }
                case 2048: {
                    return 115;
                }
                case 4096: {
                    return 116;
                }
                case 4: {
                    return 105;
                }
                case 2: {
                    return 104;
                }
                case 128: {
                    return 106;
                }
                case 64: {
                    return 107;
                }
                case 1: {
                    return 108;
                }
                case 8: {
                    return 110;
                }
                case 16: {
                    return 111;
                }
                case 32: {
                    return 109;
                }
            }
        }
        if (this.r instanceof M) {
            return 114;
        }
        if (!(this.r instanceof J)) return 113;
        return 112;
    }

    @Override
    public boolean isOffsetDirty() {
        if (this.model != 6) return super.isOffsetDirty();
        return true;
    }

    @Override
    public void calculateOffset() {
        fj fj2 = this.a;
        n n2 = this.a().a(new q(this.getWidth(), this.getHeight()), fj2, this.getModelParameter());
        n2.d(- fj2.getX(), - fj2.getY());
        super.setOffset(n2);
    }

    public y.c.q f() {
        if (this.a == null) return null;
        return this.a.getNode();
    }

    public fj g() {
        return this.a;
    }

    public bu h() {
        y.c.q q2 = this.f();
        if (q2 == null) return null;
        return (bu)q2.e();
    }

    public void a(fj fj2) {
        this.a = fj2;
        this.setOffsetDirty();
    }

    @Override
    public n getOrientedBox() {
        n n2 = this.getOffset();
        return n2.f(this.a.getX(), this.a.getY());
    }

    @Override
    public void repaint() {
        if (this.a == null) return;
        if (this.a.d() == null) return;
        y y2 = this.getBox();
        this.a.d().a(y2.c(), y2.d(), y2.a(), y2.b());
    }

    @Override
    public boolean intersects(double d2, double d3, double d4, double d5) {
        if (this.isSizeDirty()) {
            this.calculateSize();
        }
        if (!this.isOffsetDirty()) return n.a(this.getOrientedBox(), new y(d2, d3, d4, d5), 0.0);
        this.calculateOffset();
        return n.a(this.getOrientedBox(), new y(d2, d3, d4, d5), 0.0);
    }

    @Override
    public void calcUnionRect(Rectangle2D rectangle2D) {
        y y2;
        if (this.isSizeDirty()) {
            this.calculateSize();
        }
        if (this.isOffsetDirty()) {
            this.calculateOffset();
        }
        if (rectangle2D.getWidth() < 0.0) {
            y2 = this.getBox();
            rectangle2D.setFrame(y2.c, y2.d, y2.a, y2.b);
            if (!fj.z) return;
        }
        y2 = this.getBox();
        rectangle2D.setFrameFromDiagonal(Math.min(y2.c, rectangle2D.getX()), Math.min(y2.d, rectangle2D.getY()), Math.max(y2.c + y2.a, rectangle2D.getX() + rectangle2D.getWidth()), Math.max(y2.d + y2.b, rectangle2D.getY() + rectangle2D.getHeight()));
    }

    @Override
    public void write(ObjectOutputStream objectOutputStream) {
        objectOutputStream.writeByte(2);
        super.write(objectOutputStream);
        objectOutputStream.writeDouble(this.e());
    }

    @Override
    public void read(ObjectInputStream objectInputStream) {
        boolean bl2 = fj.z;
        switch (objectInputStream.readByte()) {
            case 0: {
                super.read(objectInputStream);
                if (!bl2) return;
            }
            case 1: {
                super.read(objectInputStream);
                this.a(objectInputStream.readDouble());
                this.setAutoSizePolicy(objectInputStream.readByte());
                if (!bl2) return;
            }
            case 2: {
                super.read(objectInputStream);
                this.a(objectInputStream.readDouble());
                if (!bl2) return;
            }
        }
        throw new a();
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
        HashMap<Class, Object> hashMap = new HashMap<Class, Object>();
        Class class_ = b == null ? (eR.b = eR.a("y.h.hd")) : b;
        hashMap.put(class_, hh.d);
        Class class_2 = c == null ? (eR.c = eR.a("y.h.ha")) : c;
        hashMap.put(class_2, hh.d);
        Class class_3 = d == null ? (eR.d = eR.a("y.h.hc")) : d;
        hashMap.put(class_3, new eS());
        Class class_4 = e == null ? (eR.e = eR.a("y.h.hf")) : e;
        hashMap.put(class_4, new gs(0));
        C = new hg(hashMap, hashMap, null);
        D = new hb(hashMap);
        hashMap = new HashMap();
        hashMap.put(d == null ? (eR.d = eR.a("y.h.hc")) : d, new eT());
        hashMap.put(b == null ? (eR.b = eR.a("y.h.hd")) : b, new hj());
        D.a("CroppingLabel", hashMap);
    }
}

