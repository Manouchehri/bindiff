package org.jfree.base;

import org.jfree.util.*;

class BasicProjectInfo$OptionalLibraryHolder
{
    private String libraryClass;
    private transient Library library;
    
    public BasicProjectInfo$OptionalLibraryHolder(final String libraryClass) {
        if (libraryClass == null) {
            throw new NullPointerException("LibraryClass must not be null.");
        }
        this.libraryClass = libraryClass;
    }
    
    public BasicProjectInfo$OptionalLibraryHolder(final Library library) {
        if (library == null) {
            throw new NullPointerException("Library must not be null.");
        }
        this.library = library;
        this.libraryClass = library.getClass().getName();
    }
    
    public String getLibraryClass() {
        return this.libraryClass;
    }
    
    public Library getLibrary() {
        if (this.library == null) {
            this.library = this.loadLibrary(this.libraryClass);
        }
        return this.library;
    }
    
    protected Library loadLibrary(final String s) {
        if (s == null) {
            return null;
        }
        try {
            final Class<?> loadClass = ObjectUtilities.getClassLoader(this.getClass()).loadClass(s);
            try {
                return (Library)loadClass.getMethod("getInstance", (Class<?>[])null).invoke(null, (Object[])null);
            }
            catch (Exception ex) {
                return loadClass.newInstance();
            }
        }
        catch (Exception ex2) {
            return null;
        }
    }
}
