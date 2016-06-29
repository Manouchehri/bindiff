package y.h;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.Shape;
import java.awt.Stroke;
import java.awt.geom.AffineTransform;
import java.awt.geom.GeneralPath;
import java.awt.geom.Ellipse2D.Double;
import java.util.Hashtable;
import y.h.az;
import y.h.dr;
import y.h.fj;
import y.h.i;
import y.h.j;
import y.h.k;
import y.h.l;
import y.h.m;
import y.h.n;
import y.h.o;
import y.h.p;
import y.h.q;

public final class h {
   private static final Hashtable w = new Hashtable(32);
   private static final h[] x = new h[23];
   private static double y = 0.0D;
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

   private h(Shape var1, Color var2, Stroke var3, Color var4, double var5, double var7) {
      this.G = dr.a;
      this.a(var1, var2, var3, var4, var5, var7);
   }

   private h(Shape var1, Color var2, double var3, double var5) {
      this.G = dr.a;
      this.a(var1, var2, dr.a, (Color)null, var3, var5);
   }

   private h(az var1, double var2, double var4) {
      this.G = dr.a;
      this.B = 0;
      this.H = var1;
      this.D = var2;
      this.E = var4;
   }

   private void a(Shape var1, Color var2, Stroke var3, Color var4, double var5, double var7) {
      if(var1 == null) {
         var1 = a((byte)1).A;
      } else {
         this.A = var1;
      }

      this.E = var7;
      this.D = var5;
      this.z = var2;
      this.G = var3;
      this.F = var4;
      this.B = 0;
   }

   public static h a(String var0) {
      return !w.containsKey(var0)?null:(h)w.get(var0);
   }

   public static h a(byte var0) {
      return x[var0];
   }

   public byte a() {
      return this.B;
   }

   public String b() {
      return this.C;
   }

   public void a(Graphics2D var1, AffineTransform var2) {
      if(this.H == null) {
         if(this == a) {
            return;
         }

         Shape var3;
         if(this.z != null) {
            var3 = var2.createTransformedShape(this.A);
            Color var4 = var1.getColor();
            Stroke var5 = var1.getStroke();
            var1.setColor(this.z);
            var1.fill(var3);
            var1.setStroke(this.G);
            var1.setColor(this.F != null?this.F:var4);
            var1.draw(var3);
            var1.setColor(var4);
            var1.setStroke(var5);
            if(!fj.z) {
               return;
            }
         }

         try {
            var3 = var2.createTransformedShape(this.A);
            var1.fill(var3);
         } finally {
            ;
         }
      } else {
         AffineTransform var9 = var1.getTransform();
         var1.transform(var2);
         this.H.a(var1);
         var1.setTransform(var9);
      }

   }

   public double c() {
      return this.D;
   }

   public double d() {
      return this.E;
   }

   static {
      GeneralPath var0 = new GeneralPath(1, 6);
      var0.moveTo(0.0F, 0.0F);
      var0.lineTo(-12.0F, -5.0F);
      var0.lineTo(-9.0F, 0.0F);
      var0.lineTo(-12.0F, 5.0F);
      var0.closePath();
      b = new h(var0, (Color)null, 8.0D, 0.0D);
      var0 = new GeneralPath(1, 6);
      var0.moveTo(0.0F, 0.0F);
      var0.lineTo(-12.0F, -6.0F);
      var0.lineTo(-12.0F, 6.0F);
      var0.closePath();
      c = new h(var0, (Color)null, 11.0D, 0.0D);
      var0 = new GeneralPath(1, 6);
      var0.moveTo(0.0F, 0.0F);
      var0.lineTo(-16.0F, -6.0F);
      var0.lineTo(-16.0F, 6.0F);
      var0.closePath();
      d = new h(var0, Color.white, 15.0D, 0.0D);
      var0 = new GeneralPath(1, 6);
      var0.moveTo(0.0F, 0.0F);
      var0.lineTo(-7.0F, 5.0F);
      var0.lineTo(-14.0F, 0.0F);
      var0.lineTo(-7.0F, -5.0F);
      var0.closePath();
      e = new h(var0, (Color)null, 7.0D, 0.0D);
      g = new h(var0, Color.white, 7.0D, 0.0D);
      var0 = new GeneralPath(1, 6);
      var0.moveTo(0.0F, 0.0F);
      var0.lineTo(-8.0F, -6.0F);
      var0.lineTo(-5.0F, 0.0F);
      var0.lineTo(-8.0F, 6.0F);
      var0.closePath();
      f = new h(var0, (Color)null, 4.0D, 0.0D);
      var0 = new GeneralPath(1, 6);
      var0.moveTo(0.0F, 0.0F);
      var0.closePath();
      a = new h(var0, (Color)null, 0.0D, 0.0D);
      BasicStroke var1 = new BasicStroke();
      var0 = new GeneralPath(1, 6);
      var0.moveTo(-1.0F, 0.0F);
      var0.lineTo(-13.0F, -6.0F);
      var0.lineTo(-1.0F, 0.0F);
      var0.lineTo(-13.0F, 6.0F);
      var0.closePath();
      h = new h(var0, Color.black, var1, (Color)null, 5.0D, 0.0D);
      i var2 = new i();
      i = new h(var2, 5.5D, 1.0D);
      j var3 = new j();
      j = new h(var3, 3.0D, 0.0D);
      Color var4 = new Color(0, 0, 0, 0);
      Double var5 = new Double(-4.0D, -4.0D, 8.0D, 8.0D);
      k = new h(var5, (Color)null, 4.0D, 0.0D);
      l = new h(var5, var4, 4.0D, 0.0D);
      var0 = new GeneralPath(1, 6);
      var0.moveTo(-8.0F, -4.0F);
      var0.lineTo(-8.0F, 4.0F);
      var0.closePath();
      m = new h(var0, Color.black, var1, (Color)null, 0.0D, 0.0D);
      var0 = new GeneralPath(1, 6);
      var0.moveTo(-12.0F, -4.0F);
      var0.lineTo(-4.0F, 4.0F);
      var0.closePath();
      n = new h(var0, Color.black, var1, (Color)null, 0.0D, 0.0D);
      var0 = new GeneralPath(1, 6);
      var0.moveTo(-2.0F, -5.0F);
      var0.lineTo(-2.0F, 5.0F);
      var0.closePath();
      o = new h(var0, Color.black, var1, (Color)null, 2.0D, 0.0D);
      k var8 = new k();
      p = new h(var8, 0.0D, 0.0D);
      l var9 = new l();
      q = new h(var9, 9.0D, 0.0D);
      m var10 = new m();
      r = new h(var10, 0.0D, 0.0D);
      n var11 = new n();
      s = new h(var11, 9.0D, 0.0D);
      t = new h(new o(), 0.0D, 0.0D);
      u = new h(new p(), 9.0D, 0.0D);
      v = new h(new q(), 0.0D, 0.0D);
      w.put("Arrow.STANDARD", b);
      w.put("Arrow.DELTA", c);
      w.put("Arrow.WHITE_DELTA", d);
      w.put("Arrow.DIAMOND", e);
      w.put("Arrow.WHITE_DIAMOND", g);
      w.put("Arrow.SHORT", f);
      w.put("Arrow.NONE", a);
      w.put("Arrow.PLAIN", h);
      w.put("Arrow.CONCAVE", i);
      w.put("Arrow.CONVEX", j);
      w.put("Arrow.CIRCLE", k);
      w.put("Arrow.TRANSPARENT_CIRCLE", l);
      w.put("Arrow.DASH", m);
      w.put("Arrow.SKEWED_DASH", n);
      w.put("Arrow.T_SHAPE", o);
      w.put("Arrow.CROWS_FOOT_ONE_OPTIONAL", r);
      w.put("Arrow.CROWS_FOOT_ONE_MANDATORY", p);
      w.put("Arrow.CROWS_FOOT_MANY_OPTIONAL", s);
      w.put("Arrow.CROWS_FOOT_ONE_OPTIONAL", r);
      w.put("Arrow.CROWS_FOOT_ONE", t);
      w.put("Arrow.CROWS_FOOT_MANY", u);
      w.put("Arrow.CROWS_FOOT_OPTIONAL", v);
      x[1] = a;
      x[2] = b;
      x[3] = c;
      x[4] = d;
      x[5] = e;
      x[6] = g;
      x[7] = f;
      x[8] = h;
      x[9] = i;
      x[10] = j;
      x[11] = k;
      x[12] = l;
      x[13] = m;
      x[14] = n;
      x[15] = o;
      x[16] = p;
      x[17] = q;
      x[18] = r;
      x[19] = s;
      x[20] = t;
      x[21] = u;
      x[22] = v;
      a.B = 1;
      b.B = 2;
      c.B = 3;
      d.B = 4;
      e.B = 5;
      g.B = 6;
      f.B = 7;
      h.B = 8;
      i.B = 9;
      j.B = 10;
      k.B = 11;
      l.B = 12;
      m.B = 13;
      n.B = 14;
      o.B = 15;
      p.B = 16;
      q.B = 17;
      r.B = 18;
      s.B = 19;
      t.B = 20;
      u.B = 21;
      v.B = 22;
   }
}
