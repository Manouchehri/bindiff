/*
 * Decompiled with CFR 0_115.
 */
package org.ibex.nestedvm;

import org.ibex.nestedvm.Runtime;
import org.ibex.nestedvm.Runtime$SocketFStat;
import org.ibex.nestedvm.Runtime$TerminalFD;

class Runtime$TerminalFD$1
extends Runtime$SocketFStat {
    private final Runtime.TerminalFD this$0;

    Runtime$TerminalFD$1(Runtime.TerminalFD terminalFD) {
        this.this$0 = terminalFD;
    }

    @Override
    public int type() {
        return 8192;
    }

    @Override
    public int mode() {
        return 384;
    }
}

