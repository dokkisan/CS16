package CS09.practice;

// # 재귀
// 재귀를 이용하면 변화가 일어나지 않고, 루프 단계마다 갱신되는 반복 변수를 제거할 수 있음
// 팩토리얼 함수 (반복 + 재귀)

import java.util.stream.LongStream;

public class Practice2 {

    // 1. 반복 방식의 팩토리얼
    static int factorialIterative(int n) {
        int r = 1;
        for (int i = 1; i <= n; i++) {
            r *= i;
        }
        return r;
    }

    // 2. 재귀 방식의 팩토리얼
    static long factorialRecursive(long n) {
        return n == 1 ? 1 : n * factorialRecursive(n - 1);
    }

    // 3. 스트림 팩토리얼
    static long factorialStreams(long n) {
        return LongStream.rangeClosed(1, n)
                .reduce(1, (long a, long b) -> a + b);
    }

    // 일반적으로 반복 코드보다 재귀 코드가 더 비쌈
    // 함수 호출 시마다 호출 스택에 스택 프레임이 새로 만들어짐
    // 즉, 재귀 팩토리얼의 입력값에 비례해서 메모리 사용량 증가(스택오버플로우)


    // 4. 꼬리 재귀 팩토리얼
    // 꼬리 재귀 최적화(tail-call optimization)
    static long factorialTailRecursive(long n) {
        return factorialHelper(1, n);
    }
    static long factorialHelper(long acc, long n) {
        return n == 1 ? acc : factorialHelper(acc * n, n - 1);
    }
}
