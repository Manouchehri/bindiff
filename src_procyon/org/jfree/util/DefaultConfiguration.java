package org.jfree.util;

import org.jfree.base.config.*;
import java.util.*;

public class DefaultConfiguration extends Properties implements ModifiableConfiguration
{
    public String getConfigProperty(final String s) {
        return this.getProperty(s);
    }
    
    public String getConfigProperty(final String s, final String s2) {
        return this.getProperty(s, s2);
    }
    
    public Iterator findPropertyKeys(final String s) {
        final TreeSet<String> set = new TreeSet<String>();
        final Enumeration<String> keys = ((Hashtable<String, V>)this).keys();
        while (keys.hasMoreElements()) {
            final String s2 = keys.nextElement();
            if (s2.startsWith(s) && !set.contains(s2)) {
                set.add(s2);
            }
        }
        return Collections.unmodifiableSet((Set<?>)set).iterator();
    }
    
    public Enumeration getConfigProperties() {
        return this.keys();
    }
    
    public void setConfigProperty(final String s, final String s2) {
        if (s2 == null) {
            this.remove(s);
        }
        else {
            this.setProperty(s, s2);
        }
    }
}
