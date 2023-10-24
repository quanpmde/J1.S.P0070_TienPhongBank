/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package common;

import java.util.Scanner;

/**
 *
 * @author Admin
 */
public class Validation {
    public String inputNumber(String title, String error){
        String s = "";
        while (s.isEmpty() || s.length()!=10 || s.length() == 10 && s.matches("[^\\d]+")){
            Scanner sc = new Scanner(System.in);
            System.out.println(title + ":");
            s = sc.nextLine();
            if (s.length()!=10){
                System.out.println(error);
            }
            else if(s.matches("[^\\d]+")){
                System.out.println(error);
            }
        }
        return s;
    }
    
    public String inputPassword(String title, String error){
        String s = "";
        while (s.isEmpty() || s.length()<8 || s.length()>31 
                || s.length()>=8 && s.length()<=31 && s.matches("(?=.*\\D)(?=.*\\d).*")){
            Scanner sc = new Scanner(System.in);
            System.out.println(title + ":");
            s = sc.nextLine();
            if (s.length()<8 || s.length()>31){
                System.out.println(error);
            }
            else if(s.matches("(?=.*\\D)(?=.*\\d).*")){
                System.out.println(error);
            }
        }
        return s;
    }
    
    public StringBuilder inputCaptcha(String title, String error, StringBuilder checkCode){
        Captcha captcha = new Captcha();
        while (true){
            StringBuilder s = new StringBuilder();
            String str;
            Scanner sc = new Scanner(System.in);
            System.out.println(title + ":");
            str = sc.nextLine();
            s.append(str);
            if(!captcha.checkCaptcha(s, checkCode)){
                System.out.println(error);
                continue;
            }
            return s;
        }
    }
}
