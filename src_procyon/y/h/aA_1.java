package y.h;

import java.awt.geom.*;
import y.f.*;
import y.c.*;
import y.d.*;
import java.io.*;
import java.awt.*;
import y.e.*;
import java.util.*;

public class aA extends gZ implements C
{
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
    public static final byte UNDEFINED = Byte.MAX_VALUE;
    public static final byte TWO_POS = 0;
    public static final byte CENTERED = 1;
    public static final byte SIX_POS = 2;
    public static final byte THREE_CENTER = 3;
    public static final byte FREE = 4;
    public static final byte CENTER_SLIDER = 5;
    public static final byte SIDE_SLIDER = 6;
    public static final byte CUSTOM_LABEL_MODEL = Byte.MAX_VALUE;
    private static final byte[][] jb;
    private double rb;
    private E kb;
    private Object sb;
    private aB pb;
    private double nb;
    private aG mb;
    private static final hb ob;
    private static final hg qb;
    static Class class$y$view$YLabel$BoundsProvider;
    static Class class$y$view$YLabel$Layout;
    static Class class$y$view$YLabel$Painter;
    static Class class$y$view$YLabel$UserDataHandler;
    static Class class$y$layout$DiscreteEdgeLabelModel;
    static Class class$y$layout$FreeEdgeLabelModel;
    static Class class$y$layout$SliderEdgeLabelModel;
    
    public aA(final String text, final byte model) {
        this.rb = 0.5;
        this.nb = 2.0;
        this.mb = aG.g((byte)0);
        this.kb = new z(63);
        this.sb = this.kb.c();
        this.setModel(model);
        this.setText(text);
    }
    
    hg c() {
        return aA.qb;
    }
    
    public aA(final String s) {
        this(s, (byte)2);
    }
    
    void b() {
        if (this.pb != null && this.pb.getEdge() != null) {
            final i a = this.pb.getEdge().a();
            if (a instanceof bu) {
                ((bu)a).e(this);
            }
        }
    }
    
    public aA() {
        this("");
    }
    
    public Object clone() {
        final aA aa = new aA();
        aa.adoptValues(this);
        return aa;
    }
    
    public void adoptValues(final gZ gz) {
        super.adoptValues(gz);
        if (gz instanceof aA) {
            final aA aa = (aA)gz;
            this.sb = aa.sb;
            this.kb = aa.kb;
            this.nb = aa.nb;
            this.mb = aa.mb;
        }
    }
    
    public void calculateOffset() {
        try {
            final bu graph2D = this.getGraph2D();
            final Point2D sourceIntersection = this.pb.getSourceIntersection();
            final n a = this.getLabelModel().a(new q(this.getWidth(), this.getHeight()), this.pb, graph2D.t(this.getEdge().c()), graph2D.t(this.getEdge().d()), this.getModelParameter());
            a.a(a.a().b(-sourceIntersection.getX(), -sourceIntersection.getY()));
            super.setOffset(a);
        }
        catch (Exception ex) {
            this.offsetRectangle.b(this.getWidth(), this.getHeight());
        }
    }
    
    public void setText(final String text) {
        final String text2 = this.getText();
        super.setText(text);
        final bu graph2D = this.getGraph2D();
        if (graph2D != null) {
            graph2D.a(this, "text", text2, this.getText());
        }
    }
    
    public void setDistance(final double nb) {
        this.nb = nb;
        if (this.kb instanceof aO) {
            ((aO)this.kb).a(this.nb, this.nb);
        }
        if (this.kb instanceof z) {
            ((z)this.kb).a(this.nb);
        }
        if (this.kb instanceof aJ) {
            ((aJ)this.kb).a(nb);
        }
        if (this.kb instanceof aL) {
            ((aL)this.kb).a(nb);
        }
        if (this.kb instanceof s) {
            ((s)this.kb).a(nb);
        }
        this.setOffsetDirty();
    }
    
    public void setOffset(final double n, final double n2) {
        super.setOffset(n, n2);
        if (this.kb instanceof K) {
            final Object bestModelParameterForOffset = this.getBestModelParameterForOffset(n, n2);
            if (bestModelParameterForOffset != null) {
                this.sb = bestModelParameterForOffset;
                this.pb.h();
            }
        }
    }
    
    public double getDistance() {
        return this.nb;
    }
    
    public void setPreferredPlacement(final byte b) {
        this.mb = aG.g(b);
    }
    
    public byte getPreferredPlacement() {
        return (byte)(this.mb.a() | this.mb.b());
    }
    
    public aG getPreferredPlacementDescriptor() {
        return this.mb;
    }
    
    public void setPreferredPlacementDescriptor(final aG mb) {
        if (mb == null) {
            throw new IllegalArgumentException("null");
        }
        this.mb = mb;
    }
    
    public double getRatio() {
        if (this.kb instanceof aO) {
            return ((aP)this.b(this.getOrientedBox(), this.getOwner())).e();
        }
        if (this.sb instanceof u) {
            final u u = (u)this.sb;
            if (u.b() < 0) {
                return u.a();
            }
        }
        return 0.5;
    }
    
    public void setRatio(final double n) {
        final boolean z = fj.z;
        if (this.kb instanceof s) {
            this.setModelParameter(new u(n, -1));
        }
        if (this.kb instanceof aO) {
            final aO ao = (aO)this.kb;
            final aB owner = this.getOwner();
            if (owner != null) {
                final aP ap = (aP)this.b(this.getOrientedBox(), owner);
                Object modelParameter = null;
                double abs = Double.MAX_VALUE;
                final y.c.C m = ao.a(this, owner, owner.getSourceRealizer(), owner.getTargetRealizer()).m();
                while (true) {
                    while (m.f()) {
                        final aP ap3;
                        final aP ap2 = ap3 = (aP)((B)m.d()).b();
                        if (!z) {
                            if (Math.abs(ap3.e() - n) < abs && ap2.d() == ap.d()) {
                                abs = Math.abs(ap2.e() - n);
                                modelParameter = ap2;
                            }
                            m.g();
                            if (z) {
                                break;
                            }
                            continue;
                        }
                        else {
                            if (ap3 != null) {
                                this.setModelParameter(modelParameter);
                            }
                            return;
                        }
                    }
                    continue;
                }
            }
        }
    }
    
    public Object getBestModelParameterForBounds(final n n) {
        if (this.kb != null) {
            final aB owner = this.getOwner();
            if (owner != null && owner.getEdge() != null && owner.getEdge().a() != null) {
                return this.b(n, owner);
            }
        }
        return null;
    }
    
    public Object getBestModelParameterForOffset(final double n, final double n2) {
        final aB owner = this.getOwner();
        if (owner != null) {
            final Point2D sourceIntersection = owner.getSourceIntersection();
            return this.b(this.d(sourceIntersection.getX() + n, sourceIntersection.getY() + n2), owner);
        }
        return null;
    }
    
    public Object getBestModelParameterForLocation(final double n, final double n2) {
        final aB owner = this.getOwner();
        if (owner != null) {
            return this.b(this.d(n, n2), owner);
        }
        return null;
    }
    
    private n d(final double n, final double n2) {
        final double height = this.getHeight();
        return new n(n, n2 + height, this.getWidth(), height, 0.0, -1.0);
    }
    
    public boolean hasFreePositioning() {
        return this.model == 4;
    }
    
    public boolean hasSliderPositioning() {
        return this.model == 5 || this.model == 6;
    }
    
    public void setModel(final byte model) {
        final boolean z = fj.z;
        if (model == this.model) {
            return;
        }
        if (model >= 0 && model <= 7) {
            final aB pb = this.pb;
            final boolean b = pb != null && pb.getEdge() != null && pb.getEdge().a() != null;
            this.model = model;
            final E kb = this.kb;
            Label_0219: {
                switch (this.model) {
                    case 0: {
                        this.kb = b(18, this.nb);
                        if (z) {
                            break Label_0219;
                        }
                        break;
                    }
                    case 1: {
                        this.kb = b(128, this.nb);
                        if (z) {
                            break Label_0219;
                        }
                        break;
                    }
                    case 2: {
                        this.kb = b(63, this.nb);
                        if (z) {
                            break Label_0219;
                        }
                        break;
                    }
                    case 3: {
                        this.kb = b(448, this.nb);
                        if (z) {
                            break Label_0219;
                        }
                        break;
                    }
                    case 4: {
                        this.kb = new K();
                        if (z) {
                            break Label_0219;
                        }
                        break;
                    }
                    case 5: {
                        this.kb = b((byte)0, this.nb);
                        if (z) {
                            break Label_0219;
                        }
                        break;
                    }
                    case 6: {
                        this.kb = b((byte)1, this.nb);
                        break;
                    }
                }
            }
            if (kb instanceof z && this.kb instanceof z && ((z)this.kb).a(this.sb)) {
                if (this.nb != ((z)kb).b()) {
                    this.setOffsetDirty();
                }
                return;
            }
            this.sb = this.kb.c();
            if (this.kb instanceof K && b) {
                final Point2D sourceIntersection = this.pb.getSourceIntersection();
                final double f = this.offsetRectangle.f();
                final double g = this.offsetRectangle.g();
                final double i = this.offsetRectangle.i();
                final double n = this.offsetRectangle.b() + f * g;
                final double n2 = this.offsetRectangle.c() + f * i;
                final double height = this.height;
                this.sb = this.b(new n(n - height * g + sourceIntersection.getX(), n2 - height * i + sourceIntersection.getY(), this.width, height, g, i), pb);
            }
            this.placement = this.getPosition();
            this.setOffsetDirty();
            if (!z) {
                return;
            }
        }
        if (127 == model) {
            this.model = 127;
            this.kb = null;
        }
    }
    
    private static E b(final int n, final double n2) {
        final z z = new z(n);
        z.a(n2);
        return z;
    }
    
    private static aO b(final byte b, final double n) {
        final aO ao = new aO(b);
        ao.a(n, n);
        return ao;
    }
    
    public byte getPosition() {
        if (this.kb instanceof z) {
            switch ((int)this.sb) {
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
            switch (aJ.a(this.sb)) {
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
        if (this.kb instanceof aL) {
            return 24;
        }
        return 127;
    }
    
    public void setPosition(final byte b) {
        if (this.kb instanceof z) {
            this.b(b);
            if (!fj.z) {
                return;
            }
        }
        if (this.kb instanceof aJ) {
            this.c(b);
        }
    }
    
    private void b(final byte b) {
        final boolean z = fj.z;
        final z z2 = (z)this.kb;
        int n = 0;
        Label_0131: {
            switch (b) {
                case 13: {
                    n = 1;
                    if (z) {
                        break Label_0131;
                    }
                    break;
                }
                case 10: {
                    n = 2;
                    if (z) {
                        break Label_0131;
                    }
                    break;
                }
                case 14: {
                    n = 4;
                    if (z) {
                        break Label_0131;
                    }
                    break;
                }
                case 17: {
                    n = 64;
                    if (z) {
                        break Label_0131;
                    }
                    break;
                }
                case 12: {
                    n = 128;
                    if (z) {
                        break Label_0131;
                    }
                    break;
                }
                case 18: {
                    n = 256;
                    if (z) {
                        break Label_0131;
                    }
                    break;
                }
                case 15: {
                    n = 8;
                    if (z) {
                        break Label_0131;
                    }
                    break;
                }
                case 11: {
                    n = 16;
                    if (z) {
                        break Label_0131;
                    }
                    break;
                }
                case 16: {
                    n = 32;
                    break;
                }
            }
        }
        final Object a = y.f.z.a(n);
        if (z2.a(a)) {
            this.sb = a;
        }
        this.setOffsetDirty();
    }
    
    private void c(final byte b) {
        final boolean z = fj.z;
        final aJ aj = (aJ)this.kb;
        int n = 0;
        Label_0131: {
            switch (b) {
                case 13: {
                    n = 1;
                    if (z) {
                        break Label_0131;
                    }
                    break;
                }
                case 10: {
                    n = 2;
                    if (z) {
                        break Label_0131;
                    }
                    break;
                }
                case 14: {
                    n = 4;
                    if (z) {
                        break Label_0131;
                    }
                    break;
                }
                case 17: {
                    n = 64;
                    if (z) {
                        break Label_0131;
                    }
                    break;
                }
                case 12: {
                    n = 128;
                    if (z) {
                        break Label_0131;
                    }
                    break;
                }
                case 18: {
                    n = 256;
                    if (z) {
                        break Label_0131;
                    }
                    break;
                }
                case 15: {
                    n = 8;
                    if (z) {
                        break Label_0131;
                    }
                    break;
                }
                case 11: {
                    n = 16;
                    if (z) {
                        break Label_0131;
                    }
                    break;
                }
                case 16: {
                    n = 32;
                    break;
                }
            }
        }
        final Object a = aJ.a(n);
        if (aj.b(a)) {
            this.sb = a;
        }
        this.setOffsetDirty();
    }
    
    public static Map modelToStringMap() {
        final LinkedHashMap<Byte, String> linkedHashMap = new LinkedHashMap<Byte, String>(11);
        linkedHashMap.put(new Byte((byte)1), "Centered");
        linkedHashMap.put(new Byte((byte)0), "2 Pos");
        linkedHashMap.put(new Byte((byte)2), "6 Pos");
        linkedHashMap.put(new Byte((byte)3), "3 Pos Center");
        linkedHashMap.put(new Byte((byte)4), "Free");
        linkedHashMap.put(new Byte((byte)5), "Center Slider");
        linkedHashMap.put(new Byte((byte)6), "Side Slider");
        return linkedHashMap;
    }
    
    public static Map positionToStringMap() {
        final LinkedHashMap<Byte, String> linkedHashMap = new LinkedHashMap<Byte, String>(21);
        linkedHashMap.put(new Byte((byte)10), "Head");
        linkedHashMap.put(new Byte((byte)11), "Tail");
        linkedHashMap.put(new Byte((byte)12), "Center");
        linkedHashMap.put(new Byte((byte)13), "Source Head");
        linkedHashMap.put(new Byte((byte)14), "Target Head");
        linkedHashMap.put(new Byte((byte)15), "Source Tail");
        linkedHashMap.put(new Byte((byte)16), "Target Tail");
        linkedHashMap.put(new Byte((byte)99), "Anywhere");
        linkedHashMap.put(new Byte((byte)19), "Center");
        linkedHashMap.put(new Byte((byte)20), "Tail");
        linkedHashMap.put(new Byte((byte)21), "Head");
        linkedHashMap.put(new Byte((byte)24), "Dynamic");
        linkedHashMap.put(new Byte((byte)17), "Source Center");
        linkedHashMap.put(new Byte((byte)18), "Target Center");
        linkedHashMap.put(new Byte((byte)127), "Undefined");
        return linkedHashMap;
    }
    
    public static Map preferredPlacementsToStringMap() {
        final LinkedHashMap<Byte, String> linkedHashMap = new LinkedHashMap<Byte, String>(3);
        linkedHashMap.put(new Byte((byte)34), "At Target (right)");
        linkedHashMap.put(new Byte((byte)2), "At Target");
        linkedHashMap.put(new Byte((byte)18), "At Target (left)");
        linkedHashMap.put(new Byte((byte)33), "At Source (right)");
        linkedHashMap.put(new Byte((byte)1), "At Source");
        linkedHashMap.put(new Byte((byte)17), "At Source (left)");
        linkedHashMap.put(new Byte((byte)36), "At Center (right)");
        linkedHashMap.put(new Byte((byte)4), "At Center");
        linkedHashMap.put(new Byte((byte)20), "At Center (left)");
        linkedHashMap.put(new Byte((byte)4), "At Center");
        linkedHashMap.put(new Byte((byte)0), "Anywhere");
        return linkedHashMap;
    }
    
    public static final byte[] getModelPositions(final byte b) {
        return aA.jb[b];
    }
    
    public byte[] getModelPositions() {
        return getModelPositions(this.getModel());
    }
    
    public static Vector availablePositions(final Byte b) {
        final boolean z = fj.z;
        final Vector<Byte> vector = new Vector<Byte>(10);
        Vector<Byte> vector2 = null;
        Label_0063: {
            if (b != null) {
                final byte[] modelPositions = getModelPositions(b);
                int i = 0;
                while (i < modelPositions.length) {
                    vector2 = vector;
                    if (z) {
                        break;
                    }
                    vector2.add(new Byte(modelPositions[i]));
                    ++i;
                    if (z) {
                        break Label_0063;
                    }
                }
                return vector2;
            }
        }
        vector.add(new Byte((byte)127));
        return vector2;
    }
    
    public d getEdge() {
        return (this.pb != null) ? this.pb.getEdge() : null;
    }
    
    protected bu getGraph2D() {
        final d edge = this.getEdge();
        if (edge == null) {
            return null;
        }
        return (bu)edge.a();
    }
    
    public aB getRealizer() {
        return this.getOwner();
    }
    
    public aB getOwner() {
        return this.pb;
    }
    
    public void bindRealizer(final aB pb) {
        this.pb = pb;
        this.setOffsetDirty();
    }
    
    public E getLabelModel() {
        return this.kb;
    }
    
    public Object getModelParameter() {
        return this.sb;
    }
    
    public void setModelParameter(final Object o) {
        this.b(o);
        this.setOffsetDirty();
    }
    
    private void b(final Object sb) {
        this.sb = sb;
        this.placement = this.getPosition();
    }
    
    public void setLabelModel(final E e) {
        this.b(e);
        this.setOffsetDirty();
    }
    
    public void setLabelModel(final E e, final Object o) {
        this.b(e);
        this.b(o);
        this.setOffsetDirty();
    }
    
    private void b(final E kb) {
        final boolean z = fj.z;
        this.kb = kb;
        if (kb == null) {
            this.model = 127;
            if (!z) {
                return;
            }
        }
        if (kb.getClass() == ((aA.class$y$layout$DiscreteEdgeLabelModel == null) ? (aA.class$y$layout$DiscreteEdgeLabelModel = class$("y.f.z")) : aA.class$y$layout$DiscreteEdgeLabelModel)) {
            Label_0131: {
                switch (((z)kb).a()) {
                    case 18: {
                        this.model = 0;
                        if (z) {
                            break Label_0131;
                        }
                        return;
                    }
                    case 128: {
                        this.model = 1;
                        if (z) {
                            break Label_0131;
                        }
                        return;
                    }
                    case 63: {
                        this.model = 2;
                        if (z) {
                            break Label_0131;
                        }
                        return;
                    }
                    case 448: {
                        this.model = 3;
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
        if (kb.getClass() == ((aA.class$y$layout$FreeEdgeLabelModel == null) ? (aA.class$y$layout$FreeEdgeLabelModel = class$("y.f.K")) : aA.class$y$layout$FreeEdgeLabelModel)) {
            this.model = 4;
            if (!z) {
                return;
            }
        }
        if (kb.getClass() == ((aA.class$y$layout$SliderEdgeLabelModel == null) ? (aA.class$y$layout$SliderEdgeLabelModel = class$("y.f.aO")) : aA.class$y$layout$SliderEdgeLabelModel)) {
            Label_0261: {
                switch (((aO)kb).a()) {
                    case 0: {
                        this.model = 5;
                        if (z) {
                            break Label_0261;
                        }
                        return;
                    }
                    case 1: {
                        this.model = 6;
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
        this.model = 127;
    }
    
    public void setOffsetDirty() {
        super.setOffsetDirty();
        if (this.pb != null) {
            this.pb.h();
        }
    }
    
    public void setSizeDirty() {
        super.setSizeDirty();
        if (this.pb != null) {
            this.pb.h();
            this.pb.labelBoundsChanged();
        }
    }
    
    public n getOrientedBox() {
        final Point2D sourceIntersection = this.pb.getSourceIntersection();
        return this.getOffset().f(sourceIntersection.getX(), sourceIntersection.getY());
    }
    
    public void repaint() {
        if (this.pb != null && this.pb.i() != null) {
            final y box = this.getBox();
            this.pb.i().a(box.c(), box.d(), box.a(), box.b());
        }
    }
    
    public void write(final ObjectOutputStream objectOutputStream) {
        objectOutputStream.writeByte(2);
        super.write(objectOutputStream);
        objectOutputStream.writeFloat((float)this.rb);
        objectOutputStream.writeFloat((float)this.getDistance());
    }
    
    public void read(final ObjectInputStream objectInputStream) {
        final boolean z = fj.z;
        Label_0143: {
            switch (objectInputStream.readByte()) {
                case 0: {
                    super.read(objectInputStream);
                    if (objectInputStream.readBoolean()) {
                        this.setBackgroundColor(Color.white);
                    }
                    this.rb = objectInputStream.readFloat();
                    if (z) {
                        break Label_0143;
                    }
                    return;
                }
                case 1: {
                    super.read(objectInputStream);
                    this.rb = objectInputStream.readFloat();
                    if (this.model != 5 && this.model != 6) {
                        return;
                    }
                    final aB owner = this.getOwner();
                    if (owner == null) {
                        return;
                    }
                    final Point2D sourceIntersection = owner.getSourceIntersection();
                    this.setModelParameter(this.b(this.offsetRectangle.f(sourceIntersection.getX(), sourceIntersection.getY()), owner));
                    if (z) {
                        break Label_0143;
                    }
                    return;
                }
                case 2: {
                    super.read(objectInputStream);
                    this.rb = objectInputStream.readFloat();
                    if (this.model == 5 || this.model == 6) {
                        final aB owner2 = this.getOwner();
                        if (owner2 != null) {
                            final Point2D sourceIntersection2 = owner2.getSourceIntersection();
                            this.setModelParameter(this.b(this.offsetRectangle.f(sourceIntersection2.getX(), sourceIntersection2.getY()), owner2));
                        }
                    }
                    this.setDistance(objectInputStream.readFloat());
                    if (z) {
                        break;
                    }
                    return;
                }
            }
        }
        throw new a();
    }
    
    private Object b(final n n, final aB ab) {
        return this.kb.a(n, ab, ab.getSourceRealizer(), ab.getTargetRealizer());
    }
    
    public void setConfiguration(final String s) {
        getFactory().a(this, s);
    }
    
    public static hb getFactory() {
        return aA.ob;
    }
    
    static Class class$(final String s) {
        try {
            return Class.forName(s);
        }
        catch (ClassNotFoundException ex) {
            throw new NoClassDefFoundError(ex.getMessage());
        }
    }
    
    static {
        jb = new byte[][] { { 10, 11 }, { 12 }, { 10, 13, 14, 11, 15, 16 }, { 12, 17, 18 }, { 99 }, { 24 }, { 24 } };
        final HashMap<Class, gs> hashMap = new HashMap<Class, gs>();
        hashMap.put((aA.class$y$view$YLabel$BoundsProvider == null) ? (aA.class$y$view$YLabel$BoundsProvider = class$("y.h.ha")) : aA.class$y$view$YLabel$BoundsProvider, hh.d);
        hashMap.put((aA.class$y$view$YLabel$Layout == null) ? (aA.class$y$view$YLabel$Layout = class$("y.h.hc")) : aA.class$y$view$YLabel$Layout, hh.d);
        hashMap.put((aA.class$y$view$YLabel$Painter == null) ? (aA.class$y$view$YLabel$Painter = class$("y.h.hd")) : aA.class$y$view$YLabel$Painter, hh.d);
        hashMap.put((aA.class$y$view$YLabel$UserDataHandler == null) ? (aA.class$y$view$YLabel$UserDataHandler = class$("y.h.hf")) : aA.class$y$view$YLabel$UserDataHandler, (hh)new gs((byte)0));
        qb = new hg(hashMap, hashMap, null);
        ob = new hb(hashMap);
        final HashMap<Class, hj> hashMap2 = new HashMap<Class, hj>();
        hashMap2.put((aA.class$y$view$YLabel$Painter == null) ? (aA.class$y$view$YLabel$Painter = class$("y.h.hd")) : aA.class$y$view$YLabel$Painter, new hj());
        aA.ob.a("CroppingLabel", hashMap2);
        final HashMap<Class, ay> hashMap3 = new HashMap<Class, ay>();
        final ay ay = new ay();
        ay.a(true);
        hashMap3.put((aA.class$y$view$YLabel$Painter == null) ? (aA.class$y$view$YLabel$Painter = class$("y.h.hd")) : aA.class$y$view$YLabel$Painter, ay);
        aA.ob.a("AutoFlippingLabel", hashMap3);
    }
}
