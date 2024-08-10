package solve_string_math;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;


public class SOL3613_STRING {

    // 시간 제한 1초
    // 문자열의 최대 길이 100
    // 100 * 100 = 10000 , O(n^2) 알고리즘도 사용 가능

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder stringBuilder = new StringBuilder();

        String str = bufferedReader.readLine();

        // java , c++ 형식이 아닌 case
        // Error!

        // _ A

        // case 분류하기
        // 1. 첫 문자가 대문자인 경우 Ab
        // 2. 맨 처음에 _ 가 오는 경우 _ab
        // 3. 맨 마지막에 _가 오는 경우 ab_
        // 4. c++ case 에서 대문자가 오는 경우 a_Aa
        // 5. 중간에 _ 가 연속으로 2개 이상 오는 경우 a__b

//        if (str.charAt(0) == Character.toUpperCase(str.charAt(0))) {
//            System.out.println("Error!");
//            return;
//        } else if (str.charAt(0) == '_') {
//            System.out.println("Error!");
//            return;
//        } else if (str.charAt(str.length()-1) == '_') {
//            System.out.println("Error!");
//            return;
//        } else if (str.indexOf('_') != -1) {
//            for (int i=0; i < str.length(); i++) {
//                if (str.charAt(i) == Character.toUpperCase(str.charAt(i)) && str.charAt(i) != '_') {
//                    System.out.println("Error!");
//                    return;
//                }
//            }
//
//            for (int i=0; i < str.length()-1; i++) {
//                if (str.charAt(i) == '_' && str.charAt(i+1) == '_') {
//                    System.out.println("Error!");
//                    return;
//                }
//            }
//
//        }

        // 위 조건문 코드 중복 제거

        if (Character.isUpperCase(str.charAt(0)) || str.charAt(0) == '_' || str.charAt(str.length() - 1) == '_') {
            System.out.println("Error!");
            return;
        }

        boolean hasUnderscore = str.indexOf('_') != -1;
        for (int i = 0; i < str.length(); i++) {
            char current = str.charAt(i);

            if (Character.isUpperCase(current) && hasUnderscore) {
                System.out.println("Error!");
                return;
            }

            if (current == '_' && i < str.length() - 1 && str.charAt(i + 1) == '_') {
                System.out.println("Error!");
                return;
            }
        }



        // java -> 알파벳으로만 이루어짐 , 첫 단어는 소문자
        // c++ -> 소문자로만 이루어짐 , 단어 사이에 _
        if (str.indexOf('_') == -1) {
            // java -> c++
            for (int i=0; i < str.length(); i++) {
                if (Character.toUpperCase(str.charAt(i)) == str.charAt(i)) {
                    // 대문자 이면
                    stringBuilder.append('_').append(Character.toLowerCase(str.charAt(i)));
                } else {
                    stringBuilder.append(str.charAt(i));
                }
            }

        } else {
            // c++ -> java
            for (int i=0; i < str.length(); i++) {
                if (str.charAt(i) == '_') {
                    // 마지막에 _가 오는 케이스는 위에서 걸러짐
                    stringBuilder.append(Character.toUpperCase(str.charAt(i+1)));
                    i++;
                } else {
                    stringBuilder.append(str.charAt(i));
                }
            }
        }

        System.out.println(stringBuilder);

    }
}
