//package CS08;
//
//import java.util.HashSet;
//import java.util.Iterator;
//import java.util.Set;
//import java.util.stream.IntStream;
//
//public class ClassifierAlpha {
//    private int number;
//
//    public ClassifierAlpha(int number) {
//        this.number = number;
//    } // 생성자
//
//    public boolean isFactor(int potentialFactor) {
//        return number % potentialFactor == 0; // number가 정수인지 확인
//    }
//
////    public Set<Integer> factors() { // 약수를 찾는 메서드
////        HashSet<Integer> factors = new HashSet<>();
////        for (int pod = 1; pod <= Math.sqrt(number); pod++) { // number의 제곱근이 pod보다 작거나 같으면 실행
////            double zz = Math.sqrt(number); // 확인용
////            if (isFactor(pod)) { // number % potentialFactor == 0
////                factors.add(pod); // factor에 num의 약수 추가
////                factors.add(number / pod); // factor에  num의 약수/pod 값 추가
////            }
////        }
////        return factors;
////    }
//
////    public static Set<Integer> factors() {
////        HashSet<Integer> factors = new HashSet<>();
////        IntStream.range(1, Math.sqrt(number))
////
////    }
//
//
//
//
//    // reduce? (결과 취합. 합계 구하기)
//    static public int sum(Set<Integer> factors) {
//        Iterator iterator = factors.iterator();
//        int sum = 0;
//        while (iterator.hasNext()) { // factor에 남아있는 값 확인
//            sum += (Integer) iterator.next(); // factor의 값을 가져와서 sum에 모조리 더한다?
//        }
//        return sum;
//    }
//
//    public boolean isPerfect() {
//        return sum(factors()) - number == number; // number 정수를 모든 더한 값 - number == number // 퍼펙트의 의미는..?
//    }
//
//    public boolean isAbundant() {
//        return sum(factors()) - number > number;
//    }
//
//    public boolean isDeficient() {
//        return sum(factors()) - number < number;
//    }
//
//    public static void main(String[] args) {
//        ClassifierAlpha alpha1 = new ClassifierAlpha(10);
//        ClassifierAlpha alpha2 = new ClassifierAlpha(6);
//
//        System.out.println(alpha1.isPerfect());
//        System.out.println(alpha2.isPerfect());
//    }
//}