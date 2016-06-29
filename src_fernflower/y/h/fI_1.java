package y.h;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.awt.image.ConvolveOp;
import java.awt.image.ImageObserver;
import java.awt.image.Kernel;
import y.h.bw;
import y.h.ch;
import y.h.fD;
import y.h.fF;
import y.h.fj;

final class fI extends bw {
   private BufferedImage f;
   private BufferedImage g;
   private ConvolveOp h;
   private final fD i;

   private boolean F() {
      if(this.h == null) {
         byte var1 = 5;
         double var2 = 0.9D;
         Object var4 = this.i.getClientProperty("Overview.funkyTheta");
         if(var4 instanceof Number) {
            var2 = ((Number)var4).doubleValue();
         }

         float[] var5 = fD.access$100(var2, var1);
         this.h = new ConvolveOp(new Kernel(var1, var1, var5));
      }

      if(this.f != null && this.getWidth() == this.f.getWidth() && this.getHeight() == this.f.getHeight()) {
         return false;
      } else {
         if(!fD.access$200()) {
            this.f = new BufferedImage(this.getWidth(), this.getHeight(), 1);
            this.g = new BufferedImage(this.getWidth(), this.getHeight(), 1);
            if(!fj.z) {
               return true;
            }
         }

         this.f = new BufferedImage(this.getWidth(), this.getHeight(), 2);
         this.g = new BufferedImage(this.getWidth(), this.getHeight(), 2);
         return true;
      }
   }

   public fI(fD var1, ch var2) {
      super(var2);
      this.i = var1;
   }

   public void paintComponent(Graphics var1) {
      BufferedImage var2;
      BufferedImage var3;
      if(this.F() || this.i.xc) {
         var2 = this.g;
         var3 = this.f;
         Color var4 = (Color)this.i.getClientProperty("Overview.FogColor");
         if(var4 == null) {
            var4 = new Color(0.85F, 0.85F, 0.85F, 0.6F);
         }

         if(this.i.xc) {
            this.i();
            this.i.xc = false;
         }

         Graphics2D var5 = var3.createGraphics();

         try {
            var5.setColor(this.getBackground());
            var5.clearRect(0, 0, this.getWidth(), this.getHeight());
            var5.setClip(0, 0, this.getWidth(), this.getHeight());
            super.paintComponent(var5);
         } finally {
            var5.dispose();
         }

         if("Funky".equals(this.i.getClientProperty("Overview.PaintStyle")) && !fD.access$200()) {
            this.h.filter(this.f, this.g);
            var5 = var2.createGraphics();

            try {
               var5.setColor(var4);
               var5.fillRect(0, 0, this.getWidth(), this.getHeight());
            } finally {
               var5.dispose();
            }
         } else {
            var5 = var2.createGraphics();

            try {
               var5.drawImage(this.f, 0, 0, (ImageObserver)null);
               var5.setColor(var4);
               var5.fillRect(0, 0, this.getWidth(), this.getHeight());
            } finally {
               var5.dispose();
            }
         }
      }

      if(this.i.xc) {
         this.i();
         this.i.xc = false;
      }

      label267: {
         if(Boolean.TRUE.equals(this.i.getClientProperty("Overview.Inverse"))) {
            var2 = this.f;
            var3 = this.g;
            if(!fj.z) {
               break label267;
            }
         }

         var2 = this.g;
         var3 = this.f;
      }

      var1.drawImage(var3, 0, 0, (ImageObserver)null);
      int var25 = this.e(fF.a(this.i.wc).x);
      int var26 = this.f(fF.a(this.i.wc).y);
      int var6 = Math.max(0, var25);
      int var7 = Math.max(0, var26);
      int var8 = this.e(fF.a(this.i.wc).getMaxX());
      int var9 = this.f(fF.a(this.i.wc).getMaxY());
      int var10 = Math.min(this.getWidth(), var8);
      int var11 = Math.min(this.getHeight(), var9);
      if(var10 >= var6 && var11 >= var7) {
         var1.drawImage(var2, var6, var7, var10, var11, var6, var7, var10, var11, (ImageObserver)null);
         Color var12 = (Color)this.i.getClientProperty("Overview.BorderColor");
         if(var12 == null) {
            var12 = Color.lightGray;
         }

         var1.setColor(var12);
         var1.drawRect(var25, var26, var8 - var25, var9 - var26);
         if(Boolean.TRUE.equals(this.i.getClientProperty("Overview.AllowZooming"))) {
            var1.setColor(Color.darkGray);
            var1.fillRect(var8 - 1, var9 - 1, 3, 3);
         }
      }

   }
}
