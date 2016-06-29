package com.google.security.zynamics.zylib.yfileswrap.gui.zygraph.realizers;

import com.google.security.zynamics.zylib.gui.zygraph.realizers.*;
import com.google.common.base.*;
import java.awt.geom.*;
import java.awt.*;
import y.h.*;

public class ZyNormalNodeRealizer extends ZyNodeRealizer
{
    private static final byte SHADOW_SIZE = 8;
    private static final Color SHADOW_COLOR;
    private final ZyLabelContent m_content;
    
    public ZyNormalNodeRealizer(final ZyLabelContent content) {
        Preconditions.checkNotNull(content, (Object)"Error: Node content can't be null.");
        this.m_content = content;
        this.setShapeType((byte)1);
        this.setLineType(dr.b);
        this.setDropShadowOffsetX((byte)8);
        this.setDropShadowOffsetY((byte)8);
        this.setDropShadowColor(ZyNormalNodeRealizer.SHADOW_COLOR);
        final Rectangle2D bounds = this.getNodeContent().getBounds();
        this.setSize(bounds.getWidth(), bounds.getHeight());
    }
    
    @Override
    protected void paintShadow(final Graphics2D graphics2D) {
        if (!this.isSelected() && this.isDropShadowVisible()) {
            graphics2D.setColor(ZyNormalNodeRealizer.SHADOW_COLOR);
            this.setDropShadowOffsetX((byte)8);
            this.setDropShadowOffsetY((byte)8);
            graphics2D.setComposite(AlphaComposite.getInstance(3, 0.7f));
            super.paintShadow(graphics2D);
            graphics2D.setComposite(AlphaComposite.getInstance(3, 1.0f));
        }
    }
    
    @Override
    public ZyLabelContent getNodeContent() {
        return this.m_content;
    }
    
    @Override
    public fj getRealizer() {
        return this;
    }
    
    @Override
    public void paintHotSpots(final Graphics2D graphics2D) {
    }
    
    public void paintNode(final Graphics2D graphics2D) {
        super.paintNode(graphics2D);
        final Rectangle2D bounds = this.getNodeContent().getBounds();
        final double n = this.getWidth() / bounds.getWidth();
        final double n2 = this.getHeight() / bounds.getHeight();
        graphics2D.scale(n, n2);
        this.getNodeContent().draw(graphics2D, this.getX() * 1.0 / n, this.getY() * 1.0 / n2);
        graphics2D.scale(1.0 / n, 1.0 / n2);
    }
    
    @Override
    public String toString() {
        return this.m_content.toString();
    }
    
    static {
        SHADOW_COLOR = Color.GRAY;
    }
}
