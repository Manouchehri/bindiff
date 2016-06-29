package y.f.i.a;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import y.f.i.a.H;
import y.f.i.a.I;
import y.f.i.a.M;
import y.f.i.a.P;
import y.f.i.a.R;
import y.f.i.a.U;
import y.f.i.a.W;
import y.f.i.a.X;
import y.f.i.a.Y;
import y.f.i.a.Z;
import y.f.i.a.aa;
import y.f.i.a.ab;
import y.f.i.a.ac;
import y.f.i.a.ad;
import y.f.i.a.bR;
import y.f.i.a.bz;
import y.f.i.a.f;
import y.f.i.a.v;
import y.f.i.a.w;
import y.f.i.a.x;

public class V {
   private y.c.h b;
   int a;
   private Z c;
   private y.c.D d = new y.c.D();
   private y.c.D e = new y.c.D();
   private y.c.D f = new y.c.D();
   private y.c.D g = new y.c.D();
   private bz h = new bz();
   private Y i;

   y.c.D a() {
      return this.d;
   }

   public boolean a(ab var1) {
      return this.d.add(var1);
   }

   y.c.D b() {
      return this.e;
   }

   boolean a(bR var1) {
      return this.e.add(var1);
   }

   boolean b(bR var1) {
      return this.e.remove(var1);
   }

   private void a(f var1, aa var2, byte var3) {
      int var5 = ab.a;
      y.c.C var4 = this.b().m();

      while(var4.f()) {
         ((bR)var4.d()).a(var1, var2, var3);
         var4.g();
         if(var5 != 0) {
            break;
         }
      }

   }

   y.c.D c() {
      return this.f;
   }

   public boolean a(H var1) {
      return this.f.add(var1);
   }

   public boolean b(H var1) {
      return this.f.remove(var1);
   }

   public void a(Z var1) {
      int var4 = ab.a;
      this.c = var1;
      this.b = y.g.M.b();
      this.a = 0;
      Iterator var2 = this.d.iterator();

      while(var2.hasNext()) {
         ab var3 = (ab)var2.next();
         var3.a(var1);
         if(var4 != 0) {
            break;
         }
      }

   }

   public void d() {
      int var5 = ab.a;
      y.c.D var1 = this.a();
      y.c.C var2 = var1.m();

      while(true) {
         if(var2.f()) {
            ((ab)var2.d()).c();
            var2.g();
            if(var5 != 0) {
               break;
            }

            if(var5 == 0) {
               continue;
            }
         }

         var1.clear();
         break;
      }

      y.f.X var6 = this.c.a();
      this.e.clear();
      this.f.clear();
      this.g.clear();
      this.h.c();
      this.i = null;
      this.c = null;
      this.b = null;
      y.c.c var3 = var6.c("y.layout.router.polyline.PathSearch.VISITED_NEIGHBORS");
      if(var3 != null) {
         y.f.c.a.aO var4 = (y.f.c.a.aO)var3.b(var6);
         if(var4 != null) {
            var4.a(this.a);
         }
      }

   }

   void a(y.c.d var1, U var2) {
      this.b.a(var1, var2);
   }

   public U a(y.c.d var1) {
      return (U)this.b.b(var1);
   }

   protected void a(aa var1) {
      int var14 = ab.a;
      y.c.d var2 = var1.c();
      boolean var3 = false;
      x var4 = var1.d();
      ad var5 = var4.f();
      double var6 = 0.0D;

      y.c.C var8;
      label115:
      while(!var3) {
         var8 = this.a().m();

         while(var8.f()) {
            ((ab)var8.d()).b(var1);
            var8.g();
            if(var14 != 0) {
               continue label115;
            }

            if(var14 != 0) {
               break;
            }
         }

         y.c.D var15 = this.c(var1);
         Iterator var9 = var15.iterator();

         boolean var10000;
         label104: {
            label103:
            while(true) {
               if(var9.hasNext()) {
                  f var10 = (f)var9.next();
                  var10.a(var10.f() + this.a(var10));
                  this.h.a(var10, var10.f());
                  var10.a(true);
                  this.a(var10, var1, (byte)1);
                  if(var14 != 0) {
                     break;
                  }

                  if(var14 == 0) {
                     continue;
                  }
               }

               while(true) {
                  if(this.h.a()) {
                     break label103;
                  }

                  f var16 = this.h.b();
                  this.a(var16, var1, (byte)0);
                  var16.a(false);
                  R var19 = var16.a();
                  if(var1.d(var19) && this.b(var16)) {
                     var3 = true;
                     U var11 = a(var16, var1.c());
                     this.a(var11);
                     this.a(var2, var11);
                     if(var14 == 0) {
                        break label103;
                     }
                  }

                  List var20 = this.c.c().r().c(var19);
                  this.a += var20.size();
                  Iterator var12 = var20.iterator();

                  while(true) {
                     if(var12.hasNext()) {
                        R var13 = (R)var12.next();
                        this.a(var16, var13, var1);
                        if(var14 != 0) {
                           break;
                        }

                        if(var14 == 0) {
                           continue;
                        }
                     }

                     if(var6 < 1.0D) {
                        var10000 = this.i.a();
                        if(var14 != 0) {
                           break label104;
                        }

                        if(var10000) {
                           break label103;
                        }
                     }
                     break;
                  }
               }
            }

            var10000 = var3;
         }

         if(!var10000) {
            y.c.C var17 = this.a().m();

            label72: {
               while(var17.f()) {
                  ((ab)var17.d()).c(var1);
                  var17.g();
                  if(var14 != 0) {
                     break label72;
                  }

                  if(var14 != 0) {
                     break;
                  }
               }

               if(!this.h.a()) {
                  ad var18 = var5.q();
                  var6 = Math.min(1.0D, var6 + 0.25D);
                  this.a(var18, var6, var1);
                  var4.a(var18);
                  continue;
               }
            }

            if(var4.f() == var5) {
               break;
            }

            var4.a(var5);
            if(var14 == 0) {
               break;
            }
         }

         if(var4.f() != var5) {
            var4.a(var5);
            if(var14 != 0) {
               break;
            }
         }
      }

      var8 = this.a().m();

      while(true) {
         if(var8.f()) {
            ((ab)var8.d()).d(var1);
            var8.g();
            if(var14 != 0) {
               break;
            }

            if(var14 == 0) {
               continue;
            }
         }

         this.e();
         break;
      }

   }

   protected void a(ad var1, double var2, aa var4) {
      int var13 = ab.a;
      double var5 = 1.0D - Math.min(1.0D, Math.max(0.0D, var2 - 0.3D) * 2.0D);
      var1.b((int)((double)var1.c() * var5));
      double var7 = 1.0D - Math.min(1.0D, var2 * 2.0D);
      var1.l((int)((double)var1.m() * var7));
      var1.o((int)((double)var1.p() * var7));
      var1.n((int)((double)var1.o() * var7));
      double var9 = 1.0D - Math.min(1.0D, var2 * 3.5D);
      var1.k((int)((double)var1.l() * var9));
      var1.h((int)((double)var1.i() * var9));
      var1.f((int)((double)var1.g() * var9));
      var1.g((int)((double)var1.h() * var9));
      var1.i((int)((double)var1.j() * var9));
      var1.j((int)((double)var1.k() * var9));
      var1.m((int)((double)var1.n() * var9));
      double var11 = 1.0D - Math.min(1.0D, var2 * 10.0D);
      var1.a((int)((double)var1.b() * var11));
      var1.c((int)((double)var1.d() * var11));
      var1.d((int)((double)var1.e() * var11));
      var1.e((int)((double)var1.f() * var11));
      if(var13 != 0) {
         y.c.i.g = !y.c.i.g;
      }

   }

   private double a(f var1) {
      int var6 = ab.a;
      double var2 = 0.0D;
      y.c.C var4 = this.a().m();

      double var10000;
      while(true) {
         if(var4.f()) {
            ab var5 = (ab)var4.d();
            var10000 = var2 + var5.a(var1);
            if(var6 != 0) {
               break;
            }

            var2 = var10000;
            var4.g();
            if(var6 == 0) {
               continue;
            }
         }

         var10000 = var2;
         break;
      }

      return var10000;
   }

   private void e() {
      int var2 = ab.a;
      y.c.C var1 = this.g.m();

      while(true) {
         if(var1.f()) {
            ((R)var1.d()).a((HashMap)null);
            var1.g();
            if(var2 != 0) {
               break;
            }

            if(var2 == 0) {
               continue;
            }
         }

         this.g.clear();
         this.h.c();
         break;
      }

   }

   public void b(aa var1) {
      int var13 = ab.a;
      int var2 = var1.b().k();
      if(var2 != 0) {
         long var3 = System.currentTimeMillis() + var1.j();
         Object var5 = this.a().m();

         int var10000;
         label89:
         while(true) {
            if(((y.c.C)var5).f()) {
               ((ab)((y.c.C)var5).d()).a(var1);
               ((y.c.C)var5).g();
               if(var13 != 0) {
                  var10000 = ((y.c.C)var5).f();
                  break;
               }

               if(var13 == 0) {
                  continue;
               }

               var5 = var1.b();
            } else {
               var5 = var1.b();
            }

            while(true) {
               if(((y.c.e)var5).f()) {
                  y.c.d var6 = ((y.c.e)var5).a();
                  var1.a(var6);
                  long var18;
                  var10000 = (var18 = var1.k() - Long.MAX_VALUE) == 0L?0:(var18 < 0L?-1:1);
                  if(var13 != 0) {
                     break label89;
                  }

                  label82: {
                     if(var10000 == 0) {
                        this.i = new X();
                        if(var13 == 0) {
                           break label82;
                        }
                     }

                     long var7 = System.currentTimeMillis();
                     long var9 = (var3 - var7) / (long)var2;
                     long var11 = var7 + Math.max(var9, var1.k());
                     this.i = new W(var7, var11);
                  }

                  this.a(var1);
                  --var2;
                  ((y.c.e)var5).g();
                  if(var13 == 0) {
                     continue;
                  }
               }

               var5 = this.a().m();
               var10000 = ((y.c.C)var5).f();
               break label89;
            }
         }

         while(var10000 != 0) {
            ((ab)((y.c.C)var5).d()).e(var1);
            ((y.c.C)var5).g();
            if(var13 != 0) {
               break;
            }

            var10000 = ((y.c.C)var5).f();
         }

         ac var15 = var1.i();
         Object var14 = var1.b();

         while(true) {
            if(((y.c.e)var14).f()) {
               y.c.d var16 = ((y.c.e)var14).a();
               U var8 = this.a(var16);
               if(var13 == 0) {
                  if(var8 != null) {
                     var15.a(var16, var8);
                     w var17 = var15.a(var16);
                     if(var17 != null) {
                        this.a(var17);
                     }
                  }

                  ((y.c.e)var14).g();
                  if(var13 == 0) {
                     continue;
                  }

                  var14 = this.a().m();
               } else {
                  ((ab)var8).a(var15);
                  ((y.c.C)var14).g();
                  if(var13 != 0) {
                     return;
                  }
               }
            } else {
               var14 = this.a().m();
            }

            do {
               if(!((y.c.C)var14).f()) {
                  return;
               }

               ((ab)((y.c.C)var14).d()).a(var15);
               ((y.c.C)var14).g();
            } while(var13 == 0);

            return;
         }
      }
   }

   private void a(w var1) {
      int var4 = ab.a;
      Iterator var2 = var1.d().iterator();

      while(var2.hasNext()) {
         v var3 = (v)var2.next();
         var3.h().b().a(var3);
         if(var4 != 0) {
            break;
         }
      }

   }

   protected void a(U var1) {
      int var3 = ab.a;
      y.c.C var2 = this.a().m();

      while(var2.f()) {
         ((ab)var2.d()).a(var1);
         var2.g();
         if(var3 != 0) {
            break;
         }
      }

   }

   private y.c.D c(aa var1) {
      int var13 = ab.a;
      y.c.D var2 = new y.c.D();
      boolean var3 = false;
      y.c.C var4 = this.a().m();

      while(var4.f()) {
         ab var5 = (ab)var4.d();
         var5.a((List)var2);
         var4.g();
         if(var13 != 0) {
            break;
         }
      }

      int var14 = 0;
      int var15 = var1.e();

      while(var14 < var15) {
         R var6 = var1.a(var14);
         f var7 = new f(var6);
         I var8 = this.c.c().r();
         List var9 = var8.c(var6);
         Iterator var10 = var9.iterator();

         while(true) {
            if(var10.hasNext()) {
               R var11 = (R)var10.next();
               if(var1.b(var11)) {
                  continue;
               }

               f var12 = new f(var11);
               var12.a(var7);
               var12.a(a(var7, var11));
               var12.a(a(var6, var11));
               var2.add(var12);
               if(var13 != 0) {
                  break;
               }

               if(var13 == 0) {
                  continue;
               }
            }

            ++var14;
            break;
         }

         if(var13 != 0) {
            break;
         }
      }

      return var2;
   }

   private List a(f var1, R var2, y.f.y var3, aa var4) {
      int var20 = ab.a;
      ArrayList var5 = new ArrayList();
      P var6 = a(var1.a(), var2);
      if(var6 == null) {
         throw new IllegalArgumentException("neighborCell has no common border with the PartitionCell of currentEntrance");
      } else {
         label131: {
            y.c.D var7 = this.c();
            if(!var7.isEmpty()) {
               int[] var8 = new int[var7.size()];
               int var9 = 0;
               y.c.p var10 = var7.k();

               int var12;
               while(var10 != null) {
                  H var11 = (H)var10.c();
                  var12 = var5.size();
                  var11.a(var1, var2, var6, var5, var4);
                  var8[var9++] = var5.size() - var12;
                  var10 = var10.a();
                  if(var20 != 0) {
                     break label131;
                  }

                  if(var20 != 0) {
                     break;
                  }
               }

               int var22 = var5.size();
               if(var22 > 1) {
                  int var24 = 0;
                  var12 = 0;

                  while(var12 < var8.length) {
                     int var13 = var24 + var8[var12];
                     if(var20 != 0) {
                        break label131;
                     }

                     int var14 = var24;

                     int var10000;
                     label116: {
                        label115:
                        do {
                           var10000 = var14;

                           label112:
                           while(true) {
                              if(var10000 >= var13) {
                                 break label115;
                              }

                              P var15 = (P)var5.get(var14);
                              var10000 = var13;
                              if(var20 != 0) {
                                 break label116;
                              }

                              int var16 = var13;

                              while(true) {
                                 if(var16 >= var22) {
                                    break label112;
                                 }

                                 P var17 = (P)var5.get(var16);
                                 var10000 = var15.c(var17);
                                 if(var20 != 0) {
                                    break;
                                 }

                                 if(var10000 == 0 && !var17.c(var15)) {
                                    P var18 = P.a(var15, var17);
                                    if(var18 != null) {
                                       var5.add(var18);
                                    }
                                 }

                                 ++var16;
                                 if(var20 != 0) {
                                    break label112;
                                 }
                              }
                           }

                           ++var14;
                        } while(var20 == 0);

                        var10000 = var24 + var8[var12];
                     }

                     var24 = var10000;
                     ++var12;
                     if(var20 != 0) {
                        break;
                     }
                  }
               }
            }

            var5.add(var6);
         }

         if(var3 == var1.d() && var1.c() != null) {
            double var21 = var6.f();
            boolean var23 = var6.a();
            M var25 = var1.c().e();
            M var26 = new M(var25.a() - 0.1D, var25.b() + 0.1D);
            HashSet var27 = new HashSet();
            ArrayList var28 = new ArrayList();
            Iterator var29 = var5.iterator();

            ArrayList var32;
            while(true) {
               if(var29.hasNext()) {
                  P var30 = (P)var29.next();
                  M var31 = var30.e();
                  if(var26.b(var31) > 0.0D || var31.c(var25)) {
                     if(!var27.add(var31)) {
                        continue;
                     }

                     var32 = var28;
                     if(var20 != 0) {
                        break;
                     }

                     var28.add(var30);
                     if(var20 == 0) {
                        continue;
                     }
                  }

                  P var19;
                  M var33;
                  if(var31.a() < var26.a()) {
                     var33 = new M(var31.a(), var26.a());
                     if(var27.add(var33)) {
                        var19 = new P(var33, var21, var23);
                        var28.add(var19);
                     }
                  }

                  if(var31.b() > var26.b()) {
                     var33 = new M(var26.b(), var31.b());
                     if(var27.add(var33)) {
                        var19 = new P(var33, var21, var23);
                        var28.add(var19);
                     }
                  }

                  var33 = M.a(var25, var31);
                  if(var33 == null || !var27.add(var33)) {
                     continue;
                  }

                  var19 = new P(var33, var21, var23);
                  var28.add(var19);
                  if(var20 == 0) {
                     continue;
                  }
               }

               var32 = var28;
               break;
            }

            return var32;
         } else {
            return var5;
         }
      }
   }

   private boolean b(f var1) {
      int var4 = ab.a;
      y.c.C var2 = this.a().m();

      boolean var10000;
      while(true) {
         if(var2.f()) {
            ab var3 = (ab)var2.d();
            var10000 = var3.c(var1);
            if(var4 != 0) {
               break;
            }

            if(!var10000) {
               return false;
            }

            var2.g();
            if(var4 == 0) {
               continue;
            }
         }

         var10000 = true;
         break;
      }

      return var10000;
   }

   protected void a(f var1, R var2, aa var3) {
      int var26 = ab.a;
      y.f.y var4 = a(var1, var2);
      List var5 = this.a(var1, var2, var4, var3);
      f[] var6 = new f[var5.size()];
      HashSet var7 = new HashSet(var5.size());
      y.c.D var8 = new y.c.D();
      int var9 = 0;
      Iterator var10 = var5.iterator();

      while(var10.hasNext()) {
         P var11 = (P)var10.next();
         if(var7.add(var11.e())) {
            f var12 = this.b(var1, var2, var11);
            if(var12 == null || var12.f() >= var1.f()) {
               var6[var9++] = var12;
               var8.add(var11);
               if(var26 != 0) {
                  break;
               }
            }
         }
      }

      y.c.d var27 = var3.c();
      R var28 = var1.a();
      int var29 = var1.j() != null?var1.j().e():0;
      P[] var13 = new P[var8.size()];
      v[] var14 = new v[var8.size()];
      double[] var15 = new double[var8.size()];
      var9 = 0;
      Iterator var16 = var8.iterator();

      double[] var10000;
      P var17;
      while(true) {
         if(var16.hasNext()) {
            var17 = (P)var16.next();
            var13[var9] = var17;
            var14[var9] = new v(var27, var28, var1.c(), var17, var1.d(), var4, var29);
            f var18 = var6[var9];
            var10000 = var15;
            if(var26 != 0) {
               break;
            }

            var15[var9] = var18 != null?var18.f() - var1.f():Double.MAX_VALUE;
            ++var9;
            if(var26 == 0) {
               continue;
            }
         }

         var10000 = this.a(var1, var2, var13, var14, var3, var15);
         break;
      }

      double[] var30 = var10000;
      var9 = 0;

      do {
         int var31 = var9;

         label80:
         while(true) {
            if(var31 >= var13.length) {
               return;
            }

            f var21;
            double var32;
            label77: {
               var17 = var13[var9];
               var32 = var1.f() + var30[var9];
               f var20 = var6[var9];
               if(var20 != null) {
                  if(var32 >= var20.f()) {
                     break;
                  }

                  if(var20.c().d(var17)) {
                     var21 = var20;
                     var20.b((P)null);
                     if(var26 == 0) {
                        break label77;
                     }
                  }

                  var21 = new f(var2);
                  if(var26 == 0) {
                     break label77;
                  }
               }

               var21 = new f(var2);
            }

            label68: {
               var21.a(var1);
               var21.a(var17);
               var21.a(var32);
               var21.a(var14[var9]);
               double var22;
               double var24;
               if(var21.e()) {
                  var22 = this.a(var21, var3);
                  var24 = var32 + var22;
                  this.h.b(var21, var24);
                  this.a(var21, var3, (byte)2);
                  if(var26 == 0) {
                     break label68;
                  }
               }

               var21.a(true);
               var21.a(var4);
               var22 = this.a(var21, var3);
               var24 = var32 + var22;
               this.h.a(var21, var24);
               this.a(var21, var1);
               this.a(var21, var3, (byte)1);
            }

            List var33 = this.a(var1, var2, var17);
            if(var33 == null) {
               break;
            }

            Iterator var23 = var33.iterator();

            while(true) {
               if(!var23.hasNext()) {
                  break label80;
               }

               f var34 = (f)var23.next();
               if(var34 != var21) {
                  var31 = this.h.a(var34);
                  if(var26 != 0) {
                     break;
                  }

                  if(var31 != 0 && var34.f() > var32) {
                     this.h.b(var34);
                     var34.a(false);
                     if(var26 != 0) {
                        break label80;
                     }
                  }
               }
            }
         }

         ++var9;
      } while(var26 == 0);

   }

   private void a(f var1, f var2) {
      R var3 = var2.a();
      HashMap var4 = var3.c();
      if(var4 == null) {
         var4 = new HashMap();
         this.g.add(var3);
         var3.a(var4);
      }

      R var5 = var1.a();
      ArrayList var6 = (ArrayList)var4.get(var5);
      if(var6 == null) {
         var6 = new ArrayList();
         var4.put(var5, var6);
      }

      var6.add(var1);
   }

   private List a(f var1, R var2, P var3) {
      int var9 = ab.a;
      HashMap var4 = var1.a().c();
      if(var4 == null) {
         return null;
      } else {
         ArrayList var5 = (ArrayList)var4.get(var2);
         if(var5 == null) {
            return null;
         } else {
            ArrayList var6 = new ArrayList();
            Iterator var7 = var5.iterator();

            ArrayList var10000;
            while(true) {
               if(var7.hasNext()) {
                  f var8 = (f)var7.next();
                  if(!var8.c().c(var3)) {
                     continue;
                  }

                  var10000 = var6;
                  if(var9 != 0) {
                     break;
                  }

                  var6.add(var8);
                  if(var9 == 0) {
                     continue;
                  }
               }

               var10000 = var6;
               break;
            }

            return var10000;
         }
      }
   }

   private f b(f var1, R var2, P var3) {
      int var8 = ab.a;
      List var4 = this.a(var1, var2, var3);
      if(var4 == null) {
         return null;
      } else {
         f var5 = null;
         Iterator var6 = var4.iterator();

         f var10000;
         while(true) {
            if(var6.hasNext()) {
               f var7 = (f)var6.next();
               var10000 = var5;
               if(var8 != 0) {
                  break;
               }

               if(var5 != null && var5.f() <= var7.f()) {
                  continue;
               }

               var5 = var7;
               if(var8 == 0) {
                  continue;
               }
            }

            var10000 = var5;
            break;
         }

         return var10000;
      }
   }

   protected double[] a(f var1, R var2, P[] var3, v[] var4, aa var5, double[] var6) {
      int var14 = ab.a;
      double[] var7 = new double[var3.length];
      double[] var8 = new double[var6.length];
      System.arraycopy(var6, 0, var8, 0, var6.length);
      y.c.C var9 = this.a().m();

      double[] var10000;
      while(true) {
         if(var9.f()) {
            ab var10 = (ab)var9.d();
            var10000 = var10.a(var1, var2, var3, var4, var8);
            if(var14 != 0) {
               break;
            }

            double[] var11 = var10000;
            byte var12 = 1;
            int var13 = 0;

            int var15;
            label45: {
               while(var13 < var11.length) {
                  var7[var13] += var11[var13];
                  double var16;
                  var15 = (var16 = var8[var13] - Double.MAX_VALUE) == 0.0D?0:(var16 < 0.0D?-1:1);
                  if(var14 != 0) {
                     break label45;
                  }

                  label56: {
                     if(var15 == 0) {
                        var12 = 0;
                        if(var14 == 0) {
                           break label56;
                        }
                     }

                     var8[var13] -= var11[var13];
                     if(var8[var13] <= 0.0D) {
                        var8[var13] = 0.0D;
                        if(var14 == 0) {
                           break label56;
                        }
                     }

                     var12 = 0;
                  }

                  ++var13;
                  if(var14 != 0) {
                     break;
                  }
               }

               var15 = var12;
            }

            if(var15 != 0) {
               return var7;
            }

            var9.g();
            if(var14 == 0) {
               continue;
            }
         }

         var10000 = var7;
         break;
      }

      return var10000;
   }

   protected double a(f var1, aa var2) {
      int var7 = ab.a;
      double var3 = 0.0D;
      ab var5 = null;
      y.c.C var6 = this.a().m();

      while(true) {
         if(var6.f()) {
            var5 = (ab)var6.d();
            var3 += var5.b(var1);
            var6.g();
            if(var7 != 0) {
               break;
            }

            if(var7 == 0) {
               continue;
            }
         }

         if(var5 != null) {
            ;
         }
         break;
      }

      return var3;
   }

   static P a(R var0, R var1) {
      double var2 = Math.max(var1.h(), var0.h());
      double var4 = Math.min(var1.j(), var0.j());
      double var6 = Math.max(var1.i(), var0.i());
      double var8 = Math.min(var1.k(), var0.k());
      return new P(var2, var6, var4, var8);
   }

   static y.f.y a(f var0, R var1) {
      R var2 = var0.a();
      double var3 = Math.max(var2.h(), var1.h());
      double var5 = Math.min(var2.j(), var1.j());
      double var7 = Math.max(var2.i(), var1.i());
      return Math.abs(var3 - var5) > 1.0E-6D?(Math.abs(var7 - var1.i()) < 1.0E-6D?y.f.y.c:y.f.y.a):(Math.abs(var3 - var1.h()) < 1.0E-6D?y.f.y.b:y.f.y.d);
   }

   static U a(f var0, y.c.d var1) {
      int var5 = ab.a;
      if(var0 == null) {
         return null;
      } else {
         y.c.D var2 = new y.c.D();
         f var3 = var0;

         while(var3 != null) {
            var2.a((Object)var3);
            var3 = var3.b();
            if(var5 != 0) {
               break;
            }
         }

         U var4 = new U(var1, var2, var0.f());
         return var4;
      }
   }
}
