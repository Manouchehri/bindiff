package y.f.i;

import y.f.i.v;

public class ac extends y.f.a {
   public void c(y.f.X var1) {
      int var10 = v.f;
      y.c.x var2 = var1.o();

      while(var2.f()) {
         y.c.q var3 = var2.e();
         y.c.q var10000 = var3;

         label55:
         while(true) {
            y.c.e var4 = var10000.j();

            while(true) {
               if(!var4.f()) {
                  break label55;
               }

               y.c.d var5 = var4.a();
               y.c.D var6 = var1.m(var5);
               var10000 = var5.c();
               if(var10 != 0) {
                  break;
               }

               y.c.p var7;
               y.d.t var8;
               y.f.am var9;
               if(var10000 == var3) {
                  var7 = var6.b(0);
                  var8 = (y.d.t)var7.c();
                  var9 = var1.a((Object)var3);
                  if(var8.b() < var9.getY() || var8.b() > var9.getY() + var9.getHeight() || var8.a() < var9.getX() || var8.a() > var9.getX() + var9.getWidth()) {
                     this.a(var9, var7);
                  }
               }

               if(var5.d() == var3) {
                  var7 = var6.b(var6.size() - 1);
                  var8 = (y.d.t)var7.c();
                  var9 = var1.a((Object)var3);
                  if(var8.b() < var9.getY() || var8.b() > var9.getY() + var9.getHeight() || var8.a() < var9.getX() || var8.a() > var9.getX() + var9.getWidth()) {
                     this.a(var9, var7);
                  }
               }

               var1.a(var5, var6);
               var4.g();
               if(var10 != 0) {
                  break label55;
               }
            }
         }

         var2.g();
         if(var10 != 0) {
            break;
         }
      }

   }

   private void a(y.f.am var1, y.c.p var2) {
      y.d.t var3 = (y.d.t)var2.c();
      if(var3.b() < var1.getY()) {
         var3 = new y.d.t(var3.a, var1.getY());
         var2.a(var3);
      }

      if(var3.a() < var1.getX()) {
         var3 = new y.d.t(var1.getX(), var3.b);
         var2.a(var3);
      }

      if(var3.b() > var1.getY() + var1.getHeight()) {
         var3 = new y.d.t(var3.a, var1.getY() + var1.getHeight());
         var2.a(var3);
      }

      if(var3.a() > var1.getX() + var1.getWidth()) {
         var3 = new y.d.t(var1.getX() + var1.getWidth(), var3.b);
         var2.a(var3);
      }

   }
}
