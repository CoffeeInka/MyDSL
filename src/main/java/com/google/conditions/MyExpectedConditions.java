package com.google.conditions;

public class MyExpectedConditions {

        public static Condition nthElementText(int index, String text){
            return new NthElementText(index, text);
        }
    }
