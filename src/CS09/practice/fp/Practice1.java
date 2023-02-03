package CS09.practice.fp;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

// # 함수형 프로그래밍(FP)
public class Practice1 {
    static List<List<Integer>> subsets(List<Integer> list) {
        if (list.isEmpty()) {
            List<List<Integer>> ans = new ArrayList<>();
            ans.add(Collections.emptyList());
            return ans;
        }
        Integer first = list.get(0);
        List<Integer> rest = list.subList(1,list.size());

        List<List<Integer>> subans = subsets(rest);
        List<List<Integer>> subans2 = insertAll(first,subans);
        return concat(subans, subans2);
    }

    // Integer 객체가 불변이라는 사실을 이용
    // Integer가 불변이 아니라면 각 요소를 모두 복제해야 함
    static List<List<Integer>> insertAll(Integer first, List<List<Integer>> lists) {
        List<List<Integer>> result = new ArrayList<>();
        for (List<Integer> list: lists) {
            List<Integer> copyList = new ArrayList<>();
            copyList.add(first);
            copyList.addAll(list);
            result.add(copyList);
        }
        return result;
    }

    // 순수 함수
    // 내부적으로는 리스트 r에 요소를 추가하는 변화가 발생하지만,
    // 반환 결과는 오로지 인수에 의해 이뤄지며 인수의 정보는 변하지 않음
    static List<List<Integer>> concat(List<List<Integer>> a,
                             List<List<Integer>> b) {
        List<List<Integer>> r = new ArrayList<>(a);
        r.addAll(b);
        return r;
    }
}
