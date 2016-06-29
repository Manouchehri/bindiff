package org.jfree.util;

import java.io.Serializable;
import java.util.Enumeration;
import java.util.Iterator;

public interface Configuration extends Serializable, Cloneable {
   String getConfigProperty(String var1);

   String getConfigProperty(String var1, String var2);

   Iterator findPropertyKeys(String var1);

   Enumeration getConfigProperties();

   Object clone();
}
