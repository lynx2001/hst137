// JavaScript file to fetch data from the /exercise API and update the HTML table

// Example GET request to fetch all exercises
async function fetchExercises() {
    try {
        const response = await fetch('http://localhost:8080/exercise'); // API endpoint to fetch exercises
        if (!response.ok) {
            throw new Error(`HTTP error! status: ${response.status}`);
        }
        const exercises = await response.json();
        populateTable(exercises);
    } catch (error) {
        console.error('Error fetching exercises:', error);
    }
}

// Populate the HTML table with the fetched exercises data
function populateTable(exercises) {
    const tbody = document.querySelector('tbody');
    tbody.innerHTML = ''; // Clear the table body

    exercises.forEach((exercise) => {
        const exerciseRow = document.createElement('tr');
        exerciseRow.classList.add('exercise');

        exerciseRow.innerHTML = `
            <td rowspan="4">${exercise.name}</td>
            <td colspan="2" rowspan="2">Lighter of the two weights</td>
            <td colspan="2" rowspan="2">Heavier of the two weights</td>
            <td rowspan="4">${exercise.repMaxLightWeight}</td>
            <td rowspan="4">${exercise.repMaxHeavyWeight}</td>
            <td rowspan="4">N/A</td>
            <td rowspan="4">${exercise.alternation ? 'Yes' : 'No'}</td>
            <td rowspan="4">No</td>
            <td rowspan="4">${exercise.tool}</td>
        `;

        const headerRow = document.createElement('tr');
        headerRow.innerHTML = `
            <td>Weight lifted</td>
            <td>Number of Reps</td>
            <td>Weight lifted</td>
            <td>Number of Reps</td>
        `;

        const dataRow = document.createElement('tr');
        dataRow.innerHTML = `
            <td>${exercise.repMaxLightWeight}</td>
            <td>${exercise.repMaxLightReps}</td>
            <td>${exercise.repMaxHeavyWeight}</td>
            <td>${exercise.repMaxHeavyReps}</td>
        `;

        tbody.appendChild(exerciseRow);
        tbody.appendChild(headerRow);
        tbody.appendChild(dataRow);
    });
}

// Call the function to fetch and display the data when the page loads
window.addEventListener('DOMContentLoaded', fetchExercises);
