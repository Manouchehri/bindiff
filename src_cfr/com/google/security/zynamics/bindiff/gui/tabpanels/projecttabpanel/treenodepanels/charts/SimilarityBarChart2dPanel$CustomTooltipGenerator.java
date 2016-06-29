/*
 * Decompiled with CFR 0_115.
 */
package com.google.security.zynamics.bindiff.gui.tabpanels.projecttabpanel.treenodepanels.charts;

import com.google.security.zynamics.bindiff.gui.tabpanels.projecttabpanel.treenodepanels.charts.SimilarityBarChart2dPanel;
import org.jfree.chart.labels.CategoryToolTipGenerator;
import org.jfree.data.category.CategoryDataset;

public class SimilarityBarChart2dPanel$CustomTooltipGenerator
implements CategoryToolTipGenerator {
    final /* synthetic */ SimilarityBarChart2dPanel this$0;

    public SimilarityBarChart2dPanel$CustomTooltipGenerator(SimilarityBarChart2dPanel similarityBarChart2dPanel) {
        this.this$0 = similarityBarChart2dPanel;
    }

    @Override
    public String generateToolTip(CategoryDataset categoryDataset, int n2, int n3) {
        String string = null;
        double d2 = (double)n3 / 10.0;
        String string2 = "";
        string2 = d2 == 1.0 ? "= 1.0" : String.format("%.1f - %.1f", d2, d2 + 0.1);
        return String.format("%.0f %s (%s %s)", categoryDataset.getValue(n2, n3), "Matched Functions", "Similarity", string2);
    }
}

