package org.jfree.chart;

import org.jfree.ui.about.*;
import javax.swing.event.*;
import org.jfree.chart.title.*;
import java.util.*;
import java.awt.*;
import org.jfree.chart.entity.*;
import org.jfree.chart.plot.*;
import org.jfree.ui.*;
import org.jfree.data.*;
import org.jfree.chart.block.*;
import java.awt.image.*;
import java.awt.geom.*;
import org.jfree.chart.event.*;
import org.jfree.util.*;
import org.jfree.io.*;
import java.io.*;
import javax.swing.*;

public class JFreeChart implements Serializable, Cloneable, PlotChangeListener, TitleChangeListener, Drawable
{
    private static final long serialVersionUID = -3470703747817429120L;
    public static final ProjectInfo INFO;
    public static final Font DEFAULT_TITLE_FONT;
    public static final Paint DEFAULT_BACKGROUND_PAINT;
    public static final Image DEFAULT_BACKGROUND_IMAGE;
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
    private int backgroundImageAlignment;
    private float backgroundImageAlpha;
    private transient EventListenerList changeListeners;
    private transient EventListenerList progressListeners;
    private boolean notify;
    static Class class$org$jfree$chart$event$ChartChangeListener;
    static Class class$org$jfree$chart$event$ChartProgressListener;
    
    public JFreeChart(final Plot plot) {
        this(null, null, plot, true);
    }
    
    public JFreeChart(final String s, final Plot plot) {
        this(s, JFreeChart.DEFAULT_TITLE_FONT, plot, true);
    }
    
    public JFreeChart(final String s, Font default_TITLE_FONT, final Plot plot, final boolean b) {
        this.backgroundImageAlignment = 15;
        this.backgroundImageAlpha = 0.5f;
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
        (this.plot = plot).addChangeListener(this);
        this.subtitles = new ArrayList();
        if (b) {
            final LegendTitle legendTitle = new LegendTitle(this.plot);
            legendTitle.setMargin(new RectangleInsets(1.0, 1.0, 1.0, 1.0));
            legendTitle.setFrame(new LineBorder());
            legendTitle.setBackgroundPaint(Color.white);
            legendTitle.setPosition(RectangleEdge.BOTTOM);
            this.subtitles.add(legendTitle);
        }
        if (s != null) {
            if (default_TITLE_FONT == null) {
                default_TITLE_FONT = JFreeChart.DEFAULT_TITLE_FONT;
            }
            (this.title = new TextTitle(s, default_TITLE_FONT)).addChangeListener(this);
        }
        this.backgroundPaint = JFreeChart.DEFAULT_BACKGROUND_PAINT;
        this.backgroundImage = JFreeChart.DEFAULT_BACKGROUND_IMAGE;
        this.backgroundImageAlignment = 15;
        this.backgroundImageAlpha = 0.5f;
    }
    
    public RenderingHints getRenderingHints() {
        return this.renderingHints;
    }
    
    public void setRenderingHints(final RenderingHints renderingHints) {
        if (renderingHints == null) {
            throw new NullPointerException("RenderingHints given are null");
        }
        this.renderingHints = renderingHints;
        this.fireChartChanged();
    }
    
    public boolean isBorderVisible() {
        return this.borderVisible;
    }
    
    public void setBorderVisible(final boolean borderVisible) {
        this.borderVisible = borderVisible;
        this.fireChartChanged();
    }
    
    public Stroke getBorderStroke() {
        return this.borderStroke;
    }
    
    public void setBorderStroke(final Stroke borderStroke) {
        this.borderStroke = borderStroke;
        this.fireChartChanged();
    }
    
    public Paint getBorderPaint() {
        return this.borderPaint;
    }
    
    public void setBorderPaint(final Paint borderPaint) {
        this.borderPaint = borderPaint;
        this.fireChartChanged();
    }
    
    public RectangleInsets getPadding() {
        return this.padding;
    }
    
    public void setPadding(final RectangleInsets padding) {
        if (padding == null) {
            throw new IllegalArgumentException("Null 'padding' argument.");
        }
        this.padding = padding;
        this.notifyListeners(new ChartChangeEvent(this));
    }
    
    public TextTitle getTitle() {
        return this.title;
    }
    
    public void setTitle(final TextTitle title) {
        this.title = title;
        this.fireChartChanged();
    }
    
    public void setTitle(final String text) {
        if (text != null) {
            if (this.title == null) {
                this.setTitle(new TextTitle(text, JFreeChart.DEFAULT_TITLE_FONT));
            }
            else {
                this.title.setText(text);
            }
        }
        else {
            this.setTitle((TextTitle)null);
        }
    }
    
    public void addLegend(final LegendTitle legendTitle) {
        this.addSubtitle(legendTitle);
    }
    
    public LegendTitle getLegend() {
        return this.getLegend(0);
    }
    
    public LegendTitle getLegend(final int n) {
        int n2 = 0;
        for (final Title title : this.subtitles) {
            if (title instanceof LegendTitle) {
                if (n2 == n) {
                    return (LegendTitle)title;
                }
                ++n2;
            }
        }
        return null;
    }
    
    public void removeLegend() {
        this.removeSubtitle(this.getLegend());
    }
    
    public List getSubtitles() {
        return this.subtitles;
    }
    
    public void setSubtitles(final List subtitles) {
        if (subtitles == null) {
            throw new NullPointerException("Null 'subtitles' argument.");
        }
        this.subtitles = subtitles;
        this.fireChartChanged();
    }
    
    public int getSubtitleCount() {
        return this.subtitles.size();
    }
    
    public Title getSubtitle(final int n) {
        if (n < 0 || n == this.getSubtitleCount()) {
            throw new IllegalArgumentException("Index out of range.");
        }
        return this.subtitles.get(n);
    }
    
    public void addSubtitle(final Title title) {
        if (title == null) {
            throw new IllegalArgumentException("Null 'subtitle' argument.");
        }
        this.subtitles.add(title);
        title.addChangeListener(this);
        this.fireChartChanged();
    }
    
    public void clearSubtitles() {
        final Iterator<Title> iterator = this.subtitles.iterator();
        while (iterator.hasNext()) {
            iterator.next().removeChangeListener(this);
        }
        this.subtitles.clear();
        this.fireChartChanged();
    }
    
    public void removeSubtitle(final Title title) {
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
        return RenderingHints.VALUE_ANTIALIAS_ON.equals(this.renderingHints.get(RenderingHints.KEY_ANTIALIASING));
    }
    
    public void setAntiAlias(final boolean b) {
        Object o = this.renderingHints.get(RenderingHints.KEY_ANTIALIASING);
        if (o == null) {
            o = RenderingHints.VALUE_ANTIALIAS_DEFAULT;
        }
        if ((!b && RenderingHints.VALUE_ANTIALIAS_OFF.equals(o)) || (b && RenderingHints.VALUE_ANTIALIAS_ON.equals(o))) {
            return;
        }
        if (b) {
            this.renderingHints.put(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
        }
        else {
            this.renderingHints.put(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_OFF);
        }
        this.fireChartChanged();
    }
    
    public Object getTextAntiAlias() {
        return this.renderingHints.get(RenderingHints.KEY_TEXT_ANTIALIASING);
    }
    
    public void setTextAntiAlias(final boolean b) {
        if (b) {
            this.setTextAntiAlias(RenderingHints.VALUE_TEXT_ANTIALIAS_ON);
        }
        else {
            this.setTextAntiAlias(RenderingHints.VALUE_TEXT_ANTIALIAS_OFF);
        }
    }
    
    public void setTextAntiAlias(final Object o) {
        this.renderingHints.put(RenderingHints.KEY_TEXT_ANTIALIASING, o);
        this.notifyListeners(new ChartChangeEvent(this));
    }
    
    public Paint getBackgroundPaint() {
        return this.backgroundPaint;
    }
    
    public void setBackgroundPaint(final Paint paint) {
        if (this.backgroundPaint != null) {
            if (!this.backgroundPaint.equals(paint)) {
                this.backgroundPaint = paint;
                this.fireChartChanged();
            }
        }
        else if (paint != null) {
            this.backgroundPaint = paint;
            this.fireChartChanged();
        }
    }
    
    public Image getBackgroundImage() {
        return this.backgroundImage;
    }
    
    public void setBackgroundImage(final Image image) {
        if (this.backgroundImage != null) {
            if (!this.backgroundImage.equals(image)) {
                this.backgroundImage = image;
                this.fireChartChanged();
            }
        }
        else if (image != null) {
            this.backgroundImage = image;
            this.fireChartChanged();
        }
    }
    
    public int getBackgroundImageAlignment() {
        return this.backgroundImageAlignment;
    }
    
    public void setBackgroundImageAlignment(final int backgroundImageAlignment) {
        if (this.backgroundImageAlignment != backgroundImageAlignment) {
            this.backgroundImageAlignment = backgroundImageAlignment;
            this.fireChartChanged();
        }
    }
    
    public float getBackgroundImageAlpha() {
        return this.backgroundImageAlpha;
    }
    
    public void setBackgroundImageAlpha(final float backgroundImageAlpha) {
        if (this.backgroundImageAlpha != backgroundImageAlpha) {
            this.backgroundImageAlpha = backgroundImageAlpha;
            this.fireChartChanged();
        }
    }
    
    public boolean isNotify() {
        return this.notify;
    }
    
    public void setNotify(final boolean notify) {
        this.notify = notify;
        if (notify) {
            this.notifyListeners(new ChartChangeEvent(this));
        }
    }
    
    public void draw(final Graphics2D graphics2D, final Rectangle2D rectangle2D) {
        this.draw(graphics2D, rectangle2D, null, null);
    }
    
    public void draw(final Graphics2D graphics2D, final Rectangle2D rectangle2D, final ChartRenderingInfo chartRenderingInfo) {
        this.draw(graphics2D, rectangle2D, null, chartRenderingInfo);
    }
    
    public void draw(final Graphics2D graphics2D, final Rectangle2D rectangle2D, final Point2D point2D, final ChartRenderingInfo chartRenderingInfo) {
        this.notifyListeners(new ChartProgressEvent(this, this, 1, 0));
        if (chartRenderingInfo != null) {
            chartRenderingInfo.clear();
            chartRenderingInfo.setChartArea(rectangle2D);
        }
        final Shape clip = graphics2D.getClip();
        graphics2D.clip(rectangle2D);
        graphics2D.addRenderingHints(this.renderingHints);
        if (this.backgroundPaint != null) {
            graphics2D.setPaint(this.backgroundPaint);
            graphics2D.fill(rectangle2D);
        }
        if (this.backgroundImage != null) {
            final Composite composite = graphics2D.getComposite();
            graphics2D.setComposite(AlphaComposite.getInstance(3, this.backgroundImageAlpha));
            final Rectangle2D.Double double1 = new Rectangle2D.Double(0.0, 0.0, this.backgroundImage.getWidth(null), this.backgroundImage.getHeight(null));
            Align.align(double1, rectangle2D, this.backgroundImageAlignment);
            graphics2D.drawImage(this.backgroundImage, (int)double1.getX(), (int)double1.getY(), (int)double1.getWidth(), (int)double1.getHeight(), null);
            graphics2D.setComposite(composite);
        }
        if (this.isBorderVisible()) {
            final Paint borderPaint = this.getBorderPaint();
            final Stroke borderStroke = this.getBorderStroke();
            if (borderPaint != null && borderStroke != null) {
                final Rectangle2D.Double double2 = new Rectangle2D.Double(rectangle2D.getX(), rectangle2D.getY(), rectangle2D.getWidth() - 1.0, rectangle2D.getHeight() - 1.0);
                graphics2D.setPaint(borderPaint);
                graphics2D.setStroke(borderStroke);
                graphics2D.draw(double2);
            }
        }
        final Rectangle2D.Double double3 = new Rectangle2D.Double();
        double3.setRect(rectangle2D);
        this.padding.trim(double3);
        EntityCollection entityCollection = null;
        if (chartRenderingInfo != null) {
            entityCollection = chartRenderingInfo.getEntityCollection();
        }
        if (this.title != null) {
            final EntityCollection drawTitle = this.drawTitle(this.title, graphics2D, double3, entityCollection != null);
            if (drawTitle != null) {
                entityCollection.addAll(drawTitle);
            }
        }
        final Iterator<Title> iterator = (Iterator<Title>)this.subtitles.iterator();
        while (iterator.hasNext()) {
            final EntityCollection drawTitle2 = this.drawTitle(iterator.next(), graphics2D, double3, entityCollection != null);
            if (drawTitle2 != null) {
                entityCollection.addAll(drawTitle2);
            }
        }
        final Rectangle2D.Double double4 = double3;
        PlotRenderingInfo plotInfo = null;
        if (chartRenderingInfo != null) {
            plotInfo = chartRenderingInfo.getPlotInfo();
        }
        this.plot.draw(graphics2D, double4, point2D, null, plotInfo);
        graphics2D.setClip(clip);
        this.notifyListeners(new ChartProgressEvent(this, this, 2, 100));
    }
    
    private Rectangle2D createAlignedRectangle2D(final Size2D size2D, final Rectangle2D rectangle2D, final HorizontalAlignment horizontalAlignment, final VerticalAlignment verticalAlignment) {
        double x = Double.NaN;
        double y = Double.NaN;
        if (horizontalAlignment == HorizontalAlignment.LEFT) {
            x = rectangle2D.getX();
        }
        else if (horizontalAlignment == HorizontalAlignment.CENTER) {
            x = rectangle2D.getCenterX() - size2D.width / 2.0;
        }
        else if (horizontalAlignment == HorizontalAlignment.RIGHT) {
            x = rectangle2D.getMaxX() - size2D.width;
        }
        if (verticalAlignment == VerticalAlignment.TOP) {
            y = rectangle2D.getY();
        }
        else if (verticalAlignment == VerticalAlignment.CENTER) {
            y = rectangle2D.getCenterY() - size2D.height / 2.0;
        }
        else if (verticalAlignment == VerticalAlignment.BOTTOM) {
            y = rectangle2D.getMaxY() - size2D.height;
        }
        return new Rectangle2D.Double(x, y, size2D.width, size2D.height);
    }
    
    protected EntityCollection drawTitle(final Title title, final Graphics2D graphics2D, final Rectangle2D rectangle2D, final boolean generateEntities) {
        if (title == null) {
            throw new IllegalArgumentException("Null 't' argument.");
        }
        if (rectangle2D == null) {
            throw new IllegalArgumentException("Null 'area' argument.");
        }
        final Rectangle2D.Double double1 = new Rectangle2D.Double();
        final RectangleEdge position = title.getPosition();
        final double width = rectangle2D.getWidth();
        if (width <= 0.0) {
            return null;
        }
        final double height = rectangle2D.getHeight();
        if (height <= 0.0) {
            return null;
        }
        final RectangleConstraint rectangleConstraint = new RectangleConstraint(width, new Range(0.0, width), LengthConstraintType.RANGE, height, new Range(0.0, height), LengthConstraintType.RANGE);
        final BlockParams blockParams = new BlockParams();
        blockParams.setGenerateEntities(generateEntities);
        Object o;
        if (position == RectangleEdge.TOP) {
            final Size2D arrange = title.arrange(graphics2D, rectangleConstraint);
            o = title.draw(graphics2D, this.createAlignedRectangle2D(arrange, rectangle2D, title.getHorizontalAlignment(), VerticalAlignment.TOP), blockParams);
            rectangle2D.setRect(rectangle2D.getX(), Math.min(rectangle2D.getY() + arrange.height, rectangle2D.getMaxY()), rectangle2D.getWidth(), Math.max(rectangle2D.getHeight() - arrange.height, 0.0));
        }
        else if (position == RectangleEdge.BOTTOM) {
            final Size2D arrange2 = title.arrange(graphics2D, rectangleConstraint);
            o = title.draw(graphics2D, this.createAlignedRectangle2D(arrange2, rectangle2D, title.getHorizontalAlignment(), VerticalAlignment.BOTTOM), blockParams);
            rectangle2D.setRect(rectangle2D.getX(), rectangle2D.getY(), rectangle2D.getWidth(), rectangle2D.getHeight() - arrange2.height);
        }
        else if (position == RectangleEdge.RIGHT) {
            final Size2D arrange3 = title.arrange(graphics2D, rectangleConstraint);
            o = title.draw(graphics2D, this.createAlignedRectangle2D(arrange3, rectangle2D, HorizontalAlignment.RIGHT, title.getVerticalAlignment()), blockParams);
            rectangle2D.setRect(rectangle2D.getX(), rectangle2D.getY(), rectangle2D.getWidth() - arrange3.width, rectangle2D.getHeight());
        }
        else {
            if (position != RectangleEdge.LEFT) {
                throw new RuntimeException("Unrecognised title position.");
            }
            final Size2D arrange4 = title.arrange(graphics2D, rectangleConstraint);
            o = title.draw(graphics2D, this.createAlignedRectangle2D(arrange4, rectangle2D, HorizontalAlignment.LEFT, title.getVerticalAlignment()), blockParams);
            rectangle2D.setRect(rectangle2D.getX() + arrange4.width, rectangle2D.getY(), rectangle2D.getWidth() - arrange4.width, rectangle2D.getHeight());
        }
        EntityCollection entityCollection = null;
        if (o instanceof EntityBlockResult) {
            entityCollection = ((EntityBlockResult)o).getEntityCollection();
        }
        return entityCollection;
    }
    
    public BufferedImage createBufferedImage(final int n, final int n2) {
        return this.createBufferedImage(n, n2, null);
    }
    
    public BufferedImage createBufferedImage(final int n, final int n2, final ChartRenderingInfo chartRenderingInfo) {
        return this.createBufferedImage(n, n2, 1, chartRenderingInfo);
    }
    
    public BufferedImage createBufferedImage(final int n, final int n2, final int n3, final ChartRenderingInfo chartRenderingInfo) {
        final BufferedImage bufferedImage = new BufferedImage(n, n2, n3);
        final Graphics2D graphics = bufferedImage.createGraphics();
        this.draw(graphics, new Rectangle2D.Double(0.0, 0.0, n, n2), null, chartRenderingInfo);
        graphics.dispose();
        return bufferedImage;
    }
    
    public BufferedImage createBufferedImage(final int n, final int n2, final double n3, final double n4, final ChartRenderingInfo chartRenderingInfo) {
        final BufferedImage bufferedImage = new BufferedImage(n, n2, 1);
        final Graphics2D graphics = bufferedImage.createGraphics();
        graphics.transform(AffineTransform.getScaleInstance(n / n3, n2 / n4));
        this.draw(graphics, new Rectangle2D.Double(0.0, 0.0, n3, n4), null, chartRenderingInfo);
        graphics.dispose();
        return bufferedImage;
    }
    
    public void handleClick(final int n, final int n2, final ChartRenderingInfo chartRenderingInfo) {
        this.plot.handleClick(n, n2, chartRenderingInfo.getPlotInfo());
    }
    
    public void addChangeListener(final ChartChangeListener chartChangeListener) {
        if (chartChangeListener == null) {
            throw new IllegalArgumentException("Null 'listener' argument.");
        }
        this.changeListeners.add((JFreeChart.class$org$jfree$chart$event$ChartChangeListener == null) ? (JFreeChart.class$org$jfree$chart$event$ChartChangeListener = class$("org.jfree.chart.event.ChartChangeListener")) : JFreeChart.class$org$jfree$chart$event$ChartChangeListener, chartChangeListener);
    }
    
    public void removeChangeListener(final ChartChangeListener chartChangeListener) {
        if (chartChangeListener == null) {
            throw new IllegalArgumentException("Null 'listener' argument.");
        }
        this.changeListeners.remove((JFreeChart.class$org$jfree$chart$event$ChartChangeListener == null) ? (JFreeChart.class$org$jfree$chart$event$ChartChangeListener = class$("org.jfree.chart.event.ChartChangeListener")) : JFreeChart.class$org$jfree$chart$event$ChartChangeListener, chartChangeListener);
    }
    
    public void fireChartChanged() {
        this.notifyListeners(new ChartChangeEvent(this));
    }
    
    protected void notifyListeners(final ChartChangeEvent chartChangeEvent) {
        if (this.notify) {
            final Object[] listenerList = this.changeListeners.getListenerList();
            for (int i = listenerList.length - 2; i >= 0; i -= 2) {
                if (listenerList[i] == ((JFreeChart.class$org$jfree$chart$event$ChartChangeListener == null) ? (JFreeChart.class$org$jfree$chart$event$ChartChangeListener = class$("org.jfree.chart.event.ChartChangeListener")) : JFreeChart.class$org$jfree$chart$event$ChartChangeListener)) {
                    ((ChartChangeListener)listenerList[i + 1]).chartChanged(chartChangeEvent);
                }
            }
        }
    }
    
    public void addProgressListener(final ChartProgressListener chartProgressListener) {
        this.progressListeners.add((JFreeChart.class$org$jfree$chart$event$ChartProgressListener == null) ? (JFreeChart.class$org$jfree$chart$event$ChartProgressListener = class$("org.jfree.chart.event.ChartProgressListener")) : JFreeChart.class$org$jfree$chart$event$ChartProgressListener, chartProgressListener);
    }
    
    public void removeProgressListener(final ChartProgressListener chartProgressListener) {
        this.progressListeners.remove((JFreeChart.class$org$jfree$chart$event$ChartProgressListener == null) ? (JFreeChart.class$org$jfree$chart$event$ChartProgressListener = class$("org.jfree.chart.event.ChartProgressListener")) : JFreeChart.class$org$jfree$chart$event$ChartProgressListener, chartProgressListener);
    }
    
    protected void notifyListeners(final ChartProgressEvent chartProgressEvent) {
        final Object[] listenerList = this.progressListeners.getListenerList();
        for (int i = listenerList.length - 2; i >= 0; i -= 2) {
            if (listenerList[i] == ((JFreeChart.class$org$jfree$chart$event$ChartProgressListener == null) ? (JFreeChart.class$org$jfree$chart$event$ChartProgressListener = class$("org.jfree.chart.event.ChartProgressListener")) : JFreeChart.class$org$jfree$chart$event$ChartProgressListener)) {
                ((ChartProgressListener)listenerList[i + 1]).chartProgress(chartProgressEvent);
            }
        }
    }
    
    public void titleChanged(final TitleChangeEvent titleChangeEvent) {
        titleChangeEvent.setChart(this);
        this.notifyListeners(titleChangeEvent);
    }
    
    public void plotChanged(final PlotChangeEvent plotChangeEvent) {
        plotChangeEvent.setChart(this);
        this.notifyListeners(plotChangeEvent);
    }
    
    public boolean equals(final Object o) {
        if (o == this) {
            return true;
        }
        if (!(o instanceof JFreeChart)) {
            return false;
        }
        final JFreeChart freeChart = (JFreeChart)o;
        return this.renderingHints.equals(freeChart.renderingHints) && this.borderVisible == freeChart.borderVisible && ObjectUtilities.equal(this.borderStroke, freeChart.borderStroke) && PaintUtilities.equal(this.borderPaint, freeChart.borderPaint) && this.padding.equals(freeChart.padding) && ObjectUtilities.equal(this.title, freeChart.title) && ObjectUtilities.equal(this.subtitles, freeChart.subtitles) && ObjectUtilities.equal(this.plot, freeChart.plot) && PaintUtilities.equal(this.backgroundPaint, freeChart.backgroundPaint) && ObjectUtilities.equal(this.backgroundImage, freeChart.backgroundImage) && this.backgroundImageAlignment == freeChart.backgroundImageAlignment && this.backgroundImageAlpha == freeChart.backgroundImageAlpha && this.notify == freeChart.notify;
    }
    
    private void writeObject(final ObjectOutputStream objectOutputStream) {
        objectOutputStream.defaultWriteObject();
        SerialUtilities.writeStroke(this.borderStroke, objectOutputStream);
        SerialUtilities.writePaint(this.borderPaint, objectOutputStream);
        SerialUtilities.writePaint(this.backgroundPaint, objectOutputStream);
    }
    
    private void readObject(final ObjectInputStream objectInputStream) {
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
        for (int i = 0; i < this.getSubtitleCount(); ++i) {
            this.getSubtitle(i).addChangeListener(this);
        }
        this.plot.addChangeListener(this);
    }
    
    public static void main(final String[] array) {
        System.out.println(JFreeChart.INFO.toString());
    }
    
    public Object clone() {
        final JFreeChart freeChart = (JFreeChart)super.clone();
        freeChart.renderingHints = (RenderingHints)this.renderingHints.clone();
        if (this.title != null) {
            (freeChart.title = (TextTitle)this.title.clone()).addChangeListener(freeChart);
        }
        freeChart.subtitles = new ArrayList();
        for (int i = 0; i < this.getSubtitleCount(); ++i) {
            final Title title = (Title)this.getSubtitle(i).clone();
            freeChart.subtitles.add(title);
            title.addChangeListener(freeChart);
        }
        if (this.plot != null) {
            (freeChart.plot = (Plot)this.plot.clone()).addChangeListener(freeChart);
        }
        freeChart.progressListeners = new EventListenerList();
        freeChart.changeListeners = new EventListenerList();
        return freeChart;
    }
    
    static Class class$(final String s) {
        try {
            return Class.forName(s);
        }
        catch (ClassNotFoundException ex) {
            throw new NoClassDefFoundError(ex.getMessage());
        }
    }
    
    static {
        INFO = new JFreeChartInfo();
        DEFAULT_TITLE_FONT = new Font("SansSerif", 1, 18);
        DEFAULT_BACKGROUND_PAINT = UIManager.getColor("Panel.background");
        DEFAULT_BACKGROUND_IMAGE = null;
    }
}
