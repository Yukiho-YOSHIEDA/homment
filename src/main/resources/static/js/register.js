const nameTextBox = document.getElementById('nameText');
const postButton = document.getElementById('postButton');
const imageInput = document.getElementById('imageInput');
const icon = document.getElementById('icon');

nameTextBox.addEventListener('keyup', function () {
  if (!nameTextBox.value) {
    postButton.disabled = true;
    return;
  }
  postButton.disabled = false;
});

imageInput.addEventListener('change', function (event) {
  updateIcon(event.target.files[0]);
});

function updateIcon(image) {
  icon.file = image;
  const reader = new FileReader();
  reader.onload = (function (img) {
    return function (e) {
      img.src = e.target.result;
    };
  })(icon);
  reader.readAsDataURL(image);
}
