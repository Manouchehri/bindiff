package y.f.i;

import y.f.i.am;
import y.f.i.ao;
import y.f.i.v;

class al extends ao {
   private int q;
   protected y.c.D a;
   public y.c.D b = new y.c.D();
   public y.c.D c = new y.c.D();
   protected boolean d;
   protected double e;
   protected double f;
   protected double g;
   protected double h;
   public y.c.D i;
   public y.c.D j;

   public al(double var1, double var3, double var5, double var7, boolean var9) {
      super(var1, var3, var5, var7, var9);
   }

   public void d(boolean var1) {
      this.d = var1;
   }

   public void a(double var1) {
      this.e = var1;
   }

   public void b(double var1) {
      this.f = var1;
   }

   public void a(y.c.D var1) {
      this.i = var1;
   }

   public void b(y.c.D var1) {
      this.j = var1;
   }

   public void c(double var1) {
      this.g = var1;
   }

   public void d(double var1) {
      this.h = var1;
   }

   public void a(int var1) {
      this.q = var1;
   }

   public boolean f() {
      return this.d;
   }

   public double g() {
      return this.e;
   }

   public double h() {
      return this.f;
   }

   public double i() {
      return this.g;
   }

   public double j() {
      return this.h;
   }

   public int k() {
      return this.q;
   }

   public y.c.D l() {
      return this.a;
   }

   public boolean m() {
      return this.a != null;
   }

   public void a(boolean var1, y.c.D var2) {
      if(var1) {
         this.b.a(var2);
         if(v.f == 0) {
            return;
         }
      }

      this.c.a(var2);
   }

   public void a(boolean var1, al var2) {
      if(var1) {
         this.b.add(var2);
         if(v.f == 0) {
            return;
         }
      }

      this.c.add(var2);
   }

   public void b(boolean var1, al var2) {
      int var5 = v.f;
      y.c.D var3 = var1?this.b:this.c;
      y.c.C var4 = var3.m();

      while(var4.f()) {
         if(var2 == var4.d()) {
            var3.b(var4);
            if(var5 == 0) {
               break;
            }
         }

         var4.g();
         if(var5 != 0) {
            break;
         }
      }

   }

   public void e(boolean var1) {
      y.c.D var2 = var1?this.b:this.c;
      var2.clear();
   }

   public void c(boolean var1, al var2) {
      int var9 = v.f;
      y.c.D var3 = var1?this.b:this.c;
      al var10000;
      y.c.C var4;
      al var5;
      y.c.D var6;
      if(var2 == null) {
         var4 = var3.m();

         do {
            if(!var4.f()) {
               return;
            }

            var10000 = (al)var4.d();

            label76:
            while(true) {
               var5 = var10000;
               var6 = var1?var5.c:var5.b;
               y.c.C var7 = var6.m();

               while(true) {
                  if(!var7.f()) {
                     break label76;
                  }

                  al var8 = (al)var7.d();
                  var10000 = this;
                  if(var9 != 0) {
                     break;
                  }

                  if(this == var8) {
                     var6.b(var7);
                  }

                  var7.g();
                  if(var9 != 0) {
                     break label76;
                  }
               }
            }

            var4.g();
         } while(var9 == 0);
      }

      var4 = var3.m();

      while(var4.f()) {
         var10000 = (al)var4.d();

         label56:
         while(true) {
            var5 = var10000;
            var6 = var1?var5.c:var5.b;
            y.c.p var10 = var6.k();

            while(true) {
               if(var10 == null) {
                  break label56;
               }

               var10000 = this;
               if(var9 != 0) {
                  break;
               }

               if(this == (al)var10.c()) {
                  var6.a((y.c.p)var10, (Object)var2);
               }

               var10 = var6.c(var10);
               if(var9 != 0) {
                  break label56;
               }
            }
         }

         var4.g();
         if(var9 != 0) {
            break;
         }
      }

   }

   public void a(y.c.d var1, double var2, byte var4, boolean var5) {
      int var11 = v.f;
      if(var2 >= this.t() && var2 <= this.u()) {
         am var6 = null;
         if(this.a == null) {
            this.a = new y.c.D();
            var6 = new am(var1, var2, var4, var5);
            this.a.add(var6);
         } else {
            boolean var7 = false;
            y.c.p var8 = this.a.k();

            boolean var10000;
            label34: {
               while(var8 != null) {
                  var10000 = var7;
                  if(var11 != 0) {
                     break label34;
                  }

                  if(var7) {
                     break;
                  }

                  double var9 = ((am)var8.c()).b;
                  if(var9 <= var2) {
                     var8 = this.a.c(var8);
                     if(var11 == 0) {
                        continue;
                     }
                  }

                  var6 = new am(var1, var2, var4, var5);
                  var8 = this.a.a((Object)var6, (y.c.p)var8);
                  var7 = true;
                  if(var11 != 0) {
                     break;
                  }
               }

               var10000 = var7;
            }

            if(!var10000) {
               var6 = new am(var1, var2, var4, var5);
               this.a.add(var6);
            }
         }

      }
   }

   public void a(am var1) {
      int var7 = v.f;
      if(var1.b >= this.t() && var1.b <= this.u()) {
         if(this.a == null) {
            this.a = new y.c.D();
            this.a.add(var1);
            if(var7 == 0) {
               return;
            }
         }

         boolean var2 = false;
         y.c.p var3 = this.a.k();

         boolean var10000;
         label46: {
            while(var3 != null) {
               var10000 = var2;
               if(var7 != 0) {
                  break label46;
               }

               if(var2) {
                  break;
               }

               double var4 = ((am)var3.c()).b;
               if(var4 < var1.b) {
                  var3 = this.a.c(var3);
                  if(var7 == 0) {
                     continue;
                  }
               }

               if(var4 > var1.b) {
                  var3 = this.a.a((Object)var1, (y.c.p)var3);
                  var2 = true;
                  if(var7 == 0) {
                     continue;
                  }
               }

               am var6 = (am)var3.c();
               if(var6.a == var1.a && var6.d == var1.d) {
                  var2 = true;
                  if(var7 == 0) {
                     continue;
                  }
               }

               var3 = this.a.c(var3);
               if(var7 != 0) {
                  break;
               }
            }

            var10000 = var2;
         }

         if(!var10000) {
            this.a.add(var1);
         }

      }
   }

   public void a(y.c.d var1, double var2, boolean var4) {
      int var8 = v.f;
      if(this.a != null) {
         boolean var5 = false;
         y.c.C var6 = this.a.m();

         while(var6.f() && !var5) {
            am var7 = (am)var6.d();
            if(var1 == var7.a && var2 == var7.b && var4 == var7.d) {
               this.a.b(var6);
               var5 = true;
            }

            var6.g();
            if(var8 != 0) {
               break;
            }
         }

      }
   }

   public void b(am var1) {
      int var5 = v.f;
      if(this.a != null) {
         boolean var2 = false;
         y.c.C var3 = this.a.m();

         while(var3.f() && !var2) {
            am var4 = (am)var3.d();
            if(var1 == var4) {
               this.a.b(var3);
               var2 = true;
            }

            var3.g();
            if(var5 != 0) {
               break;
            }
         }

      }
   }
}
