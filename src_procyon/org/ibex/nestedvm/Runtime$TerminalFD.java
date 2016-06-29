package org.ibex.nestedvm;

import java.io.*;

class Runtime$TerminalFD extends Runtime$InputOutputStreamFD
{
    public Runtime$TerminalFD(final InputStream inputStream) {
        this(inputStream, null);
    }
    
    public Runtime$TerminalFD(final OutputStream outputStream) {
        this(null, outputStream);
    }
    
    public Runtime$TerminalFD(final InputStream inputStream, final OutputStream outputStream) {
        super(inputStream, outputStream);
    }
    
    public void _close() {
    }
    
    public Runtime$FStat _fstat() {
        return new Runtime$TerminalFD$1(this);
    }
}
