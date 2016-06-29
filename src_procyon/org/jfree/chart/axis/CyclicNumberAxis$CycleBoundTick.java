package org.jfree.chart.axis;

import org.jfree.ui.*;

public class CyclicNumberAxis$CycleBoundTick extends NumberTick
{
    public boolean mapToLastCycle;
    
    public CyclicNumberAxis$CycleBoundTick(final boolean mapToLastCycle, final Number n, final String s, final TextAnchor textAnchor, final TextAnchor textAnchor2, final double n2) {
        super(n, s, textAnchor, textAnchor2, n2);
        this.mapToLastCycle = mapToLastCycle;
    }
}
