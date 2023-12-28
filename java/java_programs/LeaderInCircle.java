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
    