import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.Iterator;

public class List_Set_diff {

    public static void main(String[] args) {
        // Set으로 보는 ArrayList와 차이점.
        
        // Set은 중복을 허용하지 않는다.
        // 이미 들어가 있는 데이터와 비교 한 후, 중복이 있으면 등록하지 않는다.
        // 순서는 없다. - 뒤죽박죽이다. => 리스트는 순서가 있다.
        HashSet<String> A = new HashSet<String>();
        A.add("aim");
        A.add("kim");
        A.add("asm");
        A.add("jin");
        A.add("jung");
        A.add("hun");

        Iterator e = (Iterator) A.iterator();
        while (e.hasNext()) { // hasnext() bool 형 반환.
            System.out.println(e.next());
        }

        // 완전히 풀네임을 입력해야지 결과가 반환 된다.
        boolean IsContains = A.contains("kim");
        System.out.println("Contains 'kim': " + IsContains);

        // 특정 문자열이 포함된 데이터 찾기
        String searchString = "a";

        // hashcode를 구하는 방법
        System.out.println(new String("aim").hashCode());
        System.out.println(new String("asm").hashCode());

        // Set을 순회를 시킨다음에 찾을 문자만 입력해도 검색이 된다. 
        // 캐시미스 (cache miss) : 1차로 cache에 데이터 조회, 2차로 DB 조회.
        for (String data : A) {
            if (data.contains(searchString)) {
                System.out.println("Found: " + data);
            }
        }

        // ArrayList은 중복을 허용하지 않는다.
        System.out.println("\n");
        ArrayList<String> B = new ArrayList<String>();
        B.add("aim");
        B.add("kim");
        B.add("kim");
        B.add("jin");
        B.add("jung");
        B.add("hun");

        Iterator s = (Iterator) B.iterator();
        while (s.hasNext()) {
            System.out.println(s.next());
        }

    }
}