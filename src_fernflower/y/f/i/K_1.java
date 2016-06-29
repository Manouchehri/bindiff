package y.f.i;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;
import y.f.i.L;
import y.f.i.M;
import y.f.i.N;
import y.f.i.O;
import y.f.i.P;
import y.f.i.Q;
import y.f.i.R;
import y.f.i.S;
import y.f.i.U;
import y.f.i.V;
import y.f.i.W;
import y.f.i.v;

public class K extends y.f.a {
   public static final Object a = "y.layout.router.OrthogonalSegmentDistributionStage.AFFECTED_EDGES";
   private y.f.X b;
   private boolean c;
   private Comparator d;
   private int[] e;
   private int[] f;
   private double g = 10.0D;
   private Object h;
   private boolean i;
   private double n;
   private double o;
   private double p;
   private boolean q;
   private boolean r;
   private boolean s;
   private byte t;

   public K() {
      this.h = a;
      this.n = 10.0D;
      this.r = true;
      this.s = true;
      this.d = new L(this);
   }

   public void c(y.f.X var1) {
      this.b = var1;
      this.a((y.f.X)var1);
      if(var1.h() != 0) {
         int var2 = var1.g() * 2;
         byte[] var3 = new byte[var2 * (var2 - 1) / 2];
         this.t = 0;
         this.a(var1, var3);
         y.f.an var4 = new y.f.an((byte)3);
         var4.a((y.f.ah)(new M(this, var3)));
         var4.c(var1);
         this.a(var3);
         this.q = true;
         this.t = 0;
         this.b(var1);
         var4 = new y.f.an((byte)3);
         this.q = false;
         var4.a((y.f.ah)(new N(this)));
         var4.c(var1);
      }
   }

   private void a(y.f.X var1, byte[] var2) {
      List var3 = this.f(var1);
      var3.addAll(this.e(var1));
      y.g.e.a((List)var3, (Comparator)null);
      this.a(var3, var2);
   }

   private void b(y.f.X var1) {
      List var2 = this.f(var1);
      var2.addAll(this.e(var1));
      y.g.e.a((List)var2, (Comparator)null);
      this.a(var2);
   }

   private void a(List var1) {
      int var10 = v.f;
      ArrayList var2 = new ArrayList();
      double var3 = -1.7976931348623157E308D;
      y.d.c var5 = new y.d.c(-1.7976931348623157E308D);
      int var6 = 0;

      while(true) {
         if(var6 < var1.size()) {
            R var7 = (R)var1.get(var6);
            byte var8 = var7.k();
            if(var10 != 0) {
               break;
            }

            label53: {
               if(var8 == 0) {
                  if(Math.abs(var7.j() - var3) < 5.0D) {
                     var2.add(var7);
                     if(var10 == 0) {
                        break label53;
                     }
                  }

                  if(var2.size() > 0) {
                     this.a(var2, var5, var6, var1);
                  }

                  var2.add(var7);
                  var3 = var7.j();
                  if(var10 == 0) {
                     break label53;
                  }
               }

               W var9;
               if(var8 == 2) {
                  if(var2.size() > 0) {
                     this.a(var2, var5, var6, var1);
                  }

                  var9 = (W)var7;
                  var5.c(var9.b().c().b() - 2.0D, var9.b().d().b() + 2.0D, var7.j());
                  if(var10 == 0) {
                     break label53;
                  }
               }

               if(var8 == 1) {
                  if(var2.size() > 0) {
                     this.a(var2, var5, var6, var1);
                  }

                  var9 = (W)var7;
                  var5.c(var9.b().c().b(), var9.b().d().b(), var7.j());
               }
            }

            ++var6;
            if(var10 == 0) {
               continue;
            }
         }

         this.a(var2, var5, var1.size(), var1);
         break;
      }

   }

   private void a(List var1, byte[] var2) {
      int var9 = v.f;
      ArrayList var3 = new ArrayList();
      double var4 = -1.7976931348623157E308D;
      int var6 = 0;

      int var10000;
      while(true) {
         if(var6 < var1.size()) {
            R var7 = (R)var1.get(var6);
            byte var8 = var7.k();
            var10000 = var8;
            if(var9 != 0) {
               break;
            }

            label57: {
               if(var8 == 0) {
                  if(Math.abs(var7.j() - var4) < 5.0D) {
                     var3.add(var7);
                     if(var9 == 0) {
                        break label57;
                     }
                  }

                  if(var3.size() > 1) {
                     this.b(var3, var2);
                  }

                  var3.clear();
                  var3.add(var7);
                  var4 = var7.j();
                  if(var9 == 0) {
                     break label57;
                  }
               }

               if(var8 == 2) {
                  if(var3.size() > 1) {
                     this.b(var3, var2);
                  }

                  var3.clear();
                  if(var9 == 0) {
                     break label57;
                  }
               }

               if(var8 == 1) {
                  if(var3.size() > 1) {
                     this.b(var3, var2);
                  }

                  var3.clear();
               }
            }

            ++var6;
            if(var9 == 0) {
               continue;
            }
         }

         var10000 = var3.size();
         break;
      }

      if(var10000 > 1) {
         this.b(var3, var2);
      }

      var3.clear();
   }

   private void a(byte[] var1) {
      int var16 = v.f;
      y.c.i var2 = new y.c.i();
      y.c.q[] var3 = new y.c.q[this.b.g() * 2];
      int var4 = 0;

      while(true) {
         if(var4 < this.b.g() * 2) {
            var3[var4] = var2.d();
            ++var4;
            if(var16 != 0) {
               break;
            }

            if(var16 == 0) {
               continue;
            }
         }

         var4 = 1;
         break;
      }

      int var5;
      int var10000;
      label188:
      while(true) {
         var10000 = var4;

         label185:
         while(var10000 < this.b.g() * 2) {
            var10000 = 0;
            if(var16 != 0) {
               break label188;
            }

            var5 = 0;

            while(var5 < var4) {
               byte var6 = var1[var4 * (var4 - 1) / 2 + var5];
               var10000 = var6;
               if(var16 != 0) {
                  continue label185;
               }

               label179: {
                  if(var6 > 0) {
                     var2.a(var3[var4], var3[var5]);
                     if(var16 == 0) {
                        break label179;
                     }
                  }

                  if(var6 < 0) {
                     var2.a(var3[var5], var3[var4]);
                  }
               }

               ++var5;
               if(var16 != 0) {
                  break;
               }
            }

            ++var4;
            if(var16 == 0) {
               continue label188;
            }
            break;
         }

         var10000 = var2.e();
         break;
      }

      int[] var17 = new int[var10000];
      var5 = var2.e() / 2;
      byte var18 = 1;

      int var10;
      label161:
      while(true) {
         var10000 = var18;

         while(true) {
            if(var10000 == 0) {
               break label161;
            }

            var18 = 0;
            y.a.m.b(var2, var17);
            y.c.e var7 = var2.p();

            while(true) {
               if(!var7.f()) {
                  continue label161;
               }

               y.c.d var8 = var7.a();
               int var9 = var8.c().d();
               var10 = var8.d().d();
               var10000 = var17[var9];
               if(var16 != 0) {
                  break;
               }

               if(var10000 < var17[var10]) {
                  var9 = var9 >= var5?var9 - var5:var9 + var5;
                  var10 = var10 >= var5?var10 - var5:var10 + var5;
                  var2.a(var8);
                  var2.a(var3[var9].b(var3[var10]));
                  var18 = 1;
                  if(var16 == 0) {
                     continue label161;
                  }
               }

               var7.g();
               if(var16 != 0) {
                  break label161;
               }
            }
         }
      }

      y.g.a.d var19 = new y.g.a.d(var2);
      int var20 = 1;
      int[] var21 = new int[var2.e()];
      var10 = 0;

      while(true) {
         if(var10 < var17.length) {
            var17[var10] = 0;
            ++var10;
            if(var16 != 0) {
               break;
            }

            if(var16 == 0) {
               continue;
            }
         }

         var10 = 0;
         break;
      }

      y.c.q var11;
      while(true) {
         if(var10 < var3.length) {
            var11 = var3[var10];
            var10000 = var11.b();
            if(var16 != 0) {
               break;
            }

            label128: {
               if(var10000 == 0) {
                  int var12 = var10 < var5?var10 + var5:var10 - var5;
                  if(var17[var12] != 0) {
                     var17[var10] = -var17[var12];
                     var19.a(var11, var17[var10]);
                     if(var16 == 0) {
                        break label128;
                     }
                  }

                  var17[var10] = var20;
                  var19.a(var11, var20++);
                  if(var16 == 0) {
                     break label128;
                  }
               }

               var21[var10] = var11.b();
            }

            ++var10;
            if(var16 == 0) {
               continue;
            }
         }

         var10000 = 1;
         break;
      }

      var10 = var10000;

      label115:
      while(true) {
         var10000 = var19.a();

         label112:
         while(var10000 == 0) {
            var11 = var19.c();
            var17[var11.d()] = var10++;
            y.c.d var23 = var11.f();

            while(true) {
               if(var23 == null) {
                  continue label115;
               }

               y.c.q var13 = var23.d();
               int var14 = var21[var13.d()]--;
               var10000 = var14;
               if(var16 != 0) {
                  break label115;
               }

               if(var16 != 0) {
                  break;
               }

               if(var14 == 1) {
                  label212: {
                     y.c.q var15 = var13.d() < var5?var3[var13.d() + var5]:var3[var13.d() - var5];
                     if(var17[var15.d()] != 0) {
                        var19.a(var13, -var17[var15.d()]);
                        if(var16 == 0) {
                           break label212;
                        }
                     }

                     var17[var13.d()] = var20;
                     var19.a(var13, var20++);
                  }
               }

               var23 = var23.g();
               if(var16 != 0) {
                  break label112;
               }
            }
         }

         var10000 = 0;
         break;
      }

      int var22 = var10000;

      while(true) {
         if(var22 < var17.length) {
            var17[var22] = -var17[var22];
            ++var22;
            if(var16 != 0) {
               break;
            }

            if(var16 == 0) {
               continue;
            }
         }

         this.e = new int[this.b.g()];
         this.f = new int[this.b.g()];
         System.arraycopy(var17, 0, this.e, 0, this.e.length);
         System.arraycopy(var17, this.e.length, this.f, 0, this.f.length);
         break;
      }

   }

   private y.c.c d(y.f.X var1) {
      Object var2 = var1.c(this.h);
      if(var2 == null) {
         var2 = new O(this);
      }

      return (y.c.c)var2;
   }

   private void a(List var1, y.d.c var2, int var3, List var4) {
      int var15 = v.f;
      if(var1.size() < 2) {
         if(var1.size() > 0) {
            Q var5 = (Q)var1.get(0);
            this.a(var2, var5);
         }

         var1.clear();
         if(var15 == 0) {
            return;
         }
      }

      ArrayList var16 = new ArrayList(var1.size() * 2);
      Iterator var6 = var1.iterator();

      byte var10000;
      label70: {
         while(var6.hasNext()) {
            Q var7 = (Q)var6.next();
            var10000 = var7.f();
            if(var15 != 0) {
               break label70;
            }

            if(var10000 != 0) {
               this.a(var2, var7);
               if(var15 == 0) {
                  continue;
               }
            }

            double var8 = var7.a().c().b();
            double var10 = var7.a().d().b();
            if(var8 <= var10) {
               var16.add(new P((byte)3, var8, var7));
               var16.add(new P((byte)4, var10, var7));
               if(var15 == 0) {
                  continue;
               }
            }

            var16.add(new P((byte)3, var10, var7));
            var16.add(new P((byte)4, var8, var7));
            if(var15 != 0) {
               break;
            }
         }

         y.g.e.a((List)var16, (Comparator)null);
         var10000 = 0;
      }

      int var17 = var10000;
      double var18 = 0.0D;
      double var9 = 0.0D;
      ArrayList var11 = new ArrayList();
      Iterator var12 = var16.iterator();

      Object var19;
      label53: {
         while(var12.hasNext()) {
            P var13 = (P)var12.next();
            if(var13.k() == 3) {
               label47: {
                  if(var17 == 0) {
                     var18 = var13.j();
                     if(var15 == 0) {
                        break label47;
                     }
                  }

                  var18 = Math.min(var13.j(), var18);
               }

               var11.add(var13.a());
               ++var17;
               if(var15 == 0) {
                  continue;
               }
            }

            --var17;
            var9 = Math.max(var13.j(), var9);
            if(var17 == 0) {
               var19 = var11;
               if(var15 != 0) {
                  break label53;
               }

               if(var11.size() > 1) {
                  y.d.c var14 = this.a(var3, var4, var11, var18 - 10.0D, var9 + 10.0D);
                  this.a((List)var11, (y.d.c)var2, (y.d.c)var14);
               }

               var11.clear();
               if(var15 != 0) {
                  break;
               }
            }
         }

         var19 = var1;
      }

      ((List)var19).clear();
   }

   private void a(y.d.c var1, Q var2) {
      double var3 = var2.a().c().b();
      double var5 = var2.a().d().b();
      double var7 = Math.min(var3, var5);
      double var9 = Math.max(var3, var5);
      var1.c(var7, var9, var2.a().c().a());
   }

   private void b(List var1, byte[] var2) {
      int var12 = v.f;
      ArrayList var3 = new ArrayList(var1.size() * 2);
      Iterator var4 = var1.iterator();

      byte var10000;
      while(true) {
         if(var4.hasNext()) {
            Q var5 = (Q)var4.next();
            var10000 = var5.f();
            if(var12 != 0) {
               break;
            }

            if(var10000 != 0) {
               continue;
            }

            double var6 = var5.a().c().b();
            double var8 = var5.a().d().b();
            if(var6 <= var8) {
               var3.add(new P((byte)3, var6, var5));
               var3.add(new P((byte)4, var8, var5));
               if(var12 == 0) {
                  continue;
               }
            }

            var3.add(new P((byte)3, var8, var5));
            var3.add(new P((byte)4, var6, var5));
            if(var12 == 0) {
               continue;
            }
         }

         y.g.e.a((List)var3, (Comparator)null);
         var10000 = 0;
         break;
      }

      int var13 = var10000;
      double var14 = 0.0D;
      double var7 = 0.0D;
      ArrayList var9 = new ArrayList();
      Iterator var10 = var3.iterator();

      while(var10.hasNext()) {
         P var11 = (P)var10.next();
         if(var11.k() == 3) {
            label36: {
               if(var13 == 0) {
                  var14 = var11.j();
                  if(var12 == 0) {
                     break label36;
                  }
               }

               var14 = Math.min(var11.j(), var14);
            }

            var9.add(var11.a());
            ++var13;
            if(var12 == 0) {
               continue;
            }
         }

         --var13;
         var7 = Math.max(var11.j(), var7);
         if(var13 == 0) {
            if(var9.size() > 1) {
               this.c(var9, var2);
            }

            var9.clear();
            if(var12 != 0) {
               break;
            }
         }
      }

   }

   private y.d.c a(int var1, List var2, List var3, double var4, double var6) {
      int var24 = v.f;
      int var8 = var3.size();
      double var9 = -1.7976931348623157E308D;
      Iterator var11 = var3.iterator();

      while(var11.hasNext()) {
         Q var12 = (Q)var11.next();
         y.c.d var13 = var12.e();
         y.f.am var14;
         double var15;
         if(var12.h()) {
            var14 = ((y.f.X)var13.a()).a((Object)var13.c());
            var15 = var14.getX() + var14.getWidth();
            var9 = Math.max(var9, var15 + 1.0D);
         }

         if(var12.i()) {
            var14 = ((y.f.X)var13.a()).a((Object)var13.c());
            var15 = var14.getX() + var14.getWidth();
            var9 = Math.max(var9, var15 + 1.0D);
            if(var24 != 0) {
               break;
            }
         }
      }

      y.d.c var25 = new y.d.c(Double.MAX_VALUE);
      double var26 = ((R)var2.get(var1 - 1)).j() + this.b() * (double)(var8 + 1);
      double var27 = var26;
      int var16 = var1;

      while(true) {
         if(var16 < var2.size()) {
            label76: {
               R var17 = (R)var2.get(var16);
               var27 = var17.j();
               if(var24 != 0) {
                  break;
               }

               if(var9 > -1.7976931348623157E308D) {
                  if(var27 > var9) {
                     break label76;
                  }
               } else if(var27 > var26) {
                  break label76;
               }

               byte var18 = var17.k();
               if(var18 != 0) {
                  label75: {
                     W var19;
                     double var20;
                     double var22;
                     if(var18 == 2) {
                        var19 = (W)var17;
                        var20 = var19.b().c().b();
                        var22 = var19.b().d().b();
                        if(var22 <= var4 || var20 >= var6) {
                           break label75;
                        }

                        var20 = Math.max(var4, var20);
                        var22 = Math.min(var22, var6);
                        var25.a(var20, var22, var17.j());
                        if(var24 == 0) {
                           break label75;
                        }
                     }

                     if(var18 == 1) {
                        var19 = (W)var17;
                        var20 = var19.b().c().b() - 2.0D;
                        var22 = var19.b().d().b() + 2.0D;
                        if(var22 > var4 && var20 < var6) {
                           var20 = Math.max(var20, var4);
                           var22 = Math.min(var22, var6);
                           var25.a(var20, var22, var17.j());
                        }
                     }
                  }
               }

               ++var16;
               if(var24 == 0) {
                  continue;
               }
            }
         }

         var25.a(var4 - 20.0D, var6 + 20.0D, var27);
         break;
      }

      return var25;
   }

   private void a(List var1, y.d.c var2, y.d.c var3) {
      int var25 = v.f;
      S var4 = new S();
      var4.c(Double.NaN);
      var4.a(this.d);
      if(this.i) {
         var4.a(this.n);
         var4.b(this.q?this.o:this.p);
      }

      double var7 = this.n;
      int var9 = 0;
      byte var10 = 0;

      label89:
      while(true) {
         double var5 = this.b();

         while(true) {
            var4.a();
            Iterator var11 = var1.iterator();

            Q var12;
            label74: {
               while(var11.hasNext()) {
                  var12 = (Q)var11.next();
                  y.d.m var13 = var12.a();
                  var4.a(var12, 0.0D, var5, var13.c().b(), var12.b(), var13.d().b(), var12.c(), var12.d());
                  if(var25 != 0) {
                     break label74;
                  }

                  if(var25 != 0) {
                     break;
                  }
               }

               var4.a(var3);
               var4.b(var2);
               var4.c();
            }

            double var26 = var4.d();
            int var27 = var1.size();
            var5 -= var26 / (double)(var27 + 1);
            ++var9;
            int var10000 = this.s;

            while(var10000 == 0 || var4.d() <= 0.001D || var5 <= 0.1D || var9 > 20) {
               var7 /= 2.0D;
               var4.a(var7);
               var10000 = this.i;
               if(var25 == 0) {
                  if(var10000 != 0 && this.r && var4.d() > 0.0D && var7 >= 1.0D && var10 <= 20) {
                     continue label89;
                  }

                  double var29;
                  var10000 = (var29 = var4.d() - 0.001D) == 0.0D?0:(var29 < 0.0D?-1:1);
                  if(var25 == 0) {
                     if(var10000 > 0) {
                        return;
                     }

                     var11 = var1.iterator();

                     while(var11.hasNext()) {
                        var12 = (Q)var11.next();
                        double var28 = var4.a((Object)var12);
                        y.c.d var15 = var12.e();
                        if(!var12.f() && !Double.isNaN(var28)) {
                           y.c.D var16 = ((y.f.X)var15.a()).m(var15);
                           y.c.p var17 = var16.b(var12.g());
                           y.d.t var18 = (y.d.t)var17.c();
                           y.c.p var19 = var16.b(var12.g() + 1);
                           y.d.t var20 = (y.d.t)var19.c();
                           var18 = new y.d.t(var28, var18.b);
                           var20 = new y.d.t(var28, var20.b);
                           double var21 = Math.min(var18.b, var20.b);
                           double var23 = Math.max(var18.b, var20.b);
                           if(var21 + 2.0D < var23 - 2.0D) {
                              ++var21;
                              --var23;
                           }

                           var2.b(var21, var23, var28);
                           var17.a(var18);
                           var19.a(var20);
                           this.b.a(var15, var16);
                           if(var25 != 0) {
                              break;
                           }
                        }
                     }

                     var4.a();
                     return;
                  }
               }
            }
         }
      }
   }

   private void c(List var1, byte[] var2) {
      int var21 = v.f;
      S var3 = new S();
      U[] var4 = new U[var1.size()];
      int var5 = 0;
      Iterator var6 = var1.iterator();

      while(var6.hasNext()) {
         Q var7 = (Q)var6.next();
         y.d.m var8 = var7.a();
         var4[var5] = var3.a(var7, 0.0D, 10.0D, var8.c().b(), var7.b(), var8.d().b(), var7.c());
         ++var5;
         if(var21 != 0) {
            break;
         }
      }

      V var22 = new V((Comparator)null);
      int var23 = this.b.g();
      int var24 = 0;

      do {
         int var10000 = var24;
         int var10001 = var4.length;

         label58:
         while(true) {
            if(var10000 >= var10001) {
               return;
            }

            U var9 = var4[var24];
            int var10 = var24 + 1;

            while(true) {
               if(var10 >= var4.length) {
                  break label58;
               }

               U var11 = var4[var10];
               int var12 = Q.a((Q)var9.c()).b();
               int var13 = Q.a((Q)var11.c()).b();
               var10000 = var12;
               var10001 = var13;
               if(var21 != 0) {
                  break;
               }

               if(var12 != var13) {
                  int var14 = var22.compare(var9, var11);
                  Q var15 = (Q)var9.c();
                  y.d.m var17 = var15.a();
                  boolean var16 = var17.c().b() >= var17.d().b();
                  Q var18 = (Q)var11.c();
                  y.d.m var19 = var18.a();
                  boolean var20 = var19.c().b() >= var19.d().b();
                  if(U.a(var9) == 3 && U.a(var11) == 3) {
                     var14 = -var14;
                  }

                  this.a(var12, var13, var16, var20, var23, var14, var2);
                  this.a(var12, var13, !var16, !var20, var23, -var14, var2);
               }

               ++var10;
               if(var21 != 0) {
                  break label58;
               }
            }
         }

         ++var24;
      } while(var21 == 0);

   }

   private void a(int var1, int var2, boolean var3, boolean var4, int var5, int var6, byte[] var7) {
      if(!var3) {
         var1 += var5;
      }

      if(!var4) {
         var2 += var5;
      }

      int var8;
      if(var1 < var2) {
         var8 = var2;
         var2 = var1;
         var1 = var8;
         var6 = -var6;
      }

      if(var6 != 0) {
         var8 = var1 * (var1 - 1) / 2 + var2;
         byte var9 = var7[var8];
         if(var6 > 0) {
            if(var9 >= 127) {
               return;
            }

            var7[var8] = (byte)(var9 + 1);
            if(v.f == 0) {
               return;
            }
         }

         if(var9 > -128) {
            var7[var8] = (byte)(var9 - 1);
         }
      }

   }

   private List e(y.f.X var1) {
      int var5 = v.f;
      ArrayList var2 = new ArrayList(var1.e() * 2);
      y.c.x var3 = var1.o();

      ArrayList var10000;
      while(true) {
         if(var3.f()) {
            y.c.q var4 = var3.e();
            var2.add(new W(var4, (byte)0));
            var10000 = var2;
            if(var5 != 0) {
               break;
            }

            var2.add(new W(var4, (byte)1));
            var3.g();
            if(var5 == 0) {
               continue;
            }
         }

         var10000 = var2;
         break;
      }

      return var10000;
   }

   private List f(y.f.X var1) {
      int var17 = v.f;
      y.c.c var2 = this.d(var1);
      ArrayList var3 = new ArrayList();
      y.c.c var4 = var1.c(y.f.aF.a);
      y.c.c var5 = var1.c(y.f.aF.b);
      y.c.c var6 = var1.c(y.f.ax.a);
      y.c.c var7 = var1.c(y.f.ax.b);
      y.c.x var8 = var1.o();

      while(var8.f()) {
         y.c.q var9 = var8.e();
         y.c.e var10 = var9.l();

         label116:
         while(true) {
            boolean var10000 = var10.f();

            label113:
            while(var10000) {
               y.c.d var11 = var10.a();
               int var12 = 0;
               int var13 = var1.l(var11).h() - 2;
               if(var17 != 0) {
                  break label116;
               }

               y.d.s var14 = var1.l(var11).j();

               while(var14.f()) {
                  y.d.m var15 = var14.a();
                  boolean var16 = false;
                  var10000 = var2.d(var11);
                  if(var17 != 0) {
                     continue label113;
                  }

                  label127: {
                     if(!var10000) {
                        var16 = true;
                        if(var17 == 0) {
                           break label127;
                        }
                     }

                     if(this.c && (var12 == 0 || var12 + 1 == var14.k())) {
                        var16 = true;
                        if(var17 == 0) {
                           break label127;
                        }
                     }

                     if(var12 == 0) {
                        var16 = this.a(var11, var4) || this.a(var1, var11, var6, true);
                        if(var16 || var12 != var13) {
                           break label127;
                        }

                        var16 = this.a(var11, var5) || this.a(var1, var11, var7, false);
                        if(var17 == 0) {
                           break label127;
                        }
                     }

                     if(var12 == var13) {
                        var16 = this.a(var11, var5) || this.a(var1, var11, var7, false);
                     }
                  }

                  if(Math.abs(var15.c().a() - var15.d().a()) < 0.001D) {
                     var3.add(new Q((byte)0, var15, var11, var16, var12, var12 == 0, var12 == var13));
                  }

                  var14.g();
                  ++var12;
                  if(var17 != 0) {
                     break;
                  }
               }

               var10.g();
               if(var17 == 0) {
                  continue label116;
               }
               break;
            }

            var8.g();
            break;
         }

         if(var17 != 0) {
            break;
         }
      }

      return var3;
   }

   private boolean a(y.f.X var1, y.c.d var2, y.c.c var3, boolean var4) {
      int var18 = v.f;
      boolean var10000;
      if(var3 != null) {
         Collection var5 = (Collection)var3.b(var2);
         if(var5 == null) {
            return false;
         }

         Iterator var6 = var5.iterator();

         label38:
         while(true) {
            y.f.ax var7;
            do {
               if(!var6.hasNext()) {
                  break label38;
               }

               var7 = (y.f.ax)var6.next();
            } while(!var7.b());

            var10000 = var4;
            if(var18 != 0) {
               return var10000;
            }

            y.f.am var8;
            y.d.t var9;
            label35: {
               if(var4) {
                  var8 = var1.a((Object)var2.c());
                  var9 = var1.l(var2).c();
                  if(var18 == 0) {
                     break label35;
                  }
               }

               var8 = var1.a((Object)var2.d());
               var9 = var1.l(var2).d();
            }

            double var10 = var8.getX() + 0.5D * var8.getWidth() + var7.c(this.t);
            double var12 = var8.getY() + 0.5D * var8.getHeight() + var7.d(this.t);
            double var14 = var9.a();
            double var16 = var9.b();
            if(Math.abs(var10 - var14) < 0.001D && Math.abs(var12 - var16) < 0.001D) {
               return true;
            }
         }
      }

      var10000 = false;
      return var10000;
   }

   private boolean a(y.c.d var1, y.c.c var2) {
      if(var2 != null) {
         y.f.aE var3 = (y.f.aE)var2.b(var1);
         if(var3 != null && var3.a()) {
            return true;
         }
      }

      return false;
   }

   public void a(Object var1) {
      this.h = var1;
   }

   public double b() {
      return this.g;
   }

   static int[] a(K var0) {
      return var0.e;
   }

   static int[] b(K var0) {
      return var0.f;
   }

   static byte a(K var0, byte var1) {
      return var0.t = var1;
   }

   static void a(K var0, y.f.X var1, byte[] var2) {
      var0.a(var1, var2);
   }

   static void a(K var0, y.f.X var1) {
      var0.b(var1);
   }
}
