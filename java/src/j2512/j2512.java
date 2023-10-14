package j2512;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

class StringMatchTree {
    // char val;
    boolean end = false;
    HashMap<Character, StringMatchTree> childs = new HashMap<>();
}

class Student {
    int id;
    int score;

    Student(int id, int score) {
        this.id = id;
        this.score = score;
    }

    public static int compareStd(Student a, Student b) {
        if (a.score == b.score) {
            return b.id - a.id;
        }
        return a.score - b.score;
    }
}

class Solution {
    public List<Integer> topStudents(String[] positive_feedback, String[] negative_feedback, String[] report,
            int[] student_id, int k) {
        StringMatchTree posTree = buildTree(positive_feedback);
        StringMatchTree negTree = buildTree(negative_feedback);
        ArrayList<Student> topKStudents = new ArrayList<>();
        for (int i = 0; i < report.length; i++) {
            String[] rp_token = report[i].split(" ");
            Student std = new Student(student_id[i], 0);
            for (String token : rp_token) {
                if (search(negTree, token)) {
                    std.score--;
                }
                if (search(posTree, token)) {
                    std.score += 3;
                }
            }
            topKStudents.add(std);
        }
        ArrayList<Integer> ans = new ArrayList<>();
        topKStudents.sort(Student::compareStd);
        for (int i = k - 1; i >= 0; i--) {
            ans.add(topKStudents.get(i).id);
        }
        return ans;
    }

    StringMatchTree buildTree(String[] key_word) {
        StringMatchTree head = new StringMatchTree();
        for (String string : key_word) {
            StringMatchTree curr = head;
            for (char ch : string.toCharArray()) {
                if (!curr.childs.containsKey(ch)){
                    curr.childs.put(ch, new StringMatchTree());
                }
                curr = curr.childs.get(ch);
            }
            curr.end = true;
        }
        return head;
    }

    boolean search(StringMatchTree head, String str) {
        StringMatchTree curr = head;
        for (char ch : str.toCharArray()) {
            if (curr.childs.containsKey(ch)) {
                curr = curr.childs.get(ch);
            } else {
                return false;
            }
        }
        return curr.end;
    }
}

public class j2512 {
    public static void main(String[] args) {
        String[] positive_feedback = {"abcs","abc","ab"};
        String[] negative_feedback = {"not"};
        String[] report = {"this a ab abc is not","the abcs"};
        int[] student_id = {1,2};
        int k = 2;
        Solution sol = new Solution();
        List<Integer> ans = sol.topStudents(positive_feedback, negative_feedback, report, student_id, k);
        System.out.println(ans);
    }
}
