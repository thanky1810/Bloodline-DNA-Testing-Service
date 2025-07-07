function toggleSidebar() {
    document.getElementById("sidebar").classList.toggle("active");
}

// Doanh thu chart
const ctxRevenue = document.getElementById('revenueChart').getContext('2d');
new Chart(ctxRevenue, {
    type: 'line',
    data: {
        labels: ['1', '2', '3', '4', '5', '6', '7', '8', '9', '10', '11', '12'],
        datasets: [{
            label: 'Doanh thu',
            data: [5, 7, 6, 12, 18, 40, 60, 100, 0, 30, 85, 100],
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

// Đánh giá chart
const ctxRating = document.getElementById('ratingChart').getContext('2d');
new Chart(ctxRating, {
    type: 'pie',
    data: {
        labels: ['1', '2', '3', '4', '5'],
        datasets: [{
            label: 'Đánh giá',
            data: [2, 5, 10, 20, 63],
            backgroundColor: ['#8D4A1E', '#D87A3B', '#F7B396', '#F78C3D', '#FFF0E1']
        }]
    },
    options: {
        responsive: true,
        plugins: { legend: { position: 'top' } }
    }
});





