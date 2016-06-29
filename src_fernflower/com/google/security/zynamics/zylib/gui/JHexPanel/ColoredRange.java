package com.google.security.zynamics.zylib.gui.JHexPanel;

import java.awt.Color;

public class ColoredRange implements Comparable {
   private final Color fcolor;
   private final long start;
   private final int size;
   private final Color bgcolor;

   public ColoredRange(long var1, int var3, Color var4, Color var5) {
      this.start = var1;
      this.size = var3;
      this.fcolor = var4;
      this.bgcolor = var5;
   }

   public int compareTo(ColoredRange var1) {
      return (int)(this.start - var1.start);
   }

   public boolean containsOffset(long var1) {
      return var1 >= this.start && var1 < this.start + (long)this.size;
   }

   public Color getBackgroundColor() {
      return this.bgcolor;
   }

   public Color getColor() {
      return this.fcolor;
   }

   public int getSize() {
      return this.size;
   }

   public long getStart() {
      return this.start;
   }
}
