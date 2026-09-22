import { getDom, onClick, getValue, setText } from "./calculator.js";

const firstNum = getDom(".input-number");
const secondNum = getDom(".input-number-2");

const sumBtn = getDom(".sum");
const subBtn = getDom(".sub");
const mulBtn = getDom(".mul");
const divBtn = getDom(".div");

const resultDom = getDom(".result");

function getInt(dom) {
  return parseInt(getValue(dom));
}

onClick(sumBtn, function () {
  const result = getInt(firstNum) + getInt(secondNum);
  setText(resultDom, result);
});

onClick(subBtn, () => {
  const result = getInt(firstNum) - getInt(secondNum);
  setText(resultDom, result);
});

onClick(mulBtn, () => {
  const result = getInt(firstNum) * getInt(secondNum);
  setText(resultDom, result);
});

onClick(divBtn, () => {
  const result = getInt(firstNum) / getInt(secondNum);
  setText(resultDom, result);
});
