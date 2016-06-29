package org.jfree.chart.title;

import java.awt.Graphics2D;
import java.awt.geom.Rectangle2D;
import java.io.Serializable;
import org.jfree.chart.block.BlockContainer;
import org.jfree.chart.block.BorderArrangement;
import org.jfree.chart.block.RectangleConstraint;
import org.jfree.chart.title.Title;
import org.jfree.ui.Size2D;

public class CompositeTitle extends Title implements Serializable, Cloneable {
   private static final long serialVersionUID = -6770854036232562290L;
   private BlockContainer container;

   public CompositeTitle() {
      this(new BlockContainer(new BorderArrangement()));
   }

   public CompositeTitle(BlockContainer var1) {
      if(var1 == null) {
         throw new IllegalArgumentException("Null \'container\' argument.");
      } else {
         this.container = var1;
      }
   }

   public BlockContainer getContainer() {
      return this.container;
   }

   public void setTitleContainer(BlockContainer var1) {
      if(var1 == null) {
         throw new IllegalArgumentException("Null \'container\' argument.");
      } else {
         this.container = var1;
      }
   }

   public Size2D arrange(Graphics2D var1, RectangleConstraint var2) {
      RectangleConstraint var3 = this.toContentConstraint(var2);
      Size2D var4 = this.container.arrange(var1, var3);
      return new Size2D(this.calculateTotalWidth(var4.getWidth()), this.calculateTotalHeight(var4.getHeight()));
   }

   public void draw(Graphics2D var1, Rectangle2D var2) {
      var2 = this.trimMargin(var2);
      this.drawBorder(var1, var2);
      var2 = this.trimBorder(var2);
      var2 = this.trimPadding(var2);
      this.container.draw(var1, var2);
   }

   public Object draw(Graphics2D var1, Rectangle2D var2, Object var3) {
      this.draw(var1, var2);
      return null;
   }

   public boolean equals(Object var1) {
      if(var1 == this) {
         return true;
      } else if(!(var1 instanceof CompositeTitle)) {
         return false;
      } else if(!super.equals(var1)) {
         return false;
      } else {
         CompositeTitle var2 = (CompositeTitle)var1;
         return this.container.equals(var2.container);
      }
   }
}
