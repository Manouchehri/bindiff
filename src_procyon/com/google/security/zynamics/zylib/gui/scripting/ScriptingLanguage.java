package com.google.security.zynamics.zylib.gui.scripting;

public class ScriptingLanguage implements Comparable
{
    private final String name;
    private final String version;
    
    public ScriptingLanguage(final String name, final String version) {
        this.name = name;
        this.version = version;
    }
    
    public int compareTo(final ScriptingLanguage scriptingLanguage) {
        return this.name.compareTo(scriptingLanguage.name);
    }
    
    public String getName() {
        return this.name;
    }
    
    @Override
    public String toString() {
        final String name = this.name;
        final String version = this.version;
        return new StringBuilder(1 + String.valueOf(name).length() + String.valueOf(version).length()).append(name).append(" ").append(version).toString();
    }
}
