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
