function toggleSidebar() {
    document.getElementById("sidebar").classList.toggle("active");
}

// Lấy dữ liệu từ biến toàn cục nếu có (do Thymeleaf truyền vào), nếu không thì dùng dữ liệu mẫu
const revenueData = window.revenueData || [5, 7, 6, 12, 18, 40, 60, 100, 0, 30, 85, 100];
const ratingData = window.ratingData || [2, 5, 10, 20, 63];

// Vẽ biểu đồ doanh thu nếu tồn tại phần tử
const revenueChartElem = document.getElementById('revenueChart');
if (revenueChartElem) {
    const ctxRevenue = revenueChartElem.getContext('2d');
    new Chart(ctxRevenue, {
        type: 'line',
        data: {
            labels: ['1', '2', '3', '4', '5', '6', '7', '8', '9', '10', '11', '12'],
            datasets: [{
                label: 'Doanh thu',
                data: revenueData,
                borderColor: '#0072bb',
                backgroundColor: 'transparent',
                tension: 0.3
            }]
        },
        options: {
            responsive: true,
            plugins: { legend: { display: true } },
            scales: { y: { beginAtZero: true } }
        }
    });
}

// Vẽ biểu đồ đánh giá nếu tồn tại phần tử
const ratingChartElem = document.getElementById('ratingChart');
if (ratingChartElem) {
    const ctxRating = ratingChartElem.getContext('2d');
    new Chart(ctxRating, {
        type: 'pie',
        data: {
            labels: ['1', '2', '3', '4', '5'],
            datasets: [{
                label: 'Đánh giá',
                data: ratingData,
                backgroundColor: ['#8D4A1E', '#D87A3B', '#F7B396', '#F78C3D', '#FFF0E1']
            }]
        },
        options: {
            responsive: true,
            plugins: { legend: { position: 'top' } }
        }
    });
}


// Thêm vào cuối file Admin.js hoặc trong <script> cuối trang
document.addEventListener('DOMContentLoaded', function () {
    const adminName = document.getElementById('adminName');
    const adminDropdown = document.getElementById('adminDropdown');
    if (adminName && adminDropdown) {
        adminName.onclick = function (e) {
            e.stopPropagation();
            adminDropdown.classList.toggle('show');
        };
        document.addEventListener('click', function () {
            adminDropdown.classList.remove('show');
        });
    }
});