/*
 * Decompiled with CFR 0_115.
 */
package y.h;

import java.awt.geom.AffineTransform;
import java.awt.geom.GeneralPath;
import java.awt.geom.Line2D;
import java.awt.geom.PathIterator;
import java.awt.geom.Point2D;
import java.awt.geom.Rectangle2D;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import javax.swing.Icon;
import y.c.d;
import y.c.p;
import y.d.y;
import y.e.a;
import y.h.C;
import y.h.aA;
import y.h.aB;
import y.h.fL;
import y.h.fj;
import y.h.ij;
import y.h.x;
import y.h.z;

public class fJ
extends aB {
    private boolean ic;

    public fJ() {
        this.ic = false;
    }

    public fJ(aB aB2) {
        super(aB2);
        if (aB2 instanceof fJ) {
            this.ic = ((fJ)aB2).getSmoothedBends();
            if (!fj.z) return;
        }
        this.ic = false;
    }

    @Override
    public aB createCopy(aB aB2) {
        return new fJ(aB2);
    }

    public void setSmoothedBends(boolean bl2) {
        if (bl2 == this.ic) return;
        this.ic = bl2;
        this.setDirty();
    }

    public boolean getSmoothedBends() {
        return this.ic;
    }

    @Override
    public x createBend(double d2, double d3, x x2, int n2) {
        x x3 = new x(this, d2, d3);
        this.reInsertBend(x3, x2, n2);
        return x3;
    }

    /*
     * Unable to fully structure code
     */
    @Override
    public void reInsertBend(x var1_1, x var2_2, int var3_3) {
        var4_4 = fj.z;
        if (var3_3 != 0) ** GOTO lbl8
        if (this.bends.size() <= 0 || var2_2 != this.bends.i()) ** GOTO lbl6
        this.bends.b(var1_1, this.bends.l());
        if (!var4_4) ** GOTO lbl12
lbl6: // 2 sources:
        this.bends.b(var1_1, this.bends.d(var2_2));
        if (!var4_4) ** GOTO lbl12
lbl8: // 2 sources:
        if (this.bends.size() <= 0 || var2_2 != this.bends.f()) ** GOTO lbl-1000
        this.bends.a(var1_1, this.bends.k());
        if (var4_4) lbl-1000: // 2 sources:
        {
            this.bends.a(var1_1, this.bends.d(var2_2));
        }
lbl12: // 5 sources:
        this.setDirty();
    }

    @Override
    public x insertBend(double d2, double d3) {
        int n2 = this.containsSeg(d2, d3);
        if (n2 <= 0) return this.appendBend(d2, d3);
        if (n2 > this.bends.size()) return this.appendBend(d2, d3);
        return this.createBend(d2, d3, (x)this.bends.a(n2 - 1), 1);
    }

    @Override
    public x removeBend(x x2) {
        this.bends.remove(x2);
        this.setDirty();
        return x2;
    }

    @Override
    public int containsSeg(double d2, double d3) {
        double d4;
        int n2;
        block5 : {
            double d5;
            double d6;
            boolean bl2 = fj.z;
            if (this.getEdge().e() && this.bendCount() < 2) {
                return super.containsSeg(d2, d3);
            }
            if (this.isDirty()) {
                this.recalculateFeatures();
            }
            Point2D point2D = this.getSourceIntersection();
            double d7 = point2D.getX();
            double d8 = point2D.getY();
            n2 = 1;
            for (p p2 = this.bends.k(); p2 != null; p2 = p2.a(), ++n2) {
                x x2 = (x)p2.c();
                d5 = x2.b();
                d6 = x2.c();
                d4 = Line2D.ptSegDistSq(d7, d8, d5, d6, d2, d3) DCMPG 25.0;
                if (!bl2) {
                    if (d4 < 0) {
                        return n2;
                    }
                    d7 = d5;
                    d8 = d6;
                    if (!bl2) continue;
                }
                break block5;
            }
            point2D = this.getTargetIntersection();
            d5 = point2D.getX();
            d6 = point2D.getY();
            d4 = Line2D.ptSegDistSq(d7, d8, d5, d6, d2, d3) DCMPG 25.0;
        }
        if (d4 >= 0) return 0;
        return n2;
    }

    /*
     * Unable to fully structure code
     */
    @Override
    Rectangle2D.Float b(Rectangle2D.Float var1_1) {
        var16_2 = fj.z;
        if (this.getEdge().e() && this.bendCount() < 2) {
            var1_1 = super.b(var1_1);
            if (this.bendCount() != 1) return var1_1;
            var2_3 = this.bends.a();
            var1_1.add(var2_3.b(), var2_3.c());
            return var1_1;
        }
        var2_4 = this.getTargetIntersection();
        if (var1_1 == null) ** GOTO lbl-1000
        var1_1.setFrame(var2_4.getX(), var2_4.getY(), 1.0, 1.0);
        if (var16_2) lbl-1000: // 2 sources:
        {
            var1_1 = new Rectangle2D.Float((float)var2_4.getX(), (float)var2_4.getY(), 1.0f, 1.0f);
        }
        for (var3_5 = this.bends.k(); var3_5 != null; var3_5 = var3_5.a()) {
            var4_6 = (x)var3_5.c();
            var1_1.add(var4_6.b(), var4_6.c());
            if (!var16_2) continue;
        }
        var3_5 = this.getSourcePort();
        var4_6 = this.getTargetPort();
        var3_5.a(var1_1, this.getSourceRealizer());
        var4_6.a(var1_1, this.getTargetRealizer());
        var5_7 = var1_1.getX();
        var7_8 = var5_7 + var1_1.getWidth();
        var9_9 = var1_1.getY();
        var11_10 = var9_9 + var1_1.getHeight();
        for (var13_11 = this.labelCount() - 1; var13_11 >= 0; --var13_11) {
            var14_12 = this.getLabel(var13_11);
            if (var16_2 != false) return var1_1;
            if (!var14_12.isVisible() || var14_12.getText().length() == 0 && var14_12.getIcon() == null) continue;
            var15_13 = var14_12.getBox();
            var7_8 = Math.max(var15_13.c + var15_13.a, var7_8);
            var5_7 = Math.min(var15_13.c, var5_7);
            var11_10 = Math.max(var15_13.d + var15_13.b, var11_10);
            var9_9 = Math.min(var15_13.d, var9_9);
            if (!var16_2) continue;
        }
        var1_1.setFrame(var5_7, var9_9, var7_8 - var5_7, var11_10 - var9_9);
        return var1_1;
    }

    @Override
    public boolean pathIntersects(Rectangle2D rectangle2D, boolean bl2) {
        Object object;
        Object object2;
        boolean bl3;
        boolean bl4 = fj.z;
        if (!this.isDirty() && this.nb != null && !this.nb.intersects(rectangle2D)) {
            return false;
        }
        if (this.bends.size() > 0) {
            for (object2 = this.bends.k(); object2 != null; object2 = object2.a()) {
                object = (x)object2.c();
                if (!rectangle2D.contains(object.b(), object.c())) continue;
                return true;
            }
        }
        if (rectangle2D.contains((Point2D)(object2 = this.getTargetIntersection()))) {
            return true;
        }
        object = this.getSourceIntersection();
        if (rectangle2D.contains((Point2D)object)) {
            return true;
        }
        if (bl2) {
            for (int i2 = this.labelCount() - 1; i2 >= 0; --i2) {
                aA aA2 = this.getLabel(i2);
                if (!aA2.isVisible() || aA2.getText().length() == 0 && aA2.getIcon() == null) continue;
                y y2 = aA2.getBox();
                if (!rectangle2D.intersects(y2.c, y2.d, y2.a, y2.b)) continue;
                return true;
            }
        }
        double d2 = object.getX();
        double d3 = object.getY();
        if (this.bends.size() > 0) {
            for (p p2 = this.bends.k(); p2 != null; p2 = p2.a()) {
                x x2 = (x)p2.c();
                bl3 = rectangle2D.intersectsLine(d2, d3, x2.b(), x2.c());
                if (bl4) return bl3;
                if (bl3) {
                    return true;
                }
                d2 = x2.b();
                d3 = x2.c();
                if (!bl4) continue;
            }
        }
        bl3 = rectangle2D.intersectsLine(d2, d3, object2.getX(), object2.getY());
        return bl3;
    }

    @Override
    protected byte calculatePath(Point2D point2D, Point2D point2D2) {
        boolean bl2 = false;
        if (this.getEdge().e()) {
            if (this.bendCount() == 0) {
                fj fj2 = this.getSourceRealizer();
                this.appendBend(this.getSourcePort().a(fj2), this.getSourcePort().b(fj2) - 10.0 - fj2.getHeight());
                bl2 = true;
                if (!fj.z) return ij.b(this, this.path, point2D, point2D2);
            }
            if (this.bendCount() == 1) {
                return ij.b(this, this.path, point2D, point2D2);
            }
            if (bl2) {
                return ij.b(this, this.path, point2D, point2D2);
            }
        }
        if (!this.ic) return ij.a(this, this.path, point2D, point2D2);
        return ij.c(this, this.path, point2D, point2D2);
    }

    @Override
    public void registerObstacles(C c2) {
        c2.b(this.getPath().getPathIterator(null));
    }

    @Override
    public void write(ObjectOutputStream objectOutputStream) {
        objectOutputStream.writeByte(1);
        super.write(objectOutputStream);
        objectOutputStream.writeBoolean(this.ic);
    }

    @Override
    public void read(ObjectInputStream objectInputStream) {
        boolean bl2 = fj.z;
        switch (objectInputStream.readByte()) {
            case 0: {
                super.read(objectInputStream);
                this.ic = false;
                if (!bl2) return;
            }
            case 1: {
                super.read(objectInputStream);
                this.ic = objectInputStream.readBoolean();
                if (!bl2) return;
            }
        }
        throw new a();
    }
}

