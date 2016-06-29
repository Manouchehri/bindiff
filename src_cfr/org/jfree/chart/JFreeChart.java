/*
 * Decompiled with CFR 0_115.
 */
package org.jfree.chart;

import java.awt.AlphaComposite;
import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Composite;
import java.awt.Font;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.Paint;
import java.awt.RenderingHints;
import java.awt.Shape;
import java.awt.Stroke;
import java.awt.geom.AffineTransform;
import java.awt.geom.Point2D;
import java.awt.geom.Rectangle2D;
import java.awt.image.BufferedImage;
import java.awt.image.ImageObserver;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.PrintStream;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.EventListener;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import javax.swing.UIManager;
import javax.swing.event.EventListenerList;
import org.jfree.chart.ChartRenderingInfo;
import org.jfree.chart.JFreeChartInfo;
import org.jfree.chart.LegendItemSource;
import org.jfree.chart.block.BlockFrame;
import org.jfree.chart.block.BlockParams;
import org.jfree.chart.block.EntityBlockResult;
import org.jfree.chart.block.LengthConstraintType;
import org.jfree.chart.block.LineBorder;
import org.jfree.chart.block.RectangleConstraint;
import org.jfree.chart.entity.EntityCollection;
import org.jfree.chart.event.ChartChangeEvent;
import org.jfree.chart.event.ChartChangeListener;
import org.jfree.chart.event.ChartProgressEvent;
import org.jfree.chart.event.ChartProgressListener;
import org.jfree.chart.event.PlotChangeEvent;
import org.jfree.chart.event.PlotChangeListener;
import org.jfree.chart.event.TitleChangeEvent;
import org.jfree.chart.event.TitleChangeListener;
import org.jfree.chart.plot.CategoryPlot;
import org.jfree.chart.plot.Plot;
import org.jfree.chart.plot.PlotRenderingInfo;
import org.jfree.chart.plot.PlotState;
import org.jfree.chart.plot.XYPlot;
import org.jfree.chart.title.LegendTitle;
import org.jfree.chart.title.TextTitle;
import org.jfree.chart.title.Title;
import org.jfree.data.Range;
import org.jfree.io.SerialUtilities;
import org.jfree.ui.Align;
import org.jfree.ui.Drawable;
import org.jfree.ui.HorizontalAlignment;
import org.jfree.ui.RectangleEdge;
import org.jfree.ui.RectangleInsets;
import org.jfree.ui.Size2D;
import org.jfree.ui.VerticalAlignment;
import org.jfree.ui.about.ProjectInfo;
import org.jfree.util.ObjectUtilities;
import org.jfree.util.PaintUtilities;

public class JFreeChart
implements Serializable,
Cloneable,
PlotChangeListener,
TitleChangeListener,
Drawable {
    private static final long serialVersionUID = -3470703747817429120L;
    public static final ProjectInfo INFO = new JFreeChartInfo();
    public static final Font DEFAULT_TITLE_FONT = new Font("SansSerif", 1, 18);
    public static final Paint DEFAULT_BACKGROUND_PAINT = UIManager.getColor("Panel.background");
    public static final Image DEFAULT_BACKGROUND_IMAGE = null;
    public static final int DEFAULT_BACKGROUND_IMAGE_ALIGNMENT = 15;
    public static final float DEFAULT_BACKGROUND_IMAGE_ALPHA = 0.5f;
    private transient RenderingHints renderingHints;
    private boolean borderVisible;
    private transient Stroke borderStroke;
    private transient Paint borderPaint;
    private RectangleInsets padding;
    private TextTitle title;
    private List subtitles;
    private Plot plot;
    private transient Paint backgroundPaint;
    private transient Image backgroundImage;
    private int backgroundImageAlignment = 15;
    private float backgroundImageAlpha = 0.5f;
    private transient EventListenerList changeListeners;
    private transient EventListenerList progressListeners;
    private boolean notify;
    static Class class$org$jfree$chart$event$ChartChangeListener;
    static Class class$org$jfree$chart$event$ChartProgressListener;

    public JFreeChart(Plot plot) {
        this(null, null, plot, true);
    }

    public JFreeChart(String string, Plot plot) {
        this(string, DEFAULT_TITLE_FONT, plot, true);
    }

    public JFreeChart(String string, Font font, Plot plot, boolean bl2) {
        if (plot == null) {
            throw new NullPointerException("Null 'plot' argument.");
        }
        this.progressListeners = new EventListenerList();
        this.changeListeners = new EventListenerList();
        this.notify = true;
        this.renderingHints = new RenderingHints(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
        this.borderVisible = false;
        this.borderStroke = new BasicStroke(1.0f);
        this.borderPaint = Color.black;
        this.padding = RectangleInsets.ZERO_INSETS;
        this.plot = plot;
        plot.addChangeListener(this);
        this.subtitles = new ArrayList();
        if (bl2) {
            LegendTitle legendTitle = new LegendTitle(this.plot);
            legendTitle.setMargin(new RectangleInsets(1.0, 1.0, 1.0, 1.0));
            legendTitle.setFrame(new LineBorder());
            legendTitle.setBackgroundPaint(Color.white);
            legendTitle.setPosition(RectangleEdge.BOTTOM);
            this.subtitles.add(legendTitle);
        }
        if (string != null) {
            if (font == null) {
                font = DEFAULT_TITLE_FONT;
            }
            this.title = new TextTitle(string, font);
            this.title.addChangeListener(this);
        }
        this.backgroundPaint = DEFAULT_BACKGROUND_PAINT;
        this.backgroundImage = DEFAULT_BACKGROUND_IMAGE;
        this.backgroundImageAlignment = 15;
        this.backgroundImageAlpha = 0.5f;
    }

    public RenderingHints getRenderingHints() {
        return this.renderingHints;
    }

    public void setRenderingHints(RenderingHints renderingHints) {
        if (renderingHints == null) {
            throw new NullPointerException("RenderingHints given are null");
        }
        this.renderingHints = renderingHints;
        this.fireChartChanged();
    }

    public boolean isBorderVisible() {
        return this.borderVisible;
    }

    public void setBorderVisible(boolean bl2) {
        this.borderVisible = bl2;
        this.fireChartChanged();
    }

    public Stroke getBorderStroke() {
        return this.borderStroke;
    }

    public void setBorderStroke(Stroke stroke) {
        this.borderStroke = stroke;
        this.fireChartChanged();
    }

    public Paint getBorderPaint() {
        return this.borderPaint;
    }

    public void setBorderPaint(Paint paint) {
        this.borderPaint = paint;
        this.fireChartChanged();
    }

    public RectangleInsets getPadding() {
        return this.padding;
    }

    public void setPadding(RectangleInsets rectangleInsets) {
        if (rectangleInsets == null) {
            throw new IllegalArgumentException("Null 'padding' argument.");
        }
        this.padding = rectangleInsets;
        this.notifyListeners(new ChartChangeEvent(this));
    }

    public TextTitle getTitle() {
        return this.title;
    }

    public void setTitle(TextTitle textTitle) {
        this.title = textTitle;
        this.fireChartChanged();
    }

    public void setTitle(String string) {
        if (string == null) {
            this.setTitle((TextTitle)null);
            return;
        }
        if (this.title == null) {
            this.setTitle(new TextTitle(string, DEFAULT_TITLE_FONT));
            return;
        }
        this.title.setText(string);
    }

    public void addLegend(LegendTitle legendTitle) {
        this.addSubtitle(legendTitle);
    }

    public LegendTitle getLegend() {
        return this.getLegend(0);
    }

    public LegendTitle getLegend(int n2) {
        int n3 = 0;
        Iterator iterator = this.subtitles.iterator();
        while (iterator.hasNext()) {
            Title title = (Title)iterator.next();
            if (!(title instanceof LegendTitle)) continue;
            if (n3 == n2) {
                return (LegendTitle)title;
            }
            ++n3;
        }
        return null;
    }

    public void removeLegend() {
        this.removeSubtitle(this.getLegend());
    }

    public List getSubtitles() {
        return this.subtitles;
    }

    public void setSubtitles(List list) {
        if (list == null) {
            throw new NullPointerException("Null 'subtitles' argument.");
        }
        this.subtitles = list;
        this.fireChartChanged();
    }

    public int getSubtitleCount() {
        return this.subtitles.size();
    }

    public Title getSubtitle(int n2) {
        if (n2 < 0) throw new IllegalArgumentException("Index out of range.");
        if (n2 != this.getSubtitleCount()) return (Title)this.subtitles.get(n2);
        throw new IllegalArgumentException("Index out of range.");
    }

    public void addSubtitle(Title title) {
        if (title == null) {
            throw new IllegalArgumentException("Null 'subtitle' argument.");
        }
        this.subtitles.add(title);
        title.addChangeListener(this);
        this.fireChartChanged();
    }

    public void clearSubtitles() {
        Iterator iterator = this.subtitles.iterator();
        do {
            if (!iterator.hasNext()) {
                this.subtitles.clear();
                this.fireChartChanged();
                return;
            }
            Title title = (Title)iterator.next();
            title.removeChangeListener(this);
        } while (true);
    }

    public void removeSubtitle(Title title) {
        this.subtitles.remove(title);
        this.fireChartChanged();
    }

    public Plot getPlot() {
        return this.plot;
    }

    public CategoryPlot getCategoryPlot() {
        return (CategoryPlot)this.plot;
    }

    public XYPlot getXYPlot() {
        return (XYPlot)this.plot;
    }

    public boolean getAntiAlias() {
        Object object = this.renderingHints.get(RenderingHints.KEY_ANTIALIASING);
        return RenderingHints.VALUE_ANTIALIAS_ON.equals(object);
    }

    public void setAntiAlias(boolean bl2) {
        Object object = this.renderingHints.get(RenderingHints.KEY_ANTIALIASING);
        if (object == null) {
            object = RenderingHints.VALUE_ANTIALIAS_DEFAULT;
        }
        if (!bl2) {
            if (RenderingHints.VALUE_ANTIALIAS_OFF.equals(object)) return;
        }
        if (bl2 && RenderingHints.VALUE_ANTIALIAS_ON.equals(object)) {
            return;
        }
        if (bl2) {
            this.renderingHints.put(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
        } else {
            this.renderingHints.put(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_OFF);
        }
        this.fireChartChanged();
    }

    public Object getTextAntiAlias() {
        return this.renderingHints.get(RenderingHints.KEY_TEXT_ANTIALIASING);
    }

    public void setTextAntiAlias(boolean bl2) {
        if (bl2) {
            this.setTextAntiAlias(RenderingHints.VALUE_TEXT_ANTIALIAS_ON);
            return;
        }
        this.setTextAntiAlias(RenderingHints.VALUE_TEXT_ANTIALIAS_OFF);
    }

    public void setTextAntiAlias(Object object) {
        this.renderingHints.put(RenderingHints.KEY_TEXT_ANTIALIASING, object);
        this.notifyListeners(new ChartChangeEvent(this));
    }

    public Paint getBackgroundPaint() {
        return this.backgroundPaint;
    }

    public void setBackgroundPaint(Paint paint) {
        if (this.backgroundPaint != null) {
            if (this.backgroundPaint.equals(paint)) return;
            this.backgroundPaint = paint;
            this.fireChartChanged();
            return;
        }
        if (paint == null) return;
        this.backgroundPaint = paint;
        this.fireChartChanged();
    }

    public Image getBackgroundImage() {
        return this.backgroundImage;
    }

    public void setBackgroundImage(Image image) {
        if (this.backgroundImage != null) {
            if (this.backgroundImage.equals(image)) return;
            this.backgroundImage = image;
            this.fireChartChanged();
            return;
        }
        if (image == null) return;
        this.backgroundImage = image;
        this.fireChartChanged();
    }

    public int getBackgroundImageAlignment() {
        return this.backgroundImageAlignment;
    }

    public void setBackgroundImageAlignment(int n2) {
        if (this.backgroundImageAlignment == n2) return;
        this.backgroundImageAlignment = n2;
        this.fireChartChanged();
    }

    public float getBackgroundImageAlpha() {
        return this.backgroundImageAlpha;
    }

    public void setBackgroundImageAlpha(float f2) {
        if (this.backgroundImageAlpha == f2) return;
        this.backgroundImageAlpha = f2;
        this.fireChartChanged();
    }

    public boolean isNotify() {
        return this.notify;
    }

    public void setNotify(boolean bl2) {
        this.notify = bl2;
        if (!bl2) return;
        this.notifyListeners(new ChartChangeEvent(this));
    }

    @Override
    public void draw(Graphics2D graphics2D, Rectangle2D rectangle2D) {
        this.draw(graphics2D, rectangle2D, null, null);
    }

    public void draw(Graphics2D graphics2D, Rectangle2D rectangle2D, ChartRenderingInfo chartRenderingInfo) {
        this.draw(graphics2D, rectangle2D, null, chartRenderingInfo);
    }

    public void draw(Graphics2D graphics2D, Rectangle2D rectangle2D, Point2D point2D, ChartRenderingInfo chartRenderingInfo) {
        Object object;
        Object object2;
        Object object32;
        Object object4;
        Object object5;
        this.notifyListeners(new ChartProgressEvent(this, this, 1, 0));
        if (chartRenderingInfo != null) {
            chartRenderingInfo.clear();
            chartRenderingInfo.setChartArea(rectangle2D);
        }
        Shape shape = graphics2D.getClip();
        graphics2D.clip(rectangle2D);
        graphics2D.addRenderingHints(this.renderingHints);
        if (this.backgroundPaint != null) {
            graphics2D.setPaint(this.backgroundPaint);
            graphics2D.fill(rectangle2D);
        }
        if (this.backgroundImage != null) {
            object4 = graphics2D.getComposite();
            graphics2D.setComposite(AlphaComposite.getInstance(3, this.backgroundImageAlpha));
            object2 = new Rectangle2D.Double(0.0, 0.0, this.backgroundImage.getWidth(null), this.backgroundImage.getHeight(null));
            Align.align((Rectangle2D)object2, rectangle2D, this.backgroundImageAlignment);
            graphics2D.drawImage(this.backgroundImage, (int)object2.getX(), (int)object2.getY(), (int)object2.getWidth(), (int)object2.getHeight(), null);
            graphics2D.setComposite((Composite)object4);
        }
        if (this.isBorderVisible()) {
            object4 = this.getBorderPaint();
            object2 = this.getBorderStroke();
            if (object4 != null && object2 != null) {
                object5 = new Rectangle2D.Double(rectangle2D.getX(), rectangle2D.getY(), rectangle2D.getWidth() - 1.0, rectangle2D.getHeight() - 1.0);
                graphics2D.setPaint((Paint)object4);
                graphics2D.setStroke((Stroke)object2);
                graphics2D.draw((Shape)object5);
            }
        }
        object4 = new Rectangle2D.Double();
        object4.setRect(rectangle2D);
        this.padding.trim((Rectangle2D)object4);
        object2 = null;
        if (chartRenderingInfo != null) {
            object2 = chartRenderingInfo.getEntityCollection();
        }
        if (this.title != null && (object5 = this.drawTitle(this.title, graphics2D, (Rectangle2D)object4, object2 != null)) != null) {
            object2.addAll((EntityCollection)object5);
        }
        for (Object object32 : this.subtitles) {
            object = this.drawTitle((Title)object32, graphics2D, (Rectangle2D)object4, object2 != null);
            if (object == null) continue;
            object2.addAll((EntityCollection)object);
        }
        object32 = object4;
        object = null;
        if (chartRenderingInfo != null) {
            object = chartRenderingInfo.getPlotInfo();
        }
        this.plot.draw(graphics2D, (Rectangle2D)object32, point2D, null, (PlotRenderingInfo)object);
        graphics2D.setClip(shape);
        this.notifyListeners(new ChartProgressEvent(this, this, 2, 100));
    }

    private Rectangle2D createAlignedRectangle2D(Size2D size2D, Rectangle2D rectangle2D, HorizontalAlignment horizontalAlignment, VerticalAlignment verticalAlignment) {
        double d2 = Double.NaN;
        double d3 = Double.NaN;
        if (horizontalAlignment == HorizontalAlignment.LEFT) {
            d2 = rectangle2D.getX();
        } else if (horizontalAlignment == HorizontalAlignment.CENTER) {
            d2 = rectangle2D.getCenterX() - size2D.width / 2.0;
        } else if (horizontalAlignment == HorizontalAlignment.RIGHT) {
            d2 = rectangle2D.getMaxX() - size2D.width;
        }
        if (verticalAlignment == VerticalAlignment.TOP) {
            d3 = rectangle2D.getY();
            return new Rectangle2D.Double(d2, d3, size2D.width, size2D.height);
        }
        if (verticalAlignment == VerticalAlignment.CENTER) {
            d3 = rectangle2D.getCenterY() - size2D.height / 2.0;
            return new Rectangle2D.Double(d2, d3, size2D.width, size2D.height);
        }
        if (verticalAlignment != VerticalAlignment.BOTTOM) return new Rectangle2D.Double(d2, d3, size2D.width, size2D.height);
        d3 = rectangle2D.getMaxY() - size2D.height;
        return new Rectangle2D.Double(d2, d3, size2D.width, size2D.height);
    }

    protected EntityCollection drawTitle(Title title, Graphics2D graphics2D, Rectangle2D rectangle2D, boolean bl2) {
        Object object;
        if (title == null) {
            throw new IllegalArgumentException("Null 't' argument.");
        }
        if (rectangle2D == null) {
            throw new IllegalArgumentException("Null 'area' argument.");
        }
        Rectangle2D rectangle2D2 = new Rectangle2D.Double();
        RectangleEdge rectangleEdge = title.getPosition();
        double d2 = rectangle2D.getWidth();
        if (d2 <= 0.0) {
            return null;
        }
        double d3 = rectangle2D.getHeight();
        if (d3 <= 0.0) {
            return null;
        }
        RectangleConstraint rectangleConstraint = new RectangleConstraint(d2, new Range(0.0, d2), LengthConstraintType.RANGE, d3, new Range(0.0, d3), LengthConstraintType.RANGE);
        Object object2 = null;
        BlockParams blockParams = new BlockParams();
        blockParams.setGenerateEntities(bl2);
        if (rectangleEdge == RectangleEdge.TOP) {
            object = title.arrange(graphics2D, rectangleConstraint);
            rectangle2D2 = this.createAlignedRectangle2D((Size2D)object, rectangle2D, title.getHorizontalAlignment(), VerticalAlignment.TOP);
            object2 = title.draw(graphics2D, rectangle2D2, blockParams);
            rectangle2D.setRect(rectangle2D.getX(), Math.min(rectangle2D.getY() + object.height, rectangle2D.getMaxY()), rectangle2D.getWidth(), Math.max(rectangle2D.getHeight() - object.height, 0.0));
        } else if (rectangleEdge == RectangleEdge.BOTTOM) {
            object = title.arrange(graphics2D, rectangleConstraint);
            rectangle2D2 = this.createAlignedRectangle2D((Size2D)object, rectangle2D, title.getHorizontalAlignment(), VerticalAlignment.BOTTOM);
            object2 = title.draw(graphics2D, rectangle2D2, blockParams);
            rectangle2D.setRect(rectangle2D.getX(), rectangle2D.getY(), rectangle2D.getWidth(), rectangle2D.getHeight() - object.height);
        } else if (rectangleEdge == RectangleEdge.RIGHT) {
            object = title.arrange(graphics2D, rectangleConstraint);
            rectangle2D2 = this.createAlignedRectangle2D((Size2D)object, rectangle2D, HorizontalAlignment.RIGHT, title.getVerticalAlignment());
            object2 = title.draw(graphics2D, rectangle2D2, blockParams);
            rectangle2D.setRect(rectangle2D.getX(), rectangle2D.getY(), rectangle2D.getWidth() - object.width, rectangle2D.getHeight());
        } else {
            if (rectangleEdge != RectangleEdge.LEFT) throw new RuntimeException("Unrecognised title position.");
            object = title.arrange(graphics2D, rectangleConstraint);
            rectangle2D2 = this.createAlignedRectangle2D((Size2D)object, rectangle2D, HorizontalAlignment.LEFT, title.getVerticalAlignment());
            object2 = title.draw(graphics2D, rectangle2D2, blockParams);
            rectangle2D.setRect(rectangle2D.getX() + object.width, rectangle2D.getY(), rectangle2D.getWidth() - object.width, rectangle2D.getHeight());
        }
        object = null;
        if (!(object2 instanceof EntityBlockResult)) return object;
        EntityBlockResult entityBlockResult = (EntityBlockResult)object2;
        return entityBlockResult.getEntityCollection();
    }

    public BufferedImage createBufferedImage(int n2, int n3) {
        return this.createBufferedImage(n2, n3, null);
    }

    public BufferedImage createBufferedImage(int n2, int n3, ChartRenderingInfo chartRenderingInfo) {
        return this.createBufferedImage(n2, n3, 1, chartRenderingInfo);
    }

    public BufferedImage createBufferedImage(int n2, int n3, int n4, ChartRenderingInfo chartRenderingInfo) {
        BufferedImage bufferedImage = new BufferedImage(n2, n3, n4);
        Graphics2D graphics2D = bufferedImage.createGraphics();
        this.draw(graphics2D, new Rectangle2D.Double(0.0, 0.0, n2, n3), null, chartRenderingInfo);
        graphics2D.dispose();
        return bufferedImage;
    }

    public BufferedImage createBufferedImage(int n2, int n3, double d2, double d3, ChartRenderingInfo chartRenderingInfo) {
        BufferedImage bufferedImage = new BufferedImage(n2, n3, 1);
        Graphics2D graphics2D = bufferedImage.createGraphics();
        double d4 = (double)n2 / d2;
        double d5 = (double)n3 / d3;
        AffineTransform affineTransform = AffineTransform.getScaleInstance(d4, d5);
        graphics2D.transform(affineTransform);
        this.draw(graphics2D, new Rectangle2D.Double(0.0, 0.0, d2, d3), null, chartRenderingInfo);
        graphics2D.dispose();
        return bufferedImage;
    }

    public void handleClick(int n2, int n3, ChartRenderingInfo chartRenderingInfo) {
        this.plot.handleClick(n2, n3, chartRenderingInfo.getPlotInfo());
    }

    public void addChangeListener(ChartChangeListener chartChangeListener) {
        if (chartChangeListener == null) {
            throw new IllegalArgumentException("Null 'listener' argument.");
        }
        Class class_ = class$org$jfree$chart$event$ChartChangeListener == null ? (JFreeChart.class$org$jfree$chart$event$ChartChangeListener = JFreeChart.class$("org.jfree.chart.event.ChartChangeListener")) : class$org$jfree$chart$event$ChartChangeListener;
        this.changeListeners.add(class_, chartChangeListener);
    }

    public void removeChangeListener(ChartChangeListener chartChangeListener) {
        if (chartChangeListener == null) {
            throw new IllegalArgumentException("Null 'listener' argument.");
        }
        Class class_ = class$org$jfree$chart$event$ChartChangeListener == null ? (JFreeChart.class$org$jfree$chart$event$ChartChangeListener = JFreeChart.class$("org.jfree.chart.event.ChartChangeListener")) : class$org$jfree$chart$event$ChartChangeListener;
        this.changeListeners.remove(class_, chartChangeListener);
    }

    public void fireChartChanged() {
        ChartChangeEvent chartChangeEvent = new ChartChangeEvent(this);
        this.notifyListeners(chartChangeEvent);
    }

    protected void notifyListeners(ChartChangeEvent chartChangeEvent) {
        if (!this.notify) return;
        Object[] arrobject = this.changeListeners.getListenerList();
        int n2 = arrobject.length - 2;
        while (n2 >= 0) {
            if (arrobject[n2] == (class$org$jfree$chart$event$ChartChangeListener == null ? JFreeChart.class$("org.jfree.chart.event.ChartChangeListener") : class$org$jfree$chart$event$ChartChangeListener)) {
                ((ChartChangeListener)arrobject[n2 + 1]).chartChanged(chartChangeEvent);
            }
            n2 -= 2;
        }
    }

    public void addProgressListener(ChartProgressListener chartProgressListener) {
        Class class_ = class$org$jfree$chart$event$ChartProgressListener == null ? (JFreeChart.class$org$jfree$chart$event$ChartProgressListener = JFreeChart.class$("org.jfree.chart.event.ChartProgressListener")) : class$org$jfree$chart$event$ChartProgressListener;
        this.progressListeners.add(class_, chartProgressListener);
    }

    public void removeProgressListener(ChartProgressListener chartProgressListener) {
        Class class_ = class$org$jfree$chart$event$ChartProgressListener == null ? (JFreeChart.class$org$jfree$chart$event$ChartProgressListener = JFreeChart.class$("org.jfree.chart.event.ChartProgressListener")) : class$org$jfree$chart$event$ChartProgressListener;
        this.progressListeners.remove(class_, chartProgressListener);
    }

    protected void notifyListeners(ChartProgressEvent chartProgressEvent) {
        Object[] arrobject = this.progressListeners.getListenerList();
        int n2 = arrobject.length - 2;
        while (n2 >= 0) {
            if (arrobject[n2] == (class$org$jfree$chart$event$ChartProgressListener == null ? JFreeChart.class$("org.jfree.chart.event.ChartProgressListener") : class$org$jfree$chart$event$ChartProgressListener)) {
                ((ChartProgressListener)arrobject[n2 + 1]).chartProgress(chartProgressEvent);
            }
            n2 -= 2;
        }
    }

    @Override
    public void titleChanged(TitleChangeEvent titleChangeEvent) {
        titleChangeEvent.setChart(this);
        this.notifyListeners(titleChangeEvent);
    }

    @Override
    public void plotChanged(PlotChangeEvent plotChangeEvent) {
        plotChangeEvent.setChart(this);
        this.notifyListeners(plotChangeEvent);
    }

    public boolean equals(Object object) {
        if (object == this) {
            return true;
        }
        if (!(object instanceof JFreeChart)) {
            return false;
        }
        JFreeChart jFreeChart = (JFreeChart)object;
        if (!this.renderingHints.equals(jFreeChart.renderingHints)) {
            return false;
        }
        if (this.borderVisible != jFreeChart.borderVisible) {
            return false;
        }
        if (!ObjectUtilities.equal(this.borderStroke, jFreeChart.borderStroke)) {
            return false;
        }
        if (!PaintUtilities.equal(this.borderPaint, jFreeChart.borderPaint)) {
            return false;
        }
        if (!this.padding.equals(jFreeChart.padding)) {
            return false;
        }
        if (!ObjectUtilities.equal(this.title, jFreeChart.title)) {
            return false;
        }
        if (!ObjectUtilities.equal(this.subtitles, jFreeChart.subtitles)) {
            return false;
        }
        if (!ObjectUtilities.equal(this.plot, jFreeChart.plot)) {
            return false;
        }
        if (!PaintUtilities.equal(this.backgroundPaint, jFreeChart.backgroundPaint)) {
            return false;
        }
        if (!ObjectUtilities.equal(this.backgroundImage, jFreeChart.backgroundImage)) {
            return false;
        }
        if (this.backgroundImageAlignment != jFreeChart.backgroundImageAlignment) {
            return false;
        }
        if (this.backgroundImageAlpha != jFreeChart.backgroundImageAlpha) {
            return false;
        }
        if (this.notify == jFreeChart.notify) return true;
        return false;
    }

    private void writeObject(ObjectOutputStream objectOutputStream) {
        objectOutputStream.defaultWriteObject();
        SerialUtilities.writeStroke(this.borderStroke, objectOutputStream);
        SerialUtilities.writePaint(this.borderPaint, objectOutputStream);
        SerialUtilities.writePaint(this.backgroundPaint, objectOutputStream);
    }

    private void readObject(ObjectInputStream objectInputStream) {
        objectInputStream.defaultReadObject();
        this.borderStroke = SerialUtilities.readStroke(objectInputStream);
        this.borderPaint = SerialUtilities.readPaint(objectInputStream);
        this.backgroundPaint = SerialUtilities.readPaint(objectInputStream);
        this.progressListeners = new EventListenerList();
        this.changeListeners = new EventListenerList();
        this.renderingHints = new RenderingHints(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
        if (this.title != null) {
            this.title.addChangeListener(this);
        }
        int n2 = 0;
        do {
            if (n2 >= this.getSubtitleCount()) {
                this.plot.addChangeListener(this);
                return;
            }
            this.getSubtitle(n2).addChangeListener(this);
            ++n2;
        } while (true);
    }

    public static void main(String[] arrstring) {
        System.out.println(INFO.toString());
    }

    public Object clone() {
        JFreeChart jFreeChart = (JFreeChart)super.clone();
        jFreeChart.renderingHints = (RenderingHints)this.renderingHints.clone();
        if (this.title != null) {
            jFreeChart.title = (TextTitle)this.title.clone();
            jFreeChart.title.addChangeListener(jFreeChart);
        }
        jFreeChart.subtitles = new ArrayList();
        for (int i2 = 0; i2 < this.getSubtitleCount(); ++i2) {
            Title title = (Title)this.getSubtitle(i2).clone();
            jFreeChart.subtitles.add(title);
            title.addChangeListener(jFreeChart);
        }
        if (this.plot != null) {
            jFreeChart.plot = (Plot)this.plot.clone();
            jFreeChart.plot.addChangeListener(jFreeChart);
        }
        jFreeChart.progressListeners = new EventListenerList();
        jFreeChart.changeListeners = new EventListenerList();
        return jFreeChart;
    }

    static Class class$(String string) {
        try {
            return Class.forName(string);
        }
        catch (ClassNotFoundException var1_1) {
            throw new NoClassDefFoundError(var1_1.getMessage());
        }
    }
}

