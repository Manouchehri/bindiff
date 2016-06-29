package y.h;

import java.util.HashMap;
import java.util.Iterator;
import y.h.aZ;
import y.h.bu;
import y.h.eU;
import y.h.fO;
import y.h.ff;
import y.h.fg;
import y.h.fh;
import y.h.fj;

final class fi extends y.f.a {
   private final ff a;

   private fi(ff var1) {
      this.a = var1;
   }

   public void c(y.f.X var1) {
      this.a(var1);
      if(this.a.a()) {
         this.b(var1);
         if(!fj.z) {
            return;
         }
      }

      this.d(var1);
   }

   private void b(y.f.X var1) {
      boolean var17 = fj.z;
      Object var2 = ff.a;
      y.c.c var3 = var1.c(var2);
      var2 = y.f.aF.a;
      y.c.c var4 = var1.c(var2);
      var2 = y.f.aF.b;
      y.c.c var5 = var1.c(var2);
      if(var3 != null && var1.h() > 0) {
         bu var6 = (bu)((y.c.d)var3.b(var1.l())).a();
         aZ var7 = new aZ(ff.e());
         eU var8 = var7.getPort(0);
         y.c.e var9 = var1.p();

         while(var9.f()) {
            y.c.d var10 = var9.a();
            y.c.d var11 = (y.c.d)var3.b(var10);
            eU var12 = eU.a(var6, var11, true);
            if(var12 != null && ff.a(var4, var10)) {
               y.f.am var13 = var1.a((Object)var10.c());
               var7.setFrame(var13.getX(), var13.getY(), var13.getWidth(), var13.getHeight());
               var8.a(var12.g());
               y.d.t var14 = eU.b(var8);
               y.f.I var15 = var1.b(var10);
               if(!var14.equals(var15.getSourcePoint())) {
                  var15.setSourcePoint(var14);
               }
            }

            eU var18 = eU.a(var6, var11, false);
            if(var18 != null && ff.a(var5, var10)) {
               y.f.am var19 = var1.a((Object)var10.d());
               var7.setFrame(var19.getX(), var19.getY(), var19.getWidth(), var19.getHeight());
               var8.a(var18.g());
               y.d.t var20 = eU.b(var8);
               y.f.I var16 = var1.b(var10);
               if(!var20.equals(var16.getTargetPoint())) {
                  var16.setTargetPoint(var20);
               }
            }

            var9.g();
            if(var17) {
               break;
            }
         }
      }

   }

   private void d(y.f.X var1) {
      boolean var16 = fj.z;
      Object var2 = ff.a;
      y.c.c var3 = var1.c(var2);
      if(var3 != null && var1.h() > 0) {
         bu var4 = (bu)((y.c.d)var3.b(var1.l())).a();
         aZ var5 = new aZ(ff.e());
         eU var6 = var5.getPort(0);
         HashMap var7 = new HashMap();
         y.c.e var8 = var1.p();

         while(var8.f()) {
            y.c.d var9 = var8.a();
            y.c.d var10 = (y.c.d)var3.b(var9);
            eU var11 = eU.a(var4, var10, true);
            if(var16) {
               return;
            }

            if(var11 != null) {
               fh var12 = (fh)var7.get(var11);
               if(var12 == null) {
                  var12 = new fh();
                  var7.put(var11, var12);
               }

               if(var12.c() || var12.d() && !var9.e()) {
                  y.f.am var13 = var1.a((Object)var9.c());
                  var5.setFrame(var13.getX(), var13.getY(), var13.getWidth(), var13.getHeight());
                  fO var14 = var11.g().a();
                  var6.a(var14.a((fj)var5, (y.d.t)var1.p(var9)));
                  var12.a(eU.b(var6));
               }

               var12.b(var9);
            }

            eU var21 = eU.a(var4, var10, false);
            if(var21 != null) {
               fh var23 = (fh)var7.get(var21);
               if(var23 == null) {
                  var23 = new fh();
                  var7.put(var21, var23);
               }

               if(var23.c() || var23.d() && !var9.e()) {
                  y.f.am var24 = var1.a((Object)var9.d());
                  var5.setFrame(var24.getX(), var24.getY(), var24.getWidth(), var24.getHeight());
                  fO var15 = var21.g().a();
                  var6.a(var15.a((fj)var5, (y.d.t)var1.q(var9)));
                  var23.a(eU.b(var6));
               }

               var23.a(var9);
            }

            var8.g();
            if(var16) {
               break;
            }
         }

         Iterator var17 = var7.values().iterator();

         while(var17.hasNext()) {
            fh var18 = (fh)var17.next();
            Iterator var19 = var18.a();

            y.c.d var20;
            y.f.I var22;
            label53: {
               while(var19.hasNext()) {
                  var20 = (y.c.d)var19.next();
                  var22 = var1.b(var20);
                  var22.setTargetPoint(var18.e());
                  if(var16) {
                     break label53;
                  }

                  if(var16) {
                     break;
                  }
               }

               var19 = var18.b();
            }

            while(var19.hasNext()) {
               var20 = (y.c.d)var19.next();
               var22 = var1.b(var20);
               var22.setSourcePoint(var18.e());
               if(var16 || var16) {
                  return;
               }
            }
         }
      }

   }

   fi(ff var1, fg var2) {
      this(var1);
   }
}
