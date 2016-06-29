package com.google.security.zynamics.bindiff.gui.tabpanels.projecttabpanel.treenodepanels.charts;

import org.jfree.chart.labels.*;
import org.jfree.data.category.*;

public class SimilarityBarChart2dPanel$CustomTooltipGenerator implements CategoryToolTipGenerator
{
    final /* synthetic */ SimilarityBarChart2dPanel this$0;
    
    public SimilarityBarChart2dPanel$CustomTooltipGenerator(final SimilarityBarChart2dPanel this$0) {
        this.this$0 = this$0;
    }
    
    @Override
    public String generateToolTip(final CategoryDataset categoryDataset, final int n, final int n2) {
        final double n3 = n2 / 10.0;
        String format;
        if (n3 == 1.0) {
            format = "= 1.0";
        }
        else {
            format = String.format("%.1f - %.1f", n3, n3 + 0.1);
        }
        return String.format("%.0f %s (%s %s)", categoryDataset.getValue(n, n2), "Matched Functions", "Similarity", format);
    }
}
