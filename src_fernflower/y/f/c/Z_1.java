package y.f.c;

import y.f.c.a;

public class Z extends a {
   private boolean C = false;
   private double D;
   private double E;
   private double F = 10.0D;
   private double G = 2.0D;
   protected y.c.A o;
   protected y.c.A p;
   private int H = 1;
   y.g.al q = new y.g.al(false);
   y.g.al r = new y.g.al(false);
   y.g.al s = new y.g.al(false);
   y.g.al t = new y.g.al(false);
   y.g.al u = new y.g.al(false);
   y.g.al v = new y.g.al(false);
   y.g.al w = new y.g.al(false);
   y.g.al x = new y.g.al(false);
   y.g.al y = new y.g.al(false);
   y.g.al z = new y.g.al(false);
   y.g.al A = new y.g.al(false);
   y.g.al B = new y.g.al(false);

   protected void f() {
      this.q.c();
      this.D = Math.max(this.b(), this.a());
      if(this.D < 1.0D) {
         this.D = 1.0D;
      }

      this.E = (double)((int)(this.c() / this.D)) * this.D;
      this.o = y.g.M.a(new Object[this.g.f()]);
      this.p = y.g.M.a(new Object[this.g.f()]);
      this.q.c();
   }

   protected void a(y.c.y[] var1, y.c.c var2) {
      boolean var10 = a.i;
      this.r.c();
      this.f();
      this.b(var1);
      double var3 = this.i();
      double var5 = Double.POSITIVE_INFINITY;
      int var7 = 0;

      while(var7 < this.H && var3 < var5) {
         y.a.a.a();
         ++var7;
         var5 = var3;
         int var8 = 1;

         y.c.D var9;
         while(true) {
            if(var8 < var1.length) {
               var9 = this.a((y.c.y)var1[var8], -1);
               this.a((y.c.D)var9, -1);
               ++var8;
               if(var10) {
                  break;
               }

               if(!var10) {
                  continue;
               }
            }

            var8 = var1.length - 2;
            break;
         }

         while(true) {
            if(var8 >= 0) {
               var9 = this.a((y.c.y)var1[var8], 1);
               this.a((y.c.D)var9, 1);
               --var8;
               if(var10) {
                  break;
               }

               if(!var10) {
                  continue;
               }
            }

            var8 = 1;
            break;
         }

         while(true) {
            if(var8 < var1.length - 1) {
               var9 = this.a((y.c.y)var1[var8], 0);
               this.a((y.c.D)var9, 0);
               ++var8;
               if(var10) {
                  break;
               }

               if(!var10) {
                  continue;
               }
            }

            this.h();
            var3 = this.i();
            break;
         }

         if(var10) {
            break;
         }
      }

      y.a.a.a();
      y.c.D var11 = this.g();
      this.a(var11);
      this.r.c();
   }

   protected boolean a(y.c.D var1) {
      boolean var13 = a.i;
      this.s.c();
      int var2 = 0;
      double[] var3 = new double[2];
      double[] var4 = new double[2];
      double[] var5 = new double[2];

      label61:
      while(true) {
         int var6 = 0;
         Object var10000 = var1;

         label59:
         while(true) {
            y.c.C var7 = ((y.c.D)var10000).m();

            label57:
            while(true) {
               int var14 = var7.f();

               do {
                  if(var14 != 0) {
                     y.c.y var8 = (y.c.y)var7.d();
                     y.c.q var9 = var8.b();
                     var3[0] = this.a(var9, true);
                     var3[1] = this.a(var9, false);
                     y.c.p var10 = var8.k();
                     var10000 = var8;
                     if(var13) {
                        continue label59;
                     }

                     y.c.p var11 = var8.k().a();

                     while(true) {
                        if(var11 != null) {
                           var9 = (y.c.q)var11.c();
                           var4[0] = this.a(var9, true);
                           var4[1] = this.a(var9, false);
                           var5[0] = Math.max(var3[0], var4[0]);
                           var5[1] = Math.min(var3[1], var4[1]);
                           double var15;
                           var14 = (var15 = var5[1] - var5[0]) == 0.0D?0:(var15 < 0.0D?-1:1);
                           if(var13) {
                              break;
                           }

                           label46: {
                              if(var14 < 0) {
                                 y.c.p var12 = var11.b();
                                 if(var12 != null && var12 != var10) {
                                    var6 |= this.a(var10, var12, var3);
                                    var2 |= var6;
                                 }

                                 var10 = var11;
                                 var3[0] = var4[0];
                                 var3[1] = var4[1];
                                 if(!var13) {
                                    break label46;
                                 }
                              }

                              var3[0] = var5[0];
                              var3[1] = var5[1];
                           }

                           var11 = var11.a();
                           if(!var13) {
                              continue;
                           }
                        }

                        var6 |= this.a(var10, var8.l(), var3);
                        var14 = var2 | var6;
                        break;
                     }

                     var2 = var14;
                     var7.g();
                     if(!var13) {
                        continue label57;
                     }
                  }

                  if(var6 != 0) {
                     continue label61;
                  }

                  this.s.c();
                  var14 = var2;
               } while(var13);

               return (boolean)var2;
            }
         }
      }
   }

   protected y.c.D g() {
      boolean var6 = a.i;
      this.t.c();
      y.c.A var1 = y.g.M.a(new Object[this.g.f()]);
      y.c.D var2 = new y.c.D();
      y.c.x var3 = this.g.o();

      label65:
      while(true) {
         boolean var10000 = var3.f();

         label62:
         while(var10000) {
            y.c.q var4 = var3.e();
            if(var6) {
               return var2;
            }

            if(var1.b(var4) == null && this.h(var4)) {
               while(var4.b() == 1) {
                  var10000 = this.h(var4.n().e());
                  if(var6) {
                     continue label62;
                  }

                  if(!var10000) {
                     break;
                  }

                  var4 = var4.n().e();
                  if(var6) {
                     break;
                  }
               }

               y.c.y var5 = new y.c.y();
               var5.add(var4);
               var1.a(var4, var5);

               int var7;
               label44: {
                  while(var4.c() == 1) {
                     var4 = var4.o().e();
                     var7 = this.h(var4);
                     if(var6) {
                        break label44;
                     }

                     if(var7 == 0) {
                        break;
                     }

                     var5.add(var4);
                     var1.a(var4, var5);
                     if(var6) {
                        break;
                     }
                  }

                  var7 = var5.size();
               }

               if(var7 > 1) {
                  var2.add(var5);
               }
            }

            var3.g();
            if(!var6) {
               continue label65;
            }
            break;
         }

         this.t.c();
         return var2;
      }
   }

   protected boolean a(y.c.p var1, y.c.p var2, double[] var3) {
      boolean var11 = a.i;
      this.u.c();
      boolean var4 = false;
      if(var1 == var2) {
         this.u.c();
         return false;
      } else {
         y.c.q var5 = (y.c.q)var1.c();
         y.c.q var6 = (y.c.q)var2.c();
         double var7 = (var3[0] + var3[1]) / 2.0D;
         double var9;
         if(var3[0] <= -1.7976931348623157E308D) {
            var3[0] = Math.min(this.g.j(var5), this.g.j(var6));
            var9 = var3[0];
            if(var5.b() == 1) {
               var9 = Math.min(var9, this.g.j(var5.n().e()));
            }

            if(var6.c() == 1) {
               var9 = Math.min(var9, this.g.j(var6.o().e()));
            }

            var3[0] = var9;
            if(var3[0] > var3[1]) {
               var3[0] = var3[1];
            }

            var7 = var3[0];
         }

         if(var3[1] >= Double.MAX_VALUE) {
            var3[1] = Math.max(this.g.j(var5), this.g.j(var6));
            var9 = var3[1];
            if(var5.b() == 1) {
               var9 = Math.max(var9, this.g.j(var5.n().e()));
            }

            if(var6.c() == 1) {
               var9 = Math.max(var9, this.g.j(var6.o().e()));
            }

            var3[1] = var9;
            if(var3[1] < var3[0]) {
               var3[1] = var3[0];
            }

            var7 = var3[1];
         }

         while(true) {
            y.c.q var12 = (y.c.q)var1.c();
            if(!var4 && Math.abs(this.g.j(var12) - var7) > 5.0D) {
               var4 = true;
            }

            this.g.a(var12, var7, this.g.k(var12));
            var1 = var1.a();

            while(var1 == var2.a()) {
               this.u.c();
               if(!var11) {
                  return var4;
               }
            }
         }
      }
   }

   protected boolean h(y.c.q var1) {
      return var1.b() == 1?var1.c() < 2:(var1.c() == 1?var1.b() < 2:false);
   }

   protected void h() {
      boolean var8 = a.i;
      this.v.c();
      y.c.y var1 = new y.c.y(this.g.o());
      boolean[] var2 = new boolean[this.g.f()];
      int var3 = 0;

      label40:
      while(true) {
         boolean var10000 = var1.isEmpty();

         label37:
         while(!var10000 && var3 < this.g.f() * this.g.f()) {
            ++var3;
            y.c.q var4 = var1.d();
            var2[var4.d()] = true;
            double var5 = this.a(var4, var4.j());
            var5 = this.a(var4, var5);
            if(Math.abs(var5) <= 1.0E-5D) {
               continue label40;
            }

            this.b(var4, var5);
            if(var8) {
               return;
            }

            y.c.x var7 = var4.m();

            while(true) {
               if(!var7.f()) {
                  continue label40;
               }

               var10000 = var2[var7.e().d()];
               if(var8) {
                  break;
               }

               if(var10000) {
                  var2[var7.e().d()] = false;
                  var1.b(var7.e());
               }

               var7.g();
               if(var8) {
                  break label37;
               }
            }
         }

         this.v.c();
         return;
      }
   }

   protected void a(y.c.D var1, int var2) {
      boolean var7 = a.i;
      this.w.c();
      y.c.C var3 = var1.m();

      while(true) {
         if(var3.f()) {
            y.c.y var4 = (y.c.y)var3.d();
            double var5 = this.a(var4.m(), var2);
            if(var7) {
               break;
            }

            label19: {
               if(var5 < 0.0D) {
                  var5 = this.a(var4.b(), var5);
                  this.a(var4.m(), var5);
                  if(!var7) {
                     break label19;
                  }
               }

               var5 = this.a((y.c.q)var4.i(), var5);
               this.a(var4.m(), var5);
            }

            var3.g();
            if(!var7) {
               continue;
            }
         }

         this.w.c();
         break;
      }

   }

   protected y.c.D a(y.c.y var1, int var2) {
      boolean var13 = a.i;
      this.x.c();
      y.c.D var3 = new y.c.D();
      y.c.x var4 = var1.a();

      boolean var10000;
      while(true) {
         if(var4.f()) {
            y.c.y var5 = new y.c.y();
            var5.add(var4.e());
            var3.add(var5);
            if(var13) {
               break;
            }

            var4.g();
            if(!var13) {
               continue;
            }
         }

         var10000 = false;
         break;
      }

      label54:
      while(true) {
         boolean var14 = false;
         y.c.p var15 = var3.k();

         label52:
         while(true) {
            Object var16;
            if(var15 != null) {
               var16 = var15.c();
            } else {
               if(var14) {
                  break;
               }

               this.x.c();
               var16 = var3;
               if(!var13) {
                  return var3;
               }
            }

            do {
               y.c.y var6 = (y.c.y)var16;
               var15 = var15.a();
               if(var15 == null) {
                  continue label52;
               }

               y.c.y var7 = (y.c.y)var15.c();
               var10000 = this.a((y.c.q)var6.i(), var7.b());
               if(!var13) {
                  if(!var10000) {
                     continue label52;
                  }

                  double var8 = this.a(var6.m(), var2);
                  double var10 = this.a(var7.m(), var2);
                  if(var8 < var10) {
                     continue label52;
                  }

                  var14 = true;
                  var6.a(var7.m());
                  var3.h(var15);
                  var15 = var15.a();
                  if(!var13) {
                     continue label52;
                  }

                  var10000 = var14;
               }

               if(var10000) {
                  continue label54;
               }

               this.x.c();
               var16 = var3;
            } while(var13);

            return var3;
         }
      }
   }

   protected double a(y.c.q var1, y.c.e var2) {
      boolean var10 = a.i;
      double var3 = 0.0D;
      double var5 = 0.0D;
      var2.i();

      while(true) {
         if(var2.f()) {
            y.c.d var7 = var2.a();
            double var8 = this.a(var7);
            var5 += var8;
            var3 += var8 * (this.g.j(var7.a(var1)) - this.g.j(var1));
            var2.g();
            if(var10) {
               break;
            }

            if(!var10) {
               continue;
            }
         }

         if(var3 == 0.0D) {
            return 0.0D;
         }
         break;
      }

      return var3 / var5;
   }

   protected boolean a(y.c.q var1, y.c.q var2) {
      return this.o.b(var1) == var2?this.a((y.c.q)var2) - this.b(var1) - 1.0E-5D < this.b(var1, false):(this.p.b(var1) == var2?this.a((y.c.q)var1) - this.b(var2) - 1.0E-5D < this.b(var1, true):false);
   }

   protected double a(y.c.q var1, double var2) {
      this.z.c();
      if(var2 != 0.0D) {
         label17: {
            y.c.q var4;
            if(var2 < 0.0D) {
               var4 = (y.c.q)this.p.b(var1);
               if(var4 == null) {
                  break label17;
               }

               var2 = Math.max(var2, this.b(var4) - this.a((y.c.q)var1) + this.b(var1, true));
               if(!a.i) {
                  break label17;
               }
            }

            var4 = (y.c.q)this.o.b(var1);
            if(var4 != null) {
               var2 = Math.min(var2, this.a((y.c.q)var4) - this.b(var1) - this.b(var1, false));
            }
         }
      }

      this.z.c();
      return var2;
   }

   protected double a(y.c.C var1, int var2) {
      boolean var7 = a.i;
      this.y.c();
      int var3 = 0;
      double var4 = 0.0D;
      var1.i();

      while(true) {
         if(var1.f()) {
            ++var3;
            y.c.q var6 = (y.c.q)var1.d();
            if(var7) {
               break;
            }

            label34: {
               if(var2 == -1) {
                  var4 += this.a(var6, var6.k());
                  if(!var7) {
                     break label34;
                  }
               }

               if(var2 == 0) {
                  var4 += this.a(var6, var6.j());
                  if(!var7) {
                     break label34;
                  }
               }

               var4 += this.a(var6, var6.l());
            }

            var1.g();
            if(!var7) {
               continue;
            }
         }

         this.y.c();
         break;
      }

      return var4 / (double)var3;
   }

   protected void b(y.c.q var1, double var2) {
      double var4 = this.g.j(var1) + var2;
      if(this.C) {
         label12: {
            if(this.e.b(var1) == null) {
               var4 = (double)((int)((var4 + this.E / 2.0D) / this.E)) * this.E;
               if(!a.i) {
                  break label12;
               }
            }

            var4 = (double)((int)((var4 + this.D / 2.0D) / this.D)) * this.D;
         }
      }

      this.g.a(var1, var4, this.g.k(var1));
   }

   protected void a(y.c.C var1, double var2) {
      boolean var5 = a.i;
      var1.i();

      while(var1.f()) {
         y.c.q var4 = (y.c.q)var1.d();
         this.b(var4, var2);
         var1.g();
         if(var5) {
            break;
         }
      }

   }

   protected double i() {
      boolean var6 = a.i;
      this.A.c();
      double var1 = 0.0D;
      y.c.x var3 = this.g.o();

      while(var3.f()) {
         y.c.e var4 = var3.e().j();

         while(true) {
            if(var4.f()) {
               y.c.d var5 = var4.a();
               var1 += this.a(var5) * Math.abs(this.g.j(var5.c()) - this.g.j(var5.d()));
               var4.g();
               if(var6) {
                  break;
               }

               if(!var6) {
                  continue;
               }
            }

            var3.g();
            break;
         }

         if(var6) {
            break;
         }
      }

      this.A.c();
      return var1;
   }

   protected double a(y.c.d var1) {
      return this.e.b(var1.c()) == null?(this.e.b(var1.d()) == null?1.0D:this.G * 1.0D):(this.e.b(var1.d()) == null?this.G * 1.0D:this.F * 1.0D);
   }

   protected double a(y.c.q var1, boolean var2) {
      y.c.q var3;
      if(var2) {
         var3 = (y.c.q)this.p.b(var1);
         return var3 == null?-1.7976931348623157E308D:this.b(var3) + this.b(var1, true) + this.e(var1);
      } else {
         var3 = (y.c.q)this.o.b(var1);
         return var3 == null?Double.MAX_VALUE:this.a((y.c.q)var3) - this.b(var1, false) - this.f(var1);
      }
   }

   protected double b(y.c.q var1, boolean var2) {
      y.c.q var3;
      label34: {
         if(var2) {
            if(this.p.b(var1) == null) {
               return 0.0D;
            }

            var3 = (y.c.q)this.p.b(var1);
            if(!a.i) {
               break label34;
            }
         }

         if(this.o.b(var1) == null) {
            return 0.0D;
         }

         var3 = (y.c.q)this.o.b(var1);
      }

      y.c.d var4 = (y.c.d)this.e.b(var1);
      y.c.d var5 = (y.c.d)this.e.b(var3);
      return var4 != null && var5 != null?(var4.d() != var5.c() && var4.d() != var5.d()?this.a():this.b()):this.c();
   }

   protected void b(y.c.y[] var1) {
      boolean var8 = a.i;
      this.B.c();
      this.a((y.f.X)this.g, (y.c.y[])var1);
      int var2 = 0;

      while(true) {
         if(var2 < var1.length) {
            double var3 = 0.0D;
            y.c.q var5 = null;
            if(var8) {
               break;
            }

            y.c.x var6 = var1[var2].a();

            label41: {
               while(var6.f()) {
                  y.c.q var7 = var6.e();
                  if(var8) {
                     break label41;
                  }

                  if(var5 != null) {
                     this.o.a(var5, var7);
                     this.p.a(var7, var5);
                  }

                  var5 = var7;
                  var3 += this.g.a((Object)var7).getWidth() / 2.0D + this.c(var7) + this.b(var7, true);
                  if(this.C) {
                     label36: {
                        if(this.e.b(var7) == null) {
                           var3 = (double)((int)((var3 + this.E / 2.0D) / this.E)) * this.E;
                           if(!var8) {
                              break label36;
                           }
                        }

                        var3 = (double)((int)((var3 + this.D / 2.0D) / this.D)) * this.D;
                     }
                  }

                  this.g.a(var7, var3, this.g.k(var7));
                  var3 += this.g.a((Object)var7).getWidth() / 2.0D + this.d(var7);
                  var6.g();
                  if(var8) {
                     break;
                  }
               }

               ++var2;
            }

            if(!var8) {
               continue;
            }
         }

         this.B.c();
         break;
      }

   }
}
