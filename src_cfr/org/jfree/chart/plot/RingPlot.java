/*
 * Decompiled with CFR 0_115.
 */
package org.jfree.chart.plot;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.Paint;
import java.awt.Shape;
import java.awt.Stroke;
import java.awt.geom.AffineTransform;
import java.awt.geom.Arc2D;
import java.awt.geom.GeneralPath;
import java.awt.geom.Line2D;
import java.awt.geom.PathIterator;
import java.awt.geom.Point2D;
import java.awt.geom.Rectangle2D;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import org.jfree.chart.entity.ChartEntity;
import org.jfree.chart.entity.EntityCollection;
import org.jfree.chart.entity.PieSectionEntity;
import org.jfree.chart.event.PlotChangeEvent;
import org.jfree.chart.labels.PieToolTipGenerator;
import org.jfree.chart.plot.PiePlot;
import org.jfree.chart.plot.PiePlotState;
import org.jfree.chart.plot.Plot;
import org.jfree.chart.plot.PlotRenderingInfo;
import org.jfree.chart.urls.PieURLGenerator;
import org.jfree.data.general.PieDataset;
import org.jfree.io.SerialUtilities;
import org.jfree.ui.RectangleInsets;
import org.jfree.util.ObjectUtilities;
import org.jfree.util.PaintUtilities;
import org.jfree.util.Rotation;
import org.jfree.util.ShapeUtilities;
import org.jfree.util.UnitType;

public class RingPlot
extends PiePlot
implements Serializable,
Cloneable {
    private static final long serialVersionUID = 1556064784129676620L;
    private boolean separatorsVisible = true;
    private transient Stroke separatorStroke = new BasicStroke(0.5f);
    private transient Paint separatorPaint = Color.gray;
    private double innerSeparatorExtension = 0.2;
    private double outerSeparatorExtension = 0.2;
    private double sectionDepth = 0.2;

    public RingPlot() {
        this(null);
    }

    public RingPlot(PieDataset pieDataset) {
        super(pieDataset);
    }

    public boolean getSeparatorsVisible() {
        return this.separatorsVisible;
    }

    public void setSeparatorsVisible(boolean bl2) {
        this.separatorsVisible = bl2;
        this.notifyListeners(new PlotChangeEvent(this));
    }

    public Stroke getSeparatorStroke() {
        return this.separatorStroke;
    }

    public void setSeparatorStroke(Stroke stroke) {
        if (stroke == null) {
            throw new IllegalArgumentException("Null 'stroke' argument.");
        }
        this.separatorStroke = stroke;
        this.notifyListeners(new PlotChangeEvent(this));
    }

    public Paint getSeparatorPaint() {
        return this.separatorPaint;
    }

    public void setSeparatorPaint(Paint paint) {
        if (paint == null) {
            throw new IllegalArgumentException("Null 'paint' argument.");
        }
        this.separatorPaint = paint;
        this.notifyListeners(new PlotChangeEvent(this));
    }

    public double getInnerSeparatorExtension() {
        return this.innerSeparatorExtension;
    }

    public void setInnerSeparatorExtension(double d2) {
        this.innerSeparatorExtension = d2;
        this.notifyListeners(new PlotChangeEvent(this));
    }

    public double getOuterSeparatorExtension() {
        return this.outerSeparatorExtension;
    }

    public void setOuterSeparatorExtension(double d2) {
        this.outerSeparatorExtension = d2;
        this.notifyListeners(new PlotChangeEvent(this));
    }

    public double getSectionDepth() {
        return this.sectionDepth;
    }

    public void setSectionDepth(double d2) {
        this.sectionDepth = d2;
        this.notifyListeners(new PlotChangeEvent(this));
    }

    @Override
    public PiePlotState initialise(Graphics2D graphics2D, Rectangle2D rectangle2D, PiePlot piePlot, Integer n2, PlotRenderingInfo plotRenderingInfo) {
        PiePlotState piePlotState = super.initialise(graphics2D, rectangle2D, piePlot, n2, plotRenderingInfo);
        piePlotState.setPassesRequired(3);
        return piePlotState;
    }

    @Override
    protected void drawItem(Graphics2D graphics2D, int n2, Rectangle2D rectangle2D, PiePlotState piePlotState, int n3) {
        PieDataset pieDataset = this.getDataset();
        Number number = pieDataset.getValue(n2);
        if (number == null) {
            return;
        }
        double d2 = number.doubleValue();
        double d3 = 0.0;
        double d4 = 0.0;
        Rotation rotation = this.getDirection();
        if (rotation == Rotation.CLOCKWISE) {
            d3 = piePlotState.getLatestAngle();
            d4 = d3 - d2 / piePlotState.getTotal() * 360.0;
        } else {
            if (rotation != Rotation.ANTICLOCKWISE) throw new IllegalStateException("Rotation type not recognised.");
            d3 = piePlotState.getLatestAngle();
            d4 = d3 + d2 / piePlotState.getTotal() * 360.0;
        }
        double d5 = d4 - d3;
        if (Math.abs(d5) > this.getMinimumArcAngleToDraw()) {
            Comparable comparable = this.getSectionKey(n2);
            double d6 = 0.0;
            double d7 = this.getMaximumExplodePercent();
            if (d7 > 0.0) {
                d6 = this.getExplodePercent(comparable) / d7;
            }
            Rectangle2D rectangle2D2 = this.getArcBounds(piePlotState.getPieArea(), piePlotState.getExplodedPieArea(), d3, d5, d6);
            Arc2D.Double double_ = new Arc2D.Double(rectangle2D2, d3, d5, 0);
            double d8 = this.sectionDepth / 2.0;
            RectangleInsets rectangleInsets = new RectangleInsets(UnitType.RELATIVE, d8, d8, d8, d8);
            Rectangle2D.Double double_2 = new Rectangle2D.Double();
            double_2.setRect(rectangle2D2);
            rectangleInsets.trim(double_2);
            Arc2D.Double double_3 = new Arc2D.Double(double_2, d3 + d5, - d5, 0);
            GeneralPath generalPath = new GeneralPath();
            generalPath.moveTo((float)double_.getStartPoint().getX(), (float)double_.getStartPoint().getY());
            generalPath.append(double_.getPathIterator(null), false);
            generalPath.append(double_3.getPathIterator(null), true);
            generalPath.closePath();
            Line2D.Double double_4 = new Line2D.Double(double_3.getEndPoint(), double_.getStartPoint());
            if (n3 == 0) {
                Paint paint = this.getShadowPaint();
                double d9 = this.getShadowXOffset();
                double d10 = this.getShadowYOffset();
                if (paint != null) {
                    Shape shape = ShapeUtilities.createTranslatedShape(generalPath, (float)d9, (float)d10);
                    graphics2D.setPaint(paint);
                    graphics2D.fill(shape);
                }
            } else if (n3 == 1) {
                EntityCollection entityCollection;
                Paint paint = this.lookupSectionPaint(comparable, true);
                graphics2D.setPaint(paint);
                graphics2D.fill(generalPath);
                Paint paint2 = this.lookupSectionOutlinePaint(comparable);
                Stroke stroke = this.lookupSectionOutlineStroke(comparable);
                if (paint2 != null && stroke != null) {
                    graphics2D.setPaint(paint2);
                    graphics2D.setStroke(stroke);
                    graphics2D.draw(generalPath);
                }
                if (piePlotState.getInfo() != null && (entityCollection = piePlotState.getEntityCollection()) != null) {
                    String string = null;
                    PieToolTipGenerator pieToolTipGenerator = this.getToolTipGenerator();
                    if (pieToolTipGenerator != null) {
                        string = pieToolTipGenerator.generateToolTip(pieDataset, comparable);
                    }
                    String string2 = null;
                    PieURLGenerator pieURLGenerator = this.getURLGenerator();
                    if (pieURLGenerator != null) {
                        string2 = pieURLGenerator.generateURL(pieDataset, comparable, this.getPieIndex());
                    }
                    PieSectionEntity pieSectionEntity = new PieSectionEntity(generalPath, pieDataset, this.getPieIndex(), n2, comparable, string, string2);
                    entityCollection.add(pieSectionEntity);
                }
            } else if (n3 == 2 && this.separatorsVisible) {
                Line2D line2D = this.extendLine(double_4, this.innerSeparatorExtension, this.outerSeparatorExtension);
                graphics2D.setStroke(this.separatorStroke);
                graphics2D.setPaint(this.separatorPaint);
                graphics2D.draw(line2D);
            }
        }
        piePlotState.setLatestAngle(d4);
    }

    @Override
    public boolean equals(Object object) {
        if (this == object) {
            return true;
        }
        if (!(object instanceof RingPlot)) {
            return false;
        }
        RingPlot ringPlot = (RingPlot)object;
        if (this.separatorsVisible != ringPlot.separatorsVisible) {
            return false;
        }
        if (!ObjectUtilities.equal(this.separatorStroke, ringPlot.separatorStroke)) {
            return false;
        }
        if (!PaintUtilities.equal(this.separatorPaint, ringPlot.separatorPaint)) {
            return false;
        }
        if (this.innerSeparatorExtension != ringPlot.innerSeparatorExtension) {
            return false;
        }
        if (this.outerSeparatorExtension != ringPlot.outerSeparatorExtension) {
            return false;
        }
        if (this.sectionDepth == ringPlot.sectionDepth) return super.equals(object);
        return false;
    }

    private Line2D extendLine(Line2D line2D, double d2, double d3) {
        if (line2D == null) {
            throw new IllegalArgumentException("Null 'line' argument.");
        }
        double d4 = line2D.getX1();
        double d5 = line2D.getX2();
        double d6 = d5 - d4;
        double d7 = line2D.getY1();
        double d8 = line2D.getY2();
        double d9 = d8 - d7;
        return new Line2D.Double(d4 -= d2 * d6, d7 -= d2 * d9, d5 += d3 * d6, d8 += d3 * d9);
    }

    private void writeObject(ObjectOutputStream objectOutputStream) {
        objectOutputStream.defaultWriteObject();
        SerialUtilities.writeStroke(this.separatorStroke, objectOutputStream);
        SerialUtilities.writePaint(this.separatorPaint, objectOutputStream);
    }

    private void readObject(ObjectInputStream objectInputStream) {
        objectInputStream.defaultReadObject();
        this.separatorStroke = SerialUtilities.readStroke(objectInputStream);
        this.separatorPaint = SerialUtilities.readPaint(objectInputStream);
    }
}

