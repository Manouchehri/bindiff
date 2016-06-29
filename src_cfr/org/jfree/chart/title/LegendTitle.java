/*
 * Decompiled with CFR 0_115.
 */
package org.jfree.chart.title;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics2D;
import java.awt.Paint;
import java.awt.Shape;
import java.awt.Stroke;
import java.awt.geom.Rectangle2D;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import org.jfree.chart.LegendItem;
import org.jfree.chart.LegendItemCollection;
import org.jfree.chart.LegendItemSource;
import org.jfree.chart.block.Arrangement;
import org.jfree.chart.block.Block;
import org.jfree.chart.block.BlockContainer;
import org.jfree.chart.block.BlockFrame;
import org.jfree.chart.block.BorderArrangement;
import org.jfree.chart.block.CenterArrangement;
import org.jfree.chart.block.ColumnArrangement;
import org.jfree.chart.block.FlowArrangement;
import org.jfree.chart.block.LabelBlock;
import org.jfree.chart.block.RectangleConstraint;
import org.jfree.chart.event.TitleChangeEvent;
import org.jfree.chart.title.LegendGraphic;
import org.jfree.chart.title.LegendItemBlockContainer;
import org.jfree.chart.title.Title;
import org.jfree.io.SerialUtilities;
import org.jfree.ui.GradientPaintTransformer;
import org.jfree.ui.RectangleAnchor;
import org.jfree.ui.RectangleEdge;
import org.jfree.ui.RectangleInsets;
import org.jfree.ui.Size2D;
import org.jfree.util.PaintUtilities;
import org.jfree.util.PublicCloneable;

public class LegendTitle
extends Title
implements Serializable,
Cloneable,
PublicCloneable {
    private static final long serialVersionUID = 2644010518533854633L;
    public static final Font DEFAULT_ITEM_FONT = new Font("SansSerif", 0, 12);
    public static final Paint DEFAULT_ITEM_PAINT = Color.black;
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

    public LegendTitle(LegendItemSource legendItemSource) {
        this(legendItemSource, new FlowArrangement(), new ColumnArrangement());
    }

    public LegendTitle(LegendItemSource legendItemSource, Arrangement arrangement, Arrangement arrangement2) {
        this.sources = new LegendItemSource[]{legendItemSource};
        this.items = new BlockContainer(arrangement);
        this.hLayout = arrangement;
        this.vLayout = arrangement2;
        this.backgroundPaint = null;
        this.legendItemGraphicEdge = RectangleEdge.LEFT;
        this.legendItemGraphicAnchor = RectangleAnchor.CENTER;
        this.legendItemGraphicLocation = RectangleAnchor.CENTER;
        this.legendItemGraphicPadding = new RectangleInsets(2.0, 2.0, 2.0, 2.0);
        this.itemFont = DEFAULT_ITEM_FONT;
        this.itemPaint = DEFAULT_ITEM_PAINT;
        this.itemLabelPadding = new RectangleInsets(2.0, 2.0, 2.0, 2.0);
    }

    public LegendItemSource[] getSources() {
        return this.sources;
    }

    public void setSources(LegendItemSource[] arrlegendItemSource) {
        if (arrlegendItemSource == null) {
            throw new IllegalArgumentException("Null 'sources' argument.");
        }
        this.sources = arrlegendItemSource;
        this.notifyListeners(new TitleChangeEvent(this));
    }

    public Paint getBackgroundPaint() {
        return this.backgroundPaint;
    }

    public void setBackgroundPaint(Paint paint) {
        this.backgroundPaint = paint;
        this.notifyListeners(new TitleChangeEvent(this));
    }

    public RectangleEdge getLegendItemGraphicEdge() {
        return this.legendItemGraphicEdge;
    }

    public void setLegendItemGraphicEdge(RectangleEdge rectangleEdge) {
        if (rectangleEdge == null) {
            throw new IllegalArgumentException("Null 'edge' argument.");
        }
        this.legendItemGraphicEdge = rectangleEdge;
        this.notifyListeners(new TitleChangeEvent(this));
    }

    public RectangleAnchor getLegendItemGraphicAnchor() {
        return this.legendItemGraphicAnchor;
    }

    public void setLegendItemGraphicAnchor(RectangleAnchor rectangleAnchor) {
        if (rectangleAnchor == null) {
            throw new IllegalArgumentException("Null 'anchor' point.");
        }
        this.legendItemGraphicAnchor = rectangleAnchor;
    }

    public RectangleAnchor getLegendItemGraphicLocation() {
        return this.legendItemGraphicLocation;
    }

    public void setLegendItemGraphicLocation(RectangleAnchor rectangleAnchor) {
        this.legendItemGraphicLocation = rectangleAnchor;
    }

    public RectangleInsets getLegendItemGraphicPadding() {
        return this.legendItemGraphicPadding;
    }

    public void setLegendItemGraphicPadding(RectangleInsets rectangleInsets) {
        if (rectangleInsets == null) {
            throw new IllegalArgumentException("Null 'padding' argument.");
        }
        this.legendItemGraphicPadding = rectangleInsets;
        this.notifyListeners(new TitleChangeEvent(this));
    }

    public Font getItemFont() {
        return this.itemFont;
    }

    public void setItemFont(Font font) {
        if (font == null) {
            throw new IllegalArgumentException("Null 'font' argument.");
        }
        this.itemFont = font;
        this.notifyListeners(new TitleChangeEvent(this));
    }

    public Paint getItemPaint() {
        return this.itemPaint;
    }

    public void setItemPaint(Paint paint) {
        if (paint == null) {
            throw new IllegalArgumentException("Null 'paint' argument.");
        }
        this.itemPaint = paint;
        this.notifyListeners(new TitleChangeEvent(this));
    }

    public RectangleInsets getItemLabelPadding() {
        return this.itemLabelPadding;
    }

    public void setItemLabelPadding(RectangleInsets rectangleInsets) {
        if (rectangleInsets == null) {
            throw new IllegalArgumentException("Null 'padding' argument.");
        }
        this.itemLabelPadding = rectangleInsets;
        this.notifyListeners(new TitleChangeEvent(this));
    }

    protected void fetchLegendItems() {
        this.items.clear();
        RectangleEdge rectangleEdge = this.getPosition();
        if (RectangleEdge.isTopOrBottom(rectangleEdge)) {
            this.items.setArrangement(this.hLayout);
        } else {
            this.items.setArrangement(this.vLayout);
        }
        int n2 = 0;
        while (n2 < this.sources.length) {
            LegendItemCollection legendItemCollection = this.sources[n2].getLegendItems();
            if (legendItemCollection != null) {
                for (int i2 = 0; i2 < legendItemCollection.getItemCount(); ++i2) {
                    LegendItem legendItem = legendItemCollection.get(i2);
                    Block block = this.createLegendItemBlock(legendItem);
                    this.items.add(block);
                }
            }
            ++n2;
        }
    }

    protected Block createLegendItemBlock(LegendItem legendItem) {
        BlockContainer blockContainer = null;
        LegendGraphic legendGraphic = new LegendGraphic(legendItem.getShape(), legendItem.getFillPaint());
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
        LegendItemBlockContainer legendItemBlockContainer = new LegendItemBlockContainer(new BorderArrangement(), legendItem.getDatasetIndex(), legendItem.getSeriesIndex());
        legendGraphic.setShapeAnchor(this.getLegendItemGraphicAnchor());
        legendGraphic.setShapeLocation(this.getLegendItemGraphicLocation());
        legendItemBlockContainer.add(legendGraphic, this.legendItemGraphicEdge);
        LabelBlock labelBlock = new LabelBlock(legendItem.getLabel(), this.itemFont, this.itemPaint);
        labelBlock.setPadding(this.itemLabelPadding);
        legendItemBlockContainer.add(labelBlock);
        legendItemBlockContainer.setToolTipText(legendItem.getToolTipText());
        legendItemBlockContainer.setURLText(legendItem.getURLText());
        blockContainer = new BlockContainer(new CenterArrangement());
        blockContainer.add(legendItemBlockContainer);
        return blockContainer;
    }

    public BlockContainer getItemContainer() {
        return this.items;
    }

    @Override
    public Size2D arrange(Graphics2D graphics2D, RectangleConstraint rectangleConstraint) {
        Size2D size2D = new Size2D();
        this.fetchLegendItems();
        if (this.items.isEmpty()) {
            return size2D;
        }
        BlockContainer blockContainer = this.wrapper;
        if (blockContainer == null) {
            blockContainer = this.items;
        }
        RectangleConstraint rectangleConstraint2 = this.toContentConstraint(rectangleConstraint);
        Size2D size2D2 = blockContainer.arrange(graphics2D, rectangleConstraint2);
        size2D.height = this.calculateTotalHeight(size2D2.height);
        size2D.width = this.calculateTotalWidth(size2D2.width);
        return size2D;
    }

    @Override
    public void draw(Graphics2D graphics2D, Rectangle2D rectangle2D) {
        this.draw(graphics2D, rectangle2D, null);
    }

    @Override
    public Object draw(Graphics2D graphics2D, Rectangle2D rectangle2D, Object object) {
        Rectangle2D rectangle2D2 = (Rectangle2D)rectangle2D.clone();
        rectangle2D2 = this.trimMargin(rectangle2D2);
        if (this.backgroundPaint != null) {
            graphics2D.setPaint(this.backgroundPaint);
            graphics2D.fill(rectangle2D2);
        }
        BlockFrame blockFrame = this.getFrame();
        blockFrame.draw(graphics2D, rectangle2D2);
        blockFrame.getInsets().trim(rectangle2D2);
        BlockContainer blockContainer = this.wrapper;
        if (blockContainer == null) {
            blockContainer = this.items;
        }
        rectangle2D2 = this.trimPadding(rectangle2D2);
        return blockContainer.draw(graphics2D, rectangle2D2, object);
    }

    public void setWrapper(BlockContainer blockContainer) {
        this.wrapper = blockContainer;
    }

    @Override
    public boolean equals(Object object) {
        if (object == this) {
            return true;
        }
        if (!(object instanceof LegendTitle)) {
            return false;
        }
        if (!super.equals(object)) {
            return false;
        }
        LegendTitle legendTitle = (LegendTitle)object;
        if (!PaintUtilities.equal(this.backgroundPaint, legendTitle.backgroundPaint)) {
            return false;
        }
        if (this.legendItemGraphicEdge != legendTitle.legendItemGraphicEdge) {
            return false;
        }
        if (this.legendItemGraphicAnchor != legendTitle.legendItemGraphicAnchor) {
            return false;
        }
        if (this.legendItemGraphicLocation != legendTitle.legendItemGraphicLocation) {
            return false;
        }
        if (!this.itemFont.equals(legendTitle.itemFont)) {
            return false;
        }
        if (!this.itemPaint.equals(legendTitle.itemPaint)) {
            return false;
        }
        if (!this.hLayout.equals(legendTitle.hLayout)) {
            return false;
        }
        if (this.vLayout.equals(legendTitle.vLayout)) return true;
        return false;
    }

    private void writeObject(ObjectOutputStream objectOutputStream) {
        objectOutputStream.defaultWriteObject();
        SerialUtilities.writePaint(this.backgroundPaint, objectOutputStream);
        SerialUtilities.writePaint(this.itemPaint, objectOutputStream);
    }

    private void readObject(ObjectInputStream objectInputStream) {
        objectInputStream.defaultReadObject();
        this.backgroundPaint = SerialUtilities.readPaint(objectInputStream);
        this.itemPaint = SerialUtilities.readPaint(objectInputStream);
    }
}

