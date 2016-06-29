/*
 * Decompiled with CFR 0_115.
 */
package com.google.security.zynamics.bindiff.gui.tabpanels.projecttabpanel.treenodepanels.renderers;

import com.google.security.zynamics.bindiff.gui.tabpanels.projecttabpanel.treenodepanels.renderers.PercentageTwoBarCellData;
import java.awt.AlphaComposite;
import java.awt.Color;
import java.awt.Component;
import java.awt.Composite;
import java.awt.Font;
import java.awt.FontMetrics;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.awt.geom.Rectangle2D;
import javax.swing.Icon;

public class PercentageTwoBarIcon
implements Icon {
    private String leftText;
    private String totalText;
    private String rightText;
    private int leftValue;
    private int rightValue;
    private int width;
    private final int height;
    private final int xOffset;
    private final int yOffset;
    private final Color leftBarColor;
    private final Color rightBarColor;
    private final Color emptyBarColor;
    private final Color leftTextColor;
    private final Color totalTextColor;
    private final Color rightTextColor;
    private final Color selectionColor;
    private final boolean selected;
    private boolean showAdditionalPercetageValues = false;

    public PercentageTwoBarIcon(PercentageTwoBarCellData percentageTwoBarCellData, Color color, Color color2, Color color3, Color color4, Color color5, Color color6, Color color7, boolean bl2, int n2, int n3, int n4, int n5) {
        this.totalText = Integer.toString(percentageTwoBarCellData.getTotalBarValue());
        this.leftText = Integer.toString(percentageTwoBarCellData.getLeftBarValue());
        this.rightText = Integer.toString(percentageTwoBarCellData.getRightBarValue());
        this.leftValue = percentageTwoBarCellData.getLeftBarValue();
        this.rightValue = percentageTwoBarCellData.getRightBarValue();
        this.selected = bl2;
        this.width = n4;
        this.height = n5;
        this.xOffset = n2;
        this.yOffset = n3;
        this.leftBarColor = color;
        this.rightBarColor = color2;
        this.emptyBarColor = color3;
        this.leftTextColor = color4;
        this.totalTextColor = color5;
        this.rightTextColor = color6;
        this.selectionColor = color7;
    }

    private void buildTexts() {
        this.leftText = Integer.toString(this.leftValue);
        this.rightText = Integer.toString(this.rightValue);
        if (!this.showAdditionalPercetageValues) return;
        if (this.leftValue + this.rightValue <= 0) return;
        double d2 = (double)this.leftValue / (double)(this.leftValue + this.rightValue) * 100.0;
        double d3 = 100.0 - d2;
        String string = String.valueOf(this.leftText);
        String string2 = String.valueOf(String.format(" (%.1f%s)", d2, "%"));
        this.leftText = string2.length() != 0 ? string.concat(string2) : new String(string);
        this.rightText = String.format("(%.1f%s) %s", d3, "%", this.rightText);
    }

    private void drawText(Graphics2D graphics2D) {
        Color color = graphics2D.getColor();
        Composite composite = graphics2D.getComposite();
        graphics2D.setComposite(AlphaComposite.getInstance(3, 1.0f));
        graphics2D.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
        Rectangle2D rectangle2D = graphics2D.getFontMetrics(graphics2D.getFont()).getStringBounds(this.leftText, graphics2D);
        Rectangle2D rectangle2D2 = graphics2D.getFontMetrics(graphics2D.getFont()).getStringBounds(this.totalText, graphics2D);
        Rectangle2D rectangle2D3 = graphics2D.getFontMetrics(graphics2D.getFont()).getStringBounds(this.rightText, graphics2D);
        double d2 = 4.0 + rectangle2D.getWidth() + 5.0 + rectangle2D2.getWidth() + 5.0 + rectangle2D3.getWidth() + 4.0;
        int n2 = 0;
        int n3 = 0;
        int n4 = 0;
        int n5 = (int)(((double)this.height - rectangle2D2.getHeight()) / 2.0 + rectangle2D2.getHeight()) - 1;
        if (d2 < (double)this.width) {
            n2 = 4;
            n3 = (int)(((double)this.width - rectangle2D2.getWidth()) / 2.0) + 1;
            n4 = (int)((double)this.width - rectangle2D3.getWidth() - 4.0);
            graphics2D.setColor(this.leftTextColor);
            graphics2D.drawString(this.leftText, n2, n5);
            graphics2D.setColor(this.totalTextColor);
            graphics2D.drawString(this.totalText, n3, n5);
            graphics2D.setColor(this.rightTextColor);
            graphics2D.drawString(this.rightText, n4, n5);
        } else {
            String string = "...";
            rectangle2D2 = graphics2D.getFontMetrics(graphics2D.getFont()).getStringBounds("...", graphics2D);
            n3 = (int)(((double)this.width - rectangle2D2.getWidth()) / 2.0) + 1;
            graphics2D.setColor(Color.BLACK);
            graphics2D.drawString("...", n3, n5);
        }
        graphics2D.setComposite(composite);
        graphics2D.setColor(color);
    }

    @Override
    public int getIconHeight() {
        return this.height;
    }

    @Override
    public int getIconWidth() {
        return this.width;
    }

    @Override
    public void paintIcon(Component component, Graphics graphics, int n2, int n3) {
        int n4 = n2 + this.xOffset;
        int n5 = n3 + this.yOffset;
        graphics.translate(n4, n5);
        Graphics2D graphics2D = (Graphics2D)graphics;
        Color color = graphics2D.getColor();
        if (this.leftValue + this.rightValue != 0) {
            int n6 = (this.width - 2) * this.leftValue / (this.leftValue + this.rightValue);
            graphics2D.setColor(this.leftBarColor);
            graphics2D.fillRect(n4, n5, (double)this.rightValue == 0.0 ? this.width : n6, this.height);
            if (this.rightValue != 0) {
                graphics2D.setColor(this.rightBarColor);
                graphics2D.fillRect(n4 + n6 + 1, n5, this.width - n6 - 1, this.height);
            }
            if (this.selected) {
                graphics2D.setColor(this.selectionColor);
                graphics2D.drawRect(n4, n5, this.width, this.height);
                Composite composite = graphics2D.getComposite();
                graphics2D.setComposite(AlphaComposite.getInstance(3, 0.6f));
                graphics2D.fillRect(n4, n5, this.width, this.height);
                graphics2D.setComposite(composite);
            } else {
                graphics2D.setColor(Color.WHITE);
                graphics2D.drawRect(n4, n5, this.width, this.height);
            }
            this.drawText(graphics2D);
        } else {
            graphics2D.setColor(this.emptyBarColor);
            graphics2D.fillRect(n4 + 1, n5 + 1, this.width, this.height);
            if (this.selected) {
                graphics2D.setComposite(AlphaComposite.getInstance(3, 0.6f));
                graphics2D.setColor(this.selectionColor);
                graphics2D.fillRect(n4, n5, this.width, this.height);
                graphics2D.setComposite(AlphaComposite.getInstance(3, 1.0f));
                graphics2D.drawRect(n4, n5, this.width, this.height);
            }
            Composite composite = graphics2D.getComposite();
            graphics2D.setComposite(AlphaComposite.getInstance(3, 1.0f));
            Rectangle2D rectangle2D = graphics2D.getFontMetrics(graphics2D.getFont()).getStringBounds("0", graphics2D);
            int n7 = (int)(((double)this.width - rectangle2D.getWidth()) / 2.0) + 1;
            int n8 = (int)(((double)this.height - rectangle2D.getHeight()) / 2.0 + rectangle2D.getHeight()) - 1;
            graphics2D.setColor(this.totalTextColor);
            graphics2D.drawString(this.totalText, n7, n8);
            graphics2D.setComposite(composite);
        }
        graphics2D.setColor(color);
        graphics.translate(- n4, - n5);
    }

    public void setWidth(int n2) {
        this.width = n2;
    }

    public void showAdditionalPercetageValues(boolean bl2) {
        this.showAdditionalPercetageValues = bl2;
        this.buildTexts();
    }

    public void updateData(int n2, int n3) {
        PercentageTwoBarCellData percentageTwoBarCellData = new PercentageTwoBarCellData(n2, n3);
        this.totalText = Integer.toString(percentageTwoBarCellData.getTotalBarValue());
        this.leftText = Integer.toString(percentageTwoBarCellData.getLeftBarValue());
        this.rightText = Integer.toString(percentageTwoBarCellData.getRightBarValue());
        this.leftValue = percentageTwoBarCellData.getLeftBarValue();
        this.rightValue = percentageTwoBarCellData.getRightBarValue();
    }
}

