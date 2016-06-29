package y.f.c;

import java.util.Map;
import y.f.c.R;
import y.f.c.a;
import y.f.c.aJ;
import y.f.c.w;

class aI implements R {
   private aJ a;
   private R b;
   private y.c.c c;
   private y.c.c d;
   private boolean e;
   private Object f;

   public void a(R var1, y.c.c var2, y.c.c var3, Object var4) {
      this.b = var1;
      this.c = var2;
      this.d = var3;
      this.f = var4;
   }

   public int a(y.f.X var1, y.c.A var2, y.c.f var3) {
      boolean var11 = a.i;
      y.c.x var5;
      y.c.q var6;
      Object var7;
      if(this.a != null && !this.e) {
         boolean[] var13 = new boolean[this.a.a];
         var5 = var1.o();

         boolean[] var10000;
         while(true) {
            if(var5.f()) {
               var6 = var5.e();
               var7 = this.b(var6);
               y.g.am var8 = (y.g.am)this.a.b.get(var7);

               try {
                  Integer var9 = (Integer)var8.a;
                  int var10 = var9.intValue();
                  var2.a(var6, var10);
                  var10000 = var13;
                  if(var11) {
                     break;
                  }

                  var13[var10] = true;
               } catch (NullPointerException var12) {
                  throw new IllegalStateException("Memento has no information about " + var6);
               }

               var5.g();
               if(!var11) {
                  continue;
               }
            }

            var10000 = var13;
            break;
         }

         int[] var14 = new int[var10000.length];
         int var15 = 0;
         int var16 = 0;

         int var20;
         while(true) {
            if(var16 < var14.length) {
               var20 = var13[var16];
               if(var11) {
                  break;
               }

               if(var20 != 0) {
                  var14[var16] = var15++;
               }

               ++var16;
               if(!var11) {
                  continue;
               }
            }

            var20 = var15;
            break;
         }

         if(var20 < var14.length) {
            y.c.x var17 = var1.o();

            while(var17.f()) {
               y.c.q var18 = var17.e();
               int var19 = var2.a(var18);
               var20 = var14[var19];
               if(var11) {
                  return var20;
               }

               if(var20 != var19) {
                  var2.a(var18, var14[var19]);
               }

               var17.g();
               if(var11) {
                  break;
               }
            }
         }

         var3.a(w.a(var1, var2));
         var20 = var15;
         return var20;
      } else {
         if(this.a == null) {
            this.a = new aJ();
         }

         int var4 = this.b.a(var1, var2, var3);
         this.a.a = Math.max(this.a.a, var4);
         var5 = var1.o();

         while(var5.f()) {
            var6 = var5.e();
            var7 = this.b(var6);
            this.a.b.put(var7, y.g.am.a(new Integer(var2.a(var6)), this.f));
            var5.g();
            if(var11) {
               break;
            }
         }

         return var4;
      }
   }

   public Object a(Object var1) {
      Object var2 = this.b(var1);
      if(var2 == null) {
         throw new IllegalArgumentException("No Id stored for " + var1);
      } else {
         Object var3 = this.a.b.get(var2);
         if(var3 == null) {
            throw new IllegalArgumentException("No memento information stored for id " + var2);
         } else {
            return var3;
         }
      }
   }

   final Object b(Object var1) {
      Object var2 = this.c.b(var1);
      if(var2 == null) {
         throw new IllegalArgumentException("No Id stored for " + var1);
      } else {
         return var2;
      }
   }

   public void a(boolean var1) {
      this.e = var1;
   }

   public void c(Object var1) {
      if(!(var1 instanceof Map)) {
         throw new IllegalArgumentException("Unknown memento type!");
      } else {
         Map var2 = (Map)var1;
         this.a = (aJ)var2.get("y.layout.hierarchic.MementoLayerer.LayerMemento");
      }
   }

   public void d(Object var1) {
      if(!(var1 instanceof Map)) {
         throw new IllegalArgumentException("Unknown memento type!");
      } else {
         Map var2 = (Map)var1;
         var2.put("y.layout.hierarchic.MementoLayerer.LayerMemento", this.a);
      }
   }
}
