package y.h;

import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.Point;
import java.awt.image.ImageObserver;
import y.h.M;
import y.h.ch;
import y.h.w;

final class du extends M {
   private final ch a;

   du(ch var1, ch var2) {
      super(var1);
      this.a = var2;
   }

   public void paint(Graphics2D var1, int var2, int var3, int var4, int var5) {
      this.a(this.a);

      try {
         super.paint(var1, var2, var3, var4, var5);
      } finally {
         this.a();
      }

   }

   protected void undoWorldTransform(Graphics2D var1) {
   }

   protected void redoWorldTransform(Graphics2D var1) {
   }

   void c(Graphics2D var1) {
      this.undoWorldTransform(var1);
      Image var2 = this.getImage();
      int var3 = var2.getWidth((ImageObserver)null);
      int var4 = var2.getHeight((ImageObserver)null);
      int var5 = this.a.getWidth();
      int var6 = this.a.getHeight();
      var1.drawImage(var2, (var5 - var3) / 2, (var6 - var4) / 2, (ImageObserver)null);
   }

   private void a(ch var1) {
      w var2 = var1.getBackgroundRenderer();
      if(var2 instanceof M) {
         this.a((M)var2);
      }

   }

   private void a(M var1) {
      this.setColor(var1.getColor());
      this.setImage(var1.getImage());
      Point var2 = var1.getImageOrigin();
      this.setImageOrigin(var2.getX(), var2.getY());
      this.setMode(var1.getMode());
   }

   private void a() {
      this.setColor(Color.WHITE);
      this.setImage((Image)null);
      this.setImageOrigin(0.0D, 0.0D);
      this.setMode((byte)4);
   }
}
