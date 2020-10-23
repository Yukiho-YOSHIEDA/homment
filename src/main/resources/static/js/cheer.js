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
