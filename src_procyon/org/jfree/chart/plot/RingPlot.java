package org.jfree.chart.plot;

import org.jfree.data.general.*;
import org.jfree.chart.event.*;
import org.jfree.ui.*;
import java.awt.geom.*;
import java.awt.*;
import org.jfree.chart.entity.*;
import org.jfree.chart.labels.*;
import org.jfree.chart.urls.*;
import org.jfree.util.*;
import org.jfree.io.*;
import java.io.*;

public class RingPlot extends PiePlot implements Serializable, Cloneable
{
    private static final long serialVersionUID = 1556064784129676620L;
    private boolean separatorsVisible;
    private transient Stroke separatorStroke;
    private transient Paint separatorPaint;
    private double innerSeparatorExtension;
    private double outerSeparatorExtension;
    private double sectionDepth;
    
    public RingPlot() {
        this(null);
    }
    
    public RingPlot(final PieDataset pieDataset) {
        super(pieDataset);
        this.separatorsVisible = true;
        this.separatorStroke = new BasicStroke(0.5f);
        this.separatorPaint = Color.gray;
        this.innerSeparatorExtension = 0.2;
        this.outerSeparatorExtension = 0.2;
        this.sectionDepth = 0.2;
    }
    
    public boolean getSeparatorsVisible() {
        return this.separatorsVisible;
    }
    
    public void setSeparatorsVisible(final boolean separatorsVisible) {
        this.separatorsVisible = separatorsVisible;
        this.notifyListeners(new PlotChangeEvent(this));
    }
    
    public Stroke getSeparatorStroke() {
        return this.separatorStroke;
    }
    
    public void setSeparatorStroke(final Stroke separatorStroke) {
        if (separatorStroke == null) {
            throw new IllegalArgumentException("Null 'stroke' argument.");
        }
        this.separatorStroke = separatorStroke;
        this.notifyListeners(new PlotChangeEvent(this));
    }
    
    public Paint getSeparatorPaint() {
        return this.separatorPaint;
    }
    
    public void setSeparatorPaint(final Paint separatorPaint) {
        if (separatorPaint == null) {
            throw new IllegalArgumentException("Null 'paint' argument.");
        }
        this.separatorPaint = separatorPaint;
        this.notifyListeners(new PlotChangeEvent(this));
    }
    
    public double getInnerSeparatorExtension() {
        return this.innerSeparatorExtension;
    }
    
    public void setInnerSeparatorExtension(final double innerSeparatorExtension) {
        this.innerSeparatorExtension = innerSeparatorExtension;
        this.notifyListeners(new PlotChangeEvent(this));
    }
    
    public double getOuterSeparatorExtension() {
        return this.outerSeparatorExtension;
    }
    
    public void setOuterSeparatorExtension(final double outerSeparatorExtension) {
        this.outerSeparatorExtension = outerSeparatorExtension;
        this.notifyListeners(new PlotChangeEvent(this));
    }
    
    public double getSectionDepth() {
        return this.sectionDepth;
    }
    
    public void setSectionDepth(final double sectionDepth) {
        this.sectionDepth = sectionDepth;
        this.notifyListeners(new PlotChangeEvent(this));
    }
    
    public PiePlotState initialise(final Graphics2D graphics2D, final Rectangle2D rectangle2D, final PiePlot piePlot, final Integer n, final PlotRenderingInfo plotRenderingInfo) {
        final PiePlotState initialise = super.initialise(graphics2D, rectangle2D, piePlot, n, plotRenderingInfo);
        initialise.setPassesRequired(3);
        return initialise;
    }
    
    protected void drawItem(final Graphics2D graphics2D, final int n, final Rectangle2D rectangle2D, final PiePlotState piePlotState, final int n2) {
        final PieDataset dataset = this.getDataset();
        final Number value = dataset.getValue(n);
        if (value == null) {
            return;
        }
        final double doubleValue = value.doubleValue();
        final Rotation direction = this.getDirection();
        double n3;
        double latestAngle;
        if (direction == Rotation.CLOCKWISE) {
            n3 = piePlotState.getLatestAngle();
            latestAngle = n3 - doubleValue / piePlotState.getTotal() * 360.0;
        }
        else {
            if (direction != Rotation.ANTICLOCKWISE) {
                throw new IllegalStateException("Rotation type not recognised.");
            }
            n3 = piePlotState.getLatestAngle();
            latestAngle = n3 + doubleValue / piePlotState.getTotal() * 360.0;
        }
        final double n4 = latestAngle - n3;
        if (Math.abs(n4) > this.getMinimumArcAngleToDraw()) {
            final Comparable sectionKey = this.getSectionKey(n);
            double n5 = 0.0;
            final double maximumExplodePercent = this.getMaximumExplodePercent();
            if (maximumExplodePercent > 0.0) {
                n5 = this.getExplodePercent(sectionKey) / maximumExplodePercent;
            }
            final Rectangle2D arcBounds = this.getArcBounds(piePlotState.getPieArea(), piePlotState.getExplodedPieArea(), n3, n4, n5);
            final Arc2D.Double double1 = new Arc2D.Double(arcBounds, n3, n4, 0);
            final double n6 = this.sectionDepth / 2.0;
            final RectangleInsets rectangleInsets = new RectangleInsets(UnitType.RELATIVE, n6, n6, n6, n6);
            final Rectangle2D.Double double2 = new Rectangle2D.Double();
            double2.setRect(arcBounds);
            rectangleInsets.trim(double2);
            final Arc2D.Double double3 = new Arc2D.Double(double2, n3 + n4, -n4, 0);
            final GeneralPath generalPath = new GeneralPath();
            generalPath.moveTo((float)double1.getStartPoint().getX(), (float)double1.getStartPoint().getY());
            generalPath.append(double1.getPathIterator(null), false);
            generalPath.append(double3.getPathIterator(null), true);
            generalPath.closePath();
            final Line2D.Double double4 = new Line2D.Double(double3.getEndPoint(), double1.getStartPoint());
            if (n2 == 0) {
                final Paint shadowPaint = this.getShadowPaint();
                final double shadowXOffset = this.getShadowXOffset();
                final double shadowYOffset = this.getShadowYOffset();
                if (shadowPaint != null) {
                    final Shape translatedShape = ShapeUtilities.createTranslatedShape(generalPath, (float)shadowXOffset, (float)shadowYOffset);
                    graphics2D.setPaint(shadowPaint);
                    graphics2D.fill(translatedShape);
                }
            }
            else if (n2 == 1) {
                graphics2D.setPaint(this.lookupSectionPaint(sectionKey, true));
                graphics2D.fill(generalPath);
                final Paint lookupSectionOutlinePaint = this.lookupSectionOutlinePaint(sectionKey);
                final Stroke lookupSectionOutlineStroke = this.lookupSectionOutlineStroke(sectionKey);
                if (lookupSectionOutlinePaint != null && lookupSectionOutlineStroke != null) {
                    graphics2D.setPaint(lookupSectionOutlinePaint);
                    graphics2D.setStroke(lookupSectionOutlineStroke);
                    graphics2D.draw(generalPath);
                }
                if (piePlotState.getInfo() != null) {
                    final EntityCollection entityCollection = piePlotState.getEntityCollection();
                    if (entityCollection != null) {
                        String generateToolTip = null;
                        final PieToolTipGenerator toolTipGenerator = this.getToolTipGenerator();
                        if (toolTipGenerator != null) {
                            generateToolTip = toolTipGenerator.generateToolTip(dataset, sectionKey);
                        }
                        String generateURL = null;
                        final PieURLGenerator urlGenerator = this.getURLGenerator();
                        if (urlGenerator != null) {
                            generateURL = urlGenerator.generateURL(dataset, sectionKey, this.getPieIndex());
                        }
                        entityCollection.add(new PieSectionEntity(generalPath, dataset, this.getPieIndex(), n, sectionKey, generateToolTip, generateURL));
                    }
                }
            }
            else if (n2 == 2 && this.separatorsVisible) {
                final Line2D extendLine = this.extendLine(double4, this.innerSeparatorExtension, this.outerSeparatorExtension);
                graphics2D.setStroke(this.separatorStroke);
                graphics2D.setPaint(this.separatorPaint);
                graphics2D.draw(extendLine);
            }
        }
        piePlotState.setLatestAngle(latestAngle);
    }
    
    public boolean equals(final Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof RingPlot)) {
            return false;
        }
        final RingPlot ringPlot = (RingPlot)o;
        return this.separatorsVisible == ringPlot.separatorsVisible && ObjectUtilities.equal(this.separatorStroke, ringPlot.separatorStroke) && PaintUtilities.equal(this.separatorPaint, ringPlot.separatorPaint) && this.innerSeparatorExtension == ringPlot.innerSeparatorExtension && this.outerSeparatorExtension == ringPlot.outerSeparatorExtension && this.sectionDepth == ringPlot.sectionDepth && super.equals(o);
    }
    
    private Line2D extendLine(final Line2D line2D, final double n, final double n2) {
        if (line2D == null) {
            throw new IllegalArgumentException("Null 'line' argument.");
        }
        final double x1 = line2D.getX1();
        final double x2 = line2D.getX2();
        final double n3 = x2 - x1;
        final double y1 = line2D.getY1();
        final double y2 = line2D.getY2();
        final double n4 = y2 - y1;
        return new Line2D.Double(x1 - n * n3, y1 - n * n4, x2 + n2 * n3, y2 + n2 * n4);
    }
    
    private void writeObject(final ObjectOutputStream objectOutputStream) {
        objectOutputStream.defaultWriteObject();
        SerialUtilities.writeStroke(this.separatorStroke, objectOutputStream);
        SerialUtilities.writePaint(this.separatorPaint, objectOutputStream);
    }
    
    private void readObject(final ObjectInputStream objectInputStream) {
        objectInputStream.defaultReadObject();
        this.separatorStroke = SerialUtilities.readStroke(objectInputStream);
        this.separatorPaint = SerialUtilities.readPaint(objectInputStream);
    }
}
