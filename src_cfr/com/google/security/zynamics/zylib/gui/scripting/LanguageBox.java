/*
 * Decompiled with CFR 0_115.
 */
package com.google.security.zynamics.zylib.gui.scripting;

import com.google.security.zynamics.zylib.gui.scripting.ScriptingLanguage;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import javax.script.ScriptEngineFactory;
import javax.script.ScriptEngineManager;
import javax.swing.ComboBoxModel;
import javax.swing.JComboBox;

public class LanguageBox
extends JComboBox {
    public LanguageBox(ScriptEngineManager scriptEngineManager) {
        this.fillLanguageBox(scriptEngineManager);
    }

    private void fillLanguageBox(ScriptEngineManager scriptEngineManager) {
        List<ScriptEngineFactory> list = scriptEngineManager.getEngineFactories();
        ArrayList<ScriptingLanguage> arrayList = new ArrayList<ScriptingLanguage>();
        for (ScriptEngineFactory object2 : list) {
            if (!object2.getLanguageName().equals("python")) continue;
            arrayList.add(new ScriptingLanguage(object2.getLanguageName(), object2.getLanguageVersion()));
        }
        Collections.sort(arrayList);
        Iterator iterator = arrayList.iterator();
        while (iterator.hasNext()) {
            ScriptingLanguage scriptingLanguage = (ScriptingLanguage)iterator.next();
            this.addItem(scriptingLanguage);
        }
    }

    public String getSelectedLanguage() {
        if (this.getSelectedItem() == null) return null;
        String string = ((ScriptingLanguage)this.getSelectedItem()).getName();
        return string;
    }

    public void setSelectedLanguage(String string) {
        int n2 = 0;
        while (n2 < this.getModel().getSize()) {
            String string2 = ((ScriptingLanguage)this.getItemAt(n2)).toString();
            if (string2.equals(string)) {
                this.setSelectedIndex(n2);
                return;
            }
            ++n2;
        }
    }
}

