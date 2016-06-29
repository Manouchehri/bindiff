package org.jfree.chart.editor;

import org.jfree.chart.*;

public class ChartEditorManager
{
    static ChartEditorFactory factory;
    
    public static ChartEditorFactory getChartEditorFactory() {
        return ChartEditorManager.factory;
    }
    
    public static void setChartEditorFactory(final ChartEditorFactory factory) {
        if (factory == null) {
            throw new IllegalArgumentException("Null 'f' argument.");
        }
        ChartEditorManager.factory = factory;
    }
    
    public static ChartEditor getChartEditor(final JFreeChart freeChart) {
        return ChartEditorManager.factory.createEditor(freeChart);
    }
    
    static {
        ChartEditorManager.factory = new DefaultChartEditorFactory();
    }
}
