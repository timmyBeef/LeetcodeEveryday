package hackerrank;
/*
    https://www.hackerrank.com/challenges/repeated-string/problem?h_l=interview&playlist_slugs%5B%5D=interview-preparation-kit&playlist_slugs%5B%5D=warmup


 */
public class RepeatedString {
    static long repeatedString(String s, long n) {
        int count = 0;
        int len = s.length();
        for(char c : s.toCharArray()) {
            if(c == 'a') count++;
        }
        long totalCount = count * (n/len);
        long remainder = n%len; //notice here

        for(int i = 0 ; i < remainder ; i++) {
            if(s.charAt(i) == 'a') totalCount++;
        }

        return totalCount;
    }
}
