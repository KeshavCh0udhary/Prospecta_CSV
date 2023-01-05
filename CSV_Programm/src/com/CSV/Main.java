package com.CSV;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;

public class Main{
    
    public static void main(String[] args) {
   
  	  String file = "src\\file.csv";
  	  BufferedReader reader = null;
  	  String line = "";
  	  
  	  try {
	  	   reader = new BufferedReader(new FileReader(file));
	  	   while((line = reader.readLine()) != null) {
	  	       
		  	    String[] row =  line.split(",(?=([^\"]*\"[^\"]*\")*[^\"]*$)");
		  	    getData(row);
		  	    
	  	   }
  	  }
  	  catch(Exception e) {
  	       e.getMessage();
  	  }finally {
	  	   try {
	  	       reader.close();
	  	   } catch (IOException e){
	  	       e.getMessage();
	  	   }
  	  }
  	}
	
    static HashMap<String,Integer> getData(String[] arr){
    	
    	HashMap<String,Integer> map = new HashMap<>();
    	
    	for(String s : arr) {
    		
    		String[] val = s.split(":");    		
    		String k = val[0].trim();
    		String v = val[1].trim();
    		
    		if(v.charAt(0) != '=') {
    			
    			map.put(k, Integer.parseInt(v));
    			
    		}else {
    			
    			v = v.substring(1, v.length());
    			
    			String v1 = "", v2 = "";
    			int Case = 0;
    			char operator = '.';
    			for(char c : v.toCharArray()) {
    				
    				if(c == '+' || c ==  '-' || c == '*' || c =='/') { 
    					Case = 1;
    					operator = c;
    					continue;
    				}
    				
    				switch(Case) {
   
    			 	    case 0 :
    			 	    	v1 += c;
    			 	    	break;
    			 	    case 1 :
    			 	    	v2 += c;
    			 	    	break;
    				}
    				
    			}
    			if(v1.charAt(0) > 57 && v2.charAt(0) > 57) {
    				
    				switch(operator) {
    				
    				     case '+' :
    				    	
    				    	 map.put(k, map.get(v1)+map.get(v2));
    				    	 break;
    				     
    				     case '-' :
    				    	 map.put(k, map.get(v1)-map.get(v2));
    				    	 break;
    				    	 
    				     case '*' :
    				    	 map.put(k, map.get(v1)*map.get(v2));
    				    	 break;
    				    	 
    				     case '/' :
    				    	 if(map.get(v2) != 0)
    				    	    map.put(k, map.get(v1)/map.get(v2));
    				    	 break;
    				
    				}
    				
    			}else if(v1.charAt(0) <= 57 && v2.charAt(0) <= 57) {
    				
    				switch(operator) {
    				
				     case '+' :
				    	 map.put(k, Integer.parseInt(v1) + Integer.parseInt(v2));
				    	 break;
				     
				     case '-' :
				    	 map.put(k, Integer.parseInt(v1) - Integer.parseInt(v2));
				    	 break;
				    	 
				     case '*' :
				    	 map.put(k, Integer.parseInt(v1) * Integer.parseInt(v2));
				    	 break;
				    	 
				     case '/' :
				    	 if(Integer.parseInt(v2) != 0)
				    	    map.put(k, Integer.parseInt(v1) / Integer.parseInt(v2));
				    	 break;
				
				   }
    				
    			}else if(v1.charAt(0) > 57 && v2.charAt(0) <= 57) {
    				
    				switch(operator) {
    				
				     case '+' :
				    	 map.put(k, map.get(v1) + Integer.parseInt(v2));
				    	 break;
				     
				     case '-' :
				    	 map.put(k, map.get(v1) - Integer.parseInt(v2));
				    	 break;
				    	 
				     case '*' :
				    	 map.put(k, map.get(v1) * Integer.parseInt(v2));
				    	 break;
				    	 
				     case '/' :
				    	 if(Integer.parseInt(v2) != 0)
				    	    map.put(k, map.get(v1) / Integer.parseInt(v2));
				    	 break;
				
				   }
    				
    			}else if(v1.charAt(0) <= 57 && v2.charAt(0) > 57) {
					   
    				switch(operator) {
    				
				     case '+' :
				    	 map.put(k, Integer.parseInt(v1) + map.get(v2));
				    	 break;
				     
				     case '-' :
				    	 map.put(k, Integer.parseInt(v1) - map.get(v2));
				    	 break;
				    	 
				     case '*' :
				    	 map.put(k, Integer.parseInt(v1) * map.get(v2));
				    	 break;
				    	 
				     case '/' :
				    	 if(map.get(v2) != 0)
				    	    map.put(k, Integer.parseInt(v1) / map.get(v2));
				    	 break;
				
				   }
					   	
    		    }
    			
    		}
    		
    	}
    	
    	System.out.println(map);
    	
    	return map;
    	
    }
    
}