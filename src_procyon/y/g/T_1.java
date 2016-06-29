package y.g;

import y.c.*;

final class T implements h
{
    double[] a;
    int[] b;
    boolean[] c;
    Object[] d;
    
    T(final double[] a, final int[] b, final boolean[] c, final Object[] d) {
        this.a = a;
        this.b = b;
        this.c = c;
        this.d = d;
    }
    
    public Object b(final Object o) {
        try {
            return this.d[((d)o).b()];
        }
        catch (ClassCastException ex) {
            throw new IllegalArgumentException("Argument must be of type Edge.");
        }
        catch (NullPointerException ex2) {
            if (o == null) {
                throw new IllegalArgumentException("Argument must be non-null.");
            }
            if (o instanceof d && ((d)o).a() == null) {
                throw new IllegalArgumentException("Argument is not in graph");
            }
            throw new UnsupportedOperationException("Cannot get Object from this type of Map!");
        }
    }
    
    public double c(final Object o) {
        try {
            return this.a[((d)o).b()];
        }
        catch (ClassCastException ex) {
            throw new IllegalArgumentException("Argument must be of type Edge.");
        }
        catch (NullPointerException ex2) {
            if (o == null) {
                throw new IllegalArgumentException("Argument must be non-null.");
            }
            if (o instanceof d && ((d)o).a() == null) {
                throw new IllegalArgumentException("Argument is not in graph");
            }
            throw new UnsupportedOperationException("Cannot get double from this type of Map!");
        }
    }
    
    public int a(final Object o) {
        try {
            return this.b[((d)o).b()];
        }
        catch (ClassCastException ex) {
            throw new IllegalArgumentException("Argument must be of type Edge.");
        }
        catch (NullPointerException ex2) {
            if (o == null) {
                throw new IllegalArgumentException("Argument must be non-null.");
            }
            if (o instanceof d && ((d)o).a() == null) {
                throw new IllegalArgumentException("Argument is not in graph");
            }
            throw new UnsupportedOperationException("Cannot get int from this type of Map!");
        }
    }
    
    public boolean d(final Object o) {
        try {
            return this.c[((d)o).b()];
        }
        catch (ClassCastException ex) {
            throw new IllegalArgumentException("Argument must be of type Edge.");
        }
        catch (NullPointerException ex2) {
            if (o == null) {
                throw new IllegalArgumentException("Argument must be non-null.");
            }
            if (o instanceof d && ((d)o).a() == null) {
                throw new IllegalArgumentException("Argument is not in graph");
            }
            throw new UnsupportedOperationException("Cannot get boolean from this type of Map!");
        }
    }
    
    public void a(final Object o, final Object o2) {
        try {
            this.d[((d)o).b()] = o2;
        }
        catch (ClassCastException ex) {
            throw new IllegalArgumentException("Key must be of type Edge.");
        }
        catch (NullPointerException ex2) {
            if (o == null) {
                throw new IllegalArgumentException("Key must be non-null.");
            }
            if (o instanceof d && ((d)o).a() == null) {
                throw new IllegalArgumentException("Key is not in graph");
            }
            throw new UnsupportedOperationException("Cannot set Object in this type of Map!");
        }
    }
    
    public void a(final Object o, final double n) {
        try {
            this.a[((d)o).b()] = n;
        }
        catch (ClassCastException ex) {
            throw new IllegalArgumentException("Key must be of type Edge.");
        }
        catch (NullPointerException ex2) {
            if (o == null) {
                throw new IllegalArgumentException("Key must be non-null.");
            }
            if (o instanceof d && ((d)o).a() == null) {
                throw new IllegalArgumentException("Key is not in graph");
            }
            throw new UnsupportedOperationException("Cannot set double in this type of Map!");
        }
    }
    
    public void a(final Object o, final int n) {
        try {
            this.b[((d)o).b()] = n;
        }
        catch (ClassCastException ex) {
            throw new IllegalArgumentException("Key must be of type Edge.");
        }
        catch (NullPointerException ex2) {
            if (o == null) {
                throw new IllegalArgumentException("Key must be non-null.");
            }
            if (o instanceof d && ((d)o).a() == null) {
                throw new IllegalArgumentException("Key is not in graph");
            }
            throw new UnsupportedOperationException("Cannot set int in this type of Map!");
        }
    }
    
    public void a(final Object o, final boolean b) {
        try {
            this.c[((d)o).b()] = b;
        }
        catch (ClassCastException ex) {
            throw new IllegalArgumentException("Key must be of type Edge.");
        }
        catch (NullPointerException ex2) {
            if (o == null) {
                throw new IllegalArgumentException("Key must be non-null.");
            }
            if (o instanceof d && ((d)o).a() == null) {
                throw new IllegalArgumentException("Key is not in graph");
            }
            throw new UnsupportedOperationException("Cannot set boolean in this type of Map!");
        }
    }
}
