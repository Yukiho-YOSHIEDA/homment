const balloons = [
  '/images/balloon/blue.png',
  '/images/balloon/green.png',
  '/images/balloon/red.png',
];

const actions = {
  cheer: '/images/action/cheer.png',
  clap: '/images/action/clap.png',
  good: '/images/action/good.png',
  star: '/images/action/star.png',
};

function create() {
  const panel = document.getElementById('bg');
  const left = getRandomInt(window.innerWidth - 500);
  const style = `bottom: -1000; left: ${left}px`;
  const balloon = balloons[getRandomInt(balloons.length)];
  const element = document.createElement('div');
  element.classList.add('comment-wrapper');
  element.style.cssText = style;
  element.innerHTML = `<div class="comment">
    <img class="balloon" src="${balloon}" alt="気球">
    <img class="icon" src="/images/default_icon.png" alt="アイコン">
    <img class="action" src="/images/good.png" alt="リアクション">
  </div>`
  panel.insertAdjacentElement('beforeend', element);

  setTimeout(balloonRise, 1000 / 60, element, -1000, left, 3, 0);
}

function getRandomInt(max) {
  return Math.floor(Math.random() * Math.floor(max));
}

function balloonRise(element, bottom, left, step, count) {
  const currentStep = count * step;
  const newBottom = bottom + currentStep;
  if (newBottom < window.innerHeight) {
    element.style.cssText = `bottom: ${newBottom}px; left: ${left}px`;
    setTimeout(balloonRise, 1000 / 60, element, bottom, left, step, count + 1);
  } else {
    element.remove();
  }
}

