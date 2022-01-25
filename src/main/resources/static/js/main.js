const chartDataStr = decodeHtml(chartData);
const chartDataJsonArray = JSON.parse(chartDataStr);
const projectStatus = [];
const projectStatusCount = [];
for (let i = 0; i < chartDataJsonArray.length; i++) {
    projectStatusCount.push(chartDataJsonArray[i].count);
    projectStatus.push(chartDataJsonArray[i].projectStatus);
}

const data = {
    labels: projectStatus,
    datasets: [{
        label: 'My First dataset',
        backgroundColor: ["#3e95cd", "#8e5ea2", "#3cba9f"],
        data: projectStatusCount,
    }]
};

const config = {
    type: 'pie',
    data: data,
    options: {
        title: {
            display: true,
            text: "Project Statuses"
        }
    }
};


const myChart = new Chart(
    document.getElementById('myChart'),
    config
);


function decodeHtml(html){
    const text = document.createElement("textarea");
    text.innerHTML = html;
    return text.value;
}
