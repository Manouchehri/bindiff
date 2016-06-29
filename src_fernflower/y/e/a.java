package y.e;

import java.io.IOException;

public class a extends IOException {
   public a(byte var1) {
      super("Incompatible version number found : " + var1);
   }

   public a(byte var1, byte var2) {
      super("Expected version " + var1 + " but found : " + var2);
   }

   public a() {
   }

   public a(String var1) {
      super(var1);
   }
}
