/*
 * Decompiled with CFR 0_115.
 */
package org.ibex.nestedvm;

import java.io.PrintStream;
import org.ibex.nestedvm.Interpreter;
import org.ibex.nestedvm.Runtime;

public class Interpreter$DebugShutdownHook
implements Runnable {
    private final Interpreter this$0;

    public Interpreter$DebugShutdownHook(Interpreter interpreter) {
        this.this$0 = interpreter;
    }

    @Override
    public void run() {
        int n2 = Interpreter.access$000(this.this$0);
        if (this.this$0.getState() != 0) return;
        System.err.print(new StringBuffer().append("\nCPU Executing ").append(Runtime.toHex(n2)).append(": ").append(this.this$0.sourceLine(n2)).append("\n").toString());
    }
}

