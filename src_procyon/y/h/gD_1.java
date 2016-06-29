package y.h;

import java.awt.geom.*;
import java.io.*;
import y.e.*;

public class gD extends aB
{
    public gD() {
    }
    
    public gD(final aB ab) {
        super(ab);
    }
    
    public aB createCopy(final aB ab) {
        return new gD(ab);
    }
    
    public x createBend(final double n, final double n2, final x x, final int n3) {
        final x x2 = new x(this, n, n2);
        this.reInsertBend(x2, x, n3);
        return x2;
    }
    
    public void reInsertBend(final x x, final x x2, final int n) {
        Label_0044: {
            if (n == 0) {
                this.bends.b(x, this.bends.d(x2));
                if (!fj.z) {
                    break Label_0044;
                }
            }
            this.bends.a(x, this.bends.d(x2));
        }
        this.setDirty();
    }
    
    public x insertBend(final double n, final double n2) {
        final int containsSeg = this.containsSeg(n, n2);
        if (containsSeg > 0) {
            return this.createBend(n, n2, (x)this.bends.a(containsSeg - 1), 1);
        }
        return null;
    }
    
    public x removeBend(final x x) {
        this.bends.remove(x);
        this.setDirty();
        return x;
    }
    
    protected byte calculatePath(final Point2D point2D, final Point2D point2D2) {
        final boolean z = fj.z;
        if (this.bendCount() == 0) {
            return ij.a(this, this.path, point2D, point2D2);
        }
        final int n = this.bendCount() + 2;
        final int[] array = new int[n];
        final int[] array2 = new int[n];
        final fj sourceRealizer = this.getSourceRealizer();
        final fj targetRealizer = this.getTargetRealizer();
        final fL sourcePort = this.getSourcePort();
        final fL targetPort = this.getTargetPort();
        int n2 = 0;
        array[n2] = (int)sourcePort.a(sourceRealizer);
        array2[n2] = (int)sourcePort.b(sourceRealizer);
        ++n2;
        final y bends = this.bends();
        while (true) {
            while (bends.f()) {
                final x a = bends.a();
                array[n2] = (int)a.b();
                array2[n2] = (int)a.c();
                bends.g();
                ++n2;
                if (z) {
                    final gE[] a2 = this.a(n - 1, array);
                    final gE[] a3 = this.a(n - 1, array2);
                    this.path.reset();
                    this.path.moveTo(a2[0].a(0.0f), a3[0].a(0.0f));
                    int i = 0;
                    boolean b = false;
                Label_0318_Outer:
                    while (i < a2.length) {
                        b = true;
                        if (!z) {
                            int j = b ? 1 : 0;
                            while (true) {
                                while (j <= 12) {
                                    final float n3 = j / 12.0f;
                                    this.path.lineTo(a2[i].a(n3), a3[i].a(n3));
                                    ++j;
                                    if (!z) {
                                        if (z) {
                                            break;
                                        }
                                        continue Label_0318_Outer;
                                    }
                                    else {
                                        if (z) {
                                            break Label_0318_Outer;
                                        }
                                        continue Label_0318_Outer;
                                    }
                                }
                                ++i;
                                continue;
                            }
                        }
                        return (byte)(b ? 1 : 0);
                    }
                    ij.a(this, this.path, this.path = new GeneralPath(1, this.bendCount() + 4), point2D, point2D2);
                    return (byte)(b ? 1 : 0);
                }
                if (z) {
                    break;
                }
            }
            array[n2] = (int)targetPort.a(targetRealizer);
            array2[n2] = (int)targetPort.b(targetRealizer);
            continue;
        }
    }
    
    public int containsSeg(final double n, final double n2) {
        final boolean z = fj.z;
        if (this.bendCount() == 0) {
            return super.containsSeg(n, n2);
        }
        int n3 = 1;
        if (this.isDirty()) {
            this.recalculateFeatures();
        }
        final y bends = this.bends();
        double n4 = bends.a().b();
        double n5 = bends.a().c();
        final PathIterator pathIterator = this.path.getPathIterator(null);
        if (pathIterator.isDone()) {
            return 0;
        }
        final float[] c = hC.a().c;
        pathIterator.currentSegment(c);
        pathIterator.next();
        float n6 = c[0];
        float n7 = c[1];
        double n8 = 0.0;
        while (!pathIterator.isDone()) {
            pathIterator.currentSegment(c);
            n8 = dcmpg(Line2D.ptSegDist(n6, n7, c[0], c[1], n, n2), 5.0);
            if (z) {
                return (int)n8;
            }
            if (n8 < 0) {
                return n3;
            }
            if (Line2D.ptSegDist(n6, n7, c[0], c[1], n4, n5) < 5.0 && bends.f()) {
                ++n3;
                bends.g();
                if (bends.f()) {
                    n4 = bends.a().b();
                    n5 = bends.a().c();
                }
            }
            pathIterator.next();
            n6 = c[0];
            n7 = c[1];
            if (z) {
                break;
            }
        }
        return (int)n8;
    }
    
    public void write(final ObjectOutputStream objectOutputStream) {
        objectOutputStream.writeByte(0);
        super.write(objectOutputStream);
    }
    
    public void read(final ObjectInputStream objectInputStream) {
        switch (objectInputStream.readByte()) {
            case 0: {
                super.read(objectInputStream);
                if (fj.z) {
                    break;
                }
                return;
            }
        }
        throw new a();
    }
    
    private gE[] a(final int n, final int[] array) {
        final boolean z = fj.z;
        final float[] array2 = new float[n + 1];
        final float[] array3 = new float[n + 1];
        final float[] array4 = new float[n + 1];
        array2[0] = 0.5f;
        int i = 1;
        while (true) {
            while (i < n) {
                array2[i] = 1.0f / (4.0f - array2[i - 1]);
                ++i;
                if (z) {
                    int j = 1;
                    while (true) {
                        while (j < n) {
                            array3[j] = (3 * (array[j + 1] - array[j - 1]) - array3[j - 1]) * array2[j];
                            ++j;
                            if (z) {
                                int k = n - 1;
                                while (k >= 0) {
                                    array4[k] = array3[k] - array2[k] * array4[k + 1];
                                    --k;
                                    if (z) {
                                        break;
                                    }
                                }
                                final gE[] array5 = new gE[n];
                                int l = 0;
                                gE[] array6 = null;
                                while (l < n) {
                                    array6 = array5;
                                    if (z) {
                                        return array6;
                                    }
                                    array6[l] = new gE(array[l], array4[l], 3 * (array[l + 1] - array[l]) - 2.0f * array4[l] - array4[l + 1], 2 * (array[l] - array[l + 1]) + array4[l] + array4[l + 1]);
                                    ++l;
                                    if (z) {
                                        break;
                                    }
                                }
                                return array6;
                            }
                            if (z) {
                                break;
                            }
                        }
                        array4[n] = (array3[n] = (3 * (array[n] - array[n - 1]) - array3[n - 1]) * array2[n]);
                        continue;
                    }
                }
                if (z) {
                    break;
                }
            }
            array2[n] = 1.0f / (2.0f - array2[n - 1]);
            array3[0] = 3 * (array[1] - array[0]) * array2[0];
            continue;
        }
    }
}
