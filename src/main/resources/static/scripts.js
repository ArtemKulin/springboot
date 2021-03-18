'use distinct'

const modalTrigger = document.querySelector('[data-toggle]'),
    modal = document.querySelector('.modal'),
    modalCloseBtn = document.querySelector('.close');

modalTrigger.addEventListener('click', () => {
    modal.classList.add('show');
    modal.classList.remove('hide');
});

modalTrigger.addEventListener('click', () => {
    modal.classList.add('hide');
    modal.classList.remove('show');
});