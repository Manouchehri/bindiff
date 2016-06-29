package y.h.a;

import java.awt.geom.*;
import y.d.*;
import java.io.*;
import y.h.*;

public class e extends aZ implements h
{
    private boolean w;
    private boolean A;
    private boolean B;
    private double C;
    private double D;
    private double E;
    private double F;
    private double G;
    private double H;
    private double I;
    private double J;
    private double K;
    private double L;
    private boolean M;
    private g N;
    
    public e() {
        this.w = true;
        this.C = 100.0;
        this.D = 80.0;
        this.I = 15.0;
        this.J = 15.0;
        this.K = 15.0;
        this.L = 15.0;
        this.a(true);
    }
    
    public e(final fj fj) {
        super(fj);
        this.w = true;
        this.C = 100.0;
        this.D = 80.0;
        this.I = 15.0;
        this.J = 15.0;
        this.K = 15.0;
        this.L = 15.0;
        if (fj instanceof e) {
            this.a((aZ)fj);
        }
    }
    
    protected void a(final aZ az) {
        this.a(false);
        super.a(az);
        if (az instanceof e) {
            final e e = (e)az;
            this.b(e.getBorderInsets());
            this.a(e.getMinimalInsets());
            this.a(e.i());
            this.b(e.j());
            this.setGroupClosed(e.isGroupClosed());
            this.a(e.g());
        }
    }
    
    public void calcUnionRect(final Rectangle2D rectangle2D) {
        if (this.M) {
            return;
        }
        if (this.a.m != null) {
            this.b(true);
            try {
                this.M = true;
                this.a.m.c(this);
            }
            finally {
                this.M = false;
            }
        }
        super.calcUnionRect(rectangle2D);
    }
    
    public boolean g() {
        return this.w;
    }
    
    public void a(final boolean w) {
        this.w = w;
    }
    
    public boolean isGroupClosed() {
        return this.A;
    }
    
    public boolean h() {
        return this.B;
    }
    
    public void b(final boolean b) {
        this.B = b;
    }
    
    public double i() {
        return this.C;
    }
    
    public void a(final double c) {
        this.C = c;
    }
    
    public double j() {
        return this.D;
    }
    
    public void b(final double d) {
        this.D = d;
    }
    
    public fj createCopy(final fj fj) {
        return new e(fj);
    }
    
    public void setGroupClosed(final boolean a) {
        if (this.A != a) {
            this.A = a;
            Label_0119: {
                if (a) {
                    final gt sizeConstraintProvider = this.getSizeConstraintProvider();
                    if (sizeConstraintProvider != null) {
                        final double a2 = sizeConstraintProvider.getMinimumSize().a();
                        final double b = sizeConstraintProvider.getMinimumSize().b();
                        if (this.C < a2) {
                            this.C = a2;
                        }
                        if (this.D < b) {
                            this.D = b;
                        }
                    }
                    super.setFrame(this.x, this.y, this.C, this.D);
                    if (y.h.a.v.a == 0) {
                        break Label_0119;
                    }
                }
                this.C = this.width;
                this.D = this.height;
            }
            this.b(true);
            this.boundsChanged();
        }
    }
    
    public Rectangle2D.Double getBoundingBox() {
        if (this.h() && this.a.m != null) {
            this.a.m.c(this);
            this.boundsChanged();
        }
        return super.getBoundingBox();
    }
    
    public r getBorderInsets() {
        return new r(this.E, this.G, this.F, this.H);
    }
    
    public r getMinimalInsets() {
        return new r(this.I, this.K, this.J, this.L);
    }
    
    public a getAutoBoundsFeature() {
        if (this.a.m != null) {
            if (this.N == null) {
                this.N = new g(this);
            }
            return this.N;
        }
        this.N = null;
        return super.getAutoBoundsFeature();
    }
    
    public void a(final r r) {
        this.J = r.c;
        this.I = r.a;
        this.K = r.b;
        this.L = r.d;
        if (this.a.m != null) {
            this.a.m.c(this);
        }
    }
    
    public void b(final r r) {
        this.E = r.a;
        this.F = r.c;
        this.H = r.d;
        this.G = r.b;
        if (this.a.m != null) {
            this.a.m.c(this);
        }
    }
    
    public void read(final ObjectInputStream objectInputStream) {
        switch (objectInputStream.readByte()) {
            case 0: {
                super.read(objectInputStream);
                this.w = objectInputStream.readBoolean();
                this.D = objectInputStream.readDouble();
                this.C = objectInputStream.readDouble();
                this.F = objectInputStream.readDouble();
                this.G = objectInputStream.readDouble();
                this.E = objectInputStream.readDouble();
                this.H = objectInputStream.readDouble();
                this.J = objectInputStream.readDouble();
                this.K = objectInputStream.readDouble();
                this.I = objectInputStream.readDouble();
                this.L = objectInputStream.readDouble();
                this.A = objectInputStream.readBoolean();
                if (y.h.a.v.a != 0) {
                    break;
                }
                return;
            }
        }
        throw new y.e.a();
    }
    
    public void write(final ObjectOutputStream objectOutputStream) {
        objectOutputStream.writeByte(0);
        super.write(objectOutputStream);
        objectOutputStream.writeBoolean(this.w);
        objectOutputStream.writeDouble(this.D);
        objectOutputStream.writeDouble(this.C);
        objectOutputStream.writeDouble(this.F);
        objectOutputStream.writeDouble(this.G);
        objectOutputStream.writeDouble(this.E);
        objectOutputStream.writeDouble(this.H);
        objectOutputStream.writeDouble(this.J);
        objectOutputStream.writeDouble(this.K);
        objectOutputStream.writeDouble(this.I);
        objectOutputStream.writeDouble(this.L);
        objectOutputStream.writeBoolean(this.A);
    }
    
    static boolean a(final e e) {
        return e.w;
    }
    
    static bc b(final e e) {
        return e.a;
    }
    
    static double a(final e e, final double h) {
        return e.H = h;
    }
    
    static double c(final e e) {
        return e.x;
    }
    
    static double d(final e e) {
        return e.width;
    }
    
    static double e(final e e) {
        return e.x;
    }
    
    static double f(final e e) {
        return e.width;
    }
    
    static double b(final e e, final double e2) {
        return e.E = e2;
    }
    
    static double g(final e e) {
        return e.y;
    }
    
    static double h(final e e) {
        return e.y;
    }
    
    static double c(final e e, final double f) {
        return e.F = f;
    }
    
    static double i(final e e) {
        return e.y;
    }
    
    static double j(final e e) {
        return e.height;
    }
    
    static double k(final e e) {
        return e.y;
    }
    
    static double l(final e e) {
        return e.height;
    }
    
    static double d(final e e, final double g) {
        return e.G = g;
    }
    
    static double m(final e e) {
        return e.x;
    }
    
    static double n(final e e) {
        return e.x;
    }
    
    static boolean a(final e e, final boolean w) {
        return e.w = w;
    }
    
    static bc o(final e e) {
        return e.a;
    }
    
    static bc p(final e e) {
        return e.a;
    }
}
