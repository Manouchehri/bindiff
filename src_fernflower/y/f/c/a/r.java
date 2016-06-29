package y.f.c.a;

import java.util.Arrays;
import java.util.Comparator;
import java.util.Random;
import y.f.c.a.E;
import y.f.c.a.N;
import y.f.c.a.aP;
import y.f.c.a.aU;
import y.f.c.a.aV;
import y.f.c.a.aX;
import y.f.c.a.bK;
import y.f.c.a.bR;
import y.f.c.a.bx;
import y.f.c.a.cF;
import y.f.c.a.cX;
import y.f.c.a.s;
import y.f.c.a.t;
import y.f.c.a.u;
import y.f.c.a.v;

public class r implements bx {
   private int e = 50;
   private boolean f = true;
   private boolean g = false;
   private Comparator h;
   private long i = 10000L;
   private byte j = 0;
   private float[] k;
   private float[] l;
   private y.c.q[] m;
   private int[] n;
   private int[] o;
   private y.c.p[] p;
   private y.c.D q;
   private y.c.D r;
   private y.c.D s;
   private y.c.D t;
   private byte[] u;
   private byte[] v;
   private int[] w;
   private int[] x;
   private Comparator y;
   private Comparator z;
   private Comparator A;
   private Comparator B;
   private Comparator C;
   private Comparator D;
   private y.f.X E;
   private y.c.D[] F;
   private int[] G;
   private int[] H;
   int[] a;
   int[] b;
   Comparator c;
   private bR I;
   private E J;
   private aX[] K;
   final int[] d = new int[4];

   public void a(long var1) {
      this.i = var1;
   }

   private cF a(y.f.X var1, aU var2, aV var3, int[] var4, int[] var5) {
      this.u = new byte[var1.h()];
      this.w = new int[var1.h()];
      this.v = new byte[var1.h()];
      this.x = new int[var1.h()];
      return cF.a(var1, var2, var3, var5, var4, this.u, this.w, this.v, this.x, (byte)1, (byte)0);
   }

   private cF b(y.f.X var1, aU var2, aV var3, int[] var4, int[] var5) {
      boolean var9 = N.x;
      cF var6 = this.a(var1, var2, var3, var4, var5);
      y.c.e var7 = var1.p();

      while(var7.f()) {
         y.c.d var8 = var7.a();
         a(var8, this.u, this.v, var5);
         a(var8, this.v, this.u, var5);
         var7.g();
         if(var9) {
            break;
         }
      }

      return var6;
   }

   private static void a(y.c.d var0, byte[] var1, byte[] var2, int[] var3) {
      int var4 = var0.b();
      if(Math.abs(var1[var4]) == 1) {
         if(var3[var0.d().d()] < 0) {
            y.c.d var5 = var0.h() == null?var0.j():var0.h();
            int var6 = var5.b();
            if(var2[var6] == -2) {
               var2[var4] = (byte)(-var1[var4]);
               var2[var6] = var1[var4];
               var1[var6] = (byte)(-var1[var4]);
            }
         }

      }
   }

   private void a(y.c.i var1, y.g.ar var2) {
      boolean var4 = N.x;
      y.c.x var3 = var1.o();

      while(true) {
         if(var3.f()) {
            this.k[var3.e().d()] = (float)var2.nextInt();
            var3.g();
            if(var4) {
               break;
            }

            if(!var4) {
               continue;
            }
         }

         var1.a((Comparator)(new s(this)), (Comparator)(new t(this)));
         break;
      }

   }

   private int a() {
      boolean var3 = N.x;
      this.a((y.c.i)this.E, (Comparator)this.C, (Comparator)this.D);
      int var1 = 0;
      int var2 = this.F.length - 1;

      int var10000;
      while(true) {
         if(var2 > 0) {
            var10000 = var1 + this.a(this.F[var2 - 1], this.F[var2]);
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

   private int a(y.c.D var1, y.c.D var2) {
      boolean var6 = N.x;
      y.c.p var3 = var1.k();
      y.c.p var4 = var2.k();
      this.q.clear();
      this.r.clear();
      this.s.clear();
      this.t.clear();
      int var5 = 0;

      int var7;
      label55:
      while(true) {
         y.c.p var10000;
         if(var3 != null) {
            var10000 = var4;
            if(!var6) {
               if(var4 != null) {
                  var5 += this.a((y.c.q)var3.c(), this.q, this.s, this.r);
                  var5 += this.b((y.c.q)var4.c(), this.r, this.t, this.q);
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
            var5 += this.a((y.c.q)var3.c(), this.q, this.s, this.r);
            var3 = var3.a();
            if(var6) {
               break label55;
            }

            if(var6) {
               while(true) {
                  if(var4 == null) {
                     break label55;
                  }

                  var7 = var5 + this.b((y.c.q)var4.c(), this.r, this.t, this.q);
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

            var7 = var5 + this.b((y.c.q)var4.c(), this.r, this.t, this.q);
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

   private int a(y.c.q var1, y.c.D var2, y.c.D var3, y.c.D var4) {
      boolean var14 = N.x;
      int var5 = this.H[var1.d()];
      int var6 = this.d[0] = this.d[1] = this.d[2] = this.d[3] = 0;
      y.c.d var7 = var1.f();

      while(var7 != null) {
         label107: {
            label115: {
               int var8;
               y.c.p var9 = this.p[var8 = var7.b()];
               y.c.p var11;
               if(var9.c() == null) {
                  label103: {
                     if(this.G[var7.d().d()] < 0) {
                        y.c.d var10 = var7.h() == null?var7.j():var7.h();
                        var11 = this.p[var10.b()];
                        var3.a(var11);
                        var11.a(var10);
                        if(!var14) {
                           break label103;
                        }
                     }

                     var6 += var3.size();
                     var4.a(var9);
                     var9.a(var7);
                  }

                  ++this.d[this.u[var8] + 2];
                  if(!var14) {
                     break label115;
                  }
               }

               if(this.G[var7.d().d()] < 0) {
                  var3.h(var9);
                  var9.a((Object)null);
                  y.c.p var15 = var9.a();

                  do {
                     if(var15 == null) {
                        break label115;
                     }

                     ++var6;
                     var15 = var15.a();
                     if(var14) {
                        break label107;
                     }
                  } while(!var14);
               }

               var2.h(var9);
               var9.a((Object)null);
               int var16 = this.w[var8];
               if(var16 > 0) {
                  var11 = var9.b();

                  label82: {
                     while(var11 != null) {
                        ++var6;
                        var11 = var11.b();
                        if(var14) {
                           break label82;
                        }

                        if(var14) {
                           break;
                        }
                     }

                     var6 += var4.size();
                     var6 += var3.size();
                  }

                  if(!var14) {
                     break label115;
                  }
               }

               byte var17 = this.u[var8];
               y.c.p var12 = var9.b();

               int var10000;
               int var10001;
               label69: {
                  while(var12 != null) {
                     y.c.d var13;
                     var10000 = this.H[(var13 = (y.c.d)var12.c()).c().d()];
                     var10001 = var5;
                     if(var14) {
                        break label69;
                     }

                     if(var10000 > var5 || var17 != -2 && this.u[var13.b()] > var17) {
                        ++var6;
                     }

                     var12 = var12.b();
                     if(var14) {
                        break;
                     }
                  }

                  var10000 = var6;
                  var10001 = var4.size() + var3.size();
               }

               var6 = var10000 + var10001;
               switch(var17) {
               case -1:
                  var6 -= this.d[1];
                  if(!var14) {
                     break;
                  }
               case 0:
                  var6 -= this.d[2];
                  if(!var14) {
                     break;
                  }
               case 1:
                  var6 -= this.d[3];
               }
            }

            var7 = var7.g();
         }

         if(var14) {
            break;
         }
      }

      return var6;
   }

   private int b(y.c.q var1, y.c.D var2, y.c.D var3, y.c.D var4) {
      boolean var14 = N.x;
      int var5 = this.H[var1.d()];
      int var6 = this.d[0] = this.d[1] = this.d[2] = this.d[3] = 0;
      y.c.d var7 = var1.g();

      while(var7 != null) {
         label107: {
            label115: {
               int var8;
               y.c.p var9 = this.p[var8 = var7.b()];
               y.c.p var11;
               if(var9.c() == null) {
                  label103: {
                     if(this.G[var7.c().d()] < 0) {
                        y.c.d var10 = var7.g() == null?var7.i():var7.g();
                        var11 = this.p[var10.b()];
                        var3.a(var11);
                        var11.a(var10);
                        if(!var14) {
                           break label103;
                        }
                     }

                     var6 += var3.size();
                     var4.a(var9);
                     var9.a(var7);
                  }

                  ++this.d[this.v[var8] + 2];
                  if(!var14) {
                     break label115;
                  }
               }

               if(this.G[var7.c().d()] < 0) {
                  var3.h(var9);
                  var9.a((Object)null);
                  y.c.p var15 = var9.a();

                  do {
                     if(var15 == null) {
                        break label115;
                     }

                     ++var6;
                     var15 = var15.a();
                     if(var14) {
                        break label107;
                     }
                  } while(!var14);
               }

               var2.h(var9);
               var9.a((Object)null);
               int var16 = this.x[var8];
               if(var16 > 0) {
                  var11 = var9.b();

                  label82: {
                     while(var11 != null) {
                        ++var6;
                        var11 = var11.b();
                        if(var14) {
                           break label82;
                        }

                        if(var14) {
                           break;
                        }
                     }

                     var6 += var4.size() + var3.size();
                  }

                  if(!var14) {
                     break label115;
                  }
               }

               byte var17 = this.v[var8];
               y.c.p var12 = var9.b();

               int var10000;
               int var10001;
               label69: {
                  while(var12 != null) {
                     y.c.d var13;
                     var10000 = this.H[(var13 = (y.c.d)var12.c()).d().d()];
                     var10001 = var5;
                     if(var14) {
                        break label69;
                     }

                     if(var10000 > var5 || var17 != -2 && this.v[var13.b()] > var17) {
                        ++var6;
                     }

                     var12 = var12.b();
                     if(var14) {
                        break;
                     }
                  }

                  var10000 = var6;
                  var10001 = var4.size() + var3.size();
               }

               var6 = var10000 + var10001;
               switch(var17) {
               case -1:
                  var6 -= this.d[1];
                  if(!var14) {
                     break;
                  }
               case 0:
                  var6 -= this.d[2];
                  if(!var14) {
                     break;
                  }
               case 1:
                  var6 -= this.d[3];
               }
            }

            var7 = var7.h();
         }

         if(var14) {
            break;
         }
      }

      return var6;
   }

   private byte a(int[] var1) {
      return this.a(0, this.F.length - 1, var1);
   }

   private byte a(int var1, int var2, int[] var3) {
      int var10000;
      byte var4;
      label80: {
         boolean var10 = N.x;
         var4 = 0;
         int var5;
         int var6;
         int var7;
         y.c.D var8;
         byte var9;
         if(var1 <= var2) {
            var5 = 1;
            var6 = 20;

            label74:
            while(true) {
               var10000 = var5;

               while(true) {
                  if(var10000 == 0) {
                     break label80;
                  }

                  --var6;
                  if(var6 <= 0) {
                     break label80;
                  }

                  var5 = 0;
                  var7 = var1;

                  while(true) {
                     if(var7 > var2) {
                        continue label74;
                     }

                     var8 = this.F[var7];
                     this.a(var8, this.B, this.A);
                     var9 = this.a(var8, true, true, var3);
                     var10000 = var9 & 4;
                     if(var10) {
                        break;
                     }

                     if(var10) {
                        return (byte)var10000;
                     }

                     var5 = var10000 != 0?1:0;
                     var4 |= var9;
                     ++var7;
                     if(var10) {
                        break label74;
                     }
                  }
               }
            }
         }

         var5 = 1;
         var6 = 20;

         label55:
         while(true) {
            var10000 = var5;

            while(true) {
               if(var10000 == 0) {
                  break label55;
               }

               --var6;
               if(var6 <= 0) {
                  break label55;
               }

               var5 = 0;
               var7 = var1;

               while(true) {
                  if(var7 < var2) {
                     continue label55;
                  }

                  var8 = this.F[var7];
                  this.a(var8, this.B, this.A);
                  var9 = this.a(var8, true, true, var3);
                  var10000 = var9 & 4;
                  if(var10) {
                     break;
                  }

                  if(var10) {
                     return (byte)var10000;
                  }

                  var5 = var10000 != 0?1:0;
                  var4 |= var9;
                  --var7;
                  if(var10) {
                     break label55;
                  }
               }
            }
         }
      }

      var10000 = var4;
      return (byte)var10000;
   }

   private byte a(y.c.D var1, boolean var2, boolean var3, int[] var4) {
      byte var5 = this.b(var1, var2, var3, var4);
      byte var6 = this.c(var1, var2, var3, var4);
      return (byte)(var5 | var6);
   }

   private byte b(y.c.D var1, boolean var2, boolean var3, int[] var4) {
      boolean var18 = N.x;
      boolean var5 = false;
      boolean var6 = false;
      boolean var7 = false;
      y.c.p var8 = var1.k();
      int var9 = 0;

      byte var10000;
      while(true) {
         if(var9 < var1.size() - 1) {
            y.c.p var10 = var8;
            var8 = var8.a();
            y.c.q var11 = (y.c.q)var10.c();
            y.c.q var12 = (y.c.q)var8.c();
            if(var18) {
               break;
            }

            label195: {
               int var13;
               int var14;
               if(this.I != null) {
                  if(this.I.a(this.E, (y.c.q)var11, (y.c.q)var12)) {
                     break label195;
                  }
               } else if(this.a != null) {
                  var13 = this.a[var11.d()];
                  var14 = this.a[var12.d()];
                  if(var13 >= 0 && var14 >= 0 && var13 != var14) {
                     break label195;
                  }
               }

               if(this.J.k()) {
                  if(this.K[var12.d()] == null || this.K[var11.d()] == null || this.K[var11.d()].l() != this.K[var12.d()].l()) {
                     break label195;
                  }

                  byte var19 = this.K[var11.d()].b();
                  byte var20 = this.K[var12.d()].b();
                  if(var19 == 12 || var19 == 13 || var20 == 12 || var20 == 13) {
                     break label195;
                  }
               }

               var13 = 0;
               var14 = 0;
               if(var2) {
                  var13 = this.d(var11, var12, var4);
                  if(var3 || var13 > 0) {
                     var14 = this.d(var12, var11, var4);
                  }
               }

               if(var3) {
                  var13 += this.c(var11, var12, var4);
                  if(var2 || var13 > 0) {
                     var14 += this.c(var12, var11, var4);
                  }
               }

               if(var13 >= var14) {
                  label228: {
                     int var15;
                     if(var13 > var14) {
                        var5 = true;
                        var15 = var4[var11.d()];
                        var4[var11.d()] = var4[var12.d()];
                        var4[var12.d()] = var15;
                        var8.a(var11);
                        var10.a(var12);
                        var6 |= var11.c() > 0 || var12.c() > 0;
                        var7 |= var11.b() > 0 || var12.b() > 0;
                        this.a(var11, var2?this.B:null, var3?this.A:null, true);
                        this.a(var12, var2?this.B:null, var3?this.A:null, false);
                        if(!var18) {
                           break label228;
                        }
                     }

                     var15 = this.a(var11, var12, true, true, var4);
                     int var16 = this.a(var12, var11, true, true, var4);
                     if(var16 < var15 || var16 == var15 && var2 && var3) {
                        int var17 = var4[var11.d()];
                        var4[var11.d()] = var4[var12.d()];
                        var4[var12.d()] = var17;
                        var8.a(var11);
                        var10.a(var12);
                        var6 |= var11.c() > 0 || var12.c() > 0;
                        var7 |= var11.b() > 0 || var12.b() > 0;
                        this.a(var11, var2?this.B:null, var3?this.A:null, true);
                        this.a(var12, var2?this.B:null, var3?this.A:null, false);
                     }
                  }
               }
            }

            ++var9;
            if(!var18) {
               continue;
            }
         }

         if(var5) {
            var10000 = 4;
            return (byte)(var10000 | (var7?2:0) | (var6?1:0));
         }
         break;
      }

      var10000 = 0;
      return (byte)(var10000 | (var7?2:0) | (var6?1:0));
   }

   private byte c(y.c.D var1, boolean var2, boolean var3, int[] var4) {
      boolean var18 = N.x;
      boolean var5 = false;
      boolean var6 = false;
      boolean var7 = false;
      y.c.p var8 = var1.l();
      int var9 = var1.size() - 2;

      byte var10000;
      while(true) {
         if(var9 >= 0) {
            y.c.p var10 = var8;
            var8 = var8.b();
            y.c.q var11 = (y.c.q)var8.c();
            y.c.q var12 = (y.c.q)var10.c();
            if(var18) {
               break;
            }

            label195: {
               int var13;
               int var14;
               if(this.I != null) {
                  if(this.I.a(this.E, (y.c.q)var11, (y.c.q)var12)) {
                     break label195;
                  }
               } else if(this.a != null) {
                  var13 = this.a[var11.d()];
                  var14 = this.a[var12.d()];
                  if(var13 >= 0 && var14 >= 0 && var13 != var14) {
                     break label195;
                  }
               }

               if(this.J.k()) {
                  if(this.K[var12.d()] == null || this.K[var11.d()] == null || this.K[var12.d()].l() != this.K[var11.d()].l()) {
                     break label195;
                  }

                  byte var19 = this.K[var11.d()].b();
                  byte var20 = this.K[var12.d()].b();
                  if(var19 == 12 || var19 == 13 || var20 == 12 || var20 == 13) {
                     break label195;
                  }
               }

               var13 = 0;
               var14 = 0;
               if(var2) {
                  var13 = this.d(var11, var12, var4);
                  if(var3 || var13 > 0) {
                     var14 = this.d(var12, var11, var4);
                  }
               }

               if(var3) {
                  var13 += this.c(var11, var12, var4);
                  if(var2 || var13 > 0) {
                     var14 += this.c(var12, var11, var4);
                  }
               }

               if(var13 >= var14) {
                  label228: {
                     int var15;
                     if(var13 > var14) {
                        var5 = true;
                        var15 = var4[var11.d()];
                        var4[var11.d()] = var4[var12.d()];
                        var4[var12.d()] = var15;
                        var10.a(var11);
                        var8.a(var12);
                        var6 |= var11.c() > 0 || var12.c() > 0;
                        var7 |= var11.b() > 0 || var12.b() > 0;
                        this.a(var11, var2?this.B:null, var3?this.A:null, true);
                        this.a(var12, var2?this.B:null, var3?this.A:null, false);
                        if(!var18) {
                           break label228;
                        }
                     }

                     var15 = this.a(var11, var12, true, true, var4);
                     int var16 = this.a(var12, var11, true, true, var4);
                     if(var16 < var15 || var16 == var15 && var2 && var3) {
                        int var17 = var4[var11.d()];
                        var4[var11.d()] = var4[var12.d()];
                        var4[var12.d()] = var17;
                        var10.a(var11);
                        var8.a(var12);
                        var6 |= var11.c() > 0 || var12.c() > 0;
                        var7 |= var11.b() > 0 || var12.b() > 0;
                        this.a(var11, var2?this.B:null, var3?this.A:null, true);
                        this.a(var12, var2?this.B:null, var3?this.A:null, false);
                     }
                  }
               }
            }

            --var9;
            if(!var18) {
               continue;
            }
         }

         if(var5) {
            var10000 = 4;
            return (byte)(var10000 | (var7?2:0) | (var6?1:0));
         }
         break;
      }

      var10000 = 0;
      return (byte)(var10000 | (var7?2:0) | (var6?1:0));
   }

   private void a(y.c.q var1, Comparator var2, Comparator var3, boolean var4) {
      boolean var7 = N.x;
      y.c.d var10000;
      y.c.d var5;
      y.c.d var6;
      if(var4) {
         label115: {
            if(var2 != null && var1.b() > 1) {
               var5 = var1.g();
               var6 = var1.i();

               while(var2.compare(var5, var6) > 0) {
                  var10000 = var6.g();
                  if(var7) {
                     break label115;
                  }

                  label101: {
                     if(var10000 != null) {
                        this.E.a(var6, var6.g(), var5, 1, 1);
                        if(!var7) {
                           break label101;
                        }
                     }

                     this.E.a(var6, var6.i(), var5, 0, 1);
                  }

                  var6 = var1.i();
                  if(var7) {
                     break;
                  }
               }
            }

            if(var3 == null || var1.c() <= 1) {
               return;
            }

            var5 = var1.f();
            var10000 = var1.h();
         }

         var6 = var10000;

         do {
            if(var3.compare(var5, var6) <= 0) {
               return;
            }

            label87: {
               if(var6.h() != null) {
                  this.E.a(var6, var5, var6.h(), 1, 1);
                  if(!var7) {
                     break label87;
                  }
               }

               this.E.a(var6, var5, var6.j(), 1, 0);
            }

            var6 = var1.h();
         } while(!var7);
      }

      label118: {
         if(var2 != null && var1.b() > 1) {
            var5 = var1.i();
            var6 = var1.g();

            while(var2.compare(var6, var5) > 0) {
               var10000 = var6.g();
               if(var7) {
                  break label118;
               }

               label67: {
                  if(var10000 != null) {
                     this.E.a(var6, var6.g(), var5, 1, 0);
                     if(!var7) {
                        break label67;
                     }
                  }

                  this.E.a(var6, var6.i(), var5, 0, 0);
               }

               var6 = var1.g();
               if(var7) {
                  break;
               }
            }
         }

         if(var3 == null || var1.c() <= 1) {
            return;
         }

         var5 = var1.h();
         var10000 = var1.f();
      }

      var6 = var10000;

      while(var3.compare(var6, var5) > 0) {
         label48: {
            if(var6.h() != null) {
               this.E.a(var6, var5, var6.h(), 0, 1);
               if(!var7) {
                  break label48;
               }
            }

            this.E.a(var6, var5, var6.j(), 0, 0);
         }

         var6 = var1.f();
         if(var7) {
            break;
         }
      }

   }

   private int a(y.c.q var1, y.c.q var2, boolean var3, boolean var4, int[] var5) {
      int var6 = 0;
      if(var3) {
         var6 = this.a(var1, var2, var5);
      }

      if(var4) {
         var6 += this.b(var1, var2, var5);
      }

      return var6;
   }

   private int a(y.c.q var1, y.c.q var2, int[] var3) {
      boolean var9 = N.x;
      int var4 = 0;
      int var5 = var3[var1.d()];
      y.c.d var6 = var1.g();

      int var10000;
      while(true) {
         if(var6 != null) {
            var10000 = this.G[var6.c().d()];
            if(var9) {
               break;
            }

            if(var10000 < 0) {
               y.c.q var7 = var6.g() == null?var6.i().d():var6.g().d();
               if(var7 != var2) {
                  int var8 = var3[var7.d()] - var5;
                  var4 += var8 > 0?1:(var8 < 0?-1:0);
               }
            }

            var6 = var6.h();
            if(!var9) {
               continue;
            }
         }

         var10000 = var4;
         break;
      }

      return var10000;
   }

   private int b(y.c.q var1, y.c.q var2, int[] var3) {
      boolean var9 = N.x;
      int var4 = 0;
      int var5 = var3[var1.d()];
      y.c.d var6 = var1.f();

      int var10000;
      while(true) {
         if(var6 != null) {
            var10000 = this.G[var6.d().d()];
            if(var9) {
               break;
            }

            if(var10000 < 0) {
               y.c.q var7 = var6.h() == null?var6.j().c():var6.h().c();
               if(var7 != var2) {
                  int var8 = var3[var7.d()] - var5;
                  var4 += var8 > 0?1:(var8 < 0?-1:0);
               }
            }

            var6 = var6.g();
            if(!var9) {
               continue;
            }
         }

         var10000 = var4;
         break;
      }

      return var10000;
   }

   private int c(y.c.q var1, y.c.q var2, int[] var3) {
      boolean var22 = N.x;
      y.c.d var4 = var1.f();
      y.c.d var5 = var2.f();
      int var6 = 0;
      int var7 = 0;

      int var31;
      label192: {
         y.c.d var10000;
         while(true) {
            if(var4 != null) {
               var10000 = var5;
               if(var22) {
                  break;
               }

               if(var5 != null) {
                  boolean var8;
                  label199: {
                     var8 = true;
                     int var15;
                     int var16;
                     if(this.G[var4.d().d()] < 0) {
                        y.c.d var9 = var4.h() == null?var4.j():var4.h();
                        y.c.q var10 = var9.c();
                        if(var10 == var2) {
                           var4 = var4.g();
                           if(!var22) {
                              continue;
                           }
                        }

                        boolean var11 = var3[var10.d()] < var3[var1.d()];
                        if(this.G[var5.d().d()] < 0) {
                           y.c.d var12 = var5.h() == null?var5.j():var5.h();
                           y.c.q var13 = var12.c();
                           if(var13 == var1) {
                              var5 = var5.g();
                              if(!var22) {
                                 continue;
                              }
                           }

                           boolean var14 = var3[var13.d()] < var3[var2.d()];
                           if(var14 == var11) {
                              var15 = var3[var10.d()] - var3[var13.d()];
                              if(var15 == 0) {
                                 byte var18 = this.u[var16 = var9.b()];
                                 int var17;
                                 byte var19 = this.u[var17 = var12.b()];
                                 if(var18 == -2 || var19 == -2) {
                                    break label199;
                                 }

                                 if(var18 < var19) {
                                    var8 = false;
                                    if(!var22) {
                                       break label199;
                                    }
                                 }

                                 if(var18 != var19) {
                                    break label199;
                                 }

                                 int var20 = this.w[var16];
                                 int var21 = this.w[var17];
                                 if(var20 == 0 || var21 == 0 || var20 >= var21) {
                                    break label199;
                                 }

                                 var8 = false;
                                 if(!var22) {
                                    break label199;
                                 }
                              }

                              var8 = var15 > 0;
                              if(!var22) {
                                 break label199;
                              }
                           }

                           var8 = var11;
                           if(!var22) {
                              break label199;
                           }
                        }

                        var8 = var11;
                        if(!var22) {
                           break label199;
                        }
                     }

                     if(this.G[var5.d().d()] < 0) {
                        y.c.q var23 = var5.h() == null?var5.j().c():var5.h().c();
                        if(var23 == var1) {
                           var5 = var5.g();
                           if(!var22) {
                              continue;
                           }
                        }

                        var8 = var3[var23.d()] >= var3[var1.d()];
                        if(!var22) {
                           break label199;
                        }
                     }

                     int var24 = var3[var4.d().d()];
                     int var25 = var3[var5.d().d()];
                     if(var24 == var25) {
                        int var26;
                        byte var29 = this.v[var26 = var4.b()];
                        int var28;
                        byte var30 = this.v[var28 = var5.b()];
                        if(var29 == -2 || var30 == -2) {
                           break label199;
                        }

                        if(var29 > var30) {
                           var8 = false;
                           if(!var22) {
                              break label199;
                           }
                        }

                        if(var29 != var30) {
                           break label199;
                        }

                        var15 = this.x[var26];
                        var16 = this.x[var28];
                        if(var15 == 0 || var16 == 0 || var15 <= var16) {
                           break label199;
                        }

                        var8 = false;
                        if(!var22) {
                           break label199;
                        }
                     }

                     var8 = var24 < var25;
                  }

                  if(var8) {
                     var7 += var6;
                     var4 = var4.g();
                     if(!var22) {
                        continue;
                     }
                  }

                  ++var6;
                  var5 = var5.g();
                  if(!var22) {
                     continue;
                  }
               }
            }

            if(var6 <= 0) {
               break label192;
            }

            var10000 = var4;
            break;
         }

         while(var10000 != null) {
            var31 = this.G[var4.d().d()];
            if(var22) {
               return var31;
            }

            label118: {
               if(var31 < 0) {
                  y.c.q var27 = var4.h() == null?var4.j().c():var4.h().c();
                  if(var27 == var2) {
                     break label118;
                  }

                  var7 += var6;
                  if(!var22) {
                     break label118;
                  }
               }

               var7 += var6;
            }

            var4 = var4.g();
            if(var22) {
               break;
            }

            var10000 = var4;
         }
      }

      var31 = var7;
      return var31;
   }

   private int d(y.c.q var1, y.c.q var2, int[] var3) {
      boolean var22 = N.x;
      y.c.d var4 = var1.g();
      y.c.d var5 = var2.g();
      int var6 = 0;
      int var7 = 0;

      int var31;
      label192: {
         y.c.d var10000;
         while(true) {
            if(var4 != null) {
               var10000 = var5;
               if(var22) {
                  break;
               }

               if(var5 != null) {
                  boolean var8;
                  label199: {
                     var8 = true;
                     int var15;
                     int var16;
                     if(this.G[var4.c().d()] < 0) {
                        y.c.d var9 = var4.g() == null?var4.i():var4.g();
                        y.c.q var10 = var9.d();
                        if(var10 == var2) {
                           var4 = var4.h();
                           if(!var22) {
                              continue;
                           }
                        }

                        boolean var11 = var3[var10.d()] < var3[var1.d()];
                        if(this.G[var5.c().d()] < 0) {
                           y.c.d var12 = var5.g() == null?var5.i():var5.g();
                           y.c.q var13 = var12.d();
                           if(var13 == var1) {
                              var5 = var5.h();
                              if(!var22) {
                                 continue;
                              }
                           }

                           boolean var14 = var3[var13.d()] < var3[var2.d()];
                           if(var14 == var11) {
                              var15 = var3[var10.d()] - var3[var13.d()];
                              if(var15 == 0) {
                                 byte var18 = this.v[var16 = var9.b()];
                                 int var17;
                                 byte var19 = this.v[var17 = var12.b()];
                                 if(var18 == -2 || var19 == -2) {
                                    break label199;
                                 }

                                 if(var18 < var19) {
                                    var8 = false;
                                    if(!var22) {
                                       break label199;
                                    }
                                 }

                                 if(var18 != var19) {
                                    break label199;
                                 }

                                 int var20 = this.x[var16];
                                 int var21 = this.x[var17];
                                 if(var20 == 0 || var21 == 0 || var20 >= var21) {
                                    break label199;
                                 }

                                 var8 = false;
                                 if(!var22) {
                                    break label199;
                                 }
                              }

                              var8 = var15 > 0;
                              if(!var22) {
                                 break label199;
                              }
                           }

                           var8 = var11;
                           if(!var22) {
                              break label199;
                           }
                        }

                        var8 = var11;
                        if(!var22) {
                           break label199;
                        }
                     }

                     if(this.G[var5.c().d()] < 0) {
                        y.c.q var23 = var5.g() == null?var5.i().d():var5.g().d();
                        if(var23 == var1) {
                           var5 = var5.h();
                           if(!var22) {
                              continue;
                           }
                        }

                        var8 = var3[var23.d()] >= var3[var1.d()];
                        if(!var22) {
                           break label199;
                        }
                     }

                     int var24 = var3[var4.c().d()];
                     int var25 = var3[var5.c().d()];
                     if(var24 == var25) {
                        int var26;
                        byte var29 = this.u[var26 = var4.b()];
                        int var28;
                        byte var30 = this.u[var28 = var5.b()];
                        if(var29 == -2 || var30 == -2) {
                           break label199;
                        }

                        if(var29 > var30) {
                           var8 = false;
                           if(!var22) {
                              break label199;
                           }
                        }

                        if(var29 != var30) {
                           break label199;
                        }

                        var15 = this.w[var26];
                        var16 = this.w[var28];
                        if(var15 == 0 || var16 == 0 || var15 <= var16) {
                           break label199;
                        }

                        var8 = false;
                        if(!var22) {
                           break label199;
                        }
                     }

                     var8 = var24 < var25;
                  }

                  if(var8) {
                     var7 += var6;
                     var4 = var4.h();
                     if(!var22) {
                        continue;
                     }
                  }

                  ++var6;
                  var5 = var5.h();
                  if(!var22) {
                     continue;
                  }
               }
            }

            if(var6 <= 0) {
               break label192;
            }

            var10000 = var4;
            break;
         }

         while(var10000 != null) {
            var31 = this.G[var4.c().d()];
            if(var22) {
               return var31;
            }

            label118: {
               if(var31 < 0) {
                  y.c.q var27 = var4.g() == null?var4.i().d():var4.g().d();
                  if(var27 == var2) {
                     break label118;
                  }

                  var7 += var6;
                  if(!var22) {
                     break label118;
                  }
               }

               var7 += var6;
            }

            var4 = var4.h();
            if(var22) {
               break;
            }

            var10000 = var4;
         }
      }

      var31 = var7;
      return var31;
   }

   public void a(y.f.X param1, aU param2, aV param3, aP param4) {
      // $FF: Couldn't be decompiled
   }

   private void a(y.f.X var1, y.c.D[] var2, int[] var3) {
      boolean var11 = N.x;
      int[] var4 = new int[var3.length];
      y.c.x var5 = var1.o();

      label71:
      do {
         int var10000 = var5.f();

         y.c.q var6;
         int var7;
         label68:
         while(true) {
            if(var10000 == 0) {
               break label71;
            }

            var6 = var5.e();
            var7 = 0;
            y.c.e var8 = var6.j();

            while(true) {
               if(!var8.f()) {
                  break label68;
               }

               var10000 = var7;
               if(var11) {
                  break;
               }

               if(var7 <= -3) {
                  break label68;
               }

               label63: {
                  y.c.d var9 = var8.a();
                  byte var10 = var9.c() == var6?this.u[var9.b()]:this.v[var9.b()];
                  if(var10 == -1) {
                     var7 = var7 == 1?-3:-1;
                     if(!var11) {
                        break label63;
                     }
                  }

                  if(var10 == 1) {
                     var7 = var7 == -1?-3:1;
                  }
               }

               var8.g();
               if(var11) {
                  break label68;
               }
            }
         }

         var4[var6.d()] = var7 < -1?0:var7;
         var5.g();
      } while(!var11);

      u var12 = new u(this, var4);
      int var13 = 0;

      while(var13 < var2.length) {
         this.a((y.c.D)var2[var13], (int[])var3, (Comparator)var12);
         ++var13;
         if(var11) {
            break;
         }
      }

   }

   boolean a(y.c.i var1, y.c.D[] var2, aV var3) {
      boolean var13 = N.x;
      int[] var4 = new int[var1.e()];
      int var5 = 0;

      while(true) {
         if(var5 < var4.length) {
            var4[var5] = -1;
            ++var5;
            if(var13) {
               break;
            }

            if(!var13) {
               continue;
            }
         }

         var5 = 0;
         break;
      }

      int var6 = -1;
      int var7 = 0;

      while(true) {
         if(var7 < var2.length) {
            y.c.D var8 = var2[var7];
            if(var13) {
               break;
            }

            y.c.p var9 = var8.k();

            label60: {
               while(var9 != null) {
                  y.c.q var10 = (y.c.q)var9.c();
                  bK var11 = var3.a(var10).h();
                  if(var13) {
                     break label60;
                  }

                  if(var11 != null) {
                     ++var5;
                     int var12 = var11.j();
                     var4[var10.d()] = var12;
                     var6 = Math.max(var6, var12);
                  }

                  var9 = var9.a();
                  if(var13) {
                     break;
                  }
               }

               ++var7;
            }

            if(!var13) {
               continue;
            }
         }

         if(var5 > 0 && var6 > 0) {
            this.a = var4;
            this.b = new int[var2.length];
            var7 = 0;

            while(true) {
               if(var7 < this.b.length) {
                  this.b[var7] = var6;
                  ++var7;
                  if(var13) {
                     break;
                  }

                  if(!var13) {
                     continue;
                  }
               }

               if(this.J != null && this.J.k()) {
                  this.J.a(var2, var4, this.b);
               }
               break;
            }

            return true;
         }

         this.a = null;
         this.b = null;
         break;
      }

      return false;
   }

   void a(y.c.i var1, y.c.D[] var2, int[] var3, y.g.ar var4) {
      boolean var12 = N.x;
      y.c.q var5 = null;
      y.c.p[] var6 = new y.c.p[var1.e()];
      int[] var7 = new int[var1.e()];
      int var8 = 0;

      while(true) {
         if(var8 < var2.length) {
            y.c.D var9 = var2[var8];
            if(var12) {
               break;
            }

            if(var5 == null) {
               var5 = (y.c.q)var9.f();
            }

            y.c.p var10 = var9.k();

            label93: {
               while(var10 != null) {
                  y.c.q var11 = (y.c.q)var10.c();
                  var6[var11.d()] = var10;
                  var7[var11.d()] = var8 + 1;
                  var10 = var10.a();
                  if(var12) {
                     break label93;
                  }

                  if(var12) {
                     break;
                  }
               }

               ++var8;
            }

            if(!var12) {
               continue;
            }
         }

         if(var4 != null) {
            var8 = var4.nextInt(var1.e());
            y.c.x var14 = var1.o();

            while(true) {
               if(var14.f()) {
                  label106: {
                     y.c.q var17 = var14.e();
                     if(var12) {
                        break;
                     }

                     if(var8 == 0) {
                        var5 = var17;
                        if(!var12) {
                           break label106;
                        }
                     }

                     var14.g();
                     --var8;
                     if(!var12) {
                        continue;
                     }
                  }
               }

               this.a(var1, var4);
               break;
            }

            Arrays.fill(var3, 0);
         }

         var1.a((Comparator)(new cX(this.v)), (Comparator)(new cX(this.u)));
         break;
      }

      v var13 = new v(this, var6, var7, var2);
      var13.a(false);
      var13.b(true);
      var13.a(var1, var5);
      if(this.I != null) {
         Comparator var15 = this.I.a(var1, var2, var3);
         int var18 = 0;

         do {
            if(var18 >= var2.length) {
               return;
            }

            this.a(var2[var18], var3, var15);
            ++var18;
         } while(!var12);
      }

      int var16;
      if(this.c != null) {
         var16 = 0;

         do {
            if(var16 >= var2.length) {
               return;
            }

            this.a(var2[var16], var3, this.c);
            ++var16;
         } while(!var12);
      }

      var16 = 0;

      while(var16 < var2.length) {
         this.a(var2[var16], var3);
         ++var16;
         if(var12) {
            break;
         }
      }

   }

   private int a(y.g.ar var1) {
      boolean var9 = N.x;
      y.a.a.a();
      boolean var2 = false;
      int var3 = Integer.MAX_VALUE;
      int var4 = Integer.MAX_VALUE;
      int[] var5 = new int[this.H.length];
      int var6 = var1.nextInt(2);
      int var7 = 0;
      int var8 = 0;

      int var10000;
      int var10001;
      while(true) {
         if(var8 < 2) {
            var10000 = var7;
            var10001 = 6;
            if(var9) {
               break;
            }

            if(var7 < 6 && var3 > 0) {
               label46: {
                  var4 = this.a(var6, var1);
                  if(var4 < var3) {
                     var3 = var4;
                     var2 = true;
                     this.a(this.H, var5);
                     if(!var9) {
                        break label46;
                     }
                  }

                  if(var4 > var3) {
                     ++var8;
                     if(!var9) {
                        break label46;
                     }
                  }

                  ++var7;
               }

               var6 = (var6 + 1) % 2;
               if(!var9) {
                  continue;
               }
            }
         }

         if(!var2) {
            return var3;
         }

         var10000 = var4;
         var10001 = var3;
         break;
      }

      if(var10000 > var10001) {
         this.b(var5);
      }

      return var3;
   }

   private void a(y.c.D var1, Comparator var2, Comparator var3) {
      boolean var6 = N.x;
      if(var2 != null || var3 != null) {
         y.c.p var4 = var1.k();

         while(var4 != null) {
            y.c.q var5 = (y.c.q)var4.c();
            if(var2 != null) {
               var5.a(var2);
            }

            if(var3 != null) {
               var5.b(var3);
            }

            var4 = var4.a();
            if(var6) {
               break;
            }
         }
      }

   }

   private void a(y.c.i var1, Comparator var2, Comparator var3) {
      if(var2 != null || var3 != null) {
         var1.a(var2, var3);
      }

   }

   private int a(int var1, Random var2) {
      int var3;
      boolean var5;
      label56: {
         var5 = N.x;
         var3 = 0;
         if(var1 == 0) {
            var3 = var2.nextInt(this.F.length) / 2;
            if(!var5) {
               break label56;
            }
         }

         if(var1 == 1) {
            var3 = (this.F.length + var2.nextInt(this.F.length)) / 2;
            if(!var5) {
               break label56;
            }
         }

         if(var1 == 2) {
            var3 = var2.nextInt(this.F.length);
         }
      }

      this.J.a(var3);
      int var4 = var3 - 1;

      while(true) {
         if(var4 >= 0) {
            this.b(this.F, var4, this.H);
            --var4;
            if(var5) {
               break;
            }

            if(!var5) {
               continue;
            }
         }

         var4 = var3 + 1;
         break;
      }

      while(true) {
         if(var4 < this.F.length) {
            this.a(this.F, var4, this.H);
            ++var4;
            if(var5) {
               break;
            }

            if(!var5) {
               continue;
            }
         }

         if(this.f && (!this.J.k() || this.g)) {
            this.a(this.H);
         }
         break;
      }

      return this.a();
   }

   void a(y.c.D[] var1, int var2, int[] var3) {
      boolean var13 = N.x;
      y.c.D var4 = var1[var2 - 1];
      y.c.D var5 = var1[var2];
      int var6 = var4.size();
      int var7 = var5.size();
      float var8 = 1.0F;
      y.c.p var9 = var5.k();

      label75: {
         label74: {
            byte var10000;
            while(true) {
               if(var9 != null) {
                  y.c.q var10 = (y.c.q)var9.c();
                  int var11 = var10.d();
                  var10000 = this.j;
                  if(var13) {
                     break;
                  }

                  switch(var10000) {
                  case 0:
                     this.k[var11] = this.b(var10, var7, false, var6, var3);
                     if(!var13) {
                        break;
                     }
                  case 1:
                     this.k[var11] = this.a(var10, var7, false, var6, var3);
                  }

                  this.k[var11] += (float)var3[var11] / (float)(var6 * 200);
                  if(this.a != null) {
                     label84: {
                        int var12 = this.a[var11];
                        if(var12 < 0) {
                           this.k[var11] = 2.0F * this.k[var11] * (float)(this.b[var2] + 1);
                           if(!var13) {
                              break label84;
                           }
                        }

                        this.k[var11] += (float)((var12 + 1) * (var6 + 1) * 2);
                     }
                  }

                  if(var8 < this.k[var11]) {
                     var8 = this.k[var11];
                  }

                  var9 = var9.a();
                  if(!var13) {
                     continue;
                  }
               }

               if(this.I != null) {
                  var9 = var5.k();

                  while(var9 != null) {
                     int var14 = ((y.c.q)var9.c()).d();
                     this.k[var14] = this.k[var14] / var8 * (float)this.n[var14] + (float)this.o[var14];
                     var9 = var9.a();
                     if(var13) {
                        break label74;
                     }

                     if(var13) {
                        break;
                     }
                  }
               }

               var10000 = this.J.k();
               break;
            }

            if(var10000 != 0) {
               this.J.a(var5, var2, this.k, var3, true);
               if(!var13) {
                  break label75;
               }
            }
         }

         this.a(var5, var3, this.h);
      }

      if(this.f && (!this.J.k() || this.g)) {
         this.a((y.c.D)var5, (Comparator)this.B, (Comparator)null);
         this.a(var5, true, false, var3);
         this.a((y.c.D)var4, (Comparator)null, (Comparator)this.z);
      }

   }

   void b(y.c.D[] var1, int var2, int[] var3) {
      boolean var13 = N.x;
      y.c.D var4 = var1[var2 + 1];
      y.c.D var5 = var1[var2];
      int var6 = var4.size();
      int var7 = var5.size();
      float var8 = 1.0F;
      y.c.p var9 = var5.k();

      label75: {
         label74: {
            byte var10000;
            while(true) {
               if(var9 != null) {
                  y.c.q var10 = (y.c.q)var9.c();
                  int var11 = var10.d();
                  var10000 = this.j;
                  if(var13) {
                     break;
                  }

                  switch(var10000) {
                  case 0:
                     this.k[var11] = this.b(var10, var7, true, var6, var3);
                     if(!var13) {
                        break;
                     }
                  case 1:
                     this.k[var11] = this.a(var10, var7, true, var6, var3);
                  }

                  this.k[var11] += (float)var3[var11] / (float)(var6 * 200);
                  if(this.a != null) {
                     label84: {
                        int var12 = this.a[var11];
                        if(var12 < 0) {
                           this.k[var11] = 2.0F * this.k[var11] * (float)(this.b[var2] + 1);
                           if(!var13) {
                              break label84;
                           }
                        }

                        this.k[var11] += (float)((var12 + 1) * (var6 + 1) * 2);
                     }
                  }

                  if(var8 < this.k[var11]) {
                     var8 = this.k[var11];
                  }

                  var9 = var9.a();
                  if(!var13) {
                     continue;
                  }
               }

               if(this.I != null) {
                  var9 = var5.k();

                  while(var9 != null) {
                     int var14 = ((y.c.q)var9.c()).d();
                     this.k[var14] = this.k[var14] / var8 * (float)this.n[var14] + (float)this.o[var14];
                     var9 = var9.a();
                     if(var13) {
                        break label74;
                     }

                     if(var13) {
                        break;
                     }
                  }
               }

               var10000 = this.J.k();
               break;
            }

            if(var10000 != 0) {
               this.J.a(var5, var2, this.k, var3, false);
               if(!var13) {
                  break label75;
               }
            }
         }

         this.a(var5, var3, this.h);
      }

      if(this.f && (!this.J.k() || this.g)) {
         this.a((y.c.D)var5, (Comparator)null, (Comparator)this.A);
         this.a(var5, false, true, var3);
         this.a((y.c.D)var4, (Comparator)this.y, (Comparator)null);
      }

   }

   private float a(y.c.q var1, int var2, boolean var3, int var4, int[] var5) {
      int var6;
      float var8;
      float var15;
      r var10000;
      label115: {
         int var18;
         label111: {
            label116: {
               boolean var12 = N.x;
               var6 = 0;
               y.c.d var7;
               if(var3) {
                  var7 = var1.f();

                  do {
                     if(var7 == null) {
                        break label116;
                     }

                     var8 = (float)var5[var7.d().d()];
                     var10000 = this;
                     if(var12) {
                        break label115;
                     }

                     if(this.v != null) {
                        int var9;
                        switch(this.v[var9 = var7.b()]) {
                        case 1:
                           var8 += 0.3F;
                           if(!var12) {
                              break;
                           }
                        case -1:
                           var8 -= 0.3F;
                        }

                        var8 += (float)this.x[var9] * 0.01F;
                     }

                     this.l[var6] = var8;
                     var7 = var7.g();
                     ++var6;
                  } while(!var12);
               }

               var7 = var1.g();

               while(var7 != null) {
                  int var16 = var7.c().d();
                  var18 = this.G[var16];
                  if(var12) {
                     break label111;
                  }

                  label119: {
                     if(var18 < 0) {
                        y.c.q var14 = var7.g() == null?var7.i().d():var7.g().d();
                        float var10 = (float)var5[var14.d()];
                        if(this.u != null) {
                           int var11;
                           switch(this.u[var11 = var7.b()]) {
                           case 1:
                              var10 += 0.3F;
                              if(!var12) {
                                 break;
                              }
                           case -1:
                              var10 -= 0.3F;
                           }

                           var10 += (float)this.w[var11] * 0.01F;
                        }

                        this.l[var6] = var10;
                        if(!var12) {
                           break label119;
                        }
                     }

                     var15 = (float)var5[var16];
                     if(this.u != null) {
                        int var17;
                        switch(this.u[var17 = var7.b()]) {
                        case 1:
                           var15 += 0.3F;
                           if(!var12) {
                              break;
                           }
                        case -1:
                           var15 -= 0.3F;
                        }

                        var15 += (float)this.w[var17] * 0.01F;
                     }

                     this.l[var6] = var15;
                  }

                  var7 = var7.h();
                  ++var6;
                  if(var12) {
                     break;
                  }
               }
            }

            var18 = var6;
         }

         if(var18 == 0) {
            return (float)((var4 - 1) * var5[var1.d()]) / (float)(var2 - 1);
         }

         var10000 = this;
      }

      Arrays.sort(var10000.l, 0, var6);
      int var13 = var6 >> 1;
      if(var6 % 2 == 1) {
         return this.l[var13];
      } else if(var6 == 2) {
         return (this.l[0] + this.l[1]) * 0.5F;
      } else {
         var8 = this.l[var13 - 1] - this.l[0];
         var15 = this.l[var6 - 1] - this.l[var13];
         return var8 == 0.0F && var15 == 0.0F?(this.l[var13 - 1] + this.l[var13]) * 0.5F:(this.l[var13 - 1] * var15 + this.l[var13] * var8) / (var8 + var15);
      }
   }

   private float b(y.c.q var1, int var2, boolean var3, int var4, int[] var5) {
      boolean var13 = N.x;
      float var6 = 0.0F;
      int var7 = var3?var1.c():var1.b();
      if(var7 == 0) {
         var6 = (float)((var4 - 1) * var5[var1.d()]) / (float)(var2 - 1);
         if(!var13) {
            return var6;
         }
      }

      label124: {
         y.c.d var8;
         int var9;
         y.c.d var10;
         y.c.q var11;
         int var12;
         int var14;
         if(var3) {
            var8 = var1.f();

            do {
               if(var8 == null) {
                  break label124;
               }

               var9 = var8.d().d();
               if(var13) {
                  return var6;
               }

               label126: {
                  if(this.G[var9] < 0) {
                     var10 = var8.h() == null?var8.j():var8.h();
                     var11 = var10.c();
                     var6 += (float)((var4 - 1) * var5[var11.d()]) / (float)(var2 - 1);
                     if(this.u == null) {
                        break label126;
                     }

                     switch(this.u[var12 = var10.b()]) {
                     case 1:
                        var6 -= 0.3F;
                        if(!var13) {
                           break;
                        }
                     case -1:
                        var6 += 0.3F;
                     }

                     var6 -= (float)this.w[var12] * 0.01F;
                     if(!var13) {
                        break label126;
                     }
                  }

                  var6 += (float)var5[var9];
                  if(this.v != null) {
                     switch(this.v[var14 = var8.b()]) {
                     case 1:
                        var6 += 0.3F;
                        if(!var13) {
                           break;
                        }
                     case -1:
                        var6 -= 0.3F;
                     }

                     var6 += (float)this.x[var14] * 0.01F;
                  }
               }

               var8 = var8.g();
            } while(!var13);
         }

         var8 = var1.g();

         while(var8 != null) {
            var9 = var8.c().d();
            if(var13) {
               return var6;
            }

            label129: {
               if(this.G[var9] < 0) {
                  var10 = var8.g() == null?var8.i():var8.g();
                  var11 = var10.d();
                  var6 += (float)((var4 - 1) * var5[var11.d()]) / (float)(var2 - 1);
                  if(this.v == null) {
                     break label129;
                  }

                  switch(this.v[var12 = var10.b()]) {
                  case 1:
                     var6 -= 0.3F;
                     if(!var13) {
                        break;
                     }
                  case -1:
                     var6 += 0.3F;
                  }

                  var6 -= (float)this.x[var12] * 0.01F;
                  if(!var13) {
                     break label129;
                  }
               }

               var6 += (float)var5[var9];
               if(this.u != null) {
                  switch(this.u[var14 = var8.b()]) {
                  case 1:
                     var6 += 0.3F;
                     if(!var13) {
                        break;
                     }
                  case -1:
                     var6 -= 0.3F;
                  }

                  var6 += (float)this.w[var14] * 0.01F;
               }
            }

            var8 = var8.h();
            if(var13) {
               break;
            }
         }
      }

      var6 /= (float)var7;
      return var6;
   }

   private final void a(y.c.D var1, int[] var2) {
      boolean var5 = N.x;
      int var3 = 0;
      y.c.p var4 = var1.k();

      while(var4 != null) {
         var2[((y.c.q)var4.c()).d()] = var3++;
         var4 = var4.a();
         if(var5) {
            break;
         }
      }

   }

   private final void a(int[] var1, int[] var2) {
      System.arraycopy(var1, 0, var2, 0, var1.length);
   }

   private final void b(int[] var1) {
      boolean var3 = N.x;
      this.a(var1, this.H);
      int var2 = 0;

      while(var2 < this.F.length) {
         this.b(this.F[var2], this.H);
         ++var2;
         if(var3) {
            break;
         }
      }

   }

   private final void b(y.c.D var1, int[] var2) {
      boolean var5 = N.x;
      y.c.p var3 = var1.k();

      while(var3 != null) {
         y.c.q var4 = (y.c.q)var3.c();
         this.m[var2[var4.d()]] = var4;
         var3 = var3.a();
         if(var5) {
            break;
         }
      }

      int var6 = 0;
      y.c.p var7 = var1.k();

      while(var7 != null) {
         var7.a(this.m[var6]);
         var7 = var7.a();
         ++var6;
         if(var5) {
            break;
         }
      }

   }

   private final void a(y.c.D var1, int[] var2, Comparator var3) {
      boolean var7 = N.x;
      int var4 = 0;
      y.c.p var5 = var1.k();

      while(true) {
         if(var5 != null) {
            this.m[var4] = (y.c.q)var5.c();
            var5 = var5.a();
            ++var4;
            if(var7) {
               break;
            }

            if(!var7) {
               continue;
            }
         }

         y.g.e.a(this.m, 0, var1.size(), var3);
         var4 = 0;
         break;
      }

      var5 = var1.k();

      while(var5 != null) {
         y.c.q var6 = this.m[var4];
         var5.a(var6);
         var2[var6.d()] = var4;
         var5 = var5.a();
         ++var4;
         if(var7) {
            break;
         }
      }

   }

   static float[] a(r var0) {
      return var0.k;
   }
}
