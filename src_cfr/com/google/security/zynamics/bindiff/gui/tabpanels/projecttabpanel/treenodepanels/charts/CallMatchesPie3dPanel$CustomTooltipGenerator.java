/*
 * Decompiled with CFR 0_115.
 */
package com.google.security.zynamics.bindiff.gui.tabpanels.projecttabpanel.treenodepanels.charts;

import com.google.security.zynamics.bindiff.gui.tabpanels.projecttabpanel.treenodepanels.charts.CallMatchesPie3dPanel;
import com.google.security.zynamics.bindiff.gui.tabpanels.projecttabpanel.treenodepanels.charts.CallMatchesPie3dPanel$1;
import org.jfree.chart.labels.PieToolTipGenerator;
import org.jfree.data.general.PieDataset;

class CallMatchesPie3dPanel$CustomTooltipGenerator
implements PieToolTipGenerator {
    final /* synthetic */ CallMatchesPie3dPanel this$0;

    private CallMatchesPie3dPanel$CustomTooltipGenerator(CallMatchesPie3dPanel callMatchesPie3dPanel) {
        this.this$0 = callMatchesPie3dPanel;
    }

    @Override
    public String generateToolTip(PieDataset pieDataset, Comparable comparable) {
        if (pieDataset == null) return null;
        if (comparable.equals(CallMatchesPie3dPanel.access$300()[0])) {
            return String.format("%s %d (%.1f%s)", CallMatchesPie3dPanel.access$300()[0], CallMatchesPie3dPanel.access$400(this.this$0), CallMatchesPie3dPanel.access$500(this.this$0), "%");
        }
        if (comparable.equals(CallMatchesPie3dPanel.access$300()[1])) {
            return String.format("%s %d (%.1f%s)", CallMatchesPie3dPanel.access$300()[1], CallMatchesPie3dPanel.access$600(this.this$0), CallMatchesPie3dPanel.access$700(this.this$0), "%");
        }
        if (!comparable.equals(CallMatchesPie3dPanel.access$300()[2])) return null;
        return String.format("%s %d (%.1f%s)", CallMatchesPie3dPanel.access$300()[2], CallMatchesPie3dPanel.access$800(this.this$0), CallMatchesPie3dPanel.access$900(this.this$0), "%");
    }

    /* synthetic */ CallMatchesPie3dPanel$CustomTooltipGenerator(CallMatchesPie3dPanel callMatchesPie3dPanel, CallMatchesPie3dPanel$1 callMatchesPie3dPanel$1) {
        this(callMatchesPie3dPanel);
    }
}

