package y.h;

import y.c.*;
import y.d.*;
import java.awt.geom.*;
import java.io.*;
import y.e.*;

public class fJ extends aB
{
    private boolean ic;
    
    public fJ() {
        this.ic = false;
    }
    
    public fJ(final aB ab) {
        super(ab);
        if (ab instanceof fJ) {
            this.ic = ((fJ)ab).getSmoothedBends();
            if (!fj.z) {
                return;
            }
        }
        this.ic = false;
    }
    
    public aB createCopy(final aB ab) {
        return new fJ(ab);
    }
    
    public void setSmoothedBends(final boolean ic) {
        if (ic != this.ic) {
            this.ic = ic;
            this.setDirty();
        }
    }
    
    public boolean getSmoothedBends() {
        return this.ic;
    }
    
    public x createBend(final double n, final double n2, final x x, final int n3) {
        final x x2 = new x(this, n, n2);
        this.reInsertBend(x2, x, n3);
        return x2;
    }
    
    public void reInsertBend(final x x, final x x2, final int n) {
        final boolean z = fj.z;
        Label_0132: {
            if (n == 0) {
                if (this.bends.size() > 0 && x2 == this.bends.i()) {
                    this.bends.b(x, this.bends.l());
                    if (!z) {
                        break Label_0132;
                    }
                }
                this.bends.b(x, this.bends.d(x2));
                if (!z) {
                    break Label_0132;
                }
            }
            if (this.bends.size() > 0 && x2 == this.bends.f()) {
                this.bends.a(x, this.bends.k());
                if (!z) {
                    break Label_0132;
                }
            }
            this.bends.a(x, this.bends.d(x2));
        }
        this.setDirty();
    }
    
    public x insertBend(final double n, final double n2) {
        final int containsSeg = this.containsSeg(n, n2);
        if (containsSeg > 0 && containsSeg <= this.bends.size()) {
            return this.createBend(n, n2, (x)this.bends.a(containsSeg - 1), 1);
        }
        return this.appendBend(n, n2);
    }
    
    public x removeBend(final x x) {
        this.bends.remove(x);
        this.setDirty();
        return x;
    }
    
    public int containsSeg(final double n, final double n2) {
        final boolean z = fj.z;
        if (this.getEdge().e() && this.bendCount() < 2) {
            return super.containsSeg(n, n2);
        }
        if (this.isDirty()) {
            this.recalculateFeatures();
        }
        final Point2D sourceIntersection = this.getSourceIntersection();
        double x = sourceIntersection.getX();
        double y = sourceIntersection.getY();
        int n3 = 1;
        p p2 = this.bends.k();
        while (true) {
            while (p2 != null) {
                final x x2 = (x)p2.c();
                final double b = x2.b();
                final double c = x2.c();
                final double n4 = dcmpg(Line2D.ptSegDistSq(x, y, b, c, n, n2), 25.0);
                if (!z) {
                    if (n4 < 0) {
                        return n3;
                    }
                    x = b;
                    y = c;
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
                    return 0;
                }
            }
            final Point2D targetIntersection = this.getTargetIntersection();
            final double n5 = dcmpg(Line2D.ptSegDistSq(x, y, targetIntersection.getX(), targetIntersection.getY(), n, n2), 25.0);
            continue;
        }
    }
    
    Rectangle2D.Float b(Rectangle2D.Float b) {
        final boolean z = fj.z;
        if (this.getEdge().e() && this.bendCount() < 2) {
            b = super.b(b);
            if (this.bendCount() == 1) {
                final x a = this.bends.a();
                b.add(a.b(), a.c());
            }
            return b;
        }
        final Point2D targetIntersection = this.getTargetIntersection();
        Label_0107: {
            if (b != null) {
                b.setFrame(targetIntersection.getX(), targetIntersection.getY(), 1.0, 1.0);
                if (!z) {
                    break Label_0107;
                }
            }
            b = new Rectangle2D.Float((float)targetIntersection.getX(), (float)targetIntersection.getY(), 1.0f, 1.0f);
        }
        p p = this.bends.k();
        while (p != null) {
            final x x = (x)p.c();
            b.add(x.b(), x.c());
            p = p.a();
            if (z) {
                break;
            }
        }
        final fL sourcePort = this.getSourcePort();
        final fL targetPort = this.getTargetPort();
        sourcePort.a(b, this.getSourceRealizer());
        targetPort.a(b, this.getTargetRealizer());
        double n = b.getX();
        double max = n + b.getWidth();
        double n2 = b.getY();
        double max2 = n2 + b.getHeight();
        int i = this.labelCount() - 1;
        while (i >= 0) {
            final aA label = this.getLabel(i);
            if (z) {
                return b;
            }
            if (label.isVisible() && (label.getText().length() != 0 || label.getIcon() != null)) {
                final y box = label.getBox();
                max = Math.max(box.c + box.a, max);
                n = Math.min(box.c, n);
                max2 = Math.max(box.d + box.b, max2);
                n2 = Math.min(box.d, n2);
            }
            --i;
            if (z) {
                break;
            }
        }
        b.setFrame(n, n2, max - n, max2 - n2);
        return b;
    }
    
    public boolean pathIntersects(final Rectangle2D rectangle2D, final boolean b) {
        final boolean z = fj.z;
        if (!this.isDirty() && this.nb != null && !this.nb.intersects(rectangle2D)) {
            return false;
        }
        if (this.bends.size() > 0) {
            p p2 = this.bends.k();
            while (p2 != null) {
                final x x = (x)p2.c();
                if (rectangle2D.contains(x.b(), x.c())) {
                    return true;
                }
                p2 = p2.a();
                if (z) {
                    break;
                }
            }
        }
        final Point2D targetIntersection = this.getTargetIntersection();
        if (rectangle2D.contains(targetIntersection)) {
            return true;
        }
        final Point2D sourceIntersection = this.getSourceIntersection();
        if (rectangle2D.contains(sourceIntersection)) {
            return true;
        }
        if (b) {
            int i = this.labelCount() - 1;
            while (i >= 0) {
                final aA label = this.getLabel(i);
                if (label.isVisible() && (label.getText().length() != 0 || label.getIcon() != null)) {
                    final y box = label.getBox();
                    if (rectangle2D.intersects(box.c, box.d, box.a, box.b)) {
                        return true;
                    }
                }
                --i;
                if (z) {
                    break;
                }
            }
        }
        double n = sourceIntersection.getX();
        double n2 = sourceIntersection.getY();
        boolean intersectsLine = false;
        if (this.bends.size() > 0) {
            p p3 = this.bends.k();
            while (p3 != null) {
                final x x2 = (x)p3.c();
                intersectsLine = rectangle2D.intersectsLine(n, n2, x2.b(), x2.c());
                if (z) {
                    return intersectsLine;
                }
                if (intersectsLine) {
                    return true;
                }
                n = x2.b();
                n2 = x2.c();
                p3 = p3.a();
                if (z) {
                    break;
                }
            }
        }
        rectangle2D.intersectsLine(n, n2, targetIntersection.getX(), targetIntersection.getY());
        return intersectsLine;
    }
    
    protected byte calculatePath(final Point2D point2D, final Point2D point2D2) {
        boolean b = false;
        Label_0076: {
            if (this.getEdge().e()) {
                if (this.bendCount() == 0) {
                    final fj sourceRealizer = this.getSourceRealizer();
                    this.appendBend(this.getSourcePort().a(sourceRealizer), this.getSourcePort().b(sourceRealizer) - 10.0 - sourceRealizer.getHeight());
                    b = true;
                    if (!fj.z) {
                        break Label_0076;
                    }
                }
                if (this.bendCount() == 1) {
                    b = true;
                }
            }
        }
        if (b) {
            return ij.b(this, this.path, point2D, point2D2);
        }
        if (this.ic) {
            return ij.c(this, this.path, point2D, point2D2);
        }
        return ij.a(this, this.path, point2D, point2D2);
    }
    
    public void registerObstacles(final C c) {
        c.b(this.getPath().getPathIterator(null));
    }
    
    public void write(final ObjectOutputStream objectOutputStream) {
        objectOutputStream.writeByte(1);
        super.write(objectOutputStream);
        objectOutputStream.writeBoolean(this.ic);
    }
    
    public void read(final ObjectInputStream objectInputStream) {
        final boolean z = fj.z;
        Label_0050: {
            switch (objectInputStream.readByte()) {
                case 0: {
                    super.read(objectInputStream);
                    this.ic = false;
                    if (z) {
                        break Label_0050;
                    }
                    return;
                }
                case 1: {
                    super.read(objectInputStream);
                    this.ic = objectInputStream.readBoolean();
                    if (z) {
                        break;
                    }
                    return;
                }
            }
        }
        throw new a();
    }
}
