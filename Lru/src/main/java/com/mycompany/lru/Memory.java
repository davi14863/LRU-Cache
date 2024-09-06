
package com.mycompany.lru;

public class Memory {
    
    Node head = null;
    
    public void addNode(String key, String value){

        Node node = new Node(key,value, head, null);
        if (head != null)head.setPrev(node);
        head = node;   
        //System.out.println("added: Key = " + key + " Value = " + value);

    }
    
    public String getValue(String key){
        
        Node cursor = head;
        
        while(cursor != null){
            
        if(cursor.getKey().equals(key))
            break;
        cursor = cursor.getNext();
        }
        if(cursor == null)return "Memoria Vazia";
        return cursor.getValue();

    }
    
    
    
}
