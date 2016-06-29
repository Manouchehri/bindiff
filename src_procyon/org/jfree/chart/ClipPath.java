package org.jfree.chart;

import org.jfree.chart.axis.*;
import java.awt.geom.*;
import java.awt.*;
import org.jfree.ui.*;

public class ClipPath implements Cloneable
{
    private double[] xValue;
    private double[] yValue;
    private boolean clip;
    private boolean drawPath;
    private boolean fillPath;
    private Paint fillPaint;
    private Paint drawPaint;
    private Stroke drawStroke;
    private Composite composite;
    
    public ClipPath() {
        this.xValue = null;
        this.yValue = null;
        this.clip = true;
        this.drawPath = false;
        this.fillPath = false;
        this.fillPaint = null;
        this.drawPaint = null;
        this.drawStroke = null;
        this.composite = null;
    }
    
    public ClipPath(final double[] array, final double[] array2) {
        this(array, array2, true, false, true);
    }
    
    public ClipPath(final double[] xValue, final double[] yValue, final boolean clip, final boolean fillPath, final boolean drawPath) {
        this.xValue = null;
        this.yValue = null;
        this.clip = true;
        this.drawPath = false;
        this.fillPath = false;
        this.fillPaint = null;
        this.drawPaint = null;
        this.drawStroke = null;
        this.composite = null;
        this.xValue = xValue;
        this.yValue = yValue;
        this.clip = clip;
        this.fillPath = fillPath;
        this.drawPath = drawPath;
        this.fillPaint = Color.gray;
        this.drawPaint = Color.blue;
        this.drawStroke = new BasicStroke(1.0f);
        this.composite = AlphaComposite.Src;
    }
    
    public ClipPath(final double[] xValue, final double[] yValue, final boolean fillPath, final boolean drawPath, final Paint fillPaint, final Paint drawPaint, final Stroke drawStroke, final Composite composite) {
        this.xValue = null;
        this.yValue = null;
        this.clip = true;
        this.drawPath = false;
        this.fillPath = false;
        this.fillPaint = null;
        this.drawPaint = null;
        this.drawStroke = null;
        this.composite = null;
        this.xValue = xValue;
        this.yValue = yValue;
        this.fillPath = fillPath;
        this.drawPath = drawPath;
        this.fillPaint = fillPaint;
        this.drawPaint = drawPaint;
        this.drawStroke = drawStroke;
        this.composite = composite;
    }
    
    public GeneralPath draw(final Graphics2D graphics2D, final Rectangle2D rectangle2D, final ValueAxis valueAxis, final ValueAxis valueAxis2) {
        final GeneralPath generateClipPath = this.generateClipPath(rectangle2D, valueAxis, valueAxis2);
        if (this.fillPath || this.drawPath) {
            final Composite composite = graphics2D.getComposite();
            final Paint paint = graphics2D.getPaint();
            final Stroke stroke = graphics2D.getStroke();
            if (this.fillPaint != null) {
                graphics2D.setPaint(this.fillPaint);
            }
            if (this.composite != null) {
                graphics2D.setComposite(this.composite);
            }
            if (this.fillPath) {
                graphics2D.fill(generateClipPath);
            }
            if (this.drawStroke != null) {
                graphics2D.setStroke(this.drawStroke);
            }
            if (this.drawPath) {
                graphics2D.draw(generateClipPath);
            }
            graphics2D.setPaint(paint);
            graphics2D.setComposite(composite);
            graphics2D.setStroke(stroke);
        }
        return generateClipPath;
    }
    
    public GeneralPath generateClipPath(final Rectangle2D rectangle2D, final ValueAxis valueAxis, final ValueAxis valueAxis2) {
        final GeneralPath generalPath = new GeneralPath();
        generalPath.moveTo((float)valueAxis.valueToJava2D(this.xValue[0], rectangle2D, RectangleEdge.BOTTOM), (float)valueAxis2.valueToJava2D(this.yValue[0], rectangle2D, RectangleEdge.LEFT));
        for (int i = 0; i < this.yValue.length; ++i) {
            generalPath.lineTo((float)valueAxis.valueToJava2D(this.xValue[i], rectangle2D, RectangleEdge.BOTTOM), (float)valueAxis2.valueToJava2D(this.yValue[i], rectangle2D, RectangleEdge.LEFT));
        }
        generalPath.closePath();
        return generalPath;
    }
    
    public Composite getComposite() {
        return this.composite;
    }
    
    public Paint getDrawPaint() {
        return this.drawPaint;
    }
    
    public boolean isDrawPath() {
        return this.drawPath;
    }
    
    public Stroke getDrawStroke() {
        return this.drawStroke;
    }
    
    public Paint getFillPaint() {
        return this.fillPaint;
    }
    
    public boolean isFillPath() {
        return this.fillPath;
    }
    
    public double[] getXValue() {
        return this.xValue;
    }
    
    public double[] getYValue() {
        return this.yValue;
    }
    
    public void setComposite(final Composite composite) {
        this.composite = composite;
    }
    
    public void setDrawPaint(final Paint drawPaint) {
        this.drawPaint = drawPaint;
    }
    
    public void setDrawPath(final boolean drawPath) {
        this.drawPath = drawPath;
    }
    
    public void setDrawStroke(final Stroke drawStroke) {
        this.drawStroke = drawStroke;
    }
    
    public void setFillPaint(final Paint fillPaint) {
        this.fillPaint = fillPaint;
    }
    
    public void setFillPath(final boolean fillPath) {
        this.fillPath = fillPath;
    }
    
    public void setXValue(final double[] xValue) {
        this.xValue = xValue;
    }
    
    public void setYValue(final double[] yValue) {
        this.yValue = yValue;
    }
    
    public boolean isClip() {
        return this.clip;
    }
    
    public void setClip(final boolean clip) {
        this.clip = clip;
    }
    
    public Object clone() {
        final ClipPath clipPath = (ClipPath)super.clone();
        clipPath.xValue = this.xValue.clone();
        clipPath.yValue = this.yValue.clone();
        return clipPath;
    }
}
