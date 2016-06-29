package org.jfree.chart.axis;

import java.util.ArrayList;
import java.util.List;
import org.jfree.chart.axis.Axis;
import org.jfree.ui.RectangleEdge;

public class AxisCollection {
   private List axesAtTop = new ArrayList();
   private List axesAtBottom = new ArrayList();
   private List axesAtLeft = new ArrayList();
   private List axesAtRight = new ArrayList();

   public List getAxesAtTop() {
      return this.axesAtTop;
   }

   public List getAxesAtBottom() {
      return this.axesAtBottom;
   }

   public List getAxesAtLeft() {
      return this.axesAtLeft;
   }

   public List getAxesAtRight() {
      return this.axesAtRight;
   }

   public void add(Axis var1, RectangleEdge var2) {
      if(var1 == null) {
         throw new IllegalArgumentException("Null \'axis\' argument.");
      } else if(var2 == null) {
         throw new IllegalArgumentException("Null \'edge\' argument.");
      } else {
         if(var2 == RectangleEdge.TOP) {
            this.axesAtTop.add(var1);
         } else if(var2 == RectangleEdge.BOTTOM) {
            this.axesAtBottom.add(var1);
         } else if(var2 == RectangleEdge.LEFT) {
            this.axesAtLeft.add(var1);
         } else if(var2 == RectangleEdge.RIGHT) {
            this.axesAtRight.add(var1);
         }

      }
   }
}
