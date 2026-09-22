/*
    DOM
    > HTML 문서를 브라우저가 읽으면서 태그별로 객체화 시켜둔 것

    DOM Tree
    > DOM 간의 관계 (자식, 형제, 부모)

    DOM 종류
    > DOM, Shadow DOM (Virtual DOM)
    > Shadow DOM (Virtual DOM) >> 스크립트에 의해 생성된 DOM
*/

onload = function () {
  const priceDom = document.querySelector(".package-ticket-price");
  //   priceDom?.onclick = function () {
  //     alert("hello world");
  //   };
  priceDom?.addEventListener("click", function () {
    alert("hello world");
  });

  const buttons = document.querySelectorAll("button.package-green-button");
  buttons.forEach(function (btn) {
    btn.onclick = function () {
      const package = btn.closest("div.package");
      const price = package.dataset.price;
      const area = package.querySelector("div.package-button-area");
      const p = document.createElement("p");
      // p.innerText = "From $" + price;
      p.innerText = `From $${price}`;
      p.classList.add("package-ticket-price");
      p.onclick = function () {
        alert("hello world");
      };
      area.append(p);
      // btn.closest("div").after(p);
      btn.remove();
    };
  });
};
