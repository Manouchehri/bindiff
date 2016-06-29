package org.jfree.chart.plot;

import java.io.*;
import org.jfree.chart.event.*;
import org.jfree.data.general.*;
import java.awt.geom.*;
import java.util.*;
import java.awt.*;
import org.jfree.chart.entity.*;
import org.jfree.chart.labels.*;

public class PiePlot3D extends PiePlot implements Serializable
{
    private static final long serialVersionUID = 3408984188945161432L;
    private double depthFactor;
    
    public PiePlot3D() {
        this(null);
    }
    
    public PiePlot3D(final PieDataset pieDataset) {
        super(pieDataset);
        this.depthFactor = 0.2;
        this.setCircular(false, false);
    }
    
    public double getDepthFactor() {
        return this.depthFactor;
    }
    
    public void setDepthFactor(final double depthFactor) {
        this.depthFactor = depthFactor;
        this.notifyListeners(new PlotChangeEvent(this));
    }
    
    public void draw(final Graphics2D graphics2D, final Rectangle2D rectangle2D, final Point2D point2D, final PlotState plotState, final PlotRenderingInfo plotRenderingInfo) {
        this.getInsets().trim(rectangle2D);
        final Rectangle2D rectangle2D2 = (Rectangle2D)rectangle2D.clone();
        if (plotRenderingInfo != null) {
            plotRenderingInfo.setPlotArea(rectangle2D);
            plotRenderingInfo.setDataArea(rectangle2D);
        }
        final Shape clip = graphics2D.getClip();
        graphics2D.clip(rectangle2D);
        final double interiorGap = this.getInteriorGap();
        double n = 0.0;
        if (this.getLabelGenerator() != null) {
            n = this.getLabelGap() + this.getMaximumLabelWidth() + this.getLabelLinkMargin();
        }
        final double n2 = rectangle2D.getWidth() * (interiorGap + n);
        final double n3 = rectangle2D.getHeight() * interiorGap;
        double n4 = rectangle2D.getX() + n2 / 2.0;
        double n5 = rectangle2D.getY() + n3 / 2.0;
        double n6 = rectangle2D.getWidth() - n2;
        double n7 = rectangle2D.getHeight() - n3;
        if (this.isCircular()) {
            final double n8 = Math.min(n6, n7) / 2.0;
            n4 = (n4 + n4 + n6) / 2.0 - n8;
            n5 = (n5 + n5 + n7) / 2.0 - n8;
            n6 = 2.0 * n8;
            n7 = 2.0 * n8;
        }
        final PiePlotState initialise = this.initialise(graphics2D, rectangle2D, this, null, plotRenderingInfo);
        final double n9 = n6 * this.getLabelLinkMargin();
        final double n10 = n7 * this.getLabelLinkMargin();
        final Rectangle2D.Double explodedPieArea = new Rectangle2D.Double(n4 + n9 / 2.0, n5 + n10 / 2.0, n6 - n9, n7 - n10);
        initialise.setExplodedPieArea(explodedPieArea);
        final double maximumExplodePercent = this.getMaximumExplodePercent();
        final double n11 = maximumExplodePercent / (1.0 + maximumExplodePercent);
        final double n12 = explodedPieArea.getWidth() * n11;
        final double n13 = explodedPieArea.getHeight() * n11;
        final Rectangle2D.Double pieArea = new Rectangle2D.Double(explodedPieArea.getX() + n12 / 2.0, explodedPieArea.getY() + n13 / 2.0, explodedPieArea.getWidth() - n12, explodedPieArea.getHeight() - n13);
        final int n14 = (int)(pieArea.getHeight() * this.depthFactor);
        final Rectangle2D.Double linkArea = new Rectangle2D.Double(n4, n5, n6, n7 - n14);
        initialise.setLinkArea(linkArea);
        initialise.setPieArea(pieArea);
        initialise.setPieCenterX(pieArea.getCenterX());
        initialise.setPieCenterY(pieArea.getCenterY() - n14 / 2.0);
        initialise.setPieWRadius(pieArea.getWidth() / 2.0);
        initialise.setPieHRadius((pieArea.getHeight() - n14) / 2.0);
        this.drawBackground(graphics2D, rectangle2D);
        final PieDataset dataset = this.getDataset();
        if (DatasetUtilities.isEmptyOrNull(this.getDataset())) {
            this.drawNoDataMessage(graphics2D, rectangle2D);
            graphics2D.setClip(clip);
            this.drawOutline(graphics2D, rectangle2D);
            return;
        }
        if (dataset.getKeys().size() > rectangle2D.getWidth()) {
            final String s = "Too many elements";
            final Font font = new Font("dialog", 1, 10);
            graphics2D.setFont(font);
            graphics2D.drawString(s, (int)(rectangle2D.getX() + (rectangle2D.getWidth() - graphics2D.getFontMetrics(font).stringWidth(s)) / 2.0), (int)(rectangle2D.getY() + rectangle2D.getHeight() / 2.0));
            return;
        }
        if (this.isCircular()) {
            final double n15 = Math.min(rectangle2D.getWidth(), rectangle2D.getHeight()) / 2.0;
            final Rectangle2D.Double double1 = new Rectangle2D.Double(rectangle2D.getCenterX() - n15, rectangle2D.getCenterY() - n15, 2.0 * n15, 2.0 * n15);
        }
        final List keys = dataset.getKeys();
        if (keys.size() == 0) {
            return;
        }
        final double x = pieArea.getX();
        final double y = pieArea.getY();
        final Composite composite = graphics2D.getComposite();
        graphics2D.setComposite(AlphaComposite.getInstance(3, this.getForegroundAlpha()));
        final double calculatePieDatasetTotal = DatasetUtilities.calculatePieDatasetTotal(dataset);
        double n16 = 0.0;
        if (n14 < 0) {
            return;
        }
        final ArrayList list = new ArrayList<Arc2D.Double>();
        final Iterator<Comparable> iterator = keys.iterator();
        while (iterator.hasNext()) {
            final Number value = dataset.getValue(iterator.next());
            if (value == null) {
                list.add(null);
            }
            else {
                final double doubleValue = value.doubleValue();
                if (doubleValue <= 0.0) {
                    list.add(null);
                }
                else {
                    final double startAngle = this.getStartAngle();
                    final double factor = this.getDirection().getFactor();
                    final double n17 = startAngle + factor * (n16 * 360.0) / calculatePieDatasetTotal;
                    final double n18 = startAngle + factor * (n16 + doubleValue) * 360.0 / calculatePieDatasetTotal;
                    if (Math.abs(n18 - n17) > this.getMinimumArcAngleToDraw()) {
                        list.add(new Arc2D.Double(x, y + n14, pieArea.getWidth(), pieArea.getHeight() - n14, n17, n18 - n17, 2));
                    }
                    else {
                        list.add(null);
                    }
                    n16 += doubleValue;
                }
            }
        }
        final Shape clip2 = graphics2D.getClip();
        final Ellipse2D.Double double2 = new Ellipse2D.Double(pieArea.getX(), pieArea.getY(), pieArea.getWidth(), pieArea.getHeight() - n14);
        final Ellipse2D.Double double3 = new Ellipse2D.Double(pieArea.getX(), pieArea.getY() + n14, pieArea.getWidth(), pieArea.getHeight() - n14);
        final Rectangle2D.Double double4 = new Rectangle2D.Double(double2.getX(), double2.getCenterY(), pieArea.getWidth(), double3.getMaxY() - double2.getCenterY());
        final Rectangle2D.Double double5 = new Rectangle2D.Double(pieArea.getX(), double2.getY(), pieArea.getWidth(), double3.getCenterY() - double2.getY());
        final Area area = new Area(double2);
        area.add(new Area(double4));
        final Area area2 = new Area(double3);
        area2.add(new Area(double5));
        final Area area3 = new Area(area);
        area3.intersect(area2);
        final Area area4 = new Area(area3);
        area4.subtract(new Area(double2));
        final Area area5 = new Area(area3);
        area5.subtract(new Area(double3));
        final Arc2D.Double double6 = new Arc2D.Double(x, y + n14, pieArea.getWidth(), pieArea.getHeight() - n14, 0.0, 360.0, 2);
        final int size = list.size();
        for (int i = 0; i < size; ++i) {
            final Arc2D.Double double7 = list.get(i);
            if (double7 != null) {
                final Comparable sectionKey = this.getSectionKey(i);
                final Paint lookupSectionPaint = this.lookupSectionPaint(sectionKey, true);
                final Paint lookupSectionOutlinePaint = this.lookupSectionOutlinePaint(sectionKey);
                final Stroke lookupSectionOutlineStroke = this.lookupSectionOutlineStroke(sectionKey);
                graphics2D.setPaint(lookupSectionPaint);
                graphics2D.fill(double7);
                graphics2D.setPaint(lookupSectionOutlinePaint);
                graphics2D.setStroke(lookupSectionOutlineStroke);
                graphics2D.draw(double7);
                graphics2D.setPaint(lookupSectionPaint);
                final Point2D startPoint = double7.getStartPoint();
                final Polygon polygon = new Polygon(new int[] { (int)double7.getCenterX(), (int)double7.getCenterX(), (int)startPoint.getX(), (int)startPoint.getX() }, new int[] { (int)double7.getCenterY(), (int)double7.getCenterY() - n14, (int)startPoint.getY() - n14, (int)startPoint.getY() }, 4);
                graphics2D.setPaint(Color.lightGray);
                graphics2D.fill(polygon);
                graphics2D.setPaint(lookupSectionOutlinePaint);
                graphics2D.setStroke(lookupSectionOutlineStroke);
                graphics2D.draw(polygon);
                graphics2D.setPaint(lookupSectionPaint);
            }
        }
        graphics2D.setPaint(Color.gray);
        graphics2D.fill(area5);
        graphics2D.fill(area4);
        int n19 = 0;
        for (final Arc2D.Double double8 : list) {
            if (double8 != null) {
                final Comparable sectionKey2 = this.getSectionKey(n19);
                this.drawSide(graphics2D, pieArea, double8, area4, area5, this.lookupSectionPaint(sectionKey2, true), this.lookupSectionOutlinePaint(sectionKey2), this.lookupSectionOutlineStroke(sectionKey2), false, true);
            }
            ++n19;
        }
        int n20 = 0;
        for (final Arc2D.Double double9 : list) {
            if (double9 != null) {
                final Comparable sectionKey3 = this.getSectionKey(n20);
                this.drawSide(graphics2D, pieArea, double9, area4, area5, this.lookupSectionPaint(sectionKey3), this.lookupSectionOutlinePaint(sectionKey3), this.lookupSectionOutlineStroke(sectionKey3), true, false);
            }
            ++n20;
        }
        graphics2D.setClip(clip2);
        for (int j = 0; j < size; ++j) {
            final Arc2D.Double double10 = list.get(j);
            if (double10 != null) {
                final Arc2D.Double double11 = new Arc2D.Double(x, y, pieArea.getWidth(), pieArea.getHeight() - n14, double10.getAngleStart(), double10.getAngleExtent(), 2);
                final Comparable comparable = keys.get(j);
                final Paint lookupSectionPaint2 = this.lookupSectionPaint(comparable, true);
                final Paint lookupSectionOutlinePaint2 = this.lookupSectionOutlinePaint(comparable);
                final Stroke lookupSectionOutlineStroke2 = this.lookupSectionOutlineStroke(comparable);
                graphics2D.setPaint(lookupSectionPaint2);
                graphics2D.fill(double11);
                graphics2D.setStroke(lookupSectionOutlineStroke2);
                graphics2D.setPaint(lookupSectionOutlinePaint2);
                graphics2D.draw(double11);
                if (plotRenderingInfo != null) {
                    final EntityCollection entityCollection = plotRenderingInfo.getOwner().getEntityCollection();
                    if (entityCollection != null) {
                        String generateToolTip = null;
                        final PieToolTipGenerator toolTipGenerator = this.getToolTipGenerator();
                        if (toolTipGenerator != null) {
                            generateToolTip = toolTipGenerator.generateToolTip(dataset, comparable);
                        }
                        String generateURL = null;
                        if (this.getURLGenerator() != null) {
                            generateURL = this.getURLGenerator().generateURL(dataset, comparable, this.getPieIndex());
                        }
                        entityCollection.add(new PieSectionEntity(double11, dataset, this.getPieIndex(), j, comparable, generateToolTip, generateURL));
                    }
                }
                this.drawLabels(graphics2D, dataset.getKeys(), calculatePieDatasetTotal, new Rectangle2D.Double(rectangle2D2.getX(), rectangle2D2.getY(), rectangle2D2.getWidth(), rectangle2D2.getHeight() - n14), linkArea, initialise);
            }
        }
        graphics2D.setClip(clip);
        graphics2D.setComposite(composite);
        this.drawOutline(graphics2D, rectangle2D2);
    }
    
    protected void drawSide(final Graphics2D graphics2D, final Rectangle2D rectangle2D, final Arc2D arc2D, final Area area, final Area area2, final Paint paint, final Paint paint2, final Stroke stroke, final boolean b, final boolean b2) {
        final double angleStart = arc2D.getAngleStart();
        final double angleExtent = arc2D.getAngleExtent();
        final double n = angleStart + angleExtent;
        graphics2D.setStroke(stroke);
        if (angleExtent < 0.0) {
            if (this.isAngleAtFront(angleStart)) {
                if (!this.isAngleAtBack(n)) {
                    if (angleExtent > -180.0) {
                        if (b) {
                            final Area area3 = new Area(new Rectangle2D.Double(arc2D.getEndPoint().getX(), rectangle2D.getY(), arc2D.getStartPoint().getX() - arc2D.getEndPoint().getX(), rectangle2D.getHeight()));
                            area3.intersect(area);
                            graphics2D.setPaint(paint);
                            graphics2D.fill(area3);
                            graphics2D.setPaint(paint2);
                            graphics2D.draw(area3);
                        }
                    }
                    else {
                        final Area area4 = new Area(new Rectangle2D.Double(rectangle2D.getX(), rectangle2D.getY(), arc2D.getStartPoint().getX() - rectangle2D.getX(), rectangle2D.getHeight()));
                        area4.intersect(area);
                        final Area area5 = new Area(new Rectangle2D.Double(arc2D.getEndPoint().getX(), rectangle2D.getY(), rectangle2D.getMaxX() - arc2D.getEndPoint().getX(), rectangle2D.getHeight()));
                        area5.intersect(area);
                        graphics2D.setPaint(paint);
                        if (b) {
                            graphics2D.fill(area4);
                            graphics2D.fill(area5);
                        }
                        if (b2) {
                            graphics2D.fill(area2);
                        }
                        graphics2D.setPaint(paint2);
                        if (b) {
                            graphics2D.draw(area4);
                            graphics2D.draw(area5);
                        }
                        if (b2) {
                            graphics2D.draw(area2);
                        }
                    }
                }
                else {
                    if (b2) {
                        final Area area6 = new Area(new Rectangle2D.Double(rectangle2D.getX(), rectangle2D.getY(), arc2D.getEndPoint().getX() - rectangle2D.getX(), rectangle2D.getHeight()));
                        area6.intersect(area2);
                        graphics2D.setPaint(paint);
                        graphics2D.fill(area6);
                        graphics2D.setPaint(paint2);
                        graphics2D.draw(area6);
                    }
                    if (b) {
                        final Area area7 = new Area(new Rectangle2D.Double(rectangle2D.getX(), rectangle2D.getY(), arc2D.getStartPoint().getX() - rectangle2D.getX(), rectangle2D.getHeight()));
                        area7.intersect(area);
                        graphics2D.setPaint(paint);
                        graphics2D.fill(area7);
                        graphics2D.setPaint(paint2);
                        graphics2D.draw(area7);
                    }
                }
            }
            else if (!this.isAngleAtFront(n)) {
                if (angleExtent > -180.0) {
                    if (b2) {
                        final Area area8 = new Area(new Rectangle2D.Double(arc2D.getStartPoint().getX(), rectangle2D.getY(), arc2D.getEndPoint().getX() - arc2D.getStartPoint().getX(), rectangle2D.getHeight()));
                        area8.intersect(area2);
                        graphics2D.setPaint(paint);
                        graphics2D.fill(area8);
                        graphics2D.setPaint(paint2);
                        graphics2D.draw(area8);
                    }
                }
                else {
                    final Area area9 = new Area(new Rectangle2D.Double(arc2D.getStartPoint().getX(), rectangle2D.getY(), rectangle2D.getMaxX() - arc2D.getStartPoint().getX(), rectangle2D.getHeight()));
                    area9.intersect(area2);
                    final Area area10 = new Area(new Rectangle2D.Double(rectangle2D.getX(), rectangle2D.getY(), arc2D.getEndPoint().getX() - rectangle2D.getX(), rectangle2D.getHeight()));
                    area10.intersect(area2);
                    graphics2D.setPaint(paint);
                    if (b2) {
                        graphics2D.fill(area9);
                        graphics2D.fill(area10);
                    }
                    if (b) {
                        graphics2D.fill(area);
                    }
                    graphics2D.setPaint(paint2);
                    if (b2) {
                        graphics2D.draw(area9);
                        graphics2D.draw(area10);
                    }
                    if (b) {
                        graphics2D.draw(area);
                    }
                }
            }
            else {
                if (b2) {
                    final Area area11 = new Area(new Rectangle2D.Double(arc2D.getStartPoint().getX(), rectangle2D.getY(), rectangle2D.getMaxX() - arc2D.getStartPoint().getX(), rectangle2D.getHeight()));
                    area11.intersect(area2);
                    graphics2D.setPaint(paint);
                    graphics2D.fill(area11);
                    graphics2D.setPaint(paint2);
                    graphics2D.draw(area11);
                }
                if (b) {
                    final Area area12 = new Area(new Rectangle2D.Double(arc2D.getEndPoint().getX(), rectangle2D.getY(), rectangle2D.getMaxX() - arc2D.getEndPoint().getX(), rectangle2D.getHeight()));
                    area12.intersect(area);
                    graphics2D.setPaint(paint);
                    graphics2D.fill(area12);
                    graphics2D.setPaint(paint2);
                    graphics2D.draw(area12);
                }
            }
        }
        else if (angleExtent > 0.0) {
            if (this.isAngleAtFront(angleStart)) {
                if (!this.isAngleAtBack(n)) {
                    if (angleExtent < 180.0) {
                        if (b) {
                            final Area area13 = new Area(new Rectangle2D.Double(arc2D.getStartPoint().getX(), rectangle2D.getY(), arc2D.getEndPoint().getX() - arc2D.getStartPoint().getX(), rectangle2D.getHeight()));
                            area13.intersect(area);
                            graphics2D.setPaint(paint);
                            graphics2D.fill(area13);
                            graphics2D.setPaint(paint2);
                            graphics2D.draw(area13);
                        }
                    }
                    else {
                        final Area area14 = new Area(new Rectangle2D.Double(arc2D.getStartPoint().getX(), rectangle2D.getY(), rectangle2D.getMaxX() - arc2D.getStartPoint().getX(), rectangle2D.getHeight()));
                        area14.intersect(area);
                        final Area area15 = new Area(new Rectangle2D.Double(rectangle2D.getX(), rectangle2D.getY(), arc2D.getEndPoint().getX() - rectangle2D.getX(), rectangle2D.getHeight()));
                        area15.intersect(area);
                        graphics2D.setPaint(paint);
                        if (b) {
                            graphics2D.fill(area14);
                            graphics2D.fill(area15);
                        }
                        if (b2) {
                            graphics2D.fill(area2);
                        }
                        graphics2D.setPaint(paint2);
                        if (b) {
                            graphics2D.draw(area14);
                            graphics2D.draw(area15);
                        }
                        if (b2) {
                            graphics2D.draw(area2);
                        }
                    }
                }
                else {
                    if (b2) {
                        final Area area16 = new Area(new Rectangle2D.Double(arc2D.getEndPoint().getX(), rectangle2D.getY(), rectangle2D.getMaxX() - arc2D.getEndPoint().getX(), rectangle2D.getHeight()));
                        area16.intersect(area2);
                        graphics2D.setPaint(paint);
                        graphics2D.fill(area16);
                        graphics2D.setPaint(paint2);
                        graphics2D.draw(area16);
                    }
                    if (b) {
                        final Area area17 = new Area(new Rectangle2D.Double(arc2D.getStartPoint().getX(), rectangle2D.getY(), rectangle2D.getMaxX() - arc2D.getStartPoint().getX(), rectangle2D.getHeight()));
                        area17.intersect(area);
                        graphics2D.setPaint(paint);
                        graphics2D.fill(area17);
                        graphics2D.setPaint(paint2);
                        graphics2D.draw(area17);
                    }
                }
            }
            else if (!this.isAngleAtFront(n)) {
                if (angleExtent < 180.0) {
                    if (b2) {
                        final Area area18 = new Area(new Rectangle2D.Double(arc2D.getEndPoint().getX(), rectangle2D.getY(), arc2D.getStartPoint().getX() - arc2D.getEndPoint().getX(), rectangle2D.getHeight()));
                        area18.intersect(area2);
                        graphics2D.setPaint(paint);
                        graphics2D.fill(area18);
                        graphics2D.setPaint(paint2);
                        graphics2D.draw(area18);
                    }
                }
                else {
                    final Area area19 = new Area(new Rectangle2D.Double(arc2D.getStartPoint().getX(), rectangle2D.getY(), rectangle2D.getX() - arc2D.getStartPoint().getX(), rectangle2D.getHeight()));
                    area19.intersect(area2);
                    final Area area20 = new Area(new Rectangle2D.Double(arc2D.getEndPoint().getX(), rectangle2D.getY(), rectangle2D.getMaxX() - arc2D.getEndPoint().getX(), rectangle2D.getHeight()));
                    area20.intersect(area2);
                    graphics2D.setPaint(paint);
                    if (b2) {
                        graphics2D.fill(area19);
                        graphics2D.fill(area20);
                    }
                    if (b) {
                        graphics2D.fill(area);
                    }
                    graphics2D.setPaint(paint2);
                    if (b2) {
                        graphics2D.draw(area19);
                        graphics2D.draw(area20);
                    }
                    if (b) {
                        graphics2D.draw(area);
                    }
                }
            }
            else {
                if (b2) {
                    final Area area21 = new Area(new Rectangle2D.Double(rectangle2D.getX(), rectangle2D.getY(), arc2D.getStartPoint().getX() - rectangle2D.getX(), rectangle2D.getHeight()));
                    area21.intersect(area2);
                    graphics2D.setPaint(paint);
                    graphics2D.fill(area21);
                    graphics2D.setPaint(paint2);
                    graphics2D.draw(area21);
                }
                if (b) {
                    final Area area22 = new Area(new Rectangle2D.Double(rectangle2D.getX(), rectangle2D.getY(), arc2D.getEndPoint().getX() - rectangle2D.getX(), rectangle2D.getHeight()));
                    area22.intersect(area);
                    graphics2D.setPaint(paint);
                    graphics2D.fill(area22);
                    graphics2D.setPaint(paint2);
                    graphics2D.draw(area22);
                }
            }
        }
    }
    
    public String getPlotType() {
        return PiePlot3D.localizationResources.getString("Pie_3D_Plot");
    }
    
    private boolean isAngleAtFront(final double n) {
        return Math.sin(Math.toRadians(n)) < 0.0;
    }
    
    private boolean isAngleAtBack(final double n) {
        return Math.sin(Math.toRadians(n)) > 0.0;
    }
    
    public boolean equals(final Object o) {
        return o == this || (o instanceof PiePlot3D && this.depthFactor == ((PiePlot3D)o).depthFactor && super.equals(o));
    }
}
