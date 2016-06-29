/*
 * Decompiled with CFR 0_115.
 */
package com.google.security.zynamics.zylib.gui.scripting;

public class ScriptingLanguage
implements Comparable {
    private final String name;
    private final String version;

    public ScriptingLanguage(String string, String string2) {
        this.name = string;
        this.version = string2;
    }

    public int compareTo(ScriptingLanguage scriptingLanguage) {
        return this.name.compareTo(scriptingLanguage.name);
    }

    public String getName() {
        return this.name;
    }

    public String toString() {
        String string = this.name;
        String string2 = this.version;
        return new StringBuilder(1 + String.valueOf(string).length() + String.valueOf(string2).length()).append(string).append(" ").append(string2).toString();
    }
}

