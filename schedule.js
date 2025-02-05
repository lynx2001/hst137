document.addEventListener("DOMContentLoaded", function() {
    fetch("http://localhost:8080/schedule")
        .then(response => response.json())
        .then(data => {
            renderSchedule(data);
        })
        .catch(error => console.error("Error fetching schedule data:", error));
});

function renderSchedule(workoutData) {
    const container = document.getElementById("scheduleContainer");
    container.innerHTML = "";
    workoutData.forEach(session => {
        let sessionDiv = document.createElement("div");
        sessionDiv.classList.add("week");
        sessionDiv.innerHTML = `
            <h2>Week ${session.week}</h2>
            <div class="day">
                <h3>${session.date}</h3>
                <table>
                    <thead>
                        <tr>
                            <th>운동</th>
                            <th>무게 (kg)</th>
                            <th>RM (%)</th>
                            <th>세트</th>
                        </tr>
                    </thead>
                    <tbody>
                        ${session.exercises.map(exercise => `
                            <tr>
                                <td>${exercise.name}</td>
                                <td>${exercise.weight.toFixed(1)}</td>
                                <td>${exercise.rm.toFixed(1)} %</td>
                                <td>${exercise.sets}</td>
                            </tr>
                        `).join('')}
                    </tbody>
                </table>
            </div>
        `;
        container.appendChild(sessionDiv);
    });
}