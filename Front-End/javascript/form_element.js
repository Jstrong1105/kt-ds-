onload = function () {
  // alert("hello");
  // 아이다가 email인 input 에 oninput 이벤트가 발생하면
  // 해당 엘리먼트의 부모인 .page-123 을 찾고
  // 부모의 자식 중 클래스가 email-value인 엘리먼트에
  // email의 value를 작성한다.
  document.querySelector("input#email").oninput = function () {
    // alert("hello");
    this.closest(".page-123").querySelector(".email-value").innerText =
      this.value;
  };

  // 아이디가 jobs인 select 에 onchange 이벤트가 발생하면
  // 해당 엘리먼트의 부모인 .page-124 를 찾고
  // 부모의 자식 중 클래스가 job-value인 엘리먼트에
  // jobs 의 value를 작성한다.
  document.querySelector("select#jobs").onchange = function () {
    // alert("hello");
    this.closest(".page-124").querySelector(".job-value").innerText =
      this.value;
  };

  // input 태그 중 타입이 radio 이면서 name 이 age 인 엘리먼트에
  // input[type=radio][name=age]
  // onchange 이벤트가 발생하면 해당 엘리먼트의 부모인 .page-125를 찾고
  // 부모의 자식 중 클래스가 name-value 인 엘리먼트에
  // input의 value 를 작성한다.
  document
    .querySelectorAll("input[type=radio][name=age]")
    .forEach(function (inputElement) {
      inputElement.onchange = function () {
        // alert("hello");
        this.closest(".page-125").querySelector(".name-value").innerText =
          this.value;
      };
    });

  //   document
  //     .querySelectorAll("input[type=checkbox][name=favorate-genre]")
  //     .forEach(function (inputElement) {
  //       inputElement.onchange = function () {
  //         //alert("hello");
  //         //console.dir(this);
  //         //console.log(this.checked);
  //         const genreValue = document.querySelector(".favorate-genre-value");
  //         if (this.checked) {
  //           if (!genreValue.innerText) {
  //             genreValue.innerText += this.value;
  //           } else {
  //             genreValue.innerText += `, ${this.value}`;
  //           }
  //         } else {
  //           // console.dir(genreValue);
  //           // console.dir(genreValue.innerText.__proto__);
  //           let text = genreValue.innerText;
  //           text = text.replace(`, ${this.value}`, "");
  //           text = text.replace(`${this.value}, `, "");
  //           text = text.replace(this.value, "");
  //           genreValue.innerText = text;
  //         }
  //       };
  //     });

  document
    .querySelectorAll("input[type=checkbox][name=favorate-genre]")
    .forEach((eachInput) => {
      eachInput.onchange = function () {
        // alert("hello");
        const genreValue = document.querySelector(".favorate-genre-value");
        // genreValue.textContent = "";
        // console.log(genreValue);

        const inputs = document.querySelectorAll(
          "input[type=checkbox][name=favorate-genre]",
        );
        // console.log(inputs);

        const textValue = Array.from(inputs)
          .filter((input) => input.checked)
          .map((input) => input.value)
          .join(", ");
        // console.log(textValue);

        genreValue.textContent = textValue;

        // console.log(evt.target);

        if (!this.checked) {
          document.querySelector("#checked-all").checked = "";
        } else {
          const allInput = Array.from(
            document.querySelectorAll(
              "input[type=checkbox][name=favorate-genre]",
            ),
          ).filter((eachInput) => !eachInput.checked);

          if (allInput.length == 0) {
            document.querySelector("#checked-all").checked = "checked";
          }
        }
      };
    });

  document.querySelector("#checked-all").onchange = (evt) => {
    // alert("hello");

    let inputList = Array.from(
      document.querySelectorAll("input[type=checkbox][name=favorate-genre]"),
    );

    // console.log(selectAll);
    // console.dir(selectAll);

    if (evt.target.checked) {
      inputList
        .filter((eachInput) => !eachInput.checked)
        .forEach((eachInput) => {
          eachInput.checked = "checked";
        });
    } else {
      inputList
        .filter((eachInput) => eachInput.checked)
        .forEach((eachInput) => {
          eachInput.checked = "";
        });
    }

    document
      .querySelector("input[type=checkbox][name=favorate-genre]")
      .onchange();
  };

  document
    .querySelector("input[type=checkbox][name=favorate-genre]")
    .onchange();
};
