package com.example.awesomefat.bst_csc300_spring2016;

/**
 * Created by awesomefat on 3/8/16.
 */
public class BinaryTree
{
    private char payload;
    private BinaryTree leftTree;
    private BinaryTree rightTree;
    private String toReturn = "";

    public BinaryTree(char payload)
    {
        this.payload = payload;
        this.leftTree = null;
        this.rightTree = null;
    }

    public boolean isOutOfBalance()
    {
        int leftDepth = this.leftTree == null?0:this.leftTree.depth();
        int rightDepth = this.rightTree == null?0:this.rightTree.depth();
        return Math.abs(leftDepth-rightDepth) > 1;
    }

    public String outOfBalanceSecondarily(char val, String turn)
    {

        this.toReturn = turn;
        //are we looking at a matching payload and are we a leaf node
        if(this.payload == val && this.leftTree == null)
        {

            //return the last turn we made
            //HOW DO WE KNOW WHAT WAS THE LAST TURN?
            return this.toReturn;

        }
        else
        {

            if(val > this.payload)
            {

                this.getRightTree().outOfBalanceSecondarily(val, "right");


            }
            else
            {

                this.getLeftTree().outOfBalanceSecondarily(val, "left");
            }

        }
        return this.toReturn;



    }

    public int depth()
    {
        //boolean-exp?true-stmt:false-stmt
        return 1 + Math.max((this.leftTree == null?0:this.leftTree.depth()),
                (this.rightTree == null?0:this.rightTree.depth()));
    }

    public void add(char payload)
    {
        if(payload <= this.payload)
        {
            if(this.leftTree == null)
            {
                this.leftTree = new BinaryTree(payload);
            }
            else
            {
                this.leftTree.add(payload);
            }
        }
        else
        {
            if(this.rightTree == null)
            {
                this.rightTree = new BinaryTree(payload);
            }
            else
            {
                this.rightTree.add(payload);
            }
        }
    }

    public String displayPreOrder()
    {
        String answer = "" + this.payload + "\t";
        if(this.leftTree != null)
        {
            answer += this.leftTree.displayPreOrder();
        }

        if(this.rightTree != null)
        {
            answer += this.rightTree.displayPreOrder();
        }
        return answer;
    }

    public String displayPostOrder()
    {
        String answer = "";
        if(this.leftTree != null)
        {
            answer += this.leftTree.displayPostOrder();
        }

        if(this.rightTree != null)
        {
            answer += this.rightTree.displayPostOrder();
        }
        return answer + this.payload + "\t";
    }

    public String displayInOrder()
    {
        String answer = "";
        if(this.leftTree != null)
        {
            answer += this.leftTree.displayInOrder();
        }
        answer += this.payload + "\t";
        if(this.rightTree != null)
        {
            answer += this.rightTree.displayInOrder();
        }
        return answer;
    }

    public char getPayload()
    {
        return payload;
    }

    public BinaryTree getLeftTree()
    {
        return leftTree;
    }

    public BinaryTree getRightTree()
    {
        return rightTree;
    }
}