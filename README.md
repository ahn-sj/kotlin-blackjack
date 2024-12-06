# kotlin-blackjack

## STEP 2

### 도메인 분석

- 블랙잭 게임은 딜러에게 카드를 받아 21에 가까운 수를 만드는 사람이 승리한다.
  - 21을 넘으면 패배한다.
- 게임을 시작하면 플레이어는 두 장의 카드를 지급 받는다.
- 두 장의 카드 숫자를 합쳐 21을 초과하지 않으면서 21에 가깝게 만들면 승리한다.
- 21을 넘지 않을 경우 원한다면 언제든지 카드를 계속 뽑을 수 있다.
- 대결 구도는 딜러 vs 플레이어

### 개념 모델

- 카드
  - 숫자 (2 ~ 10)
  - 무늬 (하트, 다이아몬드, 클럽, 스페이드)
  - Ace (1 또는 11) 
  - King, Queen, Jack
- 카드 덱
  - 블랙잭에서 덱은 플레이에 사용되는 카드 한 벌(52장의 카드로 구성된 카드 세트)을 뜻한다.
- 용어
  - 스플릿: ??
  - 버스트: 21을 초과하는 상황
    - 블랙잭에서 21을 초과하면 패배\
    - ex) 10과 9를 가지고 있을 때 3을 더하면 22가 되어 버스트가 된다.
- 플레이어

### 기능 요구 사항

- [ ] 숫자 계산은 카드 숫자를 기본으로 한다.
  - [ ] 숫자는 2 ~ 10까지의 숫자를 가진다.  
  - [ ] King, Queen, Jack 카드는 10으로 계산한다.
  - [ ] Ace 카드는 1 또는 11로 계산한다.
- [ ] 모든 엔티티를 작게 유지한다.

### 기능 구현 사항

- [x] 카드를 생성한다.
  - [x] 카드는 1~13까지의 숫자와 무늬(하트, 다이아몬드, 클럽, 스페이드)의 조합으로 이루어진다. 
  - [x] 총 52(13*4)개의 카드가 미리 생성돼있어야 한다.
- [x] 플레이어가 존재한다.
  - [x] 플레이어는 이름을 가진다.
  - [x] 플레이어는 여러 명이 존재할 수 있다.
  - [x] 플레이어는 카드를 여러 장 가질 수 있다.
- [x] 게임에 참여할 사람의 이름을 입력받는다.
  - [x] 플레이어(이름)는 쉼표(,)를 기준으로 구분한다.
- [x] 플레이어에게 카드를 2장씩 나눠준다.
- [x] 플레이어가 받은 카드를 출력한다.
- [x] 플레이어가 카드를 더 받을지 결정한다.
  - [x] y는 추가적인 카드를 받는다.
  - [x] n은 추가적인 카드를 받지 않는다.
    - [x] n을 입력하면 다음 플레이어에게 선택권이 넘어간다.
    - [x] 모든 플레이어가 선택이 끝나면 종료된다.
- [x] 플레이어의 모든 선택이 끝나면 플레이어의 카드 합을 계산한다.
  - [x] 플레이어의 카드 합을 출력한다.
- [x] 덱을 재사용하게 해야 한다.
- [x] 스페이스는 1 또는 11로 계산할 수 있다.
- [x] 테스트를 작성한다.
