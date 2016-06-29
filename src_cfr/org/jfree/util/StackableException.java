/*
 * Decompiled with CFR 0_115.
 */
package org.jfree.util;

import java.io.PrintStream;
import java.io.PrintWriter;

public abstract class StackableException
extends Exception {
    private Exception parent;

    public StackableException() {
    }

    public StackableException(String string, Exception exception) {
        super(string);
        this.parent = exception;
    }

    public StackableException(String string) {
        super(string);
    }

    public Exception getParent() {
        return this.parent;
    }

    @Override
    public void printStackTrace(PrintStream printStream) {
        super.printStackTrace(printStream);
        if (this.getParent() == null) return;
        printStream.println("ParentException: ");
        this.getParent().printStackTrace(printStream);
    }

    @Override
    public void printStackTrace(PrintWriter printWriter) {
        super.printStackTrace(printWriter);
        if (this.getParent() == null) return;
        printWriter.println("ParentException: ");
        this.getParent().printStackTrace(printWriter);
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    @Override
    public void printStackTrace() {
        PrintStream printStream = System.err;
        synchronized (printStream) {
            this.printStackTrace(System.err);
            return;
        }
    }
}

