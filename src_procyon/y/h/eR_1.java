package y.h;

import y.c.*;
import y.f.*;
import y.d.*;
import java.awt.geom.*;
import java.io.*;
import y.e.*;
import java.util.*;

public class eR extends gZ implements aj
{
    private static final byte[][] i;
    fj a;
    private al r;
    private Object A;
    private double B;
    private static final hg C;
    private static final hb D;
    static Class b;
    static Class c;
    static Class d;
    static Class e;
    static Class f;
    static Class g;
    static Class h;
    
    public void setAutoSizePolicy(final byte autoSizePolicy) {
        super.setAutoSizePolicy(autoSizePolicy);
    }
    
    public void setConfiguration(final String s) {
        d().a(this, s);
    }
    
    public static hb d() {
        return eR.D;
    }
    
    public eR(final String text, final byte model) {
        this.A = new Integer(1);
        this.B = 4.0;
        this.r = new A(130816, this.B);
        this.A = this.r.c();
        this.setModel(model);
        this.setText(text);
    }
    
    public eR(final String s) {
        this(s, (byte)1);
    }
    
    void b() {
        if (this.a != null && this.a.getNode() != null) {
            final i e = this.a.getNode().e();
            if (e instanceof bu) {
                ((bu)e).e(this);
            }
        }
    }
    
    public eR() {
        this("");
    }
    
    public Object clone() {
        final eR er = new eR();
        er.adoptValues(this);
        return er;
    }
    
    public void adoptValues(final gZ gz) {
        super.adoptValues(gz);
        if (gz instanceof eR) {
            final eR er = (eR)gz;
            this.a(er.e());
            if (this.getModel() == 127 || this.a() == null) {
                this.a(er.a(), er.getModelParameter());
                if (!fj.z) {
                    return;
                }
            }
            this.setModelParameter(er.getModelParameter());
        }
    }
    
    public void setOffset(final double n, final double n2) {
        super.setOffset(n, n2);
        if (this.r instanceof M) {
            this.A = new N(n, n2);
        }
    }
    
    public void setOffsetDirty() {
        if (this.v == 2 || this.v == 1 || this.v == 3) {
            this.setSizeDirty();
        }
        super.setOffsetDirty();
    }
    
    public void setSizeDirty() {
        super.setSizeDirty();
        if (this.a != null) {
            this.a.labelBoundsChanged(this);
        }
    }
    
    hg c() {
        return eR.C;
    }
    
    public void setText(final String text) {
        final String text2 = this.getText();
        if (text.equals(text2)) {
            return;
        }
        super.setText(text);
        final bu h = this.h();
        if (h != null) {
            h.a(this, "text", text2, this.getText());
        }
    }
    
    public void a(final double b) {
        this.B = b;
        if (this.r instanceof A) {
            ((A)this.r).a(this.B);
        }
        this.setOffsetDirty();
    }
    
    public double e() {
        return this.B;
    }
    
    public al a() {
        return this.r;
    }
    
    public void a(final al al, final Object o) {
        this.a(al);
        this.a(o);
        this.setOffsetDirty();
    }
    
    private void a(final al r) {
        final boolean z = fj.z;
        this.r = r;
        if (r == null) {
            this.model = 127;
            if (!z) {
                return;
            }
        }
        if (r.getClass() == ((eR.f == null) ? (eR.f = a("y.f.A")) : eR.f)) {
            Label_0148: {
                switch (((A)r).a()) {
                    case 57: {
                        this.model = 3;
                        if (z) {
                            break Label_0148;
                        }
                        return;
                    }
                    case 198: {
                        this.model = 0;
                        if (z) {
                            break Label_0148;
                        }
                        return;
                    }
                    case 130816: {
                        this.model = 1;
                        if (z) {
                            break Label_0148;
                        }
                        return;
                    }
                    case 33: {
                        this.model = 2;
                        if (z) {
                            break Label_0148;
                        }
                        return;
                    }
                    case 255: {
                        this.model = 5;
                        if (z) {
                            break;
                        }
                        return;
                    }
                }
            }
            this.model = 127;
            if (!z) {
                return;
            }
        }
        if (r.getClass() == ((eR.g == null) ? (eR.g = a("y.f.M")) : eR.g)) {
            this.model = 4;
            if (!z) {
                return;
            }
        }
        if (r.getClass() == ((eR.h == null) ? (eR.h = a("y.f.J")) : eR.h)) {
            this.model = 6;
            if (!z) {
                return;
            }
        }
        this.model = 127;
    }
    
    public Object getModelParameter() {
        return this.A;
    }
    
    public void setModelParameter(final Object o) {
        this.a(o);
        this.setOffsetDirty();
    }
    
    private void a(final Object a) {
        this.A = a;
        this.placement = this.getPosition();
    }
    
    public Object getBestModelParameterForBounds(final n n) {
        if (this.r != null) {
            final fj g = this.g();
            if (g != null) {
                return this.r.a(n, g);
            }
        }
        return null;
    }
    
    public void setModel(final byte model) {
        if (model >= 0 && model <= 6) {
            final fj a = this.a;
            this.model = model;
            final al r = this.r;
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
                    break;
                }
            }
            if (r instanceof A && this.r instanceof A && ((A)this.r).a(this.A)) {
                if (this.B != ((A)r).b()) {
                    this.setOffsetDirty();
                }
                return;
            }
            this.A = this.r.c();
            if (this.r instanceof M && a != null) {
                final double f = this.offsetRectangle.f();
                final double g = this.offsetRectangle.g();
                final double i = this.offsetRectangle.i();
                final double n = this.offsetRectangle.b() + f * g;
                final double n2 = this.offsetRectangle.c() + f * i;
                final double height = this.height;
                this.A = this.r.a(new n(n - height * g + this.a.getX(), n2 - height * i + this.a.getY(), this.width, height, g, i), a);
            }
            this.placement = this.getPosition();
            this.setOffsetDirty();
        }
        else if (127 == model) {
            this.model = 127;
            this.r = null;
        }
    }
    
    public void setPosition(final byte b) {
        if (!(this.r instanceof A)) {
            return;
        }
        final A a = (A)this.r;
        int n = 0;
        switch (b) {
            case 100: {
                n = 256;
                break;
            }
            case 101: {
                n = 512;
                break;
            }
            case 102: {
                n = 1024;
                break;
            }
            case 117: {
                n = 8192;
                break;
            }
            case 118: {
                n = 16384;
                break;
            }
            case 119: {
                n = 32768;
                break;
            }
            case 120: {
                n = 65536;
                break;
            }
            case 115: {
                n = 2048;
                break;
            }
            case 116: {
                n = 4096;
                break;
            }
            case 104: {
                n = 2;
                break;
            }
            case 105: {
                n = 4;
                break;
            }
            case 106: {
                n = 128;
                break;
            }
            case 107: {
                n = 64;
                break;
            }
            case 108: {
                n = 1;
                break;
            }
            case 109: {
                n = 32;
                break;
            }
            case 110: {
                n = 8;
                break;
            }
            case 111: {
                n = 16;
                break;
            }
        }
        final Integer a2 = new Integer(n);
        if (a.a(a2)) {
            this.A = a2;
            this.setOffsetDirty();
            return;
        }
        System.err.println("NLabel::setPos: ERROR: pos " + b + " not valid for model " + this.model);
    }
    
    public byte getPosition() {
        if (this.r instanceof A) {
            switch ((int)this.A) {
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
        if (this.r instanceof J) {
            return 112;
        }
        return 113;
    }
    
    public boolean isOffsetDirty() {
        return this.model == 6 || super.isOffsetDirty();
    }
    
    public void calculateOffset() {
        final fj a = this.a;
        final n a2 = this.a().a(new q(this.getWidth(), this.getHeight()), a, this.getModelParameter());
        a2.d(-a.getX(), -a.getY());
        super.setOffset(a2);
    }
    
    public y.c.q f() {
        if (this.a != null) {
            return this.a.getNode();
        }
        return null;
    }
    
    public fj g() {
        return this.a;
    }
    
    public bu h() {
        final y.c.q f = this.f();
        if (f != null) {
            return (bu)f.e();
        }
        return null;
    }
    
    public void a(final fj a) {
        this.a = a;
        this.setOffsetDirty();
    }
    
    public n getOrientedBox() {
        return this.getOffset().f(this.a.getX(), this.a.getY());
    }
    
    public void repaint() {
        if (this.a != null && this.a.d() != null) {
            final y box = this.getBox();
            this.a.d().a(box.c(), box.d(), box.a(), box.b());
        }
    }
    
    public boolean intersects(final double n, final double n2, final double n3, final double n4) {
        if (this.isSizeDirty()) {
            this.calculateSize();
        }
        if (this.isOffsetDirty()) {
            this.calculateOffset();
        }
        return n.a(this.getOrientedBox(), new y(n, n2, n3, n4), 0.0);
    }
    
    public void calcUnionRect(final Rectangle2D rectangle2D) {
        if (this.isSizeDirty()) {
            this.calculateSize();
        }
        if (this.isOffsetDirty()) {
            this.calculateOffset();
        }
        if (rectangle2D.getWidth() < 0.0) {
            final y box = this.getBox();
            rectangle2D.setFrame(box.c, box.d, box.a, box.b);
            if (!fj.z) {
                return;
            }
        }
        final y box2 = this.getBox();
        rectangle2D.setFrameFromDiagonal(Math.min(box2.c, rectangle2D.getX()), Math.min(box2.d, rectangle2D.getY()), Math.max(box2.c + box2.a, rectangle2D.getX() + rectangle2D.getWidth()), Math.max(box2.d + box2.b, rectangle2D.getY() + rectangle2D.getHeight()));
    }
    
    public void write(final ObjectOutputStream objectOutputStream) {
        objectOutputStream.writeByte(2);
        super.write(objectOutputStream);
        objectOutputStream.writeDouble(this.e());
    }
    
    public void read(final ObjectInputStream objectInputStream) {
        final boolean z = fj.z;
        Label_0070: {
            switch (objectInputStream.readByte()) {
                case 0: {
                    super.read(objectInputStream);
                    if (z) {
                        break Label_0070;
                    }
                    return;
                }
                case 1: {
                    super.read(objectInputStream);
                    this.a(objectInputStream.readDouble());
                    this.setAutoSizePolicy(objectInputStream.readByte());
                    if (z) {
                        break Label_0070;
                    }
                    return;
                }
                case 2: {
                    super.read(objectInputStream);
                    this.a(objectInputStream.readDouble());
                    if (z) {
                        break;
                    }
                    return;
                }
            }
        }
        throw new a();
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
        i = new byte[][] { { 104, 105, 106, 107 }, { 100, 102, 101, 115, 116, 117, 118, 119, 120 }, { 108, 109 }, { 108, 109, 111, 110 }, { 114 }, { 108, 109, 110, 111, 104, 105, 107, 106 }, { 112 } };
        final HashMap<Class, eS> hashMap = new HashMap<Class, eS>();
        hashMap.put((eR.b == null) ? (eR.b = a("y.h.hd")) : eR.b, hh.d);
        hashMap.put((eR.c == null) ? (eR.c = a("y.h.ha")) : eR.c, hh.d);
        hashMap.put((eR.d == null) ? (eR.d = a("y.h.hc")) : eR.d, (hh)new eS());
        hashMap.put((eR.e == null) ? (eR.e = a("y.h.hf")) : eR.e, (hh)new gs((byte)0));
        C = new hg(hashMap, hashMap, null);
        D = new hb(hashMap);
        final HashMap<Class, eT> hashMap2 = new HashMap<Class, eT>();
        hashMap2.put((eR.d == null) ? (eR.d = a("y.h.hc")) : eR.d, new eT());
        hashMap2.put((eR.b == null) ? (eR.b = a("y.h.hd")) : eR.b, (eT)new hj());
        eR.D.a("CroppingLabel", hashMap2);
    }
}
