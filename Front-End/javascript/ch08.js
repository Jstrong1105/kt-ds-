/** @format */

// 클래스가 load-posts 인 버튼을 클릭하면 https://jsonplaceholder.typicode.com/posts
// 의 데이터를 fetch해 .posts에 채운다. (async & await 사용)
// template: post-item-template 사용.

onload = function () {
  const userButton = document.querySelector(".load-git-users");
  userButton.onclick = function () {
    function fillUsers(userList) {
      const template = document.querySelector("#github-user-template");
      const users = document.querySelector(".github-users");

      users.innerHTML = "";

      userList.forEach(function ({ html_url, avatar_url, login }) {
        const userDom = document.importNode(template.content, true);
        userDom.querySelector("a").setAttribute("href", html_url);
        userDom.querySelector("img").setAttribute("src", avatar_url);
        userDom.querySelector(".user-name").innerText = login;
        users.append(userDom);
      });
    }
    (async function () {
      try {
        const fetchResult = await fetch("https://api.github.com/users");
        const body = await fetchResult.json();
        console.log(body);
        fillUsers(body);
      } catch (e) {
        console.log(e.message);
      }
    })();
  };

  // post 불러오기 추가 작성.
  const postsButton = document.querySelector(".load-posts");
  postsButton.onclick = function () {
    function fillPosts(postList) {
      const template = document.querySelector("#post-item-template");
      const posts = document.querySelector(".posts");

      posts.innerHTML = "";

      postList.forEach(function ({ userId, id, title, body }) {
        const postDom = document.importNode(template.content, true);
        postDom.querySelector("li").dataset.userId = userId;
        postDom.querySelector("li").dataset.id = id;
        postDom.querySelector(".title").innerText = title;
        postDom.querySelector(".body").innerText = body;

        postDom.querySelector(".title").onclick = function () {
          const body = this.nextElementSibling;
          if (body.style.display === "none" || !body.style.display) {
            body.style.display = "block";
          } else {
            body.style.display = "none";
          }
        };

        posts.append(postDom);
      });
    }
    (async function () {
      try {
        const fetchResult = await fetch(
          "https://jsonplaceholder.typicode.com/posts",
        );
        const body = await fetchResult.json();
        console.log(body);
        fillPosts(body);
      } catch (e) {
        console.log(e.message);
      }
    })();
  };

  const commentsButton = document.querySelector(".load-comments");
  commentsButton.onclick = function () {
    function fillComments(commentList) {
      const template = document.querySelector("#comments-item-template");
      const comments = document.querySelector(".comments");

      comments.innerHTML = "";
      console.log(comments.childNodes.length);

      commentList.forEach(function ({ postId, name, email, body }) {
        const commentDom = document.importNode(template.content, true);
        commentDom.querySelector("li").dataset.postId = postId;
        commentDom.querySelector(".name").innerText = name;
        commentDom.querySelector(".email").innerText = email;
        commentDom.querySelector(".body").innerText = body;

        comments.append(commentDom);
      });
    }

    (async function () {
      try {
        const fetchResult = await fetch(
          "https://jsonplaceholder.typicode.com/comments",
        );
        const body = await fetchResult.json();
        console.log(body);
        fillComments(body);
      } catch (e) {
        console.log(e.message);
      }
    })();
  };
};
