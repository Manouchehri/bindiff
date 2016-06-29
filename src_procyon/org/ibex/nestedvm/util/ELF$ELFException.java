package org.ibex.nestedvm.util;

import java.io.*;

public class ELF$ELFException extends IOException
{
    private final ELF this$0;
    
    ELF$ELFException(final ELF this$0, final String s) {
        super(s);
        this.this$0 = this$0;
    }
}
