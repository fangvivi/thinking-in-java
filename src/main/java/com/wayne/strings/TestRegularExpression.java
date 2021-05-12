package com.wayne.strings;

import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import static com.wayne.utils.Print.print;

/**
 * 正则表达式应用于字符串时，可以产生很多状态，以便在匹配失败的时候可以回溯
 * @author wayne
 */
public class TestRegularExpression {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("type a String: ");
        String str = scanner.next();
        print("Input: \"" + str + "\"");
        System.out.print("type a regular expression: ");
        while (scanner.hasNext()){
            String reg = scanner.next();
            if("q".equals(reg)){
                scanner.close();
                System.exit(0);
            }
            print("Regular expression: \"" + reg + "\"");
            Pattern p = Pattern.compile(reg);
            Matcher m = p.matcher(str);
            while(m.find()) {
                print("Match \"" + m.group() + "\" at positions " +
                        m.start() + "-" + (m.end() - 1));
            }
            System.out.print("type a regular expression: ");
        }
        scanner.close();
    }
    /*
    输出：
    type a String: abcabcabcdefabc
    Input: "abcabcabcdefabc"
    type a regular expression: abcabcabcdefabc
    Regular expression: "abcabcabcdefabc"
    Match "abcabcabcdefabc" at positions 0-14
    type a regular expression: abc+
    Regular expression: "abc+"
    Match "abc" at positions 0-2
    Match "abc" at positions 3-5
    Match "abc" at positions 6-8
    Match "abc" at positions 12-14
    type a regular expression: (abc)+ 贪婪型，匹配满足模式所需的最多字符数
    Regular expression: "(abc)+"
    Match "abcabcabc" at positions 0-8
    Match "abc" at positions 12-14
    type a regular expression: (abc)+? 勉强型，匹配满足模式所需的最新少字符数
    Regular expression: "(abc)+?"
    Match "abc" at positions 0-2
    Match "abc" at positions 3-5
    Match "abc" at positions 6-8
    Match "abc" at positions 12-14
    type a regular expression: (abc)++ 占有型，只在Java语言中有，可以防止回溯，防止正则表达式失控
    Regular expression: "(abc)++"  执行起来更有效率
    Match "abcabcabc" at positions 0-8
    Match "abc" at positions 12-14
    type a regular expression: (abc){2,}
    Regular expression: "(abc){2,}"
    Match "abcabcabc" at positions 0-8
    type a regular expression: (abc){2,}+
    Regular expression: "(abc){2,}+"
    Match "abcabcabc" at positions 0-8
    type a regular expression: q
    */
}
