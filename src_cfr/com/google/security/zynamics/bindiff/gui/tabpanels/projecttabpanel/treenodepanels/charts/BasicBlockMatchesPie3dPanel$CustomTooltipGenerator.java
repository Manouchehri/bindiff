/*
 * Decompiled with CFR 0_115.
 */
package com.google.security.zynamics.bindiff.gui.tabpanels.projecttabpanel.treenodepanels.charts;

import com.google.security.zynamics.bindiff.gui.tabpanels.projecttabpanel.treenodepanels.charts.BasicBlockMatchesPie3dPanel;
import com.google.security.zynamics.bindiff.gui.tabpanels.projecttabpanel.treenodepanels.charts.BasicBlockMatchesPie3dPanel$1;
import org.jfree.chart.labels.PieToolTipGenerator;
import org.jfree.data.general.PieDataset;

class BasicBlockMatchesPie3dPanel$CustomTooltipGenerator
implements PieToolTipGenerator {
    final /* synthetic */ BasicBlockMatchesPie3dPanel this$0;

    private BasicBlockMatchesPie3dPanel$CustomTooltipGenerator(BasicBlockMatchesPie3dPanel basicBlockMatchesPie3dPanel) {
        this.this$0 = basicBlockMatchesPie3dPanel;
    }

    @Override
    public String generateToolTip(PieDataset pieDataset, Comparable comparable) {
        if (pieDataset == null) return null;
        if (comparable.equals(BasicBlockMatchesPie3dPanel.access$300()[0])) {
            return String.format("%s %d (%.1f%s)", BasicBlockMatchesPie3dPanel.access$300()[0], BasicBlockMatchesPie3dPanel.access$400(this.this$0), BasicBlockMatchesPie3dPanel.access$500(this.this$0), "%");
        }
        if (comparable.equals(BasicBlockMatchesPie3dPanel.access$300()[1])) {
            return String.format("%s %d (%.1f%s)", BasicBlockMatchesPie3dPanel.access$300()[1], BasicBlockMatchesPie3dPanel.access$600(this.this$0), BasicBlockMatchesPie3dPanel.access$700(this.this$0), "%");
        }
        if (!comparable.equals(BasicBlockMatchesPie3dPanel.access$300()[2])) return null;
        return String.format("%s %d (%.1f%s)", BasicBlockMatchesPie3dPanel.access$300()[2], BasicBlockMatchesPie3dPanel.access$800(this.this$0), BasicBlockMatchesPie3dPanel.access$900(this.this$0), "%");
    }

    /* synthetic */ BasicBlockMatchesPie3dPanel$CustomTooltipGenerator(BasicBlockMatchesPie3dPanel basicBlockMatchesPie3dPanel, BasicBlockMatchesPie3dPanel$1 basicBlockMatchesPie3dPanel$1) {
        this(basicBlockMatchesPie3dPanel);
    }
}

