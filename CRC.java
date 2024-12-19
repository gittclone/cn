import java.io.*;
class CRC {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        // Input data and divisor
        System.out.println("Enter data bits: ");
        String data = br.readLine();
        System.out.println("Enter divisor bits: ");
        String divisor = br.readLine();

        // Append zeros to data
        String dividend = data + "0".repeat(divisor.length() - 1);

        // Generate CRC
        String crc = divide(dividend, divisor);
        System.out.println("CRC: " + crc);

        // Transmitted data
        String transmitted = data + crc;
        System.out.println("Transmitted data: " + transmitted);

        // Verify
        System.out.println("Enter received data: ");
        String received = br.readLine();
        String remainder = divide(received, divisor);
        if (remainder.contains("1")) {
            System.out.println("Error detected.");
        } else {
            System.out.println("No error.");
        }
    }

    static String divide(String dividend, String divisor) {
        char[] rem = dividend.toCharArray();
        int n = divisor.length();

        for (int i = 0; i <= dividend.length() - n; i++) {
            if (rem[i] == '1') {
                for (int j = 0; j < n; j++) {
                    rem[i + j] = (rem[i + j] == divisor.charAt(j)) ? '0' : '1';
                }
            }
        }
        return new String(rem).substring(dividend.length() - n + 1);
    }
}
