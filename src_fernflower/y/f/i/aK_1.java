package y.f.i;

import java.awt.geom.Rectangle2D.Double;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;
import y.f.i.aD;
import y.f.i.aE;
import y.f.i.aF;
import y.f.i.aH;
import y.f.i.aJ;
import y.f.i.aL;
import y.f.i.aM;
import y.f.i.aN;
import y.f.i.aO;
import y.f.i.aP;
import y.f.i.ae;
import y.f.i.ai;
import y.f.i.aj;
import y.f.i.ak;
import y.f.i.ao;
import y.f.i.aq;
import y.f.i.av;
import y.f.i.v;

class aK extends y.f.a {
   private y.f.X p;
   private aH q;
   private y.c.A r;
   private y.c.h s;
   private y.c.A t;
   private y.c.i u;
   private y.c.h v;
   private y.c.h w;
   private y.c.D x;
   private y.c.D y;
   private y.c.c z;
   private y.c.c A;
   private y.c.c B;
   private aF C;
   private y.c.A D;
   private y.c.A E;
   private y.c.D F;
   boolean a;
   boolean b;
   boolean c;
   y.d.t d;
   int e;
   int f;
   double g;
   byte h;
   Object i;
   Object n;
   Set o;

   aK() {
      this.i = y.f.ah.g_;
      this.n = y.f.ah.h_;
   }

   public void c(y.f.X var1) {
      int var4 = v.f;
      Object var2;
      y.c.c var3;
      if(this.h == 2) {
         var2 = this.n;
         var3 = var1.c(var2);
         if(var3 == null) {
            throw new IllegalStateException("No DataProvider " + var2 + " registered with graph!");
         }
      } else if(this.h == 4) {
         var2 = this.i;
         var3 = var1.c(var2);
         if(var3 == null) {
            throw new IllegalStateException("No DataProvider " + var2 + " registered with graph!");
         }
      }

      y.f.ah var5 = this.a();
      if(var5 != null) {
         var5.c(var1);
      }

      if(var1.h() != 0) {
         this.p = var1;
         this.w = var1.u();
         y.c.e var6 = var1.p();

         while(true) {
            if(var6.f()) {
               this.w.a(var6.a(), new ae(var6.a()));
               var6.g();
               if(var4 != 0) {
                  break;
               }

               if(var4 == 0) {
                  continue;
               }
            }

            this.g();
            this.u = new y.c.i();
            this.t = this.u.t();
            this.r = this.u.t();
            this.s = this.u.u();
            this.q = new aH();
            this.v = var1.u();
            this.b(var1);
            this.i();
            this.h();
            this.b();
            break;
         }

         switch(this.h) {
         case 4:
            this.e();
            if(var4 == 0) {
               break;
            }
         case 2:
            this.f();
            if(var4 == 0) {
               break;
            }
         case 0:
         case 1:
         case 3:
         default:
            this.c();
         }

         this.d();
         var1.a((y.c.h)this.v);
         var1.a((y.c.h)this.w);
         this.C = null;
         this.A = null;
         this.z = null;
         this.B = null;
         this.A = null;
         this.y = null;
         this.x = null;
         this.D = null;
      }
   }

   private void g() {
      int var9 = v.f;
      y.c.e var7 = this.p.p();

      while(var7.f()) {
         y.c.d var3 = var7.a();
         ae var6 = (ae)this.w.b(var3);
         y.f.aE var4 = y.f.aE.d(this.p, var3);
         y.f.aE var5 = y.f.aE.e(this.p, var3);
         if(var4 != null && var4.a()) {
            var6.b(true, true);
         }

         if(var5 != null && var5.a()) {
            var6.b(false, true);
         }

         label41: {
            boolean var8 = this.p.k(var3).size() == 0;
            if(var8 && var6.b(true) && !var6.b(false)) {
               var6.c(false, true);
               if(var9 == 0) {
                  break label41;
               }
            }

            if(var8 && !var6.b(true) && var6.b(false)) {
               var6.c(true, true);
            }
         }

         var7.g();
         if(var9 != 0) {
            break;
         }
      }

   }

   private void h() {
      int var12 = v.f;
      y.c.i var1 = new y.c.i();
      if(this.D != null) {
         var1.a(this.D);
      }

      this.D = var1.t();
      this.C = new aF();
      int var2 = 0;
      y.c.C var3 = this.y.m();

      ao var4;
      y.c.q var5;
      int var10000;
      while(true) {
         if(var3.f()) {
            ++var2;
            var4 = (ao)var3.d();
            double var13;
            var10000 = (var13 = var4.t() - var4.u()) == 0.0D?0:(var13 < 0.0D?-1:1);
            if(var12 != 0) {
               break;
            }

            if(var10000 != 0) {
               var5 = var1.d();
               this.C.a(var4, var5);
               this.D.a(var5, var4);
            }

            var3.g();
            if(var12 == 0) {
               continue;
            }
         }

         var10000 = 0;
         break;
      }

      var2 = var10000;
      var3 = this.x.m();

      do {
         var10000 = var3.f();

         label51:
         while(true) {
            if(var10000 == 0) {
               return;
            }

            ++var2;
            var4 = (ao)var3.d();
            if(var4.t() == var4.u()) {
               break;
            }

            var5 = var1.d();
            this.C.a(var4, var5);
            this.D.a(var5, var4);
            Double var6 = new Double(var4.k.a, var4.k.b, var4.l.a - var4.k.a, var4.l.b - var4.k.b);
            y.c.C var7 = ((y.c.D)this.B.b(var4)).m();
            boolean var8 = false;

            while(true) {
               if(!var7.f()) {
                  break label51;
               }

               ao var9 = (ao)var7.d();
               double var14;
               var10000 = (var14 = var9.t() - var9.u()) == 0.0D?0:(var14 < 0.0D?-1:1);
               if(var12 != 0) {
                  break;
               }

               if(var10000 != 0) {
                  Double var10 = new Double(var9.k.a, var9.k.b, var9.l.a - var9.k.a, var9.l.b - var9.k.b);
                  y.c.q var11 = (y.c.q)this.C.b(var9);
                  if(var11 != null && var6.intersects(var10)) {
                     var1.a(var5, (y.c.q)this.C.b(var9));
                  }
               }

               var7.g();
               if(var12 != 0) {
                  break label51;
               }
            }
         }

         var3.g();
      } while(var12 == 0);

   }

   private void i() {
      av var1;
      label11: {
         var1 = new av(this.p, new y.c.f());
         if(this.c) {
            var1.a((double)(5 * this.e));
            var1.b(0.5D);
            if(v.f == 0) {
               break label11;
            }
         }

         var1.b(this.g);
      }

      var1.b(true);
      var1.a((byte)8);
      var1.g();
      this.x = var1.a();
      this.y = var1.b();
      this.z = var1.c();
      this.A = var1.d();
      this.B = var1.e();
   }

   void b() {
      int var3 = v.f;
      y.c.e var1 = this.p.p();

      while(var1.f()) {
         y.c.d var2 = var1.a();
         if(!this.v.d(var2)) {
            this.a(var2);
         }

         var1.g();
         if(var3 != 0) {
            break;
         }
      }

   }

   private void a(y.c.d var1) {
      int var12 = v.f;
      y.d.s var6 = null;
      y.d.m var7 = null;
      y.d.m var8 = null;
      Object var9 = null;
      y.c.q var10 = var1.c();
      ae var11 = (ae)this.w.b(var1);
      if(var11 == null) {
         var11 = new ae(var1);
         this.w.a(var1, var11);
      }

      var6 = this.p.l(var1).j();
      var7 = var6.a();
      y.d.t var2 = var7.c();
      y.d.t var3 = var7.d();
      if(this.p.s(var10).a(var2) && this.p.s(var10).a(var3)) {
         this.v.a(var1, true);
      } else {
         ai var4 = this.a(var1, var2, var3, var10);
         if(var4 == null) {
            this.v.a(var1, true);
         } else {
            label43: {
               if(var4.x()) {
                  var4.a(var1, var2.a, var2.b, var3.b);
                  if(var12 == 0) {
                     break label43;
                  }
               }

               var4.a(var1, var2.b, var2.a, var3.a);
            }

            this.q.a(var7, var4);
            var11.a(var7);
            var6.g();

            while(var6.f()) {
               var8 = var6.a();
               var2 = var8.c();
               var3 = var8.d();
               ai var5 = this.a(var1, var2, var3, var4);
               if(var5 == null) {
                  this.v.a(var1, true);
                  return;
               }

               label34: {
                  if(var5.x()) {
                     var5.a(var1, var2.a, var2.b, var3.b);
                     if(var12 == 0) {
                        break label34;
                     }
                  }

                  var5.a(var1, var2.b, var2.a, var3.a);
               }

               this.q.a(var8, var5);
               var11.a(var8);
               var4 = var5;
               var6.g();
               if(var12 != 0) {
                  break;
               }
            }

         }
      }
   }

   private ai a(y.c.d var1, y.d.t var2, y.d.t var3, y.c.q var4) {
      int var15 = v.f;
      byte[] var5 = new byte[]{(byte)1, (byte)2, (byte)8, (byte)4};
      ai var6 = null;
      aJ var7 = (aJ)this.A.b(var4);
      int var8 = this.a(var4, var2, var3);
      if(var8 == -9) {
         return null;
      } else {
         y.c.D var9 = null;
         double var10 = 0.0D;
         switch(var5[var8]) {
         case 1:
            var9 = var7.a;
            var10 = var2.a;
            break;
         case 2:
            var9 = var7.c;
            var10 = var2.a;
         case 3:
         case 5:
         case 6:
         case 7:
         default:
            break;
         case 4:
            var9 = var7.g;
            var10 = var2.b;
            break;
         case 8:
            var9 = var7.e;
            var10 = var2.b;
         }

         boolean var12 = false;
         y.c.C var13 = var9.m();

         while(var13.f() && !var12) {
            ai var14 = (ai)var13.d();
            if(var10 >= var14.t() && var10 < var14.u()) {
               var12 = true;
               var6 = var14;
            }

            var13.g();
            if(var15 != 0) {
               break;
            }
         }

         return var6;
      }
   }

   private ai a(y.c.d var1, y.d.t var2, y.d.t var3, ai var4) {
      int var12 = v.f;
      ai var5 = null;
      y.c.q var6 = (y.c.q)this.C.b(var4);
      double var7 = var4.x()?var2.b:var2.a;
      boolean var9 = false;
      y.c.e var10 = var6.j();

      while(var10.f() && !var9) {
         ai var11 = (ai)this.D.b(var10.a().a(var6));
         if(var7 >= var11.t() && var7 < var11.u()) {
            var9 = true;
            var5 = var11;
         }

         var10.g();
         if(var12 != 0) {
            break;
         }
      }

      return var5;
   }

   private int a(y.c.q var1, y.d.t var2, y.d.t var3) {
      int var7 = v.f;
      int var4;
      double var5;
      if(Math.abs(var2.a - var3.a) < 0.01D) {
         var5 = this.p.n(var1) + this.p.q(var1) / 2.0D;
         var4 = var3.b <= var5?0:1;
         if(var7 == 0) {
            return var4;
         }
      }

      if(Math.abs(var2.b - var3.b) < 0.01D) {
         var5 = this.p.m(var1) + this.p.p(var1) / 2.0D;
         var4 = var3.a <= var5?2:3;
         if(var7 == 0) {
            return var4;
         }
      }

      var4 = -9;
      return var4;
   }

   void c() {
      int var7 = v.f;
      y.g.a.d var2 = new y.g.a.d(this.p);
      this.E = this.p.t();
      y.c.x var4 = this.p.o();

      y.c.q var1;
      int var3;
      aO var8;
      boolean var11;
      label172: {
         label171:
         while(true) {
            int var10000;
            if(var4.f()) {
               var1 = var4.e();
               aO var5 = new aO(this, var1, (y.c.c)null);
               this.E.a(var1, var5);
               var3 = var5.c().size();
               var10000 = var3;
               if(var7 == 0) {
                  if(var3 > 0) {
                     var2.a(var1, -var3);
                  }

                  var4.g();
                  if(var7 == 0) {
                     continue;
                  }

                  var10000 = var2.a();
               }
            } else {
               var10000 = var2.a();
            }

            while(true) {
               while(true) {
                  if(var10000 != 0) {
                     break label171;
                  }

                  var1 = var2.b();
                  var8 = (aO)this.E.b(var1);
                  this.a(var1, var8.c());
                  this.u.j();
                  var11 = var8.b();
                  if(var7 != 0) {
                     break label172;
                  }

                  if(var11) {
                     var3 = var8.c().size();
                     if(var3 > 0) {
                        var2.c(var1, -var3);
                        if(var7 == 0) {
                           var10000 = var2.a();
                           continue;
                        }
                     }

                     var2.c();
                     if(var7 != 0) {
                        var2.c();
                        if(var7 != 0) {
                           break label171;
                        }
                     }
                  } else {
                     var2.c();
                     if(var7 != 0) {
                        break label171;
                     }
                  }

                  var10000 = var2.a();
               }
            }
         }

         var11 = this.b;
      }

      if(var11) {
         var4 = this.p.o();

         label134:
         while(true) {
            Object var12;
            if(var4.f()) {
               var1 = var4.e();
               aJ var9 = (aJ)this.A.b(var1);
               var12 = var9.a.m();
               if(var7 == 0) {
                  Object var6 = var12;

                  label72: {
                     while(((y.c.C)var6).f()) {
                        ((ai)((y.c.C)var6).d()).c(false);
                        ((y.c.C)var6).g();
                        if(var7 != 0) {
                           break label72;
                        }

                        if(var7 != 0) {
                           break;
                        }
                     }

                     var6 = var9.c.m();
                  }

                  label82: {
                     while(((y.c.C)var6).f()) {
                        ((ai)((y.c.C)var6).d()).c(true);
                        ((y.c.C)var6).g();
                        if(var7 != 0) {
                           break label82;
                        }

                        if(var7 != 0) {
                           break;
                        }
                     }

                     var6 = var9.e.m();
                  }

                  label92: {
                     while(((y.c.C)var6).f()) {
                        ((ai)((y.c.C)var6).d()).c(false);
                        ((y.c.C)var6).g();
                        if(var7 != 0) {
                           break label92;
                        }

                        if(var7 != 0) {
                           break;
                        }
                     }

                     var6 = var9.g.m();
                  }

                  while(((y.c.C)var6).f()) {
                     ((ai)((y.c.C)var6).d()).c(true);
                     ((y.c.C)var6).g();
                     if(var7 != 0) {
                        continue label134;
                     }

                     if(var7 != 0) {
                        break;
                     }
                  }

                  aO var10 = (aO)this.E.b(var1);
                  var10.a();
                  var3 = var10.c().size();
                  if(var3 > 0) {
                     var2.a(var1, -var3);
                  }

                  var4.g();
                  if(var7 == 0) {
                     continue;
                  }

                  if(var2.a()) {
                     break;
                  }

                  var1 = var2.b();
                  var12 = this.E.b(var1);
               }
            } else {
               if(var2.a()) {
                  break;
               }

               var1 = var2.b();
               var12 = this.E.b(var1);
            }

            while(true) {
               var8 = (aO)var12;
               this.a(var1, var8.c());
               this.u.j();
               if(var7 != 0) {
                  return;
               }

               if(var8.b()) {
                  var3 = var8.c().size();
                  if(var3 > 0) {
                     var2.c(var1, -var3);
                     if(var7 != 0) {
                        var2.c();
                        if(var7 != 0) {
                           var2.c();
                           if(var7 != 0) {
                              break label134;
                           }
                        }
                     }
                  } else {
                     var2.c();
                     if(var7 != 0) {
                        var2.c();
                        if(var7 != 0) {
                           break label134;
                        }
                     }
                  }
               } else {
                  var2.c();
                  if(var7 != 0) {
                     break label134;
                  }
               }

               if(var2.a()) {
                  break label134;
               }

               var1 = var2.b();
               var12 = this.E.b(var1);
            }
         }
      }

      this.p.a((y.c.A)this.E);
      var2.f();
   }

   void b(y.f.X var1) {
      int var11 = v.f;
      this.o = new HashSet();
      y.c.e var2 = var1.p();

      while(var2.f()) {
         y.c.d var3 = var2.a();
         if(var3.e()) {
            y.c.D var4 = var1.m(var3);
            if(var4.size() >= 5) {
               y.c.D var5 = new y.c.D();
               var5.add(var4.g());
               var5.add(var4.g());
               var5.add(var4.f());
               y.c.q var6 = var1.d();
               var1.b(var6, 1.0D, 1.0D);
               var1.a(var6, (y.d.t)var4.f());
               y.c.d var7 = var1.a((y.c.q)var3.c(), (y.c.q)var6);
               ae var8 = new ae(var7);
               boolean var9 = ((ae)this.w.b(var3)).b(true);
               if(var9) {
                  var8.b(true, true);
               }

               boolean var10 = ((ae)this.w.b(var3)).b(false);
               if(var10) {
                  var8.b(false, true);
               }

               this.w.a(var7, var8);
               var1.a(var7, var5);
               var1.a(var3, var6, var3.d());
               var1.a(var3, var4);
               this.o.add(var6);
            }
         }

         var2.g();
         if(var11 != 0) {
            break;
         }
      }

   }

   void d() {
      int var7 = v.f;
      Iterator var1 = this.o.iterator();

      while(true) {
         if(var1.hasNext()) {
            y.c.q var2 = (y.c.q)var1.next();
            y.c.d var3 = var2.f();
            y.c.d var4 = var2.g();
            y.c.D var5 = this.p.m(var3);
            y.c.D var6 = this.p.m(var4);
            var6.j();
            var6.a(var5);
            this.p.a((y.c.d)var4);
            this.p.a(var3, var4.c(), var3.d());
            this.p.a((y.c.q)var2);
            this.p.a(var3, var6);
            if(var7 != 0) {
               break;
            }

            if(var7 == 0) {
               continue;
            }
         }

         this.o = null;
         break;
      }

   }

   void e() {
      int var8 = v.f;
      y.g.a.d var2 = new y.g.a.d(this.p);
      this.E = this.p.t();
      y.c.c var4 = this.p.c(this.i);
      y.c.x var5 = this.p.o();

      y.c.q var1;
      int var3;
      aO var9;
      boolean var10000;
      label171: {
         label170:
         while(true) {
            if(var5.f()) {
               var1 = var5.e();
               var10000 = var4.d(var1);
               if(var8 == 0) {
                  if(var10000) {
                     aO var6 = new aO(this, var1, (y.c.c)null);
                     this.E.a(var1, var6);
                     var3 = var6.c().size();
                     if(var3 > 0) {
                        var2.a(var1, -var3);
                     }
                  }

                  var5.g();
                  if(var8 == 0) {
                     continue;
                  }

                  var10000 = var2.a();
               }
            } else {
               var10000 = var2.a();
            }

            while(true) {
               while(true) {
                  if(var10000) {
                     break label170;
                  }

                  var1 = var2.b();
                  var9 = (aO)this.E.b(var1);
                  this.a(var1, var9.c());
                  this.u.j();
                  var10000 = var9.b();
                  if(var8 != 0) {
                     break label171;
                  }

                  if(var10000) {
                     var3 = var9.c().size();
                     if(var3 > 0) {
                        var2.c(var1, -var3);
                        if(var8 == 0) {
                           var10000 = var2.a();
                           continue;
                        }
                     }

                     var2.c();
                     if(var8 != 0) {
                        var2.c();
                        if(var8 != 0) {
                           break label170;
                        }
                     }
                  } else {
                     var2.c();
                     if(var8 != 0) {
                        break label170;
                     }
                  }

                  var10000 = var2.a();
               }
            }
         }

         var10000 = this.b;
      }

      if(var10000) {
         var5 = this.p.o();

         label133:
         while(true) {
            if(var5.f()) {
               var1 = var5.e();
               var10000 = var4.d(var1);
               if(var8 == 0) {
                  label107: {
                     if(var10000) {
                        aJ var10 = (aJ)this.A.b(var1);
                        y.c.C var7 = var10.a.m();

                        label76: {
                           while(var7.f()) {
                              ((ai)var7.d()).c(false);
                              var7.g();
                              if(var8 != 0) {
                                 break label76;
                              }

                              if(var8 != 0) {
                                 break;
                              }
                           }

                           var7 = var10.c.m();
                        }

                        label86: {
                           while(var7.f()) {
                              ((ai)var7.d()).c(true);
                              var7.g();
                              if(var8 != 0) {
                                 break label86;
                              }

                              if(var8 != 0) {
                                 break;
                              }
                           }

                           var7 = var10.e.m();
                        }

                        label96: {
                           while(var7.f()) {
                              ((ai)var7.d()).c(false);
                              var7.g();
                              if(var8 != 0) {
                                 break label96;
                              }

                              if(var8 != 0) {
                                 break;
                              }
                           }

                           var7 = var10.g.m();
                        }

                        while(var7.f()) {
                           ((ai)var7.d()).c(true);
                           var7.g();
                           if(var8 != 0) {
                              break label107;
                           }

                           if(var8 != 0) {
                              break;
                           }
                        }

                        aO var11 = (aO)this.E.b(var1);
                        var11.a();
                        var3 = var11.c().size();
                        if(var3 > 0) {
                           var2.a(var1, -var3);
                        }
                     }

                     var5.g();
                  }

                  if(var8 == 0) {
                     continue;
                  }

                  var10000 = var2.a();
               }
            } else {
               var10000 = var2.a();
            }

            while(true) {
               while(true) {
                  if(var10000) {
                     break label133;
                  }

                  var1 = var2.b();
                  var9 = (aO)this.E.b(var1);
                  this.a(var1, var9.c());
                  this.u.j();
                  if(var8 != 0) {
                     return;
                  }

                  if(var9.b()) {
                     var3 = var9.c().size();
                     if(var3 > 0) {
                        var2.c(var1, -var3);
                        if(var8 == 0) {
                           var10000 = var2.a();
                           continue;
                        }
                     }

                     var2.c();
                     if(var8 != 0) {
                        var2.c();
                        if(var8 != 0) {
                           break label133;
                        }
                     }
                  } else {
                     var2.c();
                     if(var8 != 0) {
                        break label133;
                     }
                  }

                  var10000 = var2.a();
               }
            }
         }
      }

      this.p.a((y.c.A)this.E);
      var2.f();
   }

   void f() {
      int var10 = v.f;
      y.c.y var1 = new y.c.y();
      y.c.c var2 = this.p.c(this.n);
      y.c.A var3 = this.p.t();
      y.c.x var4 = this.p.o();

      boolean var10000;
      label213:
      while(true) {
         var10000 = var4.f();

         label210:
         while(var10000) {
            y.c.q var5 = var4.e();
            if(var10 != 0) {
               break label213;
            }

            y.c.e var6 = var5.j();

            while(var6.f()) {
               y.c.d var7 = var6.a();
               var10000 = this.v.d(var7);
               if(var10 != 0) {
                  continue label210;
               }

               if(!var10000 && var2.d(var7) && !var3.d(var5)) {
                  var1.add(var5);
                  var3.a(var5, true);
                  if(var10 == 0) {
                     break;
                  }
               }

               var6.g();
               if(var10 != 0) {
                  break;
               }
            }

            var4.g();
            if(var10 == 0) {
               continue label213;
            }
            break;
         }

         this.p.a((y.c.A)var3);
         break;
      }

      y.g.a.d var12 = new y.g.a.d(this.p);
      this.E = this.p.t();
      y.c.x var14 = var1.a();

      y.c.q var11;
      int var13;
      aO var15;
      label186: {
         label185:
         while(true) {
            int var18;
            if(var14.f()) {
               var11 = var14.e();
               aO var8 = new aO(this, var11, var2);
               this.E.a(var11, var8);
               var13 = var8.c().size();
               var18 = var13;
               if(var10 == 0) {
                  if(var13 > 0) {
                     var12.a(var11, -var13);
                  }

                  var14.g();
                  if(var10 == 0) {
                     continue;
                  }

                  var18 = var12.a();
               }
            } else {
               var18 = var12.a();
            }

            while(true) {
               while(true) {
                  if(var18 != 0) {
                     break label185;
                  }

                  var11 = var12.b();
                  var15 = (aO)this.E.b(var11);
                  this.a(var11, var15.c());
                  this.u.j();
                  var10000 = var15.b();
                  if(var10 != 0) {
                     break label186;
                  }

                  if(var10000) {
                     var13 = var15.c().size();
                     if(var13 > 0) {
                        var12.c(var11, -var13);
                        if(var10 == 0) {
                           var18 = var12.a();
                           continue;
                        }
                     }

                     var12.c();
                     if(var10 != 0) {
                        var12.c();
                        if(var10 != 0) {
                           break label185;
                        }
                     }
                  } else {
                     var12.c();
                     if(var10 != 0) {
                        break label185;
                     }
                  }

                  var18 = var12.a();
               }
            }
         }

         var10000 = this.b;
      }

      if(var10000) {
         var14 = var1.a();

         label148:
         while(true) {
            Object var19;
            if(var14.f()) {
               var11 = var14.e();
               aJ var16 = (aJ)this.A.b(var11);
               var19 = var16.a.m();
               if(var10 == 0) {
                  Object var9 = var19;

                  label86: {
                     while(((y.c.C)var9).f()) {
                        ((ai)((y.c.C)var9).d()).c(false);
                        ((y.c.C)var9).g();
                        if(var10 != 0) {
                           break label86;
                        }

                        if(var10 != 0) {
                           break;
                        }
                     }

                     var9 = var16.c.m();
                  }

                  label96: {
                     while(((y.c.C)var9).f()) {
                        ((ai)((y.c.C)var9).d()).c(true);
                        ((y.c.C)var9).g();
                        if(var10 != 0) {
                           break label96;
                        }

                        if(var10 != 0) {
                           break;
                        }
                     }

                     var9 = var16.e.m();
                  }

                  label106: {
                     while(((y.c.C)var9).f()) {
                        ((ai)((y.c.C)var9).d()).c(false);
                        ((y.c.C)var9).g();
                        if(var10 != 0) {
                           break label106;
                        }

                        if(var10 != 0) {
                           break;
                        }
                     }

                     var9 = var16.g.m();
                  }

                  while(((y.c.C)var9).f()) {
                     ((ai)((y.c.C)var9).d()).c(true);
                     ((y.c.C)var9).g();
                     if(var10 != 0) {
                        continue label148;
                     }

                     if(var10 != 0) {
                        break;
                     }
                  }

                  aO var17 = (aO)this.E.b(var11);
                  var17.a();
                  var13 = var17.c().size();
                  if(var13 > 0) {
                     var12.a(var11, -var13);
                  }

                  var14.g();
                  if(var10 == 0) {
                     continue;
                  }

                  if(var12.a()) {
                     break;
                  }

                  var11 = var12.b();
                  var19 = this.E.b(var11);
               }
            } else {
               if(var12.a()) {
                  break;
               }

               var11 = var12.b();
               var19 = this.E.b(var11);
            }

            while(true) {
               var15 = (aO)var19;
               this.a(var11, var15.c());
               this.u.j();
               if(var10 != 0) {
                  return;
               }

               if(var15.b()) {
                  var13 = var15.c().size();
                  if(var13 > 0) {
                     var12.c(var11, -var13);
                     if(var10 != 0) {
                        var12.c();
                        if(var10 != 0) {
                           var12.c();
                           if(var10 != 0) {
                              break label148;
                           }
                        }
                     }
                  } else {
                     var12.c();
                     if(var10 != 0) {
                        var12.c();
                        if(var10 != 0) {
                           break label148;
                        }
                     }
                  }
               } else {
                  var12.c();
                  if(var10 != 0) {
                     break label148;
                  }
               }

               if(var12.a()) {
                  break label148;
               }

               var11 = var12.b();
               var19 = this.E.b(var11);
            }
         }
      }

      this.p.a((y.c.A)this.E);
      var12.f();
   }

   private void a(y.c.q var1, y.c.f var2) {
      int var30 = v.f;
      if(var2.size() >= 2) {
         aq var3 = new aq(this.p, var1);
         var2.sort(var3);
         aO var4 = (aO)this.E.b(var1);
         byte[] var5 = new byte[]{(byte)1, (byte)2, (byte)8, (byte)4};
         aJ var6 = (aJ)this.A.b(var1);
         y.c.D var7 = null;
         boolean var8 = false;
         switch(var5[var4.d()]) {
         case 1:
            var7 = var6.a;
            var8 = false;
            break;
         case 2:
            var7 = var6.c;
            var8 = true;
         case 3:
         case 5:
         case 6:
         case 7:
         default:
            break;
         case 4:
            var7 = var6.g;
            var8 = true;
            break;
         case 8:
            var7 = var6.e;
            var8 = false;
         }

         aD var9 = new aD(this.p.o(var1));
         var7.sort(var9);
         this.a(var7, var8);
         aF var10 = new aF();
         boolean var11 = false;
         aM var12 = null;
         y.c.C var13 = var7.m();

         while(var13.f()) {
            Object var10000 = var13.d();

            label159:
            while(true) {
               ai var14 = (ai)var10000;
               y.c.D var15 = var14.a(var8);
               if(var15 == null) {
                  break;
               }

               y.c.C var16 = var15.m();

               while(true) {
                  if(!var16.f()) {
                     break label159;
                  }

                  ak var17 = (ak)var16.d();
                  y.c.q var18 = this.u.d();
                  var17.c = var18;
                  var10000 = var12;
                  if(var30 != 0) {
                     break;
                  }

                  if(var12 != null) {
                     var12.b(var18);
                  }

                  aM var19 = new aM();
                  var19.a = true;
                  var19.a((Object)(new aP(var14, var17.a)));
                  var19.a(var17.b);
                  this.t.a(var18, var19);
                  if(var12 == null) {
                     var10.a(var14, var18);
                  }

                  var12 = var19;
                  var16.g();
                  if(var30 != 0) {
                     break label159;
                  }
               }
            }

            var13.g();
            if(var30 != 0) {
               break;
            }
         }

         var12 = null;
         y.c.e var31 = var2.a();

         while(var31.f()) {
            y.c.d var33 = var31.a();
            boolean var35 = var33.c() == var1;
            ae var37 = (ae)this.w.b(var33);
            if(!var37.b(var35) && !var37.d(var35) && !var37.c() && !this.v.d(var33)) {
               y.c.q var40 = this.u.d();
               var37.a(var40);
               if(var12 != null) {
                  var12.b(var40);
               }

               aM var42;
               y.c.C var44;
               label130: {
                  var42 = new aM();
                  var12 = var42;
                  var42.a = false;
                  var42.a((Object)var33);
                  this.t.a(var40, var42);
                  var44 = var37.b();
                  if(var35) {
                     var44.i();
                     if(var30 == 0) {
                        break label130;
                     }
                  }

                  var44.j();
               }

               ai var21;
               double var22;
               double var24;
               double var26;
               double var28;
               label124: {
                  y.d.m var20 = (y.d.m)var44.d();
                  var21 = (ai)this.q.b(var20);
                  var28 = var8?var21.v():var21.w();
                  if(var21.x()) {
                     var22 = Math.min(var20.c().b, var20.d().b);
                     var24 = Math.max(var20.c().b, var20.d().b);
                     var26 = var20.c().a;
                     if(var30 == 0) {
                        break label124;
                     }
                  }

                  var22 = Math.min(var20.c().a, var20.d().a);
                  var24 = Math.max(var20.c().a, var20.d().a);
                  var26 = var20.c().b;
               }

               label119: {
                  if(var8) {
                     var22 = var28;
                     if(var30 == 0) {
                        break label119;
                     }
                  }

                  var24 = var28;
               }

               label114: {
                  if(var44.k() == 1) {
                     aM.a(var42, var21.q());
                     if(var30 == 0) {
                        break label114;
                     }
                  }

                  aM.a(var42, var24 - var22);
               }

               this.a(var40, var21, aM.a(var42), var8, var26);
            }

            var31.g();
            if(var30 != 0) {
               break;
            }
         }

         var13 = null;
         y.c.x var34 = this.u.o();

         boolean var39;
         while(true) {
            if(var34.f()) {
               y.c.q var36 = var34.e();
               aM var38 = (aM)this.t.b(var36);
               var39 = var38.a;
               if(var30 != 0) {
                  break;
               }

               label99: {
                  if(!var39) {
                     y.c.D var32;
                     label96: {
                        y.c.d var41 = (y.c.d)var38.a();
                        if(this.p.m(var41).size() == 2) {
                           var32 = this.a(var1, var41, var7);
                           if(var30 == 0) {
                              break label96;
                           }
                        }

                        var32 = this.b(var1, var41, var7);
                     }

                     y.c.C var43 = var32.m();

                     while(var43.f()) {
                        ai var45 = (ai)var43.d();
                        this.a(var36, var45, aM.a(var38), var8);
                        var43.g();
                        if(var30 != 0) {
                           break label99;
                        }

                        if(var30 != 0) {
                           break;
                        }
                     }
                  }

                  var34.g();
               }

               if(var30 == 0) {
                  continue;
               }
            }

            var39 = this.u.i();
            break;
         }

         if(!var39) {
            this.a(var1, var2, var8);
         }

      }
   }

   private void a(y.c.q var1, y.c.f var2, boolean var3) {
      int var30 = v.f;
      aM var5 = null;
      this.F = new y.c.D();
      y.c.x var6 = this.u.o();
      aM var9 = (aM)this.t.b(var6.e());
      if(var9.a) {
         double var7 = ((aP)var9.a()).b;

         while(var6.f() && ((aM)this.t.b(var6.d())).a) {
            var6.g();
         }

         y.c.q var4;
         while(true) {
            if(var6.f()) {
               var4 = var6.e();
               var5 = (aM)this.t.b(var4);
               this.a(this.F, var5.c());
               var6.g();
               if(var30 != 0) {
                  break;
               }

               if(var30 == 0) {
                  continue;
               }
            }

            var6.i();
            break;
         }

         boolean var10 = false;

         y.c.q var14;
         aM var15;
         boolean var10000;
         label387:
         while(true) {
            var10000 = var6.f();

            label384:
            while(true) {
               if(!var10000 || var10) {
                  break label387;
               }

               var4 = var6.e();
               var5 = (aM)this.t.b(var4);
               if(!var5.a) {
                  break;
               }

               this.b(this.F, var5.c());
               boolean var11 = false;
               y.c.e var12 = var4.j();

               y.c.d var13;
               while(true) {
                  if(var12.f()) {
                     var10000 = var11;
                     if(var30 != 0) {
                        break;
                     }

                     if(!var11) {
                        var13 = var12.a();
                        var14 = var13.a(var4);
                        if(var14.a() == 1) {
                           var15 = (aM)this.t.b(var14);
                           this.a(this.F, var5.c(), var15.c());
                           this.s.a(var13, true);
                           this.r.a(var14, true);
                           var11 = true;
                        }

                        var12.g();
                        if(var30 == 0) {
                           continue;
                        }
                     }
                  }

                  var10000 = var11;
                  break;
               }

               if(var10000) {
                  var12 = var4.j();

                  while(var12.f()) {
                     var13 = var12.a();
                     var10000 = this.s.d(var13);
                     if(var30 != 0) {
                        continue label384;
                     }

                     if(!var10000) {
                        this.u.a(var13);
                     }

                     var12.g();
                     if(var30 != 0) {
                        break;
                     }
                  }

                  this.r.a(var4, true);
               }

               var6.g();
               if(var30 == 0) {
                  continue label387;
               }
               break;
            }

            var10 = true;
            if(var30 != 0) {
               break;
            }
         }

         double var31 = 0.0D;
         var31 = var7;
         y.c.y var32 = new y.c.y();
         var14 = null;
         var15 = null;
         y.c.d var16 = null;

         label348:
         while(true) {
            boolean var20;
            Object var35;
            if(var6.f()) {
               var4 = var6.e();
               var5 = (aM)this.t.b(var4);
               var10000 = this.r.d(var4);
               if(var30 == 0) {
                  if(!var10000) {
                     y.c.f var17 = new y.c.f();
                     aE var18 = new aE(var4, this.t);
                     y.c.f var19 = new y.c.f(var4.j());
                     var19.sort(var18);
                     var20 = false;
                     boolean var21 = false;
                     boolean var22 = false;
                     aL var23 = new aL(this);
                     var23.a(var4);
                     y.c.e var24 = var19.a();

                     y.c.d var25;
                     label413: {
                        while(true) {
                           if(var24.f()) {
                              var10000 = var21;
                              if(var30 != 0) {
                                 break;
                              }

                              if(!var21) {
                                 var25 = var24.a();
                                 var14 = var25.a(var4);
                                 var15 = (aM)this.t.b(var14);
                                 double var26 = ((aP)var15.a()).b;
                                 if(!this.r.d(var4) && this.b(this.F, var15.c(), var5.c())) {
                                    var17.add(var25);
                                 }

                                 var21 = var26 >= var31;
                                 if(var21 && var17.isEmpty()) {
                                    var21 = false;
                                 }

                                 var24.g();
                                 if(var30 == 0) {
                                    continue;
                                 }
                              }
                           }

                           var16 = null;
                           var10000 = var17.isEmpty();
                           break;
                        }

                        while(!var10000) {
                           var10000 = var20;
                           if(var30 != 0) {
                              break label413;
                           }

                           if(var20) {
                              break;
                           }

                           var16 = (y.c.d)var17.j();
                           var14 = var16.a(var4);
                           var20 = var23.b(var14);
                           var15 = (aM)this.t.b(var14);
                           var31 = Math.max(var31, ((aP)var15.a()).b);
                           if(var30 != 0) {
                              break;
                           }

                           var10000 = var17.isEmpty();
                        }

                        var20 = var16 != null;
                        var10000 = var20;
                     }

                     if(!var10000) {
                        return;
                     }

                     this.a(this.F, var15.c(), var5.c());
                     this.s.a(var16, true);
                     this.r.a(var4, true);
                     this.r.a(var14, true);
                     var24 = var14.j();

                     while(true) {
                        if(!var24.f()) {
                           var6.g();
                           if(var30 == 0) {
                              continue label348;
                           }

                           var6.i();
                           if(!var6.f()) {
                              return;
                           }

                           var4 = var6.e();
                           var35 = this.t.b(var4);
                           break;
                        }

                        var25 = var24.a();
                        var35 = var25;
                        if(var30 != 0) {
                           break;
                        }

                        if(var25 != var16) {
                           y.c.q var43 = var25.a(var14);
                           this.u.a(var25);
                           if(!this.r.d(var43) && var43.a() == 1) {
                              var32.add(var43);
                              this.a(var32);
                           }
                        }

                        var24.g();
                        if(var30 != 0) {
                           var14 = var4.j().a().a(var4);
                           var15 = (aM)this.t.b(var14);
                           var31 = Math.max(var31, ((aP)var15.a()).b);
                           var6.g();
                           if(var30 == 0) {
                              continue label348;
                           }

                           var6.i();
                           if(!var6.f()) {
                              return;
                           }

                           var4 = var6.e();
                           var35 = this.t.b(var4);
                           break;
                        }
                     }
                  } else {
                     var14 = var4.j().a().a(var4);
                     var15 = (aM)this.t.b(var14);
                     var31 = Math.max(var31, ((aP)var15.a()).b);
                     var6.g();
                     if(var30 == 0) {
                        continue;
                     }

                     var6.i();
                     if(!var6.f()) {
                        break;
                     }

                     var4 = var6.e();
                     var35 = this.t.b(var4);
                  }
               } else {
                  if(!var10000) {
                     break;
                  }

                  var4 = var6.e();
                  var35 = this.t.b(var4);
               }
            } else {
               var6.i();
               if(!var6.f()) {
                  break;
               }

               var4 = var6.e();
               var35 = this.t.b(var4);
            }

            while(true) {
               while(true) {
                  var5 = (aM)var35;
                  var16 = null;
                  if(var5.a) {
                     ai var33 = ((aP)var5.a()).a;
                     double var34 = ((aP)var5.a()).b;
                     var20 = false;
                     y.c.e var36 = var4.j();

                     while(true) {
                        if(!var36.f()) {
                           var10000 = var20;
                           break;
                        }

                        var10000 = var20;
                        if(var30 != 0) {
                           break;
                        }

                        if(var20) {
                           var10000 = var20;
                           break;
                        }

                        y.c.d var38 = var36.a();
                        if(this.s.d(var38)) {
                           var16 = var38;
                           var20 = true;
                        }

                        var36.g();
                        if(var30 != 0) {
                           var10000 = var20;
                           break;
                        }
                     }

                     if(var10000) {
                        var14 = var16.a(var4);
                        var15 = (aM)this.t.b(var14);
                        y.c.d var37 = (y.c.d)var15.a();
                        ae var39 = (ae)this.w.b(var37);
                        y.c.C var40 = var39.b();
                        boolean var41 = var1 == var37.c();
                        if(var41) {
                           var40.i();
                           if(var30 != 0) {
                              var40.j();
                           }
                        } else {
                           var40.j();
                        }

                        ai var42 = (ai)this.q.b(var40.d());
                        aj var44 = var42.a(var37, var3);
                        if(var33 != var42) {
                           if(var44 != null) {
                              var42.a(var44);
                              var33.a(var37, var34, var44.c, var44.d);
                              this.a(var37, var41, var34, var33);
                              if(var30 != 0 && var44 != null && var34 != var44.b) {
                                 var33.a(var44, var34);
                                 this.a(var37, var41, var34, (ai)null);
                              }
                           } else if(var44 != null && var34 != var44.b) {
                              var33.a(var44, var34);
                              this.a(var37, var41, var34, (ai)null);
                           }
                        } else if(var44 != null && var34 != var44.b) {
                           var33.a(var44, var34);
                           this.a(var37, var41, var34, (ai)null);
                        }

                        y.d.m var27;
                        ai var28;
                        aj var29;
                        if(var40.k() == 1) {
                           var39.f(true);
                           if(var30 != 0) {
                              this.b(var37);
                              var40 = var39.b();
                              if(var41) {
                                 var40.i();
                                 var40.g();
                                 if(var30 != 0) {
                                    var40.j();
                                    var40.h();
                                 }
                              } else {
                                 var40.j();
                                 var40.h();
                              }

                              var27 = (y.d.m)var40.d();
                              var28 = (ai)this.q.b(var27);
                              var29 = var28.a(var37);
                              var28.a(var29, var27.c(), var27.d());
                              var6.g();
                              if(var30 != 0) {
                                 return;
                              }

                              var10000 = var6.f();
                           } else {
                              var6.g();
                              if(var30 != 0) {
                                 return;
                              }

                              var10000 = var6.f();
                           }
                        } else {
                           this.b(var37);
                           var40 = var39.b();
                           if(var41) {
                              var40.i();
                              var40.g();
                              if(var30 != 0) {
                                 var40.j();
                                 var40.h();
                              }
                           } else {
                              var40.j();
                              var40.h();
                           }

                           var27 = (y.d.m)var40.d();
                           var28 = (ai)this.q.b(var27);
                           var29 = var28.a(var37);
                           var28.a(var29, var27.c(), var27.d());
                           var6.g();
                           if(var30 != 0) {
                              return;
                           }

                           var10000 = var6.f();
                        }
                     } else {
                        var6.g();
                        if(var30 != 0) {
                           return;
                        }

                        var10000 = var6.f();
                     }

                     if(!var10000) {
                        return;
                     }

                     var4 = var6.e();
                     var35 = this.t.b(var4);
                  } else {
                     var6.g();
                     if(var30 != 0 || !var6.f()) {
                        return;
                     }

                     var4 = var6.e();
                     var35 = this.t.b(var4);
                  }
               }
            }
         }

      }
   }

   private void b(y.c.d var1) {
      int var9 = v.f;
      ae var2 = (ae)this.w.b(var1);
      y.d.s var3 = this.p.l(var1).j();
      y.c.C var4 = var2.b();
      y.c.D var5 = new y.c.D();

      while(true) {
         if(var4.f()) {
            y.d.m var6 = (y.d.m)var4.d();
            y.d.m var7 = (y.d.m)var3.d();
            ai var8 = (ai)this.q.b(var6);
            this.q.a(var6, (Object)null);
            this.q.a(var7, var8);
            var5.add(var7);
            var4.g();
            var3.g();
            if(var9 != 0) {
               break;
            }

            if(var9 == 0) {
               continue;
            }
         }

         var2.a(var5);
         break;
      }

   }

   private void a(y.c.d var1, boolean var2, double var3, ai var5) {
      ae var6;
      y.c.C var7;
      label39: {
         var6 = (ae)this.w.b(var1);
         var7 = var6.b();
         if(var2) {
            var7.i();
            if(v.f == 0) {
               break label39;
            }
         }

         var7.j();
      }

      y.d.m var8 = (y.d.m)var7.d();
      ai var9 = (ai)this.q.b(var8);
      y.f.I var10 = this.p.g(var1);
      y.d.t var11 = null;
      y.d.t var12 = null;
      if(var2) {
         if(var9.x()) {
            var11 = new y.d.t(var3, this.p.p(var1).b);
            this.p.c(var1, var11);
            if(var10.pointCount() > 0) {
               var12 = new y.d.t(var3, var10.getPoint(0).b);
               var10.setPoint(0, var12.a, var12.b);
            } else {
               var12 = new y.d.t(var3, this.p.q(var1).b);
               this.p.d(var1, var12);
            }
         } else {
            var11 = new y.d.t(this.p.p(var1).a, var3);
            this.p.c(var1, var11);
            if(var10.pointCount() > 0) {
               var12 = new y.d.t(var10.getPoint(0).a, var3);
               var10.setPoint(0, var12.a, var12.b);
            } else {
               var12 = new y.d.t(this.p.q(var1).a, var3);
               this.p.d(var1, var12);
            }
         }
      } else if(var9.x()) {
         var11 = new y.d.t(var3, this.p.q(var1).b);
         this.p.d(var1, var11);
         if(var10.pointCount() > 0) {
            var12 = new y.d.t(var3, var10.getPoint(var10.pointCount() - 1).b);
            var10.setPoint(var10.pointCount() - 1, var12.a, var12.b);
         } else {
            var12 = new y.d.t(var3, this.p.p(var1).b);
            this.p.c(var1, var12);
         }
      } else {
         var11 = new y.d.t(this.p.q(var1).a, var3);
         this.p.d(var1, var11);
         if(var10.pointCount() > 0) {
            var12 = new y.d.t(var10.getPoint(var10.pointCount() - 1).a, var3);
            var10.setPoint(var10.pointCount() - 1, var12.a, var12.b);
         } else {
            var12 = new y.d.t(this.p.p(var1).a, var3);
            this.p.c(var1, var12);
         }
      }

      y.d.m var13 = new y.d.m(var11, var12);
      this.q.a(var8, (Object)null);
      this.q.a(var13, var5 != null?var5:var9);
      var6.a(var2, var13);
   }

   private y.c.D a(y.c.q var1, y.c.d var2, y.c.D var3) {
      int var20 = v.f;
      y.c.D var4 = new y.c.D();
      ae var5 = (ae)this.w.b(var2);
      y.c.C var6 = var5.b();
      var6.i();
      ao var7 = (ao)this.q.b(var6.d());
      double var8 = var7.q();
      aJ var10 = (aJ)this.z.b(var7);
      y.c.q var11 = null;
      y.c.q var12 = null;
      y.c.D var13 = var7.x()?var10.a:var10.e;
      y.c.D var14 = var7.x()?var10.c:var10.g;
      if(!var13.isEmpty() && !var14.isEmpty()) {
         var11 = (y.c.q)var13.f();
         var12 = (y.c.q)var14.f();
         y.c.C var15 = var3.m();

         while(var15.f()) {
            ao var16 = (ao)var15.d();
            if(var16 != var7 && var16.q() == var8) {
               y.c.q var18;
               y.c.q var19;
               label36: {
                  aJ var17 = (aJ)this.z.b(var16);
                  if(var7.x()) {
                     var18 = (y.c.q)var17.a.f();
                     var19 = (y.c.q)var17.c.f();
                     if(var20 == 0) {
                        break label36;
                     }
                  }

                  var18 = (y.c.q)var17.e.f();
                  var19 = (y.c.q)var17.g.f();
               }

               if(var11 == var18 && var12 == var19) {
                  var4.add(var16);
               }
            }

            var15.g();
            if(var20 != 0) {
               break;
            }
         }

         return var4;
      } else {
         return var4;
      }
   }

   private y.c.D b(y.c.q var1, y.c.d var2, y.c.D var3) {
      y.c.D var4;
      y.d.m var8;
      ao var9;
      int var16;
      label48: {
         var16 = v.f;
         var4 = new y.c.D();
         ae var5 = (ae)this.w.b(var2);
         y.c.C var6 = var5.b();
         boolean var7 = var1 == var2.c();
         if(var7) {
            var6.i();
            var9 = (ao)this.q.b(var6.d());
            var6.g();
            var8 = (y.d.m)var6.d();
            if(var16 == 0) {
               break label48;
            }
         }

         var6.j();
         var9 = (ao)this.q.b(var6.d());
         var6.h();
         var8 = (y.d.m)var6.d();
      }

      ao var10 = (ao)this.q.b(var8);
      y.c.q var11 = (y.c.q)this.C.b(var10);
      y.c.C var12 = var3.m();

      while(var12.f()) {
         Object var10000 = var12.d();

         label39:
         while(true) {
            ao var13 = (ao)var10000;
            if(var13 == var9) {
               break;
            }

            y.c.q var14 = (y.c.q)this.C.b(var13);
            y.c.x var15 = var14.m();

            while(true) {
               if(!var15.f()) {
                  break label39;
               }

               var10000 = var15.e();
               if(var16 != 0) {
                  break;
               }

               if(var10000 == var11) {
                  var4.add(var13);
               }

               var15.g();
               if(var16 != 0) {
                  break label39;
               }
            }
         }

         var12.g();
         if(var16 != 0) {
            break;
         }
      }

      return var4;
   }

   private void a(y.c.D var1, boolean var2) {
      int var5 = v.f;
      if(!var1.isEmpty()) {
         y.c.C var3 = var1.m();

         while(var3.f()) {
            ai var4 = (ai)var3.d();
            this.a(var4, var2);
            this.a(var4);
            var3.g();
            if(var5 != 0) {
               break;
            }
         }

      }
   }

   private void a(ai var1) {
      int var7 = v.f;
      var1.e();
      y.c.q var2 = (y.c.q)this.C.b(var1);
      y.c.x var3 = var2.m();

      do {
         int var10000 = var3.f();

         label37:
         while(true) {
            if(var10000 == 0) {
               return;
            }

            ai var4 = (ai)this.D.b(var3.e());
            if(var4 == null) {
               break;
            }

            y.c.C var5 = var4.a();
            if(var5 == null) {
               break;
            }

            while(true) {
               if(!var5.f()) {
                  break label37;
               }

               aj var6 = (aj)var5.d();
               double var8;
               var10000 = (var8 = var6.d - var1.t()) == 0.0D?0:(var8 < 0.0D?-1:1);
               if(var7 != 0) {
                  break;
               }

               if(var10000 > 0 && var6.c < var1.u()) {
                  var1.b(var6);
               }

               var5.g();
               if(var7 != 0) {
                  break label37;
               }
            }
         }

         var3.g();
      } while(var7 == 0);

   }

   private void a(ai var1, boolean var2) {
      y.c.D var4;
      int var33;
      label340: {
         var33 = v.f;
         aJ var3 = (aJ)this.z.b(var1);
         if(var1.x()) {
            var4 = var2?var3.a:var3.c;
            if(var33 == 0) {
               break label340;
            }
         }

         var4 = var2?var3.e:var3.g;
      }

      y.c.q var5 = null;
      if(!var4.isEmpty()) {
         var5 = (y.c.q)var4.f();
         y.c.C var6 = var1.a();
         double var8;
         double var12;
         int var10000;
         double var20;
         double var36;
         double var45;
         if(var6 != null && var6.k() > 0) {
            boolean var7 = var1.d();
            var1.b(true);
            var8 = ((aj)var6.d()).b;
            if(this.a) {
               label359: {
                  y.c.D var10;
                  if(this.c) {
                     var10 = this.a(var1.t(), var8 - 1.0D, var1.x());
                     if(var10 == null) {
                        break label359;
                     }

                     y.c.C var11 = var10.m();

                     do {
                        if(!var11.f()) {
                           break label359;
                        }

                        var12 = ((java.lang.Double)var11.d()).doubleValue();
                        var1.a(var12, var1.q(), var2);
                        var11.g();
                        if(var33 != 0) {
                           return;
                        }
                     } while(var33 == 0);
                  }

                  var10 = var1.b;
                  double var37 = var1.t() - this.g;
                  double var13 = var37 - 1.0D;
                  y.c.C var15 = var10.m();

                  while(true) {
                     if(var15.f()) {
                        ai var16 = (ai)var15.d();
                        double var17 = var16.b();
                        var10000 = java.lang.Double.isNaN(var17);
                        if(var33 != 0) {
                           break;
                        }

                        if(var10000 == 0) {
                           var13 = Math.max(var37, var17);
                        }

                        var15.g();
                        if(var33 == 0) {
                           continue;
                        }
                     }

                     double var55;
                     var10000 = (var55 = var13 - var37) == 0.0D?0:(var55 < 0.0D?-1:1);
                     break;
                  }

                  double var40;
                  if(var10000 > 0) {
                     var40 = var13 + 2.0D * this.g;
                  } else {
                     var40 = var1.t() + this.g;
                  }

                  int var42 = (int)Math.floor((var8 - var40) / (2.0D * this.g));
                  if(var42 > 0) {
                     int var18 = 1;

                     while(var18 <= var42) {
                        var1.a(var8 - (double)(var18 * 2) * this.g, var1.q(), var2);
                        ++var18;
                        if(var33 != 0) {
                           return;
                        }

                        if(var33 != 0) {
                           break;
                        }
                     }
                  }
               }
            }

            var36 = 0.0D;
            var12 = 0.0D;
            aj var41 = null;
            Object var43 = null;
            --var8;
            var45 = 0.0D;
            var20 = 0.0D;
            int var22 = 0;
            boolean var23 = true;

            ak var24;
            label291: {
               while(var6.f()) {
                  var41 = (aj)var6.d();
                  double var56;
                  var10000 = (var56 = var41.b - var8) == 0.0D?0:(var56 < 0.0D?-1:1);
                  if(var33 != 0) {
                     break label291;
                  }

                  if(var10000 > 0) {
                     if(!var23 && var22 == 0) {
                        var24 = var1.a(var8, var20 - var45, var2);
                        var24.d = true;
                     }

                     var8 = var41.b;
                     var45 = var1.v();
                     var20 = var1.w();
                     var22 = 0;
                     var23 = false;
                  }

                  if(var22 == 0) {
                     label348: {
                        boolean var25;
                        ae var48;
                        double var49;
                        if(var2) {
                           if(var41.c == var1.v()) {
                              var48 = (ae)this.w.b(var41.a);
                              var25 = var41.a.c() == var5;
                              var22 = !var48.b(var25) && !var48.d(var25)?0:1;
                              var22 |= var41.d == var1.w() && var48.c()?1:0;
                              if(var33 == 0) {
                                 break label348;
                              }
                           }

                           var49 = var41.c;
                           var49 -= this.c?(double)this.e:2.0D * this.g;
                           var20 = Math.min(var20, var49);
                           var22 = 1;
                           if(var33 == 0) {
                              break label348;
                           }
                        }

                        if(var41.d == var1.w()) {
                           var48 = (ae)this.w.b(var41.a);
                           var25 = var41.a.c() == var5;
                           var22 = !var48.b(var25) && !var48.d(var25)?0:1;
                           var22 |= var41.c == var1.v() && var48.c()?1:0;
                           if(var33 == 0) {
                              break label348;
                           }
                        }

                        var49 = var41.d;
                        var49 += this.c?(double)this.e:2.0D * this.g;
                        var45 = Math.max(var45, var49);
                        var22 = 1;
                     }
                  }

                  var6.g();
                  if(var33 != 0) {
                     break;
                  }
               }

               var10000 = var22;
            }

            if(var10000 == 0) {
               var24 = var1.a(var8, var20 - var45, var2);
               var24.d = true;
            }

            if(!this.a) {
               return;
            }

            y.c.D var52;
            if(this.c) {
               var52 = this.a(var41.b + 1.0D, var1.u(), var1.x());
               if(var52 == null) {
                  return;
               }

               y.c.C var50 = var52.m();

               do {
                  if(!var50.f()) {
                     return;
                  }

                  double var26 = ((java.lang.Double)var50.d()).doubleValue();
                  var1.a(var26, var1.q(), var2);
                  var50.g();
               } while(var33 == 0);
            }

            var52 = var1.c;
            double var51 = var1.u() + this.g;
            double var27 = var51 + 1.0D;
            y.c.C var29 = var52.m();

            label232: {
               while(var29.f()) {
                  ai var30 = (ai)var29.d();
                  double var31 = var30.c();
                  var10000 = java.lang.Double.isNaN(var31);
                  if(var33 != 0) {
                     break label232;
                  }

                  if(var10000 == 0) {
                     var27 = Math.min(var51, var31);
                  }

                  var29.g();
                  if(var33 != 0) {
                     break;
                  }
               }

               double var57;
               var10000 = (var57 = var27 - var51) == 0.0D?0:(var57 < 0.0D?-1:1);
            }

            double var53;
            if(var10000 < 0) {
               var53 = var27 - 2.0D * this.g;
            } else {
               var53 = var1.u() - this.g;
            }

            int var54 = (int)Math.floor((var53 - var41.b) / (2.0D * this.g));
            if(var54 <= 0) {
               return;
            }

            int var32 = 1;

            do {
               if(var32 > var54) {
                  return;
               }

               var1.a(var41.b + (double)(var32 * 2) * this.g, var1.q(), var2);
               ++var32;
            } while(var33 == 0);
         }

         if(this.a) {
            y.c.D var34;
            if(this.c) {
               var34 = this.a((ao)var1);
               if(var34 == null) {
                  return;
               }

               y.c.C var35 = var34.m();

               do {
                  if(!var35.f()) {
                     return;
                  }

                  double var9 = ((java.lang.Double)var35.d()).doubleValue();
                  var1.a(var9, var1.q(), var2);
                  var35.g();
               } while(var33 == 0);
            }

            var34 = var1.b;
            var8 = var1.t() - this.g;
            var36 = var8 - 1.0D;
            y.c.C var38 = var34.m();

            double var14;
            label191: {
               while(var38.f()) {
                  ai var39 = (ai)var38.d();
                  var14 = var39.b();
                  var10000 = java.lang.Double.isNaN(var14);
                  if(var33 != 0) {
                     break label191;
                  }

                  if(var10000 == 0) {
                     var36 = Math.max(var8, var14);
                  }

                  var38.g();
                  if(var33 != 0) {
                     break;
                  }
               }

               double var58;
               var10000 = (var58 = var36 - var8) == 0.0D?0:(var58 < 0.0D?-1:1);
            }

            if(var10000 > 0) {
               var12 = var36 + 2.0D * this.g;
            } else {
               var12 = var1.t() + this.g;
            }

            var34 = var1.c;
            var14 = var1.u() + this.g;
            double var44 = var14 + 1.0D;
            y.c.C var46 = var34.m();

            label179: {
               while(var46.f()) {
                  ai var19 = (ai)var46.d();
                  var20 = var19.c();
                  var10000 = java.lang.Double.isNaN(var20);
                  if(var33 != 0) {
                     break label179;
                  }

                  if(var10000 == 0) {
                     var44 = Math.min(var14, var20);
                  }

                  var46.g();
                  if(var33 != 0) {
                     break;
                  }
               }

               double var59;
               var10000 = (var59 = var44 - var14) == 0.0D?0:(var59 < 0.0D?-1:1);
            }

            if(var10000 < 0) {
               var45 = var44 - 2.0D * this.g;
            } else {
               var45 = var1.u() - this.g;
            }

            int var47 = (int)Math.floor((var45 - var12) / (2.0D * this.g));
            if(var47 > 0) {
               int var21 = 0;

               while(var21 < var47) {
                  var1.a(var12 + (double)(var21 * 2) * this.g, var1.q(), var2);
                  ++var21;
                  if(var33 != 0) {
                     break;
                  }
               }
            }
         }

      }
   }

   private y.c.D a(double var1, double var3, boolean var5) {
      int var16 = v.f;
      y.c.D var7 = null;
      double var8 = var5?this.d.a:this.d.b;
      int var6 = (int)Math.floor((var1 - var8) / (double)this.f);
      double var10 = (double)(var6 * this.f) + var8;
      if(var10 < var1) {
         var10 += (double)this.f;
      }

      var6 = (int)Math.floor((var3 - var8) / (double)this.f);
      double var12 = (double)(var6 * this.f) + var8;
      if(var12 >= var3) {
         var12 -= (double)this.f;
      }

      y.c.D var10000;
      if(var10 >= var1 && var12 < var3) {
         var7 = new y.c.D();
         double var14 = var10;

         while(var14 <= var12) {
            var10000 = var7;
            if(var16 != 0) {
               return var10000;
            }

            var7.add(new java.lang.Double(var14));
            var14 += (double)this.f;
            if(var16 != 0) {
               break;
            }
         }
      }

      var10000 = var7;
      return var10000;
   }

   private y.c.D a(ao var1) {
      return this.a(var1.t(), var1.u(), var1.x());
   }

   private void a(y.c.q var1, ai var2, double var3, boolean var5, double var6) {
      int var15 = v.f;
      y.c.D var8 = var2.a(var5);
      if(var8 != null) {
         y.c.C var9 = var8.m();

         while(var9.f()) {
            label36: {
               ak var10 = (ak)var9.d();
               if(var10.a == var6 && var1.e() == this.u && var10.c.e() == this.u) {
                  this.u.a(var1, var10.c);
                  if(var15 == 0) {
                     break label36;
                  }
               }

               if(var10.b >= var3) {
                  double var10000;
                  if(var5) {
                     var10000 = var2.v() + var3;
                  } else {
                     var10000 = var2.w() - var3;
                  }

                  aM var13 = (aM)this.t.b(var1);
                  if(var1.e() == this.u && var10.c.e() == this.u) {
                     this.u.a(var1, var10.c);
                  }
               }
            }

            var9.g();
            if(var15 != 0) {
               break;
            }
         }

      }
   }

   private void a(y.c.q var1, ai var2, double var3, boolean var5) {
      int var13 = v.f;
      y.c.D var6 = var2.a(var5);
      if(var6 != null) {
         y.c.C var7 = var6.m();

         while(var7.f()) {
            ak var8 = (ak)var7.d();
            if(var8.b >= var3) {
               double var9 = var5?var2.v() + var3:var2.w() - var3;
               aM var11 = (aM)this.t.b(var1);
               if(!var2.a(var8.a, var9, (y.c.d)var11.a()) && var1.e() == this.u && var8.c.e() == this.u) {
                  this.u.a(var1, var8.c);
               }
            }

            var7.g();
            if(var13 != 0) {
               break;
            }
         }

      }
   }

   private void a(y.c.D var1, double var2) {
      int var9 = v.f;
      boolean var5 = false;
      y.c.p var6 = var1.k();

      boolean var10000;
      aN var4;
      while(true) {
         if(var6 != null) {
            var10000 = var5;
            if(var9 != 0) {
               break;
            }

            if(!var5) {
               var4 = (aN)var6.c();
               double var7 = var4.a;
               if(var7 < var2) {
                  var6 = var1.c(var6);
                  if(var9 == 0) {
                     continue;
                  }
               }

               if(var7 == var2) {
                  ++var4.c;
                  var5 = true;
                  if(var9 == 0) {
                     continue;
                  }
               }

               var4 = new aN(var2, 0, 1);
               var6 = var1.a((Object)var4, (y.c.p)var6);
               var5 = true;
               if(var9 == 0) {
                  continue;
               }
            }
         }

         var10000 = var5;
         break;
      }

      if(!var10000) {
         var4 = new aN(var2, 0, 1);
         var1.add(var4);
      }

   }

   private void b(y.c.D var1, double var2) {
      int var9 = v.f;
      boolean var4 = false;
      y.c.p var5 = var1.k();

      while(var5 != null && !var4) {
         aN var6 = (aN)var5.c();
         double var7 = var6.a;
         if(var7 <= var2) {
            ++var6.b;
            var5 = var1.c(var5);
            if(var9 == 0) {
               continue;
            }
         }

         var4 = true;
         if(var9 != 0) {
            break;
         }
      }

   }

   private void a(y.c.D var1, double var2, double var4) {
      int var9 = v.f;
      boolean var6 = false;
      y.c.C var7 = var1.m();

      while(var7.f() && !var6) {
         aN var8 = (aN)var7.d();
         if(var8.a <= var2) {
            --var8.b;
         }

         if(var8.a == var4) {
            --var8.c;
         }

         if(var8.c == 0) {
            var1.b(var7);
         }

         var6 = var8.a > var2;
         var7.g();
         if(var9 != 0) {
            break;
         }
      }

   }

   private boolean b(y.c.D var1, double var2, double var4) {
      int var12 = v.f;
      boolean var6 = true;
      int var9 = 0;
      y.c.C var10 = var1.m();
      var10.j();

      boolean var10000;
      while(true) {
         if(var10.f()) {
            var10000 = var6;
            if(var12 != 0) {
               break;
            }

            if(var6) {
               aN var11 = (aN)var10.d();
               int var8 = var11.b;
               int var7 = var11.c;
               if(var11.a <= var2) {
                  --var8;
               }

               if(var11.a == var4) {
                  --var7;
               }

               var9 += var7;
               if(var7 > 0 && var8 < var9) {
                  var6 = false;
               }

               if(var8 < var7) {
                  var6 = false;
               }

               var10.h();
               if(var12 == 0) {
                  continue;
               }
            }
         }

         var10000 = var6;
         break;
      }

      return var10000;
   }

   private void a(y.c.y var1) {
      int var11 = v.f;
      y.c.x var2 = var1.a();

      do {
         boolean var10000 = var2.f();

         label33:
         while(true) {
            if(!var10000) {
               return;
            }

            y.c.q var3 = var2.e();
            aM var4 = (aM)this.t.b(var3);
            y.c.d var5 = var3.j().a();
            y.c.q var6 = var5.a(var3);
            aM var7 = (aM)this.t.b(var6);
            this.a(this.F, var7.c(), var4.c());
            this.s.a(var5, true);
            this.r.a(var3, true);
            this.r.a(var6, true);
            var1.b(var2);
            y.c.e var8 = var6.j();

            while(true) {
               if(!var8.f()) {
                  break label33;
               }

               y.c.d var9 = var8.a();
               var10000 = this.s.d(var9);
               if(var11 != 0) {
                  break;
               }

               if(!var10000) {
                  y.c.q var10 = var5.a(var6);
                  this.u.a(var9);
                  if(!this.r.d(var10) && var10.a() == 1) {
                     var1.add(var10);
                  }
               }

               var8.g();
               if(var11 != 0) {
                  break label33;
               }
            }
         }

         var2.g();
      } while(var11 == 0);

   }

   static y.c.h a(aK var0) {
      return var0.v;
   }

   static y.c.A b(aK var0) {
      return var0.t;
   }

   static y.c.A c(aK var0) {
      return var0.r;
   }

   static void a(aK var0, y.c.D var1, double var2) {
      var0.a(var1, var2);
   }

   static void b(aK var0, y.c.D var1, double var2) {
      var0.b(var1, var2);
   }
}
