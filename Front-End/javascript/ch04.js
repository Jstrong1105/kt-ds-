onload = function () {
  const button = document.querySelector("button.package-green-button");
  // console.dir(button);

  button.onclick = function () {
    const p = document.createElement("p");
    p.innerText = "From $399.99";
    p.classList.add("package-ticket-price");

    this.after(p);
    this.remove();
  };
};

// // p 태그를 동적으로 생성.
// const newParagraph = document.createElement("p");

// // p 태그의 Content 영역에 "From $399.99" 작성
// newParagraph.innerText = "From $399.99";

// // p 태그에게 package-ticket-price 클래스를 할당
// // console.dir(newParagraph.classList);
// newParagraph.classList.add("package-ticket-price");

// // 1. package-button-area의 내부 아래쪽에 p 태그를 추가
// // .package-button-area DOM(Element) 가져오기
// // const area = document.querySelector("div.package-button-area");

// // .package-button-area DOM 내부 아래에 p 태그를 추가한다
// // area.append(newParagraph);

// // 2. package-green-button 아래에 p 태그를 추가
// const button = document.querySelector("button.package-green-button");
// button.after(newParagraph);

// // pacakge-green-button 태그 제거
// button.remove();
