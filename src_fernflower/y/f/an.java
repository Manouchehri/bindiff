package y.f;

import y.f.I;
import y.f.S;
import y.f.U;
import y.f.X;
import y.f.a;
import y.f.aF;
import y.f.aG;
import y.f.ah;
import y.f.am;
import y.f.ao;
import y.f.ap;
import y.f.aq;
import y.f.ar;
import y.f.c.a.bk;

public class an extends a {
   y.c.c a;
   y.c.c b;
   y.c.c c;
   y.c.c d;
   private y.c.b e;
   private y.c.b f;
   private byte g;
   private int h;
   private boolean i;

   public an(ah var1) {
      this();
      this.a((ah)var1);
      this.a((byte)0);
   }

   public an() {
      this.e = null;
      this.f = null;
      this.h = 4;
      this.i = true;
   }

   public an(byte var1) {
      this.e = null;
      this.f = null;
      this.h = 4;
      this.i = true;
      this.a(var1);
   }

   public void a(byte var1) {
      this.g = var1;
   }

   public byte b() {
      return this.g;
   }

   public int c() {
      return this.h;
   }

   public void a(int var1) {
      this.h = var1;
   }

   public boolean d() {
      return this.g == 1 || this.g == 3;
   }

   public boolean e() {
      return this.i;
   }

   public void a(boolean var1) {
      this.i = var1;
   }

   public void c(X var1) {
      var1.a((Object)"PARTITION_ORIENTATION_DPKEY", (y.c.c)y.g.q.a((Object)this));
      ao var2 = new ao(this);
      bk var3 = bk.c(var1);
      if(var3 != null) {
         var3.b(this, var2);
      }

      this.e = y.g.M.c();
      this.f = y.g.M.c();
      this.b(var1);
      if(this.a() != null) {
         this.a((X)var1);
      }

      this.d(var1);
      this.e = null;
      this.f = null;
      if(var3 != null) {
         var3.a(this, var2);
      }

      var1.d_("PARTITION_ORIENTATION_DPKEY");
   }

   public boolean b(byte var1) {
      boolean var3 = X.j;
      boolean var2 = false;
      switch(var1) {
      case 0:
         var2 = (1 & this.h) != 0;
         if(!var3) {
            break;
         }
      case 3:
         var2 = (2 & this.h) != 0;
         if(!var3) {
            break;
         }
      case 2:
         var2 = (4 & this.h) != 0;
         if(!var3) {
            break;
         }
      case 1:
         var2 = (8 & this.h) != 0;
         if(!var3) {
            break;
         }
      default:
         var2 = false;
      }

      return var2;
   }

   protected void b(X var1) {
      this.i(var1);
      this.l(var1);
      this.o(var1);
      this.p(var1);
      this.g(var1);
      this.e(var1);
   }

   private void e(X var1) {
      y.c.c var2 = var1.c(y.f.b.f.f);
      if(var2 != null) {
         ar var3 = new ar(this, var2);
         var1.a((Object)y.f.b.f.f, (y.c.c)var3);
      }

   }

   private void f(X var1) {
      y.c.c var2 = var1.c(y.f.b.f.f);
      if(var2 != null) {
         var2 = ((ar)var2).a;
         var1.d_(y.f.b.f.f);
         var1.a((Object)y.f.b.f.f, (y.c.c)var2);
      }

   }

   private void g(X var1) {
      y.c.c var2 = var1.c(y.f.b.f.e);
      if(y.f.b.c.b((y.c.i)var1) && var2 != null) {
         ap var3 = new ap(this, var2);
         var1.a((Object)y.f.b.f.e, (y.c.c)var3);
      }

   }

   private void h(X var1) {
      y.c.c var2 = var1.c(y.f.b.f.e);
      if(y.f.b.c.b((y.c.i)var1) && var2 instanceof ap) {
         var2 = ((ap)var2).a;
         var1.d_(y.f.b.f.e);
         var1.a((Object)y.f.b.f.e, (y.c.c)var2);
      }

   }

   private void i(X var1) {
      boolean var5 = X.j;
      y.c.x var2 = var1.o();

      while(var2.f()) {
         y.d.t var3 = var1.l(var2.e());
         if(this.d()) {
            am var4 = var1.h(var2.e());
            var4.setSize(var4.getHeight(), var4.getWidth());
         }

         var1.a(var2.e(), this.a(var3));
         var2.g();
         if(var5) {
            break;
         }
      }

   }

   protected void d(X var1) {
      this.j(var1);
      this.k(var1);
      this.m(var1);
      this.n(var1);
      this.h(var1);
      this.f(var1);
   }

   private void j(X var1) {
      boolean var5 = X.j;
      y.c.x var2 = var1.o();

      while(var2.f()) {
         y.d.t var3 = var1.l(var2.e());
         if(this.d()) {
            am var4 = var1.h(var2.e());
            var4.setSize(var4.getHeight(), var4.getWidth());
         }

         var1.a(var2.e(), this.b(var3));
         var2.g();
         if(var5) {
            break;
         }
      }

   }

   private void k(X var1) {
      boolean var6 = X.j;
      y.c.e var2 = var1.p();

      while(var2.f()) {
         I var3 = var1.b(var2.a());
         y.d.t var4 = var3.getSourcePoint();
         var3.setSourcePoint(this.b(var4));
         var4 = var3.getTargetPoint();
         var3.setTargetPoint(this.b(var4));
         int var5 = 0;

         while(true) {
            if(var5 < var3.pointCount()) {
               var4 = this.b(var3.getPoint(var5));
               var3.setPoint(var5, var4.a(), var4.b());
               ++var5;
               if(var6) {
                  break;
               }

               if(!var6) {
                  continue;
               }
            }

            var2.g();
            break;
         }

         if(var6) {
            break;
         }
      }

   }

   private void l(X var1) {
      boolean var6 = X.j;
      y.c.e var2 = var1.p();

      while(var2.f()) {
         I var3 = var1.b(var2.a());
         y.d.t var4 = var3.getSourcePoint();
         var3.setSourcePoint(this.a(var4));
         var4 = var3.getTargetPoint();
         var3.setTargetPoint(this.a(var4));
         int var5 = 0;

         while(true) {
            if(var5 < var3.pointCount()) {
               var4 = this.a(var3.getPoint(var5));
               var3.setPoint(var5, var4.a(), var4.b());
               ++var5;
               if(var6) {
                  break;
               }

               if(!var6) {
                  continue;
               }
            }

            var2.g();
            break;
         }

         if(var6) {
            break;
         }
      }

   }

   protected y.d.t a(y.d.t var1, boolean var2) {
      return var2?this.a(var1):this.b(var1);
   }

   protected y.d.t a(y.d.t var1) {
      if(this.b(this.g)) {
         switch(this.g) {
         case 0:
            return new y.d.t(-var1.a, var1.b);
         case 1:
            return new y.d.t(var1.b(), var1.a());
         case 2:
            return new y.d.t(var1.a(), -var1.b());
         case 3:
            return new y.d.t(-var1.b(), -var1.a());
         default:
            if(!X.j) {
               return var1;
            }
         }
      }

      switch(this.g) {
      case 0:
         return var1;
      case 1:
         return new y.d.t(-var1.b(), var1.a());
      case 2:
         return new y.d.t(-var1.a(), -var1.b());
      case 3:
         return new y.d.t(var1.b(), -var1.a());
      default:
         return var1;
      }
   }

   protected y.d.t b(y.d.t var1) {
      if(this.b(this.g)) {
         switch(this.g) {
         case 0:
            return new y.d.t(-var1.a, var1.b);
         case 1:
            return new y.d.t(var1.b(), var1.a());
         case 2:
            return new y.d.t(var1.a(), -var1.b());
         case 3:
            return new y.d.t(-var1.b(), -var1.a());
         default:
            if(!X.j) {
               return var1;
            }
         }
      }

      switch(this.g) {
      case 0:
         return var1;
      case 1:
         return new y.d.t(var1.b(), -var1.a());
      case 2:
         return new y.d.t(-var1.a(), -var1.b());
      case 3:
         return new y.d.t(-var1.b(), var1.a());
      default:
         return var1;
      }
   }

   private void m(X var1) {
      if(this.a != null) {
         var1.a((Object)aF.a, (y.c.c)this.a);
         this.a = null;
         this.c = null;
      }

      if(this.b != null) {
         var1.a((Object)aF.b, (y.c.c)this.b);
         this.b = null;
         this.d = null;
      }

   }

   private void n(X var1) {
      this.a(var1, false);
   }

   private void o(X var1) {
      this.a = var1.c(aF.a);
      if(this.a != null) {
         this.c = new aq(this, this.a);
         var1.a((Object)aF.a, (y.c.c)this.c);
      }

      this.b = var1.c(aF.b);
      if(this.b != null) {
         this.d = new aq(this, this.b);
         var1.a((Object)aF.b, (y.c.c)this.d);
      }

   }

   private void p(X var1) {
      this.a(var1, true);
   }

   private void a(X var1, boolean var2) {
      this.c(var1, var2);
      if(this.e()) {
         this.b(var1, var2);
      }

   }

   private void b(X var1, boolean var2) {
      boolean var8 = X.j;
      y.c.c var3 = var1.c(U.a);
      if(var3 != null) {
         y.c.e var4 = var1.p();

         while(var4.f()) {
            label30: {
               S[] var5 = (S[])var3.b(var4.a());
               if(var5 != null && var5.length > 0) {
                  int var6 = 0;

                  while(var6 < var5.length) {
                     S var7 = var5[var6];
                     this.b(var7, var2);
                     ++var6;
                     if(var8) {
                        break label30;
                     }

                     if(var8) {
                        break;
                     }
                  }
               }

               var4.g();
            }

            if(var8) {
               break;
            }
         }
      }

   }

   private void c(X var1, boolean var2) {
      boolean var8 = X.j;
      y.c.c var3 = var1.c(U.b);
      if(var3 != null) {
         y.c.x var4 = var1.o();

         while(var4.f()) {
            label30: {
               S[] var5 = (S[])var3.b(var4.e());
               if(var5 != null && var5.length > 0) {
                  int var6 = 0;

                  while(var6 < var5.length) {
                     S var7 = var5[var6];
                     this.a(var7, var2);
                     ++var6;
                     if(var8) {
                        break label30;
                     }

                     if(var8) {
                        break;
                     }
                  }
               }

               var4.g();
            }

            if(var8) {
               break;
            }
         }
      }

   }

   private void a(S var1, boolean var2) {
      y.d.t var3 = this.a(new y.d.t(var1.d() + var1.b() / 2.0D, var1.e() + var1.c() / 2.0D), var2);
      y.d.t var4 = this.a(new y.d.t(var1.a().g(), var1.a().i()), var2);
      var1.a().c(var4.a, var4.b);
      double var5 = var3.a() - var1.b() / 2.0D;
      double var7 = var3.b() - var1.c() / 2.0D;
      var1.a(var5, var7);
   }

   private void b(S var1, boolean var2) {
      y.d.t var3 = this.a(new y.d.t(var1.d() + var1.b() / 2.0D, var1.e() + var1.c() / 2.0D), var2);
      y.d.t var4 = this.a(new y.d.t(var1.a().g(), var1.a().i()), var2);
      var1.a().c(var4.a, var4.b);
      double var5 = var3.a() - var1.b() / 2.0D;
      double var7 = var3.b() - var1.c() / 2.0D;
      var1.a(var5, var7);
      boolean var9 = this.b(this.g);
      if(var9) {
         aG var10;
         if(var2) {
            var10 = var1.f();
            byte var11 = 0;
            if(var10.m()) {
               var11 = (byte)(var11 | 8);
            }

            if(var10.l()) {
               var11 = (byte)(var11 | 32);
            }

            if(var10.n()) {
               var11 = (byte)(var11 | 16);
            }

            if(var10.b() == var11) {
               return;
            }

            this.e.a(var1, var10);
            aG var12 = (aG)this.f.b(var10);
            if(var12 == null) {
               var12 = new aG(var10);
               var12.b(var11);
               this.f.a(var10, var12);
            }

            var1.a(var12);
            if(!X.j) {
               return;
            }
         }

         var10 = (aG)this.e.b(var1);
         if(var10 != null) {
            var1.a(var10);
         }
      }

   }

   public y.d.r a(y.d.r var1) {
      if(this.b(this.g)) {
         switch(this.g) {
         case 1:
            return new y.d.r(var1.b, var1.a, var1.d, var1.c);
         case 2:
            return new y.d.r(var1.c, var1.b, var1.a, var1.d);
         case 3:
            return new y.d.r(var1.d, var1.c, var1.b, var1.a);
         default:
            return new y.d.r(var1.a, var1.d, var1.c, var1.b);
         }
      } else {
         switch(this.g) {
         case 1:
            return new y.d.r(var1.b, var1.c, var1.d, var1.a);
         case 2:
            return new y.d.r(var1.c, var1.d, var1.a, var1.b);
         case 3:
            return new y.d.r(var1.d, var1.a, var1.b, var1.c);
         default:
            return var1;
         }
      }
   }

   public y.d.q a(y.d.q var1) {
      switch(this.g) {
      case 1:
      case 3:
         return new y.d.q(var1.b(), var1.a());
      case 2:
      default:
         return new y.d.q(var1.a(), var1.b());
      }
   }
}
