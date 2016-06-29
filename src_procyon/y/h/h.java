package y.h;

import java.util.*;
import java.awt.*;
import java.awt.geom.*;

public final class h
{
    private static final Hashtable w;
    private static final h[] x;
    private static double y;
    public static final h a;
    public static final h b;
    public static final h c;
    public static final h d;
    public static final h e;
    public static final h f;
    public static final h g;
    public static final h h;
    public static final h i;
    public static final h j;
    public static final h k;
    public static final h l;
    public static final h m;
    public static final h n;
    public static final h o;
    public static final h p;
    public static final h q;
    public static final h r;
    public static final h s;
    public static final h t;
    public static final h u;
    public static final h v;
    private Color z;
    private Shape A;
    private byte B;
    private String C;
    private double D;
    private double E;
    private Color F;
    private Stroke G;
    private az H;
    
    private h(final Shape shape, final Color color, final Stroke stroke, final Color color2, final double n, final double n2) {
        this.G = dr.a;
        this.a(shape, color, stroke, color2, n, n2);
    }
    
    private h(final Shape shape, final Color color, final double n, final double n2) {
        this.G = dr.a;
        this.a(shape, color, dr.a, null, n, n2);
    }
    
    private h(final az h, final double d, final double e) {
        this.G = dr.a;
        this.B = 0;
        this.H = h;
        this.D = d;
        this.E = e;
    }
    
    private void a(Shape a, final Color z, final Stroke g, final Color f, final double d, final double e) {
        if (a == null) {
            a = a((byte)1).A;
        }
        else {
            this.A = a;
        }
        this.E = e;
        this.D = d;
        this.z = z;
        this.G = g;
        this.F = f;
        this.B = 0;
    }
    
    public static h a(final String s) {
        if (!y.h.h.w.containsKey(s)) {
            return null;
        }
        return y.h.h.w.get(s);
    }
    
    public static h a(final byte b) {
        return y.h.h.x[b];
    }
    
    public byte a() {
        return this.B;
    }
    
    public String b() {
        return this.C;
    }
    
    public void a(final Graphics2D graphics2D, final AffineTransform affineTransform) {
        if (this.H == null) {
            if (this == y.h.h.a) {
                return;
            }
            if (this.z != null) {
                final Shape transformedShape = affineTransform.createTransformedShape(this.A);
                final Color color = graphics2D.getColor();
                final Stroke stroke = graphics2D.getStroke();
                graphics2D.setColor(this.z);
                graphics2D.fill(transformedShape);
                graphics2D.setStroke(this.G);
                graphics2D.setColor((this.F != null) ? this.F : color);
                graphics2D.draw(transformedShape);
                graphics2D.setColor(color);
                graphics2D.setStroke(stroke);
                if (!fj.z) {
                    return;
                }
            }
            try {
                graphics2D.fill(affineTransform.createTransformedShape(this.A));
                return;
            }
            finally {}
        }
        final AffineTransform transform = graphics2D.getTransform();
        graphics2D.transform(affineTransform);
        this.H.a(graphics2D);
        graphics2D.setTransform(transform);
    }
    
    public double c() {
        return this.D;
    }
    
    public double d() {
        return this.E;
    }
    
    static {
        w = new Hashtable(32);
        x = new h[23];
        y.h.h.y = 0.0;
        final GeneralPath generalPath = new GeneralPath(1, 6);
        generalPath.moveTo(0.0f, 0.0f);
        generalPath.lineTo(-12.0f, -5.0f);
        generalPath.lineTo(-9.0f, 0.0f);
        generalPath.lineTo(-12.0f, 5.0f);
        generalPath.closePath();
        b = new h(generalPath, null, 8.0, 0.0);
        final GeneralPath generalPath2 = new GeneralPath(1, 6);
        generalPath2.moveTo(0.0f, 0.0f);
        generalPath2.lineTo(-12.0f, -6.0f);
        generalPath2.lineTo(-12.0f, 6.0f);
        generalPath2.closePath();
        c = new h(generalPath2, null, 11.0, 0.0);
        final GeneralPath generalPath3 = new GeneralPath(1, 6);
        generalPath3.moveTo(0.0f, 0.0f);
        generalPath3.lineTo(-16.0f, -6.0f);
        generalPath3.lineTo(-16.0f, 6.0f);
        generalPath3.closePath();
        d = new h(generalPath3, Color.white, 15.0, 0.0);
        final GeneralPath generalPath4 = new GeneralPath(1, 6);
        generalPath4.moveTo(0.0f, 0.0f);
        generalPath4.lineTo(-7.0f, 5.0f);
        generalPath4.lineTo(-14.0f, 0.0f);
        generalPath4.lineTo(-7.0f, -5.0f);
        generalPath4.closePath();
        e = new h(generalPath4, null, 7.0, 0.0);
        g = new h(generalPath4, Color.white, 7.0, 0.0);
        final GeneralPath generalPath5 = new GeneralPath(1, 6);
        generalPath5.moveTo(0.0f, 0.0f);
        generalPath5.lineTo(-8.0f, -6.0f);
        generalPath5.lineTo(-5.0f, 0.0f);
        generalPath5.lineTo(-8.0f, 6.0f);
        generalPath5.closePath();
        f = new h(generalPath5, null, 4.0, 0.0);
        final GeneralPath generalPath6 = new GeneralPath(1, 6);
        generalPath6.moveTo(0.0f, 0.0f);
        generalPath6.closePath();
        a = new h(generalPath6, null, 0.0, 0.0);
        final BasicStroke basicStroke = new BasicStroke();
        final GeneralPath generalPath7 = new GeneralPath(1, 6);
        generalPath7.moveTo(-1.0f, 0.0f);
        generalPath7.lineTo(-13.0f, -6.0f);
        generalPath7.lineTo(-1.0f, 0.0f);
        generalPath7.lineTo(-13.0f, 6.0f);
        generalPath7.closePath();
        h = new h(generalPath7, Color.black, basicStroke, null, 5.0, 0.0);
        i = new h(new i(), 5.5, 1.0);
        j = new h(new j(), 3.0, 0.0);
        final Color color = new Color(0, 0, 0, 0);
        final Ellipse2D.Double double1 = new Ellipse2D.Double(-4.0, -4.0, 8.0, 8.0);
        k = new h(double1, null, 4.0, 0.0);
        l = new h(double1, color, 4.0, 0.0);
        final GeneralPath generalPath8 = new GeneralPath(1, 6);
        generalPath8.moveTo(-8.0f, -4.0f);
        generalPath8.lineTo(-8.0f, 4.0f);
        generalPath8.closePath();
        m = new h(generalPath8, Color.black, basicStroke, null, 0.0, 0.0);
        final GeneralPath generalPath9 = new GeneralPath(1, 6);
        generalPath9.moveTo(-12.0f, -4.0f);
        generalPath9.lineTo(-4.0f, 4.0f);
        generalPath9.closePath();
        n = new h(generalPath9, Color.black, basicStroke, null, 0.0, 0.0);
        final GeneralPath generalPath10 = new GeneralPath(1, 6);
        generalPath10.moveTo(-2.0f, -5.0f);
        generalPath10.lineTo(-2.0f, 5.0f);
        generalPath10.closePath();
        o = new h(generalPath10, Color.black, basicStroke, null, 2.0, 0.0);
        p = new h(new k(), 0.0, 0.0);
        q = new h(new l(), 9.0, 0.0);
        r = new h(new m(), 0.0, 0.0);
        s = new h(new n(), 9.0, 0.0);
        t = new h(new o(), 0.0, 0.0);
        u = new h(new p(), 9.0, 0.0);
        v = new h(new q(), 0.0, 0.0);
        y.h.h.w.put("Arrow.STANDARD", y.h.h.b);
        y.h.h.w.put("Arrow.DELTA", y.h.h.c);
        y.h.h.w.put("Arrow.WHITE_DELTA", y.h.h.d);
        y.h.h.w.put("Arrow.DIAMOND", y.h.h.e);
        y.h.h.w.put("Arrow.WHITE_DIAMOND", y.h.h.g);
        y.h.h.w.put("Arrow.SHORT", y.h.h.f);
        y.h.h.w.put("Arrow.NONE", y.h.h.a);
        y.h.h.w.put("Arrow.PLAIN", y.h.h.h);
        y.h.h.w.put("Arrow.CONCAVE", y.h.h.i);
        y.h.h.w.put("Arrow.CONVEX", y.h.h.j);
        y.h.h.w.put("Arrow.CIRCLE", y.h.h.k);
        y.h.h.w.put("Arrow.TRANSPARENT_CIRCLE", y.h.h.l);
        y.h.h.w.put("Arrow.DASH", y.h.h.m);
        y.h.h.w.put("Arrow.SKEWED_DASH", y.h.h.n);
        y.h.h.w.put("Arrow.T_SHAPE", y.h.h.o);
        y.h.h.w.put("Arrow.CROWS_FOOT_ONE_OPTIONAL", y.h.h.r);
        y.h.h.w.put("Arrow.CROWS_FOOT_ONE_MANDATORY", y.h.h.p);
        y.h.h.w.put("Arrow.CROWS_FOOT_MANY_OPTIONAL", y.h.h.s);
        y.h.h.w.put("Arrow.CROWS_FOOT_ONE_OPTIONAL", y.h.h.r);
        y.h.h.w.put("Arrow.CROWS_FOOT_ONE", y.h.h.t);
        y.h.h.w.put("Arrow.CROWS_FOOT_MANY", y.h.h.u);
        y.h.h.w.put("Arrow.CROWS_FOOT_OPTIONAL", y.h.h.v);
        y.h.h.x[1] = y.h.h.a;
        y.h.h.x[2] = y.h.h.b;
        y.h.h.x[3] = y.h.h.c;
        y.h.h.x[4] = y.h.h.d;
        y.h.h.x[5] = y.h.h.e;
        y.h.h.x[6] = y.h.h.g;
        y.h.h.x[7] = y.h.h.f;
        y.h.h.x[8] = y.h.h.h;
        y.h.h.x[9] = y.h.h.i;
        y.h.h.x[10] = y.h.h.j;
        y.h.h.x[11] = y.h.h.k;
        y.h.h.x[12] = y.h.h.l;
        y.h.h.x[13] = y.h.h.m;
        y.h.h.x[14] = y.h.h.n;
        y.h.h.x[15] = y.h.h.o;
        y.h.h.x[16] = y.h.h.p;
        y.h.h.x[17] = y.h.h.q;
        y.h.h.x[18] = y.h.h.r;
        y.h.h.x[19] = y.h.h.s;
        y.h.h.x[20] = y.h.h.t;
        y.h.h.x[21] = y.h.h.u;
        y.h.h.x[22] = y.h.h.v;
        y.h.h.a.B = 1;
        y.h.h.b.B = 2;
        y.h.h.c.B = 3;
        y.h.h.d.B = 4;
        y.h.h.e.B = 5;
        y.h.h.g.B = 6;
        y.h.h.f.B = 7;
        y.h.h.h.B = 8;
        y.h.h.i.B = 9;
        y.h.h.j.B = 10;
        y.h.h.k.B = 11;
        y.h.h.l.B = 12;
        y.h.h.m.B = 13;
        y.h.h.n.B = 14;
        y.h.h.o.B = 15;
        y.h.h.p.B = 16;
        y.h.h.q.B = 17;
        y.h.h.r.B = 18;
        y.h.h.s.B = 19;
        y.h.h.t.B = 20;
        y.h.h.u.B = 21;
        y.h.h.v.B = 22;
    }
}
