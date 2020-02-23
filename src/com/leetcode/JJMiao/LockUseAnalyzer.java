package com.leetcode.JJMiao;

import java.util.*;

public class LockUseAnalyzer {
    public static void main(String[] args) {


        List<String> events= Arrays.asList("ACQUIRE 364","ACQUIRE 84","RELEASE 84","RELEASE 364");
        System.out.println(check_log_history(events));


    }
   public  static int check_log_history(List<String> events) {
        HashSet<Integer> hs = new HashSet();
        Stack<Integer> st = new Stack();
        for(int i = 0; i < events.size(); i++){
            String e = events.get(i);
            String name = e.split(" ")[0];
            int num = Integer.parseInt(e.split(" ")[1]);
            if(name.equals("ACQUIRE")){
                if(hs.contains(num)){
                    return i+1;
                }
                st.push(num);
                hs.add(num);
            }else{
                if(!hs.contains(num) || st.peek() != num){
                    return i+1;
                }
                st.pop();
                hs.remove(num);
            }
        }
        return st.empty() ? 0 : events.size()+1;

    }

}
