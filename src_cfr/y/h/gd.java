/*
 * Decompiled with CFR 0_115.
 */
package y.h;

import java.awt.geom.AffineTransform;
import java.awt.geom.GeneralPath;
import java.awt.geom.Line2D;
import java.awt.geom.PathIterator;
import java.awt.geom.Point2D;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import y.c.p;
import y.e.a;
import y.h.aB;
import y.h.fL;
import y.h.fj;
import y.h.gE;
import y.h.hC;
import y.h.ij;
import y.h.x;
import y.h.y;
import y.h.z;

public class gD
extends aB {
    public gD() {
    }

    public gD(aB aB2) {
        super(aB2);
    }

    @Override
    public aB createCopy(aB aB2) {
        return new gD(aB2);
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
        int n2 = this.containsSeg(d2, d3);
        if (n2 <= 0) return null;
        return this.createBend(d2, d3, (x)this.bends.a(n2 - 1), 1);
    }

    @Override
    public x removeBend(x x2) {
        this.bends.remove(x2);
        this.setDirty();
        return x2;
    }

    @Override
    protected byte calculatePath(Point2D point2D, Point2D point2D2) {
        int n2;
        int[] arrn;
        int[] arrn2;
        gE[] arrgE;
        boolean bl2;
        int n3;
        gE[] arrgE2;
        int n4;
        block6 : {
            bl2 = fj.z;
            if (this.bendCount() == 0) {
                return ij.a(this, this.path, point2D, point2D2);
            }
            n3 = this.bendCount() + 2;
            arrn = new int[n3];
            arrn2 = new int[n3];
            fj fj2 = this.getSourceRealizer();
            fj fj3 = this.getTargetRealizer();
            fL fL2 = this.getSourcePort();
            fL fL3 = this.getTargetPort();
            n2 = 0;
            arrn[n2] = (int)fL2.a(fj2);
            arrn2[n2] = (int)fL2.b(fj2);
            ++n2;
            arrgE = this.bends();
            while (arrgE.f()) {
                arrgE2 = arrgE.a();
                arrn[n2] = (int)arrgE2.b();
                arrn2[n2] = (int)arrgE2.c();
                arrgE.g();
                ++n2;
                if (!bl2) {
                    if (!bl2) continue;
                }
                break block6;
            }
            arrn[n2] = (int)fL3.a(fj3);
            arrn2[n2] = (int)fL3.b(fj3);
        }
        arrgE = this.a(n3 - 1, arrn);
        arrgE2 = this.a(n3 - 1, arrn2);
        this.path.reset();
        this.path.moveTo(arrgE[0].a(0.0f), arrgE2[0].a(0.0f));
        n2 = 0;
        while (n2 < arrgE.length) {
            block7 : {
                n4 = 1;
                if (bl2) return (byte)n4;
                for (int i2 = v2251279; i2 <= 12; ++i2) {
                    float f2 = (float)i2 / 12.0f;
                    this.path.lineTo(arrgE[n2].a(f2), arrgE2[n2].a(f2));
                    if (!bl2) {
                        if (!bl2) continue;
                    }
                    break block7;
                }
                ++n2;
            }
            if (!bl2) continue;
        }
        this.path = new GeneralPath(1, this.bendCount() + 4);
        n4 = ij.a(this, this.path, this.path, point2D, point2D2);
        return (byte)n4;
    }

    @Override
    public int containsSeg(double d2, double d3) {
        boolean bl2 = fj.z;
        if (this.bendCount() == 0) {
            return super.containsSeg(d2, d3);
        }
        int n2 = 1;
        if (this.isDirty()) {
            this.recalculateFeatures();
        }
        y y2 = this.bends();
        double d4 = y2.a().b();
        double d5 = y2.a().c();
        PathIterator pathIterator = this.path.getPathIterator(null);
        if (pathIterator.isDone()) {
            return 0;
        }
        float[] arrf = hC.a().c;
        pathIterator.currentSegment(arrf);
        pathIterator.next();
        float f2 = arrf[0];
        float f3 = arrf[1];
        do {
            if (pathIterator.isDone()) return 0;
            pathIterator.currentSegment(arrf);
            int n3 = (int)(Line2D.ptSegDist(f2, f3, arrf[0], arrf[1], d2, d3) DCMPG 5.0);
            if (bl2) return n3;
            if (n3 < 0) {
                return n2;
            }
            if (Line2D.ptSegDist(f2, f3, arrf[0], arrf[1], d4, d5) < 5.0 && y2.f()) {
                ++n2;
                y2.g();
                if (y2.f()) {
                    d4 = y2.a().b();
                    d5 = y2.a().c();
                }
            }
            pathIterator.next();
            f2 = arrf[0];
            f3 = arrf[1];
        } while (!bl2);
        return 0;
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

    private gE[] a(int n2, int[] arrn) {
        int n3;
        float[] arrf;
        gE[] arrgE;
        float[] arrf2;
        boolean bl2;
        float[] arrf3;
        block7 : {
            block6 : {
                bl2 = fj.z;
                arrf2 = new float[n2 + 1];
                arrf3 = new float[n2 + 1];
                arrf = new float[n2 + 1];
                arrf2[0] = 0.5f;
                for (n3 = 1; n3 < n2; ++n3) {
                    arrf2[n3] = 1.0f / (4.0f - arrf2[n3 - 1]);
                    if (!bl2) {
                        if (!bl2) continue;
                    }
                    break block6;
                }
                arrf2[n2] = 1.0f / (2.0f - arrf2[n2 - 1]);
                arrf3[0] = (float)(3 * (arrn[1] - arrn[0])) * arrf2[0];
            }
            for (n3 = 1; n3 < n2; ++n3) {
                arrf3[n3] = ((float)(3 * (arrn[n3 + 1] - arrn[n3 - 1])) - arrf3[n3 - 1]) * arrf2[n3];
                if (!bl2) {
                    if (!bl2) continue;
                }
                break block7;
            }
            arrf3[n2] = ((float)(3 * (arrn[n2] - arrn[n2 - 1])) - arrf3[n2 - 1]) * arrf2[n2];
            arrf[n2] = arrf3[n2];
        }
        for (n3 = n2 - 1; n3 >= 0; --n3) {
            arrf[n3] = arrf3[n3] - arrf2[n3] * arrf[n3 + 1];
            if (!bl2) continue;
        }
        gE[] arrgE2 = new gE[n2];
        for (n3 = 0; n3 < n2; ++n3) {
            arrgE = arrgE2;
            if (bl2) return arrgE;
            arrgE[n3] = new gE(arrn[n3], arrf[n3], (float)(3 * (arrn[n3 + 1] - arrn[n3])) - 2.0f * arrf[n3] - arrf[n3 + 1], (float)(2 * (arrn[n3] - arrn[n3 + 1])) + arrf[n3] + arrf[n3 + 1]);
            if (!bl2) continue;
        }
        arrgE = arrgE2;
        return arrgE;
    }
}

