# CS09

### Check List

## FP
- 반복을 스트림으로 대체해 변화 줄이기
- 반복을 재귀로 바꿔 간결하고 부작용 없는 알고리즘 만들기

### 재귀
- 함수형 메서드는 입력 인수와 출력 결과만을 가짐
- 같은 인수값으로 함수를 호출했을 때 항상 같은 값을 반환하면 참조 투명성을 갖는 함수
- 자바에서는 고전 방식의 재귀보다는 꼬리 재귀 지향(컴파일러 최적화)

### 커링
- 커링은 함수를 모듈화하고 코드 재사용에 도움

### 병렬성과 가변 데이터
- 스트림 메서드로 전달하는 코드는 다른 코드와 동시에 실행하더라도 안전하게 실행될 수 있어야 함

### 방어적 복사와 Unmodifiable Collection
// UnsupportedOperationException
- https://tecoble.techcourse.co.kr/post/2021-04-26-defensive-copy-vs-unmodifiable/