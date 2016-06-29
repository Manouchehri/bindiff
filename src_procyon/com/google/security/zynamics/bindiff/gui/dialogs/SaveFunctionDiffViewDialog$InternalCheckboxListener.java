package com.google.security.zynamics.bindiff.gui.dialogs;

import java.awt.event.*;
import com.google.security.zynamics.bindiff.enums.*;
import com.google.security.zynamics.bindiff.gui.components.*;
import javax.swing.event.*;
import com.google.security.zynamics.bindiff.gui.window.*;
import com.google.security.zynamics.bindiff.project.diff.*;
import com.google.common.base.*;
import com.google.security.zynamics.zylib.system.*;
import com.google.security.zynamics.zylib.io.*;
import com.google.security.zynamics.bindiff.project.matches.*;
import java.awt.*;
import javax.swing.border.*;
import javax.swing.*;
import com.google.security.zynamics.bindiff.config.*;
import com.google.security.zynamics.bindiff.project.*;
import com.google.security.zynamics.zylib.gui.ProgressDialogs.*;
import com.google.security.zynamics.bindiff.log.*;
import com.google.security.zynamics.bindiff.gui.tabpanels.*;
import com.google.security.zynamics.bindiff.utils.*;
import java.util.*;
import com.google.security.zynamics.zylib.gui.*;
import java.io.*;

class SaveFunctionDiffViewDialog$InternalCheckboxListener implements ActionListener
{
    final /* synthetic */ SaveFunctionDiffViewDialog this$0;
    
    private SaveFunctionDiffViewDialog$InternalCheckboxListener(final SaveFunctionDiffViewDialog this$0) {
        this.this$0 = this$0;
    }
    
    @Override
    public void actionPerformed(final ActionEvent actionEvent) {
        if ((actionEvent.getSource() == this.this$0.primaryExportOverwrite && this.this$0.primaryExportOverwrite.isSelected()) || (actionEvent.getSource() == this.this$0.secondaryExportOverwrite && this.this$0.secondaryExportOverwrite.isSelected())) {
            MessageBox.showWarning(this.this$0, String.format("There is already a '%s' file with different content existing!\nIf you choose override make sure that the new and the existing disassembly are\nstructurally identical, e.g. only comments have been added or modified. Otherwise,\nexisting older saved views may not be loadable anymore!", this.this$0.getExportBinaryTargetFile((actionEvent.getSource() == this.this$0.primaryExportOverwrite) ? ESide.PRIMARY : ESide.SECONDARY).getName()));
        }
    }
}
