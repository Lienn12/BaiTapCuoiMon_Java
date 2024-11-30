
package Combobox;

import javax.swing.JComboBox;


public class ComboboxSuggestion<E> extends JComboBox<Object>{
    public ComboboxSuggestion(){
        setUI(new ComboSuggestionUI());
    }
}
