package y.h;

import javax.swing.*;
import java.awt.geom.*;
import java.awt.*;
import java.io.*;
import y.e.*;

public class dg extends fL
{
    Icon a;
    float b;
    float c;
    
    public dg() {
        this.a = null;
    }
    
    public dg(final fL fl) {
        super(fl);
        this.a = null;
        if (fl instanceof dg) {
            this.a = ((dg)fl).a;
        }
    }
    
    public fL a() {
        return new dg(this);
    }
    
    public void a(final Rectangle2D rectangle2D, final fj fj) {
        final double b = this.b();
        final double c = this.c();
        final double n = this.a(fj) - b / 2.0;
        final double n2 = this.b(fj) - c / 2.0;
        rectangle2D.add(n, n2);
        rectangle2D.add(n + b, n2 + c);
        rectangle2D.add(n, n2 + c);
        rectangle2D.add(n + b, n2);
    }
    
    public boolean a(final fj fj, final double n, final double n2, final double n3, final double n4, final Point2D point2D) {
        if (fj.findIntersection(n, n2, n3, n4, point2D)) {
            final double max = Math.max(this.b(), this.c());
            final double n5 = n3 - point2D.getX();
            final double n6 = n4 - point2D.getY();
            final double n7 = n5 * n5 + n6 * n6;
            if (n7 > 0.0) {
                final double sqrt = Math.sqrt(n7);
                final double n8 = n5 * max / sqrt;
                final double n9 = n6 * max / sqrt;
                point2D.setLocation(point2D.getX() + n8, point2D.getY() + n9);
                this.b = (float)(n8 / 2.0);
                this.c = (float)(n9 / 2.0);
            }
            return true;
        }
        return false;
    }
    
    public void a(final Graphics2D graphics2D, final fj fj) {
        final boolean z = fj.z;
        if (this.a != null) {
            Point2D point2D = null;
            Label_0044: {
                if (this.f.getSourcePort() == this) {
                    point2D = this.f.getSourceIntersection();
                    if (!z) {
                        break Label_0044;
                    }
                }
                point2D = this.f.getTargetIntersection();
            }
            this.a.paintIcon(null, graphics2D, (int)(point2D.getX() - this.b() / 2.0 - this.b), (int)(point2D.getY() - this.c() / 2.0 - this.c));
            if (!this.f.isSelected()) {
                return;
            }
            super.a(graphics2D, fj);
            if (!z) {
                return;
            }
        }
        super.a(graphics2D, fj);
    }
    
    double b() {
        if (this.a != null) {
            return this.a.getIconWidth();
        }
        return 1.0;
    }
    
    double c() {
        if (this.a != null) {
            return this.a.getIconHeight();
        }
        return 1.0;
    }
    
    public boolean a(final double n, final double n2) {
        final boolean z = fj.z;
        Point2D point2D = null;
        Label_0039: {
            if (this.f.getSourcePort() == this) {
                point2D = this.f.getSourceIntersection();
                if (!z) {
                    break Label_0039;
                }
            }
            point2D = this.f.getTargetIntersection();
        }
        final double n3 = point2D.getX() - this.b;
        final double n4 = point2D.getY() - this.c;
        if (n3 - this.b() / 2.0 <= n && n3 + this.b() / 2.0 >= n && n4 - this.c() / 2.0 <= n2 && n4 + this.c() / 2.0 >= n2) {
            return true;
        }
        if (this.f.isSelected()) {
            fj fj = null;
            Label_0175: {
                if (this.f.getSourcePort() == this) {
                    fj = this.f.getSourceRealizer();
                    if (!z) {
                        break Label_0175;
                    }
                }
                fj = this.f.getTargetRealizer();
            }
            final double a = this.a(fj);
            final double b = this.b(fj);
            return a - this.b() / 2.0 <= n && a + this.b() / 2.0 >= n && b - this.c() / 2.0 <= n2 && b + this.c() / 2.0 >= n2;
        }
        return false;
    }
    
    public void a(final ObjectOutputStream objectOutputStream) {
        objectOutputStream.writeByte(0);
        super.a(objectOutputStream);
        if (this.a != null && this.a instanceof Serializable) {
            objectOutputStream.writeBoolean(true);
            objectOutputStream.writeObject(this.a);
            if (!fj.z) {
                return;
            }
        }
        objectOutputStream.writeBoolean(false);
    }
    
    public void a(final ObjectInputStream objectInputStream) {
        switch (objectInputStream.readByte()) {
            case 0: {
                super.a(objectInputStream);
                if (objectInputStream.readBoolean()) {
                    this.a = (Icon)objectInputStream.readObject();
                    if (fj.z) {
                        break;
                    }
                }
                return;
            }
        }
        throw new a();
    }
    
    public String toString() {
        return "InterfacePort: (" + this.g() + ',' + this.h() + ')';
    }
}
