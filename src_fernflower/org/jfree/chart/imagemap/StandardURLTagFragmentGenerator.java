package org.jfree.chart.imagemap;

import org.jfree.chart.imagemap.URLTagFragmentGenerator;

public class StandardURLTagFragmentGenerator implements URLTagFragmentGenerator {
   public String generateURLFragment(String var1) {
      return " href=\"" + var1 + "\"";
   }
}
