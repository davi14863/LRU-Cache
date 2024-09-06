
package com.mycompany.lru;

public class CacheMemory {
    
    int maxSize;
    Node head = null;
    int size = 0;
    
    CacheMemory(int size){
        maxSize = size;
    }
    
    
    
    public void addNode(String key, String value){

        Node node = new Node(key,value, head, null);
        head = node;   
        size ++;
        //System.out.println("added: Key = " + key + " Value = " + value);
        
        if(size > maxSize)discart();

    }
    
    public void discart(){

        Node cursor = head;
        
        for(int i = 0 ; i < maxSize - 1; i++){
        
        cursor = cursor.getNext();
        
        }
        cursor.getNext().Delete();
        cursor.setNext(null);
    }

    public int getSize() {
        return size;
    }
    
    public String getValue(String key){
        
        Node cursor = head;
        
        while(cursor != null){
            
            if(cursor.getKey().equals(key))
                break;
            cursor = cursor.getNext();
        }
        
        if(cursor == null)return null;
        
        addNode(cursor.getKey(),cursor.getValue());
        if(cursor.getPrev() != null)cursor.getPrev().setNext(cursor.getNext());
        if(cursor.getNext() != null)cursor.getNext().setPrev(cursor.getPrev());
        cursor.Delete();
        return head.getValue();

    }
}
