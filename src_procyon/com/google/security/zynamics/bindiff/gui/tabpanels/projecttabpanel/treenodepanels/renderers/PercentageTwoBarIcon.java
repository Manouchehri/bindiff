package com.google.security.zynamics.bindiff.gui.tabpanels.projecttabpanel.treenodepanels.renderers;

import javax.swing.*;
import java.awt.geom.*;
import java.awt.*;

public class PercentageTwoBarIcon implements Icon
{
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
    private boolean showAdditionalPercetageValues;
    
    public PercentageTwoBarIcon(final PercentageTwoBarCellData percentageTwoBarCellData, final Color leftBarColor, final Color rightBarColor, final Color emptyBarColor, final Color leftTextColor, final Color totalTextColor, final Color rightTextColor, final Color selectionColor, final boolean selected, final int xOffset, final int yOffset, final int width, final int height) {
        this.showAdditionalPercetageValues = false;
        this.totalText = Integer.toString(percentageTwoBarCellData.getTotalBarValue());
        this.leftText = Integer.toString(percentageTwoBarCellData.getLeftBarValue());
        this.rightText = Integer.toString(percentageTwoBarCellData.getRightBarValue());
        this.leftValue = percentageTwoBarCellData.getLeftBarValue();
        this.rightValue = percentageTwoBarCellData.getRightBarValue();
        this.selected = selected;
        this.width = width;
        this.height = height;
        this.xOffset = xOffset;
        this.yOffset = yOffset;
        this.leftBarColor = leftBarColor;
        this.rightBarColor = rightBarColor;
        this.emptyBarColor = emptyBarColor;
        this.leftTextColor = leftTextColor;
        this.totalTextColor = totalTextColor;
        this.rightTextColor = rightTextColor;
        this.selectionColor = selectionColor;
    }
    
    private void buildTexts() {
        this.leftText = Integer.toString(this.leftValue);
        this.rightText = Integer.toString(this.rightValue);
        if (this.showAdditionalPercetageValues && this.leftValue + this.rightValue > 0) {
            final double n = this.leftValue / (this.leftValue + this.rightValue) * 100.0;
            final double n2 = 100.0 - n;
            final String value = String.valueOf(this.leftText);
            final String value2 = String.valueOf(String.format(" (%.1f%s)", n, "%"));
            this.leftText = ((value2.length() != 0) ? value.concat(value2) : new String(value));
            this.rightText = String.format("(%.1f%s) %s", n2, "%", this.rightText);
        }
    }
    
    private void drawText(final Graphics2D graphics2D) {
        final Color color = graphics2D.getColor();
        final Composite composite = graphics2D.getComposite();
        graphics2D.setComposite(AlphaComposite.getInstance(3, 1.0f));
        graphics2D.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
        final Rectangle2D stringBounds = graphics2D.getFontMetrics(graphics2D.getFont()).getStringBounds(this.leftText, graphics2D);
        final Rectangle2D stringBounds2 = graphics2D.getFontMetrics(graphics2D.getFont()).getStringBounds(this.totalText, graphics2D);
        final Rectangle2D stringBounds3 = graphics2D.getFontMetrics(graphics2D.getFont()).getStringBounds(this.rightText, graphics2D);
        final double n = 4.0 + stringBounds.getWidth() + 5.0 + stringBounds2.getWidth() + 5.0 + stringBounds3.getWidth() + 4.0;
        final int n2 = (int)((this.height - stringBounds2.getHeight()) / 2.0 + stringBounds2.getHeight()) - 1;
        if (n < this.width) {
            final int n3 = 4;
            final int n4 = (int)((this.width - stringBounds2.getWidth()) / 2.0) + 1;
            final int n5 = (int)(this.width - stringBounds3.getWidth() - 4.0);
            graphics2D.setColor(this.leftTextColor);
            graphics2D.drawString(this.leftText, n3, n2);
            graphics2D.setColor(this.totalTextColor);
            graphics2D.drawString(this.totalText, n4, n2);
            graphics2D.setColor(this.rightTextColor);
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
        if (this.leftValue + this.rightValue != 0) {
            final int n5 = (this.width - 2) * this.leftValue / (this.leftValue + this.rightValue);
            graphics2D.setColor(this.leftBarColor);
            graphics2D.fillRect(n3, n4, (this.rightValue == 0.0) ? this.width : n5, this.height);
            if (this.rightValue != 0) {
                graphics2D.setColor(this.rightBarColor);
                graphics2D.fillRect(n3 + n5 + 1, n4, this.width - n5 - 1, this.height);
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
            graphics2D.fillRect(n3 + 1, n4 + 1, this.width, this.height);
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
            final int n6 = (int)((this.width - stringBounds.getWidth()) / 2.0) + 1;
            final int n7 = (int)((this.height - stringBounds.getHeight()) / 2.0 + stringBounds.getHeight()) - 1;
            graphics2D.setColor(this.totalTextColor);
            graphics2D.drawString(this.totalText, n6, n7);
            graphics2D.setComposite(composite2);
        }
        graphics2D.setColor(color);
        graphics.translate(-n3, -n4);
    }
    
    public void setWidth(final int width) {
        this.width = width;
    }
    
    public void showAdditionalPercetageValues(final boolean showAdditionalPercetageValues) {
        this.showAdditionalPercetageValues = showAdditionalPercetageValues;
        this.buildTexts();
    }
    
    public void updateData(final int n, final int n2) {
        final PercentageTwoBarCellData percentageTwoBarCellData = new PercentageTwoBarCellData(n, n2);
        this.totalText = Integer.toString(percentageTwoBarCellData.getTotalBarValue());
        this.leftText = Integer.toString(percentageTwoBarCellData.getLeftBarValue());
        this.rightText = Integer.toString(percentageTwoBarCellData.getRightBarValue());
        this.leftValue = percentageTwoBarCellData.getLeftBarValue();
        this.rightValue = percentageTwoBarCellData.getRightBarValue();
    }
}
