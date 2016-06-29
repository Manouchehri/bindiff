package y.e;

import y.h.*;
import java.awt.geom.*;
import java.awt.*;

public class g
{
    public static byte a;
    public static byte b;
    public static byte c;
    public static byte d;
    public static byte e;
    private byte f;
    private byte g;
    private int h;
    private int i;
    private int j;
    private bu k;
    private ch l;
    private double m;
    
    public g() {
        this.f = y.e.g.a;
        this.g = y.e.g.c;
        this.h = 500;
        this.i = 500;
        this.j = 15;
        this.m = 1.0;
    }
    
    public void a(final ch ch) {
        final int a = y.e.c.a;
        double n = this.d();
        double n2 = this.e();
        Point point = ch.getViewPoint();
        double n3 = 1.0;
        Label_0336: {
            if (this.b() == y.e.g.a) {
                final Rectangle2D bounds2D = this.f().a().getBounds2D();
                final double n4 = this.a() / this.m;
                bounds2D.setFrame(bounds2D.getX() - n4, bounds2D.getY() - n4, bounds2D.getWidth() + 2.0 * n4, bounds2D.getHeight() + 2.0 * n4);
                Label_0183: {
                    if (this.c() == y.e.g.e) {
                        n = n2 * bounds2D.getWidth() / bounds2D.getHeight();
                        if (a == 0) {
                            break Label_0183;
                        }
                    }
                    if (this.c() == y.e.g.d) {
                        n2 = n * bounds2D.getHeight() / bounds2D.getWidth();
                        if (a == 0) {
                            break Label_0183;
                        }
                    }
                    n = bounds2D.getWidth();
                    n2 = bounds2D.getHeight();
                }
                n3 = n / bounds2D.getWidth();
                point = new Point((int)bounds2D.getX(), (int)bounds2D.getY());
                if (a == 0) {
                    break Label_0336;
                }
            }
            if (this.b() == y.e.g.b) {
                final ch g = this.g();
                final Dimension canvasSize = g.getCanvasSize();
                Label_0314: {
                    if (this.c() == y.e.g.e) {
                        n = n2 * canvasSize.getWidth() / canvasSize.getHeight();
                        if (a == 0) {
                            break Label_0314;
                        }
                    }
                    if (this.c() == y.e.g.d) {
                        n2 = n * canvasSize.getHeight() / canvasSize.getWidth();
                        if (a == 0) {
                            break Label_0314;
                        }
                    }
                    n = canvasSize.getWidth();
                    n2 = canvasSize.getHeight();
                }
                point = g.getViewPoint();
                n3 = g.getZoom() * n / canvasSize.getWidth();
            }
        }
        final double n5 = n * this.m;
        final double n6 = n2 * this.m;
        ch.setZoom(n3 * this.m);
        ch.setSize((int)n5, (int)n6);
        ch.setViewPoint(point.x, point.y);
    }
    
    public int a() {
        return this.j;
    }
    
    public void a(final byte f) {
        this.f = f;
    }
    
    public byte b() {
        return this.f;
    }
    
    public void b(final byte g) {
        this.g = g;
    }
    
    public byte c() {
        return this.g;
    }
    
    public int d() {
        return this.h;
    }
    
    public int e() {
        return this.i;
    }
    
    public void a(final bu k) {
        this.k = k;
    }
    
    public bu f() {
        return this.k;
    }
    
    public ch g() {
        return this.l;
    }
    
    static {
        g.a = 0;
        g.b = 1;
        g.c = 0;
        g.d = 1;
        g.e = 2;
    }
}
