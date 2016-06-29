package com.google.security.zynamics.zylib.gui.tooltips;

public class ToolTipBuilder
{
    private final StringBuilder toolTip;
    
    public ToolTipBuilder() {
        (this.toolTip = new StringBuilder()).append("<html><table border=\"1\" cellpadding=\"1\" cellspacing=\"0f\">");
    }
    
    public ToolTipBuilder(final int n) {
        (this.toolTip = new StringBuilder()).append(new StringBuilder(67).append("<html><table border=\"").append(n).append("\" cellpadding=\"1\" cellspacing=\"0f\">").toString());
    }
    
    public void addCell(final String s) {
        this.toolTip.append("<td>");
        this.toolTip.append(s);
        this.toolTip.append("</td>");
    }
    
    public void beginNewTable(final int n) {
        this.toolTip.append(new StringBuilder(69).append("</table><table border=\"").append(n).append("\" cellpadding=\"1\" cellspacing=\"0f\">").toString());
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
