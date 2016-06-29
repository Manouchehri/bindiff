package org.jfree.chart.title;

import org.jfree.chart.event.*;
import org.jfree.chart.*;
import org.jfree.ui.*;
import java.awt.geom.*;
import org.jfree.chart.block.*;
import org.jfree.util.*;
import org.jfree.io.*;
import java.io.*;
import java.awt.*;

public class LegendTitle extends Title implements Serializable, Cloneable, PublicCloneable
{
    private static final long serialVersionUID = 2644010518533854633L;
    public static final Font DEFAULT_ITEM_FONT;
    public static final Paint DEFAULT_ITEM_PAINT;
    private LegendItemSource[] sources;
    private transient Paint backgroundPaint;
    private RectangleEdge legendItemGraphicEdge;
    private RectangleAnchor legendItemGraphicAnchor;
    private RectangleAnchor legendItemGraphicLocation;
    private RectangleInsets legendItemGraphicPadding;
    private Font itemFont;
    private transient Paint itemPaint;
    private RectangleInsets itemLabelPadding;
    private BlockContainer items;
    private Arrangement hLayout;
    private Arrangement vLayout;
    private BlockContainer wrapper;
    
    public LegendTitle(final LegendItemSource legendItemSource) {
        this(legendItemSource, new FlowArrangement(), new ColumnArrangement());
    }
    
    public LegendTitle(final LegendItemSource legendItemSource, final Arrangement hLayout, final Arrangement vLayout) {
        this.sources = new LegendItemSource[] { legendItemSource };
        this.items = new BlockContainer(hLayout);
        this.hLayout = hLayout;
        this.vLayout = vLayout;
        this.backgroundPaint = null;
        this.legendItemGraphicEdge = RectangleEdge.LEFT;
        this.legendItemGraphicAnchor = RectangleAnchor.CENTER;
        this.legendItemGraphicLocation = RectangleAnchor.CENTER;
        this.legendItemGraphicPadding = new RectangleInsets(2.0, 2.0, 2.0, 2.0);
        this.itemFont = LegendTitle.DEFAULT_ITEM_FONT;
        this.itemPaint = LegendTitle.DEFAULT_ITEM_PAINT;
        this.itemLabelPadding = new RectangleInsets(2.0, 2.0, 2.0, 2.0);
    }
    
    public LegendItemSource[] getSources() {
        return this.sources;
    }
    
    public void setSources(final LegendItemSource[] sources) {
        if (sources == null) {
            throw new IllegalArgumentException("Null 'sources' argument.");
        }
        this.sources = sources;
        this.notifyListeners(new TitleChangeEvent(this));
    }
    
    public Paint getBackgroundPaint() {
        return this.backgroundPaint;
    }
    
    public void setBackgroundPaint(final Paint backgroundPaint) {
        this.backgroundPaint = backgroundPaint;
        this.notifyListeners(new TitleChangeEvent(this));
    }
    
    public RectangleEdge getLegendItemGraphicEdge() {
        return this.legendItemGraphicEdge;
    }
    
    public void setLegendItemGraphicEdge(final RectangleEdge legendItemGraphicEdge) {
        if (legendItemGraphicEdge == null) {
            throw new IllegalArgumentException("Null 'edge' argument.");
        }
        this.legendItemGraphicEdge = legendItemGraphicEdge;
        this.notifyListeners(new TitleChangeEvent(this));
    }
    
    public RectangleAnchor getLegendItemGraphicAnchor() {
        return this.legendItemGraphicAnchor;
    }
    
    public void setLegendItemGraphicAnchor(final RectangleAnchor legendItemGraphicAnchor) {
        if (legendItemGraphicAnchor == null) {
            throw new IllegalArgumentException("Null 'anchor' point.");
        }
        this.legendItemGraphicAnchor = legendItemGraphicAnchor;
    }
    
    public RectangleAnchor getLegendItemGraphicLocation() {
        return this.legendItemGraphicLocation;
    }
    
    public void setLegendItemGraphicLocation(final RectangleAnchor legendItemGraphicLocation) {
        this.legendItemGraphicLocation = legendItemGraphicLocation;
    }
    
    public RectangleInsets getLegendItemGraphicPadding() {
        return this.legendItemGraphicPadding;
    }
    
    public void setLegendItemGraphicPadding(final RectangleInsets legendItemGraphicPadding) {
        if (legendItemGraphicPadding == null) {
            throw new IllegalArgumentException("Null 'padding' argument.");
        }
        this.legendItemGraphicPadding = legendItemGraphicPadding;
        this.notifyListeners(new TitleChangeEvent(this));
    }
    
    public Font getItemFont() {
        return this.itemFont;
    }
    
    public void setItemFont(final Font itemFont) {
        if (itemFont == null) {
            throw new IllegalArgumentException("Null 'font' argument.");
        }
        this.itemFont = itemFont;
        this.notifyListeners(new TitleChangeEvent(this));
    }
    
    public Paint getItemPaint() {
        return this.itemPaint;
    }
    
    public void setItemPaint(final Paint itemPaint) {
        if (itemPaint == null) {
            throw new IllegalArgumentException("Null 'paint' argument.");
        }
        this.itemPaint = itemPaint;
        this.notifyListeners(new TitleChangeEvent(this));
    }
    
    public RectangleInsets getItemLabelPadding() {
        return this.itemLabelPadding;
    }
    
    public void setItemLabelPadding(final RectangleInsets itemLabelPadding) {
        if (itemLabelPadding == null) {
            throw new IllegalArgumentException("Null 'padding' argument.");
        }
        this.itemLabelPadding = itemLabelPadding;
        this.notifyListeners(new TitleChangeEvent(this));
    }
    
    protected void fetchLegendItems() {
        this.items.clear();
        if (RectangleEdge.isTopOrBottom(this.getPosition())) {
            this.items.setArrangement(this.hLayout);
        }
        else {
            this.items.setArrangement(this.vLayout);
        }
        for (int i = 0; i < this.sources.length; ++i) {
            final LegendItemCollection legendItems = this.sources[i].getLegendItems();
            if (legendItems != null) {
                for (int j = 0; j < legendItems.getItemCount(); ++j) {
                    this.items.add(this.createLegendItemBlock(legendItems.get(j)));
                }
            }
        }
    }
    
    protected Block createLegendItemBlock(final LegendItem legendItem) {
        final LegendGraphic legendGraphic = new LegendGraphic(legendItem.getShape(), legendItem.getFillPaint());
        legendGraphic.setFillPaintTransformer(legendItem.getFillPaintTransformer());
        legendGraphic.setShapeFilled(legendItem.isShapeFilled());
        legendGraphic.setLine(legendItem.getLine());
        legendGraphic.setLineStroke(legendItem.getLineStroke());
        legendGraphic.setLinePaint(legendItem.getLinePaint());
        legendGraphic.setLineVisible(legendItem.isLineVisible());
        legendGraphic.setShapeVisible(legendItem.isShapeVisible());
        legendGraphic.setShapeOutlineVisible(legendItem.isShapeOutlineVisible());
        legendGraphic.setOutlinePaint(legendItem.getOutlinePaint());
        legendGraphic.setOutlineStroke(legendItem.getOutlineStroke());
        legendGraphic.setPadding(this.legendItemGraphicPadding);
        final LegendItemBlockContainer legendItemBlockContainer = new LegendItemBlockContainer(new BorderArrangement(), legendItem.getDatasetIndex(), legendItem.getSeriesIndex());
        legendGraphic.setShapeAnchor(this.getLegendItemGraphicAnchor());
        legendGraphic.setShapeLocation(this.getLegendItemGraphicLocation());
        legendItemBlockContainer.add(legendGraphic, this.legendItemGraphicEdge);
        final LabelBlock labelBlock = new LabelBlock(legendItem.getLabel(), this.itemFont, this.itemPaint);
        labelBlock.setPadding(this.itemLabelPadding);
        legendItemBlockContainer.add(labelBlock);
        legendItemBlockContainer.setToolTipText(legendItem.getToolTipText());
        legendItemBlockContainer.setURLText(legendItem.getURLText());
        final BlockContainer blockContainer = new BlockContainer(new CenterArrangement());
        blockContainer.add(legendItemBlockContainer);
        return blockContainer;
    }
    
    public BlockContainer getItemContainer() {
        return this.items;
    }
    
    public Size2D arrange(final Graphics2D graphics2D, final RectangleConstraint rectangleConstraint) {
        final Size2D size2D = new Size2D();
        this.fetchLegendItems();
        if (this.items.isEmpty()) {
            return size2D;
        }
        BlockContainer blockContainer = this.wrapper;
        if (blockContainer == null) {
            blockContainer = this.items;
        }
        final Size2D arrange = blockContainer.arrange(graphics2D, this.toContentConstraint(rectangleConstraint));
        size2D.height = this.calculateTotalHeight(arrange.height);
        size2D.width = this.calculateTotalWidth(arrange.width);
        return size2D;
    }
    
    public void draw(final Graphics2D graphics2D, final Rectangle2D rectangle2D) {
        this.draw(graphics2D, rectangle2D, null);
    }
    
    public Object draw(final Graphics2D graphics2D, final Rectangle2D rectangle2D, final Object o) {
        final Rectangle2D trimMargin = this.trimMargin((Rectangle2D)rectangle2D.clone());
        if (this.backgroundPaint != null) {
            graphics2D.setPaint(this.backgroundPaint);
            graphics2D.fill(trimMargin);
        }
        final BlockFrame frame = this.getFrame();
        frame.draw(graphics2D, trimMargin);
        frame.getInsets().trim(trimMargin);
        BlockContainer blockContainer = this.wrapper;
        if (blockContainer == null) {
            blockContainer = this.items;
        }
        return blockContainer.draw(graphics2D, this.trimPadding(trimMargin), o);
    }
    
    public void setWrapper(final BlockContainer wrapper) {
        this.wrapper = wrapper;
    }
    
    public boolean equals(final Object o) {
        if (o == this) {
            return true;
        }
        if (!(o instanceof LegendTitle)) {
            return false;
        }
        if (!super.equals(o)) {
            return false;
        }
        final LegendTitle legendTitle = (LegendTitle)o;
        return PaintUtilities.equal(this.backgroundPaint, legendTitle.backgroundPaint) && this.legendItemGraphicEdge == legendTitle.legendItemGraphicEdge && this.legendItemGraphicAnchor == legendTitle.legendItemGraphicAnchor && this.legendItemGraphicLocation == legendTitle.legendItemGraphicLocation && this.itemFont.equals(legendTitle.itemFont) && this.itemPaint.equals(legendTitle.itemPaint) && this.hLayout.equals(legendTitle.hLayout) && this.vLayout.equals(legendTitle.vLayout);
    }
    
    private void writeObject(final ObjectOutputStream objectOutputStream) {
        objectOutputStream.defaultWriteObject();
        SerialUtilities.writePaint(this.backgroundPaint, objectOutputStream);
        SerialUtilities.writePaint(this.itemPaint, objectOutputStream);
    }
    
    private void readObject(final ObjectInputStream objectInputStream) {
        objectInputStream.defaultReadObject();
        this.backgroundPaint = SerialUtilities.readPaint(objectInputStream);
        this.itemPaint = SerialUtilities.readPaint(objectInputStream);
    }
    
    static {
        DEFAULT_ITEM_FONT = new Font("SansSerif", 0, 12);
        DEFAULT_ITEM_PAINT = Color.black;
    }
}
