package de.tum.in.ase.eist;

import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.List;

@Service
public class QueryProcessor {

    public String process(String query) {
		query = query.toLowerCase();
        if (query.contains("shakespeare")) {
            return "William Shakespeare (26 April 1564 - 23 April 1616) was an " +
                    "English poet, playwright, and actor, widely regarded as the greatest " +
                    "writer in the English language and the world's pre-eminent dramatist.";
        } else if (query.contains("name")) {
           return "Dalia";
        } else { // TODO extend the programm here
            String[] crap = {":", ",", "?"};
            for (String replace : crap) {
                query = query.replace(replace, " ").trim();
            }
            String[] values = query.split(" ");

            int[] iValues = new int[values.length];
            for (int index = 0; index < values.length; index++) {

                String sValue = values[index];
                iValues[index] = Integer.parseInt(values[index].trim());
            }
            if (query.contains("which of the following numbers is the largest:")) {

                int max = Arrays.stream(iValues).max().getAsInt();
                System.out.println(max);

            }
            else if(query.contains("plus")) {
                int sum = iValues[0]+iValues[1];
            System.out.println(sum);

            }
            else if(query.contains("multiplied")) {
                int product = iValues[0]*iValues[1];
                System.out.println(product);
            }
            else if(query.contains("cube")) {

            }


        }
        return query;
    }
}
