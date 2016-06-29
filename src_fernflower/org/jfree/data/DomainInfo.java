package org.jfree.data;

import org.jfree.data.Range;

public interface DomainInfo {
   double getDomainLowerBound(boolean var1);

   double getDomainUpperBound(boolean var1);

   Range getDomainBounds(boolean var1);
}
