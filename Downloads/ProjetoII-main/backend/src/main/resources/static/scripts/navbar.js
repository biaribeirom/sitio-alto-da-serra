window.addEventListener("scroll", function () {
	let head = document.querySelector('.navbar');
	head.classList.toggle('rolagem', window.scrollY > 0);
});