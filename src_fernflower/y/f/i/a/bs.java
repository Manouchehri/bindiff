package y.f.i.a;

import java.util.Iterator;
import java.util.List;
import y.f.i.a.L;
import y.f.i.a.M;
import y.f.i.a.Z;
import y.f.i.a.ab;
import y.f.i.a.ah;
import y.f.i.a.ai;
import y.f.i.a.bt;
import y.f.i.a.bu;
import y.f.i.a.bv;
import y.f.i.a.bw;
import y.f.i.a.bx;
import y.f.i.a.by;
import y.f.i.a.d;
import y.f.i.a.e;
import y.f.i.a.h;
import y.f.i.a.y;

class bs {
   private boolean a = true;
   private final h b;
   private final boolean c;
   private final L d;
   private y.c.i e;
   private y.c.A f;
   private y.c.q[] g;
   private Z h;
   private double[] i;
   private final bw j;

   bs(h var1, Z var2) {
      this.b = var1;
      this.h = var2;
      this.c = var1.c();
      this.d = var2.c().k();
      this.j = new bw(this);
   }

   public bx a() {
      int var11 = ab.a;
      List var1 = this.b.d();
      bx var2 = this.a(false);
      boolean var3 = true;

      label86:
      while(true) {
         boolean var10000 = var2.a();

         label84:
         while(true) {
            Iterator var4;
            bu var5;
            label63:
            while(true) {
               if(!var10000 || !var3) {
                  return var2;
               }

               var3 = false;
               var4 = var2.d.iterator();
               var5 = (bu)var4.next();

               while(true) {
                  if(var5 == null) {
                     break label63;
                  }

                  var10000 = var5.a();
                  if(var11 != 0) {
                     break;
                  }

                  if(var10000) {
                     break label63;
                  }

                  var5 = var4.hasNext()?(bu)var4.next():null;
                  if(var11 != 0) {
                     break label63;
                  }
               }
            }

            while(true) {
               if(var5 == null) {
                  continue label86;
               }

               int var6;
               int var7;
               label71: {
                  var6 = 0;
                  var7 = 0;
                  if(var5.d < 0) {
                     var6 = var5.a;
                     var7 = var5.b;
                     if(var11 == 0) {
                        break label71;
                     }
                  }

                  if(var5.c < var5.d) {
                     var6 = var5.c;
                     var7 = var5.d;
                  }
               }

               ai var8 = (ai)var1.remove(var6);
               var1.add(var7, var8);
               bx var9 = this.a(false);
               if(var9.a(var2)) {
                  var2 = var9;
                  var3 = true;
                  if(var11 == 0) {
                     continue label86;
                  }
               }

               ai var10 = (ai)var1.remove(var7);
               var1.add(var6, var10);
               var5 = var4.hasNext()?(bu)var4.next():null;

               while(var5 != null) {
                  var10000 = var5.a();
                  if(var11 != 0 || var11 != 0) {
                     continue label84;
                  }

                  if(var10000) {
                     break;
                  }

                  var5 = var4.hasNext()?(bu)var4.next():null;
                  if(var11 != 0) {
                     return var2;
                  }
               }
            }
         }
      }
   }

   private bx a(boolean var1) {
      this.c();
      this.d();
      bx var2 = this.a((L)null, false, false);
      if(var2.d.size() != 0) {
         return var2;
      } else {
         bx var3 = this.a((L)null, false, true);
         if(var3.b()) {
            return var1?var2:var3;
         } else {
            bx var4 = this.a((L)null, true, true);
            if(this.d != null && !var4.b()) {
               bx var5 = this.a(this.d, true, true);
               return var1 && var5.b()?var4:var5;
            } else {
               return var1 && var4.b()?var3:var4;
            }
         }
      }
   }

   private bx a(L var1, boolean var2, boolean var3) {
      int var13 = ab.a;
      bv[] var4 = new bv[this.b.b()];
      int var5 = 0;
      boolean var6 = false;
      y.c.D var7 = new y.c.D();
      double[] var8 = new double[this.b.b()];
      boolean[] var9 = new boolean[this.b.b()];
      int var10 = 0;

      boolean var10000;
      while(true) {
         if(var10 < this.b.b()) {
            bv var11 = this.a(var10, var8, var1, var2, var3, this.j);
            var8[var10] = var11.i();
            var9[var10] = var11.h();
            var4[var10] = var11;
            var5 += var11.g();
            var10000 = var11.a();
            if(var13 != 0) {
               break;
            }

            if(var10000) {
               var6 = true;
            }

            if(this.a(var11, var1, var2, var3)) {
               bu var12 = this.a(var10, var8, var9, var1, var2, var3, var11.g());
               var7.add(var12);
            }

            ++var10;
            if(var13 == 0) {
               continue;
            }
         }

         var10000 = var3;
         break;
      }

      var10 = !var10000?0:(!var2?1:(var1 != null?2:3));
      bx var14 = new bx(var4, var10, var5, var6, var7);
      return var14;
   }

   private boolean a(bv var1, L var2, boolean var3, boolean var4) {
      return var1.a()?true:!var1.f() && (!var1.e() || var2 != null && !var1.b()) && (!var1.d() || var3) && (!var1.c() || var4);
   }

   private bu a(int var1, double[] var2, boolean[] var3, L var4, boolean var5, boolean var6, int var7) {
      int var17 = ab.a;
      ai var8 = this.b.a(var1);
      M var9 = var8.c();
      int var10 = var1;
      int var11 = 0;

      int var10000;
      while(true) {
         if(var11 < var1) {
            label106: {
               double var21;
               var10000 = (var21 = var2[var11] - var9.b()) == 0.0D?0:(var21 < 0.0D?-1:1);
               if(var17 != 0) {
                  break;
               }

               if(var10000 >= 0) {
                  var10 = var11;
                  if(var17 == 0) {
                     break label106;
                  }
               }

               ++var11;
               if(var17 == 0) {
                  continue;
               }
            }
         }

         var10000 = 0;
         break;
      }

      int var12 = var10000;
      var11 = var10;

      int var15;
      label89:
      while(true) {
         if(var11 >= 1) {
            label107: {
               by var13 = new by(this, var1, var11);
               bv var14 = this.a(var11, var2, var4, var5, var6, var13);
               var10000 = var14.g();
               if(var17 != 0) {
                  break;
               }

               if(var10000 > var7) {
                  var12 = var11;
                  if(var14.h()) {
                     break label107;
                  }

                  var15 = var11 - 1;

                  do {
                     if(var15 < 0) {
                        break label107;
                     }

                     var12 = var15;
                     var10000 = var3[var15];
                     if(var17 != 0) {
                        break label89;
                     }

                     if(var10000 != 0) {
                        break label107;
                     }

                     --var15;
                  } while(var17 == 0);
               }

               --var11;
               if(var17 == 0) {
                  continue;
               }
            }
         }

         var10000 = var12;
         break;
      }

      int var18 = var10000;

      int var10001;
      while(true) {
         if(var18 <= var11) {
            by var19 = new by(this, var1, var18);
            var10000 = this.a(var2, var18, var1, var4, var5, var6, var19);
            var10001 = this.a(var2, var18, var1, var4, var5, var6, this.j);
            if(var17 != 0) {
               break;
            }

            if(var10000 <= var10001) {
               ++var18;
               if(var17 == 0) {
                  continue;
               }
            }
         }

         var10000 = var18;
         var10001 = var11;
         break;
      }

      if(var10000 > var10001) {
         var18 = -1;
      }

      int var20 = this.a(var2, var12, var1, var4, var5, var6, this.j);
      var15 = var12 + 1;

      while(true) {
         if(var15 <= var1) {
            by var16 = new by(this, var12, var15);
            var10000 = this.a(var2, var12, var1, var4, var5, var6, var16);
            var10001 = var20;
            if(var17 != 0) {
               break;
            }

            if(var10000 <= var20) {
               ++var15;
               if(var17 == 0) {
                  continue;
               }
            }
         }

         var10000 = var15;
         var10001 = var1;
         break;
      }

      if(var10000 > var10001) {
         var15 = -1;
      }

      return new bu(var1, var18, var12, var15);
   }

   private int a(double[] var1, int var2, int var3, L var4, boolean var5, boolean var6, bw var7) {
      int var12 = ab.a;
      double[] var8 = new double[var1.length];
      int var9 = 0;

      while(true) {
         if(var9 < var2) {
            var8[var9] = var1[var9];
            ++var9;
            if(var12 != 0) {
               break;
            }

            if(var12 == 0) {
               continue;
            }
         }

         var9 = 0;
         break;
      }

      int var10 = var2;

      int var10000;
      while(true) {
         if(var10 <= var3) {
            bv var11 = this.a(var10, var8, var4, var5, var6, var7);
            var8[var10] = var11.i();
            var10000 = var9 + var11.g();
            if(var12 != 0) {
               break;
            }

            var9 = var10000;
            ++var10;
            if(var12 == 0) {
               continue;
            }
         }

         var10000 = var9;
         break;
      }

      return var10000;
   }

   private bv a(int var1, double[] var2, L var3, boolean var4, boolean var5, bw var6) {
      int var35 = ab.a;
      int var7 = var6.a(var1);
      ai var8 = this.b.a(var7);
      boolean var9 = a(var8);
      int var10 = var9?1:0;
      double var11 = var4?this.i[var7]:(var5?1.0E-6D:0.0D);
      double var13 = var8.c().a();
      double var15 = var8.c().b();
      double var17 = var1 > 0?var2[var1 - 1]:-1.7976931348623157E308D;
      if(var17 > var15) {
         return var9 && var17 < var15 + 1.0E-6D?new bv(var15, (byte)(var10 | 2), false):new bv(var17, (byte)(var10 | 32), false);
      } else {
         byte var36 = (byte)(var10 | 2);
         if(!var5) {
            return var13 > var17?new bv(var13, var36, true):new bv(var17, var36, false);
         } else {
            double var10000;
            double var19;
            double var23;
            double var31;
            label102: {
               var19 = Math.max(var17, var13);
               double var21 = -1.7976931348623157E308D;
               var23 = -1.7976931348623157E308D;
               List var25 = var6.c(var1);
               if(!var25.isEmpty()) {
                  Iterator var26 = var25.iterator();

                  while(var26.hasNext()) {
                     int var27 = ((Integer)var26.next()).intValue();
                     int var28 = var6.b(var27);
                     double var29 = var2[var28];
                     if(var29 > var21) {
                        var21 = var29;
                     }

                     var31 = var4?this.i[var27]:(var5?1.0E-6D:0.0D);
                     double var33 = var29 + Math.max(var31, var11);
                     if(var33 > var23) {
                        var10000 = var33;
                        if(var35 != 0) {
                           break label102;
                        }

                        var23 = var33;
                        if(var35 != 0) {
                           break;
                        }
                     }
                  }
               }

               var10000 = Math.max(var17, var21 + 1.0E-6D);
            }

            double var37 = var10000;
            if(var37 > var15) {
               return new bv(var19, var36, false);
            } else {
               var36 = (byte)(var36 | 4);
               if(!var4) {
                  return var13 > var37?new bv(var13, var36, true):new bv(var37, var36, false);
               } else {
                  var19 = Math.max(var37, var19);
                  double var38 = Math.max(var17, var23);
                  boolean var30 = var13 > var38;
                  if(var38 > var15) {
                     return new bv(var19, var36, false);
                  } else {
                     var36 = (byte)(var36 | 8);
                     if(var3 != null && !var9) {
                        var19 = Math.max(var38, var19);
                        var31 = var3.a(var19, new M(var19, Double.MAX_VALUE), this.c);
                        if(var31 > var15) {
                           return new bv(var19, var36, var30);
                        } else {
                           var36 = (byte)(var36 | 16);
                           return new bv(var31, var36, var30);
                        }
                     } else {
                        return var30?new bv(var13, var36, true):new bv(var38, var36, false);
                     }
                  }
               }
            }
         }
      }
   }

   private void c() {
      int var7 = ab.a;
      this.e = new y.c.i();
      this.f = this.e.t();
      this.e.a((Object)"index", (y.c.c)this.f);
      this.g = new y.c.q[this.b.b()];
      int var1 = 0;

      bs var10000;
      while(true) {
         if(var1 < this.b.b()) {
            y.c.q var2 = this.e.d();
            this.g[var1] = var2;
            var10000 = this;
            if(var7 != 0) {
               break;
            }

            this.f.a(var2, var1);
            ++var1;
            if(var7 == 0) {
               continue;
            }
         }

         var10000 = this;
         break;
      }

      M[] var8 = new M[var10000.b.b()];
      int var9 = 0;

      do {
         int var10 = var9;

         label34:
         while(true) {
            if(var10 >= this.b.b()) {
               return;
            }

            M var3 = this.b.a(var9).b();
            var8[var9] = var3;
            y.c.q var4 = this.g[var9];
            int var5 = 0;

            while(true) {
               if(var5 >= var9) {
                  break label34;
               }

               double var11;
               var10 = (var11 = var3.b(var8[var5]) - 1.0E-6D) == 0.0D?0:(var11 < 0.0D?-1:1);
               if(var7 != 0) {
                  break;
               }

               if(var10 < 0) {
                  y.c.q var6 = this.g[var5];
                  this.e.a(var6, var4);
               }

               ++var5;
               if(var7 != 0) {
                  break label34;
               }
            }
         }

         ++var9;
      } while(var7 == 0);

   }

   private static y.c.f a(ah var0) {
      int var4 = ab.a;
      y.c.f var1 = new y.c.f();
      Iterator var2 = var0.b().iterator();

      y.c.f var10000;
      while(true) {
         if(var2.hasNext()) {
            ai var3 = (ai)var2.next();
            var10000 = var1;
            if(var4 != 0) {
               break;
            }

            var1.add(var3.i());
            if(var4 == 0) {
               continue;
            }
         }

         var10000 = var1;
         break;
      }

      return var10000;
   }

   public void b() {
      int var18 = ab.a;
      bx var1 = this.a(true);
      double[] var2 = this.a(var1);
      double[] var3 = this.b(var1);
      double[] var4 = new double[this.b.b()];
      int var5 = 0;

      int var10000;
      while(true) {
         if(var5 < this.b.b()) {
            double var6 = var3[var5] - var2[var5];
            double var23;
            var10000 = (var23 = var6 - 0.0D) == 0.0D?0:(var23 < 0.0D?-1:1);
            if(var18 != 0) {
               break;
            }

            if(var10000 < 0) {
               label126: {
                  if(-var6 < 1.0E-6D) {
                     var3[var5] = var2[var5];
                     var6 = 0.0D;
                     if(var18 == 0) {
                        break label126;
                     }
                  }

                  M var8 = this.b.a(var5).c();
                  var2[var5] = var8.a();
                  var3[var5] = var8.b();
                  var6 = var3[var5] - var2[var5];
               }
            }

            var4[var5] = Math.max(0.0D, var6);
            ++var5;
            if(var18 == 0) {
               continue;
            }
         }

         var10000 = this.b.b();
         break;
      }

      e[] var19 = new e[var10000];
      d var20 = this.a(var4, var19);

      label100:
      while(true) {
         var10000 = var20.d();

         label98:
         while(var10000 == 0) {
            e var7 = var20.c();
            var20.a(var7);
            int var21 = ((Integer)var7.a()).intValue();
            var19[var21] = null;
            double var9 = this.a(var21, var2, var3, var4);
            ai var11 = this.b.a(var21);
            double var12 = this.a(var21, var9, var2, var3, var1);
            M var14 = var11.c();
            if(var14.a() > var12 + 1.0E-6D || var14.b() + 1.0E-6D < var12) {
               var12 = var14.c();
            }

            this.b.a(var11, var12);
            var2[var21] = var3[var21] = var12;
            var4[var21] = 0.0D;
            double[] var15 = new double[this.b.b()];
            int var16 = 0;

            label81: {
               label80:
               while(true) {
                  if(var16 < this.b.b()) {
                     var15[var16] = var3[var16];
                     ++var16;
                     if(var18 != 0) {
                        break;
                     }

                     if(var18 == 0) {
                        continue;
                     }
                  }

                  if(var21 > 0) {
                     this.a(var15, var21 - 1, var1);
                     var16 = 0;

                     while(var16 < var21) {
                        double var24;
                        var10000 = (var24 = var15[var16] - var3[var16]) == 0.0D?0:(var24 < 0.0D?-1:1);
                        if(var18 != 0) {
                           break label81;
                        }

                        if(var10000 < 0) {
                           var3[var16] = var15[var16];
                           var4[var16] = var3[var16] - var2[var16];
                           if(var19[var16] != null) {
                              var20.b(var19[var16], new Integer(var16));
                           }
                        }

                        ++var16;
                        if(var18 != 0) {
                           break label80;
                        }
                     }
                  }
                  break;
               }

               var10000 = this.b.b();
            }

            double[] var22 = new double[var10000];
            int var17 = 0;

            while(var17 < this.b.b()) {
               var22[var17] = var2[var17];
               ++var17;
               if(var18 != 0) {
                  continue label100;
               }

               if(var18 != 0) {
                  break;
               }
            }

            if(var21 >= this.b.b() - 1) {
               continue label100;
            }

            this.b(var22, var21 + 1, var1);
            var17 = var21 + 1;

            do {
               if(var17 >= this.b.b()) {
                  continue label100;
               }

               double var25;
               var10000 = (var25 = var22[var17] - var2[var17]) == 0.0D?0:(var25 < 0.0D?-1:1);
               if(var18 != 0) {
                  continue label98;
               }

               if(var10000 > 0) {
                  var2[var17] = var22[var17];
                  var4[var17] = var3[var17] - var2[var17];
                  if(var19[var17] != null) {
                     var20.b(var19[var17], new Integer(var17));
                  }
               }

               ++var17;
            } while(var18 == 0);

            return;
         }

         return;
      }
   }

   private void d() {
      int var2 = ab.a;
      this.i = new double[this.b.b()];
      int var1 = 0;

      while(var1 < this.b.b()) {
         this.i[var1] = this.b.a(var1).m();
         ++var1;
         if(var2 != 0) {
            break;
         }
      }

   }

   private static boolean a(ai var0) {
      return var0.f() || var0.n();
   }

   private double[] a(bx var1) {
      int var4 = ab.a;
      double[] var2 = new double[this.b.b()];
      int var3 = 0;

      double[] var10000;
      while(true) {
         if(var3 < this.b.b()) {
            var10000 = var2;
            if(var4 != 0) {
               break;
            }

            var2[var3] = var1.e[var3].i();
            ++var3;
            if(var4 == 0) {
               continue;
            }
         }

         var10000 = var2;
         break;
      }

      return var10000;
   }

   private double[] b(bx var1) {
      double[] var2 = new double[this.b.b()];
      this.a(var2, var2.length - 1, var1);
      return var2;
   }

   private void a(double[] var1, int var2, bx var3) {
      int var8 = ab.a;
      int var4 = var2;

      while(var4 >= 0) {
         label33: {
            bv var5 = var3.e[var4];
            if(var5.b()) {
               var1[var4] = this.b.a(var4).c().b();
               if(var8 == 0) {
                  break label33;
               }
            }

            double var6 = Double.MAX_VALUE;
            if(var4 < this.b.b() - 1) {
               var6 = var1[var4 + 1];
               var6 = this.b(var4, var6, var1, var3);
            }

            var6 = Math.min(var6, this.b.a(var4).c().b());
            if(var5.f()) {
               var6 = this.d.a(var6, new M(-1.7976931348623157E308D, var6), this.c);
            }

            var1[var4] = var6;
         }

         --var4;
         if(var8 != 0) {
            break;
         }
      }

   }

   private void b(double[] var1, int var2, bx var3) {
      int var8 = ab.a;
      int var4 = var2;

      while(var4 < this.b.b()) {
         label33: {
            bv var5 = var3.e[var4];
            if(var5.b()) {
               var1[var4] = this.b.a(var4).c().a();
               if(var8 == 0) {
                  break label33;
               }
            }

            double var6 = -1.7976931348623157E308D;
            if(var4 > 0) {
               var6 = var1[var4 - 1];
               var6 = this.a(var4, var6, var1, var3);
            }

            var6 = Math.max(var6, this.b.a(var4).c().a());
            if(var5.f()) {
               var6 = this.d.a(var6, new M(var6, Double.MAX_VALUE), this.c);
            }

            var1[var4] = var6;
         }

         ++var4;
         if(var8 != 0) {
            break;
         }
      }

   }

   private double a(int var1, double var2, double[] var4, bx var5) {
      int var14 = ab.a;
      boolean var6 = var5.e[var1].e();
      if(!var6) {
         return var2;
      } else {
         double var7 = this.i[var1];
         List var9 = this.j.c(var1);
         Iterator var10 = var9.iterator();

         double var10000;
         while(true) {
            if(var10.hasNext()) {
               int var11 = ((Integer)var10.next()).intValue();
               double var12 = var4[var11] + Math.max(var7, this.i[var11]);
               var10000 = Math.max(var2, var12);
               if(var14 != 0) {
                  break;
               }

               var2 = var10000;
               if(var14 == 0) {
                  continue;
               }
            }

            var10000 = var2;
            break;
         }

         return var10000;
      }
   }

   private double b(int var1, double var2, double[] var4, bx var5) {
      int var13 = ab.a;
      double var6 = this.i[var1];
      List var8 = this.j.d(var1);
      Iterator var9 = var8.iterator();

      double var10000;
      while(true) {
         if(var9.hasNext()) {
            int var10 = ((Integer)var9.next()).intValue();
            if(!var5.e[var10].e()) {
               continue;
            }

            double var11 = var4[var10] - Math.max(var6, this.i[var10]);
            var10000 = Math.min(var2, var11);
            if(var13 != 0) {
               break;
            }

            var2 = var10000;
            if(var13 == 0) {
               continue;
            }
         }

         var10000 = var2;
         break;
      }

      return var10000;
   }

   private d a(double[] var1, e[] var2) {
      int var5 = ab.a;
      d var3 = new d(this.b.b(), new bt(this, var1));
      int var4 = 0;

      while(var4 < this.b.b()) {
         var2[var4] = var3.a((Object)(new Integer(var4)), this.b.a(var4));
         ++var4;
         if(var5 != 0) {
            break;
         }
      }

      return var3;
   }

   private double a(int var1, double[] var2, double[] var3, double[] var4) {
      int var26 = ab.a;
      double var5 = var2[var1];
      int var7 = var1;
      int var8 = var1 - 1;

      int var10000;
      while(true) {
         if(var8 >= 0) {
            var5 = var2[var8];
            var7 = var8;
            double var29;
            var10000 = (var29 = var4[var8] - 1.0E-6D) == 0.0D?0:(var29 < 0.0D?-1:1);
            if(var26 != 0) {
               break;
            }

            if(var10000 > 0) {
               --var8;
               if(var26 == 0) {
                  continue;
               }
            }
         }

         var10000 = var8;
         break;
      }

      boolean var9 = var10000 == -1;
      double var10 = var3[var1];
      int var12 = var1;
      int var13 = var1 + 1;

      while(true) {
         if(var13 < this.b.b()) {
            var10 = var3[var13];
            var12 = var13;
            double var30;
            var10000 = (var30 = var4[var13] - 1.0E-6D) == 0.0D?0:(var30 < 0.0D?-1:1);
            if(var26 != 0) {
               break;
            }

            if(var10000 > 0) {
               ++var13;
               if(var26 == 0) {
                  continue;
               }
            }
         }

         var10000 = var13;
         break;
      }

      boolean var14 = var10000 == this.b.b();
      int[] var15 = new int[this.b.b()];
      int var16 = var7;

      label85:
      do {
         var10000 = var16;
         int var10001 = var12;

         label82:
         while(true) {
            if(var10000 > var10001) {
               break label85;
            }

            y.c.e var17 = this.g[var16].k();

            while(true) {
               if(!var17.f()) {
                  break label82;
               }

               int var18 = this.f.a(((y.c.d)var17.d()).c());
               var10000 = var18;
               var10001 = var7;
               if(var26 != 0) {
                  break;
               }

               if(var18 >= var7) {
                  var15[var16] = Math.max(var15[var16], var15[var18] + 1);
               }

               var17.g();
               if(var26 != 0) {
                  break label82;
               }
            }
         }

         if(var16 > 0) {
            var15[var16] = Math.max(var15[var16], var15[var16 - 1]);
         }

         ++var16;
      } while(var26 == 0);

      var16 = var15[var12];
      int var27 = var15[var1];
      double var28 = (double)var16;
      double var20 = (double)var27;
      if(this.a) {
         var28 += var9?0.5D:0.0D;
         var28 += var14?0.5D:0.0D;
         var20 += var9?0.5D:0.0D;
      }

      double var22;
      if(var28 == 0.0D) {
         var22 = var5 + (var10 - var5) / 2.0D;
         if(var26 == 0) {
            return var22;
         }
      }

      double var24 = (var10 - var5) / var28;
      var22 = var5 + var24 * var20;
      return var22;
   }

   private double a(int var1, double var2, double[] var4, double[] var5, bx var6) {
      bv var7 = var6.e[var1];
      M var8 = new M(var4[var1], var5[var1]);
      if(var7.f()) {
         return this.d.a(var2, var8, this.c);
      } else {
         double var9 = var8.c(var2);
         double var11 = this.a(var1, var9, var4, var6);
         double var13 = this.b(var1, var9, var5, var6);
         if(var13 >= var11) {
            var8 = new M(var11, var13);
            var9 = var8.c(var9);
         }

         if(this.d != null && !var7.b()) {
            int var15 = this.d.a(var8, this.c, 2);
            if(var15 >= 0) {
               return this.d.a(var9, var8, this.c, var15);
            }
         }

         return var9;
      }
   }

   public static void a(h var0, Z var1) {
      int var19 = ab.a;
      boolean var2 = var0.c();
      L var3 = var1.c().k();
      int var4 = var0.b();
      int var5 = var4 - 1;

      label151:
      while(true) {
         int var10000 = var5;

         ai var6;
         double var7;
         double var9;
         int var11;
         ai var12;
         double var13;
         double var15;
         double var17;
         double var20;
         label148:
         while(true) {
            if(var10000 >= 0) {
               var6 = var0.a(var5);
               byte var21 = var6.d();
               if(var19 != 0) {
                  if(var21 >= 1) {
                     return;
                  }
                  break;
               }

               if(var21 != 1) {
                  --var5;
                  if(var19 == 0) {
                     continue label151;
                  }
               } else {
                  var7 = var6.c().b();
                  var9 = a(var6, var1);
                  var11 = var5 + 1;

                  while(var11 < var4) {
                     var12 = var0.a(var11);
                     var13 = a(var12, var1);
                     var15 = Math.max(var9, var13);
                     double var22;
                     var10000 = (var22 = var6.b().b(var12.b()) - 0.0D) == 0.0D?0:(var22 < 0.0D?-1:1);
                     if(var19 != 0) {
                        continue label148;
                     }

                     if(var10000 == 0) {
                        var7 = Math.min(var7, var0.b(var12) - var15);
                     }

                     ++var11;
                     if(var19 != 0) {
                        break;
                     }
                  }

                  var20 = var0.b(var6);
                  var13 = Math.min(var20, var7);
                  var15 = Math.max(var20, var7);
                  var17 = var3 != null?(!a(var6)?(var3.a(new M(var13, var15), var2)?var3.a(var7, new M(var20, var7), var2):var20):var7):var7;
                  if(var17 > var20) {
                     var0.a(var6, var17);
                  }

                  --var5;
                  if(var19 == 0) {
                     continue label151;
                  }
               }

               var5 = 0;
               var10000 = var5;
            } else {
               var5 = 0;
               var10000 = var5;
            }

            if(var10000 >= var4) {
               return;
            }
            break;
         }

         while(true) {
            while(true) {
               label127:
               while(true) {
                  var6 = var0.a(var5);
                  if(var6.d() == -1) {
                     var7 = var6.c().a();
                     var9 = a(var6, var1);
                     var11 = var5 - 1;

                     while(var11 >= 0) {
                        var12 = var0.a(var11);
                        var13 = a(var12, var1);
                        var15 = Math.max(var9, var13);
                        double var23;
                        var10000 = (var23 = var6.b().b(var12.b()) - var15) == 0.0D?0:(var23 < 0.0D?-1:1);
                        if(var19 != 0) {
                           if(var10000 >= var4) {
                              return;
                           }
                           continue label127;
                        }

                        if(var10000 < 0) {
                           var7 = Math.max(var7, var0.b(var12) + var15);
                        }

                        --var11;
                        if(var19 != 0) {
                           break;
                        }
                     }

                     var20 = var0.b(var6);
                     var13 = Math.min(var20, var7);
                     var15 = Math.max(var20, var7);
                     var17 = var3 != null?(!a(var6)?(var3.a(new M(var13, var15), var2)?var3.a(var7, new M(var20, var7), var2):var20):var7):var7;
                     if(var17 < var20) {
                        var0.a(var6, var17);
                     }

                     ++var5;
                     if(var19 != 0 || var5 >= var4) {
                        return;
                     }
                  } else {
                     ++var5;
                     if(var19 != 0 || var5 >= var4) {
                        return;
                     }
                  }
               }
            }
         }
      }
   }

   private static double a(ai var0, Z var1) {
      y var2 = var1.c();
      return var0.i() != null?var2.a(var0.i()).c():a(a(var0.k()), var1);
   }

   private static double a(y.c.f var0, Z var1) {
      int var7 = ab.a;
      double var2 = 0.0D;
      y var4 = var1.c();
      y.c.e var5 = var0.a();

      double var10000;
      while(true) {
         if(var5.f()) {
            y.c.d var6 = var5.a();
            var10000 = Math.max(var2, var4.a(var6).c());
            if(var7 != 0) {
               break;
            }

            var2 = var10000;
            var5.g();
            if(var7 == 0) {
               continue;
            }
         }

         var10000 = var2;
         break;
      }

      return var10000;
   }

   static y.c.q[] a(bs var0) {
      return var0.g;
   }

   static y.c.A b(bs var0) {
      return var0.f;
   }

   static h c(bs var0) {
      return var0.b;
   }
}
