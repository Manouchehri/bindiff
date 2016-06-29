package y.h;

import y.c.*;
import java.awt.geom.*;
import java.awt.*;
import java.io.*;
import y.e.*;

public class B extends aB
{
    private final GeneralPath a;
    
    public B() {
        this.a = new GeneralPath();
    }
    
    public B(final aB ab) {
        super(ab);
        this.a = new GeneralPath();
    }
    
    public aB createCopy(final aB ab) {
        return new B(ab);
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
        final int a = this.a(n, n2);
        if (a >= 0) {
            return this.createBend(n, n2, (x)this.bends.a(a), 1);
        }
        return null;
    }
    
    public boolean contains(final double n, final double n2) {
        if (!this.isSelected()) {
            return super.contains(n, n2);
        }
        return this.a(n, n2) >= 0;
    }
    
    public x removeBend(final x x) {
        this.bends.remove(x);
        this.setDirty();
        return x;
    }
    
    private int a(final double n, final double n2) {
        final boolean z = fj.z;
        double a = this.getSourcePort().a(this.getSourceRealizer());
        double b = this.getSourcePort().b(this.getSourceRealizer());
        int n3 = 0;
        p p2 = this.bends.k();
        while (true) {
            while (p2 != null) {
                final x x = (x)p2.c();
                final double b2 = x.b();
                final double c = x.c();
                final double n4 = dcmpg(Line2D.ptSegDist(a, b, b2, c, n, n2), 5.0);
                if (!z) {
                    if (n4 < 0) {
                        return n3;
                    }
                    a = b2;
                    b = c;
                    p2 = p2.a();
                    ++n3;
                    if (z) {
                        break;
                    }
                    continue;
                }
                else {
                    if (n4 < 0) {
                        return n3;
                    }
                    return -1;
                }
            }
            final double n5 = dcmpg(Line2D.ptSegDist(a, b, this.getTargetPort().a(this.getTargetRealizer()), this.getTargetPort().b(this.getTargetRealizer()), n, n2), 5.0);
            continue;
        }
    }
    
    protected byte calculatePath(final Point2D point2D, final Point2D point2D2) {
        final boolean z = fj.z;
        if (this.bendCount() == 0) {
            return ij.a(this, this.path, point2D, point2D2);
        }
        int n = 2;
        Label_0066: {
            if ((this.bendCount() & 0x1) == 0x1) {
                n += 3 * this.bendCount() + 1 >> 1;
                if (!z) {
                    break Label_0066;
                }
            }
            n += 3 * (this.bendCount() >> 1) - 1;
        }
        final float[] array = new float[n];
        final float[] array2 = new float[n];
        final fj sourceRealizer = this.getSourceRealizer();
        final fL sourcePort = this.getSourcePort();
        array[0] = (float)sourcePort.a(sourceRealizer);
        array2[0] = (float)sourcePort.b(sourceRealizer);
        int n2 = 1;
        final y bends = this.bends();
        while (true) {
            while (bends.f()) {
                final x a = bends.a();
                final int n3 = n2 % 3;
                if (z) {
                    if (n3 == 2) {
                        array[n2] = array[n2 - 1];
                        array2[n2] = array2[n2 - 1];
                    }
                    final fj targetRealizer = this.getTargetRealizer();
                    final fL targetPort = this.getTargetPort();
                    array[n - 1] = (float)targetPort.a(targetRealizer);
                    array2[n - 1] = (float)targetPort.b(targetRealizer);
                    this.path.reset();
                    this.a.reset();
                    this.a.moveTo(array[0], array2[0]);
                    int i = 0;
                    while (true) {
                        while (i < n - 3) {
                            this.a.curveTo(array[i + 1], array2[i + 1], array[i + 2], array2[i + 2], array[i + 3], array2[i + 3]);
                            i += 3;
                            if (z) {
                                final GeneralPath path = this.path;
                                final GeneralPath path2 = new GeneralPath(1, this.bendCount() + 4);
                                this.path = path2;
                                return ij.a(this, path, path2, point2D, point2D2);
                            }
                            if (z) {
                                break;
                            }
                        }
                        this.path.append(this.a.getPathIterator(null, 0.75), false);
                        continue;
                    }
                }
                if (n3 == 0) {
                    array[n2] = (float)(a.b() + array[n2 - 1]) / 2.0f;
                    array2[n2] = (float)(a.c() + array2[n2 - 1]) / 2.0f;
                    ++n2;
                }
                array[n2] = (float)a.b();
                array2[n2] = (float)a.c();
                bends.g();
                ++n2;
                if (z) {
                    break;
                }
            }
            continue;
        }
    }
    
    public void calcUnionRect(final Rectangle2D rectangle2D) {
        final boolean z = fj.z;
        super.calcUnionRect(rectangle2D);
        if (this.isSelected()) {
            p p = this.bends.k();
            while (p != null) {
                final x x = (x)p.c();
                rectangle2D.add(x.b(), x.c());
                p = p.a();
                if (z) {
                    return;
                }
                if (z) {
                    break;
                }
            }
            final fj sourceRealizer = this.getSourceRealizer();
            final fL sourcePort = this.getSourcePort();
            rectangle2D.add(sourcePort.a(sourceRealizer), sourcePort.b(sourceRealizer));
            final fj targetRealizer = this.getTargetRealizer();
            final fL targetPort = this.getTargetPort();
            rectangle2D.add(targetPort.a(targetRealizer), targetPort.b(targetRealizer));
            if (!z) {
                return;
            }
        }
        p p2 = this.bends.k();
        while (p2 != null) {
            final x x2 = (x)p2.c();
            if (x2.d()) {
                rectangle2D.add(x2.b(), x2.c());
            }
            p2 = p2.a();
            if (z) {
                break;
            }
        }
    }
    
    public boolean intersects(final Rectangle2D rectangle2D) {
        final boolean z = fj.z;
        if (!super.intersects(rectangle2D)) {
            boolean contains = false;
            if (this.isSelected()) {
                p p = this.bends.k();
                while (p != null) {
                    final x x = (x)p.c();
                    contains = rectangle2D.contains(x.b(), x.c());
                    if (z) {
                        return contains;
                    }
                    if (contains) {
                        return true;
                    }
                    p = p.a();
                    if (z) {
                        break;
                    }
                }
                final fj sourceRealizer = this.getSourceRealizer();
                final fL sourcePort = this.getSourcePort();
                if (rectangle2D.contains(sourcePort.a(sourceRealizer), sourcePort.b(sourceRealizer))) {
                    return true;
                }
                final fj targetRealizer = this.getTargetRealizer();
                final fL targetPort = this.getTargetPort();
                if (rectangle2D.contains(targetPort.a(targetRealizer), targetPort.b(targetRealizer))) {
                    return true;
                }
            }
            else {
                p p2 = this.bends.k();
                while (p2 != null) {
                    final x x2 = (x)p2.c();
                    final boolean d = x2.d();
                    if (z) {
                        break;
                    }
                    if (d && rectangle2D.contains(x2.b(), x2.c())) {
                        return true;
                    }
                    p2 = p2.a();
                    if (z) {
                        break;
                    }
                }
            }
            return contains;
        }
        return true;
    }
    
    protected void paintHighlightedBends(final Graphics2D graphics2D) {
        super.c(graphics2D);
        super.paintHighlightedBends(graphics2D);
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
}
