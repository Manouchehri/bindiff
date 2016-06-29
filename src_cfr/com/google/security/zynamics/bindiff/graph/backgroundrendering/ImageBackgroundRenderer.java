/*
 * Decompiled with CFR 0_115.
 */
package com.google.security.zynamics.bindiff.graph.backgroundrendering;

import com.google.security.zynamics.bindiff.enums.EGraph;
import com.google.security.zynamics.bindiff.graph.backgroundrendering.BackgroundRendererManager;
import com.google.security.zynamics.bindiff.graph.backgroundrendering.ImageBackgroundRenderer$1;
import com.google.security.zynamics.bindiff.project.userview.ViewData;
import com.google.security.zynamics.bindiff.utils.ImageUtils;
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.Paint;
import java.awt.RenderingHints;
import java.awt.Shape;
import java.awt.font.FontRenderContext;
import java.awt.geom.Rectangle2D;
import java.awt.image.BufferedImage;
import java.awt.image.ImageObserver;
import y.h.M;
import y.h.ch;

public class ImageBackgroundRenderer
extends M {
    private static int OFFSET = 15;
    private final Image PRIMARY_TEXT_IMAGE = ImageUtils.getImage("data/graphview/primary.png");
    private final Image SECONDRAY_TEXT_IMAGE = ImageUtils.getImage("data/graphview/secondary.png");
    private final Image COMBINED_TEXT_IMAGE = ImageUtils.getImage("data/graphview/combined.png");
    private final ch graphView;
    private final EGraph type;
    private int oldViewWidth = 0;
    private int oldViewHeight = 0;
    private BufferedImage backgroundImage;
    private final String title;

    public ImageBackgroundRenderer(ViewData viewData, ch ch2, EGraph eGraph) {
        super(ch2);
        this.graphView = ch2;
        this.type = eGraph;
        this.title = BackgroundRendererManager.buildTitle(viewData, eGraph);
    }

    private Image getTextImage() {
        if (this.type == EGraph.PRIMARY_GRAPH) {
            return this.PRIMARY_TEXT_IMAGE;
        }
        if (this.type != EGraph.SECONDARY_GRAPH) return this.COMBINED_TEXT_IMAGE;
        return this.SECONDRAY_TEXT_IMAGE;
    }

    private int getX(int n2, int n3) {
        if (this.type != EGraph.SECONDARY_GRAPH) return OFFSET;
        int n4 = OFFSET;
        if (this.graphView.getVerticalScrollBarPolicy() != 22) return n2 - n3 - n4;
        n4 += 15;
        return n2 - n3 - n4;
    }

    @Override
    public void paint(Graphics2D graphics2D, int n2, int n3, int n4, int n5) {
        if (graphics2D == null) {
            return;
        }
        int n6 = this.graphView.getWidth();
        int n7 = this.graphView.getHeight();
        if (n6 != this.oldViewWidth || n7 != this.oldViewHeight && n6 != 0 && n7 != 0) {
            this.oldViewWidth = n6;
            this.oldViewHeight = n7;
            this.backgroundImage = new BufferedImage(n6, n7, 1);
        }
        if (this.backgroundImage != null) {
            int n8;
            Graphics2D graphics2D2 = (Graphics2D)this.backgroundImage.getGraphics();
            graphics2D2.setPaint(Color.WHITE);
            graphics2D2.fill(new Rectangle2D.Double(0.0, 0.0, n6, n7));
            graphics2D2.setPaint(Color.GRAY.darker());
            int n9 = n8 = this.getX(n6, this.SECONDRAY_TEXT_IMAGE.getWidth(null));
            Font font = graphics2D2.getFont();
            Font font2 = new Font(font.getName(), 1, font.getSize());
            graphics2D2.setFont(font2);
            graphics2D2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
            if (this.type == EGraph.SECONDARY_GRAPH) {
                Rectangle2D rectangle2D = graphics2D2.getFont().getStringBounds(this.title, graphics2D2.getFontRenderContext());
                n9 = this.getX(n6, Math.max(OFFSET, (int)rectangle2D.getWidth()));
            }
            graphics2D2.drawString(this.title, n9, 15);
            graphics2D2.drawImage(this.getTextImage(), n8, 20, null);
            graphics2D2.setFont(font);
            this.setImage(this.backgroundImage);
        }
        super.paint(graphics2D, n2, n3, n4, n5);
    }

    public void update() {
        EventQueue.invokeLater(new ImageBackgroundRenderer$1(this));
    }

    static /* synthetic */ ch access$000(ImageBackgroundRenderer imageBackgroundRenderer) {
        return imageBackgroundRenderer.graphView;
    }
}

