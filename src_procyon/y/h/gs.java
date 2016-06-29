package y.h;

import java.lang.reflect.*;
import java.io.*;

public class gs implements aX, bs, fd, hf
{
    private final byte a;
    
    public gs(final byte a) {
        this.a = a;
    }
    
    public Object a(final fj fj, final Object o, final fj fj2) {
        return this.a(o);
    }
    
    protected Object a(final Object o) {
        if (o == null) {
            return null;
        }
        try {
            if (o instanceof Cloneable) {
                final Method method = o.getClass().getMethod("clone", (Class<?>[])null);
                if (Modifier.isPublic(method.getModifiers())) {
                    return method.invoke(o, (Object[])null);
                }
            }
        }
        catch (InvocationTargetException ex) {
            final Throwable targetException = ex.getTargetException();
            if (targetException instanceof RuntimeException) {
                throw (RuntimeException)targetException;
            }
        }
        catch (NoSuchMethodException ex2) {}
        catch (IllegalAccessException ex3) {}
        switch (this.a) {
            default: {
                throw new IllegalArgumentException("Cloning failed.");
            }
            case 0: {
                return o;
            }
            case 1: {
                return null;
            }
        }
    }
    
    public Object a(final fj fj, final ObjectInputStream objectInputStream) {
        return this.a(objectInputStream);
    }
    
    protected Object a(final ObjectInputStream objectInputStream) {
        try {
            return objectInputStream.readObject();
        }
        catch (ClassNotFoundException ex) {
            if (this.a == 1) {
                return null;
            }
            throw new IOException(ex.getMessage());
        }
    }
    
    public void a(final fj fj, final Object o, final ObjectOutputStream objectOutputStream) {
        this.a(o, objectOutputStream);
    }
    
    protected void a(final Object o, final ObjectOutputStream objectOutputStream) {
        if (o == null || o instanceof Serializable) {
            objectOutputStream.writeObject(o);
            if (!fj.z) {
                return;
            }
        }
        if (this.a == 2) {
            throw new IOException("Could not write userData.");
        }
        objectOutputStream.writeObject(null);
    }
    
    public void a(final aB ab, final Object o, final ObjectOutputStream objectOutputStream) {
        this.a(o, objectOutputStream);
    }
    
    public Object a(final aB ab, final ObjectInputStream objectInputStream) {
        return this.a(objectInputStream);
    }
    
    public Object a(final aB ab, final Object o, final aB ab2) {
        return this.a(o);
    }
    
    public void a(final gZ gz, final Object o, final ObjectOutputStream objectOutputStream) {
        this.a(o, objectOutputStream);
    }
    
    public Object a(final gZ gz, final ObjectInputStream objectInputStream) {
        return this.a(objectInputStream);
    }
    
    public Object a(final gZ gz, final Object o, final gZ gz2) {
        return this.a(o);
    }
    
    public Object a(final eU eu, final Object o, final eU eu2) {
        return this.a(o);
    }
}
