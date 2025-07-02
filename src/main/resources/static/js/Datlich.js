
function toggleDateList() {
    const list = document.getElementById("dateList");
    list.style.display = list.style.display === "block" ? "none" : "block";
}

function selectDate(element) {
    const button = document.querySelector(".date-toggle");
    button.innerHTML = element.textContent + ' <i class="fas fa-chevron-down"></i>';
    document.getElementById("dateList").style.display = "none";


}

window.addEventListener("click", function (e) {
    const picker = document.querySelector(".date-picker");
    if (!picker.contains(e.target)) {
        document.getElementById("dateList").style.display = "none";
    }
});

