/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package common;

/**
 *
 * @author Admin
 */
public class Captcha {
    public StringBuilder createCaptcha(int size){
        StringBuilder captcha = new StringBuilder();
        String str = "ABCDEFGHIJKLMNOPQRSTUVWXYZ" + "0123456789";
        for (int i=1 ; i < size; i++){
            int number = (int) (Math.random() * str.length() - 1);
            captcha.append(str.charAt(number));
        }
        return captcha;
    }
    
    public boolean checkCaptcha(StringBuilder str, StringBuilder captcha) {
        return str.toString().equals(captcha.toString());
    }
}
