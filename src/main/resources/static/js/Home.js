// Get the hamburger button and nav list
const hamburger = document.getElementById('hamburger');
const navList = document.getElementById('navList');

// Add click event listener to the hamburger button
hamburger.addEventListener('click', () => {
    // Toggle the "active" class to show/hide the nav list
    navList.classList.toggle('active');
});