package org.jfree.chart.renderer.xy;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics2D;
import java.awt.Paint;
import java.awt.Stroke;
import java.awt.geom.Rectangle2D;
import java.awt.geom.Line2D.Double;
import java.io.Serializable;
import org.jfree.chart.axis.ValueAxis;
import org.jfree.chart.plot.CrosshairState;
import org.jfree.chart.plot.PlotRenderingInfo;
import org.jfree.chart.plot.XYPlot;
import org.jfree.chart.renderer.xy.AbstractXYItemRenderer;
import org.jfree.chart.renderer.xy.XYItemRenderer;
import org.jfree.chart.renderer.xy.XYItemRendererState;
import org.jfree.data.xy.WindDataset;
import org.jfree.data.xy.XYDataset;
import org.jfree.ui.RectangleEdge;
import org.jfree.util.PublicCloneable;

public class WindItemRenderer extends AbstractXYItemRenderer implements Serializable, Cloneable, XYItemRenderer, PublicCloneable {
   private static final long serialVersionUID = 8078914101916976844L;

   public void drawItem(Graphics2D var1, XYItemRendererState var2, Rectangle2D var3, PlotRenderingInfo var4, XYPlot var5, ValueAxis var6, ValueAxis var7, XYDataset var8, int var9, int var10, CrosshairState var11, int var12) {
      WindDataset var13 = (WindDataset)var8;
      Paint var14 = this.getItemPaint(var9, var10);
      Stroke var15 = this.getItemStroke(var9, var10);
      var1.setPaint(var14);
      var1.setStroke(var15);
      Number var16 = var13.getX(var9, var10);
      Number var17 = var13.getWindDirection(var9, var10);
      Number var18 = var13.getWindForce(var9, var10);
      double var19 = var18.doubleValue();
      double var21 = Math.toRadians(var17.doubleValue() * -30.0D - 90.0D);
      RectangleEdge var35 = var5.getDomainAxisEdge();
      RectangleEdge var36 = var5.getRangeAxisEdge();
      double var23 = var6.valueToJava2D(var16.doubleValue(), var3, var35);
      double var27 = var7.valueToJava2D(0.0D, var3, var36);
      double var31 = var16.doubleValue() + var19 * Math.cos(var21) * 8000000.0D;
      double var33 = var19 * Math.sin(var21);
      double var25 = var6.valueToJava2D(var31, var3, var35);
      double var29 = var7.valueToJava2D(var33, var3, var36);
      int var37 = var17.intValue();
      int var38 = var18.intValue();
      String var39 = var37 + "-" + var38;
      Double var40 = new Double(var23, var27, var25, var29);
      var1.draw(var40);
      var1.setPaint(Color.blue);
      var1.setFont(new Font("foo", 1, 9));
      var1.drawString(var39, (float)var23, (float)var27);
      var1.setPaint(var14);
      var1.setStroke(var15);
      double var57 = Math.toRadians(var17.doubleValue() * -30.0D - 90.0D - 5.0D);
      double var49 = var18.doubleValue() * Math.cos(var57) * 8000000.0D * 0.8D + var16.doubleValue();
      double var51 = var18.doubleValue() * Math.sin(var57) * 0.8D;
      double var41 = var6.valueToJava2D(var49, var3, var35);
      double var43 = var7.valueToJava2D(var51, var3, var36);
      var40 = new Double(var41, var43, var25, var29);
      var1.draw(var40);
      double var59 = Math.toRadians(var17.doubleValue() * -30.0D - 90.0D + 5.0D);
      double var53 = var18.doubleValue() * Math.cos(var59) * 8000000.0D * 0.8D + var16.doubleValue();
      double var55 = var18.doubleValue() * Math.sin(var59) * 0.8D;
      double var45 = var6.valueToJava2D(var53, var3, var35);
      double var47 = var7.valueToJava2D(var55, var3, var36);
      var40 = new Double(var45, var47, var25, var29);
      var1.draw(var40);
   }

   public Object clone() {
      return super.clone();
   }
}
