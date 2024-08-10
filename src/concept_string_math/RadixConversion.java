package concept_string_math;

public class RadixConversion {
    public static void main(String[] args) {
        int number = 5;

        // 10진수 -> 다른 진수
        // Integer 클래스의 진법에 맞는 메서드 활용
        decimalToBinary(number); // 101
        decimalToOctal(number); // 5
        decimalToHexadecimal(number); // 5

        // 다른 진수 -> 10진수
        // Integer.parseInt
        // 2번째 인수는 생략 가능 , default는 10
        radixToDecimal("11101",2); // 29
        radixToDecimal("35", 8); // 29
        radixToDecimal("1D", 16); // 29


        // 직접 구현
        decimalToBinaryDirect(number);
        binaryToDecimalDirect("1101"); // 13

    }

    // 10진수 -> 2진수
    public static void decimalToBinary(int number) {
        String binaryString = Integer.toBinaryString(number);
        System.out.println("2진수 : " + binaryString);
    }

    // 10진수 -> 8진수
    public static void decimalToOctal(int number) {
        String octalString = Integer.toOctalString(number);
        System.out.println("8진수 : " + octalString);
    }

    // 10진수 -> 16진수
    public static void decimalToHexadecimal(int number) {
        String hexadecimalString = Integer.toHexString(number);
        System.out.println("16진수 : " + hexadecimalString);
    }

    // 2진수 -> 10진수
    public static void radixToDecimal(String binaryString, int radix) {
        int decimal = Integer.parseInt(binaryString, radix);
        System.out.println("10진수 : " + decimal);
    }

    // 10진수 -> 2진수 직접 변환
    public static void decimalToBinaryDirect(int number) {

        StringBuilder stringBuilder = new StringBuilder();

        while (number > 0) {
            // 2로 나눈 나머지를 계속 문자열의 처음 위치에 삽입한다.
            stringBuilder.insert(0, number % 2);
            number = number / 2;
        }

        System.out.println("2진수 " + stringBuilder.toString());
    }

    // 2진수 -> 10진수 직접 변환
    public static void binaryToDecimalDirect(String binaryString) {
       int decimalValue = 0;

       for (int i=0; i < binaryString.length(); i++) {
           // (binaryString.charAt(i)-'0') -> 해당 위치의 문자를 정수로 리턴 by 아스키 코드
           // 해당 문자열을 정순으로 처리해도 문제가 되지 않는 이유는
           // 2진수는 제곱근의 성질 때문에 역순 , 정순 중 편한 방식을 차용하면 된다.

           decimalValue = decimalValue*2 + (binaryString.charAt(i)-'0');
       }

        System.out.println("10진수 " + decimalValue);
    }

}
