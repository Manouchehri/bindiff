/*
 * Decompiled with CFR 0_115.
 */
package org.jfree.chart.block;

import java.awt.Graphics2D;
import java.awt.geom.Rectangle2D;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import org.jfree.chart.block.AbstractBlock;
import org.jfree.chart.block.Arrangement;
import org.jfree.chart.block.Block;
import org.jfree.chart.block.BlockResult;
import org.jfree.chart.block.BorderArrangement;
import org.jfree.chart.block.EntityBlockParams;
import org.jfree.chart.block.EntityBlockResult;
import org.jfree.chart.block.RectangleConstraint;
import org.jfree.chart.entity.EntityCollection;
import org.jfree.chart.entity.StandardEntityCollection;
import org.jfree.ui.Size2D;
import org.jfree.util.PublicCloneable;

public class BlockContainer
extends AbstractBlock
implements Serializable,
Cloneable,
Block,
PublicCloneable {
    private static final long serialVersionUID = 8199508075695195293L;
    private List blocks;
    private Arrangement arrangement;

    public BlockContainer() {
        this(new BorderArrangement());
    }

    public BlockContainer(Arrangement arrangement) {
        if (arrangement == null) {
            throw new IllegalArgumentException("Null 'arrangement' argument.");
        }
        this.arrangement = arrangement;
        this.blocks = new ArrayList();
    }

    public Arrangement getArrangement() {
        return this.arrangement;
    }

    public void setArrangement(Arrangement arrangement) {
        if (arrangement == null) {
            throw new IllegalArgumentException("Null 'arrangement' argument.");
        }
        this.arrangement = arrangement;
    }

    public boolean isEmpty() {
        return this.blocks.isEmpty();
    }

    public List getBlocks() {
        return Collections.unmodifiableList(this.blocks);
    }

    public void add(Block block) {
        this.add(block, null);
    }

    public void add(Block block, Object object) {
        this.blocks.add(block);
        this.arrangement.add(block, object);
    }

    public void clear() {
        this.blocks.clear();
        this.arrangement.clear();
    }

    @Override
    public Size2D arrange(Graphics2D graphics2D, RectangleConstraint rectangleConstraint) {
        return this.arrangement.arrange(this, graphics2D, rectangleConstraint);
    }

    @Override
    public void draw(Graphics2D graphics2D, Rectangle2D rectangle2D) {
        this.draw(graphics2D, rectangle2D, null);
    }

    @Override
    public Object draw(Graphics2D graphics2D, Rectangle2D rectangle2D, Object object) {
        EntityBlockParams entityBlockParams = null;
        StandardEntityCollection standardEntityCollection = null;
        if (object instanceof EntityBlockParams && (entityBlockParams = (EntityBlockParams)object).getGenerateEntities()) {
            standardEntityCollection = new StandardEntityCollection();
        }
        Rectangle2D rectangle2D2 = (Rectangle2D)rectangle2D.clone();
        rectangle2D2 = this.trimMargin(rectangle2D2);
        this.drawBorder(graphics2D, rectangle2D2);
        rectangle2D2 = this.trimBorder(rectangle2D2);
        rectangle2D2 = this.trimPadding(rectangle2D2);
        Iterator iterator = this.blocks.iterator();
        do {
            Object object2;
            if (!iterator.hasNext()) {
                object2 = null;
                if (standardEntityCollection == null) return object2;
                object2 = new BlockResult();
                object2.setEntityCollection(standardEntityCollection);
                return object2;
            }
            object2 = (Block)iterator.next();
            Rectangle2D rectangle2D3 = object2.getBounds();
            Rectangle2D.Double double_ = new Rectangle2D.Double(rectangle2D3.getX() + rectangle2D.getX(), rectangle2D3.getY() + rectangle2D.getY(), rectangle2D3.getWidth(), rectangle2D3.getHeight());
            Object object3 = object2.draw(graphics2D, double_, object);
            if (standardEntityCollection == null || !(object3 instanceof EntityBlockResult)) continue;
            EntityBlockResult entityBlockResult = (EntityBlockResult)object3;
            EntityCollection entityCollection = entityBlockResult.getEntityCollection();
            standardEntityCollection.addAll(entityCollection);
        } while (true);
    }

    @Override
    public boolean equals(Object object) {
        if (object == this) {
            return true;
        }
        if (!(object instanceof BlockContainer)) {
            return false;
        }
        if (!super.equals(object)) {
            return false;
        }
        BlockContainer blockContainer = (BlockContainer)object;
        if (!this.arrangement.equals(blockContainer.arrangement)) {
            return false;
        }
        if (this.blocks.equals(blockContainer.blocks)) return true;
        return false;
    }

    @Override
    public Object clone() {
        return (BlockContainer)super.clone();
    }
}

