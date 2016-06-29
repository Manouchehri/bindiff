/*
 * Decompiled with CFR 0_115.
 */
package y.h;

import java.awt.Rectangle;
import java.awt.Shape;
import java.awt.geom.AffineTransform;
import java.awt.geom.Area;
import java.awt.geom.FlatteningPathIterator;
import java.awt.geom.PathIterator;
import java.awt.geom.Point2D;
import java.awt.geom.Rectangle2D;
import y.h.eI;
import y.h.eJ;
import y.h.eK;
import y.h.eL;
import y.h.eM;
import y.h.eN;
import y.h.eO;
import y.h.eP;
import y.h.fj;

public class eH
implements Shape {
    private int a;
    private eM b;
    private eM c;
    private int d;
    private int e;
    private int f;
    private long g;
    private eM h;
    private eM i;
    private eM j;
    private AffineTransform k;
    private int l;

    public eI a() {
        return this.b;
    }

    public void a(PathIterator pathIterator) {
        boolean bl2 = fj.z;
        double[] arrd = new double[6];
        do {
            if (pathIterator.isDone()) return;
            int n2 = pathIterator.currentSegment(arrd);
            switch (n2) {
                case 4: {
                    this.b();
                    if (!bl2) break;
                }
                case 1: {
                    this.b(arrd[0], arrd[1]);
                    if (!bl2) break;
                }
                case 0: {
                    this.a(arrd[0], arrd[1]);
                    if (!bl2) break;
                }
                case 2: {
                    this.a(arrd[0], arrd[1], arrd[2], arrd[3]);
                    if (!bl2) break;
                }
                case 3: {
                    this.a(arrd[0], arrd[1], arrd[2], arrd[3], arrd[4], arrd[5]);
                }
            }
            pathIterator.next();
        } while (!bl2);
    }

    public eI a(double d2, double d3, double d4, double d5, eI eI2) {
        eK eK2 = this.e();
        eK2.a = d2;
        eK2.b = d3;
        eK2.c = d4;
        eK2.d = d5;
        this.a(eK2, (eM)eI2);
        return eK2;
    }

    public eI a(double d2, double d3, eI eI2) {
        ++this.e;
        eN eN2 = this.d();
        eN2.a = 0;
        eN2.b = d2;
        eN2.c = d3;
        this.a(eN2, (eM)eI2);
        return eN2;
    }

    public eI b(double d2, double d3, eI eI2) {
        eN eN2 = this.d();
        eN2.a = 1;
        eN2.b = d2;
        eN2.c = d3;
        this.a(eN2, (eM)eI2);
        return eN2;
    }

    public eI a(double d2, double d3) {
        ++this.e;
        eN eN2 = this.d();
        eN2.a = 0;
        eN2.b = d2;
        eN2.c = d3;
        this.a(eN2);
        return eN2;
    }

    public eI b(double d2, double d3) {
        eN eN2 = this.d();
        eN2.a = 1;
        eN2.b = d2;
        eN2.c = d3;
        this.a(eN2);
        return eN2;
    }

    public eI b() {
        ++this.f;
        eO eO2 = new eO();
        this.a(eO2);
        return eO2;
    }

    public eI a(double d2, double d3, double d4, double d5, double d6, double d7) {
        eL eL2 = this.f();
        eL2.a = d2;
        eL2.b = d3;
        eL2.c = d4;
        eL2.d = d5;
        eL2.e = d6;
        eL2.f = d7;
        this.a(eL2);
        ++this.d;
        return eL2;
    }

    public eI a(double d2, double d3, double d4, double d5) {
        eK eK2 = this.e();
        eK2.a = d2;
        eK2.b = d3;
        eK2.c = d4;
        eK2.d = d5;
        this.a(eK2);
        ++this.d;
        return eK2;
    }

    private eN d() {
        boolean bl2 = fj.z;
        if (this.h == null) return new eN();
        while (this.h != null && !(this.h instanceof eN)) {
            eM eM2 = this.h;
            this.h = this.h.g;
            eM2.g = null;
            eM2.h = null;
            if (eM2 instanceof eK) {
                eM2.g = this.i;
                this.i = eM2;
                if (!bl2) continue;
            }
            if (!(eM2 instanceof eL)) continue;
            eM2.g = this.j;
            this.j = eM2;
            if (bl2) return new eN();
            if (!bl2) continue;
        }
        if (this.h == null) return new eN();
        eN eN2 = (eN)this.h;
        this.h = eN2.g;
        eN2.g = null;
        eN2.h = null;
        return eN2;
    }

    private eK e() {
        if (this.i == null) return new eK();
        eK eK2 = (eK)this.i;
        this.i = eK2.g;
        eK2.g = null;
        eK2.h = null;
        if (!fj.z) return eK2;
        return new eK();
    }

    private eL f() {
        if (this.j == null) return new eL();
        eL eL2 = (eL)this.j;
        this.j = eL2.g;
        eL2.g = null;
        eL2.h = null;
        if (!fj.z) return eL2;
        return new eL();
    }

    public void c() {
        if (this.c == null) {
            return;
        }
        if (this.a > this.d + this.f) {
            this.c.g = this.h;
            this.h = this.b;
        }
        ++this.g;
        this.c = null;
        this.b = null;
        this.a = 0;
        this.d = 0;
        this.f = 0;
        this.e = 0;
    }

    /*
     * Unable to fully structure code
     */
    private void a(eM var1_1, eM var2_2) {
        var4_3 = fj.z;
        if (var2_2 != null) ** GOTO lbl5
        this.a(var1_1);
        if (!var4_3) ** GOTO lbl14
lbl5: // 2 sources:
        ++this.g;
        var3_4 = var2_2.h;
        var2_2.h = var1_1;
        var1_1.g = var2_2;
        var1_1.h = var3_4;
        if (var3_4 == null) ** GOTO lbl-1000
        var3_4.g = var1_1;
        if (var4_3) lbl-1000: // 2 sources:
        {
            this.b = var1_1;
        }
lbl14: // 4 sources:
        ++this.a;
    }

    /*
     * Unable to fully structure code
     */
    private void a(eM var1_1) {
        ++this.g;
        var1_1.g = null;
        if (this.c != null) ** GOTO lbl-1000
        this.b = var1_1;
        this.a = 1;
        if (fj.z) lbl-1000: // 2 sources:
        {
            ++this.a;
            this.c.g = var1_1;
            var1_1.h = this.c;
        }
        this.c = var1_1;
    }

    @Override
    public PathIterator getPathIterator(AffineTransform affineTransform) {
        if (affineTransform == null) {
            if (this.k == null) return new eP(this.b, this.l);
            return new eJ(this.b, affineTransform, this.l);
        }
        if (this.k == null) return new eJ(this.b, affineTransform, this.l);
        AffineTransform affineTransform2 = (AffineTransform)this.k.clone();
        affineTransform2.preConcatenate(affineTransform);
        return new eJ(this.b, affineTransform2, this.l);
    }

    @Override
    public PathIterator getPathIterator(AffineTransform affineTransform, double d2) {
        if (this.d <= 0) return this.getPathIterator(affineTransform);
        return new FlatteningPathIterator(this.getPathIterator(affineTransform), d2);
    }

    @Override
    public boolean contains(Rectangle2D rectangle2D) {
        return this.contains(rectangle2D.getX(), rectangle2D.getY(), rectangle2D.getWidth(), rectangle2D.getHeight());
    }

    @Override
    public boolean contains(Point2D point2D) {
        return this.contains(point2D.getX(), point2D.getY());
    }

    @Override
    public boolean contains(double d2, double d3) {
        if (this.f != 0) return new Area(this).contains(d2, d3);
        return false;
    }

    @Override
    public boolean contains(double d2, double d3, double d4, double d5) {
        return new Area(this).contains(d2, d3, d4, d5);
    }

    @Override
    public Rectangle getBounds() {
        return this.getBounds2D().getBounds();
    }

    @Override
    public Rectangle2D getBounds2D() {
        return new Area(this).getBounds2D();
    }

    @Override
    public boolean intersects(Rectangle2D rectangle2D) {
        return this.intersects(rectangle2D.getX(), rectangle2D.getY(), rectangle2D.getWidth(), rectangle2D.getHeight());
    }

    @Override
    public boolean intersects(double d2, double d3, double d4, double d5) {
        return new Area(this).intersects(d2, d3, d4, d5);
    }
}

