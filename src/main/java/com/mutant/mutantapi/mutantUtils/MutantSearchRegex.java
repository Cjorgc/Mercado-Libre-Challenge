package com.mutant.mutantapi.mutantUtils;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;


import java.util.regex.Matcher;
import java.util.regex.Pattern;


@Slf4j
public class MutantSearchRegex {

    private int mutantCount;

    public boolean isMutant(String[] sequences){
        mutantCount = 0;
        return searchHorizontal(sequences) || searchVertical(sequences) || searchOblique(sequences) || searchContraOblique(sequences);
    }

    public boolean search(String sequence){
        Pattern p = Pattern.compile("(C|T|G|A)\\1{3}",Pattern.CASE_INSENSITIVE);
        Matcher m = p.matcher(sequence);
        while(m.find()){
            mutantCount++;
            log.info("Encontrado : " + sequence);
            if(mutantCount >= 2) return true;
        }
        return false;
    }

    public boolean searchHorizontal(String[] sequences){
        for(String e : sequences){
            if( search(e)) return true;
        }
        return false;
    }

    public boolean searchVertical(String[] sequences){
        String sequence = "";
            for(int i = 0 ; i < sequences.length ; i ++){
                for(int j = 0 ; j < sequences.length; j ++){
                    sequence += sequences[j].charAt(i);
                }
                if(search(sequence)) return true;
            sequence = "";
        }
        return false;
    }

    public boolean searchOblique (String[] sequences){
        String sequence = "";
        int height = sequences.length;
        int width = sequences[0].length();
        for (int diagonal = 1 - width; diagonal <= height - 1; diagonal += 1) {
            for (int vertical = Math.max(0, diagonal), horizontal = -Math.min(0, diagonal);
                 vertical < height && horizontal < width; vertical += 1, horizontal += 1) {
                sequence += sequences[vertical].charAt(horizontal) ;
            }
            if(search(sequence)) return true;
            sequence = "";
        }
        return false;
    }

    public boolean searchContraOblique(String[] sequences){
        String sequence = "";
        int height = sequences.length;
        int width = sequences[0].length();
        for (int diagonal = 1 - width; diagonal <= height - 1; diagonal += 1) {
            for (int vertical = Math.max(0, diagonal), horizontal = Math.min(width - 1, diagonal + width-1);
                 vertical < height && horizontal >= 0; vertical += 1, horizontal -= 1) {
                sequence += sequences[vertical].charAt(horizontal) ;
            }
            if(search(sequence)) return true;
            sequence = "";
        }
        return false;
    }
}
