package org.jfree.base.modules;

import org.jfree.util.*;

public class ModuleInitializeException extends StackableException
{
    public ModuleInitializeException() {
    }
    
    public ModuleInitializeException(final String s, final Exception ex) {
        super(s, ex);
    }
    
    public ModuleInitializeException(final String s) {
        super(s);
    }
}
