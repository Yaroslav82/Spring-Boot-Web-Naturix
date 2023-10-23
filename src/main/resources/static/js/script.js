let menuBtn = document.querySelector('.menu-btn');
let menu = document.querySelector('.burger-menu');
menuBtn.addEventListener('click', function(){
	menu.classList.toggle('active');
})