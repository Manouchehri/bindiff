package org.jfree.chart.axis;

import java.awt.AlphaComposite;
import java.awt.Color;
import java.awt.Composite;
import java.awt.Font;
import java.awt.FontMetrics;
import java.awt.Graphics2D;
import java.awt.font.LineMetrics;
import java.awt.geom.Rectangle2D;
import java.awt.geom.Rectangle2D.Double;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import org.jfree.chart.axis.NumberAxis;
import org.jfree.chart.plot.IntervalMarker;
import org.jfree.text.TextUtilities;
import org.jfree.ui.RectangleEdge;
import org.jfree.util.ObjectUtilities;

public class MarkerAxisBand implements Serializable {
   private static final long serialVersionUID = -1729482413886398919L;
   private NumberAxis axis;
   private double topOuterGap;
   private double topInnerGap;
   private double bottomOuterGap;
   private double bottomInnerGap;
   private Font font;
   private List markers;

   public MarkerAxisBand(NumberAxis var1, double var2, double var4, double var6, double var8, Font var10) {
      this.axis = var1;
      this.topOuterGap = var2;
      this.topInnerGap = var4;
      this.bottomOuterGap = var6;
      this.bottomInnerGap = var8;
      this.font = var10;
      this.markers = new ArrayList();
   }

   public void addMarker(IntervalMarker var1) {
      this.markers.add(var1);
   }

   public double getHeight(Graphics2D var1) {
      double var2 = 0.0D;
      if(this.markers.size() > 0) {
         LineMetrics var4 = this.font.getLineMetrics("123g", var1.getFontRenderContext());
         var2 = this.topOuterGap + this.topInnerGap + (double)var4.getHeight() + this.bottomInnerGap + this.bottomOuterGap;
      }

      return var2;
   }

   private void drawStringInRect(Graphics2D var1, Rectangle2D var2, Font var3, String var4) {
      var1.setFont(var3);
      FontMetrics var5 = var1.getFontMetrics(var3);
      Rectangle2D var6 = TextUtilities.getTextBounds(var4, var1, var5);
      double var7 = var2.getX();
      if(var6.getWidth() < var2.getWidth()) {
         var7 += (var2.getWidth() - var6.getWidth()) / 2.0D;
      }

      LineMetrics var9 = var3.getLineMetrics(var4, var1.getFontRenderContext());
      var1.drawString(var4, (float)var7, (float)(var2.getMaxY() - this.bottomInnerGap - (double)var9.getDescent()));
   }

   public void draw(Graphics2D var1, Rectangle2D var2, Rectangle2D var3, double var4, double var6) {
      double var8 = this.getHeight(var1);
      Iterator var10 = this.markers.iterator();

      while(var10.hasNext()) {
         IntervalMarker var11 = (IntervalMarker)var10.next();
         double var12 = Math.max(var11.getStartValue(), this.axis.getRange().getLowerBound());
         double var14 = Math.min(var11.getEndValue(), this.axis.getRange().getUpperBound());
         double var16 = this.axis.valueToJava2D(var12, var3, RectangleEdge.BOTTOM);
         double var18 = this.axis.valueToJava2D(var14, var3, RectangleEdge.BOTTOM);
         Double var20 = new Double(var16, var6 + this.topOuterGap, var18 - var16, var8 - this.topOuterGap - this.bottomOuterGap);
         Composite var21 = var1.getComposite();
         var1.setComposite(AlphaComposite.getInstance(3, var11.getAlpha()));
         var1.setPaint(var11.getPaint());
         var1.fill(var20);
         var1.setPaint(var11.getOutlinePaint());
         var1.draw(var20);
         var1.setComposite(var21);
         var1.setPaint(Color.black);
         this.drawStringInRect(var1, var20, this.font, var11.getLabel());
      }

   }

   public boolean equals(Object var1) {
      if(var1 == this) {
         return true;
      } else if(!(var1 instanceof MarkerAxisBand)) {
         return false;
      } else {
         MarkerAxisBand var2 = (MarkerAxisBand)var1;
         return this.topOuterGap != var2.topOuterGap?false:(this.topInnerGap != var2.topInnerGap?false:(this.bottomInnerGap != var2.bottomInnerGap?false:(this.bottomOuterGap != var2.bottomOuterGap?false:(!ObjectUtilities.equal(this.font, var2.font)?false:ObjectUtilities.equal(this.markers, var2.markers)))));
      }
   }

   public int hashCode() {
      byte var1 = 37;
      int var2 = 19 * var1 + this.font.hashCode();
      var2 = 19 * var2 + this.markers.hashCode();
      return var2;
   }
}
