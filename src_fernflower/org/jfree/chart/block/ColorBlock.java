package org.jfree.chart.block;

import java.awt.Graphics2D;
import java.awt.Paint;
import java.awt.geom.Rectangle2D;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import org.jfree.chart.block.AbstractBlock;
import org.jfree.chart.block.Block;
import org.jfree.io.SerialUtilities;
import org.jfree.util.PaintUtilities;

public class ColorBlock extends AbstractBlock implements Block {
   private transient Paint paint;

   public ColorBlock(Paint var1, double var2, double var4) {
      if(var1 == null) {
         throw new IllegalArgumentException("Null \'paint\' argument.");
      } else {
         this.paint = var1;
         this.setWidth(var2);
         this.setHeight(var4);
      }
   }

   public Paint getPaint() {
      return this.paint;
   }

   public void draw(Graphics2D var1, Rectangle2D var2) {
      Rectangle2D var3 = this.getBounds();
      var1.setPaint(this.paint);
      var1.fill(var3);
   }

   public Object draw(Graphics2D var1, Rectangle2D var2, Object var3) {
      this.draw(var1, var2);
      return null;
   }

   public boolean equals(Object var1) {
      if(var1 == this) {
         return true;
      } else if(!(var1 instanceof ColorBlock)) {
         return false;
      } else {
         ColorBlock var2 = (ColorBlock)var1;
         return !PaintUtilities.equal(this.paint, var2.paint)?false:super.equals(var1);
      }
   }

   private void writeObject(ObjectOutputStream var1) {
      var1.defaultWriteObject();
      SerialUtilities.writePaint(this.paint, var1);
   }

   private void readObject(ObjectInputStream var1) {
      var1.defaultReadObject();
      this.paint = SerialUtilities.readPaint(var1);
   }
}
