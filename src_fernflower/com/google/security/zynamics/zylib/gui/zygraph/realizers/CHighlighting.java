package com.google.security.zynamics.zylib.gui.zygraph.realizers;

import java.awt.Color;

public class CHighlighting implements Comparable {
   private final double m_start;
   private final double m_end;
   private final int m_level;
   private final Color m_color;

   public CHighlighting(int var1, double var2, double var4, Color var6) {
      this.m_level = var1;
      this.m_start = var2;
      this.m_end = var4;
      this.m_color = var6;
   }

   public int compareTo(CHighlighting var1) {
      return this.m_level - var1.m_level;
   }

   public Color getColor() {
      return this.m_color;
   }

   public double getEnd() {
      return this.m_end;
   }

   public int getLevel() {
      return this.m_level;
   }

   public double getStart() {
      return this.m_start;
   }
}
