package org.jfree.util;

import java.io.*;

public class PrintStreamLogTarget implements Serializable, LogTarget
{
    private static final long serialVersionUID = 6510564403264504688L;
    private PrintStream printStream;
    
    public PrintStreamLogTarget() {
        this(System.out);
    }
    
    public PrintStreamLogTarget(final PrintStream printStream) {
        if (printStream == null) {
            throw new NullPointerException();
        }
        this.printStream = printStream;
    }
    
    public void log(int n, final Object o) {
        if (n > 3) {
            n = 3;
        }
        this.printStream.print(LogTarget.LEVELS[n]);
        this.printStream.println(o);
        if (n < 3) {
            System.out.flush();
        }
    }
    
    public void log(int n, final Object o, final Exception ex) {
        if (n > 3) {
            n = 3;
        }
        this.printStream.print(LogTarget.LEVELS[n]);
        this.printStream.println(o);
        ex.printStackTrace(this.printStream);
        if (n < 3) {
            System.out.flush();
        }
    }
}
