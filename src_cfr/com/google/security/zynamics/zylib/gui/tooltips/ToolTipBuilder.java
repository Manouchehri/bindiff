/*
 * Decompiled with CFR 0_115.
 */
package com.google.security.zynamics.zylib.gui.tooltips;

public class ToolTipBuilder {
    private final StringBuilder toolTip = new StringBuilder();

    public ToolTipBuilder() {
        this.toolTip.append("<html><table border=\"1\" cellpadding=\"1\" cellspacing=\"0f\">");
    }

    public ToolTipBuilder(int n2) {
        this.toolTip.append(new StringBuilder(67).append("<html><table border=\"").append(n2).append("\" cellpadding=\"1\" cellspacing=\"0f\">").toString());
    }

    public void addCell(String string) {
        this.toolTip.append("<td>");
        this.toolTip.append(string);
        this.toolTip.append("</td>");
    }

    public void beginNewTable(int n2) {
        this.toolTip.append(new StringBuilder(69).append("</table><table border=\"").append(n2).append("\" cellpadding=\"1\" cellspacing=\"0f\">").toString());
    }

    public void beginRow() {
        this.toolTip.append("<tr>");
    }

    public void endRow() {
        this.toolTip.append("</tr>");
    }

    public String finish() {
        this.toolTip.append("</table></html>");
        return this.toolTip.toString();
    }
}

