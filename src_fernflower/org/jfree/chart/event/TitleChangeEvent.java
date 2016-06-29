package org.jfree.chart.event;

import org.jfree.chart.event.ChartChangeEvent;
import org.jfree.chart.title.Title;

public class TitleChangeEvent extends ChartChangeEvent {
   private Title title;

   public TitleChangeEvent(Title var1) {
      super(var1);
      this.title = var1;
   }

   public Title getTitle() {
      return this.title;
   }
}
