/*
 * Decompiled with CFR 0_115.
 */
package org.jfree.chart.imagemap;

import org.jfree.chart.imagemap.ToolTipTagFragmentGenerator;

public class DynamicDriveToolTipTagFragmentGenerator
implements ToolTipTagFragmentGenerator {
    protected String title = "";
    protected int style = 1;

    public DynamicDriveToolTipTagFragmentGenerator() {
    }

    public DynamicDriveToolTipTagFragmentGenerator(String string, int n2) {
        this.title = string;
        this.style = n2;
    }

    @Override
    public String generateToolTipFragment(String string) {
        return new StringBuffer().append(" onMouseOver=\"return stm(['").append(this.title).append("','").append(string).append("'],Style[").append(this.style).append("]);\"").append(" onMouseOut=\"return htm();\"").toString();
    }
}

