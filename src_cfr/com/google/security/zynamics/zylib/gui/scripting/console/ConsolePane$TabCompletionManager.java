/*
 * Decompiled with CFR 0_115.
 */
package com.google.security.zynamics.zylib.gui.scripting.console;

import com.google.security.zynamics.zylib.gui.scripting.console.ConsolePane;
import com.google.security.zynamics.zylib.gui.scripting.console.ConsolePane$1;

class ConsolePane$TabCompletionManager {
    private int m_completionIndex;
    final /* synthetic */ ConsolePane this$0;

    private ConsolePane$TabCompletionManager(ConsolePane consolePane) {
        this.this$0 = consolePane;
        this.m_completionIndex = 0;
    }

    private String getCompletionCandidate(String[] arrstring, String string, int n2) {
        boolean bl2 = false;
        String[] arrstring2 = arrstring;
        int n3 = arrstring2.length;
        int n4 = 0;
        do {
            if (n4 >= n3) {
                if (!bl2) return null;
                return this.getCompletionCandidate(arrstring, string, n2);
            }
            String string2 = arrstring2[n4];
            if (string2.startsWith(string)) {
                bl2 = true;
                if (n2 == 0) {
                    ++this.m_completionIndex;
                    return string2;
                }
                --n2;
            }
            ++n4;
        } while (true);
    }

    public String getCompletion(String string) {
        return this.getCompletionCandidate(ConsolePane.access$3400(this.this$0).toArray(new String[0]), string, this.m_completionIndex);
    }

    public void reset() {
        this.m_completionIndex = 0;
    }

    /* synthetic */ ConsolePane$TabCompletionManager(ConsolePane consolePane, ConsolePane$1 consolePane$1) {
        this(consolePane);
    }
}

