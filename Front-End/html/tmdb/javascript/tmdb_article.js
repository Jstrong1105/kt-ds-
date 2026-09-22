onload = async function () {
  // alert("hello");

  const params = new URLSearchParams(window.location.search);
  const movieId = params.get("movieId");
  // console.log(movieId);

  const prefixImgUrl = "https://image.tmdb.org/t/p/w400/";
  const prefixLogoUrl = "https://image.tmdb.org/t/p/w200/";

  const options = {
    method: "GET",
    headers: {
      accept: "application/json",
      Authorization:
        "Bearer eyJhbGciOiJIUzI1NiJ9.eyJhdWQiOiJhMzQyN2RjNmM3YjE5YTEzYTE5YmMzYzE4NzEzNDY0YiIsIm5iZiI6MTc4OTQ1OTM0Ni4wMzMsInN1YiI6IjZhYThmYjkyYjQ2ZWMzNmU1NDYwYjVhYiIsInNjb3BlcyI6WyJhcGlfcmVhZCJdLCJ2ZXJzaW9uIjoxfQ.pkHX6lKjxos0caQRiNVDs_ekIGxPNOa7RZhB8ubWYIY",
    },
  };

  let body;

  try {
    const fetchResult = await fetch(
      `https://api.themoviedb.org/3/movie/${movieId}?language=ko-KR`,
      options,
    );
    body = await fetchResult.json();
    // console.log(body);
    // console.log(body.adult);
  } catch (error) {
    alert("존재하지 않는 영화 아이디입니다.");
    window.location.herf = "./tmdb_main.html";
  }

  const movieInfo = document.querySelector(".movie-info");
  // console.log(movieInfo);
  // console.dir(movieInfo);
  movieInfo.style.backgroundImage = `linear-gradient(rgba(0, 0, 0, 0.9), rgba(0, 0, 0, 0.9)), url(${prefixImgUrl}${body.backdrop_path})`;

  const posterDom = document.querySelector(".poster-img");
  if (body.poster_path) {
    posterDom.setAttribute("src", `${prefixImgUrl}${body.poster_path}`);
  } else {
    posterDom.setAttribute("src", "https://placehold.co/400x600");
  }

  if (!body.softcore) {
    document.querySelector(".adult").remove();
  }

  document.querySelector(".title-text").innerText = body.title;
  document.querySelector(".tagline").innerText = body.tagline;
  document.querySelector("#release-date").innerText = body.release_date;
  document.querySelector("#runtime").innerText = `${body.runtime}분`;
  document.querySelector("#status").innerText = body.status;
  document.querySelector("#vote-average").innerText =
    `평점 ${body.vote_average}`;
  document.querySelector("#vote-count").innerText = `평가수 ${body.vote_count}`;

  const genreTemplate = document.querySelector("#genre-item-template");
  const genreInfoDom = document.querySelector(".genre-info");
  // console.log(genreTemplate);

  body.genres.forEach((eachGenre) => {
    let genreItem = document.importNode(genreTemplate.content, true);
    // console.log(genreItem);
    // console.log(eachGenre);
    genreItem.querySelector(".genre-item").innerText = eachGenre.name;
    genreInfoDom.append(genreItem);
  });

  document.querySelector(".overview").innerText = body.overview;
  document.querySelector(".budget-value").innerText = `${body.budget}`;
  document.querySelector(".revenue-value").innerText = `${body.revenue}`;

  const companyTemplate = document.querySelector("#company-item-template");
  const companyInfo = document.querySelector(".company-info");

  body.production_companies.forEach((eachCompany) => {
    const companyItem = document.importNode(companyTemplate.content, true);
    // console.log(companyItem);
    // console.dir(companyItem);
    companyItem
      .querySelector("img")
      .setAttribute("src", `${prefixLogoUrl}${eachCompany.logo_path}`);
    companyItem.querySelector("span").innerText = eachCompany.name;
    companyInfo.append(companyItem);
  });

  document.querySelector(".header-left").onclick = function () {
    window.location.href = "./tmdb_main.html";
  };

  const kwdFetch = await fetch(
    `https://api.themoviedb.org/3/movie/${movieId}/keywords`,
    options,
  );
  const kwdBody = await kwdFetch.json();

  const kwdDom = document.querySelector(".keyword");
  const kwdTemplate = document.querySelector("#keyword-item-template");

  kwdBody.keywords.forEach((eachKwd) => {
    // console.log(eachKwd);
    const kwdItem = document.importNode(kwdTemplate.content, true);
    kwdItem.querySelector(".keyword-item").innerText = eachKwd.name;
    kwdDom.append(kwdItem);
    // console.log(kwdItem);
  });
};
