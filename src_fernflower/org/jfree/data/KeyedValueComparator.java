package org.jfree.data;

import java.util.Comparator;
import org.jfree.data.KeyedValue;
import org.jfree.data.KeyedValueComparatorType;
import org.jfree.util.SortOrder;

public class KeyedValueComparator implements Comparator {
   private KeyedValueComparatorType type;
   private SortOrder order;

   public KeyedValueComparator(KeyedValueComparatorType var1, SortOrder var2) {
      if(var2 == null) {
         throw new IllegalArgumentException("Null \'order\' argument.");
      } else {
         this.type = var1;
         this.order = var2;
      }
   }

   public KeyedValueComparatorType getType() {
      return this.type;
   }

   public SortOrder getOrder() {
      return this.order;
   }

   public int compare(Object var1, Object var2) {
      if(var2 == null) {
         return -1;
      } else if(var1 == null) {
         return 1;
      } else {
         KeyedValue var4 = (KeyedValue)var1;
         KeyedValue var5 = (KeyedValue)var2;
         int var3;
         if(this.type == KeyedValueComparatorType.BY_KEY) {
            if(this.order.equals(SortOrder.ASCENDING)) {
               var3 = var4.getKey().compareTo(var5.getKey());
            } else {
               if(!this.order.equals(SortOrder.DESCENDING)) {
                  throw new IllegalArgumentException("Unrecognised sort order.");
               }

               var3 = var5.getKey().compareTo(var4.getKey());
            }
         } else {
            if(this.type != KeyedValueComparatorType.BY_VALUE) {
               throw new IllegalArgumentException("Unrecognised type.");
            }

            Number var6 = var4.getValue();
            Number var7 = var5.getValue();
            if(var7 == null) {
               return -1;
            }

            if(var6 == null) {
               return 1;
            }

            double var8 = var6.doubleValue();
            double var10 = var7.doubleValue();
            if(this.order.equals(SortOrder.ASCENDING)) {
               if(var8 > var10) {
                  var3 = 1;
               } else if(var8 < var10) {
                  var3 = -1;
               } else {
                  var3 = 0;
               }
            } else {
               if(!this.order.equals(SortOrder.DESCENDING)) {
                  throw new IllegalArgumentException("Unrecognised sort order.");
               }

               if(var8 > var10) {
                  var3 = -1;
               } else if(var8 < var10) {
                  var3 = 1;
               } else {
                  var3 = 0;
               }
            }
         }

         return var3;
      }
   }
}
