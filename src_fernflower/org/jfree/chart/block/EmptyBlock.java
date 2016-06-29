package org.jfree.chart.block;

import java.awt.Graphics2D;
import java.awt.geom.Rectangle2D;
import java.io.Serializable;
import org.jfree.chart.block.AbstractBlock;
import org.jfree.chart.block.Block;
import org.jfree.util.PublicCloneable;

public class EmptyBlock extends AbstractBlock implements Serializable, Cloneable, Block, PublicCloneable {
   private static final long serialVersionUID = -4083197869412648579L;

   public EmptyBlock(double var1, double var3) {
      this.setWidth(var1);
      this.setHeight(var3);
   }

   public void draw(Graphics2D var1, Rectangle2D var2) {
   }

   public Object draw(Graphics2D var1, Rectangle2D var2, Object var3) {
      return null;
   }

   public Object clone() {
      return super.clone();
   }
}
