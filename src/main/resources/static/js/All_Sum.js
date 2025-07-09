// Get the hamburger button and nav list
const hamburger = document.getElementById('hamburger');
const navList = document.getElementById('navList');

// Add click event listener to the hamburger button
hamburger.addEventListener('click', () => {
    // Toggle the "active" class to show/hide the nav list
    navList.classList.toggle('active');
});
// của header phần nút show trang chủ, ....
///////////////////////////////////////////////////////////////////////




// Feedback logic
let feedbacks = [];

function renderFeedbacks() {
    const list = document.getElementById('feedback-items');
    if (feedbacks.length === 0) {
        list.innerHTML = '<p style="text-align:center; color:#aaa;">Chưa có đánh giá nào.</p>';
    } else {
        list.innerHTML = feedbacks.map(fb => `<div>${fb}</div>`).join('');
    }
}

// Khi bấm "Thêm đánh giá" thì mới cho nhập
function enableFeedbackInput() {
    const textarea = document.getElementById('feedback-content');
    textarea.disabled = false;
    textarea.focus();
    document.getElementById('submit-btn').disabled = !textarea.value.trim();
}

// Khi nhập thì kiểm tra để bật/tắt nút gửi
document.getElementById('feedback-content').addEventListener('input', function () {
    document.getElementById('submit-btn').disabled = !this.value.trim();
});

function submitFeedback() {
    const textarea = document.getElementById('feedback-content');
    const content = textarea.value.trim();
    if (content) {
        feedbacks.push(content);
        renderFeedbacks();
        alert("Đánh giá đã được gửi!");
        textarea.value = '';
        textarea.disabled = true;
        document.getElementById('submit-btn').disabled = true;
    } else {
        alert("Vui lòng nhập nội dung đánh giá.");
    }
}

renderFeedbacks();

document.addEventListener('DOMContentLoaded', function () {
    const loginBtn = document.getElementById('loginBtn');
    const loginModal = document.getElementById('loginModal');
    const closeModal = document.getElementById('closeModal');
    if (loginBtn && loginModal && closeModal) {
        loginBtn.onclick = () => loginModal.classList.add('show');
        closeModal.onclick = () => loginModal.classList.remove('show');
        window.onclick = (e) => {
            if (e.target === loginModal) loginModal.classList.remove('show');
        };
    }
});