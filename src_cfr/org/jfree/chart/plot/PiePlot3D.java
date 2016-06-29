/*
 * Decompiled with CFR 0_115.
 */
package org.jfree.chart.plot;

import java.awt.AlphaComposite;
import java.awt.Color;
import java.awt.Composite;
import java.awt.Font;
import java.awt.FontMetrics;
import java.awt.Graphics2D;
import java.awt.Paint;
import java.awt.Polygon;
import java.awt.Shape;
import java.awt.Stroke;
import java.awt.geom.Arc2D;
import java.awt.geom.Area;
import java.awt.geom.Ellipse2D;
import java.awt.geom.Point2D;
import java.awt.geom.Rectangle2D;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;
import org.jfree.chart.ChartRenderingInfo;
import org.jfree.chart.entity.ChartEntity;
import org.jfree.chart.entity.EntityCollection;
import org.jfree.chart.entity.PieSectionEntity;
import org.jfree.chart.event.PlotChangeEvent;
import org.jfree.chart.labels.PieSectionLabelGenerator;
import org.jfree.chart.labels.PieToolTipGenerator;
import org.jfree.chart.plot.PiePlot;
import org.jfree.chart.plot.PiePlotState;
import org.jfree.chart.plot.Plot;
import org.jfree.chart.plot.PlotRenderingInfo;
import org.jfree.chart.plot.PlotState;
import org.jfree.chart.urls.PieURLGenerator;
import org.jfree.data.general.DatasetUtilities;
import org.jfree.data.general.PieDataset;
import org.jfree.ui.RectangleInsets;
import org.jfree.util.Rotation;

public class PiePlot3D
extends PiePlot
implements Serializable {
    private static final long serialVersionUID = 3408984188945161432L;
    private double depthFactor = 0.2;

    public PiePlot3D() {
        this(null);
    }

    public PiePlot3D(PieDataset pieDataset) {
        super(pieDataset);
        this.setCircular(false, false);
    }

    public double getDepthFactor() {
        return this.depthFactor;
    }

    public void setDepthFactor(double d2) {
        this.depthFactor = d2;
        this.notifyListeners(new PlotChangeEvent(this));
    }

    @Override
    public void draw(Graphics2D graphics2D, Rectangle2D rectangle2D, Point2D point2D, PlotState plotState, PlotRenderingInfo plotRenderingInfo) {
        Paint paint;
        Stroke stroke;
        int n2;
        Object object322;
        Object object;
        Paint paint2;
        List list;
        Object object2;
        RectangleInsets rectangleInsets = this.getInsets();
        rectangleInsets.trim(rectangle2D);
        Rectangle2D rectangle2D2 = (Rectangle2D)rectangle2D.clone();
        if (plotRenderingInfo != null) {
            plotRenderingInfo.setPlotArea(rectangle2D);
            plotRenderingInfo.setDataArea(rectangle2D);
        }
        Shape shape = graphics2D.getClip();
        graphics2D.clip(rectangle2D);
        double d2 = this.getInteriorGap();
        double d3 = 0.0;
        if (this.getLabelGenerator() != null) {
            d3 = this.getLabelGap() + this.getMaximumLabelWidth() + this.getLabelLinkMargin();
        }
        double d4 = rectangle2D.getWidth() * (d2 + d3);
        double d5 = rectangle2D.getHeight() * d2;
        double d6 = rectangle2D.getX() + d4 / 2.0;
        double d7 = rectangle2D.getY() + d5 / 2.0;
        double d8 = rectangle2D.getWidth() - d4;
        double d9 = rectangle2D.getHeight() - d5;
        if (this.isCircular()) {
            double d10 = Math.min(d8, d9) / 2.0;
            d6 = (d6 + d6 + d8) / 2.0 - d10;
            d7 = (d7 + d7 + d9) / 2.0 - d10;
            d8 = 2.0 * d10;
            d9 = 2.0 * d10;
        }
        PiePlotState piePlotState = this.initialise(graphics2D, rectangle2D, this, null, plotRenderingInfo);
        double d11 = d8 * this.getLabelLinkMargin();
        double d12 = d9 * this.getLabelLinkMargin();
        Rectangle2D.Double double_ = new Rectangle2D.Double(d6 + d11 / 2.0, d7 + d12 / 2.0, d8 - d11, d9 - d12);
        piePlotState.setExplodedPieArea(double_);
        double d13 = this.getMaximumExplodePercent();
        double d14 = d13 / (1.0 + d13);
        double d15 = double_.getWidth() * d14;
        double d16 = double_.getHeight() * d14;
        Rectangle2D.Double double_2 = new Rectangle2D.Double(double_.getX() + d15 / 2.0, double_.getY() + d16 / 2.0, double_.getWidth() - d15, double_.getHeight() - d16);
        int n3 = (int)(double_2.getHeight() * this.depthFactor);
        Rectangle2D.Double double_3 = new Rectangle2D.Double(d6, d7, d8, d9 - (double)n3);
        piePlotState.setLinkArea(double_3);
        piePlotState.setPieArea(double_2);
        piePlotState.setPieCenterX(double_2.getCenterX());
        piePlotState.setPieCenterY(double_2.getCenterY() - (double)n3 / 2.0);
        piePlotState.setPieWRadius(double_2.getWidth() / 2.0);
        piePlotState.setPieHRadius((double_2.getHeight() - (double)n3) / 2.0);
        this.drawBackground(graphics2D, rectangle2D);
        PieDataset pieDataset = this.getDataset();
        if (DatasetUtilities.isEmptyOrNull(this.getDataset())) {
            this.drawNoDataMessage(graphics2D, rectangle2D);
            graphics2D.setClip(shape);
            this.drawOutline(graphics2D, rectangle2D);
            return;
        }
        if ((double)pieDataset.getKeys().size() > rectangle2D.getWidth()) {
            String string = "Too many elements";
            Font font = new Font("dialog", 1, 10);
            graphics2D.setFont(font);
            FontMetrics fontMetrics = graphics2D.getFontMetrics(font);
            int n4 = fontMetrics.stringWidth(string);
            graphics2D.drawString(string, (int)(rectangle2D.getX() + (rectangle2D.getWidth() - (double)n4) / 2.0), (int)(rectangle2D.getY() + rectangle2D.getHeight() / 2.0));
            return;
        }
        if (this.isCircular()) {
            double d17 = Math.min(rectangle2D.getWidth(), rectangle2D.getHeight()) / 2.0;
            rectangle2D = new Rectangle2D.Double(rectangle2D.getCenterX() - d17, rectangle2D.getCenterY() - d17, 2.0 * d17, 2.0 * d17);
        }
        if ((list = pieDataset.getKeys()).size() == 0) {
            return;
        }
        double d18 = double_2.getX();
        double d19 = double_2.getY();
        Composite composite = graphics2D.getComposite();
        graphics2D.setComposite(AlphaComposite.getInstance(3, this.getForegroundAlpha()));
        double d20 = DatasetUtilities.calculatePieDatasetTotal(pieDataset);
        double d21 = 0.0;
        if (n3 < 0) {
            return;
        }
        ArrayList<Arc2D.Double> arrayList = new ArrayList<Arc2D.Double>();
        for (Object object322 : list) {
            double d22;
            double d23;
            Number number = pieDataset.getValue((Comparable)object322);
            if (number == null) {
                arrayList.add(null);
                continue;
            }
            double double_4 = number.doubleValue();
            if (double_4 <= 0.0) {
                arrayList.add(null);
                continue;
            }
            double double_6 = this.getStartAngle();
            double d26 = double_6 + (d22 = this.getDirection().getFactor()) * (d21 + double_4) * 360.0 / d20;
            if (Math.abs(d26 - (d23 = double_6 + d22 * (d21 * 360.0) / d20)) > this.getMinimumArcAngleToDraw()) {
                arrayList.add(new Arc2D.Double(d18, d19 + (double)n3, double_2.getWidth(), double_2.getHeight() - (double)n3, d23, d26 - d23, 2));
            } else {
                arrayList.add(null);
            }
            d21 += double_4;
        }
        object322 = graphics2D.getClip();
        Ellipse2D.Double double_4 = new Ellipse2D.Double(double_2.getX(), double_2.getY(), double_2.getWidth(), double_2.getHeight() - (double)n3);
        Ellipse2D.Double double_5 = new Ellipse2D.Double(double_2.getX(), double_2.getY() + (double)n3, double_2.getWidth(), double_2.getHeight() - (double)n3);
        Rectangle2D.Double double_6 = new Rectangle2D.Double(double_4.getX(), double_4.getCenterY(), double_2.getWidth(), double_5.getMaxY() - double_4.getCenterY());
        Rectangle2D.Double double_7 = new Rectangle2D.Double(double_2.getX(), double_4.getY(), double_2.getWidth(), double_5.getCenterY() - double_4.getY());
        Area area = new Area(double_4);
        area.add(new Area(double_6));
        Area area2 = new Area(double_5);
        area2.add(new Area(double_7));
        Area area3 = new Area(area);
        area3.intersect(area2);
        Area area4 = new Area(area3);
        area4.subtract(new Area(double_4));
        Area area5 = new Area(area3);
        area5.subtract(new Area(double_5));
        Arc2D.Double double_8 = new Arc2D.Double(d18, d19 + (double)n3, double_2.getWidth(), double_2.getHeight() - (double)n3, 0.0, 360.0, 2);
        int n4 = arrayList.size();
        for (n2 = 0; n2 < n4; ++n2) {
            double_8 = (Arc2D.Double)arrayList.get(n2);
            if (double_8 == null) continue;
            Comparable comparable = this.getSectionKey(n2);
            paint = this.lookupSectionPaint(comparable, true);
            paint2 = this.lookupSectionOutlinePaint(comparable);
            stroke = this.lookupSectionOutlineStroke(comparable);
            graphics2D.setPaint(paint);
            graphics2D.fill(double_8);
            graphics2D.setPaint(paint2);
            graphics2D.setStroke(stroke);
            graphics2D.draw(double_8);
            graphics2D.setPaint(paint);
            object2 = double_8.getStartPoint();
            int[] arrn = new int[]{(int)double_8.getCenterX(), (int)double_8.getCenterX(), (int)object2.getX(), (int)object2.getX()};
            int[] arrn2 = new int[]{(int)double_8.getCenterY(), (int)double_8.getCenterY() - n3, (int)object2.getY() - n3, (int)object2.getY()};
            object = new Polygon(arrn, arrn2, 4);
            graphics2D.setPaint(Color.lightGray);
            graphics2D.fill((Shape)object);
            graphics2D.setPaint(paint2);
            graphics2D.setStroke(stroke);
            graphics2D.draw((Shape)object);
            graphics2D.setPaint(paint);
        }
        graphics2D.setPaint(Color.gray);
        graphics2D.fill(area5);
        graphics2D.fill(area4);
        n2 = 0;
        for (Arc2D arc2D : arrayList) {
            if (arc2D != null) {
                object2 = this.getSectionKey(n2);
                paint = this.lookupSectionPaint((Comparable)object2, true);
                paint2 = this.lookupSectionOutlinePaint((Comparable)object2);
                stroke = this.lookupSectionOutlineStroke((Comparable)object2);
                this.drawSide(graphics2D, double_2, arc2D, area4, area5, paint, paint2, stroke, false, true);
            }
            ++n2;
        }
        n2 = 0;
        for (Arc2D arc2D2 : arrayList) {
            if (arc2D2 != null) {
                object2 = this.getSectionKey(n2);
                paint = this.lookupSectionPaint((Comparable)object2);
                paint2 = this.lookupSectionOutlinePaint((Comparable)object2);
                stroke = this.lookupSectionOutlineStroke((Comparable)object2);
                this.drawSide(graphics2D, double_2, arc2D2, area4, area5, paint, paint2, stroke, true, false);
            }
            ++n2;
        }
        graphics2D.setClip((Shape)object322);
        int n5 = 0;
        do {
            if (n5 >= n4) {
                graphics2D.setClip(shape);
                graphics2D.setComposite(composite);
                this.drawOutline(graphics2D, rectangle2D2);
                return;
            }
            double_8 = (Arc2D.Double)arrayList.get(n5);
            if (double_8 != null) {
                Object object3;
                Object object4;
                Arc2D.Double double_9 = new Arc2D.Double(d18, d19, double_2.getWidth(), double_2.getHeight() - (double)n3, double_8.getAngleStart(), double_8.getAngleExtent(), 2);
                object = (Comparable)list.get(n5);
                paint = this.lookupSectionPaint((Comparable)object, true);
                paint2 = this.lookupSectionOutlinePaint((Comparable)object);
                stroke = this.lookupSectionOutlineStroke((Comparable)object);
                graphics2D.setPaint(paint);
                graphics2D.fill(double_9);
                graphics2D.setStroke(stroke);
                graphics2D.setPaint(paint2);
                graphics2D.draw(double_9);
                if (plotRenderingInfo != null && (object4 = plotRenderingInfo.getOwner().getEntityCollection()) != null) {
                    object3 = null;
                    PieToolTipGenerator pieToolTipGenerator = this.getToolTipGenerator();
                    if (pieToolTipGenerator != null) {
                        object3 = pieToolTipGenerator.generateToolTip(pieDataset, (Comparable)object);
                    }
                    String string = null;
                    if (this.getURLGenerator() != null) {
                        string = this.getURLGenerator().generateURL(pieDataset, (Comparable)object, this.getPieIndex());
                    }
                    PieSectionEntity pieSectionEntity = new PieSectionEntity(double_9, pieDataset, this.getPieIndex(), n5, (Comparable)object, (String)object3, string);
                    object4.add(pieSectionEntity);
                }
                object4 = pieDataset.getKeys();
                object3 = new Rectangle2D.Double(rectangle2D2.getX(), rectangle2D2.getY(), rectangle2D2.getWidth(), rectangle2D2.getHeight() - (double)n3);
                this.drawLabels(graphics2D, (List)object4, d20, (Rectangle2D)object3, double_3, piePlotState);
            }
            ++n5;
        } while (true);
    }

    protected void drawSide(Graphics2D graphics2D, Rectangle2D rectangle2D, Arc2D arc2D, Area area, Area area2, Paint paint, Paint paint2, Stroke stroke, boolean bl2, boolean bl3) {
        Area area3;
        double d2 = arc2D.getAngleStart();
        double d3 = arc2D.getAngleExtent();
        double d4 = d2 + d3;
        graphics2D.setStroke(stroke);
        if (d3 < 0.0) {
            Area area4;
            if (this.isAngleAtFront(d2)) {
                Area area5;
                if (!this.isAngleAtBack(d4)) {
                    if (d3 > -180.0) {
                        if (!bl2) return;
                        Area area6 = new Area(new Rectangle2D.Double(arc2D.getEndPoint().getX(), rectangle2D.getY(), arc2D.getStartPoint().getX() - arc2D.getEndPoint().getX(), rectangle2D.getHeight()));
                        area6.intersect(area);
                        graphics2D.setPaint(paint);
                        graphics2D.fill(area6);
                        graphics2D.setPaint(paint2);
                        graphics2D.draw(area6);
                        return;
                    }
                    Area area7 = new Area(new Rectangle2D.Double(rectangle2D.getX(), rectangle2D.getY(), arc2D.getStartPoint().getX() - rectangle2D.getX(), rectangle2D.getHeight()));
                    area7.intersect(area);
                    Area area8 = new Area(new Rectangle2D.Double(arc2D.getEndPoint().getX(), rectangle2D.getY(), rectangle2D.getMaxX() - arc2D.getEndPoint().getX(), rectangle2D.getHeight()));
                    area8.intersect(area);
                    graphics2D.setPaint(paint);
                    if (bl2) {
                        graphics2D.fill(area7);
                        graphics2D.fill(area8);
                    }
                    if (bl3) {
                        graphics2D.fill(area2);
                    }
                    graphics2D.setPaint(paint2);
                    if (bl2) {
                        graphics2D.draw(area7);
                        graphics2D.draw(area8);
                    }
                    if (!bl3) return;
                    graphics2D.draw(area2);
                    return;
                }
                if (bl3) {
                    area5 = new Area(new Rectangle2D.Double(rectangle2D.getX(), rectangle2D.getY(), arc2D.getEndPoint().getX() - rectangle2D.getX(), rectangle2D.getHeight()));
                    area5.intersect(area2);
                    graphics2D.setPaint(paint);
                    graphics2D.fill(area5);
                    graphics2D.setPaint(paint2);
                    graphics2D.draw(area5);
                }
                if (!bl2) return;
                area5 = new Area(new Rectangle2D.Double(rectangle2D.getX(), rectangle2D.getY(), arc2D.getStartPoint().getX() - rectangle2D.getX(), rectangle2D.getHeight()));
                area5.intersect(area);
                graphics2D.setPaint(paint);
                graphics2D.fill(area5);
                graphics2D.setPaint(paint2);
                graphics2D.draw(area5);
                return;
            }
            if (!this.isAngleAtFront(d4)) {
                if (d3 > -180.0) {
                    if (!bl3) return;
                    Area area9 = new Area(new Rectangle2D.Double(arc2D.getStartPoint().getX(), rectangle2D.getY(), arc2D.getEndPoint().getX() - arc2D.getStartPoint().getX(), rectangle2D.getHeight()));
                    area9.intersect(area2);
                    graphics2D.setPaint(paint);
                    graphics2D.fill(area9);
                    graphics2D.setPaint(paint2);
                    graphics2D.draw(area9);
                    return;
                }
                Area area10 = new Area(new Rectangle2D.Double(arc2D.getStartPoint().getX(), rectangle2D.getY(), rectangle2D.getMaxX() - arc2D.getStartPoint().getX(), rectangle2D.getHeight()));
                area10.intersect(area2);
                Area area11 = new Area(new Rectangle2D.Double(rectangle2D.getX(), rectangle2D.getY(), arc2D.getEndPoint().getX() - rectangle2D.getX(), rectangle2D.getHeight()));
                area11.intersect(area2);
                graphics2D.setPaint(paint);
                if (bl3) {
                    graphics2D.fill(area10);
                    graphics2D.fill(area11);
                }
                if (bl2) {
                    graphics2D.fill(area);
                }
                graphics2D.setPaint(paint2);
                if (bl3) {
                    graphics2D.draw(area10);
                    graphics2D.draw(area11);
                }
                if (!bl2) return;
                graphics2D.draw(area);
                return;
            }
            if (bl3) {
                area4 = new Area(new Rectangle2D.Double(arc2D.getStartPoint().getX(), rectangle2D.getY(), rectangle2D.getMaxX() - arc2D.getStartPoint().getX(), rectangle2D.getHeight()));
                area4.intersect(area2);
                graphics2D.setPaint(paint);
                graphics2D.fill(area4);
                graphics2D.setPaint(paint2);
                graphics2D.draw(area4);
            }
            if (!bl2) return;
            area4 = new Area(new Rectangle2D.Double(arc2D.getEndPoint().getX(), rectangle2D.getY(), rectangle2D.getMaxX() - arc2D.getEndPoint().getX(), rectangle2D.getHeight()));
            area4.intersect(area);
            graphics2D.setPaint(paint);
            graphics2D.fill(area4);
            graphics2D.setPaint(paint2);
            graphics2D.draw(area4);
            return;
        }
        if (d3 <= 0.0) return;
        if (this.isAngleAtFront(d2)) {
            Area area12;
            if (!this.isAngleAtBack(d4)) {
                if (d3 < 180.0) {
                    if (!bl2) return;
                    Area area13 = new Area(new Rectangle2D.Double(arc2D.getStartPoint().getX(), rectangle2D.getY(), arc2D.getEndPoint().getX() - arc2D.getStartPoint().getX(), rectangle2D.getHeight()));
                    area13.intersect(area);
                    graphics2D.setPaint(paint);
                    graphics2D.fill(area13);
                    graphics2D.setPaint(paint2);
                    graphics2D.draw(area13);
                    return;
                }
                Area area14 = new Area(new Rectangle2D.Double(arc2D.getStartPoint().getX(), rectangle2D.getY(), rectangle2D.getMaxX() - arc2D.getStartPoint().getX(), rectangle2D.getHeight()));
                area14.intersect(area);
                Area area15 = new Area(new Rectangle2D.Double(rectangle2D.getX(), rectangle2D.getY(), arc2D.getEndPoint().getX() - rectangle2D.getX(), rectangle2D.getHeight()));
                area15.intersect(area);
                graphics2D.setPaint(paint);
                if (bl2) {
                    graphics2D.fill(area14);
                    graphics2D.fill(area15);
                }
                if (bl3) {
                    graphics2D.fill(area2);
                }
                graphics2D.setPaint(paint2);
                if (bl2) {
                    graphics2D.draw(area14);
                    graphics2D.draw(area15);
                }
                if (!bl3) return;
                graphics2D.draw(area2);
                return;
            }
            if (bl3) {
                area12 = new Area(new Rectangle2D.Double(arc2D.getEndPoint().getX(), rectangle2D.getY(), rectangle2D.getMaxX() - arc2D.getEndPoint().getX(), rectangle2D.getHeight()));
                area12.intersect(area2);
                graphics2D.setPaint(paint);
                graphics2D.fill(area12);
                graphics2D.setPaint(paint2);
                graphics2D.draw(area12);
            }
            if (!bl2) return;
            area12 = new Area(new Rectangle2D.Double(arc2D.getStartPoint().getX(), rectangle2D.getY(), rectangle2D.getMaxX() - arc2D.getStartPoint().getX(), rectangle2D.getHeight()));
            area12.intersect(area);
            graphics2D.setPaint(paint);
            graphics2D.fill(area12);
            graphics2D.setPaint(paint2);
            graphics2D.draw(area12);
            return;
        }
        if (!this.isAngleAtFront(d4)) {
            if (d3 < 180.0) {
                if (!bl3) return;
                Area area16 = new Area(new Rectangle2D.Double(arc2D.getEndPoint().getX(), rectangle2D.getY(), arc2D.getStartPoint().getX() - arc2D.getEndPoint().getX(), rectangle2D.getHeight()));
                area16.intersect(area2);
                graphics2D.setPaint(paint);
                graphics2D.fill(area16);
                graphics2D.setPaint(paint2);
                graphics2D.draw(area16);
                return;
            }
            Area area17 = new Area(new Rectangle2D.Double(arc2D.getStartPoint().getX(), rectangle2D.getY(), rectangle2D.getX() - arc2D.getStartPoint().getX(), rectangle2D.getHeight()));
            area17.intersect(area2);
            Area area18 = new Area(new Rectangle2D.Double(arc2D.getEndPoint().getX(), rectangle2D.getY(), rectangle2D.getMaxX() - arc2D.getEndPoint().getX(), rectangle2D.getHeight()));
            area18.intersect(area2);
            graphics2D.setPaint(paint);
            if (bl3) {
                graphics2D.fill(area17);
                graphics2D.fill(area18);
            }
            if (bl2) {
                graphics2D.fill(area);
            }
            graphics2D.setPaint(paint2);
            if (bl3) {
                graphics2D.draw(area17);
                graphics2D.draw(area18);
            }
            if (!bl2) return;
            graphics2D.draw(area);
            return;
        }
        if (bl3) {
            area3 = new Area(new Rectangle2D.Double(rectangle2D.getX(), rectangle2D.getY(), arc2D.getStartPoint().getX() - rectangle2D.getX(), rectangle2D.getHeight()));
            area3.intersect(area2);
            graphics2D.setPaint(paint);
            graphics2D.fill(area3);
            graphics2D.setPaint(paint2);
            graphics2D.draw(area3);
        }
        if (!bl2) return;
        area3 = new Area(new Rectangle2D.Double(rectangle2D.getX(), rectangle2D.getY(), arc2D.getEndPoint().getX() - rectangle2D.getX(), rectangle2D.getHeight()));
        area3.intersect(area);
        graphics2D.setPaint(paint);
        graphics2D.fill(area3);
        graphics2D.setPaint(paint2);
        graphics2D.draw(area3);
    }

    @Override
    public String getPlotType() {
        return localizationResources.getString("Pie_3D_Plot");
    }

    private boolean isAngleAtFront(double d2) {
        if (Math.sin(Math.toRadians(d2)) >= 0.0) return false;
        return true;
    }

    private boolean isAngleAtBack(double d2) {
        if (Math.sin(Math.toRadians(d2)) <= 0.0) return false;
        return true;
    }

    @Override
    public boolean equals(Object object) {
        if (object == this) {
            return true;
        }
        if (!(object instanceof PiePlot3D)) {
            return false;
        }
        PiePlot3D piePlot3D = (PiePlot3D)object;
        if (this.depthFactor == piePlot3D.depthFactor) return super.equals(object);
        return false;
    }
}

