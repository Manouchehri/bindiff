package y.e;

import y.h.*;
import java.io.*;

public abstract class c
{
    public static int a;
    
    public abstract void a(final bu p0, final OutputStream p1);
    
    public void a(final bu bu, final String s) {
        final FileOutputStream fileOutputStream = new FileOutputStream(s);
        try {
            this.a(bu, fileOutputStream);
        }
        finally {
            if (fileOutputStream != null) {
                fileOutputStream.flush();
                fileOutputStream.close();
            }
        }
    }
}
