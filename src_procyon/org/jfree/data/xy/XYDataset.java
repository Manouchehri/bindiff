package org.jfree.data.xy;

import org.jfree.data.general.*;
import org.jfree.data.*;

public interface XYDataset extends SeriesDataset
{
    DomainOrder getDomainOrder();
    
    int getItemCount(final int p0);
    
    Number getX(final int p0, final int p1);
    
    double getXValue(final int p0, final int p1);
    
    Number getY(final int p0, final int p1);
    
    double getYValue(final int p0, final int p1);
}
