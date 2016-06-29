package org.jfree.ui.about.resources;

import java.util.ListResourceBundle;
import javax.swing.KeyStroke;

public class AboutResources_fr extends ListResourceBundle {
   private static final Object[][] CONTENTS = new Object[][]{{"about-frame.tab.about", "A propos de"}, {"about-frame.tab.system", "Système"}, {"about-frame.tab.contributors", "Développeurs"}, {"about-frame.tab.licence", "Licence"}, {"about-frame.tab.libraries", "Bibliothèque"}, {"contributors-table.column.name", "Nom:"}, {"contributors-table.column.contact", "Contact:"}, {"libraries-table.column.name", "Nom:"}, {"libraries-table.column.version", "Version:"}, {"libraries-table.column.licence", "Licence:"}, {"libraries-table.column.info", "Autre Renseignement:"}, {"system-frame.title", "Propriétés du Système"}, {"system-frame.button.close", "Fermer"}, {"system-frame.menu.file", "Fichier"}, {"system-frame.menu.file.mnemonic", new Character('F')}, {"system-frame.menu.file.close", "Fermer"}, {"system-frame.menu.file.close.mnemonic", new Character('C')}, {"system-frame.menu.edit", "Edition"}, {"system-frame.menu.edit.mnemonic", new Character('E')}, {"system-frame.menu.edit.copy", "Copier"}, {"system-frame.menu.edit.copy.mnemonic", new Character('C')}, {"system-properties-table.column.name", "Nom de la Propriété:"}, {"system-properties-table.column.value", "Valeur:"}, {"system-properties-panel.popup-menu.copy", "Copier"}, {"system-properties-panel.popup-menu.copy.accelerator", KeyStroke.getKeyStroke(67, 2)}};

   public Object[][] getContents() {
      return CONTENTS;
   }
}
