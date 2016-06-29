package y.a;

public class a extends RuntimeException
{
    public a(final String s) {
        super(s);
    }
    
    public a() {
        this("");
    }
    
    public static void a() {
        a("");
    }
    
    public static void a(final String s) {
        if (Thread.interrupted()) {
            throw new a(s);
        }
    }
}
