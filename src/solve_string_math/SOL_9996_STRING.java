package solve_string_math;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class SOL_9996_STRING {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        String target = br.readLine(); //"aa*bb"

        String[] str = target.split("\\*"); //문자열 나누기 -> String[] str = {"aa","bb"};
        StringBuilder sb = new StringBuilder(); //정답
        for(int i=0; i<n; i++) {
            String word = br.readLine(); //탐색할 문자
            String start = word.substring(0, str[0].length()); //word앞에 문자열
            String end = word.substring(word.length()-str[1].length()); //word뒤에 문자열

            if(word.length()<target.length()-1) {
                sb.append("NE").append("\n");
                continue;
            }

            if(start.equals(str[0]) && end.equals(str[1])) sb.append("DA").append("\n");//만들수있음.
            else sb.append("NE").append("\n");//못만듦.
        }

        System.out.println(sb.toString());
    }
}
