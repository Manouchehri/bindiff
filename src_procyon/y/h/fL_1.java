package y.h;

import java.awt.*;
import java.awt.geom.*;
import y.d.*;
import java.io.*;
import y.e.*;

public class fL
{
    protected double d;
    protected double e;
    protected aB f;
    
    public fL() {
        this(0.0, 0.0);
    }
    
    public fL(final double d, final double e) {
        this.d = d;
        this.e = e;
    }
    
    public fL(final fL fl) {
        this(fl.d, fl.e);
    }
    
    public fL a() {
        return new fL(this.d, this.e);
    }
    
    void a(final aB f) {
        this.f = f;
    }
    
    public aB d() {
        return this.f;
    }
    
    public boolean a(final fj fj, final double n, final double n2, final double n3, final double n4, final Point2D point2D) {
        return fj.findIntersection(n, n2, n3, n4, point2D);
    }
    
    public void a(final Graphics2D graphics2D, final fj fj) {
        if (aB.b(this.f, graphics2D)) {
            final Rectangle2D.Double k;
            final Rectangle2D.Double double2;
            final Rectangle2D.Double double1 = double2 = (k = hC.a().k);
            final double n = 6.0;
            double2.height = n;
            k.width = n;
            double1.x = this.a(fj) - 3.0;
            double1.y = this.b(fj) - 3.0;
            graphics2D.setColor(Color.black);
            graphics2D.fill(double1);
        }
    }
    
    protected void e() {
        if (this.f != null) {
            this.f.setDirty();
        }
    }
    
    public boolean a(final double n, final double n2) {
        if (this.f.isSelected()) {
            fj fj = null;
            Label_0045: {
                if (this.f.getSourcePort() == this) {
                    fj = this.f.getSourceRealizer();
                    if (!y.h.fj.z) {
                        break Label_0045;
                    }
                }
                fj = this.f.getTargetRealizer();
            }
            final double a = this.a(fj);
            final double b = this.b(fj);
            return a - 3.0 <= n && a + 3.0 >= n && b - 3.0 <= n2 && b + 3.0 >= n2;
        }
        return false;
    }
    
    t f() {
        if (this.f.getSourcePort() == this) {
            final fj fj = this.f.getSourceRealizer();
            if (!y.h.fj.z) {
                return new t(this.a(fj), this.b(fj));
            }
        }
        final fj fj = this.f.getTargetRealizer();
        return new t(this.a(fj), this.b(fj));
    }
    
    public void a(final Rectangle2D rectangle2D, final fj fj) {
        rectangle2D.add(this.a(fj), this.b(fj));
    }
    
    public double g() {
        return this.d;
    }
    
    public double h() {
        return this.e;
    }
    
    public double a(final fj fj) {
        return fj.getCenterX() + this.d;
    }
    
    public double b(final fj fj) {
        return fj.getCenterY() + this.e;
    }
    
    public void b(final double d, final double e) {
        this.e();
        this.d = d;
        this.e = e;
    }
    
    public void a(final ObjectOutputStream objectOutputStream) {
        objectOutputStream.writeByte(1);
        objectOutputStream.writeFloat((float)this.d);
        objectOutputStream.writeFloat((float)this.e);
    }
    
    public void a(final ObjectInputStream objectInputStream) {
        final boolean z = fj.z;
        Label_0063: {
            switch (objectInputStream.readByte()) {
                case 0: {
                    objectInputStream.readByte();
                    this.d = objectInputStream.readFloat();
                    this.e = objectInputStream.readFloat();
                    if (z) {
                        break Label_0063;
                    }
                    return;
                }
                case 1: {
                    this.d = objectInputStream.readFloat();
                    this.e = objectInputStream.readFloat();
                    if (z) {
                        break;
                    }
                    return;
                }
            }
        }
        throw new a();
    }
    
    public String toString() {
        return "Port: (" + this.g() + ',' + this.h() + ')';
    }
}
