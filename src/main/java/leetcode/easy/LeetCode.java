package leetcode.easy;

import leetcode.ListNode;
import leetcode.TreeNode;

import java.util.*;

public class LeetCode {

    public int[][] construct2DArray(int[] original, int m, int n) {
        if (m*n != original.length) {
            return new int[0][0];
        }
        int[][] result = new int[m][n];
        int row = 0;
        int column = 0;
        for (int i : original) {
            result[row][column] = i;
            if (column == n-1) {
                column = 0;
                row++;
                continue;
            }
            column++;
        }
        return result;
    }

    public int majorityElement(int[] nums) {
        int majorityCount = nums.length / 2;
        Arrays.sort(nums);
        return nums[majorityCount];
    }

    public boolean backspaceCompare(String s, String t) {
        String[] s1 = s.split("");
        String[] t1 = t.split("");

        int p1 = s1.length - 1;
        int p2 = t1.length - 1;

        while (p1 >= 0 && p2 >=0) {

            p1 = getNextCharacterIndex(s1, p1, 0);
            p2 = getNextCharacterIndex(t1, p2, 0);
            if (p1 < 0) return p2 < 0;
            if (p2 < 0) return false;

            if (!s1[p1].equals(t1[p2])) {
                return false;
            }
            p1--;
            p2--;
        }

        if (p1 >= 0) p1 = getNextCharacterIndex(s1, p1, 0);
        if (p2 >= 0) p2 = getNextCharacterIndex(t1, p2, 0);

        return p1 < 0 && p2 < 0;
    }

    public int getNextCharacterIndex(String[] s, int p1, int count) {
        while (p1 >= 0 && s[p1].equals("#")) {
            count++;
            p1--;
        }
        while (p1 >= 0 && count > 0) {
            if (s[p1].equals("#")) {
                return getNextCharacterIndex(s, p1, count);
            }
            count --;
            p1--;
        }
        if (p1 < 0) return p1;
        return s[p1].equals("#") ? getNextCharacterIndex(s, p1, 0) : p1;
    }

    public int[] sortedSquares(int[] nums) {
        int[] n = new int[nums.length];
        int start = 0;
        int end = nums.length - 1;
        int counter = nums.length - 1;
        while (start <= end) {
            int st = nums[start] * nums[start];
            int ed = nums[end] * nums[end];
            if (st > ed) {
                n[counter] = st;
                start++;
            } else {
                n[counter] = ed;
                end--;
            }
            counter--;
        }
        return n;
    }

    public TreeNode invertTree(TreeNode root) {
        if (root == null) return null;
        TreeNode left = root.left;
        root.left = root.right;
        root.right = left;
        invertTree(root.right);
        invertTree(root.left);
        return root;
    }

    public boolean isSubtree(TreeNode root, TreeNode subRoot) {
        if (root == null) return subRoot == null;
        if (isSameSub(root, subRoot)) {
            return true;
        }
        return isSubtree(root.left, subRoot) || isSubtree(root.right, subRoot);
    }

    public boolean isSameSub(TreeNode root, TreeNode subRoot) {
        if (subRoot == null) return root == null;
        if (root == null) return false;

        if (root.val == subRoot.val) {
            return isSameSub(root.left, subRoot.left) && isSameSub(root.right, subRoot.right);
        }
        return false;
    }

    public TreeNode mergeTrees(TreeNode root1, TreeNode root2) {
        if (root1 == null && root2 == null) return null;
        if (root1 == null) return root2;
        if (root2 == null) return root1;
        TreeNode left = mergeTrees(root1.left, root2.left);
        TreeNode right = mergeTrees(root1.right, root2.right);
        return new TreeNode(root1.val + root2.val, left, right);
    }

    int diameter = 0;

    public int diameterOfBinaryTree(TreeNode root) {
        if (root == null) return 0;
        diameterDFS(root);
        return diameter;

    }

    private int diameterDFS(TreeNode root) {
        if (root == null) return -1;
        int right = diameterDFS(root.right);
        int left = diameterDFS(root.left);
        diameter = Math.max(diameter, 2 + right + left);

        return 1 + Math.max(right, left);
    }

    public int maxDepth(TreeNode root) {
        if (root == null) return 0;

        int maxDepth = 1;
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);

        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                TreeNode currentNode = queue.poll();
                if (currentNode.right != null) queue.offer(currentNode.right);
                if (currentNode.left != null) queue.offer(currentNode.left);
            }
            maxDepth += 1;
        }
        return maxDepth;
    }

    int targetSum = 0;

    public boolean hasPathSum(TreeNode root, int targetSum) {
        this.targetSum = targetSum;
        int currSum = 0;
        return dfs(root, currSum);
    }

    private boolean dfs(TreeNode node, int currSum) {
        if (node == null) return false;

        currSum += node.val;
        if (node.right == null && node.left == null)
            return currSum == targetSum;
        else return dfs(node.right, currSum) || dfs(node.left, currSum);
    }

    public boolean isSameTree(TreeNode p, TreeNode q) {
        if (p == null) return q == null;

        if (q == null) return false;

        if (p.val == q.val)
            return isSameTree(p.right, q.right) && isSameTree(p.left, q.left);

        return false;
    }

    public int minDepth(TreeNode root) {
        if (root == null) return 0;

        int minDepth = 1;
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);

        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                TreeNode currentNode = queue.poll();
                if (currentNode.right == null && currentNode.left == null) return minDepth;
                if (currentNode.right != null) queue.offer(currentNode.right);
                if (currentNode.left != null) queue.offer(currentNode.left);
            }
            minDepth += 1;
        }
        return minDepth;
    }


    public List<Double> averageOfLevels(TreeNode root) {
        List<Double> result = new ArrayList<>();
        if (root == null) return result;

        double levelSum = 0;
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);

        while (!queue.isEmpty()) {
            levelSum = 0;
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                TreeNode poll = queue.poll();
                levelSum += poll.val;
                if (poll.right != null) queue.add(poll.right);
                if (poll.left != null) queue.add(poll.left);
            }
            result.add(levelSum /size);
        }

        return result;
    }

    public int peakIndexInMountainArray(int[] arr) {
        int start = 0;
        int end = arr.length - 1;
        while (start <= end) {
            int middle = start + ((end-start)/2);
            if (arr[middle] < arr[middle + 1]) {
                start = middle + 1;
            } else {
                end = middle - 1;
            }
        }
        return start;
    }

    public char nextGreatestLetter(char[] letters, char target) {
        int start = 0;
        int end = letters.length - 1;
        while (start <= end) {
            int middle = start + ((end-start)/2);
            if (letters[middle] > target) {
                end = middle - 1;
            } else {
                start = middle + 1;
            }
        }
        if (start == letters.length) return letters[0];
        return letters[start];
    }

    public int search(int[] nums, int target) {
        int startIndex = 0;
        int endIndex = nums.length - 1;

        while (startIndex <= endIndex) {
            int middleIndex = startIndex + ((endIndex - startIndex) / 2);
            if (nums[middleIndex] == target) return middleIndex;
            if (nums[middleIndex] < target) {
                startIndex = middleIndex + 1;
            } else {
                endIndex = middleIndex - 1;
            }
        }
        return -1;
    }

    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {


        if (list1 == null && list2 == null) return null;
        if (list1 == null) return list2;
        if (list2 == null) return list1;

        ListNode head = null;
        ListNode head1 = null;
        ListNode head2 = null;
        if (list1.val < list2.val) {
            head = list1;
            head1 = list1.next;
            head2 = list2;
        } else {
            head = list2;
            head2 = list2.next;
            head1 = list1;
        }
        ListNode movingHead = head;

        while (true) {
            if(head1 == null && head2 == null) break;
            if (head1 == null) {
                movingHead.next = head2;
                break;
            }
            if (head2 == null){
                movingHead.next = head1;
                break;
            }
            if (head1.val < head2.val) {
                movingHead.next = head1;
                head1 = head1.next;
                movingHead = movingHead.next;
            } else {
                movingHead.next = head2;
                head2 = head2.next;
                movingHead = movingHead.next;
            }
        }
        return head;
    }

    public ListNode reverseList(ListNode head) {
        ListNode prev = null;
        ListNode curr = head;
        while (curr != null) {
            ListNode temp = curr.next;
            curr.next = prev;
            prev = curr;
            curr = temp;
        }
        return prev;
    }

    public ListNode deleteDuplicates(ListNode head) {
        ListNode node = head;
        while (node != null) {
            while (node.next != null && node.next.val == node.val) {
                node.next = node.next.next;
            }
            node = node.next;
        }
        return head;
    }


}
