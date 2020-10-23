const passwordTextBox = document.getElementById('passwordInput');
const postButton = document.getElementById('postButton');

passwordTextBox.addEventListener('keyup', function () {
  if (!passwordTextBox.value) {
    postButton.disabled = true;
    return;
  }
  postButton.disabled = false;
});
