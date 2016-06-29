package y.h;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.geom.Point2D;
import java.awt.geom.Point2D.Double;
import javax.swing.Timer;
import y.h.fD;

final class fH implements ActionListener {
   private final Timer a;
   private Double b;
   private long c;
   private double d;
   private final fD e;

   public fH(fD var1) {
      this.e = var1;
      this.b = new Double(0.0D, 0.0D);
      this.a = new Timer(20, this);
      this.a.setRepeats(true);
      this.a.setDelay(20);
   }

   public void actionPerformed(ActionEvent var1) {
      Point2D var2 = this.e.tc.getCenter();
      double var3 = this.e.tc.getZoom();
      double var5 = this.b.x - var2.getX();
      double var7 = this.b.y - var2.getY();
      double var9 = var2.getX() + var5 * this.d;
      double var11 = var2.getY() + var7 * this.d;
      var5 = this.b.x - var9;
      var7 = this.b.y - var11;
      if(this.d >= 1.0D || System.currentTimeMillis() > this.c || Math.max(Math.abs(var5), Math.abs(var7)) * var3 < 5.0D) {
         this.a.stop();
         var9 = this.b.x;
         var11 = this.b.y;
      }

      this.e.tc.setCenter(var9, var11);
      this.e.tc.updateView();
   }

   public void a(double var1, double var3, double var5) {
      this.b.x = var1;
      this.b.y = var3;
      this.d = var5;
      this.c = System.currentTimeMillis() + 500L;
      if(!this.a.isRunning()) {
         this.a.start();
      }

   }
}
