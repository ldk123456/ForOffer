import java.util.Stack;

/**
 * 最小栈
 * 用一个辅助栈
 * 每次将数据圧栈，如果辅助栈为空或数据小于等于辅助栈栈顶元素，将数据也压入辅助栈
 * 出栈，如果两个栈的栈顶元素一样，全都出栈
 */
public class MinStack {

    Stack<Integer> stack=new Stack<>();
    Stack<Integer> minStack=new Stack<>();

    public void push(int node) {
        if (minStack.isEmpty() || node<=minStack.peek())
            minStack.push(node);
        stack.push(node);
    }

    public void pop() {
        if (stack.peek()==minStack.peek())
            minStack.pop();
        stack.pop();
    }

    public int top() {
        return stack.peek();
    }

    public int min() {
        return minStack.peek();
    }
}
