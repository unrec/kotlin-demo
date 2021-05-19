package com.unrec.demo;

public class CallKotlin {
    public static void main(String[] args) {
        StringBuilder sb = new StringBuilder("Demo String");
        char lastChar = ExtensionKt.getLastChar(sb);
        System.out.println("lastChar = " + lastChar);
    }
}
