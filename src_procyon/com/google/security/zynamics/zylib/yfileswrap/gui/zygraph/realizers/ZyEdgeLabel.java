package com.google.security.zynamics.zylib.yfileswrap.gui.zygraph.realizers;

import y.h.*;
import com.google.security.zynamics.zylib.gui.zygraph.realizers.*;
import com.google.common.base.*;
import java.awt.*;

public class ZyEdgeLabel extends aA
{
    private static final int SHADOW_SIZE = 5;
    private static Color m_backGroundColor;
    private static Color borderColor;
    private final ZyLabelContent m_content;
    private final int m_roundedHeight;
    private final int m_roundedWidth;
    private final double m_height;
    private final double m_width;
    
    public ZyEdgeLabel(final ZyLabelContent content) {
        Preconditions.checkNotNull(content, (Object)"Internal Error: Content can't be null");
        this.m_content = content;
        this.setVisible(true);
        this.setText("A");
        this.setModel((byte)1);
        this.setPreferredPlacement((byte)8);
        this.setPosition((byte)12);
        this.m_height = this.getHeight();
        this.m_width = this.getWidth();
        this.m_roundedHeight = (int)this.m_height;
        this.m_roundedWidth = (int)this.m_width;
    }
    
    @Override
    protected void paintBox(final Graphics2D graphics2D, final double n, final double n2, final double n3, final double n4) {
        final int n5 = (int)(n - this.m_width / 2.0);
        final int n6 = (int)(n2 - this.m_height / 2.0);
        final BasicStroke stroke = (BasicStroke)graphics2D.getStroke();
        graphics2D.setStroke(new BasicStroke(stroke.getLineWidth()));
        graphics2D.setColor(ZyEdgeLabel.m_backGroundColor);
        graphics2D.setComposite(AlphaComposite.getInstance(3, 0.8f));
        graphics2D.fillRoundRect(n5, n6, this.m_roundedWidth, this.m_roundedHeight, 5, 5);
        graphics2D.setComposite(AlphaComposite.getInstance(3, 0.95f));
        graphics2D.setColor(ZyEdgeLabel.borderColor);
        graphics2D.drawRoundRect(n5, n6, this.m_roundedWidth, this.m_roundedHeight, 5, 5);
        graphics2D.setComposite(AlphaComposite.getInstance(3, 1.0f));
        graphics2D.setStroke(stroke);
    }
    
    @Override
    protected void paintContent(final Graphics2D graphics2D, final double n, final double n2, final double n3, final double n4) {
        this.m_content.draw(graphics2D, (int)(n - this.m_width / 2.0), (int)(n2 - this.m_height / 2.0));
    }
    
    @Override
    public double getHeight() {
        return this.m_content.getBounds().getHeight();
    }
    
    public ZyLabelContent getLabelContent() {
        return this.m_content;
    }
    
    @Override
    public double getWidth() {
        return this.m_content.getBounds().getWidth();
    }
    
    static {
        ZyEdgeLabel.m_backGroundColor = new Color(250, 250, 255);
        ZyEdgeLabel.borderColor = Color.BLACK;
    }
}
