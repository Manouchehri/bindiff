package org.jfree.chart.block;

import java.io.*;
import org.jfree.util.*;
import java.awt.*;
import org.jfree.ui.*;
import java.awt.geom.*;
import org.jfree.chart.entity.*;
import java.util.*;

public class BlockContainer extends AbstractBlock implements Serializable, Cloneable, Block, PublicCloneable
{
    private static final long serialVersionUID = 8199508075695195293L;
    private List blocks;
    private Arrangement arrangement;
    
    public BlockContainer() {
        this(new BorderArrangement());
    }
    
    public BlockContainer(final Arrangement arrangement) {
        if (arrangement == null) {
            throw new IllegalArgumentException("Null 'arrangement' argument.");
        }
        this.arrangement = arrangement;
        this.blocks = new ArrayList();
    }
    
    public Arrangement getArrangement() {
        return this.arrangement;
    }
    
    public void setArrangement(final Arrangement arrangement) {
        if (arrangement == null) {
            throw new IllegalArgumentException("Null 'arrangement' argument.");
        }
        this.arrangement = arrangement;
    }
    
    public boolean isEmpty() {
        return this.blocks.isEmpty();
    }
    
    public List getBlocks() {
        return Collections.unmodifiableList((List<?>)this.blocks);
    }
    
    public void add(final Block block) {
        this.add(block, null);
    }
    
    public void add(final Block block, final Object o) {
        this.blocks.add(block);
        this.arrangement.add(block, o);
    }
    
    public void clear() {
        this.blocks.clear();
        this.arrangement.clear();
    }
    
    public Size2D arrange(final Graphics2D graphics2D, final RectangleConstraint rectangleConstraint) {
        return this.arrangement.arrange(this, graphics2D, rectangleConstraint);
    }
    
    public void draw(final Graphics2D graphics2D, final Rectangle2D rectangle2D) {
        this.draw(graphics2D, rectangle2D, null);
    }
    
    public Object draw(final Graphics2D graphics2D, final Rectangle2D rectangle2D, final Object o) {
        StandardEntityCollection entityCollection = null;
        if (o instanceof EntityBlockParams && ((EntityBlockParams)o).getGenerateEntities()) {
            entityCollection = new StandardEntityCollection();
        }
        final Rectangle2D trimMargin = this.trimMargin((Rectangle2D)rectangle2D.clone());
        this.drawBorder(graphics2D, trimMargin);
        this.trimPadding(this.trimBorder(trimMargin));
        for (final Block block : this.blocks) {
            final Rectangle2D bounds = block.getBounds();
            final Object draw = block.draw(graphics2D, new Rectangle2D.Double(bounds.getX() + rectangle2D.getX(), bounds.getY() + rectangle2D.getY(), bounds.getWidth(), bounds.getHeight()), o);
            if (entityCollection != null && draw instanceof EntityBlockResult) {
                entityCollection.addAll(((EntityBlockResult)draw).getEntityCollection());
            }
        }
        BlockResult blockResult = null;
        if (entityCollection != null) {
            blockResult = new BlockResult();
            blockResult.setEntityCollection(entityCollection);
        }
        return blockResult;
    }
    
    public boolean equals(final Object o) {
        if (o == this) {
            return true;
        }
        if (!(o instanceof BlockContainer)) {
            return false;
        }
        if (!super.equals(o)) {
            return false;
        }
        final BlockContainer blockContainer = (BlockContainer)o;
        return this.arrangement.equals(blockContainer.arrangement) && this.blocks.equals(blockContainer.blocks);
    }
    
    public Object clone() {
        return super.clone();
    }
}
