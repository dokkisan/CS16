# cs07

# Check List

### 목표
- XML DOM Parser 동작 방식 이해
  - Parsing이 필요한 이유(XML 분석 이유)
- 객체지향적 설계 고민해보기

### 이론 학습
  - [ ] Tokenizer, Lexer, Parser
  - [ ] XML, DOM, HTML, plist

### 설계와 구현
  - [ ] 다이어그램 작성
  - [ ] 학습 과정 기록 // 진행중


# 이론 학습

parsing
- 문서 파싱은 브라우저가 코드를 이해하고 사용할 수 있는 구조(tree)로 변환하는 것을 의미

## 1. Tokenizer, Lexer, Parser

### 1.1. 컴파일러
- 소스코드를 기계어로 번역
- ```구문분석``` -> 최적화 -> 코드생성 -> 링킹
  - 구문분석 과정에서 소스코드는 Tokenizer, Lexer, Parser를 차례대로 지나가며 분석 진행

### 1.1. Tokenizer
소스코드를 의미있는 단위로 쪼갬(토큰화)

### 1.1. Lexer
주어진 토큰의 의미 분석

### 1.1. Parser
분석된 데이터 검증 및 AST 구조화


# 연결고리를 찾아서 ...

### 팰린드롬, 재귀 그리고 정규표현식

- 정규표현식 만으로 파싱할 수 없는 이유 중 하나는 회문(Palindrome)
  - 어떤 언어가 정규표현식으로 파싱이 될지 안될지는 정규표현식으로 작성을 시도했을때 표현이 한없이 길어지는지를 보거나, 재귀적인 문법이 있는지, 문맥 의존적인 문법이 있는지를 따져보는 것으로 알 수 있음
    - // W3 leetcode 문제 중 'palindrome number'가 생각남. 안 풀었는데.. 생각난 김에 풀어본다!
    
- 팰린드롬을 BNF로 표현하면 간단함
  - 일반적인 정규표현식에서는 BNF 같이 재귀적인 표현을 할 수 있는 기능을 제공하지 않음
    - // BNF 구조를 보니 직렬화가 떠오름. 왠지 망망대해로 떠내려 갈 것 같은 기분 :,)


### 직렬화

- 직렬화를 왜 하는가?
  - 사용하고 있는 데이터를 파일 저장 혹은 데이터 통신에서 파싱할 수 있는 유의미한 데이터를 만들기 위함

- 데이터 직렬화의 종류
  - CSV, XML, JSON 직렬화
    - 사이 읽을 수 있는 형태
    - 저장 공간 사용의 효율성이 떨어지고, 파싱하는 시간 오래 걸림
    - 데이터의 양이 적을 때 주로 사용
    - 최근에는 JSON 형태를 통해 데이터 직렬화를 많이 함
  - Binary 직렬화
    - 사람이 읽을 수 없는 형태
    - 저장 공간 사용이 효율적이고, 파싱하는 시간 빠름
    - 데이터의 양이 많을 때 주로 사용
  - Java 직렬화
    - Java 시스템 간의 데이터 교환이 필요할 때 사용

# 다이어그램
# 기능 목록
# 1. model
## XMLTokenizer
```XML 형식의 문자열을 토큰화하여 의미있는 단위로 가공```
### Field

### Method
- **tokenizeBySpace**(String XMLString)
  - 입력된 문자열을 공백을 기준으로 토큰화
    - 공백이 없을 경우 태그 사이에 공백 삽입?

## XMLLexer
```토큰의 어휘, 의미 분석```
### Field
- **Token**
- 
### Method
- 

## XMLParser
```문법 확인 및 AST 생성```
### Field

### Method


## Token
### Field

### Method

# 2. view
## OutputView
### Field

### Method
- **stringify**(boolean ?) // Validator에서 전달받을 예정
  - 문자열 리턴
  - boolean 값을 기준으로 "올바른 XML 형식이 아닙니다." 리턴

# 3. controller


# References
- [컴파일러 이론] Tokenizer, Lexer, Parser
  - https://trumanfromkorea.tistory.com/79
- JSON.parse 직접 만들어보기
  - https://medium.com/riiid-teamblog-kr/json-parse-직접-만들어보기-f567ecdf08c0
- [Java] 직렬화와 역직렬화
  - https://steady-coding.tistory.com/576