/*
 * Decompiled with CFR 0_115.
 */
package org.jfree.chart.imagemap;

import org.jfree.chart.imagemap.ToolTipTagFragmentGenerator;

public class OverLIBToolTipTagFragmentGenerator
implements ToolTipTagFragmentGenerator {
    @Override
    public String generateToolTipFragment(String string) {
        return new StringBuffer().append(" onMouseOver=\"return overlib('").append(string).append("');\" onMouseOut=\"return nd();\"").toString();
    }
}

