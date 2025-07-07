// Get the hamburger button and nav list
const hamburger = document.getElementById('hamburger');
const navList = document.getElementById('navList');

// Add click event listener to the hamburger button
hamburger.addEventListener('click', () => {
    // Toggle the "active" class to show/hide the nav list
    navList.classList.toggle('active');
});
document.addEventListener("DOMContentLoaded", () => {
    const username = localStorage.getItem("username");

    const userInfo = document.getElementById("user-info");
    const usernameDisplay = document.getElementById("username-display");
    const logoutLink = document.getElementById("logout-link");
    const authLinks = document.getElementById("auth-links");

    if (username) {
        userInfo.style.display = "flex"; // Hiện khối thông tin người dùng
        authLinks.style.display = "none"; // Ẩn login/logup
        usernameDisplay.textContent = username;

        logoutLink.addEventListener("click", (e) => {
            e.preventDefault();
            localStorage.removeItem("username");
            window.location.href = "/"; // Chuyển về trang login
        });
    }
});