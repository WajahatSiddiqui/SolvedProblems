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

    public void inorder(TreeNode root) {
        if (root == null) return;
        inorder(root.left);
        System.out.print(root.data + " ");
        inorder(root.right);
    }

    private static class Node {
        private TreeNode node;
        private int hd;
        public Node(TreeNode node, int hd) {
            this.node = node;
            this.hd = hd;
        }
    }

    public void topView(TreeNode root) {
        if (root == null) return;
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

        map.values().forEach(System.out::println);
    }
}
