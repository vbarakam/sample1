import java.util.Deque;
import java.util.LinkedList;
import java.util.TreeMap;

public class MaxStack {

    private Node head;
    private Node tail;
    private TreeMap<Integer, Deque<Node>> map;
    
    /** initialize your data structure here. */
    public MaxStack() {
        map = new TreeMap<>();
        head = new Node();
        tail = new Node();
        head.next = tail;
        tail.prev = head;
    }
    
    public void push(int x) {
        Node node = new Node();
        node.val = x;
        addNode(node);
        map.putIfAbsent(x, new LinkedList<Node>());
        map.get(x).add(node);
        //System.out.println(node.toString());
    }
    
    public int pop() {
        if (head == null) {
            return -1;
        }
        int temp = head.next.val;
        map.get(temp).pollLast();
        removeNode(head.next);
        return temp;
    }
    
    public int top() {
        return head.next.val;
    }
    
    public int peekMax() {
        return map.lastKey();
    }
    
    public int popMax() {
        int kkey = map.lastKey();
        Node node = map.get(kkey).pollLast();
        removeNode(node);
        return kkey;
    }
    
    private void removeNode(Node node) {
        System.out.println(" node " + node.val);
        node.prev.next = node.next;
        node.next.prev = node.prev;
        System.out.println(map.get(node.val).size());
        if (map.containsKey(node.val) && map.get(node.val).size() == 0) {
            map.remove(node.val);
        }
    }
    
    private void addNode(Node node) {
        node.next = head.next;
        node.prev = head;
        head.next = node;
        node.next.prev = node;
    }
    
    public static void main(String args[]) {
    	//["MaxStack","push","push","push","peekMax","popMax","popMax","top"]
    	//		[[],[5],[1],[6],[],[],[],[]]
    	String actions[] = {"MaxStack","push","pop","push","push","push","popMax","push","peekMax","pop","peekMax","pop","push","popMax","pop","push","top","top","push","push","pop","push","pop","push","push","pop","push","push","pop","pop","push","popMax","push","push","pop","top","popMax","push","pop","peekMax","push","push","pop","top","peekMax","popMax","pop","push","peekMax","push","push","push","popMax","peekMax","popMax","push","push","pop","push","pop","push","top","push","top","push","push","push","push","pop","peekMax","push","push","push","top","top","top","peekMax","pop","peekMax","peekMax","push","peekMax","push","popMax","push","top","peekMax","push","push","push","peekMax","pop","push","popMax","push","top","peekMax","pop","push","pop","peekMax","pop","pop","popMax","push","push","push","push","push","pop","top","push","push","peekMax","top","top","peekMax","push","push","push","peekMax","popMax","push","pop","push","peekMax","popMax","push","push","push","pop","push","top","top","push","push","push","push","push","push","peekMax","pop","pop","peekMax","push","top","popMax","top","pop","push","pop","pop","top","push","push","top","pop","popMax","top","push","popMax","popMax","push","pop","push","popMax","push","peekMax","push","popMax","push","push","top","top","push","push","top","push","push","top","push","popMax","pop","push","top","push","popMax","peekMax","popMax","pop","top","pop","push","peekMax","top","peekMax","push","push","push","push","push","popMax","top","pop","top","top","pop","top","popMax","push","push","push","peekMax","pop","popMax","pop","popMax","push","push","pop","push","peekMax","push","peekMax","push","top","popMax","popMax","top","peekMax","peekMax","push","push","popMax","push","push","popMax","peekMax","peekMax","push","push","peekMax","push","top","peekMax","push","push","push","pop","push","popMax","popMax","peekMax","pop","push","top","peekMax","top","push","push","push","push","push","push","push","top","pop","push","peekMax","peekMax","pop","push","top","push","popMax","peekMax","peekMax","push","peekMax","popMax","top","pop","peekMax","peekMax","push","popMax","top","peekMax","pop","push","push","push","popMax","top","push","peekMax","popMax","push","push","pop","popMax","push","push","push","top","top","pop","push","top","popMax","push","pop","peekMax","push","peekMax","pop","peekMax","popMax","push","top","top","popMax","top","popMax","push","push","push","top","push","popMax","push","peekMax","top","pop","peekMax","push","push","popMax","top","push","push","push","pop","push","push","push","top","peekMax","peekMax","push","push","popMax","peekMax","push","push","push","popMax","push","push","peekMax","peekMax","pop","peekMax","pop","top","popMax","push","pop","push","push","top","push","top","popMax","top","push","push","push","push","popMax","pop","push","push","top","push","pop","pop","popMax","push","top","top","popMax","popMax","peekMax","popMax","push","popMax","push","popMax","peekMax","push","top","popMax","push","top","top","top","popMax","top","pop","top","popMax","push","top","top","popMax","push","peekMax","pop","pop","push","pop","push","push","push","push","top","push","top","push","peekMax","push","pop","popMax","popMax","top","popMax","top","push","push","push","popMax","pop","push","push","pop","push","top","peekMax","popMax","pop","push","pop","top","pop","pop","pop","pop","peekMax","peekMax","push","push","pop","push","top","peekMax","peekMax","pop","pop","popMax","push","top","peekMax","push","push","pop","push","push","pop","push","peekMax","pop","push","top","popMax","popMax","push","push","push","push","popMax","top","push","pop","pop","peekMax","push","peekMax","push","push","peekMax","pop","push","top","push","peekMax","push","popMax","pop","top","top","top","peekMax","peekMax","peekMax","popMax","peekMax","top","top","push","top","push","push","push","popMax","popMax","push","popMax","push","peekMax","peekMax","popMax","push","popMax","top","push","push","push","push","pop","peekMax","peekMax","popMax","popMax","pop","push","pop","popMax","peekMax","peekMax","push","push","push","top","pop","popMax","push","top","pop","push","push","push","top","pop","push","popMax","push","pop","push","push","push","top","peekMax","push","push","push","pop","push","peekMax","push","push","push","pop","popMax","peekMax","peekMax","push","peekMax","pop","push","push","pop","top","top","push","push","popMax","peekMax","top","push","top","push","pop","popMax","push","popMax","push","push","top","popMax","pop","popMax","popMax","top","push","push","pop","push","top","push","push","push","push","push","peekMax","push","peekMax","top","peekMax","push","pop","push","push","push","push","popMax","push","push","push","peekMax","popMax","push","peekMax","peekMax","push","pop","popMax","push","top","push","top","popMax","push","top","pop","top","popMax","pop","push","popMax","push","push","pop","push","top","push","push","push","push","top","push","top","push","push","push","push","push","peekMax","top","push","popMax","pop","push","popMax","pop","top","pop","push","push","push","push","push","pop","top","push","push","top","top","pop","pop","pop","peekMax","popMax","popMax","pop","push","peekMax","push","popMax","pop","peekMax","push","push","push","push","push","popMax","push","pop","pop","peekMax","popMax","push","pop","peekMax","push","pop","popMax","push","pop","popMax","push","pop","top","push","pop","pop","pop","push","top","peekMax","push","peekMax","pop","push","pop","peekMax","popMax","popMax","push","peekMax","pop","push","push","top","push","push","top","popMax","push","push","push","peekMax","pop","pop","top","popMax","peekMax","top","push","top","pop","push","top","popMax","push","push","peekMax","pop","push","pop","top","push","push","push","peekMax","push","push","pop","top","peekMax","peekMax","push","peekMax","top","peekMax","popMax","push","peekMax","top","peekMax","push","push","pop","peekMax","push","push","push","push","peekMax","peekMax","peekMax","pop","push","popMax","push","popMax","push","popMax","top","push","push","push","pop","popMax","push","top","push","peekMax","top","top","top","popMax","peekMax","peekMax","push","push","push","peekMax","push","push","top","push","peekMax","peekMax","push","push","push","top","pop","push","peekMax","push","top","peekMax","top","push","push","pop","peekMax","top","push","peekMax","top","pop","top"};
    	String values = ",72,,-59,54,27,,16,,,,,-96,,,-29,,,22,67,,93,,66,-14,,84,22,,,60,,-82,-31,,,,80,,,97,-11,,,,,,51,,-63,-57,81,,,,-89,90,,22,,31,,-33,,21,-52,100,-17,,,22,19,58,,,,,,,,92,,11,,-97,,,-75,-59,-79,,,89,,-12,,,,-9,,,,,,83,-1,38,42,85,,,-25,80,,,,,32,16,23,,,-71,,-62,,,29,-80,32,,45,,,78,-50,-52,-36,-41,25,,,,,-59,,,,,95,,,,5,-16,,,,,-95,,,66,,-40,,93,,-57,,-62,47,,,-4,-72,,-58,-63,,14,,,78,,15,,,,,,,67,,,,-19,64,-36,5,78,,,,,,,,,64,11,-11,,,,,,-60,55,,-89,,95,,13,,,,,,,18,-100,,89,50,,,,-84,-93,,-71,,,-92,64,-59,,67,,,,,-64,,,,73,-89,-5,-57,89,12,-69,,,25,,,,-12,,86,,,,30,,,,,,,-75,,,,,63,-70,67,,,-80,,,88,-79,,,72,1,-92,,,,72,,,-4,,,40,,,,,44,,,,,,-99,51,-28,,-10,,-86,,,,,87,1,,,80,-46,10,,-92,-61,31,,,,74,2,,,34,4,-33,,17,32,,,,,,,,83,,-61,-13,,-43,,,,-10,55,10,60,,,25,-24,,-92,,,,34,,,,,,,-78,,-14,,,59,,,-16,,,,,,,,,-73,,,,20,,,,7,,-20,76,84,-55,,22,,33,,96,,,,,,,95,85,10,,,1,-33,,59,,,,,-92,,,,,,,,,-73,58,,67,,,,,,,-80,,,15,-42,,24,-49,,25,,,81,,,,100,95,56,-50,,,-43,,,,15,,-53,-57,,,-46,,13,,-9,,,,,,,,,,,,,12,,75,7,67,,,10,,-37,,,,39,,,27,29,44,-28,,,,,,,72,,,,,-1,36,60,,,,76,,,-51,-32,23,,,36,,9,,-96,-76,38,,,-91,93,94,,8,,74,-43,46,,,,,-38,,,49,65,,,,41,-45,,,,-9,,44,,,80,,-69,64,,,,,,,91,62,,35,,42,91,-86,-27,-27,,56,,,,-11,,76,-69,16,-44,,71,78,75,,,-1,,,-9,,,-37,,-34,,,54,,,,,,-18,,-95,37,,-6,,-33,68,-93,-6,,-84,,-81,-18,-30,17,6,,,-65,,,-65,,,,,27,7,11,28,10,,,-15,31,,,,,,,,,,-4,,-22,,,,65,38,82,-96,9,,49,,,,,42,,,55,,,-85,,,-88,,,97,,,,25,,,24,,,-62,,,,,-51,,,30,-89,,85,-28,,,-96,55,-41,,,,,,,,-75,,,-60,,,-17,-41,,,14,,,7,-6,64,,53,-57,,,,,-92,,,,,-88,,,,-51,-14,,,74,39,4,-25,,,,,-12,,-63,,94,,,21,59,-49,,,-99,,17,,,,,,,,80,69,54,,87,99,,33,,,14,-65,-13,,,73,,15,,,,-4,-23,,,,-31,,,,";
    	String splits[] = values.split(",");
    	MaxStack stack = new MaxStack();
    	for (int i = 1; i < actions.length; i ++) {
    		System.out.println(" i " + i +  " " + actions[i]);
    		System.out.println(" i " + i +  " " + splits[i]);
    		if (i == 10) {
    			System.out.println(" i " + i);
    		}
    		if (actions[i].equals("push")) {
    			stack.push(new Integer(splits[i]));
    		} else if (actions[i].equals("pop")) {
    			System.out.println(" pop "+ stack.pop());
    		} else if (actions[i].equals("popMax")) {
    			System.out.println(" popMax " + stack.popMax());
    		} else if (actions[i].equals("peekMax")) {
    			System.out.println(" peekMax " + stack.peekMax());
    		}
    	}
 
    	
    	/*
    	 * System.out.println(stack.peekMax());
    	System.out.println(stack.popMax());
    	System.out.println(stack.popMax());
    	System.out.println(stack.top());*/
    }
}

class Node {
    int val = 0;
    Node prev, next;
    
    public Node() {
    }
    
    public String toString() {
    	return prev != null ? prev.toString() : null + " -> " + val + " -> "+ (next != null ? next.toString() : null) + " "; 
    }
}