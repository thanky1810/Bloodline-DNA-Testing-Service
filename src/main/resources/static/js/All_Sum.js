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



// Function to enable the "Gửi đánh giá" button when the textarea has content
document.getElementById('feedback-content').addEventListener('input', function() {
    const submitButton = document.getElementById('submit-btn');
    if (this.value.trim() !== "") {
        submitButton.disabled = false;
    } else {
        submitButton.disabled = true;
    }
});

// Function to add the feedback to a list (just a mock function for now)
function addFeedback() {
    const feedbackContent = document.getElementById('feedback-content').value;
    if (feedbackContent.trim() === "") {
        alert("Vui lòng nhập đánh giá.");
        return;
    }
    alert("Đánh giá đã được thêm!");
    // You can replace the alert with an actual logic to save the feedback
    document.getElementById('feedback-content').value = '';  // Clear the textarea
    document.getElementById('submit-btn').disabled = true;  // Disable the submit button again
}

// Function to submit the feedback (mock function for now)
function submitFeedback() {
    const feedbackContent = document.getElementById('feedback-content').value;
    if (feedbackContent.trim() === "") {
        alert("Vui lòng nhập nội dung đánh giá.");
        return;
    }
    alert("Đánh giá đã được gửi!");
    // You can replace the alert with an actual function to send the feedback to a server
    document.getElementById('feedback-content').value = '';  // Clear the textarea
    document.getElementById('submit-btn').disabled = true;  // Disable the submit button again
}

// Gắn sự kiện click cho nút "Gửi đánh giá" (chỉ 1 lần, đặt ngoài hàm)
document.getElementById('submit-btn').addEventListener('click', submitFeedback);


// hàm chọn option khi nhập mẩu
document.addEventListener("DOMContentLoaded", function () {
    const radioCenter = document.getElementById("radio-center");
    const radioHome = document.getElementById("radio-home");
    const radioSelf = document.getElementById("radio-self");

    function showSection(type) {
        document.getElementById("section-center").style.display = (type === "center") ? "block" : "none";
        document.getElementById("section-home").style.display = (type === "home") ? "block" : "none";
        document.getElementById("section-self").style.display = (type === "self") ? "block" : "none";
    }

    radioCenter.addEventListener("change", () => showSection("center"));
    radioHome.addEventListener("change", () => showSection("home"));
    radioSelf.addEventListener("change", () => showSection("self"));

    // Hiển thị form phù hợp lúc đầu nếu có sẵn checked
    if (radioCenter.checked) showSection("center");
    else if (radioHome.checked) showSection("home");
    else if (radioSelf.checked) showSection("self");
});
