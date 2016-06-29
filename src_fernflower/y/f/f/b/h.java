package y.f.f.b;

import y.c.A;
import y.c.C;
import y.c.D;
import y.c.x;
import y.d.t;
import y.d.v;
import y.f.X;
import y.f.ae;
import y.f.f.b.i;
import y.f.f.b.j;
import y.f.f.b.n;
import y.f.f.b.o;
import y.f.h.N;
import y.f.h.q;
import y.f.h.r;

public class h {
   private D b;
   private static double c = 0.001D;
   private N d;
   private y.f.h.D e;
   private y.c.h f;
   private A g;
   private boolean h;
   public static int a;

   public h(y.c.i var1) {
      this(new N(var1));
      this.h = true;
   }

   public h(N var1) {
      label11: {
         super();
         this.d = var1;
         if(this.d instanceof y.f.h.D) {
            this.e = (y.f.h.D)this.d;
            if(a == 0) {
               break label11;
            }
         }

         this.e = null;
         this.g = this.a().t();
      }

      this.b = new D();
      this.f = this.a().u();
   }

   public h(y.f.h.D var1) {
      this((N)var1);
   }

   public y.c.i a() {
      return this.d.g();
   }

   public N b() {
      return this.d;
   }

   public y.c.d a(y.c.d var1) {
      return this.d.h(var1);
   }

   public void a(y.c.d var1, y.c.d var2) {
      this.d.b(var1, var2);
   }

   public q c() {
      return this.d.h();
   }

   public void a(y.f.h.p var1) {
      this.d.b(var1);
   }

   public y.f.h.p d() {
      return this.d.i();
   }

   public int e() {
      return this.d.j();
   }

   public y.f.h.p b(y.c.d var1) {
      return this.d.i(var1);
   }

   public void f() {
      this.d.l();
   }

   public r g() {
      return this.d.m();
   }

   public void a(r var1) {
      this.d.a(var1);
   }

   public boolean h() {
      return this.d.n();
   }

   public boolean c(y.c.d var1) {
      return this.d.n(var1);
   }

   protected void a(y.c.q var1, int var2) {
      if(this.e == null) {
         this.j(var1).a(var2);
         if(a == 0) {
            return;
         }
      }

      this.e.a(var1, var2);
   }

   protected int a(y.c.q var1) {
      return this.e == null?this.j(var1).a():this.e.a(var1);
   }

   public boolean b(y.c.q var1) {
      return this.a(var1) == 1;
   }

   public void c(y.c.q var1) {
      this.a((y.c.q)var1, (int)1);
   }

   public boolean d(y.c.q var1) {
      return this.a(var1) == 0;
   }

   public void e(y.c.q var1) {
      this.a((y.c.q)var1, (int)0);
   }

   public void f(y.c.q var1) {
      this.a((y.c.q)var1, (int)2);
   }

   public boolean g(y.c.q var1) {
      return this.a(var1) == 2;
   }

   public void a(y.c.d var1, int var2) {
      this.q(var1).a(var2);
   }

   public void a(y.c.d var1, double var2) {
      this.q(var1).a((int)Math.floor(var2 + c));
   }

   public int d(y.c.d var1) {
      return this.q(var1).a();
   }

   public String e(y.c.d var1) {
      return this.q(var1).b();
   }

   public void a(y.c.d var1, String var2) {
      this.q(var1).a(var2);
   }

   public void a(y.c.d var1, char var2) {
      char[] var3 = new char[]{var2};
      this.q(var1).a(new String(var3));
   }

   public void a(y.c.d var1, o var2) {
      this.q(var1).a(var2.toString());
   }

   public void f(y.c.d var1) {
      y.c.d var2 = this.a(var1);
      String var3 = this.e(var1);
      if(var3 == null) {
         this.a(var2, (String)null);
         if(a == 0) {
            return;
         }
      }

      this.a(var2, a(var3));
   }

   public static String a(String var0) {
      int var4 = a;
      StringBuffer var1 = new StringBuffer();
      int var2 = var0.length() - 1;

      StringBuffer var10000;
      while(true) {
         if(var2 >= 0) {
            o var3 = o.a(var0.charAt(var2));
            var3 = var3.c();
            var10000 = var1.append(var3.toString());
            if(var4 != 0) {
               break;
            }

            --var2;
            if(var4 == 0) {
               continue;
            }
         }

         var10000 = var1;
         break;
      }

      return var10000.toString();
   }

   public void a(y.c.h var1, y.c.d var2, o var3) {
      int var21 = a;
      boolean[] var5 = new boolean[this.e()];
      y.c.d[] var6 = new y.c.d[this.e()];
      r var7 = this.g();
      int var8 = 0;
      q var9 = this.c();

      while(true) {
         if(var9.f()) {
            y.f.h.p var10 = var9.a();
            var7.a(var10, var8);
            var6[var8] = null;
            var5[var8] = false;
            ++var8;
            var9.g();
            if(var21 != 0) {
               break;
            }

            if(var21 == 0) {
               continue;
            }
         }

         var9 = this.c();
         break;
      }

      y.c.d var22 = this.a(var2);
      y.f.h.p var11 = this.b(var22);
      this.a(this.a(var22), var3.toString());
      var6[var7.a(var11)] = var22;
      int var12 = 0;
      y.f.h.p var4 = var11;

      label108:
      while(var12 < this.e()) {
         label106:
         while(var21 == 0) {
            if(var5[var7.a(var4)] || var6[var7.a(var4)] == null) {
               var9.g();
               if(!var9.f()) {
                  var9 = this.c();
               }

               var4 = var9.a();
               if(var21 == 0) {
                  continue;
               }
            }

            y.c.d var13 = var6[var7.a(var4)];
            o var14 = o.a(this.e(this.a(var13)).charAt(0));
            var14 = var14.c();
            y.c.e var15 = var4.a();

            while(true) {
               if(var15.a() != var13) {
                  var15.g();
                  if(var21 != 0) {
                     break;
                  }

                  if(var21 == 0) {
                     continue;
                  }

                  var22 = var13;
               } else {
                  var22 = var13;
               }

               var15.b();
               var13 = var15.a();
               break;
            }

            while(true) {
               o var16 = var14.c();
               var16 = var16.b(this.d(var13));
               String var17 = (String)var1.b(var13);
               String var18 = null;
               if(var17.length() > 0) {
                  StringBuffer var19 = new StringBuffer(var16.toString());
                  int var20 = 0;
                  int var10000 = var20;
                  int var10001 = var17.length();

                  while(true) {
                     if(var10000 >= var10001) {
                        var18 = var19.toString();
                        break;
                     }

                     var10000 = var17.charAt(var20);
                     var10001 = 60;
                     if(var21 == 0) {
                        if(var10000 == 60) {
                           var16 = var16.b();
                           if(var17.charAt(var20) == 62) {
                              var16 = var16.a();
                           }
                        } else if(var17.charAt(var20) == 62) {
                           var16 = var16.a();
                        }

                        var19.append(var16.toString());
                        ++var20;
                        if(var21 != 0) {
                           var18 = var19.toString();
                           break;
                        }

                        var10000 = var20;
                        var10001 = var17.length();
                     }
                  }
               } else {
                  var18 = var16.toString();
               }

               this.a(var13, var18);
               var6[var7.a(this.b(this.a(var13)))] = this.a(var13);
               var14 = o.a(var18.charAt(var18.length() - 1));

               while(var13 == var22) {
                  var5[var7.a(var4)] = true;
                  ++var12;
                  if(var21 == 0) {
                     if(var21 == 0) {
                        continue label106;
                     }
                     break label108;
                  }
               }

               var15.b();
               var13 = var15.a();
            }
         }

         return;
      }

      this.a(var7);
   }

   public int[] h(y.c.q var1) {
      int var6 = a;
      int[] var2 = new int[]{0, 0, 0, 0};
      y.c.e var3 = var1.l();

      int[] var10000;
      while(true) {
         if(var3.f()) {
            y.c.d var4 = var3.a();
            o var5 = o.a(this.e(var4).charAt(0));
            var10000 = var2;
            if(var6 != 0) {
               break;
            }

            ++var2[var5.f()];
            var3.g();
            if(var6 == 0) {
               continue;
            }
         }

         var10000 = var2;
         break;
      }

      return var10000;
   }

   public int[][] i(y.c.q var1) {
      int var6 = a;
      int[][] var2 = new int[][]{{0, 0, 0}, {0, 0, 0}, {0, 0, 0}, {0, 0, 0}};
      y.c.e var3 = var1.l();

      while(var3.f()) {
         label42: {
            y.c.d var4 = var3.a();
            o var5 = o.a(this.e(var4).charAt(0));
            if(this.d(var4.d()) || this.b(var4.d())) {
               ++var2[var5.f()][1];
               if(var6 == 0) {
                  break label42;
               }
            }

            if(this.d(this.a(var4)) == 1) {
               ++var2[var5.f()][0];
               if(var6 == 0) {
                  break label42;
               }
            }

            if(this.d(this.a(var4)) == 3) {
               ++var2[var5.f()][2];
               if(var6 == 0) {
                  break label42;
               }
            }

            y.g.o.a((Object)("Cannot classify edge : " + var4));
         }

         var3.g();
         if(var6 != 0) {
            break;
         }
      }

      return var2;
   }

   public int g(y.c.d var1) {
      o var2 = o.a(this.e(var1).charAt(0));
      return var2.f();
   }

   public o h(y.c.d var1) {
      return o.a(this.e(var1).charAt(0));
   }

   public int i(y.c.d var1) {
      i var2 = this.q(var1);
      return var2.c();
   }

   public boolean j(y.c.d var1) {
      i var2 = this.q(var1);
      return var2.c() != Integer.MIN_VALUE;
   }

   public void b(y.c.d var1, int var2) {
      i var3 = this.q(var1);
      var3.b(var2);
   }

   public double k(y.c.d var1) {
      i var2 = this.q(var1);
      return var2.d();
   }

   public void b(y.c.d var1, double var2) {
      i var4 = this.q(var1);
      var4.a(var2);
   }

   public void c(y.c.d var1, int var2) {
      i.a(this.q(var1), var2);
   }

   public void d(y.c.d var1, int var2) {
      i.b(this.q(var1), var2);
   }

   public int l(y.c.d var1) {
      return i.a(this.q(var1));
   }

   public int m(y.c.d var1) {
      return i.b(this.q(var1));
   }

   public void a(n var1) {
      this.b.add(var1);
   }

   public C i() {
      return this.b.m();
   }

   public y.c.f e(y.c.d var1, int var2) {
      int var11 = a;
      y.f.h.D var3 = (y.f.h.D)this.b();
      if(this.e(var1).length() != 1) {
         throw new RuntimeException("Shape not simple: " + this.e(var1));
      } else {
         o var4 = this.h(var1);
         o var5 = var4.c();
         int var6 = this.d(var1);
         int var7 = this.d(this.a(var1));
         y.c.f var8 = var3.a(var1, var2);
         y.c.e var9 = var8.a();

         while(var9.f()) {
            y.c.d var10;
            label33: {
               var10 = var9.a();
               this.a(var10, var4);
               this.a(this.a(var10), var5);
               if(var10.d() != var1.d()) {
                  this.a((y.c.d)this.a(var10), (int)2);
                  if(var11 == 0) {
                     break label33;
                  }
               }

               this.a(this.a(var10), var7);
            }

            label28: {
               if(var10.c() != var1.c()) {
                  this.a((y.c.d)var10, (int)2);
                  if(var11 == 0) {
                     break label28;
                  }
               }

               this.a(var10, var6);
            }

            if(var10.d() != var1.d()) {
               this.e(var10.d());
            }

            var9.g();
            if(var11 != 0) {
               break;
            }
         }

         return var8;
      }
   }

   public void n(y.c.d var1) {
      int var14 = a;
      if(this.d.n(var1)) {
         throw new IllegalArgumentException("Edge: " + var1 + " is inserted !");
      } else {
         String var2 = this.e(var1);
         if(var2.length() != 1) {
            y.c.d var3 = this.a(var1);
            String var4 = this.e(var3);
            y.f.h.D var5 = (y.f.h.D)this.b();
            y.c.f var6 = var5.a(var1, var2.length() - 1);
            int var7 = 0;
            y.c.e var8 = var6.a();

            while(var8.f()) {
               y.c.d var9;
               y.c.d var10;
               y.c.q var11;
               int var12;
               int var13;
               label41: {
                  var9 = var8.a();
                  var10 = this.a(var9);
                  var11 = var9.d();
                  if(var7 == 0) {
                     this.a(var9, this.d(var1));
                     if(var14 == 0) {
                        break label41;
                     }
                  }

                  var12 = o.a(var2.charAt(var7 - 1)).f();
                  var13 = o.a(var2.charAt(var7)).f();
                  this.a(var9, o.a(var12 - var13).f());
               }

               label36: {
                  if(var7 == var2.length() - 1) {
                     this.a(var10, this.d(var3));
                     if(var14 == 0) {
                        break label36;
                     }
                  }

                  var12 = o.a(var4.charAt(var4.length() - var7 - 2)).f();
                  var13 = o.a(var4.charAt(var4.length() - var7 - 1)).f();
                  this.a(var10, o.a(var12 - var13).f());
                  this.f(var11);
                  var5.d(var11);
               }

               if(var2.charAt(var7) != 43) {
                  this.a(var9, var2.charAt(var7));
               }

               if(var4.charAt(var4.length() - var7 - 1) != 43) {
                  this.a(var10, var4.charAt(var4.length() - var7 - 1));
               }

               ++var7;
               var8.g();
               if(var14 != 0) {
                  break;
               }
            }

         }
      }
   }

   public void j() {
      int var20 = a;
      y.c.i var1 = this.a();
      y.f.h.D var2 = (y.f.h.D)this.b();
      x var3 = var1.o();

      while(true) {
         if(var3.f()) {
            y.c.q var4 = var3.e();
            if(var20 != 0) {
               break;
            }

            if(this.g(var4)) {
               y.c.e var5 = var4.l();
               y.c.d var6 = var5.a();
               var5.g();
               y.c.d var7 = var5.a();
               if(this.h(var6).c().a(this.h(var7))) {
                  label82: {
                     y.c.d var8 = var2.h(var6);
                     y.c.d var9 = var2.h(var7);
                     String var10 = this.e(var8);
                     var10 = var10 + this.e(var7).substring(1);
                     double var11 = (double)this.d(var8);
                     double var13 = (double)this.d(var9);
                     boolean var15 = var2.i(var6) == var2.i();
                     boolean var16 = var2.i(var8) == var2.i();
                     y.c.d var17 = var2.h(var4);
                     y.c.d var18 = var2.h(var17);
                     X var19;
                     if(var17.c() == var8.c() && var17.d() == var7.d()) {
                        this.a(var17, var10);
                        this.f(var17);
                        this.a(var17, var11);
                        this.a(var18, var13);
                        if(var16) {
                           var2.b((y.f.h.p)var2.i(var17));
                        }

                        if(var15) {
                           var2.b((y.f.h.p)var2.i(var18));
                        }

                        if(!(var1 instanceof X)) {
                           break label82;
                        }

                        var19 = (X)var1;
                        var19.c(var17, var19.p(var8));
                        var19.d(var17, var19.q(var7));
                        var19.b(var17, v.a);
                        if(var20 == 0) {
                           break label82;
                        }
                     }

                     if(var17.c() != var9.c() || var17.d() != var6.d()) {
                        throw new RuntimeException("Error in remove 180 degree bends");
                     }

                     this.a(var18, var10);
                     this.f(var18);
                     this.a(var17, var13);
                     this.a(var18, var11);
                     if(var15) {
                        var2.b((y.f.h.p)var2.i(var17));
                     }

                     if(var16) {
                        var2.b((y.f.h.p)var2.i(var18));
                     }

                     if(var1 instanceof X) {
                        var19 = (X)var1;
                        var19.c(var17, var19.p(var9));
                        var19.d(var17, var19.q(var6));
                        var19.b(var17, v.a);
                        if(var20 != 0) {
                           throw new RuntimeException("Error in remove 180 degree bends");
                        }
                     }
                  }
               }
            }

            var3.g();
            if(var20 == 0) {
               continue;
            }
         }

         var2.k();
         break;
      }

   }

   public void k() {
      int var16 = a;
      X var1 = (X)this.a();
      y.f.h.D var2 = (y.f.h.D)this.b();
      x var3 = var1.o();

      while(true) {
         if(var3.f()) {
            y.c.q var4 = var3.e();
            if(var16 != 0) {
               break;
            }

            if(this.g(var4)) {
               label46: {
                  y.c.e var5 = var4.l();
                  y.c.d var6 = var5.a();
                  var5.g();
                  y.c.d var7 = var5.a();
                  y.c.d var8 = var2.h(var6);
                  y.c.d var9 = var2.h(var7);
                  t var10 = var1.p(var8);
                  t var11 = var1.q(var7);
                  t var12 = var1.l(var4);
                  D var13 = var1.k(var8);
                  var13.add(var12);
                  var13.a(var1.k(var7));
                  y.c.d var14 = var2.h(var4);
                  y.c.d var15 = var2.h(var14);
                  if(var14.c() == var8.c() && var14.d() == var7.d()) {
                     var1.c(var14, var10);
                     var1.d(var14, var11);
                     var1.b(var14, var13);
                     ae.a(var1, var15, var14);
                     if(var16 == 0) {
                        break label46;
                     }
                  }

                  if(var14.c() != var9.c() || var14.d() != var6.d()) {
                     throw new RuntimeException("Error in remove bend");
                  }

                  var1.c(var15, var10);
                  var1.d(var15, var11);
                  var1.b(var15, var13);
                  ae.a(var1, var14, var15);
                  if(var16 != 0) {
                     throw new RuntimeException("Error in remove bend");
                  }
               }
            }

            var3.g();
            if(var16 == 0) {
               continue;
            }
         }

         var2.k();
         break;
      }

   }

   public void l() {
      int var10 = a;
      y.g.o.a(this, "Check if all necessary data is set..");
      y.c.e var1 = this.a().p();

      label168: {
         y.c.d var2;
         String var10000;
         while(true) {
            if(var1.f()) {
               var2 = var1.a();
               var10000 = this.e(var2);
               if(var10 != 0) {
                  break;
               }

               if(var10000 == null) {
                  throw new RuntimeException("Null shape !");
               }

               if(this.e(var2).length() == 0) {
                  throw new RuntimeException("Empty shape !");
               }

               if(this.d(var2) < 0 || this.d(var2) > 4) {
                  throw new RuntimeException("Angle out of bounds !");
               }

               var1.g();
               if(var10 == 0) {
                  continue;
               }

               y.g.o.a(this, 0, "Check if reverse directions are compatible..");
               var1 = this.a().p();
            } else {
               y.g.o.a(this, 0, "Check if reverse directions are compatible..");
               var1 = this.a().p();
            }

            if(!var1.f()) {
               y.g.o.a(this, 0, "Check if sum of angles around a node is four..");
               break label168;
            }

            var2 = var1.a();
            var10000 = this.e(var2);
            break;
         }

         while(true) {
            String var3 = var10000;
            String var4 = a(var3);
            if(var10 != 0) {
               break;
            }

            if(!var4.equals(a(var3))) {
               throw new RuntimeException("Shapes are not compatible for " + var2 + " !");
            }

            var1.g();
            if(var10 != 0) {
               y.g.o.a(this, 0, "Check if sum of angles around a node is four..");
               break;
            }

            if(!var1.f()) {
               y.g.o.a(this, 0, "Check if sum of angles around a node is four..");
               break;
            }

            var2 = var1.a();
            var10000 = this.e(var2);
         }
      }

      x var11 = this.a().o();

      label177: {
         y.c.q var12;
         int var21;
         while(true) {
            if(var11.f()) {
               var12 = var11.e();
               int var13 = 0;
               var21 = var12.c();
               if(var10 != 0) {
                  break;
               }

               if(var21 == 0) {
                  var13 = 4;
               }

               y.c.e var16 = var12.l();

               label180: {
                  while(var16.f()) {
                     var13 += this.d(var16.a());
                     var16.g();
                     if(var10 != 0) {
                        break label180;
                     }

                     if(var10 != 0) {
                        break;
                     }
                  }

                  if(var13 != 4) {
                     throw new RuntimeException("Node [" + var12 + "] has anglesum != 4 (" + var13 + ") !");
                  }

                  var11.g();
               }

               if(var10 == 0) {
                  continue;
               }
            }

            y.g.o.a(this, 0, "Check if angles are compatible with shape..");
            var11 = this.a().o();
            var21 = var11.f();
            break;
         }

         label107:
         while(true) {
            label105:
            while(true) {
               if(var21 == 0) {
                  break label107;
               }

               var12 = var11.e();
               if(var10 != 0) {
                  break label177;
               }

               y.c.e var18 = var12.l();

               while(true) {
                  if(!var18.f()) {
                     break label105;
                  }

                  y.c.d var17 = var18.a();
                  y.c.d var5 = this.d.j(var17);
                  int var6 = this.g(var17);
                  int var7 = this.g(var5);
                  int var8 = this.d(var5);
                  int var9 = (var7 - var6) % 4;
                  var21 = var9;
                  if(var10 != 0) {
                     break;
                  }

                  if(var9 < 0) {
                     var9 += 4;
                  }

                  if(var9 != var8 % 4) {
                     throw new RuntimeException("Angle <-> shape inconsistency ( " + var17 + "[" + this.e(var17) + "],  " + var5 + "[" + this.e(var5) + "], angle field " + var8 + ", shape: " + var9 + " )" + " !");
                  }

                  var18.g();
                  if(var10 != 0) {
                     break label105;
                  }
               }
            }

            var11.g();
            if(var10 != 0) {
               break;
            }

            var21 = var11.f();
         }

         y.g.o.a(this, 0, "Check if outer face is set correctly..");
      }

      if(this.d() == null) {
         throw new RuntimeException("No outer face defined !");
      } else {
         y.f.h.p var14 = this.d();
         boolean var15 = false;
         q var20 = this.c();

         while(true) {
            if(var20.f()) {
               y.f.h.p var19 = var20.a();
               if(var10 != 0) {
                  break;
               }

               if(var14 == var19) {
                  var15 = true;
               }

               var20.g();
               if(var10 == 0) {
                  continue;
               }
            }

            if(!var15) {
               throw new RuntimeException("Non existing face set to outer face : " + var14);
            }
            break;
         }

      }
   }

   public void m() {
      int var3 = a;
      y.c.e var1 = this.a().p();

      while(true) {
         if(var1.f()) {
            y.c.d var2 = var1.a();
            if(this.e(var2) == null) {
               throw new RuntimeException("Null shape !");
            }

            if(this.e(var2).length() != 1) {
               throw new RuntimeException("non-simple shape !");
            }

            var1.g();
            if(var3 == 0) {
               continue;
            }
         }

         return;
      }
   }

   public void n() {
      int var6 = a;
      this.m();
      q var1 = this.c();

      while(var1.f()) {
         y.f.h.p var2 = var1.a();
         int var3 = 0;
         int var4 = 0;
         y.c.e var5 = var2.a();

         while(true) {
            if(var5.f()) {
               var3 += this.d(var5.a());
               ++var4;
               var5.g();
               if(var6 != 0) {
                  break;
               }

               if(var6 == 0) {
                  continue;
               }
            }

            if(this.d() != var2 && var3 != 2 * var4 - 4) {
               throw new RuntimeException("Inner Face ( " + var2 + " ) has wrong angle sum (" + var3 + " != " + (2 * var4 - 4) + " ) !");
            }
            break;
         }

         if(this.d() == var2 && var3 != 2 * var4 + 4) {
            throw new RuntimeException("Outer Face ( " + var2 + " ) has wrong angle sum (" + var3 + " != " + (2 * var4 + 4) + " ) !");
         }

         var1.g();
         if(var6 != 0) {
            break;
         }
      }

   }

   public void o() {
      if(!this.h()) {
         throw new RuntimeException("Graph is not planar !");
      }
   }

   protected boolean o(y.c.d var1) {
      y.c.d var2 = this.d.j(this.d.h(var1));
      int var3 = this.d(var2);
      if(var3 == 1) {
         return true;
      } else if(var3 == 3) {
         return false;
      } else {
         throw new RuntimeException("Undefined Angle: " + var3);
      }
   }

   protected boolean p(y.c.d var1) {
      y.c.d var2 = this.d.k(var1);
      return !this.d(var1.c())?false:(this.g(var1.d()) && this.g(var2.d())?this.d(var1) == 0 && this.o(var2) && !this.o(var1):false);
   }

   public boolean[] p() {
      int var9 = a;
      boolean[] var1 = new boolean[this.a().g()];
      x var2 = this.a().o();

      y.c.d var6;
      y.c.d var7;
      h var14;
      boolean var10000;
      label138:
      while(true) {
         var10000 = var2.f();

         label135:
         while(var10000) {
            y.c.q var3 = var2.e();
            var14 = this;
            if(var9 != 0) {
               break label138;
            }

            if(this.d(var3)) {
               y.c.e var4 = var3.l();

               while(var4.f()) {
                  y.c.d var5 = var4.a();
                  var10000 = this.g(var5.d());
                  if(var9 != 0) {
                     continue label135;
                  }

                  if(var10000) {
                     var6 = this.d.j(var5);
                     var7 = this.d.k(var5);
                     if(this.d(var6) == 0) {
                        label125: {
                           if(!this.g(var6.d())) {
                              var1[var5.b()] = true;
                              if(var9 == 0) {
                                 break label125;
                              }
                           }

                           if(this.o(var6) && this.o(var5)) {
                              var1[var5.b()] = true;
                           }
                        }
                     }

                     if(this.d(var5) == 0) {
                        label151: {
                           if(!this.g(var7.d())) {
                              var1[var5.b()] = true;
                              if(var9 == 0) {
                                 break label151;
                              }
                           }

                           if(!this.o(var7) && !this.o(var5)) {
                              var1[var5.b()] = true;
                           }
                        }
                     }
                  }

                  var4.g();
                  if(var9 != 0) {
                     break;
                  }
               }
            }

            var2.g();
            if(var9 == 0) {
               continue label138;
            }
            break;
         }

         var14 = this;
         break;
      }

      q var10 = var14.d.h();

      do {
         var10000 = var10.f();

         label97:
         while(true) {
            if(!var10000) {
               return var1;
            }

            y.f.h.p var11 = var10.a();
            y.c.d var12 = null;
            y.c.e var13 = var11.a();

            label75: {
               while(var13.f()) {
                  var12 = var13.a();
                  var10000 = this.d(var12.c());
                  if(var9 != 0) {
                     break label75;
                  }

                  if(var10000) {
                     if(!this.p(var12)) {
                        break;
                     }
                  } else if(!this.d(var12.d())) {
                     break;
                  }

                  var13.g();
                  if(var9 != 0) {
                     break;
                  }
               }

               var10000 = var13.f();
            }

            label80: {
               if(var10000) {
                  var13.b();
                  if(var9 == 0) {
                     break label80;
                  }
               }

               var13.i();
            }

            while(true) {
               if(var13.a() == var12) {
                  break label97;
               }

               var6 = var13.a();
               var7 = this.d.k(var6);
               var10000 = this.p(var6);
               if(var9 != 0) {
                  break;
               }

               if(var10000) {
                  label152: {
                     y.c.d var8 = this.d.h(this.d.j(this.d.h(var7)));
                     if(var1[var8.b()]) {
                        var1[var6.b()] = true;
                        if(var9 == 0) {
                           break label152;
                        }
                     }

                     var1[var7.b()] = true;
                  }
               }

               var13.b();
               if(var9 != 0) {
                  break label97;
               }
            }
         }

         var10.g();
      } while(var9 == 0);

      return var1;
   }

   public void q() {
      this.a().a(this.f);
      if(this.e == null) {
         this.a().a(this.g);
      }

      if(this.h) {
         this.d.e();
      }

   }

   protected j j(y.c.q var1) {
      j var2 = (j)this.g.b(var1);
      if(var2 == null) {
         var2 = this.r();
         this.g.a(var1, var2);
      }

      return var2;
   }

   protected j r() {
      return new j();
   }

   protected i q(y.c.d var1) {
      i var2 = (i)this.f.b(var1);
      if(var2 == null) {
         var2 = this.s();
         this.f.a(var1, var2);
      }

      return var2;
   }

   protected i s() {
      return new i(this);
   }
}
