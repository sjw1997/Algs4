package CHAPTER_5_3;

public class Search {
    /** Brute force search.
     *  Search hit, returns the start index of text. Otherwise, return the length of text.
     */
    public static int search(String pat, String text) {
        int M = pat.length(), N = text.length();
        for (int i = 0; i <= N - M; i++) {
            int j;
            for (j = 0; j < M; j++) {
                if (text.charAt(i + j) != pat.charAt(j)) {
                    break;
                }
            }
            if (j == M) {
                return i;
            }
        }
        return N;
    }

    /** Another implementation of brute force search */
    public static int search2(String pat, String text) {
        int j, M = pat.length();
        int i, N = text.length();
        for (i = 0, j = 0; i < N && j < M; i++) {
            if (text.charAt(i) == pat.charAt(j)) {
                j++;
            } else {
                i -= j;
                j = 0;
            }
        }
        if (j == M) {
            return i - M;
        }
        return N;
    }

    public static void main(String[] args) {
        String text = "this is an test";
        String pat = "test";
        int index = search2(pat, text);
        System.out.println(text.substring(index, index + pat.length()));
    }
}
