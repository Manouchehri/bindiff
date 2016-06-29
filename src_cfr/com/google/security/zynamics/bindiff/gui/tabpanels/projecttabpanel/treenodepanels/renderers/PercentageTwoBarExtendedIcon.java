/*
 * Decompiled with CFR 0_115.
 */
package com.google.security.zynamics.bindiff.gui.tabpanels.projecttabpanel.treenodepanels.renderers;

import com.google.security.zynamics.bindiff.gui.tabpanels.projecttabpanel.treenodepanels.renderers.PercentageTwoBarExtendedCellData;
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

public class PercentageTwoBarExtendedIcon
implements Icon {
    private String leftText;
    private String totalText;
    private String rightText;
    private int leftValue;
    private int innerLeftValue;
    private int rightValue;
    private int width;
    private final int height;
    private final int xOffset;
    private final int yOffset;
    private final Color leftBarColor;
    private final Color innerLeftBarColor;
    private final Color rightBarColor;
    private final Color emptyBarColor;
    private final Color textColor;

    public PercentageTwoBarExtendedIcon(PercentageTwoBarExtendedCellData percentageTwoBarExtendedCellData, Color color, Color color2, Color color3, Color color4, Color color5, int n2, int n3, int n4, int n5) {
        this.totalText = Integer.toString(percentageTwoBarExtendedCellData.getTotalBarValue());
        this.leftText = percentageTwoBarExtendedCellData.getLeftBarString(true, true);
        this.rightText = percentageTwoBarExtendedCellData.getRightBarString(true);
        this.leftValue = percentageTwoBarExtendedCellData.getLeftBarValue();
        this.innerLeftValue = percentageTwoBarExtendedCellData.getInnerLeftBarValue();
        this.rightValue = percentageTwoBarExtendedCellData.getRightBarValue();
        this.width = n4;
        this.height = n5;
        this.xOffset = n2;
        this.yOffset = n3;
        this.leftBarColor = color;
        this.innerLeftBarColor = color2;
        this.rightBarColor = color3;
        this.emptyBarColor = color4;
        this.textColor = color5;
    }

    private void drawText(Graphics2D graphics2D) {
        Color color = graphics2D.getColor();
        Composite composite = graphics2D.getComposite();
        graphics2D.setComposite(AlphaComposite.getInstance(3, 1.0f));
        graphics2D.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
        Rectangle2D rectangle2D = graphics2D.getFontMetrics(graphics2D.getFont()).getStringBounds(String.valueOf(this.leftText).concat("----"), graphics2D);
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
            graphics2D.setColor(this.textColor);
            graphics2D.drawString(this.leftText, n2, n5);
            graphics2D.setColor(this.textColor);
            graphics2D.drawString(this.totalText, n3, n5);
            graphics2D.setColor(this.textColor);
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
        int n6 = this.leftValue + this.rightValue;
        if (n6 != 0) {
            int n7 = 0;
            if (this.leftValue != 0) {
                n7 = (this.width - 2) * this.leftValue / n6;
                graphics2D.setColor(this.leftBarColor);
                graphics2D.fillRect(n4, n5, (double)this.rightValue == 0.0 ? this.width : n7, this.height);
                int n8 = (this.width - 2) * this.innerLeftValue / n6;
                if ((n8 -= 2) + 5 > n7) {
                    n8 = n7 - 14;
                }
                if (n8 > 0) {
                    graphics2D.setColor(this.innerLeftBarColor);
                    graphics2D.fillRect(n4 + 5, n5 + 5, (double)this.rightValue == 0.0 ? this.width - 4 : n8 - 2, this.height - 7);
                }
            }
            if (this.rightValue != 0) {
                graphics2D.setColor(this.rightBarColor);
                graphics2D.fillRect(n4 + n7 + 1, n5, this.width - n7 - 1, this.height);
            }
            graphics2D.setColor(Color.WHITE);
            graphics2D.drawRect(n4, n5, this.width, this.height);
            this.drawText(graphics2D);
        } else {
            graphics2D.setColor(this.emptyBarColor);
            graphics2D.fillRect(n4 + 1, n5 + 1, this.width, this.height);
            Composite composite = graphics2D.getComposite();
            graphics2D.setComposite(AlphaComposite.getInstance(3, 1.0f));
            Rectangle2D rectangle2D = graphics2D.getFontMetrics(graphics2D.getFont()).getStringBounds("0", graphics2D);
            int n9 = (int)(((double)this.width - rectangle2D.getWidth()) / 2.0) + 1;
            int n10 = (int)(((double)this.height - rectangle2D.getHeight()) / 2.0 + rectangle2D.getHeight()) - 1;
            graphics2D.setColor(this.textColor);
            graphics2D.drawString(this.totalText, n9, n10);
            graphics2D.setComposite(composite);
        }
        graphics2D.setColor(color);
        graphics.translate(- n4, - n5);
    }

    public void setWidth(int n2) {
        this.width = n2;
    }

    public void updateData(int n2, int n3, int n4) {
        PercentageTwoBarExtendedCellData percentageTwoBarExtendedCellData = new PercentageTwoBarExtendedCellData(n2, n3, n4);
        this.totalText = Integer.toString(percentageTwoBarExtendedCellData.getTotalBarValue());
        this.leftText = percentageTwoBarExtendedCellData.getLeftBarString(true, true);
        this.rightText = percentageTwoBarExtendedCellData.getRightBarString(true);
        this.leftValue = percentageTwoBarExtendedCellData.getLeftBarValue();
        this.innerLeftValue = percentageTwoBarExtendedCellData.getInnerLeftBarValue();
        this.rightValue = percentageTwoBarExtendedCellData.getRightBarValue();
    }
}

