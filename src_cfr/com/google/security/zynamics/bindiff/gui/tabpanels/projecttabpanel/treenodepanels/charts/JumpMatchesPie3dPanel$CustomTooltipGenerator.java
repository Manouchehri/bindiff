/*
 * Decompiled with CFR 0_115.
 */
package com.google.security.zynamics.bindiff.gui.tabpanels.projecttabpanel.treenodepanels.charts;

import com.google.security.zynamics.bindiff.gui.tabpanels.projecttabpanel.treenodepanels.charts.JumpMatchesPie3dPanel;
import com.google.security.zynamics.bindiff.gui.tabpanels.projecttabpanel.treenodepanels.charts.JumpMatchesPie3dPanel$1;
import org.jfree.chart.labels.PieToolTipGenerator;
import org.jfree.data.general.PieDataset;

class JumpMatchesPie3dPanel$CustomTooltipGenerator
implements PieToolTipGenerator {
    final /* synthetic */ JumpMatchesPie3dPanel this$0;

    private JumpMatchesPie3dPanel$CustomTooltipGenerator(JumpMatchesPie3dPanel jumpMatchesPie3dPanel) {
        this.this$0 = jumpMatchesPie3dPanel;
    }

    @Override
    public String generateToolTip(PieDataset pieDataset, Comparable comparable) {
        String string = null;
        if (pieDataset == null) return string;
        if (comparable.equals(JumpMatchesPie3dPanel.access$300()[0])) {
            return String.format("%s %d (%.1f%s)", JumpMatchesPie3dPanel.access$300()[0], JumpMatchesPie3dPanel.access$400(this.this$0), JumpMatchesPie3dPanel.access$500(this.this$0), "%");
        }
        if (comparable.equals(JumpMatchesPie3dPanel.access$300()[1])) {
            return String.format("%s %d (%.1f%s)", JumpMatchesPie3dPanel.access$300()[1], JumpMatchesPie3dPanel.access$600(this.this$0), JumpMatchesPie3dPanel.access$700(this.this$0), "%");
        }
        if (!comparable.equals(JumpMatchesPie3dPanel.access$300()[2])) return string;
        return String.format("%s %d (%.1f%s)", JumpMatchesPie3dPanel.access$300()[2], JumpMatchesPie3dPanel.access$800(this.this$0), JumpMatchesPie3dPanel.access$900(this.this$0), "%");
    }

    /* synthetic */ JumpMatchesPie3dPanel$CustomTooltipGenerator(JumpMatchesPie3dPanel jumpMatchesPie3dPanel, JumpMatchesPie3dPanel$1 jumpMatchesPie3dPanel$1) {
        this(jumpMatchesPie3dPanel);
    }
}

