package org.jfree.util;

public interface ExtendedConfiguration extends Configuration
{
    boolean isPropertySet(final String p0);
    
    int getIntProperty(final String p0);
    
    int getIntProperty(final String p0, final int p1);
    
    boolean getBoolProperty(final String p0);
    
    boolean getBoolProperty(final String p0, final boolean p1);
}
