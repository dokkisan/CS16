#CS10

### 문맥 교환(context switch)
- CPU가 다른 프로세스에게 넘어갈 때 OS는 다음을 수행
  - CPU를 내어주는 프로세스의 상태를 그 프로세스의 PCB에 저장
  - CPU를 새롭게 얻는 프로세스의 상태를 PCB에서 읽음

#### CPU dispatch
- 준비 상태에 있는 프로세스들 중에서 CPU를 할당받을 프로세스를 선택한 후 실제로 CPU의 제어권을 넘겨받는 과정

### PCB
- OS가 프로세스를 관리하기 위한 커널 내 자료구조
- process context를 구성하는 중요한 요소

#### PCB의 구성 요소
- 구성요소는 구조체로 유지   
(1) 운영체제가 관리상 사용하는 정보
>- **프로세스의 상태**(process state)
>  - CPU를 할당해도 되는지 여부 결정을 위해 필요
>- CPU 스케줄링 정보

(2) CPU 수행 관련 하드웨어값
>- **프로그램 카운터**(program counter)
   >  - 다음에 수행할 명령의 위치 가리킴
>- **CPU 레지스터 값**
   >  - CPU 연산을 위해 현 시점에 레지스터에 어떤 값을 저장하고 있는지 나타냄

>- 메모리 관리 정보
>- 자원 사용 정보
>- 입출력 상태 정보
