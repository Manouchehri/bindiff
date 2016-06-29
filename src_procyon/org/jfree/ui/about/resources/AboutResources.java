package org.jfree.ui.about.resources;

import java.util.*;
import javax.swing.*;

public class AboutResources extends ListResourceBundle
{
    private static final Object[][] CONTENTS;
    
    public Object[][] getContents() {
        return AboutResources.CONTENTS;
    }
    
    static {
        CONTENTS = new Object[][] { { "about-frame.tab.about", "About" }, { "about-frame.tab.system", "System" }, { "about-frame.tab.contributors", "Developers" }, { "about-frame.tab.licence", "Licence" }, { "about-frame.tab.libraries", "Libraries" }, { "contributors-table.column.name", "Name:" }, { "contributors-table.column.contact", "Contact:" }, { "libraries-table.column.name", "Name:" }, { "libraries-table.column.version", "Version:" }, { "libraries-table.column.licence", "Licence:" }, { "libraries-table.column.info", "Other Information:" }, { "system-frame.title", "System Properties" }, { "system-frame.button.close", "Close" }, { "system-frame.button.close.mnemonic", new Character('C') }, { "system-frame.menu.file", "File" }, { "system-frame.menu.file.mnemonic", new Character('F') }, { "system-frame.menu.file.close", "Close" }, { "system-frame.menu.file.close.mnemonic", new Character('C') }, { "system-frame.menu.edit", "Edit" }, { "system-frame.menu.edit.mnemonic", new Character('E') }, { "system-frame.menu.edit.copy", "Copy" }, { "system-frame.menu.edit.copy.mnemonic", new Character('C') }, { "system-properties-table.column.name", "Property Name:" }, { "system-properties-table.column.value", "Value:" }, { "system-properties-panel.popup-menu.copy", "Copy" }, { "system-properties-panel.popup-menu.copy.accelerator", KeyStroke.getKeyStroke(67, 2) } };
    }
}
