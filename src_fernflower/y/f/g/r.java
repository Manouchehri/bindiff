package y.f.g;

import y.f.g.d;
import y.f.g.n;
import y.f.g.q;
import y.f.g.u;
import y.f.g.v;
import y.f.g.x;
import y.f.g.y;

final class r {
   int a;
   int b;
   int c;
   int d;
   int e;
   int f;
   private x g;
   private int h;
   private int i;
   private int j;
   private final n k;

   r(n var1, int var2, int var3, int var4, int var5) {
      this.k = var1;
      this.a = var4;
      this.b = var5;
      this.c = var2;
      this.e = 0;
      this.d = var3;
      this.f = 0;
      this.g = new x(var4 * var5);
   }

   int a() {
      return this.e;
   }

   int b() {
      return this.f;
   }

   void a(int var1, int var2, int var3, int var4) {
      boolean var6 = d.d;
      int var5 = var2;

      while(var5 < var4) {
         this.a(var1, var3, var5, true);
         ++var5;
         if(var6) {
            break;
         }
      }

   }

   void c() {
      boolean var9 = d.d;
      int[] var1 = new int[this.b];
      int[] var2 = new int[this.b];
      int[] var3 = new int[this.a];
      int[] var4 = new int[this.a];
      int var5 = 0;

      while(true) {
         if(var5 < var1.length) {
            var1[var5] = this.a;
            var2[var5] = -1;
            ++var5;
            if(var9) {
               break;
            }

            if(!var9) {
               continue;
            }
         }

         var5 = 0;
         break;
      }

      while(true) {
         if(var5 < var3.length) {
            var3[var5] = this.b;
            var4[var5] = -1;
            ++var5;
            if(var9) {
               break;
            }

            if(!var9) {
               continue;
            }
         }

         var5 = this.g.nextSetBit(0);
         break;
      }

      int var6;
      int var7;
      while(true) {
         if(var5 >= 0) {
            var6 = var5 % this.a;
            var7 = var5 / this.a;
            var1[var7] = Math.min(var1[var7], var6);
            var3[var6] = Math.min(var3[var6], var7);
            var2[var7] = Math.max(var2[var7], var6);
            var4[var6] = Math.max(var4[var6], var7);
            var5 = this.g.nextSetBit(var5 + 1);
            if(var9) {
               break;
            }

            if(!var9) {
               continue;
            }
         }

         var5 = 0;
         break;
      }

      var6 = 0;

      while(var6 < this.b) {
         var7 = var1[var6];

         int var10000;
         int var10001;
         label63:
         while(true) {
            var10000 = var7;
            var10001 = var2[var6];

            label60:
            while(var10000 < var10001) {
               var10000 = var3[var7];
               var10001 = var6;
               if(var9) {
                  break label63;
               }

               if(var10000 <= var6 && var4[var7] >= var6) {
                  int var8 = var7 + 1;

                  while(var3[var8] <= var6) {
                     var10000 = var4[var8];
                     var10001 = var6;
                     if(var9) {
                        continue label60;
                     }

                     if(var10000 < var6) {
                        break;
                     }

                     ++var8;
                     if(var9) {
                        break;
                     }
                  }

                  this.g.set(var5 + var7, var5 + var8);
               }

               ++var7;
               if(!var9) {
                  continue label63;
               }
               break;
            }

            var10000 = var5;
            var10001 = this.a;
            break;
         }

         var5 = var10000 + var10001;
         ++var6;
         if(var9) {
            break;
         }
      }

   }

   q a(r var1, int var2, int var3, int var4, int var5, boolean var6, y var7, y.c.D var8, y.c.D var9, boolean var10) {
      boolean var22 = d.d;
      this.h = Integer.MAX_VALUE;
      this.i = 0;
      this.j = 0;
      int var11 = this.c + this.a / 2;
      int var12 = this.d + this.b / 2;
      this.b(var2 - var11, var3 - var12);
      var11 = this.c + this.a / 2;
      var12 = this.d + this.b / 2;
      q var13 = null;
      int var14 = 0;

      boolean var10000;
      while(true) {
         if(var14 < var5) {
            var10000 = n.c(this.k);
            if(var22) {
               break;
            }

            if(var10000) {
               var13 = this.a(var1, var14, var7, var8, var6, var10);
               if(var13 != null) {
                  int var23;
                  label54: {
                     double var15 = Math.sqrt((double)((var11 - var13.a) * (var11 - var13.a) + (var12 - var13.b) * (var12 - var13.b)));
                     if(var9 != null && !var9.isEmpty()) {
                        int var17 = var11 - var13.a;
                        int var18 = var12 - var13.b;
                        this.c += var17;
                        this.d += var18;
                        this.e += var17;
                        this.f += var18;
                        v var19 = new v(this.k, (double)var11, (double)var12);
                        var9.sort(var19);
                        y.c.C var20 = var9.m();

                        while(var20.f()) {
                           q var21 = (q)var20.d();
                           var23 = var19.compare(var21, var13);
                           if(var22) {
                              break label54;
                           }

                           if(var23 < 0 && (y.d.t.a((double)var11, (double)var12, (double)var21.a, (double)var21.b) < Math.max((double)n.d(this.k) / n.a(this.k), var15) || y.d.t.a((double)var13.a, (double)var13.b, (double)var21.a, (double)var21.b) < 15.0D / n.a(this.k)) && this.a(var1, var21.a - var11, var21.b - var12, var7, var6)) {
                              return var21;
                           }

                           var20.g();
                           if(var22) {
                              break;
                           }
                        }

                        this.c -= var17;
                        this.d -= var18;
                        this.e -= var17;
                        this.f -= var18;
                     }

                     var23 = var14;
                  }

                  if(var23 != 0) {
                     return var13;
                  }

                  return null;
               }
            }

            var14 += var4;
            if(!var22) {
               continue;
            }
         }

         var10000 = var6;
         break;
      }

      if(var10000) {
         this.c += this.i;
         this.d += this.j;
         this.e += this.i;
         this.f += this.j;
         return var13;
      } else {
         return null;
      }
   }

   boolean a(r var1, int var2, int var3, int var4, int var5, y var6, boolean var7) {
      boolean var11 = d.d;
      this.h = Integer.MAX_VALUE;
      this.i = 0;
      this.j = 0;
      int var8 = this.c + this.a / 2;
      int var9 = this.d + this.b / 2;
      this.b(var2 - var8, var3 - var9);
      int var10 = 0;

      boolean var10000;
      while(true) {
         if(var10 < var5) {
            var10000 = n.c(this.k);
            if(var11) {
               break;
            }

            if(var10000 && this.a(var1, 0, 0, var10, var6, var7)) {
               if(var10 != 0) {
                  return true;
               }

               return false;
            }

            var10 += var4;
            if(!var11) {
               continue;
            }
         }

         var10000 = var7;
         break;
      }

      if(var10000) {
         this.c += this.i;
         this.d += this.j;
         this.e += this.i;
         this.f += this.j;
         return true;
      } else {
         return false;
      }
   }

   q a(r var1, int var2, y var3, y.c.D var4, boolean var5, boolean var6) {
      boolean var16 = d.d;
      int var7 = this.c + this.a / 2;
      int var8 = this.d + this.b / 2;
      if(var2 == 0) {
         y.c.C var17 = var4.m();

         while(var17.f()) {
            u var18 = (u)var17.d();
            if(!var6 || var18.b()) {
               y.d.t var20 = new y.d.t((double)var7, (double)var8);
               if(var18.a(var20) && this.a(var1, 0, 0, var3, var5)) {
                  return new q(var20, var18.l(), var18);
               }
            }

            var17.g();
            if(var16) {
               break;
            }
         }

         return null;
      } else {
         y.d.p var9 = new y.d.p(new y.d.t((double)var7, (double)var8), (double)var2);
         y.c.D var10 = new y.c.D();
         y.c.C var11 = var4.m();

         label88:
         do {
            boolean var10000 = var11.f();

            label85:
            while(true) {
               if(!var10000) {
                  break label88;
               }

               u var12 = (u)var11.d();
               if(var6 && !var12.b()) {
                  break;
               }

               y.d.t[] var13;
               label82: {
                  if(var12.c().a() == var12.d().a()) {
                     var13 = var9.b(var12.c().a());
                     if(!var16) {
                        break label82;
                     }
                  }

                  var13 = var9.a(var12.c().b());
               }

               if(var13 == null) {
                  break;
               }

               int var14 = 0;

               while(true) {
                  if(var14 >= var13.length) {
                     break label85;
                  }

                  var10000 = var12.a(var13[var14]);
                  if(var16) {
                     break;
                  }

                  if(var10000) {
                     int var15 = var12.l();
                     var10.add(new q(var13[var14], var15, var12));
                  }

                  ++var14;
                  if(var16) {
                     break label85;
                  }
               }
            }

            var11.g();
         } while(!var16);

         v var19 = new v(this.k);
         var10.sort(var19);
         y.c.C var21 = var10.m();

         while(var21.f()) {
            q var22 = (q)var21.d();
            if(this.a(var1, var22.a - var7, var22.b - var8, var3, var5)) {
               return var22;
            }

            var21.g();
            if(var16) {
               break;
            }
         }

         return null;
      }
   }

   boolean a(r var1, int var2, int var3, int var4, y var5, boolean var6) {
      boolean var11 = d.d;
      if(var4 == 0) {
         return this.a(var1, var2, var3, var5, var6);
      } else {
         int var7 = var4;
         int var8 = 0;
         int var9 = var4 * var4;
         int var10 = var9;

         boolean var10000;
         while(true) {
            if(var7 >= var8) {
               var10000 = this.a(var1, var2 + var7, var3 + var8, var5, var6);
               if(var11) {
                  break;
               }

               if(var10000) {
                  return true;
               }

               if(this.a(var1, var2 + var7, var3 - var8, var5, var6)) {
                  return true;
               }

               if(this.a(var1, var2 - var7, var3 + var8, var5, var6)) {
                  return true;
               }

               if(this.a(var1, var2 - var7, var3 - var8, var5, var6)) {
                  return true;
               }

               if(this.a(var1, var2 + var8, var3 + var7, var5, var6)) {
                  return true;
               }

               if(this.a(var1, var2 + var8, var3 - var7, var5, var6)) {
                  return true;
               }

               if(this.a(var1, var2 - var8, var3 + var7, var5, var6)) {
                  return true;
               }

               if(this.a(var1, var2 - var8, var3 - var7, var5, var6)) {
                  return true;
               }

               if(var10 < var9) {
                  var10 += 1 + 2 * var8;
                  ++var8;
                  if(!var11) {
                     continue;
                  }
               }

               var10 += 2 - 2 * var7 + 2 * var8;
               --var7;
               ++var8;
               if(!var11) {
                  continue;
               }
            }

            var10000 = false;
            break;
         }

         return var10000;
      }
   }

   private final boolean a(r var1, int var2, int var3, y var4, boolean var5) {
      y.d.t var6 = new y.d.t((double)(var2 + this.c) + (double)this.a * 0.5D, (double)(var3 + this.d) + (double)this.b * 0.5D);
      if(var4 != null && !var4.a(var6)) {
         return false;
      } else if(!var5) {
         return this.a(var1, var2, var3);
      } else {
         this.c += var2;
         this.d += var3;
         int var7 = this.b(var1);
         if(var7 < this.h) {
            this.h = var7;
            this.i = var2;
            this.j = var3;
         }

         if(var7 == 0) {
            this.e += var2;
            this.f += var3;
            return true;
         } else {
            this.c -= var2;
            this.d -= var3;
            return false;
         }
      }
   }

   private final boolean a(r var1, int var2, int var3) {
      this.c += var2;
      this.d += var3;
      if(!this.a(var1)) {
         this.e += var2;
         this.f += var3;
         return true;
      } else {
         this.c -= var2;
         this.d -= var3;
         return false;
      }
   }

   private int b(r var1) {
      boolean var9 = d.d;
      int var2 = Math.max(this.c, var1.c);
      int var3 = Math.min(this.c + this.a, var1.c + var1.a);
      int var4 = Math.max(this.d, var1.d);
      int var5 = Math.min(this.d + this.b, var1.d + var1.b);
      int var6 = 0;
      int var7 = var2;

      label40:
      while(true) {
         int var10000 = var7;

         label37:
         while(var10000 < var3) {
            var10000 = var4;
            if(var9) {
               return var10000;
            }

            int var8 = var4;

            while(var8 < var5) {
               var10000 = this.a(var7, var8);
               if(var9) {
                  continue label37;
               }

               if(var10000 != 0 && var1.a(var7, var8)) {
                  ++var6;
               }

               ++var8;
               if(var9) {
                  break;
               }
            }

            ++var7;
            if(!var9) {
               continue label40;
            }
            break;
         }

         var10000 = var6;
         return var10000;
      }
   }

   public boolean a(int var1, int var2) {
      if(var1 >= this.c && var1 < this.c + this.a && var2 >= this.d && var2 < this.d + this.b) {
         int var3 = (var2 - this.d) * this.a + var1 - this.c;
         return this.g.get(var3);
      } else {
         return false;
      }
   }

   public void a(int var1, int var2, boolean var3) {
      if(var1 >= this.c && var1 < this.c + this.a && var2 >= this.d && var2 < this.d + this.b) {
         int var4 = (var2 - this.d) * this.a + var1 - this.c;
         if(var3) {
            this.g.set(var4);
            if(!d.d) {
               return;
            }
         }

         this.g.clear(var4);
      } else {
         throw new IndexOutOfBoundsException();
      }
   }

   public void a(int var1, int var2, int var3, boolean var4) {
      if(var1 >= this.c && var2 < this.c + this.a && var3 >= this.d && var3 < this.d + this.b) {
         int var5 = (var3 - this.d) * this.a + var1 - this.c;
         int var6 = (var3 - this.d) * this.a + var2 - this.c;
         if(var4) {
            this.g.set(var5, var6);
            if(!d.d) {
               return;
            }
         }

         this.g.clear(var5, var6);
      } else {
         throw new IndexOutOfBoundsException();
      }
   }

   public void b(int var1, int var2) {
      this.c += var1;
      this.d += var2;
      this.e += var1;
      this.f += var2;
   }

   public boolean a(r var1) {
      boolean var14 = d.d;
      if(var1.c < this.c + this.a && var1.d < this.d + this.b && var1.c + var1.a > this.c && var1.d + var1.b > this.d) {
         r var2 = this;
         r var3 = var1;
         int var4 = Math.max(this.c, var1.c);
         int var5 = Math.min(this.c + this.a, var1.c + var1.a);
         int var6 = Math.max(this.d, var1.d);
         int var7 = Math.max(this.d + this.b, var1.d + var1.b);
         if(var4 < var5 && var6 < var7) {
            int var8 = this.a(var4, var6, var4, var6, var5, var7);
            int var9 = var1.a(var4, var6, var4, var6, var5, var7);

            int var10000;
            while(true) {
               if(var8 >= 0) {
                  var10000 = var9;
                  if(var14) {
                     break;
                  }

                  if(var9 >= 0) {
                     int var10 = var8 % var2.a + var2.c;
                     int var11 = var9 % var3.a + var3.c;
                     int var12 = var8 / var2.a + var2.d;
                     int var13 = var9 / var3.a + var3.d;
                     if(var12 == var13) {
                        if(var10 == var11) {
                           return true;
                        }

                        if(var10 < var11) {
                           var8 = var2.a(var11, var13, var4, var6, var5, var7);
                           if(!var14) {
                              continue;
                           }
                        }

                        var9 = var3.a(var10, var12, var4, var6, var5, var7);
                        if(!var14) {
                           continue;
                        }
                     }

                     if(var12 < var13) {
                        var8 = var2.a(var11, var13, var4, var6, var5, var7);
                        if(!var14) {
                           continue;
                        }
                     }

                     var9 = var3.a(var10, var12, var4, var6, var5, var7);
                     if(!var14) {
                        continue;
                     }
                  }
               }

               var10000 = 0;
               break;
            }

            return (boolean)var10000;
         } else {
            return false;
         }
      } else {
         return false;
      }
   }

   public final int a(int var1, int var2, int var3, int var4, int var5, int var6) {
      boolean var9 = d.d;
      int var7 = var1 - this.c + (var2 - this.d) * this.a;
      var3 -= this.c;
      var5 -= this.c;
      var4 -= this.d;
      var6 -= this.d;
      boolean var8 = var7 >= 0 && var7 % this.a >= var3 && var7 % this.a < var5 && var7 / this.a >= var4 && var7 / this.a < var6;

      label50:
      while(true) {
         if(!var8) {
            label64: {
               if(var7 % this.a < var3) {
                  var7 += var3 - var7 % this.a;
                  if(!var9) {
                     break label64;
                  }
               }

               var7 += this.a - var7 % this.a;
            }
         }

         var7 = this.g.nextSetBit(var7);
         int var10000 = var7;

         do {
            if(var10000 < 0) {
               return -1;
            }

            var8 = var7 % this.a >= var3 && var7 % this.a < var5 && var7 / this.a >= var4 && var7 / this.a < var6;
            if(!var8) {
               continue label50;
            }

            var10000 = var7;
         } while(var9);

         return var7;
      }
   }

   public String toString() {
      boolean var5 = d.d;
      StringBuffer var1 = new StringBuffer(this.a * this.b + this.b + 1);
      int var2 = 0;
      int var3 = 0;

      do {
         int var10000 = var3;

         label33:
         while(true) {
            if(var10000 >= this.b) {
               return "x: " + this.c + " y: " + this.d + "\n" + var1.toString();
            }

            int var4 = 0;

            while(true) {
               if(var4 >= this.a) {
                  break label33;
               }

               var10000 = this.g.get(var2);
               if(var5) {
                  break;
               }

               label28: {
                  if(var10000 != 0) {
                     var1.append('#');
                     if(!var5) {
                        break label28;
                     }
                  }

                  var1.append('.');
               }

               ++var2;
               ++var4;
               if(var5) {
                  break label33;
               }
            }
         }

         var1.append('\n');
         ++var3;
      } while(!var5);

      return "x: " + this.c + " y: " + this.d + "\n" + var1.toString();
   }
}
