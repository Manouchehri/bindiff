package com.google.security.zynamics.zylib.resources;

import java.util.*;

public class Constants
{
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
        final ResourceBundle bundle = ResourceBundle.getBundle("com.google.security.zynamics.zylib.resources.Strings");
        OK = bundle.getString("OK");
        CANCEL = bundle.getString("CANCEL");
        OK2 = bundle.getString("OK2");
        CANCEL2 = bundle.getString("CANCEL2");
        PREVIEW = bundle.getString("PREVIEW");
        MENU_FILE = bundle.getString("MENU_FILE");
        MENU_CLOSE_ACTIVE_TAB = bundle.getString("MENU_CLOSE_ACTIVE_TAB");
        MENU_OPEN_NEW_TAB = bundle.getString("MENU_OPEN_NEW_TAB");
        MENU_LOAD_SCRIPT = bundle.getString("MENU_LOAD_SCRIPT");
        MENU_SAVE_SCRIPT = bundle.getString("MENU_SAVE_SCRIPT");
        MENU_SAVE_SCRIPT_AS = bundle.getString("MENU_SAVE_SCRIPT_AS");
        MENU_EXECUTE_SCRIPT = bundle.getString("MENU_EXECUTE_SCRIPT");
        MENU_EXECUTE_AGAIN_SCRIPT = bundle.getString("MENU_EXECUTE_AGAIN_SCRIPT");
        MENU_EDIT = bundle.getString("MENU_EDIT");
        MENU_EDIT_UNDO = bundle.getString("MENU_EDIT_UNDO");
        MENU_EDIT_REDO = bundle.getString("MENU_EDIT_REDO");
        MENU_EDIT_CUT = bundle.getString("MENU_EDIT_CUT");
        MENU_EDIT_COPY = bundle.getString("MENU_EDIT_COPY");
        MENU_EDIT_PASTE = bundle.getString("MENU_EDIT_PASTE");
        MENU_SCRIPTING_CONSOLE = bundle.getString("MENU_SCRIPTING_CONSOLE");
        MESSAGE_RUNNING_SCRIPT = bundle.getString("MESSAGE_RUNNING_SCRIPT");
        COLOR_CHOOSER = bundle.getString("COLOR_CHOOSER");
        RGB = bundle.getString("RGB");
        RED = bundle.getString("RED");
        GREEN = bundle.getString("GREEN");
        BLUE = bundle.getString("BLUE");
        HIDE_NEVER = bundle.getString("HIDE_NEVER");
        HIDE_ALWAYS = bundle.getString("HIDE_ALWAYS");
        THRESHOLD = bundle.getString("THRESHOLD");
        ASK_FILE_OVERWRITE = bundle.getString("ASK_FILE_OVERWRITE");
    }
}
