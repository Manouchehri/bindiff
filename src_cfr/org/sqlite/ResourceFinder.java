/*
 * Decompiled with CFR 0_115.
 */
package org.sqlite;

import java.net.URL;

public class ResourceFinder {
    public static URL find(Class class_, String string) {
        return ResourceFinder.find(class_.getClassLoader(), class_.getPackage(), string);
    }

    public static URL find(ClassLoader classLoader, Package package_, String string) {
        return ResourceFinder.find(classLoader, package_.getName(), string);
    }

    public static URL find(ClassLoader classLoader, String string, String string2) {
        String string3 = ResourceFinder.packagePath(string);
        String string4 = string3 + string2;
        if (string4.startsWith("/")) return classLoader.getResource(string4);
        string4 = "/" + string4;
        return classLoader.getResource(string4);
    }

    private static String packagePath(Class class_) {
        return ResourceFinder.packagePath(class_.getPackage());
    }

    private static String packagePath(Package package_) {
        return ResourceFinder.packagePath(package_.getName());
    }

    private static String packagePath(String string) {
        String string2;
        String string3 = string.replaceAll("\\.", "/");
        if (string3.endsWith("/")) {
            string2 = string3;
            return string2;
        }
        string2 = string3 + "/";
        return string2;
    }
}

