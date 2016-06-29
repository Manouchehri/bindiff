package y.h;

import y.h.a.*;
import java.awt.geom.*;
import java.awt.*;
import y.c.*;
import java.io.*;
import y.e.*;

public class bV extends gn
{
    private bu a;
    private boolean b;
    private boolean c;
    private boolean d;
    
    public bV() {
        this.h();
    }
    
    public bV(final fj fj) {
        super(fj);
        if (fj instanceof bV) {
            final bV bv = (bV)fj;
            this.a = bv.a;
            this.b = bv.b;
            this.c = bv.c;
            this.d = bv.d;
            if (!fj.z) {
                return;
            }
        }
        this.h();
    }
    
    private void h() {
        this.b = true;
        this.c = false;
        this.d = true;
    }
    
    public boolean a() {
        return this.d;
    }
    
    public boolean e() {
        return this.c;
    }
    
    public boolean f() {
        return this.b;
    }
    
    public bu g() {
        if (this.a != null) {
            return this.a;
        }
        try {
            return (bu)y.h.a.v.a(this.getNode().e()).m(this.getNode());
        }
        catch (Exception ex) {
            return null;
        }
    }
    
    protected void paintNode(final Graphics2D graphics2D) {
        super.paintNode(graphics2D);
        if (this.f()) {
            this.a(graphics2D);
        }
    }
    
    public void paintSloppy(final Graphics2D graphics2D) {
        if (this.b()) {
            return;
        }
        super.paintSloppy(graphics2D);
        if (this.f()) {
            final Double n = (Double)graphics2D.getRenderingHint(hk.y);
            if (n != null && n < Double.MAX_VALUE) {
                this.a(graphics2D);
            }
        }
    }
    
    protected void a(final Graphics2D graphics2D) {
        final boolean z = fj.z;
        final bu g = this.g();
        if (g == null) {
            return;
        }
        final double n = 10.0;
        double n2 = this.getHeight() - n * 2.0;
        double n3 = this.getWidth() - n * 2.0;
        double centerX = this.getCenterX();
        double centerY = this.getCenterY();
        final eR label = this.getLabel();
        Label_0243: {
            switch (label.getModel()) {
                case 1: {
                    Label_0219: {
                        switch (label.getPosition()) {
                            case 102: {
                                n2 -= label.getHeight();
                                centerY += label.getHeight() / 2.0;
                                if (z) {
                                    break Label_0219;
                                }
                                break Label_0243;
                            }
                            case 101: {
                                n2 -= label.getHeight();
                                centerY -= label.getHeight() / 2.0;
                                if (z) {
                                    break Label_0219;
                                }
                                break Label_0243;
                            }
                            case 115: {
                                n3 -= label.getWidth();
                                centerX += label.getWidth() / 2.0;
                                if (z) {
                                    break Label_0219;
                                }
                                break Label_0243;
                            }
                            case 116: {
                                n3 -= label.getWidth();
                                centerX -= label.getWidth() / 2.0;
                                break Label_0243;
                            }
                        }
                    }
                    break;
                }
            }
        }
        if (n3 <= 5.0 || n2 <= 5.0) {
            return;
        }
        Shape clip = null;
        double min = 1.0;
        final AffineTransform transform = graphics2D.getTransform();
        if (this.e()) {
            clip = graphics2D.getClip();
            graphics2D.clip(new Rectangle2D.Double(this.getX(), this.getY(), n3, n2));
        }
        graphics2D.translate(centerX, centerY);
        if (this.a()) {
            final Rectangle a = g.a();
            min = Math.min(n3 / a.getWidth(), n2 / a.getHeight());
            graphics2D.scale(min, min);
            graphics2D.translate(-a.getCenterX(), -a.getCenterY());
        }
        final double n4 = min * transform.getScaleX();
        final Double n5 = (Double)graphics2D.getRenderingHint(hk.y);
        Label_0656: {
            Label_0532: {
                if (n5 == null || n4 > n5) {
                    final x o = g.o();
                    while (o.f()) {
                        g.t(o.e()).paint(graphics2D);
                        o.g();
                        if (z) {
                            break Label_0656;
                        }
                        if (z) {
                            break;
                        }
                    }
                    final e p = g.p();
                    while (p.f()) {
                        g.i(p.a()).paint(graphics2D);
                        p.g();
                        if (z) {
                            return;
                        }
                        if (z) {
                            break Label_0532;
                        }
                    }
                    break Label_0656;
                }
            }
            if (n5 == null || 4.0 * n4 > n5) {
                final x o2 = g.o();
                while (o2.f()) {
                    g.t(o2.e()).paintSloppy(graphics2D);
                    o2.g();
                    if (z) {
                        break Label_0656;
                    }
                    if (z) {
                        break;
                    }
                }
                final e p2 = g.p();
                while (p2.f()) {
                    g.i(p2.a()).paintSloppy(graphics2D);
                    p2.g();
                    if (z) {
                        return;
                    }
                    if (z) {
                        break;
                    }
                }
            }
        }
        if (this.e()) {
            graphics2D.setClip(clip);
        }
        graphics2D.setTransform(transform);
    }
    
    public fj createCopy(final fj fj) {
        return new bV(fj);
    }
    
    public void write(final ObjectOutputStream objectOutputStream) {
        objectOutputStream.writeByte(0);
        super.write(objectOutputStream);
        objectOutputStream.writeBoolean(this.b);
        objectOutputStream.writeBoolean(this.c);
        objectOutputStream.writeBoolean(this.d);
    }
    
    public void read(final ObjectInputStream objectInputStream) {
        switch (objectInputStream.readByte()) {
            case 0: {
                super.read(objectInputStream);
                this.b = objectInputStream.readBoolean();
                this.c = objectInputStream.readBoolean();
                this.d = objectInputStream.readBoolean();
                if (fj.z) {
                    break;
                }
                return;
            }
        }
        throw new a();
    }
}
