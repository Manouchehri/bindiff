/*
 * Decompiled with CFR 0_115.
 */
package org.jfree.chart.labels;

import java.text.AttributedString;
import org.jfree.data.general.PieDataset;

public interface PieSectionLabelGenerator {
    public String generateSectionLabel(PieDataset var1, Comparable var2);

    public AttributedString generateAttributedSectionLabel(PieDataset var1, Comparable var2);
}

