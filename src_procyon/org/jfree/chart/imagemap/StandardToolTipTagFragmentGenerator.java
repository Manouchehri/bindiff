package org.jfree.chart.imagemap;

public class StandardToolTipTagFragmentGenerator implements ToolTipTagFragmentGenerator
{
    public String generateToolTipFragment(final String s) {
        return " title=\"" + s + "\" alt=\"\"";
    }
}
