#include <iostream>
using namespace std;

struct TreeNode {
	int data;
	TreeNode *left, *right;
};

TreeNode *newNode(int data) {
	TreeNode * node = new TreeNode();
	if (!node) return NULL;
	node->data = data;
	node->left = NULL;
	node->right = NULL;

	return node;
}

void mirror(TreeNode *tree) {
	if (!tree) return;
	if (tree->left && tree->right) {
		TreeNode *temp = tree->left;
		tree->left = tree->right;
		tree->right = temp;
	}
	mirror(tree->left);
	mirror(tree->right);
}

TreeNode *getMirroredTree(TreeNode *tree) {
	if (!tree) return NULL;
	TreeNode *newTree;
	if (tree->left && tree->right) {
		newTree->left = newNode(tree->right->data);
		newTree->right = newNode(tree->right->data);
	}
	return mirror(tree->left);
	return mirror(tree->right);	
}

bool isMirror(TreeNode *tree1, TreeNode *tree2) {

}

void inorder(TreeNode *tree) {
	if (!tree) return;
	inorder(tree->left);
	cout<<tree->data<<" ";
	inorder(tree->right);
}

int main() {
	TreeNode *tree = newNode(10);
	tree->left = newNode(7);
	tree->right = newNode(12);
	tree->left->left = newNode(4);
	tree->left->right = newNode(8);
	inorder(tree);
	cout<<endl;
 	mirror(tree);
	inorder(tree);
	cout<<endl;
}