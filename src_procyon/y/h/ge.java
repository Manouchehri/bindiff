package y.h;

import java.awt.geom.*;
import y.c.*;
import java.awt.*;
import java.io.*;
import y.e.*;

public class ge extends aB
{
    private final GeneralPath a;
    private double b;
    
    public ge() {
        this.a = new GeneralPath();
        this.b = 0.1;
    }
    
    public ge(final aB ab) {
        super(ab);
        this.a = new GeneralPath();
        this.b = 0.1;
        if (ab instanceof ge) {
            this.a(((ge)ab).a());
        }
    }
    
    public aB createCopy(final aB ab) {
        return new ge(ab);
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
        final y bends = this.bends();
        while (true) {
            while (bends.f()) {
                final x a2 = bends.a();
                final double b2 = a2.b();
                final double c = a2.c();
                final double n4 = dcmpg(Line2D.ptSegDist(a, b, b2, c, n, n2), 5.0);
                if (!z) {
                    if (n4 < 0) {
                        return n3;
                    }
                    a = b2;
                    b = c;
                    bends.g();
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
        if (this.bendCount() == 0 || this.b >= 1.0) {
            return ij.a(this, this.path, point2D, point2D2);
        }
        final int bendCount = this.bendCount();
        final float n = (this.b == 0.0) ? 0.0f : ((float)(1.0 - this.b) * 0.5f);
        final float n2 = 1.0f - n;
        this.path.reset();
        this.a.reset();
        fj fj = this.getSourceRealizer();
        fL fl = this.getSourcePort();
        final GeneralPath a = this.a;
        final float n3 = (float)fl.a(fj);
        final float n4;
        a.moveTo(n3, n4 = (float)fl.b(fj));
        int i = 0;
        float n5 = n3;
        float n6 = n4;
        final y bends = this.bends();
        final x a2 = bends.a();
        float n7 = (float)a2.b();
        float n8 = (float)a2.c();
        bends.g();
        ++i;
        while (true) {
            while (i < bendCount) {
                final x a3 = bends.a();
                final float n9 = (float)a3.b();
                final float n10 = (float)a3.c();
                final float n11 = n;
                if (z) {
                    final float n12 = n11;
                    final float n13 = (float)fl.b(fj);
                    Label_0515: {
                        if (n > 0.0f) {
                            this.a.lineTo(n2 * n7 + n5 * n, n2 * n8 + n6 * n);
                            this.a.quadTo(n7, n8, n * n12 + n7 * n2, n * n13 + n8 * n2);
                            this.a.lineTo(n12, n13);
                            if (!z) {
                                break Label_0515;
                            }
                        }
                        this.a.quadTo(n7, n8, n12, n13);
                    }
                    this.path.append(this.a.getPathIterator(null, 0.5), false);
                    final GeneralPath path = this.path;
                    final GeneralPath path2 = new GeneralPath(1, this.bendCount() + 4);
                    this.path = path2;
                    return ij.a(this, path, path2, point2D, point2D2);
                }
                Label_0352: {
                    if (n11 > 0.0f) {
                        this.a.lineTo(n2 * n7 + n5 * n, n2 * n8 + n6 * n);
                        this.a.quadTo(n7, n8, n * n9 + n7 * n2, n * n10 + n8 * n2);
                        n5 = n7;
                        n6 = n8;
                        n7 = n9;
                        n8 = n10;
                        if (!z) {
                            break Label_0352;
                        }
                    }
                    this.a.quadTo(n7, n8, (n7 + n9) * 0.5f, (n8 + n10) * 0.5f);
                    n7 = n9;
                    n8 = n10;
                }
                bends.g();
                ++i;
                if (z) {
                    break;
                }
            }
            fj = this.getTargetRealizer();
            fl = this.getTargetPort();
            final float n14 = (float)fl.a(fj);
            continue;
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
    
    protected void paintHighlightedBends(final Graphics2D graphics2D) {
        super.c(graphics2D);
        super.paintHighlightedBends(graphics2D);
    }
    
    public void write(final ObjectOutputStream objectOutputStream) {
        objectOutputStream.writeByte(0);
        super.write(objectOutputStream);
        objectOutputStream.writeDouble(this.a());
    }
    
    public void read(final ObjectInputStream objectInputStream) {
        switch (objectInputStream.readByte()) {
            case 0: {
                super.read(objectInputStream);
                this.a(objectInputStream.readDouble());
                if (fj.z) {
                    break;
                }
                return;
            }
        }
        throw new a();
    }
    
    public double a() {
        return this.b;
    }
    
    public void a(final double b) {
        if (b < 0.0 || b > 1.0) {
            throw new IllegalArgumentException();
        }
        if (this.b != b) {
            this.b = b;
            this.setDirty();
        }
    }
}
