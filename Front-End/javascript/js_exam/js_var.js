var a = 10;
console.log(a);

// javascript는 타입이 존재하지 않는다

console.log(typeof a);

var b = true;
console.log(b, typeof b);

var c = "abcd";
console.log(c, typeof c);

var d = "abcdefg";
console.log(d, typeof d);

var e = `정세찬`;
console.log(e, typeof e);

var f = [1, 2, 3, 4, 5];
console.log(f, typeof f);

// js (Vanila) 변수의 특징
var number = 10;
console.log(number);

number = "20" + 2;
console.log(number);

var number = true;
console.log(number);

// 콘솔을 지워라.
clear();

// var result = 10;
var random = parseInt(Math.random() * 100);
console.log(random);

if (random >= 50) {
  var result = 30;
}
console.log(result);

// ECMAScript 2015 이후 부터는 var 를 사용하지 않는다.
// 대신 변수가 필요할 땐 let
// 상수가 필요할 땐 const 를 쓴다.
// let, const hoisting 현상이 발생하지 않는다.
let number = 10;
// let number = 20; // Error!

// console.log(result); // Error!
let result = 30;

console.log(number);

clear();

let arrays = [];
let arrays2 = [10, 20, 30, 40];
let arrays3 = [1, true, false, 1.2, "aa", "bb"];

console.log("arrays", arrays);
console.log("arrays2", arrays2);
console.log("arrays3", arrays3);

console.log("array.length", arrays.length);
console.log("arrays2.length", arrays2.length);
console.log("arrays3.length", arrays3.length);

console.log("arrays[0]", arrays[0]);
console.log("arrays[-1]", arrays[-1]);
console.log("arrays2[0]", arrays2[0]);
console.log("arrays2[1]", arrays2[1]);
console.log("arrays2[2]", arrays2[2]);
console.log("arrays2[3]", arrays2[3]);
console.log("arrays2[4]", arrays2[4]);

for (let i = 0; i < arrays3.length; i++) {
  console.log(arrays3[i]);
}

// for - in (배열의 인덱스를 가져와 반복)
for (let i in arrays3) {
  console.log(i, arrays3[i]);
}

// for - of (배열의 아이템을 하나씩 가져와 반복)
for (let value of arrays3) {
  console.log(value);
}

clear();

// 배열에 아이템 추가
// 배열.push(값); ==> 배열 가장 마지막에 추가
// 배열.unshift(값); ==> 배열 가장 앞부분에 추가
let newArray = [];
newArray.push(1);
newArray.push(2);
console.log(newArray);

newArray.push(3);
console.log(newArray);

newArray.unshift("A");
console.log(newArray);

newArray.unshift("B");
console.log(newArray);

// 아이템 제거
// 배열.pop(); ==> 가장 마지막에 있는 아이템 제거
// 배열.shift(); ==> 가장 앞부분에 있는 아이템 제거
// 배열.splice(n,m); ==> n번째 부터 m개 까지 제거

// newArray ==> B, A, 1, 2, 3
// 4번 인덱스 제거
let popValue = newArray.pop();
console.log(popValue);
console.log(newArray);

// newArray ==> B, A, 1, 2
// 0번 인덱스 제거
let shiftValue = newArray.shift();
console.log(shiftValue);
console.log(newArray);

// newArray ==> A, 1, 2
// 1번 인덱스부터 2번 까지 제거
let spliceValue = newArray.splice(1, 2);
console.log(spliceValue);
console.log(newArray);
// 배열 ==> Java 의 List 와 유사

// 객체 리터럴 { key : value, key : value ...}
// Java 의 Map 유사

clear();

let certificate = {
  issuedDate: "2026-09-14",
  name: "정보처리기사",
  org: "q-net",
};

console.log(certificate, typeof certificate);

console.log(certificate.issuedDate);
console.log(certificate.name);
console.log(certificate.org);
console.log(certificate.level);

console.log(certificate["issuedDate"]);
console.log(certificate["name"]);
console.log(certificate["org"]);
console.log(certificate["level"]);

// certificate 에게 level 값을 추가
certificate.level = "1급";

// certificate 에게 학점을 추가
certificate["point"] = "4점";

console.log(certificate);

// 객체 리터널의 값으로 사용할 수 있는 데이터 타입의 종류: all
certificate.사용처 = ["대학", "대학원", "학원", "회사", "학교", "기관"];
console.log(certificate);

certificate.가산점 = {
  대학: "1점",
  대학원: "2점",
  기관: "3점",
};
console.log(certificate);

// 객체 반복 (for - in)
for (let key in certificate) {
  console.log(key, certificate[key]);
}

// 가산점 키를 삭제.
delete certificate.가산점;
console.log(certificate);

console.log("document", document);
console.dir(document);
console.dir("abc".__proto__);
console.log("window", window);

clear();

function calcNumber(a = 0, b = 0, operator = "+") {
  if (operator === "+") {
    return a + b;
  } else if (operator === "-") {
    return a - b;
  } else if (operator === "*") {
    return a * b;
  } else if (operator === "/") {
    return a / b;
  }
}

function addAll() {
  // console.log(a, b, c);
  // console.log(arguments);
  let sum = 0;
  for (let value of arguments) {
    sum += value;
  }
  return sum;
}

function add(a, b) {
  let result = a + b;
  console.log("결과:", result);
}

function getAddResult(a, b) {
  let result = a + b;
  return result;
}

// add 와 getAddResult 함수가 어디에 만들어져있을까?
/*
브라우저는 여러개의 tab을 동시에 실행시키는 애플리케이션
하나의 탭 마다 별도의 웹 페이지가 표시되는 역할
각 탭은 하나의 웹 페이지를 표시하기 위해서 
"전역(Global)" 범위의 상수를 사용.
==> window 상수 객체 (페이지의 정보, 함수, 객체, 배열 등)
*/
clear();

// 1. 함수는 변수에 할당 가능하다.
const fn = function add(a, b) {
  console.log(a + b);
};

// 2. 함수 표현식 (function expression)
// 이름이 없는 함수를 변수에 할당하는 방법
// 함수를 변수에 할당할 때, 함수의 이름은 작성하지 않는다. (익명 함수)
const fn2 = function (a, b) {
  console.log(a + b);
};

// 3. 콜백 함수 (callback function)
// 어떤 작업 중에 실행되길 희망하는 함수
// 파라미터로 전달되는 함수
// 예 > 1부터 10000 까지 반복하여 더하는 과정 중에
// 더한 값이 5의 배수일 때, 특정 함수가 실행되길 바랄 때 사용하는 함수 작성 패턴
function addFromTo(from, to, callbackFunction) {
  let sum = 0;
  for (let i = from; i <= to; i++) {
    sum += i;

    if (sum % 5 == 0) {
      callbackFunction(sum);
    }
  }
  return sum;
}

const printNum = function (num) {
  console.log("현재 값:", num);
};
