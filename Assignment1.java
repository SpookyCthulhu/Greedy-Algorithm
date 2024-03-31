import java.util.Arrays;
import java.util.Scanner;

public class Assignment1 {
    public static void main(String[] args) {
        // Takes in a string of the users inputs.
        Scanner input = new Scanner(System.in);
        //  Commented prompt out as I believe you requested. 
        //System.out.print("Please enter a distance, followed by pogostick ranges seperated by spaces\n> ");
        String[] line = (input.nextLine()).split(" ", 0);
        input.close();
        // Turns the string input into an array of integers.
        int[] pogoSet = new int[line.length - 1];
        int goal = Integer.parseInt(line[0]);
        for (int i = 0; i < line.length - 1; i++) {
                pogoSet[i] = Integer.parseInt(line[i + 1]);
            }
        // Sorts the created int array from low to high.
        Arrays.sort(pogoSet);
        // Initial call to Solutions, with return value printed.
        long startTime = System.nanoTime();
        System.out.println(j5_Solutions(pogoSet, goal, ""));
        long endTime = System.nanoTime();
        System.out.println("Time in milliseconds: " + ((endTime - startTime) / 1000000));
    }

    // Recursively finds every permutation of combinations of pogosticks
    // that can be used to reach the goal. 
    // pogoSet is an array of pogo stick distances, goal is the distance to
    // reach, and record is used to construct string of used pogo sticks.
    public static String j5_Solutions(int[] pogoSet, int goal, String record) {
        // Will store every record that reaches goal in order with newline.
        String output = "";
        // for each pogo stick in the set.
        for (int pogo : pogoSet) {
            // if the pogo stick would bring us to the goal...
            if (pogo == goal) {
                // add pogo stick to record and return as string.
                output = output + record + pogo + "\n";
                break;
            }
            // else if the pogo stick would overshoot...
            if (pogo > goal) {
                // return any previous additions to output or "".
                break;
            }
            // if we've yet to reach goal / overshoot, recurse to next number.
            String next = j5_Solutions(pogoSet, goal - pogo, record + pogo);
            // if the recursive called returned anything, add it to output.
            output += next;
            // then continue to next pogo stick
        }
        // return statement used throughout function.
        return output;
    }
}