package y.h.b;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import y.h.bu;
import y.h.fj;
import y.h.b.a;
import y.h.b.i;
import y.h.b.v;

final class I {
   private final Collection a;
   private final Collection b;
   private final Map c;

   I(Collection var1, Collection var2, Map var3) {
      this.a = Collections.unmodifiableCollection(var1);
      this.b = Collections.unmodifiableCollection(var2);
      this.c = var3;
   }

   public Collection a() {
      return this.a;
   }

   Collection b() {
      return this.b;
   }

   y.c.q a(i var1) {
      return (y.c.q)this.c.get(var1);
   }

   static I a(bu var0) {
      int var11 = a.H;
      y.h.a.v var1 = y.h.a.v.a((y.c.i)var0);
      if(var1 == null) {
         return null;
      } else {
         ArrayList var2 = new ArrayList();
         ArrayList var3 = new ArrayList();
         HashMap var4 = new HashMap();
         y.c.x var5 = var0.o();

         label69:
         while(true) {
            boolean var10000 = var5.f();

            label66:
            while(var10000) {
               y.c.q var6 = var5.e();
               if(var11 != 0) {
                  return new I(var2, var3, var4);
               }

               if(var1.n(var6) == null) {
                  label62: {
                     if(var1.k(var6)) {
                        fj var7 = v.a(var0, var6);
                        if(var7 instanceof a) {
                           i var8 = ((a)var7).l();
                           var3.add(var8);
                           var4.put(var8, var6);
                           if(var11 == 0) {
                              break label62;
                           }
                        }

                        var2.add(var6);
                        ArrayList var12 = new ArrayList();
                        var12.add(var6);

                        label59:
                        while(true) {
                           var10000 = var12.isEmpty();

                           while(true) {
                              if(var10000) {
                                 break label62;
                              }

                              y.c.q var9 = (y.c.q)var12.remove(var12.size() - 1);
                              y.c.x var10 = var1.p(var9);

                              while(true) {
                                 if(!var10.f()) {
                                    continue label59;
                                 }

                                 var2.add(var10.e());
                                 var10000 = var1.k(var10.e());
                                 if(var11 != 0) {
                                    continue label66;
                                 }

                                 if(var11 != 0) {
                                    break;
                                 }

                                 if(var10000) {
                                    var12.add(var10.e());
                                 }

                                 var10.g();
                                 if(var11 != 0) {
                                    break label59;
                                 }
                              }
                           }
                        }
                     }

                     var2.add(var6);
                  }
               }

               var5.g();
               if(var11 == 0) {
                  continue label69;
               }
               break;
            }

            if(var3.isEmpty()) {
               return null;
            }

            return new I(var2, var3, var4);
         }
      }
   }
}
