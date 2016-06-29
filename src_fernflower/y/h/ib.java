package y.h;

import java.awt.AlphaComposite;
import java.awt.Color;
import java.awt.image.BufferedImage;

class ib {
   public static final Color a = new Color(0, 0, 0, 77);
   private double b;
   private Color c;
   private BufferedImage d;
   private final int e;
   private final double f;
   private AlphaComposite g;

   public ib() {
      this(3.0D, a);
   }

   public ib(double var1, Color var3) {
      this.b = 3.0D;
      this.c = a;
      this.e = 9;
      this.f = 2.0D;
      this.g = AlphaComposite.getInstance(5, 1.0F);
      this.a(var1);
      this.a(var3);
   }

   public void a(double var1) {
      if(this.b != var1) {
         this.b = var1;
         this.a();
      }

   }

   public void a(Color var1) {
      if(this.c != var1) {
         this.c = var1;
         this.a();
      }

   }

   protected void a() {
      this.d = null;
   }
}
