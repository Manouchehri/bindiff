package y.f.i;

import y.f.i.aK;
import y.f.i.v;

class aO {
   private y.c.f[] a;
   private int[] b;
   private int c;
   private y.c.q d;
   private y.f.X e;
   private final aK f;

   public aO(aK var1, y.c.q var2, y.c.c var3) {
      int var5 = v.f;
      super();
      this.f = var1;
      this.a = new y.c.f[4];
      this.b = new int[4];
      this.c = 0;
      int var4 = 0;

      while(true) {
         if(var4 < 4) {
            this.a[var4] = new y.c.f();
            ++var4;
            if(var5 != 0) {
               break;
            }

            if(var5 == 0) {
               continue;
            }
         }

         this.d = var2;
         this.e = (y.f.X)this.d.e();
         break;
      }

      label16: {
         if(var3 != null) {
            this.a(var3);
            if(var5 == 0) {
               break label16;
            }
         }

         this.e();
      }

      this.f();
   }

   private void a(y.c.c var1) {
      int var11 = v.f;
      boolean[] var2 = new boolean[4];
      y.c.e var3 = this.d.j();

      byte var10000;
      while(true) {
         if(var3.f()) {
            y.c.d var4 = var3.a();
            var10000 = aK.a(this.f).d(var4);
            if(var11 != 0) {
               break;
            }

            if(var10000 == 0) {
               y.d.t var7;
               y.d.t var8;
               label47: {
                  boolean var5 = this.d == var4.c();
                  y.c.D var6 = this.e.m(var4);
                  int var9 = var6.size();
                  if(var5) {
                     var7 = (y.d.t)var6.a(0);
                     var8 = (y.d.t)var6.a(1);
                     if(var11 == 0) {
                        break label47;
                     }
                  }

                  var7 = (y.d.t)var6.a(var9 - 1);
                  var8 = (y.d.t)var6.a(var9 - 2);
               }

               int var10 = this.a(var7, var8);
               if(var10 != -9) {
                  this.a[var10].add(var4);
                  if(var1.d(var4)) {
                     var2[var10] = true;
                  }
               }
            }

            var3.g();
            if(var11 == 0) {
               continue;
            }
         }

         var10000 = 0;
         break;
      }

      int var12 = var10000;

      while(var12 < 4) {
         if(!var2[var12]) {
            this.a[var12].clear();
         }

         ++var12;
         if(var11 != 0) {
            break;
         }
      }

   }

   private void e() {
      int var9 = v.f;
      y.c.e var1 = this.d.j();

      while(var1.f()) {
         y.c.d var2;
         y.d.t var5;
         y.d.t var6;
         label26: {
            var2 = var1.a();
            boolean var3 = this.d == var2.c();
            y.c.D var4 = this.e.m(var2);
            int var7 = var4.size();
            if(var3) {
               var5 = (y.d.t)var4.a(0);
               var6 = (y.d.t)var4.a(1);
               if(var9 == 0) {
                  break label26;
               }
            }

            var5 = (y.d.t)var4.a(var7 - 1);
            var6 = (y.d.t)var4.a(var7 - 2);
         }

         int var8 = this.a(var5, var6);
         if(var8 != -9) {
            this.a[var8].add(var2);
         }

         var1.g();
         if(var9 != 0) {
            break;
         }
      }

   }

   private int a(y.d.t var1, y.d.t var2) {
      int var6 = v.f;
      int var3;
      double var4;
      if(Math.abs(var1.a - var2.a) < 0.01D) {
         var4 = this.e.n(this.d) + this.e.q(this.d) / 2.0D;
         var3 = var2.b <= var4?0:1;
         if(var6 == 0) {
            return var3;
         }
      }

      if(Math.abs(var1.b - var2.b) < 0.01D) {
         var4 = this.e.m(this.d) + this.e.p(this.d) / 2.0D;
         var3 = var2.a <= var4?2:3;
         if(var6 == 0) {
            return var3;
         }
      }

      var3 = -9;
      return var3;
   }

   private void f() {
      int var7 = v.f;
      int var1 = Integer.MIN_VALUE;
      int var2 = -1;
      int var3 = Integer.MAX_VALUE;
      int var4 = -1;
      int var5 = 0;

      int var10000;
      while(true) {
         if(var5 < 4) {
            var10000 = this.a[var5].size();
            if(var7 != 0) {
               break;
            }

            if(var10000 > var1) {
               var2 = var5;
               var1 = this.a[var5].size();
            }

            if(this.a[var5].size() <= var3) {
               var4 = var5;
               var3 = this.a[var5].size();
            }

            ++var5;
            if(var7 == 0) {
               continue;
            }
         }

         this.b[0] = var2;
         this.b[3] = var4;
         var10000 = 2;
         break;
      }

      int[] var9 = new int[var10000];
      var9[0] = 0;
      var9[1] = 0;
      int[] var8 = var9;
      int var6 = 0;

      int var10001;
      while(true) {
         if(var6 < 4) {
            var10000 = var6;
            var10001 = var4;
            if(var7 != 0) {
               break;
            }

            if(var6 != var4 && var6 != var2) {
               var8[1] = var8[0];
               var8[0] = var6;
            }

            ++var6;
            if(var7 == 0) {
               continue;
            }
         }

         var10000 = this.a[var8[0]].size();
         var10001 = this.a[var8[1]].size();
         break;
      }

      if(var10000 > var10001) {
         this.b[1] = var8[0];
         this.b[2] = var8[1];
         if(var7 == 0) {
            return;
         }
      }

      this.b[1] = var8[1];
      this.b[2] = var8[0];
   }

   public void a() {
      this.c = 0;
   }

   public boolean b() {
      ++this.c;
      return this.c >= 0 && this.c < 4;
   }

   public y.c.f c() {
      return this.a[this.b[this.c]];
   }

   public int d() {
      return this.b[this.c];
   }

   public String toString() {
      int var3 = v.f;
      StringBuffer var1 = new StringBuffer();
      var1.append("[n: ").append(this.d);
      var1.append("; sequence = (");
      int var2 = 0;

      while(true) {
         if(var2 < 3) {
            var1.append(this.b[var2]).append(", ");
            ++var2;
            if(var3 != 0) {
               break;
            }

            if(var3 == 0) {
               continue;
            }
         }

         var1.append(this.b[3]).append(")");
         var1.append("; currIndex = ").append(this.c).append("]");
         break;
      }

      return var1.toString();
   }
}
