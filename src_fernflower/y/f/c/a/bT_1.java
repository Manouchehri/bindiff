package y.f.c.a;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.Map;
import y.f.c.a.A;
import y.f.c.a.E;
import y.f.c.a.N;
import y.f.c.a.aP;
import y.f.c.a.aU;
import y.f.c.a.aV;
import y.f.c.a.aX;
import y.f.c.a.bK;
import y.f.c.a.bR;
import y.f.c.a.bU;
import y.f.c.a.bV;
import y.f.c.a.bW;
import y.f.c.a.bX;
import y.f.c.a.bx;
import y.f.c.a.cF;
import y.f.c.a.cP;
import y.f.c.a.cX;

class bT implements bx {
   private int e = 250;
   private boolean f = true;
   private Comparator g;
   private long h = 10000L;
   private byte i = 0;
   private float[] j;
   private float[] k;
   private y.c.q[] l;
   private int[] m;
   private int[] n;
   private y.c.p[] o;
   private y.c.D p;
   private y.c.D q;
   private y.c.D r;
   private y.c.D s;
   private byte[] t;
   private byte[] u;
   private int[] v;
   private int[] w;
   private Comparator x;
   private Comparator y;
   private Comparator z;
   private Comparator A;
   private Comparator B;
   private Comparator C;
   private y.f.X D;
   private y.c.D[] E;
   private int[] F;
   private int[] G;
   private y.c.q[][] H;
   private y.c.q[][] I;
   private int J = 0;
   private int K = 0;
   private int L = 0;
   int[] a;
   int[] b;
   Comparator c;
   private bR M;
   private Comparator N;
   private E O;
   final int[] d = new int[4];

   void a(Map var1) {
      Object var2 = var1.get("SubgraphLayerSequencer.weightHeuristic");
      if(var2 instanceof Number) {
         this.a(((Number)var2).byteValue());
      }

      var2 = var1.get("SubgraphLayerSequencer.maximalDuration");
      if(var2 instanceof Number) {
         this.a(((Number)var2).longValue());
      }

      var2 = var1.get("SubgraphLayerSequencer.transpositionEnabled");
      if(var2 instanceof Boolean) {
         this.a(((Boolean)var2).booleanValue());
      }

      var2 = var1.get("SubgraphLayerSequencer.randomizationRounds");
      if(var2 instanceof Number) {
         this.a(((Number)var2).intValue());
      }

   }

   public void a(boolean var1) {
      this.f = var1;
   }

   public void a(byte var1) {
      if(var1 != 0 && var1 != 1) {
         throw new IllegalArgumentException();
      } else {
         this.i = var1;
      }
   }

   public void a(int var1) {
      this.e = var1;
   }

   public void a(long var1) {
      this.h = var1;
   }

   private cF a(y.f.X var1, aU var2, aV var3, int[] var4, int[] var5) {
      this.t = new byte[var1.h()];
      Arrays.fill(this.t, (byte)-2);
      this.v = new int[var1.h()];
      this.u = new byte[var1.h()];
      Arrays.fill(this.u, (byte)-2);
      this.w = new int[var1.h()];
      return cF.a(var1, var2, var3, var5, var4, this.t, this.v, this.u, this.w, (byte)1, (byte)0);
   }

   private void a(y.c.i var1, y.g.ar var2) {
      boolean var4 = N.x;
      y.c.x var3 = var1.o();

      while(true) {
         if(var3.f()) {
            this.j[var3.e().d()] = (float)var2.nextInt();
            var3.g();
            if(var4) {
               break;
            }

            if(!var4) {
               continue;
            }
         }

         var1.a((Comparator)(new bU(this)), (Comparator)(new bV(this)));
         break;
      }

   }

   private int a() {
      boolean var3 = N.x;
      this.a((y.c.i)this.D, (Comparator)this.B, (Comparator)this.C);
      int var1 = 0;
      int var2 = this.E.length - 1;

      int var10000;
      while(true) {
         if(var2 > 0) {
            var10000 = this.L;
            if(var3) {
               break;
            }

            if(var10000 == 0 || this.H[var2] != null || this.H[var2 - 1] != null) {
               var1 += this.a(this.E[var2 - 1], this.E[var2]);
            }

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
      this.p.clear();
      this.q.clear();
      this.r.clear();
      this.s.clear();
      int var5 = 0;

      int var7;
      label55:
      while(true) {
         y.c.p var10000;
         if(var3 != null) {
            var10000 = var4;
            if(!var6) {
               if(var4 != null) {
                  var5 += this.a((y.c.q)var3.c(), this.p, this.r, this.q);
                  var5 += this.b((y.c.q)var4.c(), this.q, this.s, this.p);
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
            var5 += this.a((y.c.q)var3.c(), this.p, this.r, this.q);
            var3 = var3.a();
            if(var6) {
               break label55;
            }

            if(var6) {
               while(true) {
                  if(var4 == null) {
                     break label55;
                  }

                  var7 = var5 + this.b((y.c.q)var4.c(), this.q, this.s, this.p);
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

            var7 = var5 + this.b((y.c.q)var4.c(), this.q, this.s, this.p);
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
      int var5 = this.G[var1.d()];
      int var6 = this.d[0] = this.d[1] = this.d[2] = this.d[3] = 0;
      y.c.d var7 = var1.f();

      while(var7 != null) {
         label107: {
            label115: {
               int var8;
               y.c.p var9 = this.o[var8 = var7.b()];
               y.c.p var11;
               if(var9.c() == null) {
                  label103: {
                     if(this.F[var7.d().d()] < 0) {
                        y.c.d var10 = var7.h() == null?var7.j():var7.h();
                        var11 = this.o[var10.b()];
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

                  ++this.d[this.t[var8] + 2];
                  if(!var14) {
                     break label115;
                  }
               }

               if(this.F[var7.d().d()] < 0) {
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
               int var16 = this.v[var8];
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

               byte var17 = this.t[var8];
               y.c.p var12 = var9.b();

               int var10000;
               int var10001;
               label69: {
                  while(var12 != null) {
                     y.c.d var13;
                     var10000 = this.G[(var13 = (y.c.d)var12.c()).c().d()];
                     var10001 = var5;
                     if(var14) {
                        break label69;
                     }

                     if(var10000 > var5 || var17 != -2 && this.t[var13.b()] > var17) {
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
      int var5 = this.G[var1.d()];
      int var6 = this.d[0] = this.d[1] = this.d[2] = this.d[3] = 0;
      y.c.d var7 = var1.g();

      while(var7 != null) {
         label107: {
            label115: {
               int var8;
               y.c.p var9 = this.o[var8 = var7.b()];
               y.c.p var11;
               if(var9.c() == null) {
                  label103: {
                     if(this.F[var7.c().d()] < 0) {
                        y.c.d var10 = var7.g() == null?var7.i():var7.g();
                        var11 = this.o[var10.b()];
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

               if(this.F[var7.c().d()] < 0) {
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

                     var6 += var4.size() + var3.size();
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
                     var10000 = this.G[(var13 = (y.c.d)var12.c()).d().d()];
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

            var7 = var7.h();
         }

         if(var14) {
            break;
         }
      }

      return var6;
   }

   private byte a(int[] var1) {
      return this.a(0, this.E.length - 1, var1);
   }

   private byte a(int var1, int var2, int[] var3) {
      boolean var10 = N.x;
      byte var4 = 0;
      boolean var5;
      int var6;
      int var7;
      y.c.D var8;
      byte var9;
      if(var1 <= var2) {
         var5 = true;
         var6 = 20;

         label60:
         while(true) {
            if(!var5) {
               return var4;
            }

            --var6;
            if(var6 <= 0) {
               return var4;
            }

            var5 = false;
            var7 = var1;

            while(var7 <= var2) {
               if(this.H[var7] != null) {
                  var8 = this.E[var7];
                  this.a(var8, this.A, this.z);
                  var9 = this.a(var7, var8, true, true, var3);
                  var5 = (var9 & 4) != 0;
                  var4 |= var9;
               }

               ++var7;
               if(var10) {
                  break label60;
               }
            }
         }
      }

      var5 = true;
      var6 = 20;

      while(var5) {
         --var6;
         if(var6 <= 0) {
            break;
         }

         var5 = false;
         var7 = var1;

         while(var7 >= var2) {
            if(this.H[var7] != null) {
               var8 = this.E[var7];
               this.a(var8, this.A, this.z);
               var9 = this.a(var7, var8, true, true, var3);
               var5 = (var9 & 4) != 0;
               var4 |= var9;
            }

            --var7;
            if(var10) {
               return var4;
            }
         }
      }

      return var4;
   }

   private byte a(int var1, y.c.D var2, boolean var3, boolean var4, int[] var5) {
      if(this.L > 0 && this.H[var1] == null) {
         return (byte)0;
      } else {
         byte var6 = this.a(var2, var3, var4, var5);
         byte var7 = this.b(var2, var3, var4, var5);
         return (byte)(var6 | var7);
      }
   }

   private byte a(y.c.D var1, boolean var2, boolean var3, int[] var4) {
      boolean var18 = N.x;
      byte var5 = 0;
      boolean var6 = false;
      boolean var7 = false;
      y.c.p var8 = var1.k();
      int var9 = 0;

      int var10000;
      while(true) {
         if(var9 < var1.size() - 1) {
            y.c.p var10 = var8;
            var8 = var8.a();
            y.c.q var11 = (y.c.q)var10.c();
            y.c.q var12 = (y.c.q)var8.c();
            var10000 = this.L;
            if(var18) {
               break;
            }

            if(var10000 <= 0 || this.a(var11) || this.a(var12)) {
               label205: {
                  int var13;
                  int var14;
                  if(this.M != null) {
                     if(this.M.a(this.D, (y.c.q)var11, (y.c.q)var12)) {
                        break label205;
                     }
                  } else if(this.a != null) {
                     var13 = this.a[var11.d()];
                     var14 = this.a[var12.d()];
                     if(var13 >= 0 && var14 >= 0 && var13 != var14) {
                        break label205;
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
                     label171: {
                        int var15;
                        if(var13 > var14) {
                           var5 = 1;
                           var15 = var4[var11.d()];
                           var4[var11.d()] = var4[var12.d()];
                           var4[var12.d()] = var15;
                           var8.a(var11);
                           var10.a(var12);
                           var6 |= var11.c() > 0 || var12.c() > 0;
                           var7 |= var11.b() > 0 || var12.b() > 0;
                           this.a(var11, var2?this.A:null, var3?this.z:null, true);
                           this.a(var12, var2?this.A:null, var3?this.z:null, false);
                           if(!var18) {
                              break label171;
                           }
                        }

                        var15 = this.a(var11, var12, true, true, var4);
                        int var16 = this.a(var12, var11, true, true, var4);
                        if(var16 < var15) {
                           int var17 = var4[var11.d()];
                           var4[var11.d()] = var4[var12.d()];
                           var4[var12.d()] = var17;
                           var8.a(var11);
                           var10.a(var12);
                           var6 |= var11.c() > 0 || var12.c() > 0;
                           var7 |= var11.b() > 0 || var12.b() > 0;
                           this.a(var11, var2?this.A:null, var3?this.z:null, true);
                           this.a(var12, var2?this.A:null, var3?this.z:null, false);
                        }
                     }
                  }
               }
            }

            ++var9;
            if(!var18) {
               continue;
            }
         }

         var10000 = var5;
         break;
      }

      return (byte)((var10000 != 0?4:0) | (var7?2:0) | (var6?1:0));
   }

   private byte b(y.c.D var1, boolean var2, boolean var3, int[] var4) {
      boolean var18 = N.x;
      byte var5 = 0;
      boolean var6 = false;
      boolean var7 = false;
      y.c.p var8 = var1.l();
      int var9 = var1.size() - 2;

      int var10000;
      while(true) {
         if(var9 >= 0) {
            y.c.p var10 = var8;
            var8 = var8.b();
            y.c.q var11 = (y.c.q)var8.c();
            y.c.q var12 = (y.c.q)var10.c();
            var10000 = this.L;
            if(var18) {
               break;
            }

            if(var10000 <= 0 || this.a(var11) || this.a(var12)) {
               label213: {
                  int var13;
                  int var14;
                  if(this.M != null) {
                     if(this.M.a(this.D, (y.c.q)var11, (y.c.q)var12)) {
                        break label213;
                     }
                  } else if(this.a != null) {
                     var13 = this.a[var11.d()];
                     var14 = this.a[var12.d()];
                     if(var13 >= 0 && var14 >= 0 && var13 != var14) {
                        break label213;
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
                     label211: {
                        int var15;
                        if(var13 > var14) {
                           var5 = 1;
                           var15 = var4[var11.d()];
                           var4[var11.d()] = var4[var12.d()];
                           var4[var12.d()] = var15;
                           var10.a(var11);
                           var8.a(var12);
                           var6 |= var11.c() > 0 || var12.c() > 0;
                           var7 |= var11.b() > 0 || var12.b() > 0;
                           this.a(var11, var2?this.A:null, var3?this.z:null, true);
                           this.a(var12, var2?this.A:null, var3?this.z:null, false);
                           if(!var18) {
                              break label211;
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
                           this.a(var11, var2?this.A:null, var3?this.z:null, true);
                           this.a(var12, var2?this.A:null, var3?this.z:null, false);
                        }
                     }
                  }
               }
            }

            --var9;
            if(!var18) {
               continue;
            }
         }

         var10000 = var5;
         break;
      }

      return (byte)((var10000 != 0?4:0) | (var7?2:0) | (var6?1:0));
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
                        this.D.a(var6, var6.g(), var5, 1, 1);
                        if(!var7) {
                           break label101;
                        }
                     }

                     this.D.a(var6, var6.i(), var5, 0, 1);
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
                  this.D.a(var6, var5, var6.h(), 1, 1);
                  if(!var7) {
                     break label87;
                  }
               }

               this.D.a(var6, var5, var6.j(), 1, 0);
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
                     this.D.a(var6, var6.g(), var5, 1, 0);
                     if(!var7) {
                        break label67;
                     }
                  }

                  this.D.a(var6, var6.i(), var5, 0, 0);
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
               this.D.a(var6, var5, var6.h(), 0, 1);
               if(!var7) {
                  break label48;
               }
            }

            this.D.a(var6, var5, var6.j(), 0, 0);
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
            var10000 = this.F[var6.c().d()];
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
            var10000 = this.F[var6.d().d()];
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
                     if(this.F[var4.d().d()] < 0) {
                        y.c.d var9 = var4.h() == null?var4.j():var4.h();
                        y.c.q var10 = var9.c();
                        if(var10 == var2) {
                           var4 = var4.g();
                           if(!var22) {
                              continue;
                           }
                        }

                        boolean var11 = var3[var10.d()] < var3[var1.d()];
                        if(this.F[var5.d().d()] < 0) {
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
                                 byte var18 = this.t[var16 = var9.b()];
                                 int var17;
                                 byte var19 = this.t[var17 = var12.b()];
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

                                 int var20 = this.v[var16];
                                 int var21 = this.v[var17];
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

                     if(this.F[var5.d().d()] < 0) {
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
            var31 = this.F[var4.d().d()];
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
                     if(this.F[var4.c().d()] < 0) {
                        y.c.d var9 = var4.g() == null?var4.i():var4.g();
                        y.c.q var10 = var9.d();
                        if(var10 == var2) {
                           var4 = var4.h();
                           if(!var22) {
                              continue;
                           }
                        }

                        boolean var11 = var3[var10.d()] < var3[var1.d()];
                        if(this.F[var5.c().d()] < 0) {
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

                     if(this.F[var5.c().d()] < 0) {
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
                        byte var29 = this.t[var26 = var4.b()];
                        int var28;
                        byte var30 = this.t[var28 = var5.b()];
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

                        var15 = this.v[var26];
                        var16 = this.v[var28];
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
            var31 = this.F[var4.c().d()];
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

   private boolean a(y.f.X var1, aU var2, y.c.c var3) {
      boolean var14 = N.x;
      y.c.q[][] var4 = new y.c.q[var2.b()][];
      y.c.q[][] var5 = new y.c.q[var2.b()][];
      int var6 = Integer.MAX_VALUE;
      int var7 = 0;
      int var8 = 0;
      ArrayList var9 = new ArrayList(120);
      ArrayList var10 = new ArrayList(120);
      int var11 = 0;

      while(true) {
         if(var11 < var2.b()) {
            var9.clear();
            var10.clear();
            if(var14) {
               break;
            }

            y.c.p var12 = var2.a(var11).d().k();

            int var10000;
            label51: {
               while(var12 != null) {
                  y.c.q var13 = (y.c.q)var12.c();
                  var10000 = var3.d(var13);
                  if(var14) {
                     break label51;
                  }

                  label47: {
                     if(var10000 != 0) {
                        var9.add(var13);
                        var1.e(var13);
                        if(!var14) {
                           break label47;
                        }
                     }

                     var10.add(var13);
                  }

                  var12 = var12.a();
                  if(var14) {
                     break;
                  }
               }

               var10000 = var9.size();
            }

            if(var10000 > 0) {
               y.c.q[] var15;
               if(var10.size() > 0) {
                  var15 = (y.c.q[])var10.toArray(new y.c.q[var10.size()]);
                  var5[var11] = var15;
               }

               if(var11 < var6) {
                  var6 = var11;
               }

               var7 = var11;
               var15 = (y.c.q[])var9.toArray(new y.c.q[var9.size()]);
               var4[var11] = var15;
               var8 += var15.length;
            }

            ++var11;
            if(!var14) {
               continue;
            }
         }

         if(var8 > 0) {
            this.H = var4;
            this.L = var8;
            this.J = var6;
            this.K = var7;
            this.I = var5;
            return true;
         }

         this.L = 0;
         this.H = (y.c.q[][])null;
         this.I = (y.c.q[][])null;
         break;
      }

      return true;
   }

   private final boolean a(y.c.q var1) {
      return var1.d() < this.L;
   }

   public void a(y.f.X var1, aU var2, aV var3, aP var4) {
      boolean var27 = N.x;
      this.O = (E)var1.c(N.w).b(var1);
      this.M = (bR)var1.c(N.v).b(var1);
      int var5 = this.e;
      if(this.M != null) {
         var5 = Math.min(this.e, 50);
      }

      boolean var7;
      label911: {
         y.c.c var6 = var1.c(N.t);
         if(var6 != null) {
            var7 = this.a(var1, var2, var6);
            if(!var27) {
               break label911;
            }
         }

         var7 = false;
      }

      if(!var7 || this.L != 0) {
         this.E = new y.c.D[var2.b()];
         int var8 = 0;
         ArrayList var9 = new ArrayList();
         int var10 = 0;
         y.c.x var11 = var1.o();

         aX var12;
         while(true) {
            if(var11.f()) {
               var12 = var3.a(var11.e());
               var10 += var12.e();
               var11.g();
               if(var27) {
                  break;
               }

               if(!var27) {
                  continue;
               }
            }

            this.F = new int[var1.e() + var10 / 2];
            this.G = new int[var1.e() + var10 / 2];
            break;
         }

         int var30 = 0;

         int var10000;
         int var32;
         Object var37;
         label896:
         while(true) {
            var10000 = var30;

            label893:
            while(var10000 < var2.b()) {
               this.E[var30] = new y.c.D();
               var32 = 0;
               var37 = var2.a(var30).d();
               if(var27) {
                  break label896;
               }

               y.c.p var13 = ((y.c.y)var37).k();

               while(var13 != null) {
                  y.c.q var38 = (y.c.q)var13.c();

                  y.c.q var14;
                  label887:
                  while(true) {
                     var14 = var38;
                     aX var15 = var3.a(var14);
                     var10000 = var15.e();
                     if(var27) {
                        continue label893;
                     }

                     if(var10000 <= 0) {
                        break;
                     }

                     y.c.p var16 = var15.d();

                     while(true) {
                        if(var16 == null) {
                           break label887;
                        }

                        y.c.d var17 = (y.c.d)var16.c();
                        A var18 = var3.a(var17);
                        var38 = var17.c();
                        if(var27) {
                           break;
                        }

                        if(var38 == var14) {
                           y.c.q var19;
                           label881: {
                              var19 = var1.d();
                              var9.add(var19);
                              if(var18.j()) {
                                 var4.b(var19, var14, var17, false, true);
                                 var4.a(var19, var17.d(), var17, false, true);
                                 var8 = Math.max(var8, var17.d().b());
                                 if(!var27) {
                                    break label881;
                                 }
                              }

                              var4.a(var14, var19, var17, true, false);
                              var4.b(var17.d(), var19, var17, true, false);
                              var8 = Math.max(var8, var17.d().c());
                           }

                           var8 = Math.max(2, var8);
                           this.G[var19.d()] = -1;
                           this.F[var19.d()] = -(var30 + 1);
                        }

                        var16 = var16.a();
                        if(var27) {
                           break label887;
                        }
                     }
                  }

                  var8 = Math.max(var8, Math.max(var14.b(), var14.c()));
                  this.E[var30].b((Object)var14);
                  this.G[var14.d()] = var32;
                  this.F[var14.d()] = var30;
                  ++var32;
                  var13 = var13.a();
                  if(var27) {
                     break;
                  }
               }

               ++var30;
               if(!var27) {
                  continue label896;
               }
               break;
            }

            this.p = new y.c.D();
            this.q = new y.c.D();
            this.r = new y.c.D();
            this.s = new y.c.D();
            this.l = new y.c.q[var1.f()];
            this.j = new float[var1.f()];
            this.o = new y.c.p[var1.g()];
            var37 = new y.c.D();
            break;
         }

         Object var31 = var37;
         var32 = var1.g() - 1;

         while(true) {
            if(var32 >= 0) {
               this.o[var32] = ((y.c.D)var31).a((Object)null);
               ((y.c.D)var31).g();
               --var32;
               if(var27) {
                  break;
               }

               if(!var27) {
                  continue;
               }
            }

            this.k = new float[var8 + 2];
            this.g = new bX(this.j);
            break;
         }

         label844: {
            label843: {
               if(this.M != null) {
                  this.m = new int[var1.f()];
                  this.n = new int[var1.f()];
                  this.M.a(var1, var3, true);
                  this.M.a(var1, (int[])this.n, (int[])this.m);
                  this.N = this.M.a(var1, (y.c.D[])this.E, (int[])this.G);
                  var32 = 0;

                  do {
                     if(var32 >= this.E.length) {
                        break label843;
                     }

                     this.a(this.E[var32], this.G, this.N);
                     ++var32;
                     if(var27) {
                        break label844;
                     }
                  } while(!var27);
               }

               if(this.a((y.c.i)var1, (y.c.D[])this.E, (aV)var3)) {
                  this.c = new cP(this.a);
                  var32 = 0;

                  while(var32 < this.E.length) {
                     this.a(this.E[var32], this.G, this.c);
                     ++var32;
                     if(var27) {
                        break label844;
                     }

                     if(var27) {
                        break;
                     }
                  }
               }
            }

            this.D = var1;
         }

         try {
            label819: {
               cF var35 = this.a(var1, var2, var3, this.G, this.F);
               this.x = var35.b(false);
               this.y = var35.b(true);
               this.z = var35.c(true);
               this.A = var35.c(false);
               this.B = this.x;
               this.C = this.y;
               long var33 = System.currentTimeMillis();
               y.g.ar var36 = new y.g.ar(666L);
               this.a((y.c.i)var1, (y.c.D[])this.E, (int[])this.G, (y.g.ar)null);
               this.O.a(this.E, this.G, true);
               int[] var39 = new int[this.G.length];
               int var40 = this.a(var36);
               this.a(this.G, var39);
               if(System.currentTimeMillis() - var33 < this.h && var40 > 0) {
                  int var41 = 0;

                  while(var41 < var5) {
                     var10000 = var40;
                     if(var27) {
                        break label819;
                     }

                     if(var40 <= 0 || System.currentTimeMillis() - var33 >= this.h) {
                        break;
                     }

                     int var42;
                     bT var43;
                     label811: {
                        label924: {
                           if((var41 & 3) < 2) {
                              this.a((y.c.i)var1, (y.c.D[])this.E, (int[])this.G, (y.g.ar)var36);
                              if(!var27) {
                                 break label924;
                              }
                           }

                           var42 = 0;

                           label804: {
                              label803:
                              do {
                                 var10000 = var42;

                                 label800:
                                 while(true) {
                                    int var10001 = this.E.length;

                                    label797:
                                    while(true) {
                                       if(var10000 >= var10001) {
                                          break label803;
                                       }

                                       var10000 = this.L;
                                       if(var27) {
                                          break label804;
                                       }

                                       int var20;
                                       if(var10000 == 0) {
                                          label780: {
                                             label929: {
                                                if(this.a == null && this.M == null) {
                                                   var20 = 0;

                                                   do {
                                                      if(var20 >= this.j.length) {
                                                         break label929;
                                                      }

                                                      this.j[var20] = var36.nextFloat();
                                                      ++var20;
                                                      if(var27) {
                                                         break label780;
                                                      }
                                                   } while(!var27);
                                                }

                                                if(this.a != null) {
                                                   var20 = 0;

                                                   do {
                                                      if(var20 >= this.j.length) {
                                                         break label929;
                                                      }

                                                      int var21 = this.a[var20];
                                                      var10000 = var21;
                                                      if(var27) {
                                                         continue label800;
                                                      }

                                                      label762: {
                                                         if(var21 < 0) {
                                                            this.j[var20] = var36.nextFloat() * (float)(this.b[var42] + 1) * 2.0F;
                                                            if(!var27) {
                                                               break label762;
                                                            }
                                                         }

                                                         this.j[var20] = var36.nextFloat() + (float)((var21 + 1) * 2);
                                                      }

                                                      ++var20;
                                                   } while(!var27);
                                                }

                                                var20 = 0;

                                                while(var20 < this.j.length) {
                                                   this.j[var20] = var36.nextFloat() * (float)this.m[var20] + (float)this.n[var20];
                                                   ++var20;
                                                   if(var27) {
                                                      break label780;
                                                   }

                                                   if(var27) {
                                                      break;
                                                   }
                                                }
                                             }

                                             this.a(this.E[var42], this.G, this.g);
                                          }

                                          if(!var27) {
                                             break label800;
                                          }
                                       }

                                       var20 = 0;
                                       if(this.H[var42] == null || this.H[var42].length <= 0) {
                                          break label800;
                                       }

                                       float var44 = 1.0F / (float)(1 + this.E[var42].size() - this.H[var42].length);
                                       y.c.p var22 = this.E[var42].k();

                                       while(true) {
                                          if(var22 == null) {
                                             break label797;
                                          }

                                          int var23 = ((y.c.q)var22.c()).d();
                                          var10000 = var23;
                                          var10001 = this.L;
                                          if(var27) {
                                             break;
                                          }

                                          label792: {
                                             if(var23 < var10001) {
                                                this.j[var23] = var36.nextFloat();
                                                if(!var27) {
                                                   break label792;
                                                }
                                             }

                                             ++var20;
                                             this.j[var23] = var44 * (float)var20;
                                          }

                                          var22 = var22.a();
                                          if(var27) {
                                             break label797;
                                          }
                                       }
                                    }

                                    this.a(this.E[var42], this.G, this.g);
                                    if(this.a != null) {
                                       this.a(this.E[var42], this.G, this.c);
                                    }
                                    break;
                                 }

                                 ++var42;
                              } while(!var27);

                              var10000 = this.L;
                           }

                           if(var10000 != 0 && this.M != null) {
                              this.N = this.M.a(var1, (y.c.D[])this.E, (int[])this.G);
                              var42 = 0;

                              while(var42 < this.E.length) {
                                 var43 = this;
                                 if(var27) {
                                    break label811;
                                 }

                                 if(this.H[var42] != null && this.H[var42].length > 0) {
                                    this.a(this.E[var42], this.G, this.N);
                                 }

                                 ++var42;
                                 if(var27) {
                                    break;
                                 }
                              }
                           }
                        }

                        this.O.a(this.E, this.G, true);
                        var43 = this;
                     }

                     var42 = var43.a(var36);
                     if(var42 < var40) {
                        this.a(this.G, var39);
                        var40 = var42;
                     }

                     ++var41;
                     if(var27) {
                        break;
                     }
                  }

                  this.b(var39);
               }

               var10000 = this.f;
            }

            if(var10000 != 0 && !this.O.k()) {
               this.a(this.G);
            }
         } finally {
            int var26;
            label690: {
               label689: {
                  if(this.M != null) {
                     this.N = this.M.a(var1, (y.c.D[])this.E, (int[])this.G);
                     var26 = 0;

                     label685: {
                        while(var26 < this.E.length) {
                           this.a(this.E[var26], this.G, this.N);
                           ++var26;
                           if(var27) {
                              break label685;
                           }

                           if(var27) {
                              break;
                           }
                        }

                        this.M.b(var1, var3, false);
                     }

                     if(!var27) {
                        break label689;
                     }
                  }

                  if(this.c != null) {
                     var26 = 0;

                     while(var26 < this.E.length) {
                        this.a(this.E[var26], this.G, this.c);
                        ++var26;
                        if(var27) {
                           break label690;
                        }

                        if(var27) {
                           break;
                        }
                     }
                  }
               }

               var26 = 0;
            }

            while(true) {
               if(var26 < var9.size()) {
                  var1.a((y.c.q)((y.c.q)var9.get(var26)));
                  ++var26;
                  if(var27) {
                     break;
                  }

                  if(!var27) {
                     continue;
                  }
               }

               this.D = null;
               this.G = null;
               this.r = null;
               this.s = null;
               this.p = null;
               this.q = null;
               this.j = null;
               this.o = null;
               this.k = null;
               this.l = null;
               this.t = null;
               this.u = null;
               break;
            }

            var12 = null;
            this.g = null;
            this.v = null;
            this.w = null;
            this.x = null;
            this.y = null;
            this.z = null;
            this.A = null;
            this.B = null;
            this.C = null;
            this.c = null;
            this.a = null;
         }

         if(this.E != null) {
            int var34 = 0;

            while(var34 < var2.b()) {
               var2.a(var34).a(this.E[var34]);
               ++var34;
               if(var27) {
                  return;
               }

               if(var27) {
                  break;
               }
            }

            this.O.g(var2);
         }

         this.E = null;
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

               if(this.O != null && this.O.k()) {
                  this.O.a(var2, var4, this.b);
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
                     y.c.q var16 = var14.e();
                     if(var12) {
                        break;
                     }

                     if(var8 == 0) {
                        var5 = var16;
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

         var1.a((Comparator)(new cX(this.u)), (Comparator)(new cX(this.t)));
         break;
      }

      bW var13 = new bW(this, var6, var7, var2);
      var13.a(false);
      var13.b(true);
      var13.a(var1, var5);
      int var15;
      if(this.M != null) {
         this.N = this.M.a(var1, var2, var3);
         var15 = 0;

         do {
            if(var15 >= var2.length) {
               return;
            }

            this.a(var2[var15], var3, this.N);
            ++var15;
         } while(!var12);
      }

      if(this.c != null) {
         var15 = 0;

         do {
            if(var15 >= var2.length) {
               return;
            }

            this.a(var2[var15], var3, this.c);
            ++var15;
         } while(!var12);
      }

      var15 = 0;

      while(var15 < var2.length) {
         this.a(var2[var15], var3);
         ++var15;
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
      int[] var5 = new int[this.G.length];
      boolean var6 = var1.nextBoolean();
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
               label52: {
                  var4 = this.b(var6);
                  if(var4 < var3) {
                     var3 = var4;
                     var2 = true;
                     this.a(this.G, var5);
                     if(!var9) {
                        break label52;
                     }
                  }

                  if(var4 > var3) {
                     ++var8;
                     if(!var9) {
                        break label52;
                     }
                  }

                  ++var7;
               }

               var6 = !var6;
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

   private int b(boolean var1) {
      bT var10000;
      label81: {
         label84: {
            boolean var3 = N.x;
            int var2;
            if(this.L > 0) {
               if(var1) {
                  this.O.a(Math.max(1, this.J) - 1);
                  var2 = Math.max(1, this.J);

                  do {
                     if(var2 > this.K) {
                        break label84;
                     }

                     var10000 = this;
                     if(var3) {
                        break label81;
                     }

                     if(this.H[var2] != null) {
                        this.a(true, false, var2, this.E[var2], this.E[var2 - 1], (y.c.D)null, this.j, this.G);
                     }

                     ++var2;
                  } while(!var3);
               }

               this.O.a(Math.min(this.E.length - 1, this.K));
               var2 = Math.min(this.E.length - 1, this.K) - 1;

               do {
                  if(var2 < this.J) {
                     break label84;
                  }

                  var10000 = this;
                  if(var3) {
                     break label81;
                  }

                  if(this.H[var2] != null) {
                     this.a(false, true, var2, this.E[var2], (y.c.D)null, this.E[var2 + 1], this.j, this.G);
                  }

                  --var2;
               } while(!var3);
            }

            if(var1) {
               this.O.a(0);
               var2 = 1;

               do {
                  if(var2 >= this.E.length) {
                     break label84;
                  }

                  this.a(this.E, var2, this.G);
                  ++var2;
                  if(var3) {
                     return this.a();
                  }
               } while(!var3);
            }

            this.O.a(this.E.length - 1);
            var2 = this.E.length - 2;

            while(var2 >= 0) {
               this.b(this.E, var2, this.G);
               --var2;
               if(var3) {
                  return this.a();
               }

               if(var3) {
                  break;
               }
            }
         }

         var10000 = this;
      }

      if(var10000.f && !this.O.k()) {
         this.a(this.G);
      }

      return this.a();
   }

   private void a(boolean var1, boolean var2, int var3, y.c.D var4, y.c.D var5, y.c.D var6, float[] var7, int[] var8) {
      boolean var29 = N.x;
      int var9 = var4.size();
      int var10 = var9 * 2;
      float var11 = 1.0F;
      int var12 = 0;
      y.c.p var13 = var4.k();

      int var10000;
      while(true) {
         if(var13 != null) {
            y.c.q var14 = (y.c.q)var13.c();
            var8[var14.d()] = var12 + 1;
            var7[var14.d()] = (float)var12;
            float var40;
            var10000 = (var40 = var11 - var7[var14.d()]) == 0.0F?0:(var40 < 0.0F?-1:1);
            if(var29) {
               break;
            }

            if(var10000 < 0) {
               var11 = var7[var14.d()];
            }

            var13 = var13.a();
            var12 += 2;
            if(!var29) {
               continue;
            }
         }

         var10000 = var2;
         break;
      }

      if(var10000 != 0) {
         this.a((y.c.D)var4, (Comparator)null, (Comparator)this.z);
      }

      if(var1 != 0) {
         this.a((y.c.D)var4, (Comparator)this.A, (Comparator)null);
      }

      y.c.q[] var30 = this.H[var3];
      y.c.q[] var31 = this.I[var3];
      int var32 = var1 != 0?var5.size():0;
      int var15 = var2 != 0?var6.size():0;
      int var16 = 0;

      label220: {
         label219: {
            label235: {
               int var18;
               int var19;
               bR var34;
               label217:
               while(true) {
                  if(var16 < var30.length) {
                     y.c.q var17 = var30[var16];
                     var18 = var17.d();
                     var19 = 0;
                     float var20 = 0.0F;
                     var10000 = var1;
                     if(var29) {
                        break label235;
                     }

                     if(var1 != 0) {
                        label245: {
                           y.c.d var21 = var17.g();

                           while(var21 != null) {
                              var20 += this.a(true, var21, var9, var10, this.G);
                              var21 = var21.h();
                              ++var19;
                              if(var29) {
                                 break label245;
                              }

                              if(var29) {
                                 break;
                              }
                           }

                           var20 /= (float)var32;
                        }
                     }

                     float var38;
                     if(var2 != 0) {
                        label246: {
                           var38 = 0.0F;
                           y.c.d var22 = var17.f();

                           while(var22 != null) {
                              var38 += this.a(false, var22, var9, var10, this.G);
                              var22 = var22.g();
                              ++var19;
                              if(var29) {
                                 break label246;
                              }

                              if(var29) {
                                 break;
                              }
                           }

                           var20 += var38 / (float)var15;
                        }
                     }

                     label186: {
                        if(var19 == 0) {
                           var38 = (float)this.G[var18];
                           if(!var29) {
                              break label186;
                           }
                        }

                        var20 = var20 * (float)var10 / (float)var19;
                        var38 = var20 + (float)this.G[var18] / 200.0F;
                     }

                     label181: {
                        int var39 = 0;
                        int var23 = var39;
                        int var24 = -1;
                        if(var31 != null && var31.length > 0) {
                           int var25 = 0;

                           while(var25 < var31.length) {
                              y.c.q var26 = var31[var25];
                              var34 = this.M;
                              if(var29) {
                                 break label217;
                              }

                              label243: {
                                 if(var34 != null) {
                                    if(this.M.a(var17.e(), var26, var17)) {
                                       var23 = var39;
                                       var24 = this.G[var26.d()] + 1;
                                       if(!var29) {
                                          break label243;
                                       }
                                    }

                                    if(this.M.a(var17.e(), var17, var26)) {
                                       break;
                                    }
                                 } else if(this.a != null && this.a[var18] >= 0 && this.a[var26.d()] >= 0) {
                                    if(this.a[var18] > this.a[var26.d()]) {
                                       var23 = var39;
                                       var24 = this.G[var26.d()] + 1;
                                       if(!var29) {
                                          break label243;
                                       }
                                    }

                                    if(this.a[var18] < this.a[var26.d()]) {
                                       break;
                                    }
                                 }

                                 int var27 = this.G[var26.d()] - 1;
                                 int var28 = 0;
                                 if(var1 != 0) {
                                    var8[var18] = var27;
                                    this.a(var17, this.A, (Comparator)null, true);
                                    var28 -= this.d(var17, var26, this.G);
                                    var8[var18] += 2;
                                    this.a(var17, this.A, (Comparator)null, true);
                                    var28 += this.d(var26, var17, this.G);
                                 }

                                 if(var2 != 0) {
                                    var8[var18] = var27;
                                    this.a(var17, (Comparator)null, this.z, true);
                                    var28 -= this.c(var17, var26, this.G);
                                    var8[var18] += 2;
                                    this.a(var17, (Comparator)null, this.z, true);
                                    var28 += this.c(var26, var17, this.G);
                                 }

                                 var39 += var28;
                                 if(var39 < var23) {
                                    var24 = var27;
                                    var23 = var39;
                                    if(!var29) {
                                       break label243;
                                    }
                                 }

                                 if(var39 == var23 && Math.abs((float)var27 - var38) < Math.abs((float)var24 - var38)) {
                                    var24 = var27;
                                 }
                              }

                              ++var25;
                              if(var29) {
                                 break;
                              }
                           }

                           var7[var18] = (float)var24 + var38 / (float)var10;
                           if(!var29) {
                              break label181;
                           }
                        }

                        var7[var18] = var38;
                     }

                     if(var11 < var7[var18]) {
                        var11 = var7[var18];
                     }

                     ++var16;
                     if(!var29) {
                        continue;
                     }
                  }

                  var34 = this.M;
                  break;
               }

               if(var34 != null) {
                  y.c.p var33 = var4.k();

                  while(var33 != null) {
                     int var36 = ((y.c.q)var33.c()).d();
                     var7[var36] = var7[var36] / var11 * (float)this.m[var36] + (float)this.n[var36];
                     var33 = var33.a();
                     if(var29) {
                        break label219;
                     }
                  }
               } else if(this.a != null) {
                  float var35 = (float)(var4.size() * 3);
                  y.c.p var37 = var4.k();

                  while(var37 != null) {
                     var18 = ((y.c.q)var37.c()).d();
                     var19 = this.a[var18];
                     var10000 = var19;
                     if(var29) {
                        break label235;
                     }

                     label131: {
                        if(var19 >= 0) {
                           var7[var18] += (float)(var19 + 1) * var35;
                           if(!var29) {
                              break label131;
                           }
                        }

                        var7[var18] = var7[var18] / (float)(var10 + 1) * (float)(this.b[var3] + 1) * var35;
                     }

                     var37 = var37.a();
                     if(var29) {
                        break;
                     }
                  }
               }

               var10000 = this.O.k();
            }

            if(var10000 != 0) {
               this.O.a(var4, var3, this.j, this.G, true);
               if(!var29) {
                  break label220;
               }
            }
         }

         this.a(var4, this.G, this.g);
      }

      if(this.f && !this.O.k()) {
         if(var1 != 0) {
            this.a(var3, var4, true, false, this.G);
         }

         if(var2 != 0) {
            this.a(var3, var4, false, true, this.G);
         }
      }

   }

   void a(y.c.D[] var1, int var2, int[] var3) {
      boolean var13 = N.x;
      y.c.D var4 = var1[var2 - 1];
      y.c.D var5 = var1[var2];
      int var6 = var4.size();
      int var7 = var5.size();
      float var8 = 1.0F;
      y.c.p var9 = var5.k();

      label71: {
         label70: {
            byte var10000;
            while(true) {
               if(var9 != null) {
                  y.c.q var10 = (y.c.q)var9.c();
                  int var11 = var10.d();
                  var10000 = this.i;
                  if(var13) {
                     break;
                  }

                  switch(var10000) {
                  case 0:
                     this.j[var11] = this.b(var10, var7, false, var6, var3);
                     if(!var13) {
                        break;
                     }
                  case 1:
                     this.j[var11] = this.a(var10, var7, false, var6, var3);
                  }

                  this.j[var11] += (float)var3[var11] / (float)(var6 * 200);
                  if(this.a != null) {
                     label80: {
                        int var12 = this.a[var11];
                        if(var12 < 0) {
                           this.j[var11] = 2.0F * this.j[var11] * (float)(this.b[var2] + 1);
                           if(!var13) {
                              break label80;
                           }
                        }

                        this.j[var11] += (float)((var12 + 1) * (var6 + 1) * 2);
                     }
                  }

                  if(var8 < this.j[var11]) {
                     var8 = this.j[var11];
                  }

                  var9 = var9.a();
                  if(!var13) {
                     continue;
                  }
               }

               if(this.M != null) {
                  var9 = var5.k();

                  while(var9 != null) {
                     int var14 = ((y.c.q)var9.c()).d();
                     this.j[var14] = this.j[var14] / var8 * (float)this.m[var14] + (float)this.n[var14];
                     var9 = var9.a();
                     if(var13) {
                        break label70;
                     }

                     if(var13) {
                        break;
                     }
                  }
               }

               var10000 = this.O.k();
               break;
            }

            if(var10000 != 0) {
               this.O.a(var5, var2, this.j, var3, true);
               if(!var13) {
                  break label71;
               }
            }
         }

         this.a(var5, var3, this.g);
      }

      if(this.f && !this.O.k()) {
         this.a((y.c.D)var5, (Comparator)this.A, (Comparator)null);
         this.a(var2, var5, true, false, var3);
         this.a((y.c.D)var4, (Comparator)null, (Comparator)this.y);
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

      label71: {
         label70: {
            byte var10000;
            while(true) {
               if(var9 != null) {
                  y.c.q var10 = (y.c.q)var9.c();
                  int var11 = var10.d();
                  var10000 = this.i;
                  if(var13) {
                     break;
                  }

                  switch(var10000) {
                  case 0:
                     this.j[var11] = this.b(var10, var7, true, var6, var3);
                     if(!var13) {
                        break;
                     }
                  case 1:
                     this.j[var11] = this.a(var10, var7, true, var6, var3);
                  }

                  this.j[var11] += (float)var3[var11] / (float)(var6 * 200);
                  if(this.a != null) {
                     label80: {
                        int var12 = this.a[var11];
                        if(var12 < 0) {
                           this.j[var11] = 2.0F * this.j[var11] * (float)(this.b[var2] + 1);
                           if(!var13) {
                              break label80;
                           }
                        }

                        this.j[var11] += (float)((var12 + 1) * (var6 + 1) * 2);
                     }
                  }

                  if(var8 < this.j[var11]) {
                     var8 = this.j[var11];
                  }

                  var9 = var9.a();
                  if(!var13) {
                     continue;
                  }
               }

               if(this.M != null) {
                  var9 = var5.k();

                  while(var9 != null) {
                     int var14 = ((y.c.q)var9.c()).d();
                     this.j[var14] = this.j[var14] / var8 * (float)this.m[var14] + (float)this.n[var14];
                     var9 = var9.a();
                     if(var13) {
                        break label70;
                     }

                     if(var13) {
                        break;
                     }
                  }
               }

               var10000 = this.O.k();
               break;
            }

            if(var10000 != 0) {
               this.O.a(var5, var2, this.j, var3, false);
               if(!var13) {
                  break label71;
               }
            }
         }

         this.a(var5, var3, this.g);
      }

      if(this.f && !this.O.k()) {
         this.a((y.c.D)var5, (Comparator)null, (Comparator)this.y);
         this.a(var2, var5, false, true, var3);
         this.a((y.c.D)var4, (Comparator)this.x, (Comparator)null);
      }

   }

   private float a(boolean var1, y.c.d var2, int var3, int var4, int[] var5) {
      boolean var11 = N.x;
      float var6;
      int var7;
      y.c.d var8;
      y.c.q var9;
      int var10;
      int var12;
      if(var1) {
         var7 = var2.c().d();
         if(this.F[var7] < 0) {
            var8 = var2.g() == null?var2.i():var2.g();
            var9 = var8.d();
            var6 = (float)((var4 - 1) * var5[var9.d()]) / (float)(var3 - 1);
            if(this.u == null) {
               return var6;
            }

            switch(this.u[var10 = var8.b()]) {
            case 1:
               var6 -= 0.3F;
               if(!var11) {
                  break;
               }
            case -1:
               var6 += 0.3F;
            }

            var6 -= (float)this.w[var10] * 0.01F;
            if(!var11) {
               return var6;
            }
         }

         var6 = (float)var5[var7];
         if(this.t == null) {
            return var6;
         }

         switch(this.t[var12 = var2.b()]) {
         case 1:
            var6 += 0.3F;
            if(!var11) {
               break;
            }
         case -1:
            var6 -= 0.3F;
         }

         var6 += (float)this.v[var12] * 0.01F;
         if(!var11) {
            return var6;
         }
      }

      var7 = var2.d().d();
      if(this.F[var7] < 0) {
         var8 = var2.h() == null?var2.j():var2.h();
         var9 = var8.c();
         var6 = (float)((var4 - 1) * var5[var9.d()]) / (float)(var3 - 1);
         if(this.t == null) {
            return var6;
         }

         switch(this.t[var10 = var8.b()]) {
         case 1:
            var6 -= 0.3F;
            if(!var11) {
               break;
            }
         case -1:
            var6 += 0.3F;
         }

         var6 -= (float)this.v[var10] * 0.01F;
         if(!var11) {
            return var6;
         }
      }

      var6 = (float)var5[var7];
      if(this.u != null) {
         switch(this.u[var12 = var2.b()]) {
         case 1:
            var6 += 0.3F;
            if(!var11) {
               break;
            }
         case -1:
            var6 -= 0.3F;
         }

         var6 += (float)this.w[var12] * 0.01F;
      }

      return var6;
   }

   private float a(y.c.q var1, int var2, boolean var3, int var4, int[] var5) {
      int var6;
      int var11;
      label64: {
         label65: {
            boolean var10 = N.x;
            var6 = 0;
            y.c.d var7;
            if(var3) {
               var7 = var1.f();

               do {
                  if(var7 == null) {
                     break label65;
                  }

                  this.k[var6] = this.a(false, var7, var2, var4, var5);
                  var7 = var7.g();
                  ++var6;
                  if(var10) {
                     break label64;
                  }
               } while(!var10);
            }

            var7 = var1.g();

            while(var7 != null) {
               this.k[var6] = this.a(true, var7, var2, var4, var5);
               var7 = var7.h();
               ++var6;
               if(var10) {
                  break label64;
               }

               if(var10) {
                  break;
               }
            }
         }

         if(var6 == 0) {
            var11 = var5[var1.d()];
            if(var11 == 0) {
               return -1.0F;
            }

            if(var11 >= var2 - 1) {
               return (float)var4;
            }

            return (float)((var4 - 1) * var5[var1.d()]) / (float)(var2 - 1);
         }

         Arrays.sort(this.k, 0, var6);
      }

      var11 = var6 >> 1;
      if(var6 % 2 == 1) {
         return this.k[var11];
      } else if(var6 == 2) {
         return (this.k[0] + this.k[1]) * 0.5F;
      } else {
         float var8 = this.k[var11 - 1] - this.k[0];
         float var9 = this.k[var6 - 1] - this.k[var11];
         return var8 == 0.0F && var9 == 0.0F?(this.k[var11 - 1] + this.k[var11]) * 0.5F:(this.k[var11 - 1] * var9 + this.k[var11] * var8) / (var8 + var9);
      }
   }

   private float b(y.c.q var1, int var2, boolean var3, int var4, int[] var5) {
      boolean var9 = N.x;
      float var6 = 0.0F;
      int var7 = var3?var1.c():var1.b();
      if(var7 == 0) {
         int var10 = var5[var1.d()];
         return var10 == 0?-1.0F:(var10 >= var2 - 1?(float)var4:(float)((var4 - 1) * var5[var1.d()]) / (float)(var2 - 1));
      } else {
         label56: {
            y.c.d var8;
            if(var3) {
               var8 = var1.f();

               do {
                  if(var8 == null) {
                     break label56;
                  }

                  var6 += this.a(false, var8, var2, var4, var5);
                  var8 = var8.g();
                  if(var9) {
                     return var6;
                  }
               } while(!var9);
            }

            var8 = var1.g();

            while(var8 != null) {
               var6 += this.a(true, var8, var2, var4, var5);
               var8 = var8.h();
               if(var9) {
                  return var6;
               }

               if(var9) {
                  break;
               }
            }
         }

         var6 /= (float)var7;
         return var6;
      }
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
      this.a(var1, this.G);
      int var2 = 0;

      while(var2 < this.E.length) {
         this.b(this.E[var2], this.G);
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
         this.l[var2[var4.d()]] = var4;
         var3 = var3.a();
         if(var5) {
            break;
         }
      }

      int var6 = 0;
      y.c.p var7 = var1.k();

      while(var7 != null) {
         var7.a(this.l[var6]);
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
            this.l[var4] = (y.c.q)var5.c();
            var5 = var5.a();
            ++var4;
            if(var7) {
               break;
            }

            if(!var7) {
               continue;
            }
         }

         y.g.e.a(this.l, 0, var1.size(), var3);
         var4 = 0;
         break;
      }

      var5 = var1.k();

      while(var5 != null) {
         y.c.q var6 = this.l[var4];
         var5.a(var6);
         var2[var6.d()] = var4;
         var5 = var5.a();
         ++var4;
         if(var7) {
            break;
         }
      }

   }

   static float[] a(bT var0) {
      return var0.j;
   }

   static boolean a(bT var0, y.c.q var1) {
      return var0.a(var1);
   }
}
