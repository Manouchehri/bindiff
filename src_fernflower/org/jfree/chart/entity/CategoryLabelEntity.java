package org.jfree.chart.entity;

import java.awt.Shape;
import org.jfree.chart.entity.TickLabelEntity;

public class CategoryLabelEntity extends TickLabelEntity {
   private Comparable key;

   public CategoryLabelEntity(Comparable var1, Shape var2, String var3, String var4) {
      super(var2, var3, var4);
      this.key = var1;
   }

   public Comparable getKey() {
      return this.key;
   }

   public String toString() {
      StringBuffer var1 = new StringBuffer("CategoryLabelEntity: ");
      var1.append("category=");
      var1.append(this.key);
      var1.append(", tooltip=" + this.getToolTipText());
      var1.append(", url=" + this.getURLText());
      return var1.toString();
   }
}
