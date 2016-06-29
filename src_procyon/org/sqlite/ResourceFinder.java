package org.sqlite;

import java.net.*;

public class ResourceFinder
{
    public static URL find(final Class clazz, final String s) {
        return find(clazz.getClassLoader(), clazz.getPackage(), s);
    }
    
    public static URL find(final ClassLoader classLoader, final Package package1, final String s) {
        return find(classLoader, package1.getName(), s);
    }
    
    public static URL find(final ClassLoader classLoader, final String s, final String s2) {
        String s3 = packagePath(s) + s2;
        if (!s3.startsWith("/")) {
            s3 = "/" + s3;
        }
        return classLoader.getResource(s3);
    }
    
    private static String packagePath(final Class clazz) {
        return packagePath(clazz.getPackage());
    }
    
    private static String packagePath(final Package package1) {
        return packagePath(package1.getName());
    }
    
    private static String packagePath(final String s) {
        final String replaceAll = s.replaceAll("\\.", "/");
        return replaceAll.endsWith("/") ? replaceAll : (replaceAll + "/");
    }
}
