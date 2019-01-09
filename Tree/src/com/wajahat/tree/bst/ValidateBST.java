package com.wajahat.tree.bst;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

// Validate a given binary tree as BST
// Created by Wajahat
public class ValidateBST {

    public boolean isBSTArray(TreeNode root) {
        List<Integer> values = new ArrayList<>();
        isBSTArray(root, values);
        for (int i = 1; i < values.size(); i++) {
            if (values.get(i) < values.get(i-1)) return false;
        }
        Stream.of(1, 2, 3).forEach(System.out::println);
        return true;
    }

    private void isBSTArray(TreeNode node, List<Integer> value) {
        if (node == null) return;
        isBSTArray(node.left, value);
        value.add(node.data);
        isBSTArray(node.right, value);
    }

    public boolean isBST(TreeNode root, Integer prev) {
        if (root == null) return true;

        if (!isBST(root.left, prev)) return false;

        if (prev != null && root.data <= prev) return false;
        prev = root.data;

        return isBST(root.right, prev);
    }

    public boolean isBSTMinMax(TreeNode root, Integer min, Integer max) {
        if (root == null) return true;
        if (root.data < min || root.data > max) return false;
        return isBSTMinMax(root.left, min, root.data - 1)
                && isBSTMinMax(root.right, root.data + 1, max);
    }
}
