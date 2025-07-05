package Feature;

import java.util.*;

public class Stringtest {
    public static void main(String[] args) {
        String str = "/";
        String[] arr = str.split("/");
        System.out.println(Arrays.toString(arr));
        System.out.println(str.length());


        Stringtest st =new Stringtest();
        st.minimumCost(3, 2, new int[]{1,3}, new int[]{5});
    }

    public int minimumCost(int m, int n, int[] horizontalCut, int[] verticalCut) {
        Map<String, Integer> map = new HashMap<>();
        return dfs(m, n, 0, 0,  horizontalCut,  verticalCut, map);
    }

    private int dfs(int m, int n, int hStart, int vStart, int[] hCost, int[] vCost, Map<String, Integer> map){
        if(m == 1 && n ==  1) return 0;
        String str = m + "+" + n + "+" + hStart + "+" + vStart;
        if(map.containsKey(str)){
            return map.get(str);
        }
        int res = Integer.MAX_VALUE;
        if( m > 1 ){
            for(int i = hStart;i < hCost.length; i++){

                int cur = hCost[i] + dfs(i - hStart + 1, n, hStart, vStart, hCost, vCost, map)
                        + dfs(m - i - 1, n, i+1, vStart, hCost, vCost, map);
                res = Math.min(res, cur);
            }
        }

        if( n > 1 ){
            for(int i = vStart;i < vCost.length; i++){

                int cur = vCost[i] + dfs(m, i - vStart + 1, hStart, vStart, hCost, vCost, map)
                        + dfs(m, n - i - 1, i+1, vStart, hCost, vCost, map);
                res = Math.min(res, cur);
            }
        }
        map.put(str, res);
        return res;

    }


}



