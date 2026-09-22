export function getDom(selector) {
  // document 에서 selector dom 하나 반환 시키기
  return document.querySelector(selector);
}

export function onClick(dom, cbFunction /* 버튼을 클릭했을 때 이벤트 */) {
  // dom 에 클릭 이벤트를 할당하기
  dom.onclick = cbFunction;
}

export function getValue(dom) {
  // dom 에 입력된 값을 반환하기
  return dom.value;
}

export function setText(dom, text) {
  // dom 에 textContent 를 할당하기
  dom.textContent = text;
}
