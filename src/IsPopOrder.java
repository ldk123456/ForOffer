import java.util.Stack;

/**
 * 栈的压入、弹出序列
 */
public class IsPopOrder {
    public static void main(String[] args) {
        int[] push={1,2,3,4,5};
        int[] pop={4,3,5,1,2};
        System.out.println(IsPopOrder(push, pop));
    }

    /**
     * 借用一个辅助的栈，遍历压栈顺序，
     * 先将第一个数放入栈中，然后判断栈顶元素是不是出栈顺序的第一个元素，如果不是就继续压栈，
     * 直到相等以后开始出栈，出栈一个元素，则将出栈顺序向后移动一位，直到不相等，
     * 这样循环等压栈顺序遍历完成，如果辅助栈还不为空，说明弹出序列不是该栈的弹出顺序。
     */
    public static boolean IsPopOrder(int [] pushA,int [] popA) {
        if (pushA==null || popA==null)
            return false;
        Stack<Integer> stack=new Stack<>();
        int j=0;
        for (int i = 0; i < pushA.length; i++) {
            stack.push(pushA[i]);
            while (j<popA.length && stack.peek()==popA[j]){
                stack.pop();
                j++;
            }
        }
        return stack.isEmpty();
    }
}
