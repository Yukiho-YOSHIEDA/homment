function post(roomId) {
  const data = {
    toUserId: 8,
  };
  const uri = '/api/rooms/' + roomId + '/comment/request';

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
