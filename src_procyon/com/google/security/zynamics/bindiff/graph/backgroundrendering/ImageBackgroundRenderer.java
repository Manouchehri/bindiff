package com.google.security.zynamics.bindiff.graph.backgroundrendering;

import y.h.*;
import com.google.security.zynamics.bindiff.enums.*;
import com.google.security.zynamics.bindiff.project.userview.*;
import com.google.security.zynamics.bindiff.utils.*;
import java.awt.geom.*;
import java.awt.image.*;
import java.awt.*;

public class ImageBackgroundRenderer extends M
{
    private static int OFFSET;
    private final Image PRIMARY_TEXT_IMAGE;
    private final Image SECONDRAY_TEXT_IMAGE;
    private final Image COMBINED_TEXT_IMAGE;
    private final ch graphView;
    private final EGraph type;
    private int oldViewWidth;
    private int oldViewHeight;
    private BufferedImage backgroundImage;
    private final String title;
    
    public ImageBackgroundRenderer(final ViewData viewData, final ch graphView, final EGraph type) {
        super(graphView);
        this.PRIMARY_TEXT_IMAGE = ImageUtils.getImage("data/graphview/primary.png");
        this.SECONDRAY_TEXT_IMAGE = ImageUtils.getImage("data/graphview/secondary.png");
        this.COMBINED_TEXT_IMAGE = ImageUtils.getImage("data/graphview/combined.png");
        this.oldViewWidth = 0;
        this.oldViewHeight = 0;
        this.graphView = graphView;
        this.type = type;
        this.title = BackgroundRendererManager.buildTitle(viewData, type);
    }
    
    private Image getTextImage() {
        if (this.type == EGraph.PRIMARY_GRAPH) {
            return this.PRIMARY_TEXT_IMAGE;
        }
        if (this.type == EGraph.SECONDARY_GRAPH) {
            return this.SECONDRAY_TEXT_IMAGE;
        }
        return this.COMBINED_TEXT_IMAGE;
    }
    
    private int getX(final int n, final int n2) {
        if (this.type == EGraph.SECONDARY_GRAPH) {
            int offset = ImageBackgroundRenderer.OFFSET;
            if (this.graphView.getVerticalScrollBarPolicy() == 22) {
                offset += 15;
            }
            return n - n2 - offset;
        }
        return ImageBackgroundRenderer.OFFSET;
    }
    
    @Override
    public void paint(final Graphics2D graphics2D, final int n, final int n2, final int n3, final int n4) {
        if (graphics2D == null) {
            return;
        }
        final int width = this.graphView.getWidth();
        final int height = this.graphView.getHeight();
        if (width != this.oldViewWidth || (height != this.oldViewHeight && width != 0 && height != 0)) {
            this.oldViewWidth = width;
            this.oldViewHeight = height;
            this.backgroundImage = new BufferedImage(width, height, 1);
        }
        if (this.backgroundImage != null) {
            final Graphics2D graphics2D2 = (Graphics2D)this.backgroundImage.getGraphics();
            graphics2D2.setPaint(Color.WHITE);
            graphics2D2.fill(new Rectangle2D.Double(0.0, 0.0, width, height));
            graphics2D2.setPaint(Color.GRAY.darker());
            int n5 = this.getX(width, this.SECONDRAY_TEXT_IMAGE.getWidth(null));
            final Font font = graphics2D2.getFont();
            graphics2D2.setFont(new Font(font.getName(), 1, font.getSize()));
            graphics2D2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
            if (this.type == EGraph.SECONDARY_GRAPH) {
                n5 = this.getX(width, Math.max(ImageBackgroundRenderer.OFFSET, (int)graphics2D2.getFont().getStringBounds(this.title, graphics2D2.getFontRenderContext()).getWidth()));
            }
            graphics2D2.drawString(this.title, n5, 15);
            graphics2D2.drawImage(this.getTextImage(), n5, 20, null);
            graphics2D2.setFont(font);
            this.setImage(this.backgroundImage);
        }
        super.paint(graphics2D, n, n2, n3, n4);
    }
    
    public void update() {
        EventQueue.invokeLater(new ImageBackgroundRenderer$1(this));
    }
    
    static {
        ImageBackgroundRenderer.OFFSET = 15;
    }
}
