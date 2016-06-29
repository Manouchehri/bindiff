package com.google.security.zynamics.zylib.gui.scripting.console;

import java.awt.event.*;
import javax.script.*;
import java.util.*;
import com.google.security.zynamics.zylib.gui.*;
import java.awt.*;
import javax.swing.border.*;
import com.google.security.zynamics.zylib.io.*;
import java.io.*;
import com.google.security.zynamics.zylib.gui.scripting.*;
import com.google.common.base.*;
import javax.swing.text.*;
import javax.swing.*;
import com.google.security.zynamics.zylib.gui.ProgressDialogs.*;
import com.google.security.zynamics.zylib.general.*;

class ConsolePane$InterpreterKeyListener$InternalScriptRunner$1 extends Thread
{
    final /* synthetic */ ConsolePane$InterpreterKeyListener$InternalScriptRunner this$2;
    
    ConsolePane$InterpreterKeyListener$InternalScriptRunner$1(final ConsolePane$InterpreterKeyListener$InternalScriptRunner this$2) {
        this.this$2 = this$2;
    }
    
    @Override
    public void run() {
        try {
            this.this$2.this$1.this$0.engine.eval(this.this$2.this$1.this$0.buffered);
        }
        catch (ScriptException ex) {
            this.this$2.this$1.this$0.getOutputPane().setText(ex.getLocalizedMessage());
            this.this$2.quitProperly = false;
        }
        final Iterator iterator = this.this$2.listeners.iterator();
        while (iterator.hasNext()) {
            iterator.next().finished();
        }
    }
}
