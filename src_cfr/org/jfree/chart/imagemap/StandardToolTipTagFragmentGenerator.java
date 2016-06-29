/*
 * Decompiled with CFR 0_115.
 */
package org.jfree.chart.imagemap;

import org.jfree.chart.imagemap.ToolTipTagFragmentGenerator;

public class StandardToolTipTagFragmentGenerator
implements ToolTipTagFragmentGenerator {
    @Override
    public String generateToolTipFragment(String string) {
        return new StringBuffer().append(" title=\"").append(string).append("\" alt=\"\"").toString();
    }
}

