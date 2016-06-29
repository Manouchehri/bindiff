package y.f.f.d;

import java.util.ArrayList;
import y.f.f.d.H;
import y.f.f.d.o;
import y.g.al;

public class G extends o {
   protected static final Integer q = new Integer(2);
   protected y.c.A r;
   protected y.c.c s = new H(this);
   protected boolean t;
   private y.c.h u;
   private y.c.A v;
   private y.c.h w;
   private y.c.h x;

   public void b(y.c.h var1) {
      this.w = var1;
   }

   public void c(y.c.h var1) {
      this.x = var1;
   }

   public void a(y.c.c var1) {
      this.s = var1;
   }

   public void a(y.c.A var1) {
      this.r = var1;
   }

   public void b(boolean var1) {
      this.t = var1;
   }

   public void a() {
      label11: {
         this.a(false);
         this.v = this.a.t();
         if(this.w == null) {
            y.c.h var1 = this.a.u();
            this.a((y.c.h)var1);
            this.b.a(var1, this.a.p().a(), y.f.f.b.o.a);
            this.a.a(var1);
            if(!o.p) {
               break label11;
            }
         }

         this.a((y.c.h)this.w);
      }

      this.a.a(this.v);
   }

   protected int a(y.c.i param1, y.c.h param2, ArrayList param3, y.c.q[] param4, y.c.A param5, ArrayList param6) {
      // $FF: Couldn't be decompiled
   }

   protected double a(y.c.i var1, int var2, y.c.h var3, y.c.q[] var4, ArrayList var5, ArrayList var6, y.c.h var7, y.c.A var8) {
      boolean var28 = o.p;
      al var9 = new al();
      y.c.h var10 = var1.u();
      double var11 = -1.0D;
      var11 = (double)this.o.a(var1, var4[0], var4[1], var3, var10, var2, var5, var6, this.h, this.i);
      var9.e();
      y.c.e var13 = this.a.p();

      G var10000;
      int var19;
      while(true) {
         if(var13.f()) {
            y.c.d var14 = var13.a();
            y.c.d var15 = this.b.a(var13.a());
            StringBuffer var16 = new StringBuffer();
            Object var17 = this.e.b(var14);
            var10000 = this;
            if(var28) {
               break;
            }

            Object var18 = this.d.b(var14);
            var19 = var17 == null?0:var10.a(var17);
            int var20 = var18 == null?0:var10.a(var18);
            a(var16, var20, '<');
            a(var16, var19, '>');
            int var21 = var10.a(this.c.b(var14));
            int var22 = var10.a(this.c.b(var15));
            a(var16, var22, '>');
            a(var16, var21, '<');
            var17 = this.e.b(var15);
            var18 = this.d.b(var15);
            int var23 = var17 == null?0:var10.a(var17);
            int var24 = var18 == null?0:var10.a(var18);
            a(var16, var23, '<');
            a(var16, var24, '>');
            this.j += var16.length();
            var7.a(var14, var16.toString());
            int var25 = var10.a(this.f.b(var14));
            int var26 = 0;
            if(!this.a(var14.c())) {
               var26 = var10.a(this.g.b(var14));
            }

            this.b.a(var14, var25 - var26 + 1);
            var13.g();
            if(!var28) {
               continue;
            }
         }

         var10000 = this;
         break;
      }

      y.c.x var29 = var10000.a.o();

      label74:
      while(true) {
         boolean var33 = var29.f();

         label71:
         while(var33) {
            y.c.q var30 = var29.e();
            var10000 = this;
            if(var28) {
               break label74;
            }

            if(this.b.g(var30)) {
               y.c.e var31 = var30.l();

               while(var31.f()) {
                  y.c.d var32 = this.b.a(var31.a());
                  var33 = this.x.d(var32);
                  if(var28) {
                     continue label71;
                  }

                  if(var33) {
                     y.c.d var34 = (y.c.d)this.v.b(var30);
                     y.c.d var35 = (y.c.d)this.u.b(var32);
                     if(var35 != null) {
                        var19 = var10.a(var35);
                        if(var19 > 0) {
                           this.b.a(var34, this.b.d(var34) + var19);
                           y.c.d var36 = this.b.a(var32);
                           String var37 = (String)var7.b(var32);
                           String var38 = (String)var7.b(var36);
                           y.c.e var39 = var30.a(var36);
                           var39.b();
                           y.c.d var40 = var39.a();
                           y.c.d var41 = this.b.a(var39.a());
                           String var42 = (String)var7.b(var40);
                           String var27 = (String)var7.b(var41);
                           var7.a(var40, var37 + var42);
                           var7.a(var41, var27 + var38);
                           var7.a(var32, "");
                           var7.a(var36, "");
                        }
                     }
                  }

                  var31.g();
                  if(var28) {
                     break;
                  }
               }
            }

            var29.g();
            if(!var28) {
               continue label74;
            }
            break;
         }

         this.j /= 2;
         this.a.a(this.f);
         this.a.a(this.g);
         this.a.a(this.c);
         this.a.a(this.d);
         this.a.a(this.e);
         var10000 = this;
         break;
      }

      var10000.a.a(this.u);
      var1.a(var10);
      return var11;
   }

   private boolean a(y.c.q var1) {
      return this.b.b(var1) || this.b.g(var1);
   }
}
