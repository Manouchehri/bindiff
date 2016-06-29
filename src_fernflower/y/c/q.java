package y.c;

import java.util.Comparator;
import y.c.D;
import y.c.I;
import y.c.d;
import y.c.e;
import y.c.i;
import y.c.r;
import y.c.s;
import y.c.t;
import y.c.u;
import y.c.v;
import y.c.w;
import y.c.x;

public class q extends I {
   i a;
   d b;
   d c;
   d d;
   d e;
   int f;
   int g;
   int h;

   protected q(i var1) {
      var1.g(this);
   }

   public q a(i var1) {
      return var1.d();
   }

   public int a() {
      return this.f + this.g;
   }

   public int b() {
      return this.g;
   }

   public int c() {
      return this.f;
   }

   public int d() {
      if(this.a.e) {
         this.a.A();
      }

      return this.h;
   }

   public i e() {
      return this.a;
   }

   public d f() {
      return this.c;
   }

   public d g() {
      return this.b;
   }

   public d h() {
      return this.d;
   }

   public d i() {
      return this.e;
   }

   public e j() {
      return new u(this);
   }

   public e k() {
      return new s(this);
   }

   public e l() {
      return new v(this);
   }

   public e a(d var1) {
      return new v(this, var1);
   }

   public x m() {
      return new r(this);
   }

   public x n() {
      return new w(this);
   }

   public x o() {
      return new t(this);
   }

   public d a(q var1) {
      boolean var3 = D.e;
      if(var1.g < this.f) {
         return var1.b(this);
      } else {
         d var2 = this.c;

         while(var2 != null) {
            if(var2.f == var1) {
               return var2;
            }

            var2 = var2.a;
            if(var3) {
               break;
            }
         }

         return null;
      }
   }

   public d b(q var1) {
      boolean var3 = D.e;
      if(var1.f < this.g) {
         return var1.a(this);
      } else {
         d var2 = this.b;

         while(var2 != null) {
            if(var2.e == var1) {
               return var2;
            }

            var2 = var2.b;
            if(var3) {
               break;
            }
         }

         return null;
      }
   }

   public d c(q var1) {
      d var2 = this.a(var1);
      if(var2 == null) {
         var2 = this.b(var1);
      }

      return var2;
   }

   public void a(Comparator var1) {
      if(this.g > 1) {
         if(this.g > 2 || var1 == null) {
            this.b(var1, new d[this.g]);
            if(!D.e) {
               return;
            }
         }

         this.b(var1, (d[])null);
      }

   }

   public void b(Comparator var1) {
      if(this.f > 1) {
         if(this.f > 2 || var1 == null) {
            this.a(var1, new d[this.f]);
            if(!D.e) {
               return;
            }
         }

         this.a(var1, (d[])null);
      }

   }

   public String toString() {
      return this.e() != null?"node index:" + this.d():"node without a graph";
   }

   void a(i var1, int var2) {
      this.a(var2);
      this.a = var1;
   }

   void b(i var1) {
      this.a = var1;
   }

   void b(d var1) {
      label11: {
         var1.c = this.d;
         var1.a = null;
         if(this.d != null) {
            this.d.a = var1;
            if(!D.e) {
               break label11;
            }
         }

         this.c = var1;
      }

      this.d = var1;
      ++this.f;
   }

   void c(d var1) {
      label11: {
         var1.a = this.c;
         var1.c = null;
         if(this.c != null) {
            this.c.c = var1;
            if(!D.e) {
               break label11;
            }
         }

         this.d = var1;
      }

      this.c = var1;
      ++this.f;
   }

   void a(d var1, d var2, int var3) {
      boolean var5 = D.e;
      d var4;
      if(var3 == 0) {
         if(var2 == null) {
            this.b(var1);
            if(!var5) {
               return;
            }
         }

         if(var2 == this.d) {
            this.b(var1);
            if(!var5) {
               return;
            }
         }

         label43: {
            if(this.d == null) {
               var1.c = null;
               var1.a = null;
               this.c = this.d = var1;
               if(!var5) {
                  break label43;
               }
            }

            var4 = var2.a;
            var2.a = var1;
            var1.a = var4;
            var4.c = var1;
            var1.c = var2;
         }

         ++this.f;
         if(!var5) {
            return;
         }
      }

      if(var2 == null) {
         this.b(var1);
         if(!var5) {
            return;
         }
      }

      if(var2 == this.c) {
         this.c(var1);
         if(!var5) {
            return;
         }
      }

      label25: {
         if(this.d == null) {
            var1.c = null;
            var1.a = null;
            this.c = this.d = var1;
            if(!var5) {
               break label25;
            }
         }

         var4 = var2.c;
         var2.c = var1;
         var1.c = var4;
         var4.a = var1;
         var1.a = var2;
      }

      ++this.f;
   }

   void d(d var1) {
      label11: {
         var1.d = this.e;
         var1.b = null;
         if(this.e != null) {
            this.e.b = var1;
            if(!D.e) {
               break label11;
            }
         }

         this.b = var1;
      }

      this.e = var1;
      ++this.g;
   }

   void e(d var1) {
      label11: {
         var1.b = this.b;
         var1.d = null;
         if(this.b != null) {
            this.b.d = var1;
            if(!D.e) {
               break label11;
            }
         }

         this.e = var1;
      }

      this.b = var1;
      ++this.g;
   }

   void b(d var1, d var2, int var3) {
      boolean var5 = D.e;
      d var4;
      if(var3 == 0) {
         if(var2 == null) {
            this.d(var1);
            if(!var5) {
               return;
            }
         }

         if(var2 == this.e) {
            this.d(var1);
            if(!var5) {
               return;
            }
         }

         label43: {
            if(this.e == null) {
               var1.d = null;
               var1.b = null;
               this.b = this.e = var1;
               if(!var5) {
                  break label43;
               }
            }

            var4 = var2.b;
            var2.b = var1;
            var1.b = var4;
            var4.d = var1;
            var1.d = var2;
         }

         ++this.g;
         if(!var5) {
            return;
         }
      }

      if(var2 == null) {
         this.d(var1);
         if(!var5) {
            return;
         }
      }

      if(var2 == this.b) {
         this.e(var1);
         if(!var5) {
            return;
         }
      }

      label25: {
         if(this.e == null) {
            var1.d = null;
            var1.b = null;
            this.b = this.e = var1;
            if(!var5) {
               break label25;
            }
         }

         var4 = var2.d;
         var2.d = var1;
         var1.d = var4;
         var4.b = var1;
         var1.b = var2;
      }

      ++this.g;
   }

   void f(d var1) {
      boolean var2;
      label19: {
         var2 = D.e;
         if(var1 != this.c) {
            var1.c.a = var1.a;
            if(!var2) {
               break label19;
            }
         }

         this.c = var1.a;
      }

      label14: {
         if(var1 != this.d) {
            var1.a.c = var1.c;
            if(!var2) {
               break label14;
            }
         }

         this.d = var1.c;
      }

      --this.f;
   }

   void g(d var1) {
      boolean var2;
      label19: {
         var2 = D.e;
         if(var1 != this.b) {
            var1.d.b = var1.b;
            if(!var2) {
               break label19;
            }
         }

         this.b = var1.b;
      }

      label14: {
         if(var1 != this.e) {
            var1.b.d = var1.d;
            if(!var2) {
               break label14;
            }
         }

         this.e = var1.d;
      }

      --this.g;
   }

   void p() {
      this.c = this.b = this.e = this.d = null;
      this.f = this.g = 0;
   }

   void a(Comparator var1, d[] var2) {
      boolean var7 = D.e;
      if(this.f >= 2) {
         if(this.f == 2 && var1 != null) {
            if(var1.compare(this.c, this.d) > 0) {
               this.d = this.c;
               this.c = this.d.a;
               this.d.c = this.c;
               this.c.a = this.d;
               this.d.a = this.c.c = null;
            }

         } else {
            int var6 = this.f;
            int var5 = 0;
            d var3 = this.c;

            while(true) {
               if(var3 != null) {
                  var2[var5] = var3;
                  ++var5;
                  var3 = var3.a;
                  if(var7) {
                     break;
                  }

                  if(!var7) {
                     continue;
                  }
               }

               y.g.e.a(var2, 0, var6, var1);
               break;
            }

            d var4 = this.c = var2[0];
            var4.c = null;
            var5 = 1;

            while(true) {
               if(var5 < var6) {
                  var3 = var2[var5];
                  var3.c = var4;
                  var4.a = var3;
                  ++var5;
                  var4 = var3;
                  if(var7) {
                     break;
                  }

                  if(!var7) {
                     continue;
                  }
               }

               this.d = var3;
               var3.a = null;
               break;
            }

         }
      }
   }

   void b(Comparator var1, d[] var2) {
      boolean var7 = D.e;
      if(this.g >= 2) {
         if(this.g == 2 && var1 != null) {
            if(var1.compare(this.b, this.e) > 0) {
               this.e = this.b;
               this.b = this.e.b;
               this.e.d = this.b;
               this.b.b = this.e;
               this.e.b = this.b.d = null;
            }

         } else {
            int var6 = this.g;
            int var5 = 0;
            d var3 = this.b;

            while(true) {
               if(var3 != null) {
                  var2[var5] = var3;
                  ++var5;
                  var3 = var3.b;
                  if(var7) {
                     break;
                  }

                  if(!var7) {
                     continue;
                  }
               }

               y.g.e.a(var2, 0, var6, var1);
               break;
            }

            d var4 = this.b = var2[0];
            var4.d = null;
            var5 = 1;

            while(true) {
               if(var5 < var6) {
                  var3 = var2[var5];
                  var3.d = var4;
                  var4.b = var3;
                  ++var5;
                  var4 = var3;
                  if(var7) {
                     break;
                  }

                  if(!var7) {
                     continue;
                  }
               }

               this.e = var3;
               var3.b = null;
               break;
            }

         }
      }
   }
}
