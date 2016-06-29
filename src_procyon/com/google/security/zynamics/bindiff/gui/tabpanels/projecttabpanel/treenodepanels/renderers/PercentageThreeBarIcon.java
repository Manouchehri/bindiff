package com.google.security.zynamics.bindiff.gui.tabpanels.projecttabpanel.treenodepanels.renderers;

import javax.swing.*;
import com.google.security.zynamics.bindiff.gui.tabpanels.projecttabpanel.treenodepanels.tables.renderers.*;
import java.awt.geom.*;
import java.awt.*;

public class PercentageThreeBarIcon implements Icon
{
    private final String leftText;
    private final String centerText;
    private final String rightText;
    private final int leftValue;
    private final int centerValue;
    private final int rightValue;
    private int width;
    private final int height;
    private final int xOffset;
    private final int yOffset;
    private final Color leftBarColor;
    private final Color centerBarColor;
    private final Color rightBarColor;
    private final Color emptyBarColor;
    private final Color textColor;
    private final Color selectionColor;
    private final boolean selected;
    
    public PercentageThreeBarIcon(final PercentageThreeBarCellData percentageThreeBarCellData, final Color color, final Color centerBarColor, final Color color2, final Color emptyBarColor, final Color color3, final Color color4, final boolean b, final int n, final int n2, final int n3, final int n4) {
        if (percentageThreeBarCellData.getLeftBarValue() == 0 && percentageThreeBarCellData.getCenterBarValue() == 0 && percentageThreeBarCellData.getRightBarValue() == 0) {
            this.leftText = "";
            this.centerText = "";
            this.rightText = "";
            this.leftValue = 0;
            this.centerValue = 1;
            this.rightValue = 0;
            this.selected = b;
            this.width = n3;
            this.height = n4;
            this.xOffset = n;
            this.yOffset = n2;
            this.leftBarColor = AbstractTableCellRenderer.NOT_ACCESSABLE_COLOR;
            this.centerBarColor = AbstractTableCellRenderer.NOT_ACCESSABLE_COLOR;
            this.rightBarColor = AbstractTableCellRenderer.NOT_ACCESSABLE_COLOR;
            this.emptyBarColor = AbstractTableCellRenderer.NOT_ACCESSABLE_COLOR;
            this.textColor = color3;
            this.selectionColor = color4;
        }
        else if (percentageThreeBarCellData.getLeftBarValue() != 0 && percentageThreeBarCellData.getCenterBarValue() == 0 && percentageThreeBarCellData.getRightBarValue() == 0) {
            this.leftText = "";
            this.centerText = Integer.toString(percentageThreeBarCellData.getLeftBarValue());
            this.rightText = "";
            this.leftValue = 0;
            this.centerValue = percentageThreeBarCellData.getLeftBarValue();
            this.rightValue = 0;
            this.selected = b;
            this.width = n3;
            this.height = n4;
            this.xOffset = n;
            this.yOffset = n2;
            this.leftBarColor = color;
            this.centerBarColor = color;
            this.rightBarColor = color;
            this.emptyBarColor = emptyBarColor;
            this.textColor = color3;
            this.selectionColor = color4;
        }
        else if (percentageThreeBarCellData.getLeftBarValue() == 0 && percentageThreeBarCellData.getCenterBarValue() == 0 && percentageThreeBarCellData.getRightBarValue() != 0) {
            this.leftText = "";
            this.centerText = Integer.toString(percentageThreeBarCellData.getRightBarValue());
            this.rightText = "";
            this.leftValue = 0;
            this.centerValue = percentageThreeBarCellData.getRightBarValue();
            this.rightValue = 0;
            this.selected = b;
            this.width = n3;
            this.height = n4;
            this.xOffset = n;
            this.yOffset = n2;
            this.leftBarColor = color2;
            this.centerBarColor = color2;
            this.rightBarColor = color2;
            this.emptyBarColor = emptyBarColor;
            this.textColor = color3;
            this.selectionColor = color4;
        }
        else {
            this.leftText = Integer.toString(percentageThreeBarCellData.getLeftBarValue());
            this.centerText = Integer.toString(percentageThreeBarCellData.getCenterBarValue());
            this.rightText = Integer.toString(percentageThreeBarCellData.getRightBarValue());
            this.leftValue = percentageThreeBarCellData.getLeftBarValue();
            this.centerValue = percentageThreeBarCellData.getCenterBarValue();
            this.rightValue = percentageThreeBarCellData.getRightBarValue();
            this.selected = b;
            this.width = n3;
            this.height = n4;
            this.xOffset = n;
            this.yOffset = n2;
            this.leftBarColor = color;
            this.centerBarColor = centerBarColor;
            this.rightBarColor = color2;
            this.emptyBarColor = emptyBarColor;
            this.textColor = color3;
            this.selectionColor = color4;
        }
    }
    
    private void drawText(final Graphics2D graphics2D) {
        final Color color = graphics2D.getColor();
        final Composite composite = graphics2D.getComposite();
        graphics2D.setComposite(AlphaComposite.getInstance(3, 1.0f));
        graphics2D.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
        final Rectangle2D stringBounds = graphics2D.getFontMetrics(graphics2D.getFont()).getStringBounds(this.leftText, graphics2D);
        final Rectangle2D stringBounds2 = graphics2D.getFontMetrics(graphics2D.getFont()).getStringBounds(this.centerText, graphics2D);
        final Rectangle2D stringBounds3 = graphics2D.getFontMetrics(graphics2D.getFont()).getStringBounds(this.rightText, graphics2D);
        final double n = 4.0 + stringBounds.getWidth() + 5.0 + stringBounds2.getWidth() + 5.0 + stringBounds3.getWidth() + 4.0;
        final int n2 = (int)((this.height - stringBounds2.getHeight()) / 2.0 + stringBounds2.getHeight()) - 1;
        if (n < this.width) {
            final int n3 = 4;
            final int n4 = (int)((this.width - stringBounds2.getWidth()) / 2.0) + 1;
            final int n5 = (int)(this.width - stringBounds3.getWidth() - 4.0);
            graphics2D.setColor(this.textColor);
            graphics2D.drawString(this.leftText, n3, n2);
            graphics2D.drawString(this.centerText, n4, n2);
            graphics2D.drawString(this.rightText, n5, n2);
        }
        else {
            final int n6 = (int)((this.width - graphics2D.getFontMetrics(graphics2D.getFont()).getStringBounds("...", graphics2D).getWidth()) / 2.0) + 1;
            graphics2D.setColor(Color.BLACK);
            graphics2D.drawString("...", n6, n2);
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
    public void paintIcon(final Component component, final Graphics graphics, final int n, final int n2) {
        final int n3 = n + this.xOffset;
        final int n4 = n2 + this.yOffset;
        graphics.translate(n3, n4);
        final Graphics2D graphics2D = (Graphics2D)graphics;
        final Color color = graphics2D.getColor();
        final int n5 = this.leftValue + this.centerValue + this.rightValue;
        int n6 = 0;
        int n7 = 0;
        if (n5 != 0) {
            int n8 = 0;
            if (this.leftValue != 0) {
                n6 = (this.width - 2) * this.leftValue / n5;
                graphics2D.setColor(this.leftBarColor);
                graphics2D.fillRect(n3, n4, (this.centerValue + this.rightValue == 0.0) ? this.width : n6, this.height);
                if (n6 > 1) {
                    ++n8;
                }
            }
            if (this.centerValue != 0) {
                n7 = (this.width - 1) * this.centerValue / n5;
                graphics2D.setColor(this.centerBarColor);
                graphics2D.fillRect(n3 + n6 + n8, n4, (this.rightValue == 0.0) ? (this.width - n6 - n8) : n7, this.height);
                if (n7 > 1) {
                    ++n8;
                }
            }
            if (this.rightValue != 0) {
                graphics2D.setColor(this.rightBarColor);
                graphics2D.fillRect(n3 + n6 + n7 + n8, n4, this.width - n6 - n7 - n8, this.height);
            }
            if (this.selected) {
                graphics2D.setColor(this.selectionColor);
                graphics2D.drawRect(n3, n4, this.width, this.height);
                final Composite composite = graphics2D.getComposite();
                graphics2D.setComposite(AlphaComposite.getInstance(3, 0.6f));
                graphics2D.fillRect(n3, n4, this.width, this.height);
                graphics2D.setComposite(composite);
            }
            else {
                graphics2D.setColor(Color.WHITE);
                graphics2D.drawRect(n3, n4, this.width, this.height);
            }
            this.drawText(graphics2D);
        }
        else {
            graphics2D.setColor(this.emptyBarColor);
            graphics2D.fillRect(n3 + 1, n4 + 1, this.width - 1, this.height - 1);
            if (this.selected) {
                graphics2D.setComposite(AlphaComposite.getInstance(3, 0.6f));
                graphics2D.setColor(this.selectionColor);
                graphics2D.fillRect(n3, n4, this.width, this.height);
                graphics2D.setComposite(AlphaComposite.getInstance(3, 1.0f));
                graphics2D.drawRect(n3, n4, this.width, this.height);
            }
            final Composite composite2 = graphics2D.getComposite();
            graphics2D.setComposite(AlphaComposite.getInstance(3, 1.0f));
            final Rectangle2D stringBounds = graphics2D.getFontMetrics(graphics2D.getFont()).getStringBounds("0", graphics2D);
            final int n9 = (int)((this.width - stringBounds.getWidth()) / 2.0) + 1;
            final int n10 = (int)((this.height - stringBounds.getHeight()) / 2.0 + stringBounds.getHeight()) - 1;
            graphics2D.setColor(this.textColor);
            graphics2D.drawString(this.centerText, n9, n10);
            graphics2D.setComposite(composite2);
        }
        graphics2D.setColor(color);
        graphics.translate(-n3, -n4);
    }
    
    public void setWidth(final int width) {
        this.width = width;
    }
}
