package y.e;

import java.io.*;

public class a extends IOException
{
    public a(final byte b) {
        super("Incompatible version number found : " + b);
    }
    
    public a(final byte b, final byte b2) {
        super("Expected version " + b + " but found : " + b2);
    }
    
    public a() {
    }
    
    public a(final String s) {
        super(s);
    }
}
