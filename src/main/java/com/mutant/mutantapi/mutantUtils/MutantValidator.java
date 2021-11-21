package com.mutant.mutantapi.mutantUtils;

public class MutantValidator {
    public static boolean isValidAdn(String[] dna) {
        int size = dna.length;
        if (size < 4) return false;
        for (String line : dna) {
            if (line.length() != size) return false;
        }
        return true;
    }
}
