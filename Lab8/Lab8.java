/*
 * Vandan Amin
 * Nov 15 2023
 * Lab 8 - More Tree Exercises
 */

import java.io.*;
import java.util.*;

public class Lab8
{

    /**
     *  Problem 1: Determine if two given trees are equal.
     *  Iterative Solution
     */
    private static boolean problem1Iterative(Node t1, Node t2){
    // if both trees are empty return true
    if (t1 == null && t2 == null) {
        return true;
    }

    // if one of the trees is empty while the other is not return false
    if (t1 == null || t2 == null) {
        return false;
    }

    // Create queues
    Queue<Node> queue1 = new LinkedList<>();
    Queue<Node> queue2 = new LinkedList<>();

    // Add root nodes to queues
    queue1.add(t1);
    queue2.add(t2);

    // Perform iterative level order traversal
    while (!queue1.isEmpty() && !queue2.isEmpty()) {
        Node node1 = queue1.poll();
        Node node2 = queue2.poll();

        // if values are not equal return false
        if (node1.value != node2.value) {
            return false;
        }

        // Add left children to the queues
        if (node1.left != null) {
            queue1.add(node1.left);
        }
        if (node2.left != null) {
            queue2.add(node2.left);
        }

        // Add right children to the queues
        if (node1.right != null) {
            queue1.add(node1.right);
        }
        if (node2.right != null) {
            queue2.add(node2.right);
        }
    }

    // if trees are equivalent
    return queue1.isEmpty() && queue2.isEmpty();
    }

    
    
    /**
     *  Problem 1: Determine if two given trees are equal.
     *  Recursive Solution
     */
    private static boolean problem1Recursive(Node t1, Node t2){
        // Base case: both trees are empty
        if (t1 == null && t2 == null) {
            return true;
        }
    
        // Base case: one tree is empty while the other is not
        if (t1 == null || t2 == null) {
            return false;
        }
    
        // if values are equal and recursively check left and right subtrees
        return (t1.value == t2.value)
                && problem1Recursive(t1.left, t2.left)
                && problem1Recursive(t1.right, t2.right);
    }
    


    /**
     *  Problem 2: Merge two given binary trees.
     *  Iterative Solution
     */
    private static Node problem2Iterative(Node t1, Node t2){
    // if one of the trees is empty
    if (t1 == null) {
        return t2;
    }
    if (t2 == null) {
        return t1;
    }

    // Create a stack for iterative traversal
    Stack<Node[]> stack = new Stack<>();
    stack.push(new Node[]{t1, t2});

    // Perform iterative pre-order traversal
    while (!stack.isEmpty()) {
        Node[] nodes = stack.pop();
        Node node1 = nodes[0];
        Node node2 = nodes[1];

        // If both nodes are not null, update the value of node1 and push children to the stack
        if (node1 != null && node2 != null) {
            node1.value += node2.value;

            // Push right children to the stack
            if (node1.right != null && node2.right != null) {
                stack.push(new Node[]{node1.right, node2.right});
            } else if (node1.right == null) {
                node1.right = node2.right;
            }

            // Push left children to the stack
            if (node1.left != null && node2.left != null) {
                stack.push(new Node[]{node1.left, node2.left});
            } else if (node1.left == null) {
                node1.left = node2.left;
            }
        }
    }

    return t1;
    }

    
    /**
     *  Problem 2: Merge two given binary trees.
     *  Recursive Solution
     */
    private static Node problem2Recursive(Node t1, Node t2){
    // Base case: one tree is empty
    if (t1 == null) {
        return t2;
    }
    if (t2 == null) {
        return t1;
    }

    // Update the value of the current node
    t1.value += t2.value;

    // Recursively merge left and right subtrees
    t1.left = problem2Recursive(t1.left, t2.left);
    t1.right = problem2Recursive(t1.right, t2.right);

    return t1;
    }


    // ---------------------------------------------------------------------
    // Do not change any of the code below!

    static class Node
    {
        public int value;
        public Node left;
        public Node right;
    }

    private static final int LabNo = 8;
    private static final String classNum = "CS 301";

    private static final Random rng = new Random(654521);

    public static void main(String args[])
    {
        System.out.println(classNum + " -- Lab " + LabNo);

        testProblems(1, 1);
        testProblems(1, 2);
        testProblems(2, 1);
        testProblems(2, 2);
    }

    private static boolean testProblem1(int[][] testCase, int style)
    {
        int[] left1 = testCase[0];
        int[] right1 = testCase[1];
        int[] values1 = testCase[2];

        int[] left2 = testCase[3];
        int[] right2 = testCase[4];
        int[] values2 = testCase[5];

        boolean solution = testCase[6][0] == 1;

        Node t1 = makeTree(left1, right1, values1);
        Node t2 = makeTree(left2, right2, values2);
        
        boolean answer;
        
        if(style == 1)
        {
           answer = problem1Iterative(t1, t2); 
        }else{
           answer = problem1Recursive(t1, t2);
        }
        
        
        return solution == answer;
    }

    private static boolean testProblem2(int[][] testCase, int style)
    {
        int[] left1 = testCase[0];
        int[] right1 = testCase[1];
        int[] values1 = testCase[2];

        int[] left2 = testCase[3];
        int[] right2 = testCase[4];
        int[] values2 = testCase[5];

        int[] left3 = testCase[6];
        int[] right3 = testCase[7];
        int[] values3 = testCase[8];

        Node t1 = makeTree(left1, right1, values1);
        Node t2 = makeTree(left2, right2, values2);
        Node merge = makeTree(left3, right3, values3);
        
        Node answer;
        
        if(style == 1)
        {
           answer = problem2Iterative(t1, t2); 
        }else{
           answer = problem2Recursive(t1, t2);
        }

        

        return problem1Iterative(merge, answer);
    }

    private static void testProblems(int prob, int style)
    {
        int noOfLines = 100000;

        System.out.println("-- -- -- -- --");
        
        switch (style)
        {
            case 1:
                  System.out.println(noOfLines + " test cases for problem " + prob + " iterative solution.");
                  break;
            case 2:
                  System.out.println(noOfLines + " test cases for problem " + prob + " recursive solution.");
                  break;
        }

        boolean passedAll = true;

        for (int i = 1; i <= noOfLines; i++)
        {
            boolean passed = false;
            boolean exce = false;
            int[][] testCase = null;

            try
            {
                switch (prob)
                {
                    case 1:
                        testCase = createProblem1(i);
                        passed = testProblem1(testCase, style);
                        break;

                    case 2:
                        testCase = createProblem2(i);
                        passed = testProblem2(testCase, style);
                        break;
                }
            }
            catch (Exception ex)
            {
                passed = false;
                exce = true;
            }

            if (!passed)
            {
                System.out.println("Test " + i + " failed!" + (exce ? " (Exception)" : ""));

                System.out.println("    left 1: " + Arrays.toString(testCase[0]));
                System.out.println("   right 1: " + Arrays.toString(testCase[1]));
                System.out.println("   value 1: " + Arrays.toString(testCase[2]));

                System.out.println("    left 2: " + Arrays.toString(testCase[3]));
                System.out.println("   right 2: " + Arrays.toString(testCase[4]));
                System.out.println("   value 2: " + Arrays.toString(testCase[5]));

                passedAll = false;
                break;
            }
        }

        if (passedAll)
        {
            System.out.println("All test passed.");
        }

    }

    private static Node makeTree(int[] left, int[] right, int[] values)
    {
        int size = left.length;
        Node[] nodes = new Node[size];

        for (int i = 0; i < size; i++)
        {
            nodes[i] = new Node();
            nodes[i].value = values[i];
        }

        for (int i = 0; i < size; i++)
        {
            if (left[i] >=0) nodes[i].left = nodes[left[i]];
            if (right[i] >=0) nodes[i].right = nodes[right[i]];
        }

        return nodes[0];
    }

    private static int[][] makeRndBinaryTree(int size)
    {
        int[] left = new int[size];
        int[] right = new int[size];
        int[] values = new int[size];

        int[] childCount = new int[size];

        ArrayList<Integer> available = new ArrayList<Integer>();

        available.add(0);
        left[0] = -1;
        right[0] = -1;

        for (int i = 1; i < size; i++)
        {
            int parInd = rng.nextInt(available.size());
            int par = available.get(parInd);

            if (childCount[par] == 0)
            {
                if (rng.nextInt(2) == 0)
                {
                    left[par] = i;
                }
                else
                {
                    right[par] = i;
                }

                childCount[par]++;
            }
            else // childCount[par] == 0
            {
                if (left[par] < 0)
                {
                    left[par] = i;
                }
                else
                {
                    right[par] = i;
                }
                childCount[par]++;

                available.set(parInd, available.get(available.size() - 1));
                available.remove(available.size() - 1);
            }

            left[i] = -1;
            right[i] = -1;

            available.add(i);
        }

        for (int i = 0; i < size; i++)
        {
            values[i] = rng.nextInt(size * size);
        }

        return new int[][] { left, right, values };

    }

    private static int[][] createProblem1(int max)
    {
        int maxSize = max < 250 ? max : 250;
        int size = rng.nextInt(maxSize) + 5;

        int[][] rndTree1 = makeRndBinaryTree(size);
        int[][] rndTree2 = rndTree1.clone();
        int answer = 0;

        int rndNum = rng.nextInt(3);

        if (rndNum == 0)
        {
            // Same tree
            answer = 1;
        }
        else if (rndNum == 1)
        {
            // Some value different
            int diff = rng.nextInt(maxSize) + 1;
            if (rng.nextInt(2) == 0) diff *= -1;

            rndTree2[2] = rndTree1[2].clone();
            rndTree2[2][rng.nextInt(size)] += diff;
        }
        else
        {
            ArrayList<Integer> hasL = new ArrayList<Integer>();
            ArrayList<Integer> hasR = new ArrayList<Integer>();

            // Some children different
            for (int i = 0; i < size; i++)
            {
                if (rndTree1[0][i] >= 0) hasL.add(i);
                if (rndTree1[1][i] >= 0) hasR.add(i);
            }

            int total = hasL.size() + hasR.size();
            int ind = rng.nextInt(total);

            if (ind < hasL.size())
            {
                ind = hasL.get(ind);
                rndTree2[0] = rndTree1[0].clone();
                rndTree2[0][ind] = -1;
            }
            else
            {
                ind = hasR.get(ind - hasL.size());
                rndTree2[1] = rndTree1[1].clone();
                rndTree2[1][ind] = -1;
            }
        }

        // 0: left1
        // 1: right1
        // 2: values1
        // 3: left2
        // 4: right2
        // 5: values2
        // 6: answer (0 for false, 1 for true)

        return new int[][] {
            rndTree1[0], rndTree1[1], rndTree1[2],
            rndTree2[0], rndTree2[1], rndTree2[2],
            new int[] { answer }
        };
    }

    private static int[][] createProblem2(int max)
    {
        int maxSize = max < 250 ? max : 250;
        int size = rng.nextInt(maxSize) + 5;

        int[][] rndTree1 = makeRndBinaryTree(size);
        int[][] rndTree2 = new int[][]
        {
            rndTree1[0].clone(),
            rndTree1[1].clone(),
            rndTree1[2].clone()
        };

        for (int i = 0; i < size; i++)
        {
            rndTree2[2][i] = rng.nextInt(size * size);
        }

        ArrayList<Integer> hasL = new ArrayList<Integer>();
        ArrayList<Integer> hasR = new ArrayList<Integer>();

        for (int i = 0; i < size; i++)
        {
            if (rndTree1[0][i] >= 0) hasL.add(i);
            if (rndTree1[1][i] >= 0) hasR.add(i);
        }

        int total = hasL.size() + hasR.size();

        ArrayList<Integer> removed = new ArrayList<Integer>();
        ArrayList<Integer> removedInd = new ArrayList<Integer>();

        int[][][] trees = { rndTree1, rndTree2 };

        for (int i = 0; i < Math.log(size) / Math.log(2); i++)
        {
            int treeInd = rng.nextInt(2);
            removedInd.add(treeInd);

            int[][] tree = trees[treeInd];
            int ind = rng.nextInt(total);

            if (ind < hasL.size())
            {
                ind = hasL.get(ind);
                removed.add(tree[0][ind]);
                tree[0][ind] = -1;
            }
            else
            {
                ind = hasR.get(ind - hasL.size());
                removed.add(tree[1][ind]);
                tree[1][ind] = -1;
            }
        }

        for (int i = 0; i < removed.size(); i++)
        {
            int treeInd = removedInd.get(i);
            int ind = removed.get(i);

            if (ind < 0) continue;

            int left = trees[treeInd][0][ind];
            int right = trees[treeInd][1][ind];

            trees[treeInd][0][ind] = -1;
            trees[treeInd][1][ind] = -1;
            trees[treeInd][2][ind] = 0;

            if (left >= 0)
            {
                removed.add(left);
                removedInd.add(treeInd);
            }

            if (right >= 0)
            {
                removed.add(right);
                removedInd.add(treeInd);
            }
        }


        int[][] mergeTree = new int[][]
        {
            new int[size],
            new int[size],
            new int[size]
        };


        for (int i = 0; i < size; i++)
        {
            mergeTree[0][i] = Math.max(rndTree1[0][i], rndTree2[0][i]);
            mergeTree[1][i] = Math.max(rndTree1[1][i], rndTree2[1][i]);
            mergeTree[2][i] = rndTree1[2][i] + rndTree2[2][i];
        }

        return new int[][]
        {
            rndTree1[0], rndTree1[1], rndTree1[2],
            rndTree2[0], rndTree2[1], rndTree2[2],
            mergeTree[0], mergeTree[1], mergeTree[2]
        };
    }

}
