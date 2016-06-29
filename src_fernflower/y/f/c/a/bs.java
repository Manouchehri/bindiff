package y.f.c.a;

public class bs {
   private byte a;
   private byte b;
   private byte c;
   private byte d;
   private byte e;

   public bs(byte var1) {
      this.e(var1);
      this.a(var1);
      this.c(var1);
      this.d(var1);
      this.b(var1);
   }

   public byte a() {
      return this.b;
   }

   private boolean f(byte var1) {
      return var1 == 1 || var1 == 0 || var1 == 2;
   }

   public void a(byte var1) {
      if(!this.f(var1)) {
         throw new IllegalArgumentException();
      } else {
         this.b = var1;
      }
   }

   public byte b() {
      return this.d;
   }

   public void b(byte var1) {
      if(!this.f(var1)) {
         throw new IllegalArgumentException();
      } else {
         this.d = var1;
      }
   }

   public byte c() {
      return this.c;
   }

   public void c(byte var1) {
      if(!this.f(var1)) {
         throw new IllegalArgumentException();
      } else {
         this.c = var1;
      }
   }

   public byte d() {
      return this.e;
   }

   public void d(byte var1) {
      if(!this.f(var1)) {
         throw new IllegalArgumentException();
      } else {
         this.e = var1;
      }
   }

   public byte e() {
      return this.a;
   }

   public void e(byte var1) {
      if(!this.f(var1)) {
         throw new IllegalArgumentException();
      } else {
         this.a = var1;
      }
   }
}
