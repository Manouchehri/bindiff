package y.g;

import java.util.Comparator;
import y.g.av;

final class aw implements Comparator {
   private aw() {
   }

   public int compare(Object var1, Object var2) {
      return ((Comparable)var1).compareTo(var2);
   }

   aw(av var1) {
      this();
   }
}
