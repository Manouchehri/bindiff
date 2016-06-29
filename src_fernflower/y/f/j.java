package y.f;

import y.f.X;
import y.f.aU;

final class j {
   int a;
   int b;
   int c;
   int d;
   int e;
   int f;
   private aU g;

   j(int var1, int var2, int var3, int var4) {
      this.a = var3;
      this.b = var4;
      this.c = var1;
      this.e = 0;
      this.d = var2;
      this.f = 0;
      this.g = new aU(var3 * var4);
   }

   int a() {
      return this.e;
   }

   int b() {
      return this.f;
   }

   void a(int var1, int var2, int var3, int var4) {
      boolean var6 = X.j;
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
      boolean var9 = X.j;
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

   void a(j var1, int var2, int var3, double var4, boolean var6) {
      label126: {
         boolean var16 = X.j;
         int var7 = this.c + this.a / 2;
         int var8 = this.d + this.b / 2;
         this.a(var2 - var7, var3 - var8);
         int var9;
         if(var6) {
            var9 = 0;

            do {
               if(this.a(var1, 0, 0, var9)) {
                  break label126;
               }

               ++var9;
               if(var16) {
                  return;
               }
            } while(!var16);
         }

         var9 = 0;
         int var10 = 0;
         if(this.a(var1, 0, 0)) {
            var1.a(this);
            return;
         }

         label112:
         while(true) {
            double var11 = (double)(var9 + 1) / (double)var10 / var4;
            double var13 = (double)var9 / (double)(var10 + 1) / var4;
            double var17;
            int var10000 = (var17 = var11 - 1.0D) == 0.0D?0:(var17 < 0.0D?-1:1);

            label110:
            while(true) {
               if(var10000 < 0) {
                  var11 = 1.0D / var11;
               }

               double var18;
               var10000 = (var18 = var13 - 1.0D) == 0.0D?0:(var18 < 0.0D?-1:1);

               while(true) {
                  if(var10000 < 0) {
                     var13 = 1.0D / var13;
                  }

                  int var15;
                  if(var11 < var13) {
                     ++var9;
                     if(this.a(var1, -var9, 0) || this.a(var1, var9, 0)) {
                        break label112;
                     }

                     var15 = 1;

                     do {
                        if(var15 > var10) {
                           continue label112;
                        }

                        var10000 = this.a(var1, -var9, -var15);
                        if(var16) {
                           continue label110;
                        }

                        if(var10000 != 0 || this.a(var1, -var9, var15) || this.a(var1, var9, -var15) || this.a(var1, var9, var15)) {
                           break label112;
                        }

                        ++var15;
                     } while(!var16);
                  }

                  ++var10;
                  if(this.a(var1, 0, -var10) || this.a(var1, 0, var10)) {
                     break label112;
                  }

                  var15 = 1;

                  while(true) {
                     if(var15 > var9) {
                        continue label112;
                     }

                     var10000 = this.a(var1, var15, -var10);
                     if(var16) {
                        break;
                     }

                     if(var16) {
                        continue label110;
                     }

                     if(var10000 != 0 || this.a(var1, var15, var10) || this.a(var1, -var15, -var10) || this.a(var1, -var15, var10)) {
                        break label112;
                     }

                     ++var15;
                     if(var16) {
                        break label112;
                     }
                  }
               }
            }
         }
      }

      var1.a(this);
   }

   boolean a(j var1, int var2, int var3, int var4) {
      boolean var9 = X.j;
      if(var4 == 0) {
         return this.a(var1, var2, var3);
      } else {
         int var5 = var4;
         int var6 = 0;
         int var7 = var4 * var4;
         int var8 = var7;

         boolean var10000;
         while(true) {
            if(var5 >= var6) {
               var10000 = this.a(var1, var2 + var5, var3 + var6);
               if(var9) {
                  break;
               }

               if(var10000) {
                  return true;
               }

               if(this.a(var1, var2 + var5, var3 - var6)) {
                  return true;
               }

               if(this.a(var1, var2 - var5, var3 + var6)) {
                  return true;
               }

               if(this.a(var1, var2 - var5, var3 - var6)) {
                  return true;
               }

               if(this.a(var1, var2 + var6, var3 + var5)) {
                  return true;
               }

               if(this.a(var1, var2 + var6, var3 - var5)) {
                  return true;
               }

               if(this.a(var1, var2 - var6, var3 + var5)) {
                  return true;
               }

               if(this.a(var1, var2 - var6, var3 - var5)) {
                  return true;
               }

               if(var8 < var7) {
                  var8 += 1 + 2 * var6;
                  ++var6;
                  if(!var9) {
                     continue;
                  }
               }

               var8 += 2 - 2 * var5 + 2 * var6;
               --var5;
               ++var6;
               if(!var9) {
                  continue;
               }
            }

            var10000 = false;
            break;
         }

         return var10000;
      }
   }

   private final boolean a(j var1, int var2, int var3) {
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

   public void a(int var1, int var2, boolean var3) {
      if(var1 >= this.c && var1 < this.c + this.a && var2 >= this.d && var2 < this.d + this.b) {
         int var4 = (var2 - this.d) * this.a + var1 - this.c;
         if(var3) {
            this.g.set(var4);
            if(!X.j) {
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
            if(!X.j) {
               return;
            }
         }

         this.g.clear(var5, var6);
      } else {
         throw new IndexOutOfBoundsException();
      }
   }

   public void a(int var1, int var2) {
      this.c += var1;
      this.d += var2;
      this.e += var1;
      this.f += var2;
   }

   public void a(j var1) {
      boolean var6 = X.j;
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
         if(var6) {
            break;
         }
      }

   }

   void b(int var1, int var2, int var3, int var4) {
      boolean var10 = X.j;
      int var5 = var3 - var1;
      aU var6 = new aU(var5 * (var4 - var2));
      int var7 = this.g.nextSetBit(0);

      while(true) {
         if(var7 >= 0) {
            int var8 = var7 % this.a + this.c;
            int var9 = var7 / this.a + this.d;
            var6.set(var8 - var1 + (var9 - var2) * var5);
            var7 = this.g.nextSetBit(var7 + 1);
            if(var10) {
               break;
            }

            if(!var10) {
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

   public boolean b(j var1) {
      boolean var14 = X.j;
      if(var1.c < this.c + this.a && var1.d < this.d + this.b && var1.c + var1.a > this.c && var1.d + var1.b > this.d) {
         j var2 = this;
         j var3 = var1;
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
      boolean var9 = X.j;
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
      boolean var5 = X.j;
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

   static aU c(j var0) {
      return var0.g;
   }
}
