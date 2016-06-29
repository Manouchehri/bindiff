package com.google.security.zynamics.bindiff.graph.realizers;

import java.awt.geom.*;
import com.google.security.zynamics.bindiff.enums.*;
import com.google.security.zynamics.zylib.gui.zygraph.realizers.*;
import y.h.*;
import java.awt.*;
import com.google.security.zynamics.zylib.yfileswrap.gui.zygraph.realizers.*;

public class CombinedNodeRealizer extends ZyNodeRealizer
{
    private static final byte SHADOW_SIZE = 8;
    private static final Color SHADOW_COLOR;
    private static final int SEPARATOR_GAP = 12;
    private final ZyLabelContent leftContent;
    private final ZyLabelContent rightContent;
    private final Rectangle2D bounds;
    private ESide activeContentSide;
    
    public CombinedNodeRealizer(final ZyLabelContent leftContent, final ZyLabelContent rightContent) {
        this.bounds = new Rectangle();
        this.leftContent = leftContent;
        this.rightContent = rightContent;
        this.activeContentSide = ((leftContent != null) ? ESide.PRIMARY : ESide.SECONDARY);
        this.setShapeType((byte)1);
        this.setLineType(dr.b);
        this.setDropShadowOffsetX((byte)8);
        this.setDropShadowOffsetY((byte)8);
        this.setDropShadowColor(CombinedNodeRealizer.SHADOW_COLOR);
        this.setNodeSize();
    }
    
    private boolean isUnmatched() {
        return this.leftContent == null || this.rightContent == null;
    }
    
    private void setNodeSize() {
        if (this.isUnmatched()) {
            this.bounds.setRect(this.getNodeContent().getBounds());
        }
        else {
            this.bounds.setRect(this.leftContent.getBounds().getX(), this.leftContent.getBounds().getY(), this.leftContent.getBounds().getWidth() + 12.0 + this.rightContent.getBounds().getWidth(), Math.max(this.leftContent.getBounds().getHeight(), this.rightContent.getBounds().getHeight()));
        }
        this.setSize(this.bounds.getWidth(), this.bounds.getHeight());
    }
    
    @Override
    protected void paintShadow(final Graphics2D graphics2D) {
        if (!this.isSelected() && this.isDropShadowVisible()) {
            graphics2D.setColor(CombinedNodeRealizer.SHADOW_COLOR);
            this.setDropShadowOffsetX((byte)8);
            this.setDropShadowOffsetY((byte)8);
            graphics2D.setComposite(AlphaComposite.getInstance(3, 0.7f));
            super.paintShadow(graphics2D);
            graphics2D.setComposite(AlphaComposite.getInstance(3, 1.0f));
        }
    }
    
    @Override
    public void addListener(final IZyNodeRealizerListener zyNodeRealizerListener) {
    }
    
    @Override
    public void removeListener(final IZyNodeRealizerListener zyNodeRealizerListener) {
    }
    
    @Override
    public ZyLabelContent getNodeContent() {
        if (this.isUnmatched()) {
            return (this.leftContent == null) ? this.rightContent : this.leftContent;
        }
        return (this.activeContentSide == ESide.PRIMARY) ? this.leftContent : this.rightContent;
    }
    
    @Override
    public fj getRealizer() {
        return this;
    }
    
    @Override
    public void paintHotSpots(final Graphics2D graphics2D) {
    }
    
    @Override
    public void paintText(final Graphics2D graphics2D) {
        if (this.leftContent != null && this.rightContent == null) {
            this.leftContent.draw(graphics2D, this.getX(), this.getY());
        }
        else if (this.leftContent == null && this.rightContent != null) {
            this.rightContent.draw(graphics2D, this.getX(), this.getY());
        }
        else {
            final double width = this.leftContent.getBounds().getWidth();
            final int n = (int)Math.round(this.getX() + width + 6.0 - 1.0);
            final int n2 = (int)Math.round(this.getY() + 1.0);
            final int n3 = (int)Math.round(this.getY() + this.bounds.getHeight() - 1.0);
            graphics2D.setStroke(new BasicStroke(1.0f));
            this.leftContent.draw(graphics2D, this.getX(), this.getY());
            this.rightContent.draw(graphics2D, this.getX() + 12.0 + width, this.getY());
            graphics2D.setColor(Color.BLACK);
            graphics2D.setStroke(new BasicStroke(2.0f));
            graphics2D.drawLine(n, n2, n, n3);
        }
        super.paintText(graphics2D);
    }
    
    @Override
    public void regenerate() {
        if (this.isUnmatched()) {
            super.regenerate();
            return;
        }
        final double n = this.leftContent.getBounds().getWidth() + 12.0 + this.rightContent.getBounds().getWidth();
        final double n2 = this.leftContent.getBounds().getHeight() + this.rightContent.getBounds().getHeight();
        this.getUpdater().generateContent(this, this.leftContent);
        this.getUpdater().generateContent(this, this.rightContent);
        this.setNodeSize();
        this.scalePortCoordinates(this.getNode(), n, this.bounds.getWidth(), n2, this.bounds.getHeight());
        this.notifyHasRegenerated();
        this.repaint();
    }
    
    public void setActiveContent(final ESide activeContentSide) {
        if (!this.isUnmatched()) {
            this.activeContentSide = activeContentSide;
        }
    }
    
    @Override
    public void updateContentSelectionColor() {
        if (this.isUnmatched()) {
            super.updateContentSelectionColor();
        }
    }
    
    static {
        SHADOW_COLOR = Color.GRAY;
    }
}
