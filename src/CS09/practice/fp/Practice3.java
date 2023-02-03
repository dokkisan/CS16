package CS09.practice.fp;

import java.util.function.DoubleUnaryOperator;

// # 커링
public class Practice3 {
    static double converter(double x, double f, double b) {
        return x * f + b;
    }

    // 팩토리 정의
    static DoubleUnaryOperator curriedConverter(double f,double b) {
        return (double x) -> x * f + b;
    }

    // 팩토리를 이용해 변환기 생성
    DoubleUnaryOperator convertCtoF = curriedConverter(9.0/5, 32);
    DoubleUnaryOperator convertUSDtoGBP = curriedConverter(0.6, 0);
    DoubleUnaryOperator convertKmtoMi = curriedConverter(0.6214, 0);

    // 로직 재활용
    double gdp = convertUSDtoGBP.applyAsDouble(1000);

}
