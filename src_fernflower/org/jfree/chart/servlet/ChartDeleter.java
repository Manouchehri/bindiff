package org.jfree.chart.servlet;

import java.io.File;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.ListIterator;
import javax.servlet.http.HttpSessionBindingEvent;
import javax.servlet.http.HttpSessionBindingListener;

public class ChartDeleter implements Serializable, HttpSessionBindingListener {
   private List chartNames = new ArrayList();

   public void addChart(String var1) {
      this.chartNames.add(var1);
   }

   public boolean isChartAvailable(String var1) {
      return this.chartNames.contains(var1);
   }

   public void valueBound(HttpSessionBindingEvent var1) {
   }

   public void valueUnbound(HttpSessionBindingEvent var1) {
      ListIterator var2 = this.chartNames.listIterator();

      while(var2.hasNext()) {
         String var3 = (String)var2.next();
         File var4 = new File(System.getProperty("java.io.tmpdir"), var3);
         if(var4.exists()) {
            var4.delete();
         }
      }

   }
}
