package Day2;
import java.util.Scanner;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
public class Day2 {
    public static void main(String[] args) throws IOException {
        ArrayList<Integer> nums = new ArrayList<>();
        File reports = new File("/workspaces/AdventOfCode/Day2/reports.txt");
        Scanner reportsReader = new Scanner(reports);
        int safeCounter = 0;
        
        while(reportsReader.hasNextLine()){
            String line = reportsReader.nextLine();
            Scanner lineReader = new Scanner(line);
            String[] data = line.split(" ");
            for(int i=0; i<data.length; i++) {
                nums.add(Integer.parseInt(data[i]));
            }
            if(safeOrUnsafe(nums)) {
                safeCounter++;
            }
            for(int i = 0; i<data.length; i++) {
                nums.remove(0);
            }
            
        }
        reportsReader.close();
        System.out.println("safe reports: "+safeCounter);
    }
    
    
    // public static boolean safeOrUnsafe(ArrayList<Integer> nums) { // T if safe and F if not
    //     int currentNum = 0; 
    //     int nextNum = 0;
    //     int safeChanges = 0;
    //     int unsafeChanges = 0;
    //     for(int i=0; i<nums.size()-1; i++) {
    //         currentNum = nums.get(i);
    //         nextNum = nums.get(i+1);
    //         int decreaseRange = currentNum-nextNum; 
    //         int increaseRange = nextNum-currentNum; 
    //         System.out.println("current: "+currentNum);
            
    //         System.out.println("next: "+nextNum);
    //         System.out.println();
    //         if(currentNum<nextNum) { // this is for when its increasing
    //             if(1<=increaseRange && increaseRange<=3){
    //                 safeChanges++;
    //                 System.out.println("increase: "+safeChanges);
    //             }
    //         } 
            
    //         else if(currentNum>nextNum) { // this is for when its decreasing
    //             if(1<=decreaseRange && decreaseRange<=3){
    //                 safeChanges--;
    //                 System.out.println("decrease: "+safeChanges);
    //             }
    //         }
            
    //         else{ // if there is no change then its unsafe
    //             safeChanges--;
    //         }
            
    //     } // end of loop
    //     System.out.println(safeChanges);
    //     System.out.println("unsafeChanges: "+ unsafeChanges);
    //     // if safe changes are increments the left side checks it if its decrements the right side comes in

    //     boolean condition = safeChanges==nums.size()-1 || safeChanges==(nums.size()-nums.size()-nums.size()+1); 
    //     boolean condition2 = safeChanges==nums.size()-2 || safeChanges==(nums.size()-nums.size()-nums.size())+2;
    //     boolean condition3 = safeChanges==nums.size() || safeChanges==nums.size()-nums.size()-nums.size();
    //     if(condition) {
    //         return true;
    //     }
    //     else if(condition || condition2 || condition3 ) {
    //         return true;
    //     }
        
    //     else{
    //         return false;
    //     }
        
    // } // end of method


    public static boolean safeOrUnsafe(ArrayList<Integer> nums) { // T if safe and F if not
            int currentNum = 0; 
            int nextNum = 0;
            int unsafeChanges = 0;
            int increases = 0;
            int decreases = 0;
            for(int i=0; i<nums.size()-1; i++) {
                currentNum = nums.get(i);
                nextNum = nums.get(i+1);

                if(currentNum<nextNum) { // increasing 
                    int increaseRange = nextNum-currentNum;
                    if(increaseRange>3) {
                        unsafeChanges++;
                    }
                    increases++;
                }
                else if(currentNum>nextNum) { // decreasing 
                    int decreaseRange = currentNum-nextNum; 
                    if(decreaseRange>3) {
                        unsafeChanges++;
                    }
                    decreases++;
                }
                else{ // no change
                    unsafeChanges++;
                }
                
            }
            System.out.println("decrease amount: "+decreases);
            System.out.println("increase amount: "+increases);
            System.out.println("num of levels: "+nums.size());
            System.out.println();
            boolean condition1 = (increases==nums.size()-1 && unsafeChanges==0);
            boolean condition2 = (decreases==nums.size()-1 && unsafeChanges==0);
            boolean condition3 = (increases==nums.size()-1 && unsafeChanges==1);
            boolean condition4 = (decreases==nums.size()-1 && unsafeChanges==1);
            if(condition1 || condition2 || condition3 || condition4) {
                return true;
            }
            else {
                return false;
            }
        } // end of method
    
} // end of class