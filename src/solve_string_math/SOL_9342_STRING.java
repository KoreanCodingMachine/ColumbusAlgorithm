package solve_string_math;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;


public class SOL_9342_STRING {

    // 시간 제한 2초
    // 첫째 줄에 테스트 케이스의 개수 T ≤ 20 이 주어진다. 각 테스트 케이스는 한 줄로 이루어져 있으며,
    // 최대 200개의 알파벳 대문자로 이루어진 문자열이 주어진다.

    // O(N^2) 연산으로도 해결 가능

    public static void main(String[] args) throws IOException {
        // {A,B,C,D,E,F} 중 0개 또는 1개로 시작한다.
        // A가 하나 또는 그 이상 있어야 한다.
        // F가 하나 또는 그 이상 있어야 한다.
        // C가 하나 또는 그 이상 있어야 한다.
        // {A, B, C, D, E, F} 중 0개 또는 1개, 더이상의 문자는 없어야 한다.

        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder stringBuilder = new StringBuilder();
        int n = Integer.parseInt(bufferedReader.readLine());

        for (int i=0; i < n; i++) {
            checkString(bufferedReader.readLine(), stringBuilder);
        }

        System.out.println(stringBuilder);

    }

    public static boolean checkString(String str, StringBuilder stringBuilder) {
        String arr[] = {"A","B","C","D","E","F"};

        String target[] = {"A", "F", "C"};

        // 1. A , B , C , D , E , F 중 1개 또는 0개로 시작
        // 2. 위 중에서 0개로 시작한다면 A가 하나 또는 그 이상 으로 시작

        boolean start = false;

        for (int i=0; i < arr.length; i++) {
            if (str.startsWith(arr[i])) {
                start = true;
            }
        }

        // AFC -> 0개로 시작
        // AAFC -> 0개로 시작 , AA
        // AAFC -> 1개로 시작 , A

        int index = 0;
        if (start) {
            // A B C D E F 중 1개로 시작하는 case
            for (int i=1; i < str.length()-1; i++) {
                String str1 = String.valueOf(str.charAt(i));

                if (str1.equals(target[index])) {
                    continue;
                } else {
                    if (index < target.length-1) {
                        index++;
                    } else {
                        stringBuilder.append("Good\n");
                        return false;
                    }

                    if (str1.equals(target[index])) {
                        continue;
                    } else {
                        stringBuilder.append("Good\n");
                        return false;
                    }
                }
            }

            // 맨 마지막 문자가 arr 중 0개 or 1개
            // 0개라면 C 일 것이고 , 1개라면 A B C D E F 중 1개이다.
            // -> A B C D E F 중 아무거나 한개라도 오면 ok

            boolean last_check = false;
            for (int i=0; i < arr.length; i++) {
                if (String.valueOf(str.charAt(str.length()-1)).equals(arr[i])) {
                    last_check = true;
                    break;
                }
            }

            if (last_check) {
                stringBuilder.append("Infected!\n");
                return true;
            } else {
                stringBuilder.append("Good\n");
                return false;
            }


        } else {
            // A B C D E F 중 0개로 시작하는 case

            // 첫 번째부터 A로 시작해야함
            for (int i=0; i < str.length()-1; i++) {
                String str1 = String.valueOf(str.charAt(i));

                if (str1.equals(target[index])) {
                    continue;
                } else {
                    if (index < target.length-1) {
                        index++;
                    } else {
                        stringBuilder.append("Good\n");
                        return false;
                    }

                    if (str1.equals(target[index])) {
                        continue;
                    } else {
                        stringBuilder.append("Good\n");
                        return false;
                    }
                }
            }

            boolean last_check = false;
            for (int i=0; i < arr.length; i++) {
                if (String.valueOf(str.charAt(str.length()-1)).equals(arr[i])) {
                    last_check = true;
                    break;
                }
            }

            if (last_check) {
                stringBuilder.append("Infected!\n");
                return true;
            } else {
                stringBuilder.append("Good\n");
                return false;
            }

        }

    }
}
