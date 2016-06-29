package com.google.security.zynamics.bindiff.gui.window;

import javax.swing.*;
import com.google.common.base.*;
import com.google.security.zynamics.bindiff.project.*;
import java.awt.event.*;
import com.google.security.zynamics.bindiff.config.*;
import com.google.security.zynamics.bindiff.utils.*;
import com.google.security.zynamics.zylib.io.*;
import java.awt.*;
import com.google.security.zynamics.bindiff.gui.tabpanels.*;
import com.google.security.zynamics.bindiff.gui.tabpanels.projecttabpanel.*;
import com.google.security.zynamics.bindiff.gui.tabpanels.detachedviewstabpanel.*;
import com.google.security.zynamics.bindiff.gui.tabpanels.viewtabpanel.*;

class MainWindow$InternalWindowListener$1 implements Runnable
{
    final /* synthetic */ MainWindow$InternalWindowListener this$1;
    
    MainWindow$InternalWindowListener$1(final MainWindow$InternalWindowListener this$1) {
        this.this$1 = this$1;
    }
    
    @Override
    public void run() {
        this.this$1.this$0.controller.exitBinDiff();
    }
}
