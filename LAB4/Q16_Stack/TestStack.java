package LAB4.Q16_Stack;

public class TestStack {
    public static void main(String[] args) {

        Stack myStack = new Stack();

        assert myStack.isEmpty() : "Stack should be empty";
        assert myStack.getTop() == -1 : "Top should be -1 when empty";

        assert myStack.pop() == -1 : "Popping an empty stack returns -1";

        myStack.push(10);
        assert myStack.getTop() == 10 : "Top should be 10";

        myStack.push(20);
        assert myStack.getTop() == 20 : "Top should be 20";

        myStack.push(30);
        assert myStack.getTop() == 30 : "Top should be 30";

        myStack.push(40);
        assert myStack.getTop() == 40 : "Top should be 40";

        myStack.push(50);
        assert myStack.getTop() == 50 : "Top should be 50";

        myStack.push(60);
        assert myStack.getTop() == 50 : "Top should remain 50 after overflow";
        assert myStack.isFull() : "Stack should be full";

        assert myStack.pop() == 50 : "Removed element should be 50";
        assert myStack.getTop() == 40 : "Top should now be 40";

        assert myStack.pop() == 40 : "Removed element should be 40";
        assert myStack.getTop() == 30 : "Top should now be 30";

        assert myStack.pop() == 30 : "Removed element should be 30";
        assert myStack.getTop() == 20 : "Top should now be 20";

        assert myStack.pop() == 20 : "Removed element should be 20";
        assert myStack.getTop() == 10 : "Top should now be 10";

        assert myStack.pop() == 10 : "Removed element should be 10";
        assert myStack.isEmpty() : "Stack should now be empty";
        assert myStack.getTop() == -1 : "Top should be -1 when empty";

        System.out.println(myStack);
        System.out.println("All stack tests passed!");
    }
}