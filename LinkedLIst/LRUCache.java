import java.util.*;
public class LRUCache {
	
	class DLinkedNode {
	    int key;
	    int value;
	    DLinkedNode prev;
	    DLinkedNode next;
	  }

	  private void add(DLinkedNode node) {
	    /**
	     * Always add the new node right after head.
	     */
	    node.prev = head;
	    node.next = head.next;

	    head.next.prev = node;
	    head.next = node;
	  }

	  private void delete(DLinkedNode node){
	    /**
	     * Remove an existing node from the linked list.
	     */
	    DLinkedNode prev = node.prev;
	    DLinkedNode next = node.next;

	    prev.next = next;
	    next.prev = prev;
	  }

	  private void moveToHead(DLinkedNode node){
	    /**
	     * Move certain node in between to the head.
	     */
	    delete(node);
	    add(node);
	  }

	  private DLinkedNode popTail() {
	    /**
	     * Pop the current tail.
	     */
	    DLinkedNode res = tail.prev;
	    delete(res);
	    return res;
	  }

	  Map<Integer, DLinkedNode> cache = new HashMap<>();
	  int size;
	  int capacity;
	  DLinkedNode head, tail;

	  public LRUCache(int capacity) {
	    this.size = 0;
	    this.capacity = capacity;
	    head = new DLinkedNode();
	    tail = new DLinkedNode();
	    head.next = tail;
	    tail.prev = head;
	  }

	  public int get(int key) {
	    DLinkedNode node = cache.get(key);
	    if(node == null) {
	    	return -1;
	    }
	    // every access we need to move the node to the front
	    moveToHead(node);
	    return node.value;
	  }

	  public void put(int key, int value) {
	    DLinkedNode node = cache.get(key);
	    if(node == null) {
	      DLinkedNode newNode = new DLinkedNode();
	      newNode.key = key;
	      newNode.value = value;
	      cache.put(key, newNode);
	      add(newNode);
	      size++;
	      if(size > capacity) {
	        // pop the tail
	        DLinkedNode tail = popTail();
	        cache.remove(tail.key);
	        size--;
	      }
	    } else {
	      // update the value.
	      node.value = value;
	      moveToHead(node);
	    }
	  }
}
