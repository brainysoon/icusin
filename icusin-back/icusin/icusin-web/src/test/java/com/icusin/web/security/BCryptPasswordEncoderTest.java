package com.icusin.web.security;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

/**
 * copyright icusin.com
 *
 * @author brainysoon
 * @create 2017-09-20 下午7:33
 */
public class BCryptPasswordEncoderTest {
    private static BCryptPasswordEncoderTest ourInstance = new BCryptPasswordEncoderTest();

    public static BCryptPasswordEncoderTest getInstance() {
        return ourInstance;
    }

    private BCryptPasswordEncoderTest() {
    }

    public static void main(String[] args) {

        System.out.println(getInstance().encodePassword("123"));
    }

    public String encodePassword(String password) {

        BCryptPasswordEncoder bCryptPasswordEncoder = new BCryptPasswordEncoder();
        return bCryptPasswordEncoder.encode(password);
    }
}
