package com.wayne.strings;

import com.wayne.utils.TextFile;

import java.util.regex.Matcher;

import static com.wayne.utils.Print.print;
import static java.util.regex.Pattern.*;

/**
 * @author wayne
 */
/*! Here's a block of text to use as input to
    the regular expression matcher. Note that we'll
    first extract the block of text by looking for
    the special delimiters, then process the
    extracted block. !*/
public class TheReplacements {
    public static void main(String[] args) {
        String s = TextFile.read("src/main/java/com/wayne/strings/TheReplacements.java");
        // 获取上面那段注释内容 Pattern.DOTALL 表示可以匹配任意字符，包括结束符
        Matcher m = compile("/\\*!(.*)!\\*/", DOTALL).matcher(s);
        if(m.find()){
            /*The number of capturing groups : 1
            不包括group(0),group(0)在这里表示整个输入的字符串
            */
            print("The number of capturing groups : " + m.groupCount());
            // 正则表达式中的组括号发挥作用，把注释符号的开头和结尾去掉，只取句子部分
            s = m.group(1);
            // 因为下面两处都是单词使用replaceAll，所以不需要编译为Pattern，这样可以降低开销
            // 把两个和两个以上的空格替换成一个
            s = s.replaceAll(" {2,}", " ");
            // 去掉每行开头的空格，所以要启用多行模式
            // line with no spaces. Must enable MULTILINE mode:
            s = s.replaceAll("(?m)^ +", "");
            // Here's ——》 H(VOWEL1)re‘s
            s = s.replaceFirst("[aeiou]", "(VOWEL1)");
            print(s);
            StringBuffer sb = new StringBuffer();
            Matcher m1 = compile("[aeiou]").matcher(s);
            /*
            如果不使用循环，只会替换下一处满足匹配条件的地方
            H(VOWEL1)re‘s ——》 H(VOWEL1)rE‘s
            所以，appendReplacement(StringBuffer sb, String replacement)方法的最重要的作用之一就是逐渐替换
            m1.find();
            m1.appendReplacement(sb,m1.group().toUpperCase());
            */
            while (m1.find()){
                // 最终索引结束的位置在"block." c的位置
                // 此处展示了appendReplacement方法的灵活性，可以操作用来替换的字符
                m1.appendReplacement(sb,m1.group().toUpperCase());
            }
            // 如果不使用这个方法，直接输出StringBuffer，"block."的"ck."无法输出
            m1.appendTail(sb);
            print(sb);
        }
    }
}
        /*
        The number of capturing groups : 1
        H(VOWEL1)re's a block of text to use as input to
        the regular expression matcher. Note that we'll
        first extract the block of text by looking for
        the special delimiters, then process the
        extracted block.
        H(VOWEL1)rE's A blOck Of tExt tO UsE As InpUt tO
        thE rEgUlAr ExprEssIOn mAtchEr. NOtE thAt wE'll
        fIrst ExtrAct thE blOck Of tExt by lOOkIng fOr
        thE spEcIAl dElImItErs, thEn prOcEss thE
        ExtrActEd blOck.
        */