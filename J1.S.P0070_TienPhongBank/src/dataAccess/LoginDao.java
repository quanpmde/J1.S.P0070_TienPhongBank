/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dataAccess;

import common.Captcha;
import common.Validation;
import java.util.Locale;
import java.util.ResourceBundle;

/**
 *
 * @author Admin
 */
public class LoginDao {

    private static LoginDao instance = null;
    private static Validation valid = new Validation();
    private Captcha captcha = new Captcha();
    private Locale localeEN = new Locale("en");
    private Locale localeVI = new Locale("vi");
    ResourceBundle labels;

    public static LoginDao Instance() {
        if (instance == null) {
            synchronized (LoginDao.class) {
                if (instance == null) {
                    instance = new LoginDao();
                }
            }
        }
        return instance;
    }

    public void login(String language) {
        if ("en".equals(language)){
            labels = ResourceBundle.getBundle("prompt", localeEN);
        }
        else{
            labels = ResourceBundle.getBundle("prompt", localeVI);
        }
        valid.inputNumber(labels.getString("Account_number"), 
                                                labels.getString("Wrong_number"));
        valid.inputPassword(labels.getString("Password"), 
                                            labels.getString("Wrong_password"));
        StringBuilder checkCode = captcha.createCaptcha(6);
        System.out.print(labels.getString("Captcha"));
        System.out.println(": "+checkCode);
        valid.inputCaptcha(labels.getString("TypeCaptcha"),
                                        labels.getString("Wrong_captcha"),checkCode);
        System.out.println(labels.getString("Success"));
    }
}