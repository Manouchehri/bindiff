package y.a;

import y.a.f;
import y.a.h;

public class e {
   private y.c.h a;
   private int f;
   private int g;
   private boolean h = true;
   private boolean i = false;
   protected y.c.A b;
   protected static final Object c = null;
   protected static final Object d = new Object();
   protected static final Object e = new Object();
   private final byte[] j = new byte[1];

   public void a(boolean var1) {
      this.i = var1;
   }

   public void b(boolean var1) {
      this.h = var1;
   }

   public void a(y.c.i var1) {
      if(var1.f() != 0) {
         this.a(var1, var1.k());
      }
   }

   public void a(y.c.i var1, y.c.q var2) {
      boolean var9 = h.a;
      if(var2 != null) {
         this.b = var1.t();
         if(!this.i) {
            this.a = var1.u();
         }

         this.f = 0;
         this.g = 0;
         int var3 = Math.min(60, var1.e() + 3);
         f var4 = new f(var3);

         try {
            this.a(var4, var2);
            if(this.h) {
               y.c.x var5 = var1.o();

               while(var5.f()) {
                  y.c.q var6 = var5.e();
                  if(this.b.b(var6) == null) {
                     this.a(var6);
                     this.a(var4, var6);
                  }

                  var5.g();
                  if(var9) {
                     break;
                  }
               }
            }
         } finally {
            var4 = null;
            var1.a(this.b);
            this.b = null;
            if(!this.i) {
               var1.a(this.a);
               this.a = null;
            }

         }

      }
   }

   private final y.c.d a(y.c.q var1, y.c.d var2, byte[] var3) {
      y.c.d var4;
      switch(var3[0]) {
      case 0:
         if(this.i) {
            var3[0] = 1;
            return var1.f();
         } else {
            var4 = var1.f();
            if(var4 == null) {
               var4 = var1.g();
               var3[0] = 3;
               return var4;
            }

            var3[0] = 2;
            return var4;
         }
      case 1:
         return var2.g();
      case 2:
         var4 = var2.g();
         if(var4 == null) {
            var4 = var1.g();
            var3[0] = 3;
         }

         return var4;
      case 3:
         return var2.h();
      default:
         throw new InternalError();
      }
   }

   private final void a(f var1, y.c.q var2) {
      boolean var7 = h.a;
      this.j[0] = 0;
      y.c.q var3 = var2;
      this.b.a(var2, d);
      this.a(var2, ++this.f);
      y.c.d var4 = this.a(var2, (y.c.d)null, this.j);
      var1.a(var2, var4, this.j[0], this.f);

      while(!var1.a()) {
         var4 = var1.d();
         this.j[0] = var1.e();

         boolean var10000;
         while(true) {
            if(var4 != null) {
               var10000 = this.i;
               if(var7) {
                  break;
               }

               if(var10000 || !this.a.d(var4)) {
                  y.c.q var5;
                  label41: {
                     if(!this.i) {
                        this.a.a(var4, true);
                        var5 = var4.a(var3);
                        if(!var7) {
                           break label41;
                        }
                     }

                     var5 = var4.d();
                  }

                  if(this.b.b(var5) == null) {
                     this.a(var4, var5, true);
                     this.b.a(var5, d);
                     var3 = var5;
                     this.a(var5, ++this.f);
                     this.j[0] = 0;
                     var4 = this.a(var5, (y.c.d)null, this.j);
                     var1.a(var5, var4, this.j[0], this.f);
                     if(!var7) {
                        continue;
                     }
                  }

                  this.a(var4, var5, false);
                  var4 = this.a(var3, var4, this.j);
                  var1.a(var4, this.j[0]);
                  if(!var7) {
                     continue;
                  }
               }

               var4 = this.a(var3, var4, this.j);
               var1.a(var4, this.j[0]);
               if(!var7) {
                  continue;
               }
            }

            this.a(var3, var1.f(), ++this.g);
            this.b.a(var3, e);
            var1.b();
            var10000 = var1.a();
            break;
         }

         if(!var10000) {
            y.c.d var8 = var1.d();
            this.a(var8, var3);
            var3 = var1.c();
            this.j[0] = var1.e();
            y.c.d var6 = this.a(var3, var8, this.j);
            var1.a(var6, this.j[0]);
            if(var7) {
               break;
            }
         }
      }

   }

   protected void a(y.c.q var1, int var2) {
   }

   protected void a(y.c.q var1, int var2, int var3) {
   }

   protected void a(y.c.d var1, y.c.q var2, boolean var3) {
   }

   protected void a(y.c.d var1, y.c.q var2) {
   }

   protected void a(y.c.q var1) {
   }
}
