package y.h;

import java.awt.geom.Rectangle2D;
import y.h.bu;
import y.h.ch;
import y.h.dk;
import y.h.dl;
import y.h.fj;

public class dj implements y.b.d {
   private static final long xf = 300L;
   private static final boolean uf = true;
   private y.c.q zf;
   private boolean wf;
   private boolean sf;
   private long vf = 300L;
   private boolean yf = true;
   private dl tf;

   public dj() {
   }

   public dj(ch var1, y.f.O var2) {
      this.initialize(var1, var2);
   }

   public boolean isEasedExecution() {
      return this.yf;
   }

   public void setEasedExecution(boolean var1) {
      this.yf = var1;
      if(this.tf != null) {
         this.tf.a(var1);
      }

   }

   public long preferredDuration() {
      return this.vf;
   }

   public void setPreferredDuration(long var1) {
      this.vf = var1;
      if(this.tf != null) {
         this.tf.a(var1);
      }

   }

   public y.c.q getFocusNode() {
      return this.zf;
   }

   public void setFocusNode(y.c.q var1) {
      this.zf = var1;
      if(this.tf != null) {
         this.tf.a(var1);
      }

   }

   public boolean isSmoothViewTransform() {
      return this.wf;
   }

   public void setSmoothViewTransform(boolean var1) {
      this.wf = var1;
      if(this.tf != null) {
         this.tf.b(var1);
      }

   }

   public void initAnimation() {
      if(this.tf != null) {
         this.tf.initAnimation();
      }

   }

   protected Rectangle2D calcBoundingBox(y.c.i var1, y.f.O var2, Rectangle2D var3) {
      boolean var12 = fj.z;
      y.c.x var4 = var1.o();

      while(var4.f()) {
         y.f.am var5 = var2.a(var4.e());
         if(var3.getWidth() < 0.0D) {
            var3.setFrame(var5.getX(), var5.getY(), var5.getWidth(), var5.getHeight());
         }

         label80: {
            var3.add(var5.getX(), var5.getY());
            var3.add(var5.getX() + var5.getWidth(), var5.getY() + var5.getHeight());
            y.f.aj[] var6 = var2.a_(var4.e());
            if(var6 != null && var6.length > 0) {
               int var7 = 0;

               while(var7 < var6.length) {
                  y.f.al var8 = var6[var7].a();
                  y.d.y var9 = var8.a(var6[var7].getOrientedBox().d(), var5, var6[var7].getModelParameter()).h();
                  var3.add(var9.c, var9.d);
                  var3.add(var9.c + var9.a, var9.d + var9.b);
                  ++var7;
                  if(var12) {
                     break label80;
                  }

                  if(var12) {
                     break;
                  }
               }
            }

            var4.g();
         }

         if(var12) {
            break;
         }
      }

      y.c.e var13 = var1.p();

      Rectangle2D var10000;
      while(true) {
         if(var13.f()) {
            y.f.C[] var14 = var2.d(var13.a());
            y.f.I var15 = var2.b(var13.a());
            y.f.am var16 = var2.a(var13.a().c());
            y.f.am var17 = var2.a(var13.a().d());
            var3.add(var16.getX() + var16.getWidth() * 0.5D + var15.getSourcePoint().a, var16.getY() + var16.getHeight() * 0.5D + var15.getSourcePoint().b);
            var10000 = var3;
            if(var12) {
               break;
            }

            var3.add(var17.getX() + var17.getWidth() * 0.5D + var15.getTargetPoint().a, var17.getY() + var17.getHeight() * 0.5D + var15.getTargetPoint().b);
            int var18 = 0;

            label90: {
               while(var18 < var15.pointCount()) {
                  y.d.t var10 = var15.getPoint(var18);
                  var3.add(var10.a, var10.b);
                  ++var18;
                  if(var12) {
                     break label90;
                  }

                  if(var12) {
                     break;
                  }
               }

               if(var14 != null && var14.length > 0) {
                  var18 = 0;

                  while(var18 < var14.length) {
                     y.f.E var19 = var14[var18].getLabelModel();
                     y.d.y var11 = var19.a(var14[var18].getOrientedBox().d(), var15, var16, var17, var14[var18].getModelParameter()).h();
                     var3.add(var11.c, var11.d);
                     var3.add(var11.c + var11.a, var11.d + var11.b);
                     ++var18;
                     if(var12) {
                        break label90;
                     }

                     if(var12) {
                        break;
                     }
                  }
               }

               var13.g();
            }

            if(!var12) {
               continue;
            }
         }

         var10000 = var3;
         break;
      }

      return var10000;
   }

   public void calcFrame(double var1) {
      if(this.tf != null) {
         this.tf.calcFrame(var1);
      }

   }

   public void disposeAnimation() {
      if(this.tf != null) {
         this.tf.disposeAnimation();
         this.tf = null;
      }

   }

   public void execute() {
      if(this.tf != null) {
         ch var1 = this.tf.p;
         bu var2 = this.tf.a;
         y.b.e var3 = new y.b.e();
         var3.a((y.b.c)var1);
         var3.a((y.b.c)(new dk(this, var2)));
         if(this.yf) {
            var3.a(y.b.b.a(this));
            if(!fj.z) {
               return;
            }
         }

         var3.a((y.b.d)this);
      }

   }

   public void execute(ch var1, y.f.O var2) {
      this.initialize(var1, var2);
      this.execute();
   }

   protected void initialize(ch var1, y.f.O var2) {
      this.tf = new dl(var1, var2, this);
      this.tf.c(this.isKeepZoomFactor());
      this.tf.a(this.getFocusNode());
      this.tf.a(this.isEasedExecution());
      this.tf.a(this.preferredDuration());
      this.tf.b(this.isSmoothViewTransform());
   }

   public boolean isKeepZoomFactor() {
      return this.sf;
   }

   public void setKeepZoomFactor(boolean var1) {
      this.sf = var1;
      if(this.tf != null) {
         this.tf.c(var1);
      }

   }
}
