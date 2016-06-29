package y.h;

import java.awt.Graphics2D;
import java.awt.Rectangle;
import java.awt.RenderingHints;
import java.awt.geom.AffineTransform;
import java.awt.image.BufferedImage;
import java.awt.image.ImageObserver;
import javax.swing.JComponent;
import y.h.az;
import y.h.ch;
import y.h.fj;

final class ia implements az {
   private JComponent a;
   private AffineTransform b;

   public ia(ch var1, JComponent var2, AffineTransform var3) {
      var1.s().add(var2);
      this.a = var2;
      this.b = var3;
   }

   public void a(Graphics2D var1) {
      boolean var2 = this.a.isDoubleBuffered();
      if(var2) {
         this.a.setDoubleBuffered(false);
      }

      if(this.a.getClientProperty("NodeCellRenderer.noImage") == null) {
         try {
            BufferedImage var3 = var1.getDeviceConfiguration().createCompatibleImage(this.a.getWidth(), this.a.getHeight(), 1);
            Graphics2D var4 = var3.createGraphics();
            if(this.a.getClientProperty("NodeCellRenderer.adoptRenderingHints") != null) {
               var4.setRenderingHint(RenderingHints.KEY_ANTIALIASING, var1.getRenderingHint(RenderingHints.KEY_ANTIALIASING));
               var4.setRenderingHint(RenderingHints.KEY_TEXT_ANTIALIASING, var1.getRenderingHint(RenderingHints.KEY_TEXT_ANTIALIASING));
            }

            this.a.paint(var4);
            var4.dispose();
            if(this.a.getClientProperty("NodeCellRender.lowQualityImage") == null) {
               Graphics2D var5 = (Graphics2D)var1.create();
               var5.setRenderingHint(RenderingHints.KEY_INTERPOLATION, RenderingHints.VALUE_INTERPOLATION_BICUBIC);
               var5.drawImage(var3, this.b, (ImageObserver)null);
               var5.dispose();
               if(!fj.z) {
                  return;
               }
            }

            var1.drawImage(var3, this.b, (ImageObserver)null);
         } finally {
            if(var2) {
               this.a.setDoubleBuffered(true);
            }

         }
      } else {
         var1 = (Graphics2D)var1.create();

         try {
            var1.transform(this.b);
            this.a.paint(var1);
         } finally {
            var1.dispose();
            if(var2) {
               this.a.setDoubleBuffered(true);
            }

         }
      }

   }

   public Rectangle getBounds() {
      double[] var1 = new double[8];
      var1[0] = var1[1] = var1[2] = var1[5] = 0.0D;
      var1[3] = var1[7] = (double)this.a.getHeight();
      var1[4] = var1[6] = (double)this.a.getWidth();
      this.b.transform(var1, 0, var1, 0, 4);
      double var2 = Math.max(Math.max(var1[0], var1[2]), Math.max(var1[4], var1[6]));
      double var4 = Math.min(Math.min(var1[0], var1[2]), Math.min(var1[4], var1[6]));
      double var6 = Math.max(Math.max(var1[1], var1[3]), Math.max(var1[5], var1[7]));
      double var8 = Math.min(Math.min(var1[1], var1[3]), Math.min(var1[5], var1[7]));
      return new Rectangle((int)var4 - 1, (int)var8 - 1, (int)(var2 - var4) + 2, (int)(var6 - var8) + 2);
   }
}
