|          Kiosk Project          |  
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

**" Kiosk Project "**

## 2. 프로젝트 소개

- 해당 프로젝트는 사용자의 입력을 받아 주문을 처리하는 Kiosk Java Project 입니다.
- 최종 결과물은 `level7` 패키지이기 때문에 `level7` 패키지 참고 부탁드립니다.

## 3. 주요 프로젝트 패키지

### 1) `level7` 패키지

- [도전] level2 을 구현한 패키지입니다.
- **src/level7/Main.java** 를 실행 시키면 키오스크를 실행할 수 있습니다.
- `Main.java`: 키오스크를 실행하는 클래스
- `Menu.java`: Menu 를 관리하는 클래스
- `MenuItem`: MenuItem 을 관리하는 클래스
- `Cart.java`: 장바구니 를 관리하는 클래스
- `CartItem`: 장바구니 속 MenuItem 을 관리하는 클래스
- `Kiosk`: Menu 정보를 담고 있으며, 키오스크 역할을 담당하는 클래스
- `Discount`: `Eunm` 을 활용하여 사용자별 Discount Type 을 담고 있는 클래스

### 2) `io` 패키지

- `Input`: 입력을 담당하는 클래스
- `Output`: 출력을 담당하는 클래스

----

# 🌟 프로젝트의 주요 기능

## `level7` 패키지 를 중심으로 설명했습니다.

### 1) 메뉴 관리

- 키오스크는 Menu와 MenuItem을 사용하여 다양한 카테고리(버거, 음료, 디저트)에 속하는 메뉴 항목들을 제공합니다.

### 2) 장바구니 관리

- 사용자는 원하는 메뉴를 장바구니에 추가하거나 삭제할 수 있으며, 장바구니에서 주문을 확인하고 최종 결제를 처리할 수 있습니다.

### 3) 주문 및 결제

- 주문은 메뉴 항목을 선택하여 장바구니에 추가하는 방식으로 이루어지며, 최종적으로 사용자는 장바구니의 항목들을 확인하고 결제할 수 있습니다.

### 4) 할인 적용

- 주문을 결제할 때, 사용자가 선택한 할인 유형(국가유공자, 군인, 학생 등)에 맞춰 할인율을 적용합니다. 
- 할인율은 Discount Enum을 사용하여 적용됩니다.

### 5) 입력/출력:

- 시스템은 Input 클래스를 통해 사용자 입력을 받으며, Output 클래스를 통해 시스템의 상태나 결과를 출력합니다.

---

# 📑 요구사항

## [ 🐣 필수 기능 🐣 ] 

### Lv 1. 기본적인 키오스크 프로그래밍 

#### 1) Scanner 를 활용한 입력

- `int inputNumber = sc.nextInt();` 를 통하여 사용자를 입력을 활용

#### 2) 반복문과 조건문을 활용한 입력 처리

- `while` 이용하여 `0(Exit)` 입력 전까지 반복 
- `Switch` 이용하여 사용자의 입력에 따라 조작

### Lv2. 객체 지향 설계를 적용한 햄버거 메뉴의 클래스 관리

#### 1) 클래스에 요구사항에 따른 필드값이 존재하는가

- `MenuItem.java` 에 `Field` 값 [`menuName`, `menuPrice`, `menuDescription`] 선언

#### 2) List 와 new 키워드를 활용했는가

- `List<MenuItem> menuItems = new ArrayList<>();` 를 통해 `List` 선언
- `add(new MenuItem())` 를 코드를 통하여 적절히 `new` 키워드 활용

### Lv3. 객체 지향 설계를 적용한 순서 제어의 클래스 관리

#### 1) Kiosk 클래스 생성 및 활용

- `MenuItem` 을 관리하는 리스트 `Field` 로 존재
- `Kiosk(List<MenuItem> menuItems)` 생성자를 통해 값을 할당 

#### 2) `start()` 메서드 활용한 입/출력 및 종료 흐름 처리

- `Main.java` 가 관리하던 입력과 반복문 로직을 `start()` 함수로 관리

### Lv 4. 객체 지향 설계를 적용한 음식 메뉴와 주문 내역의 클래스 기반 관리

#### 1) Menu 클래스를 활용한 메뉴 카테고리 관리 및 MenuItem 리스트 포함 여부

- `Menu.java` 클래스를 생성 후 `Menu` 를 관리
- `List<MenuItem> menuItems = new ArrayList<>();` 를 통하여 `MenuItem` 리스트를 `Field`로 선언
- `menu.menuItems.add(new MenuItem())` 를 통하여 `Menu` 속에 포함된 `List<MenuItem>`에 `MenuItem` 객체 삽입

#### 2) 메뉴 카테고리 이름을 반환하는 메서드 구현 여부

- `getCategoryName()` 함수를 통하여 카테고리 이름 반환

### Lv 5. 캡슐화 적용

#### 1) 접근 제한자 활용

- `Field` 로 선언된 지역 변수들을 `Default` -> `private` 변경
- 일부 `Field` 는 `final` 로 선언.

#### 2) Getter/Setter 를 활용해 데이터에 접근 여부

- `getCategoryName()` 등 여러 개의 `Getter` 함수 생성
- `addMenuItems()` 등 여러 개의 `Setter` 함수 생성


## [ 🐔 도전 기능 🐔 ]

### Lv 1. 장바구니 및 구매하기 기능 추가

#### 1) 장바구니 기능 추가 여부

- `Cart.java` 를 통하여 장바구니 객체 관리
- `CartItem.java` 를 통하여 장바구니이 포함된 `item` 객체 관리 

#### 2) 주문 흐름 동작 여부

- [메인메뉴] ➡ [메인메뉴 선택] ➡ [서브메뉴] ➡ [서브메뉴 선택] ➡ [장바구니 추가 여부] ➡ [장바구니 추가] 
- [메인메뉴] ➡ [장바구니 확인] ➡ [주문하기] ➡ [장바구니 초기화]

#### 3) 잘못된 입력값에 대한 예외처리 여부

- `IndexOutOfBoundsException`: 범위 밖의 값을 받았을 경우 예외 발생 
- `cart.cartItemsNotEmpty()` : 장바구니가 없을 경우 Main Menu 에서 접근 불가
- `InputMismatchException`, `NullPointerException`, `NumberFormatException`: `Input.java` 클래스에서 재귀 

### Lv 2. Enum, 람다 & 스트림을 활용한 주문 및 장바구니 관리

#### 1) Enum 을 활용한 사용자 유형별 할인율 관리 여부

- `Discount.java` 에서 `enum`을 관리
- `Kiosk.java` 에서 `enum`을 활용하여 사용자 유형별 할인율 관리

#### 2) 람다/스트림을 활용한 장바구니 조회 기능 여부

- `Menu.java` 클래스에서 `showMenuItems()` 함수를 이용하여 리스트를 순차적으로 조회
- `Kiosk.java` 클래스에서 `determineDiscount()` 함수를 이용하여 `enum Type`을 순차적으로 조회
- `Cart.java` 클래스에서 `removeCartItems()` 함수를 이용하여 장바구니에서 특정 메뉴 빼기 기능

---


**"도전과제 Lv.2 를 기준으로 작성되었습니다."**

## 📂 Cart

### 🛒 `Cart.java`

#### 1. 필드
- `Map<String, CartItem> cartItemMap`: 장바구니에 담긴 메뉴 아이템과 수량을 관리하는 맵.

#### 2. `addCartItems(MenuItem menuItem)`
- 메뉴 항목을 장바구니에 추가.
- 이미 장바구니에 있으면 수량만 추가, 없으면 새로 추가.

#### 3. `showCartItems()`
- 장바구니의 모든 아이템을 출력.
- 각 메뉴 이름, 가격, 수량을 출력하고 총 금액도 계산하여 표시.

#### 4. `getTotalPrice()`
- 장바구니에 담긴 모든 아이템의 총 가격을 계산

#### 5. `isCartNotEmpty()`
- 장바구니가 비어 있지 않으면 `true`, 비어 있으면 `false` 반환

#### 6. `clearCartItems()`
- 장바구니를 비우는 기능

#### 7. `removeCartItems()`
- 장바구니에서 특정 메뉴를 삭제.
- 메뉴가 없으면 재입력 요청.

### 🛒 `CartItem.java`

#### 1. 필드
- `menuItem`: `MenuItem` 객체 (메뉴 항목)
- `itemQuantity`: 항목의 수량, 기본값은 `1`

#### 2. 생성자
- `CartItem(MenuItem menuItem)`: `MenuItem`을 받아 `menuItem` 필드 초기화

#### 3. Getter 메서드
- `getMenuItem()`: `MenuItem` 객체 반환
- `getCartItemName()`: 메뉴 이름 반환
- `getItemQuantity()`: 항목 수량 반환

#### 4. Setter 메서드
- `addCartItemQuantity()`: 항목 수량 1 증가

#### 5. 장바구니 항목 출력
- `showAllCartItems()`: "메뉴 이름, 가격, 설명, 수량"을 출력 형식에 맞춰 표시

----

## 📂 Menu

### 🍽️ **`Menu.java`**

#### 1. 필드
- `categoryName`: 메뉴 카테고리 이름
- `menuItems`: `MenuItem` 객체들을 담는 리스트

#### 2. 생성자
- `Menu(String categoryName)`: 카테고리 이름을 받아 `categoryName` 필드 초기화

#### 3. Getter 메서드
- `getMenuItems()`: `MenuItem` 객체들이 담긴 리스트 반환
- `getCategoryName()`: 메뉴 카테고리 이름 반환
- `showMenuItems()`: 메뉴 항목을 순차적으로 번호와 함께 출력

#### 4. 메뉴 선택 출력 (`displaySelectedMenu(Integer index)`)
- 사용자가 선택한 메뉴 인덱스가 유효하면 선택된 메뉴 출력
- 유효하지 않으면 범위 초과 메시지 출력

#### 5. Setter 메서드
- `addMenuItems(MenuItem menuItem)`: 새로운 `MenuItem`을 메뉴에 추가

### 🍔 **`MenuItem.java`**

#### 1. 필드
- `menuName`: 메뉴 이름
- `menuPrice`: 메뉴 가격
- `menuDescription`: 메뉴 설명

#### 2. 생성자
- `MenuItem(String menuName, Integer menuPrice, String menuDescription)`: 메뉴 이름, 가격, 설명을 받아 `menuName`, `menuPrice`, `menuDescription` 필드 초기화

#### 3. Getter 메서드
- `getMenuPrice()`: 메뉴 가격 반환.
- `getMenuDescription()`: 메뉴 설명 반환.
- `getMenuName()`: 메뉴 이름 반환.

#### 4. 메뉴 출력 형식 지정
- `menuFormatString(boolean gap)`
  - `gap = true`: 일정한 간격을 주어 메뉴 이름, 가격, 설명 출력 
  - `gap = false`: 간격 없이 메뉴 이름, 가격, 설명을 출력

----

## 📂 etc

### ⚡ **`Main.java`**

- `Kiosk` 를 실행시켜주는 클래스

### 📱 **`Kiosk.java`**

#### 1.필드
- `menus` (List<Menu>): 메뉴 목록을 저장하는 리스트.

#### 2. 생성자
- `Kiosk()`: `menus` 필드를 초기화하는 생성자. `initMenus()` 메서드를 호출하여 메뉴들을 초기화합니다.

#### 3. 메서드

- `initMenus()`: 기본 메뉴와 메뉴 항목을 초기화하여 `menus` 리스트를 반환.
- `start()`: 키오스크 메인 루프. 사용자 입력을 받아 메인 메뉴와 서브 메뉴를 처리.
- `showAllCategory()`: 모든 메뉴 카테고리를 출력.
- `getSpecificMenus(Integer index)`: 인덱스를 받아 특정 메뉴를 반환.
- `getSpecificMenuItem(Menu menu, Integer index)`: 특정 메뉴의 항목을 반환.
- `showMainMenu(Cart cart, Menu menu)`: 메인 메뉴를 출력. 장바구니 상태에 따라 출력 항목이 달라짐.
- `showSubMenu(Menu menu)`: 선택한 메뉴의 서브 메뉴를 출력.
- `confirmOrReturn(Cart cart)`: 장바구니에서 주문을 확정하거나, 메뉴로 돌아가거나, 항목을 삭제할 수 있는 기능.
- `determineDiscount(Cart cart)`: 사용자 유형에 맞는 할인율을 적용하고 최종 금액을 계산.
- `processSubMenuSelection(Menu menu, Cart cart)`: 서브 메뉴에서 항목을 선택하고 장바구니에 추가하는 처리.
- `processCartInput(Menu menu, int orderMenuItem, Cart cart)`: 장바구니에 메뉴 항목을 추가할지 결정하는 함수.


### 💸 **`Dicount.java`** - enum

#### 1. 필드
- `userType`: 할인 대상의 사용자 유형 (예: 국가유공자, 군인, 학생, 일반인).
- `type`: 할인 대상의 유형 번호.
- `rate`: 할인율 (예: 0.9는 10% 할인).

#### 2. 생성자
- `Discount(int type, String userType, Double rate)`: 할인 정보를 초기화하는 생성자

#### 3. 메서드
- `getUserType()`: 할인 대상의 사용자 유형을 반환
- `getRate()`: 할인율을 반환
- `getType()`: 할인 유형 번호를 반환
- `getPercent()`: 할인율을 백분율로 계산하여 반환


---

## ️️🪢 데이터 흐름 (Data Flow)

### 1. Kiosk 객체 생성 및 시작 

- `main()`: Kiosk 클래스의 `start()` 메서드가 호출되면서 키오스크 시스템이 시작됩니다.

### 2. 메뉴 초기화

- `initMenus()`: Kiosk 클래스는 `initMenus()` 메서드에서 각 메뉴 카테고리 (버거, 음료, 디저트)를 초기화하고, 각 카테고리에는 여러 메뉴 항목이 추가됩니다.

### 3. 메인 메뉴 출력 및 사용자 입력 처리

- `start()`: 메인 메뉴가 출력되고, 사용자는 카테고리를 선택합니다.
- 선택한 카테고리별로 해당 메뉴 항목이 출력되며, 사용자는 원하는 메뉴를 장바구니에 추가하거나 취소할 수 있습니다.

### 4. 하위 메뉴 처리 

- `processSubMenuSelection()`: 사용자가 메뉴 항목을 선택하면 해당 항목을 장바구니에 추가할지 취소할지 결정합니다.

### 5. 장바구니 확인 및 최종 주문 처리 

- `confirmOrReturn()`: 사용자가 장바구니를 확인하고 주문을 최종적으로 확정하거나 취소할 수 있습니다.
- 주문 확정 시, 할인 적용 여부가 결정됩니다.

### 6. 할인 적용

- `determineDiscount()`: 사용자가 선택한 할인 종류에 따라 할인율이 적용되며, 해당 할인율에 맞춰 최종 가격이 계산됩니다.

### 7. 장바구니 취소 및 비우기:

- 사용자는 장바구니를 비우거나 특정 항목을 삭제할 수 있습니다.

---

# 다른 패키지 설명

### 1) `level1` 패키지

- [필수] level1 을 구현한 패키지입니다.
- src/level1/Main.java 를 실행 시키면 키오스크를 실행할 수 있습니다.
- `Main.java`: 키오스크 역할을 담당하고, 실행하는 클래스

### 2) `level2` 패키지

- [필수] level2 을 구현한 패키지입니다.
- src/level2/Main.java 를 실행 시키면 키오스크를 실행할 수 있습니다.
- `Main.java`: 메뉴 정보를 담고 있으며, 키오스크 역할을 담당하고 실행하는 클래스
- `MenuItem`: MenuItem 을 관리하는 클래스

### 3) `level3` 패키지

- [필수] level3 을 구현한 패키지입니다.
- src/level3/Main.java 를 실행 시키면 키오스크를 실행할 수 있습니다.
- `Main.java`: 메뉴 정보를 담고 있으며, 키오스크를 실행하는 클래스
- `MenuItem`: MenuItem 을 관리하는 클래스
- `Kiosk`: 키오스크 역할을 담당하는 클래스

### 4) `level4` 패키지

- [필수] level4 을 구현한 패키지입니다.
- src/level4/Main.java 를 실행 시키면 키오스크를 실행할 수 있습니다.
- `Main.java`: 메뉴 정보를 담고 있으며, 키오스크를 실행하는 클래스
- `Menu.java`: Menu 를 관리하는 클래스
- `MenuItem`: MenuItem 을 관리하는 클래스
- `Kiosk`: 키오스크 역할을 담당하는 클래스

### 5) `level5` 패키지

- [필수] level5 을 구현한 패키지입니다.
- src/level5/Main.java 를 실행 시키면 키오스크를 실행할 수 있습니다.
- `Main.java`: 메뉴 정보를 담고 있으며, 키오스크를 실행하는 클래스
- `Menu.java`: Menu 를 관리하는 클래스
- `MenuItem`: MenuItem 을 관리하는 클래스
- `Kiosk`: 키오스크 역할을 담당하는 클래스

### 6) `level6` 패키지

- [도전] level1 을 구현한 패키지입니다.
- src/level6/Main.java 를 실행 시키면 키오스크를 실행할 수 있습니다.
- `Main.java`: 메뉴 정보를 담고 있으며, 키오스크를 실행하는 클래스
- `Menu.java`: Menu 를 관리하는 클래스
- `MenuItem`: MenuItem 을 관리하는 클래스
- `Cart.java`: 장바구니 를 관리하는 클래스
- `CartItem`: 장바구니 속 MenuItem 을 관리하는 클래스
- `Kiosk`: 키오스크 역할을 담당하는 클래스


---


## 📚 Stacks

### ✔️ Environment
<img src="https://img.shields.io/badge/intellijidea-000000?style=for-the-badge&logo=intellijidea&logoColor=white"> <img src="https://img.shields.io/badge/github-181717?style=for-the-badge&logo=github&logoColor=white"> <img src="https://img.shields.io/badge/git-F05032?style=for-the-badge&logo=git&logoColor=white">


### ✔️ Project
<img src="https://img.shields.io/badge/Java-007396?style=for-the-badge&logo=Java&logoColor=white"> 

<br>
<br>
