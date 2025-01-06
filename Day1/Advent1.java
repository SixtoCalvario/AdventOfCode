package Day1;
import java.util.Scanner;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
public class Advent1 {
    
    public static void main(String[] args) throws IOException {
        // array list to store numbers from puzzleInput
        ArrayList<Integer> left = new ArrayList<Integer>(1000);
        ArrayList<Integer> right = new ArrayList<Integer>(1000);
        
        
        // read the file 
        File data = new File("puzzleInput.txt");
        Scanner fileReader = new Scanner(data);
        
        while(fileReader.hasNextLine()) {
            
            String num = fileReader.nextLine();
            Scanner numReader = new Scanner(num);
            numReader.useDelimiter("   ");
            
            
            while(numReader.hasNext()) {
                System.out.println(numReader.nextLine());
                String[] nums = num.split("   ");
                int leftNum = Integer.parseInt(nums[0]);
                int rightNum = Integer.parseInt(nums[1]);
                left.add(leftNum);
                right.add(rightNum);
            }
            
        }
        fileReader.close();
        left.sort(null);
        right.sort(null);
        System.out.println(left);

        int totalDistance = 0;
        for(int i=0; i<left.size(); i++) {
            if(left.get(i)<right.get(i)) { // if left is smaller
                totalDistance += right.get(i)-left.get(i);
            }
            else{
                totalDistance += left.get(i)-right.get(i);
            }
        }
        System.out.println(totalDistance);

        int similarityScore = 0;
        for(int i=0; i<left.size(); i++) {
            int leftNum = left.get(i);
            int occurances = 0;
            for(int j=0; j<right.size(); j++) {
                if(leftNum==right.get(j)) {
                    occurances++;
                }
            }
            similarityScore += leftNum*occurances;
        }
        System.out.println(similarityScore);

    
    } // end of main;
    

}