package com.google.security.zynamics.bindiff.gui.components.graphsearchfield;

import javax.swing.plaf.metal.*;
import com.google.security.zynamics.zylib.general.*;
import java.awt.event.*;
import com.google.security.zynamics.bindiff.gui.tabpanels.viewtabpanel.*;
import com.google.security.zynamics.zylib.gui.comboboxes.memorybox.*;
import java.awt.*;
import com.google.security.zynamics.zylib.gui.*;
import com.google.common.base.*;
import javax.swing.border.*;
import javax.swing.*;
import com.google.security.zynamics.bindiff.enums.*;
import com.google.security.zynamics.zylib.yfileswrap.gui.zygraph.nodes.*;
import com.google.security.zynamics.bindiff.graph.nodes.*;
import com.google.security.zynamics.zylib.yfileswrap.gui.zygraph.edges.*;
import com.google.security.zynamics.bindiff.graph.edges.*;
import com.google.security.zynamics.bindiff.graph.searchers.*;
import com.google.security.zynamics.bindiff.graph.*;
import java.util.*;
import com.google.security.zynamics.bindiff.utils.*;
import com.google.security.zynamics.bindiff.resources.*;

final class GraphSearchField$CEditorBorder extends AbstractBorder
{
    final /* synthetic */ GraphSearchField this$0;
    
    private GraphSearchField$CEditorBorder(final GraphSearchField this$0) {
        this.this$0 = this$0;
    }
    
    @Override
    public Insets getBorderInsets(final Component component) {
        return GraphSearchField.BORDER_INSETS;
    }
    
    @Override
    public void paintBorder(final Component component, final Graphics graphics, final int n, final int n2, final int n3, final int n4) {
        graphics.translate(n, n2);
        this.this$0.activeIcon.paintIcon(component, graphics, n + 4, n2 + 5);
        graphics.setColor(MetalLookAndFeel.getControlDarkShadow());
        graphics.drawRect(0, 0, n3, n4 - 1);
        graphics.setColor(MetalLookAndFeel.getControlShadow());
        graphics.drawRect(1, 1, n3 - 2, n4 - 3);
        graphics.translate(-n, -n2);
    }
}
