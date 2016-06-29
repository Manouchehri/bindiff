package org.jfree.util;

import java.io.*;
import java.util.*;

public interface Configuration extends Serializable, Cloneable
{
    String getConfigProperty(final String p0);
    
    String getConfigProperty(final String p0, final String p1);
    
    Iterator findPropertyKeys(final String p0);
    
    Enumeration getConfigProperties();
    
    Object clone();
}
