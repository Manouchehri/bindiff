/*
 * Decompiled with CFR 0_115.
 */
package org.jfree.util;

import java.io.PrintStream;
import java.io.Serializable;
import org.jfree.util.LogTarget;

public class PrintStreamLogTarget
implements Serializable,
LogTarget {
    private static final long serialVersionUID = 6510564403264504688L;
    private PrintStream printStream;

    public PrintStreamLogTarget() {
        this(System.out);
    }

    public PrintStreamLogTarget(PrintStream printStream) {
        if (printStream == null) {
            throw new NullPointerException();
        }
        this.printStream = printStream;
    }

    @Override
    public void log(int n2, Object object) {
        if (n2 > 3) {
            n2 = 3;
        }
        this.printStream.print(LogTarget.LEVELS[n2]);
        this.printStream.println(object);
        if (n2 >= 3) return;
        System.out.flush();
    }

    @Override
    public void log(int n2, Object object, Exception exception) {
        if (n2 > 3) {
            n2 = 3;
        }
        this.printStream.print(LogTarget.LEVELS[n2]);
        this.printStream.println(object);
        exception.printStackTrace(this.printStream);
        if (n2 >= 3) return;
        System.out.flush();
    }
}

