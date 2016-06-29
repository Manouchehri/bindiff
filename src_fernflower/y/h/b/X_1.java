package y.h.b;

import java.awt.Cursor;
import java.awt.geom.Rectangle2D;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import y.h.az;
import y.h.bu;
import y.h.cW;
import y.h.dw;
import y.h.fj;
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

public class X extends ae {
   private byte j = 2;
   protected i a = null;
   protected f b = null;
   protected f c = null;
   protected c d = null;
   protected c e = null;
   private byte k = 0;
   private double l = 5.0D;
   private double m;
   private double n;
   private Rectangle2D o;
   private Rectangle2D p;
   private Rectangle2D q;
   private double r;
   private double s;
   protected double f;
   protected double g;
   private ad t = new ad();
   private ad u = new ad();
   private ad v = new ad();
   private ac w;
   private ac x;
   private ac y;
   private boolean z = true;
   private boolean A;
   private aa B = new aa();

   public boolean a(double var1, double var3) {
      int var18 = a.H;
      this.l();
      if(this.h != null && this.i != null) {
         cW var5 = new cW(this.h, var1, var3, true);
         y.c.q var6 = var5.i();
         if(var6 != null) {
            bu var7 = this.h.getGraph2D();
            if(var7 != null && a((bu)var7, (y.c.q)var6) == this.i) {
               byte var8 = this.a(new y.d.y(this.i.getX(), this.i.getY(), this.i.getWidth(), this.i.getHeight()), var1, var3, this.k());
               f var9;
               if(var8 != 0) {
                  List var20;
                  c var22;
                  label204: {
                     this.k = var8;
                     this.a = this.i.l();
                     switch(var8) {
                     case 1:
                        var9 = this.i.l().c(0);

                        label118: {
                           while(!var9.o().isEmpty()) {
                              var9 = var9.c(0);
                              if(var18 != 0) {
                                 break label118;
                              }

                              if(var18 != 0) {
                                 break;
                              }
                           }

                           this.b = var9;
                        }

                        if(var18 == 0) {
                           return true;
                        }
                     case 3:
                        var20 = this.i.l().o();
                        var9 = (f)var20.get(var20.size() - 1);

                        label106: {
                           while(!var9.o().isEmpty()) {
                              var20 = var9.o();
                              var9 = (f)var20.get(var20.size() - 1);
                              if(var18 != 0) {
                                 break label106;
                              }

                              if(var18 != 0) {
                                 break;
                              }
                           }

                           this.b = var9;
                        }

                        if(var18 == 0) {
                           return true;
                        }
                     case 2:
                        break;
                     case 4:
                        break label204;
                     default:
                        return true;
                     }

                     var22 = this.i.l().b(0);

                     label94: {
                        while(!var22.l().isEmpty()) {
                           var22 = var22.b(0);
                           if(var18 != 0) {
                              break label94;
                           }

                           if(var18 != 0) {
                              break;
                           }
                        }

                        this.d = var22;
                     }

                     if(var18 == 0) {
                        return true;
                     }
                  }

                  var20 = this.i.l().l();
                  var22 = (c)var20.get(var20.size() - 1);

                  while(!var22.l().isEmpty()) {
                     var20 = var22.l();
                     var22 = (c)var20.get(var20.size() - 1);
                     if(var18 != 0) {
                        return true;
                     }

                     if(var18 != 0) {
                        break;
                     }
                  }

                  this.d = var22;
                  return true;
               }

               var9 = this.i.l().a(var1, var3);
               if(var9 != null) {
                  Rectangle2D var10 = var9.h();
                  byte var11 = this.a(new y.d.y(var10.getX(), var10.getY(), var10.getWidth(), var10.getHeight()), var1, var3, this.k());
                  if(var11 == 3) {
                     this.k = 3;
                     f var23 = var9;

                     while(true) {
                        if(!var23.o().isEmpty()) {
                           List var24 = var23.o();
                           var23 = (f)var24.get(var24.size() - 1);
                           if(var18 != 0) {
                              break;
                           }

                           if(var18 == 0) {
                              continue;
                           }
                        }

                        this.b = var23;
                        break;
                     }

                     f var26 = null;

                     f var27;
                     for(Object var28 = var23; var28 instanceof f; var28 = var27.a()) {
                        var27 = (f)var28;
                        int var29 = var27.b();
                        if(var27.a().n() > var29 + 1) {
                           var26 = var27.a().c(var29 + 1);
                           break;
                        }
                     }

                     if(var26 != null) {
                        while(var26.n() > 0) {
                           var26 = var26.c(0);
                           if(var18 != 0) {
                              return true;
                           }

                           if(var18 != 0) {
                              break;
                           }
                        }

                        this.c = var26;
                     }

                     return true;
                  }
               }

               c var19 = this.i.l().b(var1, var3);
               if(var19 != null) {
                  Rectangle2D var21 = var19.h();
                  byte var12 = this.a(new y.d.y(var21.getX(), var21.getY(), var21.getWidth(), var21.getHeight()), var1, var3, this.k());
                  if(var12 == 4) {
                     this.k = 4;
                     c var13 = var19;

                     while(true) {
                        if(!var13.l().isEmpty()) {
                           List var14 = var13.l();
                           var13 = (c)var14.get(var14.size() - 1);
                           if(var18 != 0) {
                              break;
                           }

                           if(var18 == 0) {
                              continue;
                           }
                        }

                        this.d = var13;
                        break;
                     }

                     c var25 = null;

                     c var16;
                     for(Object var15 = var13; var15 instanceof c; var15 = var16.a()) {
                        var16 = (c)var15;
                        int var17 = var16.b();
                        if(var16.a().k() > var17 + 1) {
                           var25 = var16.a().b(var17 + 1);
                           break;
                        }
                     }

                     if(var25 != null) {
                        while(var25.k() > 0) {
                           var25 = var25.b(0);
                           if(var18 != 0) {
                              return true;
                           }

                           if(var18 != 0) {
                              break;
                           }
                        }

                        this.e = var25;
                     }

                     return true;
                  }
               }
            }
         }
      }

      this.i();
      return false;
   }

   protected boolean d(dw var1) {
      return (var1.d() & 64) != 0;
   }

   private byte a(y.d.y var1, double var2, double var4, double var6) {
      y.d.y var8 = new y.d.y(var1.c - var6, var1.d - var6, 2.0D * var6, var1.b + 2.0D * var6);
      if(var8.a(var2, var4)) {
         return (byte)2;
      } else {
         var8 = new y.d.y(var1.c + var1.a - var6, var1.d - var6, 2.0D * var6, var1.b + 2.0D * var6);
         if(var8.a(var2, var4)) {
            return (byte)4;
         } else {
            var8 = new y.d.y(var1.c - var6, var1.d - var6, var1.a + 2.0D * var6, 2.0D * var6);
            if(var8.a(var2, var4)) {
               return (byte)1;
            } else {
               var8 = new y.d.y(var1.c - var6, var1.d + var1.b - var6, var1.a + 2.0D * var6, var1.b + 2.0D * var6);
               return (byte)(var8.a(var2, var4)?3:0);
            }
         }
      }
   }

   private void l() {
      this.b = null;
      this.c = null;
      this.d = null;
      this.e = null;
      this.k = 0;
      this.a = null;
      this.A = false;
   }

   private void a(bu var1, a var2) {
      int var3 = a.H;
      this.r = -1.7976931348623157E308D;
      this.s = Double.MAX_VALUE;
      switch(this.k) {
      case 1:
         if(this.b == null) {
            break;
         }

         this.s = this.a(var1, var2, this.b);
         if(var3 == 0) {
            break;
         }
      case 3:
         if(this.b != null) {
            this.r = -this.b(var1, var2, this.b);
         }

         if(!this.A || this.c == null) {
            break;
         }

         this.s = this.a(var1, var2, this.c);
         if(var3 == 0) {
            break;
         }
      case 2:
         if(this.d == null) {
            break;
         }

         this.s = this.a(var1, var2, this.d);
         if(var3 == 0) {
            break;
         }
      case 4:
         if(this.d != null) {
            this.r = -this.b(var1, var2, this.d);
         }

         if(this.A && this.e != null) {
            this.s = this.a(var1, var2, this.e);
         }
      }

   }

   private double a(bu var1, a var2, f var3) {
      int var15 = a.H;
      double var4 = var3.g() - this.B.a(var3);
      y.d.r var6 = var3.i();
      double var20;
      if(var1 != null && var2 != null) {
         label92: {
            Rectangle2D var7 = var3.h();
            double var8 = var7.getMinY();
            if(var6 != null) {
               var8 += var6.a;
            }

            byte var10 = this.h();
            if(3 == var10) {
               boolean var11 = true;
               Object var12 = var3;

               boolean var10000;
               label81: {
                  while(var12 instanceof f) {
                     f var13 = (f)var12;
                     var12 = var13.a();
                     var10000 = var11;
                     if(var15 != 0) {
                        break label81;
                     }

                     var11 &= var13.b() == 0;
                     if(var15 != 0) {
                        break;
                     }
                  }

                  var10000 = var11;
               }

               if(!var10000) {
                  break label92;
               }

               Rectangle2D var18 = b(var1, var2);
               if(var18.getWidth() <= 0.0D || var18.getHeight() <= 0.0D) {
                  break label92;
               }

               if(var18.getY() < var8) {
                  return 0.0D;
               }

               if(var4 <= var18.getY() - var8) {
                  break label92;
               }

               var4 = var18.getY() - var8;
               if(var15 == 0) {
                  break label92;
               }
            }

            y.c.x var16 = var3.d().a();

            while(var16.f()) {
               fj var17 = var1.t(var16.e());
               var20 = 0.0D;
               if(var15 != 0) {
                  return var20;
               }

               double var19;
               label56: {
                  var19 = 0.0D;
                  if(1 == var10) {
                     var19 = var17.getCenterY();
                     if(var15 == 0) {
                        break label56;
                     }
                  }

                  if(2 == var10) {
                     var19 = var17.getY();
                  }
               }

               if(var19 < var8) {
                  return 0.0D;
               }

               if(var19 - var8 < var4) {
                  var4 = var19 - var8;
               }

               var16.g();
               if(var15 != 0) {
                  break;
               }
            }
         }
      }

      var20 = var4;
      return var20;
   }

   private double b(bu var1, a var2, f var3) {
      int var15 = a.H;
      double var4 = var3.g() - this.B.a(var3);
      y.d.r var6 = var3.i();
      double var20;
      if(var1 != null && var2 != null) {
         label92: {
            Rectangle2D var7 = var3.h();
            double var8 = var7.getMaxY();
            if(var6 != null) {
               var8 -= var6.c;
            }

            byte var10 = this.h();
            if(3 == var10) {
               boolean var11 = true;
               Object var12 = var3;

               boolean var10000;
               label81: {
                  while(var12 instanceof f) {
                     f var13 = (f)var12;
                     var12 = var13.a();
                     var10000 = var11;
                     if(var15 != 0) {
                        break label81;
                     }

                     var11 &= var13.b() == ((g)var12).n() - 1;
                     if(var15 != 0) {
                        break;
                     }
                  }

                  var10000 = var11;
               }

               if(!var10000) {
                  break label92;
               }

               Rectangle2D var18 = b(var1, var2);
               if(var18.getWidth() <= 0.0D || var18.getHeight() <= 0.0D) {
                  break label92;
               }

               if(var18.getMaxY() > var8) {
                  return 0.0D;
               }

               if(var4 <= var8 - var18.getMaxY()) {
                  break label92;
               }

               var4 = var8 - var18.getMaxY();
               if(var15 == 0) {
                  break label92;
               }
            }

            y.c.x var16 = var3.d().a();

            while(var16.f()) {
               fj var17 = var1.t(var16.e());
               var20 = 0.0D;
               if(var15 != 0) {
                  return var20;
               }

               double var19;
               label56: {
                  var19 = 0.0D;
                  if(var10 == 1) {
                     var19 = var17.getCenterY();
                     if(var15 == 0) {
                        break label56;
                     }
                  }

                  if(var10 == 2) {
                     var19 = var17.getY() + var17.getHeight();
                  }
               }

               if(var19 > var8) {
                  return 0.0D;
               }

               if(var8 - var19 < var4) {
                  var4 = var8 - var19;
               }

               var16.g();
               if(var15 != 0) {
                  break;
               }
            }
         }
      }

      var20 = var4;
      return var20;
   }

   private double a(bu var1, a var2, c var3) {
      int var15 = a.H;
      double var4 = var3.g() - this.B.a(var3);
      y.d.r var6 = var3.i();
      double var20;
      if(var1 != null && var2 != null) {
         label92: {
            Rectangle2D var7 = var3.h();
            double var8 = var7.getMinX();
            if(var6 != null) {
               var8 += var6.b;
            }

            byte var10 = this.h();
            if(3 == var10) {
               boolean var11 = true;
               Object var12 = var3;

               boolean var10000;
               label81: {
                  while(var12 instanceof c) {
                     c var13 = (c)var12;
                     var12 = var13.a();
                     var10000 = var11;
                     if(var15 != 0) {
                        break label81;
                     }

                     var11 &= var13.b() == 0;
                     if(var15 != 0) {
                        break;
                     }
                  }

                  var10000 = var11;
               }

               if(!var10000) {
                  break label92;
               }

               Rectangle2D var18 = b(var1, var2);
               if(var18.getWidth() <= 0.0D || var18.getHeight() <= 0.0D) {
                  break label92;
               }

               if(var18.getX() < var8) {
                  return 0.0D;
               }

               if(var4 <= var18.getX() - var8) {
                  break label92;
               }

               var4 = var18.getX() - var8;
               if(var15 == 0) {
                  break label92;
               }
            }

            y.c.x var16 = var3.d().a();

            while(var16.f()) {
               y.c.q var17 = var16.e();
               var20 = 0.0D;
               if(var15 != 0) {
                  return var20;
               }

               double var19;
               label56: {
                  var19 = 0.0D;
                  if(var10 == 1) {
                     var19 = var1.t(var17).getCenterX();
                     if(var15 == 0) {
                        break label56;
                     }
                  }

                  if(var10 == 2) {
                     var19 = var1.t(var17).getX();
                  }
               }

               if(var19 < var8) {
                  return 0.0D;
               }

               if(var19 - var8 < var4) {
                  var4 = var19 - var8;
               }

               var16.g();
               if(var15 != 0) {
                  break;
               }
            }
         }
      }

      var20 = var4;
      return var20;
   }

   private double b(bu var1, a var2, c var3) {
      int var15 = a.H;
      double var4 = var3.g() - this.B.a(var3);
      y.d.r var6 = var3.i();
      double var20;
      if(var1 != null && var2 != null) {
         label92: {
            Rectangle2D var7 = var3.h();
            double var8 = var7.getMaxX();
            if(var6 != null) {
               var8 -= var6.d;
            }

            byte var10 = this.h();
            if(3 == var10) {
               boolean var11 = true;
               Object var12 = var3;

               boolean var10000;
               label81: {
                  while(var12 instanceof c) {
                     c var13 = (c)var12;
                     var12 = var13.a();
                     var10000 = var11;
                     if(var15 != 0) {
                        break label81;
                     }

                     var11 &= var13.b() == ((d)var12).k() - 1;
                     if(var15 != 0) {
                        break;
                     }
                  }

                  var10000 = var11;
               }

               if(!var10000) {
                  break label92;
               }

               Rectangle2D var18 = b(var1, var2);
               if(var18.getWidth() <= 0.0D || var18.getHeight() <= 0.0D) {
                  break label92;
               }

               if(var18.getMaxX() > var8) {
                  return 0.0D;
               }

               if(var4 <= var8 - var18.getMaxX()) {
                  break label92;
               }

               var4 = var8 - var18.getMaxX();
               if(var15 == 0) {
                  break label92;
               }
            }

            y.c.x var16 = var3.d().a();

            while(var16.f()) {
               y.c.q var17 = var16.e();
               var20 = 0.0D;
               if(var15 != 0) {
                  return var20;
               }

               double var19;
               label56: {
                  var19 = 0.0D;
                  if(var10 == 1) {
                     var19 = var1.t(var17).getCenterX();
                     if(var15 == 0) {
                        break label56;
                     }
                  }

                  if(var10 == 2) {
                     var19 = var1.t(var17).getX() + var1.t(var17).getWidth();
                  }
               }

               if(var19 > var8) {
                  return 0.0D;
               }

               if(var8 - var19 < var4) {
                  var4 = var8 - var19;
               }

               var16.g();
               if(var15 != 0) {
                  break;
               }
            }
         }
      }

      var20 = var4;
      return var20;
   }

   private static Rectangle2D b(bu var0, a var1) {
      int var6 = a.H;
      java.awt.geom.Rectangle2D.Double var2 = new java.awt.geom.Rectangle2D.Double(0.0D, 0.0D, -1.0D, -1.0D);
      y.h.a.v var3 = var0.C();
      if(var3 != null) {
         y.c.q var4 = var1.getNode();
         if(var4 != null && var4.e() == var0 && var3.k(var4)) {
            y.c.x var5 = var3.p(var4);

            while(var5.f()) {
               var0.t(var5.e()).calcUnionRect(var2);
               var5.g();
               if(var6 != 0) {
                  break;
               }
            }
         }
      }

      return var2;
   }

   protected void a(double var1, double var3, boolean var5) {
      int var6 = a.H;
      if(!this.a(var1, var3)) {
         this.m();
      } else if(this.i == null) {
         this.m();
      } else {
         label69: {
            this.m = var1;
            this.n = var3;
            this.f = 0.0D;
            this.g = 0.0D;
            this.A = (var5 || 3 == this.h()) && (this.e != null || this.c != null);
            this.a(this.h.getGraph2D(), this.i);
            if(this.b != null) {
               this.o = this.b.h();
               this.t.a(this.a(this.b, this.o));
               if(!this.A) {
                  break label69;
               }

               this.p = this.c.h();
               this.u.a(this.a(this.c, this.p));
               if(var6 == 0) {
                  break label69;
               }
            }

            if(this.d == null) {
               throw new IllegalStateException("A resize action was started although no row or column was set to be resized.");
            }

            this.o = this.d.h();
            this.t.a(this.a(this.d, this.o));
            if(this.A) {
               this.p = this.e.h();
               this.u.a(this.a(this.e, this.p));
               if(var6 != 0) {
                  throw new IllegalStateException("A resize action was started although no row or column was set to be resized.");
               }
            }
         }

         this.h.addDrawable(this.t);
         if(this.A) {
            this.h.addDrawable(this.u);
         }

         if(this.j()) {
            this.q = new java.awt.geom.Rectangle2D.Double(this.i.getX(), this.i.getY(), this.i.getWidth(), this.i.getHeight());
            this.v.a(this.a(this.i.l(), this.q));
            this.h.addDrawable(this.v);
            this.h.updateView(this.v.getBounds());
            if(var6 == 0) {
               return;
            }
         }

         this.h.updateView(this.t.getBounds());
         if(this.A) {
            this.h.updateView(this.u.getBounds());
         }

      }
   }

   protected void b(double var1, double var3) {
      int var5 = a.H;
      this.f = Math.min(Math.max(var1 - this.m, this.r), this.s);
      this.g = Math.min(Math.max(var3 - this.n, this.r), this.s);
      switch(this.k) {
      case 1:
         this.t.a(this.a((f)this.b, (Rectangle2D)(new java.awt.geom.Rectangle2D.Double(this.o.getX(), this.o.getY() + this.g, this.o.getWidth(), this.o.getHeight() - this.g))));
         if(!this.j()) {
            break;
         }

         this.v.a(this.a((i)this.a, (Rectangle2D)(new java.awt.geom.Rectangle2D.Double(this.q.getX(), this.q.getY() + this.g, this.q.getWidth(), this.q.getHeight() - this.g))));
         if(var5 == 0) {
            break;
         }
      case 3:
         this.t.a(this.a((f)this.b, (Rectangle2D)(new java.awt.geom.Rectangle2D.Double(this.o.getX(), this.o.getY(), this.o.getWidth(), this.o.getHeight() + this.g))));
         if(this.A) {
            this.u.a(this.a((f)this.c, (Rectangle2D)(new java.awt.geom.Rectangle2D.Double(this.p.getX(), this.p.getY() + this.g, this.p.getWidth(), this.p.getHeight() - this.g))));
            if(var5 == 0) {
               break;
            }
         }

         if(!this.j()) {
            break;
         }

         this.v.a(this.a((i)this.a, (Rectangle2D)(new java.awt.geom.Rectangle2D.Double(this.q.getX(), this.q.getY(), this.q.getWidth(), this.q.getHeight() + this.g))));
         if(var5 == 0) {
            break;
         }
      case 2:
         this.t.a(this.a((c)this.d, (Rectangle2D)(new java.awt.geom.Rectangle2D.Double(this.o.getX() + this.f, this.o.getY(), this.o.getWidth() - this.f, this.o.getHeight()))));
         if(!this.j()) {
            break;
         }

         this.v.a(this.a((i)this.a, (Rectangle2D)(new java.awt.geom.Rectangle2D.Double(this.q.getX() + this.f, this.q.getY(), this.q.getWidth() - this.f, this.q.getHeight()))));
         if(var5 == 0) {
            break;
         }
      case 4:
         label22: {
            this.t.a(this.a((c)this.d, (Rectangle2D)(new java.awt.geom.Rectangle2D.Double(this.o.getX(), this.o.getY(), this.o.getWidth() + this.f, this.o.getHeight()))));
            if(this.A) {
               this.u.a(this.a((c)this.e, (Rectangle2D)(new java.awt.geom.Rectangle2D.Double(this.p.getX() + this.f, this.p.getY(), this.p.getWidth() - this.f, this.p.getHeight()))));
               if(var5 == 0) {
                  break label22;
               }
            }

            if(this.j()) {
               this.v.a(this.a((i)this.a, (Rectangle2D)(new java.awt.geom.Rectangle2D.Double(this.q.getX(), this.q.getY(), this.q.getWidth() + this.f, this.q.getHeight()))));
            }
         }
      }

      this.h.getGraph2D().T();
   }

   protected void c(double var1, double var3) {
      this.g();
      this.m();
   }

   protected void g() {
      int var7 = a.H;
      if(this.i != null) {
         y.c.q var1 = this.i.getNode();
         bu var2 = (bu)var1.e();
         if(var2 != null && (this.b != null || this.d != null)) {
            var2.r();

            try {
               var2.a((new y.c.y(var1)).a());
               fj var3 = a((bu)var2, (y.c.q)var1);
               if(var3 == this.i) {
                  if(this.b != null) {
                     this.a(var2, this.i, this.b, this.c);
                     if(var7 == 0) {
                        return;
                     }
                  }

                  if(this.d == null) {
                     return;
                  }

                  this.a(var2, this.i, this.d, this.e);
                  if(var7 == 0) {
                     return;
                  }
               }

               if(var3 instanceof a) {
                  a var4 = (a)var3;
                  ArrayList var5;
                  if(this.b != null) {
                     var5 = new ArrayList();
                     this.a(var2, var4, aa.a((f)this.b, (a)var4, (List)var5), this.c == null?null:aa.a((f)this.c, (a)var4, (List)var5));
                     if(var7 == 0) {
                        return;
                     }
                  }

                  if(this.d != null) {
                     var5 = new ArrayList();
                     this.a(var2, var4, aa.a((c)this.d, (a)var4, (List)var5), this.e == null?null:aa.a((c)this.e, (a)var4, (List)var5));
                  }
               }
            } finally {
               var2.s();
            }

         }
      }
   }

   private void a(bu var1, a var2, c var3, c var4) {
      int var8 = a.H;
      if(3 == this.h()) {
         boolean var5;
         d var6;
         c var7;
         boolean var10000;
         switch(this.k) {
         case 2:
            var3.b(var3.g() - this.f);
            if(var3.b() != 0) {
               break;
            }

            var5 = true;
            var6 = var3.a();

            label91: {
               while(var6 instanceof c) {
                  var7 = (c)var6;
                  var7.b(var7.g() - this.f);
                  var6 = var7.a();
                  var10000 = var5;
                  if(var8 != 0) {
                     break label91;
                  }

                  var5 &= var7.b() == 0;
                  if(var8 != 0) {
                     break;
                  }
               }

               var10000 = var5;
            }

            if(!var10000) {
               break;
            }

            a(var2, var2.getX() + this.f, var2.getY(), var2.getWidth() - this.f, var2.getHeight());
            if(var8 == 0) {
               break;
            }
         case 4:
            var3.b(var3.g() + this.f);
            if(var3.b() == var3.a().k() - 1) {
               var5 = true;
               var6 = var3.a();

               label77: {
                  while(var6 instanceof c) {
                     var7 = (c)var6;
                     var7.b(var7.g() + this.f);
                     var6 = var7.a();
                     var10000 = var5;
                     if(var8 != 0) {
                        break label77;
                     }

                     var5 &= var7.b() == var6.k() - 1;
                     if(var8 != 0) {
                        break;
                     }
                  }

                  var10000 = var5;
               }

               if(var10000) {
                  a(var2, var2.getX(), var2.getY(), var2.getWidth() + this.f, var2.getHeight());
               }
            }

            if(this.A) {
               var4.b(var4.g() - this.f);
               if(var4.b() == 0) {
                  d var9 = var4.a();

                  while(var9 instanceof c) {
                     c var10 = (c)var9;
                     var10.b(var10.g() - this.f);
                     var9 = var10.a();
                     if(var8 != 0) {
                        return;
                     }

                     if(var8 != 0) {
                        break;
                     }
                  }
               }
            }
         }

         if(var8 == 0) {
            return;
         }
      }

      switch(this.k) {
      case 2:
         this.B.a(var3, var3.g() - this.f, true);
         y.c.y var11 = new y.c.y();
         this.B.a((y.c.q)var2.getNode(), (Rectangle2D)var2.getBoundingBox(), (Collection)var11);
         y.h.z var12 = new y.h.z();
         this.B.a((bu)var1, (Rectangle2D)var2.getBoundingBox(), (Collection)var12);
         var2.setFrame(var2.getX() + this.f, var2.getY(), var2.getWidth(), var2.getHeight());
         this.B.a(var1, var11, var12, this.f, 0.0D);
         if(var8 == 0) {
            break;
         }
      case 4:
         this.B.a(var3, var3.g() + this.f, false);
         if(this.A) {
            this.B.a(var4, var4.g() - this.f, true);
         }
      }

   }

   private void a(bu var1, a var2, f var3, f var4) {
      int var8 = a.H;
      if(3 == this.h()) {
         boolean var5;
         g var6;
         f var7;
         boolean var10000;
         switch(this.k) {
         case 1:
            var3.b(var3.g() - this.g);
            if(var3.b() != 0) {
               break;
            }

            var5 = true;
            var6 = var3.a();

            label91: {
               while(var6 instanceof f) {
                  var7 = (f)var6;
                  var7.b(var7.g() - this.g);
                  var6 = var7.a();
                  var10000 = var5;
                  if(var8 != 0) {
                     break label91;
                  }

                  var5 &= var7.b() == 0;
                  if(var8 != 0) {
                     break;
                  }
               }

               var10000 = var5;
            }

            if(!var10000) {
               break;
            }

            a(var2, var2.getX(), var2.getY() + this.g, var2.getWidth(), var2.getHeight() - this.g);
            if(var8 == 0) {
               break;
            }
         case 3:
            var3.b(var3.g() + this.g);
            if(var3.b() == var3.a().n() - 1) {
               var5 = true;
               var6 = var3.a();

               label77: {
                  while(var6 instanceof f) {
                     var7 = (f)var6;
                     var7.b(var7.g() + this.g);
                     var6 = var7.a();
                     var10000 = var5;
                     if(var8 != 0) {
                        break label77;
                     }

                     var5 &= var7.b() == var6.n() - 1;
                     if(var8 != 0) {
                        break;
                     }
                  }

                  var10000 = var5;
               }

               if(var10000) {
                  a(var2, var2.getX(), var2.getY(), var2.getWidth(), var2.getHeight() + this.g);
               }
            }

            if(this.A) {
               var4.b(var4.g() - this.g);
               if(var4.b() == 0) {
                  g var9 = var4.a();

                  while(var9 instanceof f) {
                     f var10 = (f)var9;
                     var10.b(var10.g() - this.g);
                     var9 = var10.a();
                     if(var8 != 0) {
                        return;
                     }

                     if(var8 != 0) {
                        break;
                     }
                  }
               }
            }
         }

         if(var8 == 0) {
            return;
         }
      }

      switch(this.k) {
      case 1:
         this.B.a(var3, var3.g() - this.g, true);
         y.c.y var11 = new y.c.y();
         this.B.a((y.c.q)var2.getNode(), (Rectangle2D)var2.getBoundingBox(), (Collection)var11);
         y.h.z var12 = new y.h.z();
         this.B.a((bu)var1, (Rectangle2D)var2.getBoundingBox(), (Collection)var12);
         var2.setFrame(var2.getX(), var2.getY() + this.g, var2.getWidth(), var2.getHeight());
         this.B.a(var1, var11, var12, 0.0D, this.g);
         if(var8 == 0) {
            break;
         }
      case 3:
         this.B.a(var3, var3.g() + this.g, false);
         if(this.A) {
            this.B.a(var4, var4.g() - this.g, true);
         }
      }

   }

   private static void a(a var0, double var1, double var3, double var5, double var7) {
      y.h.a.a var9 = var0.getAutoBoundsFeature();
      boolean var10 = var9 != null && var9.isAutoBoundsEnabled();
      if(var10) {
         var9.setAutoBoundsEnabled(false);
      }

      try {
         boolean var11 = var0.k();
         if(var11) {
            var0.c(false);
         }

         try {
            var0.setFrame(var1, var3, var5, var7);
         } finally {
            if(var11) {
               var0.c(var11);
            }

         }
      } finally {
         if(var10) {
            var9.setAutoBoundsEnabled(var10);
         }

      }

   }

   private void m() {
      this.l();
      if(this.t.a() != null) {
         this.t.a((az)null);
         this.h.removeDrawable(this.t);
      }

      if(this.u.a() != null) {
         this.u.a((az)null);
         this.h.removeDrawable(this.u);
      }

      if(this.v.a() != null) {
         this.v.a((az)null);
         this.h.removeDrawable(this.v);
      }

      this.h.getGraph2D().T();
      this.e();
   }

   protected az a(i var1, Rectangle2D var2) {
      if(this.y == null) {
         this.y = new ac();
      }

      if(var1 != null) {
         label15: {
            y.d.r var3 = var1.d();
            if(var3.a > var3.b) {
               this.y.a(false);
               this.y.a(var3.a);
               if(a.H == 0) {
                  break label15;
               }
            }

            this.y.a(true);
            this.y.a(var3.b);
         }
      }

      this.y.a(var2.getX(), var2.getY(), var2.getWidth(), var2.getHeight());
      return this.y;
   }

   protected az a(f var1, Rectangle2D var2) {
      ac var3;
      label35: {
         int var4 = a.H;
         if(var1 != null && var1 == this.b) {
            if(this.w == null) {
               this.w = new ac();
            }

            var3 = this.w;
            if(var4 == 0) {
               break label35;
            }
         }

         if(var1 != null && var1 == this.c) {
            if(this.x == null) {
               this.x = new ac();
            }

            var3 = this.x;
            if(var4 == 0) {
               break label35;
            }
         }

         return null;
      }

      if(var1.i() != null) {
         var3.a(true);
         var3.a(var1.i().b);
      }

      var3.a(var2.getX(), var2.getY(), var2.getWidth(), var2.getHeight());
      return var3;
   }

   protected az a(c var1, Rectangle2D var2) {
      ac var3;
      label35: {
         int var4 = a.H;
         if(var1 != null && var1 == this.d) {
            if(this.w == null) {
               this.w = new ac();
            }

            var3 = this.w;
            if(var4 == 0) {
               break label35;
            }
         }

         if(var1 != null && var1 == this.e) {
            if(this.x == null) {
               this.x = new ac();
            }

            var3 = this.x;
            if(var4 == 0) {
               break label35;
            }
         }

         return null;
      }

      if(var1.i() != null) {
         var3.a(false);
         var3.a(var1.i().a);
      }

      var3.a(var2.getX(), var2.getY(), var2.getWidth(), var2.getHeight());
      return var3;
   }

   public byte h() {
      return this.j;
   }

   public boolean j() {
      return this.z;
   }

   public double k() {
      return this.l;
   }

   public void e() {
      this.h.setViewCursor(Cursor.getPredefinedCursor(13));
      super.e();
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

         this.a(var1.a(), var1.b(), this.d(var1));
         if(var2 == 0) {
            break;
         }
      case 506:
         this.b(var1.a(), var1.b());
         if(var2 == 0) {
            break;
         }
      case 502:
         if(!this.e(var1)) {
            break;
         }

         this.c(var1.a(), var1.b());
         if(var2 == 0) {
            break;
         }
      default:
         this.m();
      }

   }

   public Cursor c(dw var1) {
      if(this.a(var1.a(), var1.b())) {
         switch(this.k) {
         case 1:
         case 3:
            return Cursor.getPredefinedCursor(8);
         case 2:
         case 4:
            return Cursor.getPredefinedCursor(10);
         default:
            return null;
         }
      } else {
         return null;
      }
   }

   void i() {
      super.i();
      this.a = null;
      this.b = null;
      this.c = null;
      this.d = null;
      this.e = null;
   }
}
