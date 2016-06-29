package org.jfree.data;

import org.jfree.data.Range;

public interface RangeInfo {
   double getRangeLowerBound(boolean var1);

   double getRangeUpperBound(boolean var1);

   Range getRangeBounds(boolean var1);
}
