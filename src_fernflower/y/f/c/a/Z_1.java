package y.f.c.a;

public final class Z {
   public static final Z a = new Z((byte)-1);
   static final Z b = new Z((byte)0);
   static final Z c = new Z((byte)1);
   static final Z d = new Z((byte)4);
   static final Z e = new Z((byte)6);
   static final Z f = new Z((byte)5);
   final byte g;

   private Z(byte var1) {
      this.g = var1;
   }

   public byte a() {
      return this.g;
   }
}
