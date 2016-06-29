package org.jfree.chart.entity;

import java.awt.Shape;
import java.io.Serializable;
import org.jfree.chart.entity.ChartEntity;

public class TickLabelEntity extends ChartEntity implements Serializable, Cloneable {
   private static final long serialVersionUID = 681583956588092095L;

   public TickLabelEntity(Shape var1, String var2, String var3) {
      super(var1, var2, var3);
   }
}
