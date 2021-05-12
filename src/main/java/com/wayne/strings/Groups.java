package com.wayne.strings;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import static com.wayne.utils.Print.print;
import static com.wayne.utils.Print.printnb;

/**
 * @author wayne
 */
public class Groups {
    static final String POEM =
            "Twas brillig, and the slithy toves\n" +
                    "Did gyre and gimble in the wabe.\n" +
                    "All mimsy were the borogoves,\n" +
                    "And the mome raths outgrabe.\n\n" +
                    "Beware the Jabberwock, my son,\n" +
                    "The jaws that bite, the claws that catch.\n" +
                    "Beware the Jubjub bird, and shun\n" +
                    "The frumious Bandersnatch.";

    public static void main(String[] args) {
        // ?m表示启用多行模式，多行模式下，^或者$会在行终止符或者输入序列的结尾之后或者之前匹配
        // 本例中表示$在\n之前匹配，捕获每行最后三个词
        String reg = "(?m)(\\S+)\\s+((\\S+)\\s+(\\S+))$";
        Matcher matcher = Pattern.compile(reg).matcher(POEM);
        while (matcher.find()){
            for (int i = 0; i <= matcher.groupCount(); i++) {
                printnb("[" + matcher.group(i) + "]");
                print();
            }
        }

    }
}

        /*
        单词A空格单词B空格单词C 为一个小组，组0
        单词A 组1
        单词B空格单词C 组2
        单词B 组3
        单词C 组4
        输出：
        [the slithy toves]
        [the]
        [slithy toves]
        [slithy]
        [toves]
        [in the wabe.]
        [in]
        [the wabe.]
        [the]
        [wabe.]
        [were the borogoves,]
        [were]
        [the borogoves,]
        [the]
        [borogoves,]
        [mome raths outgrabe.]
        [mome]
        [raths outgrabe.]
        [raths]
        [outgrabe.]
        [Jabberwock, my son,]
        [Jabberwock,]
        [my son,]
        [my]
        [son,]
        [claws that catch.]
        [claws]
        [that catch.]
        [that]
        [catch.]
        [bird, and shun]
        [bird,]
        [and shun]
        [and]
        [shun]
        [The frumious Bandersnatch.]
        [The]
        [frumious Bandersnatch.]
        [frumious]
        [Bandersnatch.]*/
