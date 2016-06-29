package org.jfree.chart.block;

import java.io.*;
import org.jfree.util.*;
import java.awt.*;
import java.awt.geom.*;

public class EmptyBlock extends AbstractBlock implements Serializable, Cloneable, Block, PublicCloneable
{
    private static final long serialVersionUID = -4083197869412648579L;
    
    public EmptyBlock(final double width, final double height) {
        this.setWidth(width);
        this.setHeight(height);
    }
    
    public void draw(final Graphics2D graphics2D, final Rectangle2D rectangle2D) {
    }
    
    public Object draw(final Graphics2D graphics2D, final Rectangle2D rectangle2D, final Object o) {
        return null;
    }
    
    public Object clone() {
        return super.clone();
    }
}
