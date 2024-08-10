package solve_string_math;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class SOL_20291_3_STRING_TREEMAP {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder stringBuilder = new StringBuilder();
        int n = Integer.parseInt(bufferedReader.readLine());

        Map<String, Integer> extendMap = new HashMap<>();

        String arr[];

        for (int i=0; i < n; i++) {
            arr = bufferedReader.readLine().split("\\.");
            extendMap.put(arr[1], extendMap.getOrDefault(arr[1],0) + 1);
        }

        // 정렬된 상태 유지하기 위해 TreeMap 사용
        // TreeMap 은 key의 값에 따라 자동으로 정렬되는 기능이 있다.

        TreeMap<String, Integer> sortedExtensionsMap = new TreeMap<>(extendMap);

        for (String str : sortedExtensionsMap.keySet()) {
            stringBuilder.append(str).append(" ").append(sortedExtensionsMap.get(str)).append("\n");
        }


        System.out.println(stringBuilder);
    }
}
