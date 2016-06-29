package org.jfree.data.statistics;

import org.jfree.data.xy.*;
import java.util.*;

public interface BoxAndWhiskerXYDataset extends XYDataset
{
    Number getMeanValue(final int p0, final int p1);
    
    Number getMedianValue(final int p0, final int p1);
    
    Number getQ1Value(final int p0, final int p1);
    
    Number getQ3Value(final int p0, final int p1);
    
    Number getMinRegularValue(final int p0, final int p1);
    
    Number getMaxRegularValue(final int p0, final int p1);
    
    Number getMinOutlier(final int p0, final int p1);
    
    Number getMaxOutlier(final int p0, final int p1);
    
    List getOutliers(final int p0, final int p1);
    
    double getOutlierCoefficient();
    
    double getFaroutCoefficient();
}
