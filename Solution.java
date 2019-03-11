import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;


class Result {

    /*
     * Complete the 'pickingNumbers' function below.
     *
     * The function is expected to return an INTEGER.
     * The function accepts INTEGER_ARRAY a as parameter.
     */

    public static int pickingNumbers(List<Integer> a) {

    	// **** empty or 1 item ****
    	if (a.size() <= 1) 
    		return 0;

    	// **** sort list in ascending order ****
    	Collections.sort(a);
//    	System.out.println("a: " + a.toString());
    	
    	// **** loop counting consecutive numbers whose value is <= 1 ****
    	int maxCount	= 0;
    	int count 		= 0;
    	int fi			= 0;
    	
    	for (int i = 1; i < a.size(); i++) {
    		
    		// **** count this entry (if needed) ****
    		if (Math.abs(a.get(fi) - a.get(i)) <= 1) {
    			
    			// **** increment the count ****
    			if (count == 0)
    				count = 2;
    			else
    				count++;
    			
    			// **** update the max count (if needed) ****
    			if (count > maxCount)
    				maxCount = count;
    		} 
    		
    		// **** reset the count ****
    		else {
    			count = 0;
    			fi 	  = i;
    		}
    		
//    		System.out.println("fi: " + fi + " i: " + i + " count: " + count + " maxCount: " + maxCount);
    	}
    		
    	// **** ****
    	return maxCount;
    }

}


public class Solution {

    public static void main(String[] args) throws IOException {
    	
    	// **** ****
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        
        int n = Integer.parseInt(br.readLine().trim());
        
        List<Integer> a = new ArrayList<Integer>();
        
        String line 	= br.readLine();
        String[] strs 	= line.trim().split("\\s+");
        
        for (int i = 0; i < n; i++) {
        	a.add(Integer.parseInt(strs[i]));
        }
              
        int result = Result.pickingNumbers(a);

        bw.write(String.valueOf(result));
        bw.newLine();

        br.close();
        bw.close();
    }

}
