onload = function () {
  const image = document.querySelector("img");

  image.onmouseenter = function () {
    const ticket = document.querySelector("div.ticket");
    // console.log(ticket);
    // console.dir(ticket);
    // console.log(ticket.style);
    // ticket.style.display = "block";
    // ticket.style.setProperty("display", "block");
    css(ticket, {
      display: "block",
      ["font-size"]: "2rem",
      color: "#f00",
      ["background-color"]: "#fff",
    });
  };

  image.onmouseleave = function () {
    const ticket = document.querySelector("div.ticket");
    // ticket.style.removeProperty("display");
    removeCSS(ticket, ["display", "font-size", "color", "background-color"]);
  };
};

function css(dom, styles) {
  // if (dom != null && dom != undefined)
  if (dom) {
    for (let key in styles) {
      dom.style.setProperty(key, styles[key]);
    }
  }
}

function removeCSS(dom, properties) {
  // if (dom != null && dom != undefined)
  if (dom) {
    properties.forEach(function (eachProp) {
      dom.style.removeProperty(eachProp);
    });
  }
}
