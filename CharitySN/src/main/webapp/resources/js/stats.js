/* 
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/ClientSide/javascript.js to edit this template
 */

function generateColor() {
    let r = parseInt(Math.random()*255);
    let g = parseInt(Math.random()*255);
    let b = parseInt(Math.random()*255); 
    return `rgb(${r}, ${g}, ${b})`
}

function postsChart(id, postsLabels=[], postsInfo=[]) {
    let colors = []
    for (let i = 0; i < postsInfo.length; i++)
        colors.push(generateColor())
    
    const data = {
        labels: postsLabels,
        datasets: [{
          label: 'Thống kê bài viết theo người dùng',
          data: postsInfo,
          backgroundColor: colors,
          hoverOffset: 4
        }]
    };
    const config = {
        type: 'doughnut',
        data: data,
    };
    
    let ctx = document.getElementById(id).getContext("2d")
    
    new Chart(ctx, config)
}
