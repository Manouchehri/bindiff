package y.h;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.Rectangle;
import java.awt.Stroke;
import java.awt.geom.Line2D.Double;
import y.h.aA;
import y.h.aB;
import y.h.az;
import y.h.dB;
import y.h.dC;
import y.h.eR;
import y.h.fj;
import y.h.hC;

class dG implements az {
   private final BasicStroke a;
   private final BasicStroke b;
   private boolean c;
   private boolean d;
   private Rectangle e;
   private y.f.Q f;
   private boolean g;
   private Object h;
   private final dB i;

   private dG(dB var1) {
      this.i = var1;
      this.b = new BasicStroke(3.0F, 2, 0);
      this.a = new BasicStroke(1.0F, 2, 0);
      this.c = true;
      this.d = false;
      this.d();
   }

   public Rectangle getBounds() {
      return this.a()?(this.i.e instanceof eR?this.a(this.a(dB.a(this.i))):(this.i.e instanceof aA?this.a(this.a(dB.b(this.i))):new Rectangle(0, 0, -1, -1))):this.e;
   }

   private Rectangle a(y.d.n var1) {
      y.d.y var2 = var1.h();
      return new Rectangle((int)Math.floor(var2.c()), (int)Math.floor(var2.d()), (int)Math.ceil(var2.a()), (int)Math.ceil(var2.b()));
   }

   public void a(Graphics2D var1) {
      if(this.a()) {
         this.c(var1);
         if(!fj.z) {
            return;
         }
      }

      this.b(var1);
   }

   private void b(Graphics2D var1) {
      y.f.Q var10000;
      Stroke var2;
      Color var3;
      label29: {
         boolean var6 = fj.z;
         var2 = var1.getStroke();
         var3 = var1.getColor();
         var1.setColor(dB.h());
         if(dB.c(this.i) != null) {
            y.c.C var4 = dB.c(this.i).m();

            while(var4.f()) {
               y.f.Q var5 = (y.f.Q)var4.d();
               var10000 = var5;
               if(var6) {
                  break label29;
               }

               if(!var5.equals(this.f)) {
                  this.a(var1, var5, this.a);
               }

               var4.g();
               if(var6) {
                  break;
               }
            }
         }

         var10000 = this.f;
      }

      if(var10000 != null) {
         this.a(var1, this.f, this.b);
      }

      var1.setStroke(var2);
      var1.setColor(var3);
   }

   private void a(Graphics2D var1, y.f.Q var2, Stroke var3) {
      boolean var8 = fj.z;
      if(var2 != null) {
         Double var4;
         y.d.t[] var5;
         label51: {
            var1.setStroke(var3);
            var4 = hC.a().l;
            if(this.i.e instanceof eR && this.b() || this.i.e instanceof aA && this.c()) {
               y.d.n var6 = new y.d.n(var2.h());
               var5 = y.d.n.a(var6);
               if(!var8) {
                  break label51;
               }
            }

            var5 = y.d.n.a(var2.d());
         }

         int var9 = 0;

         while(var9 < var5.length) {
            int var7 = var9 == 0?var5.length - 1:var9 - 1;
            var4.setLine(var5[var9].a(), var5[var9].b(), var5[var7].a(), var5[var7].b());
            var1.draw(var4);
            ++var9;
            if(var8) {
               break;
            }
         }

      }
   }

   private void c(Graphics2D var1) {
      y.d.n var2;
      if(this.i.e instanceof aA) {
         var2 = this.a(dB.b(this.i));
         this.a(var1, var2);
         if(!fj.z) {
            return;
         }
      }

      if(this.i.e instanceof eR) {
         var2 = this.a(dB.a(this.i));
         this.a(var1, var2);
      }

   }

   private y.d.n a(aA var1) {
      aB var2 = var1.getRealizer();
      return dB.d(this.i).a(var1.getOrientedBox().d(), var2, var2.getSourceRealizer(), var2.getTargetRealizer(), this.h);
   }

   private y.d.n a(eR var1) {
      return dB.e(this.i).a(var1.getOrientedBox().d(), var1.g(), this.h);
   }

   private void a(Graphics2D var1, y.d.n var2) {
      Color var3;
      Stroke var4;
      Double var5;
      y.d.t[] var6;
      boolean var9;
      label46: {
         var9 = fj.z;
         var3 = var1.getColor();
         var4 = var1.getStroke();
         var1.setColor(dB.h());
         var1.setStroke(new BasicStroke(3.0F, 2, 0));
         var5 = hC.a().l;
         if(this.i.e instanceof eR && this.b() || this.i.e instanceof aA && this.c()) {
            y.d.n var7 = new y.d.n(var2.h());
            var6 = y.d.n.a(var7);
            if(!var9) {
               break label46;
            }
         }

         var6 = y.d.n.a(var2);
      }

      int var10 = 0;

      while(var10 < var6.length) {
         int var8 = var10 == 0?var6.length - 1:var10 - 1;
         var5.setLine(var6[var10].a(), var6[var10].b(), var6[var8].a(), var6[var8].b());
         var1.draw(var5);
         ++var10;
         if(var9) {
            break;
         }
      }

      var1.setColor(var3);
      var1.setStroke(var4);
   }

   private void a(Object var1) {
      this.h = var1;
   }

   private void a(y.f.Q var1) {
      this.f = var1;
   }

   private void d() {
      boolean var11 = fj.z;
      if(dB.c(this.i) == null || dB.c(this.i).isEmpty()) {
         this.e = null;
         if(!var11) {
            return;
         }
      }

      double var1 = java.lang.Double.MAX_VALUE;
      double var3 = java.lang.Double.MAX_VALUE;
      double var5 = -1.7976931348623157E308D;
      double var7 = -1.7976931348623157E308D;
      y.c.C var9 = dB.c(this.i).m();

      while(var9.f()) {
         y.d.y var10 = ((y.f.Q)var9.d()).h();
         var1 = Math.min(var1, var10.c());
         var3 = Math.min(var3, var10.d());
         var5 = Math.max(var5, var10.c() + var10.a());
         var7 = Math.max(var7, var10.d() + var10.b());
         var9.g();
         if(var11) {
            return;
         }

         if(var11) {
            break;
         }
      }

      double var12 = (double)this.b.getLineWidth();
      this.e = new Rectangle((int)Math.floor(var1 - var12), (int)Math.floor(var3 - var12), (int)Math.ceil(var5 - var1 + 2.0D * var12), (int)Math.ceil(var7 - var3 + 2.0D * var12));
   }

   public boolean a() {
      return this.g;
   }

   public void a(boolean var1) {
      this.g = var1;
   }

   public boolean b() {
      return this.c;
   }

   public boolean c() {
      return this.d;
   }

   dG(dB var1, dC var2) {
      this(var1);
   }

   static void a(dG var0, y.f.Q var1) {
      var0.a(var1);
   }

   static void a(dG var0, Object var1) {
      var0.a(var1);
   }
}
