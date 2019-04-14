package com.wajahat;


import java.util.*;

/**
 * BinaryTree
 * Created by Wajahat
 **/
public class BinaryTree {
    public static  class TreeNode {
        int data;
        TreeNode left, right;

        TreeNode(int data) {
            this.data = data;
            left = null;
            right = null;
        }
    }

    public TreeNode insert(TreeNode root, int data) {
        TreeNode node = new TreeNode(data);
        if (root == null) {
            return node;
        }

        Queue<TreeNode> queue = new ArrayDeque<>();
        queue.add(root);
        while (!queue.isEmpty()) {
            TreeNode front = queue.poll();
            if (front == null) throw new RuntimeException("Invalid queue");
            if (front.left != null) {
                queue.add(front.left);
            } else {
                front.left = node;
                break;
            }
            if (front.right != null) {
                queue.add(front.right);
            } else {
                front.right = node;
                break;
            }
        }
        return root;
    }

    public boolean contains(TreeNode root, int data) {
        if (root == null) return false;
        Queue<TreeNode> queue = new ArrayDeque<>();
        queue.add(root);

        while (!queue.isEmpty()) {
            TreeNode front = queue.poll();
            if (front == null) throw new RuntimeException("Invalid queue");
            if (front.data == data) return true;
            if (front.left != null) queue.add(front.left);
            if (front.right != null) queue.add(front.right);
        }
        return false;
    }

    private static class Node {
        private TreeNode node;
        private int hd;
        public Node(TreeNode node, int hd) {
            this.node = node;
            this.hd = hd;
        }
    }

    public List<Integer> inorder(TreeNode root) {
        List<Integer> list = new ArrayList<>();
        return inorder(root, list);
    }

    private List<Integer> inorder(TreeNode root, List<Integer> list) {
        if(root == null) return list;
        inorder(root.left, list);
        list.add(root.data);
        inorder(root.right, list);
        return list;
    }

    public List<Integer> preorder(TreeNode root) {
        List<Integer> list = new ArrayList<>();
        return preorder(root, list);
    }

    private List<Integer> preorder(TreeNode root, List<Integer> list) {
        if(root == null) return list;
        list.add(root.data);
        preorder(root.left, list);
        preorder(root.right, list);
        return list;
    }

    public List<Integer> postorder(TreeNode root) {
        List<Integer> list = new ArrayList<>();
        return postorder(root, list);
    }

    private List<Integer> postorder(TreeNode root, List<Integer> list) {
        if(root == null) return list;
        postorder(root.left, list);
        postorder(root.right, list);
        list.add(root.data);
        return list;
    }

    public List<Integer> levelOrder(TreeNode root) {
        if (root == null) return null;
        Queue<TreeNode> queue = new ArrayDeque<>();
        queue.add(root);
        List<Integer> result = new ArrayList<>();
        while (!queue.isEmpty()) {
            TreeNode front = queue.poll();
            if (front == null) throw new RuntimeException("Invalid queue");
            result.add(front.data);
            if (front.left != null) queue.add(front.left);
            if (front.right != null) queue.add(front.right);
        }
        return result;
    }

    public List<Integer> topView(TreeNode root) {
        if (root == null) return null;
        Queue<Node> queue = new ArrayDeque<>();
        Map<Integer, Integer> map = new LinkedHashMap<>();
        queue.add(new Node(root, 0));
        while (!queue.isEmpty()) {
            Node front = queue.poll();
            if (front == null) throw new RuntimeException("invalid state");
            if (!map.containsKey(front.hd)) {
                map.put(front.hd, front.node.data);
            }
            if (front.node.left != null) queue.add(new Node (front.node.left, front.hd - 1));
            if (front.node.right != null) queue.add(new Node (front.node.right, front.hd + 1));
        }

        return new ArrayList<>(map.values());
    }

    public List<Integer> bottomView(TreeNode root) {
        if (root == null) return null;
        Queue<Node> queue = new ArrayDeque<>();
        Map<Integer, Integer> map = new TreeMap<>();
        queue.add(new Node(root, 0));
        while (!queue.isEmpty()) {
            Node front = queue.poll();
            if (front == null) throw new RuntimeException("invalid state");
            map.put(front.hd, front.node.data);
            if (front.node.left != null) queue.add(new Node(front.node.left, front.hd-1));
            if (front.node.right != null) queue.add(new Node(front.node.right, front.hd+1));
        }
        return new ArrayList<>(map.values());
    }

    public List<Integer> spiralView(TreeNode root) {
        if (root == null) return null;
        Stack<TreeNode> s1 = new Stack<>();
        Stack<TreeNode> s2 = new Stack<>();
        s1.add(root);
        List<Integer> list = new ArrayList<>();
        while (!s1.empty() || !s2.empty()) {
            if (s1.empty() && !s2.empty()) {
                while (!s2.empty()) {
                    s1.push(s2.pop());
                }
            }
            TreeNode node = s1.pop();
            list.add(node.data);
            if (node.left != null) s2.add(node.left);
            if (node.right != null) s2.add(node.right);
        }
        return list;
    }

    public TreeNode lca(TreeNode root, int n1, int n2) {
        if (root == null) return null;

        if (root.data == n1 || root.data == n2) return root;

        TreeNode left_lca = lca(root.left, n1, n2);
        TreeNode right_lca = lca(root.right, n1, n2);

        if (left_lca != null && right_lca != null) return root;
        return left_lca != null ? left_lca : right_lca;
    }

    public TreeNode mirror(TreeNode root) {
        if (root == null) return null;
        mirror(root.left);
        mirror(root.right);
        TreeNode temp = root.left;
        root.left = root.right;
        root.right = temp;
        return root;
    }

    public boolean isMirror(TreeNode root1, TreeNode root2) {
        if (root1 == null && root2 == null) return true;
        if (root1 == null || root2 == null) return false;

        return root1.data == root2.data
                && isMirror(root1.left, root2. right)
                && isMirror(root1.right, root2.left);
    }

    public String toString(TreeNode root) {
        StringBuilder sb = new StringBuilder();
        inorder(root).forEach(i->sb.append(i).append(" "));
        return sb.toString();
    }
}
