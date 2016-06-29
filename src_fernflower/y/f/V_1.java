package y.f;

import y.f.C;
import y.f.E;
import y.f.I;
import y.f.S;
import y.f.U;
import y.f.X;
import y.f.ad;
import y.f.ae;
import y.f.ah;
import y.f.aj;
import y.f.al;
import y.f.am;

public class V implements ad {
   private ah a;
   private y.c.h b;
   private y.c.A c;
   private boolean d = false;
   private boolean e = true;
   private boolean f = false;
   private boolean g = true;
   private boolean h = false;
   private boolean i = true;
   private boolean n = true;

   public void a(ah var1) {
      this.a = var1;
   }

   public ah a() {
      return this.a;
   }

   public void c(X var1) {
      if(this.a != null) {
         if(this.e() || this.d()) {
            this.a(var1);
         }

         this.a.c(var1);
         this.d(var1);
         this.b(var1);
      }

   }

   public boolean b() {
      return this.n;
   }

   private void a(X var1) {
      am var6;
      boolean var13;
      boolean var10000;
      Object var10001;
      X var22;
      label79: {
         var13 = X.j;
         y.c.c var2 = var1.c(U.a);
         if(var2 == null && this.e()) {
            this.b = var1.u();
            var1.a((Object)U.a, (y.c.c)this.b);
            y.c.e var3 = var1.p();

            label75:
            do {
               var10000 = var3.f();

               y.c.d var4;
               S[] var9;
               label72:
               while(true) {
                  if(!var10000) {
                     break label75;
                  }

                  var4 = var3.a();
                  am var5 = var1.a((Object)var4.c());
                  var6 = var1.a((Object)var4.d());
                  I var7 = var1.b(var4);
                  var22 = var1;
                  var10001 = var4;
                  if(var13) {
                     break label79;
                  }

                  C[] var8 = var1.d(var4);
                  var9 = new S[var8.length];
                  int var10 = 0;

                  while(true) {
                     if(var10 >= var8.length) {
                        break label72;
                     }

                     y.d.n var11 = var8[var10].getLabelModel().a(var8[var10].getOrientedBox().d(), var7, var5, var6, var8[var10].getModelParameter());
                     var10000 = this.i;
                     if(var13) {
                        break;
                     }

                     if(var10000) {
                        y.d.t var12 = var11.k();
                        var11.c(0.0D, -1.0D);
                        var11.b(var12);
                     }

                     var9[var10] = new S(var11.f(-(var5.getX() + var5.getWidth() * 0.5D), -(var5.getY() + var5.getHeight() * 0.5D)), var8[var10].getPreferredPlacementDescriptor());
                     ++var10;
                     if(var13) {
                        break label72;
                     }
                  }
               }

               this.b.a(var4, var9);
               var3.g();
            } while(!var13);
         }

         var22 = var1;
         var10001 = U.b;
      }

      y.c.c var14 = var22.c(var10001);
      if(var14 == null && this.d()) {
         this.c = var1.t();
         var1.a((Object)U.b, (y.c.c)this.c);
         y.c.x var15 = var1.o();

         do {
            var10000 = var15.f();

            y.c.q var16;
            S[] var18;
            label47:
            while(true) {
               if(!var10000) {
                  return;
               }

               var16 = var15.e();
               var6 = var1.a((Object)var16);
               aj[] var17 = var1.a_(var16);
               var18 = new S[var17.length];
               int var19 = 0;

               while(true) {
                  if(var19 >= var17.length) {
                     break label47;
                  }

                  y.d.n var20 = var17[var19].a().a(var17[var19].getOrientedBox().d(), var6, var17[var19].getModelParameter());
                  var10000 = this.h;
                  if(var13) {
                     break;
                  }

                  if(var10000) {
                     y.d.t var21 = var20.k();
                     var20.c(0.0D, -1.0D);
                     var20.b(var21);
                  }

                  var18[var19] = new S(var20.f(-(var6.getX() + var6.getWidth() * 0.5D), -(var6.getY() + var6.getHeight() * 0.5D)));
                  ++var19;
                  if(var13) {
                     break label47;
                  }
               }
            }

            this.c.a(var16, var18);
            var15.g();
         } while(!var13);
      }

   }

   private void b(X var1) {
      if(this.b != null) {
         var1.d_(U.a);
         var1.a((y.c.h)this.b);
         this.b = null;
      }

      if(this.c != null) {
         var1.d_(U.b);
         var1.a((y.c.A)this.c);
         this.c = null;
      }

   }

   private void d(X param1) {
      // $FF: Couldn't be decompiled
   }

   private void a(X var1, y.c.d var2, C var3, S var4) {
      E var5 = var3.getLabelModel();
      y.d.n var6 = var4.a();
      if(this.b()) {
         ae.b(var6);
      }

      var3.setModelParameter(var5.a(var6, var1.b(var2), var1.a((Object)var2.c()), var1.a((Object)var2.d())));
   }

   private void a(X var1, y.c.q var2, aj var3, S var4) {
      al var5 = var3.a();
      var3.setModelParameter(var5.a(var4.a(), var1.a((Object)var2)));
   }

   public boolean c() {
      return this.g;
   }

   public void a(boolean var1) {
      this.g = var1;
   }

   public void b(boolean var1) {
      this.f = var1;
   }

   public boolean d() {
      return this.d;
   }

   public void c(boolean var1) {
      this.d = var1;
   }

   public boolean e() {
      return this.e;
   }

   public void d(boolean var1) {
      this.e = var1;
   }
}
