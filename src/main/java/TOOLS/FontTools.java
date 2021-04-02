/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package TOOLS;

import java.awt.Font;
import java.awt.font.TextAttribute;
import java.util.Map;
import javax.swing.JComponent;

/**
 *
 * @author rajay
 */
public class FontTools {

    public static JComponent formatFont(JComponent component, int underLine, int size) {
        Font font = component.getFont();
        Map attributes = font.getAttributes();
        attributes.put(TextAttribute.UNDERLINE, underLine);
        attributes.put(TextAttribute.SIZE, size);
        component.setFont(font.deriveFont(attributes));
        return component;

    }
}
