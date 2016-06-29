package org.jfree.chart.axis;

import org.jfree.chart.axis.Tick;
import org.jfree.text.TextBlock;
import org.jfree.text.TextBlockAnchor;
import org.jfree.ui.TextAnchor;
import org.jfree.util.ObjectUtilities;

public class CategoryTick extends Tick {
   private Comparable category;
   private TextBlock label;
   private TextBlockAnchor labelAnchor;

   public CategoryTick(Comparable var1, TextBlock var2, TextBlockAnchor var3, TextAnchor var4, double var5) {
      super("", TextAnchor.CENTER, var4, var5);
      this.category = var1;
      this.label = var2;
      this.labelAnchor = var3;
   }

   public Comparable getCategory() {
      return this.category;
   }

   public TextBlock getLabel() {
      return this.label;
   }

   public TextBlockAnchor getLabelAnchor() {
      return this.labelAnchor;
   }

   public boolean equals(Object var1) {
      if(this == var1) {
         return true;
      } else if(var1 instanceof CategoryTick && super.equals(var1)) {
         CategoryTick var2 = (CategoryTick)var1;
         return !ObjectUtilities.equal(this.category, var2.category)?false:(!ObjectUtilities.equal(this.label, var2.label)?false:ObjectUtilities.equal(this.labelAnchor, var2.labelAnchor));
      } else {
         return false;
      }
   }

   public int hashCode() {
      byte var1 = 41;
      int var2 = 37 * var1 + this.category.hashCode();
      var2 = 37 * var2 + this.label.hashCode();
      var2 = 37 * var2 + this.labelAnchor.hashCode();
      return var2;
   }
}
