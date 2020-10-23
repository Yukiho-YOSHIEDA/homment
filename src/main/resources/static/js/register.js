const nameTextBox = document.getElementById('nameText');
const postButton = document.getElementById('postButton');

nameTextBox.addEventListener('keyup', function () {
  if (!nameTextBox.value) {
    postButton.disabled = true;
    return;
  }
  postButton.disabled = false;
});
