package y.h;

import java.awt.geom.*;
import java.io.*;
import y.e.*;

public class g extends aB
{
    private float b;
    private float c;
    private float d;
    private float e;
    private float f;
    private float g;
    private float h;
    private float i;
    private float j;
    private float k;
    private float l;
    private float m;
    private float n;
    private float o;
    private byte p;
    x a;
    
    public g() {
        this((byte)1);
    }
    
    public g(final byte p) {
        this.d();
        this.p = p;
    }
    
    public void clearBends() {
    }
    
    public g(final aB ab) {
        final boolean z = fj.z;
        super(ab);
        if (ab instanceof g) {
            final g g = (g)ab;
            this.p = g.a();
            this.f = g.b();
            this.g = g.c();
            Label_0193: {
                if (g.bendCount() != 1) {
                    this.a = new x(this, 0.0, 0.0);
                    if (!z) {
                        break Label_0193;
                    }
                }
                this.a = new x(this, g.a.b(), g.a.c());
                this.b = g.b;
                this.d = g.d;
                this.c = g.c;
                this.e = g.e;
                this.h = g.h;
                this.i = g.i;
                this.j = g.j;
                this.k = g.k;
                this.m = g.m;
                this.l = g.l;
                this.n = g.n;
                this.o = g.o;
            }
            this.bends.clear();
            this.bends.b(this.a);
            if (!z) {
                return;
            }
        }
        this.d();
    }
    
    public aB createCopy(final aB ab) {
        return new g(ab);
    }
    
    private void d() {
        this.f = 1.0f;
        this.g = 30.0f;
        this.a = new x(this, 0.0, 0.0);
        this.bends.clear();
        this.bends.b(this.a);
        this.p = 1;
    }
    
    public void a(final byte p) {
        if (this.p != p) {
            this.p = p;
            this.e();
            this.setDirty();
        }
    }
    
    public byte a() {
        return this.p;
    }
    
    public float b() {
        return this.f;
    }
    
    public float c() {
        return this.g;
    }
    
    public x createBend(final double n, final double n2, final x x, final int n3) {
        return null;
    }
    
    public void reInsertBend(final x x, final x x2, final int n) {
    }
    
    public x insertBend(final double n, final double n2) {
        return null;
    }
    
    public x removeBend(final x x) {
        return null;
    }
    
    public int getMinBendCount() {
        return 1;
    }
    
    public void bendChanged(final x x, final double n, final double n2) {
        final boolean z = fj.z;
        if (!x.d()) {
            return;
        }
        if (this.getTargetRealizer().isSelected() || this.getSourceRealizer().isSelected()) {
            return;
        }
        double ptLineDist = Line2D.ptLineDist(this.b, this.c, this.d, this.e, this.a.b(), this.a.c());
        if (Double.isNaN(ptLineDist)) {
            ptLineDist = (float)Math.sqrt((this.b - this.a.b()) * (this.b - this.a.b()) + (this.c - this.a.c()) * (this.c - this.a.c()));
        }
        final int relativeCCW = Line2D.relativeCCW(this.b, this.c, this.d, this.e, this.a.b(), this.a.c());
        final double n3 = (float)Math.sqrt(this.j * this.j + this.k * this.k);
        Label_0273: {
            switch (this.p) {
                case 0: {
                    if (relativeCCW != 0) {
                        this.g = relativeCCW * (float)ptLineDist;
                        if (!z) {
                            break;
                        }
                    }
                    this.g = (float)ptLineDist;
                    if (z) {
                        break Label_0273;
                    }
                    break;
                }
                case 1: {
                    if (n3 > 0.0) {
                        this.f = relativeCCW * (float)(4.0 * ptLineDist / n3);
                        break;
                    }
                    break;
                }
            }
        }
        this.e();
    }
    
    private void e() {
        final boolean z = fj.z;
        if (this.getEdge() == null || this.getEdge().a() == null) {
            return;
        }
        final fj sourceRealizer = this.getSourceRealizer();
        final fj targetRealizer = this.getTargetRealizer();
        final fL sourcePort = this.getSourcePort();
        final fL targetPort = this.getTargetPort();
        this.b = (float)sourcePort.a(sourceRealizer);
        this.c = (float)sourcePort.b(sourceRealizer);
        this.d = (float)targetPort.a(targetRealizer);
        this.e = (float)targetPort.b(targetRealizer);
        this.j = this.d - this.b;
        this.k = this.e - this.c;
        this.h = this.b + this.j / 2.0f;
        this.i = this.c + this.k / 2.0f;
        Label_0256: {
            switch (this.p) {
                case 1: {
                    this.m = this.k * this.f / 4.0f;
                    this.l = -this.j * this.f / 4.0f;
                    this.g = (float)Math.sqrt(this.m * this.m + this.l * this.l);
                    if (this.f >= 0.0f) {
                        break;
                    }
                    this.g = -this.g;
                    if (z) {
                        break Label_0256;
                    }
                    break;
                }
                case 0: {
                    final double sqrt = Math.sqrt(this.j * this.j + this.k * this.k);
                    if (sqrt > 0.0) {
                        this.f = (float)(this.g / sqrt);
                        this.m = this.k * this.f;
                        this.l = -this.j * this.f;
                        this.f *= 4.0f;
                        if (!z) {
                            break;
                        }
                    }
                    this.m = 0.0f;
                    this.l = 0.0f;
                    break;
                }
            }
        }
        this.a.a = this.h + this.m;
        this.a.b = this.i + this.l;
        this.n = (float)(this.a.b() + this.m);
        this.o = (float)(this.a.c() + this.l);
    }
    
    protected byte calculatePath(final Point2D point2D, final Point2D point2D2) {
        final boolean z = fj.z;
        this.e();
        final GeneralPath generalPath = new GeneralPath(1, 5);
        generalPath.moveTo(this.b, this.c);
        generalPath.quadTo(this.n, this.o, this.d, this.e);
        final PathIterator pathIterator = generalPath.getPathIterator(null, 1.0);
        final float[] c = hC.a().c;
        pathIterator.currentSegment(c);
        pathIterator.next();
        this.path.reset();
        this.path.moveTo(c[0], c[1]);
        while (true) {
            while (!pathIterator.isDone()) {
                pathIterator.currentSegment(c);
                pathIterator.next();
                final g g = this;
                if (z) {
                    final GeneralPath path = this.path;
                    final GeneralPath path2 = new GeneralPath(1, this.bendCount() + 4);
                    this.path = path2;
                    return ij.a(g, path, path2, point2D, point2D2);
                }
                this.path.lineTo(c[0], c[1]);
                if (z) {
                    break;
                }
            }
            final g g = this;
            continue;
        }
    }
    
    public void write(final ObjectOutputStream objectOutputStream) {
        objectOutputStream.writeByte(1);
        super.write(objectOutputStream);
        objectOutputStream.writeByte(this.p);
        objectOutputStream.writeFloat(this.f);
        objectOutputStream.writeFloat(this.g);
    }
    
    public void read(final ObjectInputStream objectInputStream) {
        final boolean z = fj.z;
        Label_0119: {
            Label_0076: {
                switch (objectInputStream.readByte()) {
                    case 0: {
                        objectInputStream.readByte();
                        super.read(objectInputStream);
                        final byte byte1 = objectInputStream.readByte();
                        this.f = objectInputStream.readFloat();
                        this.g = objectInputStream.readFloat();
                        this.a(byte1);
                        if (z) {
                            break Label_0076;
                        }
                        break Label_0119;
                    }
                    case 1: {
                        super.read(objectInputStream);
                        final byte byte2 = objectInputStream.readByte();
                        this.f = objectInputStream.readFloat();
                        this.g = objectInputStream.readFloat();
                        this.a(byte2);
                        if (z) {
                            break;
                        }
                        break Label_0119;
                    }
                }
            }
            throw new a();
        }
        this.e();
        this.setDirty();
    }
}
