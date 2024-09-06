
package com.mycompany.lru;

public class Node {
    
    Node next, prev;
    String key;
    String value;
    
    Node(String key,String value,Node next, Node prev){
        this.next = next;
        this.prev = prev;
        this.key = key;
        this.value = value;
    }

    public void setPrev(Node prev) {
        this.prev = prev;
    }

    public Node getPrev() {
        return prev;
    }

    public String getKey() {
        return key;
    }

    public void setNext(Node next) {
        this.next = next;
    }

    public Node getNext() {
        return next;
    }

    public String getValue() {
        return value;
    }
    
     public void Delete() {
        this.next = null;
        this.prev = null;
        this.key  = null;
        this.value= null;
    }
    
}
