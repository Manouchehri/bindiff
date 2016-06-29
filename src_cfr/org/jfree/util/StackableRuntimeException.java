/*
 * Decompiled with CFR 0_115.
 */
package org.jfree.util;

import java.io.PrintStream;
import java.io.PrintWriter;

public class StackableRuntimeException
extends RuntimeException {
    private Exception parent;

    public StackableRuntimeException() {
    }

    public StackableRuntimeException(String string, Exception exception) {
        super(string);
        this.parent = exception;
    }

    public StackableRuntimeException(String string) {
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
}

