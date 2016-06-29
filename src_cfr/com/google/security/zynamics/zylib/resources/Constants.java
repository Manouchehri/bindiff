/*
 * Decompiled with CFR 0_115.
 */
package com.google.security.zynamics.zylib.resources;

import java.util.ResourceBundle;

public class Constants {
    public static final String OK;
    public static final String CANCEL;
    public static final String OK2;
    public static final String CANCEL2;
    public static final String MENU_FILE;
    public static final String MENU_CLOSE_ACTIVE_TAB;
    public static final String MENU_OPEN_NEW_TAB;
    public static final String MENU_LOAD_SCRIPT;
    public static final String MENU_SAVE_SCRIPT;
    public static final String MENU_SAVE_SCRIPT_AS;
    public static final String MENU_EXECUTE_SCRIPT;
    public static final String MENU_EXECUTE_AGAIN_SCRIPT;
    public static final String MESSAGE_RUNNING_SCRIPT;
    public static final String MENU_EDIT;
    public static final String MENU_EDIT_UNDO;
    public static final String MENU_EDIT_REDO;
    public static final String MENU_EDIT_CUT;
    public static final String MENU_EDIT_COPY;
    public static final String MENU_EDIT_PASTE;
    public static final String MENU_SCRIPTING_CONSOLE;
    public static final String COLOR_CHOOSER;
    public static final String RGB;
    public static final String RED;
    public static final String GREEN;
    public static final String BLUE;
    public static final String PREVIEW;
    public static final String HIDE_NEVER;
    public static final String HIDE_ALWAYS;
    public static final String THRESHOLD;
    public static final String ASK_FILE_OVERWRITE;

    static {
        ResourceBundle resourceBundle = ResourceBundle.getBundle("com.google.security.zynamics.zylib.resources.Strings");
        OK = resourceBundle.getString("OK");
        CANCEL = resourceBundle.getString("CANCEL");
        OK2 = resourceBundle.getString("OK2");
        CANCEL2 = resourceBundle.getString("CANCEL2");
        PREVIEW = resourceBundle.getString("PREVIEW");
        MENU_FILE = resourceBundle.getString("MENU_FILE");
        MENU_CLOSE_ACTIVE_TAB = resourceBundle.getString("MENU_CLOSE_ACTIVE_TAB");
        MENU_OPEN_NEW_TAB = resourceBundle.getString("MENU_OPEN_NEW_TAB");
        MENU_LOAD_SCRIPT = resourceBundle.getString("MENU_LOAD_SCRIPT");
        MENU_SAVE_SCRIPT = resourceBundle.getString("MENU_SAVE_SCRIPT");
        MENU_SAVE_SCRIPT_AS = resourceBundle.getString("MENU_SAVE_SCRIPT_AS");
        MENU_EXECUTE_SCRIPT = resourceBundle.getString("MENU_EXECUTE_SCRIPT");
        MENU_EXECUTE_AGAIN_SCRIPT = resourceBundle.getString("MENU_EXECUTE_AGAIN_SCRIPT");
        MENU_EDIT = resourceBundle.getString("MENU_EDIT");
        MENU_EDIT_UNDO = resourceBundle.getString("MENU_EDIT_UNDO");
        MENU_EDIT_REDO = resourceBundle.getString("MENU_EDIT_REDO");
        MENU_EDIT_CUT = resourceBundle.getString("MENU_EDIT_CUT");
        MENU_EDIT_COPY = resourceBundle.getString("MENU_EDIT_COPY");
        MENU_EDIT_PASTE = resourceBundle.getString("MENU_EDIT_PASTE");
        MENU_SCRIPTING_CONSOLE = resourceBundle.getString("MENU_SCRIPTING_CONSOLE");
        MESSAGE_RUNNING_SCRIPT = resourceBundle.getString("MESSAGE_RUNNING_SCRIPT");
        COLOR_CHOOSER = resourceBundle.getString("COLOR_CHOOSER");
        RGB = resourceBundle.getString("RGB");
        RED = resourceBundle.getString("RED");
        GREEN = resourceBundle.getString("GREEN");
        BLUE = resourceBundle.getString("BLUE");
        HIDE_NEVER = resourceBundle.getString("HIDE_NEVER");
        HIDE_ALWAYS = resourceBundle.getString("HIDE_ALWAYS");
        THRESHOLD = resourceBundle.getString("THRESHOLD");
        ASK_FILE_OVERWRITE = resourceBundle.getString("ASK_FILE_OVERWRITE");
    }
}

