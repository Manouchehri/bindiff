package y.d.a;

import java.util.ArrayList;
import y.c.D;
import y.c.p;
import y.d.a.b;
import y.d.a.c;
import y.d.a.d;
import y.d.a.e;

class h {
   private D a;
   private d b;
   private final b c;

   private h(b var1) {
      this.c = var1;
      this.a = new D();
      this.b = new d(this.c);
   }

   void a(Object var1, ArrayList var2, e[] var3) {
      int var10 = b.b;
      var2.clear();
      p var4 = this.a.k();
      p var5 = null;
      p var6 = null;
      boolean var7 = false;

      while(true) {
         if(var4 != null) {
            e var8 = (e)this.a.g(var4);
            int var9 = b.a(this.c).a(var8.g, var1);
            if(var10 != 0) {
               break;
            }

            if(var9 > 0) {
               var5 = var4;
            }

            int var10000;
            label47: {
               if(var9 == 0) {
                  if(var7) {
                     throw new RuntimeException("YStruct not correct on get !");
                  }

                  var2.add(var8);
               } else {
                  var10000 = var9;
                  if(var10 == 0) {
                     break label47;
                  }
               }

               do {
                  while(true) {
                     var8 = var8.h;
                     if(var8 == null) {
                        var10000 = var9;
                        break;
                     }

                     var2.add(var8);
                  }
               } while(var10 != 0);
            }

            if(var10000 < 0) {
               if(!var7) {
                  var6 = var4;
               }

               var7 = true;
            }

            var4 = this.a.c(var4);
            if(var10 == 0) {
               continue;
            }
         }

         var3[0] = (e)this.a.g(var5);
         var3[1] = (e)this.a.g(var6);
         break;
      }

   }

   void a(Object var1, e var2) {
      int var7 = b.b;
      p var3 = this.a.k();
      this.b.a(var1);
      int var4 = -1;

      while(true) {
         if(var3 != null && var4 < 0) {
            e var5 = (e)this.a.g(var3);
            var4 = this.b.compare(var2, var5);
            if(var4 == 0) {
               e var9 = null;

               while(var5.b() < var2.b()) {
                  var9 = var5;
                  var5 = var5.h;
                  if(var5 == null) {
                     break;
                  }
               }

               label24: {
                  if(var9 != null) {
                     var2.a(var9.h);
                     var9.a(var2);
                     if(var7 == 0) {
                        break label24;
                     }
                  }

                  var5 = (e)this.a.g(var3);
                  var2.a(var5);
                  this.a.a((p)var3, (Object)var2);
               }

               var2.a(var3);
               return;
            }

            if(var4 > 0) {
               p var6 = this.a.a((Object)var2, (p)var3);
               var2.a(var6);
               return;
            }

            var3 = this.a.c(var3);
            if(var7 == 0) {
               continue;
            }
         }

         p var8 = this.a.b((Object)var2, (p)null);
         var2.a(var8);
         return;
      }
   }

   void a(e var1) {
      int var3 = b.b;
      e var2 = (e)this.a.g(var1.b);
      if(var2 == var1) {
         if(var1.h == null) {
            this.a.h(var2.b);
            if(var3 == 0) {
               return;
            }
         }

         this.a.a((p)var1.b, (Object)var1.h);
         if(var3 == 0) {
            return;
         }
      }

      while(true) {
         if(var2.h != var1) {
            var2 = var2.h;
            if(var3 != 0) {
               break;
            }

            if(var3 == 0) {
               continue;
            }
         }

         var2.h = var1.h;
         break;
      }

   }

   void a(Object var1) {
      int var7 = b.b;
      ArrayList var2 = new ArrayList();
      p var3 = this.a.k();
      p var4 = null;
      boolean var5 = false;

      h var10000;
      while(true) {
         if(var3 != null) {
            e var6 = (e)this.a.g(var3);
            var10000 = this;
            if(var7 != 0) {
               break;
            }

            label25: {
               if(b.a(this.c).e(var6.g, var1)) {
                  if(var5) {
                     throw new RuntimeException("YStruct not correct on swap !");
                  }

                  var4 = var3;
                  var2.add(var6);
                  if(var7 == 0) {
                     break label25;
                  }
               }

               if(var4 != null) {
                  var5 = true;
               }
            }

            var3 = this.a.c(var3);
            if(var7 == 0) {
               continue;
            }
         }

         var10000 = this;
         break;
      }

      var10000.a(var2);
   }

   void a(ArrayList var1) {
      int var6 = b.b;
      if(var1.size() != 0) {
         p var2 = this.a.k();
         Object var3 = var1.get(0);

         while(this.a.g(var2) != var3) {
            var2 = this.a.c(var2);
            if(var6 != 0) {
               break;
            }
         }

         int var4 = var1.size() - 1;

         label35:
         while(var4 >= 0) {
            if(!this.a.g(var2).equals(var1.get(var1.size() - 1 - var4))) {
               throw new RuntimeException("Cannot swap segments");
            }

            e var5 = (e)var1.get(var4);
            this.a.a((p)var2, (Object)var5);

            while(true) {
               var5.a(var2);
               var5 = var5.h;

               while(var5 == null) {
                  var2 = this.a.c(var2);
                  --var4;
                  if(var6 == 0) {
                     if(var6 != 0) {
                        return;
                     }
                     continue label35;
                  }
               }
            }
         }

      }
   }

   e b(e var1) {
      p var2 = this.a.c(var1.b);
      return var2 == null?null:(e)this.a.g(var2);
   }

   e c(e var1) {
      p var2 = this.a.d(var1.b);
      return var2 == null?null:(e)this.a.g(var2);
   }

   h(b var1, c var2) {
      this(var1);
   }
}
