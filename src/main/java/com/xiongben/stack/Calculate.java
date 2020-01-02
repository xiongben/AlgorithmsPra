package com.xiongben.stack;

public class Calculate {
    public static void main(String[] args) {
       String expression = "7*2*2-5+1-5+3-4"; //18
        ArrayStack numStack = new ArrayStack(10);
        ArrayStack operStack = new ArrayStack(10);

        int index = 0;
        int num1 = 0;
        int num2 = 0;
        int oper = 0;
        int res = 0;
        char ch = ' ';
        String keepNum = "";
        while (true){
            ch = expression.substring(index,index+1).charAt(0);
            if(operStack.isOper(ch)){
                if(!operStack.isEmpty()){
                    if(operStack.priority(ch) <= operStack.priority(operStack.peek())){
                        num1 = numStack.pop();
                        num2 = numStack.pop();
                        oper = operStack.pop();
                        res = numStack.cal(num1,num2,oper);
                        numStack.push(res);
                        operStack.push(ch);
                    }else{
                        operStack.push(ch);
                    }
                }else{
                    operStack.push(ch);
                }
            }else{
                //如果是数值，直接入栈
//                numStack.push(ch - 48);
                keepNum += ch;
                if(index == expression.length()-1){
                    numStack.push(Integer.parseInt(keepNum));
                }else{
                    if(operStack.isOper(expression.substring(index+1,index+2).charAt(0))){
                        int ss = Integer.parseInt(keepNum);
                        System.out.println(ss);
                        numStack.push(ss);
                        keepNum = "";
                    }

                }
            }
            index++;
            if(index >= expression.length()){
                break;
            }
        }

        //扫描结束后，开始计算
        while (true){
            if(operStack.isEmpty()){
                break;
            }
            num1 = numStack.pop();
            num2 = numStack.pop();
            oper = operStack.pop();
            res = operStack.cal(num1,num2,oper);
            numStack.push(res);
        }
        int res2 = numStack.pop();
//        System.out.println(res2);
        System.out.printf("表达式%s的结果是%d\n",expression,res2);
    }
}


class ArrayStack {
    private int maxSize;
    private int[] stack;
    private int top = -1;

    ArrayStack(int maxsize){
        this.maxSize = maxsize;
        stack = new int[this.maxSize];
    }

    public int peek(){
        return stack[top];
    }

    public boolean isEmpty(){
        return top == -1;
    }

    public boolean isFull(){
        return top == maxSize-1;
    }

    public void push(int value){
        if(isFull()){
            throw new RuntimeException("栈满了，无法写入");
        }
        top++;
        stack[top] = value;
    }

    public int pop(){
        if(isEmpty()){
            throw new RuntimeException("栈为空，无法弹出");
        }
        int value = stack[top];
        top--;
        return value;
    }

    public void list(){
        if(isEmpty()){
            System.out.println("没有数据");
            return;
        }
        for (int i=top;i>-1;i--) {
            System.out.printf("stack[%d] = %d\n",i,stack[i]);
        }
    }

    public int priority(int oper) {
        if(oper == '*' || oper == '/') {
            return 1;
        }else if(oper == '+' || oper == '-'){
            return 0;
        }else {
            return -1;
        }
    }

    public boolean isOper(char val){
        return val == '+' || val == '-' || val == '*' || val == '/';
    }

    public int cal(int num1,int num2,int oper) {
        int res = 0;
        switch (oper){
            case '+':
                res = num1 + num2;
                break;
            case  '-':
                res = num2 - num1;
                break;
            case  '*':
                res = num1 * num2;
                break;
            case '/':
                res = num2 / num1;
                break;
            default:
                break;

        }
        return res;
    }
}