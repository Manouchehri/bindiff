package y.f.k;

import y.f.k.P;
import y.f.k.V;
import y.f.k.Y;

class X extends V {
   X() {
      super((P)null);
   }

   X(P var1, P var2) {
      super(var2);
      Y var3 = new Y();
      var3.a(new y.d.t(var1.f(), var1.g()));
      var3.a(new y.d.t(var1.e(), var1.d()));
      this.a(var3);
      var3 = new Y();
      var3.a(new y.d.t(var2.f(), var2.g()));
      var3.a(new y.d.t(var2.e(), var2.d()));
      this.a(var3);
   }
}
