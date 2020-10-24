const commentField = document.getElementById('commentField');
const postButtonDisable = document.getElementById('submitDisable');
const postButton = document.getElementById('submit');

commentField.addEventListener('keyup', function () {
  if (!commentField.value) {
    postButtonDisable.style.display = "inline-block";
    postButton.style.display = "none";
    return;
  }
  postButtonDisable.style.display = "none";
  postButton.style.display = "inline-block";
});
