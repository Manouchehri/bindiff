package y.h.b;

import java.awt.Cursor;
import java.awt.geom.Rectangle2D;
import java.awt.geom.Rectangle2D.Double;
import java.util.Iterator;
import java.util.List;
import y.h.az;
import y.h.bu;
import y.h.cW;
import y.h.dw;
import y.h.b.a;
import y.h.b.aa;
import y.h.b.ac;
import y.h.b.ad;
import y.h.b.ae;
import y.h.b.c;
import y.h.b.d;
import y.h.b.f;
import y.h.b.g;
import y.h.b.i;

public class S extends ae {
   private f a;
   private c b;
   private ad c = new ad();
   private ac d;
   private g e;
   private d f;
   private g g;
   private d j;
   private aa k = new aa();
   private byte l = 1;
   private boolean m = true;
   private int n;
   private int o;
   private int p;
   private int q = Integer.MAX_VALUE;
   private int r = Integer.MAX_VALUE;

   public boolean a(double var1, double var3) {
      this.b = null;
      this.a = null;
      if(this.h != null && this.i != null) {
         cW var5 = new cW(this.h, var1, var3, true);
         y.c.q var6 = this.a((cW)var5);
         if(var6 != null) {
            bu var7 = this.h.getGraph2D();
            if(var7 != null && a((bu)var7, (y.c.q)var6) == this.i) {
               f var8 = this.i.l().a(var1, var3);
               if(var8 != null && this.a(var8, var1, var3)) {
                  this.a = var8;
                  return true;
               }

               c var9 = this.i.l().b(var1, var3);
               if(var9 != null && this.a(var9, var1, var3)) {
                  this.b = var9;
                  return true;
               }
            }
         }
      }

      this.i();
      return false;
   }

   protected boolean a(c var1, double var2, double var4) {
      return (this.g() == 2 || var1.e()) && this.a(this.i, var1, var2, var4, this.h());
   }

   protected boolean a(f var1, double var2, double var4) {
      return (this.g() == 2 || var1.e()) && this.a(this.i, var1, var2, var4, this.h());
   }

   protected void b(double var1, double var3) {
      if(this.a(var1, var3) && (this.b != null || this.a != null)) {
         this.e = null;
         this.f = null;
         this.n = -1;
         this.p = 0;
         Rectangle2D var5 = null;
         if(this.a != null) {
            var5 = this.a.h();
            this.c.a(this.a(this.a, var5));
            this.e = this.a.a();
            this.n = this.a.b();
            this.p = this.b(this.a);
         } else if(this.b != null) {
            var5 = this.b.h();
            this.c.a(this.a(this.b, var5));
            this.f = this.b.a();
            this.n = this.b.b();
            this.p = this.b(this.b);
         }

         this.h.addDrawable(this.c);
         this.h.updateView(var5);
         this.g = this.e;
         this.j = this.f;
         this.o = this.n;
         if(a.H == 0) {
            return;
         }
      }

      this.i();
   }

   protected void c(double var1, double var3) {
      label129: {
         if(this.a != null && this.a.b() >= 0) {
            this.e(var1, var3);
            if(this.e != this.g) {
               this.h.getGraph2D().r();

               try {
                  this.k.a(this.a, this.g);
                  this.k.a(this.a, this.o);
                  break label129;
               } finally {
                  this.h.getGraph2D().s();
               }
            }

            if(this.n == this.o) {
               break label129;
            }

            this.k.a(this.a, this.o);
            if(a.H == 0) {
               break label129;
            }
         }

         if(this.b != null && this.b.b() >= 0) {
            this.f(var1, var3);
            if(this.f != this.j) {
               this.h.getGraph2D().r();

               try {
                  this.k.a(this.b, this.j);
                  this.k.a(this.b, this.o);
               } finally {
                  this.h.getGraph2D().s();
               }
            } else if(this.n != this.o) {
               this.k.a(this.b, this.o);
            }
         }
      }

      this.e();
   }

   protected void d(double var1, double var3) {
      label91: {
         int var16 = a.H;
         i var5;
         int var6;
         Rectangle2D var7;
         double var8;
         double var10;
         double var12;
         double var14;
         y.d.r var15;
         double var19;
         Rectangle2D var20;
         int var21;
         Rectangle2D var22;
         if(this.a != null) {
            this.e(var1, var3);
            if(this.g instanceof i) {
               var5 = (i)this.g;
               var6 = var5.n() > this.o?this.o:this.o - 1;
               var7 = var5.c(var6).h();
               var8 = var7.getX();
               var10 = var7.getY();
               var12 = var7.getWidth();
               var14 = this.a.g();
               if(var5.n() <= this.o) {
                  var10 += var7.getHeight();
               }

               this.c.a(this.a((f)this.a, new Double(var8, var10, var12, var14)));
               if(var16 == 0) {
                  break label91;
               }
            }

            if(!(this.g instanceof f)) {
               break label91;
            }

            label95: {
               f var17 = (f)this.g;
               if(var17.o().isEmpty()) {
                  var20 = var17.h();
                  var19 = var20.getX();
                  var8 = var20.getY();
                  var10 = var20.getWidth();
                  var12 = var20.getHeight();
                  var15 = var17.i();
                  if(var15 != null) {
                     var19 += var15.b;
                     var8 += var15.a;
                     var10 -= var15.b + var15.d;
                     var12 -= var15.a + var15.c;
                  }

                  if(var12 >= this.a.g()) {
                     break label95;
                  }

                  var12 = this.a.g();
                  if(var16 == 0) {
                     break label95;
                  }
               }

               var21 = var17.n() > this.o?this.o:this.o - 1;
               var22 = var17.c(var21).h();
               var19 = var22.getX();
               var10 = var22.getWidth();
               var12 = this.a.g();
               var8 = var22.getY();
               if(var17.n() <= this.o) {
                  var8 += var22.getHeight();
               }
            }

            this.c.a(this.a((f)this.a, new Double(var19, var8, var10, var12)));
            if(var16 == 0) {
               break label91;
            }
         }

         if(this.b != null) {
            label72: {
               this.f(var1, var3);
               if(this.j instanceof i) {
                  var5 = (i)this.j;
                  var6 = var5.k() > this.o?this.o:this.o - 1;
                  var7 = var5.b(var6).h();
                  var8 = var7.getX();
                  var10 = var7.getY();
                  var12 = this.b.g();
                  var14 = var7.getHeight();
                  if(var5.k() <= this.o) {
                     var8 += var7.getWidth();
                  }

                  this.c.a(this.a((c)this.b, new Double(var8, var10, var12, var14)));
                  if(var16 == 0) {
                     break label72;
                  }
               }

               if(this.j instanceof c) {
                  label98: {
                     c var18 = (c)this.j;
                     if(var18.l().isEmpty()) {
                        var20 = var18.h();
                        var19 = var20.getX();
                        var8 = var20.getY();
                        var10 = var20.getWidth();
                        var12 = var20.getHeight();
                        var15 = var18.i();
                        if(var15 != null) {
                           var19 += var15.b;
                           var8 += var15.a;
                           var10 -= var15.b + var15.d;
                           var12 -= var15.a + var15.c;
                        }

                        if(var10 >= this.b.g()) {
                           break label98;
                        }

                        var10 = this.b.g();
                        if(var16 == 0) {
                           break label98;
                        }
                     }

                     var21 = var18.k() > this.o?this.o:this.o - 1;
                     var22 = var18.b(var21).h();
                     var19 = var22.getX();
                     var8 = var22.getY();
                     var10 = this.b.g();
                     var12 = var22.getHeight();
                     if(var18.k() <= this.o) {
                        var19 += var22.getWidth();
                     }
                  }

                  this.c.a(this.a((c)this.b, new Double(var19, var8, var10, var12)));
               }
            }
         }
      }

      this.h.getGraph2D().T();
   }

   private void e(double var1, double var3) {
      int var13 = a.H;
      if(this.i != null) {
         f var5 = this.i.l().a(var1, var3);
         if(var5 != null && (var5 == this.a || this.p + 1 < this.q)) {
            int var6 = this.a(var5);

            while(var5 != this.a && var6 + this.p > this.q) {
               var5 = (f)var5.a();
               --var6;
               if(var13 != 0) {
                  break;
               }
            }

            Object var9;
            int var10;
            label117: {
               y.d.r var7 = var5.i();
               Rectangle2D var8 = var5.h();
               if(var6 + this.p >= this.q || var7 != null && var1 < var8.getX() + var7.b) {
                  var9 = var5.a();
                  var10 = var5.b();
                  if(var13 == 0) {
                     break label117;
                  }
               }

               var9 = var5;
               if(var7 != null && var3 > var8.getMaxY() - var7.c) {
                  if(var5 == this.a.a()) {
                     var10 = var5.n() - 1;
                     if(var13 == 0) {
                        break label117;
                     }
                  }

                  var10 = var5.n();
                  if(var13 == 0) {
                     break label117;
                  }
               }

               var10 = 0;
            }

            Object var11 = var9;
            boolean var12 = false;

            while(var11 instanceof f) {
               if(var11 == this.a) {
                  var12 = true;
               }

               var11 = ((f)var11).a();
               if(var13 != 0) {
                  break;
               }
            }

            if(var12) {
               this.g = this.e;
               this.o = this.n;
               if(var13 == 0) {
                  return;
               }
            }

            this.g = (g)var9;
            this.o = var10;
            if(var13 == 0) {
               return;
            }
         }

         double var14 = this.i.getY() + this.i.t();
         i var15 = this.i.l();
         if(var3 < var14) {
            this.g = var15;
            this.o = 0;
            if(var13 == 0) {
               return;
            }
         }

         Iterator var16 = var15.o().iterator();

         while(var16.hasNext()) {
            f var17 = (f)var16.next();
            var14 += var17.g();
            if(var3 < var14) {
               this.g = var15;
               this.o = var17.b();
               if(var13 != 0) {
                  return;
               }
               break;
            }
         }

         if(var3 >= var14) {
            this.g = var15;
            this.o = this.e == var15?var15.n() - 1:var15.n();
         }
      }

   }

   private void f(double var1, double var3) {
      int var13 = a.H;
      if(this.i != null) {
         c var5 = this.i.l().b(var1, var3);
         if(var5 != null && (var5 == this.b || this.p + 1 < this.r)) {
            int var6 = this.a(var5);

            while(var5 != this.b && var6 + this.p > this.r) {
               var5 = (c)var5.a();
               --var6;
               if(var13 != 0) {
                  break;
               }
            }

            Object var9;
            int var10;
            label117: {
               y.d.r var7 = var5.i();
               Rectangle2D var8 = var5.h();
               if(var6 + this.p >= this.r || var7 != null && var3 < var8.getY() + var7.a) {
                  var9 = var5.a();
                  var10 = var5.b();
                  if(var13 == 0) {
                     break label117;
                  }
               }

               var9 = var5;
               if(var7 != null && var1 > var8.getMaxX() - var7.d) {
                  if(var5 == this.b.a()) {
                     var10 = var5.k() - 1;
                     if(var13 == 0) {
                        break label117;
                     }
                  }

                  var10 = var5.k();
                  if(var13 == 0) {
                     break label117;
                  }
               }

               var10 = 0;
            }

            Object var11 = var9;
            boolean var12 = false;

            while(var11 instanceof c) {
               if(var11 == this.b) {
                  var12 = true;
               }

               var11 = ((c)var11).a();
               if(var13 != 0) {
                  break;
               }
            }

            if(var12) {
               this.j = this.f;
               this.o = this.n;
               if(var13 == 0) {
                  return;
               }
            }

            this.j = (d)var9;
            this.o = var10;
            if(var13 == 0) {
               return;
            }
         }

         double var14 = this.i.getX() + this.i.v();
         i var15 = this.i.l();
         if(var1 < var14) {
            this.j = var15;
            this.o = 0;
            if(var13 == 0) {
               return;
            }
         }

         Iterator var16 = var15.l().iterator();

         while(var16.hasNext()) {
            c var17 = (c)var16.next();
            var14 += var17.g();
            if(var1 < var14) {
               this.j = var15;
               this.o = var17.b();
               if(var13 != 0) {
                  return;
               }
               break;
            }
         }

         if(var1 >= var14) {
            this.j = var15;
            this.o = this.f == var15?var15.k() - 1:var15.k();
         }
      }

   }

   private int a(f var1) {
      int var4 = a.H;
      int var2 = 1;
      g var3 = var1.a();

      while(var3 instanceof f) {
         ++var2;
         var3 = ((f)var3).a();
         if(var4 != 0) {
            break;
         }
      }

      return var2;
   }

   private int a(c var1) {
      int var4 = a.H;
      int var2 = 1;
      d var3 = var1.a();

      while(var3 instanceof c) {
         ++var2;
         var3 = ((c)var3).a();
         if(var4 != 0) {
            break;
         }
      }

      return var2;
   }

   private int b(f var1) {
      int var7 = a.H;
      int var2 = 0;
      int var10000;
      if(var1.n() > 0) {
         List var3 = var1.o();
         int var4 = 0;

         while(var4 < var3.size()) {
            f var5 = (f)var3.get(var4);
            int var6 = this.b(var5);
            var10000 = var6 + 1;
            if(var7 != 0) {
               return var10000;
            }

            if(var10000 > var2) {
               var2 = var6 + 1;
            }

            ++var4;
            if(var7 != 0) {
               break;
            }
         }
      }

      var10000 = var2;
      return var10000;
   }

   private int b(c var1) {
      int var7 = a.H;
      int var2 = 0;
      int var10000;
      if(var1.k() > 0) {
         List var3 = var1.l();
         int var4 = 0;

         while(var4 < var3.size()) {
            c var5 = (c)var3.get(var4);
            int var6 = this.b(var5);
            var10000 = var6 + 1;
            if(var7 != 0) {
               return var10000;
            }

            if(var10000 > var2) {
               var2 = var6 + 1;
            }

            ++var4;
            if(var7 != 0) {
               break;
            }
         }
      }

      var10000 = var2;
      return var10000;
   }

   public void e() {
      if(this.c.a() != null) {
         this.c.a((az)null);
         this.h.removeDrawable(this.c);
      }

      this.h.setViewCursor(Cursor.getDefaultCursor());
      this.h.getGraph2D().T();
      super.e();
   }

   protected az a(f var1, Rectangle2D var2) {
      if(this.d == null) {
         this.d = new ac();
      }

      this.d.a(true);
      if(var1 != null && var1.i() != null) {
         this.d.a(var1.i().b);
      }

      this.d.a(var2.getX(), var2.getY(), var2.getWidth(), var2.getHeight());
      return this.d;
   }

   protected az a(c var1, Rectangle2D var2) {
      if(this.d == null) {
         this.d = new ac();
      }

      this.d.a(false);
      if(var1 != null && var1.i() != null) {
         this.d.a(var1.i().a);
      }

      this.d.a(var2.getX(), var2.getY(), var2.getWidth(), var2.getHeight());
      return this.d;
   }

   public byte g() {
      return this.l;
   }

   public boolean a(dw var1) {
      return this.f(var1) && this.a(var1.a(), var1.b());
   }

   public void b(dw var1) {
      int var2 = a.H;
      switch(var1.c()) {
      case 501:
         if(!this.e(var1)) {
            break;
         }

         this.b(var1.a(), var1.b());
         if(var2 == 0) {
            break;
         }
      case 506:
         this.d(var1.a(), var1.b());
         if(var2 == 0) {
            break;
         }
      case 502:
         if(this.e(var1)) {
            this.c(var1.a(), var1.b());
         }
      }

   }

   public Cursor c(dw var1) {
      return this.a(var1.a(), var1.b())?Cursor.getPredefinedCursor(13):null;
   }

   public boolean h() {
      return this.m;
   }

   void i() {
      super.i();
      this.a = null;
      this.b = null;
      this.e = null;
      this.f = null;
      this.g = null;
      this.j = null;
   }
}
