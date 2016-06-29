package y.g;

import java.io.*;

public class o
{
    private static String b;
    public static final int a;
    
    public static void a(final int n, final String s) {
        if (o.a >= n) {
            System.out.println(s);
        }
    }
    
    public static void a(final Object o) {
        System.err.println(o);
        if (o instanceof Exception) {
            ((Exception)o).printStackTrace(System.err);
        }
    }
    
    public static void a(final Object o, final Object o2) {
        if (b(o)) {
            System.err.println(o.getClass().getName() + " : " + o2);
        }
    }
    
    public static void a(final Object o, final int n, final Object o2) {
        if (o.a >= n && b(o)) {
            System.err.println(o.getClass().getName() + " : " + o2);
        }
    }
    
    public static boolean b(final Object o) {
        return a(o.getClass().getName());
    }
    
    public static boolean a(final String s) {
        final boolean c = p.c;
        final String b = o.b;
        if (b == null) {
            return false;
        }
        int n = -1;
        int i = b.indexOf(58, n + 1);
        while (true) {
            while (i > n) {
                final String substring = b.substring(n + 1, i);
                final int length = substring.length();
                if (c) {
                    if (length > n + 1) {
                        final String substring2 = b.substring(n + 1, i);
                        if (substring2.length() > 0 && s.startsWith(substring2)) {
                            return true;
                        }
                    }
                    return false;
                }
                if (length > 0 && s.startsWith(substring)) {
                    return true;
                }
                n = i;
                i = b.indexOf(58, n + 1);
                if (c) {
                    break;
                }
            }
            final int length2;
            i = (length2 = b.length());
            continue;
        }
    }
    
    static {
        o.b = null;
        while (true) {
            try {
                while (at.a() != 0L) {
                    if (at.a() < 0L) {
                        System.err.println("yFiles for Java Evaluation Version");
                        break;
                    }
                    final long n = System.currentTimeMillis() / 1000L;
                    if (at.a() - n < 0L) {
                        System.err.println("The evaluation time of yFiles for Java has expired\n");
                        System.exit(1);
                    }
                    else {
                        if (at.b() - n <= 0L) {
                            System.err.println("yFiles for Java: Remaining Evaluation Period: " + (at.a() - n) / 86400L + " days");
                            break;
                        }
                        System.err.println("The evaluation time of yFiles for Java has expired\n");
                        System.exit(1);
                    }
                }
                break;
            }
            catch (RuntimeException ex) {
                System.exit(1);
                continue;
            }
        }
        int int1 = 0;
        try {
            if (System.getProperty("y.debug.level") != null) {
                int1 = Integer.parseInt(System.getProperty("y.debug.level"));
            }
            o.b = System.getProperty("y.debug");
            final String property = System.getProperty("y.debug.file");
            if (property != null) {
                final FileInputStream fileInputStream = new FileInputStream(new File(property));
                final BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(fileInputStream));
                String line;
                while ((line = bufferedReader.readLine()) != null) {
                    if (o.b == null) {
                        o.b = line;
                    }
                    else {
                        o.b = o.b + ":" + line;
                    }
                }
                bufferedReader.close();
                fileInputStream.close();
            }
        }
        catch (Exception ex2) {}
        finally {
            a = int1;
        }
    }
}
