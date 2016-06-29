package y.f.c;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.HashSet;
import java.util.List;
import y.f.c.Q;
import y.f.c.a;
import y.f.c.aH;
import y.f.c.i;
import y.f.c.j;
import y.f.c.k;
import y.f.c.l;
import y.f.c.o;
import y.f.c.p;

public class h implements Q {
   private y.c.A n;
   private y.c.p[] o;
   int[] a;
   private y.c.q[] p;
   private float[] q;
   private float[] r;
   private Comparator s;
   private Comparator t;
   private Comparator u;
   y.f.X b;
   int c;
   y.c.y[] d;
   private y.g.ar v;
   private long w = 1000L;
   private long x;
   private y.c.D y;
   private y.c.D z;
   private y.c.p[] A;
   private int B;
   private byte C = 0;
   private boolean D = false;
   private boolean E = true;
   private boolean F = false;
   int[] e;
   int[] f;
   int[] g;
   int[] h;
   public static final Object i = "y.layout.hierarchic.ClassicLayerSequencer.GROUP_KEY";
   private boolean G = false;
   private int[][] H;
   private int[] I;
   Comparator j;
   Comparator k;
   private Comparator J;
   private Comparator K;
   int l;
   final int[] m = new int[4];
   private int L = -1;
   private int M = 40;

   public void a(boolean var1) {
      this.E = var1;
   }

   public boolean a() {
      return this.E;
   }

   public void a(byte var1) {
      this.C = var1;
   }

   public byte b() {
      return this.C;
   }

   public void b(boolean var1) {
      this.D = var1;
   }

   public boolean c() {
      return this.D;
   }

   public void a(long var1) {
      this.w = var1;
   }

   public void a(Q var1) {
      if(var1 instanceof h) {
         h var2 = (h)var1;
         this.b(var2.c());
         this.a(var2.a());
         this.d(var2.h());
         this.a(var2.i());
         this.a(var2.b());
         this.b(var2.c());
      }

   }

   public y.c.y[] a(y.f.X var1, y.c.A var2, int var3) {
      boolean var8 = a.i;
      this.b(var1, var2, var3);
      this.l = 0;
      this.c(false);
      this.d();
      int var4 = this.g();
      if(this.k() && var4 > 0) {
         int[] var5 = this.s();
         int var6 = 0;

         while(var6 < this.M && var4 > 0 && this.k()) {
            int var7;
            label58: {
               label69: {
                  if((var6 & 3) < 2) {
                     this.c(true);
                     if(!var8) {
                        break label69;
                     }
                  }

                  var7 = 0;

                  label45: {
                     while(var7 < this.q.length) {
                        this.q[var7] = this.v.nextFloat();
                        ++var7;
                        if(var8) {
                           break label45;
                        }

                        if(var8) {
                           break;
                        }
                     }

                     var7 = 0;
                  }

                  while(var7 < this.d.length) {
                     this.a((y.c.D)this.d[var7], (Comparator)this.s);
                     ++var7;
                     if(var8) {
                        break label58;
                     }

                     if(var8) {
                        break;
                     }
                  }
               }

               var7 = this.g();
            }

            if(var7 < var4) {
               this.a(var5);
               var4 = var7;
            }

            ++var6;
            if(var8) {
               break;
            }
         }

         this.b(var5);
         this.u();
      }

      this.B = var4;
      return this.e();
   }

   void d() {
      boolean var8 = a.i;
      if(this.G) {
         this.I = new int[this.b.f()];
         this.H = new int[this.d.length][];
         int var1 = 0;

         while(true) {
            y.c.x var9;
            if(var1 < this.d.length) {
               HashSet var2 = new HashSet();
               HashSet var3 = new HashSet();
               y.c.x var10000 = this.d[var1].a();
               if(!var8) {
                  y.c.x var4 = var10000;

                  int var14;
                  while(true) {
                     if(!var4.f()) {
                        var14 = var3.size();
                        break;
                     }

                     y.c.q var5 = var4.e();
                     Object var6 = this.a(var5);
                     var14 = var6 instanceof Number;
                     if(var8) {
                        break;
                     }

                     if(var14 != 0) {
                        Integer var7 = new Integer(((Number)var6).intValue());
                        if(!var2.add(var7)) {
                           var3.add(var7);
                        }
                     }

                     var4.g();
                     if(var8) {
                        var14 = var3.size();
                        break;
                     }
                  }

                  if(var14 > 0) {
                     ArrayList var11 = new ArrayList(var3);
                     y.g.e.a((List)var11, (Comparator)null);
                     this.H[var1] = new int[var11.size()];
                     int var13 = 0;

                     while(true) {
                        if(var13 >= var11.size()) {
                           ++var1;
                           break;
                        }

                        this.H[var1][var13] = ((Integer)var11.get(var13)).intValue();
                        ++var13;
                        if(var8) {
                           break;
                        }

                        if(var8) {
                           ++var1;
                           break;
                        }
                     }
                  } else {
                     ++var1;
                  }

                  if(!var8) {
                     continue;
                  }

                  var1 = 0;
                  if(var1 >= this.d.length) {
                     break;
                  }

                  var9 = this.d[var1].a();
               } else {
                  var9 = var10000;
               }
            } else {
               var1 = 0;
               if(var1 >= this.d.length) {
                  break;
               }

               var9 = this.d[var1].a();
            }

            while(true) {
               while(!var9.f()) {
                  ++var1;
                  if(var8 || var1 >= this.d.length) {
                     return;
                  }

                  var9 = this.d[var1].a();
               }

               y.c.q var10 = var9.e();
               Object var12 = this.a(var10);
               byte var15 = var12 instanceof Number;
               if(!var8) {
                  if(var15 != 0) {
                     if(this.H[var1] != null) {
                        if(Arrays.binarySearch(this.H[var1], ((Number)var12).intValue()) >= 0) {
                           this.I[var10.d()] = ((Number)var12).intValue();
                           if(var8) {
                              this.I[var10.d()] = Integer.MIN_VALUE;
                           }
                        } else {
                           this.I[var10.d()] = Integer.MIN_VALUE;
                        }
                     } else {
                        this.I[var10.d()] = Integer.MIN_VALUE;
                     }
                  }

                  var9.g();
                  if(var8) {
                     ++var1;
                     if(var8 || var1 >= this.d.length) {
                        return;
                     }

                     var9 = this.d[var1].a();
                  }
               } else {
                  if(var15 >= this.d.length) {
                     return;
                  }

                  var9 = this.d[var1].a();
               }
            }
         }
      }

   }

   private void j() {
      // $FF: Couldn't be decompiled
   }

   void b(y.f.X var1, y.c.A var2, int var3) {
      boolean var9 = a.i;
      this.x = System.currentTimeMillis();
      this.b = var1;
      this.n = var2;
      this.y = new y.c.D();
      this.z = new y.c.D();
      this.c = var3;
      this.s = new i(this);
      this.v = new y.g.ar(666L);
      this.d = new y.c.y[var3];
      int var4 = 0;

      while(true) {
         if(var4 < this.d.length) {
            this.d[var4] = new y.c.y();
            ++var4;
            if(var9) {
               break;
            }

            if(!var9) {
               continue;
            }
         }

         this.a = new int[this.b.f()];
         this.p = new y.c.q[this.b.f()];
         this.q = new float[this.b.f() + 1];
         var4 = 0;
         break;
      }

      y.c.x var5 = this.b.o();

      while(true) {
         if(var5.f()) {
            y.c.q var6 = var5.e();
            var4 = Math.max(var4, Math.max(var6.b(), var6.c()));
            var5.g();
            if(var9) {
               break;
            }

            if(!var9) {
               continue;
            }
         }

         this.A = new y.c.p[this.b.g()];
         break;
      }

      y.c.D var10 = new y.c.D();
      y.c.e var11 = this.b.p();

      while(true) {
         if(var11.f()) {
            y.c.d var7 = var11.a();
            y.c.p var8 = var10.a((Object)var7);
            var8.a((Object)null);
            this.A[var7.b()] = var8;
            var10.g();
            var11.g();
            if(var9) {
               break;
            }

            if(!var9) {
               continue;
            }
         }

         this.r = new float[var4 + 2];
         this.o = new y.c.p[this.b.f()];
         this.J = new aH(this.a, (byte)3);
         this.K = new aH(this.a, (byte)4);
         break;
      }

      label47: {
         this.G = this.b.c(i) != null;
         this.b.a((Comparator)this.K, (Comparator)this.J);
         this.j();
         if(this.g == null) {
            this.k = new aH(this.a, (byte)1);
            if(!var9) {
               break label47;
            }
         }

         this.k = new p(this);
      }

      label42: {
         if(this.h == null) {
            this.j = new aH(this.a, (byte)0);
            if(!var9) {
               break label42;
            }
         }

         this.j = new o(this);
      }

      if(y.c.i.g) {
         a.i = !var9;
      }

   }

   y.c.y[] e() {
      this.n = null;
      this.o = null;
      this.p = null;
      this.q = null;
      this.r = null;
      this.s = null;
      this.k = null;
      this.j = null;
      this.b = null;
      y.c.y[] var1 = this.d;
      this.d = null;
      this.I = null;
      this.y = null;
      this.z = null;
      this.t = null;
      this.u = null;
      return var1;
   }

   private boolean k() {
      long var1 = System.currentTimeMillis() - this.x;
      return var1 <= this.w;
   }

   private void l() {
      boolean var2 = a.i;
      y.c.x var1 = this.b.o();

      while(true) {
         if(var1.f()) {
            this.q[var1.e().d()] = (float)this.v.nextInt();
            var1.g();
            if(var2) {
               break;
            }

            if(!var2) {
               continue;
            }
         }

         this.b.a((Comparator)(new j(this)), (Comparator)(new k(this)));
         break;
      }

   }

   void c(boolean var1) {
      boolean var4 = a.i;
      int var2 = 0;

      while(true) {
         if(var2 < this.d.length) {
            this.d[var2].clear();
            ++var2;
            if(var4) {
               break;
            }

            if(!var4) {
               continue;
            }
         }

         if(var1) {
            this.l();
            Arrays.fill(this.a, 0);
            this.b.a((Comparator)null, (Comparator)this.J);
         }
         break;
      }

      y.c.q var5 = this.b.k();
      y.c.x var3 = this.b.o();

      while(var3.f()) {
         if(this.n.a(var5) > this.n.a(var3.e())) {
            var5 = var3.e();
            if(this.n.a(var5) == 0) {
               break;
            }
         }

         var3.g();
         if(var4) {
            break;
         }
      }

      l var6 = new l(this);
      var6.a(false);
      var6.b(true);
      var6.a((y.c.i)this.b, var5);
      this.t();
   }

   private void m() {
      this.b.a((Comparator)this.k, (Comparator)this.j);
   }

   int f() {
      boolean var9 = a.i;
      if(this.e != null && this.f != null) {
         return this.n();
      } else {
         this.m();
         int var1 = 0;
         int var2 = 1;

         while(true) {
            if(var2 < this.d.length) {
               int var3 = this.a((y.c.D)this.d[var2 - 1], (y.c.D)this.d[var2]);
               var1 += var3;
               ++var2;
               if(var9) {
                  break;
               }

               if(!var9) {
                  continue;
               }
            }

            var2 = 0;
            break;
         }

         y.c.x var10 = this.b.o();

         label84:
         while(true) {
            int var10000 = var10.f();

            label81:
            while(var10000 != 0) {
               y.c.q var4 = var10.e();
               if(var9) {
                  return var1;
               }

               int var5;
               int var6;
               int var7;
               y.c.d var8;
               if(this.e != null) {
                  var5 = 0;
                  var6 = 0;
                  var7 = 0;
                  var8 = var4.f();

                  while(var8 != null) {
                     var10000 = this.e[var8.b()];
                     if(var9) {
                        continue label81;
                     }

                     switch(var10000) {
                     case -2:
                     case -1:
                        ++var6;
                        var2 += var7 + var5;
                        if(!var9) {
                           break;
                        }
                     case 0:
                        ++var7;
                        var2 += var5;
                        if(!var9) {
                           break;
                        }
                     case 1:
                        ++var5;
                     }

                     var8 = var8.g();
                     if(var9) {
                        break;
                     }
                  }
               }

               if(this.f != null) {
                  var5 = 0;
                  var6 = 0;
                  var7 = 0;
                  var8 = var4.g();

                  while(var8 != null) {
                     var10000 = this.f[var8.b()];
                     if(var9) {
                        continue label81;
                     }

                     switch(var10000) {
                     case -2:
                     case -1:
                        ++var6;
                        var2 += var7 + var5;
                        if(!var9) {
                           break;
                        }
                     case 0:
                        ++var7;
                        var2 += var5;
                        if(!var9) {
                           break;
                        }
                     case 1:
                        ++var5;
                     }

                     var8 = var8.h();
                     if(var9) {
                        break;
                     }
                  }
               }

               var10.g();
               if(!var9) {
                  continue label84;
               }
               break;
            }

            var1 += var2;
            return var1;
         }
      }
   }

   private int a(y.c.D var1, y.c.D var2) {
      boolean var6 = a.i;
      y.c.p var3 = var1.k();
      y.c.p var4 = var2.k();
      this.y.clear();
      this.z.clear();
      int var5 = 0;

      int var7;
      label55:
      while(true) {
         y.c.p var10000;
         if(var3 != null) {
            var10000 = var4;
            if(!var6) {
               if(var4 != null) {
                  var5 += this.a((y.c.q)var3.c(), this.y, this.z, true);
                  var5 += this.a((y.c.q)var4.c(), this.z, this.y, false);
                  var3 = var3.a();
                  var4 = var4.a();
                  if(!var6) {
                     continue;
                  }
               }

               var10000 = var3;
            }
         } else {
            var10000 = var3;
         }

         while(var10000 != null) {
            var5 += this.a((y.c.q)var3.c(), this.y, this.z, true);
            var3 = var3.a();
            if(var6) {
               break label55;
            }

            if(var6) {
               while(true) {
                  if(var4 == null) {
                     break label55;
                  }

                  var7 = var5 + this.a((y.c.q)var4.c(), this.z, this.y, false);
                  if(var6) {
                     return var7;
                  }

                  var5 = var7;
                  var4 = var4.a();
                  if(var6) {
                     break label55;
                  }
               }
            }

            var10000 = var3;
         }

         while(true) {
            if(var4 == null) {
               break label55;
            }

            var7 = var5 + this.a((y.c.q)var4.c(), this.z, this.y, false);
            if(var6) {
               return var7;
            }

            var5 = var7;
            var4 = var4.a();
            if(var6) {
               break label55;
            }
         }
      }

      var7 = var5;
      return var7;
   }

   private int a(y.c.q var1, y.c.D var2, y.c.D var3, boolean var4) {
      boolean var14 = a.i;
      int var5 = 0;
      int var6 = 0;
      int var7 = 0;
      int var8;
      int var9 = this.a[var8 = var1.d()];
      if(this.o[var8] != null) {
         y.c.p var10 = this.o[var8].a();
         y.c.p var11 = var2.k();

         while(var11 != var10) {
            label59: {
               if(var11.c() == var1) {
                  ++var5;
                  var7 += var6;
                  var2.h(var11);
                  if(!var14) {
                     break label59;
                  }
               }

               ++var6;
            }

            var11 = var11.a();
            if(var14) {
               break;
            }
         }

         this.o[var8] = null;
      }

      int var15;
      int var10000;
      label70: {
         var15 = var5 * var3.size() + var7;
         y.c.q var12;
         int var13;
         y.c.d var16;
         if(var4) {
            var16 = var1.f();

            do {
               if(var16 == null) {
                  break label70;
               }

               var13 = (var12 = var16.d()).d();
               var10000 = this.a[var13];
               if(var14) {
                  return var10000;
               }

               if(var10000 >= var9) {
                  this.o[var13] = var3.b((Object)var12);
               }

               var16 = var16.g();
            } while(!var14);
         }

         var16 = var1.g();

         while(var16 != null) {
            var13 = (var12 = var16.c()).d();
            var10000 = this.a[var13];
            if(var14) {
               return var10000;
            }

            if(var10000 > var9) {
               this.o[var13] = var3.b((Object)var12);
            }

            var16 = var16.h();
            if(var14) {
               break;
            }
         }
      }

      var10000 = var15;
      return var10000;
   }

   private int n() {
      boolean var3 = a.i;
      this.b.a((Comparator)this.t, (Comparator)this.u);
      int var1 = 0;
      int var2 = this.d.length - 1;

      int var10000;
      while(true) {
         if(var2 > 0) {
            var10000 = var1 + this.b(this.d[var2 - 1], this.d[var2]);
            if(var3) {
               break;
            }

            var1 = var10000;
            --var2;
            if(!var3) {
               continue;
            }
         }

         var10000 = var1;
         break;
      }

      return var10000;
   }

   private int b(y.c.D var1, y.c.D var2) {
      boolean var6 = a.i;
      y.c.p var3 = var1.k();
      y.c.p var4 = var2.k();
      this.y.clear();
      this.z.clear();
      int var5 = 0;

      int var7;
      label55:
      while(true) {
         y.c.p var10000;
         if(var3 != null) {
            var10000 = var4;
            if(!var6) {
               if(var4 != null) {
                  var5 += this.b((y.c.q)var3.c(), this.y, this.z, true);
                  var5 += this.b((y.c.q)var4.c(), this.z, this.y, false);
                  var3 = var3.a();
                  var4 = var4.a();
                  if(!var6) {
                     continue;
                  }
               }

               var10000 = var3;
            }
         } else {
            var10000 = var3;
         }

         while(var10000 != null) {
            var5 += this.b((y.c.q)var3.c(), this.y, this.z, true);
            var3 = var3.a();
            if(var6) {
               break label55;
            }

            if(var6) {
               while(true) {
                  if(var4 == null) {
                     break label55;
                  }

                  var7 = var5 + this.b((y.c.q)var4.c(), this.z, this.y, false);
                  if(var6) {
                     return var7;
                  }

                  var5 = var7;
                  var4 = var4.a();
                  if(var6) {
                     break label55;
                  }
               }
            }

            var10000 = var3;
         }

         while(true) {
            if(var4 == null) {
               break label55;
            }

            var7 = var5 + this.b((y.c.q)var4.c(), this.z, this.y, false);
            if(var6) {
               return var7;
            }

            var5 = var7;
            var4 = var4.a();
            if(var6) {
               break label55;
            }
         }
      }

      var7 = var5;
      return var7;
   }

   private int b(y.c.q var1, y.c.D var2, y.c.D var3, boolean var4) {
      boolean var15 = a.i;
      int var6 = this.a[var1.d()];
      int var7 = this.m[0] = this.m[1] = this.m[2] = this.m[3] = 0;
      y.c.d var8;
      int var9;
      y.c.p var10;
      int var11;
      y.c.p var12;
      y.c.p var13;
      y.c.d var14;
      int var16;
      int var10000;
      int var10001;
      if(var4) {
         var8 = var1.f();

         do {
            label175: {
               if(var8 == null) {
                  return var7;
               }

               var10 = this.A[var9 = var8.b()];
               if(var10.c() == null) {
                  var3.a(var10);
                  var10.a(var8);
                  ++this.m[this.e[var9] + 2];
                  if(!var15) {
                     break label175;
                  }
               }

               var2.h(var10);
               var10.a((Object)null);
               var11 = this.g[var9];
               if(var11 > 0) {
                  var12 = var10;

                  label162: {
                     while(var12.b() != null) {
                        ++var7;
                        var12 = var12.b();
                        if(var15) {
                           break label162;
                        }

                        if(var15) {
                           break;
                        }
                     }

                     var7 += var3.size();
                  }

                  if(!var15) {
                     break label175;
                  }
               }

               var16 = this.e[var9];
               var13 = var10.b();

               label151: {
                  label150: {
                     label149: {
                        label148:
                        while(true) {
                           if(var13 != null) {
                              var10000 = this.a[(var14 = (y.c.d)var13.c()).c().d()];
                              var10001 = var6;
                              if(var15) {
                                 break;
                              }

                              if(var10000 > var6 || this.e[var14.b()] > var16) {
                                 ++var7;
                              }

                              var13 = var13.b();
                              if(!var15) {
                                 continue;
                              }
                           }

                           switch(var16) {
                           case -2:
                              var10000 = var7;
                              var10001 = var3.size() - this.m[0];
                              break label148;
                           case -1:
                              break label149;
                           case 0:
                              break label150;
                           case 1:
                              break label151;
                           default:
                              break label175;
                           }
                        }

                        var7 = var10000 + var10001;
                        if(!var15) {
                           break label175;
                        }
                     }

                     var7 += var3.size() - this.m[1];
                     if(!var15) {
                        break label175;
                     }
                  }

                  var7 += var3.size() - this.m[2];
                  if(!var15) {
                     break label175;
                  }
               }

               var7 += var3.size() - this.m[3];
            }

            var8 = var8.g();
         } while(!var15);
      }

      var8 = var1.g();

      while(var8 != null) {
         label179: {
            var10 = this.A[var9 = var8.b()];
            if(var10.c() == null) {
               var3.a(var10);
               var10.a(var8);
               ++this.m[this.f[var9] + 2];
               if(!var15) {
                  break label179;
               }
            }

            var2.h(var10);
            var10.a((Object)null);
            var11 = this.h[var9];
            if(var11 > 0) {
               var12 = var10;

               label104: {
                  while(var12.b() != null) {
                     ++var7;
                     var12 = var12.b();
                     if(var15) {
                        break label104;
                     }

                     if(var15) {
                        break;
                     }
                  }

                  var7 += var3.size();
               }

               if(!var15) {
                  break label179;
               }
            }

            var16 = this.f[var9];
            var13 = var10.b();

            label93: {
               label92: {
                  label91: {
                     label90:
                     while(true) {
                        if(var13 != null) {
                           var14 = (y.c.d)var13.c();
                           var10000 = this.a[var14.d().d()];
                           var10001 = var6;
                           if(var15) {
                              break;
                           }

                           if(var10000 > var6 || this.f[var14.b()] > var16) {
                              ++var7;
                           }

                           var13 = var13.b();
                           if(!var15) {
                              continue;
                           }
                        }

                        switch(var16) {
                        case -2:
                           var10000 = var7;
                           var10001 = var3.size() - this.m[0];
                           break label90;
                        case -1:
                           break label91;
                        case 0:
                           break label92;
                        case 1:
                           break label93;
                        default:
                           break label179;
                        }
                     }

                     var7 = var10000 + var10001;
                     if(!var15) {
                        break label179;
                     }
                  }

                  var7 += var3.size() - this.m[1];
                  if(!var15) {
                     break label179;
                  }
               }

               var7 += var3.size() - this.m[2];
               if(!var15) {
                  break label179;
               }
            }

            var7 += var3.size() - this.m[3];
         }

         var8 = var8.h();
         if(var15) {
            break;
         }
      }

      return var7;
   }

   int g() {
      boolean var9 = a.i;
      if(this.G) {
         this.w();
      }

      y.a.a.a();
      int[] var1 = this.s();
      int var2 = this.f();
      boolean var4 = true;
      boolean var5 = true;
      int var6 = 0;

      boolean var10000;
      while(true) {
         if(var6 < 4) {
            var10000 = this.k();
            if(var9) {
               break;
            }

            if(var10000 && var2 > 0) {
               label63: {
                  int var3 = this.e(var4);
                  if(var3 < var2) {
                     this.a(var1);
                     var2 = var3;
                     if(!var9) {
                        break label63;
                     }
                  }

                  ++var6;
               }

               var4 = !var4;
               if(!var9) {
                  continue;
               }
            }
         }

         this.b(var1);
         this.u();
         var10000 = this.D;
         break;
      }

      int var11;
      if(var10000 && var2 > 0) {
         byte var10 = 1;
         int var7 = 0;

         while(var10 == 1) {
            var11 = var2;
            if(var9) {
               return var11;
            }

            if(var2 <= 0) {
               break;
            }

            int var8;
            label46: {
               this.o();
               this.p();
               var8 = this.f();
               if(var8 < var2) {
                  var10 = 1;
                  this.a(var1);
                  if(!var9) {
                     break label46;
                  }
               }

               var10 = -1;
            }

            var2 = var8;
            ++var7;
            if(var9) {
               break;
            }
         }

         this.b(var1);
         this.u();
      }

      var11 = var2;
      return var11;
   }

   private void o() {
      // $FF: Couldn't be decompiled
   }

   private void p() {
      // $FF: Couldn't be decompiled
   }

   private int a(y.c.q var1, y.c.q var2) {
      return this.n.a(var1) - this.n.a(var2);
   }

   private y.c.h q() {
      boolean var8 = a.i;
      y.c.h var1 = y.g.M.b((Object[])(new y.c.q[this.b.h()]));
      y.c.x var2 = this.b.o();

      while(var2.f()) {
         y.c.q var3 = var2.e();
         int var10000 = var3.c();
         byte var10001 = 1;

         label83:
         while(var10000 > var10001) {
            int var4 = 0;
            y.c.d var6 = var3.f();

            y.c.q var5;
            while(true) {
               if(var6 != null) {
                  var5 = var6.d();
                  var10000 = var5.b();
                  var10001 = 1;
                  if(var8) {
                     break;
                  }

                  if(var10000 == 1 && var5.c() == 1 && (!this.G || this.I[var5.d()] == Integer.MIN_VALUE)) {
                     ++var4;
                  }

                  var6 = var6.g();
                  if(!var8) {
                     continue;
                  }
               }

               var10000 = var4;
               var10001 = 1;
               break;
            }

            if(var10000 <= var10001) {
               break;
            }

            var6 = var3.f();

            while(true) {
               if(var6 == null) {
                  break label83;
               }

               y.c.d var7 = var6;
               var5 = var6.d();
               var10000 = var5.b();
               var10001 = 1;
               if(var8) {
                  break;
               }

               if(var10000 == 1 && var5.c() == 1) {
                  while(var5.b() == 1) {
                     var10000 = var5.c();
                     var10001 = 1;
                     if(var8) {
                        continue label83;
                     }

                     if(var10000 != 1) {
                        break;
                     }

                     var1.a(var7, var3);
                     var7 = var5.f();
                     var5 = var7.d();
                     if(var8) {
                        break;
                     }
                  }

                  var1.a(var7, var3);
               }

               var6 = var6.g();
               if(var8) {
                  break label83;
               }
            }
         }

         var2.g();
         if(var8) {
            break;
         }
      }

      return var1;
   }

   private y.c.h r() {
      boolean var8 = a.i;
      y.c.h var1 = y.g.M.b((Object[])(new y.c.q[this.b.h()]));
      y.c.x var2 = this.b.o();

      while(var2.f()) {
         y.c.q var3 = var2.e();
         int var10000 = var3.b();
         byte var10001 = 1;

         label83:
         while(var10000 > var10001) {
            int var4 = 0;
            y.c.d var6 = var3.g();

            y.c.q var5;
            while(true) {
               if(var6 != null) {
                  var5 = var6.c();
                  var10000 = var5.b();
                  var10001 = 1;
                  if(var8) {
                     break;
                  }

                  if(var10000 == 1 && var5.c() == 1 && (!this.G || this.I[var5.d()] == Integer.MIN_VALUE)) {
                     ++var4;
                  }

                  var6 = var6.h();
                  if(!var8) {
                     continue;
                  }
               }

               var10000 = var4;
               var10001 = 1;
               break;
            }

            if(var10000 <= var10001) {
               break;
            }

            var6 = var3.g();

            while(true) {
               if(var6 == null) {
                  break label83;
               }

               y.c.d var7 = var6;
               var5 = var6.c();
               var10000 = var5.b();
               var10001 = 1;
               if(var8) {
                  break;
               }

               if(var10000 == 1 && var5.c() == 1) {
                  while(var5.b() == 1) {
                     var10000 = var5.c();
                     var10001 = 1;
                     if(var8) {
                        continue label83;
                     }

                     if(var10000 != 1) {
                        break;
                     }

                     var1.a(var7, var3);
                     var7 = var5.g();
                     var5 = var7.c();
                     if(var8) {
                        break;
                     }
                  }

                  var1.a(var7, var3);
               }

               var6 = var6.h();
               if(var8) {
                  break label83;
               }
            }
         }

         var2.g();
         if(var8) {
            break;
         }
      }

      return var1;
   }

   private int e(boolean var1) {
      label39: {
         boolean var3 = a.i;
         int var2;
         if(var1) {
            var2 = 1;

            do {
               if(var2 >= this.d.length) {
                  break label39;
               }

               this.a(var2);
               ++var2;
               if(var3) {
                  return this.f();
               }
            } while(!var3);
         }

         var2 = this.d.length - 2;

         while(var2 >= 0) {
            this.b(var2);
            --var2;
            if(var3) {
               return this.f();
            }

            if(var3) {
               break;
            }
         }
      }

      if(this.E) {
         this.v();
      }

      return this.f();
   }

   void a(int var1) {
      boolean var9 = a.i;
      y.c.y var2 = this.d[var1 - 1];
      y.c.y var3 = this.d[var1];
      int var4 = var2.size();
      int var5 = var3.size();
      y.c.p var6 = var3.k();

      byte var10000;
      while(true) {
         if(var6 != null) {
            y.c.q var7 = (y.c.q)var6.c();
            int var8 = var7.d();
            var10000 = this.C;
            if(var9) {
               break;
            }

            switch(var10000) {
            case 0:
               this.q[var8] = this.b(var7, var5, false, var4);
               if(!var9) {
                  break;
               }
            case 1:
               this.q[var8] = this.a(var7, var5, false, var4);
            }

            this.q[var8] += (float)this.a[var8] / (float)(var4 * 200);
            var6 = var6.a();
            if(!var9) {
               continue;
            }
         }

         this.a((y.c.D)var3, (Comparator)this.s);
         var10000 = this.E;
         break;
      }

      if(var10000 != 0) {
         this.b(var3, true, false);
         this.a(var3, true, false);
         this.b(var2, false, true);
      }

      if(this.G) {
         this.a(var1, true, false);
      }

   }

   void b(int var1) {
      boolean var9 = a.i;
      y.c.y var2 = this.d[var1 + 1];
      y.c.y var3 = this.d[var1];
      int var4 = var2.size();
      int var5 = var3.size();
      y.c.p var6 = var3.k();

      byte var10000;
      while(true) {
         if(var6 != null) {
            y.c.q var7 = (y.c.q)var6.c();
            int var8 = var7.d();
            var10000 = this.C;
            if(var9) {
               break;
            }

            switch(var10000) {
            case 0:
               this.q[var8] = this.b(var7, var5, true, var4);
               if(!var9) {
                  break;
               }
            case 1:
               this.q[var8] = this.a(var7, var5, true, var4);
            }

            this.q[var8] += (float)this.a[var8] / (float)(var4 * 200);
            var6 = var6.a();
            if(!var9) {
               continue;
            }
         }

         this.a((y.c.D)var3, (Comparator)this.s);
         var10000 = this.E;
         break;
      }

      if(var10000 != 0) {
         this.b(var3, false, true);
         this.a(var3, false, true);
         this.b(var2, true, false);
      }

      if(this.G) {
         this.a(var1, false, true);
      }

   }

   private float a(y.c.q var1, int var2, boolean var3, int var4) {
      int var5;
      float var7;
      h var10000;
      label87: {
         label90: {
            boolean var9 = a.i;
            var5 = 0;
            y.c.d var6;
            int var8;
            if(var3) {
               var6 = var1.f();

               do {
                  if(var6 == null) {
                     break label90;
                  }

                  var7 = (float)this.a[var6.d().d()];
                  var10000 = this;
                  if(var9) {
                     break label87;
                  }

                  if(this.f != null) {
                     switch(this.f[var8 = var6.b()]) {
                     case 0:
                     default:
                        break;
                     case 1:
                        var7 += 0.3F;
                        if(!var9) {
                           break;
                        }
                     case -1:
                        var7 -= 0.3F;
                        if(!var9) {
                           break;
                        }
                     case -2:
                        var7 -= 0.31F;
                     }

                     var7 += (float)this.h[var8] * 0.01F;
                  }

                  this.r[var5] = var7;
                  var6 = var6.g();
                  ++var5;
               } while(!var9);
            }

            var6 = var1.g();

            while(var6 != null) {
               var7 = (float)this.a[var6.c().d()];
               var10000 = this;
               if(var9) {
                  break label87;
               }

               if(this.e != null) {
                  switch(this.e[var8 = var6.b()]) {
                  case 0:
                  default:
                     break;
                  case 1:
                     var7 += 0.3F;
                     if(!var9) {
                        break;
                     }
                  case -1:
                     var7 -= 0.3F;
                     if(!var9) {
                        break;
                     }
                  case -2:
                     var7 -= 0.31F;
                  }

                  var7 += (float)this.g[var8] * 0.01F;
               }

               this.r[var5] = var7;
               var6 = var6.h();
               ++var5;
               if(var9) {
                  break;
               }
            }
         }

         var10000 = this;
      }

      Arrays.sort(var10000.r, 0, var5);
      int var10 = var5 >> 1;
      if(var5 == 0) {
         return (float)((var4 - 1) * this.a[var1.d()]) / (float)(var2 - 1);
      } else if(var5 % 2 == 1) {
         return this.r[var10];
      } else if(var5 == 2) {
         return (this.r[0] + this.r[1]) * 0.5F;
      } else {
         var7 = this.r[var10 - 1] - this.r[0];
         float var11 = this.r[var5 - 1] - this.r[var10];
         return var7 == 0.0F && var11 == 0.0F?(this.r[var10 - 1] + this.r[var10]) * 0.5F:(this.r[var10 - 1] * var11 + this.r[var10] * var7) / (var7 + var11);
      }
   }

   private float b(y.c.q var1, int var2, boolean var3, int var4) {
      boolean var9 = a.i;
      float var5 = 0.0F;
      int var6 = var3?var1.c():var1.b();
      if(var6 == 0) {
         var5 = (float)((var4 - 1) * this.a[var1.d()]) / (float)(var2 - 1);
         if(!var9) {
            return var5;
         }
      }

      label84: {
         y.c.d var7;
         int var8;
         if(var3) {
            var7 = var1.f();

            do {
               if(var7 == null) {
                  break label84;
               }

               var5 += (float)this.a[var7.d().d()];
               if(var9) {
                  return var5;
               }

               if(this.f != null) {
                  switch(this.f[var8 = var7.b()]) {
                  case 0:
                  default:
                     break;
                  case 1:
                     var5 += 0.3F;
                     if(!var9) {
                        break;
                     }
                  case -1:
                     var5 -= 0.3F;
                     if(!var9) {
                        break;
                     }
                  case -2:
                     var5 -= 0.31F;
                  }

                  var5 += (float)this.h[var8] * 0.01F;
               }

               var7 = var7.g();
            } while(!var9);
         }

         var7 = var1.g();

         while(var7 != null) {
            var5 += (float)this.a[var7.c().d()];
            if(var9) {
               return var5;
            }

            if(this.e != null) {
               switch(this.e[var8 = var7.b()]) {
               case 0:
               default:
                  break;
               case 1:
                  var5 += 0.3F;
                  if(!var9) {
                     break;
                  }
               case -1:
                  var5 -= 0.3F;
                  if(!var9) {
                     break;
                  }
               case -2:
                  var5 -= 0.31F;
               }

               var5 += (float)this.g[var8] * 0.01F;
            }

            var7 = var7.h();
            if(var9) {
               break;
            }
         }
      }

      var5 /= (float)var6;
      return var5;
   }

   private void a(int[] var1) {
      System.arraycopy(this.a, 0, var1, 0, var1.length);
   }

   private void b(int[] var1) {
      System.arraycopy(var1, 0, this.a, 0, var1.length);
   }

   private int[] s() {
      int[] var1 = new int[this.a.length];
      this.a(var1);
      return var1;
   }

   private void t() {
      boolean var4 = a.i;
      int var2 = 0;

      while(var2 < this.d.length) {
         int var1 = 0;
         y.c.p var3 = this.d[var2].k();

         while(true) {
            if(var3 != null) {
               this.a[((y.c.q)var3.c()).d()] = var1;
               var3 = var3.a();
               ++var1;
               if(var4) {
                  break;
               }

               if(!var4) {
                  continue;
               }
            }

            ++var2;
            break;
         }

         if(var4) {
            break;
         }
      }

   }

   private void u() {
      boolean var5 = a.i;
      int var1 = 0;

      label39:
      while(var1 < this.d.length) {
         y.c.y var2 = this.d[var1];
         y.c.p var3 = var2.k();

         while(var3 != null) {
            y.c.q var4 = (y.c.q)var3.c();
            this.p[this.a[var4.d()]] = var4;
            var3 = var3.a();
            if(var5) {
               continue label39;
            }

            if(var5) {
               break;
            }
         }

         int var6 = 0;
         y.c.p var7 = var2.k();

         while(true) {
            if(var7 != null) {
               var7.a(this.p[var6]);
               var7 = var7.a();
               ++var6;
               if(var5) {
                  break;
               }

               if(!var5) {
                  continue;
               }
            }

            ++var1;
            break;
         }

         if(var5) {
            break;
         }
      }

   }

   private void a(y.c.D var1, Comparator var2) {
      boolean var6 = a.i;
      y.c.C var3 = var1.m();
      int var4 = 0;

      while(true) {
         if(var4 < var1.size()) {
            this.p[var4] = (y.c.q)var3.d();
            ++var4;
            var3.g();
            if(var6) {
               break;
            }

            if(!var6) {
               continue;
            }
         }

         y.g.e.a(this.p, 0, var1.size(), var2);
         var4 = 0;
         break;
      }

      y.c.p var5 = var1.k();

      while(var5 != null) {
         var5.a(this.p[var4]);
         this.a[this.p[var4].d()] = var4;
         var5 = var5.a();
         ++var4;
         if(var6) {
            break;
         }
      }

   }

   private void v() {
      this.a(0, this.d.length - 1);
   }

   void a(int var1, int var2) {
      boolean var6 = a.i;
      boolean var3;
      int var4;
      y.c.y var5;
      if(var1 <= var2) {
         var3 = true;

         label42:
         while(true) {
            if(!var3) {
               return;
            }

            var3 = false;
            var4 = var1;

            while(var4 <= var2) {
               var5 = this.d[var4];
               this.a(var5);
               var3 = this.a(var5, true, true);
               ++var4;
               if(var6) {
                  return;
               }

               if(var6) {
                  break label42;
               }
            }
         }
      }

      var3 = true;

      while(var3) {
         var3 = false;
         var4 = var1;

         while(var4 >= var2) {
            var5 = this.d[var4];
            this.a(var5);
            var3 = this.a(var5, true, true);
            --var4;
            if(var6 || var6) {
               return;
            }
         }
      }

   }

   private void a(y.c.y var1) {
      boolean var3 = a.i;
      y.c.x var2 = var1.a();

      while(var2.f()) {
         var2.e().b(this.j);
         var2.e().a(this.k);
         var2.g();
         if(var3) {
            break;
         }
      }

   }

   private void b(y.c.y var1, boolean var2, boolean var3) {
      boolean var5 = a.i;
      y.c.x var4 = var1.a();

      while(var4.f()) {
         if(var3) {
            var4.e().b(this.j);
         }

         if(var2) {
            var4.e().a(this.k);
         }

         var4.g();
         if(var5) {
            break;
         }
      }

   }

   boolean a(y.c.y var1, boolean var2, boolean var3) {
      boolean var13 = a.i;
      boolean var4 = false;
      y.c.p var5 = var1.k();
      int var6 = 0;

      y.c.q var8;
      y.c.q var9;
      int var10;
      int var11;
      int var12;
      y.c.p var10000;
      while(true) {
         if(var6 < var1.size() - 1) {
            y.c.p var7 = var5;
            var5 = var5.a();
            var8 = (y.c.q)var7.c();
            var10000 = var5;
            if(var13) {
               break;
            }

            label123: {
               var9 = (y.c.q)var5.c();
               if(this.G) {
                  var10 = this.I[var8.d()];
                  var11 = this.I[var9.d()];
                  if((var10 != Integer.MIN_VALUE || var11 != Integer.MIN_VALUE) && var10 != var11) {
                     break label123;
                  }
               }

               var10 = 0;
               var11 = 0;
               if(var2) {
                  var10 = this.b(var8, var8.g(), var9, var9.g());
                  if(var3 || var10 > 0) {
                     var11 = this.b(var9, var9.g(), var8, var8.g());
                  }
               }

               if(var3) {
                  var10 += this.a(var8, var8.f(), var9, var9.f());
                  if(var2 || var10 > 0) {
                     var11 += this.a(var9, var9.f(), var8, var8.f());
                  }
               }

               if(var10 > var11 || var2 && var3 && var11 == var10) {
                  if(var10 > var11) {
                     var4 = true;
                  }

                  var12 = this.a[var8.d()];
                  this.a[var8.d()] = this.a[var9.d()];
                  this.a[var9.d()] = var12;
                  var5.a(var8);
                  var7.a(var9);
               }
            }

            ++var6;
            if(!var13) {
               continue;
            }
         }

         var10000 = var1.l();
         break;
      }

      y.c.p var14 = var10000;
      int var15 = var1.size() - 1;

      boolean var16;
      while(true) {
         if(var15 > 0) {
            var5 = var14;
            var14 = var14.b();
            var8 = (y.c.q)var14.c();
            var9 = (y.c.q)var5.c();
            var16 = this.G;
            if(var13) {
               break;
            }

            label126: {
               if(var16) {
                  var10 = this.I[var8.d()];
                  var11 = this.I[var9.d()];
                  if((var10 != Integer.MIN_VALUE || var11 != Integer.MIN_VALUE) && var10 != var11) {
                     break label126;
                  }
               }

               var10 = 0;
               var11 = 0;
               if(var2) {
                  var10 = this.b(var8, var8.g(), var9, var9.g());
                  var11 = this.b(var9, var9.g(), var8, var8.g());
               }

               if(var3) {
                  var10 += this.a(var8, var8.f(), var9, var9.f());
                  var11 += this.a(var9, var9.f(), var8, var8.f());
               }

               if(var10 > var11 || var2 && var3 && var11 == var10) {
                  if(var10 > var11) {
                     var4 = true;
                  }

                  var12 = this.a[var8.d()];
                  this.a[var8.d()] = this.a[var9.d()];
                  this.a[var9.d()] = var12;
                  var5.a(var8);
                  var14.a(var9);
               }
            }

            --var15;
            if(!var13) {
               continue;
            }
         }

         var16 = var4;
         break;
      }

      return var16;
   }

   private void w() {
      boolean var2 = a.i;
      int var1 = 0;

      while(var1 < this.d.length) {
         this.a(var1, false, false);
         ++var1;
         if(var2) {
            break;
         }
      }

   }

   private void a(int var1, boolean var2, boolean var3) {
      boolean var23 = a.i;
      int[] var4 = this.H[var1];
      if(var4 != null) {
         y.c.y var5 = this.d[var1];
         y.c.D var6 = new y.c.D();
         y.c.D var7 = new y.c.D();
         int var10 = 0;

         label302:
         do {
            int var10000 = var10;

            y.c.p var8;
            y.c.p var9;
            int var11;
            y.c.p var12;
            label299:
            while(true) {
               if(var10000 >= var4.length) {
                  return;
               }

               var11 = var4[var10];
               var8 = null;
               var9 = null;
               var6.clear();
               var7.clear();
               var12 = var5.k();

               while(true) {
                  if(var12 == null) {
                     break label299;
                  }

                  y.c.q var13 = (y.c.q)var12.c();
                  var10000 = this.a(var11, var13);
                  if(var23) {
                     break;
                  }

                  if(var10000 != 0) {
                     var9 = var12;
                     var8 = var12;
                     var12 = var12.a();

                     while(true) {
                        if(var12 == null) {
                           break label299;
                        }

                        var13 = (y.c.q)var12.c();
                        var10000 = this.a(var11, var13);
                        if(var23) {
                           continue label299;
                        }

                        if(var10000 != 0) {
                           var9 = var12;
                        }

                        var12 = var12.a();
                     }
                  }

                  var12 = var12.a();
               }
            }

            if(var8 != var9) {
               var6.a((Object)var8);
               var12 = var8.a();

               label278: {
                  while(var12 != var9) {
                     var10000 = this.a(var11, (y.c.q)var12.c());
                     if(var23) {
                        break label278;
                     }

                     label274: {
                        if(var10000 != 0) {
                           var6.b((Object)var12);
                           if(!var23) {
                              break label274;
                           }
                        }

                        var7.b((Object)var12);
                     }

                     var12 = var12.a();
                     if(var23) {
                        break;
                     }
                  }

                  var6.b((Object)var12);
                  var10000 = var7.size();
               }

               if(var10000 > 0) {
                  int var14;
                  y.c.p[] var24;
                  label339: {
                     var24 = new y.c.p[var7.size()];
                     var7.toArray(var24);
                     int[] var16 = new int[var24.length];
                     Arrays.fill(var16, Integer.MAX_VALUE);
                     int var15;
                     boolean var17 = (var15 = this.a(var11, var5, var6, var24[var24.length - 1], var2, var3)) < 0;
                     var16[var24.length - 1] = var15;
                     if(var24.length == 1) {
                        var14 = var17?0:1;
                        if(!var23) {
                           break label339;
                        }
                     }

                     if(var17) {
                        var14 = var24.length;
                        if(!var23) {
                           break label339;
                        }
                     }

                     var17 = (var15 = this.a(var11, var5, var6, var24[0], var2, var3)) < 0;
                     var16[0] = var15;
                     boolean var18 = var16[0] == 0 && var16[var24.length - 1] == 0;
                     if(!var17 && !var18) {
                        var14 = 0;
                        if(!var23) {
                           break label339;
                        }
                     }

                     int var20;
                     int var21;
                     label314: {
                        if(var18) {
                           var14 = var24.length / 2;
                           if(!var23) {
                              break label314;
                           }
                        }

                        int var19 = var24.length - 1;
                        var20 = 0;

                        label244: {
                           while(var19 - var20 > 1) {
                              var21 = var20 + (var19 - var20) / 2;
                              var15 = this.a(var11, var5, var6, var24[var21], var2, var3);
                              var16[var21] = var15;
                              var10000 = var15;
                              if(var23) {
                                 break label244;
                              }

                              label316: {
                                 if(var15 == 0) {
                                    var17 = var21 < var24.length / 2;
                                    if(!var23) {
                                       break label316;
                                    }
                                 }

                                 var17 = var15 < 0;
                              }

                              if(var17) {
                                 var20 = var21;
                                 if(!var23) {
                                    continue;
                                 }
                              }

                              var19 = var21;
                              if(var23) {
                                 break;
                              }
                           }

                           var10000 = var20;
                        }

                        var14 = var10000;
                     }

                     y.c.q var26 = (y.c.q)var24[var14].c();
                     var20 = this.I[var26.d()];
                     if(var20 != Integer.MIN_VALUE && var20 < var11) {
                        label336: {
                           int var22;
                           if(var15 > 0) {
                              while(true) {
                                 if(var14 > 0) {
                                    var10000 = this.a(var20, (y.c.q)var24[var14 - 1].c());
                                    if(var23) {
                                       break;
                                    }

                                    if(var10000 != 0) {
                                       --var14;
                                       if(!var23) {
                                          continue;
                                       }
                                    }
                                 }

                                 var10000 = var16[var14];
                                 break;
                              }

                              if(var10000 == Integer.MAX_VALUE) {
                                 var16[var14] = this.a(var11, var5, var6, var24[var14], var2, var3);
                              }

                              if(var16[var14] >= 0) {
                                 break label336;
                              }

                              var21 = 0;
                              var22 = var14;

                              label210: {
                                 while(var22 < var24.length) {
                                    var10000 = this.a(var20, (y.c.q)var24[var22].c());
                                    if(var23) {
                                       break label210;
                                    }

                                    if(var10000 == 0) {
                                       break;
                                    }

                                    if(var16[var22] == Integer.MAX_VALUE) {
                                       var16[var22] = this.a(var11, var5, var6, var24[var22], var2, var3);
                                    }

                                    var21 += var16[var22];
                                    ++var22;
                                    if(var23) {
                                       break;
                                    }
                                 }

                                 var10000 = var21;
                              }

                              if(var10000 >= 0) {
                                 break label336;
                              }

                              var14 = var22;
                              if(!var23) {
                                 break label336;
                              }
                           }

                           while(true) {
                              if(var14 < var24.length) {
                                 var10000 = this.a(var20, (y.c.q)var24[var14].c());
                                 if(var23) {
                                    break;
                                 }

                                 if(var10000 != 0) {
                                    ++var14;
                                    if(!var23) {
                                       continue;
                                    }
                                 }
                              }

                              var10000 = var16[var14 - 1];
                              break;
                           }

                           if(var10000 == Integer.MAX_VALUE) {
                              var16[var14 - 1] = this.a(var11, var5, var6, var24[var14], var2, var3);
                           }

                           if(var16[var14 - 1] >= 0) {
                              var21 = 0;
                              var22 = var14 - 1;

                              while(true) {
                                 if(var22 >= 0) {
                                    var10000 = this.a(var20, (y.c.q)var24[var22].c());
                                    if(var23) {
                                       break;
                                    }

                                    if(var10000 != 0) {
                                       if(var16[var22] == Integer.MAX_VALUE) {
                                          var16[var22] = this.a(var11, var5, var6, var24[var22], var2, var3);
                                       }

                                       var21 += var16[var22];
                                       --var22;
                                       if(!var23) {
                                          continue;
                                       }
                                    }
                                 }

                                 var10000 = var21;
                                 break;
                              }

                              if(var10000 > 0) {
                                 var14 = var22 + 1;
                              }
                           }
                        }
                     }
                  }

                  int var25 = 0;

                  label149: {
                     while(var25 < var14) {
                        var5.h(var24[var25]);
                        var5.a(var24[var25], var8);
                        ++var25;
                        if(var23) {
                           break label149;
                        }

                        if(var23) {
                           break;
                        }
                     }

                     var25 = var24.length - 1;
                  }

                  while(var25 >= var14) {
                     var5.h(var24[var25]);
                     var5.b(var24[var25], var9);
                     --var25;
                     if(var23) {
                        continue label302;
                     }

                     if(var23) {
                        break;
                     }
                  }

                  this.a((y.c.D)var5);
               }
            }

            ++var10;
         } while(!var23);

      }
   }

   private int a(int var1, y.c.D var2, y.c.D var3, y.c.p var4, boolean var5, boolean var6) {
      boolean var15 = a.i;
      if(!var5 && !var6) {
         return 0;
      } else {
         int var7 = 0;
         int var8 = 0;
         y.c.q var9 = (y.c.q)var4.c();
         y.c.p var10 = var4.b();
         y.c.p var11 = var4.a();
         int var12 = this.a[((y.c.q)var4.c()).d()] + 1;
         var2.h(var4);
         var2.a(var4, (y.c.p)var3.f());
         this.a(var2);
         this.a(var9, var5, var6);
         y.c.p var13 = var3.k();

         int var10000;
         while(true) {
            y.c.q var14;
            if(this.a[((y.c.q)((y.c.p)var13.c()).c()).d()] < var12) {
               var14 = (y.c.q)((y.c.p)var13.c()).c();
               var10000 = this.a(var1, var14);
               if(var15) {
                  break;
               }

               if(var10000 != 0) {
                  if(var5) {
                     var7 += this.b(var9, var9.g(), var14, var14.g());
                  }

                  if(var6) {
                     var7 += this.a(var9, var9.f(), var14, var14.f());
                  }
               }

               var13 = var13.a();
               if(!var15) {
                  continue;
               }
            }

            var2.h(var4);
            var2.b(var4, (y.c.p)var3.i());
            this.a(var2);
            this.a(var9, var5, var6);

            while(var13 != null) {
               var14 = (y.c.q)((y.c.p)var13.c()).c();
               var10000 = this.a(var1, var14);
               if(var15) {
                  return var10000;
               }

               if(var10000 != 0) {
                  if(var5) {
                     var8 += this.b(var14, var14.g(), var9, var9.g());
                  }

                  if(var6) {
                     var8 += this.a(var14, var14.f(), var9, var9.f());
                  }
               }

               var13 = var13.a();
               if(var15) {
                  break;
               }
            }

            var2.h(var4);
            var2.a(var4, var11);
            this.a(var2);
            this.a(var9, var5, var6);
            var10000 = var7 - var8;
            break;
         }

         return var10000;
      }
   }

   private void a(y.c.q var1, boolean var2, boolean var3) {
      boolean var5 = a.i;
      y.c.e var4;
      if(var2) {
         var4 = var1.k();

         while(var4.f()) {
            var4.a().c().b(this.j);
            var4.g();
            if(var5) {
               return;
            }

            if(var5) {
               break;
            }
         }
      }

      if(var3) {
         var4 = var1.l();

         while(var4.f()) {
            var4.a().d().a(this.k);
            var4.g();
            if(var5) {
               break;
            }
         }
      }

   }

   private void a(y.c.D var1) {
      boolean var4 = a.i;
      int var2 = 0;
      y.c.p var3 = var1.k();

      while(var3 != null) {
         this.a[((y.c.q)var3.c()).d()] = var2++;
         var3 = var3.a();
         if(var4) {
            break;
         }
      }

   }

   private boolean a(int var1, y.c.q var2) {
      return var1 != Integer.MIN_VALUE && this.I[var2.d()] == var1;
   }

   private Object a(y.c.q var1) {
      y.c.c var2 = this.b.c(i);
      return var2 != null?var2.b(var1):null;
   }

   private int a(y.c.q var1, y.c.d var2, y.c.q var3, y.c.d var4) {
      boolean var15 = a.i;
      int var5 = 0;
      int var6 = 0;

      int var10000;
      label56:
      while(true) {
         if(var2 != null && var4 != null) {
            int var7 = this.a[var2.d().d()];
            int var8 = this.a[var4.d().d()];
            if(this.f != null && var7 == var8) {
               label49: {
                  int var9;
                  int var10;
                  int var11;
                  int var12;
                  if((var9 = this.f[var11 = var2.b()]) > (var10 = this.f[var12 = var4.b()])) {
                     ++var6;
                     if(!var15) {
                        break label49;
                     }
                  }

                  if(var9 == var10) {
                     int var13 = this.h[var11];
                     int var14 = this.h[var12];
                     if(var13 != 0 && var14 != 0 && var13 > var14) {
                        ++var6;
                     }
                  }
               }
            }

            if(var7 <= var8) {
               var6 += var5;
               var2 = var2.g();
               if(!var15) {
                  continue;
               }
            }

            if(var7 < var8) {
               continue;
            }

            ++var5;
            var4 = var4.g();
            if(var15) {
               break;
            }

            if(!var15) {
               continue;
            }
         }

         while(true) {
            if(var2 == null) {
               break label56;
            }

            var10000 = var6 + var5;
            if(var15) {
               return var10000;
            }

            var6 = var10000;
            var2 = var2.g();
            if(var15) {
               break label56;
            }
         }
      }

      var10000 = var6;
      return var10000;
   }

   private int b(y.c.q var1, y.c.d var2, y.c.q var3, y.c.d var4) {
      boolean var15 = a.i;
      int var5 = 0;
      int var6 = 0;

      int var10000;
      label56:
      while(true) {
         if(var2 != null && var4 != null) {
            int var7 = this.a[var2.c().d()];
            int var8 = this.a[var4.c().d()];
            if(this.e != null && var7 == var8) {
               label49: {
                  int var9;
                  int var10;
                  int var11;
                  int var12;
                  if((var9 = this.e[var11 = var2.b()]) > (var10 = this.e[var12 = var4.b()])) {
                     ++var6;
                     if(!var15) {
                        break label49;
                     }
                  }

                  if(var9 == var10) {
                     int var13 = this.g[var11];
                     int var14 = this.g[var12];
                     if(var13 != 0 && var14 != 0 && var13 > var14) {
                        ++var6;
                     }
                  }
               }
            }

            if(var7 <= var8) {
               var6 += var5;
               var2 = var2.h();
               if(!var15) {
                  continue;
               }
            }

            if(var7 < var8) {
               continue;
            }

            ++var5;
            var4 = var4.h();
            if(var15) {
               break;
            }

            if(!var15) {
               continue;
            }
         }

         while(true) {
            if(var2 == null) {
               break label56;
            }

            var10000 = var6 + var5;
            if(var15) {
               return var10000;
            }

            var6 = var10000;
            var2 = var2.h();
            if(var15) {
               break label56;
            }
         }
      }

      var10000 = var6;
      return var10000;
   }

   public boolean h() {
      return this.G;
   }

   public void d(boolean var1) {
      this.G = var1;
   }

   public long i() {
      return this.w;
   }

   static float[] a(h var0) {
      return var0.q;
   }

   static y.c.A b(h var0) {
      return var0.n;
   }
}
