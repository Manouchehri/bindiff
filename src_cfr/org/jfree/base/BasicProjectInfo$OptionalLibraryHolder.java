/*
 * Decompiled with CFR 0_115.
 */
package org.jfree.base;

import java.lang.reflect.Method;
import org.jfree.base.Library;
import org.jfree.util.ObjectUtilities;

class BasicProjectInfo$OptionalLibraryHolder {
    private String libraryClass;
    private transient Library library;

    public BasicProjectInfo$OptionalLibraryHolder(String string) {
        if (string == null) {
            throw new NullPointerException("LibraryClass must not be null.");
        }
        this.libraryClass = string;
    }

    public BasicProjectInfo$OptionalLibraryHolder(Library library) {
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
        if (this.library != null) return this.library;
        this.library = this.loadLibrary(this.libraryClass);
        return this.library;
    }

    protected Library loadLibrary(String string) {
        if (string == null) {
            return null;
        }
        try {
            Class class_ = ObjectUtilities.getClassLoader(this.getClass()).loadClass(string);
            try {
                Method method = class_.getMethod("getInstance", null);
                return (Library)method.invoke(null, null);
            }
            catch (Exception var3_5) {
                return (Library)class_.newInstance();
            }
        }
        catch (Exception var2_3) {
            return null;
        }
    }
}

