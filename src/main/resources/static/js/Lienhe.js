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