package org.jfree.data.statistics;

import org.jfree.data.category.*;
import java.util.*;

public interface BoxAndWhiskerCategoryDataset extends CategoryDataset
{
    Number getMeanValue(final int p0, final int p1);
    
    Number getMeanValue(final Comparable p0, final Comparable p1);
    
    Number getMedianValue(final int p0, final int p1);
    
    Number getMedianValue(final Comparable p0, final Comparable p1);
    
    Number getQ1Value(final int p0, final int p1);
    
    Number getQ1Value(final Comparable p0, final Comparable p1);
    
    Number getQ3Value(final int p0, final int p1);
    
    Number getQ3Value(final Comparable p0, final Comparable p1);
    
    Number getMinRegularValue(final int p0, final int p1);
    
    Number getMinRegularValue(final Comparable p0, final Comparable p1);
    
    Number getMaxRegularValue(final int p0, final int p1);
    
    Number getMaxRegularValue(final Comparable p0, final Comparable p1);
    
    Number getMinOutlier(final int p0, final int p1);
    
    Number getMinOutlier(final Comparable p0, final Comparable p1);
    
    Number getMaxOutlier(final int p0, final int p1);
    
    Number getMaxOutlier(final Comparable p0, final Comparable p1);
    
    List getOutliers(final int p0, final int p1);
    
    List getOutliers(final Comparable p0, final Comparable p1);
}
