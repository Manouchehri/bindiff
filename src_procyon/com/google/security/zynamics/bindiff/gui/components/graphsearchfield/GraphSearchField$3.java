package com.google.security.zynamics.bindiff.gui.components.graphsearchfield;

import javax.swing.plaf.basic.*;
import com.google.security.zynamics.zylib.general.*;
import java.awt.event.*;
import com.google.security.zynamics.bindiff.gui.tabpanels.viewtabpanel.*;
import com.google.security.zynamics.zylib.gui.comboboxes.memorybox.*;
import com.google.security.zynamics.zylib.gui.*;
import com.google.common.base.*;
import javax.swing.border.*;
import java.awt.*;
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

class GraphSearchField$3 extends BasicComboBoxEditor
{
    final /* synthetic */ GraphSearchField this$0;
    
    GraphSearchField$3(final GraphSearchField this$0) {
        this.this$0 = this$0;
    }
    
    @Override
    protected JTextField createEditorComponent() {
        return this.this$0.secHexField;
    }
}
