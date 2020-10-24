function post(action) {
  const data = {
    action: action,
  };
  const uri = '/api/rooms/' + roomId + '/cheer';

  fetch(uri, {
    method: 'POST',
    headers: {
      'Content-Type': 'application/json',
    },
    body: JSON.stringify(data),
  }).catch((error) => {
    console.error('Error:', error);
  });
}

// WebSocket
const socket = new SockJS('/sockws');
stompClient = webstomp.over(socket);
stompClient.connect({}, function () {
  stompClient.subscribe('/comment/rooms/' + roomId + '/redirect', function (data) {
    const res = JSON.parse(data.body);
    window.location.href = res.url;
  });
});
