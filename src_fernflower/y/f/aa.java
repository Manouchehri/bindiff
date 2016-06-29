package y.f;

import java.io.File;
import java.io.FileWriter;
import java.io.Writer;
import java.util.HashMap;
import y.f.I;
import y.f.O;
import y.f.X;
import y.f.ab;
import y.f.am;

public final class aa {
   private y.c.i a;
   private O b;

   public aa(X var1) {
      this(var1, var1);
   }

   public aa(y.c.i var1, O var2) {
      this.a = var1;
      this.b = var2;
   }

   public void a(String var1) {
      this.a(new File(var1));
   }

   public void a(File var1) {
      FileWriter var2 = new FileWriter(var1);
      this.a((Writer)var2);
      var2.close();
   }

   public void a(Writer var1) {
      boolean var15 = X.j;
      y.c.c var2 = this.a.c(y.f.b.f.c);
      y.c.c var3 = this.a.c(y.f.b.f.b);
      y.c.c var4 = this.a.c(y.f.b.f.d);
      boolean var5 = var2 != null && var3 != null && var4 != null;
      HashMap var6 = new HashMap();
      if(var5) {
         y.c.x var7 = this.a.o();

         while(var7.f()) {
            var6.put(var3.b(var7.e()), var7.e());
            var7.g();
            if(var15) {
               break;
            }
         }
      }

      ab var16 = new ab(var1);
      var16.b("Creator", "yFiles-LayoutGraphWriter");
      var16.b("Version", y.g.as.a());
      var16.a("graph");
      var16.b("label", "");
      var16.a("directed", 1);
      if(var5) {
         var16.a("hierarchic", 1);
      }

      int var8 = 0;
      y.c.x var9 = this.a.o();

      while(var9.f()) {
         ++var8;
         y.c.q var10 = var9.e();
         var16.a("node");
         var16.a("id", var10.d());
         if(var5) {
            if(var4.d(var10)) {
               var16.a("isGroup", 1);
            }

            if(var2.b(var10) != null) {
               var16.a("gid", ((y.c.q)var6.get(var2.b(var10))).d());
            }
         }

         if(this.b != null) {
            var16.a("graphics");
            am var11 = this.b.a(var10);
            var16.a("x", (double)((float)var11.getX()) + var11.getWidth() * 0.5D);
            var16.a("y", (double)((float)var11.getY()) + var11.getHeight() * 0.5D);
            var16.a("w", (double)((float)var11.getWidth()));
            var16.a("h", (double)((float)var11.getHeight()));
            var16.b("type", "rectangle");
            var16.b();
         }

         var16.b();
         var9.g();
         if(var15) {
            break;
         }
      }

      y.c.e var17 = this.a.p();

      while(true) {
         if(var17.f()) {
            y.c.d var18 = var17.a();
            var16.a("edge");
            var16.a("source", var18.c().d());
            var16.a("target", var18.d().d());
            if(var15) {
               break;
            }

            if(this.b != null) {
               I var19 = this.b.b(var18);
               var16.a("graphics");
               int var12 = var19.pointCount();
               am var13;
               if(var12 > 0) {
                  var16.a("Line");
                  var16.a("point");
                  var13 = this.b.a(var18.c());
                  y.d.t var14 = var19.getSourcePoint();
                  var16.a("x", (double)((float)(var14.a + var13.getX() + var13.getWidth() * 0.5D)));
                  var16.a("y", (double)((float)(var14.b + var13.getY() + var13.getHeight() * 0.5D)));
                  var16.b();
                  int var21 = 0;

                  label75: {
                     while(var21 < var12) {
                        var16.a("point");
                        var14 = var19.getPoint(var21);
                        var16.a("x", (double)((float)var14.a));
                        var16.a("y", (double)((float)var14.b));
                        var16.b();
                        ++var21;
                        if(var15) {
                           break label75;
                        }

                        if(var15) {
                           break;
                        }
                     }

                     var16.a("point");
                  }

                  var13 = this.b.a(var18.d());
                  var14 = var19.getTargetPoint();
                  var16.a("x", (double)((float)(var14.a + var13.getX() + var13.getWidth() * 0.5D)));
                  var16.a("y", (double)((float)(var14.b + var13.getY() + var13.getHeight() * 0.5D)));
                  var16.b();
                  var16.b();
               }

               var16.b();
               var16.a("edgeAnchor");
               y.d.t var20 = var19.getSourcePoint();
               var13 = this.b.a(var18.c());
               if(var20.a != 0.0D) {
                  var16.a("xSource", (double)((float)(2.0D * var20.a / var13.getWidth())));
               }

               if(var20.b != 0.0D) {
                  var16.a("ySource", (double)((float)(2.0D * var20.b / var13.getHeight())));
               }

               am var22 = this.b.a(var18.d());
               var20 = var19.getTargetPoint();
               if(var20.a != 0.0D) {
                  var16.a("xTarget", (double)((float)(2.0D * var20.a / var22.getWidth())));
               }

               if(var20.b != 0.0D) {
                  var16.a("yTarget", (double)((float)(2.0D * var20.b / var22.getHeight())));
               }

               var16.b();
            }

            var16.b();
            var17.g();
            if(!var15) {
               continue;
            }
         }

         var16.b();
         break;
      }

   }
}
