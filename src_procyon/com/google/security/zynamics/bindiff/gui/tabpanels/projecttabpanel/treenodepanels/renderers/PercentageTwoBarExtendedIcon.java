package com.google.security.zynamics.bindiff.gui.tabpanels.projecttabpanel.treenodepanels.renderers;

import javax.swing.*;
import java.awt.geom.*;
import java.awt.*;

public class PercentageTwoBarExtendedIcon implements Icon
{
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
    
    public PercentageTwoBarExtendedIcon(final PercentageTwoBarExtendedCellData percentageTwoBarExtendedCellData, final Color leftBarColor, final Color innerLeftBarColor, final Color rightBarColor, final Color emptyBarColor, final Color textColor, final int xOffset, final int yOffset, final int width, final int height) {
        this.totalText = Integer.toString(percentageTwoBarExtendedCellData.getTotalBarValue());
        this.leftText = percentageTwoBarExtendedCellData.getLeftBarString(true, true);
        this.rightText = percentageTwoBarExtendedCellData.getRightBarString(true);
        this.leftValue = percentageTwoBarExtendedCellData.getLeftBarValue();
        this.innerLeftValue = percentageTwoBarExtendedCellData.getInnerLeftBarValue();
        this.rightValue = percentageTwoBarExtendedCellData.getRightBarValue();
        this.width = width;
        this.height = height;
        this.xOffset = xOffset;
        this.yOffset = yOffset;
        this.leftBarColor = leftBarColor;
        this.innerLeftBarColor = innerLeftBarColor;
        this.rightBarColor = rightBarColor;
        this.emptyBarColor = emptyBarColor;
        this.textColor = textColor;
    }
    
    private void drawText(final Graphics2D graphics2D) {
        final Color color = graphics2D.getColor();
        final Composite composite = graphics2D.getComposite();
        graphics2D.setComposite(AlphaComposite.getInstance(3, 1.0f));
        graphics2D.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
        final Rectangle2D stringBounds = graphics2D.getFontMetrics(graphics2D.getFont()).getStringBounds(String.valueOf(this.leftText).concat("----"), graphics2D);
        final Rectangle2D stringBounds2 = graphics2D.getFontMetrics(graphics2D.getFont()).getStringBounds(this.totalText, graphics2D);
        final Rectangle2D stringBounds3 = graphics2D.getFontMetrics(graphics2D.getFont()).getStringBounds(this.rightText, graphics2D);
        final double n = 4.0 + stringBounds.getWidth() + 5.0 + stringBounds2.getWidth() + 5.0 + stringBounds3.getWidth() + 4.0;
        final int n2 = (int)((this.height - stringBounds2.getHeight()) / 2.0 + stringBounds2.getHeight()) - 1;
        if (n < this.width) {
            final int n3 = 4;
            final int n4 = (int)((this.width - stringBounds2.getWidth()) / 2.0) + 1;
            final int n5 = (int)(this.width - stringBounds3.getWidth() - 4.0);
            graphics2D.setColor(this.textColor);
            graphics2D.drawString(this.leftText, n3, n2);
            graphics2D.setColor(this.textColor);
            graphics2D.drawString(this.totalText, n4, n2);
            graphics2D.setColor(this.textColor);
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
        final int n5 = this.leftValue + this.rightValue;
        if (n5 != 0) {
            int n6 = 0;
            if (this.leftValue != 0) {
                n6 = (this.width - 2) * this.leftValue / n5;
                graphics2D.setColor(this.leftBarColor);
                graphics2D.fillRect(n3, n4, (this.rightValue == 0.0) ? this.width : n6, this.height);
                int n7 = (this.width - 2) * this.innerLeftValue / n5;
                n7 -= 2;
                if (n7 + 5 > n6) {
                    n7 = n6 - 14;
                }
                if (n7 > 0) {
                    graphics2D.setColor(this.innerLeftBarColor);
                    graphics2D.fillRect(n3 + 5, n4 + 5, (this.rightValue == 0.0) ? (this.width - 4) : (n7 - 2), this.height - 7);
                }
            }
            if (this.rightValue != 0) {
                graphics2D.setColor(this.rightBarColor);
                graphics2D.fillRect(n3 + n6 + 1, n4, this.width - n6 - 1, this.height);
            }
            graphics2D.setColor(Color.WHITE);
            graphics2D.drawRect(n3, n4, this.width, this.height);
            this.drawText(graphics2D);
        }
        else {
            graphics2D.setColor(this.emptyBarColor);
            graphics2D.fillRect(n3 + 1, n4 + 1, this.width, this.height);
            final Composite composite = graphics2D.getComposite();
            graphics2D.setComposite(AlphaComposite.getInstance(3, 1.0f));
            final Rectangle2D stringBounds = graphics2D.getFontMetrics(graphics2D.getFont()).getStringBounds("0", graphics2D);
            final int n8 = (int)((this.width - stringBounds.getWidth()) / 2.0) + 1;
            final int n9 = (int)((this.height - stringBounds.getHeight()) / 2.0 + stringBounds.getHeight()) - 1;
            graphics2D.setColor(this.textColor);
            graphics2D.drawString(this.totalText, n8, n9);
            graphics2D.setComposite(composite);
        }
        graphics2D.setColor(color);
        graphics.translate(-n3, -n4);
    }
    
    public void setWidth(final int width) {
        this.width = width;
    }
    
    public void updateData(final int n, final int n2, final int n3) {
        final PercentageTwoBarExtendedCellData percentageTwoBarExtendedCellData = new PercentageTwoBarExtendedCellData(n, n2, n3);
        this.totalText = Integer.toString(percentageTwoBarExtendedCellData.getTotalBarValue());
        this.leftText = percentageTwoBarExtendedCellData.getLeftBarString(true, true);
        this.rightText = percentageTwoBarExtendedCellData.getRightBarString(true);
        this.leftValue = percentageTwoBarExtendedCellData.getLeftBarValue();
        this.innerLeftValue = percentageTwoBarExtendedCellData.getInnerLeftBarValue();
        this.rightValue = percentageTwoBarExtendedCellData.getRightBarValue();
    }
}
