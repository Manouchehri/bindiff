package com.google.security.zynamics.zylib.gui.JHexPanel;

import com.google.security.zynamics.zylib.gui.JHexPanel.ColoredRange;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;

public class ColoredRangeManager {
   private final ArrayList ranges = new ArrayList();

   public void addRange(ColoredRange var1) {
      this.ranges.add(var1);
      Collections.sort(this.ranges);
   }

   public void clear() {
      this.ranges.clear();
   }

   public ColoredRange findRange(long var1) {
      Iterator var3 = this.ranges.iterator();

      ColoredRange var4;
      do {
         if(!var3.hasNext()) {
            return null;
         }

         var4 = (ColoredRange)var3.next();
      } while(var4.getStart() < var1);

      return var4;
   }

   public ColoredRange findRangeWith(long var1) {
      Iterator var3 = this.ranges.iterator();

      ColoredRange var4;
      do {
         if(!var3.hasNext()) {
            return null;
         }

         var4 = (ColoredRange)var3.next();
      } while(!var4.containsOffset(var1));

      return var4;
   }

   public void removeRange(long var1, int var3) {
      ColoredRange var4 = this.findRangeWith(var1);
      if(var4 == null) {
         var4 = this.findRange(var1);
      }

      if(var4 != null) {
         if(var1 <= var4.getStart()) {
            if(var4.getSize() == var3) {
               this.ranges.remove(var4);
            } else if(var4.getSize() < var3) {
               this.ranges.remove(var4);
               this.removeRange(var4.getStart() + (long)var4.getSize(), var3 - var4.getSize());
            } else {
               this.ranges.remove(var4);
               this.addRange(new ColoredRange(var1 + (long)var3, var4.getSize() - var3, var4.getColor(), var4.getBackgroundColor()));
            }
         } else {
            long var5;
            int var7;
            if(var1 + (long)var3 == var4.getStart() + (long)var4.getSize()) {
               this.ranges.remove(var4);
               var5 = var4.getStart();
               var7 = var4.getSize() - var3;
               this.addRange(new ColoredRange(var5, var7, var4.getColor(), var4.getBackgroundColor()));
            } else if(var1 + (long)var3 < var4.getStart() + (long)var4.getSize()) {
               this.ranges.remove(var4);
               var5 = var4.getStart();
               var7 = (int)(var1 - var4.getStart());
               this.addRange(new ColoredRange(var5, var7, var4.getColor(), var4.getBackgroundColor()));
               long var8 = var1 + (long)var3;
               int var10 = (int)(var4.getStart() + (long)var4.getSize() - var1 - (long)var3);
               this.addRange(new ColoredRange(var8, var10, var4.getColor(), var4.getBackgroundColor()));
            } else {
               this.ranges.remove(var4);
               var5 = var4.getStart();
               var7 = (int)(var1 - var4.getStart());
               this.addRange(new ColoredRange(var5, var7, var4.getColor(), var4.getBackgroundColor()));
               this.removeRange(var4.getStart() + (long)var4.getSize(), var3 - (int)(var4.getStart() + (long)var4.getSize() - var1));
            }
         }

      }
   }
}
