package y.h;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import y.h.bG;
import y.h.bu;
import y.h.fj;

public class bF implements y.g.C {
   private y.h.a.v a;
   private y.h.a.v b;
   private Map c;
   private int d;
   private y.g.B e;
   private final y.g.C f;

   public bF(y.g.C var1) {
      this.f = var1;
      this.e = new y.g.B(this);
   }

   public y.c.d a(y.c.i var1, y.c.q var2, y.c.q var3, y.c.d var4) {
      return this.f.a(var1, var2, var3, var4);
   }

   public y.c.q a(y.c.i var1, y.c.q var2) {
      return this.f.a(var1, var2);
   }

   public y.g.B a() {
      return this.e;
   }

   public void a(y.g.B var1) {
      this.e = var1;
   }

   public void a(y.c.i var1, y.c.i var2, Map var3, Map var4) {
      this.f.a(var1, var2, var3, var4);
      this.a(var1, var3, var4);
      if(this.d == 0) {
         this.a = null;
         this.b = null;
         this.c = null;
      }

   }

   public void a(y.c.i var1, y.c.i var2) {
      this.f.a(var1, var2);
      if(this.d == 0) {
         this.c = new HashMap();
         this.b = this.a(var1);
         this.a = this.a(var2);
         if(this.b != null && this.a == null && var1 instanceof bu) {
            ((bu)var1).a(this.a = new y.h.a.v(var2));
         }
      }

   }

   private void a(y.c.i var1, Map var2, Map var3) {
      boolean var15 = fj.z;
      y.c.x var4 = var1.o();

      while(true) {
         if(var4.f()) {
            y.c.q var5 = var4.e();
            Object var6 = var2.get(var5);
            if(var15) {
               break;
            }

            if(var6 != null) {
               this.c.put(var5, var6);
            }

            var4.g();
            if(!var15) {
               continue;
            }
         }

         if(this.b != null && this.a != null && this.a() != null) {
            int var18 = 0;
            ArrayList var19 = new ArrayList();
            y.c.x var20 = var1.o();

            y.c.q var7;
            while(var20.f()) {
               var7 = var20.e();
               y.c.q var8 = (y.c.q)var2.get(var7);
               if(var15) {
                  return;
               }

               if(var8 != null && this.b.j(var7) && !this.a.j(var8)) {
                  var19.add(var7);
                  var18 += var7.a();
                  this.a.d(var8);
                  ++this.d;

                  try {
                     this.a(var7, this.b, var8, this.a);
                  } finally {
                     --this.d;
                  }
               }

               var20.g();
               if(var15) {
                  break;
               }
            }

            if(var18 > 0) {
               int var21 = 0;

               while(var21 < var19.size()) {
                  Object var10000 = var19.get(var21);

                  label165:
                  while(true) {
                     var7 = (y.c.q)var10000;
                     y.c.e var22 = var7.j();

                     while(true) {
                        if(!var22.f()) {
                           break label165;
                        }

                        y.c.d var9 = var22.a();
                        y.c.d var10 = (y.c.d)var3.get(var9);
                        var10000 = var10;
                        if(var15) {
                           break;
                        }

                        if(var10 != null && this.b.e(var9)) {
                           y.c.q var11 = this.b.b(var9);
                           y.c.q var12 = this.b.c(var9);
                           y.c.q var13 = (y.c.q)this.c.get(var11);
                           y.c.q var14 = (y.c.q)this.c.get(var12);
                           if(var13 != null && var14 != null) {
                              this.a(var9, this.a, var10, var13, var14);
                           }
                        }

                        var22.g();
                        if(var15) {
                           break label165;
                        }
                     }
                  }

                  ++var21;
                  if(var15) {
                     return;
                  }
               }
            }
         }
         break;
      }

   }

   protected void a(y.c.d var1, y.h.a.v var2, y.c.d var3, y.c.q var4, y.c.q var5) {
      var2.b(var3, var4, var5);
   }

   private y.h.a.v a(y.c.i var1) {
      y.h.a.v var2 = null;
      if(var1 instanceof bu) {
         var2 = ((bu)var1).C();
      } else if(y.h.a.v.a(var1) != null) {
         var2 = y.h.a.v.a(var1);
      }

      return var2;
   }

   protected void a(y.c.q var1, y.h.a.v var2, y.c.q var3, y.h.a.v var4) {
      y.c.i var5 = var4.m(var3);
      y.g.B var6 = this.b(var1, var2, var3, var4);
      if(var6.a() != this) {
         bG var7 = new bG(this, var6.a());
         var6.a((y.g.C)var7);

         try {
            var6.a(var2.m(var1), var5);
         } finally {
            var6.a(var7.a);
         }
      } else {
         var6.a(var2.m(var1), var5);
      }

   }

   protected y.g.B b(y.c.q var1, y.h.a.v var2, y.c.q var3, y.h.a.v var4) {
      return this.a();
   }

   static void a(bF var0, y.c.i var1, Map var2, Map var3) {
      var0.a(var1, var2, var3);
   }
}
