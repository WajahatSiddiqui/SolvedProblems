package com.wajahat.tree.bst;

import org.junit.Test;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;


/**
 * Class Test Cases for ValidateBST
 * Created by wajahat
 */
public class ValidateBSTTest {

    private ValidateBST validateBST;
    TreeNode validBST;
    TreeNode notValidBST;

    public ValidateBSTTest() {
        validateBST = new ValidateBST();

        validBST = new TreeNode(10);
        validBST.left = new TreeNode(6);
        validBST.right = new TreeNode(15);
        validBST.left.left = new TreeNode(4);
        validBST.left.right = new TreeNode(7);
        validBST.right.left = new TreeNode(12);


        notValidBST = new TreeNode(10);
        notValidBST.left = new TreeNode(6);
        notValidBST.right = new TreeNode(15);
        notValidBST.left.left = new TreeNode(4);
        notValidBST.left.right = new TreeNode(7);
        notValidBST.right.right = new TreeNode(12);
    }
    
    @Test
    public void validBST() {
        assertTrue(validateBST.isBST(null, null));
        assertTrue(validateBST.isBST(validBST, null));
        assertTrue(validateBST.isBSTArray(validBST));
        assertTrue(validateBST.isBSTMinMax(validBST, Integer.MIN_VALUE, Integer.MAX_VALUE));
    }

    @Test
    public void invalidBST() {
        assertFalse(validateBST.isBST(notValidBST, null));
        assertFalse(validateBST.isBSTArray(notValidBST));
        assertFalse(validateBST.isBSTMinMax(notValidBST, Integer.MIN_VALUE, Integer.MAX_VALUE));
    }
}
