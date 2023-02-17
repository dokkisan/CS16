# CS12

> CS12. HTTP 분석기 미션 설명은 크롱과 함께!
CS스터디에서 네트워크 발표도 했었는데. . HTTP 동작 원리는 전혀 알지 못해서 생활코딩 영상을 보고 정리함 🐰..

## [HTTP 소개](https://opentutorials.org/course/3385/21673)

#### 클라이언트와 서버

- 클라이언트 client
  : 서버에게 **요청 request** 하는 컴퓨터.

    - 무엇을 요청하는가? 웹 페이지의 **컨텐츠 contents.**
      HTML, CSS, JS, img, etc.

- 서버 server
  : 클라이언트로부터 요청을 받아 **응답 response** 하는 컴퓨터.
  <br>

#### HTTP, HyperText Transger Protocol

: HTTP는 request와 response로 구성된 메시지, 서로가 알아들을 수 있는 서로의 약속.

HTTP는 하이퍼텍스트가 다니는 도로라고 할 수 있음.

*구글 크롬 - 개발자 도구 - Network 탭에 들어가 각 파일을 클릭하면 HTTP 요청 내역을 알 수 있음.


#### 웹 브라우저, 웹 서버

- 웹 브라우저는 사용자가 요청한 정보를 웹 서버에게 대신 물어봐줌. ```request header```

- 웹 서버는 자신이 가지고 있는 정보를 보내주면서 응답 헤더를 만듦. ```response header```

- 웹 브라우저는 웹 서버로부터 응답받은 정보를 화면에 그려줌.
  <br>

## [Request message](https://opentutorials.org/course/3385/21674)

### HTTP request format
![](https://velog.velcdn.com/images/esgibtnureins/post/9347dfa0-11f1-49e9-84c6-f6b977014fd9/image.png)

- Request Line
  : Request Message의 가장 첫 줄. (== 요청 행)

- Request Headers
  : Request Line 과 Request Message Body 사이 부분에 해당.
  (Request Headers 와 Request Body 사이에는 한 줄이 띄워져 구분되어 있음)

- Request Message Header
  : Request Line 과 Request Headers를 묶어 부르는 부분.

- Request Body (또는 페이로드)
  : 클라이언트가 요청 시 서버 쪽으로 전송해야 할 정보가 있을 때, Request Body에 넣어서 보냄.
  <br>

#### Request Line

``` java
GET /doc/test.html HTTP/1.1
```

- ```GET```
  웹 서버-웹 브라우저 간의 통신 방식을 나타내는 부분(method).
  GET은 데이터를 웹 서버로부터 가져올 때 사용하는 방식.

- ```/doc/test.html```
  웹 브라우저가 웹 서버에게 요청하는 정보가 무엇인지 나타내는 부분.

- ```HTTP/1.1```
  웹 브라우저가 현재 사용하고 있거나 사용할 수 있는 프로토콜과 그 버전을 나타내는 부분.
  (웹 서버가 해당 HTTP버전을 기준으로 자원을 보내주도록 함)

#### Request Headers

- ```Host``` (필수)
    - 요청하는 웹 사이트의 웹 서버 주소.
      웹 서버는 이 주소에 따라 다른 정보를 보내줄 수 있음. (이걸 '가상 호스트' 라고 부름)

- ```User Agent```
    - 웹 브라우저의 다른 표현.
      어떤 웹 브라우저와 운영체제를 사용하는지 확인 가능. (로봇이 접근하면 웹 서버가 차단 가능)

- ```Accept-Encoding```
    - 웹 브라우저가 지원하는 압축 방식.
      웹 브라우저와 웹 서버가 통신할 때 응답하는 데이터가 많으면 그걸 압축해서 전송, 웹 브라우저가 압축을 풀어서 처리할 수 있음. -> 네트워크 자원 절약

- ```If-Modified-Since```
    - 파일의 최종 수정 날짜.
      웹 서버에게 요청하는 파일이 이전에 웹 브라우저가 요청한 적이 있는 파일이라면,
      웹 브라우저가 가지고 있는 파일의 최종 수정 날짜(마지막으로 웹 서버로부터 다운로드 받은 날짜)를 함께 보내며 요청함.
      웹 서버는 요청한 파일의 최종 수정 날짜를 보고, 웹 브라우저가 가진 파일이 최신이라면 미전송.
      웹 서버가 가진 파일이 더 최신이라면 최신 파일을 전송해 줌.
      -> 같은 페이지에 자주 방문하는 경우, 같은 파일을 매번 요청하지 않아도 되어 효율성과 응답 속도를 높일 수 있음.
      <br>

## [Response message](https://opentutorials.org/course/3385/21675)

### HTTP response format
![](https://velog.velcdn.com/images/esgibtnureins/post/e1a98724-8081-4e3b-af7a-7dc0124ac563/image.png)

- Status 또는 Status Line
  서버가 응답했을 때 정상 / 비정상 응답인지,
  비정상 응답이라면 어떤 오류가 발생했는지 나타내는 부분.

    1. ```version``` : HTTP 버전에 대한 정보

    2. ```status code``` : 서버의 응답 결과를 나타내는 코드

       - ```1xx``` : Information
          100번대 코드는 어떠한 정보를 의미함.

       - ```2xx``` : Successes
          200번대 코드는 서버가 성공적으로 응답했음을 의미함.

       - ```3xx``` : Redirection
          300번대 코드는 서버가 요청을 redirection 했음을 의미함.

       - ```4xx``` : Client Error
          400번대 코드는 client errror를 의미함.
          *```404 Not Found``` : 클라이언트가 서버에 없는 데이터를 요청했을 때 발생.

       - ```5xx``` : Server Error
          500번대 코드는 서버 측 에러를 의미함.   
          *```500 Internal Server Error``` : 서버 내부적인 문제로 응답할 수 없을 때 발생.

    3. ```phrase``` : ```status code```를 인간이 이해할 수 있게 풀어 쓴 부분.


- Response Headers   
  *1.Status Line과 2.Response Header를 묶어 부르는 부분.


- Response Message Body (또는 페이로드)
  서버가 응답해주는 컨텐츠가 담긴 실제 내용에 해당.
  (Request와 마찬가지로, Herders와 한 줄 띄어져 있음)
  <br>

#### HTTP Response Message
![](https://velog.velcdn.com/images/esgibtnureins/post/39ceb7f1-6cfc-49fa-86b2-0a477e587613/image.png)

1. Status Line

   1) ```HTTP/1.1``` : ```version```을 나타내는 부분.

   2) ```200``` : ```status code```를 나타내는 부분.

   3) ```OK``` : ```phrase```를 나타내는 부분.

2. Response Headers

   1) ```Content-Type``` : 웹 서버가 응답한 컨텐츠에 대한 정보를 나타내는 부분.
   웹 브라우저는 이 정보를 기준으로 화면에 해당 응답을 어떻게 나타낼지 결정함.
   *```Content-Type : text/html```은 해당 응답이 HTML로 된 text 파일임을 의미

   2) ```Content-Length``` : 웹 서버가 응답한 컨텐츠의 전체 길이를 나타내는 부분. (단위는 **byte**)

   3) ```Content-Encoding``` : 해당 컨텐츠가 압축된 방식을 나타내는 부분.
   웹 브라우저는 이 정보를 기준으로 컨텐츠 압축을 해제해 화면에 나타냄.

   4) ```Last-Modified``` : 해당 컨텐츠가 마지막으로 수정된 날짜를 나타내는 부분.
   <br>


#### +HTTP와 네트워크에 대해 공부해 볼 만한 주제들
```https```(```SSL```), ```cache```, ```cookie```와 ```web storage```, ```proxy```(중개 서버), 네트워크 모니터링 도구(크롬 개발자도구 또는 wireshark)