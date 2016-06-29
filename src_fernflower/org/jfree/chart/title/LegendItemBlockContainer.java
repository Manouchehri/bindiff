package org.jfree.chart.title;

import java.awt.Graphics2D;
import java.awt.Shape;
import java.awt.geom.Rectangle2D;
import org.jfree.chart.block.Arrangement;
import org.jfree.chart.block.BlockContainer;
import org.jfree.chart.block.BlockResult;
import org.jfree.chart.block.EntityBlockParams;
import org.jfree.chart.entity.LegendItemEntity;
import org.jfree.chart.entity.StandardEntityCollection;

public class LegendItemBlockContainer extends BlockContainer {
   private int dataset;
   private int series;
   private String toolTipText;
   private String urlText;

   public LegendItemBlockContainer(Arrangement var1, int var2, int var3) {
      super(var1);
      this.dataset = var2;
      this.series = var3;
   }

   public int getDatasetIndex() {
      return this.dataset;
   }

   public int getSeriesIndex() {
      return this.series;
   }

   public String getToolTipText() {
      return this.toolTipText;
   }

   public void setToolTipText(String var1) {
      this.toolTipText = var1;
   }

   public String getURLText() {
      return this.urlText;
   }

   public void setURLText(String var1) {
      this.urlText = var1;
   }

   public Object draw(Graphics2D var1, Rectangle2D var2, Object var3) {
      super.draw(var1, var2, (Object)null);
      EntityBlockParams var4 = null;
      BlockResult var5 = new BlockResult();
      if(var3 instanceof EntityBlockParams) {
         var4 = (EntityBlockParams)var3;
         if(var4.getGenerateEntities()) {
            StandardEntityCollection var6 = new StandardEntityCollection();
            LegendItemEntity var7 = new LegendItemEntity((Shape)var2.clone());
            var7.setSeriesIndex(this.series);
            var7.setToolTipText(this.getToolTipText());
            var7.setURLText(this.getURLText());
            var6.add(var7);
            var5.setEntityCollection(var6);
         }
      }

      return var5;
   }
}
