/*
 * Decompiled with CFR 0_115.
 */
package y.h;

import java.awt.Graphics2D;
import java.awt.geom.AffineTransform;
import java.awt.geom.GeneralPath;
import java.awt.geom.Line2D;
import java.awt.geom.PathIterator;
import java.awt.geom.Point2D;
import java.awt.geom.Rectangle2D;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import y.c.p;
import y.e.a;
import y.h.aB;
import y.h.fL;
import y.h.fj;
import y.h.ij;
import y.h.x;
import y.h.y;
import y.h.z;

public class B
extends aB {
    private final GeneralPath a = new GeneralPath();

    public B() {
    }

    public B(aB aB2) {
        super(aB2);
    }

    @Override
    public aB createCopy(aB aB2) {
        return new B(aB2);
    }

    @Override
    public x createBend(double d2, double d3, x x2, int n2) {
        x x3 = new x(this, d2, d3);
        this.reInsertBend(x3, x2, n2);
        return x3;
    }

    @Override
    public void reInsertBend(x x2, x x3, int n2) {
        block2 : {
            if (n2 == 0) {
                this.bends.b(x2, this.bends.d(x3));
                if (!fj.z) break block2;
            }
            this.bends.a(x2, this.bends.d(x3));
        }
        this.setDirty();
    }

    @Override
    public x insertBend(double d2, double d3) {
        int n2 = this.a(d2, d3);
        if (n2 < 0) return null;
        return this.createBend(d2, d3, (x)this.bends.a(n2), 1);
    }

    @Override
    public boolean contains(double d2, double d3) {
        if (!this.isSelected()) {
            return super.contains(d2, d3);
        }
        if (this.a(d2, d3) < 0) return false;
        return true;
    }

    @Override
    public x removeBend(x x2) {
        this.bends.remove(x2);
        this.setDirty();
        return x2;
    }

    private int a(double d2, double d3) {
        int n2;
        double d4;
        block3 : {
            double d5;
            double d6;
            boolean bl2 = fj.z;
            double d7 = this.getSourcePort().a(this.getSourceRealizer());
            double d8 = this.getSourcePort().b(this.getSourceRealizer());
            n2 = 0;
            for (p p2 = this.bends.k(); p2 != null; p2 = p2.a(), ++n2) {
                x x2 = (x)p2.c();
                d6 = x2.b();
                d5 = x2.c();
                d4 = Line2D.ptSegDist(d7, d8, d6, d5, d2, d3) DCMPG 5.0;
                if (!bl2) {
                    if (d4 < 0) {
                        return n2;
                    }
                    d7 = d6;
                    d8 = d5;
                    if (!bl2) continue;
                }
                break block3;
            }
            d6 = this.getTargetPort().a(this.getTargetRealizer());
            d5 = this.getTargetPort().b(this.getTargetRealizer());
            d4 = Line2D.ptSegDist(d7, d8, d6, d5, d2, d3) DCMPG 5.0;
        }
        if (d4 >= 0) return -1;
        return n2;
    }

    @Override
    protected byte calculatePath(Point2D point2D, Point2D point2D2) {
        block11 : {
            int n2;
            float[] arrf;
            fL fL2;
            int n3;
            fj fj2;
            boolean bl2;
            int n4;
            float[] arrf2;
            block10 : {
                block9 : {
                    bl2 = fj.z;
                    if (this.bendCount() == 0) {
                        return ij.a(this, this.path, point2D, point2D2);
                    }
                    n2 = 2;
                    if ((this.bendCount() & 1) == 1) {
                        n2 += 3 * this.bendCount() + 1 >> 1;
                        if (!bl2) break block9;
                    }
                    n2 += 3 * (this.bendCount() >> 1) - 1;
                }
                arrf2 = new float[n2];
                arrf = new float[n2];
                fj2 = this.getSourceRealizer();
                fL2 = this.getSourcePort();
                arrf2[0] = (float)fL2.a(fj2);
                arrf[0] = (float)fL2.b(fj2);
                n4 = 1;
                y y2 = this.bends();
                while (y2.f()) {
                    x x2 = y2.a();
                    n3 = n4 % 3;
                    if (!bl2) {
                        if (n3 == 0) {
                            arrf2[n4] = (float)(x2.b() + (double)arrf2[n4 - 1]) / 2.0f;
                            arrf[n4] = (float)(x2.c() + (double)arrf[n4 - 1]) / 2.0f;
                            ++n4;
                        }
                        arrf2[n4] = (float)x2.b();
                        arrf[n4] = (float)x2.c();
                        y2.g();
                        ++n4;
                        if (!bl2) continue;
                    }
                    break block10;
                }
                n3 = n4 % 3;
            }
            if (n3 == 2) {
                arrf2[n4] = arrf2[n4 - 1];
                arrf[n4] = arrf[n4 - 1];
            }
            fj2 = this.getTargetRealizer();
            fL2 = this.getTargetPort();
            arrf2[n2 - 1] = (float)fL2.a(fj2);
            arrf[n2 - 1] = (float)fL2.b(fj2);
            this.path.reset();
            this.a.reset();
            this.a.moveTo(arrf2[0], arrf[0]);
            for (int i2 = 0; i2 < n2 - 3; i2 += 3) {
                this.a.curveTo(arrf2[i2 + 1], arrf[i2 + 1], arrf2[i2 + 2], arrf[i2 + 2], arrf2[i2 + 3], arrf[i2 + 3]);
                if (!bl2) {
                    if (!bl2) continue;
                }
                break block11;
            }
            this.path.append(this.a.getPathIterator(null, 0.75), false);
        }
        this.path = new GeneralPath(1, this.bendCount() + 4);
        return ij.a(this, this.path, this.path, point2D, point2D2);
    }

    @Override
    public void calcUnionRect(Rectangle2D rectangle2D) {
        Object object;
        Object object2;
        boolean bl2 = fj.z;
        super.calcUnionRect(rectangle2D);
        if (this.isSelected()) {
            for (object2 = this.bends.k(); object2 != null; object2 = object2.a()) {
                object = (x)object2.c();
                rectangle2D.add(object.b(), object.c());
                if (bl2) return;
                if (!bl2) continue;
            }
            object2 = this.getSourceRealizer();
            object = this.getSourcePort();
            rectangle2D.add(object.a((fj)object2), object.b((fj)object2));
            object2 = this.getTargetRealizer();
            object = this.getTargetPort();
            rectangle2D.add(object.a((fj)object2), object.b((fj)object2));
            if (!bl2) return;
        }
        object2 = this.bends.k();
        do {
            if (object2 == null) return;
            object = (x)object2.c();
            if (object.d()) {
                rectangle2D.add(object.b(), object.c());
            }
            object2 = object2.a();
        } while (!bl2);
    }

    @Override
    public boolean intersects(Rectangle2D rectangle2D) {
        boolean bl2;
        boolean bl3 = fj.z;
        boolean bl4 = super.intersects(rectangle2D);
        if (bl4) return true;
        if (this.isSelected()) {
            Object object;
            Object object2;
            for (object2 = this.bends.k(); object2 != null; object2 = object2.a()) {
                object = (x)object2.c();
                bl2 = rectangle2D.contains(object.b(), object.c());
                if (bl3) return bl2;
                if (!bl2) continue;
                return true;
            }
            object2 = this.getSourceRealizer();
            object = this.getSourcePort();
            if (rectangle2D.contains(object.a((fj)object2), object.b((fj)object2))) {
                return true;
            }
            object2 = this.getTargetRealizer();
            object = this.getTargetPort();
            if (!rectangle2D.contains(object.a((fj)object2), object.b((fj)object2))) return false;
            return true;
        }
        p p2 = this.bends.k();
        do {
            if (p2 == null) return false;
            x x2 = (x)p2.c();
            bl2 = x2.d();
            if (bl3) return bl2;
            if (bl2 && rectangle2D.contains(x2.b(), x2.c())) {
                return true;
            }
            p2 = p2.a();
        } while (!bl3);
        return false;
    }

    @Override
    protected void paintHighlightedBends(Graphics2D graphics2D) {
        super.c(graphics2D);
        super.paintHighlightedBends(graphics2D);
    }

    @Override
    public void write(ObjectOutputStream objectOutputStream) {
        objectOutputStream.writeByte(0);
        super.write(objectOutputStream);
    }

    @Override
    public void read(ObjectInputStream objectInputStream) {
        switch (objectInputStream.readByte()) {
            case 0: {
                super.read(objectInputStream);
                if (!fj.z) return;
            }
        }
        throw new a();
    }
}

