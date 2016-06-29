package com.google.common.collect;

import com.google.common.base.Objects;
import com.google.common.collect.MapDifference;
import com.google.common.collect.Maps;
import java.util.Map;

class Maps$MapDifferenceImpl implements MapDifference {
   final Map onlyOnLeft;
   final Map onlyOnRight;
   final Map onBoth;
   final Map differences;

   Maps$MapDifferenceImpl(Map var1, Map var2, Map var3, Map var4) {
      this.onlyOnLeft = Maps.access$100(var1);
      this.onlyOnRight = Maps.access$100(var2);
      this.onBoth = Maps.access$100(var3);
      this.differences = Maps.access$100(var4);
   }

   public boolean areEqual() {
      return this.onlyOnLeft.isEmpty() && this.onlyOnRight.isEmpty() && this.differences.isEmpty();
   }

   public Map entriesOnlyOnLeft() {
      return this.onlyOnLeft;
   }

   public Map entriesOnlyOnRight() {
      return this.onlyOnRight;
   }

   public Map entriesInCommon() {
      return this.onBoth;
   }

   public Map entriesDiffering() {
      return this.differences;
   }

   public boolean equals(Object var1) {
      if(var1 == this) {
         return true;
      } else if(!(var1 instanceof MapDifference)) {
         return false;
      } else {
         MapDifference var2 = (MapDifference)var1;
         return this.entriesOnlyOnLeft().equals(var2.entriesOnlyOnLeft()) && this.entriesOnlyOnRight().equals(var2.entriesOnlyOnRight()) && this.entriesInCommon().equals(var2.entriesInCommon()) && this.entriesDiffering().equals(var2.entriesDiffering());
      }
   }

   public int hashCode() {
      return Objects.hashCode(new Object[]{this.entriesOnlyOnLeft(), this.entriesOnlyOnRight(), this.entriesInCommon(), this.entriesDiffering()});
   }

   public String toString() {
      if(this.areEqual()) {
         return "equal";
      } else {
         StringBuilder var1 = new StringBuilder("not equal");
         if(!this.onlyOnLeft.isEmpty()) {
            var1.append(": only on left=").append(this.onlyOnLeft);
         }

         if(!this.onlyOnRight.isEmpty()) {
            var1.append(": only on right=").append(this.onlyOnRight);
         }

         if(!this.differences.isEmpty()) {
            var1.append(": value differences=").append(this.differences);
         }

         return var1.toString();
      }
   }
}
