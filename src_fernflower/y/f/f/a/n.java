package y.f.f.a;

import y.c.A;
import y.c.q;
import y.c.x;
import y.c.y;
import y.d.r;
import y.f.f.a.f;
import y.f.f.a.o;
import y.f.f.d.t;

public class n extends t {
   public void a() {
      boolean var13;
      n var10000;
      label100: {
         var13 = f.a;
         y.c.c var1 = this.c.c("y.layout.orthogonal.cluster.NodeSplitter.INSETS_KEY");
         if(var1 != null) {
            y.c.e var2 = this.c.p();

            while(var2.f()) {
               y.c.d var3 = var2.a();
               var10000 = this;
               if(var13) {
                  break label100;
               }

               if(!this.b.c(var3)) {
                  r var4 = r.a(var1.b(var3));
                  y.f.f.b.o var5 = this.b.h(var3);
                  if(var4 != null) {
                     double var6 = 0.0D;
                     double var8 = 0.0D;
                     if(var5.a(y.f.f.b.o.a)) {
                        var6 = var4.b;
                     }

                     if(var5.a(y.f.f.b.o.b)) {
                        var6 = var4.a;
                     }

                     if(var5.a(y.f.f.b.o.c)) {
                        var8 = var4.d;
                     }

                     if(var5.a(y.f.f.b.o.d)) {
                        var8 = var4.c;
                     }

                     var8 = Math.ceil(var8 / (double)this.f);
                     var6 = Math.ceil(var6 / (double)this.f);
                     this.b.c(var3, (int)var8);
                     this.b.c(this.b.a(var3), (int)var8);
                     this.b.d(var3, (int)var6);
                     this.b.d(this.b.a(var3), (int)var6);
                  }
               }

               var2.g();
               if(var13) {
                  break;
               }
            }
         }

         var10000 = this;
      }

      label86: {
         y.c.c var14 = var10000.c.c(y.f.b.f.f);
         y.c.c var15 = this.c.c("y.layout.orthogonal.cluster.NodeSplitter.BORDER_INFO_KEY");
         if(var14 != null && var15 != null) {
            y var16 = new y();
            A var17 = this.c.t();
            y.c.e var19 = this.c.p();

            while(var19.f()) {
               y.c.d var7 = var19.a();
               q var21 = (q)var15.b(var7);
               var10000 = this;
               if(var13) {
                  break label86;
               }

               if(!this.b.c(var7) && var21 != null) {
                  label110: {
                     y.c.f var9 = (y.c.f)var17.b(var21);
                     if(var9 != null) {
                        var9.add(var7);
                        if(!var13) {
                           break label110;
                        }
                     }

                     var9 = new y.c.f(var7);
                     var17.a(var21, var9);
                     var16.add(var21);
                  }
               }

               var19.g();
               if(var13) {
                  break;
               }
            }

            x var20 = var16.a();

            while(var20.f()) {
               q var18 = var20.e();
               y.c.f var23 = (y.c.f)var17.b(var18);
               y.d.q var22 = (y.d.q)var14.b(var18);
               if(var13) {
                  return;
               }

               if(var22 != null) {
                  int var10 = (int)Math.ceil(var22.a() / (double)this.f);
                  int var11 = (int)Math.ceil(var22.b() / (double)this.f);
                  o var12 = this.a(var23);
                  this.b.a(new y.f.f.b.n(var12.a, var12.c, var10, 1, y.f.f.b.o.b));
                  this.b.a(new y.f.f.b.n(var12.a, var12.c, var11, 1, y.f.f.b.o.c));
               }

               var20.g();
               if(var13) {
                  break;
               }
            }

            this.c.a((A)var17);
         }

         var10000 = this;
      }

      var10000.a();
   }

   private o a(y.c.f var1) {
      boolean var10 = f.a;
      o var2 = new o();
      y.c.e var3 = var1.a();

      while(var3.f()) {
         y.c.d var4 = var3.a();
         q var5 = var4.c();
         String var6 = "";
         y.c.e var7 = var5.l();

         label71: {
            label60: {
               while(true) {
                  if(var7.f()) {
                     y.c.d var8 = var7.a();
                     y.f.f.b.o var9 = this.b.h(var8);
                     var6 = var6 + var9;
                     var7.g();
                     if(var10) {
                        break;
                     }

                     if(!var10) {
                        continue;
                     }
                  }

                  if(!var6.equals(">_") && !var6.equals("_>")) {
                     break label60;
                  }

                  var2.a = var5;
                  break;
               }

               if(!var10) {
                  break label71;
               }
            }

            if(var6.equals("<_") || var6.equals("_<")) {
               var2.b = var5;
               if(!var10) {
                  break label71;
               }
            }

            if(var6.equals(">^") || var6.equals("^>")) {
               var2.d = var5;
               if(!var10) {
                  break label71;
               }
            }

            if(var6.equals("<^") || var6.equals("^<")) {
               var2.c = var5;
            }
         }

         var3.g();
         if(var10) {
            break;
         }
      }

      return var2;
   }
}
