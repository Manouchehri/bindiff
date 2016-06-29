package org.jfree.chart.labels;

import org.jfree.data.general.*;
import java.text.*;

public interface PieSectionLabelGenerator
{
    String generateSectionLabel(final PieDataset p0, final Comparable p1);
    
    AttributedString generateAttributedSectionLabel(final PieDataset p0, final Comparable p1);
}
