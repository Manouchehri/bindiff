package y.h;

import java.awt.Color;
import java.awt.Font;
import java.awt.Rectangle;
import java.awt.font.TextLayout;
import java.awt.geom.Rectangle2D.Double;
import y.h.ca;
import y.h.cb;
import y.h.cc;

public abstract class bX implements ca, cc {
   String a = "";
   Font b = new Font("Dialog", 0, 24);
   Color c;
   cb d;
   TextLayout e;
   Double f = new Double();

   public bX() {
      this.c = Color.black;
   }

   public void a(cb var1) {
      this.d = var1;
   }

   public Rectangle getBounds() {
      this.a();
      return this.f.getBounds();
   }

   abstract void a();

   public void a(Font var1) {
      this.b = var1;
   }

   public void a(String var1) {
      this.a = var1;
   }

   public void a(Color var1) {
      this.c = var1;
   }
}
