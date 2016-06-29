package org.jfree.chart.imagemap;

public class OverLIBToolTipTagFragmentGenerator implements ToolTipTagFragmentGenerator
{
    public String generateToolTipFragment(final String s) {
        return " onMouseOver=\"return overlib('" + s + "');\" onMouseOut=\"return nd();\"";
    }
}
