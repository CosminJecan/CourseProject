
let urlsList = document.querySelectorAll('li');
for (let i = 0; i < urlsList.length; i++) {
    window.open(urlsList[i].innerText);

}
