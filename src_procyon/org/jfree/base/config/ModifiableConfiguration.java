package org.jfree.base.config;

import org.jfree.util.*;
import java.util.*;

public interface ModifiableConfiguration extends Configuration
{
    void setConfigProperty(final String p0, final String p1);
    
    Enumeration getConfigProperties();
    
    Iterator findPropertyKeys(final String p0);
}
