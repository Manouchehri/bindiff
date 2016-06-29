package org.jfree.chart.editor;

import org.jfree.chart.JFreeChart;
import org.jfree.chart.editor.ChartEditor;
import org.jfree.chart.editor.ChartEditorFactory;
import org.jfree.chart.editor.DefaultChartEditorFactory;

public class ChartEditorManager {
   static ChartEditorFactory factory = new DefaultChartEditorFactory();

   public static ChartEditorFactory getChartEditorFactory() {
      return factory;
   }

   public static void setChartEditorFactory(ChartEditorFactory var0) {
      if(var0 == null) {
         throw new IllegalArgumentException("Null \'f\' argument.");
      } else {
         factory = var0;
      }
   }

   public static ChartEditor getChartEditor(JFreeChart var0) {
      return factory.createEditor(var0);
   }
}
