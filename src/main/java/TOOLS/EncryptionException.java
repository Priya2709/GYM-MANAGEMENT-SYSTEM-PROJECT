/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package TOOLS;

/**
 *
 * @author rajay
 */
public class EncryptionException extends Exception {

    /**
     *
     * @param e
     */
    public EncryptionException(Exception e) {
        System.out.println(e.getLocalizedMessage());
    }

}
