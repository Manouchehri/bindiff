package com.google.security.zynamics.bindiff.gui.dialogs.criteriadialog;

import java.awt.event.*;
import com.google.security.zynamics.bindiff.gui.dialogs.*;
import com.google.security.zynamics.bindiff.gui.dialogs.criteriadialog.expressionmodel.*;
import com.google.security.zynamics.bindiff.gui.dialogs.criteriadialog.expressiontree.*;
import com.google.security.zynamics.bindiff.gui.dialogs.criteriadialog.expressiontree.nodes.*;
import javax.swing.tree.*;
import java.util.*;
import javax.swing.border.*;
import javax.swing.*;
import java.awt.*;
import com.google.security.zynamics.zylib.gui.*;

class CriteriaDialog$InternalOkCancelButttonListener implements ActionListener
{
    final /* synthetic */ CriteriaDialog this$0;
    
    private CriteriaDialog$InternalOkCancelButttonListener(final CriteriaDialog this$0) {
        this.this$0 = this$0;
    }
    
    @Override
    public void actionPerformed(final ActionEvent actionEvent) {
        this.this$0.selectNodes = actionEvent.getActionCommand().equals("Execute");
        this.this$0.dispose();
    }
}
