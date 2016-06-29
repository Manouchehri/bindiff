package org.jfree.data;

import java.util.List;
import org.jfree.data.Values2D;

public interface KeyedValues2D extends Values2D {
   Comparable getRowKey(int var1);

   int getRowIndex(Comparable var1);

   List getRowKeys();

   Comparable getColumnKey(int var1);

   int getColumnIndex(Comparable var1);

   List getColumnKeys();

   Number getValue(Comparable var1, Comparable var2);
}
