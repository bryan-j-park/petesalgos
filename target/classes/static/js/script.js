const forms = document.querySelector('.forms');
const pwShowHide = document.querySelectorAll('.eye-icon');
const links = document.querySelectorAll('.link');

pwShowHide.forEach(eyeIcon => {
    eyeIcon.addEventListener('click', () => {
        let pwFields = eyeIcon.parentElement.parentElement.querySelectorAll('.password');
        pwFields.forEach(password => {
            if(password.type === 'password') {
                password.type = "text";
                eyeIcon.classList.replace('bx-hide', 'bx-show');
                return;
            }
            password.type = "password";
            eyeIcon.classList.replace('bx-show', 'bx-hide');
        })
    })
});

const solution = document.getElementById('solution');
const button = document.getElementById('sol-btn');

function solShowHide() {
    if(solution.style.display !== 'none') {
        solution.style.display = 'none';
        button.innerHTML = 'Show Solution';
    } else {
        solution.style.display = 'block';
        button.innerHTML = 'Hide Solution';
    }
}