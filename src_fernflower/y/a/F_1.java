package y.a;

import java.util.ArrayList;
import y.a.G;
import y.a.H;
import y.a.I;
import y.a.J;
import y.a.ab;
import y.a.h;
import y.a.m;

class F {
   private y.c.i a;
   private int[] b;
   private int[] c;
   private int[] d;
   private y.c.q e;
   private int[] f;
   private int[] g;
   private y.c.d[] h;
   private int[] i;
   private I[] j;
   private H k;
   private boolean[] l;
   private I m;
   private int[] n;
   private int[] o;
   private int p;
   private int q;
   private boolean[] r;
   private int[] s;
   private int[] t;
   private int[] u;
   private y.c.d[] v;
   private int[] w;
   private int[] x;
   private ArrayList y;
   private ArrayList z;
   private H[] A;
   private H[] B;

   public int a(y.c.i var1, y.c.A var2, y.c.c var3, y.c.c var4, y.c.c var5, y.c.q var6, boolean var7) {
      return this.a(var1, var2, var3, var4, var5, var6, var7, Long.MAX_VALUE);
   }

   public int a(y.c.i var1, y.c.A var2, y.c.c var3, y.c.c var4, y.c.c var5, y.c.q var6, boolean var7, long var8) {
      boolean var16 = h.a;
      if(var1.f() < 1) {
         return 0;
      } else if(var1.f() == 1) {
         var2.a(var1.k(), 0);
         return 1;
      } else {
         long var10 = System.currentTimeMillis();
         this.a = var1;
         this.a(var2, var3, var4, var7, var6, var5, var8, var10);

         F var10000;
         while(true) {
            if(System.currentTimeMillis() - var10 < var8) {
               var10000 = this;
               if(var16) {
                  break;
               }

               y.c.d var12;
               if((var12 = this.e()) != null) {
                  y.c.d var13 = this.a(var12);
                  this.b(var12, var13);
                  if(!var16) {
                     continue;
                  }
               }
            }

            var10000 = this;
            break;
         }

         int var14 = var10000.f();
         y.c.x var15 = var1.o();

         while(var15.f()) {
            var2.a(var15.e(), this.d[var15.e().d()]);
            var15.g();
            if(var16) {
               break;
            }
         }

         return var14;
      }
   }

   private void a(y.c.A var1, y.c.c var2, y.c.c var3, boolean var4, y.c.q var5, y.c.c var6, long var7, long var9) {
      y.c.e var11;
      y.c.d var12;
      boolean var14;
      int var15;
      label169: {
         label172: {
            var14 = h.a;
            this.p = this.a.f();
            this.q = this.a.h();
            this.b = new int[this.q];
            if(var2 != null) {
               var11 = this.a.p();

               do {
                  if(!var11.f()) {
                     break label172;
                  }

                  var12 = var11.a();
                  this.b[var12.b()] = var2.a(var12);
                  var11.g();
                  if(var14) {
                     break label169;
                  }
               } while(!var14);
            }

            var15 = 0;

            while(var15 < this.b.length) {
               this.b[var15] = 1;
               ++var15;
               if(var14) {
                  break label169;
               }

               if(var14) {
                  break;
               }
            }
         }

         this.c = new int[this.q];
      }

      label147: {
         label175: {
            if(var3 != null) {
               var11 = this.a.p();

               do {
                  if(!var11.f()) {
                     break label175;
                  }

                  var12 = var11.a();
                  this.c[var12.b()] = var3.a(var12);
                  var11.g();
                  if(var14) {
                     break label147;
                  }
               } while(!var14);
            }

            var15 = 0;

            while(var15 < this.b.length) {
               this.c[var15] = 1;
               ++var15;
               if(var14) {
                  break label147;
               }

               if(var14) {
                  break;
               }
            }
         }

         this.d = new int[this.p];
      }

      label125: {
         label124: {
            if(var4) {
               y.c.x var17 = this.a.o();

               do {
                  if(!var17.f()) {
                     break label124;
                  }

                  y.c.q var16 = var17.e();
                  this.d[var16.d()] = var1.a(var16);
                  var17.g();
                  if(var14) {
                     break label125;
                  }
               } while(!var14);
            }

            this.b();
         }

         this.f = new int[this.p];
         this.g = new int[this.p];
         this.i = new int[this.p];
         this.h = new y.c.d[this.p];
         this.n = new int[this.q];
      }

      label110: {
         this.o = this.a()?new int[this.q]:null;
         this.m = new I();
         if(var5 == null) {
            this.e = this.a.o().e();
            if(!var14) {
               break label110;
            }
         }

         this.e = var5;
      }

      this.A = new H[this.q];
      this.B = new H[this.q];
      var11 = this.a.p();

      while(true) {
         if(var11.f()) {
            var12 = var11.a();
            int var13 = var12.b();
            this.A[var13] = new H(var13, var12);
            this.B[var13] = new H(var13, var12);
            var11.g();
            if(var14) {
               break;
            }

            if(!var14) {
               continue;
            }
         }

         this.j = new I[this.p];
         break;
      }

      var15 = 0;

      while(true) {
         if(var15 < this.j.length) {
            this.j[var15] = new I();
            ++var15;
            if(var14) {
               break;
            }

            if(!var14) {
               continue;
            }
         }

         this.l = new boolean[this.q];
         break;
      }

      byte var10000;
      label87: {
         if(var6 != null) {
            for(var11 = this.a.p(); var11.f(); var11.g()) {
               var12 = var11.a();
               var10000 = var6.d(var12);
               if(var14) {
                  break label87;
               }

               if(var10000 != 0) {
                  this.l[var12.b()] = true;
               }
            }
         } else {
            this.a(var7);
         }

         this.c();
         this.k = this.m.a;
         this.r = new boolean[this.q];
         this.s = new int[this.p];
         this.u = new int[this.p];
         this.w = new int[this.q];
         this.x = new int[this.q];
         this.v = this.a.n();
         var10000 = 0;
      }

      var15 = var10000;

      while(true) {
         if(var15 < this.q) {
            var12 = this.v[var15];
            this.w[var15] = var12.c().d();
            this.x[var15] = var12.d().d();
            ++var15;
            if(var14) {
               break;
            }

            if(!var14) {
               continue;
            }
         }

         this.y = new ArrayList(this.p);
         this.z = new ArrayList(this.p);
         this.t = new int[this.p];
         break;
      }

      long var18 = var7 - System.currentTimeMillis() + var9;
      if(var18 > 0L) {
         this.d();
      }

   }

   private boolean a() {
      boolean var4 = h.a;
      int var1 = 0;
      int var2 = 0;

      int var10000;
      while(true) {
         if(var2 < this.b.length) {
            int var3 = this.b[var2];
            var1 += var3;
            var10000 = var1;
            if(var4) {
               break;
            }

            if(var1 < 0) {
               return true;
            }

            ++var2;
            if(!var4) {
               continue;
            }
         }

         var10000 = 0;
         break;
      }

      return (boolean)var10000;
   }

   private void b() {
      boolean var7 = h.a;
      y.c.y var1 = m.a(this.a);
      y.c.x var2 = var1.a();

      do {
         int var10000 = var2.f();

         label29:
         while(true) {
            if(var10000 == 0) {
               return;
            }

            y.c.q var3 = var2.e();
            int var4 = this.d[var3.d()];
            y.c.e var5 = var3.l();

            while(true) {
               if(!var5.f()) {
                  break label29;
               }

               y.c.d var6 = var5.a();
               var10000 = var4 + this.c[var6.b()];
               if(var7) {
                  break;
               }

               if(var10000 > this.d[var6.d().d()]) {
                  this.d[var6.d().d()] = var4 + this.c[var6.b()];
               }

               var5.g();
               if(var7) {
                  break label29;
               }
            }
         }

         var2.g();
      } while(!var7);

   }

   private void a(long var1) {
      boolean var11 = h.a;
      ab var3 = new ab();
      var3.a(this.a, this.d, this.c, var1);
      ArrayList var4 = new ArrayList();
      var4.add(this.e);
      boolean[] var5 = new boolean[this.p];
      y.c.e[] var6 = new y.c.e[this.p];
      y.c.x var7 = this.a.o();

      while(true) {
         if(var7.f()) {
            var6[var7.e().d()] = var7.e().j();
            var7.g();
            if(var11) {
               return;
            }

            if(!var11) {
               continue;
            }
         }

         while(true) {
            boolean var10000 = var4.isEmpty();

            y.c.q var12;
            label42:
            while(true) {
               if(var10000) {
                  return;
               }

               var12 = (y.c.q)var4.get(var4.size() - 1);
               var5[var12.d()] = true;
               y.c.e var8 = var6[var12.d()];

               while(true) {
                  if(!var8.f()) {
                     break label42;
                  }

                  y.c.d var9 = var8.a();
                  y.c.q var10 = var9.a(var12);
                  var10000 = var5[var10.d()];
                  if(var11) {
                     break;
                  }

                  if(!var10000 && this.d[var9.d().d()] - this.d[var9.c().d()] - this.c[var9.b()] == 0) {
                     this.l[var9.b()] = true;
                     var4.add(var10);
                     if(!var11) {
                        break label42;
                     }
                  }

                  var8.g();
                  if(var11) {
                     break label42;
                  }
               }
            }

            if(var4.get(var4.size() - 1) == var12) {
               var4.remove(var4.size() - 1);
               if(var11) {
                  return;
               }
            }
         }
      }
   }

   private void c() {
      boolean var9 = h.a;
      ArrayList var1 = new ArrayList();
      var1.add(this.e);
      boolean[] var2 = new boolean[this.p];
      y.c.e[] var3 = new y.c.e[this.p];
      y.c.x var4 = this.a.o();

      while(true) {
         if(var4.f()) {
            var3[var4.e().d()] = var4.e().j();
            var4.g();
            if(var9) {
               return;
            }

            if(!var9) {
               continue;
            }
         }

         while(true) {
            boolean var10000 = var1.isEmpty();

            y.c.q var10;
            label42:
            while(true) {
               if(var10000) {
                  return;
               }

               var10 = (y.c.q)var1.get(var1.size() - 1);
               var2[var10.d()] = true;
               y.c.e var5 = var3[var10.d()];

               while(true) {
                  if(!var5.f()) {
                     break label42;
                  }

                  y.c.d var6 = var5.a();
                  y.c.q var7 = var6.a(var10);
                  var10000 = var2[var7.d()];
                  if(var9) {
                     break;
                  }

                  if(!var10000 && this.l[var6.b()]) {
                     H var8 = this.A[var6.b()];
                     var8.d = var7.d();
                     this.j[var10.d()].a(var8);
                     this.h[var7.d()] = var6;
                     this.m.a(this.B[var6.b()]);
                     var1.add(var7);
                     if(!var9) {
                        break label42;
                     }
                  }

                  var5.g();
                  if(var9) {
                     break label42;
                  }
               }
            }

            if(var1.get(var1.size() - 1) == var10) {
               var1.remove(var1.size() - 1);
               if(var9) {
                  return;
               }
            }
         }
      }
   }

   private void d() {
      boolean var5 = h.a;
      this.a(this.e, (y.c.q)null, 1, 0);
      int var1 = this.a.f();
      y.g.a.a var2 = new y.g.a.a(this.a, var1 + 1);
      y.c.x var4 = this.a.o();

      while(true) {
         if(var4.f()) {
            y.c.q var3 = var4.e();
            var2.a(var3, var1 - this.i[var3.d()]);
            var4.g();
            if(var5) {
               break;
            }

            if(!var5) {
               continue;
            }
         }

         while(!var2.a()) {
            this.a(var2.c());
            if(var5) {
               return;
            }

            if(var5) {
               break;
            }
         }

         var2.b();
         break;
      }

   }

   private void a(y.c.q var1) {
      boolean var9 = h.a;
      if(var1 != this.e) {
         F var10000;
         y.c.d var2;
         int var4;
         label90: {
            int var3;
            label94: {
               var2 = this.h[var1.d()];
               var3 = this.b[var2.b()];
               var4 = 0;
               J var7 = new J((G)null);
               y.c.d var5;
               int var6;
               y.c.e var8;
               if(this.o == null) {
                  var8 = var1.j();

                  do {
                     if(!var8.f()) {
                        break label94;
                     }

                     var5 = var8.a();
                     var6 = var5.b();
                     var10000 = this;
                     if(var9) {
                        break label90;
                     }

                     label96: {
                        if(this.l[var6]) {
                           if(var5 == var2) {
                              break label96;
                           }

                           if(this.a(var5, var2)) {
                              var3 += this.n[var6] - this.b[var6];
                              if(!var9) {
                                 break label96;
                              }
                           }

                           var3 += this.b[var6] - this.n[var6];
                           if(!var9) {
                              break label96;
                           }
                        }

                        if(this.a(var2, var5)) {
                           var3 -= this.b[var6];
                           if(!var9) {
                              break label96;
                           }
                        }

                        var3 += this.b[var6];
                     }

                     var8.g();
                  } while(!var9);
               }

               var8 = var1.j();

               while(var8.f()) {
                  var5 = var8.a();
                  var6 = var5.b();
                  var10000 = this;
                  if(var9) {
                     break label90;
                  }

                  label99: {
                     if(this.l[var6]) {
                        if(var5 == var2) {
                           break label99;
                        }

                        label58: {
                           if(this.a(var5, var2)) {
                              b(this.o[var6], this.n[var6], 0, this.b[var6], var7);
                              a(var4, var3, var7.a, var7.b, var7);
                              if(!var9) {
                                 break label58;
                              }
                           }

                           b(0, this.b[var6], this.o[var6], this.n[var6], var7);
                           a(var4, var3, var7.a, var7.b, var7);
                        }

                        var4 = var7.a;
                        var3 = var7.b;
                        if(!var9) {
                           break label99;
                        }
                     }

                     label53: {
                        if(this.a(var5, var2)) {
                           b(var4, var3, 0, this.b[var6], var7);
                           if(!var9) {
                              break label53;
                           }
                        }

                        a(var4, var3, 0, this.b[var6], var7);
                     }

                     var4 = var7.a;
                     var3 = var7.b;
                  }

                  var8.g();
                  if(var9) {
                     break;
                  }
               }
            }

            this.n[var2.b()] = var3;
            var10000 = this;
         }

         if(var10000.o != null) {
            this.o[var2.b()] = var4;
         }

      }
   }

   private boolean a(y.c.d var1, y.c.d var2) {
      return var1.c() == var2.d() || var1.d() == var2.c();
   }

   private void a(y.c.q var1, y.c.q var2, int var3, int var4) {
      this.b(var1, var2, var3, var4);
   }

   private void b(y.c.q var1, y.c.q var2, int var3, int var4) {
      boolean var27 = h.a;
      int var5 = 0;
      int var6 = var2 == null?-1:var2.d();
      int var7 = var1.d();
      int[] var8 = this.t;
      var8[0] = var7;
      int[] var9 = this.u;
      var9[var7] = 0;
      int[] var10 = this.c;
      I[] var11 = this.j;
      int[] var12 = this.d;
      y.c.d[] var13 = this.h;
      int[] var14 = this.s;
      int[] var15 = this.g;
      int[] var16 = this.i;
      int[] var17 = this.f;
      int[] var18 = this.w;
      int[] var19 = this.x;
      int var20 = var3;

      label41:
      while(var5 >= 0) {
         int var21 = var8[var5];
         if(var14[var21] % 2 == 0) {
            int var22 = var9[var21];
            ++var14[var21];
            var15[var21] = var20;
            var16[var21] = var4;
            int var24;
            if(var21 == var6) {
               y.c.d var23 = var13[var6];
               var24 = var23.b();
               int var25 = var18[var24];
               int var26 = var19[var24];
               var22 = var25 == var6?-var10[var24] - var12[var25] + var12[var26]:var10[var24] + var12[var25] - var12[var26];
            }

            var12[var21] += var22;
            ++var4;
            H var28 = var11[var21].a;

            do {
               if(var28 == null) {
                  continue label41;
               }

               var24 = var28.d;
               var9[var28.d] = var22;
               ++var5;
               var8[var5] = var24;
               var28 = var28.a;
               if(var27) {
                  return;
               }
            } while(!var27);
         }

         ++var14[var21];
         var17[var21] = var20++;
         --var5;
         --var4;
         if(var27) {
            break;
         }
      }

   }

   private boolean a(y.c.d var1, y.c.q var2) {
      return !this.a(var1, var2, this.e);
   }

   private boolean a(y.c.d var1, y.c.q var2, y.c.q var3) {
      int var4 = var1.d().d();
      int var5 = var1.c().d();
      return this.a(var4, var5, var2.d(), var3.d());
   }

   private boolean a(int var1, int var2, int var3, int var4) {
      int var5;
      int var6;
      label36: {
         if(this.f[var1] > this.f[var2]) {
            var5 = this.f[var2];
            var6 = this.g[var2];
            if(!h.a) {
               break label36;
            }
         }

         var5 = this.f[var1];
         var6 = this.g[var1];
      }

      int var7 = this.f[var3];
      int var8 = this.f[var4];
      return (var6 > var7 || var6 > var8 || var5 < var7 || var5 < var8) && (var6 <= var7 && var5 >= var7 || var6 <= var8 && var5 >= var8);
   }

   private y.c.q a(y.c.q var1, y.c.q var2, ArrayList var3, boolean[] var4) {
      boolean var10 = h.a;
      int var7 = var1.d();
      int var8 = var2.d();
      this.z.clear();

      int var10000;
      label89: {
         label88: {
            y.c.d var5;
            y.c.d var6;
            label87:
            while(true) {
               if(this.i[var7] < this.i[var8]) {
                  var6 = this.h[var8];
                  this.z.add(var6);
                  if(var10) {
                     break;
                  }

                  var4[var6.b()] = var6.d() != var2;
                  var2 = var6.a(var2);
                  var8 = var2.d();
                  if(!var10) {
                     continue;
                  }
               }

               while(true) {
                  if(this.i[var7] <= this.i[var8]) {
                     break label87;
                  }

                  var5 = this.h[var7];
                  var3.add(var5);
                  int var10001 = var5.b();
                  y.c.q var10002 = var5.c();
                  if(var10) {
                     var4[var10001] = var10002 != var1;
                     var1 = var5.a(var1);
                     var7 = var1.d();
                     var6 = this.h[var8];
                     this.z.add(var6);
                     var4[var6.b()] = var6.d() != var2;
                     var2 = var6.a(var2);
                     var8 = var2.d();
                     if(var10) {
                        break label88;
                     }
                     break label87;
                  }

                  var4[var10001] = var10002 != var1;
                  var1 = var5.a(var1);
                  var7 = var1.d();
                  if(var10) {
                     break label87;
                  }
               }
            }

            while(var1 != var2) {
               var5 = this.h[var7];
               var10000 = var3.add(var5);
               if(var10) {
                  break label89;
               }

               var4[var5.b()] = var5.c() != var1;
               var1 = var5.a(var1);
               var7 = var1.d();
               var6 = this.h[var8];
               this.z.add(var6);
               var4[var6.b()] = var6.d() != var2;
               var2 = var6.a(var2);
               var8 = var2.d();
               if(var10) {
                  break;
               }
            }
         }

         var10000 = this.z.size() - 1;
      }

      int var9 = var10000;

      while(var9 >= 0) {
         var3.add(this.z.get(var9));
         --var9;
         if(var10) {
            break;
         }
      }

      return var1;
   }

   private y.c.d e() {
      boolean var6 = h.a;
      int[] var1 = this.n;
      int[] var2 = this.o;
      H var3 = this.k;
      int var4 = 0;

      while(true) {
         if(var4++ < this.p) {
            if(var3 == null) {
               var3 = this.m.a;
            }

            if(var2 == null && var1[var3.c] < 0 || var2 != null && var2[var3.c] < 0) {
               y.c.d var5 = var3.e;
               this.k = var3.a;
               return var5;
            }

            var3 = var3.a;
            if(!var6) {
               continue;
            }
         }

         this.k = var3;
         return null;
      }
   }

   private y.c.d a(y.c.d var1) {
      int var2;
      int var3;
      int[] var6;
      int var7;
      int var8;
      int var9;
      boolean var20;
      label60: {
         var20 = h.a;
         var2 = -1;
         var3 = Integer.MAX_VALUE;
         int var4 = var1.c().d();
         int var5 = var1.d().d();
         var6 = this.f;
         var7 = var6[var5];
         if(var6[var4] > var6[var5]) {
            var8 = var6[var5];
            var9 = this.g[var5];
            if(!var20) {
               break label60;
            }
         }

         var8 = var6[var4];
         var9 = this.g[var4];
      }

      int[] var10 = this.w;
      int[] var11 = this.x;
      int[] var12 = this.d;
      int[] var13 = this.c;
      int var14 = this.q - 1;

      while(var14 >= 0) {
         int var15 = var10[var14];
         int var16 = var11[var14];
         int var17 = var12[var16] - var12[var15] - var13[var14];
         if(var3 > var17) {
            int var18 = var6[var15];
            int var19 = var6[var16];
            if((var9 > var19 || var8 < var19 || (var9 > var18 || var8 < var18) && (var9 > var7 || var8 < var7)) && (var9 <= var19 && var8 >= var19 || var9 <= var18 && var8 >= var18 && var9 <= var7 && var8 >= var7)) {
               var3 = var17;
               var2 = var14;
            }
         }

         --var14;
         if(var20) {
            break;
         }
      }

      return this.v[var2];
   }

   private void b(y.c.d var1, y.c.d var2) {
      y.c.q var3;
      y.c.q var4;
      int var5;
      int var6;
      y.c.q var7;
      y.c.q var8;
      boolean var21;
      label113: {
         var21 = h.a;
         this.y.clear();
         var5 = var1.b();
         var6 = var2.b();
         var7 = var2.c();
         var8 = var2.d();
         if(this.a(var1, var8)) {
            var3 = var7;
            this.r[var6] = true;
            var4 = this.a(var7, var8, this.y, this.r);
            if(!var21) {
               break label113;
            }
         }

         var3 = var8;
         this.r[var6] = false;
         var4 = this.a(var8, var7, this.y, this.r);
      }

      int var16;
      label116: {
         int var11;
         int var12;
         J var15;
         boolean var10000;
         boolean var10001;
         label117: {
            label118: {
               y.c.d var9 = var2;
               boolean var10 = true;
               var11 = this.n[var5];
               var12 = this.o == null?0:this.o[var5];
               boolean var13 = this.r[var5];
               int var14 = var3.d();
               var15 = new J((G)null);
               y.c.d var17;
               int var18;
               int var19;
               H var20;
               if(this.o == null) {
                  var16 = 0;

                  do {
                     if(var16 >= this.y.size()) {
                        break label118;
                     }

                     var17 = (y.c.d)this.y.get(var16);
                     var18 = var17.b();
                     var10000 = this.r[var18];
                     var10001 = var13;
                     if(var21) {
                        break label117;
                     }

                     label92: {
                        if(var10000 == var13) {
                           this.n[var18] -= var11;
                           if(!var21) {
                              break label92;
                           }
                        }

                        this.n[var18] += var11;
                     }

                     if(var10) {
                        label123: {
                           this.h[var14] = var9;
                           var19 = var14;
                           var3 = var17.a(var3);
                           var14 = var3.d();
                           var20 = this.A[var18];
                           this.j[var14].b(var20);
                           if(var17 != var1) {
                              this.j[var19].a(var20);
                              var20.d = var14;
                              var9 = var17;
                              if(!var21) {
                                 break label123;
                              }
                           }

                           var10 = false;
                        }
                     }

                     ++var16;
                  } while(!var21);
               }

               var16 = 0;

               while(var16 < this.y.size()) {
                  var17 = (y.c.d)this.y.get(var16);
                  var18 = var17.b();
                  var10000 = this.r[var18];
                  var10001 = var13;
                  if(var21) {
                     break label117;
                  }

                  label72: {
                     if(var10000 == var13) {
                        b(this.o[var18], this.n[var18], var12, var11, var15);
                        if(!var21) {
                           break label72;
                        }
                     }

                     a(this.o[var18], this.n[var18], var12, var11, var15);
                  }

                  this.o[var18] = var15.a;
                  this.n[var18] = var15.b;
                  if(var10) {
                     label124: {
                        this.h[var14] = var9;
                        var19 = var14;
                        var3 = var17.a(var3);
                        var14 = var3.d();
                        var20 = this.A[var18];
                        this.j[var14].b(var20);
                        if(var17 != var1) {
                           this.j[var19].a(var20);
                           var20.d = var14;
                           var9 = var17;
                           if(!var21) {
                              break label124;
                           }
                        }

                        var10 = false;
                     }
                  }

                  ++var16;
                  if(var21) {
                     break;
                  }
               }
            }

            if(this.o == null) {
               this.n[var6] = this.r[var5] == this.r[var6]?-var11:var11;
               if(!var21) {
                  break label116;
               }
            }

            var10000 = this.r[var5];
            var10001 = this.r[var6];
         }

         if(var10000 == var10001) {
            a(var12, var11, var15);
            this.o[var6] = var15.a;
            this.n[var6] = var15.b;
            if(!var21) {
               break label116;
            }
         }

         this.o[var6] = var12;
         this.n[var6] = var11;
      }

      this.l[var5] = false;
      this.l[var6] = true;
      this.m.b(this.B[var5]);
      this.m.a(this.B[var6]);
      var16 = var4.d();
      H var22 = this.A[var6];
      if(this.a(var1, var7)) {
         var22.d = var8.d();
         this.j[var7.d()].a(var22);
         this.a(var4, var8, this.g[var16], this.i[var16]);
         if(!var21) {
            return;
         }
      }

      var22.d = var7.d();
      this.j[var8.d()].a(var22);
      this.a(var4, var7, this.g[var16], this.i[var16]);
   }

   private int f() {
      boolean var5 = h.a;
      int var1 = Integer.MAX_VALUE;
      int var2 = -2147483647;
      int var4 = 0;

      int var10000;
      int var10001;
      while(true) {
         if(var4 < this.d.length) {
            int var3 = this.d[var4];
            var10000 = var3;
            var10001 = var1;
            if(var5) {
               break;
            }

            if(var3 < var1) {
               var1 = var3;
            }

            if(var3 > var2) {
               var2 = var3;
            }

            ++var4;
            if(!var5) {
               continue;
            }
         }

         if(var1 != 0) {
            label51: {
               var4 = 0;

               while(var4 < this.d.length) {
                  this.d[var4] -= var1;
                  ++var4;
                  if(var5) {
                     break label51;
                  }

                  if(var5) {
                     break;
                  }
               }

               var2 -= var1;
            }
         }

         var10000 = var2;
         var10001 = 1;
         break;
      }

      return var10000 + var10001;
   }

   private static void a(int var0, int var1, int var2, int var3, J var4) {
      int var5 = var1 + var3;
      int var6 = (var1 & var3 | (var1 | var3) & ~var5) >>> 31;
      int var7 = var0 + var2 + var6;
      var4.a = var7;
      var4.b = var5;
   }

   private static void b(int var0, int var1, int var2, int var3, J var4) {
      int var5 = var1 - var3;
      int var6 = (~var1 & var3 | ~(var1 ^ var3) & var5) >>> 31;
      int var7 = var0 - var2 - var6;
      var4.a = var7;
      var4.b = var5;
   }

   private static void a(int var0, int var1, J var2) {
      int var3 = ~var1 + 1;
      int var4 = (~var1 & ~var3) >>> 31;
      int var5 = ~var0 + var4;
      var2.a = var5;
      var2.b = var3;
   }
}
