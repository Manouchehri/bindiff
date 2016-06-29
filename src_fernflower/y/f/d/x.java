package y.f.d;

import y.f.d.B;
import y.f.d.a;

final class x {
   int a;
   int b;
   int c;
   int d;
   int e;
   int f;
   private B g;
   private int h;
   private int i;
   private int j;

   x(int var1, int var2, int var3, int var4) {
      this.a = var3;
      this.b = var4;
      this.c = var1;
      this.e = 0;
      this.d = var2;
      this.f = 0;
      this.g = new B(var3 * var4);
   }

   int a() {
      return this.e;
   }

   int b() {
      return this.f;
   }

   void a(int var1, int var2, int var3, int var4) {
      int var6 = a.f;
      int var5 = var2;

      while(var5 < var4) {
         this.a(var1, var3, var5, true);
         ++var5;
         if(var6 != 0) {
            break;
         }
      }

   }

   void c() {
      int var9 = a.f;
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
            if(var9 != 0) {
               break;
            }

            if(var9 == 0) {
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
            if(var9 != 0) {
               break;
            }

            if(var9 == 0) {
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
            if(var9 != 0) {
               break;
            }

            if(var9 == 0) {
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
               if(var9 != 0) {
                  break label63;
               }

               if(var10000 <= var6 && var4[var7] >= var6) {
                  int var8 = var7 + 1;

                  while(var3[var8] <= var6) {
                     var10000 = var4[var8];
                     var10001 = var6;
                     if(var9 != 0) {
                        continue label60;
                     }

                     if(var10000 < var6) {
                        break;
                     }

                     ++var8;
                     if(var9 != 0) {
                        break;
                     }
                  }

                  this.g.set(var5 + var7, var5 + var8);
               }

               ++var7;
               if(var9 == 0) {
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
         if(var9 != 0) {
            break;
         }
      }

   }

   boolean a(x var1, int var2, int var3, int var4, int var5, y.d.n var6, boolean var7) {
      int var11 = a.f;
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
            var10000 = this.a(var1, 0, 0, var10, var6, var7);
            if(var11 != 0) {
               break;
            }

            if(var10000) {
               if(var10 != 0) {
                  return true;
               }

               return false;
            }

            var10 += var4;
            if(var11 == 0) {
               continue;
            }
         }

         var10000 = var7;
         break;
      }

      if(!var10000 || this.i <= 0 && this.j <= 0) {
         return false;
      } else {
         this.c += this.i;
         this.d += this.j;
         this.e += this.i;
         this.f += this.j;
         return true;
      }
   }

   boolean a(x var1, int var2, int var3, int var4, y.d.n var5, boolean var6) {
      int var11 = a.f;
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
               if(var11 != 0) {
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
                  if(var11 == 0) {
                     continue;
                  }
               }

               var10 += 2 - 2 * var7 + 2 * var8;
               --var7;
               ++var8;
               if(var11 == 0) {
                  continue;
               }
            }

            var10000 = false;
            break;
         }

         return var10000;
      }
   }

   private final boolean a(x var1, int var2, int var3, y.d.n var4, boolean var5) {
      y.d.t var6 = new y.d.t((double)(var2 + this.c) + (double)this.a * 0.5D, (double)(var3 + this.d) + (double)this.b * 0.5D);
      if(var4 != null && !y.d.n.a(var4, var6, 1.0D)) {
         return false;
      } else if(!var5) {
         return this.a(var1, var2, var3);
      } else {
         this.c += var2;
         this.d += var3;
         int var7 = this.c(var1);
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

   private final boolean a(x var1, int var2, int var3) {
      this.c += var2;
      this.d += var3;
      if(!this.b(var1)) {
         this.e += var2;
         this.f += var3;
         return true;
      } else {
         this.c -= var2;
         this.d -= var3;
         return false;
      }
   }

   private int c(x var1) {
      int var9 = a.f;
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
            if(var9 != 0) {
               return var10000;
            }

            int var8 = var4;

            while(var8 < var5) {
               var10000 = this.a(var7, var8);
               if(var9 != 0) {
                  continue label37;
               }

               if(var10000 != 0 && var1.a(var7, var8)) {
                  ++var6;
               }

               ++var8;
               if(var9 != 0) {
                  break;
               }
            }

            ++var7;
            if(var9 == 0) {
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
            if(a.f == 0) {
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
            if(a.f == 0) {
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

   public void a(x var1) {
      int var6 = a.f;
      if(var1.c < this.c || var1.c >= this.c + this.a || var1.d < this.d || var1.d >= this.d + this.b || var1.c + var1.a > this.c + this.a || var1.d + var1.b > this.d + this.b) {
         this.b(Math.min(var1.c, this.c), Math.min(var1.d, this.d), Math.max(var1.c + var1.a, this.c + this.a), Math.max(var1.d + var1.b, this.d + this.b));
      }

      int var2 = var1.g.nextSetBit(0);

      while(var2 >= 0) {
         int var3 = var2 % var1.a + var1.c;
         int var4 = var2 / var1.a + var1.d;
         int var5 = var3 - this.c + (var4 - this.d) * this.a;
         this.g.set(var5);
         var2 = var1.g.nextSetBit(var2 + 1);
         if(var6 != 0) {
            break;
         }
      }

   }

   void b(int var1, int var2, int var3, int var4) {
      int var10 = a.f;
      int var5 = var3 - var1;
      B var6 = new B(var5 * (var4 - var2));
      int var7 = this.g.nextSetBit(0);

      while(true) {
         if(var7 >= 0) {
            int var8 = var7 % this.a + this.c;
            int var9 = var7 / this.a + this.d;
            var6.set(var8 - var1 + (var9 - var2) * var5);
            var7 = this.g.nextSetBit(var7 + 1);
            if(var10 != 0) {
               break;
            }

            if(var10 == 0) {
               continue;
            }
         }

         this.g = var6;
         this.c = var1;
         this.d = var2;
         this.a = var5;
         this.b = var4 - var2;
         break;
      }

   }

   public boolean b(x var1) {
      int var14 = a.f;
      if(var1.c < this.c + this.a && var1.d < this.d + this.b && var1.c + var1.a > this.c && var1.d + var1.b > this.d) {
         x var2 = this;
         x var3 = var1;
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
                  if(var14 != 0) {
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
                           if(var14 == 0) {
                              continue;
                           }
                        }

                        var9 = var3.a(var10, var12, var4, var6, var5, var7);
                        if(var14 == 0) {
                           continue;
                        }
                     }

                     if(var12 < var13) {
                        var8 = var2.a(var11, var13, var4, var6, var5, var7);
                        if(var14 == 0) {
                           continue;
                        }
                     }

                     var9 = var3.a(var10, var12, var4, var6, var5, var7);
                     if(var14 == 0) {
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
      int var9 = a.f;
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
                  if(var9 == 0) {
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
         } while(var9 != 0);

         return var7;
      }
   }

   public String toString() {
      int var5 = a.f;
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
               if(var5 != 0) {
                  break;
               }

               label28: {
                  if(var10000 != 0) {
                     var1.append('#');
                     if(var5 == 0) {
                        break label28;
                     }
                  }

                  var1.append('.');
               }

               ++var2;
               ++var4;
               if(var5 != 0) {
                  break label33;
               }
            }
         }

         var1.append('\n');
         ++var3;
      } while(var5 == 0);

      return "x: " + this.c + " y: " + this.d + "\n" + var1.toString();
   }
}
