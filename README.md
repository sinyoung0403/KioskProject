|          📱 Kiosk Project 📱          |  
|:-------------------------------------:|
| <img src="https://github.com/user-attachments/assets/6d48f3cc-b8d9-46f1-91bb-ae2b599fe4ce" alt="image" width="300"> |



---

# 🧑‍💻 개발자 소개

|  |                                   팀원                                   |
|:-------------:|:----------------------------------------------------------------------:|
|프로필| ![image](https://avatars.githubusercontent.com/u/94594402?v=4&size=64) |
|이름|                                  박신영                                   |
|GitHub|                              sinyoung0403                              |
|기술블로그|                 [블로그](https://sintory-04.tistory.com/)                 |

---

# ⚒ 프로젝트

## 1. 프로젝트 이름

- **" Kiosk Project "**

## 2. 프로젝트 소개

- 해당 프로젝트는 사용자의 입력을 받아 주문을 처리하는 Kiosk Java Project 입니다.

## 3. 프로젝트 패키지 설명 음 'ㅡ' .. 이 설명이 뒤로 가야하나 ..

### 1) `level1` 패키지

- level1 을 구현한 패키지입니다. 
- src/level1/Main.java 를 실행 시키면 키오스크를 실행할 수 있습니다.
- `Main.java`: 키오스크 역할을 담당하고, **실행하는 클래스**

### 2) `level2` 패키지

- level2 을 구현한 패키지입니다.
- src/level2/Main.java 를 실행 시키면 키오스크를 실행할 수 있습니다.
- `Main.java`: 메뉴 정보를 담고 있으며, 키오스크 역할을 담당하고 **실행하는 클래스**
- `MenuItem`: MenuItem 을 관리하는 클래스

### 3) `level3` 패키지

- level3 을 구현한 패키지입니다.
- src/level3/Main.java 를 실행 시키면 키오스크를 실행할 수 있습니다.
- `Main.java`: 메뉴 정보를 담고 있으며, **키오스크를 실행하는 클래스**
- `MenuItem`: MenuItem 을 관리하는 클래스
- `Kiosk`: 키오스크 역할을 담당하는 클래스

### 4) `level4` 패키지

- level4 을 구현한 패키지입니다.
- src/level4/Main.java 를 실행 시키면 키오스크를 실행할 수 있습니다.
- `Main.java`: 메뉴 정보를 담고 있으며, **키오스크를 실행하는 클래스**
- `Menu.java`: Menu 를 관리하는 클래스
- `MenuItem`: MenuItem 을 관리하는 클래스
- `Kiosk`: 키오스크 역할을 담당하는 클래스

### 5) `level5` 패키지

- level5 을 구현한 패키지입니다.
- src/level5/Main.java 를 실행 시키면 키오스크를 실행할 수 있습니다.
- `Main.java`: 메뉴 정보를 담고 있으며, **키오스크를 실행하는 클래스**
- `Menu.java`: Menu 를 관리하는 클래스
- `MenuItem`: MenuItem 을 관리하는 클래스
- `Kiosk`: 키오스크 역할을 담당하는 클래스

### 6) `level6` 패키지

- level6 을 구현한 패키지입니다.
- src/level6/Main.java 를 실행 시키면 키오스크를 실행할 수 있습니다.
- `Main.java`: 메뉴 정보를 담고 있으며, **키오스크를 실행하는 클래스**
- `Menu.java`: Menu 를 관리하는 클래스
- `MenuItem`: MenuItem 을 관리하는 클래스
- `Cart.java`: 장바구니 를 관리하는 클래스
- `CartItem`: 장바구니 속 MenuItem 을 관리하는 클래스
- `Kiosk`: 키오스크 역할을 담당하는 클래스

### 7) `level7` 패키지

- level7 을 구현한 패키지입니다.
- src/level7/Main.java 를 실행 시키면 키오스크를 실행할 수 있습니다.
- `Main.java`: 키오스크를 실행하는 클래스
- `Menu.java`: Menu 를 관리하는 클래스
- `MenuItem`: MenuItem 을 관리하는 클래스
- `Cart.java`: 장바구니 를 관리하는 클래스
- `CartItem`: 장바구니 속 MenuItem 을 관리하는 클래스
- `Kiosk`: Menu 정보를 담고 있으며, 키오스크 역할을 담당하는 클래스
- `Discount`: `Eunm` 을 활용하여 사용자별 Discount Type 을 담고 있는 클래스

### 8) `io` 패키지

- `Input`: 입력을 담당하는 클래스
- `Output`: 출력을 담당하는 클래스

## 4. 프로젝트의 주요 기능

### 1) 주문 기능

- 사용자의 입력을 통해 햄버거, 음료, 디저트 별 주문이 가능하다.
- 장바구니에 담긴 Menu 를 통하여 최종 주문이 가능하다.

### 2) 장바구니 기능

- 사용자가 주문한 Menu 를 장바구니에 저장, 삭제가 가능하다.

### 3) 할인 기능

- 사용자에 따라 다른 할인율을 적용하여 주문 가능하다.

---

# 📑 요구사항

## Lv 1. 기본적인 키오스크 프로그래밍 

### 1) Scanner 를 활용한 입력

- `int inputNumber = sc.nextInt();` 를 통하여 사용자를 입력을 활용

### 2) 반복문과 조건문을 활용한 입력 처리

- `while` 이용하여 `0(Exit)` 입력 전까지 반복 
- `Switch` 이용하여 사용자의 입력에 따라 조작

## Lv2. 객체 지향 설계를 적용한 햄버거 메뉴의 클래스 관리

### 1) 클래스에 요구사항에 따른 필드값이 존재하는가

- `MenuItem.java` 에 `flied` 값 [`menuName`, `menuPrice`, `menuDescription`] 선언

### 2) List 와 new 키워드를 활용했는가

- `List<MenuItem> menuItems = new ArrayList<>();` 를 통해 `List` 선언
- `add(new MenuItem())` 를 코드를 통하여 적절히 `new` 키워드 활용

## Lv3. 객체 지향 설계를 적용한 순서 제어의 클래스 관리

### 1) Kiosk 클래스 생성 및 활용

- `MenuItem` 을 관리하는 리스트 `flied` 로 존재
- Kiosk 생성자를 통해 값을 할당 `Kiosk(List<MenuItem> menuItems)`

### 2) `start()` 메서드 활용한 입/출력 및 종료 흐름 처리

- `Main.java` 가 관리하던 입력과 반복문 로직을 `start()` 함수로 관리

## Lv 4. 객체 지향 설계를 적용한 음식 메뉴와 주문 내역의 클래스 기반 관리

### 1) Menu 클래스를 활용한 메뉴 카테고리 관리 및 MenuItem 리스트 포함 여부

- 음 

### 2) 메뉴 카테고리 이름을 반환하는 메서드 구현 여부



---

## 📂 buttonListener

✔ `ButtonFunctionListener`

1. ◀ (Back):

- 입력값이 비어있지 않으면 마지막 입력값을 제거하고, presentLabel에 업데이트
- CalculatorList가 비어있을 경우, removeInputNumber()로 입력값만 제거

2. C (Clear):

- 모든 값 초기화 (clearInputNumber(), clearCalculatorList(), clearStepText())
- 초기화 후 stateLabel, presentLabel에 업데이트된 상태 반영

3. CE (Clear Entry):

- 현재 입력값만 초기화하고, presentLabel에 반영

4. Big:
- 입력값보다 큰 값들을 출력하는 기능
- saveResultList에서 현재 입력값보다 큰 값들을 필터링하여 보여줌
- 값이 없거나 saveResultList가 비어있을 경우 에러 메시지 출력

5. Del (Delete):

- saveResultList에서 첫 번째 값을 삭제하고, 해당 결과를 myList에 재출력
- 삭제된 값에 대한 알림 메시지 출력

6. Negative:

- 입력값이 음수가 아닌 경우 음수로 변경하여 presentLabel에 반영
- 이미 음수인 값에는 에러 메시지 출력

✔ `InputBtnClickListener`

1. 숫자 버튼 (1~9, 0):

- 버튼 클릭 시 해당 숫자를 입력값에 추가하고, label에 반영

2. 소수점 (.):

- 이미 소수점이 포함되어 있으면 에러 메시지를 출력
- 소수점이 없다면 입력값에 소수점을 추가하고, label에 반영

✔ `SymbolBtnClickListener`

1. 등호 버튼 (=):

- 현재 입력된 값이 비어 있으면 오류 메시지를 출력
- 입력값이 있으면 계산을 수행하고, 결과를 화면에 표시
- 연산 기록을 저장하고 계산 결과를 초기화

2. 사칙연산 버튼 (➕, ➖, *, ➗):

- 입력값이 없으면 오류 메시지 출력
- 입력값이 있으면 사칙연산을 수행하고, 해당 연산기호를 연산 리스트에 추가
- 계산 후 결과를 화면에 표시하고 연산 기록을 저장


## 📂 logic

✔ `Calculators`

1. 연산 기능 (ArithmeticCalculator)

- SUM(+): 더하기 연산 수행
- SUBTRACT(-): 빼기 연산 수행
- MULTIPLY(*): 곱하기 연산 수행
- DIVIDE(/): 나누기 연산 수행 (0으로 나누면 ArithmeticException 발생 및 Swing Dialog 출력)

2. 타입 변환 (toBigDecimal, toType)

- toBigDecimal(T number): T 타입 숫자를 BigDecimal로 변환
- toType(BigDecimal result): BigDecimal 값을 T 타입으로 변환

3. 숫자 설정 (setNum)

- 두 개의 숫자(num1, num2)를 설정하여 연산 준비

✔ `CalculatorState`

1. 데이터 관리

- calculatorList : 연산 대상 저장
- stepString : 연산 과정 표시
- inputString : 사용자 입력 값 저장
- saveList : 전체 결과 저장
- saveResultList : 연산 결과만 저장

2. 값 설정 및 추가

- add/setInputNumber(String number) : 입력값 추가/설정
- addSaveList(String text) : 결과 저장
- addSaveResultList(Double number) : 연산 결과 저장
- addCalculatorList(S number) : 연산 대상 추가

3. 값 조회

- getInputString() / getStepText() : 입력값 & 연산 과정 조회
- getCalculatorList() / getSaveList() / getSaveResultList() : 저장된 데이터 조회
- getCalculatorListSize() : 연산 대상 개수 반환


4. 값 삭제 및 초기화

- clearInputNumber() / clearStepText() / clearCalculatorList() : 입력 & 과정 초기화
- removeInputNumber() : 입력값 마지막 문자 삭제
- removeSaveList(int index) / removeSaveResultList(int index) : 특정 저장값 삭제

5. 라벨 수정

- insertLabel(JLabel label, String text) : UI 라벨 업데이트

--------------------

## 📂 swingui

✔ `swingUI`

1. UI 구성 요소
- 프레임: 계산기 창 생성 및 설정
- 패널: 버튼 및 레이블을 포함하는 컨테이너
- 라벨: stateLabel (계산 과정), presentLabel (입력값), myList (저장된 값) 표시
- 버튼:
    - 연산 버튼: sumBtn, subtractBtn, multiplyBtn, divideBtn, equalBtn
    - 숫자 버튼: btn0 ~ btn9, pointBtn
    - 기타 버튼: ceBtn, cBtn, backBtn, negativeBtn, delBtn, viewBtn

2. 버튼 클릭 리스너

-숫자 및 점 버튼: InputBtnClickListener → 입력값 처리
-연산 버튼: SymbolBtnClickListener → 연산 수행 및 계산 처리
-기타 버튼: ButtonFunctionListener → 지우기, 뒤로가기 등 기능 처리

3. 레이아웃 설정

- 프레임 크기: 460x540
- 버튼 배치: setBounds()로 버튼 위치 및 크기 설정
- 프레임 표시: frame.setVisible(true)로 화면에 출력

✔ `SwingOutput`

1. Error Dialog 출력

2. 안내문 출력

---

## ️️🪢 데이터 흐름 (Data Flow)

1. 사용자 입력 (Swing UI)

✔ 사용자가 **Swing UI**에서 버튼을 클릭하여 연산을 수행합니다.
- 숫자, 연산자, 기타 버튼 클릭

2. 버튼 클릭 리스너 (Button Click Listeners)

✔ 버튼 클릭에 따라 각기 다른 리스너가 호출됩니다:
- `InputBtnClickListener`: 숫자 클릭 시 처리
- `SymbolBtnClickListener`: 사칙연산 연산자 처리 (예: +, -, *, /)
- `ButtonFunctionListener`: 삭제 및 백스페이스 처리 (연산 결과 삭제)

3. 연산 요청 처리 (Calculation Request)

✔ **Calculator 클래스**에서 연산을 수행합니다.
- Enum 타입(`Operator`)을 사용하여 연산자 처리
- 제네릭을 사용하여 다양한 타입의 값을 연산
- `ArithmeticCalculator`에서 계산을 처리하고 결과를 컬렉션에 저장

4. 계산 결과 저장 (Calculation Results Storage)

✔ **CalculatorsState** 클래스의 컬렉션 필드에 연산 결과를 저장합니다.
- 캡슐화 되어 있어, 직접 접근할 수 없고 **getter**와 **setter** 메서드를 통해 간접 접근

5. 결과 출력 (Output)

✔ 계산된 결과는 **Swing UI**의 라벨을 통해 화면에 표시됩니다.
- **CalculatorState**의 `insertLabel` 메서드를 통해 **Swing UI** 의 라벨 조작

6. 연산 결과 삭제 (Delete Calculation)

✔ ButtonFunctionListener 클래스의 `actionPerformed` 메서드가 가장 먼저 저장된 연산 결과를 **CalculatorsState** 클래스에서 삭제
- 삭제 기능은 `removeSaveList()`와 `removeResultSaveList()` 메서드를 통해 처리

7. 값 비교 및 출력 (Compare and Print Results)

✔ 사용자가 **Swing UI**를 통해 입력한 값보다 큰 계산 결과들을 출력
- ButtonFunctionListener 클래스의 `actionPerformed` 메서드에서 사용하여 **Lambda**와 **Stream**을 활용하여 필터링하고 출력
- 이 기능은 저장된 연산 결과 리스트에서 입력 받은 값보다 큰 결과값 들만 출력한다.


### 📃 흐름 요약

1. 사용자 입력 → **Swing UI**
2. 버튼 클릭 → **InputBtnClickListener**, **SymbolBtnClickListener**, **ButtonFunctionListener**
3. 연산 요청 → **Calculator** 클래스 (Enum, 제네릭 사용)
4. 연산 결과 저장 → **CalculatorsState** (캡슐화된 컬렉션 필드)
5. 결과 출력 → **Swing UI** (CalculatorState 통해 업데이트)
6. 결과 삭제 → **ButtonFunctionListener** 클래스
7. 값 비교 → **Lambda & Stream**을 활용하여 **Swing UI**로 입력된 값보다 큰 결과값 출력

---

## 📚 Stacks

### ✔️ Environment
<img src="https://img.shields.io/badge/intellijidea-000000?style=for-the-badge&logo=intellijidea&logoColor=white"> <img src="https://img.shields.io/badge/github-181717?style=for-the-badge&logo=github&logoColor=white"> <img src="https://img.shields.io/badge/git-F05032?style=for-the-badge&logo=git&logoColor=white">


### ✔️ Project
<img src="https://img.shields.io/badge/Java-007396?style=for-the-badge&logo=Java&logoColor=white"> 

<br>
<br>
