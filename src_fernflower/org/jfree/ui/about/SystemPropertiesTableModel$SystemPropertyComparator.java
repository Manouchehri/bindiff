package org.jfree.ui.about;

import java.util.Comparator;
import org.jfree.ui.about.SystemPropertiesTableModel$SystemProperty;

public class SystemPropertiesTableModel$SystemPropertyComparator implements Comparator {
   private boolean ascending;

   public SystemPropertiesTableModel$SystemPropertyComparator(boolean var1) {
      this.ascending = var1;
   }

   public int compare(Object var1, Object var2) {
      if(var1 instanceof SystemPropertiesTableModel$SystemProperty && var2 instanceof SystemPropertiesTableModel$SystemProperty) {
         SystemPropertiesTableModel$SystemProperty var3 = (SystemPropertiesTableModel$SystemProperty)var1;
         SystemPropertiesTableModel$SystemProperty var4 = (SystemPropertiesTableModel$SystemProperty)var2;
         return this.ascending?var3.getName().compareTo(var4.getName()):var4.getName().compareTo(var3.getName());
      } else {
         return 0;
      }
   }

   public boolean equals(Object var1) {
      if(this == var1) {
         return true;
      } else if(!(var1 instanceof SystemPropertiesTableModel$SystemPropertyComparator)) {
         return false;
      } else {
         SystemPropertiesTableModel$SystemPropertyComparator var2 = (SystemPropertiesTableModel$SystemPropertyComparator)var1;
         return this.ascending == var2.ascending;
      }
   }

   public int hashCode() {
      return this.ascending?1:0;
   }
}
