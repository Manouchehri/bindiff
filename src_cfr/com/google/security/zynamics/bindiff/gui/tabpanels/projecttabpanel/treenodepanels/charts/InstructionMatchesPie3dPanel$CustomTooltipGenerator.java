/*
 * Decompiled with CFR 0_115.
 */
package com.google.security.zynamics.bindiff.gui.tabpanels.projecttabpanel.treenodepanels.charts;

import com.google.security.zynamics.bindiff.gui.tabpanels.projecttabpanel.treenodepanels.charts.InstructionMatchesPie3dPanel;
import com.google.security.zynamics.bindiff.gui.tabpanels.projecttabpanel.treenodepanels.charts.InstructionMatchesPie3dPanel$1;
import org.jfree.chart.labels.PieToolTipGenerator;
import org.jfree.data.general.PieDataset;

class InstructionMatchesPie3dPanel$CustomTooltipGenerator
implements PieToolTipGenerator {
    final /* synthetic */ InstructionMatchesPie3dPanel this$0;

    private InstructionMatchesPie3dPanel$CustomTooltipGenerator(InstructionMatchesPie3dPanel instructionMatchesPie3dPanel) {
        this.this$0 = instructionMatchesPie3dPanel;
    }

    @Override
    public String generateToolTip(PieDataset pieDataset, Comparable comparable) {
        String string = null;
        if (pieDataset == null) return string;
        if (comparable.equals(InstructionMatchesPie3dPanel.access$300()[0])) {
            return String.format("%s %d (%.1f%s)", InstructionMatchesPie3dPanel.access$300()[0], InstructionMatchesPie3dPanel.access$400(this.this$0), InstructionMatchesPie3dPanel.access$500(this.this$0), "%");
        }
        if (comparable.equals(InstructionMatchesPie3dPanel.access$300()[1])) {
            return String.format("%s %d (%.1f%s)", InstructionMatchesPie3dPanel.access$300()[1], InstructionMatchesPie3dPanel.access$600(this.this$0), InstructionMatchesPie3dPanel.access$700(this.this$0), "%");
        }
        if (!comparable.equals(InstructionMatchesPie3dPanel.access$300()[2])) return string;
        return String.format("%s %d (%.1f%s)", InstructionMatchesPie3dPanel.access$300()[2], InstructionMatchesPie3dPanel.access$800(this.this$0), InstructionMatchesPie3dPanel.access$900(this.this$0), "%");
    }

    /* synthetic */ InstructionMatchesPie3dPanel$CustomTooltipGenerator(InstructionMatchesPie3dPanel instructionMatchesPie3dPanel, InstructionMatchesPie3dPanel$1 instructionMatchesPie3dPanel$1) {
        this(instructionMatchesPie3dPanel);
    }
}

