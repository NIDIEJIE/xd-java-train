package org.example;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class StringFuncExample {
    public static void main(String[] args) {
        String s = "hello world";
        String modifiedS = s.replace('h','H');
        System.out.println(modifiedS);
        String input = "asdb fg hhmasd asdhtmy ddbfsfss vddfw em";
        String patternString = "\\b\\w{5}\\b";

        int count = countMatches(input, patternString);
        System.out.println("Total matches found: " + count);
        String input2 = "这是一段包含敏感词的文本，例如：敏感词1，敏感词2，敏感词3。";
        String[] sensitiveWords = {"敏感词1", "敏感词2", "敏感词3"};

        String filteredText = filterSensitiveWords(input2, sensitiveWords);
        System.out.println(filteredText);
    }
    public static int countMatches(String input, String patternString) {
        Pattern pattern = Pattern.compile(patternString);
        Matcher matcher = pattern.matcher(input);

        int count = 0;
        while (matcher.find()) {
            count++;
            String match = matcher.group();
            System.out.println("Match found: " + match);
        }

        return count;
    }
    public static String filterSensitiveWords(String text, String[] sensitiveWords) {
        String filteredText = text;
        for (String word : sensitiveWords) {
            String replacement = "*".repeat(word.length());
            filteredText = filteredText.replaceAll(word, replacement);
        }
        return filteredText;
    }
}
