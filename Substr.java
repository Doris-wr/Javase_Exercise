import java.util.*;

public class Substr {
    public boolean[] chkSubStr(String[] p, int n, String s) {
        // write code here
        boolean[] hasSub=new boolean[p.length];
        for(int i=0;i<p.length;i++){
            hasSub[i]=s.contains(p[i]);
        }
        return hasSub;
    }
}
