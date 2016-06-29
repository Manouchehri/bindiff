/*
 * Decompiled with CFR 0_115.
 */
package com.google.security.zynamics.bindiff.graph.backgroundrendering;

import com.google.security.zynamics.bindiff.enums.EGraph;
import com.google.security.zynamics.bindiff.graph.backgroundrendering.BackgroundRendererManager;
import com.google.security.zynamics.bindiff.project.userview.ViewData;
import java.awt.Color;
import java.awt.Font;
import java.awt.GradientPaint;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.Paint;
import java.awt.RenderingHints;
import java.awt.Shape;
import java.awt.font.FontRenderContext;
import java.awt.geom.Rectangle2D;
import java.awt.image.BufferedImage;
import y.h.M;
import y.h.bu;
import y.h.ch;

public class GradientBackgroundRenderer
extends M {
    private static int OFFSET = 15;
    private final Color GRADIENT_START_COLOR = new Color(250, 250, 250);
    private final ch graphView;
    private final Color gradientEndColor;
    private boolean update = false;
    private int oldViewWidth = 0;
    private int oldViewHeight = 0;
    private final String title;
    private final EGraph type;

    public GradientBackgroundRenderer(ViewData viewData, ch ch2, Color color, EGraph eGraph) {
        super(ch2);
        this.graphView = ch2;
        this.gradientEndColor = color;
        this.type = eGraph;
        this.title = BackgroundRendererManager.buildTitle(viewData, eGraph);
    }

    @Override
    public void paint(Graphics2D graphics2D, int n2, int n3, int n4, int n5) {
        int n6 = this.graphView.getWidth();
        int n7 = this.graphView.getHeight();
        if (n6 != this.oldViewWidth || n7 != this.oldViewHeight || n6 == 0 && n7 == 0 || this.update) {
            this.update = false;
            this.oldViewWidth = n6;
            this.oldViewHeight = n7;
            BufferedImage bufferedImage = new BufferedImage(n6, n7, 1);
            Graphics2D graphics2D2 = (Graphics2D)bufferedImage.getGraphics();
            GradientPaint gradientPaint = new GradientPaint(0.0f, 0.0f, this.GRADIENT_START_COLOR, 0.0f, n7, this.gradientEndColor);
            graphics2D2.setPaint(gradientPaint);
            graphics2D2.fill(new Rectangle2D.Double(0.0, 0.0, n6, n7));
            graphics2D2.setPaint(Color.GRAY.darker());
            int n8 = OFFSET;
            Font font = graphics2D2.getFont();
            Font font2 = new Font(font.getName(), 1, font.getSize());
            graphics2D2.setFont(font2);
            graphics2D2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
            if (this.type == EGraph.SECONDARY_GRAPH) {
                Rectangle2D rectangle2D = graphics2D2.getFont().getStringBounds(this.title, graphics2D2.getFontRenderContext());
                n8 = Math.max(OFFSET, n6 - (int)rectangle2D.getWidth() - OFFSET);
            }
            graphics2D2.drawString(this.title, n8, OFFSET);
            graphics2D2.setFont(font);
            this.setImage(bufferedImage);
        }
        super.paint(graphics2D, n2, n3, n4, n5);
    }

    public void update() {
        this.update = true;
        this.graphView.getGraph2D().T();
    }
}

