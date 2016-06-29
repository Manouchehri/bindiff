package com.google.security.zynamics.zylib.yfileswrap.gui.zygraph.realizers;

import com.google.common.base.*;
import y.h.*;
import java.awt.geom.*;
import java.awt.*;
import com.google.security.zynamics.zylib.gui.zygraph.realizers.*;

public class ZyProximityNodeRealizer extends ZyNodeRealizer
{
    private static Color m_backGroundColor;
    private final ZyLabelContent m_content;
    
    public ZyProximityNodeRealizer(final ZyLabelContent content) {
        Preconditions.checkNotNull(content, (Object)"Error: Node content can't be null.");
        this.m_content = content;
        this.setShapeType((byte)2);
        this.setLineType(dr.b);
        this.setDropShadowOffsetX((byte)0);
        this.setDropShadowOffsetY((byte)0);
        this.setFillColor(ZyProximityNodeRealizer.m_backGroundColor);
        fj.setSloppySelectionColor(ZyProximityNodeRealizer.m_backGroundColor);
        final Rectangle2D bounds = this.getNodeContent().getBounds();
        final double max = Math.max(bounds.getWidth(), bounds.getHeight());
        this.setSize(max, max);
    }
    
    @Override
    protected void paintFilledShape(final Graphics2D graphics2D) {
        graphics2D.setComposite(AlphaComposite.getInstance(3, 0.66f));
        super.paintFilledShape(graphics2D);
        graphics2D.setComposite(AlphaComposite.getInstance(3, 1.0f));
    }
    
    @Override
    public void addListener(final IZyNodeRealizerListener zyNodeRealizerListener) {
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
    public void paintSloppy(final Graphics2D graphics2D) {
        super.paintFilledShape(graphics2D);
        super.paintShapeBorder(graphics2D);
    }
    
    @Override
    public void removeListener(final IZyNodeRealizerListener zyNodeRealizerListener) {
    }
    
    @Override
    public void setSelected(final boolean b) {
    }
    
    @Override
    public void setUpdater(final IRealizerUpdater realizerUpdater) {
    }
    
    static {
        ZyProximityNodeRealizer.m_backGroundColor = new Color(250, 250, 255);
    }
}
