/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Scrollbar;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.JScrollBar;

public class ScrollBarCustom extends JScrollBar{
    private Color originalColor; 
    public ScrollBarCustom() {
        setUI(new ModernScrollBarUI());
        setPreferredSize(new Dimension(8, 8));
        setForeground(new Color(240,240,240));
        setBackground(Color.WHITE);
        originalColor = getForeground();
        addMouseListener(new MouseAdapter() {
            @Override
            public void mouseEntered(MouseEvent e) {
                setForeground(new Color(158, 158, 158)); 
            }

            @Override
            public void mouseExited(MouseEvent e) {
                setForeground(new Color(240,240,240)); 
            }
        });
    }
}
