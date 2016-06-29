/*
 * Decompiled with CFR 0_115.
 */
package com.google.security.zynamics.zylib.gui.scripting.console;

import com.google.security.zynamics.zylib.gui.ProgressDialogs.IEndlessProgressListener;
import com.google.security.zynamics.zylib.gui.scripting.console.ConsolePane;
import com.google.security.zynamics.zylib.gui.scripting.console.ConsolePane$InterpreterKeyListener;
import com.google.security.zynamics.zylib.gui.scripting.console.ConsolePane$InterpreterKeyListener$InternalScriptRunner;
import java.util.Iterator;
import javax.script.ScriptException;

class ConsolePane$InterpreterKeyListener$InternalScriptRunner$1
extends Thread {
    final /* synthetic */ ConsolePane$InterpreterKeyListener$InternalScriptRunner this$2;

    ConsolePane$InterpreterKeyListener$InternalScriptRunner$1(ConsolePane$InterpreterKeyListener$InternalScriptRunner internalScriptRunner) {
        this.this$2 = internalScriptRunner;
    }

    @Override
    public void run() {
        try {
            ConsolePane.access$3000(this.this$2.this$1.this$0).eval(ConsolePane.access$1700(this.this$2.this$1.this$0));
        }
        catch (ScriptException var1_1) {
            ConsolePane.access$3100(this.this$2.this$1.this$0).setText(var1_1.getLocalizedMessage());
            ConsolePane$InterpreterKeyListener$InternalScriptRunner.access$3202(this.this$2, false);
        }
        Iterator iterator = ConsolePane$InterpreterKeyListener$InternalScriptRunner.access$3300(this.this$2).iterator();
        while (iterator.hasNext()) {
            IEndlessProgressListener iEndlessProgressListener = (IEndlessProgressListener)iterator.next();
            iEndlessProgressListener.finished();
        }
    }
}

