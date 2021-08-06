package com.wayne.strings.exercise;

import com.wayne.strings.Splitting;

/**
 ****************** Exercise 9 ******************
 * Using the documentation for java.util.regex.Pattern
 * as a resource, replace all the vowels（元音） in
 * Splitting.knights with underscores.
 ***********************************************
 * @author wayne
 */
public class StringsExercise9 {
    public static void main(String[] args) {
        // （？i）表示大小写不敏感
        String reg = "(?i)[aeiou]";
        String reg1 = "[aeiou]";
        String s = Splitting.knights.replaceAll(reg, "_");
        System.out.println(s);
        /*
        输出：
        Th_n, wh_n y__ h_v_ f__nd th_ shr_bb_ry, y__ m_st c_t d_wn
        th_ m_ght__st tr__ _n th_ f_r_st... w_th... _ h_rr_ng!*/
    }
}
