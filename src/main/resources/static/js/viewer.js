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

const userCache = {};

// WebSocket
const socket = new SockJS('/sockws');
stompClient = webstomp.over(socket);
stompClient.connect({}, function () {
  stompClient.subscribe('/comment/rooms/' + roomId + '/updated', function (data) {
    const comment = JSON.parse(data.body);

    if (userCache[comment.commentedBy]) {
      create(comment.action, userCache[comment.commentedBy]);
    } else {
      fetch('/api/users/' + comment.commentedBy)
        .then(function (response) {
          return response.json();
        })
        .then(function (data) {
          const icon = data.icon;
          userCache[comment.commentedBy] = icon;
          create(comment.action, icon);
        });
    }
  });
});

function create(action, icon) {
  const panel = document.getElementById('bg');
  const left = getRandomInt(window.innerWidth - 500);
  const style = `bottom: -1000; left: ${left}px`;
  const balloon = balloons[getRandomInt(balloons.length)];
  const element = document.createElement('div');
  element.classList.add('comment-wrapper');
  element.style.cssText = style;
  element.innerHTML = `<div class="comment">
    <img class="balloon" src="${balloon}" alt="気球">
    <img class="icon" src="${icon}" alt="アイコン">
    <img class="action" src="${actions[action]}" alt="リアクション">
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

