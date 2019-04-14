package com.wajahat.hackerrank.string.problems;

/**
 * Class Find the difference between two strings
 *
 * oldStr = abcxyz newStr = abcXXxyz, Result(3, 0, 2) at position 3, 2 characters XX is inserted
 * oldStr = abcXXxyz newStr = abcxyz, Result(3, 2, 0) at position 2, 2 characters XX is deleted
 * oldStr = abcXYZTpqr newStr = abcMNOpqr, Result(3, 4, 3) at position 3, 4 chars are replaced by 3 chars
 * oldStr = aa newStr = bb, Result(0, 2, 2) at position 0 2 chars replaced with 2 chars
 * oldStr = abcxyz, newStr = abcxyz, Result(0, 0, 0) both the strings are same
 * Created by wajahat
 */
public class StringDiff {

    private static class Result {
        int position;
        int len_old;
        int len_new;
    }

    Result detect(String oldStr, String newStr) {
        char [] os = oldStr.toCharArray();
        char [] ns = newStr.toCharArray();
        Result result = new Result();

        int l1 = 0;
        int h1 = os.length-1;

        int l2 = 0;
        int h2 = ns.length-1;

        while (l1 < h1 && l2 < h2) {
            if (os[l1] == ns[l2] && os[l2] == ns[h2]) {
                l1++;
                h1--;
                l2++;
                h2--;
            } else {
                break;
            }
        }
        // inserted
        if (l2 < h2) {
            result.position = l2;
            result.len_old = 0;
            result.len_new = h2 - l2 + 1;
        } else if (l1 < h1) { // deleted
            result.position = l1;
            result.len_old = h1 - l1 + 1;
            result.len_new = 0;
        } else if (l1 > h1 && l2 > h2) { //both strings are equal
            result.position = 0;
            result.len_old = 0;
            result.len_new = 0;
        } else if (l1 == 0 && l2 == 0){ // both strings are completely different
            result.position = 0;
            result.len_old = h1 + 1;
            result.len_new = h2 + 1;
        }



        return result;
    }
}
