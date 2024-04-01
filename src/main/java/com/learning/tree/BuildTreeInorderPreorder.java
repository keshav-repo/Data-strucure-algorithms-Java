package com.learning.tree;

class CNode {
    char data;
    CNode left, right;
    CNode(char item)
    {
        data = item;
        left = right = null;
    }
}

class BuildTreeInorderPreorder {
    CNode root;
    static int preIndex = 0;
    CNode buildTree(char in[], char pre[], int inStrt, int inEnd)
    {
        if (inStrt > inEnd)
            return null;

        CNode tCNode = new CNode(pre[preIndex++]);

        if (inStrt == inEnd)
            return tCNode;

        int inIndex = search(in, inStrt, inEnd, tCNode.data);

        tCNode.left = buildTree(in, pre, inStrt, inIndex - 1);
        tCNode.right = buildTree(in, pre, inIndex + 1, inEnd);

        return tCNode;
    }
    
    
    int search(char arr[], int strt, int end, char value)
    {
        int i;
        for (i = strt; i <= end; i++) {
            if (arr[i] == value)
                return i;
        }
        return i;
    }

    
    void printInorder(CNode node)
    {
        if (node == null)
            return;
        printInorder(node.left);
        System.out.print(node.data + " ");
        printInorder(node.right);
    }

    
    public static void main(String args[])
    {
        BuildTreeInorderPreorder tree = new BuildTreeInorderPreorder();
        char in[] = new char[] { 'D', 'B', 'E', 'A', 'F', 'C' };
        char pre[] = new char[] { 'A', 'B', 'D', 'E', 'C', 'F' };
        int len = in.length;
        CNode root = tree.buildTree(in, pre, 0, len - 1);
        
        System.out.println("Inorder traversal of constructed tree is : ");
        tree.printInorder(root);
    }
}





