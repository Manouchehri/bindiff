package org.jfree.chart.editor;

import org.jfree.chart.*;

public class DefaultChartEditorFactory implements ChartEditorFactory
{
    public ChartEditor createEditor(final JFreeChart freeChart) {
        return new DefaultChartEditor(freeChart);
    }
}
