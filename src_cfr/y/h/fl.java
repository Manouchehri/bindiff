/*
 * Decompiled with CFR 0_115.
 */
package y.h;

import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.Shape;
import java.awt.geom.Point2D;
import java.awt.geom.Rectangle2D;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import y.d.t;
import y.e.a;
import y.h.aB;
import y.h.fj;
import y.h.hC;

public class fL {
    protected double d;
    protected double e;
    protected aB f;

    public fL() {
        this(0.0, 0.0);
    }

    public fL(double d2, double d3) {
        this.d = d2;
        this.e = d3;
    }

    public fL(fL fL2) {
        this(fL2.d, fL2.e);
    }

    public fL a() {
        return new fL(this.d, this.e);
    }

    void a(aB aB2) {
        this.f = aB2;
    }

    public aB d() {
        return this.f;
    }

    public boolean a(fj fj2, double d2, double d3, double d4, double d5, Point2D point2D) {
        return fj2.findIntersection(d2, d3, d4, d5, point2D);
    }

    public void a(Graphics2D graphics2D, fj fj2) {
        if (!aB.b(this.f, graphics2D)) return;
        Rectangle2D.Double double_ = hC.a().k;
        double_.height = 6.0;
        double_.width = 6.0;
        double_.x = this.a(fj2) - 3.0;
        double_.y = this.b(fj2) - 3.0;
        graphics2D.setColor(Color.black);
        graphics2D.fill(double_);
    }

    protected void e() {
        if (this.f == null) return;
        this.f.setDirty();
    }

    public boolean a(double d2, double d3) {
        fj fj2;
        block2 : {
            if (!this.f.isSelected()) return false;
            if (this.f.getSourcePort() == this) {
                fj2 = this.f.getSourceRealizer();
                if (!fj.z) break block2;
            }
            fj2 = this.f.getTargetRealizer();
        }
        double d4 = this.a(fj2);
        double d5 = this.b(fj2);
        if (d4 - 3.0 > d2) return false;
        if (d4 + 3.0 < d2) return false;
        if (d5 - 3.0 > d3) return false;
        if (d5 + 3.0 < d3) return false;
        return true;
    }

    t f() {
        fj fj2;
        if (this.f.getSourcePort() == this) {
            fj2 = this.f.getSourceRealizer();
            if (!fj.z) return new t(this.a(fj2), this.b(fj2));
        }
        fj2 = this.f.getTargetRealizer();
        return new t(this.a(fj2), this.b(fj2));
    }

    public void a(Rectangle2D rectangle2D, fj fj2) {
        rectangle2D.add(this.a(fj2), this.b(fj2));
    }

    public double g() {
        return this.d;
    }

    public double h() {
        return this.e;
    }

    public double a(fj fj2) {
        return fj2.getCenterX() + this.d;
    }

    public double b(fj fj2) {
        return fj2.getCenterY() + this.e;
    }

    public void b(double d2, double d3) {
        this.e();
        this.d = d2;
        this.e = d3;
    }

    public void a(ObjectOutputStream objectOutputStream) {
        objectOutputStream.writeByte(1);
        objectOutputStream.writeFloat((float)this.d);
        objectOutputStream.writeFloat((float)this.e);
    }

    public void a(ObjectInputStream objectInputStream) {
        boolean bl2 = fj.z;
        switch (objectInputStream.readByte()) {
            case 0: {
                objectInputStream.readByte();
                this.d = objectInputStream.readFloat();
                this.e = objectInputStream.readFloat();
                if (!bl2) return;
            }
            case 1: {
                this.d = objectInputStream.readFloat();
                this.e = objectInputStream.readFloat();
                if (!bl2) return;
            }
        }
        throw new a();
    }

    public String toString() {
        return new StringBuffer().append("Port: (").append(this.g()).append(',').append(this.h()).append(')').toString();
    }
}

