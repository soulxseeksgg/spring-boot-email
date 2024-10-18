package com.example.training.email.util;

import org.passay.CharacterRule;
import org.passay.EnglishCharacterData;
import org.passay.PasswordGenerator;

import java.util.Arrays;
import java.util.List;

public class SecurityUtil {
    public static String generateToken(){
        List<CharacterRule> rules = Arrays.asList(

                new CharacterRule(EnglishCharacterData.UpperCase, 5),
                new CharacterRule(EnglishCharacterData.LowerCase, 5),
                new CharacterRule(EnglishCharacterData.Digit, 5),
                new CharacterRule(EnglishCharacterData.Special, 5)
        );

        PasswordGenerator generator = new PasswordGenerator();
        String password = generator.generatePassword(20, rules);

        return password;
    }
}
