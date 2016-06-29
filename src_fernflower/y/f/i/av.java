package y.f.i;

import java.awt.geom.Rectangle2D;
import java.awt.geom.Rectangle2D.Double;
import java.util.Collection;
import java.util.Iterator;
import y.f.i.aA;
import y.f.i.aB;
import y.f.i.aC;
import y.f.i.aF;
import y.f.i.aJ;
import y.f.i.ad;
import y.f.i.ag;
import y.f.i.ai;
import y.f.i.al;
import y.f.i.an;
import y.f.i.ao;
import y.f.i.au;
import y.f.i.aw;
import y.f.i.ax;
import y.f.i.n;
import y.f.i.v;

class av {
   private y.f.X a;
   private byte b;
   private double c;
   private boolean d;
   private boolean e;
   private Rectangle2D f;
   private boolean g;
   private double h;
   private boolean i;
   private long j;
   private ax k;
   private ax l;
   private y.c.D m;
   private y.c.D n;
   private aC o;
   private y.c.D p;
   private y.c.y q;
   private y.c.f r;
   private y.c.D s;
   private y.c.D t;
   private aF u;
   private aF v;
   private au w;
   private an x;
   private int y = 0;
   private int z = 0;
   private boolean A;

   public av(y.f.X var1, y.c.f var2) {
      this.a = var1;
      this.q = new y.c.y(var1.o());
      this.r = var2;
      this.i();
   }

   private void i() {
      this.j = 0L;
      this.b = 2;
      this.c = 3.0D;
      this.g = false;
      this.i = false;
      this.d = false;
      this.e = false;
   }

   private ao a(double var1, double var3, double var5, double var7) {
      int var10 = v.f;
      Object var9;
      if(this.A) {
         label40: {
            if(this.e) {
               var9 = new ai(var1, var3, var1 + var5, var3 + var7, true);
               if(var10 == 0) {
                  break label40;
               }
            }

            if(this.d) {
               var9 = new al(var1, var3, var1 + var5, var3 + var7, true);
               if(var10 == 0) {
                  break label40;
               }
            }

            var9 = new ao(var1, var3, var1 + var5, var3 + var7, true);
         }

         this.s.add(var9);
         if(var10 == 0) {
            return (ao)var9;
         }
      }

      label41: {
         if(this.e) {
            var9 = new ai(var3, var1, var3 + var7, var1 + var5, false);
            if(var10 == 0) {
               break label41;
            }
         }

         if(this.d) {
            var9 = new al(var3, var1, var3 + var7, var1 + var5, false);
            if(var10 == 0) {
               break label41;
            }
         }

         var9 = new ao(var3, var1, var3 + var7, var1 + var5, false);
      }

      this.t.add(var9);
      return (ao)var9;
   }

   private void a(ag var1, ag var2, byte var3) {
      int var7 = v.f;
      y.c.q var6 = (y.c.q)var1.f();
      aJ var4 = (aJ)this.x.b(var2);
      aJ var5 = (aJ)this.w.b(var6);
      if(this.A) {
         switch(var3) {
         case 1:
            var5.b(var2);
            var4.d(var6);
            if(var7 == 0) {
               break;
            }
         case 2:
            var5.d(var2);
            var4.b(var6);
         }

         if(var7 == 0) {
            return;
         }
      }

      switch(var3) {
      case 1:
         var5.f(var2);
         var4.h(var6);
         if(var7 == 0) {
            break;
         }
      case 2:
         var5.h(var2);
         var4.f(var6);
      }

   }

   private void b(ag var1, ag var2, byte var3) {
      int var7 = v.f;
      y.c.q var4 = (y.c.q)var1.f();
      aJ var5 = (aJ)this.x.b(var2);
      aJ var6 = (aJ)this.w.b(var4);
      if(this.A) {
         switch(var3) {
         case 1:
            if((y.c.q)var5.b() == var4) {
               break;
            }

            var6.a(var2);
            var5.c(var4);
            if(var7 == 0) {
               break;
            }
         case 2:
            if((y.c.q)var5.a() != var4) {
               var6.c(var2);
               var5.a(var4);
            }
         }

         if(var7 == 0) {
            return;
         }
      }

      switch(var3) {
      case 1:
         if((y.c.q)var5.d() == var4) {
            break;
         }

         var6.e(var2);
         var5.g(var4);
         if(var7 == 0) {
            break;
         }
      case 2:
         if((y.c.q)var5.c() != var4) {
            var6.g(var2);
            var5.e(var4);
         }
      }

   }

   private void j() {
      int var11 = v.f;
      y.c.e var1 = this.a.p();

      y.f.X var10000;
      while(true) {
         if(var1.f()) {
            y.c.d var2 = var1.a();
            this.a.a(var2, y.d.t.b(this.a.n(var2)));
            this.a.b(var2, y.d.t.b(this.a.o(var2)));
            var10000 = this.a;
            if(var11 != 0) {
               break;
            }

            y.f.I var3 = var10000.g(var2);
            int var4 = 0;

            label37: {
               while(var4 < var3.pointCount()) {
                  y.d.t var5 = var3.getPoint(var4);
                  var3.setPoint(var4, var5.b, var5.a);
                  ++var4;
                  if(var11 != 0) {
                     break label37;
                  }

                  if(var11 != 0) {
                     break;
                  }
               }

               var1.g();
            }

            if(var11 == 0) {
               continue;
            }
         }

         var10000 = this.a;
         break;
      }

      y.c.x var12 = var10000.o();

      while(var12.f()) {
         y.c.q var13 = var12.e();
         double var14 = this.a.m(var13);
         double var15 = this.a.n(var13);
         double var7 = this.a.p(var13);
         double var9 = this.a.q(var13);
         this.a.b(var13, var9, var7);
         this.a.c(var13, var15, var14);
         var12.g();
         if(var11 != 0) {
            break;
         }
      }

   }

   private void k() {
      this.f.setFrame(this.f.getY(), this.f.getX(), this.f.getHeight(), this.f.getWidth());
   }

   public void a(byte var1) {
      this.b = var1;
   }

   public void a(double var1) {
      this.h = var1;
      this.i = true;
   }

   public void b(double var1) {
      if(Math.abs(var1) > 0.0D) {
         this.c = Math.abs(var1);
         if(v.f == 0) {
            return;
         }
      }

      this.c = 0.5D;
   }

   public void a(boolean var1) {
      this.d = var1;
   }

   public void b(boolean var1) {
      this.e = var1;
   }

   public y.c.D a() {
      return this.s;
   }

   public y.c.D b() {
      return this.t;
   }

   public y.c.c c() {
      return this.v;
   }

   public y.c.c d() {
      return this.w;
   }

   public y.c.c e() {
      return this.u;
   }

   public String f() {
      return "\n===Orthogonal Sweepline===\nNumber of obstacles (nodes) = " + this.a.f() + "\n" + "Number of additional obstacles (edge segments) = " + this.y + "\n" + "BoundingBox = " + this.f + "\n" + "Halo = " + this.c + "\n" + "Number of vertical sight patches = " + this.s.size() + "\n" + "Number of horizontal sight patches = " + this.t.size() + "\n" + "Number of sight patch intersections = " + this.z + "\n" + "===Orthogonal Sweepline===\n";
   }

   private void l() {
      if(!this.g) {
         int var1;
         label14: {
            this.f = this.m();
            if(this.i) {
               var1 = (int)this.h;
               if(v.f == 0) {
                  break label14;
               }
            }

            var1 = (int)(10.0D * this.c);
         }

         this.f.setFrame(this.f.getX() - (double)var1, this.f.getY() - (double)var1, this.f.getWidth() + (double)(2 * var1), this.f.getHeight() + (double)(2 * var1));
      }
   }

   private Rectangle2D m() {
      if(this.a.i()) {
         return new Double(0.0D, 0.0D, 0.0D, 0.0D);
      } else {
         Rectangle2D var1 = y.f.ae.a(this.a, this.q.a(), this.r.a());
         return new Double((double)((int)var1.getX()), (double)((int)var1.getY()), (double)((int)var1.getWidth()), (double)((int)var1.getHeight()));
      }
   }

   private void n() {
      this.o = new aC();
      this.p = new y.c.D();
      this.k = new ax(this, this.o);
      this.l = new ax(this, this.o);
      this.m = new y.c.D();
      this.n = new y.c.D();
   }

   private void o() {
      int var2 = v.f;
      this.x = new an();
      this.v = new aF();
      this.w = new au();
      y.c.x var1 = this.q.a();

      while(var1.f()) {
         this.w.a((y.c.q)var1.d(), new aJ());
         var1.g();
         if(var2 != 0) {
            break;
         }
      }

   }

   private void p() {
      int var2 = v.f;
      this.u = new aF();
      y.c.C var1 = this.t.m();

      while(true) {
         if(var1.f()) {
            this.u.a((ao)var1.d(), new y.c.D());
            var1.g();
            if(var2 != 0) {
               break;
            }

            if(var2 == 0) {
               continue;
            }
         }

         var1 = this.s.m();
         break;
      }

      while(var1.f()) {
         this.u.a((ao)var1.d(), new y.c.D());
         var1.g();
         if(var2 != 0) {
            break;
         }
      }

   }

   private void q() {
      y.c.D var2;
      int var7;
      label46: {
         var7 = v.f;
         if(this.A) {
            var2 = this.s;
            if(var7 == 0) {
               break label46;
            }
         }

         var2 = this.t;
      }

      y.c.C var1 = var2.m();

      y.c.x var3;
      aJ var8;
      while(true) {
         if(var1.f()) {
            ao var4 = (ao)var1.d();
            ag var5 = var4.o();
            aJ var6 = (aJ)this.x.b(var5);
            this.v.a(var4, var6);
            var1.g();
            if(var7 != 0) {
               break;
            }

            if(var7 == 0) {
               continue;
            }
         }

         if(this.A) {
            var3 = this.q.a();

            do {
               if(!var3.f()) {
                  return;
               }

               var8 = (aJ)this.w.b((y.c.q)var3.d());
               var8.a = this.a(var8.a);
               var8.b = this.a(var8.b);
               var8.c = this.a(var8.c);
               var8.d = this.a(var8.d);
               var3.g();
            } while(var7 == 0);
         }
         break;
      }

      var3 = this.q.a();

      while(var3.f()) {
         var8 = (aJ)this.w.b((y.c.q)var3.d());
         var8.e = this.a(var8.e);
         var8.f = this.a(var8.f);
         var8.g = this.a(var8.g);
         var8.h = this.a(var8.h);
         var3.g();
         if(var7 != 0) {
            break;
         }
      }

   }

   private y.c.D a(y.c.D var1) {
      int var7 = v.f;
      y.c.D var2 = new y.c.D();
      ao var3 = null;
      y.c.C var4 = var1.m();

      while(var4.f()) {
         ag var5 = (ag)var4.d();
         ao var6 = (ao)var5.f();
         if(var6 != var3 && var6 != null) {
            var2.add(var6);
         }

         var3 = var6;
         var4.g();
         if(var7 != 0) {
            break;
         }
      }

      return var2;
   }

   private void r() {
      int var6 = v.f;
      y.c.C var1;
      y.c.C var2;
      ao var3;
      y.c.D var4;
      al var5;
      if(this.A) {
         var1 = this.s.m();

         label55:
         do {
            if(!var1.f()) {
               return;
            }

            var3 = (ao)var1.d();
            var4 = ((al)var3).b;
            var2 = var4.m();

            while(var2.f()) {
               var5 = (al)var2.d();
               var5.a(false, (al)var3);
               var2.g();
               if(var6 != 0) {
                  continue label55;
               }

               if(var6 != 0) {
                  break;
               }
            }

            var1.g();
         } while(var6 == 0);
      }

      var1 = this.t.m();

      while(var1.f()) {
         var3 = (ao)var1.d();
         var4 = ((al)var3).b;
         var2 = var4.m();

         label34: {
            while(var2.f()) {
               var5 = (al)var2.d();
               var5.a(false, (al)var3);
               var2.g();
               if(var6 != 0) {
                  break label34;
               }

               if(var6 != 0) {
                  break;
               }
            }

            var1.g();
         }

         if(var6 != 0) {
            break;
         }
      }

   }

   private void s() {
      this.o = null;
      this.p = null;
      this.k = null;
      this.l = null;
      this.m = null;
      this.n = null;
   }

   public void g() {
      int var1 = v.f;
      this.l();
      this.o();
      if(this.e) {
         this.d = true;
      }

      if(this.b == 8) {
         this.t();
         this.u();
         this.p();
         this.h();
         if(var1 == 0) {
            return;
         }
      }

      if(this.b == 4) {
         this.u();
         if(var1 == 0) {
            return;
         }
      }

      this.t();
   }

   void h() {
      int var7 = v.f;
      y.c.D var1 = new y.c.D();
      y.c.C var2 = this.t.m();

      while(true) {
         if(var2.f()) {
            var1.add(new aA((ao)var2.d()));
            var2.g();
            if(var7 != 0) {
               break;
            }

            if(var7 == 0) {
               continue;
            }
         }

         var2 = this.s.m();
         break;
      }

      while(var2.f()) {
         var1.add(new aA((ao)var2.d()));
         var2.g();
         if(var7 != 0) {
            break;
         }
      }

      Double var8 = new Double();
      Double var3 = new Double();
      Double var4 = new Double();
      y.d.f.a(var1, new aw(this, var8, var3, var4));
   }

   private void t() {
      this.A = true;
      this.s = new y.c.D();
      this.x();
   }

   private void u() {
      this.A = false;
      this.t = new y.c.D();
      this.k();
      this.j();
      this.x();
      this.j();
      this.k();
   }

   private void v() {
      ++this.j;
      ag var1 = new ag(this.f.getX(), this.f.getY(), this.f.getY() + this.f.getHeight(), (byte)8, this.j);
      this.k.a(this.f.getY(), var1);
   }

   private void w() {
      int var9 = v.f;
      y.c.C var1 = this.k.a().m();

      while(var1.f()) {
         ag var2 = (ag)var1.d();
         double var3 = var2.a();
         double var5 = var2.b();
         ag var7 = (ag)this.k.b(var5, var2);
         ao var8 = this.a(var3, var5, this.f.getX() + this.f.getWidth() - var3, this.f.getY() + this.f.getHeight() - var5);
         var7.a(var8);
         var2.a(var8);
         var8.a(var7, var2);
         if(this.d) {
            ((al)var8).a(true, var7.a);
         }

         var1.g();
         if(var9 != 0) {
            break;
         }
      }

   }

   private void x() {
      int var6 = v.f;
      this.n();
      this.B();
      this.C();
      this.p.sort(new aB());
      y.c.D var1 = this.p;
      this.v();
      y.c.C var2 = var1.m();
      double var3 = ((ag)var2.d()).a();

      int var10000;
      while(true) {
         if(var2.f()) {
            ag var5 = (ag)var2.d();
            double var7;
            var10000 = (var7 = var5.a() - var3) == 0.0D?0:(var7 < 0.0D?-1:1);
            if(var6 != 0) {
               break;
            }

            if(var10000 > 0) {
               var3 = var5.a();
               this.y();
               this.z();
               this.m.clear();
               this.n.clear();
            }

            if(var5.d() == 8) {
               this.m.add(var5);
            }

            if(var5.d() == -8) {
               this.n.add(var5);
            }

            var2.g();
            if(var6 == 0) {
               continue;
            }
         }

         this.y();
         this.z();
         this.m.clear();
         this.n.clear();
         this.w();
         this.q();
         var10000 = this.d;
         break;
      }

      if(var10000 != 0) {
         this.r();
      }

      this.s();
   }

   private void y() {
      int var30 = v.f;
      if(!this.n.isEmpty()) {
         ag var3 = null;
         y.c.D var18 = null;
         if(this.d) {
            var18 = new y.c.D();
         }

         y.c.C var1 = this.n.m();

         y.c.C var2;
         ag var4;
         double var7;
         double var9;
         double var11;
         double var13;
         boolean var10000;
         double var31;
         label260:
         while(true) {
            var10000 = var1.f();

            label257:
            while(var10000) {
               var3 = (ag)var1.d();
               var7 = var3.b();
               var31 = var3.c();
               if(var30 != 0) {
                  break label260;
               }

               var9 = var31;
               var2 = this.k.a().m();
               boolean var17 = false;

               while(var2.f()) {
                  var10000 = var17;
                  if(var30 != 0) {
                     continue label257;
                  }

                  if(var17) {
                     break;
                  }

                  var4 = (ag)var2.d();
                  var11 = var4.b();
                  var13 = var4.c();
                  if(var13 >= var7) {
                     label250: {
                        if(var11 > var9) {
                           var17 = true;
                           if(var30 == 0) {
                              break label250;
                           }
                        }

                        ag var19 = (ag)this.k.b(var11, var4);
                        if(var3.a() > var4.a()) {
                           ao var20 = this.a(var4.a(), var11, var3.a() - var4.a(), var13 - var11);
                           if(var19.f() instanceof y.c.d) {
                              var20.n();
                           }

                           var19.a(var20);
                           var4.a(var20);
                           var20.a(var19, var4);
                           if(this.d) {
                              var18.add(var20);
                              ((al)var20).a(true, var19.a);
                           }
                        }
                     }
                  }

                  var2.g();
                  if(var30 != 0) {
                     break;
                  }
               }

               this.l.b(var3.b(), var3);
               var1.g();
               if(var30 == 0) {
                  continue label260;
               }
               break;
            }

            var31 = 0.0D;
            break;
         }

         double var32 = var31;
         double var21 = 0.0D;
         double var23 = var3.a();
         double var25 = this.f.getY();
         var1 = this.l.a().m();
         var2 = this.k.a().m();
         ag var5;
         y.c.C var34;
         if(var1.k() == 0) {
            ++this.j;
            var5 = new ag(var23, this.f.getY(), this.f.getY() + this.f.getHeight(), (byte)8, this.j);
            this.k.a(this.f.getY(), var5);
            if(this.d) {
               var34 = var18.m();

               while(var34.f()) {
                  var5.a(true, (ao)var34.d());
                  var34.g();
                  if(var30 != 0) {
                     return;
                  }

                  if(var30 != 0) {
                     break;
                  }
               }
            }

            this.A();
         } else if(var2.k() == 0) {
            var9 = 0.0D;

            while(true) {
               if(var1.f()) {
                  var3 = (ag)var1.d();
                  var7 = var3.b();
                  var9 = var3.c();
                  if(var30 != 0) {
                     break;
                  }

                  label152: {
                     label284: {
                        if(var7 <= var25) {
                           if(var9 <= var25) {
                              break label284;
                           }

                           var25 = var9;
                           if(var30 == 0) {
                              break label284;
                           }
                        }

                        ++this.j;
                        var5 = new ag(var23, var25, var7, (byte)8, this.j);
                        this.k.a(var25, var5);
                        if(this.d) {
                           var34 = var18.m();

                           while(var34.f()) {
                              var5.a(true, (ao)var34.d());
                              var34.g();
                              if(var30 != 0) {
                                 break label152;
                              }

                              if(var30 != 0) {
                                 break;
                              }
                           }
                        }

                        var25 = var9;
                     }

                     var1.g();
                  }

                  if(var30 == 0) {
                     continue;
                  }
               }

               ++this.j;
               break;
            }

            var5 = new ag(var23, var9, this.f.getY() + this.f.getHeight(), (byte)8, this.j);
            this.k.a(var9, var5);
            if(this.d) {
               var34 = var18.m();

               while(var34.f()) {
                  var5.a(true, (ao)var34.d());
                  var34.g();
                  if(var30 != 0) {
                     return;
                  }

                  if(var30 != 0) {
                     break;
                  }
               }
            }

            this.A();
         } else {
            av var33;
            label229:
            while(true) {
               if(var25 < this.f.getY() + this.f.getHeight()) {
                  boolean var27 = false;

                  label224: {
                     while(var1.f()) {
                        var10000 = var27;
                        if(var30 != 0) {
                           break label224;
                        }

                        if(var27) {
                           break;
                        }

                        label220: {
                           var3 = (ag)var1.d();
                           var7 = var3.b();
                           var9 = var3.c();
                           if(var7 <= var25) {
                              if(var9 <= var25) {
                                 break label220;
                              }

                              var25 = var9;
                              if(var30 == 0) {
                                 break label220;
                              }
                           }

                           var27 = true;
                           var32 = var25;
                           var21 = var7;
                           var25 = var9;
                        }

                        var1.g();
                        if(var30 != 0) {
                           break;
                        }
                     }

                     var10000 = var27;
                  }

                  if(!var10000) {
                     var32 = var25;
                     var21 = this.f.getY() + this.f.getHeight();
                     var25 = var21;
                  }

                  boolean var28 = false;

                  y.c.C var29;
                  label204: {
                     while(var2.f()) {
                        var10000 = var28;
                        if(var30 != 0) {
                           break label204;
                        }

                        if(var28) {
                           break;
                        }

                        label200: {
                           label199: {
                              var4 = (ag)var2.d();
                              var11 = var4.b();
                              var13 = var4.c();
                              if(var11 > var21) {
                                 ++this.j;
                                 var5 = new ag(var23, var32, var21, (byte)8, this.j);
                                 this.k.a(var32, var5);
                                 if(!this.d) {
                                    break label199;
                                 }

                                 var29 = var18.m();

                                 do {
                                    if(!var29.f()) {
                                       break label199;
                                    }

                                    var5.a(true, (ao)var29.d());
                                    var29.g();
                                    if(var30 != 0) {
                                       break label200;
                                    }
                                 } while(var30 == 0);
                              }

                              var2.g();
                           }

                           var28 = true;
                        }

                        if(var30 != 0) {
                           break;
                        }
                     }

                     var10000 = var28;
                  }

                  if(var10000) {
                     continue;
                  }

                  ++this.j;
                  var5 = new ag(var23, var32, var21, (byte)8, this.j);
                  this.k.a(var32, var5);
                  var33 = this;
                  if(var30 != 0) {
                     break;
                  }

                  if(!this.d) {
                     continue;
                  }

                  var29 = var18.m();

                  do {
                     if(!var29.f()) {
                        continue label229;
                     }

                     var5.a(true, (ao)var29.d());
                     var29.g();
                     if(var30 != 0) {
                        return;
                     }
                  } while(var30 == 0);
               }

               var33 = this;
               break;
            }

            var33.A();
         }
      }
   }

   private void z() {
      int var19 = v.f;
      if(!this.m.isEmpty()) {
         y.c.C var1 = this.m.m();

         while(true) {
            if(var1.f()) {
               ag var5 = (ag)var1.d();
               double var12 = var5.b();
               double var14 = var5.c();
               y.c.C var2 = this.k.a().m();
               if(var19 != 0) {
                  break;
               }

               boolean var3 = false;

               label112: {
                  while(var2.f()) {
                     if(var19 != 0) {
                        break label112;
                     }

                     if(var3) {
                        break;
                     }

                     label108: {
                        ag var4 = (ag)var2.d();
                        double var8 = var4.b();
                        double var10 = var4.c();
                        if(var10 >= var12) {
                           label123: {
                              if(var8 > var14) {
                                 var3 = true;
                                 if(var19 == 0) {
                                    break label123;
                                 }
                              }

                              ag var16 = (ag)this.k.b(var8, var4);
                              ag var6 = null;
                              if(var8 < var12) {
                                 ++this.j;
                                 var6 = new ag(var5.a(), var8, var12, (byte)8, this.j);
                                 this.k.a(var8, var6);
                              }

                              ag var7 = null;
                              if(var10 > var14) {
                                 ++this.j;
                                 var7 = new ag(var5.a(), var14, var10, (byte)8, this.j);
                                 this.k.a(var14, var7);
                              }

                              Object var17 = null;
                              if(var5.a() > var4.a()) {
                                 ao var18 = this.a(var4.a(), var8, var5.a() - var4.a(), var10 - var8);
                                 if(var16.f() instanceof y.c.d) {
                                    var18.n();
                                 }

                                 var16.a(var18);
                                 var4.a(var18);
                                 var18.a(var16, var4);
                                 if(!this.d) {
                                    break label123;
                                 }

                                 if(var6 != null) {
                                    var6.a(true, var18);
                                 }

                                 if(var7 != null) {
                                    var7.a(true, var18);
                                 }

                                 if(var17 != null) {
                                    ((ag)var17).a(true, var18);
                                 }

                                 ((al)var18).a(true, var16.a);
                                 if(var19 == 0) {
                                    break label123;
                                 }
                              }

                              if(this.d) {
                                 y.c.C var20;
                                 if(var6 != null) {
                                    var20 = var4.a.m();

                                    while(var20.f()) {
                                       var6.a(true, (ao)var20.d());
                                       var20.g();
                                       if(var19 != 0) {
                                          break label108;
                                       }

                                       if(var19 != 0) {
                                          break;
                                       }
                                    }
                                 }

                                 if(var7 != null) {
                                    var20 = var4.a.m();

                                    while(var20.f()) {
                                       var7.a(true, (ao)var20.d());
                                       var20.g();
                                       if(var19 != 0) {
                                          break label108;
                                       }

                                       if(var19 != 0) {
                                          break;
                                       }
                                    }
                                 }
                              }
                           }
                        }

                        var2.g();
                     }

                     if(var19 != 0) {
                        break;
                     }
                  }

                  this.l.a(var5.b(), var5);
               }

               var1.g();
               if(var19 == 0) {
                  continue;
               }
            }

            this.A();
            break;
         }

      }
   }

   private void A() {
      int var23 = v.f;
      y.c.C var1 = this.l.a().m();
      y.c.C var2 = this.k.a().m();
      if(var1.k() != 0) {
         if(var2.k() != 0) {
            y.c.D var16 = new y.c.D();
            var1.i();

            Object var10000;
            while(true) {
               if(var1.f()) {
                  ag var5 = (ag)var1.d();
                  var10000 = var5.f();
                  if(var23 != 0) {
                     break;
                  }

                  if(var10000 instanceof y.c.d) {
                     var16.add(var5);
                  }

                  var1.g();
                  if(var23 == 0) {
                     continue;
                  }
               }

               var1.i();
               var10000 = var2.d();
               break;
            }

            ag var17 = (ag)var10000;
            double var18 = var17.b();
            double var20 = var17.c();
            if(this.x.b(var17) == null) {
               this.x.a(var17, new aJ());
            }

            var2.g();

            while(true) {
               boolean var24 = var2.f();

               label151:
               while(true) {
                  ag var4;
                  double var10;
                  double var12;
                  if(var24) {
                     ag var3 = (ag)var2.d();
                     double var6 = var3.b();
                     double var8 = var3.c();
                     var10000 = this.x.b(var3);
                     if(var23 == 0) {
                        if(var10000 == null) {
                           this.x.a(var3, new aJ());
                        }

                        boolean var22 = false;

                        label117:
                        do {
                           do {
                              do {
                                 do {
                                    if(!var1.f()) {
                                       break label117;
                                    }

                                    var24 = var22;
                                    if(var23 != 0) {
                                       continue label151;
                                    }

                                    if(var22) {
                                       break label117;
                                    }

                                    var4 = (ag)var1.d();
                                    var10 = var4.b();
                                    var12 = var4.c();
                                    if(!(var4.f() instanceof y.c.d)) {
                                       break;
                                    }

                                    var1.g();
                                 } while(var23 == 0);

                                 if(var12 > var18) {
                                    break;
                                 }

                                 label98: {
                                    if(var12 == var18) {
                                       this.b(var4, var17, (byte)2);
                                       if(var23 == 0) {
                                          break label98;
                                       }
                                    }

                                    this.a(var16, var4, var17, (byte)2);
                                 }

                                 var1.g();
                              } while(var23 == 0);

                              if(var10 < var20 || var12 > var6) {
                                 break;
                              }

                              if(var10 == var20) {
                                 this.b(var4, var17, (byte)1);
                              }

                              if(var10 > var20) {
                                 this.a(var16, var4, var17, (byte)1);
                              }

                              if(var12 == var6) {
                                 this.b(var4, var3, (byte)2);
                              }

                              if(var12 < var6) {
                                 this.a(var16, var4, var3, (byte)2);
                              }

                              var1.g();
                           } while(var23 == 0);

                           var22 = true;
                        } while(var23 == 0);

                        var17 = var3;
                        var18 = var6;
                        var20 = var8;
                        var2.g();
                        if(var23 == 0) {
                           break;
                        }

                        if(!var1.f()) {
                           return;
                        }

                        var10000 = var1.d();
                     }
                  } else {
                     if(!var1.f()) {
                        return;
                     }

                     var10000 = var1.d();
                  }

                  while(true) {
                     var4 = (ag)var10000;
                     var10 = var4.b();
                     var12 = var4.c();
                     if(!(var4.f() instanceof y.c.d)) {
                        if(var10 >= var20) {
                           if(var10 == var20) {
                              this.b(var4, var17, (byte)1);
                              if(var23 != 0) {
                                 this.a(var16, var4, var17, (byte)1);
                              }
                           } else {
                              this.a(var16, var4, var17, (byte)1);
                           }
                        }

                        if(var12 <= var18) {
                           if(var12 == var18) {
                              this.b(var4, var17, (byte)2);
                              if(var23 != 0) {
                                 this.a(var16, var4, var17, (byte)2);
                              }
                           } else {
                              this.a(var16, var4, var17, (byte)2);
                           }
                        }
                     }

                     var1.g();
                     if(var23 != 0 || !var1.f()) {
                        return;
                     }

                     var10000 = var1.d();
                  }
               }
            }
         }
      }
   }

   private void a(y.c.D var1, ag var2, ag var3, byte var4) {
      boolean var10000;
      label57: {
         boolean var5;
         label60: {
            int var20 = v.f;
            var5 = false;
            double var6 = var2.b();
            double var8 = var2.c();
            double var10 = var3.b();
            double var12 = var3.c();
            y.c.C var14;
            ag var15;
            double var16;
            double var18;
            if(var4 == 2) {
               var14 = var1.m();

               do {
                  if(!var14.f()) {
                     break label60;
                  }

                  var10000 = var5;
                  if(var20 != 0) {
                     break label57;
                  }

                  if(var5) {
                     break label60;
                  }

                  var15 = (ag)var14.d();
                  var16 = var15.b();
                  var18 = var15.c();
                  if(var18 >= var8 && var18 <= var10) {
                     var5 = true;
                  }

                  var14.g();
               } while(var20 == 0);
            }

            var14 = var1.m();

            while(var14.f()) {
               var10000 = var5;
               if(var20 != 0) {
                  break label57;
               }

               if(var5) {
                  break;
               }

               var15 = (ag)var14.d();
               var16 = var15.b();
               var18 = var15.c();
               if(var16 <= var6 && var16 >= var12) {
                  var5 = true;
               }

               var14.g();
               if(var20 != 0) {
                  break;
               }
            }
         }

         var10000 = var5;
      }

      if(!var10000) {
         this.a(var2, var3, var4);
      }

   }

   private void B() {
      int var14 = v.f;
      y.c.c var1 = this.a.c(n.b);
      y.c.x var2 = this.q.a();

      while(var2.f()) {
         y.c.q var3 = var2.e();
         y.d.y var4 = this.a.s(var3);
         if(var1 != null && var1.d(var3)) {
            var4 = new y.d.y(this.a.j(var3) - 0.5D, this.a.k(var3) - 0.5D, 1.0D, 1.0D);
         }

         double var5 = var4.c();
         double var7 = var5 + var4.a();
         double var9 = var4.d();
         double var11 = var9 + var4.b();
         ++this.j;
         ag var13 = this.a(this.p, var5, var9, var11, this.j, var3);
         this.x.a(var13, new aJ());
         this.b(this.p, var7, var9, var11, this.j, var3);
         var2.g();
         if(var14 != 0) {
            break;
         }
      }

   }

   boolean a(y.c.q var1, y.d.t var2, y.d.t var3, y.c.c var4) {
      byte var5;
      int var13;
      label144: {
         var13 = v.f;
         var5 = 0;
         if(this.A) {
            if(var2.a == var3.a && var2.b < var3.b) {
               var5 = 2;
               if(var13 == 0) {
                  break label144;
               }
            }

            if(var2.a == var3.a && var2.b > var3.b) {
               var5 = 1;
               if(var13 == 0) {
                  break label144;
               }
            }

            if(var2.b == var3.b && var2.a < var3.a) {
               var5 = 4;
               if(var13 == 0) {
                  break label144;
               }
            }

            if(var2.b != var3.b || var2.a <= var3.a) {
               break label144;
            }

            var5 = 8;
            if(var13 == 0) {
               break label144;
            }
         }

         if(var2.a == var3.a && var2.b < var3.b) {
            var5 = 4;
            if(var13 == 0) {
               break label144;
            }
         }

         if(var2.a == var3.a && var2.b > var3.b) {
            var5 = 8;
            if(var13 == 0) {
               break label144;
            }
         }

         if(var2.b == var3.b && var2.a < var3.a) {
            var5 = 2;
            if(var13 == 0) {
               break label144;
            }
         }

         if(var2.b == var3.b && var2.a > var3.a) {
            var5 = 1;
         }
      }

      int var6 = y.f.ax.a(y.f.aE.a(var5)).a();
      y.c.c var7 = this.a.c(y.f.aF.a);
      y.c.c var8 = this.a.c(y.f.aF.b);
      y.c.e var9 = var1.j();

      boolean var10000;
      while(true) {
         if(var9.f()) {
            y.c.d var10 = var9.a();
            var10000 = var4.d(var10);
            if(var13 != 0) {
               break;
            }

            if(!var10000) {
               y.f.aE var11;
               y.d.t var12;
               if(var10.c() == var1) {
                  var11 = y.f.aE.d(this.a, var10);
                  if(var11 != null && var11.a() && (var11.g() || var11.b() == var5)) {
                     var12 = this.a.p(var10);
                     if(var2.a == var3.a && Math.abs(var2.a - var12.a) < 1.0D) {
                        return true;
                     }

                     if(var2.b == var3.b && Math.abs(var2.b - var12.b) < 1.0D) {
                        return true;
                     }
                  }
               }

               if(var10.d() == var1) {
                  var11 = y.f.aE.e(this.a, var10);
                  if(var11 != null && var11.a() && (var11.g() || var11.b() == var5)) {
                     var12 = this.a.q(var10);
                     if(var2.a == var3.a && Math.abs(var2.a - var12.a) < 1.0D) {
                        return true;
                     }

                     if(var2.b == var3.b && Math.abs(var2.b - var12.b) < 1.0D) {
                        return true;
                     }
                  }
               }

               if(this.a(var10, true, var6, var1, var2, var3)) {
                  return true;
               }

               if(this.a(var10, false, var6, var1, var2, var3)) {
                  return true;
               }
            }

            var9.g();
            if(var13 == 0) {
               continue;
            }
         }

         var10000 = false;
         break;
      }

      return var10000;
   }

   private boolean a(y.c.d var1, boolean var2, int var3, y.c.q var4, y.d.t var5, y.d.t var6) {
      int var11 = v.f;
      Collection var7 = ad.a(this.a, var1, var2);
      boolean var10000;
      if(var7 != null && !var7.isEmpty()) {
         Iterator var8 = var7.iterator();

         while(var8.hasNext()) {
            y.f.ax var9 = (y.f.ax)var8.next();
            if(var9.b()) {
               var10000 = var9.a(var3);
               if(var11 != 0) {
                  return var10000;
               }

               if(var10000) {
                  y.d.t var10 = y.d.t.b(this.a.l(var4), new y.d.t(var9.c(), var9.d()));
                  if(var5.a == var6.a && Math.abs(var5.a - var10.a) < 1.0D) {
                     return true;
                  }

                  if(var5.b == var6.b && Math.abs(var5.b - var10.b) < 1.0D) {
                     return true;
                  }
               }
            }
         }
      }

      var10000 = false;
      return var10000;
   }

   private void C() {
      int var22 = v.f;
      y.c.h var1 = y.g.M.b(new boolean[this.a.g()]);
      y.c.e var2 = this.r.a();

      Object var10000;
      while(true) {
         if(var2.f()) {
            var10000 = var1;
            if(var22 != 0) {
               break;
            }

            var1.a(var2.a(), true);
            var2.g();
            if(var22 == 0) {
               continue;
            }
         }

         var10000 = this.a.c(n.b);
         break;
      }

      Object var23 = var10000;
      y.c.e var3 = this.r.a();

      do {
         int var24 = var3.f();

         label67:
         while(true) {
            if(var24 == 0) {
               return;
            }

            y.c.d var4 = var3.a();
            double var5 = this.c;
            double var7 = this.c;
            if(var23 != null && ((y.c.c)var23).d(var4.c())) {
               var7 = 1.0D;
               var5 = 1.0D;
            }

            boolean var9 = true;
            boolean var10 = false;
            y.c.D var11 = this.a.m(var4);
            if(var11.isEmpty()) {
               break;
            }

            y.c.p var12 = var11.k();
            y.d.t var13 = (y.d.t)var12.c();
            int var14 = 0;
            var12 = var12.a();

            while(true) {
               if(var12 == null) {
                  break label67;
               }

               y.d.t var15 = (y.d.t)var12.c();
               double var25;
               var24 = (var25 = Math.abs(var13.a - var15.a) - 0.01D) == 0.0D?0:(var25 < 0.0D?-1:1);
               if(var22 != 0) {
                  break;
               }

               label62: {
                  if(var24 < 0) {
                     if(var14 == 0 && this.a(var4.c(), var13, var15, var1)) {
                        var13 = var15;
                        if(var22 == 0) {
                           break label62;
                        }
                     }

                     if(var14 == var11.size() - 2 && this.a(var4.d(), var15, var13, var1)) {
                        var13 = var15;
                        if(var22 == 0) {
                           break label62;
                        }
                     }

                     double var16 = Math.min(var13.b, var15.b);
                     double var18 = Math.max(var13.b, var15.b);
                     if(var14 == var11.size() - 3) {
                        y.d.t var20 = (y.d.t)var12.a().c();
                        if(this.a(var4.d(), var20, var15, var1)) {
                           var5 = -var5;
                           var5 = Math.max(var5, 0.5D * (var16 - var18));
                        }
                     }

                     ++this.j;
                     this.a(this.p, var13.a - var7, var16 - var5, var18 + var5, this.j, var4);
                     this.b(this.p, var13.a + var7, var16 - var5, var18 + var5, this.j, var4);
                     var10 = true;
                     ++this.y;
                  }

                  var9 = false;
                  var13 = var15;
               }

               var12 = var12.a();
               ++var14;
               if(var22 != 0) {
                  break label67;
               }
            }
         }

         var3.g();
      } while(var22 == 0);

   }

   private ag a(y.c.D var1, double var2, double var4, double var6, long var8, Object var10) {
      ag var11 = new ag(var2, var4, var6, (byte)8, var8);
      var11.a(var10);
      var1.add(var11);
      return var11;
   }

   private ag b(y.c.D var1, double var2, double var4, double var6, long var8, Object var10) {
      ag var11 = new ag(var2, var4, var6, (byte)-8, var8);
      var11.a(var10);
      var1.add(var11);
      return var11;
   }

   static aF a(av var0) {
      return var0.u;
   }

   static int b(av var0) {
      return var0.z++;
   }
}
