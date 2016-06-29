package org.ibex.nestedvm.util;

import java.net.Socket;
import org.ibex.nestedvm.util.Platform$Jdk12;

class Platform$Jdk13 extends Platform$Jdk12 {
   void _socketHalfClose(Socket var1, boolean var2) {
      if(var2) {
         var1.shutdownOutput();
      } else {
         var1.shutdownInput();
      }

   }

   void _socketSetKeepAlive(Socket var1, boolean var2) {
      var1.setKeepAlive(var2);
   }
}
