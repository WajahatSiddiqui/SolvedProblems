package com.wajahat.hackerrank.Java;

import java.util.ArrayList;
import java.util.Scanner;

public class VisitorPattern {

    private static final int prime = 1000000000 + 7;

    enum Color {
        RED, GREEN
    }

    private static abstract class Tree {

        private int value;
        private Color color;
        private int depth;

        public Tree(int value, Color color, int depth) {
            this.value = value;
            this.color = color;
            this.depth = depth;
        }

        public int getValue() {
            return value;
        }

        public Color getColor() {
            return color;
        }

        public int getDepth() {
            return depth;
        }

        public abstract void accept(TreeVis visitor);
    }

    private static class TreeNode extends Tree {

        private ArrayList<Tree> children = new ArrayList<>();

        public TreeNode(int value, Color color, int depth) {
            super(value, color, depth);
        }

        public void accept(TreeVis visitor) {
            visitor.visitNode(this);

            for (Tree child : children) {
                child.accept(visitor);
            }
        }

        public void addChild(Tree child) {
            children.add(child);
        }
    }

    class TreeLeaf extends Tree {

        public TreeLeaf(int value, Color color, int depth) {
            super(value, color, depth);
        }

        public void accept(TreeVis visitor) {
            visitor.visitLeaf(this);
        }
    }

    private static abstract class TreeVis
    {
        public abstract int getResult();
        public abstract void visitNode(TreeNode node);
        public abstract void visitLeaf(TreeLeaf leaf);

    }

    private static class SumInLeavesVisitor extends TreeVis {
        public int getResult() {
            //implement this
            return 0;
        }

        public void visitNode(TreeNode node) {
            //implement this
        }

        public void visitLeaf(TreeLeaf leaf) {
            //implement this
        }
    }

    private static class ProductOfRedNodesVisitor extends TreeVis {
        public int getResult() {
            //implement this
            return 1;
        }

        public void visitNode(TreeNode node) {
            //implement this
        }

        public void visitLeaf(TreeLeaf leaf) {
            //implement this
        }
    }

    private static class FancyVisitor extends TreeVis {
        public int getResult() {
            //implement this
            return 0;
        }

        public void visitNode(TreeNode node) {
            //implement this
        }

        public void visitLeaf(TreeLeaf leaf) {
            //implement this
        }
    }

    private static Tree solve() {
        int N;
        int []X;
        int []C;
        try (Scanner scanner = new Scanner(System.in)) {
            N = scanner.nextInt();
            X = new int[N];
            C = new int[N];
            for (int i = 0; i < N; i++) {
                X[i] = scanner.nextInt();
            }

            for (int i = 0; i < N; i++) {
                C[i] = scanner.nextInt();
            }
            int u, v;
            TreeNode node1, node2;
            for (int i = 0; i < N-1; i++) {
                u = scanner.nextInt();
                v = scanner.nextInt();
                node1 = new TreeNode(X[u-1], C[u-1] == 0 ? Color.RED : Color.GREEN,  0);
                node2 = new TreeNode(X[v-1], C[v-1] == 0 ? Color.RED : Color.GREEN,  0);
                node1.addChild(node2);
            }
        }
        return null;
    }

    public static void main(String[] args) {
        Tree root = solve();
        SumInLeavesVisitor vis1 = new SumInLeavesVisitor();
        ProductOfRedNodesVisitor vis2 = new ProductOfRedNodesVisitor();
        FancyVisitor vis3 = new FancyVisitor();

        root.accept(vis1);
        root.accept(vis2);
        root.accept(vis3);

        int res1 = vis1.getResult();
        int res2 = vis2.getResult();
        int res3 = vis3.getResult();

        System.out.println(res1);
        System.out.println(res2);
        System.out.println(res3);
    }
}
