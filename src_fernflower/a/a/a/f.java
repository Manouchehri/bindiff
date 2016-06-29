package a.a.a;

import a.a.a.g;
import java.awt.Graphics2D;
import java.awt.Shape;
import java.awt.geom.Rectangle2D;
import java.awt.geom.Rectangle2D.Double;
import java.io.Writer;
import org.w3c.dom.Node;
import y.h.O;
import y.h.aB;
import y.h.fj;

public class f extends O {
   private g a;

   public void a(g var1) {
      this.a = var1;
   }

   protected g a() {
      return this.a;
   }

   protected void a(Node var1, Writer var2) {
      this.a().a(var1, var2);
   }

   public void paint(Graphics2D var1, fj var2) {
      Shape var3 = var1.getClip();
      if(var3 != null && var3.contains(a(var2))) {
         var1.setClip((Shape)null);
      }

      var2.paint(var1);
      var1.setClip(var3);
   }

   public void paintSloppy(Graphics2D var1, fj var2) {
      Shape var3 = var1.getClip();
      if(var3 != null && var3.contains(a(var2))) {
         var1.setClip((Shape)null);
      }

      var2.paintSloppy(var1);
      var1.setClip(var3);
   }

   public void paint(Graphics2D var1, aB var2) {
      Shape var3 = var1.getClip();
      if(var3 != null && var3.contains(a(var2))) {
         var1.setClip((Shape)null);
      }

      var2.paint(var1);
      var1.setClip(var3);
   }

   public void paintSloppy(Graphics2D var1, aB var2) {
      Shape var3 = var1.getClip();
      if(var3 != null && var3.contains(a(var2))) {
         var1.setClip((Shape)null);
      }

      var2.paintSloppy(var1);
      var1.setClip(var3);
   }

   private static Rectangle2D a(fj var0) {
      Double var1 = var0.getBoundingBox();
      if(var0.isSelected()) {
         var1.setFrame(var1.getX() - 10.0D, var1.getY() - 10.0D, var1.getWidth() + 20.0D, var1.getHeight() + 20.0D);
      }

      var0.calcUnionRect(var1);
      return var1;
   }

   private static Rectangle2D a(aB var0) {
      Double var1 = new Double(0.0D, 0.0D, -1.0D, -1.0D);
      var0.calcUnionRect(var1);
      return var1;
   }
}
