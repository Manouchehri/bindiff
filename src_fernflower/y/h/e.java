package y.h;

import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.Rectangle;
import java.awt.geom.Point2D.Double;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import y.h.aB;
import y.h.az;
import y.h.bu;
import y.h.ch;
import y.h.f;
import y.h.fj;
import y.h.gy;
import y.h.gz;

public class e {
   private az a;
   private ch b;
   private List c;
   private double d;
   private double e;
   private double f;
   private List g;
   private final List h;
   private boolean i;
   private Color j;
   private y.d.t k;

   public e(ch var1) {
      this.c = Collections.EMPTY_LIST;
      this.d = 5.0D;
      this.g = new ArrayList();
      this.h = new ArrayList();
      this.i = true;
      this.j = Color.LIGHT_GRAY;
      this.k = y.d.t.c;
      this.b = var1;
      this.a = new f(this);
   }

   public Color a() {
      return this.j;
   }

   public void a(boolean var1) {
      this.i = var1;
   }

   public void a(gz var1) {
      this.g.add(var1);
   }

   public void b() {
      this.g.clear();
   }

   protected y.d.t a(List var1, y.d.t var2) {
      boolean var10 = fj.z;
      y.d.t var3 = this.k();
      this.c = var1;
      this.c.addAll(this.g);
      if(this.c.size() <= 0) {
         this.e = var2.a - var3.a;
         this.f = var2.b - var3.b;
         return var2;
      } else {
         y.g.e.a((List)this.c, (Comparator)null);
         Double var4 = new Double(var2.a, var2.b);
         byte var5 = 0;
         int var6 = 0;

         y.d.t var11;
         label51: {
            while(true) {
               if(var6 < this.c.size()) {
                  gz var7 = (gz)this.c.get(var6);
                  var5 = var7.a(var2, var4, var5);
                  ++var6;
                  if(var10) {
                     break;
                  }

                  if(!var10) {
                     continue;
                  }
               }

               if(var5 != 0) {
                  var11 = new y.d.t(var4.x, var4.y);
                  break label51;
               }
               break;
            }

            var11 = var2;
         }

         HashSet var12 = new HashSet();
         int var8 = this.c.size() - 1;

         while(true) {
            if(var8 >= 0) {
               gz var9 = (gz)this.c.get(var8);
               if(var10) {
                  break;
               }

               label34: {
                  if(!var9.a(var2, var11, var5)) {
                     this.c.remove(var8);
                     if(!var10) {
                        break label34;
                     }
                  }

                  if(var9.a() != null && !var12.add(var9.a())) {
                     this.c.remove(var8);
                  }
               }

               --var8;
               if(!var10) {
                  continue;
               }
            }

            this.e = var11.a - var3.a;
            this.f = var11.b - var3.b;
            break;
         }

         return var11;
      }
   }

   public ch c() {
      return this.b;
   }

   public az d() {
      return this.a;
   }

   public void a(ch var1) {
      this.b = var1;
   }

   static void a(Graphics2D var0, double var1, double var3, double var5, double var7) {
      double var9;
      double var11;
      double var13;
      label35: {
         boolean var17 = fj.z;
         var0.draw(new java.awt.geom.Line2D.Double(var1, var3, var5, var7));
         if(var1 == var5) {
            var11 = var3 > var7?-1.0D:1.0D;
            var9 = 0.0D;
            if(!var17) {
               break label35;
            }
         }

         if(var3 == var7) {
            var9 = var1 > var5?-1.0D:1.0D;
            var11 = 0.0D;
            if(!var17) {
               break label35;
            }
         }

         var9 = var5 - var1;
         var11 = var7 - var3;
         var13 = Math.abs(var9 * var9 + var11 * var11);
         if(var13 == 0.0D) {
            var9 = 1.0D;
            var11 = 0.0D;
            if(!var17) {
               break label35;
            }
         }

         var9 /= var13;
         var11 /= var13;
      }

      var9 *= 5.0D;
      var11 *= 5.0D;
      var13 = -var11;
      var0.draw(new java.awt.geom.Line2D.Double(var1 + var13, var3 + var9, var1 - var13, var3 - var9));
      var0.draw(new java.awt.geom.Line2D.Double(var1, var3, var1 + var13 + var9, var3 + var9 + var11));
      var0.draw(new java.awt.geom.Line2D.Double(var1, var3, var1 - var13 + var9, var3 - var9 + var11));
      var0.draw(new java.awt.geom.Line2D.Double(var5 + var13, var7 + var9, var5 - var13, var7 - var9));
      var0.draw(new java.awt.geom.Line2D.Double(var5, var7, var5 + var13 - var9, var7 + var9 - var11));
      var0.draw(new java.awt.geom.Line2D.Double(var5, var7, var5 - var13 - var9, var7 - var9 - var11));
   }

   protected boolean a(fj var1) {
      Rectangle var2 = this.b.getVisibleRect();
      return var2.intersects(var1.getX(), var1.getY(), var1.getWidth(), var1.getHeight());
   }

   protected boolean a(aB var1, y.d.t var2, y.d.t var3) {
      Rectangle var4 = this.b.getVisibleRect();
      return var4.intersectsLine(var2.a, var2.b, var3.a, var3.b);
   }

   protected void a(Collection var1, Collection var2) {
      bu var3;
      HashSet var5;
      y.c.q var7;
      boolean var9;
      label59: {
         var9 = fj.z;
         var3 = this.b.getGraph2D();
         y.h.a.v var4 = var3.C();
         var5 = new HashSet();
         if(var4 != null) {
            Iterator var6 = var1.iterator();

            label56:
            while(true) {
               boolean var10000 = var6.hasNext();

               while(true) {
                  if(!var10000) {
                     break label56;
                  }

                  var7 = (y.c.q)var6.next();
                  if(!var3.f(var7)) {
                     break;
                  }

                  y.c.q var8 = var4.n(var7);

                  while(true) {
                     if(var8 == null) {
                        continue label56;
                     }

                     var10000 = this.a(var8);
                     if(var9) {
                        break label59;
                     }

                     if(var9) {
                        break;
                     }

                     if(!var10000 || !var5.add(var8)) {
                        continue label56;
                     }

                     var8 = var4.n(var8);
                     if(var9) {
                        break label56;
                     }
                  }
               }
            }
         }

         var5.addAll(var1);
      }

      y.c.x var10 = var3.o();

      while(var10.f()) {
         var7 = var10.e();
         if(!var5.contains(var7)) {
            var2.add(var7);
         }

         var10.g();
         if(var9) {
            break;
         }
      }

   }

   private boolean a(y.c.q var1) {
      bu var2 = this.b.getGraph2D();
      if(var2 == null) {
         return true;
      } else {
         fj var3 = var2.t(var1);
         y.h.a.a var4 = var3.getAutoBoundsFeature();
         return var4 != null && var4.isAutoBoundsEnabled();
      }
   }

   public double e() {
      return this.d;
   }

   public void a(double var1) {
      this.d = var1;
   }

   public void f() {
      this.b();
      if(this.b != null) {
         this.b.removeDrawable(this.d());
      }

      this.c = Collections.EMPTY_LIST;
      this.k = y.d.t.c;
   }

   protected void g() {
      this.c().addDrawable(this.d());
   }

   public void h() {
      this.c = Collections.EMPTY_LIST;
   }

   public void i() {
      this.h.clear();
   }

   public void a(gy var1) {
      this.h.add(var1);
   }

   protected List j() {
      return this.h;
   }

   public void a(y.d.t var1) {
      this.k = var1;
   }

   public y.d.t k() {
      return this.k;
   }

   static Color a(e var0) {
      return var0.j;
   }

   static List b(e var0) {
      return var0.c;
   }

   static boolean c(e var0) {
      return var0.i;
   }

   static y.d.t d(e var0) {
      return var0.k;
   }

   static double e(e var0) {
      return var0.e;
   }

   static double f(e var0) {
      return var0.f;
   }
}
