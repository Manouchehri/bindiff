package com.google.security.zynamics.bindiff.gui.tabpanels.viewtabpanel;

import com.google.security.zynamics.zylib.gui.zygraph.realizers.*;
import com.google.security.zynamics.zylib.general.*;
import com.google.security.zynamics.bindiff.graph.listeners.*;
import com.google.security.zynamics.bindiff.gui.dialogs.graphsettings.*;
import com.google.security.zynamics.bindiff.gui.window.*;
import com.google.security.zynamics.bindiff.project.*;
import com.google.common.base.*;
import com.google.security.zynamics.zylib.yfileswrap.gui.zygraph.nodes.*;
import com.google.security.zynamics.bindiff.graph.edges.*;
import com.google.security.zynamics.bindiff.log.*;
import com.google.security.zynamics.zylib.gui.*;
import com.google.security.zynamics.bindiff.exceptions.*;
import com.google.security.zynamics.zylib.gui.zygraph.*;
import com.google.security.zynamics.bindiff.graph.eventhandlers.*;
import java.io.*;
import com.google.security.zynamics.zylib.yfileswrap.gui.zygraph.*;
import com.google.security.zynamics.bindiff.gui.tabpanels.viewtabpanel.subpanels.*;
import com.google.security.zynamics.bindiff.graph.helpers.*;
import java.awt.*;
import com.google.security.zynamics.bindiff.gui.tabpanels.*;
import com.google.security.zynamics.bindiff.project.rawcallgraph.*;
import com.google.security.zynamics.bindiff.gui.tabpanels.projecttabpanel.*;
import com.google.security.zynamics.zylib.disassembly.*;
import com.google.security.zynamics.bindiff.gui.dialogs.printing.*;
import com.google.security.zynamics.bindiff.project.diff.*;
import com.google.security.zynamics.bindiff.gui.dialogs.*;
import com.google.security.zynamics.zylib.gui.ProgressDialogs.*;
import javax.swing.*;
import com.google.security.zynamics.bindiff.gui.dialogs.criteriadialog.*;
import com.google.security.zynamics.bindiff.graph.nodes.*;
import com.google.security.zynamics.bindiff.gui.dialogs.criteriadialog.criterium.*;
import java.util.*;
import com.google.security.zynamics.bindiff.gui.dialogs.criteriadialog.expressionmodel.*;
import com.google.security.zynamics.bindiff.project.rawflowgraph.*;
import com.google.security.zynamics.bindiff.graph.builders.*;
import com.google.security.zynamics.bindiff.graph.*;
import com.google.security.zynamics.bindiff.enums.*;
import com.google.security.zynamics.bindiff.graph.settings.*;
import com.google.security.zynamics.bindiff.io.comments.*;
import java.sql.*;
import com.google.security.zynamics.bindiff.project.matches.*;
import com.google.security.zynamics.bindiff.project.userview.*;
import com.google.security.zynamics.bindiff.database.*;

class ViewTabPanelFunctions$InternalEditableContentListener implements ILabelEditableContentListener
{
    final /* synthetic */ ViewTabPanelFunctions this$0;
    
    private ViewTabPanelFunctions$InternalEditableContentListener(final ViewTabPanelFunctions this$0) {
        this.this$0 = this$0;
    }
    
    @Override
    public void editableContentChanged(final ZyLabelContent zyLabelContent) {
        this.this$0.setCommentsChanged(true);
    }
}
