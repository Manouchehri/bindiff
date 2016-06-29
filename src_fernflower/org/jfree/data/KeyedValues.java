package org.jfree.data;

import java.util.List;
import org.jfree.data.Values;

public interface KeyedValues extends Values {
   Comparable getKey(int var1);

   int getIndex(Comparable var1);

   List getKeys();

   Number getValue(Comparable var1);
}
