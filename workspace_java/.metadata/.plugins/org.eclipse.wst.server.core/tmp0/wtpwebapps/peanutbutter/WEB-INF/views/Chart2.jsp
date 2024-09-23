<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="ko">

<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>라인별 실적 현황</title>
    <script src="https://cdn.jsdelivr.net/npm/chart.js"></script>
</head>

<body>
    <div style="width: 80%; margin: auto;">
        <canvas id="performanceChart"></canvas>
    </div>
    <script src="script.js"></script>
</body>
<script>
    const ctx = document.getElementById('performanceChart').getContext('2d');
const performanceChart = new Chart(ctx, {
    type: 'line',
    data: {
        labels: ['00:00', '02:00', '04:00', '06:00', '08:00', '10:00', '12:00', '14:00', '16:00', '18:00', '20:00', '22:00'],
        datasets: [
            {
                label: '라인 1',
                data: [120, 180, 250, 300, 450, 500, 550, 600, 620, 700, 750, 780],
                borderColor: 'rgba(255, 99, 132, 1)',
                backgroundColor: 'rgba(255, 99, 132, 0.2)',
                fill: false
            },
            {
                label: '라인 2',
                data: [100, 170, 220, 310, 330, 470, 480, 520, 540, 680, 720, 760],
                borderColor: 'rgba(54, 162, 235, 1)',
                backgroundColor: 'rgba(54, 162, 235, 0.2)',
                fill: false
            },
            {
                label: '라인 3',
                data: [140, 190, 230, 340, 390, 420, 500, 540, 570, 620, 690, 730],
                borderColor: 'rgba(255, 206, 86, 1)',
                backgroundColor: 'rgba(255, 206, 86, 0.2)',
                fill: false
            },
            {
                label: '라인 4',
                data: [130, 160, 240, 320, 350, 410, 460, 500, 530, 610, 660, 700],
                borderColor: 'rgba(75, 192, 192, 1)',
                backgroundColor: 'rgba(75, 192, 192, 0.2)',
                fill: false
            }
        ]
    },
    options: {
        responsive: true,
        plugins: {
            legend: {
                display: true,
                position: 'top'
            },
            tooltip: {
                mode: 'index',
                intersect: false
            }
        },
        scales: {
            x: {
                title: {
                    display: true,
                    text: '시간'
                }
            },
            y: {
                beginAtZero: true,
                title: {
                    display: true,
                    text: '실적'
                }
            }
        }
    }
});


</script>

</html>