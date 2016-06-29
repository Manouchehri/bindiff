package com.google.security.zynamics.bindiff.gui.tabpanels.projecttabpanel.treenodepanels.charts;

import javax.swing.*;
import org.jfree.data.general.*;
import com.google.common.base.*;
import com.google.security.zynamics.bindiff.resources.*;
import org.jfree.chart.labels.*;
import java.awt.*;
import com.google.security.zynamics.bindiff.project.diff.*;
import com.google.security.zynamics.bindiff.enums.*;
import com.google.security.zynamics.bindiff.project.matches.*;
import org.jfree.chart.*;

class JumpMatchesPie3dPanel$InternalFlowgraphCachedCountsListener extends DiffChangeAdapter
{
    final /* synthetic */ JumpMatchesPie3dPanel this$0;
    
    private JumpMatchesPie3dPanel$InternalFlowgraphCachedCountsListener(final JumpMatchesPie3dPanel this$0) {
        this.this$0 = this$0;
    }
    
    @Override
    public void jumpsCountChanged() {
        this.this$0.updateDataset();
    }
}
