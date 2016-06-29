package y.f.k;

class Y {
   private y.d.t a;
   private y.d.t b;
   private double c;

   Y() {
   }

   Y(Y var1, double var2) {
      this.c = var2;
      this.a = var1.a;
      this.b = var1.b;
   }

   Y(y.d.t var1) {
      this.a = var1;
   }

   void a(y.d.t var1) {
      if(this.a == null) {
         this.a = var1;
      } else if(!this.a.equals(var1)) {
         if(this.b != null) {
            throw new IllegalStateException("RoutingBound still has two points assigned");
         } else {
            this.b = var1;
         }
      }
   }

   Y a(double var1) {
      return new Y(this, var1);
   }

   boolean a() {
      return this.a != null;
   }

   double b() {
      return this.c() - this.d();
   }

   double c() {
      return this.b == null?this.a.a() + this.c:Math.max(this.a.a() + this.c, this.b.a() + this.c);
   }

   double d() {
      return this.b == null?this.a.a() - this.c:Math.min(this.a.a() - this.c, this.b.a() - this.c);
   }

   double e() {
      return this.f() - this.g();
   }

   double f() {
      return this.b == null?this.a.b() + this.c:Math.max(this.a.b() + this.c, this.b.b() + this.c);
   }

   double g() {
      return this.b == null?this.a.b() - this.c:Math.min(this.a.b() - this.c, this.b.b() - this.c);
   }

   public boolean equals(Object var1) {
      if(this == var1) {
         return true;
      } else if(var1 != null && this.getClass() == var1.getClass()) {
         Y var2 = (Y)var1;
         if(this.a != null) {
            if(!this.a.equals(var2.a)) {
               return false;
            }
         } else if(var2.a != null) {
            return false;
         }

         if(this.b != null) {
            if(this.b.equals(var2.b)) {
               return true;
            }
         } else if(var2.b == null) {
            return true;
         }

         return false;
      } else {
         return false;
      }
   }

   public int hashCode() {
      int var1 = this.a != null?this.a.hashCode():0;
      var1 = 29 * var1 + (this.b != null?this.b.hashCode():0);
      return var1;
   }

   public String toString() {
      return "RoutingBound{point0=" + this.a + ", point1=" + this.b + " | width=" + this.b() + ", height=" + this.e() + "}";
   }
}
