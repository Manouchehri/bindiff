/*
 * Decompiled with CFR 0_115.
 */
package com.google.security.zynamics.bindiff.gui.tabpanels.projecttabpanel.treenodepanels.charts;

import com.google.security.zynamics.bindiff.gui.tabpanels.projecttabpanel.treenodepanels.charts.FunctionMatchesPie3dPanel;
import com.google.security.zynamics.bindiff.gui.tabpanels.projecttabpanel.treenodepanels.charts.FunctionMatchesPie3dPanel$1;
import org.jfree.chart.labels.PieToolTipGenerator;
import org.jfree.data.general.PieDataset;

class FunctionMatchesPie3dPanel$CustomTooltipGenerator
implements PieToolTipGenerator {
    final /* synthetic */ FunctionMatchesPie3dPanel this$0;

    private FunctionMatchesPie3dPanel$CustomTooltipGenerator(FunctionMatchesPie3dPanel functionMatchesPie3dPanel) {
        this.this$0 = functionMatchesPie3dPanel;
    }

    @Override
    public String generateToolTip(PieDataset pieDataset, Comparable comparable) {
        if (pieDataset == null) {
            return null;
        }
        if (comparable.equals("Matched Functions")) {
            return String.format("%s %d (%.1f%s)", "Matched Functions", FunctionMatchesPie3dPanel.access$200(this.this$0), FunctionMatchesPie3dPanel.access$300(this.this$0), "%");
        }
        if (comparable.equals("Primary unmatched Functions")) {
            return String.format("%s %d (%.1f%s)", "Primary unmatched Functions", FunctionMatchesPie3dPanel.access$400(this.this$0), FunctionMatchesPie3dPanel.access$500(this.this$0), "%");
        }
        if (!comparable.equals("Secondary unmatched Functions")) return null;
        return String.format("%s %d (%.1f%s)", "Secondary unmatched Functions", FunctionMatchesPie3dPanel.access$600(this.this$0), FunctionMatchesPie3dPanel.access$700(this.this$0), "%");
    }

    /* synthetic */ FunctionMatchesPie3dPanel$CustomTooltipGenerator(FunctionMatchesPie3dPanel functionMatchesPie3dPanel, FunctionMatchesPie3dPanel$1 functionMatchesPie3dPanel$1) {
        this(functionMatchesPie3dPanel);
    }
}

