/**
     * A group of students are sitting in a circle. The teacher is electing a new class president.
     * The teacher does this by singing a song while walking around the circle. After the song is
     * finished the student at which the teacher stopped is removed from the circle.
     *
     * Starting at the student next to the one that was just removed, the teacher resumes singing
     * and walking around the circle. After the teacher is done singing, the next student is removed.
     * The teacher repeats this until only one student is left.
     *
     * A song of length k will result in the teacher walking past k students on each round.
     * The students are numbered 1 to n. The teacher starts at student 1.
     *
     * For example, suppose the song length is two (k=2). And there are four students to start
     * with (1,2,3,4). The first student to go would be `2`, after that `4`, and after that `3`.
     * Student `1` would be the next president in this example.
     * 
*/

import java.util.ArrayList;
import java.util.List;

public class LeaderInCircle {
    
    public static void main(String args[]) {
        
        int n=10;
        int k=3;
        
        List<Integer> students = new ArrayList<>();
        for(int i =1; i<=n; i++) {
            students.add(i);
        }

        /**
         * - The findLeader method is a recursive function that simulates the
         *   process of the teacher walking around the circle and removing students.
         *   The base case checks if there is only one player left in the circle.
         *   If so, the method returns.
         * - The index of the next student to be removed is calculated using the
         *   formula (index + k) % students.size().
         * - The student at the calculated index is removed from the list.
         * - The findLeader method is called recursively with the updated list of
         *   students, the same value of k, and the updated index.
         */
        findLeader(students, k-1, 0);
        System.out.println(students.get(0));
    }
    
    private static void findLeader(List<Integer> students, int k, int index) {
        System.out.println(students);
        if(students.size() == 1) {
            return;
        }

        index = (index+k)%students.size();
        students.remove(index);
        findLeader(students, k, index);
    }
}
    