package y.e;

import java.awt.Dimension;
import java.awt.Graphics2D;
import java.awt.Rectangle;
import java.awt.image.BufferedImage;
import java.io.OutputStream;
import y.e.c;
import y.h.bu;
import y.h.cV;
import y.h.ch;
import y.h.gF;
import y.h.hk;

public abstract class e extends c {
   private boolean b;
   private boolean c;
   private double d;

   protected e() {
      this(false);
   }

   protected e(boolean var1) {
      this.d = 10.0D;
      this.b = var1;
      this.c = true;
   }

   public boolean c() {
      return this.c;
   }

   public void a(bu var1, OutputStream var2) {
      ch var3 = (ch)var1.S();
      ch var4 = var3;
      if(var3 == null) {
         var4 = this.a(var1);
      }

      try {
         this.a(var4, var2);
      } finally {
         if(var3 == null) {
            var1.c(var4);
         }

      }

   }

   public void a(ch var1, OutputStream var2) {
      Dimension var3 = var1.getCanvasSize();
      long var4 = (long)var3.width * (long)var3.height;
      if(var4 > 2147483647L) {
         throw new IllegalArgumentException("Image size of " + var3.width + "x" + var3.height + "=" + var4 + "px exceeds maximum size of " + Integer.MAX_VALUE + "px.");
      } else {
         BufferedImage var6;
         try {
            var6 = this.a(var3.width, var3.height);
         } catch (OutOfMemoryError var12) {
            int var8 = (int)Math.ceil((double)(var3.width * var3.height) / 1048576.0D);
            throw new OutOfMemoryError("Not enough memory for temporary image of size " + var3.width + 'x' + var3.height + " (" + var8 + "MPixels).  Approximately " + var8 * 4 + "MByte required.");
         }

         Graphics2D var7 = (Graphics2D)var6.getGraphics();
         if(!this.c()) {
            var7.setRenderingHint(hk.a, hk.b);
         }

         if(this.b) {
            gF.a(var7);
         }

         cV var13 = this.a(var1, var7);
         if(var13 != null) {
            var7.setRenderingHint(hk.z, var13);
         }

         var1.paintVisibleContent(var7);
         if(this.b) {
            gF.b(var7);
         }

         try {
            this.a(var6, var2);
         } catch (OutOfMemoryError var11) {
            int var10 = (int)Math.ceil((double)(var3.width * var3.height) / 1048576.0D);
            throw new OutOfMemoryError("Not enough memory to encode image of size " + var6.getWidth() + 'x' + var6.getHeight() + " (" + var10 + "MPixels). Approximately " + var10 * 4 + "MByte required.");
         }
      }
   }

   protected cV a(ch var1, Graphics2D var2) {
      cV var3 = new cV();
      var3.b(true);
      var3.a(var1);
      var3.a(var2.getTransform());
      return var3;
   }

   protected abstract BufferedImage a(int var1, int var2);

   public ch a(bu var1) {
      ch var2 = new ch(var1);
      Rectangle var3 = var1.a();
      Dimension var4 = new Dimension(var3.width, var3.height);
      var2.setSize(var4);
      var2.setPreferredSize(var4);
      var2.zoomToArea((double)var3.x - this.d, (double)var3.y - this.d, (double)var3.width + 2.0D * this.d, (double)var3.height + 2.0D * this.d);
      var2.setPaintDetailThreshold(0.0D);
      return var2;
   }

   protected abstract void a(BufferedImage var1, OutputStream var2);

   public void a(boolean var1) {
      this.b = var1;
   }
}
