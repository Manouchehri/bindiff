/*
 * Decompiled with CFR 0_115.
 */
package org.ibex.nestedvm;

import java.io.InputStream;
import java.io.OutputStream;
import org.ibex.nestedvm.Runtime$FStat;
import org.ibex.nestedvm.Runtime$InputOutputStreamFD;
import org.ibex.nestedvm.Runtime$TerminalFD$1;

class Runtime$TerminalFD
extends Runtime$InputOutputStreamFD {
    public Runtime$TerminalFD(InputStream inputStream) {
        this(inputStream, null);
    }

    public Runtime$TerminalFD(OutputStream outputStream) {
        this(null, outputStream);
    }

    public Runtime$TerminalFD(InputStream inputStream, OutputStream outputStream) {
        super(inputStream, outputStream);
    }

    @Override
    public void _close() {
    }

    @Override
    public Runtime$FStat _fstat() {
        return new Runtime$TerminalFD$1(this);
    }
}

