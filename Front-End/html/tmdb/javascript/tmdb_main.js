onload = async function () {
  // alert("hello");

  const params = new URLSearchParams(window.location.search);
  // console.log(url);
  // console.dir(url);
  let page = params.get("page");
  if (!page) {
    page = 1;
  } else if (isNaN(page)) {
    alert("잘못된 URL");
    window.location.href = "https://www.google.com";
  } else if (page > 500) {
    page = 500;
  }

  const options = {
    method: "GET",
    headers: {
      accept: "application/json",
      Authorization:
        "Bearer eyJhbGciOiJIUzI1NiJ9.eyJhdWQiOiJhMzQyN2RjNmM3YjE5YTEzYTE5YmMzYzE4NzEzNDY0YiIsIm5iZiI6MTc4OTQ1OTM0Ni4wMzMsInN1YiI6IjZhYThmYjkyYjQ2ZWMzNmU1NDYwYjVhYiIsInNjb3BlcyI6WyJhcGlfcmVhZCJdLCJ2ZXJzaW9uIjoxfQ.pkHX6lKjxos0caQRiNVDs_ekIGxPNOa7RZhB8ubWYIY",
    },
  };

  const template = document.querySelector("#content-item").content;
  // console.log(template);

  function toElement(result) {
    result.forEach(function ({ id, poster_path, title }) {
      // console.log(poster_path, title);

      const temp = document.importNode(template, true);
      temp.querySelector(".item").dataset["movieId"] = id;
      if (!poster_path) {
        temp
          .querySelector(".poster > img")
          .setAttribute("src", `https://placehold.co/200x300`);
      } else {
        temp
          .querySelector(".poster > img")
          .setAttribute(
            "src",
            `https://image.tmdb.org/t/p/w200/${poster_path}`,
          );
      }

      temp.querySelector(".title").innerText = title;
      content.append(temp);
    });
  }

  const fetchResult = await fetch(
    `https://api.themoviedb.org/3/discover/movie?include_adult=true&include_video=false&language=ko-KR&page=${page}&sort_by=popularity.desc`,
    options,
  );
  const body = await fetchResult.json();
  // console.log(body.results);

  const content = document.querySelector(".content");

  // console.log(body.results);

  toElement(body.results);

  document.querySelectorAll(".item").forEach(function (eachItem) {
    eachItem.onclick = function () {
      // alert("hello");

      const movieId = this.dataset["movieId"];
      // console.log(movieId);

      window.location.href = `./tmdb_article.html?movieId=${movieId}`;
    };
  });

  document.querySelector(".page-before").onclick = function () {
    page--;
    if (page == 0) {
      page = 1;
    }

    window.location.href = `./tmdb_main.html?page=${page}`;
  };

  document.querySelector(".page-after").onclick = function () {
    page++;
    if (page == 501) {
      page = 500;
    }
    window.location.href = `./tmdb_main.html?page=${page}`;
  };
};
