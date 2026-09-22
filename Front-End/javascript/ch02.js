window.onload = function () {
  const promotion = document.querySelector(".promo");
  console.log(promotion);
  console.dir(promotion);

  promotion.onclick = function (event) {
    // console.log(arguments);
    console.log(event.target);
    console.log(this);

    // event.target.innerText += "를(을) 클릭했습니다.";
    this.innerText += "을(를) 클릭했습니다.";
    // alert("on click");
  };
};
