package y.f.i;

import java.util.HashMap;
import java.util.Iterator;
import y.f.i.v;

class D {
   private HashMap a;
   private y.c.D[] b;
   private int[] c;
   private y.c.D d;

   D(y.f.ay var1) {
      int var7 = v.f;
      this();
      Iterator var2 = var1.a();

      while(var2.hasNext()) {
         y.f.aA var3 = (y.f.aA)var2.next();
         y.f.ax var4 = var3.a();
         this.d.add(var4);
         if(var4.b()) {
            Object var5 = b(var4.c(), var4.d());
            int var6 = var3.b();
            if(this.a.containsKey(var5)) {
               var6 += ((Integer)this.a.get(var5)).intValue();
            }

            this.a.put(var5, new Integer(var6));
            if(var7 == 0) {
               continue;
            }
         }

         if(var4.a((int)1)) {
            this.c[0] += var3.b();
         }

         if(var4.a((int)2)) {
            this.c[1] += var3.b();
         }

         if(var4.a((int)8)) {
            this.c[2] += var3.b();
         }

         if(var4.a((int)4)) {
            this.c[3] += var3.b();
            if(var7 != 0) {
               break;
            }
         }
      }

   }

   D() {
      int var2 = v.f;
      super();
      this.a = null;
      this.b = new y.c.D[4];
      this.c = new int[4];
      this.d = new y.c.D();
      this.a = new HashMap();
      int var1 = 0;

      while(var1 < 4) {
         this.b[var1] = new y.c.D();
         this.c[var1] = -1;
         ++var1;
         if(var2 != 0) {
            break;
         }
      }

   }

   private static Object b(double var0, double var2) {
      return new y.d.t((double)((int)Math.floor(var0 * 10.0D)), (double)((int)Math.floor(var2 * 10.0D)));
   }

   public y.c.D a() {
      return this.d;
   }

   public int a(double var1, double var3) {
      Object var5 = b(var1, var3);
      return this.a.containsKey(var5)?((Integer)this.a.get(var5)).intValue():-1;
   }

   public int a(int var1) {
      int var2 = 0;
      if((var1 & 1) != 0) {
         if(this.c[0] < 0) {
            return Integer.MAX_VALUE;
         }

         var2 += this.c[0];
      }

      if((var1 & 2) != 0) {
         if(this.c[1] < 0) {
            return Integer.MAX_VALUE;
         }

         var2 += this.c[1];
      }

      if((var1 & 4) != 0) {
         if(this.c[3] < 0) {
            return Integer.MAX_VALUE;
         }

         var2 += this.c[3];
      }

      if((var1 & 8) != 0) {
         if(this.c[2] < 0) {
            return Integer.MAX_VALUE;
         }

         var2 += this.c[2];
      }

      return var2;
   }

   public y.c.p a(y.d.t var1, int var2) {
      if(var2 == 1) {
         return this.b[0].b((Object)var1);
      } else if(var2 == 2) {
         return this.b[1].b((Object)var1);
      } else if(var2 == 4) {
         return this.b[3].b((Object)var1);
      } else if(var2 == 8) {
         return this.b[2].b((Object)var1);
      } else {
         throw new RuntimeException("unknown direction");
      }
   }

   public void a(y.c.p var1, int var2) {
      int var3 = v.f;
      if(var2 == 1) {
         this.b[0].h(var1);
         if(var3 == 0) {
            return;
         }
      }

      if(var2 == 2) {
         this.b[1].h(var1);
         if(var3 == 0) {
            return;
         }
      }

      if(var2 == 4) {
         this.b[3].h(var1);
         if(var3 == 0) {
            return;
         }
      }

      if(var2 != 8) {
         throw new RuntimeException("unknown direction");
      } else {
         this.b[2].h(var1);
         if(var3 != 0) {
            throw new RuntimeException("unknown direction");
         }
      }
   }

   public y.c.D b(int var1) {
      y.c.D var2 = new y.c.D();
      if((var1 & 1) != 0) {
         var2.addAll(this.b[0]);
      }

      if((var1 & 2) != 0) {
         var2.addAll(this.b[1]);
      }

      if((var1 & 4) != 0) {
         var2.addAll(this.b[3]);
      }

      if((var1 & 8) != 0) {
         var2.addAll(this.b[2]);
      }

      return var2;
   }
}
