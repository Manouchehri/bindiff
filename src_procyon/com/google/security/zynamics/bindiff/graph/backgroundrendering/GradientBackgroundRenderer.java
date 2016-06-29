package com.google.security.zynamics.bindiff.graph.backgroundrendering;

import y.h.*;
import com.google.security.zynamics.bindiff.enums.*;
import com.google.security.zynamics.bindiff.project.userview.*;
import java.awt.image.*;
import java.awt.geom.*;
import java.awt.*;

public class GradientBackgroundRenderer extends M
{
    private static int OFFSET;
    private final Color GRADIENT_START_COLOR;
    private final ch graphView;
    private final Color gradientEndColor;
    private boolean update;
    private int oldViewWidth;
    private int oldViewHeight;
    private final String title;
    private final EGraph type;
    
    public GradientBackgroundRenderer(final ViewData viewData, final ch graphView, final Color gradientEndColor, final EGraph type) {
        super(graphView);
        this.GRADIENT_START_COLOR = new Color(250, 250, 250);
        this.update = false;
        this.oldViewWidth = 0;
        this.oldViewHeight = 0;
        this.graphView = graphView;
        this.gradientEndColor = gradientEndColor;
        this.type = type;
        this.title = BackgroundRendererManager.buildTitle(viewData, type);
    }
    
    @Override
    public void paint(final Graphics2D graphics2D, final int n, final int n2, final int n3, final int n4) {
        final int width = this.graphView.getWidth();
        final int height = this.graphView.getHeight();
        if (width != this.oldViewWidth || height != this.oldViewHeight || (width == 0 && height == 0) || this.update) {
            this.update = false;
            this.oldViewWidth = width;
            this.oldViewHeight = height;
            final BufferedImage image = new BufferedImage(width, height, 1);
            final Graphics2D graphics2D2 = (Graphics2D)image.getGraphics();
            graphics2D2.setPaint(new GradientPaint(0.0f, 0.0f, this.GRADIENT_START_COLOR, 0.0f, height, this.gradientEndColor));
            graphics2D2.fill(new Rectangle2D.Double(0.0, 0.0, width, height));
            graphics2D2.setPaint(Color.GRAY.darker());
            int n5 = GradientBackgroundRenderer.OFFSET;
            final Font font = graphics2D2.getFont();
            graphics2D2.setFont(new Font(font.getName(), 1, font.getSize()));
            graphics2D2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
            if (this.type == EGraph.SECONDARY_GRAPH) {
                n5 = Math.max(GradientBackgroundRenderer.OFFSET, width - (int)graphics2D2.getFont().getStringBounds(this.title, graphics2D2.getFontRenderContext()).getWidth() - GradientBackgroundRenderer.OFFSET);
            }
            graphics2D2.drawString(this.title, n5, GradientBackgroundRenderer.OFFSET);
            graphics2D2.setFont(font);
            this.setImage(image);
        }
        super.paint(graphics2D, n, n2, n3, n4);
    }
    
    public void update() {
        this.update = true;
        this.graphView.getGraph2D().T();
    }
    
    static {
        GradientBackgroundRenderer.OFFSET = 15;
    }
}
