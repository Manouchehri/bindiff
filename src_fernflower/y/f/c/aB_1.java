package y.f.c;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.Map;
import y.f.c.Q;
import y.f.c.a;
import y.f.c.aC;
import y.f.c.aD;

class aB implements Q {
   aD a;
   private Q b;
   private y.c.c c;
   private boolean d;
   private Comparator e = new aC(this);

   void a(Q var1, y.c.c var2) {
      this.b = var1;
      this.c = var2;
   }

   public void a(Object var1) {
      if(!(var1 instanceof Map)) {
         throw new IllegalArgumentException("Unknown memento type!");
      } else {
         Map var2 = (Map)var1;
         this.a = (aD)var2.get("y.layout.hierarchic.MementoSequencer.SequencerMemento");
      }
   }

   public void b(Object var1) {
      if(!(var1 instanceof Map)) {
         throw new IllegalArgumentException("Unknown memento type!");
      } else {
         Map var2 = (Map)var1;
         var2.put("y.layout.hierarchic.MementoSequencer.SequencerMemento", this.a);
      }
   }

   public y.c.y[] a(y.f.X var1, y.c.A var2, int var3) {
      boolean var10 = a.i;
      y.c.y[] var4;
      int var6;
      y.c.y var7;
      y.c.y[] var10000;
      if(this.a != null && !this.d) {
         var4 = new y.c.y[var3];
         int var11 = var4.length - 1;

         while(var11 >= 0) {
            var4[var11] = new y.c.y();
            --var11;
            if(var10) {
               break;
            }
         }

         y.c.x var12 = var1.o();

         while(var12.f()) {
            y.c.q var14 = var12.e();
            Object var15 = this.c(var14);
            if(this.a.a.get(var15) == null) {
               throw new IllegalStateException("No memento stored for " + var15);
            }

            var4[var2.a(var14)].add(var14);
            var12.g();
            if(var10) {
               break;
            }
         }

         ArrayList var13 = new ArrayList(var4.length);
         var6 = 0;

         while(true) {
            if(var6 < var4.length) {
               var10000 = var4;
               if(var10) {
                  break;
               }

               var7 = var4[var6];
               if(var7.size() > 0) {
                  var7.sort(this.e);
                  var13.add(var7);
               }

               ++var6;
               if(!var10) {
                  continue;
               }
            }

            var10000 = (y.c.y[])var13.toArray(new y.c.y[var13.size()]);
            break;
         }

         return var10000;
      } else {
         if(this.a == null) {
            this.a = new aD();
         }

         var4 = this.b.a(var1, var2, var3);
         Map var5 = this.a.a;
         var6 = 0;

         while(true) {
            if(var6 < var4.length) {
               var10000 = var4;
               if(var10) {
                  break;
               }

               var7 = var4[var6];
               int var8 = 0;
               y.c.p var9 = var7.k();

               label79: {
                  while(var9 != null) {
                     var5.put(this.c(var9.c()), new Integer(var8));
                     var9 = var9.a();
                     ++var8;
                     if(var10) {
                        break label79;
                     }

                     if(var10) {
                        break;
                     }
                  }

                  ++var6;
               }

               if(!var10) {
                  continue;
               }
            }

            var10000 = var4;
            break;
         }

         return var10000;
      }
   }

   final Object c(Object var1) {
      Object var2 = this.c.b(var1);
      if(var2 == null) {
         throw new IllegalArgumentException("No Id stored for " + var1);
      } else {
         return var2;
      }
   }

   public void a(boolean var1) {
      this.d = var1;
   }
}
