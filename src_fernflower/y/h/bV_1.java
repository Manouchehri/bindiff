package y.h;

import java.awt.Graphics2D;
import java.awt.Rectangle;
import java.awt.Shape;
import java.awt.geom.AffineTransform;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import y.h.aB;
import y.h.bu;
import y.h.eR;
import y.h.fj;
import y.h.gn;
import y.h.hk;

public class bV extends gn {
   private bu a;
   private boolean b;
   private boolean c;
   private boolean d;

   public bV() {
      this.h();
   }

   public bV(fj var1) {
      super(var1);
      if(var1 instanceof bV) {
         bV var2 = (bV)var1;
         this.a = var2.a;
         this.b = var2.b;
         this.c = var2.c;
         this.d = var2.d;
         if(!fj.z) {
            return;
         }
      }

      this.h();
   }

   private void h() {
      this.b = true;
      this.c = false;
      this.d = true;
   }

   public boolean a() {
      return this.d;
   }

   public boolean e() {
      return this.c;
   }

   public boolean f() {
      return this.b;
   }

   public bu g() {
      if(this.a != null) {
         return this.a;
      } else {
         try {
            y.c.i var1 = this.getNode().e();
            y.h.a.v var2 = y.h.a.v.a(var1);
            return (bu)var2.m(this.getNode());
         } catch (Exception var3) {
            return null;
         }
      }
   }

   protected void paintNode(Graphics2D var1) {
      super.paintNode(var1);
      if(this.f()) {
         this.a(var1);
      }

   }

   public void paintSloppy(Graphics2D var1) {
      if(!this.b()) {
         super.paintSloppy(var1);
         if(this.f()) {
            Double var2 = (Double)var1.getRenderingHint(hk.y);
            if(var2 != null && var2.doubleValue() < Double.MAX_VALUE) {
               this.a(var1);
            }
         }

      }
   }

   protected void a(Graphics2D var1) {
      boolean var27 = fj.z;
      bu var2 = this.g();
      if(var2 != null) {
         double var3 = 10.0D;
         double var5 = this.getHeight() - var3 * 2.0D;
         double var7 = this.getWidth() - var3 * 2.0D;
         double var9 = this.getCenterX();
         double var11 = this.getCenterY();
         eR var13 = this.getLabel();
         switch(var13.getModel()) {
         case 1:
            switch(var13.getPosition()) {
            case 102:
               var5 -= var13.getHeight();
               var11 += var13.getHeight() / 2.0D;
               if(!var27) {
                  break;
               }
            case 101:
               var5 -= var13.getHeight();
               var11 -= var13.getHeight() / 2.0D;
               if(!var27) {
                  break;
               }
            case 115:
               var7 -= var13.getWidth();
               var9 += var13.getWidth() / 2.0D;
               if(!var27) {
                  break;
               }
            case 116:
               var7 -= var13.getWidth();
               var9 -= var13.getWidth() / 2.0D;
            }
         default:
            if(var7 > 5.0D && var5 > 5.0D) {
               Shape var14 = null;
               double var15 = 1.0D;
               double var17 = 1.0D;
               double var19 = 1.0D;
               AffineTransform var21 = var1.getTransform();
               if(this.e()) {
                  var14 = var1.getClip();
                  var1.clip(new java.awt.geom.Rectangle2D.Double(this.getX(), this.getY(), var7, var5));
               }

               var1.translate(var9, var11);
               if(this.a()) {
                  Rectangle var22 = var2.a();
                  var15 = var7 / var22.getWidth();
                  var17 = var5 / var22.getHeight();
                  var19 = Math.min(var15, var17);
                  var1.scale(var19, var19);
                  var1.translate(-var22.getCenterX(), -var22.getCenterY());
               }

               label120: {
                  double var28 = var19 * var21.getScaleX();
                  Double var24 = (Double)var1.getRenderingHint(hk.y);
                  y.c.x var25;
                  fj var26;
                  y.c.e var29;
                  aB var30;
                  if(var24 == null || var28 > var24.doubleValue()) {
                     var25 = var2.o();

                     while(var25.f()) {
                        var26 = var2.t(var25.e());
                        var26.paint(var1);
                        var25.g();
                        if(var27) {
                           break label120;
                        }

                        if(var27) {
                           break;
                        }
                     }

                     var29 = var2.p();

                     do {
                        if(!var29.f()) {
                           break label120;
                        }

                        var30 = var2.i(var29.a());
                        var30.paint(var1);
                        var29.g();
                        if(var27) {
                           return;
                        }
                     } while(!var27);
                  }

                  if(var24 == null || 4.0D * var28 > var24.doubleValue()) {
                     label119: {
                        var25 = var2.o();

                        while(var25.f()) {
                           var26 = var2.t(var25.e());
                           var26.paintSloppy(var1);
                           var25.g();
                           if(var27) {
                              break label119;
                           }

                           if(var27) {
                              break;
                           }
                        }

                        var29 = var2.p();

                        while(var29.f()) {
                           var30 = var2.i(var29.a());
                           var30.paintSloppy(var1);
                           var29.g();
                           if(var27) {
                              return;
                           }

                           if(var27) {
                              break;
                           }
                        }
                     }
                  }
               }

               if(this.e()) {
                  var1.setClip(var14);
               }

               var1.setTransform(var21);
            }
         }
      }
   }

   public fj createCopy(fj var1) {
      return new bV(var1);
   }

   public void write(ObjectOutputStream var1) {
      var1.writeByte(0);
      super.write(var1);
      var1.writeBoolean(this.b);
      var1.writeBoolean(this.c);
      var1.writeBoolean(this.d);
   }

   public void read(ObjectInputStream var1) {
      switch(var1.readByte()) {
      case 0:
         super.read(var1);
         this.b = var1.readBoolean();
         this.c = var1.readBoolean();
         this.d = var1.readBoolean();
         if(!fj.z) {
            return;
         }
      default:
         throw new y.e.a();
      }
   }
}
