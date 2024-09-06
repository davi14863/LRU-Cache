package com.mycompany.lru;

public class Main {

    static int missCount = 0;
    static Memory memory;
    static CacheMemory cacheMemory;
    public static void main(String[] args) {
        
        memory = new Memory();
        cacheMemory = new CacheMemory(3);
        
        memoryStart();
        
        System.out.println(tryAccess("Variable 2"));
        
        System.out.println(tryAccess("Variable 7"));
          
        System.out.println(tryAccess("Variable 9")); 
        
        System.out.println(tryAccess("Variable 4"));
        
        System.out.println(tryAccess("Variable 7"));
          
        System.out.println(tryAccess("Variable 9")); 
         
        System.out.println("MISS Count: " + missCount); 
    }

    
    
    public static void memoryStart(){

        for(int i = 0 ; i < 100; i ++)memory.addNode("Variable " + Integer.toString(i), Integer.toString(i)); 
        //for(int i = 0 ; i < 100; i ++)System.out.print(memory.getValue("Variable " + Integer.toString(i)) + ",");
    }
    
    public static String tryAccess(String key){
        
        String result;

        result = cacheMemory.getValue(key);
            if(result == null){
                System.out.println("MISS");
                missCount ++;
                
                result = memory.getValue(key);
                
                cacheMemory.addNode(key, result);
            }else
                System.out.println("HIT");
        return result;
    }
  
}
