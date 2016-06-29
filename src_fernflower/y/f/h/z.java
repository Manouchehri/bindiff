package y.f.h;

import java.util.ArrayList;
import java.util.List;
import y.f.h.A;
import y.f.h.B;
import y.f.h.C;
import y.f.h.N;

public class z {
   private B a;
   private C b;
   private A c;
   private y.c.i d;
   private ArrayList[] e;
   private double[] f;
   private ArrayList[] g;
   private double[] h;
   private y.c.q[] i;
   private ArrayList[] j;
   private ArrayList[] k;
   private ArrayList l;
   private ArrayList m;
   private y.c.f n;
   private y.c.h o;

   public z(y.c.i var1, y.c.h var2) {
      boolean var6 = N.d;
      super();
      this.d = var1;
      this.o = var2;
      int var3 = var1.e();
      int var4 = var1.g() + 1;
      this.e = new ArrayList[var4];
      this.f = new double[var4];
      this.g = new ArrayList[var4];
      this.h = new double[var4];
      int var5 = 0;

      while(true) {
         if(var5 < var4) {
            this.e[var5] = new ArrayList(var3);
            this.g[var5] = new ArrayList(var3);
            ++var5;
            if(var6) {
               break;
            }

            if(!var6) {
               continue;
            }
         }

         this.k = new ArrayList[var3];
         this.j = new ArrayList[var3];
         break;
      }

      var5 = 0;

      while(true) {
         if(var5 < var1.e()) {
            this.k[var5] = new ArrayList(var3);
            this.j[var5] = new ArrayList(var3);
            ++var5;
            if(var6) {
               break;
            }

            if(!var6) {
               continue;
            }
         }

         this.n = new y.c.f();
         this.i = new y.c.q[var1.f() + 1];
         this.a = new B();
         this.b = new C();
         this.c = new A();
         break;
      }

   }

   public ArrayList a() {
      return this.l;
   }

   public ArrayList b() {
      return this.m;
   }

   public y.c.f c() {
      return this.n;
   }

   public void a(y.c.y var1, int[] var2) {
      boolean var13 = N.d;
      int var3 = var1.size();
      y.c.f var4 = new y.c.f();
      int var5 = 0;
      y.c.x var6 = var1.a();

      while(true) {
         if(var6.f()) {
            ++var5;
            this.i[var5] = var6.e();
            var6.g();
            if(var13) {
               break;
            }

            if(!var13) {
               continue;
            }
         }

         this.n.clear();
         break;
      }

      y.c.q var14 = var1.b();
      y.c.q var7 = var1.c();
      boolean var8 = false;
      y.c.d var9 = var14.b(var7);
      if(var9 == null) {
         var9 = var7.b(var14);
      }

      if(var9 == null) {
         var8 = true;
         var9 = this.d.a(var14, var7);
      }

      int var10 = 0;

      while(true) {
         if(var10 < this.d.g()) {
            this.e[var10].clear();
            this.f[var10] = 0.0D;
            ++var10;
            if(var13) {
               break;
            }

            if(!var13) {
               continue;
            }
         }

         this.a(var2);
         break;
      }

      var10 = var3 - 1;

      int var10000;
      while(true) {
         if(var10 > 0) {
            y.c.q var11 = this.i[var10];
            var10000 = this.k[var11.d()].isEmpty();
            if(var13) {
               break;
            }

            if(var10000 == 0) {
               this.a(var11, this.i, this.e, this.f, var2);
            }

            --var10;
            if(!var13) {
               continue;
            }
         }

         this.l = new ArrayList(this.e[var9.b()]);
         var10 = this.l.indexOf(var9);
         var10000 = var10;
         break;
      }

      if(var10000 >= 0) {
         this.l.remove(var10);
      }

      int var15 = 0;

      y.c.d var12;
      while(true) {
         if(var15 < this.l.size()) {
            var12 = (y.c.d)this.l.get(var15);
            var4.add(var12);
            this.d.d(var12);
            ++var15;
            if(var13) {
               break;
            }

            if(!var13) {
               continue;
            }
         }

         var15 = 0;
         break;
      }

      while(true) {
         if(var15 < this.d.g()) {
            this.e[var15].clear();
            this.f[var15] = 0.0D;
            ++var15;
            if(var13) {
               break;
            }

            if(!var13) {
               continue;
            }
         }

         this.a(var2);
         break;
      }

      var15 = var3 - 1;

      boolean var18;
      while(true) {
         if(var15 > 0) {
            y.c.q var16 = this.i[var15];
            var18 = this.k[var16.d()].isEmpty();
            if(var13) {
               break;
            }

            if(!var18) {
               this.a(var16, this.i, this.e, this.f, var2);
            }

            --var15;
            if(!var13) {
               continue;
            }
         }

         this.m = new ArrayList(this.e[var9.b()]);
         var18 = var8;
         break;
      }

      if(var18) {
         var10 = this.m.indexOf(var9);
         if(var10 >= 0) {
            this.m.remove(var10);
         }
      }

      var15 = 0;

      while(true) {
         if(var15 < this.m.size()) {
            var12 = (y.c.d)this.m.get(var15);
            var4.add(var12);
            this.d.d(var12);
            ++var15;
            if(var13) {
               break;
            }

            if(!var13) {
               continue;
            }
         }

         if(var8) {
            this.d.a(var9);
         }
         break;
      }

      y.c.e var17 = this.d.p();

      while(true) {
         if(var17.f()) {
            var12 = var17.a();
            this.n.add(var12);
            this.d.d(var12);
            var17.g();
            if(var13) {
               break;
            }

            if(!var13) {
               continue;
            }
         }

         var17 = var4.a();
         break;
      }

      while(var17.f()) {
         this.d.e(var17.a());
         var17.g();
         if(var13) {
            break;
         }
      }

   }

   private void a(y.c.q var1, y.c.q[] var2, ArrayList[] var3, double[] var4, int[] var5) {
      boolean var27 = N.d;
      int var6 = var1.d();
      ArrayList var7 = this.k[var6];
      y.c.d var8 = (y.c.d)var7.get(var7.size() - 1);
      int var9 = var5[var8.a(var1).d()];
      int var10 = var5[var6];
      ArrayList var11 = new ArrayList();
      double var12 = 0.0D;
      y.c.y var14 = new y.c.y();
      y.c.e var15 = this.d.p();

      int var10000;
      while(true) {
         if(var15.f()) {
            y.c.d var16 = var15.a();
            var10000 = var16.b();
            if(var27) {
               break;
            }

            int var17 = var10000;
            this.g[var17].clear();
            this.h[var17] = 0.0D;
            var15.g();
            if(!var27) {
               continue;
            }
         }

         var10000 = var10;
         break;
      }

      int var28 = var10000;

      int var10001;
      y.c.q var30;
      label113:
      while(true) {
         var10000 = var28;
         var10001 = var9;

         label110:
         while(var10000 <= var10001) {
            var30 = var2[var28];
            if(var27) {
               break label113;
            }

            y.c.e var31 = var30.j();

            while(var31.f()) {
               y.c.d var18 = var31.a();
               y.c.q var19 = var18.a(var30);
               int var20 = var5[var19.d()];
               var10000 = var20;
               var10001 = var9;
               if(var27) {
                  continue label110;
               }

               if(var20 <= var9 && var20 >= var10 && var14.d(var19) == null) {
                  var14.add(var19);
               }

               var31.g();
               if(var27) {
                  break;
               }
            }

            ++var28;
            if(!var27) {
               continue label113;
            }
            break;
         }

         this.c.a(var5);
         var14.sort(this.c);
         break;
      }

      y.c.x var29 = var14.a();

      while(var29.f()) {
         var30 = var29.e();
         ArrayList var32 = null;
         double var33 = 0.0D;
         ArrayList var34 = this.j[var30.d()];
         int var21 = 0;

         label87:
         while(true) {
            var10000 = var21;
            var10001 = var34.size();

            while(true) {
               y.c.d var22;
               int var23;
               label131: {
                  if(var10000 < var10001) {
                     var22 = (y.c.d)var34.get(var21);
                     var10000 = var5[var22.a(var30).d()];
                     var10001 = var10;
                     if(var27) {
                        break label131;
                     }

                     if(var10000 > var10) {
                        var23 = var22.b();
                        if(var33 < this.h[var23]) {
                           var32 = this.g[var23];
                           var33 = this.h[var23];
                        }

                        ++var21;
                        if(!var27) {
                           break;
                        }
                     }
                  }

                  if(var33 > var12) {
                     var11 = var32;
                     var12 = var33;
                  }

                  var10000 = var21;
                  var10001 = var34.size();
               }

               if(var10000 < var10001) {
                  var22 = (y.c.d)var34.get(var21);
                  if(var5[var22.a(var30).d()] == var10) {
                     var23 = var22.b();
                     var11.add(var22);
                     ArrayList var24 = var3[var23];
                     var24.clear();
                     var24.addAll(var11);
                     var12 += (double)this.o.a(var22);
                     var4[var23] = var12;
                  }
               }

               ArrayList var35 = this.k[var30.d()];
               var23 = 0;

               while(true) {
                  if(var23 >= var35.size()) {
                     break label87;
                  }

                  y.c.d var36 = (y.c.d)var35.get(var23);
                  var10000 = var5[var36.a(var30).d()];
                  var10001 = var9;
                  if(var27) {
                     break;
                  }

                  if(var10000 > var9) {
                     break label87;
                  }

                  if(var30 != var14.b()) {
                     int var25 = var36.b();
                     ArrayList var26 = new ArrayList(var11);
                     var26.addAll(var3[var25]);
                     this.g[var25] = var26;
                     this.h[var25] = var12 + var4[var25];
                  }

                  ++var23;
                  if(var27) {
                     break label87;
                  }
               }
            }
         }

         var29.g();
         if(var27) {
            break;
         }
      }

   }

   private void a(int[] var1) {
      boolean var11 = N.d;
      this.a.a(var1);
      this.b.a(var1);
      y.c.x var2 = this.d.o();

      do {
         int var10000 = var2.f();

         y.c.q var3;
         ArrayList var5;
         ArrayList var6;
         label33:
         while(true) {
            if(var10000 == 0) {
               return;
            }

            var3 = var2.e();
            int var4 = var3.d();
            var5 = this.j[var4];
            var5.clear();
            var6 = this.k[var4];
            var6.clear();
            y.c.e var7 = var3.j();

            while(true) {
               if(!var7.f()) {
                  break label33;
               }

               y.c.d var8 = var7.a();
               int var9 = var1[var3.d()];
               int var10 = var1[var8.a(var3).d()];
               var10000 = var9;
               if(var11) {
                  break;
               }

               label28: {
                  if(var9 < var10) {
                     var6.add(var8);
                     if(!var11) {
                        break label28;
                     }
                  }

                  var5.add(var8);
               }

               var7.g();
               if(var11) {
                  break label33;
               }
            }
         }

         this.a.a(var3);
         y.g.e.a((List)var5, this.a);
         this.b.a(var3);
         y.g.e.a((List)var6, this.b);
         var2.g();
      } while(!var11);

   }
}
