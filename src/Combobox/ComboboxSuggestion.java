
package Combobox;

import javax.swing.JComboBox;


public class ComboboxSuggestion<T> extends JComboBox<T>{
    public ComboboxSuggestion(){
        setUI(new ComboSuggestionUI());
    }
}
