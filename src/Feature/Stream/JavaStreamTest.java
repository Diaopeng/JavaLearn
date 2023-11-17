package Feature.Stream;

public class JavaStreamTest {
    public String shortestBeautifulSubstring(String s, int k) {
        String res = "";
        int count = 0;
        int left = 0;
        for(int i = 0; i < s.length(); i++){
            if(s.charAt(i) == '1'){
                count++;
            }
            while(count == k && left < s.length() && s.charAt(left) == '0'){
                left++;
            }

        }
        return res;
    }
}
