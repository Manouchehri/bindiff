package com.google.security.zynamics.bindiff.gui.tabpanels.projecttabpanel.treenodepanels.renderers;

import javax.swing.*;
import java.awt.geom.*;
import java.awt.*;

public class PercentageThreeBarExtendedBarIcon implements Icon
{
    private final String leftText;
    private final String centerText;
    private final String rightText;
    private final int leftValue;
    private final int centerValue;
    private final int innerCenterValue;
    private final int rightValue;
    private final boolean selected;
    private int width;
    private final int height;
    private final int xOffset;
    private final int yOffset;
    private final Color leftBarColor;
    private final Color centerBarColor;
    private final Color innerCenterBarColor;
    private final Color rightBarColor;
    private final Color emptyBarColor;
    private final Color textColor;
    private final Color selectionColor;
    
    public PercentageThreeBarExtendedBarIcon(final PercentageThreeBarExtendedCellData percentageThreeBarExtendedCellData, final Color leftBarColor, final Color centerBarColor, final Color innerCenterBarColor, final Color rightBarColor, final Color emptyBarColor, final Color textColor, final Color selectionColor, final boolean selected, final int xOffset, final int yOffset, final int width, final int height) {
        this.leftText = Integer.toString(percentageThreeBarExtendedCellData.getLeftBarValue());
        this.centerText = Integer.toString(percentageThreeBarExtendedCellData.getCenterBarValue());
        this.rightText = Integer.toString(percentageThreeBarExtendedCellData.getRightBarValue());
        this.leftValue = percentageThreeBarExtendedCellData.getLeftBarValue();
        this.centerValue = percentageThreeBarExtendedCellData.getCenterBarValue();
        this.innerCenterValue = percentageThreeBarExtendedCellData.getInnerCenterBarValue();
        this.rightValue = percentageThreeBarExtendedCellData.getRightBarValue();
        this.selected = selected;
        this.width = width;
        this.height = height;
        this.xOffset = xOffset;
        this.yOffset = yOffset;
        this.leftBarColor = leftBarColor;
        this.centerBarColor = centerBarColor;
        this.innerCenterBarColor = innerCenterBarColor;
        this.rightBarColor = rightBarColor;
        this.emptyBarColor = emptyBarColor;
        this.textColor = textColor;
        this.selectionColor = selectionColor;
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
                n7 = (this.width - 2) * this.centerValue / n5;
                graphics2D.setColor(this.centerBarColor);
                graphics2D.fillRect(n3 + n6 + n8, n4, (this.rightValue == 0) ? (this.width - n6 - n8) : n7, this.height);
                if (this.innerCenterValue != 0) {
                    int n9 = (n7 - 2) * this.innerCenterValue / this.centerValue;
                    if (n9 > 0) {
                        int n10 = n3 + n6 + n8 + 1;
                        if (this.rightValue == 0.0) {
                            ++n10;
                        }
                        else if (this.leftValue == 0) {
                            --n9;
                            ++n10;
                        }
                        graphics2D.setColor(this.innerCenterBarColor);
                        graphics2D.fillRect(n10, n4 + 3, (this.rightValue == 0.0) ? (this.width - n6 - n7 + n9 - n8 - 1) : n9, this.height - 5);
                    }
                }
                if (n6 > 1) {
                    ++n8;
                }
            }
            if (this.rightValue != 0) {
                if (n6 <= 1) {
                    ++n8;
                }
                if (n6 <= 1 && n7 <= 1) {
                    n8 -= 2;
                }
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
            final int n11 = (int)((this.width - stringBounds.getWidth()) / 2.0) + 1;
            final int n12 = (int)((this.height - stringBounds.getHeight()) / 2.0 + stringBounds.getHeight()) - 1;
            graphics2D.setColor(this.textColor);
            graphics2D.drawString(this.centerText, n11, n12);
            graphics2D.setComposite(composite2);
        }
        graphics2D.setColor(color);
        graphics.translate(-n3, -n4);
    }
    
    public void setWidth(final int width) {
        this.width = width;
    }
}
