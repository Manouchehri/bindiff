package org.jfree.chart.imagemap;

public class DynamicDriveToolTipTagFragmentGenerator implements ToolTipTagFragmentGenerator
{
    protected String title;
    protected int style;
    
    public DynamicDriveToolTipTagFragmentGenerator() {
        this.title = "";
        this.style = 1;
    }
    
    public DynamicDriveToolTipTagFragmentGenerator(final String title, final int style) {
        this.title = "";
        this.style = 1;
        this.title = title;
        this.style = style;
    }
    
    public String generateToolTipFragment(final String s) {
        return " onMouseOver=\"return stm(['" + this.title + "','" + s + "'],Style[" + this.style + "]);\"" + " onMouseOut=\"return htm();\"";
    }
}
