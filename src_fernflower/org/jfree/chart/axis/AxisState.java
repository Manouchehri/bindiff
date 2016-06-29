package org.jfree.chart.axis;

import java.util.ArrayList;
import java.util.List;
import org.jfree.ui.RectangleEdge;

public class AxisState {
   private double cursor;
   private List ticks;
   private double max;

   public AxisState() {
      this(0.0D);
   }

   public AxisState(double var1) {
      this.cursor = var1;
      this.ticks = new ArrayList();
   }

   public double getCursor() {
      return this.cursor;
   }

   public void setCursor(double var1) {
      this.cursor = var1;
   }

   public void moveCursor(double var1, RectangleEdge var3) {
      if(var3 == RectangleEdge.TOP) {
         this.cursorUp(var1);
      } else if(var3 == RectangleEdge.BOTTOM) {
         this.cursorDown(var1);
      } else if(var3 == RectangleEdge.LEFT) {
         this.cursorLeft(var1);
      } else if(var3 == RectangleEdge.RIGHT) {
         this.cursorRight(var1);
      }

   }

   public void cursorUp(double var1) {
      this.cursor -= var1;
   }

   public void cursorDown(double var1) {
      this.cursor += var1;
   }

   public void cursorLeft(double var1) {
      this.cursor -= var1;
   }

   public void cursorRight(double var1) {
      this.cursor += var1;
   }

   public List getTicks() {
      return this.ticks;
   }

   public void setTicks(List var1) {
      this.ticks = var1;
   }

   public double getMax() {
      return this.max;
   }

   public void setMax(double var1) {
      this.max = var1;
   }
}
