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
document.addEventListener("DOMContentLoaded", function () {
    const form = document.querySelector("form");
    const radios = document.querySelectorAll("input[name='sample-type']");

    function updateAction() {
        const selected = document.querySelector("input[name='Type']:checked").value;
        if (selected === "center") form.action = "/center/submitForm";
        else if (selected === "home") form.action = "/home/submitForm";
        else if (selected === "self") form.action = "/self/submitForm";
    }

    radios.forEach(radio => {
        radio.addEventListener("change", updateAction);
    });

    // Đặt mặc định ngay khi load
    updateAction();
});


function closePopup() {
    const overlay = document.getElementById("popupOverlay");
    if (overlay) {
        overlay.style.display = "none";
    }
}

window.onload = function () {
    const overlay = document.getElementById("popupOverlay");
    if (overlay) {
        setTimeout(() => overlay.style.display = "none", 5000);
    }
}
document.addEventListener("DOMContentLoaded", function () {
    const form = document.getElementById("mainForm");

    form.addEventListener("submit", function (e) {
        const type = document.querySelector('input[name="Type"]:checked').value;

        if (type === "center") {
            form.action = "/center/submitForm";
        } else if (type === "home") {
            form.action = "/home/submitForm";
        } else if (type === "self") {
            form.action = "/self/submitForm";
        }
    });
});
