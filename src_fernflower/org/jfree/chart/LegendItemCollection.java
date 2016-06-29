package org.jfree.chart;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import org.jfree.chart.LegendItem;

public class LegendItemCollection implements Serializable, Cloneable {
   private static final long serialVersionUID = 1365215565589815953L;
   private List items = new ArrayList();

   public void add(LegendItem var1) {
      this.items.add(var1);
   }

   public void addAll(LegendItemCollection var1) {
      this.items.addAll(var1.items);
   }

   public LegendItem get(int var1) {
      return (LegendItem)this.items.get(var1);
   }

   public int getItemCount() {
      return this.items.size();
   }

   public Iterator iterator() {
      return this.items.iterator();
   }

   public boolean equals(Object var1) {
      if(var1 == this) {
         return true;
      } else if(!(var1 instanceof LegendItemCollection)) {
         return false;
      } else {
         LegendItemCollection var2 = (LegendItemCollection)var1;
         return this.items.equals(var2.items);
      }
   }

   public Object clone() {
      return super.clone();
   }
}
