package org.jfree;

import org.jfree.ui.about.*;

public final class JCommon
{
    public static final ProjectInfo INFO;
    
    public static void main(final String[] array) {
        System.out.println(JCommon.INFO.toString());
    }
    
    static {
        INFO = JCommonInfo.getInstance();
    }
}
