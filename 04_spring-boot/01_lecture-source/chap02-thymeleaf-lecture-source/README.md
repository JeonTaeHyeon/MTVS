# Thymeleaf

<aside>
💡 '**템플릿 엔진**'의 일종. html 태그에 속성을 추가해 페이지에 동적으로 값을 추가하거나 처리할 수 있다.

</aside>

![Untitled](C:\Users\user\Downloads\18962159-d64c-4eaf-ab23-c6048ad103ae_Export-59e838ac-80d6-422d-83aa-e19311c0d37b\Thymeleaf 09ed77ca1c0745ff9199082786f07424\Untitled.png)

> 즉 server side 렌더링을 수행하기 때문에 server와 정상적으로 연결되어 있지 않는다면 작동하지 않
>

templates밑에는 forward를 통해서만 접근할 수 있고 우리한테는 html로 보이지만 thymeleaf라고 생각해야됨

![Untitled](Thymeleaf%2009ed77ca1c0745ff9199082786f07424/Untitled%201.png)

Application을 config하위에 이동시키면  error가 발생함.

component scan을 하는 base package를 설정 안해줘서 오류가 발생하는것임

![Untitled](Thymeleaf%2009ed77ca1c0745ff9199082786f07424/Untitled%202.png)

![Untitled](Thymeleaf%2009ed77ca1c0745ff9199082786f07424/Untitled%203.png)

해결하기 위해서 contextconfiguration class를 만들고 basepackage를 바꿔주면 해결할 수 있음.

![Untitled](Thymeleaf%2009ed77ca1c0745ff9199082786f07424/Untitled%204.png)

![Untitled](Thymeleaf%2009ed77ca1c0745ff9199082786f07424/Untitled%205.png)

static은 직접 접근 가능, templetes는 직접 접근 불가

```html
<li>prototype-only 주석</li>
<!--/*/  주석내용  /*/-->
```

프로토타입 주석은 서버 거쳐서오면 보인다?

## 변수표현식

```html

<button onclick="location.href='/lecture/expression?title=표현식&no=5&no=6'">표현식</button>

<h2>변수표현식${...}</h2>
<p th:text="${param.title}"></p>
<p th:text="${param.no[0]}"></p>
<p th:text="${param.no[1]}"></p>
```

## 메세지 표현

```java
<h2>메세지 표현식 #{...}</h2>
<p th:text="#{message.value}"></p>
```

message는 messages.properties에 저장되어 있음.

## 링크 표현식

```java
<h2>링크 표현식@{...}|</h2>
<a th:href="@{/}">메인으로</a>
```

## 선택 변수 표현식

```java
mv.addObject("member",new MemberDTO("홍길동",20,'남',"서울시"));
```

```html
<h2>선택 변수 표현식 *{...}</h2>
<p th:text="${member.name}"></p>
```

내부적으로 getter를 호출하도록 되어있음

메번 member.하면서 접근하면 힘드니까 div를 사용해서 더욱 간편하게 사용할 수 있음

```html
<div th:object="${member}">
    <p th:text="*{age}"></p>
    <p th:text="*{gender}"></p>
    <p th:text="*{address}"></p>

</div>
```

변수 표현식으로 객체를 가져오고 선택 변수 표현식으로 객체의 멤버에 접근할 수 있음.

```html
<h2>HTML 출력 th:text, th:utext, th:value</h2>
<ul>
    <l1 th:text="${hello}"></l1>
    <l1 th:utext="${hello}"></l1>
    <li><input type="text" th:value="타입리프"></li>
</ul>
```

![Untitled](Thymeleaf%2009ed77ca1c0745ff9199082786f07424/Untitled%206.png)

그냥 text를 사용하면 문자 그대로가 오고 utext를 사용하면 태그가 적용돼서 나옴, value를 사용하면  초기값 설정할 수 있음

## 인라인 표현식

```html
<h2 th:inline="none">인라인 표현식 [[...]] <- th:text, [(...)] <= th:utext</h2>
```

```html
<script th:inline="javascript">
    window.onload=function (){
        let hello = '[[${hello}]]';
        alert(hello);
    }
</script>
```

thymeleaf에서 변환할 때 자동으로 “”로 감싸주기 때문에 ‘’사용하여 error를 피할 수 있음.

## 리터럴 치환

```html
<h2>리터럴 치환 ||</h2>
<p th:object="${member}" th:text="|*{name}|"></p>
```

내가 할땐 오류가 안나는데..

## th:block

```html

<h2>th:block</h2>
<th:block th:object = "${member}">
    <p th:text="*{age}"></p>
</th:block>
```

div처럼 사용할 수 있다.

# 제어문

## th:if, th:unless

```html
<h2>th:if, th:unless</h2>
<p th:if="${num>0}">넘어온 값은 0보다 크다.</p>
<p th:if="${num<=0}">넘오온 값은 0보다 작거나 같다.</p>
<p th:unless = "${num<0}">넘어온 값은 0보다 크다.</p>
<!--unless는 조건에 해당하지 않으면 렌더링 시키고 if 는 조건에 해당하면 렌더링-->

<th:block th:if="${str=='사과'}">
    <p>사과가 좋아요</p>
</th:block>
<th:block th:if="${str=='바나나'}">
    <p>바나나가 좋아요</p>
</th:block>
<p th:if="${num>0 and num<=10}">1부터 10까지의 양수</p>
<p th:if="${str!=null and str=='바나나'}">바나나</p>
<!--
    utility object(method를 사용하기 위해 utility object를 사용할 수 있음
    - String
    - Numbers
    - Object
    - Arrays
    - Lists
    - Maps
    - Messages
    - Date
    - Calendars
-->
```

## th:switch th:cace

```html
<h2>th: switch, th:case</h2>
<th:block th:switch="${str}">
    <span th:case = "사과">사과가 선택되었습니다.</span>
    <span th:case = "바나나">바나나가 선택되었습니다.</span>
</th:block>
```

## th:each

```html
<h2>th:each</h2>
<table border="1">
    <tr>
        <th>이름</th>
        <th>나이</th>
        <th>성별</th>
        <th>주소</th>

    </tr>
    <tr th:each="member : ${members}">
        <td th:text = "${member.name}"></td>
        <td th:text = "${member.age}"></td>
        <td th:text = "${member.gender}"></td>
        <td th:text = "${member.address}"></td>
    </tr>
</table>

<h2>#numbers를 이용한 반복문</h2>
<th:block th:each="num:${#numbers.sequence(5,10)}">
    <a th:href="@{|/numbering/${numStat.count}|}" th:text="번호 + ${num}">번호</a>

</th:block>
```

## 페이징 처리?

```html
<body>
    <h1 align="center">기타</h1>
    <th:block th:with = "start = ${ selectCriteria.startPage }, last = ${ selectCriteria.endPage }">
        <th:block th:each="p:${#numbers.sequence(start,last)}">
            <th:block th:if="${selectCriteria.pageNo eq p}">
                <button th:text = "${p}" disabled></button>
            </th:block>

            <th:block th:if = "${selectCriteria.pageNo ne p}">
                <button th:text="${p}"></button>
            </th:block>

        </th:block>

    </th:block>
</body>
```

현재 페이지는  disabled로 선택할 수 없게 만들어