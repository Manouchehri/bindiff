/*
 * Decompiled with CFR 0_115.
 */
package com.google.security.zynamics.bindiff.gui.tabpanels.projecttabpanel.treenodepanels.charts;

import com.google.security.zynamics.bindiff.gui.tabpanels.projecttabpanel.treenodepanels.charts.BasicBlockMatchesPie3dPanel;
import com.google.security.zynamics.bindiff.gui.tabpanels.projecttabpanel.treenodepanels.charts.BasicBlockMatchesPie3dPanel$1;
import java.text.AttributedString;
import org.jfree.chart.labels.PieSectionLabelGenerator;
import org.jfree.data.general.PieDataset;

class BasicBlockMatchesPie3dPanel$CustomLabelGenerator
implements PieSectionLabelGenerator {
    final /* synthetic */ BasicBlockMatchesPie3dPanel this$0;

    private BasicBlockMatchesPie3dPanel$CustomLabelGenerator(BasicBlockMatchesPie3dPanel basicBlockMatchesPie3dPanel) {
        this.this$0 = basicBlockMatchesPie3dPanel;
    }

    @Override
    public AttributedString generateAttributedSectionLabel(PieDataset pieDataset, Comparable comparable) {
        return null;
    }

    @Override
    public String generateSectionLabel(PieDataset pieDataset, Comparable comparable) {
        String string = null;
        if (pieDataset == null) return string;
        if (comparable.equals(BasicBlockMatchesPie3dPanel.access$300()[0])) {
            return String.format("%d\n%.1f%s", BasicBlockMatchesPie3dPanel.access$400(this.this$0), BasicBlockMatchesPie3dPanel.access$500(this.this$0), "%");
        }
        if (comparable.equals(BasicBlockMatchesPie3dPanel.access$300()[1])) {
            return String.format("%d\n%.1f%s", BasicBlockMatchesPie3dPanel.access$600(this.this$0), BasicBlockMatchesPie3dPanel.access$700(this.this$0), "%");
        }
        if (!comparable.equals(BasicBlockMatchesPie3dPanel.access$300()[2])) return string;
        return String.format("%d\n%.1f%s", BasicBlockMatchesPie3dPanel.access$800(this.this$0), BasicBlockMatchesPie3dPanel.access$900(this.this$0), "%");
    }

    /* synthetic */ BasicBlockMatchesPie3dPanel$CustomLabelGenerator(BasicBlockMatchesPie3dPanel basicBlockMatchesPie3dPanel, BasicBlockMatchesPie3dPanel$1 basicBlockMatchesPie3dPanel$1) {
        this(basicBlockMatchesPie3dPanel);
    }
}

